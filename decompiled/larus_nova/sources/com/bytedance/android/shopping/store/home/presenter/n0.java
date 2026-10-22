package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.Typeface;
import android.view.View;
import com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class n0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopMarqueeTextView f184239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f184240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f184241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f184242d;

    public n0(ECShopMarqueeTextView r100, View r101, String r102, String r103) {
        this.f184239a = r100;
        this.f184240b = r101;
        this.f184241c = r102;
        this.f184242d = r103;
    }

    public final void a() {
        this.f184239a.setVisibility(0);
        View r100 = this.f184240b;
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.getMeasuredWidth());
    L6:
        int r102 = RangesKt.coerceAtLeast(r101.intValue(), com.bytedance.android.shopping.extensions.b.b(35));
        this.f184239a.setMaxWidth(r102 - com.bytedance.android.shopping.extensions.b.b(16));
        ECShopMarqueeTextView r103 = this.f184239a;
        StringBuilder r104 = new StringBuilder();
        r104.append(this.f184241c);
        String r105 = this.f184242d;
        if (r105 != null) goto L9;
        r105 = "";
    L9:
        r104.append(r105);
        r103.setText(r104.toString());
        this.f184239a.setTypeface(Typeface.DEFAULT_BOLD);
        this.f184239a.E();
        return;
    L5:
        r101 = null;
        goto L6
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
