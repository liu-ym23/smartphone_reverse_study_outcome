package stepos.support.v7.app;

import android.widget.CompoundButton;

/* loaded from: classes2.dex */
public final class P implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T f14331a;

    public P(T t4) {
        this.f14331a = t4;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        this.f14331a.getButton(-1).setEnabled(!z4);
    }
}
