package androidx.camera.camera2.pipe;

import Z8.C1172u;
import Z8.F;
import androidx.camera.camera2.pipe.s;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import w.C5691C;
import w.P;
import w.Q;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/k;", "", "Lw/Q;", "id", "", "Landroidx/camera/camera2/pipe/s;", "outputs", "<init>", "(ILjava/util/List;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "I", "()I", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "()Ljava/util/List;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<s> outputs;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\fB#\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\f\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/k$a;", "", "", "Landroidx/camera/camera2/pipe/s$a;", "outputs", "Lw/C;", "imageSourceConfig", "<init>", "(Ljava/util/List;Lw/C;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "Lw/C;", "()Lw/C;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<s.a> outputs;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/pipe/k$a$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/s$a;", "output", "Lw/C;", "imageSourceConfig", "Landroidx/camera/camera2/pipe/k$a;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/s$a;Lw/C;)Landroidx/camera/camera2/pipe/k$a;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.k$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public static /* synthetic */ a b(Companion companion, s.a aVar, C5691C c5691c, int i10, Object obj) {
                if ((i10 & 2) != 0) {
                    c5691c = null;
                }
                return companion.a(aVar, c5691c);
            }

            public final a a(s.a output, C5691C imageSourceConfig) {
                kotlin.jvm.internal.p.i(output, "output");
                return new a(C1172u.e(output), imageSourceConfig);
            }

            public Companion() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends s.a> outputs, C5691C c5691c) {
            kotlin.jvm.internal.p.i(outputs, "outputs");
            this.outputs = outputs;
            s.a aVar = (s.a) F.q0(outputs);
            List<? extends s.a> list = outputs;
            if ((list instanceof Collection) && list.isEmpty()) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!P.f(((s.a) it.next()).getFormat(), aVar.getFormat())) {
                    throw new IllegalStateException("All outputs must have the same format!");
                }
            }
        }

        public final C5691C a() {
            return null;
        }

        public final List<s.a> b() {
            return this.outputs;
        }

        public String toString() {
            return "CameraStream.Config(outputs=" + this.outputs + ", imageSourceConfig=" + ((Object) null) + ')';
        }
    }

    public /* synthetic */ k(int i10, List list, kotlin.jvm.internal.i iVar) {
        this(i10, list);
    }

    /* renamed from: a, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final List<s> b() {
        return this.outputs;
    }

    public String toString() {
        return Q.f(this.id);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(int i10, List<? extends s> outputs) {
        kotlin.jvm.internal.p.i(outputs, "outputs");
        this.id = i10;
        this.outputs = outputs;
    }
}
