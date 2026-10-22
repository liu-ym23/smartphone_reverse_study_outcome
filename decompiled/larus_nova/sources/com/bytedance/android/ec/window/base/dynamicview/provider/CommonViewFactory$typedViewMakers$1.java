package com.bytedance.android.ec.window.base.dynamicview.provider;

import android.content.Context;
import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroid/view/View;", "p1", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class CommonViewFactory$typedViewMakers$1 extends FunctionReferenceImpl implements Function1<Context, View> {
    public static final CommonViewFactory$typedViewMakers$1 INSTANCE = null;

    static {
        INSTANCE = new CommonViewFactory$typedViewMakers$1();
    }

    public CommonViewFactory$typedViewMakers$1() {
        super(1, View.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ View invoke(Context r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final View invoke2(Context r100) {
        return new View(r100);
    }
}
