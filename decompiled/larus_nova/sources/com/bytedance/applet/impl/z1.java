package com.bytedance.applet.impl;

import com.bytedance.ai.api.AppletBottomSheetAction;
import com.bytedance.ai.api.AppletBottomSheetButtonRole;
import com.bytedance.ai.api.AppletBottomSheetCancelSource;
import com.bytedance.ai.api.OperateResult;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.bridge.method.bottomsheet.DoubaoBottomSheetButtonRole;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class z1 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192030a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f192031b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f192032c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f192033d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f192034e = null;

        static {
            int[] r100 = new int[OperateResult.values().length];
            r100[OperateResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L61:
            r100[OperateResult.REJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L67:
            r100[OperateResult.CANCEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L8:
            f192030a = r100;
            int[] r101 = new int[DoubaoBottomSheetButtonRole.values().length];
            r101[DoubaoBottomSheetButtonRole.AGREE_MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L63:
            r101[DoubaoBottomSheetButtonRole.AGREE_SUB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L69:
            r101[DoubaoBottomSheetButtonRole.REJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L12:
            f192031b = r101;
            int[] r102 = new int[AppletBottomSheetAction.values().length];
            r102[AppletBottomSheetAction.BUTTON_CLICK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L55:
            r102[AppletBottomSheetAction.CANCEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L15:
            f192032c = r102;
            int[] r103 = new int[AppletBottomSheetButtonRole.values().length];
            r103[AppletBottomSheetButtonRole.AGREE_MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L47:
            r103[AppletBottomSheetButtonRole.AGREE_SUB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L57:
            r103[AppletBottomSheetButtonRole.REJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L19:
            f192033d = r103;
            int[] r104 = new int[AppletBottomSheetCancelSource.values().length];
            r104[AppletBottomSheetCancelSource.MASK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L37
        L49:
            r104[AppletBottomSheetCancelSource.GESTURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L38
        L59:
            r104[AppletBottomSheetCancelSource.HOST_UNAVAILABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L39
        L65:
            r104[AppletBottomSheetCancelSource.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L40
        L24:
            f192034e = r104;
        }
    }

    public static final GrantingAction a(OperateResult r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f192030a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return GrantingAction.DISMISSED;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return GrantingAction.REJECTED;
    L13:
        return GrantingAction.AGREED;
    }
}
