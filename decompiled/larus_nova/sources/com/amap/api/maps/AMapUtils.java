package com.amap.api.maps;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.camera.video.AudioStats;
import com.amap.api.mapcore.util.k5;
import com.amap.api.mapcore.util.l5;
import com.amap.api.mapcore.util.m5;
import com.amap.api.mapcore.util.w;
import com.amap.api.mapcore.util.w5;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NaviPara;
import com.amap.api.maps.model.PoiPara;
import com.amap.api.maps.model.RoutePara;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.locationmessage.ui.navigation.MapRouteService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.List;
import java.util.Locale;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class AMapUtils {
    private static final String AMAPNAVIURL = "androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=0&style=%d";
    private static final String AMAPPOISEARCHURL = "androidamap://arroundpoi?sourceApplication=%s&keywords=%s&dev=0";
    private static final String AMAPROUTEURL = "androidamap://route?sourceApplication=%s&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&t=%d";
    public static final int BUS_COMFORT = 4;
    public static final int BUS_MONEY_LITTLE = 1;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_TIME_FIRST = 0;
    public static final int BUS_TRANSFER_LITTLE = 2;
    public static final int BUS_WALK_LITTLE = 3;
    private static final double DEG_TO_RAD = 0.017453292519943295d;
    private static final int DRING_ROUTE_MODEL = 2;
    public static final int DRIVING_AVOID_CONGESTION = 4;
    public static final int DRIVING_DEFAULT = 0;
    public static final int DRIVING_NO_HIGHWAY = 3;
    public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
    public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
    public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SAVE_MONEY = 1;
    public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
    public static final int DRIVING_SHORT_DISTANCE = 2;
    private static final double EARTHRADIUS = 6378137.0d;
    private static final double NF_PI = 0.01745329251994329d;
    private static final double R = 6378137.0d;
    private static final int TRANSIT_ROUTE_MODEL = 1;

    public static class a extends PthreadThreadV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f28620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Context f28621b;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public void run() {
            com_amap_api_maps_AMapUtils$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_amap_api_maps_AMapUtils$a__run$___twin___() {
            if (this.f28621b == null) goto L15;
            String r100 = this.f28620a;     // Catch: k5 -> L10
            w5 r101 = new w5.a(r100, "11.2.101", w.f28256c).a(new String[]{"com.amap.api.maps"}).a();     // Catch: k5 -> L10
            m5.a(this.f28621b, r101, "", null, false, "DEF_ID", null, null, null);     // Catch: k5 -> L10
            interrupt();     // Catch: k5 -> L10
            return;
        L10:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_maps_AMapUtils$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_amap_api_maps_AMapUtils$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(String r100, Context r101) {
            super("s/AMapUtils$a");
            this.f28620a = r100;
            if (r101 == null) goto L6;
            this.f28621b = r101.getApplicationContext();
            return;
        }
    }

    public AMapUtils() {
    }

    public static float calculateArea(List<LatLng> r110) {
        if (r110 != null) goto L5;
        return 0.0f;
    L5:
        if (r110.size() < 3) goto L15;
        int r100 = r110.size();
        double r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r102 = 0;
    L8:
        if (r102 >= r100) goto L11;
        LatLng r103 = (LatLng) ListProtector.get(r110, r102);
        r102 = r102 + 1;
        LatLng r104 = (LatLng) ListProtector.get(r110, r102 % r100);
        double r105 = (r103.longitude * 111319.49079327357d) * Math.cos(r103.latitude * DEG_TO_RAD);
        double r111 = r103.latitude * 111319.49079327357d;
        double r112 = (r104.longitude * 111319.49079327357d) * Math.cos(r104.latitude * DEG_TO_RAD);
        r101 = r101 + ((r105 * (r104.latitude * 111319.49079327357d)) - (r112 * r111));
        goto L8
    L11:
        return (float) Math.abs(r101 / 2.0d);
    L15:
        return 0.0f;
    }

    public static void getLatestAMapApp(Context r100) {
        Intent r101 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Throwable -> L5
        r101.addFlags(276824064);     // Catch: Throwable -> L5
        r101.addCategory("android.intent.category.DEFAULT");     // Catch: Throwable -> L5
        r101.setData(Uri.parse("http://wap.amap.com/"));     // Catch: Throwable -> L5
        ThreadMethodProxy.start(new a("glaa", r100));     // Catch: Throwable -> L5
        r100.startActivity(r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    private static String a(PoiPara r100, Context r101) {
        String r102 = String.format(Locale.US, AMAPPOISEARCHURL, new Object[]{l5.b(r101), r100.getKeywords()});
        if (r100.getCenter() != null) goto L5;
        return r102;
    L5:
        return r102 + "&lat=" + r100.getCenter().latitude + "&lon=" + r100.getCenter().longitude;
    }

    public static float calculateArea(LatLng r100, LatLng r110) {
        if (r100 == null) goto L19;
        if (r110 == null) goto L19;
        double r101 = Math.sin((r100.latitude * 3.141592653589793d) / 180.0d) - Math.sin((r110.latitude * 3.141592653589793d) / 180.0d);     // Catch: Throwable -> L11
        double r102 = (r110.longitude - r100.longitude) / 360.0d;
        if (r102 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L10;
        r102 = r102 + 1.0d;
    L10:
        return (float) ((r101 * 2.5560394669790553E14d) * r102);
    L11:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    L19:
    L16:
        e = move-exception;
        e.printStackTrace();
        return 0.0f;
    L15:
        throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);     // Catch: AMapException -> L16
    }

    public static float calculateLineDistance(LatLng r110, LatLng r111) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            r0 = r18
            r1 = r19
            if (r0 == 0) goto L83
            if (r1 == 0) goto L83
            double r3 = r0.longitude     // Catch: java.lang.Throwable -> L7d
            double r5 = r0.latitude     // Catch: java.lang.Throwable -> L7d
            double r7 = r1.longitude     // Catch: java.lang.Throwable -> L7d
            double r0 = r1.latitude     // Catch: java.lang.Throwable -> L7d
            r9 = 4580687790476533047(0x3f91df46a2529d37, double:0.01745329251994329)
            double r3 = r3 * r9
            double r5 = r5 * r9
            double r7 = r7 * r9
            double r0 = r0 * r9
            double r9 = java.lang.Math.sin(r3)     // Catch: java.lang.Throwable -> L7d
            double r11 = java.lang.Math.sin(r5)     // Catch: java.lang.Throwable -> L7d
            double r3 = java.lang.Math.cos(r3)     // Catch: java.lang.Throwable -> L7d
            double r5 = java.lang.Math.cos(r5)     // Catch: java.lang.Throwable -> L7d
            double r13 = java.lang.Math.sin(r7)     // Catch: java.lang.Throwable -> L7d
            double r15 = java.lang.Math.sin(r0)     // Catch: java.lang.Throwable -> L7d
            double r7 = java.lang.Math.cos(r7)     // Catch: java.lang.Throwable -> L7d
            double r0 = java.lang.Math.cos(r0)     // Catch: java.lang.Throwable -> L7d
            r2 = 3
            double[] r2 = new double[r2]     // Catch: java.lang.Throwable -> L7d
            double r3 = r3 * r5
            r17 = 0
            r2[r17] = r3     // Catch: java.lang.Throwable -> L7d
            double r5 = r5 * r9
            r3 = 1
            r2[r3] = r5     // Catch: java.lang.Throwable -> L7d
            r4 = 2
            r2[r4] = r11     // Catch: java.lang.Throwable -> L7d
            double r7 = r7 * r0
            double r0 = r0 * r13
            r5 = r2[r17]     // Catch: java.lang.Throwable -> L7d
            double r9 = r5 - r7
            double r5 = r5 - r7
            double r9 = r9 * r5
            r5 = r2[r3]     // Catch: java.lang.Throwable -> L7d
            double r7 = r5 - r0
            double r5 = r5 - r0
            double r7 = r7 * r5
            double r9 = r9 + r7
            r0 = r2[r4]     // Catch: java.lang.Throwable -> L7d
            double r2 = r0 - r15
            double r0 = r0 - r15
            double r2 = r2 * r0
            double r9 = r9 + r2
            double r0 = java.lang.Math.sqrt(r9)     // Catch: java.lang.Throwable -> L7d
            r2 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r0 = r0 / r2
            double r0 = java.lang.Math.asin(r0)     // Catch: java.lang.Throwable -> L7d
            r2 = 4713102420611050193(0x41684dae328e2ad1, double:1.27420015798544E7)
            double r0 = r0 * r2
            float r0 = (float) r0
            return r0
        L7d:
            r0 = move-exception
            r0.printStackTrace()
        L81:
            r1 = 0
            return r1
        L83:
            com.amap.api.maps.AMapException r0 = new com.amap.api.maps.AMapException     // Catch: com.amap.api.maps.AMapException -> L8b
            java.lang.String r1 = com.amap.api.maps.AMapException.ERROR_ILLEGAL_VALUE     // Catch: com.amap.api.maps.AMapException -> L8b
            r0.<init>(r1)     // Catch: com.amap.api.maps.AMapException -> L8b
            throw r0     // Catch: com.amap.api.maps.AMapException -> L8b
        L8b:
            r0 = move-exception
            r0.printStackTrace()
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.AMapUtils.calculateLineDistance(com.amap.api.maps.model.LatLng, com.amap.api.maps.model.LatLng):float");
    }

    public static void openAMapDrivingRoute(RoutePara r100, Context r101) throws AMapException {
        a(r100, r101, 2);
    }

    public static void openAMapNavi(NaviPara r100, Context r101) throws AMapException {
        if (r100.getTargetPoint() == null) goto L9;
        Intent r102 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Throwable -> L6
        r102.addFlags(276824064);     // Catch: Throwable -> L6
        r102.addCategory("android.intent.category.DEFAULT");     // Catch: Throwable -> L6
        r102.setData(Uri.parse(a(r100, r101)));     // Catch: Throwable -> L6
        r102.setPackage(MapRouteService.MapPackageName.PACKAGE_NAME_AMAP);     // Catch: Throwable -> L6
        ThreadMethodProxy.start(new a("oan", r101));     // Catch: Throwable -> L6
        r101.startActivity(r102);     // Catch: Throwable -> L6
        return;
    L7:
        throw new AMapException(AMapException.AMAP_NOT_SUPPORT);
    L9:
        throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
    }

    public static void openAMapPoiNearbySearch(PoiPara r100, Context r101) throws AMapException {
        if (r100.getKeywords() == null) goto L11;
        if (r100.getKeywords().trim().length() <= 0) goto L11;
        Intent r102 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Throwable -> L8
        r102.addFlags(276824064);     // Catch: Throwable -> L8
        r102.addCategory("android.intent.category.DEFAULT");     // Catch: Throwable -> L8
        r102.setData(Uri.parse(a(r100, r101)));     // Catch: Throwable -> L8
        r102.setPackage(MapRouteService.MapPackageName.PACKAGE_NAME_AMAP);     // Catch: Throwable -> L8
        ThreadMethodProxy.start(new a("oan", r101));     // Catch: Throwable -> L8
        r101.startActivity(r102);     // Catch: Throwable -> L8
        return;
    L9:
        throw new AMapException(AMapException.AMAP_NOT_SUPPORT);
    L11:
        throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
    }

    public static void openAMapTransitRoute(RoutePara r100, Context r101) throws AMapException {
        a(r100, r101, 1);
    }

    public static void openAMapWalkingRoute(RoutePara r100, Context r101) throws AMapException {
        a(r100, r101, 4);
    }

    private static String a(NaviPara r100, Context r101) {
        return String.format(Locale.US, AMAPNAVIURL, new Object[]{l5.b(r101), Double.valueOf(r100.getTargetPoint().latitude), Double.valueOf(r100.getTargetPoint().longitude), Integer.valueOf(r100.getNaviStyle())});
    }

    private static void a(RoutePara r100, Context r101, int r102) throws AMapException {
        if (r100.getStartPoint() != null) goto L5;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == false) goto L23;
        Intent r104 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Throwable -> L20
        r104.addFlags(276824064);     // Catch: Throwable -> L20
        r104.addCategory("android.intent.category.DEFAULT");     // Catch: Throwable -> L20
        r104.setData(Uri.parse(b(r100, r101, r102)));     // Catch: Throwable -> L20
        r104.setPackage(MapRouteService.MapPackageName.PACKAGE_NAME_AMAP);     // Catch: Throwable -> L20
        ThreadMethodProxy.start(new a("oan", r101));     // Catch: Throwable -> L20
        r101.startActivity(r104);     // Catch: Throwable -> L20
        return;
    L21:
        throw new AMapException(AMapException.AMAP_NOT_SUPPORT);
    L23:
        throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
    L5:
        if (r100.getEndPoint() == null) goto L16;
        if (r100.getStartName() == null) goto L16;
        if (r100.getStartName().trim().length() <= 0) goto L16;
        if (r100.getEndName() == null) goto L16;
        if (r100.getEndName().trim().length() <= 0) goto L16;
        r103 = true;
        goto L17
    }

    private static String b(RoutePara r100, Context r101, int r102) {
        String r103 = String.format(Locale.US, AMAPROUTEURL, new Object[]{l5.b(r101), Double.valueOf(r100.getStartPoint().latitude), Double.valueOf(r100.getStartPoint().longitude), r100.getStartName(), Double.valueOf(r100.getEndPoint().latitude), Double.valueOf(r100.getEndPoint().longitude), r100.getEndName(), Integer.valueOf(r102)});
        if (r102 == 1) goto L8;
        if (r102 == 2) goto L7;
        return r103;
    L7:
        return r103 + "&m=" + r100.getDrivingRouteStyle();
    L8:
        return r103 + "&m=" + r100.getTransitRouteStyle();
    }
}
