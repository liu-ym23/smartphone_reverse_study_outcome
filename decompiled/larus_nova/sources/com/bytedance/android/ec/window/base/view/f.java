package com.bytedance.android.ec.window.base.view;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ec.window.base.repository.vo.ClickAction;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClickAction f49885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECWindowTagView f49886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f49887c;

    public f(ClickAction r100, ECWindowTagView r101, Function0 r102) {
        this.f49885a = r100;
        this.f49886b = r101;
        this.f49887c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0 r101 = this.f49887c;
        if (r101 == null) goto L5;
        String r102 = (String) r101.invoke();
    L6:
        p r103 = p.f48130a;
        Context r104 = r100.getContext();
        int r105 = com.bytedance.android.ec.window.base.utils.f.f49726a;
        r103.openSchema(r104, com.bytedance.android.ec.window.base.utils.f.a(this.f49885a.getJumpUrl(), r102));
        this.f49886b.b();
        return;
    L5:
        r102 = null;
        goto L6
    }
}
