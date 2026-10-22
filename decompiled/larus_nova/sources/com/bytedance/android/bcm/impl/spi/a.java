package com.bytedance.android.bcm.impl.spi;

import com.bytedance.android.bcm.impl.BcmRecorder;
import com.bytedance.android.btm.impl.g;
import com.bytedance.android.btm.impl.util.SharedPreferenceUtil;
import java.util.Iterator;
import java.util.Map;
import kc.c;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements g {
    public a() {
    }

    @Override // com.bytedance.android.btm.impl.g
    public final void a() {
        boolean r100 = BcmRecorder.f41789a;
        SharedPreferenceUtil r101 = (SharedPreferenceUtil) BcmRecorder.f41792d.getValue();
        if (r101 == null) goto L16;
        JSONObject r102 = new JSONObject();
        Map<String, c> r103 = BcmRecorder.f41791c;
        monitor-enter(r103);
        Iterator<Map.Entry<String, c>> r104 = r103.entrySet().iterator();     // Catch: Throwable -> L13
    L8:
        if (r104.hasNext() == false) goto L10;
        Map.Entry<String, c> r105 = r104.next();     // Catch: Throwable -> L13
        r102.putOpt(r105.getKey(), r105.getValue());     // Catch: Throwable -> L13
        goto L8
    L10:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r103);
        r101.a("key_bcm", r102.toString());
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
