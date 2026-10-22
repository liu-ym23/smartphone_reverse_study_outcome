package f0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f2528a;

    /* renamed from: b, reason: collision with root package name */
    public final g f2529b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2530c;

    public a(int i8, g gVar, int i9) {
        this.f2528a = i8;
        this.f2529b = gVar;
        this.f2530c = i9;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f2528a);
        this.f2529b.f2542a.performAction(this.f2530c, bundle);
    }
}
