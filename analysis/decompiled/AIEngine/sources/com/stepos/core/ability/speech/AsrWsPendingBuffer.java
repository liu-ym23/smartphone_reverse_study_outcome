package com.stepos.core.ability.speech;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrWsPendingBuffer {
    private final mb.k<Frame> deque = new mb.k<>();
    private final long limitPcmBytes;
    private long totalPcmBytes;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DrainResult {
        private final List<Frame> frames;
        private final long pcmBytes;

        public DrainResult(List<Frame> frames, long j10) {
            kotlin.jvm.internal.g.f(frames, "frames");
            this.frames = frames;
            this.pcmBytes = j10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DrainResult copy$default(DrainResult drainResult, List list, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                list = drainResult.frames;
            }
            if ((i10 & 2) != 0) {
                j10 = drainResult.pcmBytes;
            }
            return drainResult.copy(list, j10);
        }

        public final List<Frame> component1() {
            return this.frames;
        }

        public final long component2() {
            return this.pcmBytes;
        }

        public final DrainResult copy(List<Frame> frames, long j10) {
            kotlin.jvm.internal.g.f(frames, "frames");
            return new DrainResult(frames, j10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrainResult)) {
                return false;
            }
            DrainResult drainResult = (DrainResult) obj;
            return kotlin.jvm.internal.g.b(this.frames, drainResult.frames) && this.pcmBytes == drainResult.pcmBytes;
        }

        public final List<Frame> getFrames() {
            return this.frames;
        }

        public final long getPcmBytes() {
            return this.pcmBytes;
        }

        public int hashCode() {
            return Long.hashCode(this.pcmBytes) + (this.frames.hashCode() * 31);
        }

        public String toString() {
            return "DrainResult(frames=" + this.frames + ", pcmBytes=" + this.pcmBytes + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class EnqueueResult {
        private final int droppedFrames;
        private final long droppedPcmBytes;

        public EnqueueResult(int i10, long j10) {
            this.droppedFrames = i10;
            this.droppedPcmBytes = j10;
        }

        public static /* synthetic */ EnqueueResult copy$default(EnqueueResult enqueueResult, int i10, long j10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = enqueueResult.droppedFrames;
            }
            if ((i11 & 2) != 0) {
                j10 = enqueueResult.droppedPcmBytes;
            }
            return enqueueResult.copy(i10, j10);
        }

        public final int component1() {
            return this.droppedFrames;
        }

        public final long component2() {
            return this.droppedPcmBytes;
        }

        public final EnqueueResult copy(int i10, long j10) {
            return new EnqueueResult(i10, j10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EnqueueResult)) {
                return false;
            }
            EnqueueResult enqueueResult = (EnqueueResult) obj;
            return this.droppedFrames == enqueueResult.droppedFrames && this.droppedPcmBytes == enqueueResult.droppedPcmBytes;
        }

        public final int getDroppedFrames() {
            return this.droppedFrames;
        }

        public final long getDroppedPcmBytes() {
            return this.droppedPcmBytes;
        }

        public int hashCode() {
            return Long.hashCode(this.droppedPcmBytes) + (Integer.hashCode(this.droppedFrames) * 31);
        }

        public String toString() {
            return "EnqueueResult(droppedFrames=" + this.droppedFrames + ", droppedPcmBytes=" + this.droppedPcmBytes + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Frame {
        private final int pcmBytes;
        private final String wire;

        public Frame(String wire, int i10) {
            kotlin.jvm.internal.g.f(wire, "wire");
            this.wire = wire;
            this.pcmBytes = i10;
        }

        public static /* synthetic */ Frame copy$default(Frame frame, String str, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = frame.wire;
            }
            if ((i11 & 2) != 0) {
                i10 = frame.pcmBytes;
            }
            return frame.copy(str, i10);
        }

        public final String component1() {
            return this.wire;
        }

        public final int component2() {
            return this.pcmBytes;
        }

        public final Frame copy(String wire, int i10) {
            kotlin.jvm.internal.g.f(wire, "wire");
            return new Frame(wire, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Frame)) {
                return false;
            }
            Frame frame = (Frame) obj;
            return kotlin.jvm.internal.g.b(this.wire, frame.wire) && this.pcmBytes == frame.pcmBytes;
        }

        public final int getPcmBytes() {
            return this.pcmBytes;
        }

        public final String getWire() {
            return this.wire;
        }

        public int hashCode() {
            return Integer.hashCode(this.pcmBytes) + (this.wire.hashCode() * 31);
        }

        public String toString() {
            return ai.onnxruntime.a.i("Frame(wire=", this.pcmBytes, this.wire, ", pcmBytes=", ")");
        }
    }

    public AsrWsPendingBuffer(long j10) {
        this.limitPcmBytes = j10;
    }

    private final EnqueueResult trimOldestLocked(long j10) {
        int i10 = 0;
        long pcmBytes = 0;
        while (this.totalPcmBytes > j10 && !this.deque.isEmpty()) {
            Frame frameRemoveFirst = this.deque.removeFirst();
            this.totalPcmBytes -= frameRemoveFirst.getPcmBytes();
            i10++;
            pcmBytes += frameRemoveFirst.getPcmBytes();
        }
        return new EnqueueResult(i10, pcmBytes);
    }

    public final synchronized void clear() {
        this.deque.clear();
        this.totalPcmBytes = 0L;
    }

    public final synchronized DrainResult drainBatch(int i10) {
        long pcmBytes = 0;
        if (i10 > 0) {
            try {
                if (!this.deque.isEmpty()) {
                    int iMin = Math.min(i10, this.deque.a());
                    ArrayList arrayList = new ArrayList(iMin);
                    for (int i11 = 0; i11 < iMin; i11++) {
                        arrayList.add(this.deque.removeFirst());
                        pcmBytes += r4.getPcmBytes();
                        this.totalPcmBytes -= r4.getPcmBytes();
                    }
                    return new DrainResult(arrayList, pcmBytes);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return new DrainResult(EmptyList.f10001a, 0L);
    }

    public final synchronized EnqueueResult enqueue(String wire, int i10) {
        kotlin.jvm.internal.g.f(wire, "wire");
        if (i10 < 0) {
            throw new IllegalArgumentException("pcmBytes must be non-negative");
        }
        this.deque.addLast(new Frame(wire, i10));
        this.totalPcmBytes += i10;
        return trimOldestLocked(this.limitPcmBytes);
    }

    public final synchronized int frameCount() {
        return this.deque.a();
    }

    public final synchronized long pcmBytesQueued() {
        return this.totalPcmBytes;
    }

    public final synchronized EnqueueResult trimOldest(long j10) {
        return trimOldestLocked(j10);
    }
}
