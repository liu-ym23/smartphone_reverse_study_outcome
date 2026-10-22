package com.obric.oui.window.listener;

import androidx.lifecycle.i;
import androidx.lifecycle.o;
import androidx.lifecycle.x;

/* JADX INFO: compiled from: WindowConfigChangeListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class WindowConfigChangeListener$Companion$addListener$1 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f36890a;

    @x(a = i.a.ON_DESTROY)
    public final void onDestroy() {
        if (b.c().containsKey(Integer.valueOf(this.f36890a)) == false) goto L6;
        b.c().remove(Integer.valueOf(this.f36890a));
        return;
    }
}
