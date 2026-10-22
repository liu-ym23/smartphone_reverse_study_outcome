package com.bytedance.android.shopping.searchsimilar.view;

import android.graphics.Bitmap;
import android.text.SpannableString;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f182548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f182549b;

    public a(b r100, Bitmap r101) {
        this.f182548a = r100;
        this.f182549b = r101;
    }

    public final void a() {
        if (this.f182549b == null) goto L5;
        int r100 = (int) UIUtils.dip2Px(this.f182548a.f182550a.getContext(), 14.0f);
        Bitmap r101 = Bitmap.createScaledBitmap(this.f182549b, (int) (((r100 * 1.0f) / this.f182549b.getHeight()) * this.f182549b.getWidth()), r100, true);
        SpannableString r102 = new SpannableString(" ");
        com.bytedance.android.shopping.widget.b r103 = new com.bytedance.android.shopping.widget.b(this.f182548a.f182550a.getContext(), r101);
        r103.f187254a = com.bytedance.android.shopping.extensions.b.b(2);
        r102.setSpan(r103, 0, 1, 17);
        this.f182548a.f182551b.append(r102);
    L5:
        b r104 = this.f182548a;
        r104.f182551b.append(r104.f182552c);
        b r105 = this.f182548a;
        TextView r106 = r105.f182550a.f182521c;
        if (r106 == null) goto L9;
        r106.setText(r105.f182551b);
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
