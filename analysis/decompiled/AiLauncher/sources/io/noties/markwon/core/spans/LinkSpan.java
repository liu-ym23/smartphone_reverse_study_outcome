package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import u8.c;
import v8.C5671a;

/* loaded from: classes4.dex */
public class LinkSpan extends URLSpan {
    private final String link;
    private final c resolver;
    private final C5671a theme;

    public LinkSpan(C5671a c5671a, String str, c cVar) {
        super(str);
        this.theme = c5671a;
        this.link = str;
        this.resolver = cVar;
    }

    public String getLink() {
        return this.link;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        this.resolver.a(view, this.link);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        this.theme.g(textPaint);
    }
}
