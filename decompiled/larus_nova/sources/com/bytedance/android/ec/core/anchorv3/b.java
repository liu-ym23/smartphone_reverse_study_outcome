package com.bytedance.android.ec.core.anchorv3;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.track.TrackerProvider;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {
    public static final void a(com.bytedance.android.ec.core.event.a r100, Context r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$postWithBase");
        TrackerProvider.a r103 = TrackerProvider.Companion;
        if (r101 == null) goto L10;
        Activity r104 = d0.f165305a.getActivity(r101);
        if ((r104 instanceof FragmentActivity) == true) goto L8;
        r104 = null;
    L8:
        FragmentActivity r105 = (FragmentActivity) r104;
        if (r105 == null) goto L10;
        Object r106 = ((TrackerProvider) ViewModelProviders.of(r105).get(TrackerProvider.class)).getTracker();
        if ((r106 instanceof com.bytedance.android.shopping.anchorv3.track.a) == true) goto L14;
        r106 = null;
    L14:
        com.bytedance.android.shopping.anchorv3.track.a r107 = (com.bytedance.android.shopping.anchorv3.track.a) r106;
    L15:
        if (r107 == null) goto L17;
        r107.a(r100, r102);
    L17:
        r100.post(null, null);
        return;
    L10:
        r107 = null;
        goto L15
    }
}
