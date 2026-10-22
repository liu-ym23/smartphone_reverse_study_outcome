package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.core.setting.x;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f80544a = 0;

    public static boolean a() {
        Integer r100 = je0.d.h();
        if (r100 != null) goto L6;
    L7:
        if (r100 != null) goto L10;
    L12:
        return false;
    L10:
        if (r100.intValue() != 25) goto L12;
    L13:
        return true;
    L6:
        if (r100.intValue() == 29) goto L13;
        goto L7
    }

    static {
    }

    public static boolean b(Integer r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 != null) goto L9;
    L11:
        return false;
    L9:
        if (r100.intValue() != 25) goto L11;
    L12:
        return true;
    L5:
        if (r100.intValue() == 29) goto L12;
        goto L6
    }

    public static boolean c(boolean r100) {
        if (r100 == false) goto L7;
        if (x.f65450a.getValue().getRadioAnchorEnable() == false) goto L8;
    L9:
        return false;
    L8:
        return true;
    L7:
        if (x.f65450a.getValue().getRadioEnable() == true) goto L9;
        goto L8
    }

    public static boolean d(boolean r100) {
        if (r100 == false) goto L8;
        if (x.f65450a.getValue().getRadioAnchorEnable() == true) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (x.f65450a.getValue().getRadioEnable() != true) goto L10;
        return true;
    }
}
