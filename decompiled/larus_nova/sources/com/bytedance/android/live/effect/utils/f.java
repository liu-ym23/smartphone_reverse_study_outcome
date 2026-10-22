package com.bytedance.android.live.effect.utils;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f68869a = 0;

    public interface a {
        void a(Sticker r100);

        void b(ExceptionResult r100);
    }

    public f() {
    }

    static {
    }

    public static void a(String r100, Sticker r101, com.bytedance.android.livesdk.revenue.service.effect.k.b r102) {
        EffectResourceUtil$tryDownloadSticker$1 r103 = EffectResourceUtil$tryDownloadSticker$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "sticker");
        Intrinsics.checkNotNullParameter(r103, "processAction");
        List<String> r104 = LiveEffectContext.f66734h;
        LiveEffectContextFactoryDelegate$Type r105 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        if (LiveEffectContext.a.a(r105).b().r().q(r101) == false) goto L5;
        r101.setDownloading(false);
        r101.setDownloaded(true);
        r102.a(r101);
        return;
    L5:
        r101.setDownloading(true);
        LiveEffectContext.a.a(r105).b().r().g(r100, r101, new g(r102, r103));
    }
}
