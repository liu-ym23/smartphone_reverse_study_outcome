package com.bytedance.android.shopping.deepfeed.weights.common;

import android.text.TextPaint;
import android.widget.Scroller;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedMarqueeTextView f174222a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f174223a;

        public a(b r100) {
            this.f174223a = r100;
        }

        public final void a() {
            DeepFeedMarqueeTextView r100 = this.f174223a.f174222a;
            int r101 = DeepFeedMarqueeTextView.f174174t;
            if (r100.getMeasuredWidth() > 0) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L13;
            this.f174223a.f174222a.setCanScrollable(true);
            DeepFeedMarqueeTextView r103 = this.f174223a.f174222a;
            r103.f174184j = true;
            Scroller r104 = r103.f174176b;
            if (r104 == null) goto L12;
            r104.startScroll(0, 0, 0, 0, 0);
        L12:
            r103.y();
            return;
        L13:
            DeepFeedMarqueeTextView r105 = this.f174223a.f174222a;
            r105.f174189o = true;
            Function0<Unit> r106 = r105.f174190p;
            if (r106 == null) goto L18;
            Unit r107 = r106.invoke();
            return;
        L18:
            return;
        L5:
            if (r100.getMeasuredWidth() >= r100.x()) goto L7;
            r102 = true;
            goto L8
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

    public b(ProductMarqueeTextView r100) {
        this.f174222a = r100;
    }

    public final void a() {
        DeepFeedMarqueeTextView r100 = this.f174222a;
        if (r100.f174188n == false) goto L6;
    L33:
        this.f174222a.post(new a(this));
        return;
    L6:
        if (r100.f174183i == false) goto L22;
        CharSequence r101 = r100.getText();
        if (r101 != null) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == true) goto L22;
        if (r100.getVisibility() == 8) goto L22;
        if (r100.getMeasuredWidth() <= 0) goto L22;
        boolean r103 = false;
    L24:
        if (r103 == true) goto L33;
        TextPaint r104 = r100.getPaint();
        String r105 = r100.getText().toString();
        int r106 = r105.length();
    L27:
        if (r106 < 0) goto L32;
        float r107 = r104.measureText(r105, 0, r106);
        if (r107 <= r100.getMeasuredWidth()) goto L30;
        r106 = r106 - 1;
        goto L27
    L30:
        r100.setMaxWidth((int) r107);
        r100.f174188n = true;
        r100.requestLayout();
    L32:
        r100.f174188n = false;
        goto L33
    L11:
        if (StringsKt.isBlank(r101) == true) goto L14;
        r102 = false;
    L22:
        r103 = true;
        goto L24
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
