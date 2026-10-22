package com.bumptech.glide.load.resource.b;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.v;

/* JADX INFO: compiled from: NonOwnedDrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
final class c extends b<Drawable> {
    @Override // com.bumptech.glide.load.engine.v
    public void f() {
    }

    static v<Drawable> a(Drawable r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new c(r1);
    }

    private c(Drawable r1) {
        super(r1);
    }

    @Override // com.bumptech.glide.load.engine.v
    public Class<Drawable> c() {
        return this.f3778a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.v
    public int e() {
        return Math.max(1, (this.f3778a.getIntrinsicWidth() * this.f3778a.getIntrinsicHeight()) * 4);
    }
}
