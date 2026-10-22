package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager;

import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f141800a;

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f141800a, ((b) r100).f141800a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        o r100 = this.f141800a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "SimpleDanmakuSettingChangeEvent(setting=" + this.f141800a + ")";
    }

    public b(o r100) {
        this.f141800a = r100;
    }
}
