package br1;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.OnTouchListener f20119a;

    public int a() {
        return 0;
    }

    public a(View.OnTouchListener r100) {
        Intrinsics.checkNotNullParameter(r100, "touchListener");
        this.f20119a = r100;
    }
}
