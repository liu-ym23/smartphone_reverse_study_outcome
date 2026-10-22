package com.google.android.material.bottomappbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends FloatingActionButton.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4660a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f4661b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends FloatingActionButton.a {
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
        public final void b() {
            int i10 = BottomAppBar.f4643i0;
        }
    }

    public b(BottomAppBar bottomAppBar, int i10) {
        this.f4661b = bottomAppBar;
        this.f4660a = i10;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
    public final void a(FloatingActionButton floatingActionButton) {
        floatingActionButton.setTranslationX(this.f4661b.A(this.f4660a));
        floatingActionButton.j(new a(), true);
    }
}
