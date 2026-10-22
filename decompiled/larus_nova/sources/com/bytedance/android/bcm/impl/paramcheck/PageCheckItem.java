package com.bytedance.android.bcm.impl.paramcheck;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class PageCheckItem implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f41856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f41857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f41858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f41859e;

    @Override // com.bytedance.android.bcm.impl.paramcheck.c
    public final BcmParams b() {
        return (BcmParams) this.f41856b.getValue();
    }

    @Override // com.bytedance.android.bcm.impl.paramcheck.c
    public final String getBtm() {
        return this.f41855a;
    }

    @Override // com.bytedance.android.bcm.impl.paramcheck.c
    public final void a(com.bytedance.android.bcm.impl.paramcheck.checker.b r100) {
        int r101 = com.bytedance.android.bcm.impl.monitor.b.f41838a;
        com.bytedance.android.bcm.impl.monitor.b.c(SpeechEngineDefines.MESSAGE_TYPE_DIALOG_CHAT_RESPONSE, r100, this.f41857c, null, this.f41858d, this.f41859e, 200);
    }

    public PageCheckItem(String r100, String r101, String r102, final Map<String, ? extends BcmParams> r110) {
        this.f41857c = r100;
        this.f41858d = r101;
        this.f41859e = r102;
        this.f41855a = StringsKt.replace$default(r100, ".c0.d0", "", false, 4, null);
        this.f41856b = LazyKt.lazy(new PageCheckItem$bcmParams$2(r110));
    }
}
