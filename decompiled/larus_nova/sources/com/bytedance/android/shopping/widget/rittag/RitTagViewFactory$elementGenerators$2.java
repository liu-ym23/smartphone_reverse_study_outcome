package com.bytedance.android.shopping.widget.rittag;

import android.content.Context;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/Context;", "p1", "Lcom/bytedance/android/shopping/widget/rittag/viewimpl/a;", AbsMethodDelegate.TAG_INVOKE, "(Landroid/content/Context;)Lcom/bytedance/android/shopping/widget/rittag/viewimpl/a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class RitTagViewFactory$elementGenerators$2 extends FunctionReferenceImpl implements Function1<Context, com.bytedance.android.shopping.widget.rittag.viewimpl.a> {
    public static final RitTagViewFactory$elementGenerators$2 INSTANCE = null;

    static {
        INSTANCE = new RitTagViewFactory$elementGenerators$2();
    }

    public RitTagViewFactory$elementGenerators$2() {
        super(1, com.bytedance.android.shopping.widget.rittag.viewimpl.a.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.bytedance.android.shopping.widget.rittag.viewimpl.a invoke2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return new com.bytedance.android.shopping.widget.rittag.viewimpl.a(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.bytedance.android.shopping.widget.rittag.viewimpl.a invoke(Context r100) {
        return invoke2(r100);
    }
}
