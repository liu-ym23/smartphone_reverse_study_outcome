package com.bytedance.android.ec.window.base.shop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.bytedance.android.ec.core.utils.k1;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CardView f49641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f49642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ECWindowBubblePrompt f49643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f49644d;

    public f(CardView r100, View r101, ECWindowBubblePrompt r102, Context r103) {
        this.f49641a = r100;
        this.f49642b = r101;
        this.f49643c = r102;
        this.f49644d = r103;
    }

    public final void a() {
        View r100 = this.f49643c.f49577f;
        if (r100 == null) goto L13;
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        int r102 = (r100.getWidth() - com.bytedance.android.shopping.extensions.b.a(20)) / 2;
        int r103 = ((k1.m(this.f49644d) - r101[0]) - r100.getWidth()) + r102;
        CardView r104 = this.f49641a;
        if (r104 == null) goto L14;
        int r105 = com.bytedance.android.ec.window.base.utils.c.f49722a;
        Intrinsics.checkNotNullParameter(r104, "$this$setMarginEndCompat");
        ViewGroup.LayoutParams r106 = r104.getLayoutParams();
        if ((r106 instanceof FrameLayout.LayoutParams) == true) goto L9;
        r106 = null;
    L9:
        FrameLayout.LayoutParams r107 = (FrameLayout.LayoutParams) r106;
        if (r107 == null) goto L15;
        r107.setMarginEnd(r103);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
