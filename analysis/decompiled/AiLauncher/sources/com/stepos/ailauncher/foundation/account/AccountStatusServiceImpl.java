package com.stepos.ailauncher.foundation.account;

import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Q;
import Ua.Y;
import Xa.t;
import Xa.u;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.account.IAccountStatusService;
import com.stepos.ailauncher.contract.model.AccountStatus;
import com.stepos.ailauncher.foundation.account.api.AccountStatusApi;
import com.stepos.net.HttpManager;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u00019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0013\u0010\bJ\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0014\u0010\bJ)\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R \u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060,8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b\u0007\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/stepos/ailauncher/foundation/account/AccountStatusServiceImpl;", "Lcom/stepos/ailauncher/contract/api/account/IAccountStatusService;", "<init>", "()V", "", "uid", "Lcom/stepos/ailauncher/contract/model/AccountStatus;", "getStatus", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "peekStatus", "(Ljava/lang/String;)Lcom/stepos/ailauncher/contract/model/AccountStatus;", "", "serverNow", "()J", "reason", "screenCode", "LY8/t;", "notifyAccountSignal", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "result", "k", "(Ljava/lang/String;Lcom/stepos/ailauncher/contract/model/AccountStatus;Ljava/lang/Long;)V", "TAG", "Ljava/lang/String;", "Lcom/stepos/ailauncher/foundation/account/AccountStatusServiceImpl$a;", "snapshot", "Lcom/stepos/ailauncher/foundation/account/AccountStatusServiceImpl$a;", "Leb/a;", "mutex", "Leb/a;", "LUa/Q;", "inflight", "LUa/Q;", "inflightUid", "Lkotlinx/coroutines/g;", "valveJob", "Lkotlinx/coroutines/g;", "serverClockOffset", "Ljava/lang/Long;", "LXa/k;", "_status", "LXa/k;", "LXa/t;", "status", "LXa/t;", "()LXa/t;", "LUa/M;", "scope", "LUa/M;", "Lcom/stepos/ailauncher/foundation/account/api/AccountStatusApi;", "api$delegate", "LY8/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lcom/stepos/ailauncher/foundation/account/api/AccountStatusApi;", "api", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AccountStatusServiceImpl implements IAccountStatusService {
    private static final String TAG = "AccountStatusService";
    private static final Xa.k<AccountStatus> _status;

    /* renamed from: api$delegate, reason: from kotlin metadata */
    private static final Y8.h api;
    private static Q<? extends AccountStatus> inflight;
    private static String inflightUid;
    private static final M scope;
    private static volatile Long serverClockOffset;
    private static volatile Snapshot snapshot;
    private static final t<AccountStatus> status;
    private static volatile kotlinx.coroutines.g valveJob;
    public static final AccountStatusServiceImpl INSTANCE = new AccountStatusServiceImpl();
    private static final InterfaceC4021a mutex = eb.f.b(false, 1, null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/foundation/account/AccountStatusServiceImpl$a;", "", "", "uid", "Lcom/stepos/ailauncher/contract/model/AccountStatus;", "raw", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/contract/model/AccountStatus;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/contract/model/AccountStatus;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/contract/model/AccountStatus;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl$a, reason: from toString */
    public static final /* data */ class Snapshot {
        private final AccountStatus raw;
        private final String uid;

        public Snapshot(String uid, AccountStatus raw) {
            p.i(uid, "uid");
            p.i(raw, "raw");
            this.uid = uid;
            this.raw = raw;
        }

        /* renamed from: a, reason: from getter */
        public final AccountStatus getRaw() {
            return this.raw;
        }

        /* renamed from: b, reason: from getter */
        public final String getUid() {
            return this.uid;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) other;
            return p.d(this.uid, snapshot.uid) && p.d(this.raw, snapshot.raw);
        }

        public int hashCode() {
            return (this.uid.hashCode() * 31) + this.raw.hashCode();
        }

        public String toString() {
            return "Snapshot(uid=" + this.uid + ", raw=" + this.raw + ")";
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl", f = "AccountStatusServiceImpl.kt", l = {105}, m = "notifyAccountSignal", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl$notifyAccountSignal$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AccountStatusServiceImpl.this.notifyAccountSignal(null, null, null, this);
        }
    }

    static {
        Xa.k<AccountStatus> kVarA = u.a(AccountStatus.Available.INSTANCE);
        _status = kVarA;
        status = Xa.d.c(kVarA);
        scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));
        api = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.account.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AccountStatusServiceImpl.g();
            }
        });
    }

    public static final AccountStatusApi g() throws Throwable {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((AccountStatusApi) HttpManager.INSTANCE.create(AccountStatusApi.class, "skillStore"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g(TAG, "HttpManager.create<AccountStatusApi> failed", thE, false, 8, null);
        }
        C4849c.b(objB);
        return (AccountStatusApi) objB;
    }

    @Override // com.stepos.ailauncher.contract.api.account.IAccountStatusService
    public t<AccountStatus> getStatus() {
        return status;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.lang.String r7, e9.InterfaceC4014c<? super com.stepos.ailauncher.contract.model.AccountStatus> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl.h(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(1:(1:(1:(1:(7:14|85|65|(1:67)|70|71|72)(2:15|16))(7:17|83|49|(1:51)|54|55|56))(7:18|81|19|44|45|(7:48|83|49|(0)|54|55|56)|63))(1:23))(3:24|(1:27)|63)|79|28|(1:37)|34|39|77|40|(4:43|44|45|(0))|63) */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0110, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0111, code lost:
    
        r3 = r0;
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x012c, code lost:
    
        r2 = r0;
        r4 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ff A[Catch: all -> 0x0104, TryCatch #3 {all -> 0x0104, blocks: (B:49:0x00fb, B:51:0x00ff, B:54:0x0106), top: B:83:0x00fb }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0132 A[Catch: all -> 0x0137, TryCatch #4 {all -> 0x0137, blocks: (B:65:0x012e, B:67:0x0132, B:70:0x0139), top: B:85:0x012e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.String r17, e9.InterfaceC4014c<? super com.stepos.ailauncher.contract.model.AccountStatus> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl.i(java.lang.String, e9.c):java.lang.Object");
    }

    public final AccountStatusApi j() {
        return (AccountStatusApi) api.getValue();
    }

    public final void k(String uid, AccountStatus result, Long serverNow) {
        if (!(result instanceof AccountStatus.Banned)) {
            kotlinx.coroutines.g gVar = valveJob;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            valveJob = null;
            return;
        }
        AccountStatus.Banned banned = (AccountStatus.Banned) result;
        Long endMillis = banned.getEndMillis();
        Long startMillis = banned.getStartMillis();
        Long lValueOf = (serverNow == null || endMillis == null) ? (startMillis == null || endMillis == null || endMillis.longValue() <= startMillis.longValue()) ? null : Long.valueOf(endMillis.longValue() - startMillis.longValue()) : Long.valueOf(endMillis.longValue() - serverNow.longValue());
        if (lValueOf == null || lValueOf.longValue() <= 0) {
            kotlinx.coroutines.g gVar2 = valveJob;
            if (gVar2 != null) {
                kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
            }
            valveJob = null;
            return;
        }
        kotlinx.coroutines.g gVar3 = valveJob;
        if (gVar3 != null) {
            kotlinx.coroutines.g.Y0(gVar3, null, 1, null);
        }
        valveJob = C1060i.d(scope, null, null, new AccountStatusServiceImpl$installSafetyValve$1(lValueOf, snapshot, uid, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.contract.api.account.IAccountStatusService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object notifyAccountSignal(java.lang.String r8, java.lang.String r9, java.lang.String r10, e9.InterfaceC4014c<? super Y8.t> r11) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl$notifyAccountSignal$1 r0 = (com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl$notifyAccountSignal$1 r0 = new com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl$notifyAccountSignal$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.C4849c.b(r11)
            goto L84
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            kotlin.C4849c.b(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r2 = "notifyAccountSignal uid="
            r11.append(r2)
            r11.append(r8)
            java.lang.String r2 = " reason="
            r11.append(r2)
            r11.append(r9)
            java.lang.String r2 = " screenCode="
            r11.append(r2)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            r2 = 4
            r4 = 0
            java.lang.String r5 = "AccountStatusService"
            r6 = 0
            h8.C4148a.k(r5, r11, r6, r2, r4)
            java.lang.Object r11 = g9.h.a(r8)
            r0.L$0 = r11
            java.lang.Object r9 = g9.h.a(r9)
            r0.L$1 = r9
            java.lang.Object r9 = g9.h.a(r10)
            r0.L$2 = r9
            r0.label = r3
            java.lang.Object r11 = r7.i(r8, r0)
            if (r11 != r1) goto L84
            return r1
        L84:
            com.stepos.ailauncher.contract.model.AccountStatus r11 = (com.stepos.ailauncher.contract.model.AccountStatus) r11
            boolean r7 = r11 instanceof com.stepos.ailauncher.contract.model.AccountStatus.Error
            if (r7 == 0) goto L8f
            Xa.k<com.stepos.ailauncher.contract.model.AccountStatus> r7 = com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl._status
            r7.setValue(r11)
        L8f:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl.notifyAccountSignal(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.contract.api.account.IAccountStatusService
    public AccountStatus peekStatus(String uid) {
        p.i(uid, "uid");
        Snapshot snapshot2 = snapshot;
        if (snapshot2 != null && p.d(snapshot2.getUid(), uid)) {
            return snapshot2.getRaw();
        }
        return null;
    }

    @Override // com.stepos.ailauncher.contract.api.account.IAccountStatusService
    public long serverNow() {
        Long l10 = serverClockOffset;
        return l10 != null ? SystemClock.elapsedRealtime() + l10.longValue() : System.currentTimeMillis();
    }

    @Override // com.stepos.ailauncher.contract.api.account.IAccountStatusService
    public Object getStatus(String str, InterfaceC4014c<? super AccountStatus> interfaceC4014c) {
        Snapshot snapshot2 = snapshot;
        return (snapshot2 == null || !p.d(snapshot2.getUid(), str)) ? i(str, interfaceC4014c) : snapshot2.getRaw();
    }
}
