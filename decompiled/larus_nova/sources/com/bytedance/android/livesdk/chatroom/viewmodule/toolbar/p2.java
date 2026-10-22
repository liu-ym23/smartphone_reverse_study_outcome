package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class p2 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f116651q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f116652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f116653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f116654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f116655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f116656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f116657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f116658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f116659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f116660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f116661j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f116662k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f116663l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f116664m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f116665n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f116666o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ToolbarBroadcastFunction f116667p;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        LocalTestManager.a(new Class[]{wy.a.class});
        return "hasCommercePermission=" + this.f116653b + ", hasCommerce=" + this.f116662k + ", hasTransformWidgetPermission=" + this.f116656e + ", hasAddTransformWidget=" + this.f116665n + ", hasMiniAppPermission=" + this.f116652a + ", hasMinApp=" + this.f116658g + ", hasMixMiniApp=" + this.f116661j + " hasWelfarePermission=" + this.f116655d + ", hasWelfare=" + this.f116664m + ", hasGamePromotePermission=" + this.f116654c + ", hasGamePromote=" + this.f116663l + ",  hasGroupPurchasePermission=" + this.f116657f + ",  lastTriggered=" + this.f116667p;
    }

    public final boolean a() {
        if (this.f116665n == false) goto L5;
    L21:
        return false;
    L5:
        if (this.f116658g == true) goto L21;
        if (this.f116662k == true) goto L21;
        if (this.f116664m == true) goto L21;
        if (this.f116663l == true) goto L21;
        if (this.f116661j == true) goto L21;
        if (this.f116660i == true) goto L21;
        if (this.f116666o == true) goto L21;
        if (this.f116659h == true) goto L21;
        return true;
    }

    public final int c() {
        if (tb1.c.f545235g == true) goto L5;
        return 0;
    L5:
        if (a() == false) goto L10;
        if (this.f116667p != ToolbarBroadcastFunction.GAME_PROMOTE) goto L28;
    L8:
        return 1;
    L28:
        return 0;
    L10:
        if (this.f116662k == false) goto L12;
        return 0;
    L12:
        if (this.f116665n == false) goto L14;
        return 0;
    L14:
        if (this.f116658g == false) goto L16;
        return 0;
    L16:
        if (this.f116660i == false) goto L18;
        return 0;
    L18:
        if (this.f116664m == false) goto L20;
        return 0;
    L20:
        if (this.f116654c == true) goto L22;
        return 0;
    L22:
        if (this.f116661j == false) goto L24;
        return 0;
    L24:
        if (this.f116666o == false) goto L26;
        return 0;
    L26:
        if (this.f116659h == false) goto L8;
        return 0;
    }

    public final int d() {
        if (tb1.c.f545235g == true) goto L5;
        return 0;
    L5:
        if (a() == false) goto L10;
        if (this.f116667p != ToolbarBroadcastFunction.GROUP_PURCHASE) goto L14;
    L8:
        return 1;
    L14:
        return 0;
    L10:
        if (this.f116665n == false) goto L12;
        return 0;
    L12:
        if (this.f116666o == true) goto L8;
        return 0;
    }

    public final int e() {
        if (tb1.c.f545229a == true) goto L5;
        return 0;
    L5:
        if (this.f116661j == false) goto L9;
        return 1;
    L9:
        return 0;
    }

    public final int f() {
        if (tb1.c.f545229a == true) goto L5;
        return 0;
    L5:
        if (a() == false) goto L12;
        if (this.f116667p == ToolbarBroadcastFunction.MINI_APP) goto L9;
        return 0;
    L9:
        if (this.f116652a == false) goto L33;
    L10:
        return 1;
    L33:
        return 0;
    L12:
        if (b() == 0) goto L14;
        return 0;
    L14:
        if (this.f116659h == false) goto L16;
        return 0;
    L16:
        if (this.f116652a == true) goto L18;
        return 0;
    L18:
        if (this.f116665n == false) goto L20;
        return 0;
    L20:
        if (this.f116664m == false) goto L22;
        return 0;
    L22:
        if (this.f116663l == false) goto L26;
        if (this.f116658g == true) goto L26;
        return 0;
    L26:
        if (this.f116660i == false) goto L28;
        return 0;
    L28:
        if (this.f116661j == false) goto L30;
        return 0;
    L30:
        if (this.f116666o == false) goto L10;
        return 0;
    }

    public final int g() {
        if (tb1.c.f545229a == true) goto L5;
        return 0;
    L5:
        if (this.f116660i == false) goto L9;
        return 1;
    L9:
        return 0;
    }

    public final int h() {
        if (tb1.c.f545229a == true) goto L5;
        return 0;
    L5:
        if (a() == false) goto L10;
        if (this.f116667p != ToolbarBroadcastFunction.TRANSFORM_WIDGET) goto L12;
        return 1;
    L12:
        return 0;
    L10:
        return this.f116665n ? 1 : 0;
    }

    public p2() {
        this.f116667p = ToolbarBroadcastFunction.COMMERCE;
    }

    public final int b() {
        if (a() == false) goto L8;
        if (this.f116667p == ToolbarBroadcastFunction.COMMERCE) goto L30;
    L27:
        return 0;
    L30:
        return 1;
    L8:
        if (this.f116659h == true) goto L27;
        if (this.f116665n == true) goto L27;
        if (this.f116658g == true) goto L27;
        if (this.f116664m == true) goto L27;
        if (this.f116660i == true) goto L27;
        if (this.f116663l == false) goto L22;
        if (this.f116662k == false) goto L27;
    L22:
        if (this.f116653b == false) goto L27;
        if (this.f116661j == true) goto L27;
        if (this.f116666o == true) goto L27;
        return 1;
    }

    public final int i() {
        if (yt2.b.a().booleanValue() == true) goto L5;
        return 0;
    L5:
        if (this.f116655d == true) goto L7;
        return 0;
    L7:
        if (j() != 0) goto L13;
        return 1;
    L13:
        return 0;
    }

    public final int j() {
        if (yt2.b.a().booleanValue() == true) goto L5;
        return 0;
    L5:
        if (a() == false) goto L12;
        if (this.f116667p == ToolbarBroadcastFunction.WELFARE) goto L9;
        return 0;
    L9:
        if (this.f116655d == false) goto L33;
    L10:
        return 1;
    L33:
        return 0;
    L12:
        if (this.f116665n == false) goto L14;
        return 0;
    L14:
        if (this.f116658g == false) goto L16;
        return 0;
    L16:
        if (this.f116660i == false) goto L18;
        return 0;
    L18:
        if (this.f116662k == false) goto L20;
        return 0;
    L20:
        if (this.f116663l == false) goto L24;
        if (this.f116664m == true) goto L24;
        return 0;
    L24:
        if (this.f116655d == true) goto L26;
        return 0;
    L26:
        if (this.f116661j == false) goto L28;
        return 0;
    L28:
        if (this.f116666o == false) goto L30;
        return 0;
    L30:
        if (this.f116659h == false) goto L10;
        return 0;
    }

    public final void k(ToolbarBroadcastFunction r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f116667p = r100;
    }
}
