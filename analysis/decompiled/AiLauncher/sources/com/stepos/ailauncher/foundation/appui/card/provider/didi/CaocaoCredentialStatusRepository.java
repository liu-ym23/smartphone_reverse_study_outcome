package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import Ua.L0;
import android.os.SystemClock;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusApi;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusData;
import com.stepos.net.HttpManager;
import eb.InterfaceC4021a;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001:\u000256B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u0012\u0010\u0013J2\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020-0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00104\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/CaocaoCredentialStatusRepository;", "", "<init>", "()V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "", "accountKey", "vendorId", "integrationId", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusData;", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusData;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/b;", "l", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusApi;", "service", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusApi;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "f", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusApi;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "BASE_URL_KEY", "", "POSITIVE_TTL_MS", "J", "LUa/M;", "scope", "LUa/M;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/CaocaoCredentialStatusRepository$a;", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "Leb/a;", "mutex", "Leb/a;", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/CaocaoCredentialStatusRepository$b;", "inflight", "Ljava/util/Map;", "api$delegate", "LY8/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusApi;", "api", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CaocaoCredentialStatusRepository {
    private static final String BASE_URL_KEY = "caocaoCredentialStatus";
    private static final long POSITIVE_TTL_MS = 600000;
    private static final String TAG = "CaocaoCredentialRepo";
    public static final CaocaoCredentialStatusRepository INSTANCE = new CaocaoCredentialStatusRepository();
    private static final Ua.M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Ua.Y.b()));
    private static final ConcurrentHashMap<String, CachedAuth> cache = new ConcurrentHashMap<>();
    private static final InterfaceC4021a mutex = eb.f.b(false, 1, null);
    private static final Map<String, Inflight> inflight = new LinkedHashMap();

    /* renamed from: api$delegate, reason: from kotlin metadata */
    private static final Y8.h api = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.c
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return CaocaoCredentialStatusRepository.d();
        }
    });

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/CaocaoCredentialStatusRepository$a;", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusData;", "data", "", "atElapsed", "<init>", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusData;J)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusData;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusData;", "J", Const.INTENT_KEY_APIKEY, "()J", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository$a, reason: from toString */
    public static final /* data */ class CachedAuth {
        private final long atElapsed;
        private final CaocaoCredentialStatusData data;

        public CachedAuth(CaocaoCredentialStatusData data, long j10) {
            kotlin.jvm.internal.p.i(data, "data");
            this.data = data;
            this.atElapsed = j10;
        }

        /* renamed from: a, reason: from getter */
        public final long getAtElapsed() {
            return this.atElapsed;
        }

        /* renamed from: b, reason: from getter */
        public final CaocaoCredentialStatusData getData() {
            return this.data;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CachedAuth)) {
                return false;
            }
            CachedAuth cachedAuth = (CachedAuth) other;
            return kotlin.jvm.internal.p.d(this.data, cachedAuth.data) && this.atElapsed == cachedAuth.atElapsed;
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + Long.hashCode(this.atElapsed);
        }

        public String toString() {
            return "CachedAuth(data=" + this.data + ", atElapsed=" + this.atElapsed + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/CaocaoCredentialStatusRepository$b;", "", "LUa/Q;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusData;", "deferred", "<init>", "(LUa/Q;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "LUa/Q;", Const.INTENT_KEY_APIKEY, "()LUa/Q;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository$b, reason: from toString */
    public static final /* data */ class Inflight {
        private final Ua.Q<CaocaoCredentialStatusData> deferred;

        public Inflight(Ua.Q<CaocaoCredentialStatusData> deferred) {
            kotlin.jvm.internal.p.i(deferred, "deferred");
            this.deferred = deferred;
        }

        public final Ua.Q<CaocaoCredentialStatusData> a() {
            return this.deferred;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Inflight) && kotlin.jvm.internal.p.d(this.deferred, ((Inflight) other).deferred);
        }

        public int hashCode() {
            return this.deferred.hashCode();
        }

        public String toString() {
            return "Inflight(deferred=" + this.deferred + ")";
        }
    }

    public static final CaocaoCredentialStatusApi d() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((CaocaoCredentialStatusApi) HttpManager.INSTANCE.create(CaocaoCredentialStatusApi.class, BASE_URL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "创建曹操授权状态 API 失败，查询不可用", thE);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (CaocaoCredentialStatusApi) objB;
    }

    public final String e(String accountKey, String vendorId, String integrationId) {
        return accountKey + "|" + vendorId + "|" + integrationId;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusApi r7, java.lang.String r8, java.lang.String r9, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusData> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository.f(com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusApi, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(1:(1:(7:14|75|63|(1:65)|68|69|70)(2:15|16))(7:17|85|45|(1:47)|50|51|52))(9:18|77|19|20|79|40|41|(7:44|85|45|(0)|50|51|52)|61))(1:24))(3:25|(1:28)|61)|81|29|(1:31)|35|83|36|(5:39|79|40|41|(0))|61|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01bd, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01be, code lost:
    
        r9 = r1;
        r6 = r2;
        r2 = r14;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a9 A[Catch: all -> 0x01ad, TryCatch #5 {all -> 0x01ad, blocks: (B:45:0x01a1, B:47:0x01a9, B:50:0x01af), top: B:85:0x01a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01fd A[Catch: all -> 0x0201, TryCatch #0 {all -> 0x0201, blocks: (B:63:0x01f5, B:65:0x01fd, B:68:0x0203), top: B:75:0x01f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusApi r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusData> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository.g(com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusApi, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final CaocaoCredentialStatusApi h() {
        return (CaocaoCredentialStatusApi) api.getValue();
    }

    public final void i(String accountKey, String vendorId, String integrationId) {
        kotlin.jvm.internal.p.i(accountKey, "accountKey");
        kotlin.jvm.internal.p.i(vendorId, "vendorId");
        kotlin.jvm.internal.p.i(integrationId, "integrationId");
        if (accountKey.length() == 0) {
            return;
        }
        cache.remove(e(accountKey, vendorId, integrationId));
    }

    public final boolean j() {
        return h() != null;
    }

    public final CaocaoCredentialStatusData k(String accountKey, String vendorId, String integrationId) {
        kotlin.jvm.internal.p.i(accountKey, "accountKey");
        kotlin.jvm.internal.p.i(vendorId, "vendorId");
        kotlin.jvm.internal.p.i(integrationId, "integrationId");
        String strE = e(accountKey, vendorId, integrationId);
        ConcurrentHashMap<String, CachedAuth> concurrentHashMap = cache;
        CachedAuth cachedAuth = concurrentHashMap.get(strE);
        if (cachedAuth == null) {
            return null;
        }
        if (SystemClock.elapsedRealtime() - cachedAuth.getAtElapsed() < 600000) {
            return cachedAuth.getData();
        }
        concurrentHashMap.remove(strE);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(java.lang.String r8, java.lang.String r9, java.lang.String r10, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appui.card.provider.didi.InterfaceC3305b> r11) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository$query$1
            if (r0 == 0) goto L14
            r0 = r11
            com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository$query$1 r0 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository$query$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository$query$1 r0 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository$query$1
            r0.<init>(r7, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L46
            if (r1 != r2) goto L3e
            java.lang.Object r8 = r6.L$3
            com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusApi r8 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusApi) r8
            java.lang.Object r8 = r6.L$2
            r10 = r8
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r8 = r6.L$1
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r8 = r6.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.C4849c.b(r11)
            r1 = r7
            goto L92
        L3e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L46:
            kotlin.C4849c.b(r11)
            int r11 = r8.length()
            if (r11 != 0) goto L50
            goto L5d
        L50:
            int r11 = r9.length()
            if (r11 != 0) goto L57
            goto L5d
        L57:
            int r11 = r10.length()
            if (r11 != 0) goto L60
        L5d:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.b$c r7 = com.stepos.ailauncher.foundation.appui.card.provider.didi.InterfaceC3305b.c.INSTANCE
            return r7
        L60:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusData r11 = r7.k(r8, r9, r10)
            if (r11 == 0) goto L6c
            com.stepos.ailauncher.foundation.appui.card.provider.didi.b$a r7 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.b$a
            r7.<init>(r11)
            return r7
        L6c:
            r11 = r2
            com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusApi r2 = r7.h()
            if (r2 != 0) goto L76
            com.stepos.ailauncher.foundation.appui.card.provider.didi.b$c r7 = com.stepos.ailauncher.foundation.appui.card.provider.didi.InterfaceC3305b.c.INSTANCE
            return r7
        L76:
            r6.L$0 = r8
            r6.L$1 = r9
            r6.L$2 = r10
            java.lang.Object r1 = g9.h.a(r2)
            r6.L$3 = r1
            r6.label = r11
            r1 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            java.lang.Object r11 = r1.g(r2, r3, r4, r5, r6)
            if (r11 != r0) goto L8f
            return r0
        L8f:
            r8 = r3
            r9 = r4
            r10 = r5
        L92:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusData r11 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusData) r11
            if (r11 != 0) goto L99
            com.stepos.ailauncher.foundation.appui.card.provider.didi.b$c r7 = com.stepos.ailauncher.foundation.appui.card.provider.didi.InterfaceC3305b.c.INSTANCE
            return r7
        L99:
            java.lang.String r7 = r1.e(r8, r9, r10)
            boolean r8 = r11.isAuthorized()
            if (r8 == 0) goto Lb7
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository$a> r8 = com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository.cache
            com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository$a r9 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository$a
            long r0 = android.os.SystemClock.elapsedRealtime()
            r9.<init>(r11, r0)
            r8.put(r7, r9)
            com.stepos.ailauncher.foundation.appui.card.provider.didi.b$a r7 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.b$a
            r7.<init>(r11)
            return r7
        Lb7:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository$a> r8 = com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository.cache
            r8.remove(r7)
            com.stepos.ailauncher.foundation.appui.card.provider.didi.b$b r7 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.b$b
            r7.<init>(r11)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository.l(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }
}
