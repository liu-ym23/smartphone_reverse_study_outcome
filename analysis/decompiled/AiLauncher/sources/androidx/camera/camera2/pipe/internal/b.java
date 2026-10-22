package androidx.camera.camera2.pipe.internal;

import A.StreamGraph;
import C.h;
import C.l;
import C.q;
import Z8.C1174w;
import Z8.F;
import androidx.camera.camera2.pipe.internal.FrameState;
import androidx.camera.camera2.pipe.internal.a;
import androidx.camera.camera2.pipe.internal.f;
import androidx.camera.camera2.pipe.k;
import androidx.camera.camera2.pipe.s;
import androidx.camera.camera2.pipe.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import w.C5691C;
import w.G;
import w.H;
import w.J;
import w.K;
import w.Q;
import w.w;
import w.z;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 E2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002-+B'\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J'\u0010#\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0014H\u0016¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00170/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R2\u00107\u001a \u0012\u0004\u0012\u00020\u001b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u0002040/03038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u000209088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\"\u0010D\u001a\u00020=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006F"}, d2 = {"Landroidx/camera/camera2/pipe/internal/b;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Landroidx/camera/camera2/pipe/t$a;", "LA/q;", "streamGraphImpl", "Landroidx/camera/camera2/pipe/internal/a;", "frameCaptureQueue", "", "isCameraTimebaseRealtime", "", "realtimeToMonotonicOffsetNs", "<init>", "(LA/q;Landroidx/camera/camera2/pipe/internal/a;ZJ)V", "Lw/K;", "requestMetadata", "Lw/y;", "frameNumber", "Lw/r;", "timestamp", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lw/K;JJ)V", "Lw/w;", "result", "g0", "(Lw/K;JLw/w;)V", "Lw/Q;", "streamId", "Lw/G;", "outputId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lw/K;JII)V", "Lw/J;", "requestFailure", "Y", "(Lw/K;JLw/J;)V", "Landroidx/camera/camera2/pipe/t;", "request", "G", "(Landroidx/camera/camera2/pipe/t;)V", "close", "()V", Const.INTENT_KEY_APIKEY, "LA/q;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/internal/a;", "Landroidx/camera/camera2/pipe/internal/d;", "c", "Landroidx/camera/camera2/pipe/internal/d;", "frameInfoDistributor", "", "LC/q;", Const.INTENT_KEY_UMID, "Ljava/util/Map;", "imageDistributors", "", "Landroidx/camera/camera2/pipe/k;", "e", "Ljava/util/Set;", "imageStreams", "Landroidx/camera/camera2/pipe/internal/b$b;", "f", "Landroidx/camera/camera2/pipe/internal/b$b;", "getFrameStartedListener", "()Landroidx/camera/camera2/pipe/internal/b$b;", "setFrameStartedListener", "(Landroidx/camera/camera2/pipe/internal/b$b;)V", "frameStartedListener", Const.INTENT_KEY_BACKGROUND_COMMAND, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class b implements AutoCloseable, t.a {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final StreamGraph streamGraphImpl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final a frameCaptureQueue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final d<w> frameInfoDistributor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Map<Q, Map<G, d<q>>> imageDistributors;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Set<k> imageStreams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public InterfaceC0140b frameStartedListener;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/camera/camera2/pipe/internal/b$a;", "", "<init>", "()V", "Lw/Q;", "cameraStreamId", "Landroidx/camera/camera2/pipe/k$a;", "cameraStreamConfig", "Lw/C;", "imageSourceConfig", "", "isCameraTimebaseRealtime", "", "realtimeToMonotonicOffsetNs", "Landroidx/camera/camera2/pipe/internal/e;", Const.INTENT_KEY_PKGNAME, "(ILandroidx/camera/camera2/pipe/k$a;Lw/C;ZJ)Landroidx/camera/camera2/pipe/internal/e;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.internal.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final e b(int cameraStreamId, k.a cameraStreamConfig, C5691C imageSourceConfig, boolean isCameraTimebaseRealtime, long realtimeToMonotonicOffsetNs) {
            if (isCameraTimebaseRealtime) {
                List<s.a> listB = cameraStreamConfig.b();
                if (!(listB instanceof Collection) || !listB.isEmpty()) {
                    Iterator<T> it = listB.iterator();
                    while (it.hasNext()) {
                        ((s.a) it.next()).i();
                    }
                }
                throw null;
            }
            List<s.a> listB2 = cameraStreamConfig.b();
            if (!(listB2 instanceof Collection) || !listB2.isEmpty()) {
                Iterator<T> it2 = listB2.iterator();
                while (it2.hasNext()) {
                    ((s.a) it2.next()).i();
                    s.h.INSTANCE.a();
                }
            }
            return e.INSTANCE.a();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/internal/b$b;", "", "Lw/z;", "frameReference", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lw/z;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.internal.b$b, reason: collision with other inner class name */
    public interface InterfaceC0140b {
        void a(z frameReference);
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class c implements h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map<G, d<q>> f11023a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f11024b;

        public c(Map<G, d<q>> map, l lVar) {
            this.f11023a = map;
            this.f11024b = lVar;
        }
    }

    public b(StreamGraph streamGraphImpl, a frameCaptureQueue, boolean z10, long j10) {
        p.i(streamGraphImpl, "streamGraphImpl");
        p.i(frameCaptureQueue, "frameCaptureQueue");
        this.streamGraphImpl = streamGraphImpl;
        this.frameCaptureQueue = frameCaptureQueue;
        this.frameInfoDistributor = new d<>(0, C.p.f1613a, e.INSTANCE.a(), 1, null);
        Map<Q, l> mapK0 = streamGraphImpl.k0();
        LinkedHashMap linkedHashMap = new LinkedHashMap(Z8.Q.e(mapK0.size()));
        Iterator<T> it = mapK0.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            int value = ((Q) entry.getKey()).getValue();
            l lVar = (l) entry.getValue();
            final k kVarB = this.streamGraphImpl.b(value);
            if (kVarB == null) {
                throw new IllegalStateException("Required value was null.");
            }
            k.a aVarG0 = this.streamGraphImpl.g0(value);
            p.f(aVarG0);
            aVarG0.a();
            p.f(null);
            e eVarB = INSTANCE.b(value, aVarG0, null, z10, j10);
            Map mapC = Z8.Q.c();
            for (s sVar : kVarB.b()) {
                mapC.put(G.a(sVar.getId()), new d(0, C.e.f1611a, eVarB, 1, null));
            }
            final Map mapB = Z8.Q.b(mapC);
            lVar.N(new c(mapB, lVar));
            lVar.M(new C.f() { // from class: B.g
            });
            linkedHashMap.put(key, mapB);
        }
        this.imageDistributors = linkedHashMap;
        Set setKeySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList(C1174w.x(setKeySet, 10));
        Iterator it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            k kVarB2 = this.streamGraphImpl.b(((Q) it2.next()).getValue());
            if (kVarB2 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            arrayList.add(kVarB2);
        }
        this.imageStreams = F.r1(arrayList);
        this.frameStartedListener = new InterfaceC0140b() { // from class: B.h
            @Override // androidx.camera.camera2.pipe.internal.b.InterfaceC0140b
            public final void a(z zVar) {
                androidx.camera.camera2.pipe.internal.b.T0(zVar);
            }
        };
    }

    public static final void T0(z it) {
        p.i(it, "it");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.camera.camera2.pipe.t.a
    public void A(K requestMetadata, long frameNumber, long timestamp) throws Exception {
        a.C0139a c0139aG;
        p.i(requestMetadata, "requestMetadata");
        FrameState frameState = new FrameState(requestMetadata, frameNumber, timestamp, this.imageStreams, null);
        this.frameInfoDistributor.g(frameNumber, timestamp, frameNumber, frameState.getFrameInfoOutput());
        int size = frameState.f().size();
        for (int i10 = 0; i10 < size; i10++) {
            FrameState.d dVar = frameState.f().get(i10);
            Map<G, d<q>> map = this.imageDistributors.get(Q.a(dVar.getStreamId()));
            if (map == null) {
                throw new IllegalStateException("Required value was null.");
            }
            d<q> dVar2 = map.get(G.a(dVar.getOutputId()));
            if (dVar2 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            d<q> dVar3 = dVar2;
            dVar3.g(frameNumber, timestamp, timestamp, dVar);
            if (!requestMetadata.d().keySet().contains(Q.a(dVar.getStreamId()))) {
                dVar3.b(frameState.getFrameNumber());
            }
        }
        androidx.camera.camera2.pipe.internal.c cVar = new androidx.camera.camera2.pipe.internal.c(frameState, null, 2, 0 == true ? 1 : 0);
        this.frameStartedListener.a(cVar);
        if (requestMetadata.getRepeating() || (c0139aG = this.frameCaptureQueue.g(requestMetadata.getRequest())) == null) {
            cVar.close();
        } else {
            c0139aG.b(cVar);
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void G(t request) {
        p.i(request, "request");
        a.C0139a c0139aG = this.frameCaptureQueue.g(request);
        if (c0139aG != null) {
            c0139aG.e(H.INSTANCE.b());
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void Y(K requestMetadata, long frameNumber, J requestFailure) {
        p.i(requestMetadata, "requestMetadata");
        p.i(requestFailure, "requestFailure");
        d<w> dVar = this.frameInfoDistributor;
        f.Companion companion = f.INSTANCE;
        dVar.e(frameNumber, f.c(H.f(H.INSTANCE.c())));
        if (requestFailure.getWasImageCaptured()) {
            return;
        }
        Iterator<Q> it = requestMetadata.d().keySet().iterator();
        while (it.hasNext()) {
            Map<G, d<q>> map = this.imageDistributors.get(Q.a(it.next().getValue()));
            if (map != null) {
                Iterator<d<q>> it2 = map.values().iterator();
                while (it2.hasNext()) {
                    it2.next().b(frameNumber);
                }
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.frameCaptureQueue.close();
        this.frameInfoDistributor.close();
        Iterator<Map<G, d<q>>> it = this.imageDistributors.values().iterator();
        while (it.hasNext()) {
            Iterator<d<q>> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().close();
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void g0(K requestMetadata, long frameNumber, w result) {
        p.i(requestMetadata, "requestMetadata");
        p.i(result, "result");
        this.frameInfoDistributor.e(frameNumber, f.c(result));
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void i(K requestMetadata, long frameNumber, int streamId, int outputId) {
        p.i(requestMetadata, "requestMetadata");
        Map<G, d<q>> map = this.imageDistributors.get(Q.a(streamId));
        if (map == null) {
            return;
        }
        k.a aVarG0 = this.streamGraphImpl.g0(streamId);
        if (aVarG0 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        aVarG0.a();
        if (!map.containsKey(G.a(outputId))) {
            throw new IllegalStateException("Check failed.");
        }
        Iterator<d<q>> it = map.values().iterator();
        while (it.hasNext()) {
            it.next().b(frameNumber);
        }
    }
}
