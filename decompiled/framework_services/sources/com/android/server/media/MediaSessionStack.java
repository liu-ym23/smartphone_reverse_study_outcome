package com.android.server.media;

import android.media.Session2Token;
import android.media.session.MediaSession;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class MediaSessionStack {
    private static final boolean DEBUG = false;
    private static final String TAG = "MediaSessionStack";
    private final AudioPlayerStateMonitor mAudioPlayerStateMonitor;
    private final SparseArray<List<MediaSessionRecord>> mCachedActiveLists;
    private MediaSessionRecordImpl mMediaButtonSession;
    private final OnMediaButtonSessionChangedListener mOnMediaButtonSessionChangedListener;
    private final List<MediaSessionRecordImpl> mSessions;

    interface OnMediaButtonSessionChangedListener {
        void onMediaButtonSessionChanged(MediaSessionRecordImpl r1, MediaSessionRecordImpl r2);
    }

    static {
        DEBUG = MediaSessionService.DEBUG;
    }

    MediaSessionStack(AudioPlayerStateMonitor monitor, OnMediaButtonSessionChangedListener listener) {
        this.mSessions = new ArrayList();
        this.mCachedActiveLists = new SparseArray();
        this.mAudioPlayerStateMonitor = monitor;
        this.mOnMediaButtonSessionChangedListener = listener;
    }

    public void addSession(MediaSessionRecordImpl record) {
        Slog.i(TAG, TextUtils.formatSimple("addSession to bottom of stack | record: %s", new Object[]{record}));
        this.mSessions.add(record);
        clearCache(record.getUserId());
        updateMediaButtonSessionIfNeeded();
    }

    public void removeSession(MediaSessionRecordImpl record) {
        Slog.i(TAG, TextUtils.formatSimple("removeSession | record: %s", new Object[]{record}));
        this.mSessions.remove(record);
        if (this.mMediaButtonSession != record) goto L5;
        updateMediaButtonSession(null);
    L5:
        clearCache(record.getUserId());
    }

    public boolean contains(MediaSessionRecordImpl record) {
        return this.mSessions.contains(record);
    }

    public MediaSessionRecord getMediaSessionRecord(MediaSession.Token sessionToken) {
        Iterator<MediaSessionRecordImpl> r0 = this.mSessions.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        MediaSessionRecordImpl record = r0.next();
        if ((record instanceof MediaSessionRecord) == false) goto L4;
        MediaSessionRecord session1 = (MediaSessionRecord) record;
        if (Objects.equals(session1.getSessionToken(), sessionToken) == false) goto L4;
        return session1;
    L11:
        return null;
    }

    public void onPlaybackStateChanged(MediaSessionRecordImpl record, boolean shouldUpdatePriority) {
        if (shouldUpdatePriority == false) goto L5;
        Slog.i(TAG, TextUtils.formatSimple("onPlaybackStateChanged - Pushing session to top | record: %s", new Object[]{record}));
        this.mSessions.remove(record);
        this.mSessions.add(0, record);
        clearCache(record.getUserId());
    L5:
        if (this.mMediaButtonSession != null) goto L7;
        return;
    L7:
        if (this.mMediaButtonSession.getUid() != record.getUid()) goto L15;
        MediaSessionRecordImpl newMediaButtonSession = findMediaButtonSession(this.mMediaButtonSession.getUid());
        if (newMediaButtonSession != this.mMediaButtonSession) goto L11;
        return;
    L11:
        if ((newMediaButtonSession.getSessionPolicies() & 2) != 0) goto L17;
        updateMediaButtonSession(newMediaButtonSession);
        return;
    L17:
        return;
    }

    public void onSessionActiveStateChanged(MediaSessionRecordImpl record) {
        clearCache(record.getUserId());
    }

    public void updateMediaButtonSessionIfNeeded() {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "updateMediaButtonSessionIfNeeded, callers=" + getCallers(2));
    L5:
        List<Integer> audioPlaybackUids = this.mAudioPlayerStateMonitor.getSortedAudioPlaybackClientUids();
        int i = 0;
    L7:
        if (i >= audioPlaybackUids.size()) goto L27;
        int audioPlaybackUid = audioPlaybackUids.get(i).intValue();
        MediaSessionRecordImpl mediaButtonSession = findMediaButtonSession(audioPlaybackUid);
        if (mediaButtonSession != null) goto L14;
        if (DEBUG == false) goto L25;
        Log.d(TAG, "updateMediaButtonSessionIfNeeded, skipping uid=" + audioPlaybackUid);
    L25:
        i = i + 1;
        goto L7
    L14:
        if ((mediaButtonSession.getSessionPolicies() & 2) == 0) goto L16;
        boolean ignoreButtonSession = true;
    L18:
        if (DEBUG == false) goto L20;
        Log.d(TAG, "updateMediaButtonSessionIfNeeded, checking uid=" + audioPlaybackUid + ", mediaButtonSession=" + mediaButtonSession + ", ignoreButtonSession=" + ignoreButtonSession);
    L20:
        if (ignoreButtonSession == true) goto L25;
        this.mAudioPlayerStateMonitor.cleanUpAudioPlaybackUids(mediaButtonSession.getUid());
        if (mediaButtonSession == this.mMediaButtonSession) goto L33;
        updateMediaButtonSession(mediaButtonSession);
        return;
    L33:
        return;
    L16:
        ignoreButtonSession = false;
        goto L18
    }

    public void updateMediaButtonSessionBySessionPolicyChange(MediaSessionRecord record) {
        if ((record.getSessionPolicies() & 2) != 0) goto L5;
        updateMediaButtonSessionIfNeeded();
        return;
    L5:
        if (record != this.mMediaButtonSession) goto L9;
        updateMediaButtonSession(null);
        return;
    }

    private MediaSessionRecordImpl findMediaButtonSession(int uid) {
        MediaSessionRecordImpl mediaButtonSession = null;
        Iterator<MediaSessionRecordImpl> r1 = this.mSessions.iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        MediaSessionRecordImpl session = r1.next();
        if ((session instanceof MediaSession2Record) == true) goto L4;
        if (uid != session.getUid()) goto L4;
        if (session.checkPlaybackActiveState(this.mAudioPlayerStateMonitor.isPlaybackActive(session.getUid())) == true) goto L12;
        if (mediaButtonSession != null) goto L4;
        mediaButtonSession = session;
        goto L4
    L12:
        return session;
    L16:
        return mediaButtonSession;
    }

    public List<MediaSessionRecord> getActiveSessions(int userId) {
        List<MediaSessionRecord> cachedActiveList = this.mCachedActiveLists.get(userId);
        if (cachedActiveList != null) goto L6;
        List<MediaSessionRecord> cachedActiveList2 = getPriorityList(true, userId);
        this.mCachedActiveLists.put(userId, cachedActiveList2);
        return cachedActiveList2;
    L6:
        return cachedActiveList;
    }

    public List<Session2Token> getSession2Tokens(int userId) {
        ArrayList<Session2Token> session2Records = new ArrayList();
        Iterator<MediaSessionRecordImpl> r1 = this.mSessions.iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        MediaSessionRecordImpl record = r1.next();
        if (userId == (-1)) goto L10;
        if (record.getUserId() != userId) goto L4;
    L10:
        if (record.isActive() == false) goto L4;
        if ((record instanceof MediaSession2Record) == false) goto L4;
        MediaSession2Record session2 = (MediaSession2Record) record;
        session2Records.add(session2.getSession2Token());
        goto L4
    L15:
        return session2Records;
    }

    public MediaSessionRecordImpl getMediaButtonSession() {
        return this.mMediaButtonSession;
    }

    public void updateMediaButtonSession(MediaSessionRecordImpl newMediaButtonSession) {
        MediaSessionRecordImpl oldMediaButtonSession = this.mMediaButtonSession;
        this.mMediaButtonSession = newMediaButtonSession;
        this.mOnMediaButtonSessionChangedListener.onMediaButtonSessionChanged(oldMediaButtonSession, newMediaButtonSession);
    }

    public MediaSessionRecordImpl getDefaultVolumeSession() {
        List<MediaSessionRecord> records = getPriorityList(true, -1);
        int size = records.size();
        int i = 0;
    L3:
        if (i >= size) goto L10;
        MediaSessionRecord record = records.get(i);
        if (record.checkPlaybackActiveState(true) == false) goto L9;
        if (record.canHandleVolumeKey() == false) goto L9;
        return record;
    L9:
        i = i + 1;
        goto L3
    L10:
        return null;
    }

    public MediaSessionRecordImpl getDefaultRemoteSession(int userId) {
        List<MediaSessionRecord> records = getPriorityList(true, userId);
        int size = records.size();
        int i = 0;
    L3:
        if (i >= size) goto L8;
        MediaSessionRecord record = records.get(i);
        if (record.isPlaybackTypeLocal() == false) goto L6;
        i = i + 1;
        goto L3
    L6:
        return record;
    L8:
        return null;
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "Media button session is " + this.mMediaButtonSession);
        pw.println(prefix + "Sessions Stack - have " + this.mSessions.size() + " sessions:");
        StringBuilder r0 = new StringBuilder();
        r0.append(prefix);
        r0.append("  ");
        String indent = r0.toString();
        Iterator<MediaSessionRecordImpl> r1 = this.mSessions.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        MediaSessionRecordImpl record = r1.next();
        record.dump(pw, indent);
        goto L4
    }

    public List<MediaSessionRecord> getPriorityList(boolean activeOnly, int userId) {
        List<MediaSessionRecord> result = new ArrayList();
        int lastPlaybackActiveIndex = 0;
        int lastActiveIndex = 0;
        Iterator<MediaSessionRecordImpl> r3 = this.mSessions.iterator();
    L4:
        if (r3.hasNext() == false) goto L22;
        MediaSessionRecordImpl record = r3.next();
        if ((record instanceof MediaSessionRecord) == false) goto L4;
        MediaSessionRecord session = (MediaSessionRecord) record;
        if (userId == (-1)) goto L14;
        if (userId != session.getUserId()) goto L4;
    L14:
        if (session.isActive() == false) goto L15;
        if (session.checkPlaybackActiveState(true) == true) goto L19;
        int lastPlaybackActiveIndex2 = lastActiveIndex + 1;
        result.add(lastActiveIndex, session);
        lastActiveIndex = lastPlaybackActiveIndex2;
        goto L4
    L19:
        result.add(lastPlaybackActiveIndex, session);
        lastActiveIndex = lastActiveIndex + 1;
        lastPlaybackActiveIndex = lastPlaybackActiveIndex + 1;
        goto L4
    L15:
        if (activeOnly == true) goto L4;
        result.add(session);
        goto L4
    L22:
        return result;
    }

    private void clearCache(int userId) {
        this.mCachedActiveLists.remove(userId);
        this.mCachedActiveLists.remove(-1);
    }

    private static String getCallers(int depth) {
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder();
        int i = 0;
    L3:
        if (i >= depth) goto L6;
        sb.append(getCaller(callStack, i));
        sb.append(" ");
        i = i + 1;
        goto L3
    L6:
        return sb.toString();
    }

    private static String getCaller(StackTraceElement[] callStack, int depth) {
        if ((depth + 4) < callStack.length) goto L6;
        return "<bottom of call stack>";
    L6:
        StackTraceElement caller = callStack[depth + 4];
        return caller.getClassName() + "." + caller.getMethodName() + ":" + caller.getLineNumber();
    }
}
