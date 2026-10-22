package com.obric.autogui.agents.vlm.models.a;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.display.capture.HeifScreenshotAttachment;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotTaskInfo;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.space.cc.CCSpace;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.h.b.z;
import d.x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: ScreenshotProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements com.obric.autogui.agents.vlm.models.a.a {
    private static final String TAG = "ScrProv";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27247a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f27248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f27249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, IScreenshot> f27250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap.KeySetView<String, Boolean> f27251e;

    /* JADX INFO: compiled from: ScreenshotProvider.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ScreenshotProvider.kt */
    public final class b implements IScreenshot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f27252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f27253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f27254c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Bitmap f27255d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final AOOperatingSpace.SpaceType f27256e;
        private final HeifScreenshotAttachment f;

        @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
        public boolean isValid() {
            return true;
        }

        public b(g r2, String r3, float r4, Bitmap r5, AOOperatingSpace.SpaceType r6, HeifScreenshotAttachment r7) {
            o.e(r3, DbHelper.COL_ID);
            o.e(r5, "bitmap");
            o.e(r6, "spaceType");
            this.f27252a = r2;
            this.f27253b = r3;
            this.f27254c = r4;
            this.f27255d = r5;
            this.f27256e = r6;
            this.f = r7;
        }

        public final String a() {
            return this.f27253b;
        }

        @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
        public float getScale() {
            return this.f27254c;
        }

        @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
        public Bitmap getBitmap() {
            return this.f27255d;
        }

        @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
        public void release() {
            this.f27252a.a((IScreenshot) ZeusTransformUtils.preCheckCast(this, IScreenshot.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
        public <T> Object withResourcesLocked(d.h.a.a<? extends T> r2, d.c.d<? super T> r3) {
            d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return r1.invoke();
        }

        @Override // com.obric.autogui.common.api.platform.display.capture.IScreenshot
        public AOOperatingSpace.SpaceType getSpaceType() {
            return this.f27256e;
        }
    }

    /* JADX INFO: compiled from: ScreenshotProvider.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f27257a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final d.f f27258b = null;

        public static /* synthetic */ List lambda$xgtnAg2lJTHPtVbJmB3LpipFlaQ() {
            return b();
        }

        private c() {
        }

        static {
            f27257a = new c();
            f27258b = d.g.a($$Lambda$g$c$xgtnAg2lJTHPtVbJmB3LpipFlaQ.INSTANCE);
        }

        private final List<String> a() {
            return (List) ZeusTransformUtils.preCheckCast(f27258b.b(), List.class, "com.obric.aiagent.plugin");
        }

        private static final List b() {
            String r0 = AutoActionConfigs.INSTANCE.getStringCfg("vlm.screenshot.security_vul_pref");
            CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L12;
            return p.a("com.ss.android.lark/com.bytedance.ee.bear");
        L12:
            if (o.a(r0, "*") == false) goto L15;
            return null;
        L15:
            return d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{","}, false, 0, 6, null);
        L5:
            if (r1.length() == 0) goto L8;
            r2 = false;
            goto L9
        }

        public final boolean a(ComponentName r6) {
            o.e(r6, "componentName");
            String r7 = r6.flattenToString();
            o.c(r7, "flattenToString(...)");
            List<String> r5 = a();
            if (r5 != null) goto L5;
            return true;
        L5:
            Iterator<String> r8 = r5.iterator();
        L7:
            if (r8.hasNext() == false) goto L11;
            if (d.o.o.b(r7, (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L7;
            return true;
        L11:
            return false;
        }
    }

    /* JADX INFO: compiled from: ScreenshotProvider.kt */
    @d.c.b.a.f(b = "ScreenshotProvider.kt", c = {169, 188}, d = "acquireMDScreenshot", e = "com.obric.autogui.agents.vlm.models.modules.ScreenshotProvider")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27261c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f27262d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f27263e;
        /* synthetic */ Object f;
        final /* synthetic */ g g;
        int h;

        d(g r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ScreenshotProvider.kt */
    @d.c.b.a.f(b = "ScreenshotProvider.kt", c = {103, 125}, d = "acquireScreenshot", e = "com.obric.autogui.agents.vlm.models.modules.ScreenshotProvider")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f27267d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f27268e;
        long f;
        /* synthetic */ Object g;
        final /* synthetic */ g h;
        int i;

        e(g r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.g = r7;
            this.i |= Integer.MIN_VALUE;
            return this.h.a(null, null, false, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ScreenshotProvider.kt */
    @d.c.b.a.f(b = "ScreenshotProvider.kt", c = {222}, d = "provideResizedScreenshot", e = "com.obric.autogui.agents.vlm.models.modules.ScreenshotProvider")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27272d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27273e;
        Object f;
        /* synthetic */ Object g;
        final /* synthetic */ g h;
        int i;

        f(g r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.g = r7;
            this.i |= Integer.MIN_VALUE;
            return g.a(this.h, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f27247a = new a(null);
    }

    public static /* synthetic */ Bitmap lambda$_lAIRnbUmxpyZ5UTmQc4O_675E8(IScreenshot r0, z.a r1, g r2, Bitmap r3, long r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public g(Context r3, float r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        this.f27248b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f27249c = r4;
        this.f27250d = new ConcurrentHashMap();
        this.f27251e = ConcurrentHashMap.newKeySet();
    }

    public static final /* synthetic */ Object a(g r6, String r7, ScreenshotResult r8, AOOperatingSpace.SpaceType r9, ScreenshotTaskInfo r10, d.c.d r11) {
        return r6.a(r7, r8, r9, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final Context getContext() {
        return this.f27248b;
    }

    @Override // com.obric.autogui.agents.vlm.models.a.a
    public Object a(String r21, AOOperatingSpace r22, boolean r23, boolean r24, d.c.d<? super ScreenshotResult> r25) {
        boolean r1 = r24;
        AOOperatingSpace r2 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r22, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, e.class) == false) goto L7;
        e r5 = (e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.aiagent.plugin");
        if ((r5.i & Integer.MIN_VALUE) == 0) goto L7;
        r5.i -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.g;
        Object r7 = d.c.a.b.a();
        int r8 = r5.i;
        if (r8 == 0) goto L16;
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L14;
        d.o.a(r6);
    L45:
        return r6;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r0 = r5.f;
        boolean r3 = r5.f27268e;
        boolean r9 = r5.f27267d;
        AOOperatingSpace r10 = (AOOperatingSpace) ZeusTransformUtils.preCheckCast(r5.f27266c, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r5.f27265b, String.class, "com.obric.aiagent.plugin");
        g r13 = (g) ZeusTransformUtils.preCheckCast(r5.f27264a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        long r16 = r0;
        r1 = r3;
        boolean r15 = r9;
    L34:
        ScreenshotResult r11 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r6, ScreenshotResult.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, CCSpace.class) == false) goto L37;
        r13.a(r11, r1, (CCSpace) ZeusTransformUtils.preCheckCast(r10, CCSpace.class, "com.obric.aiagent.plugin"));
    L37:
        if (r15 == false) goto L41;
        DisplayedAppInfo r14 = AutoActionVirtualDisplay.INSTANCE.fetchVdTopAppInfo();
        if (r14 == null) goto L41;
        ScreenshotTaskInfo r17 = r13.a(r14);
    L42:
        Loog.INSTANCE.i(TAG, " - [screenshot] scr-shot, latency=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r16) + "ms");
        AOOperatingSpace.SpaceType r18 = r10.getType();
        r5.f27264a = null;
        r5.f27265b = null;
        r5.f27266c = null;
        r5.i = 2;
        r6 = r13.a(r12, r11, r18, r17, r5);
        if (r6 != r7) goto L45;
        return r7;
    L41:
        r17 = null;
        goto L42
    L16:
        d.o.a(r6);
        if (r2 != null) goto L19;
        r2 = OperatingSpaceManager.INSTANCE.getActiveSpace();
    L19:
        if (r2 != null) goto L22;
        Loog.INSTANCE.e(TAG, "[acquireScreenshot] -> no active space found.");
        return new ScreenshotResult(ScreenshotResult.Status.NoScreenFound, null, null, 0, null, null, 62, null);
    L22:
        long r19 = AOSystemTools.INSTANCE.nowTimeMillis();
        if (r1 == false) goto L25;
        ScreenshotConfig.HeifConfig r110 = a();
    L26:
        Loog r20 = Loog.INSTANCE;
        StringBuilder r26 = new StringBuilder().append("[acquireScreenshot] heif enableHeif=").append(r1).append(", hasHeifConfig=");
        if (r110 == null) goto L29;
        boolean r111 = true;
    L30:
        r20.i(TAG, r26.append(r111).toString());
        Context r27 = this.f27248b;
        ScreenshotConfig r28 = new ScreenshotConfig(null, this.f27249c, r110, 1, null);
        r5.f27264a = this;
        r5.f27265b = r21;
        r5.f27266c = r2;
        r15 = r23;
        r5.f27267d = r15;
        r5.f27268e = r1;
        r5.f = r19;
        r5.i = 1;
        r6 = r2.acquireScreenshot(r27, r28, r5);
        if (r6 != r7) goto L33;
        return r7;
    L33:
        r10 = r2;
        r16 = r19;
        r12 = r21;
        r13 = this;
        goto L34
    L29:
        r111 = false;
        goto L30
    L25:
        r110 = null;
    L7:
        r5 = new e(this, r4);
        goto L8
    }

    private final void a(ScreenshotResult r16, boolean r17, CCSpace r18) {
        if (r16.ok() == true) goto L6;
        String r0 = r16.getStatus().name();
    L5:
        String r3 = r0;
        if (this.f27251e.add(r3) == true) goto L13;
        return;
    L13:
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "screenshot", r3, com.obric.autogui.session.c.f30777a.b(), r18.getSessionAccessor(), null, null, "screenshot", null, null, null, null, 1968, null);
        return;
    L6:
        if (r17 == true) goto L8;
        return;
    L8:
        if (r16.getHeifAttachment() != null) goto L16;
        r0 = "HeifFallback";
        goto L5
    }

    @Override // com.obric.autogui.agents.vlm.models.a.a
    public Object a(String r27, ScreenshotConfig r28, boolean r29, d.c.d<? super ScreenshotResult> r30) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r30, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, d.class) == false) goto L7;
        d r2 = (d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.aiagent.plugin");
        if ((r2.h & Integer.MIN_VALUE) == 0) goto L7;
        r2.h -= Integer.MIN_VALUE;
    L8:
        d r14 = r2;
        Object r3 = r14.f;
        Object r15 = d.c.a.b.a();
        int r4 = r14.h;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        d.o.a(r3);
    L53:
        return r3;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r5 = r14.f27263e;
        boolean r0 = r14.f27262d;
        ScreenshotConfig r6 = (ScreenshotConfig) ZeusTransformUtils.preCheckCast(r14.f27261c, ScreenshotConfig.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r14.f27260b, String.class, "com.obric.aiagent.plugin");
        g r8 = (g) ZeusTransformUtils.preCheckCast(r14.f27259a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        String r10 = r7;
    L31:
        ScreenshotResult r11 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r3, ScreenshotResult.class, "com.obric.aiagent.plugin");
        if (r0 == false) goto L49;
        DisplayedAppInfo r9 = com.obric.autogui.session.e.f30963a.a(r8.f27248b);
        if (r6 == null) goto L37;
        List<String> r12 = r6.getExcludingPackages();
        if (r12 == null) goto L37;
    L38:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L43;
        ComponentName r16 = r9.getTopActivity();
        if (r16 == null) goto L43;
        String r17 = r16.getPackageName();
    L45:
        if (p.a(r13, r17) == true) goto L49;
        if (r9 == null) goto L49;
        ScreenshotTaskInfo r18 = r8.a(r9);
    L50:
        Loog.INSTANCE.i(TAG, " - [screenshot-MD] scr-shot, latency=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r5) + "ms");
        AOOperatingSpace.SpaceType r19 = AOOperatingSpace.SpaceType.MainDisplay;
        r14.f27259a = null;
        r14.f27260b = null;
        r14.f27261c = null;
        r14.h = 2;
        r3 = r8.a(r10, r11, r19, r18, r14);
        if (r3 != r15) goto L53;
        return r15;
    L43:
        r17 = null;
    L37:
        r12 = p.b();
    L49:
        r18 = null;
        goto L50
    L16:
        d.o.a(r3);
        DisplayAccessor r110 = AOPlatformTools.INSTANCE.display().getMDAccess(this.f27248b);
        if (r110 != null) goto L20;
        Loog.INSTANCE.e(TAG, "[acquireMDScreenshot] -> no MDAccess.");
        return new ScreenshotResult(ScreenshotResult.Status.NoScreenFound, null, null, 0, null, null, 62, null);
    L20:
        long r20 = AOSystemTools.INSTANCE.nowTimeMillis();
        if (r28 == null) goto L25;
        long r111 = r20;
        ScreenshotConfig r21 = ScreenshotConfig.copy$default(r28, null, this.f27249c, null, 5, null);
        if (r21 == null) goto L26;
    L27:
        Context r22 = this.f27248b;
        r14.f27259a = this;
        r14.f27260b = r27;
        r14.f27261c = r28;
        r14.f27262d = r29;
        r14.f27263e = r111;
        r14.h = 1;
        r3 = r110.captureDisplay(r22, r21, r14);
        if (r3 != r15) goto L30;
        return r15;
    L30:
        r8 = this;
        r0 = r29;
        r6 = r28;
        long r24 = r111;
        r10 = r27;
        r5 = r24;
    L26:
        r21 = new ScreenshotConfig(null, this.f27249c, null, 5, null);
        goto L27
    L25:
        r111 = r20;
    L7:
        r2 = new d(this, r1);
        goto L8
    }

    private final Object a(String r25, ScreenshotResult r26, AOOperatingSpace.SpaceType r27, ScreenshotTaskInfo r28, d.c.d<? super ScreenshotResult> r29) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r29, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L7;
        f r1 = (f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.aiagent.plugin");
        if ((r1.i & Integer.MIN_VALUE) == 0) goto L7;
        r1.i -= Integer.MIN_VALUE;
    L8:
        f r9 = r1;
        Object r2 = r9.g;
        Object r10 = d.c.a.b.a();
        int r3 = r9.i;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        z.a r4 = (z.a) ZeusTransformUtils.preCheckCast(r9.f, z.a.class, "com.obric.aiagent.plugin");
        HeifScreenshotAttachment r5 = (HeifScreenshotAttachment) ZeusTransformUtils.preCheckCast(r9.f27273e, HeifScreenshotAttachment.class, "com.obric.aiagent.plugin");
        ScreenshotTaskInfo r6 = (ScreenshotTaskInfo) ZeusTransformUtils.preCheckCast(r9.f27272d, ScreenshotTaskInfo.class, "com.obric.aiagent.plugin");
        AOOperatingSpace.SpaceType r7 = (AOOperatingSpace.SpaceType) ZeusTransformUtils.preCheckCast(r9.f27271c, AOOperatingSpace.SpaceType.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r9.f27270b, String.class, "com.obric.aiagent.plugin");
        g r11 = (g) ZeusTransformUtils.preCheckCast(r9.f27269a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        Object r12 = r2;
        String r13 = r8;
        AOOperatingSpace.SpaceType r14 = r7;
        HeifScreenshotAttachment r15 = r5;
        ScreenshotTaskInfo r16 = r6;
    L22:
        Bitmap r17 = (Bitmap) ZeusTransformUtils.preCheckCast(r12, Bitmap.class, "com.obric.aiagent.plugin");
        if (r4.f38499a == false) goto L32;
        if (r17 == null) goto L32;
        Loog.INSTANCE.i(TAG, " - [screenshot] wrap begin, id=" + r13 + ", w=" + r17.getWidth() + ", h=" + r17.getHeight() + ", spaceType=" + r14);
        b r18 = new b(r11, r13, r11.f27249c, r17, r14, r15);
        ((Map) ZeusTransformUtils.preCheckCast(r11.f27250d, Map.class, "com.obric.aiagent.plugin")).put(r13, r18);
        if (r16 == null) goto L29;
        ComponentName r19 = r16.getTopComponent();
    L30:
        Loog.INSTANCE.i(TAG, " - [screenshot] return ok, id=" + r13 + ", status=" + ScreenshotResult.Status.Ok + ", topComponent=" + r19);
        return new ScreenshotResult(ScreenshotResult.Status.Ok, (IScreenshot) ZeusTransformUtils.preCheckCast(r18, IScreenshot.class, "com.obric.aiagent.plugin"), r15, 0, r19, r16, 8, null);
    L29:
        r19 = null;
    L32:
        Loog.INSTANCE.e(TAG, "[acquireScreenshot] -> failed to resize screenshot. isScreenshotValid=" + r4.f38499a + ", maybeResizedBitmap=" + r17);
        return new ScreenshotResult(ScreenshotResult.Status.ScreenClosed, null, null, 0, null, null, 62, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        final IScreenshot r110 = r26.getPic();
        if (r26.ok() == false) goto L34;
        if (r110 == null) goto L34;
        HeifScreenshotAttachment r111 = r26.getHeifAttachment();
        final Bitmap r20 = r110.getBitmap();
        Loog.INSTANCE.i(TAG, " - [screenshot] scr-shot, w=" + r20.getWidth() + ", h=" + r20.getHeight());
        final long r21 = AOSystemTools.INSTANCE.nowTimeMillis();
        final z.a r22 = new z.a();
        r22.f38499a = true;
        d.h.a.a r23 = new $$Lambda$g$_lAIRnbUmxpyZ5UTmQc4O_675E8(r110, r22, this, r20, r21);
        r9.f27269a = this;
        r13 = r25;
        r9.f27270b = r13;
        r9.f27271c = r27;
        r16 = r28;
        r9.f27272d = r16;
        r9.f27273e = r111;
        r9.f = r22;
        r9.i = 1;
        r12 = r110.withResourcesLocked(r23, r9);
        if (r12 != r10) goto L21;
        return r10;
    L21:
        r14 = r27;
        r11 = this;
        r4 = r22;
        r15 = r111;
    L34:
        Loog.INSTANCE.e(TAG, "[acquireScreenshot] -> acquire screenshot failed; status=" + r26.getStatus());
        return ScreenshotResult.copy$default(r26, null, null, null, 0, null, null, 59, null);
    L7:
        r1 = new f(this, r0);
        goto L8
    }

    private static final Bitmap a(IScreenshot r15, z.a r16, g r17, Bitmap r18, long r19) {
        IScreenshot r2 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r15, IScreenshot.class, "com.obric.aiagent.plugin");
        if (r2.isValid() == true) goto L6;
        IAutoActionTrackingApi r7 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r9 = new JSONObject();
        r9.put("exception_type", "screenshot after release");
        x r0 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r7, "technical_bad_case", r9, false, false, null, 28, null);
        Loog.INSTANCE.e(TAG, " - [screenshot] failed after display released");
        r16.f38499a = false;
        return null;
    L6:
        boolean r4 = true;
        if (r17.f27249c != 1.0f) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
    L17:
        r4 = false;
    L18:
        Loog.INSTANCE.i(TAG, "screenshot-opti - [screenshot] shouldScale=" + r4 + ", scale=" + r2.getScale() + ", width=" + r18.getWidth() + ", height=" + r18.getHeight());
        if (r4 == false) goto L21;
        Bitmap r1 = Bitmap.createScaledBitmap(r18, (int) (r18.getWidth() * r17.f27249c), (int) (r18.getHeight() * r17.f27249c), false);
        o.c(r1, "createScaledBitmap(...)");
        long r5 = AOSystemTools.INSTANCE.nowTimeMillis();
        Loog.INSTANCE.i(TAG, " - [screenshot] resize, latency=" + (r5 - r19) + "ms");
        r18.recycle();
        Bitmap r6 = r1.copy(Bitmap.Config.ARGB_8888, false);
        r1.recycle();
        r6.setHasAlpha(false);
        Loog.INSTANCE.i(TAG, " - [screenshot] copy resize, latency=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r5) + "ms");
        return r6;
    L21:
        Bitmap r8 = r18.copy(Bitmap.Config.ARGB_8888, false);
        r18.recycle();
        r8.setHasAlpha(false);
        Loog.INSTANCE.i(TAG, " - [screenshot] copy, latency=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r19) + "ms");
        return r8;
    L12:
        if (r2.getScale() != r17.f27249c) goto L14;
        boolean r10 = true;
    L15:
        if (r10 == true) goto L17;
    L14:
        r10 = false;
        goto L15
    L9:
        r3 = false;
        goto L10
    }

    private final ScreenshotTaskInfo a(DisplayedAppInfo r7) {
        DisplayedAppInfo r6 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r7, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        return new ScreenshotTaskInfo(r6.getTaskId(), r6.isVisible(), r6.getTopActivity(), r6.getBaseActivity(), r6.getRealActivity());
    }

    private final ScreenshotConfig.HeifConfig a() {
        if (com.obric.autogui.common.a.d.f28974a.s() == true) goto L7;
        return null;
    L7:
        return new ScreenshotConfig.HeifConfig(com.obric.autogui.common.a.d.f28974a.t(), com.obric.autogui.common.a.d.f28974a.u());
    }

    @Override // com.obric.autogui.agents.vlm.models.a.a
    public IScreenshot a(String r2) {
        o.e(r2, DbHelper.COL_ID);
        return (IScreenshot) ZeusTransformUtils.preCheckCast(this.f27250d.get(r2), IScreenshot.class, "com.obric.aiagent.plugin");
    }

    public void a(IScreenshot r3) {
        IScreenshot r4 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r3, IScreenshot.class, "com.obric.aiagent.plugin");
        o.e(r4, "screenshot");
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L5;
        this.f27250d.remove(((b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin")).a());
    L5:
        r4.getBitmap().recycle();
    }

    @Override // com.obric.autogui.agents.vlm.models.a.a
    public void e() {
        Iterator r0 = ((Map) ZeusTransformUtils.preCheckCast(this.f27250d, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");
        IScreenshot r2 = (IScreenshot) ZeusTransformUtils.preCheckCast(r1.getValue(), IScreenshot.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.w(TAG, " - [screenshot] releasing screenshot `" + r3 + '`');
        r2.getBitmap().recycle();
        goto L4
    L6:
        this.f27250d.clear();
    }
}
