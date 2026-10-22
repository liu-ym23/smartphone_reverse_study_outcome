package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
public final class y0 implements Function0<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f164101a;

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return GsonProtectorUtils.toJson(TicketGuardApiKt.a(), new n(this.f164101a));
    }

    public y0(c0 r100) {
        this.f164101a = r100;
    }
}
