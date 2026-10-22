package com.bytedance.android.ec.window.base.repository.vo;

import com.bytedance.android.ec.window.base.repository.dto.r;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f49490e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f49491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f49492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f49493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f49494d;

    public static final class a {
        public static b a(r r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            b r101 = new b();
            r101.f49491a = r100.a();
            r101.f49492b = r100.b();
            r101.f49493c = r100.c();
            Boolean r102 = r100.d();
            if (r102 == null) goto L5;
            boolean r103 = r102.booleanValue();
        L6:
            r101.f49494d = Boolean.valueOf(r103);
            Map<String, Object> r104 = com.bytedance.android.shopping.extensions.k.z(r100.c());
            Object r105 = null;
            if (r104 == null) goto L9;
            Object r106 = r104.get("cart_button_new_style");
        L11:
            if ((r106 instanceof String) == false) goto L14;
            r105 = r106;
        L14:
            String r107 = (String) r105;
            return r101;
        L9:
            r106 = null;
            goto L11
        L5:
            r103 = false;
            goto L6
        }
    }

    static {
    }

    public b() {
    }
}
