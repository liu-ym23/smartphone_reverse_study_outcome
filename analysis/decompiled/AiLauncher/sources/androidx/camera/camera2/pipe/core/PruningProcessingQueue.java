package androidx.camera.camera2.pipe.core;

import Oa.a;
import Oa.b;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Wa.g;
import Wa.j;
import Y8.t;
import Z8.C1165m;
import Z8.F;
import androidx.camera.camera2.pipe.core.PruningProcessingQueue;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import p9.InterfaceC5074l;
import p9.p;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 0*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u00011Bm\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\u00070\u0005\u0012\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR&\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R&\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010 R0\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Landroidx/camera/camera2/pipe/core/PruningProcessingQueue;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "capacity", "Lkotlin/Function1;", "", "LY8/t;", "prune", "", "onUnprocessedElements", "Lkotlin/Function2;", "Le9/c;", "process", "<init>", "(ILp9/l;Lp9/l;Lp9/p;)V", "element", "", "p", "(Ljava/lang/Object;)Z", "", "o", "(Le9/c;)Ljava/lang/Object;", "", "cause", "n", "(Ljava/lang/Throwable;)V", Const.INTENT_KEY_APIKEY, "I", "getCapacity", "()I", Const.INTENT_KEY_PKGNAME, "Lp9/l;", "c", Const.INTENT_KEY_UMID, "Lp9/p;", "LOa/a;", "e", "LOa/a;", RobotInfo.STATUS_STARTED, "LWa/g;", "f", "LWa/g;", "channel", "LZ8/m;", Const.INTENT_KEY_BACKGROUND_COMMAND, "LZ8/m;", "queue", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PruningProcessingQueue<T> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int capacity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<List<T>, t> prune;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<List<? extends T>, t> onUnprocessedElements;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final p<T, InterfaceC4014c<? super t>, Object> process;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final a started;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final g<T> channel;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final C1165m<T> queue;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/pipe/core/PruningProcessingQueue$Companion;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/camera/camera2/pipe/core/PruningProcessingQueue;", "LUa/M;", "scope", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/core/PruningProcessingQueue;LUa/M;)Landroidx/camera/camera2/pipe/core/PruningProcessingQueue;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final <T> PruningProcessingQueue<T> a(PruningProcessingQueue<T> pruningProcessingQueue, M scope) {
            kotlin.jvm.internal.p.i(pruningProcessingQueue, "<this>");
            kotlin.jvm.internal.p.i(scope, "scope");
            if (!pruningProcessingQueue.started.a(false, true)) {
                throw new IllegalStateException("PruningProcessingQueue cannot be re-started!");
            }
            if (C1060i.d(scope, null, null, new PruningProcessingQueue$Companion$processIn$job$1(pruningProcessingQueue, null), 3, null).isCancelled()) {
                pruningProcessingQueue.n(null);
            }
            return pruningProcessingQueue;
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PruningProcessingQueue(int i10, InterfaceC5074l<? super List<T>, t> prune, InterfaceC5074l<? super List<? extends T>, t> onUnprocessedElements, p<? super T, ? super InterfaceC4014c<? super t>, ? extends Object> process) {
        kotlin.jvm.internal.p.i(prune, "prune");
        kotlin.jvm.internal.p.i(onUnprocessedElements, "onUnprocessedElements");
        kotlin.jvm.internal.p.i(process, "process");
        this.capacity = i10;
        this.prune = prune;
        this.onUnprocessedElements = onUnprocessedElements;
        this.process = process;
        this.started = b.a(false);
        this.channel = j.b(i10, null, new InterfaceC5074l() { // from class: z.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return PruningProcessingQueue.m(this.f44518a, obj);
            }
        }, 2, null);
        this.queue = new C1165m<>();
    }

    public static final t d(List it) {
        kotlin.jvm.internal.p.i(it, "it");
        return t.f7040a;
    }

    public static final t e(List it) {
        kotlin.jvm.internal.p.i(it, "it");
        return t.f7040a;
    }

    public static final t m(PruningProcessingQueue pruningProcessingQueue, Object obj) {
        pruningProcessingQueue.queue.add(obj);
        return t.f7040a;
    }

    public final void n(Throwable cause) {
        if (this.channel.close(cause)) {
            Object objS = this.channel.s();
            while (kotlinx.coroutines.channels.a.j(objS)) {
                this.queue.add(kotlinx.coroutines.channels.a.g(objS));
                objS = this.channel.s();
            }
            if (this.queue.isEmpty()) {
                return;
            }
            this.onUnprocessedElements.invoke(F.p1(this.queue));
            this.queue.clear();
        }
    }

    public final Object o(InterfaceC4014c interfaceC4014c) {
        return L0.c(new PruningProcessingQueue$processingLoop$2(this, null), interfaceC4014c);
    }

    public final boolean p(T element) {
        return kotlinx.coroutines.channels.a.j(this.channel.mo0trySendJP2dKIU(element));
    }

    public /* synthetic */ PruningProcessingQueue(int i10, InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, p pVar, int i11, i iVar) {
        this((i11 & 1) != 0 ? Integer.MAX_VALUE : i10, (i11 & 2) != 0 ? new InterfaceC5074l() { // from class: z.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return PruningProcessingQueue.d((List) obj);
            }
        } : interfaceC5074l, (i11 & 4) != 0 ? new InterfaceC5074l() { // from class: z.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return PruningProcessingQueue.e((List) obj);
            }
        } : interfaceC5074l2, pVar);
    }
}
