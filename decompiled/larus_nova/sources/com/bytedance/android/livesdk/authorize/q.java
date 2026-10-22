package com.bytedance.android.livesdk.authorize;

import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f104221a;

    public q(r r100) {
        this.f104221a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        TextView r102 = this.f104221a.f104206b;
        if (r102 == null) goto L5;
        r102.setEnabled(r101.booleanValue());
    L5:
        TextView r103 = this.f104221a.f104207c;
        if (r103 == null) goto L8;
        r103.setEnabled(r101.booleanValue());
    L8:
        TextView r104 = this.f104221a.f104208d;
        int r105 = 8;
        if (r104 != null) goto L11;
    L15:
        TextView r106 = this.f104221a.f104209e;
        if (r106 != null) goto L18;
        return;
    L18:
        if (r101.booleanValue() == true) goto L21;
        r105 = 0;
    L21:
        r106.setVisibility(r105);
        return;
    L11:
        if (r101.booleanValue() == false) goto L13;
        int r107 = 0;
    L14:
        r104.setVisibility(r107);
        goto L15
    L13:
        r107 = 8;
        goto L14
    }
}
