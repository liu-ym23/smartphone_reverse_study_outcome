package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.utils.ActivityCountDownTimer;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes43.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f43201a = null;

    static {
        f43201a = new e();
    }

    public e() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101 == null) goto L8;
        r101.booleanValue();
        if (r101.booleanValue() == false) goto L9;
        Lazy r102 = ActivityCountDownTimer.f43347c;
        ActivityCountDownTimer.a.a().b();
        return;
    L9:
        return;
    }
}
