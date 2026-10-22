package androidx.camera.camera2.compat.quirk;

import K.s0;
import Y8.j;
import android.os.Build;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.SurfaceConfig;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import q.d;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ExtraCroppingQuirk;", "LK/s0;", "<init>", "()V", "Landroidx/camera/core/impl/SurfaceConfig$ConfigType;", "configType", "Landroid/util/Size;", Const.INTENT_KEY_UMID, "(Landroidx/camera/core/impl/SurfaceConfig$ConfigType;)Landroid/util/Size;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExtraCroppingQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final Map<String, Range<Integer>> f9433c = kotlin.collections.a.p(j.a("SM-T580", null), j.a("SM-J710MN", new Range(21, 26)), j.a("SM-A320FL", null), j.a("SM-G570M", null), j.a("SM-G610F", null), j.a("SM-G610M", new Range(21, 26)));

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006R(\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ExtraCroppingQuirk$a;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_PKGNAME, "isSamsungDistortion", "", "", "Landroid/util/Range;", "", "SAMSUNG_DISTORTION_MODELS_TO_API_LEVEL_MAP", "Ljava/util/Map;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.ExtraCroppingQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a() {
            return b();
        }

        public final boolean b() {
            if (!d.f38469a.o()) {
                return false;
            }
            Map map = ExtraCroppingQuirk.f9433c;
            String MODEL = Build.MODEL;
            p.h(MODEL, "MODEL");
            Locale locale = Locale.ROOT;
            String upperCase = MODEL.toUpperCase(locale);
            p.h(upperCase, "toUpperCase(...)");
            if (!map.containsKey(upperCase)) {
                return false;
            }
            Map map2 = ExtraCroppingQuirk.f9433c;
            p.h(MODEL, "MODEL");
            String upperCase2 = MODEL.toUpperCase(locale);
            p.h(upperCase2, "toUpperCase(...)");
            Range range = (Range) map2.get(upperCase2);
            if (range != null) {
                return range.contains((Range) Integer.valueOf(Build.VERSION.SDK_INT));
            }
            return true;
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9434a;

        static {
            int[] iArr = new int[SurfaceConfig.ConfigType.values().length];
            try {
                iArr[SurfaceConfig.ConfigType.PRIV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurfaceConfig.ConfigType.YUV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurfaceConfig.ConfigType.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f9434a = iArr;
        }
    }

    public final Size d(SurfaceConfig.ConfigType configType) {
        p.i(configType, "configType");
        if (!INSTANCE.b()) {
            return null;
        }
        int i10 = b.f9434a[configType.ordinal()];
        if (i10 == 1) {
            return new Size(1920, 1080);
        }
        if (i10 == 2) {
            return new Size(1280, 720);
        }
        if (i10 != 3) {
            return null;
        }
        return new Size(3264, 1836);
    }
}
