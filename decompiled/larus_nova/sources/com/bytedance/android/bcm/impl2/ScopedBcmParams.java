package com.bytedance.android.bcm.impl2;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.bcm.impl2.model.BcmAllowMode;
import com.bytedance.android.btm.api.inner.ALogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import pc.f;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0006\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000J\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\n\u001a\u00020\tR\u0017\u0010\r\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/bcm/impl2/ScopedBcmParams;", "Lcom/bytedance/android/bcm/api/model/BcmParams;", "", "", "", "params", "merge", "", "isEmpty", "Lcom/bytedance/android/bcm/impl2/model/BcmAllowMode;", "mode", "", "toMap", "biz", "Ljava/lang/String;", "getBiz", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bcm-impl-v2_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class ScopedBcmParams extends BcmParams {
    public static final a Companion = null;
    public static final String TAG = "_ScopedBcmParams";
    private final String biz;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isEmpty() {
        return getMap().isEmpty();
    }

    public final String getBiz() {
        return this.biz;
    }

    public ScopedBcmParams(String r100) {
        this.biz = r100;
    }

    @Override // com.bytedance.android.bcm.api.model.BcmParams
    public final ScopedBcmParams merge(Map<String, ? extends Object> r100) {
        if (r100.isEmpty() == false) goto L5;
        return this;
    L5:
        Map<String, Object> r101 = getMap();
        monitor-enter(r101);
        Iterator<Map.Entry<String, ? extends Object>> r102 = r100.entrySet().iterator();     // Catch: Throwable -> L14
    L9:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r103 = r102.next();     // Catch: Throwable -> L14
        a(r103.getKey(), r103.getValue());     // Catch: Throwable -> L14
        goto L9
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r101);
        return this;
    L14:
        th = move-exception;
        throw th;
    }

    public final Map<String, Object> toMap(BcmAllowMode r100) {
        Lazy r101 = ScopedBcmConfigManager.f41881a;
        String r102 = this.biz;
        f r103 = (f) ((ConcurrentHashMap) ScopedBcmConfigManager.f41881a.getValue()).get(r102);
        if (r103 == null) goto L25;
        Map<String, pc.a> r104 = r103.a();
        if (r104 == null) goto L25;
        Map<String, Object> r105 = getMap();
        monitor-enter(r105);
        Map<String, Object> r106 = getMap();     // Catch: Throwable -> L21
        LinkedHashMap r107 = new LinkedHashMap();     // Catch: Throwable -> L21
        Iterator<Map.Entry<String, Object>> r108 = r106.entrySet().iterator();     // Catch: Throwable -> L21
    L10:
        if (r108.hasNext() == false) goto L18;
        Map.Entry<String, Object> r109 = r108.next();     // Catch: Throwable -> L21
        pc.a r110 = r104.get(r109.getKey());     // Catch: Throwable -> L21
        if (r110 == null) goto L14;
        int r111 = r110.a();     // Catch: Throwable -> L21
    L16:
        if (r100.isEnabled(r111) == false) goto L10;
        r107.put(r109.getKey(), r109.getValue());     // Catch: Throwable -> L21
        goto L10
    L14:
        r111 = 0;
        goto L16
    L18:
        Map<String, Object> r112 = MapsKt.toMutableMap(r107);     // Catch: Throwable -> L21
        monitor-exit(r105);
        return r112;
    L21:
        th = move-exception;
        throw th;
    L25:
        return new LinkedHashMap();
    }

    public final ScopedBcmParams merge(ScopedBcmParams r100) {
        return merge(r100.getMap());
    }

    public final void a(final String r100, Object r101) {
        Lazy r102 = ScopedBcmConfigManager.f41881a;
        String r103 = this.biz;
        f r104 = (f) ((ConcurrentHashMap) ScopedBcmConfigManager.f41881a.getValue()).get(r103);
        if (r104 == null) goto L9;
        Map<String, pc.a> r105 = r104.a();
        if (r105 == null) goto L9;
        boolean r106 = true;
        if (r105.containsKey(r100) != true) goto L9;
    L11:
        if (r106 == true) goto L14;
        ALogger.f41996d.a(TAG, false, new ScopedBcmParams$putVal$1(this, r100));
        return;
    L14:
        if (r101 != null) goto L17;
        return;
    L17:
        if ((r101 instanceof String) == false) goto L20;
    L30:
        getMap().put(r100, r101);
        return;
    L20:
        if ((r101 instanceof Number) == true) goto L30;
        if ((r101 instanceof Boolean) == true) goto L30;
        if ((r101 instanceof JSONObject) == true) goto L30;
        if ((r101 instanceof JSONArray) == true) goto L30;
        getMap().put(r100, JSONObject.wrap(r101));     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        ALogger.f41996d.a(TAG, false, new ScopedBcmParams$putVal$2(this, r100, th));
        getMap().put(r100, r101.toString());
        return;
    L9:
        r106 = false;
        goto L11
    }
}
