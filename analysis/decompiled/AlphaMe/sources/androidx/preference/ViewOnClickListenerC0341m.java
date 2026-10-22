package androidx.preference;

import android.view.View;

/* renamed from: androidx.preference.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0341m implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Preference f4153a;

    public ViewOnClickListenerC0341m(Preference preference) {
        this.f4153a = preference;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f4153a.s(view);
    }
}
