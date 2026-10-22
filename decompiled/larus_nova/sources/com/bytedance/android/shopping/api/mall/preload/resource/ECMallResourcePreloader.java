package com.bytedance.android.shopping.api.mall.preload.resource;

import android.os.Handler;
import com.bytedance.android.shopping.api.mall.IECMallHostService;
import com.bytedance.android.shopping.api.mall.common.tools.a0;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallResourcePreloader implements JsEventSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f170605a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IECMallHostService f170606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f170607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ECMallResourcePreloadConfig.ItemConfig f170608c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f170609d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Integer f170610e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Integer f170611f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Boolean f170612g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Boolean f170613h;

        public a(IECMallHostService r100, String r101, ECMallResourcePreloadConfig.ItemConfig r102, String r103, Integer r104, Integer r105, Boolean r106, Boolean r107) {
            this.f170606a = r100;
            this.f170607b = r101;
            this.f170608c = r102;
            this.f170609d = r103;
            this.f170610e = r104;
            this.f170611f = r105;
            this.f170612g = r106;
            this.f170613h = r107;
        }

        public final void a() {
            IECMallHostService r100 = this.f170606a;
            String r101 = this.f170607b;
            if (r101 != null) goto L7;
            r101 = this.f170608c.getUrl();
            if (r101 != null) goto L7;
            return;
        L7:
            String r102 = this.f170609d;
            if (r102 != null) goto L10;
            r102 = this.f170608c.getScene();
        L10:
            Integer r103 = this.f170610e;
            if (r103 != null) goto L13;
            r103 = this.f170608c.getType();
        L13:
            if (r103 != null) goto L16;
        L18:
            if (r103 != null) goto L21;
            return;
        L21:
            if (r103.intValue() != 2) goto L41;
            PreloadType r104 = PreloadType.WEB;
        L23:
            Integer r105 = this.f170611f;
            if (r105 != null) goto L28;
            r105 = this.f170608c.getMaxAge();
            if (r105 != null) goto L28;
            r105 = ECMallResourcePreloader.a().getDefaultMaxAge();
        L28:
            if (r105 == null) goto L30;
            int r106 = r105.intValue();
        L31:
            Boolean r107 = this.f170612g;
            if (r107 != null) goto L36;
            r107 = this.f170608c.getAsyncEnable();
            if (r107 != null) goto L36;
            r107 = ECMallResourcePreloader.a().getDefaultAsyncEnable();
        L36:
            Boolean r108 = Boolean.TRUE;
            boolean r109 = Intrinsics.areEqual(r107, r108);
            Boolean r110 = this.f170613h;
            if (r110 != null) goto L39;
            r110 = this.f170608c.getPredecodeEnable();
        L39:
            r100.preloadResourceWithForest(r101, r102, r104, r106, r109, Intrinsics.areEqual(r110, r108));
            return;
        L30:
            r106 = 0;
            goto L31
        L41:
            return;
        L16:
            if (r103.intValue() != 1) goto L18;
            r104 = PreloadType.LYNX;
            goto L23
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

    public static ECMallResourcePreloadConfig a() {
        return (ECMallResourcePreloadConfig) f170605a.getValue();
    }

    static {
        f170605a = LazyKt.lazy(ECMallResourcePreloader$config$2.INSTANCE);
    }

    @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
    public final void onReceiveJsEvent(Js2NativeEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "jsEvent");
        boolean r100 = true;
        if ((!Intrinsics.areEqual(r110.getEventName(), "ec.event.mallPreloadResource")) == false) goto L5;
        return;
    L5:
        XReadableMap r111 = r110.getParams();
        if (r111 == null) goto L48;
        Map<String, Object> r112 = r111.toMap();
        if (r112 == null) goto L49;
        Map<String, ECMallResourcePreloadConfig.ItemConfig> r101 = a().getItemConfigMap();
        if (r101 != null) goto L13;
    L16:
        if (r100 == true) goto L50;
        Object r102 = r112.get("key");
        Object r103 = null;
        if ((r102 instanceof String) == true) goto L21;
        r102 = null;
    L21:
        String r104 = (String) r102;
        if (r104 == null) goto L51;
        ECMallResourcePreloadConfig.ItemConfig r105 = r101.get(r104);
        if (r105 == null) goto L52;
        Object r106 = r112.get("url");
        if ((r106 instanceof String) == true) goto L30;
        r106 = null;
    L30:
        String r107 = (String) r106;
        Object r108 = r112.get("scene");
        if ((r108 instanceof String) == true) goto L33;
        r108 = null;
    L33:
        String r109 = (String) r108;
        Object r113 = r112.get("type");
        if ((r113 instanceof Integer) == true) goto L36;
        r113 = null;
    L36:
        Integer r114 = (Integer) r113;
        Object r115 = r112.get("max_age");
        if ((r115 instanceof Integer) == true) goto L39;
        r115 = null;
    L39:
        Integer r116 = (Integer) r115;
        Object r117 = r112.get("async_enable");
        if ((r117 instanceof Boolean) == true) goto L42;
        r117 = null;
    L42:
        Boolean r118 = (Boolean) r117;
        Object r119 = r112.get("predecode_enable");
        if ((r119 instanceof Boolean) == false) goto L46;
        r103 = r119;
    L46:
        b(r105, r107, r109, r114, r116, r118, (Boolean) r103, true);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L13:
        if (r101.isEmpty() == true) goto L16;
        r100 = false;
        goto L16
    L49:
        return;
    }

    public static void c(int r100, String r110) {
        if (a().getOnceExecuteEnable() == true) goto L5;
        return;
    L5:
        Map<String, ECMallResourcePreloadConfig.ItemConfig> r101 = a().getItemConfigMap();
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return;
    L14:
        Collection<ECMallResourcePreloadConfig.ItemConfig> r103 = r101.values();
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L16:
        if (r105.hasNext() == false) goto L27;
        Object r106 = r105.next();
        ECMallResourcePreloadConfig.ItemConfig r107 = (ECMallResourcePreloadConfig.ItemConfig) r106;
        if (r107.getOnceExecuteTiming() == r100) goto L20;
    L24:
        boolean r108 = false;
    L25:
        if (r108 == false) goto L16;
        r104.add(r106);
        goto L16
    L20:
        if (r107.getUrl() == null) goto L24;
        if (r107.getType() == null) goto L24;
        r108 = true;
        goto L25
    L27:
        Iterator r109 = r104.iterator();
    L29:
        if (r109.hasNext() == false) goto L45;
        ECMallResourcePreloadConfig.ItemConfig r111 = (ECMallResourcePreloadConfig.ItemConfig) r109.next();
        List<String> r112 = r111.getAccessiblePages();
        if (r112 == null) goto L35;
        if (r112.contains(r110) == false) goto L29;
    L35:
        long r113 = System.currentTimeMillis();
        if (r111.getStartTimestamp() == null) goto L44;
        if (r111.getEndTimestamp() == null) goto L44;
        Long r114 = r111.getStartTimestamp();
        Intrinsics.checkNotNull(r114);
        long r115 = r114.longValue();
        Long r116 = r111.getEndTimestamp();
        Intrinsics.checkNotNull(r116);
        long r117 = r116.longValue();
        if (r115 > r113) goto L29;
        if (r117 < r113) goto L29;
    L44:
        b(r111, null, null, null, null, null, null, false);
        goto L29
    L45:
        return;
    L8:
        if (r101.isEmpty() == true) goto L11;
        r102 = false;
        goto L12
    }

    public static void b(ECMallResourcePreloadConfig.ItemConfig r110, String r111, String r112, Integer r113, Integer r114, Boolean r115, Boolean r116, boolean r117) {
        IECMallHostService r100 = (IECMallHostService) ServiceManager.get().getService(IECMallHostService.class);
        if (r100 != null) goto L5;
        return;
    L5:
        a r101 = new a(r100, r111, r110, r112, r113, r114, r115, r116);
        if (r117 == true) goto L23;
        Long r102 = r110.getDelay();
        if (r102 != null) goto L10;
        r102 = a().getDefaultDelay();
    L10:
        long r103 = 0;
        if (r102 == null) goto L13;
        long r104 = r102.longValue();
    L15:
        if (r104 <= 0) goto L23;
        Handler r105 = a0.f170419a;
        Long r106 = r110.getDelay();
        if (r106 != null) goto L20;
        r106 = a().getDefaultDelay();
    L20:
        if (r106 == null) goto L22;
        r103 = r106.longValue();
    L22:
        Intrinsics.checkNotNullParameter(r101, "runnable");
        a0.f170419a.postDelayed(r101, r103);
        return;
    L13:
        r104 = 0;
    L23:
        r101.run();
    }
}
