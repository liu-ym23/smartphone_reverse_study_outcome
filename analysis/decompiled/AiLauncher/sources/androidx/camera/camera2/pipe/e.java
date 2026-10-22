package androidx.camera.camera2.pipe;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/pipe/e;", "", "", "name", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final Oa.c f10768c = Oa.b.c(0);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String name;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/pipe/e$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/e;", Const.INTENT_KEY_APIKEY, "()Landroidx/camera/camera2/pipe/e;", "LOa/c;", "cameraGraphIds", "LOa/c;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.e$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final e a() {
            return new e("CameraGraph-" + e.f10768c.d(), null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ e(String str, kotlin.jvm.internal.i iVar) {
        this(str);
    }

    /* renamed from: toString, reason: from getter */
    public String getName() {
        return this.name;
    }

    public e(String str) {
        this.name = str;
    }
}
