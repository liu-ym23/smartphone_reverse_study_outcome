package com.stepos.alphame.utils;

import android.view.View;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.stepos.alphame.suggest.AppSuggestStorable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003¨\u0006\u0007"}, d2 = {"setItemViewPadding", "", AppSuggestStorable.COLUMN_POSITION, "", "view", "Landroid/view/View;", MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE, "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RecyclerViewAdapterKt {
    public static final void setItemViewPadding(int i4, @NotNull View view, int i5) {
        Intrinsics.checkNotNullParameter(view, "view");
        AlphaMeLogger.debugLog("Personal", "position " + i4 + " size " + i5);
        if (i5 == 1 && i4 == 0) {
            ViewKt.setAlonePadding(view);
        }
        if (i5 == 2 && i4 == 0) {
            ViewKt.setHeadPadding(view);
        } else if (i5 == 2 && i4 == 1) {
            ViewKt.setFootPadding(view);
        }
        if (i5 >= 3) {
            for (int i6 = 0; i6 < i5; i6++) {
                if (i4 == 0) {
                    ViewKt.setHeadPadding(view);
                } else if (i4 == i5 - 1) {
                    ViewKt.setFootPadding(view);
                } else {
                    ViewKt.setMiddlePadding(view);
                }
            }
        }
    }
}
