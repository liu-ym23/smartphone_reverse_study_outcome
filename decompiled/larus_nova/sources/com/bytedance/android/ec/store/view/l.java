package com.bytedance.android.ec.store.view;

import android.view.View;
import com.bytedance.android.ec.store.repository.vo.ClickAction;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClickAction f48943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECTagListView f48944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f48945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ECTagListDTO f48946d;

    public l(ClickAction r100, ECTagListView r101, Function0 r102, ECTagListDTO r103) {
        this.f48943a = r100;
        this.f48944b = r101;
        this.f48945c = r102;
        this.f48946d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Iterator<T> r101 = this.f48944b.f48869b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) r101.next()).b();
        goto L4
    L6:
        ECToast.showToast$default(ECToast.INSTANCE, this.f48944b.getContext(), this.f48943a.getToastText(), null, 4, null);
        Iterator<T> r102 = this.f48944b.f48869b.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((a) r102.next()).a();
        goto L8
    L10:
        ECTagListView.a(this.f48944b, this.f48946d);
    }
}
