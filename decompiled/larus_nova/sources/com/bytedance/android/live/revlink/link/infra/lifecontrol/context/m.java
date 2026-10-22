package com.bytedance.android.live.revlink.link.infra.lifecontrol.context;

/* JADX INFO: loaded from: classes47.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f98705a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == true) goto L6;
        return false;
    L6:
        if (this.f98705a == ((m) r100).f98705a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f98705a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "SwitchSceneEvent(resetData=" + this.f98705a + ")";
    }

    public m(boolean r100) {
        this.f98705a = r100;
    }
}
