package G4;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes3.dex */
public final class h extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f671a;

    public h(b bVar) {
        this.f671a = bVar;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View widget) {
        kotlin.jvm.internal.k.f(widget, "widget");
        this.f671a.invoke();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint ds) {
        kotlin.jvm.internal.k.f(ds, "ds");
        super.updateDrawState(ds);
        ds.setColor(-15304705);
        ds.setUnderlineText(false);
    }
}
