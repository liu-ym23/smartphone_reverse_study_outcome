package io.ktor.client.plugins.cookies;

import Z8.A;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import eb.f;
import g9.InterfaceC4112d;
import io.ktor.client.plugins.cookies.AcceptAllCookiesStorage;
import io.ktor.http.Cookie;
import io.ktor.http.Url;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001!B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u0004\u0018\u00010\u0003*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "Lkotlin/Function0;", "", "clock", "<init>", "(Lp9/a;)V", "timestamp", "LY8/t;", "cleanup", "(J)V", "Lio/ktor/http/Cookie;", "createdAt", "maxAgeOrExpires", "(Lio/ktor/http/Cookie;J)Ljava/lang/Long;", "Lio/ktor/http/Url;", "requestUrl", "", "get", "(Lio/ktor/http/Url;Le9/c;)Ljava/lang/Object;", "cookie", "addCookie", "(Lio/ktor/http/Url;Lio/ktor/http/Cookie;Le9/c;)Ljava/lang/Object;", "close", "()V", "Lp9/a;", "", "Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage$CookieWithTimestamp;", "container", "Ljava/util/List;", "Leb/a;", "mutex", "Leb/a;", "CookieWithTimestamp", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AcceptAllCookiesStorage implements CookiesStorage {
    private final InterfaceC5063a<Long> clock;
    private final List<CookieWithTimestamp> container;
    private final InterfaceC4021a mutex;
    private volatile /* synthetic */ long oldestCookie;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001c"}, d2 = {"Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage$CookieWithTimestamp;", "", "Lio/ktor/http/Cookie;", "cookie", "", "createdAt", "<init>", "(Lio/ktor/http/Cookie;J)V", "component1", "()Lio/ktor/http/Cookie;", "component2", "()J", ChatTracker.CLICK_COPY, "(Lio/ktor/http/Cookie;J)Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage$CookieWithTimestamp;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lio/ktor/http/Cookie;", "getCookie", "J", "getCreatedAt", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CookieWithTimestamp {
        private final Cookie cookie;
        private final long createdAt;

        public CookieWithTimestamp(Cookie cookie, long j10) {
            p.i(cookie, "cookie");
            this.cookie = cookie;
            this.createdAt = j10;
        }

        public static /* synthetic */ CookieWithTimestamp copy$default(CookieWithTimestamp cookieWithTimestamp, Cookie cookie, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                cookie = cookieWithTimestamp.cookie;
            }
            if ((i10 & 2) != 0) {
                j10 = cookieWithTimestamp.createdAt;
            }
            return cookieWithTimestamp.copy(cookie, j10);
        }

        /* renamed from: component1, reason: from getter */
        public final Cookie getCookie() {
            return this.cookie;
        }

        /* renamed from: component2, reason: from getter */
        public final long getCreatedAt() {
            return this.createdAt;
        }

        public final CookieWithTimestamp copy(Cookie cookie, long createdAt) {
            p.i(cookie, "cookie");
            return new CookieWithTimestamp(cookie, createdAt);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CookieWithTimestamp)) {
                return false;
            }
            CookieWithTimestamp cookieWithTimestamp = (CookieWithTimestamp) other;
            return p.d(this.cookie, cookieWithTimestamp.cookie) && this.createdAt == cookieWithTimestamp.createdAt;
        }

        public final Cookie getCookie() {
            return this.cookie;
        }

        public final long getCreatedAt() {
            return this.createdAt;
        }

        public int hashCode() {
            return (this.cookie.hashCode() * 31) + Long.hashCode(this.createdAt);
        }

        public String toString() {
            return "CookieWithTimestamp(cookie=" + this.cookie + ", createdAt=" + this.createdAt + ')';
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.plugins.cookies.AcceptAllCookiesStorage", f = "AcceptAllCookiesStorage.kt", l = {79}, m = "addCookie")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return AcceptAllCookiesStorage.this.addCookie(null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.plugins.cookies.AcceptAllCookiesStorage", f = "AcceptAllCookiesStorage.kt", l = {79}, m = "get")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42271 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C42271(InterfaceC4014c<? super C42271> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AcceptAllCookiesStorage.this.get(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AcceptAllCookiesStorage() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addCookie$lambda$7$lambda$5(Cookie cookie, Url url, CookieWithTimestamp cookieWithTimestamp) {
        p.i(cookieWithTimestamp, "<destruct>");
        Cookie cookie2 = cookieWithTimestamp.getCookie();
        return p.d(cookie2.getName(), cookie.getName()) && CookiesStorageKt.matches(cookie2, url);
    }

    private final void cleanup(final long timestamp) {
        A.L(this.container, new InterfaceC5074l() { // from class: io.ktor.client.plugins.cookies.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AcceptAllCookiesStorage.cleanup$lambda$8(this.f33197a, timestamp, (AcceptAllCookiesStorage.CookieWithTimestamp) obj));
            }
        });
        long jMin = Long.MAX_VALUE;
        for (CookieWithTimestamp cookieWithTimestamp : this.container) {
            Long lMaxAgeOrExpires = maxAgeOrExpires(cookieWithTimestamp.getCookie(), cookieWithTimestamp.getCreatedAt());
            if (lMaxAgeOrExpires != null) {
                jMin = Math.min(jMin, lMaxAgeOrExpires.longValue());
            }
        }
        this.oldestCookie = jMin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean cleanup$lambda$8(AcceptAllCookiesStorage acceptAllCookiesStorage, long j10, CookieWithTimestamp cookieWithTimestamp) {
        p.i(cookieWithTimestamp, "<destruct>");
        Long lMaxAgeOrExpires = acceptAllCookiesStorage.maxAgeOrExpires(cookieWithTimestamp.getCookie(), cookieWithTimestamp.getCreatedAt());
        return lMaxAgeOrExpires != null && lMaxAgeOrExpires.longValue() < j10;
    }

    private final Long maxAgeOrExpires(Cookie cookie, long j10) {
        if (cookie.getMaxAgeInt() != null) {
            return Long.valueOf(j10 + (r2.intValue() * 1000));
        }
        GMTDate expires = cookie.getExpires();
        if (expires != null) {
            return Long.valueOf(expires.getTimestamp());
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object addCookie(final io.ktor.http.Url r6, final io.ktor.http.Cookie r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1 r0 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1 r0 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.L$2
            eb.a r6 = (eb.InterfaceC4021a) r6
            java.lang.Object r7 = r0.L$1
            io.ktor.http.Cookie r7 = (io.ktor.http.Cookie) r7
            java.lang.Object r0 = r0.L$0
            io.ktor.http.Url r0 = (io.ktor.http.Url) r0
            kotlin.C4849c.b(r8)
            r8 = r6
            r6 = r0
            goto L64
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            kotlin.C4849c.b(r8)
            java.lang.String r8 = r7.getName()
            boolean r8 = La.H.x0(r8)
            if (r8 == 0) goto L50
            Y8.t r5 = Y8.t.f7040a
            return r5
        L50:
            eb.a r8 = r5.mutex
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r2 = 0
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r0 = r8.m(r4, r0)
            if (r0 != r1) goto L64
            return r1
        L64:
            java.util.List<io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$CookieWithTimestamp> r0 = r5.container     // Catch: java.lang.Throwable -> L9b
            io.ktor.client.plugins.cookies.a r1 = new io.ktor.client.plugins.cookies.a     // Catch: java.lang.Throwable -> L9b
            r1.<init>()     // Catch: java.lang.Throwable -> L9b
            Z8.A.L(r0, r1)     // Catch: java.lang.Throwable -> L9b
            p9.a<java.lang.Long> r0 = r5.clock     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r0 = r0.invoke()     // Catch: java.lang.Throwable -> L9b
            java.lang.Number r0 = (java.lang.Number) r0     // Catch: java.lang.Throwable -> L9b
            long r0 = r0.longValue()     // Catch: java.lang.Throwable -> L9b
            java.util.List<io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$CookieWithTimestamp> r2 = r5.container     // Catch: java.lang.Throwable -> L9b
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$CookieWithTimestamp r3 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$CookieWithTimestamp     // Catch: java.lang.Throwable -> L9b
            io.ktor.http.Cookie r6 = io.ktor.client.plugins.cookies.CookiesStorageKt.fillDefaults(r7, r6)     // Catch: java.lang.Throwable -> L9b
            r3.<init>(r6, r0)     // Catch: java.lang.Throwable -> L9b
            r2.add(r3)     // Catch: java.lang.Throwable -> L9b
            java.lang.Long r6 = r5.maxAgeOrExpires(r7, r0)     // Catch: java.lang.Throwable -> L9b
            if (r6 == 0) goto L9f
            long r6 = r6.longValue()     // Catch: java.lang.Throwable -> L9b
            long r0 = r5.oldestCookie     // Catch: java.lang.Throwable -> L9b
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L9d
            r5.oldestCookie = r6     // Catch: java.lang.Throwable -> L9b
            goto L9d
        L9b:
            r5 = move-exception
            goto La5
        L9d:
            Y8.t r5 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L9b
        L9f:
            r8.l(r4)
            Y8.t r5 = Y8.t.f7040a
            return r5
        La5:
            r8.l(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.addCookie(io.ktor.http.Url, io.ktor.http.Cookie, e9.c):java.lang.Object");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object get(io.ktor.http.Url r6, e9.InterfaceC4014c<? super java.util.List<io.ktor.http.Cookie>> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.C42271
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1 r0 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.C42271) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1 r0 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.L$1
            eb.a r6 = (eb.InterfaceC4021a) r6
            java.lang.Object r0 = r0.L$0
            io.ktor.http.Url r0 = (io.ktor.http.Url) r0
            kotlin.C4849c.b(r7)
            r7 = r6
            r6 = r0
            goto L51
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.C4849c.b(r7)
            eb.a r7 = r5.mutex
            r0.L$0 = r6
            r0.L$1 = r7
            r2 = 0
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r0 = r7.m(r4, r0)
            if (r0 != r1) goto L51
            return r1
        L51:
            p9.a<java.lang.Long> r0 = r5.clock     // Catch: java.lang.Throwable -> L67
            java.lang.Object r0 = r0.invoke()     // Catch: java.lang.Throwable -> L67
            java.lang.Number r0 = (java.lang.Number) r0     // Catch: java.lang.Throwable -> L67
            long r0 = r0.longValue()     // Catch: java.lang.Throwable -> L67
            long r2 = r5.oldestCookie     // Catch: java.lang.Throwable -> L67
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L69
            r5.cleanup(r0)     // Catch: java.lang.Throwable -> L67
            goto L69
        L67:
            r5 = move-exception
            goto Lb8
        L69:
            java.util.List<io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$CookieWithTimestamp> r5 = r5.container     // Catch: java.lang.Throwable -> L67
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Throwable -> L67
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L67
            r0.<init>()     // Catch: java.lang.Throwable -> L67
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L67
        L76:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L67
            if (r1 == 0) goto L91
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L67
            r2 = r1
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$CookieWithTimestamp r2 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.CookieWithTimestamp) r2     // Catch: java.lang.Throwable -> L67
            io.ktor.http.Cookie r2 = r2.getCookie()     // Catch: java.lang.Throwable -> L67
            boolean r2 = io.ktor.client.plugins.cookies.CookiesStorageKt.matches(r2, r6)     // Catch: java.lang.Throwable -> L67
            if (r2 == 0) goto L76
            r0.add(r1)     // Catch: java.lang.Throwable -> L67
            goto L76
        L91:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L67
            r6 = 10
            int r6 = Z8.C1174w.x(r0, r6)     // Catch: java.lang.Throwable -> L67
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L67
            java.util.Iterator r6 = r0.iterator()     // Catch: java.lang.Throwable -> L67
        La0:
            boolean r0 = r6.hasNext()     // Catch: java.lang.Throwable -> L67
            if (r0 == 0) goto Lb4
            java.lang.Object r0 = r6.next()     // Catch: java.lang.Throwable -> L67
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$CookieWithTimestamp r0 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.CookieWithTimestamp) r0     // Catch: java.lang.Throwable -> L67
            io.ktor.http.Cookie r0 = r0.getCookie()     // Catch: java.lang.Throwable -> L67
            r5.add(r0)     // Catch: java.lang.Throwable -> L67
            goto La0
        Lb4:
            r7.l(r4)
            return r5
        Lb8:
            r7.l(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.get(io.ktor.http.Url, e9.c):java.lang.Object");
    }

    public AcceptAllCookiesStorage(InterfaceC5063a<Long> clock) {
        p.i(clock, "clock");
        this.clock = clock;
        this.container = new ArrayList();
        this.oldestCookie = 0L;
        this.mutex = f.b(false, 1, null);
    }

    public /* synthetic */ AcceptAllCookiesStorage(InterfaceC5063a interfaceC5063a, int i10, i iVar) {
        this((i10 & 1) != 0 ? new InterfaceC5063a() { // from class: io.ktor.client.plugins.cookies.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Long.valueOf(DateJvmKt.getTimeMillis());
            }
        } : interfaceC5063a);
    }
}
