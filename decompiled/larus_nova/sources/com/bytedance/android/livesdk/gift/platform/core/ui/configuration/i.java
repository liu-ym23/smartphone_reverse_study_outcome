package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.widget.Switch;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GiftEffectSwitchConfigType f131972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f131973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Switch, Unit> f131974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Switch, Unit> f131975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f131976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f131977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f131978g;

    public final GiftEffectSwitchConfigType getType() {
        return this.f131972a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(GiftEffectSwitchConfigType r100, String r101, Function1<? super Switch, Unit> r102, Function1<? super Switch, Unit> r103, boolean r104, Function0<Unit> r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "initialCheckStatus");
        Intrinsics.checkNotNullParameter(r103, "onCheckStateChanged");
        Intrinsics.checkNotNullParameter(r106, "hintAccessibilityTag");
        this.f131972a = r100;
        this.f131973b = r101;
        this.f131974c = r102;
        this.f131975d = r103;
        this.f131976e = r104;
        this.f131977f = r105;
        this.f131978g = r106;
    }
}
