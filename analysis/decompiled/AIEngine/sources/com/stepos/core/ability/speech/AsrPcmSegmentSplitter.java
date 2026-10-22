package com.stepos.core.ability.speech;

import androidx.datastore.preferences.protobuf.b1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrPcmSegmentSplitter {
    public static final AsrPcmSegmentSplitter INSTANCE = new AsrPcmSegmentSplitter();

    private AsrPcmSegmentSplitter() {
    }

    private final List<AsrPcmSegment> buildSegments(short[] sArr, int i10, List<Integer> list) {
        if (list.isEmpty()) {
            return b1.P(new AsrPcmSegment(sArr, 0L, true));
        }
        ArrayList arrayList = new ArrayList(list.size() + 1);
        Iterator<Integer> it = list.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (iIntValue > i11) {
                arrayList.add(new AsrPcmSegment(b1.w(sArr, i11, iIntValue), (i11 * 1000) / i10, false));
                i11 = iIntValue;
            }
        }
        if (i11 < sArr.length) {
            arrayList.add(new AsrPcmSegment(b1.w(sArr, i11, sArr.length), (i11 * 1000) / i10, true));
            return arrayList;
        }
        if (!arrayList.isEmpty()) {
            Object objRemove = arrayList.remove(mb.m.a0(arrayList));
            kotlin.jvm.internal.g.e(objRemove, "removeAt(...)");
            arrayList.add(AsrPcmSegment.copy$default((AsrPcmSegment) objRemove, null, 0L, true, 3, null));
        }
        return arrayList;
    }

    public final double rmsOfShorts$ability_release(short[] pcm, int i10, int i11) {
        kotlin.jvm.internal.g.f(pcm, "pcm");
        double d8 = 0.0d;
        if (i10 >= i11) {
            return 0.0d;
        }
        for (int i12 = i10; i12 < i11; i12++) {
            double d10 = pcm[i12];
            d8 += d10 * d10;
        }
        return Math.sqrt(d8 / (i11 - i10));
    }

    public final List<AsrPcmSegment> segments(short[] pcm, int i10, AsrPcmSegmentParams asrPcmSegmentParams) {
        kotlin.jvm.internal.g.f(pcm, "pcm");
        AsrPcmSegmentParams params = asrPcmSegmentParams;
        kotlin.jvm.internal.g.f(params, "params");
        if (pcm.length == 0 || i10 <= 0) {
            return EmptyList.f10001a;
        }
        long j10 = i10;
        if ((pcm.length * 1000) / j10 <= params.getMaxSegmentMs()) {
            return b1.P(new AsrPcmSegment(pcm, 0L, true));
        }
        int windowMs = (int) ((params.getWindowMs() * j10) / 1000);
        if (windowMs < 1) {
            windowMs = 1;
        }
        ArrayList arrayList = new ArrayList();
        long j11 = 0;
        long j12 = 0;
        int i11 = 0;
        boolean z = false;
        double d8 = 0.0d;
        while (i11 < pcm.length) {
            int iMin = Math.min(i11 + windowMs, pcm.length);
            long j13 = ((iMin - i11) * 1000) / j10;
            double dRmsOfShorts$ability_release = rmsOfShorts$ability_release(pcm, i11, iMin);
            if (dRmsOfShorts$ability_release > d8) {
                d8 = dRmsOfShorts$ability_release;
            }
            int i12 = windowMs;
            if (dRmsOfShorts$ability_release >= Math.max(params.getAbsSilenceRms(), params.getSilenceRmsRatio() * d8)) {
                j11 = 0;
                z = true;
            } else {
                j11 += j13;
            }
            j12 += j13;
            boolean z3 = z && j11 >= asrPcmSegmentParams.getEndpointSilenceMs() && j12 >= asrPcmSegmentParams.getMinSegmentMs();
            boolean z10 = j12 >= asrPcmSegmentParams.getMaxSegmentMs();
            if (z3 || z10) {
                arrayList.add(Integer.valueOf(iMin));
                z = false;
                d8 = 0.0d;
                j11 = 0;
                j12 = 0;
            }
            params = asrPcmSegmentParams;
            windowMs = i12;
            i11 = iMin;
        }
        return buildSegments(pcm, i10, arrayList);
    }
}
