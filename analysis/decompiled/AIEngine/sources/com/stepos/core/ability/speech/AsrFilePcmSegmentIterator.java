package com.stepos.core.ability.speech;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrFilePcmSegmentIterator {
    public static final AsrFilePcmSegmentIterator INSTANCE = new AsrFilePcmSegmentIterator();

    private AsrFilePcmSegmentIterator() {
    }

    public final List<AsrFileSegment> segments(short[] pcm, int i10) {
        kotlin.jvm.internal.g.f(pcm, "pcm");
        List<AsrPcmSegment> listSegments = AsrPcmSegmentSplitter.INSTANCE.segments(pcm, i10, AsrFilePcmSegmentPolicy.INSTANCE.getParams());
        ArrayList arrayList = new ArrayList(mb.m.Z(listSegments, 10));
        for (AsrPcmSegment asrPcmSegment : listSegments) {
            arrayList.add(new AsrFileSegment(asrPcmSegment.getPcm(), asrPcmSegment.getOffsetMs(), asrPcmSegment.isLast()));
        }
        return arrayList;
    }
}
