package com.bytedance.applet.impl;

import com.bytedance.ai.api.AppletBottomSheetButtonRole;
import com.bytedance.ai.api.AppletBottomSheetCancelSource;
import com.bytedance.ai.bridge.method.bottomsheet.DoubaoBottomSheetAction;
import com.bytedance.ai.bridge.method.bottomsheet.DoubaoBottomSheetButtonRole;
import com.bytedance.ai.bridge.method.bottomsheet.DoubaoBottomSheetCancelSource;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class p1 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f191994a;

    public /* synthetic */ p1(m3.e r100) {
        this.f191994a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r110) {
        Function1 r100 = this.f191994a;
        com.bytedance.ai.api.f r111 = (com.bytedance.ai.api.f) r110;
        Intrinsics.checkNotNullParameter(r111, "result");
        Intrinsics.checkNotNullParameter(r111, "<this>");
        int r101 = z1.a.f192032c[r111.f34013a.ordinal()];
        if (r101 == 1) goto L23;
        if (r101 != 2) goto L22;
        DoubaoBottomSheetAction r102 = DoubaoBottomSheetAction.CANCEL;
        AppletBottomSheetCancelSource r112 = r111.f34015c;
        if (r112 == null) goto L19;
        Intrinsics.checkNotNullParameter(r112, "<this>");
        int r113 = z1.a.f192034e[r112.ordinal()];
        if (r113 == 1) goto L17;
        if (r113 == 2) goto L16;
        if (r113 == 3) goto L15;
        if (r113 != 4) goto L14;
        DoubaoBottomSheetCancelSource r114 = DoubaoBottomSheetCancelSource.UNKNOWN;
    L18:
        if (r114 == null) goto L19;
    L20:
        com.bytedance.ai.bridge.method.bottomsheet.a r103 = new com.bytedance.ai.bridge.method.bottomsheet.a(r102, null, r114, 2);
    L36:
        r100.invoke(r103);
        return Unit.INSTANCE;
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        r114 = DoubaoBottomSheetCancelSource.HOST_UNAVAILABLE;
        goto L18
    L16:
        r114 = DoubaoBottomSheetCancelSource.GESTURE;
        goto L18
    L17:
        r114 = DoubaoBottomSheetCancelSource.MASK;
    L19:
        r114 = DoubaoBottomSheetCancelSource.UNKNOWN;
        goto L20
    L22:
        throw new NoWhenBranchMatchedException();
    L23:
        DoubaoBottomSheetAction r104 = DoubaoBottomSheetAction.BUTTON_CLICK;
        AppletBottomSheetButtonRole r115 = r111.f34014b;
        if (r115 == null) goto L34;
        Intrinsics.checkNotNullParameter(r115, "<this>");
        int r116 = z1.a.f192033d[r115.ordinal()];
        if (r116 == 1) goto L33;
        if (r116 == 2) goto L32;
        if (r116 != 3) goto L31;
        DoubaoBottomSheetButtonRole r117 = DoubaoBottomSheetButtonRole.REJECT;
    L35:
        r103 = new com.bytedance.ai.bridge.method.bottomsheet.a(r104, r117, null, 4);
        goto L36
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        r117 = DoubaoBottomSheetButtonRole.AGREE_SUB;
        goto L35
    L33:
        r117 = DoubaoBottomSheetButtonRole.AGREE_MAIN;
        goto L35
    L34:
        r117 = null;
        goto L35
    }
}
