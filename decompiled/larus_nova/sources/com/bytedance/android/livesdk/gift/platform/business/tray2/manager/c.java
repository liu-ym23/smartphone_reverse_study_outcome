package com.bytedance.android.livesdk.gift.platform.business.tray2.manager;

import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.k;
import com.bytedance.android.livesdk.gift.platform.business.effect.utils.VideoGiftLinkMonitor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements k.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f130394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EffectMessage f130395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.core.resources.e f130396c;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void a(List<k.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "assetsResult");
        d r101 = this.f130394a;
        EffectMessage r102 = this.f130395b;
        r101.getClass();
        d.m("特效资源下载任务被取消", r102);
        this.f130395b.a(7, com.bytedance.live.kmp.util.e.b());
        d r103 = this.f130394a;
        r103.o(this.f130395b, r103.f130399k);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void b(boolean r100) {
        if (r100 == false) goto L7;
        EffectMessage r101 = this.f130395b;
        if (r101.I != (-1)) goto L11;
        r101.I = 1;
        return;
    L11:
        return;
    L7:
        EffectMessage r102 = this.f130395b;
        if (r102.I != (-1)) goto L13;
        r102.I = 0;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void onFailed(Throwable r100) {
        d r101 = this.f130394a;
        EffectMessage r102 = this.f130395b;
        r101.getClass();
        d.m("获取特效资源本地路径失败", r102);
        EffectMessage r103 = this.f130395b;
        r103.f126020d = "";
        r103.a(7, com.bytedance.live.kmp.util.e.b());
        d r104 = this.f130394a;
        r104.o(this.f130395b, r104.f130398j);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void onResult(List<k.a> r110) {
        Intrinsics.checkNotNullParameter(r110, "assetsResult");
        EffectMessage r100 = this.f130395b;
        if (r100.f126021e != null) goto L5;
        r100.f126021e = new LinkedHashMap();
    L5:
        Iterator<k.a> r111 = r110.iterator();
    L7:
        if (r111.hasNext() == false) goto L12;
        k.a r101 = r111.next();
        if (r101.f129104a != this.f130396c.getId()) goto L11;
        EffectMessage r102 = this.f130395b;
        r102.f126020d = r101.f129105b;
        r102.f126022f = r101.f129107d;
    L11:
        this.f130395b.f126021e.put(Long.valueOf(r101.f129104a), new iy1.a(r101.f129105b, r101.f129107d));
        goto L7
    L12:
        VideoGiftLinkMonitor.Event r103 = VideoGiftLinkMonitor.Event.load_resource_success;
        EffectMessage r112 = this.f130395b;
        VideoGiftLinkMonitor.a(r103, r112.f126017a, r112.f126028l, r112.f126018b);
        this.f130395b.a(7, com.bytedance.live.kmp.util.e.b());
        d r113 = this.f130394a;
        r113.o(this.f130395b, r113.f130397i);
    }

    public c(d r100, EffectMessage r101, com.bytedance.android.live.core.resources.e r102) {
        this.f130394a = r100;
        this.f130395b = r101;
        this.f130396c = r102;
    }
}
