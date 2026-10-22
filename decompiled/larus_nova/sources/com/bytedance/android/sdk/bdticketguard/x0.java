package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
public final class x0 implements Function0<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f164097a;

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return GsonProtectorUtils.toJson(TicketGuardApiKt.a(), new m1(this.f164097a));
    }

    public x0(k r100) {
        this.f164097a = r100;
    }
}
