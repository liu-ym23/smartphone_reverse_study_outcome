package L;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f1126a;

    /* renamed from: b, reason: collision with root package name */
    public final g f1127b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1128c;

    public a(int i4, g gVar, int i5) {
        this.f1126a = i4;
        this.f1127b = gVar;
        this.f1128c = i5;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f1126a);
        this.f1127b.f1142a.performAction(this.f1128c, bundle);
    }
}
