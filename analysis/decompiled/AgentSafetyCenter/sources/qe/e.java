package qe;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class e extends URLSpan {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10231c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g f10232f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(g gVar, String str, int i) {
        super(str);
        this.f10231c = i;
        this.f10232f = gVar;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public final void onClick(View view) {
        switch (this.f10231c) {
            case 0:
                view.cancelPendingInputEvents();
                this.f10232f.f10237e.onPrivacyPolicyClick(view.getContext());
                break;
            default:
                view.cancelPendingInputEvents();
                this.f10232f.f10237e.onUserAgreementClick(view.getContext());
                break;
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        int i = g.c() ? -35584 : -15505157;
        textPaint.setUnderlineText(false);
        textPaint.setColor(i);
    }
}
