package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformMgAudienceServiceImpl;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/toolbar/MiniGameDetailPageDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniGameDetailPageDialog extends CommonStandardBottomDialog {
    public wo0.a B;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_open_platform_mg_game_detail_layout;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        throw null;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        System.currentTimeMillis();
        OpenPlatformMgAudienceServiceImpl.Companion.getClass();
        po0.a.b r101 = (po0.a.b) OpenPlatformMgAudienceServiceImpl.access$getDiComponent$cp();
        r101.getClass();
        wo0.a r102 = r101.f530020a.f530025f.get();
        this.B = r102;
        if (r102 == null) goto L5;
        r102.a();
    L5:
        Intrinsics.checkNotNullParameter(xs2.b.a().b(h1.class).subscribe(new c(this), d.f85345a), "$this$autoDispose");
        throw null;
    }
}
