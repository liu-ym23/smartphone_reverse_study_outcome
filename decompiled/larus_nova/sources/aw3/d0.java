package aw3;

import com.bytedance.applet.audio.background.AppletBackgroundAudioMediaSessionService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class d0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f16414a;

    public /* synthetic */ d0(Function1 r100) {
        this.f16414a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Function1 r100 = this.f16414a;
        AppletBackgroundAudioMediaSessionService r101 = g0.f16424c;
        if (r101 == null) goto L11;
        if ((!r101.f191434j) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L11;
        r100.invoke(r101);
    L11:
        return Unit.INSTANCE;
    }
}
