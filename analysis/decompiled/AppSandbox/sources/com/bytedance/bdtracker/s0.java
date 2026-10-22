package com.bytedance.bdtracker;

import android.app.Activity;
import com.bytedance.applog.exposure.ViewExposureManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class s0 extends Lambda implements Function1<Activity, Unit> {
    public final /* synthetic */ ViewExposureManager a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(ViewExposureManager viewExposureManager) {
        super(1);
        this.a = viewExposureManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Activity activity) {
        Activity it = activity;
        Intrinsics.checkParameterIsNotNull(it, "it");
        ViewExposureManager.access$getTask$p(this.a).b.a();
        return Unit.INSTANCE;
    }
}
