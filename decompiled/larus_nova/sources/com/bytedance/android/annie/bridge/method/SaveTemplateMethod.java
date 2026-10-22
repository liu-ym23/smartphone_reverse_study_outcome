package com.bytedance.android.annie.bridge.method;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.bridge.method.abs.SaveTemplateResultModel;
import com.bytedance.android.annie.card.ContainerInitialPropsManager;
import com.bytedance.android.annie.container.fragment.AnnieFragmentManager;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.logger.FLogger;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "saveTemplate")
public final class SaveTemplateMethod extends e7.x<e7.t0, SaveTemplateResultModel> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final List<String> f38471u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final List<String> f38472v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHybridComponent f38473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.annie.container.fragment.q f38474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f38475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f38476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f38477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f38478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f38479g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f38480h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bitmap.CompressFormat f38481i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f38482j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HybridCard f38483k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WeakReference<Context> f38484l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f38485m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SaveTemplateMethod$lifecycleObserver$1 f38486n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f38487o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f38488p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Handler f38489q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final d f38490r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f38491s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c f38492t;

    public static final class a {
    }

    public static final class b implements JsEventSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SaveTemplateMethod f38493a;

        public b(SaveTemplateMethod r100) {
            this.f38493a = r100;
        }

        @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
        public final void onReceiveJsEvent(Js2NativeEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "jsEvent");
            SaveTemplateMethod r101 = this.f38493a;
            r101.f38489q.post(r101.f38492t);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SaveTemplateMethod f38494a;

        public static final class a implements com.bytedance.android.annie.bridge.method.permission.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f38495a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f38496b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ SaveTemplateMethod f38497c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f38498d;

            @Override // com.bytedance.android.annie.bridge.method.permission.b
            public final void onRequestPermissionsResult(int r100, String[] r101, int[] r110) {
                Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
                Intrinsics.checkNotNullParameter(r110, "grantResults");
                if (ContextCompat.checkSelfPermission(this.f38495a, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L10;
                int r102 = com.bytedance.android.annie.util.k.f40065a;
                Uri r103 = null;
                Pair r104 = com.bytedance.android.annie.util.k.a(this.f38495a, this.f38496b, true, null, null);
                if (r104 == null) goto L7;
                r103 = (Uri) r104.getFirst();
            L7:
                if (r103 == null) goto L9;
                SaveTemplateMethod r105 = this.f38497c;
                SaveTemplateResultModel r106 = new SaveTemplateResultModel();
                String r107 = this.f38496b;
                String r111 = this.f38498d;
                r106.a(SaveTemplateResultModel.Code.Success);
                r106.c("Success");
                SaveTemplateResultModel.a r108 = new SaveTemplateResultModel.a();
                r108.a(r107);
                r108.b(StringsKt.replace$default(r107, r111 + '/', "", false, 4, null));
                r106.b(r108);
                List<String> r112 = SaveTemplateMethod.f38471u;
                r105.finishWithResult(r106);
                return;
            L9:
                SaveTemplateMethod.p(this.f38497c, "save image to gallery fail");
                return;
            L10:
                SaveTemplateMethod r109 = this.f38497c;
                SaveTemplateResultModel.Code r113 = SaveTemplateResultModel.Code.NO_PERMISSION;
                List<String> r114 = SaveTemplateMethod.f38471u;
                r109.o("save image to gallery fail for permission rejected", r113);
            }

            public a(Context r100, String r101, SaveTemplateMethod r102, String r103) {
                this.f38495a = r100;
                this.f38496b = r101;
                this.f38497c = r102;
                this.f38498d = r103;
            }
        }

        public c(SaveTemplateMethod r100) {
            this.f38494a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v39 */
        /* JADX WARN: Type inference failed for: r3v40 */
        /* JADX WARN: Type inference failed for: r3v41, types: [T] */
        /* JADX WARN: Type inference failed for: r3v42, types: [com.bytedance.android.annie.container.fragment.q] */
        /* JADX WARN: Type inference failed for: r3v47 */
        public final void a() {
            boolean r100 = false;
            x8.a.d("Annie_SaveTemplateMethod", "saveTemplate create bitmap begin", false);     // Catch: Throwable -> L89 Exception -> L91
            HybridCard r101 = this.f38494a.f38483k;     // Catch: Throwable -> L89 Exception -> L91
            if (r101 == null) goto L95;
            View r102 = r101.getHybridView();     // Catch: Throwable -> L89 Exception -> L91
            if (r102 == null) goto L95;
            SaveTemplateMethod r103 = this.f38494a;     // Catch: Throwable -> L89 Exception -> L91
            Bitmap r104 = SaveTemplateMethod.k(r103, r102, (int) r103.f38475c, (int) r103.f38476d);     // Catch: Throwable -> L89 Exception -> L91
            if (r104 != null) goto L13;
            SaveTemplateMethod.p(this.f38494a, "createBitmap fail");     // Catch: Throwable -> L89 Exception -> L91
        L11:
            this.f38494a.n();
            return;
        L13:
            WeakReference<Context> r105 = this.f38494a.f38484l;     // Catch: Throwable -> L89 Exception -> L91
            if (r105 == null) goto L94;
            Context r106 = r105.get();     // Catch: Throwable -> L89 Exception -> L91
            if (r106 == null) goto L94;
            x8.a.d("Annie_SaveTemplateMethod", "saveTemplate create bitmap done", false);     // Catch: Throwable -> L89 Exception -> L91
            this.f38494a.getClass();     // Catch: Throwable -> L89 Exception -> L91
            File r107 = r106.getExternalCacheDir();     // Catch: Throwable -> L89 Exception -> L91
            if (r107 != null) goto L21;
            r107 = r106.getCacheDir();     // Catch: Throwable -> L89 Exception -> L91
        L21:
            Integer r108 = null;
            if (r107 == null) goto L24;
            String r109 = r107.getAbsolutePath();     // Catch: Throwable -> L89 Exception -> L91
        L26:
            if (r109 != null) goto L28;
        L31:
            boolean r110 = true;
        L32:
            if (r110 == false) goto L34;
            SaveTemplateMethod.p(this.f38494a, "can't get cache dir");     // Catch: Throwable -> L89 Exception -> L91
            goto L11
        L34:
            String r111 = r109 + '/' + this.f38494a.f38480h;     // Catch: Throwable -> L89 Exception -> L91
            PolarisFileWrapper r112 = new PolarisFileWrapper(r111);     // Catch: Throwable -> L89 Exception -> L91
            SaveTemplateMethod r113 = this.f38494a;     // Catch: Throwable -> L89 Exception -> L91
            if (com.bytedance.android.annie.util.g.b(r104, r112, r113.f38479g, r113.f38481i) == true) goto L37;
            SaveTemplateMethod.p(this.f38494a, "save image to cache dir fail");     // Catch: Throwable -> L89 Exception -> L91
            goto L11
        L37:
            x8.a.d("Annie_SaveTemplateMethod", "saveTemplate file done", false);     // Catch: Throwable -> L89 Exception -> L91
            SaveTemplateMethod r114 = this.f38494a;     // Catch: Throwable -> L89 Exception -> L91
            if (r114.f38477e == false) goto L93;
            Ref.ObjectRef r115 = new Ref.ObjectRef();     // Catch: Throwable -> L89 Exception -> L91
            IHybridComponent r116 = this.f38494a.f38473a;     // Catch: Throwable -> L89 Exception -> L91
            if ((r116 instanceof com.bytedance.android.annie.container.fragment.o) == false) goto L43;
            com.bytedance.android.annie.container.fragment.o r117 = (com.bytedance.android.annie.container.fragment.o) r116;     // Catch: Throwable -> L89 Exception -> L91
        L44:
            if (r117 == null) goto L58;
            c7.a r118 = r117.getAnnieContext();     // Catch: Throwable -> L89 Exception -> L91
            if (r118 == null) goto L58;
            SaveTemplateMethod r119 = this.f38494a;     // Catch: Throwable -> L89 Exception -> L91
            WeakReference<HybridFragment> r120 = AnnieFragmentManager.b(r118.getUuid());     // Catch: Throwable -> L89 Exception -> L91
            if (r120 == null) goto L50;
            ActivityResultCaller r121 = (HybridFragment) r120.get();     // Catch: Throwable -> L89 Exception -> L91
        L52:
            if ((r121 instanceof com.bytedance.android.annie.container.fragment.q) == false) goto L54;
            ?? r122 = (com.bytedance.android.annie.container.fragment.q) r121;     // Catch: Throwable -> L89 Exception -> L91
        L55:
            if (r122 != 0) goto L57;
            r122 = r119.f38474b;     // Catch: Throwable -> L89 Exception -> L91
        L57:
            r115.element = r122;     // Catch: Throwable -> L89 Exception -> L91
            goto L58
        L54:
            r122 = 0;
            goto L55
        L50:
            r121 = null;
        L58:
            String r123 = ae7.c.f3110a;     // Catch: Throwable -> L89 Exception -> L91
            if (Build.VERSION.SDK_INT < 29) goto L61;
            boolean r124 = true;
        L62:
            if (r124 == false) goto L64;
            Pair r125 = com.bytedance.android.annie.util.k.b(r106, r111, true);     // Catch: Throwable -> L89 Exception -> L91
        L65:
            if (r125 == null) goto L67;
            Uri r126 = (Uri) r125.getFirst();     // Catch: Throwable -> L89 Exception -> L91
        L68:
            if (r125 == null) goto L70;
            r108 = (Integer) r125.getSecond();     // Catch: Throwable -> L89 Exception -> L91
        L70:
            if (r126 == null) goto L72;
            boolean r127 = true;
        L73:
            if (r126 != null) goto L79;
            if (r108 == null) goto L79;
            if (r108.intValue() != (-1)) goto L79;
            boolean r128 = true;
        L81:
            if (ContextCompat.checkSelfPermission(r106, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L83;
            r100 = true;
        L83:
            if (r127 == false) goto L85;
            SaveTemplateMethod r129 = this.f38494a;     // Catch: Throwable -> L89 Exception -> L91
            SaveTemplateResultModel r130 = new SaveTemplateResultModel();     // Catch: Throwable -> L89 Exception -> L91
            r130.a(SaveTemplateResultModel.Code.Success);     // Catch: Throwable -> L89 Exception -> L91
            r130.c("Success");     // Catch: Throwable -> L89 Exception -> L91
            SaveTemplateResultModel.a r131 = new SaveTemplateResultModel.a();     // Catch: Throwable -> L89 Exception -> L91
            r131.a(r111);     // Catch: Throwable -> L89 Exception -> L91
            r131.b(StringsKt.replace$default(r111, r109 + '/', "", false, 4, null));     // Catch: Throwable -> L89 Exception -> L91
            r130.b(r131);     // Catch: Throwable -> L89 Exception -> L91
            r129.finishWithResult(r130);     // Catch: Throwable -> L89 Exception -> L91
        L98:
            this.f38494a.n();
            return;
        L85:
            if (r100 == false) goto L87;
            SaveTemplateMethod.p(this.f38494a, "save image to gallery fail");     // Catch: Throwable -> L89 Exception -> L91
            goto L11
        L87:
            if (r128 == true) goto L98;
            this.f38494a.o("save image to gallery fail for no permission", SaveTemplateResultModel.Code.NO_PERMISSION);     // Catch: Throwable -> L89 Exception -> L91
        L79:
            r128 = false;
            goto L81
        L72:
            r127 = false;
            goto L73
        L67:
            r126 = null;
            goto L68
        L64:
            int r132 = com.bytedance.android.annie.util.k.f40065a;     // Catch: Throwable -> L89 Exception -> L91
            r125 = com.bytedance.android.annie.util.k.a(r106, r111, true, (com.bytedance.android.annie.container.fragment.q) r115.element, new a(r106, r111, this.f38494a, r109));     // Catch: Throwable -> L89 Exception -> L91
            goto L65
        L61:
            r124 = false;
            goto L62
        L43:
            r117 = null;
            goto L44
        L93:
            SaveTemplateResultModel r133 = new SaveTemplateResultModel();     // Catch: Throwable -> L89 Exception -> L91
            r133.a(SaveTemplateResultModel.Code.Success);     // Catch: Throwable -> L89 Exception -> L91
            r133.c("Success");     // Catch: Throwable -> L89 Exception -> L91
            SaveTemplateResultModel.a r134 = new SaveTemplateResultModel.a();     // Catch: Throwable -> L89 Exception -> L91
            r134.a(r111);     // Catch: Throwable -> L89 Exception -> L91
            r134.b(StringsKt.replace$default(r111, r109 + '/', "", false, 4, null));     // Catch: Throwable -> L89 Exception -> L91
            r133.b(r134);     // Catch: Throwable -> L89 Exception -> L91
            r114.finishWithResult(r133);     // Catch: Throwable -> L89 Exception -> L91
            goto L98
        L28:
            if (StringsKt.isBlank(r109) == true) goto L31;
            r110 = false;
            goto L32
        L24:
            r109 = null;
        L94:
            SaveTemplateMethod.p(this.f38494a, "can't get context in ref");     // Catch: Throwable -> L89 Exception -> L91
        L95:
            SaveTemplateMethod.p(this.f38494a, "can't get hybridView");     // Catch: Throwable -> L89 Exception -> L91
        L91:
            e = move-exception;
            SaveTemplateMethod.p(this.f38494a, "Exception when save bit map : " + e);     // Catch: Throwable -> L89
        L89:
            th = move-exception;
            this.f38494a.n();
            throw th;
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

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SaveTemplateMethod f38499a;

        public d(SaveTemplateMethod r100) {
            this.f38499a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SaveTemplateMethod r100 = this.f38499a;     // Catch: Throwable -> L4
            SaveTemplateResultModel r101 = new SaveTemplateResultModel();     // Catch: Throwable -> L4
            r101.a(SaveTemplateResultModel.Code.Timeout);     // Catch: Throwable -> L4
            r101.c("timeout");     // Catch: Throwable -> L4
            r100.finishWithResult(r101);     // Catch: Throwable -> L4
            this.f38499a.n();     // Catch: Throwable -> L4
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
        f38471u = CollectionsKt.listOf("webcast_lynxview");
        f38472v = CollectionsKt.listOf(new String[]{RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, ".jpg", ".jpeg", ".webp"});
    }

    public final void n() {
        x8.a.d("Annie_SaveTemplateMethod", "release resources begin", false);
        if (this.f38485m == false) goto L5;
        EventCenter.unregisterJsEventSubscriber("saveTemplateStart", this.f38491s);
        this.f38485m = false;
    L5:
        this.f38489q.removeCallbacksAndMessages(null);
        WeakReference<Context> r100 = this.f38484l;
        if (r100 == null) goto L24;
        Context r101 = r100.get();
        if (r101 == null) goto L24;
        if ((r101 instanceof FragmentActivity) == false) goto L15;
        if (this.f38487o == false) goto L15;
        ((FragmentActivity) r101).getLifecycle().removeObserver(this.f38486n);
        this.f38487o = false;
    L15:
        if ((r101 instanceof Activity) == true) goto L17;
    L21:
        WeakReference<Context> r102 = this.f38484l;
        if (r102 == null) goto L24;
        r102.clear();
        goto L24
    L17:
        if (this.f38483k == null) goto L21;
        if (this.f38488p == false) goto L21;
        ((ViewGroup) j(((Activity) r101).getWindow()).getRootView().findViewById(R.id.content)).removeView(this.f38483k);
        this.f38488p = false;
    L24:
        this.f38484l = null;
        HybridCard r103 = this.f38483k;
        if (r103 == null) goto L27;
        r103.close();
        r103.release();
    L27:
        this.f38483k = null;
        x8.a.d("Annie_SaveTemplateMethod", "release resources done", false);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        n();
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.android.annie.bridge.method.SaveTemplateMethod$lifecycleObserver$1] */
    public SaveTemplateMethod(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        com.bytedance.android.annie.util.p r101 = com.bytedance.android.annie.util.p.f40070a;
        this.f38475c = r101.e();
        this.f38476d = r101.d();
        this.f38478f = 10000;
        this.f38479g = 100;
        this.f38480h = "";
        this.f38481i = Bitmap.CompressFormat.PNG;
        this.f38482j = 1073741824;
        this.f38486n = new SaveTemplateMethod$lifecycleObserver$1(this);
        this.f38489q = new Handler(Looper.getMainLooper());
        this.f38490r = new d(this);
        this.f38491s = new b(this);
        this.f38492t = new c(this);
        IHybridComponent r102 = (IHybridComponent) r100.c(IHybridComponent.class);
        if (r102 == null) goto L5;
        this.f38473a = r102;
    L5:
        com.bytedance.android.annie.container.fragment.q r103 = (com.bytedance.android.annie.container.fragment.q) r100.c(com.bytedance.android.annie.container.fragment.q.class);
        if (r103 == null) goto L9;
        this.f38474b = r103;
        return;
    }

    public static View j(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static Uri l(e7.t0 r100) {
        Uri r101 = UriProtector.parse(r100.g());
        if (r100.c() == null) goto L6;
        String r102 = UUID.randomUUID().toString();
        Lazy r103 = ContainerInitialPropsManager.f39126a;
        JsonObject r104 = r100.c();
        Intrinsics.checkNotNullParameter(r102, "key");
        ((HashMap) ContainerInitialPropsManager.f39126a.getValue()).put(r102, r104);
        Uri.Builder r105 = r101.buildUpon();
        r105.appendQueryParameter("__initialProps_data_key", r102);
        Uri r106 = r105.build();
        int r107 = x8.a.f562881a;
        x8.a.d("Annie_SaveTemplateMethod", "BuildUri: " + r106, false);
        return r106;
    L6:
        int r108 = x8.a.f562881a;
        x8.a.d("Annie_SaveTemplateMethod", "BuildUri: " + r101, false);
        return r101;
    }

    public final void m(e7.t0 r110) {
        String r100 = r110.g();
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L19;
        String r103 = r110.g();
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == true) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L120;
        if ((r110.i() instanceof Number) == false) goto L26;
        Integer r106 = r110.i();
        Intrinsics.checkNotNull(r106);
        if (r106.intValue() <= 0) goto L26;
        boolean r107 = true;
    L27:
        if (r107 == false) goto L118;
        if ((r110.b() instanceof Number) == false) goto L33;
        Integer r108 = r110.b();
        Intrinsics.checkNotNull(r108);
        if (r108.intValue() <= 0) goto L33;
        boolean r109 = true;
    L34:
        if (r109 == false) goto L116;
        String r111 = r110.g();
        Intrinsics.checkNotNull(r111);
        Uri r112 = UriProtector.parse(r111);
        List<String> r113 = f38471u;
        String r114 = r112.getHost();
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type kotlin.String");
        if (r113.contains(r114) == false) goto L114;
        double r115 = this.f38475c;
        Integer r116 = r110.b();
        Intrinsics.checkNotNull(r116);
        double r117 = r116.intValue();
        Integer r118 = r110.i();
        Intrinsics.checkNotNull(r118);
        this.f38476d = r115 * (r117 / ((double) r118.intValue()));
        Integer r119 = r110.h();
        if (r119 == null) goto L40;
        this.f38478f = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r119.intValue(), 0), 60000);
    L40:
        Integer r120 = r110.e();
        if (r120 == null) goto L43;
        this.f38479g = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r120.intValue(), 0), 100);
    L43:
        String r121 = r110.a();
        if (r121 == null) goto L82;
        Integer r122 = Integer.valueOf(StringsKt.lastIndexOf$default(r121, '.', 0, false, 6, null));
        if (r122.intValue() <= 0) goto L48;
        boolean r123 = true;
    L49:
        String r124 = null;
        if (r123 == true) goto L53;
        r122 = null;
    L53:
        if (r122 == null) goto L82;
        int r125 = r122.intValue();
        String r126 = r110.a();
        if (r126 == null) goto L60;
        String r127 = r126.substring(r125);
        if (r127 == null) goto L60;
        r124 = r127.toLowerCase(Locale.getDefault());
    L60:
        if (CollectionsKt.contains(f38472v, r124) == false) goto L82;
        String r128 = r110.a();
        Intrinsics.checkNotNull(r128);
        this.f38480h = r128;
        if (r124 == null) goto L82;
        switch(r124.hashCode()) {
            case 1475827: goto L78;
            case 1481531: goto L74;
            case 45750678: goto L71;
            case 46127306: goto L67;
            default: goto L82;
        };
    L67:
        if (r124.equals(".webp") == false) goto L82;
        this.f38481i = Bitmap.CompressFormat.WEBP;
        goto L82
    L71:
        if (r124.equals(".jpeg") == false) goto L82;
    L80:
        this.f38481i = Bitmap.CompressFormat.JPEG;
        goto L82
    L74:
        if (r124.equals(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT) == false) goto L82;
        this.f38481i = Bitmap.CompressFormat.PNG;
        goto L82
    L78:
        if (r124.equals(".jpg") == true) goto L80;
    L48:
        r123 = false;
    L82:
        if (this.f38480h.length() == 0) goto L85;
        r101 = false;
    L85:
        if (r101 == false) goto L88;
        this.f38480h = "save_template_" + System.currentTimeMillis() + Permission.EXECUTE + MathKt.roundToInt(Math.random() * ((double) 10)) + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT;
        this.f38481i = Bitmap.CompressFormat.PNG;
    L88:
        if (r110.f() == null) goto L90;
        Boolean r129 = r110.f();
        Intrinsics.checkNotNull(r129);
        boolean r130 = r129.booleanValue();
    L91:
        this.f38477e = r130;
        String r131 = r110.d();
        if (r131 == null) goto L121;
        String r132 = r131.toUpperCase(Locale.getDefault());
        int r133 = r132.hashCode();
        if (r133 == (-605282132)) goto L109;
        if (r133 == 53152783) goto L105;
        if (r133 == 526786327) goto L101;
        return;
    L101:
        if (r132.equals("UNSPECIFIED") == false) goto L125;
        this.f38482j = 0;
        return;
    L125:
        return;
    L105:
        if (r132.equals("AT_MOST") == false) goto L126;
        this.f38482j = Integer.MIN_VALUE;
        return;
    L126:
        return;
    L109:
        if (r132.equals("EXACTLY") == false) goto L127;
        this.f38482j = 1073741824;
        return;
    L127:
        return;
    L121:
        return;
    L90:
        r130 = false;
        goto L91
    L114:
        throw new IllegalStateException("Invalid schema host".toString());
    L116:
        throw new IllegalStateException("Invalid height".toString());
    L33:
        r109 = false;
        goto L34
    L118:
        throw new IllegalStateException("Invalid width".toString());
    L26:
        r107 = false;
        goto L27
    L120:
        throw new IllegalStateException("Invalid schema".toString());
    L13:
        if (r103.length() == 0) goto L16;
        r104 = false;
    L19:
        r105 = false;
        goto L20
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.android.annie.bridge.method.SaveTemplateMethod$lifecycleObserver$1] */
    public SaveTemplateMethod(IHybridComponent r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridComponent");
        com.bytedance.android.annie.util.p r101 = com.bytedance.android.annie.util.p.f40070a;
        this.f38475c = r101.e();
        this.f38476d = r101.d();
        this.f38478f = 10000;
        this.f38479g = 100;
        this.f38480h = "";
        this.f38481i = Bitmap.CompressFormat.PNG;
        this.f38482j = 1073741824;
        this.f38486n = new SaveTemplateMethod$lifecycleObserver$1(this);
        this.f38489q = new Handler(Looper.getMainLooper());
        this.f38490r = new d(this);
        this.f38491s = new b(this);
        this.f38492t = new c(this);
        this.f38473a = r100;
    }

    public static /* synthetic */ void p(SaveTemplateMethod r100, String r101) {
        r100.o(r101, SaveTemplateResultModel.Code.Failed);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        e7.t0 r102 = (e7.t0) r100;
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        m(r102);     // Catch: Throwable -> L5
        x8.a.d("Annie_SaveTemplateMethod", "Parameters check done", false);     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L33;
        x8.a.b("Annie_SaveTemplateMethod", "Parameters invalid", false);
        SaveTemplateResultModel r106 = new SaveTemplateResultModel();
        r106.c(r105.getMessage());
        r106.a(SaveTemplateResultModel.Code.InvalidParam);
        finishWithResult(r106);
        return;
    L33:
        Context r107 = r101.getContext();     // Catch: Throwable -> L25
        this.f38484l = new WeakReference(r107);     // Catch: Throwable -> L25
        if ((r107 instanceof FragmentActivity) == false) goto L13;
        ((FragmentActivity) r107).getLifecycle().addObserver(this.f38486n);     // Catch: Throwable -> L25
        this.f38487o = true;     // Catch: Throwable -> L25
    L13:
        HybridCard r108 = Annie.with(r101.getContext(), l(r102), r101.a()).a();     // Catch: Throwable -> L25
        if (r108 == null) goto L19;
        r108.setAlpha(0.0f);     // Catch: Throwable -> L25
        r108.setClickable(false);     // Catch: Throwable -> L25
        r108.setFocusable(false);     // Catch: Throwable -> L25
        r108.setTranslationY(com.bytedance.android.annie.util.p.f40070a.d());     // Catch: Throwable -> L25
        Context r109 = r101.getContext();     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L25
        ((ViewGroup) j(((Activity) r109).getWindow()).getRootView().findViewById(R.id.content)).addView(r108);     // Catch: Throwable -> L25
        this.f38488p = true;     // Catch: Throwable -> L25
        a7.a.a(r108, null, null, 3);     // Catch: Throwable -> L25
        if (this.f38485m == true) goto L18;
        EventCenter.registerJsEventSubscriber("saveTemplateStart", this.f38491s);     // Catch: Throwable -> L25
        this.f38485m = true;     // Catch: Throwable -> L25
    L18:
        this.f38489q.postDelayed(this.f38490r, this.f38478f);     // Catch: Throwable -> L25
    L20:
        this.f38483k = r108;     // Catch: Throwable -> L25
        if (r108 != null) goto L23;
        x8.a.b("Annie_SaveTemplateMethod", "Invoke Annie.getHybridCreate failed", false);     // Catch: Throwable -> L25
        p(this, "Invoke Annie.getHybridCreate failed");     // Catch: Throwable -> L25
        n();     // Catch: Throwable -> L25
    L23:
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L36;
        x8.a.b("Annie_SaveTemplateMethod", "Invoke receive fail", false);
        p(this, r111.getMessage());
        n();
        return;
    L36:
        return;
    L19:
        r108 = null;
    L25:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void o(String r100, SaveTemplateResultModel.Code r101) {
        SaveTemplateResultModel r102 = new SaveTemplateResultModel();
        if (r101 != null) goto L5;
        r101 = SaveTemplateResultModel.Code.Failed;
    L5:
        r102.a(r101);
        r102.c(r100);
        finishWithResult(r102);
        int r103 = x8.a.f562881a;
        x8.a.b("Annie_SaveTemplateMethod", "SaveTemplateFailCallback: " + r100, false);
    }

    public static final Bitmap k(SaveTemplateMethod r100, View r101, int r102, int r103) {
        r101.measure(View.MeasureSpec.makeMeasureSpec(r102, r100.f38482j), View.MeasureSpec.makeMeasureSpec(r103, r100.f38482j));
        r101.layout(0, 0, r101.getMeasuredWidth(), r101.getMeasuredHeight());
        int r104 = x8.a.f562881a;
        x8.a.d("Annie_SaveTemplateMethod", "createBitmap measured, width: " + r101.getMeasuredWidth() + ", height: " + r101.getMeasuredHeight() + '.', false);
        Bitmap r105 = Bitmap.createBitmap(r101.getWidth(), r101.getHeight(), Bitmap.Config.ARGB_8888);
        r101.draw(new Canvas(r105));
        return r105;
    }
}
