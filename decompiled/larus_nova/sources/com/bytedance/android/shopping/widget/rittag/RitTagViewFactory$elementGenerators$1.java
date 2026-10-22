package com.bytedance.android.shopping.widget.rittag;

import android.content.Context;
import com.bytedance.android.shopping.widget.rittag.viewimpl.RitTagTextView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/bytedance/android/shopping/widget/rittag/viewimpl/RitTagTextView;", "p1", "Landroid/content/Context;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class RitTagViewFactory$elementGenerators$1 extends FunctionReferenceImpl implements Function1<Context, RitTagTextView> {
    public static final RitTagViewFactory$elementGenerators$1 INSTANCE = null;

    static {
        INSTANCE = new RitTagViewFactory$elementGenerators$1();
    }

    public RitTagViewFactory$elementGenerators$1() {
        super(1, RitTagTextView.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final RitTagTextView invoke2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return new RitTagTextView(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ RitTagTextView invoke(Context r100) {
        return invoke2(r100);
    }
}
