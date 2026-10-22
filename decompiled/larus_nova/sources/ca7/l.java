package ca7;

import com.google.gson.JsonElement;

/* JADX INFO: loaded from: classes11.dex */
public final class l extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f22966c;

    @Override // ca7.c
    public final boolean b(da7.b r100) {
        return false;
    }

    public l(JsonElement r100) {
        this.f22966c = r100;
    }

    @Override // ca7.c
    public final void c(da7.b r100) {
        int r101 = this.f22957b;
        r100.f467699c = Math.max(r100.f467699c, r101);
        r100.f467701e.add(this);
    }
}
