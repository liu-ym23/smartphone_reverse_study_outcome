package yb;

import Mb.C0964b;
import Mb.J;
import Z8.A;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import tb.AbstractC5550q;
import tb.C5528A;
import tb.C5530C;
import tb.C5548o;
import tb.InterfaceC5538e;
import tb.InterfaceC5539f;
import tb.z;
import wb.C5797a;
import yb.InterfaceC6039t;
import zb.C6477a;
import zb.C6478b;

@Metadata(d1 = {"\u0000³\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001[\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u0003:\u0003H\u001d\u0019B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020!H\u0000¢\u0006\u0004\b(\u0010#J%\u0010-\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\b2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020/2\u0006\u0010,\u001a\u00020+H\u0000¢\u0006\u0004\b0\u00101J\u0015\u00104\u001a\u00020\f2\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105JK\u0010;\u001a\u0004\u0018\u00010\u000f2\u0006\u00106\u001a\u00020/2\b\b\u0002\u00107\u001a\u00020\b2\b\b\u0002\u00108\u001a\u00020\b2\b\b\u0002\u00109\u001a\u00020\b2\b\b\u0002\u0010:\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b=\u0010\u0012J\u0011\u0010?\u001a\u0004\u0018\u00010>H\u0000¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\f¢\u0006\u0004\bA\u0010\u000eJ\r\u0010B\u001a\u00020\f¢\u0006\u0004\bB\u0010\u000eJ\u0017\u0010D\u001a\u00020\f2\u0006\u0010C\u001a\u00020\bH\u0000¢\u0006\u0004\bD\u0010EJ\r\u0010F\u001a\u00020\b¢\u0006\u0004\bF\u0010 J\u000f\u0010G\u001a\u00020\u0015H\u0000¢\u0006\u0004\bG\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001d\u0010L\u001a\u0004\bM\u0010\u001eR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0019\u0010N\u001a\u0004\bO\u0010 R\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010Z\u001a\u00020T8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0014\u0010]\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010\\R\u0014\u0010`\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010_R\u0018\u0010b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010dR(\u00103\u001a\u0004\u0018\u0001022\b\u0010f\u001a\u0004\u0018\u0001028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b-\u0010g\u001a\u0004\bh\u0010iR\u0016\u0010j\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010NR(\u0010o\u001a\u0004\u0018\u00010/2\b\u0010f\u001a\u0004\u0018\u00010/8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u0016\u0010q\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010NR\u0016\u0010r\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010NR\u0016\u0010s\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010NR\u0016\u0010t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010NR\u0016\u0010u\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010NR\u0016\u0010v\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010NR\u0018\u00106\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010lR \u0010|\u001a\b\u0012\u0004\u0012\u00020x0w8\u0000X\u0080\u0004¢\u0006\f\n\u0004\by\u0010z\u001a\u0004\by\u0010{R$\u0010\u0081\u0001\u001a\u0010\u0012\f\u0012\n \u007f*\u0004\u0018\u00010~0~0}8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b(\u0010\u0080\u0001¨\u0006\u0082\u0001"}, d2 = {"Lyb/m;", "Ltb/e;", "", "", "Ltb/z;", "client", "Ltb/A;", "originalRequest", "", "forWebSocket", "<init>", "(Ltb/z;Ltb/A;Z)V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", "Ljava/io/IOException;", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/io/IOException;)Ljava/io/IOException;", "cause", ExifInterface.LONGITUDE_EAST, "", "F", "()Ljava/lang/String;", "LMb/J;", "c", "()LMb/J;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ltb/e;", Const.INTENT_KEY_PKGNAME, "()Ltb/A;", "cancel", "()Z", "Ltb/C;", "execute", "()Ltb/C;", "Ltb/f;", "responseCallback", "J", "(Ltb/f;)V", "u", "request", "newRoutePlanner", "Lzb/g;", "chain", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ltb/A;ZLzb/g;)V", "Lyb/h;", "v", "(Lzb/g;)Lyb/h;", "Lyb/n;", "connection", "f", "(Lyb/n;)V", "exchange", "requestDone", "responseDone", "socketSourceDone", "socketSinkDone", "w", "(Lyb/h;ZZZZLjava/io/IOException;)Ljava/io/IOException;", "y", "Ljava/net/Socket;", "B", "()Ljava/net/Socket;", "D", "H", "closeExchange", "k", "(Z)V", "C", "z", Const.INTENT_KEY_APIKEY, "Ltb/z;", "n", "()Ltb/z;", "Ltb/A;", "s", "Z", "q", "Lyb/o;", Const.INTENT_KEY_UMID, "Lyb/o;", "connectionPool", "Ltb/q;", "Ltb/q;", "p", "()Ltb/q;", "setEventListener$okhttp", "(Ltb/q;)V", "eventListener", "yb/m$d", "Lyb/m$d;", "timeout", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "executed", "Ljava/lang/Object;", "callStackTrace", "Lyb/i;", "Lyb/i;", "exchangeFinder", UxipConstants.f30680s, "Lyb/n;", "o", "()Lyb/n;", "timeoutEarlyExit", "l", "Lyb/h;", "r", "()Lyb/h;", "interceptorScopedExchange", "m", "requestBodyOpen", "responseBodyOpen", "socketSinkOpen", "socketSourceOpen", "expectMoreExchanges", "canceled", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lyb/t$b;", "t", "Ljava/util/concurrent/CopyOnWriteArrayList;", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "plansToCancel", "Ljava/util/concurrent/atomic/AtomicReference;", "Lub/g;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/atomic/AtomicReference;", "tags", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6032m implements InterfaceC5538e, Cloneable {

    /* renamed from: w, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater<C6032m, AbstractC5550q> f44210w;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final z client;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C5528A originalRequest;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final boolean forWebSocket;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final C6034o connectionPool;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public volatile AbstractC5550q eventListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final d timeout;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean executed;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public Object callStackTrace;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public InterfaceC6028i exchangeFinder;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public C6033n connection;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public boolean timeoutEarlyExit;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public C6027h interceptorScopedExchange;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public boolean requestBodyOpen;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public boolean responseBodyOpen;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public boolean socketSinkOpen;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public boolean socketSourceOpen;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public boolean expectMoreExchanges;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public volatile boolean canceled;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public volatile C6027h exchange;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public final CopyOnWriteArrayList<InterfaceC6039t.b> plansToCancel;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public final AtomicReference<ub.g> tags;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0000R\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0015R$\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019R\u0011\u0010\u001e\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010!\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lyb/m$a;", "Ljava/lang/Runnable;", "Ltb/f;", "responseCallback", "<init>", "(Lyb/m;Ltb/f;)V", "Lyb/m;", "other", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lyb/m$a;)V", "Ljava/util/concurrent/ExecutorService;", "executorService", Const.INTENT_KEY_APIKEY, "(Ljava/util/concurrent/ExecutorService;)V", "Ljava/util/concurrent/RejectedExecutionException;", "e", Const.INTENT_KEY_PKGNAME, "(Ljava/util/concurrent/RejectedExecutionException;)V", "run", "()V", "Ltb/f;", "Ljava/util/concurrent/atomic/AtomicInteger;", UxipConstants.f30680s, "Ljava/util/concurrent/atomic/AtomicInteger;", "()Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "", "f", "()Ljava/lang/String;", "host", Const.INTENT_KEY_UMID, "()Lyb/m;", "call", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.m$a */
    public final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC5539f responseCallback;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public volatile AtomicInteger callsPerHost;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ C6032m f44234c;

        public a(C6032m c6032m, InterfaceC5539f responseCallback) {
            kotlin.jvm.internal.p.i(responseCallback, "responseCallback");
            this.f44234c = c6032m;
            this.responseCallback = responseCallback;
            this.callsPerHost = new AtomicInteger(0);
        }

        public static /* synthetic */ void c(a aVar, RejectedExecutionException rejectedExecutionException, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                rejectedExecutionException = null;
            }
            aVar.b(rejectedExecutionException);
        }

        public final void a(ExecutorService executorService) {
            kotlin.jvm.internal.p.i(executorService, "executorService");
            ub.q.e(this.f44234c.getClient().getDispatcher());
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e10) {
                    b(e10);
                    this.f44234c.getClient().getDispatcher().e(this);
                }
            } catch (Throwable th) {
                this.f44234c.getClient().getDispatcher().e(this);
                throw th;
            }
        }

        public final void b(RejectedExecutionException e10) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
            interruptedIOException.initCause(e10);
            this.f44234c.y(interruptedIOException);
            this.responseCallback.d(this.f44234c, interruptedIOException);
        }

        /* renamed from: d, reason: from getter */
        public final C6032m getF44234c() {
            return this.f44234c;
        }

        /* renamed from: e, reason: from getter */
        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final String f() {
            return this.f44234c.s().getUrl().getHost();
        }

        public final void g(a other) {
            kotlin.jvm.internal.p.i(other, "other");
            this.callsPerHost = other.callsPerHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            Throwable th;
            IOException e10;
            C5548o dispatcher;
            String str = "OkHttp " + this.f44234c.z();
            C6032m c6032m = this.f44234c;
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(str);
            try {
                c6032m.timeout.t();
                try {
                    try {
                        z10 = true;
                    } catch (Throwable th2) {
                        c6032m.getClient().getDispatcher().e(this);
                        throw th2;
                    }
                } catch (IOException e11) {
                    z10 = false;
                    e10 = e11;
                } catch (Throwable th3) {
                    z10 = false;
                    th = th3;
                }
                try {
                    this.responseCallback.a(c6032m, c6032m.u());
                    dispatcher = c6032m.getClient().getDispatcher();
                } catch (IOException e12) {
                    e10 = e12;
                    if (z10) {
                        okhttp3.internal.platform.c.INSTANCE.e().log("Callback failure for " + c6032m.F(), 4, e10);
                    } else {
                        this.responseCallback.d(c6032m, e10);
                    }
                    dispatcher = c6032m.getClient().getDispatcher();
                    dispatcher.e(this);
                } catch (Throwable th4) {
                    th = th4;
                    c6032m.cancel();
                    if (!z10) {
                        IOException iOException = new IOException("canceled due to " + th);
                        iOException.initCause(th);
                        this.responseCallback.d(c6032m, iOException);
                    }
                    if (!(th instanceof InterruptedException)) {
                        throw th;
                    }
                    Thread.currentThread().interrupt();
                    dispatcher = c6032m.getClient().getDispatcher();
                    dispatcher.e(this);
                }
                dispatcher.e(this);
            } finally {
                threadCurrentThread.setName(name);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\u000b"}, d2 = {"Lyb/m$b;", "Ljava/lang/ref/WeakReference;", "Lyb/m;", "referent", "", "callStackTrace", "<init>", "(Lyb/m;Ljava/lang/Object;)V", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", "()Ljava/lang/Object;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.m$b */
    public static final class b extends WeakReference<C6032m> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C6032m referent, Object obj) {
            super(referent);
            kotlin.jvm.internal.p.i(referent, "referent");
            this.callStackTrace = obj;
        }

        /* renamed from: a, reason: from getter */
        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"yb/m$d", "LMb/b;", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.m$d */
    public static final class d extends C0964b {
        public d() {
        }

        @Override // Mb.C0964b
        public void A() {
            C6032m.this.cancel();
        }
    }

    static {
        AtomicReferenceFieldUpdater<C6032m, AbstractC5550q> atomicReferenceFieldUpdaterNewUpdater = AtomicReferenceFieldUpdater.newUpdater(C6032m.class, AbstractC5550q.class, "e");
        kotlin.jvm.internal.p.h(atomicReferenceFieldUpdaterNewUpdater, "newUpdater(...)");
        f44210w = atomicReferenceFieldUpdaterNewUpdater;
    }

    public C6032m(z client, C5528A originalRequest, boolean z10) {
        kotlin.jvm.internal.p.i(client, "client");
        kotlin.jvm.internal.p.i(originalRequest, "originalRequest");
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = z10;
        this.connectionPool = client.getConnectionPool().getDelegate();
        this.eventListener = client.getEventListenerFactory().a(this);
        d dVar = new d();
        dVar.h(client.getCallTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = dVar;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
        this.plansToCancel = new CopyOnWriteArrayList<>();
        this.tags = new AtomicReference<>(originalRequest.getTags());
    }

    public static /* synthetic */ IOException x(C6032m c6032m, C6027h c6027h, boolean z10, boolean z11, boolean z12, boolean z13, IOException iOException, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        if ((i10 & 8) != 0) {
            z12 = false;
        }
        if ((i10 & 16) != 0) {
            z13 = false;
        }
        return c6032m.w(c6027h, z10, z11, z12, z13, iOException);
    }

    public final Socket B() {
        C6033n c6033n = this.connection;
        kotlin.jvm.internal.p.f(c6033n);
        if (ub.q.f42674b && !Thread.holdsLock(c6033n)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + c6033n);
        }
        List<Reference<C6032m>> listI = c6033n.i();
        Iterator<Reference<C6032m>> it = listI.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (kotlin.jvm.internal.p.d(it.next().get(), this)) {
                break;
            }
            i10++;
        }
        if (i10 == -1) {
            throw new IllegalStateException("Check failed.");
        }
        listI.remove(i10);
        this.connection = null;
        if (listI.isEmpty()) {
            c6033n.w(System.nanoTime());
            if (this.connectionPool.c(c6033n)) {
                return c6033n.getJavaNetSocket();
            }
        }
        return null;
    }

    public final boolean C() {
        C6027h c6027h = this.exchange;
        if (c6027h == null || !c6027h.l()) {
            return false;
        }
        InterfaceC6028i interfaceC6028i = this.exchangeFinder;
        kotlin.jvm.internal.p.f(interfaceC6028i);
        InterfaceC6039t interfaceC6039tB = interfaceC6028i.getRoutePlanner();
        C6027h c6027h2 = this.exchange;
        return interfaceC6039tB.a(c6027h2 != null ? c6027h2.j() : null);
    }

    public final void D() {
        if (this.timeoutEarlyExit) {
            throw new IllegalStateException("Check failed.");
        }
        this.timeoutEarlyExit = true;
        this.timeout.u();
    }

    public final IOException E(IOException cause) {
        if (this.timeoutEarlyExit || !this.timeout.u()) {
            return cause;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (cause != null) {
            interruptedIOException.initCause(cause);
        }
        return interruptedIOException;
    }

    public final String F() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getCanceled() ? "canceled " : "");
        sb2.append(this.forWebSocket ? "web socket" : "call");
        sb2.append(" to ");
        sb2.append(z());
        return sb2.toString();
    }

    public final void H() {
        D();
        synchronized (this) {
            if (this.exchange == null) {
                throw new IllegalStateException("Check failed.");
            }
            if (this.socketSinkOpen || this.socketSourceOpen) {
                throw new IllegalStateException("Check failed.");
            }
            if (this.requestBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            if (!this.responseBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            this.responseBodyOpen = false;
            this.socketSinkOpen = true;
            this.socketSourceOpen = true;
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    @Override // tb.InterfaceC5538e
    public void J(InterfaceC5539f responseCallback) {
        kotlin.jvm.internal.p.i(responseCallback, "responseCallback");
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        h();
        this.client.getDispatcher().a(new a(this, responseCallback));
    }

    @Override // tb.InterfaceC5538e
    /* renamed from: b, reason: from getter */
    public C5528A getOriginalRequest() {
        return this.originalRequest;
    }

    @Override // tb.InterfaceC5538e
    public J c() {
        return this.timeout;
    }

    @Override // tb.InterfaceC5538e
    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        C6027h c6027h = this.exchange;
        if (c6027h != null) {
            c6027h.d();
        }
        Iterator<InterfaceC6039t.b> it = this.plansToCancel.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.eventListener.f(this);
    }

    @Override // tb.InterfaceC5538e
    /* renamed from: e, reason: from getter */
    public boolean getCanceled() {
        return this.canceled;
    }

    @Override // tb.InterfaceC5538e
    public C5530C execute() {
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        this.timeout.t();
        h();
        try {
            this.client.getDispatcher().b(this);
            return u();
        } finally {
            this.client.getDispatcher().f(this);
        }
    }

    public final void f(C6033n connection) {
        kotlin.jvm.internal.p.i(connection, "connection");
        if (!ub.q.f42674b || Thread.holdsLock(connection)) {
            if (this.connection != null) {
                throw new IllegalStateException("Check failed.");
            }
            this.connection = connection;
            connection.i().add(new b(this, this.callStackTrace));
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
    }

    public final IOException g(IOException e10) throws IOException {
        Socket socketB;
        boolean z10 = ub.q.f42674b;
        if (z10 && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        C6033n c6033n = this.connection;
        if (c6033n != null) {
            if (z10 && Thread.holdsLock(c6033n)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + c6033n);
            }
            synchronized (c6033n) {
                socketB = B();
            }
            if (this.connection == null) {
                if (socketB != null) {
                    ub.q.h(socketB);
                }
                this.eventListener.k(this, c6033n);
                c6033n.getConnectionListener().g(c6033n, this);
                if (socketB != null) {
                    c6033n.getConnectionListener().f(c6033n);
                }
            } else if (socketB != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        IOException iOExceptionE = E(e10);
        if (e10 == null) {
            this.eventListener.c(this);
            return iOExceptionE;
        }
        AbstractC5550q abstractC5550q = this.eventListener;
        kotlin.jvm.internal.p.f(iOExceptionE);
        abstractC5550q.d(this, iOExceptionE);
        return iOExceptionE;
    }

    public final void h() {
        this.callStackTrace = okhttp3.internal.platform.c.INSTANCE.e().getStackTraceForCloseable("response.body().close()");
        this.eventListener.e(this);
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public InterfaceC5538e clone() {
        return new C6032m(this.client, this.originalRequest, this.forWebSocket);
    }

    public final void j(C5528A request, boolean newRoutePlanner, zb.g chain) {
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(chain, "chain");
        if (this.interceptorScopedExchange != null) {
            throw new IllegalStateException("Check failed.");
        }
        synchronized (this) {
            if (this.responseBodyOpen) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
            if (this.requestBodyOpen || this.socketSourceOpen || this.socketSinkOpen) {
                throw new IllegalStateException("Check failed.");
            }
            Y8.t tVar = Y8.t.f7040a;
        }
        if (newRoutePlanner) {
            C6035p c6035p = new C6035p(this.client.getTaskRunner(), chain.getConnectionPool().getDelegate(), chain.x(), chain.getWriteTimeoutMillis(), chain.getConnectTimeoutMillis(), chain.x(), this.client.getPingIntervalMillis(), chain.getRetryOnConnectionFailure(), this.client.getFastFallback(), chain.l(request.getUrl()), this.client.getRouteDatabase(), this, request);
            this.exchangeFinder = this.client.getFastFallback() ? new C6030k(c6035p, this.client.getTaskRunner()) : new C6041v(c6035p);
        }
    }

    public final void k(boolean closeExchange) {
        C6027h c6027h;
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released");
            }
            Y8.t tVar = Y8.t.f7040a;
        }
        if (closeExchange && (c6027h = this.exchange) != null) {
            c6027h.f();
        }
        this.interceptorScopedExchange = null;
    }

    /* renamed from: n, reason: from getter */
    public final z getClient() {
        return this.client;
    }

    /* renamed from: o, reason: from getter */
    public final C6033n getConnection() {
        return this.connection;
    }

    /* renamed from: p, reason: from getter */
    public final AbstractC5550q getEventListener() {
        return this.eventListener;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    /* renamed from: r, reason: from getter */
    public final C6027h getInterceptorScopedExchange() {
        return this.interceptorScopedExchange;
    }

    public final C5528A s() {
        return this.originalRequest;
    }

    public final CopyOnWriteArrayList<InterfaceC6039t.b> t() {
        return this.plansToCancel;
    }

    public final C5530C u() throws IOException {
        ArrayList arrayList = new ArrayList();
        A.E(arrayList, this.client.w());
        arrayList.add(new zb.j());
        arrayList.add(new C6477a());
        arrayList.add(new C5797a());
        arrayList.add(C6022c.f44145a);
        if (!this.forWebSocket) {
            A.E(arrayList, this.client.y());
        }
        arrayList.add(C6478b.f45429a);
        try {
            try {
                C5530C c5530cI = new zb.g(this, arrayList, 0, null, this.originalRequest, null, 32, null).i(this.originalRequest);
                if (getCanceled()) {
                    ub.n.f(c5530cI);
                    throw new IOException("Canceled");
                }
                y(null);
                return c5530cI;
            } catch (IOException e10) {
                IOException iOExceptionY = y(e10);
                kotlin.jvm.internal.p.g(iOExceptionY, "null cannot be cast to non-null type kotlin.Throwable");
                throw iOExceptionY;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                y(null);
            }
            throw th;
        }
    }

    public final C6027h v(zb.g chain) throws IOException {
        kotlin.jvm.internal.p.i(chain, "chain");
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released");
            }
            if (this.responseBodyOpen || this.requestBodyOpen || this.socketSourceOpen || this.socketSinkOpen) {
                throw new IllegalStateException("Check failed.");
            }
            Y8.t tVar = Y8.t.f7040a;
        }
        InterfaceC6028i interfaceC6028i = this.exchangeFinder;
        kotlin.jvm.internal.p.f(interfaceC6028i);
        C6027h c6027h = new C6027h(this, interfaceC6028i, interfaceC6028i.a().s(this.client, chain));
        this.interceptorScopedExchange = c6027h;
        this.exchange = c6027h;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
        }
        if (this.canceled) {
            throw new IOException("Canceled");
        }
        return c6027h;
    }

    public final IOException w(C6027h exchange, boolean requestDone, boolean responseDone, boolean socketSourceDone, boolean socketSinkDone, IOException e10) {
        boolean z10;
        boolean z11;
        kotlin.jvm.internal.p.i(exchange, "exchange");
        if (kotlin.jvm.internal.p.d(exchange, this.exchange)) {
            synchronized (this) {
                z10 = false;
                if (requestDone) {
                    try {
                        if (!this.requestBodyOpen) {
                            if ((responseDone || !this.responseBodyOpen) && ((!socketSinkDone || !this.socketSinkOpen) && (!socketSourceDone || !this.socketSourceOpen))) {
                                z11 = false;
                            }
                            Y8.t tVar = Y8.t.f7040a;
                        }
                        if (requestDone) {
                            this.requestBodyOpen = false;
                        }
                        if (responseDone) {
                            this.responseBodyOpen = false;
                        }
                        if (socketSinkDone) {
                            this.socketSinkOpen = false;
                        }
                        if (socketSourceDone) {
                            this.socketSourceOpen = false;
                        }
                        boolean z12 = (this.requestBodyOpen || this.responseBodyOpen || this.socketSinkOpen || this.socketSourceOpen) ? false : true;
                        if (z12 && !this.expectMoreExchanges) {
                            z10 = true;
                        }
                        boolean z13 = z12;
                        z11 = z10;
                        z10 = z13;
                        Y8.t tVar2 = Y8.t.f7040a;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else if (responseDone) {
                    z11 = false;
                    Y8.t tVar22 = Y8.t.f7040a;
                } else {
                    z11 = false;
                    Y8.t tVar222 = Y8.t.f7040a;
                }
            }
            if (z10) {
                this.exchange = null;
                C6033n c6033n = this.connection;
                if (c6033n != null) {
                    c6033n.o();
                }
            }
            if (z11) {
                return g(e10);
            }
        }
        return e10;
    }

    public final IOException y(IOException e10) {
        boolean z10;
        synchronized (this) {
            try {
                z10 = false;
                if (this.expectMoreExchanges) {
                    this.expectMoreExchanges = false;
                    if (!this.requestBodyOpen && !this.responseBodyOpen && !this.socketSinkOpen && !this.socketSourceOpen) {
                        z10 = true;
                    }
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10 ? g(e10) : e10;
    }

    public final String z() {
        return this.originalRequest.getUrl().r();
    }
}
