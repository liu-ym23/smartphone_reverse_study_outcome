package com.bytedance.android.live.core.setting;

import android.app.Application;
import android.content.Context;
import com.lynx.tasm.LynxError;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class d6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f65283a = 0;

    @JvmStatic
    public static final Application b() {
        Context r100 = wa1.b.f558800a.getContext();
        if ((r100 instanceof Application) == true) goto L6;
        r100 = null;
    L6:
        return (Application) r100;
    }

    static {
    }

    @JvmStatic
    public static final void a(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "e");
        wa1.a r102 = wa1.d.f558803a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        wa1.a r103 = wa1.d.f558803a;
        if (r103 == null) goto L6;
        r103.e(r100, r101);
        return;
    }

    @JvmStatic
    public static final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        wa1.a r102 = wa1.d.f558803a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        wa1.a r103 = wa1.d.f558803a;
        if (r103 == null) goto L6;
        r103.i(r100, r101);
        return;
    }

    @JvmStatic
    public static final void d(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        wa1.a r104 = wa1.d.f558803a;
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        wa1.a r105 = wa1.d.f558803a;
        if (r105 == null) goto L6;
        r105.monitorEvent(r100, r101, r102, r103);
        return;
    }
}
