package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.Typeface;
import com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class x2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopMarqueeTextView f184458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t2 f184459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f184460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f184461d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x2 f184462a;

        public a(x2 r100) {
            this.f184462a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f184462a.f184458a.E();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public x2(ECShopMarqueeTextView r100, t2 r101, String r102, String r103) {
        this.f184458a = r100;
        this.f184459b = r101;
        this.f184460c = r102;
        this.f184461d = r103;
    }

    public final void a() {
        this.f184458a.setVisibility(0);
        this.f184458a.setMaxWidth(this.f184459b.f184407u);
        ECShopMarqueeTextView r100 = this.f184458a;
        StringBuilder r101 = new StringBuilder();
        r101.append(this.f184460c);
        String r102 = this.f184461d;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.append(r102);
        r100.setText(r101.toString());
        this.f184458a.setTypeface(Typeface.DEFAULT_BOLD);
        this.f184458a.post(new a(this));
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
