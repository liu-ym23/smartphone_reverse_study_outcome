package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class DrawableAlphaProperty extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> DRAWABLE_ALPHA_COMPAT = null;
    private final WeakHashMap<Drawable, Integer> alphaCache;

    @Override // android.util.Property
    public /* synthetic */ Integer get(Drawable r3) {
        return get2((Drawable) ZeusTransformUtils.preCheckCast(r3, Drawable.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.util.Property
    public /* synthetic */ void set(Drawable r3, Integer r4) {
        set2((Drawable) ZeusTransformUtils.preCheckCast(r3, Drawable.class, "com.obric.aiagent.plugin"), (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin"));
    }

    static {
        DRAWABLE_ALPHA_COMPAT = new DrawableAlphaProperty();
    }

    private DrawableAlphaProperty() {
        super(Integer.class, "drawableAlphaCompat");
        this.alphaCache = new WeakHashMap();
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Integer get2(Drawable r3) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Integer.valueOf(r3.getAlpha());
    L7:
        if (this.alphaCache.containsKey(r3) == false) goto L11;
        return (Integer) ZeusTransformUtils.preCheckCast(this.alphaCache.get(r3), Integer.class, "com.obric.aiagent.plugin");
    L11:
        return 255;
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(Drawable r3, Integer r4) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        this.alphaCache.put(r3, r4);
    L5:
        r3.setAlpha(r4.intValue());
    }
}
