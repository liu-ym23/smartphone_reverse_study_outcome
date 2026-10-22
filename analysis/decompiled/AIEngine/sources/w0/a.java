package w0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f13529a;

    /* renamed from: b, reason: collision with root package name */
    public final b f13530b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13531c;

    public a(int i10, b bVar, int i11) {
        this.f13529a = i10;
        this.f13530b = bVar;
        this.f13531c = i11;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f13529a);
        this.f13530b.f13532a.performAction(this.f13531c, bundle);
    }
}
