package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class p implements com.bytedance.android.scope.o, dy0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, Integer> f131681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f131682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f131683c;

    public static final class a implements IAssetsManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f131684a;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void a() {
        }

        public a(p r100) {
            this.f131684a = r100;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void b(List<? extends com.bytedance.android.live.core.resources.e> r100) {
            Intrinsics.checkNotNullParameter(r100, "assetsModels");
            if (com.bytedance.android.livesdk.gift.platform.business.effect.a.b() == true) goto L5;
            return;
        L5:
            if (((HashMap) this.f131684a.f131681a).isEmpty() == true) goto L23;
            Iterator<T> r101 = r100.iterator();
        L9:
            if (r101.hasNext() == false) goto L24;
            long r102 = ((com.bytedance.android.live.core.resources.e) r101.next()).getId();
            if (((HashMap) this.f131684a.f131681a).keySet().contains(Long.valueOf(r102)) == false) goto L9;
            p r103 = this.f131684a;
            Map<Long, Integer> r104 = r103.f131681a;
            HashMap r105 = (HashMap) r104;
            Integer r106 = (Integer) r105.get(Long.valueOf(r102));
            if (r106 == null) goto L15;
            int r107 = r106.intValue();
        L16:
            r103.f(r102, r107);
            goto L9
        L15:
            r107 = 1008;
            goto L16
        L24:
            return;
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    public p() {
        this.f131681a = new HashMap();
        this.f131683c = new a(this);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.b() == false) goto L11;
        IGiftService r100 = (IGiftService) jc1.k.f(IGiftService.class);
        if (r100 == null) goto L9;
        IAssetsManager r101 = r100.mo8235getAssetsManager();
        if (r101 == null) goto L9;
        r101.l0(this.f131683c);
    L9:
        ((HashMap) this.f131681a).clear();
        this.f131682b = false;
        return;
    }

    public final void a(long r100, int r101) {
        if (this.f131682b == false) goto L6;
    L13:
        Map<Long, Integer> r102 = this.f131681a;
        HashMap r103 = (HashMap) r102;
        r103.put(Long.valueOf(r100), Integer.valueOf(r101));
        return;
    L6:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.b() == false) goto L13;
        IGiftService r104 = (IGiftService) jc1.k.f(IGiftService.class);
        if (r104 == null) goto L12;
        IAssetsManager r105 = r104.mo8235getAssetsManager();
        if (r105 == null) goto L12;
        r105.T(this.f131683c);
    L12:
        this.f131682b = true;
        goto L13
    }

    public final void f(long r100, int r101) {
        Intrinsics.checkNotNullParameter("JSB", "source");
        IGiftService r102 = (IGiftService) jc1.k.f(IGiftService.class);
        if (r102 == null) goto L6;
        r102.downloadAssets("JSB", r100, new o(this), r101);
        return;
    }
}
