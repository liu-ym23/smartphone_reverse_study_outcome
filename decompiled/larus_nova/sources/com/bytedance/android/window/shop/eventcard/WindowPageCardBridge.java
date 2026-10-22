package com.bytedance.android.window.shop.eventcard;

import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.monitor.ECHybridLogUtil;
import com.bytedance.android.ec.hybrid.monitor.c;
import com.bytedance.android.window.shop.eventcard.handler.LynxABReadHandler;
import com.bytedance.android.window.shop.eventcard.handler.LynxCallEventHandler;
import com.bytedance.android.window.shop.eventcard.handler.LynxNativeDBHandler;
import com.bytedance.android.window.shop.eventcard.handler.LynxPreferenceHandler;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import yj.g;

/* JADX INFO: loaded from: classes14.dex */
public final class WindowPageCardBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.window.shop.eventcard.handler.b f187775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LynxCallEventHandler f187776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, com.bytedance.android.window.shop.eventcard.handler.a> f187777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECWindowViewModel f187778d;

    public final class a implements IDLXBridgeMethod, h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IDLXBridgeMethod.Access f187779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IDLXBridgeMethod.Compatibility f187780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<Map<String, ? extends Object>, Map<String, Object>> f187781c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f187782d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f187783e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ WindowPageCardBridge f187784f;

        /* JADX INFO: renamed from: com.bytedance.android.window.shop.eventcard.WindowPageCardBridge$a$a, reason: collision with other inner class name */
        public static final class RunnableC2749a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f187785a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Map f187786b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IDLXBridgeMethod.a f187787c;

            public RunnableC2749a(a r100, Map r101, IDLXBridgeMethod.a r102) {
                this.f187785a = r100;
                this.f187786b = r101;
                this.f187787c = r102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f187785a.a(this.f187786b, this.f187787c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
        public final boolean canRunInBackground() {
            return false;
        }

        @Override // com.bytedance.sdk.xbridge.cn.protocol.h
        public final void release() {
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
        public final IDLXBridgeMethod.Access getAccess() {
            return this.f187779a;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
        public final IDLXBridgeMethod.Compatibility getCompatibility() {
            return this.f187780b;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
        public final String getName() {
            return this.f187782d;
        }

        public final void a(Map<String, ? extends Object> r100, IDLXBridgeMethod.a r101) {
            Map<String, ? extends Object> r102 = (Map) this.f187781c.invoke(r100);
            Lazy r103 = ECHybridLogUtil.f47525a;
            String r104 = this.f187782d;
            Intrinsics.checkNotNullParameter(r100, "callMsg");
            Intrinsics.checkNotNullParameter(r102, "backMsg");
            Intrinsics.checkNotNullParameter(r104, "eventName");
            IHybridHostService r105 = com.bytedance.android.ec.hybrid.a.h();
            if (r105 == null) goto L9;
            g r106 = r105.getHostAB();
            if (r106 == null) goto L9;
            Map<String, List<String>> r107 = r106.s();
            if (r107 == null) goto L9;
            List<String> r108 = r107.get(PrefetchTiming.JSB);
        L10:
            if (r108 != null) goto L12;
        L14:
            com.bytedance.android.ec.hybrid.a.i(new c(r100, r102, r104));
        L15:
            r101.invoke(r102);
            return;
        L12:
            if (r108.contains(r104) == false) goto L14;
        L9:
            r108 = null;
            goto L10
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
        public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
            Intrinsics.checkNotNullParameter(r100, "bridgeContext");
            Intrinsics.checkNotNullParameter(r101, "params");
            Intrinsics.checkNotNullParameter(r102, "callback");
            if (this.f187783e == false) goto L5;
            this.f187784f.f187778d.add(Schedulers.computation().scheduleDirect(new RunnableC2749a(this, r101, r102)));
            return;
        L5:
            a(r101, r102);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(WindowPageCardBridge r100, Function1<? super Map<String, ? extends Object>, ? extends Map<String, ? extends Object>> r101, String r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "realHandler");
            Intrinsics.checkNotNullParameter(r102, "name");
            this.f187784f = r100;
            this.f187781c = r101;
            this.f187782d = r102;
            this.f187783e = r103;
            this.f187779a = IDLXBridgeMethod.Access.PUBLIC;
            this.f187780b = IDLXBridgeMethod.Compatibility.Compatible;
        }
    }

    public static final class b {
    }

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.eventcard.WindowPageCardBridge$call$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, Boolean> {
        public AnonymousClass1(com.bytedance.android.window.shop.eventcard.handler.b r100) {
            super(1, r100, com.bytedance.android.window.shop.eventcard.handler.b.class, "checkBlocked", "checkBlocked(Ljava/lang/String;)Ljava/lang/Boolean;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(String r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            com.bytedance.android.window.shop.eventcard.handler.b r101 = (com.bytedance.android.window.shop.eventcard.handler.b) this.receiver;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "key");
            Boolean r102 = r101.f187800a.get(r100);
            if (r102 == null) goto L5;
            r101.f187800a.put(r100, Boolean.FALSE);
        L5:
            return r102;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(String r100) {
            return invoke2(r100);
        }
    }

    static {
    }

    public WindowPageCardBridge(ECWindowViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "shopViewModel");
        this.f187778d = r100;
        com.bytedance.android.window.shop.eventcard.handler.b r101 = new com.bytedance.android.window.shop.eventcard.handler.b();
        this.f187775a = r101;
        LynxCallEventHandler r102 = new LynxCallEventHandler(r100);
        this.f187776b = r102;
        this.f187777c = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(1, r102), TuplesKt.to(3, r101), TuplesKt.to(5, LynxPreferenceHandler.f187797a), TuplesKt.to(6, LynxABReadHandler.f187788a), TuplesKt.to(7, LynxNativeDBHandler.f187794c)});
    }

    public static final Map a(WindowPageCardBridge r100, Map r101) {
        r100.getClass();
        Object r102 = r101.get("event_type");
        if ((r102 instanceof Integer) == true) goto L5;
        r102 = null;
    L5:
        Integer r103 = (Integer) r102;
        if (r103 == null) goto L8;
        int r104 = r103.intValue();
    L9:
        com.bytedance.android.window.shop.eventcard.handler.a r105 = r100.f187777c.get(Integer.valueOf(r104));
        if (r105 != null) goto L13;
        return MapsKt.emptyMap();
    L13:
        return r105.a(r104, r101);
    L8:
        r104 = 0;
        goto L9
    }

    public final boolean call(ECLynxCard r100, cp3.a r101) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r101, "params");
        return this.f187776b.b(r100, r101, new AnonymousClass1(this.f187775a));
    }
}
