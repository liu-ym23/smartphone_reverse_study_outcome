package com.stepos.taskrobot.appwhitelist.repository;

import C7.r;
import J7.c;
import S7.a;
import S7.n;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.voicewakeup.service.f;
import com.stepos.taskrobot.appwhitelist.model.WhitelistManifest;
import com.stepos.taskrobot.appwhitelist.remote.WhitelistRemoteSource;
import com.stepos.taskrobot.appwhitelist.remote.dto.WhitelistManifestDto;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import org.java_websocket.WebSocketImpl;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0014J\r\u0010\u0018\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001cR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/repository/WhitelistRepository;", "", "Lcom/stepos/taskrobot/appwhitelist/remote/WhitelistRemoteSource;", "remoteSource", "Lcom/stepos/taskrobot/appwhitelist/repository/DiskAdapter;", "disk", "Lcom/stepos/taskrobot/appwhitelist/repository/DefaultAdapter;", "default", "Lm9/z;", "scope", "Lkotlin/Function0;", "", "clock", AppAgent.CONSTRUCT, "(Lcom/stepos/taskrobot/appwhitelist/remote/WhitelistRemoteSource;Lcom/stepos/taskrobot/appwhitelist/repository/DiskAdapter;Lcom/stepos/taskrobot/appwhitelist/repository/DefaultAdapter;Lm9/z;LS7/a;)V", "Lcom/stepos/taskrobot/appwhitelist/model/WhitelistManifest;", "getCurrent", "()Lcom/stepos/taskrobot/appwhitelist/model/WhitelistManifest;", "LC7/r;", "loadFromDiskOrAssets", "()V", "refresh", "(LH7/c;)Ljava/lang/Object;", "refreshIfExpired", "scheduleRefresh", "Lcom/stepos/taskrobot/appwhitelist/remote/WhitelistRemoteSource;", "Lcom/stepos/taskrobot/appwhitelist/repository/DiskAdapter;", "Lcom/stepos/taskrobot/appwhitelist/repository/DefaultAdapter;", "Lm9/z;", "LS7/a;", "Lcom/stepos/taskrobot/appwhitelist/repository/MemoryCache;", "memory", "Lcom/stepos/taskrobot/appwhitelist/repository/MemoryCache;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRefreshing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Companion", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WhitelistRepository {
    private static final String TAG = "WhitelistRepository";
    private final a clock;
    private final DefaultAdapter default;
    private final DiskAdapter disk;
    private final AtomicBoolean isRefreshing;
    private final MemoryCache memory;
    private final WhitelistRemoteSource remoteSource;
    private final InterfaceC1733z scope;

    @c(c = "com.stepos.taskrobot.appwhitelist.repository.WhitelistRepository", f = "WhitelistRepository.kt", l = {56}, m = "refresh", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.appwhitelist.repository.WhitelistRepository$refresh$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WhitelistRepository.this.refresh(this);
        }
    }

    @c(c = "com.stepos.taskrobot.appwhitelist.repository.WhitelistRepository$refreshIfExpired$1", f = "WhitelistRepository.kt", l = {WebSocketImpl.DEFAULT_PORT}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.appwhitelist.repository.WhitelistRepository$refreshIfExpired$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11461 extends SuspendLambda implements n {
        int label;

        public C11461(H7.c<? super C11461> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return WhitelistRepository.this.new C11461(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                WhitelistRepository whitelistRepository = WhitelistRepository.this;
                this.label = 1;
                if (whitelistRepository.refresh(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11461) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.taskrobot.appwhitelist.repository.WhitelistRepository$scheduleRefresh$1", f = "WhitelistRepository.kt", l = {86}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.appwhitelist.repository.WhitelistRepository$scheduleRefresh$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11471 extends SuspendLambda implements n {
        int label;

        public C11471(H7.c<? super C11471> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return WhitelistRepository.this.new C11471(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                WhitelistRepository whitelistRepository = WhitelistRepository.this;
                this.label = 1;
                if (whitelistRepository.refresh(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11471) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public WhitelistRepository(WhitelistRemoteSource remoteSource, DiskAdapter disk, DefaultAdapter defaultAdapter, InterfaceC1733z scope, a clock) {
        k.f(remoteSource, "remoteSource");
        k.f(disk, "disk");
        k.f(defaultAdapter, "default");
        k.f(scope, "scope");
        k.f(clock, "clock");
        this.remoteSource = remoteSource;
        this.disk = disk;
        this.default = defaultAdapter;
        this.scope = scope;
        this.clock = clock;
        this.memory = new MemoryCache();
        this.isRefreshing = new AtomicBoolean(false);
    }

    public final WhitelistManifest getCurrent() {
        return this.memory.getCurrent();
    }

    public final void loadFromDiskOrAssets() {
        WhitelistManifestDto whitelistManifestDtoLoad = this.disk.read();
        if (whitelistManifestDtoLoad == null) {
            whitelistManifestDtoLoad = this.default.load();
        }
        this.memory.replace(whitelistManifestDtoLoad.toManifest(((Number) this.clock.invoke()).longValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refresh(H7.c<? super C7.r> r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            java.lang.String r2 = "refresh failed, keeping stale cache: "
            boolean r3 = r0 instanceof com.stepos.taskrobot.appwhitelist.repository.WhitelistRepository.AnonymousClass1
            if (r3 == 0) goto L19
            r3 = r0
            com.stepos.taskrobot.appwhitelist.repository.WhitelistRepository$refresh$1 r3 = (com.stepos.taskrobot.appwhitelist.repository.WhitelistRepository.AnonymousClass1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            com.stepos.taskrobot.appwhitelist.repository.WhitelistRepository$refresh$1 r3 = new com.stepos.taskrobot.appwhitelist.repository.WhitelistRepository$refresh$1
            r3.<init>(r0)
        L1e:
            java.lang.Object r0 = r3.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r5 = r3.label
            C7.r r6 = C7.r.f317a
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L3d
            if (r5 != r7) goto L35
            kotlin.b.b(r0)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            goto L54
        L30:
            r0 = move-exception
            goto Lae
        L33:
            r0 = move-exception
            goto L98
        L35:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3d:
            kotlin.b.b(r0)
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.isRefreshing
            boolean r0 = r0.compareAndSet(r8, r7)
            if (r0 != 0) goto L49
            return r6
        L49:
            com.stepos.taskrobot.appwhitelist.remote.WhitelistRemoteSource r0 = r1.remoteSource     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            r3.label = r7     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            java.lang.Object r0 = r0.fetch(r3)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            if (r0 != r4) goto L54
            return r4
        L54:
            com.stepos.taskrobot.appwhitelist.remote.dto.WhitelistManifestDto r0 = (com.stepos.taskrobot.appwhitelist.remote.dto.WhitelistManifestDto) r0     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            com.stepos.taskrobot.appwhitelist.repository.MemoryCache r3 = r1.memory     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            com.stepos.taskrobot.appwhitelist.model.WhitelistManifest r9 = r3.getCurrent()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            S7.a r3 = r1.clock     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            java.lang.Object r3 = r3.invoke()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            java.lang.Number r3 = (java.lang.Number) r3     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            long r14 = r3.longValue()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            int r3 = r0.getVersion()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            int r4 = r9.getVersion()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            if (r3 <= r4) goto L81
            com.stepos.taskrobot.appwhitelist.repository.MemoryCache r3 = r1.memory     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            com.stepos.taskrobot.appwhitelist.model.WhitelistManifest r4 = r0.toManifest(r14)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            r3.replace(r4)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            com.stepos.taskrobot.appwhitelist.repository.DiskAdapter r3 = r1.disk     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            r3.write(r0)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            goto L92
        L81:
            com.stepos.taskrobot.appwhitelist.repository.MemoryCache r0 = r1.memory     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            r16 = 15
            r17 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            com.stepos.taskrobot.appwhitelist.model.WhitelistManifest r3 = com.stepos.taskrobot.appwhitelist.model.WhitelistManifest.copy$default(r9, r10, r11, r12, r13, r14, r16, r17)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            r0.replace(r3)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
        L92:
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.isRefreshing
            r0.set(r8)
            return r6
        L98:
            java.lang.String r3 = "WhitelistRepository"
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L30
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L30
            r4.append(r0)     // Catch: java.lang.Throwable -> L30
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L30
            f6.AbstractC1436a.e(r3, r0, r7)     // Catch: java.lang.Throwable -> L30
            goto L92
        Lae:
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.isRefreshing
            r1.set(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.appwhitelist.repository.WhitelistRepository.refresh(H7.c):java.lang.Object");
    }

    public final void refreshIfExpired() {
        WhitelistManifest current = this.memory.getCurrent();
        if (((Number) this.clock.invoke()).longValue() - current.getFetchedAt() > current.getTtlSeconds() * 1000) {
            AbstractC1683A.n(this.scope, null, new C11461(null), 3);
        }
    }

    public final void scheduleRefresh() {
        AbstractC1683A.n(this.scope, null, new C11471(null), 3);
    }

    public /* synthetic */ WhitelistRepository(WhitelistRemoteSource whitelistRemoteSource, DiskAdapter diskAdapter, DefaultAdapter defaultAdapter, InterfaceC1733z interfaceC1733z, a aVar, int i, e eVar) {
        this(whitelistRemoteSource, diskAdapter, defaultAdapter, interfaceC1733z, (i & 16) != 0 ? new f(9) : aVar);
    }
}
