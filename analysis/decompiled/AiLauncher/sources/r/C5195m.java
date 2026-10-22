package r;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.core.impl.DeferrableSurface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import w.Q;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0003J!\u0010\u0012\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0018¨\u0006\u001a"}, d2 = {"Lr/m;", "Lr/l;", "<init>", "()V", "Lw/Q;", "streamId", "Landroidx/camera/core/impl/DeferrableSurface;", "deferrableSurface", "Landroidx/camera/camera2/pipe/CameraGraph;", "graph", "LY8/t;", "c", "(ILandroidx/camera/core/impl/DeferrableSurface;Landroidx/camera/camera2/pipe/CameraGraph;)V", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/impl/DeferrableSurface;)V", Const.INTENT_KEY_PKGNAME, "", "Lr/m$a;", Const.INTENT_KEY_UMID, "(Ljava/util/List;Landroidx/camera/core/impl/DeferrableSurface;)V", "", "Ljava/lang/Object;", "lock", "", "Ljava/util/List;", "configuredOutputs", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: r.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5195m implements InterfaceC5194l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Object lock = new Object();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<ConfiguredOutput> configuredOutputs = new ArrayList();

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lr/m$a;", "", "Lw/Q;", "streamId", "Landroidx/camera/core/impl/DeferrableSurface;", "deferrableSurface", "Landroidx/camera/camera2/pipe/CameraGraph;", "graph", "<init>", "(ILandroidx/camera/core/impl/DeferrableSurface;Landroidx/camera/camera2/pipe/CameraGraph;Lkotlin/jvm/internal/i;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/core/impl/DeferrableSurface;)Z", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getStreamId-ptHMqGs", "Landroidx/camera/core/impl/DeferrableSurface;", "getDeferrableSurface", "()Landroidx/camera/core/impl/DeferrableSurface;", "c", "Landroidx/camera/camera2/pipe/CameraGraph;", "getGraph", "()Landroidx/camera/camera2/pipe/CameraGraph;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: r.m$a, reason: from toString */
    public static final /* data */ class ConfiguredOutput {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int streamId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final DeferrableSurface deferrableSurface;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final CameraGraph graph;

        public /* synthetic */ ConfiguredOutput(int i10, DeferrableSurface deferrableSurface, CameraGraph cameraGraph, kotlin.jvm.internal.i iVar) {
            this(i10, deferrableSurface, cameraGraph);
        }

        public final void a() {
            this.graph.a0(this.streamId, null);
            this.deferrableSurface.d();
        }

        public final boolean b(DeferrableSurface deferrableSurface) {
            kotlin.jvm.internal.p.i(deferrableSurface, "deferrableSurface");
            return kotlin.jvm.internal.p.d(this.deferrableSurface, deferrableSurface);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConfiguredOutput)) {
                return false;
            }
            ConfiguredOutput configuredOutput = (ConfiguredOutput) other;
            return Q.d(this.streamId, configuredOutput.streamId) && kotlin.jvm.internal.p.d(this.deferrableSurface, configuredOutput.deferrableSurface) && kotlin.jvm.internal.p.d(this.graph, configuredOutput.graph);
        }

        public int hashCode() {
            return (((Q.e(this.streamId) * 31) + this.deferrableSurface.hashCode()) * 31) + this.graph.hashCode();
        }

        public String toString() {
            return "ConfiguredOutput(streamId=" + ((Object) Q.f(this.streamId)) + ", deferrableSurface=" + this.deferrableSurface + ", graph=" + this.graph + ')';
        }

        public ConfiguredOutput(int i10, DeferrableSurface deferrableSurface, CameraGraph graph) {
            kotlin.jvm.internal.p.i(deferrableSurface, "deferrableSurface");
            kotlin.jvm.internal.p.i(graph, "graph");
            this.streamId = i10;
            this.deferrableSurface = deferrableSurface;
            this.graph = graph;
        }
    }

    @Override // r.InterfaceC5194l
    public void a(DeferrableSurface deferrableSurface) {
        kotlin.jvm.internal.p.i(deferrableSurface, "deferrableSurface");
        synchronized (this.lock) {
            d(this.configuredOutputs, deferrableSurface);
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    @Override // r.InterfaceC5194l
    public void b() {
        synchronized (this.lock) {
            try {
                Iterator<T> it = this.configuredOutputs.iterator();
                while (it.hasNext()) {
                    ((ConfiguredOutput) it.next()).a();
                }
                this.configuredOutputs.clear();
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // r.InterfaceC5194l
    public void c(int streamId, DeferrableSurface deferrableSurface, CameraGraph graph) {
        kotlin.jvm.internal.p.i(deferrableSurface, "deferrableSurface");
        kotlin.jvm.internal.p.i(graph, "graph");
        synchronized (this.lock) {
            this.configuredOutputs.add(new ConfiguredOutput(streamId, deferrableSurface, graph, null));
        }
    }

    public final void d(List<ConfiguredOutput> list, DeferrableSurface deferrableSurface) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((ConfiguredOutput) it.next()).b(deferrableSurface)) {
                deferrableSurface.d();
            }
        }
    }
}
