package com.bytedance.android.ec.window.base.dynamicview.renderer;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lto/a;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;)Lto/a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class RenderManager$transformers$2$1$1 extends FunctionReferenceImpl implements Function1<String, to.a> {
    public RenderManager$transformers$2$1$1(a r100) {
        super(1, r100, a.class, "transformRawData", "transformRawData(Ljava/lang/String;)Lcom/bytedance/android/ec/window/base/dynamicview/renderer/vo/BasicRenderCtrlData;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final to.a invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return ((a) this.receiver).d(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ to.a invoke(String r100) {
        return invoke2(r100);
    }
}
