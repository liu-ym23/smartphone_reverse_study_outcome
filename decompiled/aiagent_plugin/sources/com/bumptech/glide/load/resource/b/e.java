package com.bumptech.glide.load.resource.b;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: UnitDrawableDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements k<Drawable, Drawable> {
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Drawable r1, i r2) {
        return true;
    }

    public e() {
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ v<Drawable> a(Drawable r3, int r4, int r5, i r6) {
        return a2((Drawable) ZeusTransformUtils.preCheckCast(r3, Drawable.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ boolean a(Drawable r3, i r4) {
        return a2((Drawable) ZeusTransformUtils.preCheckCast(r3, Drawable.class, "com.obric.aiagent.plugin"), r4);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public v<Drawable> a2(Drawable r1, int r2, int r3, i r4) {
        return c.a(r1);
    }
}
