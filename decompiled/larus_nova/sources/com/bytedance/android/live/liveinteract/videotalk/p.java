package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f79467a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f79468b = null;

    static {
        int[] r100 = new int[MediaOperation.Type.values().length];
        f79467a = r100;
        r100[MediaOperation.Type.CAMERA.ordinal()] = 1;
        r100[MediaOperation.Type.MIC.ordinal()] = 2;
        int[] r101 = new int[MediaOperation.Action.values().length];
        MediaOperation.Action r102 = MediaOperation.Action.OPEN;
        r101[r102.ordinal()] = 1;
        MediaOperation.Action r103 = MediaOperation.Action.CLOSE;
        r101[r103.ordinal()] = 2;
        int[] r104 = new int[MediaOperation.Action.values().length];
        r104[r102.ordinal()] = 1;
        r104[r103.ordinal()] = 2;
        int[] r105 = new int[VideoShowMode.values().length];
        f79468b = r105;
        r105[VideoShowMode.VIDEO.ordinal()] = 1;
        r105[VideoShowMode.AUDIO.ordinal()] = 2;
        r105[VideoShowMode.DIGIT_AVATAR.ordinal()] = 3;
    }
}
