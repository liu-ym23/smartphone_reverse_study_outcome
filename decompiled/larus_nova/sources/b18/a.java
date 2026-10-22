package b18;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.OnClickListener f16947b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f16947b.onClick(r100);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setColor(this.f16946a);
        r100.setUnderlineText(false);
    }

    public a(int r100, View.OnClickListener r101) {
        Intrinsics.checkNotNullParameter(r101, "clickListener");
        this.f16946a = r100;
        this.f16947b = r101;
    }
}
