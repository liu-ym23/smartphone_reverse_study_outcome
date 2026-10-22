package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class DrawableAlphaProperty extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> DRAWABLE_ALPHA_COMPAT = null;
    private final WeakHashMap<Drawable, Integer> alphaCache;

    static {
        DRAWABLE_ALPHA_COMPAT = new DrawableAlphaProperty();
    }

    private DrawableAlphaProperty() {
        super(Integer.class, "drawableAlphaCompat");
        this.alphaCache = new WeakHashMap();
    }

    @Override // android.util.Property
    @Nullable
    public /* bridge */ /* synthetic */ Integer get(@NonNull Drawable r10) {
        return get2(r10);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull Drawable r10, @NonNull Integer r11) {
        set2(r10, r11);
    }

    @Nullable
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Integer get2(@NonNull Drawable r10) {
        return Integer.valueOf(r10.getAlpha());
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(@NonNull Drawable r10, @NonNull Integer r11) {
        r10.setAlpha(r11.intValue());
    }
}
