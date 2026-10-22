package com.bytedance.android.ec.core.imagex.opt;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.ec.ab.opt.LazyOptGetSettings;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.request.HasImageRequest;
import com.facebook.imagepipeline.request.ImageRequest;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class ECImageMainHandlerOpt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f44748a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f44749b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f44750c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LazyOptGetSettings f44751d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static yl.b f44752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ECImageMainHandlerOpt f44753f = null;

    public static final class URIStruct {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f44754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lazy f44755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageRequest f44756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f44757d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof URIStruct) == false) goto L10;
            URIStruct r101 = (URIStruct) r100;
            if (Intrinsics.areEqual(this.f44756c, r101.f44756c) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f44757d, r101.f44757d) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ImageRequest r100 = this.f44756c;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f44757d;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        private final String query() {
            String r100 = this.f44757d;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L12;
            return "";
        L12:
            int r102 = StringsKt.indexOf$default(this.f44757d, "?", 0, false, 6, null);
            if (r102 >= 0) goto L15;
        L22:
            return "";
        L15:
            if (this.f44757d.length() <= 1) goto L22;
            String r103 = this.f44757d;
            int r104 = r102 + 1;
            if (r103 == null) goto L21;
            return r103.substring(r104);
        L21:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L10
        }

        public final String toString() {
            String r100 = this.f44757d;
            if (r100 != null) goto L6;
            return "";
        L6:
            return r100;
        }

        public URIStruct(ImageRequest r100) {
            Intrinsics.checkNotNullParameter(r100, "imageRequest");
            this(r100, r100.getSourceUri().toString());
        }

        public static final Map a(URIStruct r110) {
            r110.getClass();
            LinkedHashMap r100 = new LinkedHashMap();
            Iterator r111 = StringsKt.split$default(r110.query(), new String[]{"&"}, false, 0, 6, null).iterator();
        L4:
            if (r111.hasNext() == false) goto L12;
            String r101 = (String) r111.next();
            List r112 = StringsKt.split$default(r101, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null);
            boolean r102 = false;
            String r103 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r101, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null), 0);
            if (r103 != null) goto L8;
        L9:
            r102 = true;
        L10:
            if (r102 == true) goto L4;
            r100.put(r103, CollectionsKt.getOrNull(r112, 1));
            goto L4
        L8:
            if (StringsKt.isBlank(r103) == false) goto L10;
        L12:
            return r100;
        }

        public final String b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Map<String, String> r101 = this.f44754a;
            if (r101 == null) goto L7;
            String r102 = r101.get(r100);
            if (r102 == null) goto L7;
            return r102;
        L7:
            return (String) ((Map) this.f44755b.getValue()).get(r100);
        }

        public URIStruct(ImageRequest r100, String r101) {
            this.f44756c = r100;
            this.f44757d = r101;
            if (r100 == null) goto L5;
            Map<String, String> r102 = r100.getCustomParam();
        L6:
            this.f44754a = r102;
            this.f44755b = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ECImageMainHandlerOpt$URIStruct$cache$2(this));
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseDataSubscriber f44758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DataSource f44759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ URIStruct f44760c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ yl.a f44761d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f44762e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f44763f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f44764g;

        public a(BaseDataSubscriber r100, DataSource r101, URIStruct r102, yl.a r103, Ref.BooleanRef r104, Ref.BooleanRef r105, long r106) {
            this.f44758a = r100;
            this.f44759b = r101;
            this.f44760c = r102;
            this.f44761d = r103;
            this.f44762e = r104;
            this.f44763f = r105;
            this.f44764g = r106;
        }

        public final void a() {
            long r100 = System.nanoTime();
            this.f44758a.onNewResult(this.f44759b);
            long r101 = System.nanoTime();
            ECImageMainHandlerOpt r102 = ECImageMainHandlerOpt.f44753f;
            URIStruct r103 = this.f44760c;
            yl.a r110 = this.f44761d;
            boolean r104 = this.f44762e.element;
            boolean r105 = this.f44763f.element;
            long r106 = this.f44764g;
            r102.getClass();
            ((ExecutorService) ECImageMainHandlerOpt.f44749b.getValue()).execute(new r(r100, r106, r101, r103, r104, r105, r110));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f44748a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ECImageMainHandlerOpt.class, "configKeys", "getConfigKeys()Ljava/util/List;", 0))};
        ECImageMainHandlerOpt r100 = new ECImageMainHandlerOpt();
        f44753f = r100;
        f44749b = LazyKt.lazy(ECImageMainHandlerOpt$executor$2.INSTANCE);
        f44750c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, ECImageMainHandlerOpt$enable$2.INSTANCE);
        final String r101 = "ec_image_main_handler_opt_configs";
        final ArrayList r102 = new ArrayList();
        ECImageMainHandlerOpt$configKeys$2 r103 = ECImageMainHandlerOpt$configKeys$2.INSTANCE;
        ECImageMainHandlerOpt$configKeys$3 r104 = new ECImageMainHandlerOpt$configKeys$3(r100);
        if (z.b() == false) goto L5;
        LazyOptGetSettings r105 = new LazyFastSDKSettings("ec_image_main_handler_opt_configs", r102, null, r103, r104, new ECImageMainHandlerOpt$$special$$inlined$lazyImageXSettings$1(r101, r102));
    L6:
        f44751d = r105;
        return;
    L5:
        r105 = com.bytedance.android.ec.core.opt.ab.h.a("ec_image_main_handler_opt_configs", r102, null, r103, r104);
        goto L6
    }

    public ECImageMainHandlerOpt() {
    }

    public final boolean a(BaseDataSubscriber<?> r110, Object r111) {
        yl.a r100 = null;
        if ((r111 instanceof DataSource) == true) goto L5;
        Object r101 = null;
    L6:
        DataSource r102 = (DataSource) r101;
        if (r102 != null) goto L10;
        return false;
    L10:
        if ((r110 instanceof BaseDataSubscriber) == true) goto L12;
        BaseDataSubscriber<?> r103 = null;
    L13:
        if (r103 != null) goto L16;
        return false;
    L16:
        if (r111 == null) goto L31;
        Method r104 = com.bytedance.android.shopping.api.image.c0.f170193a;
        Intrinsics.checkNotNullParameter(r111, "dataSource");
        if (StringsKt.contains$default(r111.getClass().getName(), "IncreasingQualityDataSource", false, 2, null) == false) goto L31;
        Intrinsics.checkNotNullParameter(r111, "dataSource");
        Method r105 = com.bytedance.android.shopping.api.image.c0.f170193a;     // Catch: Throwable -> L28
        if (r105 != null) goto L23;
        r105 = r111.getClass().getDeclaredMethod("getDataSourceWithResult", new Class[0]);     // Catch: Throwable -> L28
        com.bytedance.android.shopping.api.image.c0.f170193a = r105;     // Catch: Throwable -> L28
    L23:
        if (r105 == null) goto L25;
        r105.setAccessible(true);     // Catch: Throwable -> L28
    L25:
        if (r105 == null) goto L29;
        r111 = r105.invoke(r111, new Object[0]);     // Catch: Throwable -> L28
    L29:
        r111 = null;
    L31:
        if ((r111 instanceof HasImageRequest) == false) goto L36;
        ImageRequest r112 = ((HasImageRequest) r111).getImageRequest();
        if (r112 == null) goto L59;
        URIStruct r106 = new URIStruct(r112);
    L60:
        if (r106 != null) goto L62;
        return false;
    L62:
        Ref.BooleanRef r113 = new Ref.BooleanRef();
        r113.element = false;
        yl.b r107 = f44752e;
        if (r107 != null) goto L65;
        List r108 = (List) f44751d.getValue(this, f44748a[0]);
    L147:
        if (r100 == null) goto L155;
        Handler r114 = new Handler(Looper.getMainLooper());
        long r109 = System.nanoTime();
        Ref.BooleanRef r115 = new Ref.BooleanRef();
        r115.element = false;
        Message r116 = Message.obtain(r114, new a(r103, r102, r106, r100, r113, r115, r109));
        if (Build.VERSION.SDK_INT >= 22) goto L151;
    L153:
        r113.element = r114.sendMessageAtFrontOfQueue(r116);
        goto L155
    L151:
        if ((!Intrinsics.areEqual(r100.e(), Boolean.FALSE)) == false) goto L153;
        r116.setAsynchronous(true);
        r115.element = true;
    L155:
        return r113.element;
    L65:
        List<yl.a> r117 = r107.a();
        if (r117 != null) goto L68;
        r117 = CollectionsKt.emptyList();
    L68:
        Iterator<yl.a> r118 = r117.iterator();
    L70:
        if (r118.hasNext() == false) goto L147;
        yl.a r119 = r118.next();
        Map<String, List<String>> r120 = r119.c();
        if (r120 != null) goto L74;
    L77:
        boolean r121 = true;
    L78:
        if (r121 == false) goto L96;
        String r122 = r119.d();
        if (r122 != null) goto L82;
    L85:
        boolean r123 = true;
    L86:
        if (r123 == false) goto L96;
        String r124 = r119.a();
        if (r124 != null) goto L90;
    L93:
        boolean r125 = true;
    L94:
        if (r125 == false) goto L96;
        boolean r126 = false;
    L97:
        Boolean r127 = r119.b();
        if (r126 == true) goto L100;
    L109:
        String r128 = r119.d();
        if (r126 == false) goto L121;
        if (r128 != null) goto L113;
    L116:
        boolean r129 = true;
    L117:
        if (r129 == true) goto L121;
        if (StringsKt.startsWith$default(r106.toString(), r128, false, 2, null) == true) goto L121;
        r126 = false;
        goto L121
    L113:
        if (r128.length() == 0) goto L116;
        r129 = false;
    L121:
        String r130 = r119.a();
        if (r126 == false) goto L133;
        if (r130 != null) goto L125;
    L128:
        boolean r131 = true;
    L129:
        if (r131 == true) goto L133;
        if (StringsKt.contains$default(r106.toString(), r130, false, 2, null) == true) goto L133;
        r126 = false;
        goto L133
    L125:
        if (r130.length() == 0) goto L128;
        r131 = false;
    L133:
        Map<String, List<String>> r132 = r119.c();
        if (r126 == false) goto L145;
        if (r132 == null) goto L145;
        Iterator<T> r133 = r132.entrySet().iterator();
    L138:
        if (r133.hasNext() == false) goto L142;
        Object r134 = r133.next();
        Map.Entry r135 = (Map.Entry) r134;
        if ((!CollectionsKt.contains((List) r135.getValue(), r106.b((String) r135.getKey()))) == false) goto L138;
    L143:
        if (r134 == null) goto L145;
        r126 = false;
        goto L145
    L142:
        r134 = null;
    L145:
        if (r126 == false) goto L70;
        r100 = r119;
        goto L147
    L100:
        if (Intrinsics.areEqual(r127, Boolean.TRUE) == false) goto L109;
        ColdLaunchExpFilter.f45205e.getClass();
        if (ColdLaunchExpFilter.a() == true) goto L104;
    L106:
        boolean r136 = false;
    L107:
        if (r136 == false) goto L109;
        r126 = false;
        goto L109
    L104:
        if (ColdLaunchExpFilter.f45202b == true) goto L106;
        r136 = true;
        goto L107
    L90:
        if (r124.length() == 0) goto L93;
        r125 = false;
        goto L94
    L82:
        if (r122.length() == 0) goto L85;
        r123 = false;
    L96:
        r126 = true;
        goto L97
    L74:
        if (r120.isEmpty() == true) goto L77;
        r121 = false;
    L59:
        r106 = null;
        goto L60
    L36:
        if ((r111 instanceof FirstAvailableDataSourceSupplier.FirstAvailableDataSource) == false) goto L59;
        FirstAvailableDataSourceSupplier.FirstAvailableDataSource r137 = (FirstAvailableDataSourceSupplier.FirstAvailableDataSource) r111;
        Supplier r138 = r137.getCurrentSupplier();
        if ((r138 instanceof AbstractDraweeControllerBuilder.CustomSupplier) == false) goto L45;
        Object r139 = ((AbstractDraweeControllerBuilder.CustomSupplier) r138).getRequest();
        if ((r139 instanceof ImageRequest) == true) goto L42;
        r139 = null;
    L42:
        ImageRequest r140 = (ImageRequest) r139;
        if (r140 == null) goto L59;
        r106 = new URIStruct(r140);
        goto L60
    L45:
        String r141 = r137.getCurrentSupplier().toString();
        int r142 = StringsKt.indexOf$default(r141, "uri=", 0, false, 6, null);
        if (r142 <= 0) goto L51;
        if (r141 == null) goto L50;
        String r143 = r141.substring(r142);
    L52:
        if (r143 == null) goto L56;
        int r144 = StringsKt.indexOf$default(r143, ",", 0, false, 6, null);
        if (r144 <= 0) goto L57;
        r143 = r143.substring(0, r144);
    L57:
        if (r143 == null) goto L59;
        Intrinsics.checkNotNullParameter(r143, "uriString");
        r106 = new URIStruct(null, r143);
        goto L60
    L56:
        r143 = null;
        goto L57
    L50:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L51:
        r143 = null;
        goto L52
    L12:
        r103 = r110;
        goto L13
    L5:
        r101 = r111;
        goto L6
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00aa -> B:21:0x00c1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00be -> B:21:0x00c1). Please report as a decompilation issue!!! */
    public final Object b(List<String> r210, Continuation<? super Unit> r211) {
        if ((r211 instanceof ECImageMainHandlerOpt$onInitConfig$1) == false) goto L7;
        ECImageMainHandlerOpt$onInitConfig$1 r100 = (ECImageMainHandlerOpt$onInitConfig$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        long r105 = 0;
        int r106 = 0;
        int r107 = 1;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r108 = r100.I$1;
        int r109 = r100.I$0;
        Long[] r110 = (Long[]) r100.L$3;
        List r111 = (List) r100.L$2;
        List<yl.a> r112 = (List) r100.L$1;
        yl.b r113 = (yl.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L21:
        int r114 = r111.size() - r107;
    L22:
        if (r114 < 0) goto L562;
        String r115 = (String) CollectionsKt.getOrNull(r111, r114);
        if (r115 != null) goto L575;
    L557:
        ECImageMainHandlerOpt$onInitConfig$1 r212 = r100;
    L558:
        boolean r116 = false;
    L559:
        if (r116 == true) goto L561;
        ListProtector.remove(r111, r114);
    L561:
        r114 = r114 - 1;
        r100 = r212;
        r106 = 0;
        goto L22
    L575:
        int r117 = h0.f44861a;     // Catch: Throwable -> L555
        Object r118 = null;
        if (z.b() == true) goto L607;
        int r119 = com.bytedance.android.ec.core.opt.ab.n.f45241a;     // Catch: Throwable -> L555
        int r120 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L555
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L197
        Object r122 = com.bytedance.android.ec.base.settings.d.a().get(r115);     // Catch: Throwable -> L172
        if (r122 != null) goto L124;
    L169:
        Object r123 = null;
    L170:
        Object r124 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L172
    L174:
        Throwable r125 = Result.m9452exceptionOrNullimpl(r124);     // Catch: Throwable -> L197
        if (r125 == null) goto L178;
        EnsureManager.ensureNotReachHere(r125);     // Catch: Throwable -> L197
    L178:
        if (Result.m9455isFailureimpl(r124) == false) goto L181;
        r124 = null;
    L181:
        if ((r124 instanceof yl.b) == true) goto L183;
        r124 = null;
    L183:
        Object r126 = (yl.b) r124;     // Catch: Throwable -> L197
        if (r126 != null) goto L204;
        IHybridHostService r127 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L197
        if (r127 == null) goto L189;
        Object r128 = r127.getHostABValue(r115, r113);     // Catch: Throwable -> L197
    L190:
        if (r128 != null) goto L192;
    L203:
        r126 = r113;
        goto L204
    L192:
        if ((r128 instanceof yl.b) == true) goto L194;
        r128 = null;
    L194:
        r126 = (yl.b) r128;     // Catch: Throwable -> L197
        if (r126 != null) goto L204;
    L189:
        r128 = null;
    L204:
        yl.b r129 = (yl.b) r126;     // Catch: Throwable -> L555
        if (r129 != r113) goto L552;
        int r130 = h0.f44861a;     // Catch: Throwable -> L555
        String r131 = r115 + "_enable";     // Catch: Throwable -> L555
        Object r132 = Boxing.boxInt(r106);     // Catch: Throwable -> L555
        if (z.b() == false) goto L385;
        int r133 = com.bytedance.android.ec.base.settings.b.f42814a;     // Catch: Throwable -> L555
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L376
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L376
        SDKSettingsCacheManager r135 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L376
        r135.getClass();     // Catch: Throwable -> L264
        Object r136 = SDKSettingsCacheManager.b().get(r131);     // Catch: Throwable -> L264
        if (r136 != null) goto L214;
        r212 = r100;
    L259:
        Object r137 = null;
    L605:
        Object r138 = Result.m9449constructorimpl(r137);     // Catch: Throwable -> L262
    L587:
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);     // Catch: Throwable -> L374
        if (r139 == null) goto L271;
        EnsureManager.ensureNotReachHere(r139);     // Catch: Throwable -> L374
    L271:
        if (Result.m9455isFailureimpl(r138) == false) goto L274;
        r138 = null;
    L274:
        if ((r138 instanceof Integer) == true) goto L276;
        r138 = null;
    L276:
        Object r140 = (Integer) r138;     // Catch: Throwable -> L374
        if (r140 != null) goto L283;
        r135.getClass();     // Catch: Throwable -> L374
        Object r141 = SDKSettingsCacheManager.c().get(r131);     // Catch: Throwable -> L374
        if ((r141 instanceof Integer) == true) goto L282;
        r141 = null;
    L282:
        r140 = (Integer) r141;     // Catch: Throwable -> L374
    L283:
        if (r140 != null) goto L579;
        int r142 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L374
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L336
        Object r143 = SDKSettingsCacheManager.b().get(r131);     // Catch: Throwable -> L336
        if (r143 != null) goto L291;
    L333:
        Object r144 = null;
    L334:
        Object r145 = Result.m9449constructorimpl(r144);     // Catch: Throwable -> L336
    L338:
        Throwable r146 = Result.m9452exceptionOrNullimpl(r145);     // Catch: Throwable -> L362
        if (r146 == null) goto L342;
        EnsureManager.ensureNotReachHere(r146);     // Catch: Throwable -> L362
    L342:
        if (Result.m9455isFailureimpl(r145) == false) goto L345;
        r145 = null;
    L345:
        if ((r145 instanceof Integer) == true) goto L347;
        r145 = null;
    L347:
        r140 = (Integer) r145;     // Catch: Throwable -> L362
        if (r140 != null) goto L372;
        Object r147 = jj4.a.a(r131, Integer.class, r132, jj4.b.f499326b.a());     // Catch: Throwable -> L362
        if (r147 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L362
    L354:
        if ((r147 instanceof Integer) == false) goto L357;
        r118 = r147;
    L357:
        Object r148 = (Integer) r118;     // Catch: Throwable -> L362
        if (r148 != null) goto L360;
        r148 = r132;
    L360:
        r140 = Result.m9449constructorimpl(r148);     // Catch: Throwable -> L362
    L365:
        if (Result.m9452exceptionOrNullimpl(r140) == null) goto L372;
        r140 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo(r131, Integer.class, r132);     // Catch: Throwable -> L369
    L370:
        if (r140 != null) goto L372;
        r140 = r132;
    L369:
        r140 = r132;
    L372:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L374
        SDKSettingsCacheManager.e(r131, r140);     // Catch: Throwable -> L374
        goto L579
    L291:
        if ((r143 instanceof Integer) == true) goto L293;
        Object r149 = null;
    L294:
        r144 = (Integer) r149;     // Catch: Throwable -> L336
        if (r144 != null) goto L334;
        if ((r143 instanceof Number) == false) goto L321;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L306;
        Float r150 = Boxing.boxFloat(((Number) r143).floatValue());     // Catch: Throwable -> L336
        if ((r150 instanceof Integer) == true) goto L304;
        r150 = null;
    L304:
        r144 = (Integer) r150;     // Catch: Throwable -> L336
        goto L334
    L306:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L312;
        Double r151 = Boxing.boxDouble(((Number) r143).doubleValue());     // Catch: Throwable -> L336
        if ((r151 instanceof Integer) == true) goto L310;
        r151 = null;
    L310:
        r144 = (Integer) r151;     // Catch: Throwable -> L336
        goto L334
    L312:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L315;
        r144 = Boxing.boxInt(((Number) r143).intValue());     // Catch: Throwable -> L336
        goto L334
    L315:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L321;
        Long r152 = Boxing.boxLong(((Number) r143).longValue());     // Catch: Throwable -> L336
        if ((r152 instanceof Integer) == true) goto L319;
        r152 = null;
    L319:
        r144 = (Integer) r152;     // Catch: Throwable -> L336
    L321:
        if ((r143 instanceof JSONObject) == false) goto L323;
    L571:
        Object r153 = SDKSettingsCacheManager.a().fromJson(r143.toString(), Integer.class);     // Catch: Throwable -> L329
        if ((r153 instanceof Integer) == true) goto L327;
        r153 = null;
    L327:
        Object r154 = Result.m9449constructorimpl((Integer) r153);     // Catch: Throwable -> L329
    L331:
        r144 = r154;
        if (Result.m9455isFailureimpl(r144) == false) goto L334;
    L329:
        th = move-exception;
        Result.Companion r155 = Result.Companion;     // Catch: Throwable -> L336
        r154 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L336
        goto L331
    L323:
        if ((r143 instanceof JSONArray) == false) goto L333;
    L293:
        r149 = r143;
        goto L294
    L336:
        th = move-exception;
        Result.Companion r156 = Result.Companion;     // Catch: Throwable -> L362
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L362
        goto L338
    L362:
        th = move-exception;
        Result.Companion r157 = Result.Companion;     // Catch: Throwable -> L374
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L374
    L579:
        if (((Number) r140).intValue() != 1) goto L553;
        Logger.d("ECImageMainHandlerOpt-initConfig", "need retry key: " + r115);     // Catch: Throwable -> L568
        r116 = true;
    L553:
        r129.b(r112, r115);     // Catch: Throwable -> L568
    L374:
        th = th;
    L378:
        Result.Companion r158 = Result.Companion;     // Catch: Throwable -> L568
        Object r159 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L568
        Throwable r160 = Result.m9452exceptionOrNullimpl(r159);     // Catch: Throwable -> L568
        if (r160 == null) goto L382;
        EnsureManager.ensureNotReachHere(r160);     // Catch: Throwable -> L568
    L382:
        if (Result.m9455isFailureimpl(r159) == true) goto L548;
    L384:
        r132 = r159;
    L548:
        r140 = r132;
    L262:
        th = th;
    L266:
        Result.Companion r161 = Result.Companion;     // Catch: Throwable -> L374
        r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L374
        goto L587
    L214:
        if ((r136 instanceof Integer) == true) goto L216;
        Object r162 = null;
    L217:
        r137 = (Integer) r162;     // Catch: Throwable -> L264
        if (r137 == null) goto L221;
        r212 = r100;
        goto L605
    L221:
        if ((r136 instanceof Number) == false) goto L245;
        r212 = r100;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L231;
        Float r163 = Boxing.boxFloat(((Number) r136).floatValue());     // Catch: Throwable -> L262
        if ((r163 instanceof Integer) == true) goto L229;
        r163 = null;
    L229:
        r137 = (Integer) r163;     // Catch: Throwable -> L262
        goto L605
    L231:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L237;
        Double r164 = Boxing.boxDouble(((Number) r136).doubleValue());     // Catch: Throwable -> L262
        if ((r164 instanceof Integer) == true) goto L235;
        r164 = null;
    L235:
        r137 = (Integer) r164;     // Catch: Throwable -> L262
        goto L605
    L237:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L240;
        r137 = Boxing.boxInt(((Number) r136).intValue());     // Catch: Throwable -> L262
        goto L605
    L240:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L247;
        Long r165 = Boxing.boxLong(((Number) r136).longValue());     // Catch: Throwable -> L262
        if ((r165 instanceof Integer) == true) goto L244;
        r165 = null;
    L244:
        r137 = (Integer) r165;     // Catch: Throwable -> L262
    L247:
        if ((r136 instanceof JSONObject) == false) goto L249;
    L583:
        Object r166 = SDKSettingsCacheManager.a().fromJson(r136.toString(), Integer.class);     // Catch: Throwable -> L255
        if ((r166 instanceof Integer) == true) goto L253;
        r166 = null;
    L253:
        Object r167 = Result.m9449constructorimpl((Integer) r166);     // Catch: Throwable -> L255
    L257:
        r137 = r167;
        if (Result.m9455isFailureimpl(r137) == false) goto L605;
    L255:
        th = move-exception;
        Result.Companion r168 = Result.Companion;     // Catch: Throwable -> L262
        r167 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L262
        goto L257
    L249:
        if ((r136 instanceof JSONArray) == false) goto L259;
    L245:
        r212 = r100;
        goto L247
    L216:
        r162 = r136;
    L264:
        th = th;
        r212 = r100;
    L376:
        th = th;
        r212 = r100;
        goto L378
    L385:
        r212 = r100;
        int r169 = com.bytedance.android.ec.core.opt.ab.n.f45241a;     // Catch: Throwable -> L568
        int r170 = com.bytedance.android.ec.base.settings.a.f42813a;     // Catch: Throwable -> L568
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L542
        goto L558
    L617:
        Object r172 = com.bytedance.android.ec.base.settings.d.a().get(r131);     // Catch: Throwable -> L436
        if (r172 != null) goto L391;
    L433:
        Object r173 = null;
    L434:
        Object r174 = Result.m9449constructorimpl(r173);     // Catch: Throwable -> L436
    L438:
        Throwable r175 = Result.m9452exceptionOrNullimpl(r174);     // Catch: Throwable -> L542
        if (r175 == null) goto L442;
        EnsureManager.ensureNotReachHere(r175);     // Catch: Throwable -> L542
    L442:
        if (Result.m9455isFailureimpl(r174) == false) goto L445;
        r174 = null;
    L445:
        if ((r174 instanceof Integer) == true) goto L447;
        r174 = null;
    L447:
        r140 = (Integer) r174;     // Catch: Throwable -> L542
        if (r140 != null) goto L454;
        Object r176 = com.bytedance.android.ec.base.settings.d.b().get(r131);     // Catch: Throwable -> L542
        if ((r176 instanceof Integer) == true) goto L453;
        r176 = null;
    L453:
        r140 = (Integer) r176;     // Catch: Throwable -> L542
    L454:
        if (r140 != null) goto L579;
        int r177 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L542
        Object r178 = com.bytedance.android.ec.base.settings.d.a().get(r131);     // Catch: Throwable -> L506
        if (r178 != null) goto L461;
    L503:
        Object r179 = null;
    L504:
        Object r180 = Result.m9449constructorimpl(r179);     // Catch: Throwable -> L506
    L603:
        Throwable r181 = Result.m9452exceptionOrNullimpl(r180);     // Catch: Throwable -> L533
        if (r181 == null) goto L512;
        EnsureManager.ensureNotReachHere(r181);     // Catch: Throwable -> L533
    L512:
        if (Result.m9455isFailureimpl(r180) == false) goto L515;
        r180 = null;
    L515:
        if ((r180 instanceof Integer) == true) goto L517;
        r180 = null;
    L517:
        r140 = (Integer) r180;     // Catch: Throwable -> L533
        if (r140 != null) goto L540;
        IHybridHostService r182 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L533
        if (r182 == null) goto L523;
        Object r183 = r182.getHostABValue(r131, r132);     // Catch: Throwable -> L533
    L524:
        if (r183 != null) goto L526;
    L539:
        r140 = r132;
        goto L540
    L526:
        if ((r183 instanceof Integer) == false) goto L529;
        r118 = r183;
    L529:
        Integer r184 = (Integer) r118;     // Catch: Throwable -> L533
        if (r184 == null) goto L539;
        r140 = r184;
        goto L540
    L523:
        r183 = null;
    L540:
        com.bytedance.android.ec.base.settings.d.d(r131, r140);     // Catch: Throwable -> L542
        goto L579
    L533:
        th = move-exception;
        Result.Companion r185 = Result.Companion;     // Catch: Throwable -> L542
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L542
        Throwable r186 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L542
        if (r186 == null) goto L538;
        EnsureManager.ensureNotReachHere(r186);     // Catch: Throwable -> L542
    L538:
        if (Result.m9455isFailureimpl(r140) == false) goto L540;
    L461:
        if ((r178 instanceof Integer) == true) goto L463;
        Object r187 = null;
    L464:
        r179 = (Integer) r187;     // Catch: Throwable -> L506
        if (r179 != null) goto L504;
        if ((r178 instanceof Number) == false) goto L491;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L476;
        Float r188 = Boxing.boxFloat(((Number) r178).floatValue());     // Catch: Throwable -> L506
        if ((r188 instanceof Integer) == true) goto L474;
        r188 = null;
    L474:
        r179 = (Integer) r188;     // Catch: Throwable -> L506
        goto L504
    L476:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L482;
        Double r189 = Boxing.boxDouble(((Number) r178).doubleValue());     // Catch: Throwable -> L506
        if ((r189 instanceof Integer) == true) goto L480;
        r189 = null;
    L480:
        r179 = (Integer) r189;     // Catch: Throwable -> L506
        goto L504
    L482:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L485;
        r179 = Boxing.boxInt(((Number) r178).intValue());     // Catch: Throwable -> L506
        goto L504
    L485:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L491;
        Long r190 = Boxing.boxLong(((Number) r178).longValue());     // Catch: Throwable -> L506
        if ((r190 instanceof Integer) == true) goto L489;
        r190 = null;
    L489:
        r179 = (Integer) r190;     // Catch: Throwable -> L506
    L491:
        if ((r178 instanceof JSONObject) == false) goto L493;
    L577:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L499
        Object r191 = SDKSettingsCacheManager.a().fromJson(r178.toString(), Integer.class);     // Catch: Throwable -> L499
        if ((r191 instanceof Integer) == true) goto L497;
        r191 = null;
    L497:
        Object r192 = Result.m9449constructorimpl((Integer) r191);     // Catch: Throwable -> L499
    L501:
        r179 = r192;
        if (Result.m9455isFailureimpl(r179) == false) goto L504;
    L499:
        th = move-exception;
        Result.Companion r193 = Result.Companion;     // Catch: Throwable -> L506
        r192 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L506
        goto L501
    L493:
        if ((r178 instanceof JSONArray) == false) goto L503;
    L463:
        r187 = r178;
        goto L464
    L506:
        th = move-exception;
        Result.Companion r194 = Result.Companion;     // Catch: Throwable -> L533
        r180 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L533
        goto L603
    L391:
        if ((r172 instanceof Integer) == true) goto L393;
        Object r195 = null;
    L394:
        r173 = (Integer) r195;     // Catch: Throwable -> L436
        if (r173 != null) goto L434;
        if ((r172 instanceof Number) == false) goto L421;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L406;
        Float r196 = Boxing.boxFloat(((Number) r172).floatValue());     // Catch: Throwable -> L436
        if ((r196 instanceof Integer) == true) goto L404;
        r196 = null;
    L404:
        r173 = (Integer) r196;     // Catch: Throwable -> L436
        goto L434
    L406:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L412;
        Double r197 = Boxing.boxDouble(((Number) r172).doubleValue());     // Catch: Throwable -> L436
        if ((r197 instanceof Integer) == true) goto L410;
        r197 = null;
    L410:
        r173 = (Integer) r197;     // Catch: Throwable -> L436
        goto L434
    L412:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L415;
        r173 = Boxing.boxInt(((Number) r172).intValue());     // Catch: Throwable -> L436
        goto L434
    L415:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L421;
        Long r198 = Boxing.boxLong(((Number) r172).longValue());     // Catch: Throwable -> L436
        if ((r198 instanceof Integer) == true) goto L419;
        r198 = null;
    L419:
        r173 = (Integer) r198;     // Catch: Throwable -> L436
    L421:
        if ((r172 instanceof JSONObject) == false) goto L423;
    L591:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L429
        Object r199 = SDKSettingsCacheManager.a().fromJson(r172.toString(), Integer.class);     // Catch: Throwable -> L429
        if ((r199 instanceof Integer) == true) goto L427;
        r199 = null;
    L427:
        Object r200 = Result.m9449constructorimpl((Integer) r199);     // Catch: Throwable -> L429
    L431:
        r173 = r200;
        if (Result.m9455isFailureimpl(r173) == false) goto L434;
    L429:
        th = move-exception;
        Result.Companion r201 = Result.Companion;     // Catch: Throwable -> L436
        r200 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L436
        goto L431
    L423:
        if ((r172 instanceof JSONArray) == false) goto L433;
    L393:
        r195 = r172;
        goto L394
    L436:
        th = move-exception;
        Result.Companion r202 = Result.Companion;     // Catch: Throwable -> L542
        r174 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L542
    L542:
        th = move-exception;
        Result.Companion r203 = Result.Companion;     // Catch: Throwable -> L568
        r159 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L568
        Throwable r204 = Result.m9452exceptionOrNullimpl(r159);     // Catch: Throwable -> L568
        if (r204 == null) goto L547;
        EnsureManager.ensureNotReachHere(r204);     // Catch: Throwable -> L568
    L547:
        if (Result.m9455isFailureimpl(r159) == false) goto L384;
    L552:
        r212 = r100;
        goto L553
    L124:
        if ((r122 instanceof yl.b) == true) goto L126;
        Object r205 = null;
    L127:
        r123 = (yl.b) r205;     // Catch: Throwable -> L172
        if (r123 != null) goto L170;
        if ((r122 instanceof Number) == false) goto L157;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L139;
        Float r206 = Boxing.boxFloat(((Number) r122).floatValue());     // Catch: Throwable -> L172
        if ((r206 instanceof yl.b) == true) goto L137;
        r206 = null;
    L137:
        r123 = (yl.b) r206;     // Catch: Throwable -> L172
        goto L170
    L139:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L145;
        Double r207 = Boxing.boxDouble(((Number) r122).doubleValue());     // Catch: Throwable -> L172
        if ((r207 instanceof yl.b) == true) goto L143;
        r207 = null;
    L143:
        r123 = (yl.b) r207;     // Catch: Throwable -> L172
        goto L170
    L145:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L151;
        Integer r208 = Boxing.boxInt(((Number) r122).intValue());     // Catch: Throwable -> L172
        if ((r208 instanceof yl.b) == true) goto L149;
        r208 = null;
    L149:
        r123 = (yl.b) r208;     // Catch: Throwable -> L172
        goto L170
    L151:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L157;
        Long r209 = Boxing.boxLong(((Number) r122).longValue());     // Catch: Throwable -> L172
        if ((r209 instanceof yl.b) == true) goto L155;
        r209 = null;
    L155:
        r123 = (yl.b) r209;     // Catch: Throwable -> L172
    L157:
        if ((r122 instanceof JSONObject) == false) goto L159;
    L585:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L165
        Object r213 = SDKSettingsCacheManager.a().fromJson(r122.toString(), yl.b.class);     // Catch: Throwable -> L165
        if ((r213 instanceof yl.b) == true) goto L163;
        r213 = null;
    L163:
        Object r214 = Result.m9449constructorimpl((yl.b) r213);     // Catch: Throwable -> L165
    L167:
        r123 = r214;
        if (Result.m9455isFailureimpl(r123) == false) goto L170;
    L165:
        th = move-exception;
        Result.Companion r215 = Result.Companion;     // Catch: Throwable -> L172
        r214 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
        goto L167
    L159:
        if ((r122 instanceof JSONArray) == false) goto L169;
    L126:
        r205 = r122;
        goto L127
    L172:
        th = move-exception;
        Result.Companion r216 = Result.Companion;     // Catch: Throwable -> L197
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L197
        goto L174
    L197:
        th = move-exception;
        Result.Companion r217 = Result.Companion;     // Catch: Throwable -> L555
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L555
        Throwable r218 = Result.m9452exceptionOrNullimpl(r126);     // Catch: Throwable -> L555
        if (r218 == null) goto L202;
        EnsureManager.ensureNotReachHere(r218);     // Catch: Throwable -> L117
    L202:
        if (Result.m9455isFailureimpl(r126) == false) goto L204;
    L607:
        int r219 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L117
        Result.Companion r220 = Result.Companion;     // Catch: Throwable -> L107
        goto L557
    L615:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L82
        Object r221 = SDKSettingsCacheManager.b().get(r115);     // Catch: Throwable -> L82
        if (r221 != null) goto L34;
    L32:
        Object r222 = null;
    L80:
        Object r223 = Result.m9449constructorimpl(r222);     // Catch: Throwable -> L82
    L84:
        Throwable r224 = Result.m9452exceptionOrNullimpl(r223);     // Catch: Throwable -> L107
        if (r224 == null) goto L88;
        EnsureManager.ensureNotReachHere(r224);     // Catch: Throwable -> L107
    L88:
        if (Result.m9455isFailureimpl(r223) == false) goto L91;
        r223 = null;
    L91:
        if ((r223 instanceof yl.b) == true) goto L93;
        r223 = null;
    L93:
        r126 = (yl.b) r223;     // Catch: Throwable -> L107
        if (r126 != null) goto L204;
        Object r225 = jj4.a.a(r115, yl.b.class, r113, jj4.b.f499326b.a());     // Catch: Throwable -> L107
        if (r225 != null) goto L100;
        Intrinsics.throwNpe();     // Catch: Throwable -> L107
    L100:
        if ((r225 instanceof yl.b) == true) goto L102;
        r225 = null;
    L102:
        yl.b r226 = (yl.b) r225;     // Catch: Throwable -> L107
        if (r226 != null) goto L105;
        r226 = r113;
    L105:
        r126 = Result.m9449constructorimpl(r226);     // Catch: Throwable -> L107
    L110:
        if (Result.m9452exceptionOrNullimpl(r126) == null) goto L204;
        r126 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo(r115, yl.b.class, r113);     // Catch: Throwable -> L114
    L115:
        if (r126 != null) goto L204;
    L114:
        r126 = r113;
        goto L115
    L34:
        if ((r221 instanceof yl.b) == true) goto L36;
        Object r227 = null;
    L37:
        r222 = (yl.b) r227;     // Catch: Throwable -> L82
        if (r222 != null) goto L80;
        if ((r221 instanceof Number) == false) goto L67;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L49;
        Float r228 = Boxing.boxFloat(((Number) r221).floatValue());     // Catch: Throwable -> L82
        if ((r228 instanceof yl.b) == true) goto L47;
        r228 = null;
    L47:
        r222 = (yl.b) r228;     // Catch: Throwable -> L82
        goto L80
    L49:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L55;
        Double r229 = Boxing.boxDouble(((Number) r221).doubleValue());     // Catch: Throwable -> L82
        if ((r229 instanceof yl.b) == true) goto L53;
        r229 = null;
    L53:
        r222 = (yl.b) r229;     // Catch: Throwable -> L82
        goto L80
    L55:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L61;
        Integer r230 = Boxing.boxInt(((Number) r221).intValue());     // Catch: Throwable -> L82
        if ((r230 instanceof yl.b) == true) goto L59;
        r230 = null;
    L59:
        r222 = (yl.b) r230;     // Catch: Throwable -> L82
        goto L80
    L61:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L67;
        Long r231 = Boxing.boxLong(((Number) r221).longValue());     // Catch: Throwable -> L82
        if ((r231 instanceof yl.b) == true) goto L65;
        r231 = null;
    L65:
        r222 = (yl.b) r231;     // Catch: Throwable -> L82
    L67:
        if ((r221 instanceof JSONObject) == false) goto L69;
    L589:
        Object r232 = SDKSettingsCacheManager.a().fromJson(r221.toString(), yl.b.class);     // Catch: Throwable -> L75
        if ((r232 instanceof yl.b) == true) goto L73;
        r232 = null;
    L73:
        Object r233 = Result.m9449constructorimpl((yl.b) r232);     // Catch: Throwable -> L75
    L77:
        r222 = r233;
        if (Result.m9455isFailureimpl(r222) == false) goto L80;
    L75:
        th = move-exception;
        Result.Companion r234 = Result.Companion;     // Catch: Throwable -> L82
        r233 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L82
        goto L77
    L69:
        if ((r221 instanceof JSONArray) == false) goto L32;
    L36:
        r227 = r221;
        goto L37
    L82:
        th = move-exception;
        Result.Companion r235 = Result.Companion;     // Catch: Throwable -> L107
        r223 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        Result.Companion r236 = Result.Companion;     // Catch: Throwable -> L117
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L117
    L555:
        r212 = r100;
        goto L558
    L562:
        ECImageMainHandlerOpt$onInitConfig$1 r237 = r100;
        f44752e = new yl.b(new ArrayList(r112));
        if (r111.isEmpty() == true) goto L567;
        r109 = r109 + 1;
        r100 = r237;
        r105 = 0;
        r106 = 0;
        r107 = 1;
    L15:
        if (r109 >= r108) goto L567;
        long r1100 = r110[r109].longValue();
        if (r1100 <= r105) goto L21;
        r100.L$0 = r113;
        r100.L$1 = r112;
        r100.L$2 = r111;
        r100.L$3 = r110;
        r100.I$0 = r109;
        r100.I$1 = r108;
        r100.label = r107;
        if (DelayKt.delay(r1100, r100) != r103) goto L21;
        return r103;
    L567:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        yl.b r238 = new yl.b(0);
        ArrayList r239 = new ArrayList();
        ArrayList r240 = new ArrayList(r210);
        r113 = r238;
        r112 = r239;
        r110 = new Long[]{Boxing.boxLong(0), Boxing.boxLong(2000), Boxing.boxLong(4000), Boxing.boxLong(KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL), Boxing.boxLong(12000), Boxing.boxLong(24000)};
        r108 = 6;
        r111 = r240;
        r109 = 0;
    L7:
        r100 = new ECImageMainHandlerOpt$onInitConfig$1(this, r211);
        goto L8
    }
}
