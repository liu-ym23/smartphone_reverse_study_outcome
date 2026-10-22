package com.android.contacts.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import com.android.contacts.R;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.progress.ODownloadProgressView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import obric.util.Tasks;

/* JADX INFO: compiled from: ProgressDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0012J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0012J\u0012\u0010 \u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/android/contacts/widget/ProgressDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createTasks", "Lobric/util/Tasks;", "dim", "", "getDim", "()F", "setDim", "(F)V", "message", "Landroid/widget/TextView;", "progress", "Lcom/obric/oui/progress/ODownloadProgressView;", "progressBackgroundColor", "", "Ljava/lang/Integer;", "progressContent", "Lcom/obric/oui/layout/OUILinearLayout;", "title", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setMessage", "str", "", "setProgressBackgroundColor", "color", "setTitle", "show", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProgressDialog extends Dialog {
    private final Tasks createTasks;
    private float dim;
    private TextView message;
    private ODownloadProgressView progress;
    private Integer progressBackgroundColor;
    private OUILinearLayout progressContent;
    private TextView title;

    public static /* synthetic */ void $r8$lambda$bEUj3vVH7vVRRijXoLpp1hXnt60(ProgressDialog r0, CharSequence r1) {
        setTitle$lambda$5$lambda$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$o1_c0wQesbfrF6B8j5zMGidwRIM(ProgressDialog r0, CharSequence r1) {
        setMessage$lambda$8$lambda$7(r0, r1);
    }

    public ProgressDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.createTasks = new Tasks();
    }

    public final float getDim() {
        return this.dim;
    }

    public final void setDim(float r1) {
        this.dim = r1;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        Window r4 = getWindow();
        if (r4 == null) goto L5;
        r4.requestFeature(1);
    L5:
        setContentView(R.layout.contacts_progress_dialog);
        this.progress = (ODownloadProgressView) findViewById(R.id.progress);
        this.title = (TextView) findViewById(R.id.title);
        this.message = (TextView) findViewById(R.id.message);
        this.progressContent = (OUILinearLayout) findViewById(R.id.progress_dialog_content);
        Integer r5 = this.progressBackgroundColor;
        if (r5 == null) goto L10;
        int r6 = r5.intValue();
        OUILinearLayout r0 = this.progressContent;
        if (r0 == null) goto L10;
        r0.setBackgroundColor(r6);
    L10:
        Window r7 = getWindow();
        if (r7 == null) goto L13;
        r7.setLayout(-1, -2);
        r7.setBackgroundDrawableResource(android.R.color.transparent);
    L13:
        this.createTasks.runAndClear();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window r0 = getWindow();
        if (r0 == null) goto L9;
        float r2 = this.dim;
        if (r2 <= 0.0f) goto L7;
        r0.setDimAmount(r2);
        return;
    L7:
        r0.clearFlags(2);
        return;
    }

    @Override // android.app.Dialog
    public void setTitle(int r2) {
        setTitle(getContext().getString(r2));
    }

    @Override // android.app.Dialog
    public void setTitle(final CharSequence r3) {
        TextView r0 = this.title;
        if (r0 == null) goto L14;
        r0.setText(r3);
        TextView r1 = r0;
        int r2 = 0;
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        r2 = 8;
    L13:
        r1.setVisibility(r2);
        return;
    L7:
        if (r3.length() == 0) goto L10;
        r4 = false;
        goto L11
    L14:
        this.createTasks.add(new ProgressDialog$$ExternalSyntheticLambda1(this, r3));
    }

    private static final void setTitle$lambda$5$lambda$4(ProgressDialog r1, CharSequence r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.setTitle(r2);
    }

    public final void setMessage(int r2) {
        setMessage(getContext().getString(r2));
    }

    public final void setMessage(final CharSequence r3) {
        TextView r0 = this.message;
        if (r0 == null) goto L14;
        r0.setText(r3);
        TextView r1 = r0;
        int r2 = 0;
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        r2 = 8;
    L13:
        r1.setVisibility(r2);
        return;
    L7:
        if (r3.length() == 0) goto L10;
        r4 = false;
        goto L11
    L14:
        this.createTasks.add(new ProgressDialog$$ExternalSyntheticLambda0(this, r3));
    }

    private static final void setMessage$lambda$8$lambda$7(ProgressDialog r1, CharSequence r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.setMessage(r2);
    }

    public final void setProgressBackgroundColor(int r2) {
        this.progressBackgroundColor = Integer.valueOf(r2);
        OUILinearLayout r1 = this.progressContent;
        if (r1 == null) goto L6;
        r1.setBackgroundColor(r2);
        return;
    }
}
