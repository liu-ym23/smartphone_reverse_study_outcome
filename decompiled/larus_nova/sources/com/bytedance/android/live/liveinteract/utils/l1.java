package com.bytedance.android.live.liveinteract.utils;

import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f78792a = 0;

    static {
    }

    public static RtcAudioScene a(int r100, int r101, List r102) {
        Intrinsics.checkNotNullParameter(r102, "playModes");
        boolean r103 = r102.contains(21);
        if (r101 == 62) goto L25;
        if (r101 == 63) goto L25;
        if (r100 == 9) goto L10;
        if (r103 == false) goto L19;
        return RtcAudioScene.KTV;
    L19:
        if (ArraysKt.contains(k1.f78790a, Integer.valueOf(r100)) == false) goto L23;
        return RtcAudioScene.CHAT_ROOM;
    L23:
        return RtcAudioScene.NORMAL;
    L10:
        if (r101 != 61) goto L14;
        return RtcAudioScene.REAL_TIME_CHORUS;
    L14:
        return RtcAudioScene.KTV;
    L25:
        return RtcAudioScene.REAL_TIME_CHORUS;
    }
}
