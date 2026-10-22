package com.bytedance.android.live.effect.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements com.bytedance.android.live.effect.api.k.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.a f68870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f68871b;

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r100, Sticker r101) {
    }

    public g(f.a r100, Function1 r101) {
        this.f68870a = r100;
        this.f68871b = r101;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(String r100, Sticker r101) {
        if (r101 != null) goto L7;
        ALogger.d("ttlive_anchor_effect_ResourceUtil", "sticker download fail response: sticker: null");
        f.a r102 = this.f68870a;
        if (r102 == null) goto L11;
        r102.b(new ExceptionResult(new Exception("sticker is null")));
        return;
    L11:
        return;
    L7:
        ALogger.d("ttlive_anchor_effect_ResourceUtil", "sticker download success ^_^,response: sticker: " + r101.getId() + " path: " + r101.getUnzipPath());
        com.bytedance.android.live.effect.soundeffect.h.a(r101, LiveEffectContextFactoryDelegate$Type.DEFAULT);
        r101.setDownloading(false);
        r101.setDownloaded(true);
        f.a r103 = this.f68870a;
        if (r103 == null) goto L13;
        r103.a(r101);
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k.g
    public final void onProgress(int r100, long r101) {
        this.f68871b.invoke(Integer.valueOf(r100));
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r100, Sticker r101, ExceptionResult r102) {
        StringBuilder r103 = new StringBuilder("sticker download fail response: sticker: ");
        String r104 = null;
        if (r101 == null) goto L5;
        Long r105 = Long.valueOf(r101.getId());
    L6:
        r103.append(r105);
        r103.append(" path: ");
        if (r101 == null) goto L9;
        r104 = r101.getUnzipPath();
    L9:
        r103.append(r104);
        ALogger.d("ttlive_anchor_effect_ResourceUtil", r103.toString());
        if (r101 == null) goto L12;
        r101.setDownloading(false);
    L12:
        f.a r106 = this.f68870a;
        if (r106 == null) goto L16;
        r106.b(r102);
        return;
    L16:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
