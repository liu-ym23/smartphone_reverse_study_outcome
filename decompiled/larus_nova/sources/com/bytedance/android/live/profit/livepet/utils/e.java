package com.bytedance.android.live.profit.livepet.utils;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.scope.m;
import cy0.j;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.n;

/* JADX INFO: loaded from: classes47.dex */
public final class e {
    public static void a(long r100, String r101, boolean r110, long r111) {
        Intrinsics.checkNotNullParameter(r101, "scheme");
        Intrinsics.checkNotNullParameter("", "error");
        n r102 = new n();
        Map<String, String> r103 = r102.f516447a;
        Intrinsics.checkNotNullParameter(r103, "map");
        String r104 = String.valueOf(r100);
        Intrinsics.checkNotNullParameter("pet_type", "key");
        Intrinsics.checkNotNullParameter(r104, "value");
        r103.put("pet_type", r104);
        Intrinsics.checkNotNullParameter("scheme", "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        r103.put("scheme", r101);
        if (r110 == false) goto L5;
        String r105 = "1";
    L6:
        Intrinsics.checkNotNullParameter("success", "key");
        Intrinsics.checkNotNullParameter(r105, "value");
        r103.put("success", r105);
        String r106 = String.valueOf(r111);
        Intrinsics.checkNotNullParameter("duration", "key");
        Intrinsics.checkNotNullParameter(r106, "value");
        r103.put("duration", r106);
        if (r110 == true) goto L9;
        Intrinsics.checkNotNullParameter("error", "key");
        Intrinsics.checkNotNullParameter("", "value");
        r103.put("error", "");
    L9:
        cy0.e.f465759a.getClass();
        j r107 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r108 = m.b(r107).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r108);
        ((i) ((f80.a) r108)).w3("livesdk_pet_open_container_result_tech", r102.f516447a, r102.f516448b);
        return;
    L5:
        r105 = "0";
        goto L6
    }

    public static final void b(long r100, String r101, boolean r102, String r110) {
        Intrinsics.checkNotNullParameter(r101, "scheme");
        Intrinsics.checkNotNullParameter(r110, "error");
        n r103 = new n();
        Map<String, String> r104 = r103.f516447a;
        Intrinsics.checkNotNullParameter(r104, "map");
        String r105 = String.valueOf(r100);
        Intrinsics.checkNotNullParameter(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, "key");
        Intrinsics.checkNotNullParameter(r105, "value");
        r104.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, r105);
        Intrinsics.checkNotNullParameter("scheme", "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        r104.put("scheme", r101);
        if (r102 == false) goto L5;
        String r106 = "1";
    L6:
        Intrinsics.checkNotNullParameter("success", "key");
        Intrinsics.checkNotNullParameter(r106, "value");
        r104.put("success", r106);
        if (r102 == true) goto L9;
        Intrinsics.checkNotNullParameter("error", "key");
        Intrinsics.checkNotNullParameter(r110, "value");
        r104.put("error", r110);
    L9:
        cy0.e.f465759a.getClass();
        j r107 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r108 = m.b(r107).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r108);
        ((i) ((f80.a) r108)).w3("livesdk_pet_open_trace_container_tech", r103.f516447a, r103.f516448b);
        return;
    L5:
        r106 = "0";
        goto L6
    }
}
