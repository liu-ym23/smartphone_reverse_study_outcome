package com.stepos.ailauncher.container;

import com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class r0<T extends ScrollOverlayComponent> {
    private WeakReference<T> mCurrentComponent = new WeakReference<>(null);

    public T a() {
        return this.mCurrentComponent.get();
    }

    public void b(T t10) {
        this.mCurrentComponent = new WeakReference<>(t10);
    }

    public void c(T t10) {
        if (this.mCurrentComponent.get() == t10) {
            this.mCurrentComponent.clear();
        }
    }
}
