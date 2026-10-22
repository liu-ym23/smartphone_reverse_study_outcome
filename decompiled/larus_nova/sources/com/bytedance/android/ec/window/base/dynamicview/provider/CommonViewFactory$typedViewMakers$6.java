package com.bytedance.android.ec.window.base.dynamicview.provider;

import android.content.Context;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ro.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/Context;", "p1", "Lro/a;", AbsMethodDelegate.TAG_INVOKE, "(Landroid/content/Context;)Lro/a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class CommonViewFactory$typedViewMakers$6 extends FunctionReferenceImpl implements Function1<Context, a> {
    public static final CommonViewFactory$typedViewMakers$6 INSTANCE = null;

    static {
        INSTANCE = new CommonViewFactory$typedViewMakers$6();
    }

    public CommonViewFactory$typedViewMakers$6() {
        super(1, a.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final a invoke2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return new a(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ a invoke(Context r100) {
        return invoke2(r100);
    }
}
