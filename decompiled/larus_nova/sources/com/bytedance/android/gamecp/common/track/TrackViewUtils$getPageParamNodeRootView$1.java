package com.bytedance.android.gamecp.common.track;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class TrackViewUtils$getPageParamNodeRootView$1 extends FunctionReferenceImpl implements Function1<View, Boolean> {
    public TrackViewUtils$getPageParamNodeRootView$1(TrackViewUtils r100) {
        super(1, r100, TrackViewUtils.class, "hasPageParamNode", "hasPageParamNode(Landroid/view/View;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(View r100) {
        TrackViewUtils r101 = (TrackViewUtils) this.receiver;
        WeakHashMap<View, WeakReference<View>> r102 = TrackViewUtils.f56771a;
        r101.getClass();
        if (r100 == null) goto L5;
        Object r103 = r100.getTag(R.id.gamecp_view_tag_track_param_key);
    L6:
        if (r103 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r103 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(View r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
