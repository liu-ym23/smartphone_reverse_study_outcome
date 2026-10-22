package com.stepos.core.ability.speech;

import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.common.util.AsrParamKeys;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.base.Content;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrStreamingBuffer {
    public static final Companion Companion = new Companion(null);
    private final ConcurrentHashMap<String, PendingStash> pendingChunks;
    private final long pendingStashLimitBytes;
    private final ConcurrentHashMap<String, Session> sessions;
    private final ConcurrentHashMap.KeySetView<String, Boolean> terminatedInferIds;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final boolean isStreamingSignal(Content input) {
            kotlin.jvm.internal.g.f(input, "input");
            if (!(input instanceof AudioContent)) {
                return false;
            }
            AudioContent audioContent = (AudioContent) input;
            return audioContent.getEncoding() == 2 && audioContent.getAudioBytes().length == 0;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface FeedResult {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Buffered implements FeedResult {
            public static final Buffered INSTANCE = new Buffered();

            private Buffered() {
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class DroppedTerminated implements FeedResult {
            public static final DroppedTerminated INSTANCE = new DroppedTerminated();

            private DroppedTerminated() {
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Forward implements FeedResult {
            public static final Forward INSTANCE = new Forward();

            private Forward() {
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class NotStreaming implements FeedResult {
            public static final NotStreaming INSTANCE = new NotStreaming();

            private NotStreaming() {
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class StashedPending implements FeedResult {
            private final long droppedBytes;
            private final int droppedFrames;
            private final boolean firstStash;
            private final long stashedBytes;

            public StashedPending(boolean z, long j10, int i10, long j11) {
                this.firstStash = z;
                this.stashedBytes = j10;
                this.droppedFrames = i10;
                this.droppedBytes = j11;
            }

            public static /* synthetic */ StashedPending copy$default(StashedPending stashedPending, boolean z, long j10, int i10, long j11, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    z = stashedPending.firstStash;
                }
                if ((i11 & 2) != 0) {
                    j10 = stashedPending.stashedBytes;
                }
                if ((i11 & 4) != 0) {
                    i10 = stashedPending.droppedFrames;
                }
                if ((i11 & 8) != 0) {
                    j11 = stashedPending.droppedBytes;
                }
                int i12 = i10;
                return stashedPending.copy(z, j10, i12, j11);
            }

            public final boolean component1() {
                return this.firstStash;
            }

            public final long component2() {
                return this.stashedBytes;
            }

            public final int component3() {
                return this.droppedFrames;
            }

            public final long component4() {
                return this.droppedBytes;
            }

            public final StashedPending copy(boolean z, long j10, int i10, long j11) {
                return new StashedPending(z, j10, i10, j11);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof StashedPending)) {
                    return false;
                }
                StashedPending stashedPending = (StashedPending) obj;
                return this.firstStash == stashedPending.firstStash && this.stashedBytes == stashedPending.stashedBytes && this.droppedFrames == stashedPending.droppedFrames && this.droppedBytes == stashedPending.droppedBytes;
            }

            public final long getDroppedBytes() {
                return this.droppedBytes;
            }

            public final int getDroppedFrames() {
                return this.droppedFrames;
            }

            public final boolean getFirstStash() {
                return this.firstStash;
            }

            public final long getStashedBytes() {
                return this.stashedBytes;
            }

            public int hashCode() {
                return Long.hashCode(this.droppedBytes) + ai.onnxruntime.a.d(this.droppedFrames, a0.a.c(Boolean.hashCode(this.firstStash) * 31, this.stashedBytes, 31), 31);
            }

            public String toString() {
                boolean z = this.firstStash;
                long j10 = this.stashedBytes;
                int i10 = this.droppedFrames;
                long j11 = this.droppedBytes;
                StringBuilder sb2 = new StringBuilder("StashedPending(firstStash=");
                sb2.append(z);
                sb2.append(", stashedBytes=");
                sb2.append(j10);
                sb2.append(", droppedFrames=");
                sb2.append(i10);
                sb2.append(", droppedBytes=");
                return ai.onnxruntime.a.m(sb2, j11, ")");
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class PendingStash {
        private final TreeMap<Integer, byte[]> chunks = new TreeMap<>();
        private int noSeqCounter;
        private long totalBytes;

        public final TreeMap<Integer, byte[]> getChunks() {
            return this.chunks;
        }

        public final int getNoSeqCounter() {
            return this.noSeqCounter;
        }

        public final long getTotalBytes() {
            return this.totalBytes;
        }

        public final void setNoSeqCounter(int i10) {
            this.noSeqCounter = i10;
        }

        public final void setTotalBytes(long j10) {
            this.totalBytes = j10;
        }
    }

    public AsrStreamingBuffer() {
        this(0L, 1, null);
    }

    public static /* synthetic */ void openSession$default(AsrStreamingBuffer asrStreamingBuffer, String str, IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            contentParams = null;
        }
        asrStreamingBuffer.openSession(str, iInferenceCallback, i10, contentParams);
    }

    public final void cancelAll() {
        this.sessions.clear();
        this.pendingChunks.clear();
        this.terminatedInferIds.clear();
    }

    public final void clearTerminated(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        this.terminatedInferIds.remove(inferId);
    }

    public final CompletedAudio complete(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        Session sessionRemove = this.sessions.remove(inferId);
        if (sessionRemove == null) {
            return null;
        }
        return new CompletedAudio(new byte[0], sessionRemove.getCallback(), sessionRemove.getCallerUid(), sessionRemove.getParams(), sessionRemove.getSampleRate(), sessionRemove.getChannelCount());
    }

    public final void dropPending(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        this.pendingChunks.remove(inferId);
    }

    public final FeedResult feed(String inferId, Content input) {
        boolean zIsEmpty;
        long length;
        int i10;
        long totalBytes;
        PendingStash pendingStashPutIfAbsent;
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(input, "input");
        if (isTerminated(inferId)) {
            return FeedResult.DroppedTerminated.INSTANCE;
        }
        Session session = this.sessions.get(inferId);
        if (session != null) {
            if (input instanceof AudioContent) {
                AudioContent audioContent = (AudioContent) input;
                if (!(audioContent.getAudioBytes().length == 0)) {
                    if (session.getSampleRate() == 0 && audioContent.getSampleRate() > 0) {
                        session.setSampleRate(audioContent.getSampleRate());
                    }
                    if (session.getChannelCount() == 0 && audioContent.getChannelCount() > 0) {
                        session.setChannelCount(audioContent.getChannelCount());
                    }
                    return FeedResult.Forward.INSTANCE;
                }
            }
            return FeedResult.Buffered.INSTANCE;
        }
        if (input instanceof AudioContent) {
            AudioContent audioContent2 = (AudioContent) input;
            if (audioContent2.getEncoding() == 2) {
                byte[] audioBytes = audioContent2.getAudioBytes();
                ContentParams params = audioContent2.getParams();
                int i11 = params != null ? params.getInt(AsrParamKeys.REALTIME_FEED_SEQ, -1) : -1;
                ConcurrentHashMap<String, PendingStash> concurrentHashMap = this.pendingChunks;
                PendingStash pendingStash = concurrentHashMap.get(inferId);
                if (pendingStash == null && (pendingStashPutIfAbsent = concurrentHashMap.putIfAbsent(inferId, (pendingStash = new PendingStash()))) != null) {
                    pendingStash = pendingStashPutIfAbsent;
                }
                PendingStash pendingStash2 = pendingStash;
                synchronized (pendingStash2) {
                    try {
                        zIsEmpty = pendingStash2.getChunks().isEmpty();
                        if (i11 < 0) {
                            int noSeqCounter = pendingStash2.getNoSeqCounter();
                            pendingStash2.setNoSeqCounter(noSeqCounter + 1);
                            i11 = noSeqCounter - Integer.MIN_VALUE;
                        }
                        pendingStash2.setTotalBytes(pendingStash2.getTotalBytes() + (audioBytes.length - (pendingStash2.getChunks().put(Integer.valueOf(i11), audioBytes) != null ? r12.length : 0)));
                        length = 0;
                        i10 = 0;
                        while (pendingStash2.getTotalBytes() > this.pendingStashLimitBytes && !pendingStash2.getChunks().isEmpty()) {
                            byte[] value = pendingStash2.getChunks().pollFirstEntry().getValue();
                            pendingStash2.setTotalBytes(pendingStash2.getTotalBytes() - value.length);
                            i10++;
                            length += value.length;
                        }
                        totalBytes = pendingStash2.getTotalBytes();
                        lb.n nVar = lb.n.f10413a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return new FeedResult.StashedPending(zIsEmpty, totalBytes, i10, length);
            }
        }
        return FeedResult.NotStreaming.INSTANCE;
    }

    public final boolean isStreamingSignal(Content input) {
        kotlin.jvm.internal.g.f(input, "input");
        return Companion.isStreamingSignal(input);
    }

    public final boolean isTerminated(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        return this.terminatedInferIds.contains(inferId);
    }

    public final void markTerminated(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        this.terminatedInferIds.add(inferId);
        this.pendingChunks.remove(inferId);
    }

    public final void openSession(String inferId, IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        this.sessions.put(inferId, new Session(iInferenceCallback, i10, contentParams, 0, 0, 24, null));
    }

    public final List<byte[]> takePending(String inferId) {
        List<byte[]> listO0;
        kotlin.jvm.internal.g.f(inferId, "inferId");
        PendingStash pendingStashRemove = this.pendingChunks.remove(inferId);
        if (pendingStashRemove == null) {
            return EmptyList.f10001a;
        }
        synchronized (pendingStashRemove) {
            Collection<byte[]> collectionValues = pendingStashRemove.getChunks().values();
            kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
            listO0 = kotlin.collections.a.O0(collectionValues);
        }
        return listO0;
    }

    public final List<Pair<Integer, byte[]>> takePendingWithSeq(String inferId) {
        ArrayList arrayList;
        kotlin.jvm.internal.g.f(inferId, "inferId");
        PendingStash pendingStashRemove = this.pendingChunks.remove(inferId);
        if (pendingStashRemove == null) {
            return EmptyList.f10001a;
        }
        synchronized (pendingStashRemove) {
            try {
                Set<Map.Entry<Integer, byte[]>> setEntrySet = pendingStashRemove.getChunks().entrySet();
                kotlin.jvm.internal.g.e(setEntrySet, "<get-entries>(...)");
                Set<Map.Entry<Integer, byte[]>> set = setEntrySet;
                arrayList = new ArrayList(mb.m.Z(set, 10));
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    kotlin.jvm.internal.g.c(entry);
                    Object key = entry.getKey();
                    kotlin.jvm.internal.g.e(key, "component1(...)");
                    Integer num = (Integer) key;
                    Object value = entry.getValue();
                    kotlin.jvm.internal.g.e(value, "component2(...)");
                    arrayList.add(new Pair(Integer.valueOf(num.intValue() >= 0 ? num.intValue() : -1), (byte[]) value));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public AsrStreamingBuffer(long j10) {
        this.pendingStashLimitBytes = j10;
        this.sessions = new ConcurrentHashMap<>();
        this.pendingChunks = new ConcurrentHashMap<>();
        this.terminatedInferIds = ConcurrentHashMap.newKeySet();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Session {
        private final IInferenceCallback callback;
        private final int callerUid;
        private volatile int channelCount;
        private final ContentParams params;
        private volatile int sampleRate;

        public Session(IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, int i11, int i12) {
            this.callback = iInferenceCallback;
            this.callerUid = i10;
            this.params = contentParams;
            this.sampleRate = i11;
            this.channelCount = i12;
        }

        public static /* synthetic */ Session copy$default(Session session, IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                iInferenceCallback = session.callback;
            }
            if ((i13 & 2) != 0) {
                i10 = session.callerUid;
            }
            if ((i13 & 4) != 0) {
                contentParams = session.params;
            }
            if ((i13 & 8) != 0) {
                i11 = session.sampleRate;
            }
            if ((i13 & 16) != 0) {
                i12 = session.channelCount;
            }
            int i14 = i12;
            ContentParams contentParams2 = contentParams;
            return session.copy(iInferenceCallback, i10, contentParams2, i11, i14);
        }

        public final IInferenceCallback component1() {
            return this.callback;
        }

        public final int component2() {
            return this.callerUid;
        }

        public final ContentParams component3() {
            return this.params;
        }

        public final int component4() {
            return this.sampleRate;
        }

        public final int component5() {
            return this.channelCount;
        }

        public final Session copy(IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, int i11, int i12) {
            return new Session(iInferenceCallback, i10, contentParams, i11, i12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Session)) {
                return false;
            }
            Session session = (Session) obj;
            return kotlin.jvm.internal.g.b(this.callback, session.callback) && this.callerUid == session.callerUid && kotlin.jvm.internal.g.b(this.params, session.params) && this.sampleRate == session.sampleRate && this.channelCount == session.channelCount;
        }

        public final IInferenceCallback getCallback() {
            return this.callback;
        }

        public final int getCallerUid() {
            return this.callerUid;
        }

        public final int getChannelCount() {
            return this.channelCount;
        }

        public final ContentParams getParams() {
            return this.params;
        }

        public final int getSampleRate() {
            return this.sampleRate;
        }

        public int hashCode() {
            IInferenceCallback iInferenceCallback = this.callback;
            int iD = ai.onnxruntime.a.d(this.callerUid, (iInferenceCallback == null ? 0 : iInferenceCallback.hashCode()) * 31, 31);
            ContentParams contentParams = this.params;
            return Integer.hashCode(this.channelCount) + ai.onnxruntime.a.d(this.sampleRate, (iD + (contentParams != null ? contentParams.hashCode() : 0)) * 31, 31);
        }

        public final void setChannelCount(int i10) {
            this.channelCount = i10;
        }

        public final void setSampleRate(int i10) {
            this.sampleRate = i10;
        }

        public String toString() {
            IInferenceCallback iInferenceCallback = this.callback;
            int i10 = this.callerUid;
            ContentParams contentParams = this.params;
            int i11 = this.sampleRate;
            int i12 = this.channelCount;
            StringBuilder sb2 = new StringBuilder("Session(callback=");
            sb2.append(iInferenceCallback);
            sb2.append(", callerUid=");
            sb2.append(i10);
            sb2.append(", params=");
            sb2.append(contentParams);
            sb2.append(", sampleRate=");
            sb2.append(i11);
            sb2.append(", channelCount=");
            return ai.onnxruntime.a.j(")", i12, sb2);
        }

        public /* synthetic */ Session(IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, int i11, int i12, int i13, kotlin.jvm.internal.e eVar) {
            this(iInferenceCallback, i10, (i13 & 4) != 0 ? null : contentParams, (i13 & 8) != 0 ? 0 : i11, (i13 & 16) != 0 ? 0 : i12);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class CompletedAudio {
        private final IInferenceCallback callback;
        private final int callerUid;
        private final int channelCount;
        private final ContentParams params;
        private final byte[] pcmBytes;
        private final int sampleRate;

        public CompletedAudio(byte[] pcmBytes, IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, int i11, int i12) {
            kotlin.jvm.internal.g.f(pcmBytes, "pcmBytes");
            this.pcmBytes = pcmBytes;
            this.callback = iInferenceCallback;
            this.callerUid = i10;
            this.params = contentParams;
            this.sampleRate = i11;
            this.channelCount = i12;
        }

        public static /* synthetic */ CompletedAudio copy$default(CompletedAudio completedAudio, byte[] bArr, IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                bArr = completedAudio.pcmBytes;
            }
            if ((i13 & 2) != 0) {
                iInferenceCallback = completedAudio.callback;
            }
            if ((i13 & 4) != 0) {
                i10 = completedAudio.callerUid;
            }
            if ((i13 & 8) != 0) {
                contentParams = completedAudio.params;
            }
            if ((i13 & 16) != 0) {
                i11 = completedAudio.sampleRate;
            }
            if ((i13 & 32) != 0) {
                i12 = completedAudio.channelCount;
            }
            int i14 = i11;
            int i15 = i12;
            return completedAudio.copy(bArr, iInferenceCallback, i10, contentParams, i14, i15);
        }

        public final byte[] component1() {
            return this.pcmBytes;
        }

        public final IInferenceCallback component2() {
            return this.callback;
        }

        public final int component3() {
            return this.callerUid;
        }

        public final ContentParams component4() {
            return this.params;
        }

        public final int component5() {
            return this.sampleRate;
        }

        public final int component6() {
            return this.channelCount;
        }

        public final CompletedAudio copy(byte[] pcmBytes, IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, int i11, int i12) {
            kotlin.jvm.internal.g.f(pcmBytes, "pcmBytes");
            return new CompletedAudio(pcmBytes, iInferenceCallback, i10, contentParams, i11, i12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CompletedAudio)) {
                return false;
            }
            CompletedAudio completedAudio = (CompletedAudio) obj;
            return kotlin.jvm.internal.g.b(this.pcmBytes, completedAudio.pcmBytes) && kotlin.jvm.internal.g.b(this.callback, completedAudio.callback) && this.callerUid == completedAudio.callerUid && kotlin.jvm.internal.g.b(this.params, completedAudio.params) && this.sampleRate == completedAudio.sampleRate && this.channelCount == completedAudio.channelCount;
        }

        public final IInferenceCallback getCallback() {
            return this.callback;
        }

        public final int getCallerUid() {
            return this.callerUid;
        }

        public final int getChannelCount() {
            return this.channelCount;
        }

        public final ContentParams getParams() {
            return this.params;
        }

        public final byte[] getPcmBytes() {
            return this.pcmBytes;
        }

        public final int getSampleRate() {
            return this.sampleRate;
        }

        public int hashCode() {
            int iHashCode = Arrays.hashCode(this.pcmBytes) * 31;
            IInferenceCallback iInferenceCallback = this.callback;
            int iD = ai.onnxruntime.a.d(this.callerUid, (iHashCode + (iInferenceCallback == null ? 0 : iInferenceCallback.hashCode())) * 31, 31);
            ContentParams contentParams = this.params;
            return Integer.hashCode(this.channelCount) + ai.onnxruntime.a.d(this.sampleRate, (iD + (contentParams != null ? contentParams.hashCode() : 0)) * 31, 31);
        }

        public String toString() {
            return "CompletedAudio(pcmBytes=" + Arrays.toString(this.pcmBytes) + ", callback=" + this.callback + ", callerUid=" + this.callerUid + ", params=" + this.params + ", sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + ")";
        }

        public /* synthetic */ CompletedAudio(byte[] bArr, IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, int i11, int i12, int i13, kotlin.jvm.internal.e eVar) {
            this(bArr, iInferenceCallback, i10, (i13 & 8) != 0 ? null : contentParams, (i13 & 16) != 0 ? 0 : i11, (i13 & 32) != 0 ? 0 : i12);
        }
    }

    public /* synthetic */ AsrStreamingBuffer(long j10, int i10, kotlin.jvm.internal.e eVar) {
        this((i10 & 1) != 0 ? 8388608L : j10);
    }
}
