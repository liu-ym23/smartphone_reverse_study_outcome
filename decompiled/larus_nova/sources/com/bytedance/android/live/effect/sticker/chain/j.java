package com.bytedance.android.live.effect.sticker.chain;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.d0;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j implements m {
    public j() {
    }

    public static String b(String r100) {
        if (Intrinsics.areEqual(r100, d0.f66753c) == false) goto L6;
    L20:
        return "特效";
    L6:
        if (Intrinsics.areEqual(r100, d0.f66751a) == false) goto L9;
        return "滤镜";
    L9:
        if (Intrinsics.areEqual(r100, d0.f66761k) == false) goto L12;
        return "风格妆";
    L12:
        if (Intrinsics.areEqual(r100, d0.f66752b) == false) goto L15;
        return "手势魔法";
    L15:
        if (Intrinsics.areEqual(r100, d0.f66758h) == false) goto L18;
        return "互动特效";
    L18:
        if (Intrinsics.areEqual(r100, "live_camera_move") == false) goto L20;
        return "运镜";
    }

    @Override // com.bytedance.android.live.effect.sticker.chain.m
    public final void a(l r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        List<String> r101 = LiveEffectContext.f66734h;
        ILiveEffectComposerManager r102 = LiveEffectContext.a.a(r100.getType()).a();
        if (r102.U(r100.f68173f) <= 0) goto L10;
        Map<Long, String> r103 = r102.N(r100.f68173f);
        StringBuilder r104 = new StringBuilder("当前");
        Map.Entry r105 = (Map.Entry) CollectionsKt.firstOrNull(r103.entrySet());
        if (r105 == null) goto L8;
        String r106 = (String) r105.getValue();
        if (r106 == null) goto L8;
    L9:
        r104.append(b(r106));
        r104.append("不支持更换");
        r104.append(b(r100.f68173f));
        f2.c(r104.toString(), 0);
        Intrinsics.checkNotNullParameter("repel", "reason");
        r100.f68169b = false;
        return;
    L8:
        r106 = "";
        goto L9
    L10:
        r100.a();
    }
}
