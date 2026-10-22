package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes46.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f71786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f71787b;

    public o(Function2 r100, int r101) {
        this.f71786a = r100;
        this.f71787b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Function2 r102 = this.f71786a;
        if (r102 == null) goto L5;
        Unit r103 = (Unit) r102.invoke(null, Boolean.FALSE);
    L5:
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "requestThemeList.failed.bgType:" + this.f71787b);
        com.bytedance.android.live.liveinteract.bgComponent.theme.util.a.a(false, r101);
    }
}
