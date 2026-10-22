package com.stepos.widget.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import androidx.annotation.RestrictTo;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/widget/dialog/StepOSDialogListView;", "Landroid/widget/ListView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public final class StepOSDialogListView extends ListView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSDialogListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.f(context, "context");
    }
}
