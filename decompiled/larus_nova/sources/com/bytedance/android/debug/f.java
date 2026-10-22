package com.bytedance.android.debug;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetsUtils;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class f extends com.bytedance.android.livesdk.gift.platform.business.effect.assets.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DebugGiftPreviewDebugWidget f42619a;

    public f(DebugGiftPreviewDebugWidget r100) {
        this.f42619a = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void a(long r100) {
        ToastUtil.b("特效资源下载任务被取消", 0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onFailed(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        ToastUtil.b("获取特效资源本地路径失败", 0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void c(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "path");
        DebugGiftPreviewDebugWidget r102 = this.f42619a;
        FrameLayout r103 = r102.f42583i;
        if (r103 == null) goto L37;
        l r104 = r102.f42584j;
        if (r104 == null) goto L38;
        Object r105 = r102.context;
        boolean r106 = AssetsUtils.f129072b;
        Intrinsics.checkNotNullParameter(r101, "filePath");
        View r107 = null;
        if (StringsKt.endsWith$default(r101, '/', false, 2, null) == false) goto L9;
        r101 = r101.substring(0, r101.length() - 1);
    L9:
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "videoContainer");
        Intrinsics.checkNotNullParameter(r101, "filePath");
        r104.f42627a = r103;
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r104.f42628b == null) goto L12;
    L31:
        ITextureViewPlayerController r108 = r104.f42628b;
        if (r108 == null) goto L39;
        View r109 = r108.getAlphaView();
        if (r109 == null) goto L40;
        r109.postDelayed(new m(r104, r101), 1000);
        return;
    L40:
        return;
    L39:
        return;
    L12:
        if ((r105 instanceof FragmentActivity) == false) goto L31;
        ITextureViewPlayerController r110 = ((IGiftService) com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class)).giftPlayControllerManager().createTextureViewPlayer((LifecycleOwner) r105);
        r104.f42628b = r110;
        if (r110 == null) goto L16;
        r110.setPlayerActionListener(r104.f42629c);
    L16:
        ITextureViewPlayerController r111 = r104.f42628b;
        if (r111 == null) goto L26;
        View r112 = r111.getAlphaView();
        if (r112 == null) goto L26;
        ViewParent r113 = r112.getParent();
        if (r113 == null) goto L26;
        ViewGroup r114 = (ViewGroup) r113;
        ITextureViewPlayerController r115 = r104.f42628b;
        if (r115 == null) goto L25;
        r107 = r115.getAlphaView();
    L25:
        r114.removeView(r107);
    L26:
        FrameLayout r116 = r104.f42627a;
        if (r116 == null) goto L31;
        ITextureViewPlayerController r117 = r104.f42628b;
        if (r117 == null) goto L31;
        r117.attachAlphaView(r116);
        goto L31
    L38:
        return;
    }
}
