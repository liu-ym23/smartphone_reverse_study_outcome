package com.bytedance.android.livesdk.vscore_api.paidlive.ability;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class TempWatchPlayerTipUiInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f159404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f159405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f159406c;

    public static final class a {
    }

    static {
    }

    public TempWatchPlayerTipUiInfo() {
        this.f159404a = "试看中%time%";
        this.f159405b = "购买";
        this.f159406c = TempWatchPlayerTipUiInfo$btnClickAction$1.INSTANCE;
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f159404a = r100;
    }
}
