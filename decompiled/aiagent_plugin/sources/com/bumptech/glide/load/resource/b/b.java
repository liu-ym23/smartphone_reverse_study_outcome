package com.bumptech.glide.load.resource.b;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.f.j;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<T extends Drawable> implements r, v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f3778a;

    @Override // com.bumptech.glide.load.engine.v
    public /* synthetic */ Object d() {
        return b();
    }

    public b(T r3) {
        this.f3778a = (T) ZeusTransformUtils.preCheckCast(j.a(r3), Drawable.class, "com.obric.aiagent.plugin");
    }

    public final T b() {
        Drawable.ConstantState r0 = this.f3778a.getConstantState();
        if (r0 != null) goto L7;
        return this.f3778a;
    L7:
        return (T) r0.newDrawable();
    }

    @Override // com.bumptech.glide.load.engine.r
    public void a() {
        if (ZeusTransformUtils.instanceOf(this.f3778a, BitmapDrawable.class) == false) goto L6;
        ((BitmapDrawable) ZeusTransformUtils.preCheckCast(this.f3778a, BitmapDrawable.class, "com.obric.aiagent.plugin")).getBitmap().prepareToDraw();
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(this.f3778a, GifDrawable.class) == false) goto L10;
        ((GifDrawable) ZeusTransformUtils.preCheckCast(this.f3778a, GifDrawable.class, "com.obric.aiagent.plugin")).getFirstFrame().prepareToDraw();
        return;
    }
}
