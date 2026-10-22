package com.bytedance.android.live.base.abtest;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Object> f58811a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f58812b = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static Object a(ClientABTestKey r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return b(r100, true);
        }

        @JvmStatic
        public static Object c(ClientABTestKey r100) {
            String r101 = r100.f58801a;
            boolean r102 = false;
            if (r101 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == true) goto L33;
            ClientABTestKey.a r104 = r100.f58804d;
            if (r104 == null) goto L33;
            if (r104.f58805a != 1) goto L33;
            Lazy r105 = ABTestConfigMapper.f58799a;
            Intrinsics.checkNotNullParameter(r101, "key");
            if (((Boolean) SettingUtil.getValue("key_ttlive_sdk_setting", "live_ab_host_config_v2", Boolean.TYPE, Boolean.TRUE)).booleanValue() == false) goto L31;
            Lazy r106 = ABTestConfigMapper.f58800b;
            if (((Map) r106.getValue()).isEmpty() == true) goto L31;
            String r107 = (String) ((Map) r106.getValue()).get(r101);
            Lazy r108 = ABTestConfigMapper.f58799a;
            if (((Class) ((ConcurrentHashMap) r108.getValue()).get(r101)) != null) goto L31;
            if (r107 != null) goto L24;
        L25:
            r102 = true;
        L26:
            if (r102 == true) goto L31;
            Class r109 = ABTestConfigMapper.a(r107);     // Catch: Exception -> L29
            ((ConcurrentHashMap) r108.getValue()).put(r101, r109);     // Catch: Exception -> L29
        L29:
            e = move-exception;
            e.printStackTrace();
            goto L31
        L24:
            if (StringsKt.isBlank(r107) == false) goto L26;
        L31:
            Object r110 = ((ConcurrentHashMap) b.f58811a).get(r101);
            if ((r110 instanceof Object) == false) goto L33;
            return r110;
        L33:
            return null;
        L5:
            if (StringsKt.isBlank(r101) == true) goto L8;
            r103 = false;
            goto L9
        }

        @JvmStatic
        public static Object b(ClientABTestKey r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Object r102 = null;
            r102 = SettingUtil.getValue("key_ttlive_sdk_setting", r100.f58801a, r100.f58802b, null);     // Catch: Throwable -> L5
        L6:
            if (r102 == null) goto L32;
        L26:
            if (r102 == null) goto L28;
            return r102;
        L28:
            return r100.f58803c;
        L32:
            Object r103 = c(r100);     // Catch: Throwable -> L24
            if (r103 == null) goto L10;
            r102 = r103;
            goto L26
        L10:
            r102 = ((IHostContext) k.n(IHostContext.class)).getClientABTestValue(r100, r101);     // Catch: Throwable -> L24
            String r104 = r100.f58801a;     // Catch: Throwable -> L24
            if (r104 != null) goto L13;
        L16:
            boolean r105 = true;
        L17:
            if (r105 == true) goto L26;
            ClientABTestKey.a r106 = r100.f58804d;     // Catch: Throwable -> L24
            if (r106 == null) goto L26;
            if (r106.f58805a != 1) goto L26;
            ((ConcurrentHashMap) b.f58811a).put(r104, r102);     // Catch: Throwable -> L24
            goto L26
        L13:
            if (StringsKt.isBlank(r104) == true) goto L16;
            r105 = false;
        L24:
            th = move-exception;
            ALogger.e("LiveClientABUtils", th);
            goto L26
        }
    }

    static {
        f58812b = new a();
        f58811a = new ConcurrentHashMap();
    }
}
