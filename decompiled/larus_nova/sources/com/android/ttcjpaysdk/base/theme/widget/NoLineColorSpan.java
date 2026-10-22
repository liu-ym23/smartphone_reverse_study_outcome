package com.android.ttcjpaysdk.base.theme.widget;

import android.text.TextPaint;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.utils.CJPayDebouncingClickableSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/theme/widget/NoLineColorSpan;", "Lcom/android/ttcjpaysdk/base/utils/CJPayDebouncingClickableSpan;", "()V", "updateDrawState", "", "ds", "Landroid/text/TextPaint;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class NoLineColorSpan extends CJPayDebouncingClickableSpan {
    public NoLineColorSpan() {
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setUnderlineText(false);
        r100.setColor(CJPayThemeManager.instance.getAgreementTextColor());
    }
}
