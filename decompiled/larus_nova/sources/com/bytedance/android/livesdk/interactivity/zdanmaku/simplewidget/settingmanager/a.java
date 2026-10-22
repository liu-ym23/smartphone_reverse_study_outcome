package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager;

import android.content.Context;
import com.bytedance.android.livesdk.interactivity.api.IBarrageService;
import com.bytedance.android.livesdkapi.barrage.ChangeSettingSource;
import com.bytedance.android.livesdkapi.service.IPreviewBarrageService;
import com.bytedance.android.livesdkapi.service.OpenParams;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements IPreviewBarrageService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f141799a = null;

    public a() {
    }

    static {
        f141799a = new a();
    }

    @Override // com.bytedance.android.livesdkapi.service.IPreviewBarrageService
    public final boolean isDanmakuOpen() {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r100 = SimpleSettingManager.f141793a;
        return SimpleSettingManager.b().f();
    }

    @Override // com.bytedance.android.livesdkapi.service.IPreviewBarrageService
    public final void openDanmakuSettingDialog(Context r100, OpenParams r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        IBarrageService r102 = (IBarrageService) k.f(IBarrageService.class);
        if (r102 == null) goto L6;
        r102.openPortraitSimpleBarrageSettingDialog(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.IPreviewBarrageService
    public final void switchDanmaKu(boolean r100, ChangeSettingSource r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        com.bytedance.android.livesdk.sharedpref.e<Integer> r102 = SimpleSettingManager.f141793a;
        o r103 = SimpleSettingManager.b();
        r103.h(r100);
        SimpleSettingManager.f(r103, r101);
        SimpleSettingManager.e(null);
    }
}
