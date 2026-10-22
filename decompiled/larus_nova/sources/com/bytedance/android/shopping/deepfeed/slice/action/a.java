package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f173396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, ? extends Object> f173397b;

    public a() {
    }

    public abstract boolean d(IAction r100, View r101);

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.v
    public void dispose() {
        v r100 = this.f173396a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f173396a = null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.v
    public final void a(v r100) {
        Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_NEXT);
        this.f173396a = r100;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.v
    public void b(Map r100) {
        this.f173397b = r100;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.v
    public boolean m(final IAction r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        if (this.f173397b != null) goto L5;
        IAction r102 = r100;
    L13:
        if (r100.getDisable() == false) goto L15;
    L17:
        v r103 = this.f173396a;
        if (r103 != null) goto L20;
        return true;
    L20:
        return r103.m(r100, r101);
    L15:
        if (d(r102, r101) == false) goto L17;
        return true;
    L5:
        final LinkedHashMap r104 = new LinkedHashMap();
        Map<String, Object> r105 = r100.getParams();
        if (r105 == null) goto L8;
        r104.putAll(r105);
    L8:
        Map<String, ? extends Object> r106 = this.f173397b;
        if (r106 == null) goto L11;
        r104.putAll(r106);
    L11:
        r102 = new AbsDeepFeedAction$mergeData$3(r100, r104);
        goto L13
    }
}
