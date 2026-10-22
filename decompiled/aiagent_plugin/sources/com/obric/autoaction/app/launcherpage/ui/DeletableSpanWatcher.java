package com.obric.autoaction.app.launcherpage.ui;

import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: DeletableSpan.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeletableSpanWatcher implements TextWatcher {
    private int beforeCursorPosition;
    private String beforeText;
    private final EditText editText;
    private boolean isSelfEditing;
    private DeletableSpan pendingDeleteSpan;

    /* JADX INFO: renamed from: lambda$DezvpjD0XrPUgT-po_aBN4lssK8, reason: not valid java name */
    public static /* synthetic */ void m561lambda$DezvpjD0XrPUgTpo_aBN4lssK8(DeletableSpanWatcher r0, DeletableSpan r1) {
        onTextChanged$lambda$0(r0, r1);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r2) {
        Editable r1 = (Editable) ZeusTransformUtils.wrapperContextForParams(r2, Editable.class, "com.obric.aiagent.plugin");
    }

    public DeletableSpanWatcher(EditText r2) {
        d.h.b.o.e(r2, "editText");
        this.editText = r2;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r5, int r6, int r7, int r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L5;
        String r2 = r9.toString();
    L6:
        this.beforeText = r2;
        this.beforeCursorPosition = this.editText.getSelectionStart();
        this.pendingDeleteSpan = null;
        if (this.isSelfEditing == false) goto L9;
        return;
    L9:
        if (r7 <= 0) goto L34;
        if (r8 == 0) goto L12;
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r9, Spannable.class) == false) goto L36;
        int r10 = r7 + r6;
        Iterator r11 = d.h.b.c.a((DeletableSpan[]) ZeusTransformUtils.preCheckCast(((Spannable) ZeusTransformUtils.preCheckCast(r9, Spannable.class, "com.obric.aiagent.plugin")).getSpans(r6, r10, DeletableSpan.class), DeletableSpan[].class, "com.obric.aiagent.plugin"));
    L15:
        if (r11.hasNext() == false) goto L37;
        DeletableSpan r0 = (DeletableSpan) ZeusTransformUtils.preCheckCast(r11.next(), DeletableSpan.class, "com.obric.aiagent.plugin");
        int r3 = ((Spannable) ZeusTransformUtils.preCheckCast(r9, Spannable.class, "com.obric.aiagent.plugin")).getSpanStart(r0);
        int r4 = ((Spannable) ZeusTransformUtils.preCheckCast(r9, Spannable.class, "com.obric.aiagent.plugin")).getSpanEnd(r0);
        if (r3 < 0) goto L15;
        if (r4 <= r3) goto L15;
        if (r6 >= r4) goto L15;
        if (r10 <= r3) goto L15;
        this.pendingDeleteSpan = r0;
        return;
    L37:
        return;
    L36:
        return;
    L34:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if (this.isSelfEditing == false) goto L5;
        return;
    L5:
        final DeletableSpan r6 = this.pendingDeleteSpan;
        if (r6 != null) goto L8;
        return;
    L8:
        this.pendingDeleteSpan = null;
        this.editText.post(new $$Lambda$DeletableSpanWatcher$DezvpjD0XrPUgTpo_aBN4lssK8(this, r6));
    }

    private static final void onTextChanged$lambda$0(DeletableSpanWatcher r0, DeletableSpan r1) {
        r0.removeDeletableSpan(r1);
    }

    private final void removeDeletableSpan(DeletableSpan r6) {
        this.isSelfEditing = true;
        Editable r1 = this.editText.getText();     // Catch: Throwable -> L24
        if (r1 != null) goto L7;
        this.isSelfEditing = false;
        return;
    L7:
        int r2 = r1.getSpanStart(r6);     // Catch: Throwable -> L24
        int r3 = r1.getSpanEnd(r6);     // Catch: Throwable -> L24
        if (r2 < 0) goto L22;
        if (r3 < 0) goto L22;
        if (r3 <= r2) goto L22;
        if (r2 <= r1.length()) goto L15;
    L20:
        this.isSelfEditing = false;
        return;
    L15:
        if (r3 > r1.length()) goto L20;
        r1.removeSpan(r6);     // Catch: Throwable -> L24
        r1.delete(r2, r3);     // Catch: Throwable -> L24
        EditText r7 = this.editText;     // Catch: Throwable -> L24
        r7.setSelection(d.l.n.a(r2, 0, r7.length()));     // Catch: Throwable -> L24
        this.isSelfEditing = false;
        return;
    L22:
        this.isSelfEditing = false;
        return;
    L24:
        th = move-exception;
        this.isSelfEditing = false;
        throw th;
    }
}
