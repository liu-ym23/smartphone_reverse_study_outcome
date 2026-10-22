package com.bytedance.android.bcm.impl.paramcheck;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes43.dex */
public final class UnitCheckItem implements c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Regex f41860e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f41861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f41862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f41863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f41864d;

    public static final class a {
    }

    @Override // com.bytedance.android.bcm.impl.paramcheck.c
    public final BcmParams b() {
        return (BcmParams) this.f41861a.getValue();
    }

    static {
        f41860e = new Regex("\\.e.*$");
    }

    @Override // com.bytedance.android.bcm.impl.paramcheck.c
    public final String getBtm() {
        return this.f41862b;
    }

    @Override // com.bytedance.android.bcm.impl.paramcheck.c
    public final void a(com.bytedance.android.bcm.impl.paramcheck.checker.b r100) {
        int r101 = com.bytedance.android.bcm.impl.monitor.b.f41838a;
        String r102 = this.f41862b;
        String r103 = this.f41863c;
        com.bytedance.android.bcm.impl.monitor.b.c(SpeechEngineDefines.MESSAGE_TYPE_DIALOG_ASR_ENDED, r100, BtmFormatUtils.b(r102), r102, r103, this.f41864d, 192);
    }

    public UnitCheckItem(String r100, String r101, String r102, final BcmParams r103) {
        this.f41863c = r101;
        this.f41864d = r102;
        this.f41861a = LazyKt.lazy(new UnitCheckItem$bcmParams$2(r103));
        this.f41862b = f41860e.replace(r100, "");
    }
}
