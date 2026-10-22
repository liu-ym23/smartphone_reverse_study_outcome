package com.stepos.ailauncher.agent.aispace.market.data;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.network.RetrofitProvider;
import e9.InterfaceC4014c;
import io.ktor.http.ContentDisposition;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007Jh\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\b\b\u0002\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u0016\u0010\u0017JR\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u001e\u0010\u001fJ6\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00102\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\"\u0010#J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00102\u0006\u0010\u000f\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b%\u0010&J&\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00102\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b)\u0010*J&\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b+\u0010,J0\u0010-\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b-\u0010#J&\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0086@¢\u0006\u0004\b.\u0010/J0\u00102\u001a\b\u0012\u0004\u0012\u0002010\u00102\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\tH\u0086@¢\u0006\u0004\b2\u00103J0\u00106\u001a\b\u0012\u0004\u0012\u0002050\u00102\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\tH\u0086@¢\u0006\u0004\b6\u00103Jf\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u00110\u00102\u0006\u00107\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b9\u0010:JN\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0\u00110\u00102\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010;\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b=\u0010>J\\\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00120?2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b@\u0010\u0014J\\\u0010A\u001a\b\u0012\u0004\u0012\u0002080?2\u0006\u00107\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\bA\u0010:J.\u0010B\u001a\b\u0012\u0004\u0012\u00020<0?2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0086@¢\u0006\u0004\bB\u0010CJ\u001e\u0010D\u001a\b\u0012\u0004\u0012\u0002080\u00112\u0006\u0010\b\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bD\u0010&R\u0014\u0010E\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\bL\u0010KR\u001b\u0010R\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u001b\u0010W\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010O\u001a\u0004\bU\u0010V¨\u0006X"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/AgentMarketRepository;", "", "<init>", "()V", "", M5.b.CREDENTIAL_TOKEN, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Ljava/lang/String;", "keyword", "", "page", ContentDisposition.Parameters.Size, "testing", "scanSource", "scanType", "assetId", "Lkotlin/Result;", "", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "k", "(Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/market/data/z;", "m", "(Ljava/lang/String;IILe9/c;)Ljava/lang/Object;", "reversionId", "semver", "", "isUpdate", "displayName", "icon", "y", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Le9/c;)Ljava/lang/Object;", "installType", "Lcom/stepos/ailauncher/agent/aispace/market/data/p;", "s", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/market/data/l;", "p", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", x5.d.EXTRA_ENABLED, "LY8/t;", "C", "(Ljava/lang/String;ZLe9/c;)Ljava/lang/Object;", "F", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "G", "t", "(IILe9/c;)Ljava/lang/Object;", "version", "Lcom/stepos/ailauncher/agent/aispace/market/data/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;ILe9/c;)Ljava/lang/Object;", "skillId", "Lcom/stepos/ailauncher/agent/aispace/market/data/f;", "o", "necessary", "Lcom/stepos/ailauncher/agent/aispace/market/data/e;", "w", "(IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "appType", "Lcom/stepos/ailauncher/agent/aispace/market/data/g;", "q", "(IIILjava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/contract/model/ListPage;", "e", "D", Const.INTENT_KEY_BACKGROUND_COMMAND, "(IIILe9/c;)Ljava/lang/Object;", "B", "TAG", "Ljava/lang/String;", "", "POLL_INTERVAL_MS", "J", "POLL_MAX_FAIL", "I", "POLL_MAX_TIMES", "Lcom/stepos/ailauncher/agent/aispace/market/data/a;", "marketApi$delegate", "LY8/h;", "u", "()Lcom/stepos/ailauncher/agent/aispace/market/data/a;", "marketApi", "Lcom/stepos/ailauncher/agent/aispace/market/data/y;", "migrateApi$delegate", "v", "()Lcom/stepos/ailauncher/agent/aispace/market/data/y;", "migrateApi", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentMarketRepository {
    public static final AgentMarketRepository INSTANCE = new AgentMarketRepository();
    private static final long POLL_INTERVAL_MS = 2000;
    private static final int POLL_MAX_FAIL = 5;
    private static final int POLL_MAX_TIMES = 300;
    private static final String TAG = "AgentMarketRepo";

    /* renamed from: marketApi$delegate, reason: from kotlin metadata */
    private static final Y8.h marketApi;

    /* renamed from: migrateApi$delegate, reason: from kotlin metadata */
    private static final Y8.h migrateApi;

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        marketApi = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.data.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentMarketRepository.z();
            }
        });
        migrateApi = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.data.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentMarketRepository.A();
            }
        });
    }

    public static final y A() {
        return (y) RetrofitProvider.newRetrofit$default(H5.a.INSTANCE.a(C3197a.INSTANCE.a()).e(), null, false, false, false, 30, null).c(y.class);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0107, code lost:
    
        if (r0 == r2) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object E(java.lang.String r27, java.lang.String r28, java.lang.String r29, int r30, int r31, int r32, int r33, boolean r34, e9.InterfaceC4014c<? super com.stepos.ailauncher.agent.aispace.market.data.GetOrSearchSkillListData> r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.E(java.lang.String, java.lang.String, java.lang.String, int, int, int, int, boolean, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0106, code lost:
    
        if (r0 == r2) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(java.lang.String r18, int r19, int r20, int r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, boolean r25, e9.InterfaceC4014c<? super com.stepos.ailauncher.agent.aispace.market.data.GetOrSearchAgentListData> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.f(java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String, boolean, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object j(AgentMarketRepository agentMarketRepository, String str, String str2, int i10, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return agentMarketRepository.i(str, str2, i10, interfaceC4014c);
    }

    public static /* synthetic */ Object l(AgentMarketRepository agentMarketRepository, String str, int i10, int i11, int i12, String str2, String str3, String str4, InterfaceC4014c interfaceC4014c, int i13, Object obj) {
        String str5;
        InterfaceC4014c interfaceC4014c2;
        String str6;
        String str7;
        int i14;
        int i15;
        String str8;
        if ((i13 & 1) != 0) {
            str = "";
        }
        if ((i13 & 2) != 0) {
            i10 = 1;
        }
        if ((i13 & 4) != 0) {
            i11 = 1000;
        }
        if ((i13 & 8) != 0) {
            i12 = 0;
        }
        if ((i13 & 16) != 0) {
            str2 = null;
        }
        if ((i13 & 32) != 0) {
            str3 = null;
        }
        if ((i13 & 64) != 0) {
            str5 = null;
            str6 = str2;
            interfaceC4014c2 = interfaceC4014c;
            i14 = i11;
            str7 = str3;
            str8 = str;
            i15 = i12;
        } else {
            str5 = str4;
            interfaceC4014c2 = interfaceC4014c;
            str6 = str2;
            str7 = str3;
            i14 = i11;
            i15 = i12;
            str8 = str;
        }
        return agentMarketRepository.k(str8, i10, i14, i15, str6, str7, str5, interfaceC4014c2);
    }

    public static /* synthetic */ Object n(AgentMarketRepository agentMarketRepository, String str, int i10, int i11, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = "";
        }
        return agentMarketRepository.m(str, i10, i11, interfaceC4014c);
    }

    public static /* synthetic */ Object r(AgentMarketRepository agentMarketRepository, int i10, int i11, int i12, String str, String str2, InterfaceC4014c interfaceC4014c, int i13, Object obj) {
        String str3;
        InterfaceC4014c interfaceC4014c2;
        int i14;
        String str4;
        int i15;
        if ((i13 & 1) != 0) {
            i10 = 0;
        }
        if ((i13 & 2) != 0) {
            i11 = 1;
        }
        if ((i13 & 4) != 0) {
            i12 = 20;
        }
        if ((i13 & 8) != 0) {
            str = "";
        }
        if ((i13 & 16) != 0) {
            str3 = "";
            i14 = i12;
            interfaceC4014c2 = interfaceC4014c;
            i15 = i10;
            str4 = str;
        } else {
            str3 = str2;
            interfaceC4014c2 = interfaceC4014c;
            i14 = i12;
            str4 = str;
            i15 = i10;
        }
        return agentMarketRepository.q(i15, i11, i14, str4, str3, interfaceC4014c2);
    }

    public static /* synthetic */ Object x(AgentMarketRepository agentMarketRepository, int i10, int i11, int i12, int i13, String str, String str2, String str3, InterfaceC4014c interfaceC4014c, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            i11 = 1;
        }
        int i15 = i11;
        if ((i14 & 4) != 0) {
            i12 = 20;
        }
        int i16 = i12;
        if ((i14 & 8) != 0) {
            i13 = 0;
        }
        return agentMarketRepository.w(i10, i15, i16, i13, (i14 & 16) != 0 ? null : str, (i14 & 32) != 0 ? null : str2, (i14 & 64) != 0 ? null : str3, interfaceC4014c);
    }

    public static final InterfaceC2264a z() {
        return (InterfaceC2264a) RetrofitProvider.newRetrofit$default(H5.a.INSTANCE.a(C3197a.INSTANCE.a()).a(), null, false, false, false, 30, null).c(InterfaceC2264a.class);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:
    
        if (r9 == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(java.lang.String r8, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.agent.aispace.market.data.AgentSkillBean>> r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.B(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x009f, code lost:
    
        if (r11 == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C(java.lang.String r9, boolean r10, e9.InterfaceC4014c<? super kotlin.Result<Y8.t>> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.C(java.lang.String, boolean, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D(int r6, int r7, int r8, int r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, e9.InterfaceC4014c<? super com.stepos.ailauncher.contract.model.ListPage<com.stepos.ailauncher.agent.aispace.market.data.AgentSkillBean>> r13) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.D(int, int, int, int, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a9, code lost:
    
        if (r11 == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F(java.lang.String r9, java.lang.String r10, e9.InterfaceC4014c<? super kotlin.Result<java.lang.String>> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.F(java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0229 -> B:65:0x0231). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G(java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, e9.InterfaceC4014c<? super java.lang.Boolean> r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.G(java.lang.String, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0115 A[LOOP:0: B:44:0x010f->B:46:0x0115, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r6, int r7, int r8, int r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, e9.InterfaceC4014c<? super com.stepos.ailauncher.contract.model.ListPage<com.stepos.ailauncher.agent.aispace.market.AgentMarketItem>> r13) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.e(java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(int r14, int r15, int r16, e9.InterfaceC4014c<? super com.stepos.ailauncher.contract.model.ListPage<com.stepos.ailauncher.agent.aispace.market.data.AppItemDto>> r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.g(int, int, int, e9.c):java.lang.Object");
    }

    public final String h(String token) {
        return "Bearer " + H.D1(H.R0(token, "Bearer ")).toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b1, code lost:
    
        if (r13 == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.String r10, java.lang.String r11, int r12, e9.InterfaceC4014c<? super kotlin.Result<com.stepos.ailauncher.agent.aispace.market.data.GetAgentDetailData>> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.i(java.lang.String, java.lang.String, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x013d, code lost:
    
        if (r1 == r3) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.String r17, int r18, int r19, int r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, e9.InterfaceC4014c<? super kotlin.Result<? extends java.util.List<com.stepos.ailauncher.agent.aispace.market.AgentMarketItem>>> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.k(java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:13:0x003b, B:35:0x00d2, B:37:0x00da, B:39:0x00e2, B:41:0x00e8, B:43:0x00f0, B:46:0x00f8, B:47:0x00fc, B:48:0x010d, B:50:0x0113, B:52:0x0125, B:54:0x012b, B:55:0x0135, B:56:0x015f, B:57:0x0160, B:58:0x0167, B:59:0x0168, B:60:0x0186), top: B:72:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0168 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:13:0x003b, B:35:0x00d2, B:37:0x00da, B:39:0x00e2, B:41:0x00e8, B:43:0x00f0, B:46:0x00f8, B:47:0x00fc, B:48:0x010d, B:50:0x0113, B:52:0x0125, B:54:0x012b, B:55:0x0135, B:56:0x015f, B:57:0x0160, B:58:0x0167, B:59:0x0168, B:60:0x0186), top: B:72:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(java.lang.String r21, int r22, int r23, e9.InterfaceC4014c<? super kotlin.Result<com.stepos.ailauncher.agent.aispace.market.data.PagedAgents>> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.m(java.lang.String, int, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ae, code lost:
    
        if (r13 == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.String r10, java.lang.String r11, int r12, e9.InterfaceC4014c<? super kotlin.Result<com.stepos.ailauncher.agent.aispace.market.data.AgentSkillDto>> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.o(java.lang.String, java.lang.String, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0098, code lost:
    
        if (r10 == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.String r9, e9.InterfaceC4014c<? super kotlin.Result<com.stepos.ailauncher.agent.aispace.market.data.GetAgentStatusData>> r10) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.p(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c2, code lost:
    
        if (r14 == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(int r9, int r10, int r11, java.lang.String r12, java.lang.String r13, e9.InterfaceC4014c<? super kotlin.Result<? extends java.util.List<com.stepos.ailauncher.agent.aispace.market.data.AppItemDto>>> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.q(int, int, int, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00cb, code lost:
    
        if (r13 == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, e9.InterfaceC4014c<? super kotlin.Result<com.stepos.ailauncher.agent.aispace.market.data.GetInstallProgressData>> r13) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.s(java.lang.String, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:4|(1:6)(1:7))(0)|8|(1:66)|(1:(1:(4:12|13|31|(2:33|(2:35|(12:37|(1:39)(1:40)|(1:42)|43|(2:46|44)|67|47|(1:49)|50|60|(1:62)|63)(2:51|52))(2:53|54))(2:55|56))(2:17|18))(3:19|20|21))(4:22|23|(1:26)|29)|64|27|(3:30|31|(0)(0))|29|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0157, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0158, code lost:
    
        r9 = r0;
        r10 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x015a, code lost:
    
        r11 = kotlin.Result.INSTANCE;
        r9 = kotlin.Result.b(kotlin.C4849c.a(r9));
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a7 A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:13:0x0033, B:31:0x009f, B:33:0x00a7, B:35:0x00af, B:37:0x00b5, B:39:0x00bd, B:42:0x00c5, B:43:0x00c9, B:44:0x00da, B:46:0x00e0, B:47:0x00f0, B:49:0x00f9, B:50:0x00fd, B:51:0x0105, B:52:0x012f, B:53:0x0130, B:54:0x0137, B:55:0x0138, B:56:0x0156, B:20:0x004e, B:23:0x005b), top: B:66:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0138 A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:13:0x0033, B:31:0x009f, B:33:0x00a7, B:35:0x00af, B:37:0x00b5, B:39:0x00bd, B:42:0x00c5, B:43:0x00c9, B:44:0x00da, B:46:0x00e0, B:47:0x00f0, B:49:0x00f9, B:50:0x00fd, B:51:0x0105, B:52:0x012f, B:53:0x0130, B:54:0x0137, B:55:0x0138, B:56:0x0156, B:20:0x004e, B:23:0x005b), top: B:66:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(int r10, int r11, e9.InterfaceC4014c<? super kotlin.Result<com.stepos.ailauncher.agent.aispace.market.data.PagedAgents>> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.t(int, int, e9.c):java.lang.Object");
    }

    public final InterfaceC2264a u() {
        Object value = marketApi.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        return (InterfaceC2264a) value;
    }

    public final y v() {
        Object value = migrateApi.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        return (y) value;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0127, code lost:
    
        if (r1 == r3) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(int r26, int r27, int r28, int r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, e9.InterfaceC4014c<? super kotlin.Result<? extends java.util.List<com.stepos.ailauncher.agent.aispace.market.data.AgentSkillBean>>> r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.w(int, int, int, int, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0126, code lost:
    
        if (r1 != r3) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(java.lang.String r19, java.lang.String r20, java.lang.String r21, boolean r22, java.lang.String r23, boolean r24, java.lang.String r25, e9.InterfaceC4014c<? super kotlin.Result<java.lang.String>> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.y(java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, boolean, java.lang.String, e9.c):java.lang.Object");
    }
}
