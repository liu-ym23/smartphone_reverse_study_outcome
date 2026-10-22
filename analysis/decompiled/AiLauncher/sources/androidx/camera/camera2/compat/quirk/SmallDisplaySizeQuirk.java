package androidx.camera.camera2.compat.quirk;

import K.s0;
import Y8.j;
import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Size;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.vector.EmbedProvider;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/compat/quirk/SmallDisplaySizeQuirk;", "LK/s0;", "<init>", "()V", "Landroid/util/Size;", Const.INTENT_KEY_UMID, "()Landroid/util/Size;", "displaySize", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class SmallDisplaySizeQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final Map<String, Size> f9485c = kotlin.collections.a.m(j.a("REDMI NOTE 8", new Size(1080, 2340)), j.a("REDMI NOTE 7", new Size(1080, 2340)), j.a("SM-A207M", new Size(720, 1560)), j.a("REDMI NOTE 7S", new Size(1080, 2340)), j.a("SM-A127F", new Size(720, EmbedProvider.DEFAULT_MAX_INPUT_CHARS)), j.a("SM-A536E", new Size(1080, 2400)), j.a("220233L2I", new Size(720, EmbedProvider.DEFAULT_MAX_INPUT_CHARS)), j.a("V2149", new Size(720, EmbedProvider.DEFAULT_MAX_INPUT_CHARS)), j.a("VIVO 1920", new Size(1080, 2340)), j.a("CPH2223", new Size(1080, 2400)), j.a("V2029", new Size(720, EmbedProvider.DEFAULT_MAX_INPUT_CHARS)), j.a("CPH1901", new Size(720, 1520)), j.a("REDMI Y3", new Size(720, 1520)), j.a("SM-A045M", new Size(720, EmbedProvider.DEFAULT_MAX_INPUT_CHARS)), j.a("SM-A146U", new Size(1080, 2408)), j.a("CPH1909", new Size(720, 1520)), j.a("NOKIA 4.2", new Size(720, 1520)), j.a("SM-G960U1", new Size(1440, 2960)), j.a("SM-A137F", new Size(1080, 2408)), j.a("VIVO 1816", new Size(720, 1520)), j.a("INFINIX X6817", new Size(720, 1612)), j.a("SM-A037F", new Size(720, EmbedProvider.DEFAULT_MAX_INPUT_CHARS)), j.a("NOKIA 2.4", new Size(720, EmbedProvider.DEFAULT_MAX_INPUT_CHARS)), j.a("SM-A125M", new Size(720, EmbedProvider.DEFAULT_MAX_INPUT_CHARS)), j.a("INFINIX X670", new Size(1080, 2400)));

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/camera/camera2/compat/quirk/SmallDisplaySizeQuirk$a;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Z", "", "", "Landroid/util/Size;", "MODEL_TO_DISPLAY_SIZE_MAP", "Ljava/util/Map;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.SmallDisplaySizeQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a() {
            Map map = SmallDisplaySizeQuirk.f9485c;
            String MODEL = Build.MODEL;
            p.h(MODEL, "MODEL");
            String upperCase = MODEL.toUpperCase(Locale.ROOT);
            p.h(upperCase, "toUpperCase(...)");
            return map.containsKey(upperCase);
        }

        public Companion() {
        }
    }

    public final Size d() {
        Map<String, Size> map = f9485c;
        String MODEL = Build.MODEL;
        p.h(MODEL, "MODEL");
        String upperCase = MODEL.toUpperCase(Locale.ROOT);
        p.h(upperCase, "toUpperCase(...)");
        Size size = map.get(upperCase);
        p.f(size);
        return size;
    }
}
