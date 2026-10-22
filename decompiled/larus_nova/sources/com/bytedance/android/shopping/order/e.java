package com.bytedance.android.shopping.order;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.shopping.extensions.k;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes13.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PreviewPanelFragment f179675a;

    public e(PreviewPanelFragment r100) {
        this.f179675a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        cg3.e r101 = (cg3.e) r100;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.c();
    L6:
        boolean r104 = false;
        if (k.c(r103) == false) goto L17;
        View r105 = this.f179675a.f179639t;
        if (r105 == null) goto L11;
        r105.setVisibility(0);
    L11:
        TextView r106 = this.f179675a.f179633n;
        if (r106 == null) goto L17;
        if (r101 == null) goto L15;
        String r107 = r101.c();
    L16:
        r106.setText(r107);
        goto L17
    L15:
        r107 = null;
    L17:
        if (r101 == null) goto L19;
        String r108 = r101.b();
    L20:
        if (r108 != null) goto L22;
    L23:
        r104 = true;
    L24:
        if (r104 == false) goto L28;
        TextView r109 = this.f179675a.f179634o;
        if (r109 == null) goto L34;
        r109.setVisibility(8);
        return;
    L34:
        return;
    L28:
        TextView r110 = this.f179675a.f179634o;
        if (r110 == null) goto L36;
        if (r101 == null) goto L32;
        r102 = r101.b();
    L32:
        r110.setText(r102);
        return;
    L36:
        return;
    L22:
        if (r108.length() != 0) goto L24;
    L19:
        r108 = null;
        goto L20
    L5:
        r103 = null;
        goto L6
    }
}
