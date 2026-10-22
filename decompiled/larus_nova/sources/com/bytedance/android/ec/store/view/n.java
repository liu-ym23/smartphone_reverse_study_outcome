package com.bytedance.android.ec.store.view;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.store.repository.vo.ClickAction;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClickAction f48947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECTagView f48948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f48949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0 f48950d;

    public n(ClickAction r100, ECTagView r101, View r102, Function0 r103) {
        this.f48947a = r100;
        this.f48948b = r101;
        this.f48949c = r102;
        this.f48950d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0 r101 = this.f48950d;
        if (r101 == null) goto L5;
        String r102 = (String) r101.invoke();
    L6:
        com.bytedance.android.ec.sdk.helper.p r103 = com.bytedance.android.ec.sdk.helper.p.f48130a;
        Context r104 = r100.getContext();
        int r105 = com.bytedance.android.ec.store.utils.b.f48663a;
        Lazy r106 = ECStoreFoldPhoneHelper.f183487a;
        String r107 = this.f48947a.getJumpUrl();
        ECStoreFoldPhoneHelper.b(r107);
        r103.openSchema(r104, com.bytedance.android.ec.store.utils.b.a(r107, r102));
        this.f48948b.e();
        return;
    L5:
        r102 = null;
        goto L6
    }
}
