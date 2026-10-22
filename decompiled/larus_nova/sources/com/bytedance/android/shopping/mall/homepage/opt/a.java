package com.bytedance.android.shopping.mall.homepage.opt;

import com.ss.android.common.lib.AppLogNewUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, a> f178236c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2644a f178237d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f178238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f178239b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.opt.a$a, reason: collision with other inner class name */
    public static final class C2644a {
        public C2644a() {
        }

        public static a a(String r100) {
            Intrinsics.checkNotNullParameter("async_inflate_native_view", "type");
            Intrinsics.checkNotNullParameter(r100, "sceneId");
            String r101 = "async_inflate_native_view-" + r100;
            Map<String, a> r102 = a.f178236c;
            a r103 = (a) ((LinkedHashMap) r102).get(r101);
            if (r103 == null) goto L5;
            return r103;
        L5:
            a r104 = new a();
            r102.put(r101, r104);
            return r104;
        }
    }

    static {
        f178237d = new C2644a();
        f178236c = new LinkedHashMap();
    }

    public a() {
        Intrinsics.checkNotNullParameter("async_inflate_native_view", "type");
        this.f178239b = "async_inflate_native_view";
        this.f178238a = 2;
    }

    public final void a(int r100, int r101) {
        JSONObject r102 = new JSONObject();
        r102.putOpt("type", this.f178239b);
        r102.putOpt("state", Integer.valueOf(r100));
        r102.putOpt("result", Integer.valueOf(r101));
        Unit r103 = Unit.INSTANCE;
        AppLogNewUtils.onEventV3("mall_async_task_event", r102);
    }
}
