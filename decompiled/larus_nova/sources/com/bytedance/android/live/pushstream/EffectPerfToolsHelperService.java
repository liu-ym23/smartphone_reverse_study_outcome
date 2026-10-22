package com.bytedance.android.live.pushstream;

import android.text.TextUtils;
import com.bytedance.android.live.performance.api.IPerfToolsService;
import com.bytedance.android.livesdk.s6;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/pushstream/EffectPerfToolsHelperService;", "Lcom/bytedance/android/live/pushstream/IEffectPerfToolsHelper;", "()V", "checkDebug", "", "setPerfToolsNormalData", "key", "", "value", "liveeffect-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class EffectPerfToolsHelperService implements IEffectPerfToolsHelper {
    public EffectPerfToolsHelperService() {
    }

    @Override // com.bytedance.android.live.pushstream.IEffectPerfToolsHelper
    public boolean checkDebug() {
        IPerfToolsService r100 = p90.a.f528283a;
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L9:
        return false;
    L5:
        if (s6.f157860a.getValue().booleanValue() == false) goto L9;
        if (p90.a.f528283a == null) goto L9;
        return true;
    }

    @Override // com.bytedance.android.live.pushstream.IEffectPerfToolsHelper
    public IEffectPerfToolsHelper setPerfToolsNormalData(String r100, String r101) {
        if (p90.a.f528284b == null) goto L5;
    L14:
        p90.a.f528284b.getClass();
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L17;
    L21:
        boolean r102 = false;
    L22:
        if (r102 == true) goto L25;
    L28:
        return this;
    L25:
        if (TextUtils.isEmpty(r100) == true) goto L28;
        p90.a.f528283a.setData(r100, r101);
        goto L28
    L17:
        if (s6.f157860a.getValue().booleanValue() == false) goto L21;
        if (p90.a.f528283a == null) goto L21;
        r102 = true;
        goto L22
    L5:
        monitor-enter(p90.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (p90.a.f528284b != null) goto L9;
        p90.a.f528284b = new p90.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(p90.a.class);     // Catch: Throwable -> L11
        goto L14
    }
}
