package androidx.camera.core.featuregroup.impl;

import D.H;
import D.i0;
import M.q;
import Y.f;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.view.SurfaceHolder;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.UseCase;
import androidx.camera.core.featuregroup.impl.feature.FeatureTypeInternal;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.z;
import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0017\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Landroidx/camera/core/featuregroup/impl/UseCaseType;", "", "Ljava/lang/Class;", "surfaceClass", "<init>", "(Ljava/lang/String;ILjava/lang/Class;)V", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Class;", "getSurfaceClass", "()Ljava/lang/Class;", "Companion", Const.INTENT_KEY_APIKEY, "PREVIEW", "IMAGE_CAPTURE", "IMAGE_ANALYSIS", "VIDEO_CAPTURE", "STREAM_SHARING", "UNDEFINED", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UseCaseType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ UseCaseType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final Class<?> surfaceClass;
    public static final UseCaseType PREVIEW = new UseCaseType("PREVIEW", 0, SurfaceHolder.class);
    public static final UseCaseType IMAGE_CAPTURE = new UseCaseType("IMAGE_CAPTURE", 1, null);
    public static final UseCaseType IMAGE_ANALYSIS = new UseCaseType("IMAGE_ANALYSIS", 2, null);
    public static final UseCaseType VIDEO_CAPTURE = new UseCaseType("VIDEO_CAPTURE", 3, MediaCodec.class);
    public static final UseCaseType STREAM_SHARING = new UseCaseType("STREAM_SHARING", 4, SurfaceTexture.class);
    public static final UseCaseType UNDEFINED = new UseCaseType("UNDEFINED", 5, null);

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b*\u00020\u0004H\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u000f*\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u000f*\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0013\u0010\u0015\u001a\u00020\u000f*\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u0013\u0010\u0016\u001a\u00020\u000f*\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u0013\u0010\u0017\u001a\u00020\u000f*\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0013¨\u0006\u0018"}, d2 = {"Landroidx/camera/core/featuregroup/impl/UseCaseType$a;", "", "<init>", "()V", "Landroidx/camera/core/UseCase;", "Landroidx/camera/core/featuregroup/impl/UseCaseType;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/core/UseCase;)Landroidx/camera/core/featuregroup/impl/UseCaseType;", "Landroidx/camera/core/impl/z;", "c", "(Landroidx/camera/core/impl/z;)Landroidx/camera/core/featuregroup/impl/UseCaseType;", "Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/UseCase;)Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;", "useCase", "", Const.INTENT_KEY_UMID, "(Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;Landroidx/camera/core/UseCase;)Z", "e", "(Landroidx/camera/core/UseCase;)Z", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.core.featuregroup.impl.UseCaseType$a, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.core.featuregroup.impl.UseCaseType$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0146a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f11300a;

            /* renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f11301b;

            static {
                int[] iArr = new int[UseCaseConfigFactory.CaptureType.values().length];
                try {
                    iArr[UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[UseCaseConfigFactory.CaptureType.PREVIEW.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[UseCaseConfigFactory.CaptureType.STREAM_SHARING.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f11300a = iArr;
                int[] iArr2 = new int[FeatureTypeInternal.values().length];
                try {
                    iArr2[FeatureTypeInternal.DYNAMIC_RANGE.ordinal()] = 1;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr2[FeatureTypeInternal.FPS_RANGE.ordinal()] = 2;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr2[FeatureTypeInternal.VIDEO_STABILIZATION.ordinal()] = 3;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr2[FeatureTypeInternal.IMAGE_FORMAT.ordinal()] = 4;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr2[FeatureTypeInternal.RECORDING_QUALITY.ordinal()] = 5;
                } catch (NoSuchFieldError unused10) {
                }
                f11301b = iArr2;
            }
        }

        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final FeatureTypeInternal a(UseCase useCase) {
            FeatureTypeInternal next;
            p.i(useCase, "<this>");
            Iterator<FeatureTypeInternal> it = FeatureTypeInternal.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (UseCaseType.INSTANCE.d(next, useCase)) {
                    break;
                }
            }
            return next;
        }

        public final UseCaseType b(UseCase useCase) {
            p.i(useCase, "<this>");
            return useCase instanceof i0 ? UseCaseType.PREVIEW : useCase instanceof ImageCapture ? UseCaseType.IMAGE_CAPTURE : useCase instanceof H ? UseCaseType.IMAGE_ANALYSIS : q.h(useCase) ? UseCaseType.VIDEO_CAPTURE : useCase instanceof f ? UseCaseType.STREAM_SHARING : UseCaseType.UNDEFINED;
        }

        public final UseCaseType c(z<?> zVar) {
            p.i(zVar, "<this>");
            int i10 = C0146a.f11300a[zVar.V().ordinal()];
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? UseCaseType.UNDEFINED : UseCaseType.STREAM_SHARING : UseCaseType.VIDEO_CAPTURE : UseCaseType.PREVIEW : UseCaseType.IMAGE_CAPTURE : UseCaseType.IMAGE_ANALYSIS;
        }

        public final boolean d(FeatureTypeInternal featureTypeInternal, UseCase useCase) {
            int i10 = C0146a.f11301b[featureTypeInternal.ordinal()];
            if (i10 == 1) {
                return e(useCase);
            }
            if (i10 == 2) {
                return f(useCase);
            }
            if (i10 == 3) {
                return i(useCase);
            }
            if (i10 == 4) {
                return g(useCase);
            }
            if (i10 == 5) {
                return h(useCase);
            }
            throw new NoWhenBranchMatchedException();
        }

        public final boolean e(UseCase useCase) {
            return useCase.e().N();
        }

        public final boolean f(UseCase useCase) {
            return useCase.e().e0();
        }

        public final boolean g(UseCase useCase) {
            return useCase.e().b(androidx.camera.core.impl.q.f11473W);
        }

        public final boolean h(UseCase useCase) {
            return p.d(useCase.e().g(z.f11554O, Boolean.TRUE), Boolean.FALSE);
        }

        public final boolean i(UseCase useCase) {
            return useCase.e().b(z.f11552M) || useCase.e().b(z.f11553N);
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11302a;

        static {
            int[] iArr = new int[UseCaseType.values().length];
            try {
                iArr[UseCaseType.PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UseCaseType.IMAGE_CAPTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UseCaseType.IMAGE_ANALYSIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UseCaseType.VIDEO_CAPTURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[UseCaseType.STREAM_SHARING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[UseCaseType.UNDEFINED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f11302a = iArr;
        }
    }

    private static final /* synthetic */ UseCaseType[] $values() {
        return new UseCaseType[]{PREVIEW, IMAGE_CAPTURE, IMAGE_ANALYSIS, VIDEO_CAPTURE, STREAM_SHARING, UNDEFINED};
    }

    static {
        UseCaseType[] useCaseTypeArr$values = $values();
        $VALUES = useCaseTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(useCaseTypeArr$values);
        INSTANCE = new Companion(null);
    }

    private UseCaseType(String str, int i10, Class cls) {
        this.surfaceClass = cls;
    }

    public static InterfaceC4149a<UseCaseType> getEntries() {
        return $ENTRIES;
    }

    public static final UseCaseType getFeatureGroupUseCaseType(UseCase useCase) {
        return INSTANCE.b(useCase);
    }

    public static UseCaseType valueOf(String str) {
        return (UseCaseType) Enum.valueOf(UseCaseType.class, str);
    }

    public static UseCaseType[] values() {
        return (UseCaseType[]) $VALUES.clone();
    }

    public final Class<?> getSurfaceClass() {
        return this.surfaceClass;
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (b.f11302a[ordinal()]) {
            case 1:
                return "Preview";
            case 2:
                return "ImageCapture";
            case 3:
                return "ImageAnalysis";
            case 4:
                return "VideoCapture";
            case 5:
                return "StreamSharing";
            case 6:
                return "Undefined";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final UseCaseType getFeatureGroupUseCaseType(z<?> zVar) {
        return INSTANCE.c(zVar);
    }
}
