package com.android.ttcjpaysdk.kmp.common.view.dialog;

import com.android.ttcjpaysdk.kmp.base.alog.CJLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/dialog/CJStdDialog;", "", "<init>", "()V", "TAG", "", "show", "options", "Lcom/android/ttcjpaysdk/kmp/common/view/dialog/CJStdDialogOptions;", "dismiss", "", "dialogID", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJStdDialog {
    public static final int $stable = 0;
    public static final CJStdDialog INSTANCE = null;
    private static final String TAG = "CJStdDialog";

    static {
        INSTANCE = new CJStdDialog();
    }

    private CJStdDialog() {
    }

    public final void dismiss(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogID");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        pd6.b r102 = pd6.c.f528682a;
        IKmpCJStdDialogService r103 = (IKmpCJStdDialogService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJStdDialogService.class));
        if (r103 == null) goto L12;
        r103.dismissStdDialog(r100);
        return;
    L12:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final String show(CJStdDialogOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "options");
        pd6.b r101 = pd6.c.f528682a;
        IKmpCJStdDialogService r102 = (IKmpCJStdDialogService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJStdDialogService.class));
        if (r102 != null) goto L7;
        CJLogger.INSTANCE.e(TAG, "show: IKmpCJStdDialogService is null");
        return "";
    L7:
        return r102.showStdDialog(r100);
    }
}
