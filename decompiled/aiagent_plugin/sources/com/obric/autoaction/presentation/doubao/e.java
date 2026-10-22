package com.obric.autoaction.presentation.doubao;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.widget.RemoteViews;
import com.obric.autogui.common.api.assistant.IAssistCardResourceProvider;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: AssistWidgetBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static /* synthetic */ x lambda$QDlSz_LYnYxxgZ6k0UJTgfXt60k(Context r0, com.obric.aiagent.assistant_card.provider_core.bean.c.a r1, IAssistCardResourceProvider r2, boolean r3, d.h.a.b r4, RemoteViews r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static final com.obric.aiagent.assistant_card.provider_core.bean.c.a a(final com.obric.aiagent.assistant_card.provider_core.bean.c.a r8, Context r9, IAssistCardResourceProvider r10, final boolean r11, d.h.a.b<? super a, x> r12) {
        final Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        final IAssistCardResourceProvider r5 = (IAssistCardResourceProvider) ZeusTransformUtils.wrapperContextForParams(r10, IAssistCardResourceProvider.class, "com.obric.aiagent.plugin");
        final d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r8, "<this>");
        o.e(r3, "context");
        o.e(r5, "resProvider");
        o.e(r7, "buildRemoteView");
        return r8.a(new $$Lambda$e$QDlSz_LYnYxxgZ6k0UJTgfXt60k(r3, r8, r5, r11, r7));
    }

    private static final x a(Context r8, com.obric.aiagent.assistant_card.provider_core.bean.c.a r9, IAssistCardResourceProvider r10, boolean r11, d.h.a.b r12, RemoteViews r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        IAssistCardResourceProvider r6 = (IAssistCardResourceProvider) ZeusTransformUtils.wrapperContextForParams(r10, IAssistCardResourceProvider.class, "com.obric.aiagent.plugin");
        d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r13, "$this$configDisplay");
        a r15 = new a(r3, r13, r9, r6, r11);
        r14.invoke(r15);
        r15.c();
        return x.f38692a;
    }

    public static final Drawable a(Drawable r2, String r3) {
        o.e(r2, "<this>");
        o.e(r3, "appName");
        Drawable.ConstantState r4 = r2.getConstantState();
        if (r4 != null) goto L7;
        Loog.INSTANCE.e("AssistWidgetBuilder", "unexpected null of constantState " + r3);
        return null;
    L7:
        return r4.newDrawable().mutate();
    }

    public static final CharSequence a(CharSequence r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r6, "text");
        SpannableString r0 = new SpannableString(r6);
        r0.setSpan(new StyleSpan(r5), 0, r6.length(), 33);
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public static final Bitmap a(Bitmap r6) {
        o.e(r6, "<this>");
        int r0 = r6.getWidth();
        Bitmap.Config r1 = r6.getConfig();
        if (r1 != null) goto L5;
        r1 = Bitmap.Config.ARGB_8888;
    L5:
        Bitmap r2 = Bitmap.createBitmap(r0, r0, r1);
        Canvas r3 = new Canvas(r2);
        Paint r4 = new Paint(1);
        float r5 = r0 / 2.0f;
        r3.drawCircle(r5, r5, r5, r4);
        r4.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN), Xfermode.class, "com.obric.aiagent.plugin"));
        r3.drawBitmap(r6, 0.0f, 0.0f, r4);
        return r2;
    }
}
