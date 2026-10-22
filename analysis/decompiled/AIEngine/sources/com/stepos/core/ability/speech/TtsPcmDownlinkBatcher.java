package com.stepos.core.ability.speech;

import androidx.datastore.preferences.protobuf.b1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsPcmDownlinkBatcher {
    private final int batchChunks;
    private int channels;
    private final ArrayList<byte[]> pending;
    private int sampleRate;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class PcmBatch {
        private final int channels;
        private final byte[] pcm;
        private final int sampleRate;

        public PcmBatch(byte[] pcm, int i10, int i11) {
            kotlin.jvm.internal.g.f(pcm, "pcm");
            this.pcm = pcm;
            this.sampleRate = i10;
            this.channels = i11;
        }

        public static /* synthetic */ PcmBatch copy$default(PcmBatch pcmBatch, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                bArr = pcmBatch.pcm;
            }
            if ((i12 & 2) != 0) {
                i10 = pcmBatch.sampleRate;
            }
            if ((i12 & 4) != 0) {
                i11 = pcmBatch.channels;
            }
            return pcmBatch.copy(bArr, i10, i11);
        }

        public final byte[] component1() {
            return this.pcm;
        }

        public final int component2() {
            return this.sampleRate;
        }

        public final int component3() {
            return this.channels;
        }

        public final PcmBatch copy(byte[] pcm, int i10, int i11) {
            kotlin.jvm.internal.g.f(pcm, "pcm");
            return new PcmBatch(pcm, i10, i11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PcmBatch)) {
                return false;
            }
            PcmBatch pcmBatch = (PcmBatch) obj;
            return kotlin.jvm.internal.g.b(this.pcm, pcmBatch.pcm) && this.sampleRate == pcmBatch.sampleRate && this.channels == pcmBatch.channels;
        }

        public final int getChannels() {
            return this.channels;
        }

        public final byte[] getPcm() {
            return this.pcm;
        }

        public final int getSampleRate() {
            return this.sampleRate;
        }

        public int hashCode() {
            return Integer.hashCode(this.channels) + ai.onnxruntime.a.d(this.sampleRate, Arrays.hashCode(this.pcm) * 31, 31);
        }

        public String toString() {
            return ai.onnxruntime.a.j(")", this.channels, h0.e.f("PcmBatch(pcm=", Arrays.toString(this.pcm), ", sampleRate=", this.sampleRate, ", channels="));
        }
    }

    public TtsPcmDownlinkBatcher(int i10) {
        this.batchChunks = i10;
        this.pending = new ArrayList<>(i10 < 1 ? 1 : i10);
        this.channels = 1;
    }

    private final byte[] takeMerged(int i10) {
        int length = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            length += this.pending.get(i11).length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            byte[] bArrRemove = this.pending.remove(0);
            kotlin.jvm.internal.g.e(bArrRemove, "removeAt(...)");
            byte[] bArr2 = bArrRemove;
            b1.s(bArr2, bArr, length2, 0, 0, 12);
            length2 += bArr2.length;
        }
        return bArr;
    }

    public final List<PcmBatch> add(byte[] pcm, int i10, int i11) {
        kotlin.jvm.internal.g.f(pcm, "pcm");
        if (pcm.length == 0) {
            return EmptyList.f10001a;
        }
        if (this.sampleRate == 0) {
            this.sampleRate = i10;
        }
        if (i11 < 1) {
            i11 = 1;
        }
        this.channels = i11;
        this.pending.add(pcm);
        ArrayList arrayList = new ArrayList();
        int i12 = this.batchChunks;
        int i13 = i12 >= 1 ? i12 : 1;
        while (this.pending.size() >= i13) {
            arrayList.add(new PcmBatch(takeMerged(i13), this.sampleRate, this.channels));
        }
        return arrayList;
    }

    public final PcmBatch drain() {
        return flushPending();
    }

    public final PcmBatch flushPending() {
        if (this.pending.isEmpty()) {
            return null;
        }
        return new PcmBatch(takeMerged(this.pending.size()), this.sampleRate, this.channels);
    }

    public final boolean hasPending() {
        return !this.pending.isEmpty();
    }
}
