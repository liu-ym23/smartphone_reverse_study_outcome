package com.bytedance.android.ec.window.base.dynamicview.provider;

import android.content.Context;
import com.bytedance.android.ec.window.base.dynamicview.impl.widget.DynamicTextView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/bytedance/android/ec/window/base/dynamicview/impl/widget/DynamicTextView;", "p1", "Landroid/content/Context;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class CommonViewFactory$typedViewMakers$2 extends FunctionReferenceImpl implements Function1<Context, DynamicTextView> {
    public static final CommonViewFactory$typedViewMakers$2 INSTANCE = null;

    static {
        INSTANCE = new CommonViewFactory$typedViewMakers$2();
    }

    public CommonViewFactory$typedViewMakers$2() {
        super(1, DynamicTextView.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final DynamicTextView invoke2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return new DynamicTextView(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ DynamicTextView invoke(Context r100) {
        return invoke2(r100);
    }
}
