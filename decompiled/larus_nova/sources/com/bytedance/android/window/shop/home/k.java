package com.bytedance.android.window.shop.home;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Runnable> f188232a;

    public final boolean a() {
        if (((ArrayList) this.f188232a).isEmpty() == false) goto L5;
        return false;
    L5:
        ((Runnable) ListProtector.remove(this.f188232a, 0)).run();
        return true;
    }

    public k() {
        this.f188232a = new ArrayList();
    }
}
