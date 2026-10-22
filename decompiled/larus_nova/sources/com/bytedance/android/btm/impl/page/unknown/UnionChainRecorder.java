package com.bytedance.android.btm.impl.page.unknown;

import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.SharedPreferenceUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class UnionChainRecorder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f42387a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f42388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f42389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, String> f42390d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, String> f42391e = null;

    static {
        f42387a = LazyKt.lazy(UnionChainRecorder$sharePreference$2.INSTANCE);
        LinkedHashMap<String, String> r100 = new UnionChainRecorder$unionBtmMap$1();
        LinkedHashMap<String, String> r101 = new UnionChainRecorder$unionEventBtmMap$1();
        f42390d = Collections.synchronizedMap(r100);
        f42391e = Collections.synchronizedMap(r101);
    }

    public static void a() {
        if (BtmSetting.f42469d.c().c().L() == 1) goto L5;
        return;
    L5:
        SharedPreferenceUtil r100 = (SharedPreferenceUtil) f42387a.getValue();
        if (r100 == null) goto L19;
        JSONObject r101 = new JSONObject();
        Map<String, String> r102 = f42390d;
        monitor-enter(r102);
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();     // Catch: Throwable -> L16
    L11:
        if (r103.hasNext() == false) goto L13;
        Map.Entry<String, String> r104 = r103.next();     // Catch: Throwable -> L16
        r101.putOpt(r104.getKey(), r104.getValue());     // Catch: Throwable -> L16
        goto L11
    L13:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r102);
        r100.a("key_union_chain", r101.toString());
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
