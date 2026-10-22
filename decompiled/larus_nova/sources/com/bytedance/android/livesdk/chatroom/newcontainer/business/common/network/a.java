package com.bytedance.android.livesdk.chatroom.newcontainer.business.common.network;

import am2.j;
import ao0.g;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.config.g70;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Map;
import jc1.k;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f107310a = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.newcontainer.business.common.network.a$a, reason: collision with other inner class name */
    public static final class C1635a implements j.c {
        public C1635a() {
        }

        @Override // am2.j.c
        public final int getNetQuality() {
            Boolean r100 = a.f107310a;
            if (a.f107310a.booleanValue() == false) goto L11;
            IFeatureService r101 = (IFeatureService) k.f(IFeatureService.class);
            if (r101 == null) goto L19;
            z90.a r102 = r101.getFeatureManager();
            if (r102 == null) goto L20;
            Integer r103 = (Integer) r102.getFeature("net_quality", -1);
            if (r103 != null) goto L22;
            return -1;
        L22:
            return r103.intValue();
        L20:
            return -1;
        L19:
            return -1;
        L11:
            IHostApp r104 = (IHostApp) k.f(IHostApp.class);
            if (r104 == null) goto L23;
            Map<String, String> r105 = r104.getNQEParams();
            if (r105 == null) goto L24;
            String r106 = r105.get("net_effective_connection_type");
            if (r106 != null) goto L18;
            return -1;
        L18:
            return CastIntegerProtector.parseInt(r106);
        L24:
            return -1;
        L23:
            return -1;
        }
    }

    public static final class b implements j.b {
        public b() {
        }

        @Override // am2.j.b
        public final int a() {
            Boolean r100 = a.f107310a;
            if (a.f107310a.booleanValue() == false) goto L12;
            IFeatureService r101 = (IFeatureService) k.f(IFeatureService.class);
            if (r101 == null) goto L13;
            z90.a r102 = r101.getFeatureManager();
            if (r102 == null) goto L14;
            Integer r103 = (Integer) r102.getFeature("downstream_throughput_kbps", -1);
            if (r103 != null) goto L16;
            return -1;
        L16:
            return r103.intValue();
        L14:
            return -1;
        L13:
            return -1;
        L12:
            return g.a().optInt("downstream_throughput_kbps", -1);
        }
    }

    static {
        f107310a = g70.f120259a.getValue();
    }

    @JvmStatic
    public static final void a() {
        j r100 = j.a();
        r100.f4291b = new C1635a();
        j r101 = j.a();
        r101.f4292c = new b();
    }
}
