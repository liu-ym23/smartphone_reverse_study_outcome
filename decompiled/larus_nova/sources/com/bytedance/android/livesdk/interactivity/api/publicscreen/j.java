package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public interface j<T extends i, VH extends PSMessageViewHolder> {

    public static final class a {
        public static <T extends i, VH extends PSMessageViewHolder> void a(j<T, VH> r100, PSMessageViewHolder r101, i r102, int r103, g52.e r104) {
            Intrinsics.checkNotNullParameter(r101, "viewHolder");
            Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
            if (r102 == null) goto L10;
            if (r101 == null) goto L8;
            r100.b(r101, r102, r103, r104);
            return;
        L8:
            throw new IllegalArgumentException("Invalid type ".concat(r102.getClass().getName()));
        L10:
            throw new IllegalArgumentException("Invalid type ".concat(r102.getClass().getName()));
        }
    }

    PublicScreenConfig$ViewBinderType a();

    void b(VH r100, T r101, int r102, g52.e r103);

    VH c(LayoutInflater r100, ViewGroup r101, g52.c r102);

    void d(PSMessageViewHolder r100, i r101, int r102, g52.e r103);
}
