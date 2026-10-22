package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.manager.impl.ee;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppFunctionSkillUi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20482a = null;

    static {
        f20482a = new a();
    }

    private a() {
    }

    public final void a(SimpleDraweeView r7, String r8, float r9) {
        SimpleDraweeView r10 = (SimpleDraweeView) ZeusTransformUtils.wrapperContextForParams(r7, SimpleDraweeView.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "imageView");
        if (r8 == null) goto L5;
        String r11 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L6:
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        float r12 = r9 * ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getDisplayMetrics().density;
        GenericDraweeHierarchy r2 = new GenericDraweeHierarchyBuilder(ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin")).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).setPlaceholderImage(ZeusTransformUtils.mapRes(R.drawable.skill_default_logo, "drawable", "skill_default_logo"), ScalingUtils.ScaleType.CENTER_INSIDE).setRoundingParams(RoundingParams.fromCornersRadius(r12)).build();
        r10.setController(null);
        r10.setHierarchy((DraweeHierarchy) ZeusTransformUtils.preCheckCast(r2, DraweeHierarchy.class, "com.obric.aiagent.plugin"));
        r10.setTag(new b(r11, r12));
        Drawable r6 = a(r10, r11);
        if (r6 != null) goto L11;
        return;
    L11:
        r2.setImage(r6, 1.0f, true);
        return;
    L5:
        r11 = null;
        goto L6
    }

    private final Drawable a(SimpleDraweeView r4, String r5) {
        SimpleDraweeView r3 = (SimpleDraweeView) ZeusTransformUtils.wrapperContextForParams(r4, SimpleDraweeView.class, "com.obric.aiagent.plugin");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L10;
        return null;
    L10:
        PackageManager r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageManager();     // Catch: Exception -> L7
        return r6.getApplicationInfo(r5, 0).loadIcon(r6);
    L7:
        e = move-exception;
        ee.f19808a.c("SkillManager", "Failed to load AppFunction application icon", "Failed to load AppFunction application icon: packageName=" + r5 + ", error=" + e.getMessage());
        return null;
    }
}
