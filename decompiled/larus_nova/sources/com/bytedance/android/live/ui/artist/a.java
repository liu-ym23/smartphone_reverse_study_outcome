package com.bytedance.android.live.ui.artist;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a extends ClickableSpan {
    public abstract boolean a();

    @Override // android.text.style.ClickableSpan
    @Deprecated(message = "use onSpanClick")
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setColor(0);
        r100.setUnderlineText(false);
        r100.setFakeBoldText(false);
    }
}
