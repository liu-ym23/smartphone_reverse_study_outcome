package stepos.support.v7.app;

import android.widget.CompoundButton;
import stepos.support.v7.app.g0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0.b f12100a;

    public d0(g0.b bVar) {
        this.f12100a = bVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f12100a.getButton(-1).setEnabled(!z);
    }
}
