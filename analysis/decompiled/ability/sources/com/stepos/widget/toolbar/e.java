package com.stepos.widget.toolbar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.p;

/* loaded from: classes3.dex */
public final class e extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StepOSTitleBar f4192a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(StepOSTitleBar stepOSTitleBar, Context context) {
        super(context);
        this.f4192a = stepOSTitleBar;
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View child) {
        k.f(child, "child");
        super.onViewRemoved(child);
        StepOSTitleBar stepOSTitleBar = this.f4192a;
        p.a(stepOSTitleBar.g).remove(child);
        p.a(stepOSTitleBar.h).remove(child);
        if (child instanceof LinearLayout) {
            stepOSTitleBar.i.remove(child);
        }
    }
}
