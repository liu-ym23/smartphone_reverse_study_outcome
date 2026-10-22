package com.android.contacts.vcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.contacts.R;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.oui.common.util.ToolsExtKt;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.StyleController;
import com.obric.oui.progress.OProgressView;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProgressBodyController.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0016J\u000e\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,J\u0016\u0010-\u001a\u00020$2\u0006\u0010 \u001a\u00020,2\u0006\u0010\u0005\u001a\u00020,R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\n¨\u0006."}, d2 = {"Lcom/android/contacts/vcard/ProgressBodyController;", "Lcom/obric/oui/dialog/alert/StyleController;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", PerfConsts.KEY_CURRENT_GALVANIC, "Ljava/util/concurrent/atomic/AtomicInteger;", "getCurrent", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setCurrent", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "leftTextView", "Landroid/widget/TextView;", "getLeftTextView", "()Landroid/widget/TextView;", "setLeftTextView", "(Landroid/widget/TextView;)V", "progressView", "Lcom/obric/oui/progress/OProgressView;", "getProgressView", "()Lcom/obric/oui/progress/OProgressView;", "setProgressView", "(Lcom/obric/oui/progress/OProgressView;)V", "rightTextView", "getRightTextView", "setRightTextView", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", PerfConsts.PERF_DISK_TOTAL, "getTotal", "setTotal", "attachToDialog", "", "dialog", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "attachToParent", "parent", "Landroid/widget/FrameLayout;", "incrementProgressBy", "diff", "", "setProgress", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProgressBodyController implements StyleController {
    private AtomicInteger current;
    private TextView leftTextView;
    private OProgressView progressView;
    private TextView rightTextView;
    private View rootView;
    private AtomicInteger total;

    public ProgressBodyController(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        View r5 = LayoutInflater.from(r4).inflate(R.layout.o_dialog_body_progress, null, false);
        Intrinsics.checkNotNullExpressionValue(r5, "from(context).inflate(R.…dy_progress, null, false)");
        this.rootView = r5;
        this.progressView = (OProgressView) r5.findViewById(R.id.o_progress_view_resumed);
        this.leftTextView = (TextView) this.rootView.findViewById(R.id.o_progress_view_resumed_left_text);
        this.rightTextView = (TextView) this.rootView.findViewById(R.id.o_progress_view_resumed_right_text);
        this.total = new AtomicInteger(0);
        this.current = new AtomicInteger(0);
    }

    public final View getRootView() {
        return this.rootView;
    }

    public final void setRootView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rootView = r2;
    }

    public final OProgressView getProgressView() {
        return this.progressView;
    }

    public final void setProgressView(OProgressView r1) {
        this.progressView = r1;
    }

    public final TextView getLeftTextView() {
        return this.leftTextView;
    }

    public final void setLeftTextView(TextView r1) {
        this.leftTextView = r1;
    }

    public final TextView getRightTextView() {
        return this.rightTextView;
    }

    public final void setRightTextView(TextView r1) {
        this.rightTextView = r1;
    }

    public final AtomicInteger getTotal() {
        return this.total;
    }

    public final void setTotal(AtomicInteger r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.total = r2;
    }

    public final AtomicInteger getCurrent() {
        return this.current;
    }

    public final void setCurrent(AtomicInteger r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.current = r2;
    }

    public final void setProgress(int r5, int r6) {
        this.total.set(r5);
        AtomicInteger r0 = this.current;
        if (r6 > r5) goto L6;
        r5 = r6;
    L6:
        r0.set(r5);
        if (this.total.get() <= 0) goto L9;
        final int r7 = (int) (((((double) this.current.get()) * 1.0d) / (((double) this.total.get()) * 1.0d)) * ((double) 100));
    L10:
        final String r8 = new StringBuilder().append(r7).append('%').toString();
        final String r1 = new StringBuilder().append(this.current.get()).append('/').append(this.total.get()).toString();
        ToolsExtKt.runInUIThread(new AnonymousClass1(this, r7, r8, r1));
        return;
    L9:
        r7 = 0;
        goto L10
    }

    public final void incrementProgressBy(int r2) {
        int r0 = this.current.get() + r2;
        setProgress(this.total.get(), r0);
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToParent(Context r3, FrameLayout r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-1, -2);
        ViewParent r0 = this.rootView.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ((ViewGroup) r0).removeView(this.rootView);
    L5:
        r4.addView(this.rootView, r5);
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToDialog(OAlertDialog r1) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
        r1.setAutoDismiss(false);
    }
}
