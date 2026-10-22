package com.android.contacts.widget;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProgressDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"getTargetWindowDimAmount", "", "context", "Landroid/content/Context;", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ProgressDialogKt {
    public static final float getTargetWindowDimAmount(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if ((r1.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return 0.8f;
    L8:
        return 0.32f;
    L5:
        r2 = false;
        goto L6
    }
}
