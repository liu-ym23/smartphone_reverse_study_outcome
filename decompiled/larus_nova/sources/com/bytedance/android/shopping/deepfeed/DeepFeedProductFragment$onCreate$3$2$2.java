package com.bytedance.android.shopping.deepfeed;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0015\u0010\t\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0015\u0010\u000b\u001a\u00110\f¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r¢\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "cardPosition", "p2", "selectedIndex", "p3", "previousIndex", "p4", "", "byUser", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class DeepFeedProductFragment$onCreate$3$2$2 extends FunctionReferenceImpl implements Function4<Integer, Integer, Integer, Boolean, Unit> {
    public DeepFeedProductFragment$onCreate$3$2$2(com.bytedance.android.shopping.deepfeed.event.a r100) {
        super(4, r100, com.bytedance.android.shopping.deepfeed.event.a.class, "onImageSelected", "onImageSelected(IIIZ)V", 0);
    }

    public final void invoke(int r100, int r101, int r102, boolean r103) {
        com.bytedance.android.shopping.deepfeed.event.a r104 = (com.bytedance.android.shopping.deepfeed.event.a) this.receiver;
        if (r104.f173310o == false) goto L23;
        if (r103 == false) goto L21;
        if (r101 == r102) goto L24;
        com.bytedance.android.shopping.deepfeed.event.a.d r105 = r104.f173298c;
        if (r105 != null) goto L12;
        return;
    L12:
        if (r105.f173325c == r100) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(r105.f173336n, "enter_detail") == true) goto L27;
        r105.f173336n = "switch_image";
        if (r105.f173335m == false) goto L22;
        r104.b();
        com.bytedance.android.shopping.deepfeed.event.b r106 = new com.bytedance.android.shopping.deepfeed.event.b(r104, r105.f173323a);
        r104.f173303h.postDelayed(r106, 500);
        Unit r107 = Unit.INSTANCE;
        r104.f173306k = r106;
        return;
    L22:
        return;
    L27:
        return;
    L24:
        return;
    L21:
        return;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, Integer r101, Integer r102, Boolean r103) {
        invoke(r100.intValue(), r101.intValue(), r102.intValue(), r103.booleanValue());
        return Unit.INSTANCE;
    }
}
