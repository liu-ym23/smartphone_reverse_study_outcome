package c6;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.stepos.core.common.util.ActionDebouncer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3296a;

    public e(String str) {
        this.f3296a = str;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View widget) {
        kotlin.jvm.internal.g.f(widget, "widget");
        ActionDebouncer actionDebouncer = c.f3292a;
        Context context = widget.getContext();
        kotlin.jvm.internal.g.e(context, "getContext(...)");
        c.a(context, this.f3296a);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint ds) {
        kotlin.jvm.internal.g.f(ds, "ds");
        super.updateDrawState(ds);
        ds.setUnderlineText(false);
    }
}
