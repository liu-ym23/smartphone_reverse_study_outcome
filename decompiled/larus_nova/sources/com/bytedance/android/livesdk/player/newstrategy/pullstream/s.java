package com.bytedance.android.livesdk.player.newstrategy.pullstream;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.strategy.api.IStrategyService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class s implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f156004a = null;

    public static final class a implements e.a {
        public a() {
        }

        @Override // com.bytedance.android.livesdk.player.newstrategy.pullstream.e.a
        public final e create() {
            return new s();
        }
    }

    public static final class b {
    }

    public s() {
    }

    static {
        f156004a = new a();
    }

    @Override // com.bytedance.android.livesdk.player.newstrategy.pullstream.e
    public final void a(j r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "result");
        if (r100.f155969e.getTextureRenderMode() != 0) goto L19;
        IStrategyService r102 = (IStrategyService) jc1.k.f(IStrategyService.class);
        int r103 = 0;
        if (r102 == null) goto L10;
        LiveData r104 = IStrategyService.a.a(r102, "texture_render_mode", 0, false, 8);
        if (r104 == null) goto L10;
        Integer r105 = (Integer) r104.getValue();
        if (r105 == null) goto L10;
    L11:
        int r106 = r105.intValue();
        if (r106 != 1) goto L14;
        r103 = 1;
    L18:
        r101.f155998t = r103;
        ALogger.i("TRModeStrategyNode", "onStreamPreparePlay: textureRenderMode " + r101.f155998t);
        return;
    L14:
        if (r106 != 2) goto L18;
        r103 = 2;
    L10:
        r105 = -1;
        goto L11
    L19:
        ALogger.i("TRModeStrategyNode", "onStreamPreparePlay: textureRenderMode already has a value " + r100.f155969e.getTextureRenderMode());
    }
}
