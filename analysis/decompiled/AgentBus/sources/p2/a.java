package p2;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: f, reason: collision with root package name */
    public final int f8380f;

    /* renamed from: g, reason: collision with root package name */
    public final h f8381g;

    /* renamed from: h, reason: collision with root package name */
    public final int f8382h;

    public a(int i2, h hVar, int i10) {
        this.f8380f = i2;
        this.f8381g = hVar;
        this.f8382h = i10;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f8380f);
        this.f8381g.f8393a.performAction(this.f8382h, bundle);
    }
}
