package stepos.support.v7.permission;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;

/* loaded from: classes2.dex */
class TermsStringBuilder$PermissionClickableSpan extends URLSpan {
    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        view.cancelPendingInputEvents();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        int i4 = f.c() ? -35584 : -15505157;
        textPaint.setUnderlineText(false);
        textPaint.setColor(i4);
    }
}
