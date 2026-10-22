package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes3.dex */
public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA = null;

    static {
        CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");
    }

    private ChildrenAlphaProperty(String r10) {
        super(Float.class, r10);
    }

    @Override // android.util.Property
    @NonNull
    public /* bridge */ /* synthetic */ Float get(@NonNull ViewGroup r10) {
        return get2(r10);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull ViewGroup r10, @NonNull Float r11) {
        set2(r10, r11);
    }

    @NonNull
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Float get2(@NonNull ViewGroup r10) {
        Float r11 = (Float) r10.getTag(R.id.mtrl_internal_children_alpha_tag);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return Float.valueOf(1.0f);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(@NonNull ViewGroup r10, @NonNull Float r11) {
        float r12 = r11.floatValue();
        r10.setTag(R.id.mtrl_internal_children_alpha_tag, r11);
        int r13 = r10.getChildCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r10.getChildAt(r14).setAlpha(r12);
        r14 = r14 + 1;
        goto L3
    }
}
