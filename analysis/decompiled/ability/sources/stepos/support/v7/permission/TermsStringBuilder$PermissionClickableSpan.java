package stepos.support.v7.permission;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
class TermsStringBuilder$PermissionClickableSpan extends URLSpan {
    private static final int POLE_STAR_COLOR = -35584;
    private static final int STEP_OS_COLOR = -15505157;

    public TermsStringBuilder$PermissionClickableSpan(String str, Context context) {
        super(str);
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    @CallSuper
    public void onClick(@NonNull View view) {
        view.cancelPendingInputEvents();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        super.updateDrawState(textPaint);
        int i = f.c() ? POLE_STAR_COLOR : STEP_OS_COLOR;
        textPaint.setUnderlineText(false);
        textPaint.setColor(i);
    }
}
