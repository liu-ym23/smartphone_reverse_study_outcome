package androidx.camera.camera2.adapter;

import D.C0761b0;
import Ua.C1060i;
import Ua.Y;
import Y8.h;
import Z8.C1174w;
import android.media.MediaCodec;
import android.util.Log;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.pipe.s;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.z;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.d;
import p9.InterfaceC5063a;
import t.C5473b;
import u.C5564l;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 22\u00020\u0001:\u0001 B\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0002H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001e\u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R'\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00170\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R'\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00170\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010'R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010%\u001a\u0004\b.\u0010/R\u001b\u00103\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010%\u001a\u0004\b2\u0010\u000bR!\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010%\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"Landroidx/camera/camera2/adapter/SessionConfigAdapter;", "", "", "Landroidx/camera/core/UseCase;", "useCases", "", "isPrimary", "<init>", "(Ljava/util/Collection;Z)V", "Landroidx/camera/core/impl/SessionConfig;", "n", "()Landroidx/camera/core/impl/SessionConfig;", "p", "()Z", "Landroidx/camera/core/impl/DeferrableSurface;", "deferrableSurface", "LY8/t;", "q", "(Landroidx/camera/core/impl/DeferrableSurface;)V", "sessionConfigs", "Landroidx/camera/core/impl/z;", "useCaseConfigs", "", "", "k", "(Ljava/util/Collection;Ljava/util/Collection;)Ljava/util/Map;", "m", "(Ljava/util/Collection;)Ljava/util/Map;", "Ljava/lang/Class;", "kClass", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Class;)J", Const.INTENT_KEY_APIKEY, "Ljava/util/Collection;", Const.INTENT_KEY_PKGNAME, "Z", "c", "LY8/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/util/Map;", "surfaceToStreamUseCaseMap", Const.INTENT_KEY_UMID, "l", "surfaceToStreamUseHintMap", "Landroidx/camera/core/impl/SessionConfig$g;", "e", "o", "()Landroidx/camera/core/impl/SessionConfig$g;", "validatingBuilder", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "sessionConfig", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/List;", "deferrableSurfaces", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SessionConfigAdapter {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Collection<UseCase> useCases;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isPrimary;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final h surfaceToStreamUseCaseMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final h surfaceToStreamUseHintMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final h validatingBuilder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final h sessionConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final h deferrableSurfaces;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/adapter/SessionConfigAdapter$a;", "", "<init>", "()V", "Landroidx/camera/core/UseCase;", "", "isPrimary", "Landroidx/camera/core/impl/SessionConfig;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/UseCase;Z)Landroidx/camera/core/impl/SessionConfig;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.adapter.SessionConfigAdapter$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final SessionConfig a(UseCase useCase, boolean z10) {
            SessionConfig sessionConfigX;
            String str;
            p.i(useCase, "<this>");
            if (z10) {
                sessionConfigX = useCase.z();
                str = "getSessionConfig(...)";
            } else {
                sessionConfigX = useCase.x();
                str = "getSecondarySessionConfig(...)";
            }
            p.h(sessionConfigX, str);
            return sessionConfigX;
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SessionConfigAdapter(Collection<? extends UseCase> useCases, boolean z10) {
        p.i(useCases, "useCases");
        this.useCases = useCases;
        this.isPrimary = z10;
        this.surfaceToStreamUseCaseMap = C4848b.b(new InterfaceC5063a() { // from class: o.I
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SessionConfigAdapter.s(this.f37313a);
            }
        });
        this.surfaceToStreamUseHintMap = C4848b.b(new InterfaceC5063a() { // from class: o.J
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SessionConfigAdapter.t(this.f37314a);
            }
        });
        this.validatingBuilder = C4848b.b(new InterfaceC5063a() { // from class: o.K
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SessionConfigAdapter.u(this.f37315a);
            }
        });
        this.sessionConfig = C4848b.b(new InterfaceC5063a() { // from class: o.L
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SessionConfigAdapter.r(this.f37316a);
            }
        });
        this.deferrableSurfaces = C4848b.b(new InterfaceC5063a() { // from class: o.M
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SessionConfigAdapter.f(this.f37317a);
            }
        });
    }

    public static final List f(SessionConfigAdapter sessionConfigAdapter) {
        if (!sessionConfigAdapter.o().f()) {
            throw new IllegalStateException("Check failed.");
        }
        SessionConfig.f fVarJ = sessionConfigAdapter.h().j();
        if (fVarJ != null) {
            ArrayList arrayList = new ArrayList();
            List<DeferrableSurface> listP = sessionConfigAdapter.h().p();
            p.h(listP, "getSurfaces(...)");
            arrayList.addAll(listP);
            DeferrableSurface deferrableSurfaceF = fVarJ.f();
            p.h(deferrableSurfaceF, "getSurface(...)");
            arrayList.add(deferrableSurfaceF);
            List listUnmodifiableList = Collections.unmodifiableList(arrayList);
            if (listUnmodifiableList != null) {
                return listUnmodifiableList;
            }
        }
        return sessionConfigAdapter.h().p();
    }

    public static final SessionConfig r(SessionConfigAdapter sessionConfigAdapter) {
        if (!sessionConfigAdapter.o().f()) {
            throw new IllegalStateException("Check failed.");
        }
        SessionConfig sessionConfigC = sessionConfigAdapter.o().c();
        p.h(sessionConfigC, "build(...)");
        return sessionConfigC;
    }

    public static final Map s(SessionConfigAdapter sessionConfigAdapter) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (UseCase useCase : sessionConfigAdapter.useCases) {
            arrayList.add(INSTANCE.a(useCase, sessionConfigAdapter.isPrimary));
            z<?> zVarL = useCase.l();
            p.h(zVarL, "getCurrentConfig(...)");
            arrayList2.add(zVarL);
        }
        return sessionConfigAdapter.k(arrayList, arrayList2);
    }

    public static final Map t(SessionConfigAdapter sessionConfigAdapter) {
        Collection<UseCase> collection = sessionConfigAdapter.useCases;
        ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.a((UseCase) it.next(), sessionConfigAdapter.isPrimary));
        }
        return sessionConfigAdapter.m(arrayList);
    }

    public static final SessionConfig.g u(SessionConfigAdapter sessionConfigAdapter) {
        SessionConfig.g gVar = new SessionConfig.g();
        Iterator<UseCase> it = sessionConfigAdapter.useCases.iterator();
        while (it.hasNext()) {
            gVar.b(INSTANCE.a(it.next(), sessionConfigAdapter.isPrimary));
        }
        return gVar;
    }

    public final List<DeferrableSurface> g() {
        Object value = this.deferrableSurfaces.getValue();
        p.h(value, "getValue(...)");
        return (List) value;
    }

    public final SessionConfig h() {
        return (SessionConfig) this.sessionConfig.getValue();
    }

    public final long i(Class<?> kClass) {
        return p.d(kClass, MediaCodec.class) ? s.g.INSTANCE.b() : s.g.INSTANCE.a();
    }

    public final Map<DeferrableSurface, Long> j() {
        return (Map) this.surfaceToStreamUseCaseMap.getValue();
    }

    public final Map<DeferrableSurface, Long> k(Collection<SessionConfig> sessionConfigs, Collection<? extends z<?>> useCaseConfigs) {
        p.i(sessionConfigs, "sessionConfigs");
        p.i(useCaseConfigs, "useCaseConfigs");
        Collection<SessionConfig> collection = sessionConfigs;
        if (!collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                if (((SessionConfig) it.next()).q() == 5) {
                    C5473b c5473b = C5473b.f41865a;
                    if (C0761b0.g("CXCP")) {
                        Log.e(C5473b.TRUNCATED_TAG, "ZSL in populateSurfaceToStreamUseCaseMapping()");
                    }
                    return a.i();
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C5564l.f42381a.n(sessionConfigs, useCaseConfigs, linkedHashMap);
        return linkedHashMap;
    }

    public final Map<DeferrableSurface, Long> l() {
        return (Map) this.surfaceToStreamUseHintMap.getValue();
    }

    public final Map<DeferrableSurface, Long> m(Collection<SessionConfig> sessionConfigs) {
        p.i(sessionConfigs, "sessionConfigs");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (SessionConfig sessionConfig : sessionConfigs) {
            for (DeferrableSurface deferrableSurface : sessionConfig.p()) {
                Config configG = sessionConfig.g();
                Config.a<Long> aVar = androidx.camera.camera2.impl.a.f10035Y;
                if (!configG.b(aVar) || sessionConfig.g().a(aVar) == null) {
                    linkedHashMap.put(deferrableSurface, Long.valueOf(i(deferrableSurface.g())));
                } else {
                    Object objA = sessionConfig.g().a(aVar);
                    p.f(objA);
                    linkedHashMap.put(deferrableSurface, objA);
                }
            }
        }
        return linkedHashMap;
    }

    public final SessionConfig n() {
        if (p()) {
            return h();
        }
        return null;
    }

    public final SessionConfig.g o() {
        return (SessionConfig.g) this.validatingBuilder.getValue();
    }

    public final boolean p() {
        return o().f();
    }

    public final void q(DeferrableSurface deferrableSurface) {
        Object next;
        p.i(deferrableSurface, "deferrableSurface");
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Unavailable " + deferrableSurface + ", notify SessionConfig invalid");
        }
        Iterator<T> it = this.useCases.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (INSTANCE.a((UseCase) next, this.isPrimary).p().contains(deferrableSurface)) {
                    break;
                }
            }
        }
        UseCase useCase = (UseCase) next;
        C1060i.d(d.a(Y.c().getImmediate()), null, null, new SessionConfigAdapter$reportSurfaceInvalid$2(useCase != null ? useCase.z() : null, null), 3, null);
    }

    public /* synthetic */ SessionConfigAdapter(Collection collection, boolean z10, int i10, i iVar) {
        this(collection, (i10 & 2) != 0 ? true : z10);
    }
}
