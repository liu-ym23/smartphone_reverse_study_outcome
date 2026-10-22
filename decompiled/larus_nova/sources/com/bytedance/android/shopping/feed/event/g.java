package com.bytedance.android.shopping.feed.event;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.shopping.track.TrackerProvider;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g {
    public static final void b(com.bytedance.android.ec.core.event.a r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$buildWithBaseParams");
        TrackerProvider.a r102 = TrackerProvider.Companion;
        o1 r103 = null;
        Object r104 = null;
        r103 = null;
        if (r101 == null) goto L16;
        Activity r105 = com.bytedance.android.shopping.anchorv3.utils.d0.f165305a.getActivity(r101);
        if ((r105 instanceof FragmentActivity) == true) goto L8;
        r105 = null;
    L8:
        FragmentActivity r106 = (FragmentActivity) r105;
        if (r106 == null) goto L16;
        Object r107 = ((TrackerProvider) ViewModelProviders.of(r106).get(TrackerProvider.class)).getTracker();
        if ((r107 instanceof o1) == false) goto L15;
        r104 = r107;
    L15:
        r103 = (o1) r104;
    L16:
        if (r103 == null) goto L19;
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.appendBaseParams(r103.f174841a);
        return;
    }

    public static final void d(com.bytedance.android.ec.core.event.a r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$postWithBaseParams");
        TrackerProvider.a r102 = TrackerProvider.Companion;
        if (r101 == null) goto L10;
        Activity r103 = com.bytedance.android.shopping.anchorv3.utils.d0.f165305a.getActivity(r101);
        if ((r103 instanceof FragmentActivity) == true) goto L8;
        r103 = null;
    L8:
        FragmentActivity r104 = (FragmentActivity) r103;
        if (r104 == null) goto L10;
        Object r105 = ((TrackerProvider) ViewModelProviders.of(r104).get(TrackerProvider.class)).getTracker();
        if ((r105 instanceof o1) == true) goto L14;
        r105 = null;
    L14:
        o1 r106 = (o1) r105;
    L15:
        if (r106 == null) goto L17;
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.appendBaseParams(r106.f174841a);
    L17:
        r100.post(null, null);
        return;
    L10:
        r106 = null;
        goto L15
    }

    public static final void a(com.bytedance.android.ec.core.event.a r100, Context r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$buildWithBase");
        TrackerProvider.a r103 = TrackerProvider.Companion;
        o1 r104 = null;
        Object r105 = null;
        r104 = null;
        if (r101 == null) goto L16;
        Activity r106 = com.bytedance.android.shopping.anchorv3.utils.d0.f165305a.getActivity(r101);
        if ((r106 instanceof FragmentActivity) == true) goto L8;
        r106 = null;
    L8:
        FragmentActivity r107 = (FragmentActivity) r106;
        if (r107 == null) goto L16;
        Object r108 = ((TrackerProvider) ViewModelProviders.of(r107).get(TrackerProvider.class)).getTracker();
        if ((r108 instanceof o1) == false) goto L15;
        r105 = r108;
    L15:
        r104 = (o1) r105;
    L16:
        if (r104 == null) goto L19;
        r104.a(r100, r102);
        return;
    }

    public static final void c(com.bytedance.android.ec.core.event.a r100, Context r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$postWithBase");
        TrackerProvider.a r103 = TrackerProvider.Companion;
        if (r101 == null) goto L10;
        Activity r104 = com.bytedance.android.shopping.anchorv3.utils.d0.f165305a.getActivity(r101);
        if ((r104 instanceof FragmentActivity) == true) goto L8;
        r104 = null;
    L8:
        FragmentActivity r105 = (FragmentActivity) r104;
        if (r105 == null) goto L10;
        Object r106 = ((TrackerProvider) ViewModelProviders.of(r105).get(TrackerProvider.class)).getTracker();
        if ((r106 instanceof o1) == true) goto L14;
        r106 = null;
    L14:
        o1 r107 = (o1) r106;
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
