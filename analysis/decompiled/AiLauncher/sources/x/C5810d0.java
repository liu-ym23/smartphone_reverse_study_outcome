package x;

import android.os.Build;
import androidx.camera.camera2.pipe.CameraGraph;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00122\u00020\u0001:\u0001\u0018B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001a¨\u0006\u001b"}, d2 = {"Lx/d0;", "", "Lx/c0;", "metadataProvider", "Lw/S;", "strictMode", "<init>", "(Lx/c0;Lw/S;)V", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "", "f", "(Landroidx/camera/camera2/pipe/CameraGraph$b;)Z", "Lw/n;", "cameraId", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Z", "e", "c", "Landroidx/camera/camera2/pipe/CameraGraph$d;", "graphConfigFlags", "", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/pipe/CameraGraph$d;)I", Const.INTENT_KEY_APIKEY, "Lx/c0;", "Lw/S;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.d0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5810d0 {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final Map<String, Set<String>> f43381d = Z8.Q.f(Y8.j.a("Google", Z8.Y.j("oriole", "raven", "bluejay", "panther", "cheetah", "lynx")));

    /* renamed from: e, reason: collision with root package name */
    public static final Map<String, Set<String>> f43382e = kotlin.collections.a.m(Y8.j.a("google", Z8.Y.j("pixel 4", "pixel 4 xl")), Y8.j.a("samsung", Z8.X.d("sm-g770f")));

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5808c0 metadataProvider;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final w.S strictMode;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R&\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR&\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lx/d0$a;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Z", "", "", "", "SHOULD_WAIT_FOR_REPEATING_DEVICE_MAP", "Ljava/util/Map;", "SM8150_DEVICES", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: x.d0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a() {
            String str = Build.HARDWARE;
            if (kotlin.jvm.internal.p.d(str, "samsungexynos7870")) {
                return true;
            }
            La.D.L(str, "qcom", true);
            Map map = C5810d0.f43382e;
            String BRAND = Build.BRAND;
            kotlin.jvm.internal.p.h(BRAND, "BRAND");
            Locale locale = Locale.ROOT;
            String lowerCase = BRAND.toLowerCase(locale);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            Set set = (Set) map.get(lowerCase);
            if (set == null) {
                return false;
            }
            String MODEL = Build.MODEL;
            kotlin.jvm.internal.p.h(MODEL, "MODEL");
            String lowerCase2 = MODEL.toLowerCase(locale);
            kotlin.jvm.internal.p.h(lowerCase2, "toLowerCase(...)");
            return set.contains(lowerCase2);
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: x.d0$b */
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43385a;

        static {
            int[] iArr = new int[CameraGraph.RepeatingRequestRequirementsBeforeCapture.CompletionBehavior.values().length];
            try {
                iArr[CameraGraph.RepeatingRequestRequirementsBeforeCapture.CompletionBehavior.AT_LEAST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CameraGraph.RepeatingRequestRequirementsBeforeCapture.CompletionBehavior.EXACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f43385a = iArr;
        }
    }

    public C5810d0(InterfaceC5808c0 metadataProvider, w.S strictMode) {
        kotlin.jvm.internal.p.i(metadataProvider, "metadataProvider");
        kotlin.jvm.internal.p.i(strictMode, "strictMode");
        this.metadataProvider = metadataProvider;
        this.strictMode = strictMode;
    }

    public final int b(CameraGraph.Flags graphConfigFlags) {
        kotlin.jvm.internal.p.i(graphConfigFlags, "graphConfigFlags");
        if (this.strictMode.getEnabled()) {
            return 0;
        }
        CameraGraph.RepeatingRequestRequirementsBeforeCapture awaitRepeatingRequestBeforeCapture = graphConfigFlags.getAwaitRepeatingRequestBeforeCapture();
        Set<String> set = f43381d.get(Build.MANUFACTURER);
        if (set != null) {
            set.contains(Build.DEVICE);
        }
        int i10 = b.f43385a[awaitRepeatingRequestBeforeCapture.getCompletionBehavior().ordinal()];
        if (i10 == 1) {
            return Math.max(0, awaitRepeatingRequestBeforeCapture.getRepeatingFramesToComplete());
        }
        if (i10 == 2) {
            return awaitRepeatingRequestBeforeCapture.getRepeatingFramesToComplete();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean c(String cameraId) {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        if (this.strictMode.getEnabled()) {
            return false;
        }
        return La.D.L("motorola", Build.BRAND, true) && La.D.L("moto e20", Build.MODEL, true) && kotlin.jvm.internal.p.d(cameraId, "1");
    }

    public final boolean d(String cameraId) {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        this.strictMode.getEnabled();
        return false;
    }

    public final boolean e(String cameraId) {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        if (this.strictMode.getEnabled()) {
            return false;
        }
        return androidx.camera.camera2.pipe.g.INSTANCE.l(this.metadataProvider.a(cameraId));
    }

    public final boolean f(CameraGraph.b graphConfig) {
        kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
        if (this.strictMode.getEnabled()) {
            return false;
        }
        Boolean awaitRepeatingRequestOnDisconnect = graphConfig.getFlags().getAwaitRepeatingRequestOnDisconnect();
        return awaitRepeatingRequestOnDisconnect != null ? awaitRepeatingRequestOnDisconnect.booleanValue() : androidx.camera.camera2.pipe.g.INSTANCE.l(this.metadataProvider.a(graphConfig.getCamera()));
    }
}
