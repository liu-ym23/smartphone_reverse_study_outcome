package I;

import D.C0761b0;
import D.o0;
import G.ResolvedFeatureGroup;
import I.b;
import K.InterfaceC0898v;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Z;
import androidx.camera.core.UseCase;
import androidx.camera.core.featuregroup.impl.UseCaseType;
import androidx.camera.core.featuregroup.impl.feature.FeatureTypeInternal;
import androidx.camera.core.impl.stabilization.VideoStabilization;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0010\u001a\u0004\u0018\u00010\u000f*\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J?\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u000b0\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001c¨\u0006\u001d"}, d2 = {"LI/a;", "LI/c;", "LK/v;", "cameraInfoInternal", "<init>", "(LK/v;)V", "LD/o0;", "sessionConfig", "LI/b;", Const.INTENT_KEY_APIKEY, "(LD/o0;)LI/b;", "LF/b;", "", "Landroidx/camera/core/UseCase;", "useCases", "LI/b$d;", Const.INTENT_KEY_UMID, "(LF/b;Ljava/util/List;)LI/b$d;", "orderedPreferredFeatures", "", "index", "currentOptionalFeatures", Const.INTENT_KEY_PKGNAME, "(LD/o0;Ljava/util/List;ILjava/util/List;)LI/b;", "", "", "e", "(Ljava/util/Set;)Z", "LK/v;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC0898v cameraInfoInternal;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3246a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f3247b;

        static {
            int[] iArr = new int[VideoStabilization.values().length];
            try {
                iArr[VideoStabilization.PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoStabilization.ON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f3246a = iArr;
            int[] iArr2 = new int[FeatureTypeInternal.values().length];
            try {
                iArr2[FeatureTypeInternal.IMAGE_FORMAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[FeatureTypeInternal.DYNAMIC_RANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FeatureTypeInternal.FPS_RANGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FeatureTypeInternal.VIDEO_STABILIZATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FeatureTypeInternal.RECORDING_QUALITY.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            f3247b = iArr2;
        }
    }

    public a(InterfaceC0898v cameraInfoInternal) {
        p.i(cameraInfoInternal, "cameraInfoInternal");
        this.cameraInfoInternal = cameraInfoInternal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ I.b c(a aVar, o0 o0Var, List list, int i10, List list2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        if ((i11 & 8) != 0) {
            list2 = C1173v.m();
        }
        return aVar.b(o0Var, list, i10, list2);
    }

    @Override // I.c
    public I.b a(o0 sessionConfig) {
        p.i(sessionConfig, "sessionConfig");
        List<UseCase> listM = sessionConfig.m();
        Set<F.b> setJ = sessionConfig.j();
        List<F.b> listH = sessionConfig.h();
        if (setJ.isEmpty() && listH.isEmpty()) {
            throw new IllegalArgumentException("Must have at least one required or preferred feature");
        }
        for (UseCase useCase : listM) {
            if (UseCaseType.INSTANCE.b(useCase) == UseCaseType.UNDEFINED) {
                return new b.UnsupportedUseCase(useCase);
            }
        }
        Iterator<T> it = setJ.iterator();
        while (it.hasNext()) {
            b.UseCaseMissing useCaseMissingD = d((F.b) it.next(), listM);
            if (useCaseMissingD != null) {
                return useCaseMissingD;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listH) {
            b.UseCaseMissing useCaseMissingD2 = d((F.b) obj, listM);
            if (useCaseMissingD2 != null) {
                C0761b0.a("DefaultFeatureGroupResolver", "resolveFeatureGroup: filtered out preferred feature due to " + useCaseMissingD2);
            } else {
                useCaseMissingD2 = null;
            }
            if (useCaseMissingD2 == null) {
                arrayList.add(obj);
            }
        }
        C0761b0.a("DefaultFeatureGroupResolver", "resolveFeatureGroup: filteredPreferredFeatures = " + arrayList);
        return c(this, sessionConfig, arrayList, 0, null, 12, null);
    }

    public final I.b b(o0 sessionConfig, List<? extends F.b> orderedPreferredFeatures, int index, List<? extends F.b> currentOptionalFeatures) {
        if (index < orderedPreferredFeatures.size()) {
            int i10 = index + 1;
            I.b bVarB = b(sessionConfig, orderedPreferredFeatures, i10, F.T0(currentOptionalFeatures, orderedPreferredFeatures.get(index)));
            return bVarB instanceof b.Supported ? bVarB : b(sessionConfig, orderedPreferredFeatures, i10, currentOptionalFeatures);
        }
        Set<? extends F.b> setO = Z.o(sessionConfig.j(), currentOptionalFeatures);
        C0761b0.a("DefaultFeatureGroupResolver", "getFeatureListResolvedByPriority: features = " + setO + ", useCases = " + sessionConfig.m());
        return (e(setO) && this.cameraInfoInternal.r(new ResolvedFeatureGroup(setO), sessionConfig)) ? new b.Supported(new ResolvedFeatureGroup(setO)) : b.C0053b.f3249a;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final I.b.UseCaseMissing d(F.b r8, java.util.List<? extends androidx.camera.core.UseCase> r9) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I.a.d(F.b, java.util.List):I.b$d");
    }

    public final boolean e(Set<? extends F.b> set) {
        Set<? extends F.b> set2 = set;
        ArrayList arrayList = new ArrayList(C1174w.x(set2, 10));
        Iterator<T> it = set2.iterator();
        while (it.hasNext()) {
            arrayList.add(((F.b) it.next()).getFeatureTypeInternal());
        }
        for (FeatureTypeInternal featureTypeInternal : F.g0(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : set2) {
                if (((F.b) obj).getFeatureTypeInternal() == featureTypeInternal) {
                    arrayList2.add(obj);
                }
            }
            if (arrayList2.size() > 1) {
                return false;
            }
        }
        return true;
    }
}
