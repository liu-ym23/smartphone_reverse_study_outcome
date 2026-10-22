package com.bytedance.android.ec.store.view;

import android.view.View;
import com.bytedance.android.ec.store.repository.vo.ClickAction;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClickAction f48939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECTagListView f48940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f48941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ECTagListDTO f48942d;

    public k(ClickAction r100, ECTagListView r101, Function0 r102, ECTagListDTO r103) {
        this.f48939a = r100;
        this.f48940b = r101;
        this.f48941c = r102;
        this.f48942d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Iterator<T> r101 = this.f48940b.f48869b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) r101.next()).b();
        goto L4
    L6:
        ECTagListView r102 = this.f48940b;
        ClickAction r103 = this.f48939a;
        Function0 r104 = this.f48941c;
        if (r104 == null) goto L9;
        String r105 = (String) r104.invoke();
    L10:
        r102.getClass();
        int r106 = com.bytedance.android.ec.store.utils.b.f48663a;
        String r107 = com.bytedance.android.ec.store.utils.b.a(r103.getJumpUrl(), r105);
        com.bytedance.android.ec.sdk.helper.p.f48130a.openSchema(r100.getContext(), r107);
        Iterator<T> r108 = this.f48940b.f48869b.iterator();
    L12:
        if (r108.hasNext() == false) goto L14;
        ((a) r108.next()).a();
        goto L12
    L14:
        ECTagListView.a(this.f48940b, this.f48942d);
        return;
    L9:
        r105 = null;
        goto L10
    }
}
