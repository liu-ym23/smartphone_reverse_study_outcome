package o3;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: c, reason: collision with root package name */
    public int f9132c;

    /* renamed from: f, reason: collision with root package name */
    public e f9133f;

    /* renamed from: g, reason: collision with root package name */
    public int f9134g;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f9132c);
        e eVar = this.f9133f;
        eVar.f9149a.performAction(this.f9134g, bundle);
    }
}
