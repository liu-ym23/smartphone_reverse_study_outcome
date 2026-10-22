package com.stepos.agentframework.uikit;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p7.AppUI;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/uikit/w;", "", "<init>", "()V", "Landroid/widget/TextView;", "textView", "", "text", "", "linkColor", "Lkotlin/Function1;", "", "LY8/t;", "onExternalNavigation", "", Const.INTENT_KEY_APIKEY, "(Landroid/widget/TextView;Ljava/lang/CharSequence;ILp9/l;)Z", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.uikit.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2148w {
    public static final C2148w INSTANCE = new C2148w();

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/agentframework/uikit/w$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AppUI.TYPE_WIDGET, "LY8/t;", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", Const.SP_KEY_DEVICE_SENSORS, "updateDrawState", "(Landroid/text/TextPaint;)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.uikit.w$a */
    public static final class a extends ClickableSpan {
        final /* synthetic */ int $linkColor;
        final /* synthetic */ InterfaceC5074l<String, Y8.t> $onExternalNavigation;
        final /* synthetic */ String $url;

        /* JADX WARN: Multi-variable type inference failed */
        public a(String str, InterfaceC5074l<? super String, Y8.t> interfaceC5074l, int i10) {
            this.$url = str;
            this.$onExternalNavigation = interfaceC5074l;
            this.$linkColor = i10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            InterfaceC5074l<String, Y8.t> interfaceC5074l;
            kotlin.jvm.internal.p.i(widget, "widget");
            String str = this.$url;
            kotlin.jvm.internal.p.f(str);
            if (La.D.X(str, Const.STR_MART_WELL, false, 2, null)) {
                String str2 = this.$url;
                kotlin.jvm.internal.p.f(str2);
                MarkwonHelper.q0(widget, str2);
                return;
            }
            String str3 = this.$url;
            kotlin.jvm.internal.p.f(str3);
            if (!MarkwonHelper.o0(widget, str3) || (interfaceC5074l = this.$onExternalNavigation) == null) {
                return;
            }
            String str4 = this.$url;
            kotlin.jvm.internal.p.f(str4);
            interfaceC5074l.invoke(str4);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            kotlin.jvm.internal.p.i(ds, "ds");
            ds.setColor(this.$linkColor);
            ds.setUnderlineText(true);
        }
    }

    public static final boolean a(TextView textView, CharSequence text, int linkColor, InterfaceC5074l<? super String, Y8.t> onExternalNavigation) {
        Object objB;
        kotlin.jvm.internal.p.i(textView, "textView");
        if (text == null || text.length() == 0) {
            textView.setText(text);
            return false;
        }
        if (!MarkwonHelper.v0(text)) {
            textView.setText(text);
            return false;
        }
        SpannableString spannableString = new SpannableString(text);
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(A0.b.b(spannableString, MarkwonHelper.e0(), null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        URLSpan[] uRLSpanArr = ((Boolean) objB).booleanValue() ? (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class) : null;
        if (uRLSpanArr == null || uRLSpanArr.length == 0) {
            textView.setText(text);
            return false;
        }
        for (URLSpan uRLSpan : uRLSpanArr) {
            int spanStart = spannableString.getSpanStart(uRLSpan);
            int spanEnd = spannableString.getSpanEnd(uRLSpan);
            String url = uRLSpan.getURL();
            spannableString.removeSpan(uRLSpan);
            spannableString.setSpan(new a(url, onExternalNavigation, linkColor), spanStart, spanEnd, 33);
        }
        textView.setText(spannableString);
        if (textView.getMovementMethod() instanceof LinkMovementMethod) {
            return true;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return true;
    }

    public static /* synthetic */ boolean b(TextView textView, CharSequence charSequence, int i10, InterfaceC5074l interfaceC5074l, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = MarkwonHelper.X();
        }
        if ((i11 & 8) != 0) {
            interfaceC5074l = null;
        }
        return a(textView, charSequence, i10, interfaceC5074l);
    }
}
