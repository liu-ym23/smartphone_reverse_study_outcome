package androidx.camera.camera2.compat.quirk;

import K.s0;
import Z8.Y;
import android.annotation.SuppressLint;
import android.os.Build;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0002\u0005\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/camera/camera2/compat/quirk/FlashAvailabilityBufferUnderflowQuirk;", "LK/s0;", "<init>", "()V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class FlashAvailabilityBufferUnderflowQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final Set<DeviceInfo> f9444c;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/compat/quirk/FlashAvailabilityBufferUnderflowQuirk$a;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Z", "", "Landroidx/camera/camera2/compat/quirk/FlashAvailabilityBufferUnderflowQuirk$b;", "KNOWN_AFFECTED_MODELS", "Ljava/util/Set;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.FlashAvailabilityBufferUnderflowQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a() {
            Set set = FlashAvailabilityBufferUnderflowQuirk.f9444c;
            DeviceInfo.Companion companion = DeviceInfo.INSTANCE;
            String MANUFACTURER = Build.MANUFACTURER;
            p.h(MANUFACTURER, "MANUFACTURER");
            String MODEL = Build.MODEL;
            p.h(MODEL, "MODEL");
            return set.contains(companion.a(MANUFACTURER, MODEL));
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0010B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0011\u001a\u0004\b\u0014\u0010\b¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/compat/quirk/FlashAvailabilityBufferUnderflowQuirk$b;", "", "", "manufacturer", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getManufacturer", Const.INTENT_KEY_PKGNAME, "getModel", "c", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.FlashAvailabilityBufferUnderflowQuirk$b, reason: from toString */
    public static final /* data */ class DeviceInfo {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String manufacturer;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String model;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/compat/quirk/FlashAvailabilityBufferUnderflowQuirk$b$a;", "", "<init>", "()V", "", "manufacturer", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "Landroidx/camera/camera2/compat/quirk/FlashAvailabilityBufferUnderflowQuirk$b;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Landroidx/camera/camera2/compat/quirk/FlashAvailabilityBufferUnderflowQuirk$b;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.compat.quirk.FlashAvailabilityBufferUnderflowQuirk$b$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(i iVar) {
                this();
            }

            public final DeviceInfo a(String manufacturer, String model) {
                p.i(manufacturer, "manufacturer");
                p.i(model, "model");
                Locale US = Locale.US;
                p.h(US, "US");
                String lowerCase = manufacturer.toLowerCase(US);
                p.h(lowerCase, "toLowerCase(...)");
                p.h(US, "US");
                String lowerCase2 = model.toLowerCase(US);
                p.h(lowerCase2, "toLowerCase(...)");
                return new DeviceInfo(lowerCase, lowerCase2, null);
            }

            public Companion() {
            }
        }

        public /* synthetic */ DeviceInfo(String str, String str2, i iVar) {
            this(str, str2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeviceInfo)) {
                return false;
            }
            DeviceInfo deviceInfo = (DeviceInfo) other;
            return p.d(this.manufacturer, deviceInfo.manufacturer) && p.d(this.model, deviceInfo.model);
        }

        public int hashCode() {
            return (this.manufacturer.hashCode() * 31) + this.model.hashCode();
        }

        public String toString() {
            return "DeviceInfo(manufacturer=" + this.manufacturer + ", model=" + this.model + ')';
        }

        public DeviceInfo(String str, String str2) {
            this.manufacturer = str;
            this.model = str2;
        }
    }

    static {
        DeviceInfo.Companion companion = DeviceInfo.INSTANCE;
        f9444c = Y.j(companion.a("sprd", "lemp"), companion.a("sprd", "DM20C"));
    }
}
