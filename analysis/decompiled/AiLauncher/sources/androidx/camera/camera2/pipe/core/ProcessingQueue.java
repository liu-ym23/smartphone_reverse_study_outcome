package androidx.camera.camera2.pipe.core;

import Oa.a;
import Oa.b;
import Ua.C1060i;
import Ua.M;
import Wa.g;
import Wa.j;
import Y8.t;
import Z8.C1165m;
import Z8.F;
import androidx.camera.camera2.pipe.core.ProcessingQueue;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import p9.InterfaceC5074l;
import p9.p;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 -*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001.BW\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012(\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR&\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR6\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Landroidx/camera/camera2/pipe/core/ProcessingQueue;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "capacity", "Lkotlin/Function1;", "", "LY8/t;", "onUnprocessedElements", "Lkotlin/Function2;", "", "Le9/c;", "process", "<init>", "(ILp9/l;Lp9/p;)V", "element", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/Object;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Le9/c;)Ljava/lang/Object;", "", "cause", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Throwable;)V", Const.INTENT_KEY_APIKEY, "I", "getCapacity", "()I", Const.INTENT_KEY_PKGNAME, "Lp9/l;", "c", "Lp9/p;", "LOa/a;", Const.INTENT_KEY_UMID, "LOa/a;", RobotInfo.STATUS_STARTED, "LWa/g;", "e", "LWa/g;", "channel", "LZ8/m;", "f", "LZ8/m;", "queue", Const.INTENT_KEY_BACKGROUND_COMMAND, "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProcessingQueue<T> {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int capacity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<List<? extends T>, t> onUnprocessedElements;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final p<List<T>, InterfaceC4014c<? super t>, Object> process;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final a started;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final g<T> channel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final C1165m<T> queue;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/pipe/core/ProcessingQueue$Companion;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/camera/camera2/pipe/core/ProcessingQueue;", "LUa/M;", "scope", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/core/ProcessingQueue;LUa/M;)Landroidx/camera/camera2/pipe/core/ProcessingQueue;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final <T> ProcessingQueue<T> a(ProcessingQueue<T> processingQueue, M scope) {
            kotlin.jvm.internal.p.i(processingQueue, "<this>");
            kotlin.jvm.internal.p.i(scope, "scope");
            if (!processingQueue.started.a(false, true)) {
                throw new IllegalStateException("ProcessingQueue cannot be re-started!");
            }
            if (C1060i.d(scope, null, null, new ProcessingQueue$Companion$processIn$job$1(processingQueue, null), 3, null).isCancelled()) {
                processingQueue.i(null);
            }
            return processingQueue;
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProcessingQueue(int i10, InterfaceC5074l<? super List<? extends T>, t> onUnprocessedElements, p<? super List<T>, ? super InterfaceC4014c<? super t>, ? extends Object> process) {
        kotlin.jvm.internal.p.i(onUnprocessedElements, "onUnprocessedElements");
        kotlin.jvm.internal.p.i(process, "process");
        this.capacity = i10;
        this.onUnprocessedElements = onUnprocessedElements;
        this.process = process;
        this.started = b.a(false);
        this.channel = j.b(i10, null, new InterfaceC5074l() { // from class: z.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ProcessingQueue.g(this.f44517a, obj);
            }
        }, 2, null);
        this.queue = new C1165m<>();
    }

    public static final t c(List it) {
        kotlin.jvm.internal.p.i(it, "it");
        return t.f7040a;
    }

    public static final t g(ProcessingQueue processingQueue, Object obj) {
        processingQueue.queue.add(obj);
        return t.f7040a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0085, code lost:
    
        if (r7.invoke(r5, r0) == r1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008e, code lost:
    
        if (r2 == r6.queue.size()) goto L22;
     */
    /* JADX WARN: Path cross not found for [B:22:0x003f, B:26:0x004f], limit reached: 40 */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003f A[Catch: all -> 0x002e, TRY_ENTER, TryCatch #0 {all -> 0x002e, blocks: (B:13:0x002a, B:35:0x0088, B:26:0x004f, B:28:0x0057, B:29:0x005d, B:31:0x0063, B:32:0x0073, B:22:0x003f, B:25:0x004a, B:19:0x0038), top: B:40:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004a A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:13:0x002a, B:35:0x0088, B:26:0x004f, B:28:0x0057, B:29:0x005d, B:31:0x0063, B:32:0x0073, B:22:0x003f, B:25:0x004a, B:19:0x0038), top: B:40:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0057 A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:13:0x002a, B:35:0x0088, B:26:0x004f, B:28:0x0057, B:29:0x005d, B:31:0x0063, B:32:0x0073, B:22:0x003f, B:25:0x004a, B:19:0x0038), top: B:40:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0085 -> B:35:0x0088). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.camera.camera2.pipe.core.ProcessingQueue$processingLoop$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.camera.camera2.pipe.core.ProcessingQueue$processingLoop$1 r0 = (androidx.camera.camera2.pipe.core.ProcessingQueue$processingLoop$1) r0
            int r1 = r0.f10712d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10712d = r1
            goto L18
        L13:
            androidx.camera.camera2.pipe.core.ProcessingQueue$processingLoop$1 r0 = new androidx.camera.camera2.pipe.core.ProcessingQueue$processingLoop$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f10710b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f10712d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            int r2 = r0.f10709a
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L2e
            goto L88
        L2e:
            r7 = move-exception
            goto L91
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L2e
            goto L4a
        L3c:
            kotlin.C4849c.b(r7)
        L3f:
            Wa.g<T> r7 = r6.channel     // Catch: java.lang.Throwable -> L2e
            r0.f10712d = r4     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r7 = r7.receive(r0)     // Catch: java.lang.Throwable -> L2e
            if (r7 != r1) goto L4a
            goto L87
        L4a:
            Z8.m<T> r2 = r6.queue     // Catch: java.lang.Throwable -> L2e
            r2.add(r7)     // Catch: java.lang.Throwable -> L2e
        L4f:
            Z8.m<T> r7 = r6.queue     // Catch: java.lang.Throwable -> L2e
            boolean r7 = r7.isEmpty()     // Catch: java.lang.Throwable -> L2e
            if (r7 != 0) goto L3f
            Wa.g<T> r7 = r6.channel     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r7 = r7.s()     // Catch: java.lang.Throwable -> L2e
        L5d:
            boolean r2 = kotlinx.coroutines.channels.a.j(r7)     // Catch: java.lang.Throwable -> L2e
            if (r2 == 0) goto L73
            Z8.m<T> r2 = r6.queue     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r7 = kotlinx.coroutines.channels.a.g(r7)     // Catch: java.lang.Throwable -> L2e
            r2.add(r7)     // Catch: java.lang.Throwable -> L2e
            Wa.g<T> r7 = r6.channel     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r7 = r7.s()     // Catch: java.lang.Throwable -> L2e
            goto L5d
        L73:
            Z8.m<T> r7 = r6.queue     // Catch: java.lang.Throwable -> L2e
            int r2 = r7.size()     // Catch: java.lang.Throwable -> L2e
            p9.p<java.util.List<T>, e9.c<? super Y8.t>, java.lang.Object> r7 = r6.process     // Catch: java.lang.Throwable -> L2e
            Z8.m<T> r5 = r6.queue     // Catch: java.lang.Throwable -> L2e
            r0.f10709a = r2     // Catch: java.lang.Throwable -> L2e
            r0.f10712d = r3     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r7 = r7.invoke(r5, r0)     // Catch: java.lang.Throwable -> L2e
            if (r7 != r1) goto L88
        L87:
            return r1
        L88:
            Z8.m<T> r7 = r6.queue     // Catch: java.lang.Throwable -> L2e
            int r7 = r7.size()     // Catch: java.lang.Throwable -> L2e
            if (r2 != r7) goto L4f
            goto L3f
        L91:
            r6.i(r7)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.core.ProcessingQueue.h(e9.c):java.lang.Object");
    }

    public final void i(Throwable cause) {
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

    public final boolean j(T element) {
        return kotlinx.coroutines.channels.a.j(this.channel.mo0trySendJP2dKIU(element));
    }

    public /* synthetic */ ProcessingQueue(int i10, InterfaceC5074l interfaceC5074l, p pVar, int i11, i iVar) {
        this((i11 & 1) != 0 ? Integer.MAX_VALUE : i10, (i11 & 2) != 0 ? new InterfaceC5074l() { // from class: z.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ProcessingQueue.c((List) obj);
            }
        } : interfaceC5074l, pVar);
    }
}
