package com.bytedance.android.annie.debug.ui;

import android.view.View;
import com.bytedance.common.utility.android.ClipboardCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UrlFormAdapter f39466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UrlFormViewHolder f39467b;

    public e(UrlFormAdapter r100, UrlFormViewHolder r101) {
        this.f39466a = r100;
        this.f39467b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = this.f39466a.f39446a.size();
        int r102 = this.f39467b.getAdapterPosition();
        if (r102 < 0) goto L6;
        if (r102 >= r101) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L10;
        g r104 = (g) ListProtector.get(this.f39466a.f39446a, this.f39467b.getAdapterPosition());
        String r105 = r104.f39472c + com.alipay.sdk.m.n.a.f25612h + r104.f39473d;
        UrlFormAdapter r106 = this.f39466a;
        ClipboardCompat.setText(r106.f39447b, "", r105);
        a8.d.a(r106.f39447b, "已经复制到剪切板");
        return;
    L10:
        return;
    L6:
        r103 = false;
        goto L7
    }
}
