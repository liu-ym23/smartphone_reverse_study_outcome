package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.animation.ValueAnimator;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import he3.n0;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/vh/DeepFeedProductSlcWithAnimVH;", "Lcom/bytedance/android/shopping/deepfeed/ui/vh/DeepFeedProductSlcVH;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductSlcWithAnimVH extends DeepFeedProductSlcVH {
    public static final /* synthetic */ int H0 = 0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public ValueAnimator f173814p0;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductSlcWithAnimVH f173815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f173816b;

        public b(DeepFeedProductSlcWithAnimVH r100, int r101) {
            this.f173815a = r100;
            this.f173816b = r101;
        }

        public final void a() {
            DeepFeedProductSlcWithAnimVH r100 = this.f173815a;
            int r101 = DeepFeedProductSlcWithAnimVH.H0;
            r100.getClass();
            throw null;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductSlcWithAnimVH f173817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f173818b;

        public c(DeepFeedProductSlcWithAnimVH r100, int r101) {
            this.f173817a = r100;
            this.f173818b = r101;
        }

        public final void a() {
            DeepFeedProductSlcWithAnimVH r100 = this.f173817a;
            int r101 = DeepFeedProductSlcWithAnimVH.H0;
            if (r100.getAdapterPosition() <= r100.i4().curNoFullScreenCount()) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L8;
            return;
        L8:
            r100.getClass();
            throw null;
        L5:
            r102 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductSlcVH, com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void q4() {
        ValueAnimator r100 = this.f173814p0;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f173814p0 = null;
        super.q4();
    }

    public final int J4() {
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductSlcVH
    public final void E4(InFeedProductV2 r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        int r101 = r100.getDynamicData().f484846h;
        super.E4(r100);
        if (r101 != 2) goto L5;
        J4();
        throw null;
    L5:
        if (r101 != 3) goto L7;
        int r102 = J4();
        if (getAdapterPosition() <= i4().curNoFullScreenCount()) goto L17;
        boolean r103 = true;
    L18:
        if (r103 == false) goto L20;
        new c(this, r102);
        throw null;
    L20:
        throw null;
    L17:
        r103 = false;
        goto L18
    L7:
        if (r101 == 6) goto L13;
        if (r101 == 4) goto L25;
        r100.getDynamicData().f484846h = 1;
        return;
    L25:
        return;
    L13:
        throw null;
    }

    public final void K4(float r100) {
        InFeedProductV2 r101 = this.f173751m;
        if (r101 == null) goto L10;
        n0 r102 = r101.slcCard();
        if (r102 == null) goto L11;
        com.bytedance.android.shopping.deepfeed.slice.c r103 = r102.f484836d;
        if (r103 == null) goto L12;
        r103.a(MapsKt.mapOf(TuplesKt.to("bottom_panel_translate_y", Float.valueOf(r100))));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductSlcVH, com.bytedance.jedi.ext.adapter.JediSimpleViewHolder
    public final /* bridge */ /* synthetic */ void a4(InFeedProductV2 r100) {
        E4(r100);
    }
}
