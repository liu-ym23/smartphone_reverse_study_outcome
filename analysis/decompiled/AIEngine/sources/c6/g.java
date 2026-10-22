package c6;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.stepos.aiengine.R;
import com.stepos.aiengine.cta.WithdrawActivity;
import com.stepos.core.common.util.ActionDebouncer;
import gc.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WithdrawActivity f3298a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3299b;

    public g(WithdrawActivity withdrawActivity, String str) {
        this.f3298a = withdrawActivity;
        this.f3299b = str;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View widget) {
        kotlin.jvm.internal.g.f(widget, "widget");
        ActionDebouncer actionDebouncer = c.f3292a;
        c.a(this.f3298a, q.M0(this.f3299b, 12298, 12299));
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint ds) {
        kotlin.jvm.internal.g.f(ds, "ds");
        super.updateDrawState(ds);
        ds.setUnderlineText(false);
        ds.setColor(this.f3298a.getColor(R.color.mm_blue));
    }
}
