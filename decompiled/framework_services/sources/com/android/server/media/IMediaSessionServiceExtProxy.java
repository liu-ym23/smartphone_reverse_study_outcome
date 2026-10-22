package com.android.server.media;

import android.media.session.PlaybackState;
import android.prometheus.ext.core.ExtLoader;
import android.view.KeyEvent;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class IMediaSessionServiceExtProxy {
    private final List<IMediaSessionServiceExt> mMediaSessionServiceExts;

    public static IMediaSessionServiceExtProxy get(MediaSessionService base) {
        return new IMediaSessionServiceExtProxy(base);
    }

    public IMediaSessionServiceExtProxy(Object base) {
        this.mMediaSessionServiceExts = ExtLoader.getAll(IMediaSessionServiceExt.class, base);
    }

    public MediaSessionRecordImpl getTopPriorityVolumeSession(List<MediaSessionRecord> records) {
        if (this.mMediaSessionServiceExts != null) goto L5;
        return null;
    L5:
        Iterator<IMediaSessionServiceExt> r0 = this.mMediaSessionServiceExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        IMediaSessionServiceExt ext = r0.next();
        MediaSessionRecordImpl record = ext.getTopPriorityVolumeSession(records);
        if (record == null) goto L7;
        return record;
    L12:
        return null;
    }

    public void init(int uid, int userId, String pkg, String tag) {
        if (this.mMediaSessionServiceExts != null) goto L5;
        return;
    L5:
        Iterator<IMediaSessionServiceExt> r0 = this.mMediaSessionServiceExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        IMediaSessionServiceExt ext = r0.next();
        ext.init(uid, userId, pkg, tag);
        goto L7
    }

    public int getSid() {
        if (this.mMediaSessionServiceExts != null) goto L5;
        return 0;
    L5:
        Iterator<IMediaSessionServiceExt> r0 = this.mMediaSessionServiceExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        IMediaSessionServiceExt ext = r0.next();
        int sid = ext.getSid();
        if (sid == 0) goto L7;
        return sid;
    L12:
        return 0;
    }

    public void onSessionActiveStateChanged_onEnd(MediaSessionRecordImpl record, boolean userEngaged, PlaybackState playbackState) {
        if (this.mMediaSessionServiceExts != null) goto L5;
        return;
    L5:
        Iterator<IMediaSessionServiceExt> r0 = this.mMediaSessionServiceExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        IMediaSessionServiceExt ext = r0.next();
        ext.onSessionActiveStateChanged_onEnd(record, userEngaged, playbackState);
        goto L7
    }

    public void setGlobalPrioritySession_onEnd(MediaSessionRecordImpl record) {
        if (this.mMediaSessionServiceExts != null) goto L5;
        return;
    L5:
        Iterator<IMediaSessionServiceExt> r0 = this.mMediaSessionServiceExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        IMediaSessionServiceExt ext = r0.next();
        ext.setGlobalPrioritySession_onEnd(record);
        goto L7
    }

    public void destroySessionLocked_onStart(MediaSessionRecordImpl record) {
        if (this.mMediaSessionServiceExts != null) goto L5;
        return;
    L5:
        Iterator<IMediaSessionServiceExt> r0 = this.mMediaSessionServiceExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        IMediaSessionServiceExt ext = r0.next();
        ext.destroySessionLocked_onStart(record);
        goto L7
    }

    public void createSession_onSuccess(MediaSessionRecord record) {
        if (this.mMediaSessionServiceExts != null) goto L5;
        return;
    L5:
        Iterator<IMediaSessionServiceExt> r0 = this.mMediaSessionServiceExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        IMediaSessionServiceExt ext = r0.next();
        ext.createSession_onSuccess(record);
        goto L7
    }

    public void createSession_onException(int uid, String pkg, String tag, Exception ex) {
        if (this.mMediaSessionServiceExts != null) goto L5;
        return;
    L5:
        Iterator<IMediaSessionServiceExt> r0 = this.mMediaSessionServiceExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        IMediaSessionServiceExt ext = r0.next();
        ext.createSession_onException(uid, pkg, tag, ex);
        goto L7
    }

    public void dispatchMediaKeyEvent_onBeforeHandle(int uid, String pkg, KeyEvent keyEvent, String errorType) {
        if (this.mMediaSessionServiceExts != null) goto L5;
        return;
    L5:
        Iterator<IMediaSessionServiceExt> r0 = this.mMediaSessionServiceExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        IMediaSessionServiceExt ext = r0.next();
        ext.dispatchMediaKeyEvent_onBeforeHandle(uid, pkg, keyEvent, errorType);
        goto L7
    }

    public void dispatchMediaKeyEventToSessionAsSystemService_onBeforeDispatch(int uid, String pkg, KeyEvent keyEvent, MediaSessionRecord record, String errorType) {
        if (this.mMediaSessionServiceExts != null) goto L5;
        return;
    L5:
        Iterator<IMediaSessionServiceExt> r0 = this.mMediaSessionServiceExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        IMediaSessionServiceExt ext = r0.next();
        ext.dispatchMediaKeyEventToSessionAsSystemService_onBeforeDispatch(uid, pkg, keyEvent, record, errorType);
        goto L7
    }
}
