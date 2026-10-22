package com.bytedance.ai.widget.contianer;

import android.app.Activity;
import android.view.View;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class h implements k2.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, Object> f38008a;

    public h() {
    }

    public abstract boolean f();

    public abstract Activity getActivity();

    public abstract String h(String r100);

    public abstract String j();

    public abstract m k();

    public abstract String l();

    public abstract void m();

    public abstract void o(m r100);

    public boolean g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (Intrinsics.areEqual(realView(), r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(engineView(), r100) == true) goto L8;
        return false;
    }
}
