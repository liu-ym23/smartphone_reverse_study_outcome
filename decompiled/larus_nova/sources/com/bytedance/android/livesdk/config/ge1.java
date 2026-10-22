package com.bytedance.android.livesdk.config;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class ge1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f120275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f120276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f120277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f120278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f120279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f120280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f120281g;

    public static final class a {
    }

    static {
    }

    public ge1() {
        int r100 = 0;
        this(r100, r100, 127);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("PlayerTips(state=");
        int r101 = this.f120275a;
        String r102 = "unknown";
        if (r101 == 0) goto L9;
        if (r101 == 1) goto L8;
        if (r101 == 2) goto L7;
        String r103 = "unknown";
    L10:
        r100.append(r103);
        r100.append(", source=");
        int r104 = this.f120276b;
        if (r104 == 0) goto L17;
        if (r104 == 1) goto L16;
        if (r104 != 2) goto L18;
        r102 = "recommend";
    L18:
        r100.append(r102);
        r100.append(", content='");
        r100.append(this.f120277c);
        r100.append("', agreeText='");
        r100.append(this.f120278d);
        r100.append("', enableClose=");
        r100.append(this.f120279e);
        r100.append(')');
        return r100.toString();
    L16:
        r102 = "stall";
        goto L18
    L17:
        r102 = "none";
        goto L18
    L7:
        r103 = "hide";
        goto L10
    L8:
        r103 = "show";
        goto L10
    L9:
        r103 = "init";
        goto L10
    }

    public /* synthetic */ ge1(int r110, int r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r112 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r112 & 16) == 0) goto L21;
        boolean r104 = true;
    L22:
        this(r100, r101, r102, r103, r104, null, null);
        return;
    L21:
        r104 = false;
        goto L22
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public ge1(int r100, int r101, String r102, String r103, boolean r104, Function0<Unit> r105, Function0<Unit> r106) {
        Intrinsics.checkNotNullParameter(r102, "content");
        Intrinsics.checkNotNullParameter(r103, "agreeText");
        this.f120275a = r100;
        this.f120276b = r101;
        this.f120277c = r102;
        this.f120278d = r103;
        this.f120279e = r104;
        this.f120280f = r105;
        this.f120281g = r106;
    }
}
