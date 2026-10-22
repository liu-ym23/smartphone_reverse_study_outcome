package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.JvmStatic;
import r52.j4;

/* JADX INFO: loaded from: classes9.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f133765a = 0;

    @JvmStatic
    public static final boolean b() {
        Integer r100 = j4.f536204a.getValue();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 2) goto L8;
        return true;
    }

    static {
    }

    @JvmStatic
    public static final boolean a(boolean r100, IRoom r101) {
        if (r100 == true) goto L5;
        return false;
    L5:
        if (r101 != null) goto L7;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == true) goto L24;
        Integer r103 = j4.f536204a.getValue();
        if (r103 != null) goto L17;
    L19:
        boolean r104 = false;
    L20:
        if (r104 == false) goto L25;
        return true;
    L25:
        return false;
    L17:
        if (r103.intValue() != 1) goto L19;
        r104 = true;
        goto L20
    L24:
        return false;
    L7:
        if (r101.isMediaRoom() == false) goto L9;
    L10:
        r102 = true;
        goto L12
    L9:
        if (r101.isMergeVSRoom() == false) goto L11;
        goto L10
    }

    @JvmStatic
    public static final boolean c(boolean r100, IRoom r101) {
        if (r100 == true) goto L5;
        return false;
    L5:
        if (r101 != null) goto L7;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L14;
        return false;
    L14:
        if (b() == false) goto L19;
        return true;
    L19:
        return false;
    L7:
        if (r101.isMediaRoom() == false) goto L9;
    L10:
        r102 = true;
        goto L12
    L9:
        if (r101.isMergeVSRoom() == false) goto L11;
        goto L10
    }
}
