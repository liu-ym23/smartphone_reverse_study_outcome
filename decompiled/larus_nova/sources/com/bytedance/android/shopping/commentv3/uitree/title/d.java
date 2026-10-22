package com.bytedance.android.shopping.commentv3.uitree.title;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements CapsuleComponent.OnClickMenuListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentTitleUI f172910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f172911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IECAIHostService f172912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f172913d;

    @Override // com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent.OnClickMenuListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        CommentTitleUI r101 = this.f172910a;
        View r102 = this.f172911b;
        int r103 = CommentTitleUI.f172883v;
        r101.getClass();
        if (r102 == null) goto L7;
        boolean r104 = r102.performClick();
        boolean r105 = true;
        if (r104 != true) goto L7;
    L8:
        if (r105 == false) goto L10;
        return;
    L10:
        this.f172912c.showAppletPanel(this.f172913d, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_MODULE, CollectionsKt.emptyList(), null);
        return;
    L7:
        r105 = false;
        goto L8
    }

    public d(CommentTitleUI r100, View r101, IECAIHostService r102, Context r103) {
        this.f172910a = r100;
        this.f172911b = r101;
        this.f172912c = r102;
        this.f172913d = r103;
    }
}
