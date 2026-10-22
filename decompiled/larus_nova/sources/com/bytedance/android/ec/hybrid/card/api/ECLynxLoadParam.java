package com.bytedance.android.ec.hybrid.card.api;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxLoadType;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.shopping.verse.api.IVerseService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class ECLynxLoadParam {
    public static final Lazy G = null;
    public final ECHybridListItemVO A;
    public final int B;
    public final Function1<Map<String, ? extends Object>, Unit> C;
    public final ik.a D;
    public final boolean E;
    public Lifecycle F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f46311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f46312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f46313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f46314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f46315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lifecycle f46316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f46317h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f46318i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, Object> f46319j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f46320k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final IECLynxCardLifeCycle f46321l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Object> f46322m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, Object> f46323n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ViewGroup.LayoutParams f46324o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, IDLXBridgeMethod> f46325p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Integer f46326q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Integer f46327r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f46328s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<String, String> f46329t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final uj.b f46330u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f46331v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f46332w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<Object> f46333x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ECLynxLoadType f46334y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f46335z;

    public static final class a {
        public final String A;
        public final List<Object> B;
        public Function1<? super Map<String, ? extends Object>, Unit> C;
        public ik.a D;
        public ECLynxLoadType E;
        public boolean F;
        public int G;
        public boolean H;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f46336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f46337b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f46338c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ECLynxCard f46339d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ECHybridListItemVO f46340e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f46341f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f46342g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f46343h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Lifecycle f46344i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f46345j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public c f46346k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List<String> f46347l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Map<String, ? extends Object> f46348m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Long f46349n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public IECLynxCardLifeCycle f46350o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Map<String, ? extends Object> f46351p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Map<String, ? extends Object> f46352q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Map<String, ? extends IDLXBridgeMethod> f46353r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Map<String, String> f46354s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f46355t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public ViewGroup.LayoutParams f46356u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Integer f46357v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public uj.b f46358w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f46359x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public Integer f46360y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f46361z;

        public final ECLynxLoadParam c() {
            return new ECLynxLoadParam(this);
        }

        public final Context getContext() {
            return this.f46336a;
        }

        public final void a(List r100) {
            Intrinsics.checkNotNullParameter(r100, "list");
            ArrayList r101 = (ArrayList) this.B;
            r101.addAll(r100);
        }

        public final void b(Map r100) {
            Intrinsics.checkNotNullParameter(r100, "map");
            this.f46354s = r100;
        }

        public final void d(Map r100) {
            Intrinsics.checkNotNullParameter(r100, "ecBridgeMap");
            this.f46353r = r100;
        }

        public final void e(Map r100) {
            Intrinsics.checkNotNullParameter(r100, "ecGlobalProps");
            this.f46351p = r100;
        }

        public final void f(IECLynxCardLifeCycle.Base r100) {
            Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
            this.f46350o = r100;
        }

        public final void g(String r100) {
            if (r100 != null) goto L4;
        L6:
            r100 = null;
        L7:
            this.f46341f = r100;
            return;
        L4:
            if ((!StringsKt.isBlank(r100)) == false) goto L6;
            goto L6
        }

        public final void h(String r100) {
            Intrinsics.checkNotNullParameter(r100, "sceneID");
            this.f46361z = r100;
        }

        public final void i(ECLynxLoadType r100) {
            Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
            this.E = r100;
        }

        public final void j(long r100) {
            this.f46349n = Long.valueOf(r100);
        }

        @Deprecated(message = "this constructor can not pass page's lifecycle, may occur error about lifecycle")
        public a(Context r100, String r101, ViewGroup r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "schema");
            Intrinsics.checkNotNullParameter(r102, "parentView");
            this.f46342g = "";
            this.f46361z = "";
            this.A = "";
            this.B = new ArrayList();
            this.E = ECLynxLoadType.DEFAULT;
            this.F = true;
            this.G = -1;
            this.f46336a = r100;
            this.f46338c = r101;
            this.f46337b = r102;
        }

        public a(Context r100, Lifecycle r101, ViewGroup r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "parentView");
            Intrinsics.checkNotNullParameter(r103, "schema");
            this(r100, r103, r102);
            this.f46344i = r101;
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        new b();
        G = LazyKt.lazy(ECLynxLoadParam$Companion$verseService$2.INSTANCE);
    }

    public final Lifecycle a() {
        if (this.F != null) goto L15;
        Lifecycle r100 = this.f46316g;
        if (r100 != null) goto L13;
        ComponentCallbacks2 r101 = ECHybridExtensionsKt.a(this.f46311b);
        if ((r101 instanceof LifecycleOwner) == true) goto L9;
        r101 = null;
    L9:
        LifecycleOwner r102 = (LifecycleOwner) r101;
        if (r102 == null) goto L12;
        r100 = r102.getLifecycle();
        goto L13
    L12:
        r100 = null;
    L13:
        this.F = r100;
    L15:
        return this.F;
    }

    public final Context getContext() {
        return this.f46311b;
    }

    public ECLynxLoadParam(a r100) {
        this.f46310a = r100.f46342g;
        this.f46311b = r100.getContext();
        this.f46312c = r100.f46337b;
        String r101 = r100.f46338c;
        Lazy r102 = G;
        if (((IVerseService) r102.getValue()) == null) goto L8;
        IVerseService r103 = (IVerseService) r102.getValue();
        if (r103 == null) goto L7;
        r103.getMallDebugService();
    L7:
        r101 = r100.f46338c;
    L8:
        this.f46313d = r101;
        this.f46314e = r100.f46346k;
        this.f46315f = r100.f46341f;
        this.f46316g = r100.f46344i;
        this.f46317h = r100.f46345j;
        this.f46318i = r100.f46347l;
        this.f46319j = r100.f46348m;
        this.f46320k = r100.f46349n;
        this.f46321l = r100.f46350o;
        this.f46322m = r100.f46351p;
        this.f46323n = r100.f46352q;
        this.f46324o = r100.f46356u;
        this.f46325p = r100.f46353r;
        this.f46326q = r100.f46357v;
        this.f46327r = r100.f46360y;
        this.f46328s = r100.f46361z;
        String r104 = r100.A;
        this.f46329t = r100.f46354s;
        this.f46330u = r100.f46358w;
        this.f46331v = r100.f46355t;
        this.f46332w = r100.f46343h;
        boolean r105 = r100.F;
        this.f46333x = r100.B;
        this.f46334y = r100.E;
        this.f46335z = r100.f46359x;
        ECLynxCard r106 = r100.f46339d;
        this.A = r100.f46340e;
        this.B = r100.G;
        this.C = r100.C;
        this.D = r100.D;
        this.E = r100.H;
    }
}
