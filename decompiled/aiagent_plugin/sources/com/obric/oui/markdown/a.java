package com.obric.oui.markdown;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OMarkdownCursorRunDelegate.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends com.lynx.markdown.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Drawable f35434b;

    public a(int r3, int r4, int r5, String r6, Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "selectorId");
        o.e(r8, "context");
        super(r3, r4, r5, r6);
        this.f35434b = (Drawable) ZeusTransformUtils.preCheckCast(new OMarkdownTypingDotsDrawable(r8), Drawable.class, "com.obric.aiagent.plugin");
    }

    @Override // com.lynx.markdown.i
    public void a(Canvas r4, Rect r5) {
        o.e(r4, "canvas");
        o.e(r5, "rect");
        this.f35434b.setBounds(0, 0, r5.width(), r5.height());
        this.f35434b.draw(r4);
    }
}
