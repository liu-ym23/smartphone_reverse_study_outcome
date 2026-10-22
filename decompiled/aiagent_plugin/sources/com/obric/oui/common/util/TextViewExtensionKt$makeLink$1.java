package com.obric.oui.common.util;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: TextViewExtension.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TextViewExtensionKt$makeLink$1 extends ClickableSpan {
    final /* synthetic */ d.h.a.b<View, x> $clickActionOnLinkText;
    final /* synthetic */ int $spanColor;

    TextViewExtensionKt$makeLink$1(d.h.a.b<? super View, x> r3, int r4) {
        this.$clickActionOnLinkText = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        this.$spanColor = r4;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View r2) {
        o.e(r2, "widget");
        this.$clickActionOnLinkText.invoke(r2);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r2) {
        o.e(r2, "ds");
        super.updateDrawState(r2);
        r2.setUnderlineText(false);
        r2.setColor(this.$spanColor);
    }
}
