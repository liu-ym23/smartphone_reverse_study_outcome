package com.stepos.widget.internal;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.widget.R;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u0013\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0003\u0010\u000f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0011\u0010\u0012JI\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0003\u0010\u000f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0017\u0010\u0018JI\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0003\u0010\u000f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001f\u0010\bJ\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b!\u0010\bJ\u001f\u0010'\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0014H\u0000¢\u0006\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/stepos/widget/internal/HotspotRipple;", "", "<init>", "()V", "Landroid/view/View;", "view", "LY8/t;", "markPressScaleTarget", "(Landroid/view/View;)V", "Landroid/content/Context;", "context", "", "color", "", "cornerRadiusPx", "fadeRadiusPx", "Landroid/graphics/drawable/Drawable;", "create$StepOSWidget_release", "(Landroid/content/Context;IFF)Landroid/graphics/drawable/Drawable;", "create", "", "preserveOutline", "pressScale", "install$StepOSWidget_release", "(Landroid/view/View;IFZZF)V", W4.b.STEP_INSTALL, "Landroid/view/ViewGroup;", "parent", "installOnComposite$StepOSWidget_release", "(Landroid/view/ViewGroup;IFZZF)V", "installOnComposite", "applyPressScale$StepOSWidget_release", "applyPressScale", "clearPressScale$StepOSWidget_release", "clearPressScale", Parameters.ROOT, x5.d.EXTRA_ENABLED, "setPressScaleEnabled$StepOSWidget_release", "(Landroid/view/View;Z)V", "setPressScaleEnabled", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HotspotRipple {
    public static final HotspotRipple INSTANCE = new HotspotRipple();

    private HotspotRipple() {
    }

    public static /* synthetic */ Drawable create$StepOSWidget_release$default(HotspotRipple hotspotRipple, Context context, int i10, float f10, float f11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            f10 = 0.0f;
        }
        if ((i11 & 8) != 0) {
            f11 = 0.0f;
        }
        return hotspotRipple.create$StepOSWidget_release(context, i10, f10, f11);
    }

    public static /* synthetic */ void install$StepOSWidget_release$default(HotspotRipple hotspotRipple, View view, int i10, float f10, boolean z10, boolean z11, float f11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            f10 = 0.0f;
        }
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        if ((i11 & 16) != 0) {
            z11 = true;
        }
        if ((i11 & 32) != 0) {
            f11 = 0.0f;
        }
        hotspotRipple.install$StepOSWidget_release(view, i10, f10, z10, z11, f11);
    }

    public static /* synthetic */ void installOnComposite$StepOSWidget_release$default(HotspotRipple hotspotRipple, ViewGroup viewGroup, int i10, float f10, boolean z10, boolean z11, float f11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            f10 = 0.0f;
        }
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        if ((i11 & 16) != 0) {
            z11 = true;
        }
        if ((i11 & 32) != 0) {
            f11 = 0.0f;
        }
        hotspotRipple.installOnComposite$StepOSWidget_release(viewGroup, i10, f10, z10, z11, f11);
    }

    private final void markPressScaleTarget(View view) {
        view.setTag(R.id.stepos_tag_press_scale, Boolean.TRUE);
    }

    public final void applyPressScale$StepOSWidget_release(View view) {
        p.i(view, "view");
        markPressScaleTarget(view);
        view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(view.getContext(), R.animator.stepos_button_press));
    }

    public final void clearPressScale$StepOSWidget_release(View view) {
        p.i(view, "view");
        view.setStateListAnimator(null);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
    }

    public final Drawable create$StepOSWidget_release(Context context, int color, float cornerRadiusPx, float fadeRadiusPx) throws Resources.NotFoundException {
        p.i(context, "context");
        Resources resources = context.getResources();
        return new HotspotRippleDrawable(color, resources.getInteger(R.integer.stepos_hotspot_ripple_enter_duration), resources.getInteger(R.integer.stepos_hotspot_ripple_exit_duration), Math.max(0.0f, fadeRadiusPx), Math.max(0.0f, cornerRadiusPx), 1.0f - (C5685n.n(resources.getInteger(R.integer.stepos_hotspot_ripple_fade_percent), 0, 100) / 100.0f));
    }

    public final void install$StepOSWidget_release(View view, int color, float cornerRadiusPx, boolean preserveOutline, boolean pressScale, float fadeRadiusPx) {
        p.i(view, "view");
        Context context = view.getContext();
        p.h(context, "getContext(...)");
        view.setForeground(create$StepOSWidget_release(context, color, cornerRadiusPx, fadeRadiusPx));
        if (!preserveOutline) {
            view.setOutlineProvider(new RoundRectOutlineProvider(cornerRadiusPx));
        }
        view.setClipToOutline(true);
        if (!pressScale) {
            clearPressScale$StepOSWidget_release(view);
        } else {
            markPressScaleTarget(view);
            applyPressScale$StepOSWidget_release(view);
        }
    }

    public final void installOnComposite$StepOSWidget_release(ViewGroup parent, int color, float cornerRadiusPx, boolean preserveOutline, boolean pressScale, float fadeRadiusPx) {
        p.i(parent, "parent");
        parent.setAddStatesFromChildren(true);
        install$StepOSWidget_release(parent, color, cornerRadiusPx, preserveOutline, pressScale, fadeRadiusPx);
    }

    public final void setPressScaleEnabled$StepOSWidget_release(View root, boolean enabled) {
        p.i(root, "root");
        if (p.d(root.getTag(R.id.stepos_tag_press_scale), Boolean.TRUE)) {
            if (enabled) {
                applyPressScale$StepOSWidget_release(root);
            } else {
                clearPressScale$StepOSWidget_release(root);
            }
        }
        if (root instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) root;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                p.h(childAt, "getChildAt(...)");
                setPressScaleEnabled$StepOSWidget_release(childAt, enabled);
            }
        }
    }
}
