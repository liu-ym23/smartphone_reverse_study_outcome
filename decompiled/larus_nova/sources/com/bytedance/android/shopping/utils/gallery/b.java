package com.bytedance.android.shopping.utils.gallery;

import android.text.TextPaint;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f187111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f187112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f187113c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f187114a;

        public a(b r100) {
            this.f187114a = r100;
        }

        public final void a() {
            float r100 = (this.f187114a.f187112b.getWidth() - this.f187114a.f187112b.getPaddingLeft()) - this.f187114a.f187112b.getPaddingRight();
            StringBuilder r101 = new StringBuilder();
            int r110 = 0;
        L4:
            if (r110 >= this.f187114a.f187113c.length()) goto L9;
            TextPaint r102 = this.f187114a.f187111a.getPaint();
            String r103 = this.f187114a.f187113c;
            int r104 = RangesKt.coerceAtLeast(1, r102.breakText(r103, r110, r103.length(), true, r100, null)) + r110;
            r101.append(this.f187114a.f187113c.subSequence(r110, r104));
            if (r104 >= this.f187114a.f187113c.length()) goto L8;
            r101.append("\n");
        L8:
            r110 = r104;
            goto L4
        L9:
            this.f187114a.f187111a.setText(r101.toString());
            this.f187114a.f187111a.setVisibility(0);
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

    public b(TextView r100, ViewGroup r101, String r102) {
        this.f187111a = r100;
        this.f187112b = r101;
        this.f187113c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f187111a.post(new a(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
