package com.bytedance.android.ec.window.base.view;

import android.view.View;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ec.window.base.repository.vo.ClickAction;
import com.bytedance.android.ec.window.base.repository.vo.ECWindowTagListDTO;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClickAction f49877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECWindowTagListView f49878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f49879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ECWindowTagListDTO f49880d;

    public d(ClickAction r100, ECWindowTagListView r101, Function0 r102, ECWindowTagListDTO r103) {
        this.f49877a = r100;
        this.f49878b = r101;
        this.f49879c = r102;
        this.f49880d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ECWindowTagListView r101 = this.f49878b;
        ClickAction r102 = this.f49877a;
        Iterator<T> r103 = r101.f49834g.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((a) r103.next()).U(r102);
        goto L4
    L6:
        ECWindowTagListView r104 = this.f49878b;
        ClickAction r105 = this.f49877a;
        Function0 r106 = this.f49879c;
        String r107 = null;
        if (r106 == null) goto L9;
        String r108 = (String) r106.invoke();
    L10:
        k r109 = r104.f49833f;
        if (r109 == null) goto L13;
        r107 = r109.a(r105.getJumpUrl());
    L13:
        if (r107 != null) goto L16;
        int r110 = com.bytedance.android.ec.window.base.utils.f.f49726a;
        r107 = com.bytedance.android.ec.window.base.utils.f.a(r105.getJumpUrl(), r108);
    L16:
        p.f48130a.openSchema(r100.getContext(), r107);
        ECWindowTagListView r111 = this.f49878b;
        ClickAction r112 = this.f49877a;
        Iterator<T> r113 = r111.f49834g.iterator();
    L18:
        if (r113.hasNext() == false) goto L20;
        ((a) r113.next()).t(r112);
        goto L18
    L20:
        ECWindowTagListView.a(this.f49878b, this.f49880d);
        return;
    L9:
        r108 = null;
        goto L10
    }
}
