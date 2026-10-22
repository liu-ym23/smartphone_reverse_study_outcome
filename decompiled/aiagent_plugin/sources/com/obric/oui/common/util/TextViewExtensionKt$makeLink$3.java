package com.obric.oui.common.util;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: TextViewExtension.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TextViewExtensionKt$makeLink$3 extends ClickableSpan {
    final /* synthetic */ d.h.a.b<View, x> $clickActionOnOtherText;
    final /* synthetic */ TextView $this_makeLink;

    TextViewExtensionKt$makeLink$3(d.h.a.b<? super View, x> r3, TextView r4) {
        this.$clickActionOnOtherText = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        this.$this_makeLink = r4;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View r2) {
        o.e(r2, "widget");
        this.$clickActionOnOtherText.invoke(r2);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r2) {
        o.e(r2, "ds");
        super.updateDrawState(r2);
        r2.setUnderlineText(false);
        r2.setColor(this.$this_makeLink.getCurrentTextColor());
    }
}
