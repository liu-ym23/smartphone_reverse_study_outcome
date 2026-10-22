package com.bytedance.applet.impl;

import android.content.ClipData;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import androidx.camera.video.AudioStats;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.CoordinateType;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class s0 implements r4.k {

    public static final class a implements a3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r4.c f192006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s0 f192007b;

        /* JADX INFO: renamed from: com.bytedance.applet.impl.s0$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C2781a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f192008a = null;

            static {
                int[] r100 = new int[LocationResult.values().length];
                r100[LocationResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[LocationResult.NO_PERMISSION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[LocationResult.NO_GPS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[LocationResult.TIME_OUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f192008a = r100;
            }
        }

        public a(r4.c r100, s0 r101) {
            this.f192006a = r100;
            this.f192007b = r101;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // hq9.a3
        public final void a(LocationResult r110, Integer r111, GeoLocationInfo r112) {
            Intrinsics.checkNotNullParameter(r110, "code");
            int r113 = C2781a.f192008a[r110.ordinal()];
            boolean r100 = false;
            int r101 = 0;
            int r102 = 0;
            int r103 = 0;
            int r104 = 0;
            if (r113 != 1) goto L5;
            r4.c r114 = this.f192006a;
            double r105 = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (r112 == null) goto L29;
            double r106 = r112.getLatitude();
        L30:
            if (r112 == null) goto L32;
            r105 = r112.getLongitude();
        L32:
            double r107 = r105;
            Float r108 = null;
            if (r112 == null) goto L35;
            String r109 = Long.valueOf(r112.getGpsTime()).toString();
        L36:
            if (r112 == null) goto L38;
            Float r115 = Float.valueOf(r112.getSpeed());
        L39:
            if (r112 == null) goto L41;
            r108 = Float.valueOf(r112.getRadius());
        L41:
            if (r112 == null) goto L43;
            r100 = r112.isLightLocation();
        L43:
            r114.b(new r4.d(r106, r107, r109, r115, r108, Boolean.valueOf(r100)));
            return;
        L38:
            r115 = null;
            goto L39
        L35:
            r109 = null;
            goto L36
        L29:
            r106 = 0.0d;
            goto L30
        L5:
            if (r113 != 2) goto L7;
            r4.c r116 = this.f192006a;
            this.f192007b.getClass();
            if (r111 == null) goto L25;
            r104 = r111.intValue();
        L25:
            r116.a("location_permission_denied", r104);
            return;
        L7:
            if (r113 != 3) goto L9;
            r4.c r117 = this.f192006a;
            this.f192007b.getClass();
            if (r111 == null) goto L21;
            r103 = r111.intValue();
        L21:
            r117.a("location_service_disabled", r103);
            return;
        L9:
            if (r113 == 4) goto L14;
            r4.c r118 = this.f192006a;
            this.f192007b.getClass();
            if (r111 == null) goto L13;
            r101 = r111.intValue();
        L13:
            r118.a("location_fail", r101);
            return;
        L14:
            r4.c r119 = this.f192006a;
            this.f192007b.getClass();
            if (r111 == null) goto L17;
            r102 = r111.intValue();
        L17:
            r119.a("location_timeout", r102);
        }
    }

    public s0() {
    }

    @Override // r4.k
    public final boolean a(Context r100, e3.d r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "bridgeName");
        IFlowSdkDepend r103 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r103 == null) goto L5;
        r103.d0();
        return com.larus.home.impl.sdk.i1.f346188a.h(r100, "bpea-applet-frontend");
    L5:
        return false;
    }

    @Override // r4.k
    public final ClipData c(Context r100, e3.d r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "bridgeName");
        IFlowSdkDepend r103 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r103 == null) goto L5;
        r103.d0();
        return com.larus.home.impl.sdk.i1.f346188a.e(r100, "bpea-applet-frontend");
    L5:
        return null;
    }

    @Override // r4.k
    public final void b(Context r100, e3.d r101, String r102, ClipData r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "bridgeName");
        Intrinsics.checkNotNullParameter(r103, "clipData");
        IFlowSdkDepend r104 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r104 == null) goto L6;
        r104.d0();
        com.larus.home.impl.sdk.i1.f346188a.i(r100, r103, "bpea-applet-frontend");
        return;
    }

    @Override // r4.k
    public final Sensor e(SensorManager r100, e3.d r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "sensorManager");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "bridgeName");
        return r100.getDefaultSensor(r103);
    }

    @Override // r4.k
    public final void d(Context r110, Integer r111, Long r112, String r113, Long r114, r4.c r115, Boolean r116, String r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r115, "callback");
        com.larus.platform.service.m.f365762a.c(LocateScene.APPLET, CoordinateType.GCJ_O2, r111, r112, r113, r114, new a(r115, this), r116, r210);
    }
}
