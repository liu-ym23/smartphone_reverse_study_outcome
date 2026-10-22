package com.android.contacts.calllog.record;

import android.content.Context;
import android.widget.LinearLayout;
import com.android.contacts.R;
import com.obric.oui.layout.OUILinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallSummaryView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/contacts/calllog/record/CallSummaryView;", "Lcom/obric/oui/layout/OUILinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallSummaryView extends OUILinearLayout {
    public CallSummaryView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, null, 0, null, 14, null);
        LinearLayout.inflate(r9, R.layout.call_record_sumarry_container, this);
    }
}
