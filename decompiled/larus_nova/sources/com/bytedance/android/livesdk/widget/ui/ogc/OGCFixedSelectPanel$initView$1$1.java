package com.bytedance.android.livesdk.widget.ui.ogc;

import com.bytedance.android.livesdk.interactivity.api.expression.j;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/a;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class OGCFixedSelectPanel$initView$1$1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.interactivity.api.quickcomment.a, Unit> {
    public OGCFixedSelectPanel$initView$1$1(OGCFixedSelectPanel r100) {
        super(1, r100, OGCFixedSelectPanel.class, "onEmojiClick", "onEmojiClick(Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/EmojiDetail;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.livesdk.interactivity.api.quickcomment.a r100) {
        OGCFixedSelectPanel r101 = (OGCFixedSelectPanel) this.receiver;
        if (r100 == null) goto L8;
        j r102 = r101.f162183d;
        if (r102 == null) goto L11;
        r102.c(r100, "all");
        return;
    L11:
        return;
    L8:
        r101.getClass();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.livesdk.interactivity.api.quickcomment.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
