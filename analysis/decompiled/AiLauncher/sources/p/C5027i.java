package p;

import D.B;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.DynamicRangeProfiles;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\tB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lp/i;", "", "Lp/i$b;", "impl", "<init>", "(Lp/i$b;)V", "LD/B;", "dynamicRange", "", Const.INTENT_KEY_APIKEY, "(LD/B;)Ljava/util/Set;", "Landroid/hardware/camera2/params/DynamicRangeProfiles;", "c", "()Landroid/hardware/camera2/params/DynamicRangeProfiles;", "Lp/i$b;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Set;", "supportedDynamicRanges", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: p.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5027i {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final b impl;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lp/i$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "Lp/i;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/g;)Lp/i;", "Landroid/hardware/camera2/params/DynamicRangeProfiles;", "dynamicRangeProfiles", Const.INTENT_KEY_PKGNAME, "(Landroid/hardware/camera2/params/DynamicRangeProfiles;)Lp/i;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: p.i$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C5027i a(androidx.camera.camera2.pipe.g cameraMetadata) {
            kotlin.jvm.internal.p.i(cameraMetadata, "cameraMetadata");
            CameraCharacteristics.Key REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES = CameraCharacteristics.REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES;
            kotlin.jvm.internal.p.h(REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES, "REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES");
            C5027i c5027iB = b((DynamicRangeProfiles) cameraMetadata.e0(REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES));
            return c5027iB == null ? C5029k.INSTANCE.a() : c5027iB;
        }

        public final C5027i b(DynamicRangeProfiles dynamicRangeProfiles) {
            if (dynamicRangeProfiles == null) {
                return null;
            }
            return new C5027i(new C5028j(dynamicRangeProfiles));
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lp/i$b;", "", "LD/B;", "dynamicRange", "", Const.INTENT_KEY_PKGNAME, "(LD/B;)Ljava/util/Set;", "Landroid/hardware/camera2/params/DynamicRangeProfiles;", Const.INTENT_KEY_APIKEY, "()Landroid/hardware/camera2/params/DynamicRangeProfiles;", "c", "()Ljava/util/Set;", "supportedDynamicRanges", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: p.i$b */
    public interface b {
        /* renamed from: a */
        DynamicRangeProfiles getDynamicRangeProfiles();

        Set<B> b(B dynamicRange);

        Set<B> c();
    }

    public C5027i(b impl) {
        kotlin.jvm.internal.p.i(impl, "impl");
        this.impl = impl;
    }

    public final Set<B> a(B dynamicRange) {
        kotlin.jvm.internal.p.i(dynamicRange, "dynamicRange");
        return this.impl.b(dynamicRange);
    }

    public final Set<B> b() {
        return this.impl.c();
    }

    public final DynamicRangeProfiles c() {
        return this.impl.getDynamicRangeProfiles();
    }
}
