package com.android.server.audio;

import android.media.zte.IZAudioClientMonitor;
import android.media.zte.IZAudioService;
import android.media.zte.ZAudioReportEntry;
import android.os.RemoteException;
import android.util.Log;
import com.android.server.utils.EventLogger;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class ZAudioMonitor extends IZAudioClientMonitor.Stub {
    private static final int LOG_NB_EVENTS_MON = 20;
    private static final String TAG = "ZA.ZAudioMonitor";
    private final Map<Integer, Map<Integer, Integer>> mActiveSourceUidMap;
    private final Map<Integer, Map<Integer, Integer>> mActiveStreamUidMap;
    private final Map<Integer, Map<Integer, Integer>> mActiveUidSourceMap;
    private final Map<Integer, Map<Integer, Integer>> mActiveUidStreamMap;
    private final ZAudioClientDispatcher mDispatcher;
    private final EventLogger mEventLogger;
    private final Object mLock;
    private final Map<Integer, PlaybackClient> mPlaybackMap;
    private final Map<Integer, RecordClient> mRecordMap;

    public static abstract class BaseClient implements ZAudioClientInterface {
        private final int mFlags;
        private boolean mIsActive;
        private final String mPackageName;
        private final int mPid;
        private final int mPortId;
        private final int mSessionId;
        private final int mUid;

        public BaseClient(ZAudioReportEntry entry, String packageName) {
            this.mPortId = entry.portId;
            this.mUid = entry.uid;
            this.mPid = entry.pid;
            this.mSessionId = entry.sessionId;
            this.mIsActive = entry.active;
            this.mPackageName = packageName;
            this.mFlags = entry.flags;
        }

        @Override // com.android.server.audio.ZAudioClientInterface
        public int getUid() {
            return this.mUid;
        }

        @Override // com.android.server.audio.ZAudioClientInterface
        public int getPid() {
            return this.mPid;
        }

        @Override // com.android.server.audio.ZAudioClientInterface
        public int getPortId() {
            return this.mPortId;
        }

        @Override // com.android.server.audio.ZAudioClientInterface
        public int getSessionId() {
            return this.mSessionId;
        }

        @Override // com.android.server.audio.ZAudioClientInterface
        public String getPackageName() {
            return this.mPackageName;
        }

        @Override // com.android.server.audio.ZAudioClientInterface
        public boolean isActive() {
            return this.mIsActive;
        }

        public void setActive(boolean active) {
            this.mIsActive = active;
        }

        @Override // com.android.server.audio.ZAudioClientInterface
        public int getFlags() {
            return this.mFlags;
        }

        @Override // com.android.server.audio.ZAudioClientInterface
        public String toString() {
            return "mPortId=" + this.mPortId + ", mUid=" + this.mUid + ", mPid=" + this.mPid + ", mSessionId=" + this.mSessionId + ", mPackageName='" + this.mPackageName + "', mIsActive=" + this.mIsActive + ", mFlags=" + this.mFlags;
        }
    }

    public static final class PlaybackClient extends BaseClient implements ZPlaybackClientInterface {
        private final int mProductStrategy;
        private final int mStreamType;

        public PlaybackClient(ZAudioReportEntry entry, String packageName) {
            super(entry, packageName);
            this.mStreamType = entry.stream;
            this.mProductStrategy = entry.strategy;
        }

        @Override // com.android.server.audio.ZPlaybackClientInterface
        public int getStreamType() {
            return this.mStreamType;
        }

        @Override // com.android.server.audio.ZPlaybackClientInterface
        public int getProductStrategy() {
            return this.mProductStrategy;
        }

        @Override // com.android.server.audio.ZAudioMonitor.BaseClient, com.android.server.audio.ZAudioClientInterface
        public String toString() {
            return "PlaybackClient {" + super.toString() + "mStreamType=" + this.mStreamType + ", mProductStrategy=" + this.mProductStrategy + '}';
        }
    }

    public static final class RecordClient extends BaseClient implements ZRecordClientInterface {
        private final int mAudioSource;

        public RecordClient(ZAudioReportEntry entry, String packageName) {
            super(entry, packageName);
            this.mAudioSource = entry.audioSource;
        }

        @Override // com.android.server.audio.ZRecordClientInterface
        public int getAudioSource() {
            return this.mAudioSource;
        }

        @Override // com.android.server.audio.ZAudioMonitor.BaseClient, com.android.server.audio.ZAudioClientInterface
        public String toString() {
            return "RecordClient {" + super.toString() + "mAudioSource=" + this.mAudioSource + '}';
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$NCD3-a7WC6afIVwUDjXe0a3n0WI, reason: not valid java name */
    public static /* synthetic */ Map m2223$r8$lambda$NCD3a7WC6afIVwUDjXe0a3n0WI(Integer r0) {
        return lambda$handleClientStatusChanged$1(r0);
    }

    public static /* synthetic */ Map $r8$lambda$bPfELKLa3W8B_vi9eJ2pmJMcjKs(Integer r0) {
        return lambda$handleClientStatusChanged$0(r0);
    }

    public static /* synthetic */ String $r8$lambda$lY2MWbAjgw1_Ak4oa2C5Qnrd6jo(Map.Entry r0) {
        return lambda$convertCollectionToString$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$rhzxwFV-QYYbwkNkf1WyplIxPoo, reason: not valid java name */
    public static /* synthetic */ String m2224$r8$lambda$rhzxwFVQYYbwkNkf1WyplIxPoo(Object r0) {
        return lambda$convertCollectionToString$3(r0);
    }

    public ZAudioMonitor(ZAudioClientDispatcher dispatcher, IZAudioService service) throws IllegalArgumentException, RemoteException {
        this.mEventLogger = new EventLogger(20, "ZAudio service playbck & record monitor");
        this.mLock = new Object();
        this.mPlaybackMap = new HashMap();
        this.mRecordMap = new HashMap();
        this.mActiveStreamUidMap = new HashMap();
        this.mActiveUidStreamMap = new HashMap();
        this.mActiveSourceUidMap = new HashMap();
        this.mActiveUidSourceMap = new HashMap();
        this.mDispatcher = dispatcher;
        if (dispatcher == null) goto L8;
        if (service == null) goto L8;
        service.registerAudioClientMonitor(this);
        return;
    L8:
        throw new IllegalArgumentException("Bad parameter, dispatcher:" + dispatcher + ", service:" + service);
    }

    public List<Integer> getActiveUidsForStream(int streamType) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Map<Integer, Integer> uidMap = this.mActiveStreamUidMap.get(Integer.valueOf(streamType));     // Catch: Throwable -> L9
        if (uidMap != null) goto L11;
        List<Integer> r2 = Collections.emptyList();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        ArrayList r3 = new ArrayList(uidMap.values());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isStreamActive(int streamType) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mActiveStreamUidMap.containsKey(Integer.valueOf(streamType)) == true) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mActiveStreamUidMap.get(Integer.valueOf(streamType)).isEmpty() == true) goto L11;
        r1 = true;
        goto L12
    }

    public void onNewAudioClient(ZAudioReportEntry entry) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String packageName = entry.packageName;     // Catch: Throwable -> L7
        if (entry.isRecord == false) goto L9;
        Log.d(TAG, "Add record " + entry.portId + " " + entry.active + " " + entry.audioSource + " " + packageName);     // Catch: Throwable -> L7
        this.mRecordMap.put(Integer.valueOf(entry.portId), new RecordClient(entry, packageName));     // Catch: Throwable -> L7
        Log.v(TAG, convertCollectionToString(this.mRecordMap, "Recorder port map"));     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        Log.d(TAG, "Add track " + entry.portId + " " + entry.active + " " + entry.stream + " " + packageName);     // Catch: Throwable -> L7
        this.mPlaybackMap.put(Integer.valueOf(entry.portId), new PlaybackClient(entry, packageName));     // Catch: Throwable -> L7
        Log.v(TAG, convertCollectionToString(this.mPlaybackMap, "Player port map"));     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void onClientStart(int port) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Log.d(TAG, "onClientStart " + port);     // Catch: Throwable -> L7
        if (this.mRecordMap.containsKey(Integer.valueOf(port)) == false) goto L10;
        onClientStatusChange(this.mRecordMap.get(Integer.valueOf(port)), true);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L10:
        if (this.mPlaybackMap.containsKey(Integer.valueOf(port)) == false) goto L12;
        onClientStatusChange(this.mPlaybackMap.get(Integer.valueOf(port)), true);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void onClientStop(int port) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Log.d(TAG, "onClientStop " + port);     // Catch: Throwable -> L7
        if (this.mRecordMap.containsKey(Integer.valueOf(port)) == false) goto L10;
        onClientStatusChange(this.mRecordMap.get(Integer.valueOf(port)), false);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L10:
        if (this.mPlaybackMap.containsKey(Integer.valueOf(port)) == false) goto L12;
        onClientStatusChange(this.mPlaybackMap.get(Integer.valueOf(port)), false);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter pw) {
        pw.println("\nAudioMonitor status:");
        pw.println("  " + convertCollectionToString(this.mRecordMap, "Recorder port map"));
        pw.println("  " + convertCollectionToString(this.mPlaybackMap, "Player port map"));
        pw.println("  " + convertCollectionToString(this.mActiveSourceUidMap, "Source Uid map"));
        pw.println("  " + convertCollectionToString(this.mActiveUidSourceMap, "Uid Source map"));
        pw.println("  " + convertCollectionToString(this.mActiveStreamUidMap, "Stream Uid map"));
        pw.println("  " + convertCollectionToString(this.mActiveUidStreamMap, "Uid Stream map"));
        this.mEventLogger.dump(pw, "  ");
    }

    void handleClientStatusChanged(BaseClient client, Map<Integer, Map<Integer, Integer>> subjectToUids, Map<Integer, Map<Integer, Integer>> uidToSubjects, int subject, String subjectName, BiConsumer<Integer, Boolean> onSubjectChanged, BiConsumer<Integer, Boolean> onUidChanged) {
        boolean isActive = client.isActive();
        int portId = client.getPortId();
        int uid = client.getUid();
        Log.v(TAG, "handleClientStatusChanged port:" + portId + " start:" + isActive + " subject:" + subject);
        if (isActive == false) goto L12;
        subjectToUids.computeIfAbsent(Integer.valueOf(subject), new ZAudioMonitor$$ExternalSyntheticLambda6()).put(Integer.valueOf(portId), Integer.valueOf(uid));
        uidToSubjects.computeIfAbsent(Integer.valueOf(uid), new ZAudioMonitor$$ExternalSyntheticLambda7()).put(Integer.valueOf(portId), Integer.valueOf(subject));
        Map<Integer, Integer> portUids = subjectToUids.get(Integer.valueOf(subject));
        if (portUids.size() != 1) goto L7;
        Log.v(TAG, "handleClientStatusChanged on" + subjectName + "changed " + subjectName + ":" + subject + " start:" + isActive);
        onSubjectChanged.accept(Integer.valueOf(subject), true);
    L7:
        Map<Integer, Integer> portSubjects = uidToSubjects.get(Integer.valueOf(uid));
        if (portSubjects.size() != 1) goto L11;
        Log.v(TAG, "handleClientStatusChanged onUidChanged uid:" + uid + " start:" + isActive);
        onUidChanged.accept(Integer.valueOf(uid), true);
    L11:
        Log.v(TAG, "handleClientStatusChanged portUids " + convertCollectionToString(portUids, "portUids"));
        Log.v(TAG, "handleClientStatusChanged portSubjects " + convertCollectionToString(portSubjects, "portSubjects"));
        return;
    L12:
        Map<Integer, Integer> portUids2 = subjectToUids.get(Integer.valueOf(subject));
        if (portUids2 == null) goto L17;
        String r21 = "handleClientStatusChanged portUids ";
        portUids2.remove(Integer.valueOf(portId));
        if (portUids2.isEmpty() == false) goto L18;
        subjectToUids.remove(Integer.valueOf(subject));
        Log.v(TAG, "handleClientStatusChanged on" + subjectName + "changed " + subjectName + ":" + subject + " start:" + isActive);
        onSubjectChanged.accept(Integer.valueOf(subject), false);
    L18:
        Map<Integer, Integer> portSubjects2 = uidToSubjects.get(Integer.valueOf(uid));
        if (portSubjects2 == null) goto L23;
        portSubjects2.remove(Integer.valueOf(portId));
        if (portSubjects2.isEmpty() == false) goto L23;
        uidToSubjects.remove(Integer.valueOf(uid));
        Log.v(TAG, "handleClientStatusChanged onUidChanged uid:" + uid + " start:" + isActive);
        onUidChanged.accept(Integer.valueOf(uid), false);
    L23:
        Log.v(TAG, r21 + convertCollectionToString(portUids2, "portUids"));
        Log.v(TAG, "handleClientStatusChanged portSubjects " + convertCollectionToString(portSubjects2, "portSubjects"));
        return;
    L17:
        r21 = "handleClientStatusChanged portUids ";
        goto L18
    }

    private static /* synthetic */ Map lambda$handleClientStatusChanged$0(Integer k) {
        return new HashMap();
    }

    private static /* synthetic */ Map lambda$handleClientStatusChanged$1(Integer k) {
        return new HashMap();
    }

    public void onClientRelease(int port) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mRecordMap.containsKey(Integer.valueOf(port)) == false) goto L10;
        Log.v(TAG, "Remove record port:" + port);     // Catch: Throwable -> L7
        onClientStatusChange(this.mRecordMap.get(Integer.valueOf(port)), false);     // Catch: Throwable -> L7
        this.mRecordMap.remove(Integer.valueOf(port));     // Catch: Throwable -> L7
    L10:
        if (this.mPlaybackMap.containsKey(Integer.valueOf(port)) == false) goto L12;
        Log.v(TAG, "Remove track port" + port);     // Catch: Throwable -> L7
        onClientStatusChange(this.mPlaybackMap.get(Integer.valueOf(port)), false);     // Catch: Throwable -> L7
        this.mPlaybackMap.remove(Integer.valueOf(port));     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private <T extends BaseClient> void onClientStatusChange(T client, boolean isStart) {
        Log.v(TAG, "onClientStatusChange client:" + client + " isStart:" + isStart);
        if (client.isActive() != isStart) goto L5;
        return;
    L5:
        client.setActive(isStart);
    L10:
        e = move-exception;
        Log.v(TAG, "An error occurred: " + e.getMessage());
        return;
    L8:
        if ((client instanceof ZRecordClientInterface) == false) goto L13;
        ZRecordClientInterface recordClient = (ZRecordClientInterface) client;     // Catch: Exception -> L10
        this.mEventLogger.enqueueAndLog("onClientStatusChange record port:" + client.getPortId() + " start:" + isStart, 3, TAG);     // Catch: Exception -> L10
        int audioSource = recordClient.getAudioSource();     // Catch: Exception -> L10
        Map<Integer, Map<Integer, Integer>> r3 = this.mActiveSourceUidMap;     // Catch: Exception -> L10
        Map<Integer, Map<Integer, Integer>> r4 = this.mActiveUidSourceMap;     // Catch: Exception -> L10
        final ZAudioClientDispatcher r7 = this.mDispatcher;     // Catch: Exception -> L10
        r7.getClass();     // Catch: Exception -> L10
        BiConsumer<Integer, Boolean> r8 = new ZAudioMonitor$$ExternalSyntheticLambda2(r7);     // Catch: Exception -> L10
        final ZAudioClientDispatcher r9 = this.mDispatcher;     // Catch: Exception -> L10
        r9.getClass();     // Catch: Exception -> L10
        handleClientStatusChanged(client, r3, r4, audioSource, "audioSource", r8, new ZAudioMonitor$$ExternalSyntheticLambda3(r9));     // Catch: Exception -> L10
        this.mDispatcher.dispatchRecordingActive(recordClient, isStart);     // Catch: Exception -> L10
        this.mEventLogger.enqueueAndLog(convertCollectionToString(this.mActiveSourceUidMap, "Source Uid map"), 3, TAG);     // Catch: Exception -> L10
        this.mEventLogger.enqueueAndLog(convertCollectionToString(this.mActiveUidSourceMap, "Uid Source map"), 3, TAG);     // Catch: Exception -> L10
    L18:
        return;
    L13:
        if ((client instanceof ZPlaybackClientInterface) == false) goto L18;
        ZPlaybackClientInterface playbackClient = (ZPlaybackClientInterface) client;     // Catch: Exception -> L10
        this.mEventLogger.enqueueAndLog("onClientStatusChange playback port:" + client.getPortId() + " start:" + isStart, 3, TAG);     // Catch: Exception -> L10
        int streamType = playbackClient.getStreamType();     // Catch: Exception -> L10
        Map<Integer, Map<Integer, Integer>> r5 = this.mActiveStreamUidMap;     // Catch: Exception -> L10
        Map<Integer, Map<Integer, Integer>> r6 = this.mActiveUidStreamMap;     // Catch: Exception -> L10
        final ZAudioClientDispatcher r10 = this.mDispatcher;     // Catch: Exception -> L10
        r10.getClass();     // Catch: Exception -> L10
        BiConsumer<Integer, Boolean> r11 = new ZAudioMonitor$$ExternalSyntheticLambda4(r10);     // Catch: Exception -> L10
        final ZAudioClientDispatcher r12 = this.mDispatcher;     // Catch: Exception -> L10
        r12.getClass();     // Catch: Exception -> L10
        handleClientStatusChanged(client, r5, r6, streamType, "streamType", r11, new ZAudioMonitor$$ExternalSyntheticLambda5(r12));     // Catch: Exception -> L10
        this.mDispatcher.dispatchPlaybackActive(playbackClient, isStart);     // Catch: Exception -> L10
        this.mEventLogger.enqueueAndLog(convertCollectionToString(this.mActiveStreamUidMap, "Stream Uid map"), 3, TAG);     // Catch: Exception -> L10
        this.mEventLogger.enqueueAndLog(convertCollectionToString(this.mActiveUidSourceMap, "Uid Stream map"), 3, TAG);     // Catch: Exception -> L10
        goto L18
    }

    public static String convertCollectionToString(Object collection, String containerName) {
        if ((collection instanceof Map) == false) goto L7;
        Map<?, ?> map = (Map) collection;
        return containerName + ": " + ((String) map.entrySet().stream().map(new ZAudioMonitor$$ExternalSyntheticLambda0()).collect(Collectors.joining(", ", "{", "}")));
    L7:
        if ((collection instanceof List) == false) goto L11;
        List<?> list = (List) collection;
        return containerName + ": " + ((String) list.stream().map(new ZAudioMonitor$$ExternalSyntheticLambda1()).collect(Collectors.joining(", ", "[", "]")));
    L11:
        return collection.toString();
    }

    private static /* synthetic */ String lambda$convertCollectionToString$2(Map.Entry entry) {
        return entry.getKey() + ": " + convertCollectionToString(entry.getValue(), "");
    }

    private static /* synthetic */ String lambda$convertCollectionToString$3(Object element) {
        if ((element instanceof ZRecordClientInterface) == false) goto L7;
        return ((ZRecordClientInterface) element).toString();
    L7:
        if ((element instanceof ZPlaybackClientInterface) == false) goto L11;
        return ((ZPlaybackClientInterface) element).toString();
    L11:
        return element.toString();
    }
}
