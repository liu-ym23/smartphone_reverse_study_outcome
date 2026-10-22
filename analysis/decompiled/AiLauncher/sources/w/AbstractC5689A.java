package w;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b'\u0018\u00002\u00020\u0001:\u0005\n\u000b\f\r\bB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lw/A;", "", "", "name", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "c", Const.INTENT_KEY_PKGNAME, "e", Const.INTENT_KEY_UMID, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: w.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5689A {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String name;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\u0011¨\u0006\u0012"}, d2 = {"Lw/A$a;", "Lw/A;", "Lw/l;", "cameraError", "", "willAttemptRetry", "<init>", "(IZLkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "I", Const.INTENT_KEY_APIKEY, "()I", "c", "Z", "()Z", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: w.A$a */
    public static final class a extends AbstractC5689A {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int cameraError;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean willAttemptRetry;

        public /* synthetic */ a(int i10, boolean z10, kotlin.jvm.internal.i iVar) {
            this(i10, z10);
        }

        /* renamed from: a, reason: from getter */
        public final int getCameraError() {
            return this.cameraError;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getWillAttemptRetry() {
            return this.willAttemptRetry;
        }

        @Override // w.AbstractC5689A
        /* renamed from: toString */
        public String getName() {
            return super.getName() + "(cameraError=" + ((Object) C5706l.u(this.cameraError)) + ", willAttemptRetry=" + this.willAttemptRetry + ')';
        }

        public a(int i10, boolean z10) {
            super("GRAPH_ERROR");
            this.cameraError = i10;
            this.willAttemptRetry = z10;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lw/A$b;", "Lw/A;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: w.A$b */
    public static final class b extends AbstractC5689A {

        /* renamed from: b, reason: collision with root package name */
        public static final b f42886b = new b();

        public b() {
            super("GRAPH_STARTED");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lw/A$c;", "Lw/A;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: w.A$c */
    public static final class c extends AbstractC5689A {

        /* renamed from: b, reason: collision with root package name */
        public static final c f42887b = new c();

        public c() {
            super("GRAPH_STARTING");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lw/A$d;", "Lw/A;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: w.A$d */
    public static final class d extends AbstractC5689A {

        /* renamed from: b, reason: collision with root package name */
        public static final d f42888b = new d();

        public d() {
            super("GRAPH_STOPPED");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lw/A$e;", "Lw/A;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: w.A$e */
    public static final class e extends AbstractC5689A {

        /* renamed from: b, reason: collision with root package name */
        public static final e f42889b = new e();

        public e() {
            super("GRAPH_STOPPING");
        }
    }

    public AbstractC5689A(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        this.name = name;
    }

    /* renamed from: toString, reason: from getter */
    public String getName() {
        return this.name;
    }
}
