package b94;

import android.content.Context;

/* JADX INFO: loaded from: classes11.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18246a;

    public boolean b() {
        return this instanceof c.g;
    }

    public boolean c() {
        return !b();
    }

    public b(String r100) {
        this.f18246a = r100;
    }

    public String a(Context r100) {
        if (c() == true) goto L7;
        return "";
    L7:
        throw new RuntimeException("user definable permission must override getPermissionName()");
    }
}
