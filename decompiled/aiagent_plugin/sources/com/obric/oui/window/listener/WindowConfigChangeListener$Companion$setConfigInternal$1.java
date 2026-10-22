package com.obric.oui.window.listener;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.i;
import androidx.lifecycle.o;
import androidx.lifecycle.x;

/* JADX INFO: compiled from: WindowConfigChangeListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class WindowConfigChangeListener$Companion$setConfigInternal$1 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FragmentActivity f36893a;

    @x(a = i.a.ON_DESTROY)
    public final void onDestroy() {
        int r2 = this.f36893a.hashCode();
        if (b.b().containsKey(Integer.valueOf(r2)) == false) goto L6;
        b.b().remove(Integer.valueOf(r2));
        return;
    }
}
