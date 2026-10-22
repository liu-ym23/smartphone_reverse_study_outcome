package com.bytedance.android.live.recharge.trace.session;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f90402a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f90403b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f90404c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f90405d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f90406e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f90407f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f90408g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f90409h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f90410i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f90411j = null;

    static {
        Intrinsics.checkNotNullParameter("panelLaunch", "groupName");
        f90402a = new c("panelLaunch", "rechargePanelCreate");
        f90403b = new c("panelLaunch", "rechargePanelShow");
        f90404c = new c("panelLaunch", "rechargePanelContentLoad");
        Intrinsics.checkNotNullParameter("order", "groupName");
        f90405d = new c("order", "rechargeOrderCreate");
        f90406e = new c("order", "rechargeOrderSucceed");
        f90407f = new c("order", "rechargeOrderFail");
        f90408g = new c("order", "rechargeOrderCancel");
        Intrinsics.checkNotNullParameter("userInteraction", "groupName");
        f90409h = new c("userInteraction", "clickRechargeButton");
        f90410i = new c("userInteraction", "clickCustomRecharge");
        Intrinsics.checkNotNullParameter("cashier", "groupName");
        f90411j = new c("cashier", "cashierShow");
    }
}
