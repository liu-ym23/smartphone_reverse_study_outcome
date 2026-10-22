package com.obric.oui.window.permission;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionPurposeWindow.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/window/permission/PermissionPurposeWindowHandler;", "", "purposeTitle", "", "purposeDesc", "(Ljava/lang/String;Ljava/lang/String;)V", "descTextView", "Landroid/widget/TextView;", "titleTextView", "onCreateView", "Landroid/view/View;", "context", "Landroid/content/Context;", "decorViewPos", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PermissionPurposeWindowHandler {
    private TextView descTextView;
    private final String purposeDesc;
    private final String purposeTitle;
    private TextView titleTextView;

    public PermissionPurposeWindowHandler(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "purposeTitle");
        Intrinsics.checkNotNullParameter(r3, "purposeDesc");
        this.purposeTitle = r2;
        this.purposeDesc = r3;
    }

    public final View onCreateView(Context r6, int[] r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "decorViewPos");
        TextView r1 = null;
        View r8 = LayoutInflater.from(r6).inflate(R.layout.layout_permission_purpose_window, null);
        View r0 = r8.findViewById(R.id.permission_window_title);
        Intrinsics.checkNotNullExpressionValue(r0, "view.findViewById(R.id.permission_window_title)");
        this.titleTextView = (TextView) r0;
        View r2 = r8.findViewById(R.id.permission_window_desc);
        Intrinsics.checkNotNullExpressionValue(r2, "view.findViewById(R.id.permission_window_desc)");
        this.descTextView = (TextView) r2;
        boolean r3 = false;
        if (this.purposeTitle.length() <= 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L12;
        TextView r5 = this.titleTextView;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        r5 = null;
    L10:
        r5.setText(this.purposeTitle);
    L12:
        if (this.purposeDesc.length() <= 0) goto L14;
        r3 = true;
    L14:
        if (r3 == false) goto L20;
        TextView r9 = this.descTextView;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("descTextView");
    L19:
        r1.setText(this.purposeDesc);
        goto L20
    L18:
        r1 = r9;
    L20:
        Integer r10 = ArraysKt.getOrNull(r7, 1);
        if (r10 != null) goto L23;
    L25:
        Intrinsics.checkNotNullExpressionValue(r8, "view");
        return r8;
    L23:
        if (r10.intValue() <= 0) goto L25;
        r8.setPadding(r8.getPaddingLeft(), r8.getPaddingTop() - r10.intValue(), r8.getPaddingRight(), r8.getPaddingBottom());
        goto L25
    L5:
        r4 = false;
        goto L6
    }
}
