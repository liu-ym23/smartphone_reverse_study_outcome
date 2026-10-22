package com.android.contacts.widget;

import android.view.ActionMode;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CopyTextView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0001¨\u0006\b"}, d2 = {"emptyCopyAll", "Lcom/android/contacts/widget/CopyAll;", "view", "Landroid/view/View;", "copyPasteActionMode", "", "Landroid/widget/TextView;", "prepareCopyPasteActionMode", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CopyTextViewKt {
    /* JADX INFO: renamed from: $r8$lambda$hy3D-Sgeyf1Pjvj7QoVJIcI_XUA, reason: not valid java name */
    public static /* synthetic */ boolean m229$r8$lambda$hy3DSgeyf1Pjvj7QoVJIcI_XUA(CopyAll r0, View r1) {
        return copyPasteActionMode$lambda$1(r0, r1);
    }

    public static final CopyAll emptyCopyAll(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        CopyAll r0 = new CopyAll(r2, AnonymousClass1.INSTANCE);
        prepareCopyPasteActionMode(r0);
        return r0;
    }

    public static final void prepareCopyPasteActionMode(final CopyAll r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setCopyAllActionModeCallback(new CopyTextViewKt$prepareCopyPasteActionMode$callback$1(r1));
    }

    public static final void copyPasteActionMode(final CopyAll r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        prepareCopyPasteActionMode(r2);
        r2.getView().setOnLongClickListener(new CopyTextViewKt$$ExternalSyntheticLambda0(r2));
    }

    private static final boolean copyPasteActionMode$lambda$1(CopyAll r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "$this_copyPasteActionMode");
        r0.startCopyAllActionMode();
        return true;
    }

    public static final void copyPasteActionMode(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ActionMode.Callback r0 = new CopyTextViewKt$copyPasteActionMode$callback$1();
        r2.setTextIsSelectable(true);
        r2.setCustomSelectionActionModeCallback(r0);
    }
}
