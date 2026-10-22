package com.chad.library.adapter.base;

import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.u;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class BaseQuickAdapter$footerLayout$1 extends MutablePropertyReference0 {
    public BaseQuickAdapter$footerLayout$1(BaseQuickAdapter r10) {
        super(r10);
    }

    @Override // kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        return BaseQuickAdapter.access$getMFooterLayout$p((BaseQuickAdapter) this.receiver);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "mFooterLayout";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return u.b(BaseQuickAdapter.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getMFooterLayout()Landroid/widget/LinearLayout;";
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(@Nullable Object r10) {
        BaseQuickAdapter.access$setMFooterLayout$p((BaseQuickAdapter) this.receiver, (LinearLayout) r10);
    }
}
