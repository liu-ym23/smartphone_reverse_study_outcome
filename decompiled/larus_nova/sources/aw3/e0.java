package aw3;

import android.content.Intent;
import com.bytedance.applet.audio.background.AppletBackgroundAudioMediaSessionService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class e0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f16417a;

    public /* synthetic */ e0(Function1 r100) {
        this.f16417a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Function1<AppletBackgroundAudioMediaSessionService, Unit> r100 = this.f16417a;
        AppletBackgroundAudioMediaSessionService r101 = g0.f16424c;
        if (r101 != null) goto L5;
    L8:
        CopyOnWriteArrayList<Function1<AppletBackgroundAudioMediaSessionService, Unit>> r102 = g0.f16422a;
        r102.add(r100);
        if (g0.f16426e == true) goto L17;
        g0.f16426e = true;
        com.bytedance.applet.audio.background.a r103 = new com.bytedance.applet.audio.background.a();
        g0.f16425d = r103;
        AppHost.Companion r104 = AppHost.f326268a;
        if (r104.getApplication().bindService(new Intent(r104.getApplication(), AppletBackgroundAudioMediaSessionService.class), r103, 1) == true) goto L15;
        g0.f16426e = false;
        g0.f16425d = null;
        r102.clear();
        FLogger.f375446a.e("AppletBackgroundAudioMediaSessionController", "media session service bind failed. reason: bindService returned false");
    L15:
        return Unit.INSTANCE;
    L17:
        return Unit.INSTANCE;
    L5:
        if (r101.f191434j == true) goto L7;
        r100.invoke(r101);
        return Unit.INSTANCE;
    L7:
        g0.d();
        goto L8
    }
}
