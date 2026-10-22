package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f71788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IVoiceLiveTheme f71789b;

    public p(long r100, IVoiceLiveTheme r101) {
        this.f71788a = r100;
        this.f71789b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "selectTheme.success " + this.f71788a + ' ' + this.f71789b.getImageUri());
        h.b(true, null);
    }
}
