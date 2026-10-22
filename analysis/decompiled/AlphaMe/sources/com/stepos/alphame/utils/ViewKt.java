package com.stepos.alphame.utils;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m2.o;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0003\u001a\f\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\t\u001a\f\u0010\n\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u000b\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u000b\u001a\u00020\u0001*\u0004\u0018\u00010\u0003¨\u0006\f"}, d2 = {"gone", "", "Landroid/view/View;", "Landroid/view/ViewGroup;", "setAlonePadding", "setFootPadding", "setHeadPadding", "setMarginTop", ViewTweenItem.TOP, "", "setMiddlePadding", MapBundleKey.MapObjKey.OBJ_SL_VISI, "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ViewKt {
    public static final void gone(@Nullable View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public static final void setAlonePadding(@Nullable View view) {
        if (view != null) {
            view.setPadding(view.getPaddingLeft(), (int) o.c(view.getContext(), 8.0f), view.getPaddingRight(), (int) o.c(view.getContext(), 8.0f));
            view.setBackground(androidx.core.content.a.b(view.getContext(), R.drawable.immersive_item_bkg_alone));
        }
    }

    public static final void setFootPadding(@Nullable View view) {
        if (view != null) {
            AlphaMeLogger.debugLog("Personal", "setFootPadding");
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), (int) o.c(view.getContext(), 8.0f));
            view.setBackground(androidx.core.content.a.b(view.getContext(), R.drawable.immersive_item_bkg_foot));
        }
    }

    public static final void setHeadPadding(@Nullable View view) {
        if (view != null) {
            AlphaMeLogger.debugLog("Personal", "setHeadPadding");
            view.setPadding(view.getPaddingLeft(), (int) o.c(view.getContext(), 8.0f), view.getPaddingRight(), view.getPaddingBottom());
            view.setBackground(androidx.core.content.a.b(view.getContext(), R.drawable.immersive_item_bkg_head));
        }
    }

    public static final void setMarginTop(@Nullable View view, int i4) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, i4, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static final void setMiddlePadding(@Nullable View view) {
        if (view != null) {
            AlphaMeLogger.debugLog("Personal", "setMiddlePadding");
            view.setBackground(androidx.core.content.a.b(view.getContext(), R.drawable.immersive_item_bkg_middle));
        }
    }

    public static final void visible(@Nullable View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    public static final void gone(@Nullable ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public static final void visible(@Nullable ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(0);
    }
}
