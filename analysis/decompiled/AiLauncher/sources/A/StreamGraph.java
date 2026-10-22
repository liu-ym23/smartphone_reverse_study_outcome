package A;

import Z8.A;
import Z8.C1173v;
import Z8.F;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Size;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.g;
import androidx.camera.camera2.pipe.k;
import androidx.camera.camera2.pipe.s;
import androidx.camera.camera2.pipe.v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import s.C5423E;
import w.C5693E;
import w.G;
import w.InterfaceC5703i;
import w.P;
import w.Q;
import x.C5819i;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0007\b\u0001\u0018\u0000 ]2\u00020\u00012\u00060\u0002j\u0002`\u0003:\u00049=51B/\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0017H\u0002¢\u0006\u0004\b!\u0010\u001bJ#\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0017H\u0002¢\u0006\u0004\b#\u0010\u001bJ\u001a\u0010%\u001a\u0004\u0018\u00010\u001f2\u0006\u0010$\u001a\u00020\u0018H\u0096\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u0004\u0018\u00010\u00182\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R \u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001f0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR \u0010H\u001a\b\u0012\u0004\u0012\u00020C0\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR&\u0010M\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020C0?8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bJ\u0010A\u001a\u0004\bK\u0010LR&\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020N0?8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bO\u0010A\u001a\u0004\bP\u0010LR \u0010T\u001a\b\u0012\u0004\u0012\u00020R0\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010E\u001a\u0004\bS\u0010GR \u0010V\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\bU\u0010E\u001a\u0004\b=\u0010GR \u0010\\\u001a\b\u0012\u0004\u0012\u00020'0W8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020I0\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\bS\u0010E\u001a\u0004\b@\u0010G¨\u0006^"}, d2 = {"LA/q;", "Landroidx/camera/camera2/pipe/v;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "LC/m;", "imageSources", "LX8/a;", "Lw/i;", "cameraControllerProvider", "<init>", "(Landroidx/camera/camera2/pipe/g;Landroidx/camera/camera2/pipe/CameraGraph$b;LC/m;LX8/a;)V", "Landroidx/camera/camera2/pipe/s$a;", "outputConfig", "Landroid/hardware/camera2/params/OutputConfiguration;", "I0", "(Landroidx/camera/camera2/pipe/s$a;)Landroid/hardware/camera2/params/OutputConfiguration;", "", "e0", "(Landroidx/camera/camera2/pipe/CameraGraph$b;)I", "", "Landroidx/camera/camera2/pipe/k$a;", "outputs", "N0", "(Ljava/util/List;)Ljava/util/List;", "", "Y", "(Landroidx/camera/camera2/pipe/g;Landroidx/camera/camera2/pipe/CameraGraph$b;)Z", "Landroidx/camera/camera2/pipe/k;", "unsortedStreams", "R0", "unsortedOutputs", "T0", "config", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroidx/camera/camera2/pipe/k$a;)Landroidx/camera/camera2/pipe/k;", "Lw/Q;", "streamId", "g0", "(I)Landroidx/camera/camera2/pipe/k$a;", "", "toString", "()Ljava/lang/String;", "LY8/t;", "close", "()V", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/g;", "getCameraMetadata", "()Landroidx/camera/camera2/pipe/g;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/CameraGraph$b;", "getGraphConfig", "()Landroidx/camera/camera2/pipe/CameraGraph$b;", "c", "LC/m;", "getImageSources", "()LC/m;", Const.INTENT_KEY_UMID, "LX8/a;", "", "e", "Ljava/util/Map;", "_streamMap", "LA/q$c;", "f", "Ljava/util/List;", "D0", "()Ljava/util/List;", "outputConfigs", "Landroidx/camera/camera2/pipe/s;", Const.INTENT_KEY_BACKGROUND_COMMAND, "v0", "()Ljava/util/Map;", "outputConfigMap", "LC/l;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "k0", "imageSourceMap", "Landroidx/camera/camera2/pipe/p;", "l", "inputs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "streams", "", "k", "Ljava/util/Set;", "getStreamIds", "()Ljava/util/Set;", "streamIds", "m", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: A.q, reason: from toString */
/* loaded from: classes.dex */
public final class StreamGraph implements v, AutoCloseable {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: n, reason: collision with root package name */
    public static final Oa.c f44n = Oa.b.c(0);

    /* renamed from: o, reason: collision with root package name */
    public static final Oa.c f45o = Oa.b.c(0);

    /* renamed from: p, reason: collision with root package name */
    public static final Oa.c f46p = Oa.b.c(0);

    /* renamed from: q, reason: collision with root package name */
    public static final Oa.c f47q = Oa.b.c(0);

    /* renamed from: r, reason: collision with root package name */
    public static final Oa.c f48r = Oa.b.c(0);

    /* renamed from: s, reason: collision with root package name */
    public static final List<s.d> f49s;

    /* renamed from: t, reason: collision with root package name */
    public static final Comparator<androidx.camera.camera2.pipe.k> f50t;

    /* renamed from: u, reason: collision with root package name */
    public static final List<P> f51u;

    /* renamed from: v, reason: collision with root package name */
    public static final Comparator<androidx.camera.camera2.pipe.k> f52v;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.g cameraMetadata;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final CameraGraph.b graphConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final C.m imageSources;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final X8.a<InterfaceC5703i> cameraControllerProvider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Map<k.a, androidx.camera.camera2.pipe.k> _streamMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final List<c> outputConfigs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Map<s, c> outputConfigMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Map<Q, C.l> imageSourceMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final List<androidx.camera.camera2.pipe.p> inputs;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final List<androidx.camera.camera2.pipe.k> streams;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final Set<Q> streamIds;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final List<s> outputs;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0019R$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001e¨\u0006\""}, d2 = {"LA/q$a;", "", "<init>", "()V", "Lw/Q;", "e", "()I", "Lw/G;", Const.INTENT_KEY_UMID, "Lw/E;", "c", "LA/l;", Const.INTENT_KEY_APIKEY, "", Const.INTENT_KEY_PKGNAME, "LOa/c;", "streamIds", "LOa/c;", "outputIds", "inputIds", "configIds", "groupIds", "", "Landroidx/camera/camera2/pipe/s$d;", "previewOutputTypes", "Ljava/util/List;", "Ljava/util/Comparator;", "Landroidx/camera/camera2/pipe/k;", "Lkotlin/Comparator;", "previewOutputTypesComparator", "Ljava/util/Comparator;", "Lw/P;", "previewFormats", "previewFormatComparator", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: A.q$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final int a() {
            return l.a(StreamGraph.f47q.d());
        }

        public final int b() {
            return StreamGraph.f48r.d();
        }

        public final int c() {
            return C5693E.a(StreamGraph.f46p.d());
        }

        public final int d() {
            return G.b(StreamGraph.f45o.d());
        }

        public final int e() {
            return Q.b(StreamGraph.f44n.d());
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\n\u0010\rR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"LA/q$b;", "Landroidx/camera/camera2/pipe/p;", "Lw/E;", "id", "", "maxImages", "Lw/P;", "format", "<init>", "(IIILkotlin/jvm/internal/i;)V", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_UMID, "()I", Const.INTENT_KEY_PKGNAME, "c", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: A.q$b */
    public static final class b implements androidx.camera.camera2.pipe.p {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final int maxImages;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final int format;

        public /* synthetic */ b(int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
            this(i10, i11, i12);
        }

        @Override // androidx.camera.camera2.pipe.p
        /* renamed from: a, reason: from getter */
        public int getMaxImages() {
            return this.maxImages;
        }

        @Override // androidx.camera.camera2.pipe.p
        /* renamed from: c, reason: from getter */
        public int getFormat() {
            return this.format;
        }

        @Override // androidx.camera.camera2.pipe.p
        /* renamed from: d, reason: from getter */
        public int getId() {
            return this.id;
        }

        public b(int i10, int i11, int i12) {
            this.id = i10;
            this.maxImages = i11;
            this.format = i12;
        }
    }

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b*\u0010#\u001a\u0004\b+\u0010%R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b\"\u0010!R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b+\u00102\u001a\u0004\b.\u00103R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b0\u00104\u001a\u0004\b*\u00105R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b6\u00108R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b,\u0010;R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b(\u0010<\u001a\u0004\b=\u0010>R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006¢\u0006\f\n\u0004\b=\u0010C\u001a\u0004\b9\u0010DR \u0010G\u001a\b\u0012\u0004\u0012\u00020F0E8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bA\u0010C\u001a\u0004\b?\u0010DR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010H\u001a\u0004\bI\u0010JR\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020F0\u001a8F¢\u0006\u0006\u001a\u0004\bK\u0010DR\u0011\u0010O\u001a\u00020M8F¢\u0006\u0006\u001a\u0004\b&\u0010NR\u0011\u0010Q\u001a\u00020M8F¢\u0006\u0006\u001a\u0004\bP\u0010N¨\u0006R"}, d2 = {"LA/q$c;", "", "LA/l;", "id", "Landroid/util/Size;", ContentDisposition.Parameters.Size, "Lw/P;", "format", "Lw/n;", C3081a.CAMERA_FOCUS, "", "groupNumber", "Landroid/hardware/camera2/params/OutputConfiguration;", "externalOutputConfig", "Landroidx/camera/camera2/pipe/s$d;", "deferredOutputType", "Landroidx/camera/camera2/pipe/s$c;", "mirrorMode", "Landroidx/camera/camera2/pipe/s$h;", "timestampBase", "Landroidx/camera/camera2/pipe/s$b;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/s$f;", "streamUseCase", "Landroidx/camera/camera2/pipe/s$g;", "streamUseHint", "", "Landroidx/camera/camera2/pipe/s$e;", "sensorPixelModes", "<init>", "(ILandroid/util/Size;ILjava/lang/String;Ljava/lang/Integer;Landroid/hardware/camera2/params/OutputConfiguration;Landroidx/camera/camera2/pipe/s$d;Landroidx/camera/camera2/pipe/s$c;Landroidx/camera/camera2/pipe/s$h;Landroidx/camera/camera2/pipe/s$b;Landroidx/camera/camera2/pipe/s$f;Landroidx/camera/camera2/pipe/s$g;Ljava/util/List;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "I", "getId-hoCEiqs", "()I", Const.INTENT_KEY_PKGNAME, "Landroid/util/Size;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Landroid/util/Size;", "c", "f", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "e", "Ljava/lang/Integer;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/Integer;", "Landroid/hardware/camera2/params/OutputConfiguration;", "()Landroid/hardware/camera2/params/OutputConfiguration;", "Landroidx/camera/camera2/pipe/s$d;", "()Landroidx/camera/camera2/pipe/s$d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/camera/camera2/pipe/s$c;", "()Landroidx/camera/camera2/pipe/s$c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroidx/camera/camera2/pipe/s$b;", "()Landroidx/camera/camera2/pipe/s$b;", "Landroidx/camera/camera2/pipe/s$f;", "l", "()Landroidx/camera/camera2/pipe/s$f;", "k", "Landroidx/camera/camera2/pipe/s$g;", "m", "()Landroidx/camera/camera2/pipe/s$g;", "Ljava/util/List;", "()Ljava/util/List;", "", "Landroidx/camera/camera2/pipe/k;", "streamBuilder", "Landroidx/camera/camera2/pipe/s$h;", "p", "()Landroidx/camera/camera2/pipe/s$h;", "n", "streams", "", "()Z", "deferrable", "o", "surfaceSharing", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: A.q$c */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Size size;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final int format;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final String camera;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final Integer groupNumber;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final OutputConfiguration externalOutputConfig;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public final s.d deferredOutputType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public final s.c mirrorMode;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public final s.b dynamicRangeProfile;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public final s.f streamUseCase;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public final s.g streamUseHint;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        public final List<s.e> sensorPixelModes;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        public final List<androidx.camera.camera2.pipe.k> streamBuilder;

        public /* synthetic */ c(int i10, Size size, int i11, String str, Integer num, OutputConfiguration outputConfiguration, s.d dVar, s.c cVar, s.h hVar, s.b bVar, s.f fVar, s.g gVar, List list, kotlin.jvm.internal.i iVar) {
            this(i10, size, i11, str, num, outputConfiguration, dVar, cVar, hVar, bVar, fVar, gVar, list);
        }

        /* renamed from: a, reason: from getter */
        public final String getCamera() {
            return this.camera;
        }

        public final boolean b() {
            return this.deferredOutputType != null;
        }

        /* renamed from: c, reason: from getter */
        public final s.d getDeferredOutputType() {
            return this.deferredOutputType;
        }

        /* renamed from: d, reason: from getter */
        public final s.b getDynamicRangeProfile() {
            return this.dynamicRangeProfile;
        }

        /* renamed from: e, reason: from getter */
        public final OutputConfiguration getExternalOutputConfig() {
            return this.externalOutputConfig;
        }

        /* renamed from: f, reason: from getter */
        public final int getFormat() {
            return this.format;
        }

        /* renamed from: g, reason: from getter */
        public final Integer getGroupNumber() {
            return this.groupNumber;
        }

        /* renamed from: h, reason: from getter */
        public final s.c getMirrorMode() {
            return this.mirrorMode;
        }

        public final List<s.e> i() {
            return this.sensorPixelModes;
        }

        /* renamed from: j, reason: from getter */
        public final Size getSize() {
            return this.size;
        }

        public final List<androidx.camera.camera2.pipe.k> k() {
            return this.streamBuilder;
        }

        /* renamed from: l, reason: from getter */
        public final s.f getStreamUseCase() {
            return this.streamUseCase;
        }

        /* renamed from: m, reason: from getter */
        public final s.g getStreamUseHint() {
            return this.streamUseHint;
        }

        public final List<androidx.camera.camera2.pipe.k> n() {
            return this.streamBuilder;
        }

        public final boolean o() {
            return this.streamBuilder.size() > 1;
        }

        public final s.h p() {
            return null;
        }

        public String toString() {
            return l.b(this.id);
        }

        public c(int i10, Size size, int i11, String camera, Integer num, OutputConfiguration outputConfiguration, s.d dVar, s.c cVar, s.h hVar, s.b bVar, s.f fVar, s.g gVar, List<s.e> sensorPixelModes) {
            kotlin.jvm.internal.p.i(size, "size");
            kotlin.jvm.internal.p.i(camera, "camera");
            kotlin.jvm.internal.p.i(sensorPixelModes, "sensorPixelModes");
            this.id = i10;
            this.size = size;
            this.format = i11;
            this.camera = camera;
            this.groupNumber = num;
            this.externalOutputConfig = outputConfiguration;
            this.deferredOutputType = dVar;
            this.mirrorMode = cVar;
            this.dynamicRangeProfile = bVar;
            this.streamUseCase = fVar;
            this.streamUseHint = gVar;
            this.sensorPixelModes = sensorPixelModes;
            this.streamBuilder = new ArrayList();
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b#\u0010\u001eR\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\u001f\u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010.\u001a\u0004\b/\u00100R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00101\u001a\u0004\b&\u00102R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u00103\u001a\u0004\b\u001b\u00104R\"\u0010;\u001a\u0002058\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b,\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010<\u001a\u0004\b$\u0010=¨\u0006>"}, d2 = {"LA/q$d;", "Landroidx/camera/camera2/pipe/s;", "Lw/G;", "id", "Landroid/util/Size;", ContentDisposition.Parameters.Size, "Lw/P;", "format", "Lw/n;", C3081a.CAMERA_FOCUS, "Landroidx/camera/camera2/pipe/s$c;", "mirrorMode", "Landroidx/camera/camera2/pipe/s$h;", "timestampBase", "Landroidx/camera/camera2/pipe/s$b;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/s$f;", "streamUseCase", "Landroidx/camera/camera2/pipe/s$d;", "outputType", "Landroidx/camera/camera2/pipe/s$g;", "streamUseHint", "<init>", "(ILandroid/util/Size;ILjava/lang/String;Landroidx/camera/camera2/pipe/s$c;Landroidx/camera/camera2/pipe/s$h;Landroidx/camera/camera2/pipe/s$b;Landroidx/camera/camera2/pipe/s$f;Landroidx/camera/camera2/pipe/s$d;Landroidx/camera/camera2/pipe/s$g;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_BACKGROUND_COMMAND, "()I", Const.INTENT_KEY_PKGNAME, "Landroid/util/Size;", "getSize", "()Landroid/util/Size;", "c", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "e", "Landroidx/camera/camera2/pipe/s$c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Landroidx/camera/camera2/pipe/s$c;", "f", "Landroidx/camera/camera2/pipe/s$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Landroidx/camera/camera2/pipe/s$b;", "Landroidx/camera/camera2/pipe/s$f;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Landroidx/camera/camera2/pipe/s$f;", "Landroidx/camera/camera2/pipe/s$d;", "()Landroidx/camera/camera2/pipe/s$d;", "Landroidx/camera/camera2/pipe/s$g;", "()Landroidx/camera/camera2/pipe/s$g;", "Landroidx/camera/camera2/pipe/k;", "Landroidx/camera/camera2/pipe/k;", "k", "()Landroidx/camera/camera2/pipe/k;", "l", "(Landroidx/camera/camera2/pipe/k;)V", "stream", "Landroidx/camera/camera2/pipe/s$h;", "()Landroidx/camera/camera2/pipe/s$h;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: A.q$d */
    public static final class d implements s {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Size size;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final int format;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final String camera;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final s.c mirrorMode;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final s.b dynamicRangeProfile;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public final s.f streamUseCase;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public final s.d outputType;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public final s.g streamUseHint;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public androidx.camera.camera2.pipe.k stream;

        public /* synthetic */ d(int i10, Size size, int i11, String str, s.c cVar, s.h hVar, s.b bVar, s.f fVar, s.d dVar, s.g gVar, kotlin.jvm.internal.i iVar) {
            this(i10, size, i11, str, cVar, hVar, bVar, fVar, dVar, gVar);
        }

        @Override // androidx.camera.camera2.pipe.s
        /* renamed from: a, reason: from getter */
        public s.g getStreamUseHint() {
            return this.streamUseHint;
        }

        @Override // androidx.camera.camera2.pipe.s
        /* renamed from: b, reason: from getter */
        public String getCamera() {
            return this.camera;
        }

        @Override // androidx.camera.camera2.pipe.s
        /* renamed from: c, reason: from getter */
        public int getFormat() {
            return this.format;
        }

        @Override // androidx.camera.camera2.pipe.s
        public s.h d() {
            return null;
        }

        @Override // androidx.camera.camera2.pipe.s
        /* renamed from: e, reason: from getter */
        public s.d getOutputType() {
            return this.outputType;
        }

        @Override // androidx.camera.camera2.pipe.s
        /* renamed from: g, reason: from getter */
        public int getId() {
            return this.id;
        }

        @Override // androidx.camera.camera2.pipe.s
        public Size getSize() {
            return this.size;
        }

        @Override // androidx.camera.camera2.pipe.s
        /* renamed from: h, reason: from getter */
        public s.f getStreamUseCase() {
            return this.streamUseCase;
        }

        @Override // androidx.camera.camera2.pipe.s
        /* renamed from: i, reason: from getter */
        public s.c getMirrorMode() {
            return this.mirrorMode;
        }

        @Override // androidx.camera.camera2.pipe.s
        /* renamed from: j, reason: from getter */
        public s.b getDynamicRangeProfile() {
            return this.dynamicRangeProfile;
        }

        @Override // androidx.camera.camera2.pipe.s
        public androidx.camera.camera2.pipe.k k() {
            androidx.camera.camera2.pipe.k kVar = this.stream;
            if (kVar != null) {
                return kVar;
            }
            kotlin.jvm.internal.p.A("stream");
            return null;
        }

        public void l(androidx.camera.camera2.pipe.k kVar) {
            kotlin.jvm.internal.p.i(kVar, "<set-?>");
            this.stream = kVar;
        }

        public String toString() {
            return G.f(getId());
        }

        public d(int i10, Size size, int i11, String camera, s.c cVar, s.h hVar, s.b bVar, s.f fVar, s.d dVar, s.g gVar) {
            kotlin.jvm.internal.p.i(size, "size");
            kotlin.jvm.internal.p.i(camera, "camera");
            this.id = i10;
            this.size = size;
            this.format = i11;
            this.camera = camera;
            this.mirrorMode = cVar;
            this.dynamicRangeProfile = bVar;
            this.streamUseCase = fVar;
            this.outputType = dVar;
            this.streamUseHint = gVar;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: A.q$e */
    public static final class e<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            Iterator<T> it = ((androidx.camera.camera2.pipe.k) t10).b().iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Integer numValueOf = Integer.valueOf(F.v0(StreamGraph.f49s, ((s) it.next()).getOutputType()));
            while (it.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(F.v0(StreamGraph.f49s, ((s) it.next()).getOutputType()));
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
            Iterator<T> it2 = ((androidx.camera.camera2.pipe.k) t11).b().iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Integer numValueOf3 = Integer.valueOf(F.v0(StreamGraph.f49s, ((s) it2.next()).getOutputType()));
            while (it2.hasNext()) {
                Integer numValueOf4 = Integer.valueOf(F.v0(StreamGraph.f49s, ((s) it2.next()).getOutputType()));
                if (numValueOf3.compareTo(numValueOf4) < 0) {
                    numValueOf3 = numValueOf4;
                }
            }
            return b9.b.d(numValueOf, numValueOf3);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: A.q$f */
    public static final class f<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            Iterator<T> it = ((androidx.camera.camera2.pipe.k) t10).b().iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Integer numValueOf = Integer.valueOf(StreamGraph.f51u.indexOf(P.c(((s) it.next()).getFormat())));
            while (it.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(StreamGraph.f51u.indexOf(P.c(((s) it.next()).getFormat())));
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
            Iterator<T> it2 = ((androidx.camera.camera2.pipe.k) t11).b().iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Integer numValueOf3 = Integer.valueOf(StreamGraph.f51u.indexOf(P.c(((s) it2.next()).getFormat())));
            while (it2.hasNext()) {
                Integer numValueOf4 = Integer.valueOf(StreamGraph.f51u.indexOf(P.c(((s) it2.next()).getFormat())));
                if (numValueOf3.compareTo(numValueOf4) < 0) {
                    numValueOf3 = numValueOf4;
                }
            }
            return b9.b.d(numValueOf, numValueOf3);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: A.q$g */
    public static final class g<T> implements Comparator {
        public g() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            Iterator<T> it = ((c) t10).n().iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Integer numValueOf = Integer.valueOf(StreamGraph.this.d().indexOf((androidx.camera.camera2.pipe.k) it.next()));
            while (it.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(StreamGraph.this.d().indexOf((androidx.camera.camera2.pipe.k) it.next()));
                if (numValueOf.compareTo(numValueOf2) > 0) {
                    numValueOf = numValueOf2;
                }
            }
            Iterator<T> it2 = ((c) t11).n().iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Integer numValueOf3 = Integer.valueOf(StreamGraph.this.d().indexOf((androidx.camera.camera2.pipe.k) it2.next()));
            while (it2.hasNext()) {
                Integer numValueOf4 = Integer.valueOf(StreamGraph.this.d().indexOf((androidx.camera.camera2.pipe.k) it2.next()));
                if (numValueOf3.compareTo(numValueOf4) > 0) {
                    numValueOf3 = numValueOf4;
                }
            }
            return b9.b.d(numValueOf, numValueOf3);
        }
    }

    static {
        s.d.Companion companion = s.d.INSTANCE;
        f49s = C1173v.p(companion.f(), companion.e());
        f50t = new e();
        P.Companion companion2 = P.INSTANCE;
        f51u = C1173v.p(P.c(companion2.b()), P.c(companion2.a()));
        f52v = new f();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public StreamGraph(androidx.camera.camera2.pipe.g r29, androidx.camera.camera2.pipe.CameraGraph.b r30, C.m r31, X8.a<w.InterfaceC5703i> r32) {
        /*
            Method dump skipped, instructions count: 723
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A.StreamGraph.<init>(androidx.camera.camera2.pipe.g, androidx.camera.camera2.pipe.CameraGraph$b, C.m, X8.a):void");
    }

    public final List<c> D0() {
        return this.outputConfigs;
    }

    public final OutputConfiguration I0(s.a outputConfig) {
        s.a.b bVar = outputConfig instanceof s.a.b ? (s.a.b) outputConfig : null;
        if (bVar != null) {
            return bVar.getOutput();
        }
        return null;
    }

    public final List<Integer> N0(List<k.a> outputs) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = outputs.iterator();
        while (it.hasNext()) {
            A.E(arrayList, ((k.a) it.next()).b());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof s.a.b) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            int iC = C5819i.c(((s.a.b) it2.next()).getOutput());
            if (!arrayList3.contains(Integer.valueOf(iC))) {
                arrayList3.add(Integer.valueOf(iC));
            }
        }
        return arrayList3;
    }

    public final List<androidx.camera.camera2.pipe.k> R0(List<androidx.camera.camera2.pipe.k> unsortedStreams) {
        boolean z10;
        boolean z11;
        List<androidx.camera.camera2.pipe.k> list = unsortedStreams;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z12 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            List<s> listB = ((androidx.camera.camera2.pipe.k) next).b();
            if ((listB instanceof Collection) && listB.isEmpty()) {
                z12 = false;
            } else {
                Iterator<T> it2 = listB.iterator();
                while (it2.hasNext()) {
                    s.f streamUseCase = ((s) it2.next()).getStreamUseCase();
                    if (streamUseCase == null ? false : s.f.g(streamUseCase.getValue(), s.f.INSTANCE.b())) {
                        break;
                    }
                }
                z12 = false;
            }
            if (z12) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list2 = (List) pair.a();
        List list3 = (List) pair.b();
        List list4 = list2;
        if (!list4.isEmpty()) {
            return F.S0(list4, list3);
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : list) {
            List<s> listB2 = ((androidx.camera.camera2.pipe.k) obj).b();
            if ((listB2 instanceof Collection) && listB2.isEmpty()) {
                z11 = false;
            } else {
                Iterator<T> it3 = listB2.iterator();
                while (it3.hasNext()) {
                    if (F.f0(f49s, ((s) it3.next()).getOutputType())) {
                        z11 = true;
                        break;
                    }
                }
                z11 = false;
            }
            if (z11) {
                arrayList3.add(obj);
            } else {
                arrayList4.add(obj);
            }
        }
        Pair pair2 = new Pair(arrayList3, arrayList4);
        List list5 = (List) pair2.a();
        List list6 = (List) pair2.b();
        if (!list5.isEmpty()) {
            return F.S0(F.c1(list5, f50t), list6);
        }
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        for (Object obj2 : list) {
            List<s> listB3 = ((androidx.camera.camera2.pipe.k) obj2).b();
            if ((listB3 instanceof Collection) && listB3.isEmpty()) {
                z10 = false;
            } else {
                Iterator<T> it4 = listB3.iterator();
                while (it4.hasNext()) {
                    if (f51u.contains(P.c(((s) it4.next()).getFormat()))) {
                        z10 = true;
                        break;
                    }
                }
                z10 = false;
            }
            if (z10) {
                arrayList5.add(obj2);
            } else {
                arrayList6.add(obj2);
            }
        }
        Pair pair3 = new Pair(arrayList5, arrayList6);
        List list7 = (List) pair3.a();
        return !list7.isEmpty() ? F.S0(F.c1(list7, f52v), (List) pair3.b()) : unsortedStreams;
    }

    public final List<androidx.camera.camera2.pipe.k> T0(List<androidx.camera.camera2.pipe.k> unsortedOutputs) {
        boolean z10;
        List<androidx.camera.camera2.pipe.k> list = unsortedOutputs;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z11 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            List<s> listB = ((androidx.camera.camera2.pipe.k) next).b();
            if ((listB instanceof Collection) && listB.isEmpty()) {
                z11 = false;
            } else {
                Iterator<T> it2 = listB.iterator();
                while (it2.hasNext()) {
                    s.f streamUseCase = ((s) it2.next()).getStreamUseCase();
                    if (streamUseCase == null ? false : s.f.g(streamUseCase.getValue(), s.f.INSTANCE.c())) {
                        break;
                    }
                }
                z11 = false;
            }
            if (z11) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list2 = (List) pair.a();
        List list3 = (List) pair.b();
        if (!list2.isEmpty()) {
            return F.S0(list3, list2);
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : list) {
            List<s> listB2 = ((androidx.camera.camera2.pipe.k) obj).b();
            if ((listB2 instanceof Collection) && listB2.isEmpty()) {
                z10 = false;
            } else {
                Iterator<T> it3 = listB2.iterator();
                while (it3.hasNext()) {
                    s.g streamUseHint = ((s) it3.next()).getStreamUseHint();
                    if (streamUseHint == null ? false : s.g.f(streamUseHint.getValue(), s.g.INSTANCE.b())) {
                        z10 = true;
                        break;
                    }
                }
                z10 = false;
            }
            if (z10) {
                arrayList3.add(obj);
            } else {
                arrayList4.add(obj);
            }
        }
        Pair pair2 = new Pair(arrayList3, arrayList4);
        List list4 = (List) pair2.a();
        return !list4.isEmpty() ? F.S0((List) pair2.b(), list4) : unsortedOutputs;
    }

    public final boolean Y(androidx.camera.camera2.pipe.g cameraMetadata, CameraGraph.b graphConfig) {
        if (!CameraGraph.e.f(graphConfig.getSessionMode(), CameraGraph.e.INSTANCE.d())) {
            return false;
        }
        g.Companion companion = androidx.camera.camera2.pipe.g.INSTANCE;
        return (companion.l(cameraMetadata) || companion.m(cameraMetadata) || companion.k(cameraMetadata)) ? false : true;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        Iterator<C.l> it = this.imageSourceMap.values().iterator();
        while (it.hasNext()) {
            C5423E.a(it.next());
        }
    }

    @Override // androidx.camera.camera2.pipe.v
    public List<androidx.camera.camera2.pipe.k> d() {
        return this.streams;
    }

    @Override // androidx.camera.camera2.pipe.v
    public List<s> e() {
        return this.outputs;
    }

    public final int e0(CameraGraph.b graphConfig) {
        List<Integer> listN0 = N0(graphConfig.r());
        int iB = INSTANCE.b();
        while (listN0.contains(Integer.valueOf(iB))) {
            iB = INSTANCE.b();
        }
        return iB;
    }

    public final k.a g0(int streamId) {
        Object next;
        Iterator<T> it = this._streamMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Q.d(((androidx.camera.camera2.pipe.k) ((Map.Entry) next).getValue()).getId(), streamId)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (k.a) entry.getKey();
        }
        return null;
    }

    @Override // androidx.camera.camera2.pipe.v
    public androidx.camera.camera2.pipe.k i(k.a config) {
        kotlin.jvm.internal.p.i(config, "config");
        return this._streamMap.get(config);
    }

    public final Map<Q, C.l> k0() {
        return this.imageSourceMap;
    }

    @Override // androidx.camera.camera2.pipe.v
    public List<androidx.camera.camera2.pipe.p> l() {
        return this.inputs;
    }

    public String toString() {
        return "StreamGraph(" + this._streamMap + ')';
    }

    public final Map<s, c> v0() {
        return this.outputConfigMap;
    }
}
