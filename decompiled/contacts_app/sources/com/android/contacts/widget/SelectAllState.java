package com.android.contacts.widget;

import android.widget.TextView;
import com.android.contacts.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/android/contacts/widget/SelectAllState;", "", "btn", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "getBtn", "()Landroid/widget/TextView;", "value", "", "isSelectAll", "()Z", "setSelectAll", "(Z)V", "toggle", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectAllState {
    private final TextView btn;
    private boolean isSelectAll;

    public SelectAllState(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "btn");
        this.btn = r2;
    }

    public final TextView getBtn() {
        return this.btn;
    }

    public final boolean isSelectAll() {
        return this.isSelectAll;
    }

    public final void setSelectAll(boolean r2) {
        this.isSelectAll = r2;
        if (r2 == false) goto L5;
        TextView r1 = this.btn;
        r1.setText(r1.getContext().getString(R.string.cancel_select_all));
        return;
    L5:
        TextView r3 = this.btn;
        r3.setText(r3.getContext().getString(R.string.select_all));
    }

    public final void toggle() {
        setSelectAll(!this.isSelectAll);
    }
}
