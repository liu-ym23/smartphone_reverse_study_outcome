package com.bytedance.android.livesdk.interactivity.api.expression;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f133211a;

    public f(Function0 r100) {
        this.f133211a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0 r101 = this.f133211a;
        if (r101 == null) goto L6;
        Unit r102 = (Unit) r101.invoke();
        return;
    }
}
