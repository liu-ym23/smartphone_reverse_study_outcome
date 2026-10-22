package androidx.fragment.app;

import K.InterfaceC0078j;
import K.InterfaceC0084p;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.AbstractC0328z;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import j0.C0631f;
import stepos.support.v7.app.AbstractActivityC0866k;

/* loaded from: classes.dex */
public final class F extends L implements androidx.core.content.h, androidx.core.content.i, androidx.core.app.z, androidx.core.app.A, u0, androidx.activity.B, androidx.activity.result.h, j0.h, b0, InterfaceC0078j {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ G f3587e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(AbstractActivityC0866k abstractActivityC0866k) {
        super(abstractActivityC0866k);
        this.f3587e = abstractActivityC0866k;
    }

    @Override // androidx.fragment.app.b0
    public final void a(D d4) {
        this.f3587e.onAttachFragment(d4);
    }

    @Override // K.InterfaceC0078j
    public final void addMenuProvider(InterfaceC0084p interfaceC0084p) {
        this.f3587e.addMenuProvider(interfaceC0084p);
    }

    @Override // androidx.core.content.h
    public final void addOnConfigurationChangedListener(J.a aVar) {
        this.f3587e.addOnConfigurationChangedListener(aVar);
    }

    @Override // androidx.core.app.z
    public final void addOnMultiWindowModeChangedListener(J.a aVar) {
        this.f3587e.addOnMultiWindowModeChangedListener(aVar);
    }

    @Override // androidx.core.app.A
    public final void addOnPictureInPictureModeChangedListener(J.a aVar) {
        this.f3587e.addOnPictureInPictureModeChangedListener(aVar);
    }

    @Override // androidx.core.content.i
    public final void addOnTrimMemoryListener(J.a aVar) {
        this.f3587e.addOnTrimMemoryListener(aVar);
    }

    @Override // androidx.fragment.app.J
    public final View b(int i4) {
        return this.f3587e.findViewById(i4);
    }

    @Override // androidx.fragment.app.J
    public final boolean c() {
        Window window = this.f3587e.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // androidx.activity.result.h
    public final androidx.activity.result.g getActivityResultRegistry() {
        return this.f3587e.getActivityResultRegistry();
    }

    @Override // androidx.lifecycle.G
    public final AbstractC0328z getLifecycle() {
        return this.f3587e.mFragmentLifecycleRegistry;
    }

    @Override // androidx.activity.B
    public final androidx.activity.A getOnBackPressedDispatcher() {
        return this.f3587e.getOnBackPressedDispatcher();
    }

    @Override // j0.h
    public final C0631f getSavedStateRegistry() {
        return this.f3587e.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.u0
    public final t0 getViewModelStore() {
        return this.f3587e.getViewModelStore();
    }

    @Override // K.InterfaceC0078j
    public final void removeMenuProvider(InterfaceC0084p interfaceC0084p) {
        this.f3587e.removeMenuProvider(interfaceC0084p);
    }

    @Override // androidx.core.content.h
    public final void removeOnConfigurationChangedListener(J.a aVar) {
        this.f3587e.removeOnConfigurationChangedListener(aVar);
    }

    @Override // androidx.core.app.z
    public final void removeOnMultiWindowModeChangedListener(J.a aVar) {
        this.f3587e.removeOnMultiWindowModeChangedListener(aVar);
    }

    @Override // androidx.core.app.A
    public final void removeOnPictureInPictureModeChangedListener(J.a aVar) {
        this.f3587e.removeOnPictureInPictureModeChangedListener(aVar);
    }

    @Override // androidx.core.content.i
    public final void removeOnTrimMemoryListener(J.a aVar) {
        this.f3587e.removeOnTrimMemoryListener(aVar);
    }
}
