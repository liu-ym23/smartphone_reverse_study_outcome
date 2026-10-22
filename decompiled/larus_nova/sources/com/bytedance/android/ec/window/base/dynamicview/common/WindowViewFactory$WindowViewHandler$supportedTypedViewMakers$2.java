package com.bytedance.android.ec.window.base.dynamicview.common;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/widget/FrameLayout;", "p1", "Landroid/content/Context;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowViewFactory$WindowViewHandler$supportedTypedViewMakers$2 extends FunctionReferenceImpl implements Function1<Context, FrameLayout> {
    public static final WindowViewFactory$WindowViewHandler$supportedTypedViewMakers$2 INSTANCE = null;

    static {
        INSTANCE = new WindowViewFactory$WindowViewHandler$supportedTypedViewMakers$2();
    }

    public WindowViewFactory$WindowViewHandler$supportedTypedViewMakers$2() {
        super(1, FrameLayout.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final FrameLayout invoke2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return new FrameLayout(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ FrameLayout invoke(Context r100) {
        return invoke2(r100);
    }
}
