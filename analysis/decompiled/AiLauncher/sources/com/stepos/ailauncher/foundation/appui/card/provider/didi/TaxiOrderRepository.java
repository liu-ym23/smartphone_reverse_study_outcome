package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import Ua.L0;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiOrderApi;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.api.TaxiOrderApi;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.f0;
import com.stepos.net.HttpManager;
import eb.InterfaceC4021a;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ>\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J>\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0082@¢\u0006\u0004\b\u0011\u0010\u0010J4\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R&\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0%0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010-\u001a\u0004\u0018\u00010(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001d\u00102\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/TaxiOrderRepository;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;", "vendor", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;)Z", "", "orderNo", "platformOrderId", "cardTaskId", "userId", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "m", "o", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "n", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "outcome", "LY8/t;", "k", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0;)V", "TAG", "Ljava/lang/String;", "BASE_URL_KEY_MCP_GW", "BASE_URL_KEY_AGI_AI_TOOLS", "LUa/M;", "scope", "LUa/M;", "Leb/a;", "mutex", "Leb/a;", "", "LUa/Q;", "inflight", "Ljava/util/Map;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/TaxiOrderApi;", "mcpGwApi$delegate", "LY8/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/TaxiOrderApi;", "mcpGwApi", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiOrderApi;", "didiApi$delegate", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiOrderApi;", "didiApi", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaxiOrderRepository {
    private static final String BASE_URL_KEY_AGI_AI_TOOLS = "agiAiTools";
    private static final String BASE_URL_KEY_MCP_GW = "mcpGw";
    private static final String TAG = "TaxiOrderRepo";
    public static final TaxiOrderRepository INSTANCE = new TaxiOrderRepository();
    private static final Ua.M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Ua.Y.b()));
    private static final InterfaceC4021a mutex = eb.f.b(false, 1, null);
    private static final Map<String, Ua.Q<f0>> inflight = new LinkedHashMap();

    /* renamed from: mcpGwApi$delegate, reason: from kotlin metadata */
    private static final Y8.h mcpGwApi = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.i0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return TaxiOrderRepository.l();
        }
    });

    /* renamed from: didiApi$delegate, reason: from kotlin metadata */
    private static final Y8.h didiApi = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.j0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return TaxiOrderRepository.f();
        }
    });

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TaxiPollSource.values().length];
            try {
                iArr[TaxiPollSource.MCP_GATEWAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TaxiPollSource.DIDI_ADAPTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DidiOrderApi f() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(HttpManager.INSTANCE.create(DidiOrderApi.class, BASE_URL_KEY_AGI_AI_TOOLS));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "HttpManager.create<" + DidiOrderApi.class.getSimpleName() + ">(\"" + BASE_URL_KEY_AGI_AI_TOOLS + "\") 失败，该厂商的端侧轮询不可用（多半是对应 baseUrl 未配置，见 IEnvConfig）", thE, false, 8, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (DidiOrderApi) objB;
    }

    public static final TaxiOrderApi l() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(HttpManager.INSTANCE.create(TaxiOrderApi.class, BASE_URL_KEY_MCP_GW));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "HttpManager.create<" + TaxiOrderApi.class.getSimpleName() + ">(\"" + BASE_URL_KEY_MCP_GW + "\") 失败，该厂商的端侧轮询不可用（多半是对应 baseUrl 未配置，见 IEnvConfig）", thE, false, 8, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (TaxiOrderApi) objB;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(1:(1:(7:14|86|68|(1:70)|73|74|75)(2:15|16))(7:17|90|50|(1:52)|55|56|57))(9:18|80|19|20|84|45|46|(7:49|90|50|(0)|55|56|57)|66))(1:23))(3:24|(1:27)|66)|82|28|(3:30|(1:32)(1:33)|(1:35)(6:36|40|88|41|(5:44|84|45|46|(0))|66))|39|40|88|41|(0)|66|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01cd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01ce, code lost:
    
        r3 = r0;
        r5 = r11;
        r6 = r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01b9 A[Catch: all -> 0x01bd, TryCatch #5 {all -> 0x01bd, blocks: (B:50:0x01b1, B:52:0x01b9, B:55:0x01bf), top: B:90:0x01b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0208 A[Catch: all -> 0x020c, TryCatch #3 {all -> 0x020c, blocks: (B:68:0x0200, B:70:0x0208, B:73:0x020e), top: B:86:0x0200 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiVendorSpec r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appui.card.provider.didi.f0> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderRepository.g(com.stepos.ailauncher.foundation.appui.card.provider.didi.p0, java.lang.String, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final DidiOrderApi h() {
        return (DidiOrderApi) didiApi.getValue();
    }

    public final TaxiOrderApi i() {
        return (TaxiOrderApi) mcpGwApi.getValue();
    }

    public final boolean j(TaxiVendorSpec vendor) {
        kotlin.jvm.internal.p.i(vendor, "vendor");
        int i10 = a.$EnumSwitchMapping$0[vendor.getPollSource().ordinal()];
        if (i10 == 1) {
            return i() != null;
        }
        if (i10 == 2) {
            return h() != null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void k(TaxiVendorSpec vendor, String orderNo, f0 outcome) {
        f0.Ok ok = outcome instanceof f0.Ok ? (f0.Ok) outcome : null;
        if (ok == null) {
            return;
        }
        R5.b.INSTANCE.e("poller.raw:" + orderNo + ServerSentEventKt.COLON + ok.getTaskStatus() + ServerSentEventKt.COLON + ok.getSnapshot().get(D6.a.KEY_TASK_STATUS), "poller.raw", Y8.j.a("orderNo", orderNo), Y8.j.a("source", vendor.getPollSource()), Y8.j.a("trackStatus", ok.getTrackStatus()), Y8.j.a(D6.a.KEY_TASK_STATUS, ok.getTaskStatus()), Y8.j.a("nextPollAt", ok.getNextPollAt()), Y8.j.a("snapshotKeys", ok.getSnapshot().keySet()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c9, code lost:
    
        if (r12 == r1) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiVendorSpec r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appui.card.provider.didi.f0> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderRepository.m(com.stepos.ailauncher.foundation.appui.card.provider.didi.p0, java.lang.String, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(java.lang.String r7, java.lang.String r8, java.lang.String r9, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appui.card.provider.didi.f0> r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderRepository$requestDidiAdapter$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderRepository$requestDidiAdapter$1 r0 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderRepository$requestDidiAdapter$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderRepository$requestDidiAdapter$1 r0 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderRepository$requestDidiAdapter$1
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L4a
            if (r2 != r3) goto L42
            java.lang.Object r6 = r0.L$5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$4
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$3
            com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiOrderApi r6 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiOrderApi) r6
            java.lang.Object r6 = r0.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r10)
            goto Lab
        L42:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L4a:
            kotlin.C4849c.b(r10)
            com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiOrderApi r6 = r6.h()
            if (r6 != 0) goto L5b
            com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$c r6 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$c
            java.lang.String r7 = "api_unavailable"
            r6.<init>(r7)
            return r6
        L5b:
            if (r9 == 0) goto Lb2
            boolean r10 = La.H.x0(r9)
            r2 = 0
            if (r10 != 0) goto L66
            r10 = r9
            goto L67
        L66:
            r10 = r2
        L67:
            if (r10 != 0) goto L6a
            goto Lb2
        L6a:
            boolean r4 = La.H.x0(r7)
            if (r4 != 0) goto L72
            r4 = r7
            goto L73
        L72:
            r4 = r2
        L73:
            if (r4 != 0) goto L7e
            if (r8 == 0) goto L7e
            boolean r5 = La.H.x0(r8)
            if (r5 != 0) goto L7e
            r2 = r8
        L7e:
            java.lang.Object r7 = g9.h.a(r7)
            r0.L$0 = r7
            java.lang.Object r7 = g9.h.a(r8)
            r0.L$1 = r7
            java.lang.Object r7 = g9.h.a(r9)
            r0.L$2 = r7
            java.lang.Object r7 = g9.h.a(r6)
            r0.L$3 = r7
            java.lang.Object r7 = g9.h.a(r10)
            r0.L$4 = r7
            java.lang.Object r7 = g9.h.a(r4)
            r0.L$5 = r7
            r0.label = r3
            java.lang.Object r10 = r6.order(r10, r4, r2, r0)
            if (r10 != r1) goto Lab
            return r1
        Lab:
            yc.v r10 = (yc.v) r10
            com.stepos.ailauncher.foundation.appui.card.provider.didi.f0 r6 = com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiOrderApiKt.toTaxiOutcome(r10)
            return r6
        Lb2:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$c r6 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$c
            java.lang.String r7 = "no_user_id"
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderRepository.n(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiVendorSpec r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appui.card.provider.didi.f0> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderRepository.o(com.stepos.ailauncher.foundation.appui.card.provider.didi.p0, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }
}
