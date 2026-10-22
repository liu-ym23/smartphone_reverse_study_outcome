package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA = null;

    @Override // android.util.Property
    public /* synthetic */ Float get(ViewGroup r3) {
        return get2((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.util.Property
    public /* synthetic */ void set(ViewGroup r3, Float r4) {
        set2((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin"), (Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin"));
    }

    static {
        CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");
    }

    private ChildrenAlphaProperty(String r2) {
        super(Float.class, r2);
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Float get2(ViewGroup r3) {
        Float r2 = (Float) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.mtrl_internal_children_alpha_tag, DbHelper.COL_ID, "mtrl_internal_children_alpha_tag")), Float.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        return r2;
    L6:
        return Float.valueOf(1.0f);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(ViewGroup r3, Float r4) {
        float r2 = r4.floatValue();
        r3.setTag(ZeusTransformUtils.mapRes(R.id.mtrl_internal_children_alpha_tag, DbHelper.COL_ID, "mtrl_internal_children_alpha_tag"), Float.valueOf(r2));
        int r5 = r3.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        r3.getChildAt(r0).setAlpha(r2);
        r0 = r0 + 1;
        goto L3
    }
}
