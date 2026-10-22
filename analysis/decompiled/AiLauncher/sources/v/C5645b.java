package v;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Pair;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import t.InterfaceC5494v;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\nB3\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00010\u0005\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR,\u0010\u0007\u001a\u001a\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00010\u0005\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lv/b;", "", "Lt/v;", "cameraProperties", "", "Landroid/util/Pair;", "Landroid/hardware/camera2/CameraCharacteristics$Key;", "extensionsSpecificChars", "<init>", "(Lt/v;Ljava/util/List;)V", Const.INTENT_KEY_APIKEY, "Lt/v;", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "", "c", "Ljava/lang/String;", "cameraId", Const.INTENT_KEY_UMID, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: v.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5645b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5494v cameraProperties;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<Pair<CameraCharacteristics.Key<?>, Object>> extensionsSpecificChars;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final /* synthetic */ String cameraId;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lv/b$a;", "", "<init>", "()V", "Lt/v;", "cameraProperties", "Lv/b;", Const.INTENT_KEY_APIKEY, "(Lt/v;)Lv/b;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: v.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final C5645b a(InterfaceC5494v cameraProperties) {
            p.i(cameraProperties, "cameraProperties");
            return new C5645b(cameraProperties, null, 2, 0 == true ? 1 : 0);
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5645b(InterfaceC5494v interfaceC5494v, List<? extends Pair<CameraCharacteristics.Key<?>, Object>> list) {
        this.cameraProperties = interfaceC5494v;
        this.extensionsSpecificChars = list;
        this.cameraId = interfaceC5494v.g();
    }

    public /* synthetic */ C5645b(InterfaceC5494v interfaceC5494v, List list, int i10, i iVar) {
        this(interfaceC5494v, (i10 & 2) != 0 ? null : list);
    }
}
