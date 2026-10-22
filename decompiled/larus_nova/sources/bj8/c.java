package bj8;

import com.larus.bmhome.chat.api.q0;
import kc8.y;

/* JADX INFO: loaded from: classes26.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc8.b f19250a;

    @Override // bj8.b
    public final boolean p() {
        kc8.b r100 = this.f19250a;
        if (r100 == null) goto L9;
        y r101 = r100.f502425a;
        if (r101 == null) goto L9;
        q0 r102 = r101.f502643x;
        if (r102 == null) goto L9;
        Integer r103 = r102.I7();
    L10:
        if (r103 == null) goto L12;
        return true;
    L12:
        return false;
    L9:
        r103 = null;
        goto L10
    }

    public c(kc8.b r100) {
        this.f19250a = r100;
    }
}
