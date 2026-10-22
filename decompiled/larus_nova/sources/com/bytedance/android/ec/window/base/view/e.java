package com.bytedance.android.ec.window.base.view;

import android.view.View;
import com.bytedance.android.ec.window.base.repository.vo.ClickAction;
import com.bytedance.android.ec.window.base.repository.vo.ECWindowTagListDTO;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClickAction f49881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECWindowTagListView f49882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f49883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ECWindowTagListDTO f49884d;

    public e(ClickAction r100, ECWindowTagListView r101, Function0 r102, ECWindowTagListDTO r103) {
        this.f49881a = r100;
        this.f49882b = r101;
        this.f49883c = r102;
        this.f49884d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ECWindowTagListView r101 = this.f49882b;
        ClickAction r102 = this.f49881a;
        Iterator<T> r103 = r101.f49834g.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((a) r103.next()).U(r102);
        goto L4
    L6:
        ECToast.showToast$default(ECToast.INSTANCE, this.f49882b.getContext(), this.f49881a.getToastText(), null, 4, null);
        ECWindowTagListView r104 = this.f49882b;
        ClickAction r105 = this.f49881a;
        Iterator<T> r106 = r104.f49834g.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        ((a) r106.next()).t(r105);
        goto L8
    L10:
        ECWindowTagListView.a(this.f49882b, this.f49884d);
    }
}
