package D;

import Z8.C1173v;
import Z8.C1174w;
import android.util.Range;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.UseCase;
import androidx.camera.core.featuregroup.impl.UseCaseType;
import androidx.camera.core.featuregroup.impl.feature.FeatureTypeInternal;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001Bc\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u0013\u0010\u0017\u001a\u00020\u0012*\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001a\u001a\u00020\u0019*\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u001f\u001a\u0004\b*\u0010!R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010!R\u001a\u00101\u001a\u00020\n8\u0017X\u0096D¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00106\u001a\u0002028\u0017X\u0096D¢\u0006\f\n\u0004\b$\u00103\u001a\u0004\b4\u00105R\u001c\u0010:\u001a\u0004\u0018\u0001078\u0017X\u0096\u0004¢\u0006\f\n\u0004\b*\u00108\u001a\u0004\b&\u00109R\u001a\u0010<\u001a\u0002028\u0017X\u0096D¢\u0006\f\n\u0004\b4\u00103\u001a\u0004\b;\u00105R<\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0=2\u0012\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0=8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010?\u001a\u0004\b+\u0010@R$\u0010E\u001a\u00020B2\u0006\u0010>\u001a\u00020B8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b/\u0010C\u001a\u0004\b-\u0010DR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010F\u001a\u0004\bG\u0010HR\u001a\u0010I\u001a\u0002028\u0017X\u0096D¢\u0006\f\n\u0004\bI\u00103\u001a\u0004\bJ\u00105¨\u0006K"}, d2 = {"LD/o0;", "", "", "Landroidx/camera/core/UseCase;", "useCases", "LD/E0;", "viewPort", "LD/i;", "effects", "Landroid/util/Range;", "", "frameRateRange", "", "LF/b;", "requiredFeatureGroup", "preferredFeatureGroup", "<init>", "(Ljava/util/List;LD/E0;Ljava/util/List;Landroid/util/Range;Ljava/util/Set;Ljava/util/List;)V", "LY8/t;", "s", "()V", "r", "t", "q", "(Landroidx/camera/core/UseCase;)V", "", "l", "(Landroidx/camera/core/UseCase;)Ljava/lang/String;", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "Landroid/util/Range;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroid/util/Range;", "c", "Ljava/util/Set;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/util/Set;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "e", "m", "f", "I", "k", "()I", "sessionType", "", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", "requireNonEmptyUseCases", "LD/m;", "LD/m;", "()LD/m;", "cameraFilter", "o", "isAutoRotationEnabled", "LB0/a;", UxipConstants.f30680s, "LB0/a;", "()LB0/a;", "featureSelectionListener", "Ljava/util/concurrent/Executor;", "Ljava/util/concurrent/Executor;", "()Ljava/util/concurrent/Executor;", "featureSelectionListenerExecutor", "LD/E0;", "n", "()LD/E0;", "isLegacy", "p", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public class o0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<AbstractC0772i> effects;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final Range<Integer> frameRateRange;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final Set<F.b> requiredFeatureGroup;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<F.b> preferredFeatureGroup;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final List<UseCase> useCases;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final int sessionType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final boolean requireNonEmptyUseCases;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC0776m cameraFilter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final boolean isAutoRotationEnabled;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public B0.a<Set<F.b>> featureSelectionListener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public Executor featureSelectionListenerExecutor;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2156a;

        static {
            int[] iArr = new int[FeatureTypeInternal.values().length];
            try {
                iArr[FeatureTypeInternal.DYNAMIC_RANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FeatureTypeInternal.FPS_RANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FeatureTypeInternal.VIDEO_STABILIZATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FeatureTypeInternal.IMAGE_FORMAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FeatureTypeInternal.RECORDING_QUALITY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f2156a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o0(List<? extends UseCase> useCases, E0 e02, List<? extends AbstractC0772i> effects, Range<Integer> frameRateRange, Set<? extends F.b> requiredFeatureGroup, List<? extends F.b> preferredFeatureGroup) {
        kotlin.jvm.internal.p.i(useCases, "useCases");
        kotlin.jvm.internal.p.i(effects, "effects");
        kotlin.jvm.internal.p.i(frameRateRange, "frameRateRange");
        kotlin.jvm.internal.p.i(requiredFeatureGroup, "requiredFeatureGroup");
        kotlin.jvm.internal.p.i(preferredFeatureGroup, "preferredFeatureGroup");
        this.effects = effects;
        this.frameRateRange = frameRateRange;
        this.requiredFeatureGroup = requiredFeatureGroup;
        this.preferredFeatureGroup = preferredFeatureGroup;
        this.useCases = Z8.F.g0(useCases);
        this.requireNonEmptyUseCases = true;
        this.featureSelectionListener = new B0.a() { // from class: D.n0
            @Override // B0.a
            public final void accept(Object obj) {
                o0.b((Set) obj);
            }
        };
        ScheduledExecutorService scheduledExecutorServiceD = N.a.d();
        kotlin.jvm.internal.p.h(scheduledExecutorServiceD, "mainThreadExecutor(...)");
        this.featureSelectionListenerExecutor = scheduledExecutorServiceD;
        if (i() && useCases.isEmpty()) {
            throw new IllegalArgumentException("SessionConfig must contain at least one UseCase.");
        }
        s();
        r();
    }

    public static final void b(Set set) {
    }

    /* renamed from: c, reason: from getter */
    public InterfaceC0776m getCameraFilter() {
        return this.cameraFilter;
    }

    public final List<AbstractC0772i> d() {
        return this.effects;
    }

    public final B0.a<Set<F.b>> e() {
        return this.featureSelectionListener;
    }

    /* renamed from: f, reason: from getter */
    public final Executor getFeatureSelectionListenerExecutor() {
        return this.featureSelectionListenerExecutor;
    }

    public final Range<Integer> g() {
        return this.frameRateRange;
    }

    public final List<F.b> h() {
        return this.preferredFeatureGroup;
    }

    public boolean i() {
        throw null;
    }

    public final Set<F.b> j() {
        return this.requiredFeatureGroup;
    }

    /* renamed from: k, reason: from getter */
    public int getSessionType() {
        return this.sessionType;
    }

    public final String l(UseCase useCase) {
        return useCase instanceof i0 ? "Preview" : useCase instanceof ImageCapture ? "ImageCapture" : useCase instanceof H ? "ImageAnalysis" : M.q.h(useCase) ? "VideoCapture" : "UseCase";
    }

    public final List<UseCase> m() {
        return this.useCases;
    }

    public final E0 n() {
        return null;
    }

    /* renamed from: o, reason: from getter */
    public boolean getIsAutoRotationEnabled() {
        return this.isAutoRotationEnabled;
    }

    public boolean p() {
        throw null;
    }

    public final void q(UseCase useCase) {
        String str;
        String str2;
        String str3;
        String strL = l(useCase);
        FeatureTypeInternal featureTypeInternalA = UseCaseType.INSTANCE.a(useCase);
        if (featureTypeInternalA == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("A ");
        kotlin.jvm.internal.p.f(featureTypeInternalA);
        sb2.append(featureTypeInternalA.name());
        sb2.append(" value is set to ");
        sb2.append(strL);
        sb2.append(" despite using feature groups. Do not use APIs like ");
        int[] iArr = a.f2156a;
        int i10 = iArr[featureTypeInternalA.ordinal()];
        if (i10 == 1) {
            str = strL + ".Builder.setDynamicRange";
        } else if (i10 == 2) {
            str = strL + ".Builder.setTargetFrameRateRange";
        } else if (i10 != 3) {
            if (i10 == 4) {
                str = strL + ".Builder.setOutputFormat";
            } else {
                if (i10 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "Recorder.Builder.setQualitySelector";
            }
        } else if (M.q.h(useCase)) {
            str = strL + ".Builder.setVideoStabilizationEnabled";
        } else {
            str = strL + ".Builder.setPreviewStabilizationEnabled";
        }
        sb2.append(str);
        sb2.append(" while using feature groups. If, for example, ");
        int i11 = iArr[featureTypeInternalA.ordinal()];
        if (i11 == 1) {
            str2 = "HDR";
        } else if (i11 == 2) {
            str2 = "60 FPS";
        } else if (i11 == 3) {
            str2 = "stabilization";
        } else if (i11 == 4) {
            str2 = "JPEG_R output format";
        } else {
            if (i11 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            str2 = "UHD recording quality";
        }
        sb2.append(str2);
        sb2.append(" is required, instead set ");
        int i12 = iArr[featureTypeInternalA.ordinal()];
        if (i12 == 1) {
            str3 = "GroupableFeature.HDR_HLG10";
        } else if (i12 == 2) {
            str3 = "GroupableFeature.FPS_60";
        } else if (i12 == 3) {
            str3 = "GroupableFeature.PREVIEW_STABILIZATION";
        } else if (i12 == 4) {
            str3 = "GroupableFeature.IMAGE_ULTRA_HDR";
        } else {
            if (i12 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            str3 = "GroupableFeatures.UHD_RECORDING";
        }
        sb2.append(str3);
        sb2.append(" as either a required or preferred feature.");
        throw new IllegalArgumentException(sb2.toString().toString());
    }

    public final void r() {
        if (this.requiredFeatureGroup.isEmpty() && this.preferredFeatureGroup.isEmpty()) {
            return;
        }
        t();
        if (Z8.F.g0(this.preferredFeatureGroup).size() != this.preferredFeatureGroup.size()) {
            throw new IllegalArgumentException(("Duplicate values in preferredFeatures(" + this.preferredFeatureGroup + ')').toString());
        }
        Set setW0 = Z8.F.w0(this.requiredFeatureGroup, this.preferredFeatureGroup);
        if (!setW0.isEmpty()) {
            throw new IllegalArgumentException(("requiredFeatures and preferredFeatures have duplicate values: " + setW0).toString());
        }
        for (UseCase useCase : this.useCases) {
            if (UseCaseType.INSTANCE.b(useCase) == UseCaseType.UNDEFINED) {
                throw new IllegalArgumentException((useCase + " is not supported with feature group").toString());
            }
            q(useCase);
        }
    }

    public final void s() {
        if (kotlin.jvm.internal.p.d(this.frameRateRange, androidx.camera.core.impl.y.f11539a)) {
            return;
        }
        Iterator<UseCase> it = this.useCases.iterator();
        while (it.hasNext()) {
            if (it.next().e().e0()) {
                throw new IllegalArgumentException("Can't set target frame rate on a UseCase (by Preview.Builder.setTargetFrameRate() or VideoCapture.Builder.setTargetFrameRate()) if the frame rate range has already been set in the SessionConfig.");
            }
        }
    }

    public final void t() {
        Set<F.b> set = this.requiredFeatureGroup;
        ArrayList arrayList = new ArrayList(C1174w.x(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((F.b) it.next()).getFeatureTypeInternal());
        }
        for (FeatureTypeInternal featureTypeInternal : Z8.F.g0(arrayList)) {
            Set<F.b> set2 = this.requiredFeatureGroup;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : set2) {
                if (((F.b) obj).getFeatureTypeInternal() == featureTypeInternal) {
                    arrayList2.add(obj);
                }
            }
            if (arrayList2.size() > 1) {
                throw new IllegalArgumentException(("requiredFeatures has conflicting feature values: " + arrayList2).toString());
            }
        }
    }

    public String toString() {
        return "SessionConfig@" + Integer.toHexString(System.identityHashCode(this)) + " {useCases=" + this.useCases + ", frameRateRange=" + this.frameRateRange + ", requiredFeatureGroup=" + this.requiredFeatureGroup + ", preferredFeatureGroup=" + this.preferredFeatureGroup + ", effects=" + this.effects + ", viewPort=" + ((Object) null) + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ o0(List list, E0 e02, List list2, Range FRAME_RATE_RANGE_UNSPECIFIED, Set set, List list3, int i10, kotlin.jvm.internal.i iVar) {
        E0 e03 = (i10 & 2) != 0 ? null : e02;
        List listM = (i10 & 4) != 0 ? C1173v.m() : list2;
        if ((i10 & 8) != 0) {
            FRAME_RATE_RANGE_UNSPECIFIED = androidx.camera.core.impl.y.f11539a;
            kotlin.jvm.internal.p.h(FRAME_RATE_RANGE_UNSPECIFIED, "FRAME_RATE_RANGE_UNSPECIFIED");
        }
        this(list, e03, listM, FRAME_RATE_RANGE_UNSPECIFIED, (i10 & 16) != 0 ? Z8.Y.e() : set, (i10 & 32) != 0 ? C1173v.m() : list3);
    }
}
