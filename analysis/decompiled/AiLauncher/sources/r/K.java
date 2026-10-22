package r;

import androidx.camera.camera2.compat.quirk.UseTorchAsFlashQuirk;
import androidx.camera.camera2.compat.workaround.UseTorchAsFlashImpl;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import u.InterfaceC5562j;
import w.InterfaceC5705k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\tJ0\u0010\u0007\u001a\u00020\u00062\u001e\u0010\u0005\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H¦@¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lr/K;", "", "Lkotlin/Function1;", "Le9/c;", "Lw/x;", "frameMetadata", "", Const.INTENT_KEY_PKGNAME, "(Lp9/l;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "()Z", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface K {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b'\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lr/K$a;", "", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lr/K$a$a;", "", "<init>", "()V", "Landroidx/camera/camera2/compat/quirk/a;", "cameraQuirks", "Lw/k;", "cameraDevices", "Lu/j;", "intrinsicZoomCalculator", "Lr/K;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/compat/quirk/a;Lw/k;Lu/j;)Lr/K;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: r.K$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final K a(androidx.camera.camera2.compat.quirk.a cameraQuirks, InterfaceC5705k cameraDevices, InterfaceC5562j intrinsicZoomCalculator) {
                kotlin.jvm.internal.p.i(cameraQuirks, "cameraQuirks");
                kotlin.jvm.internal.p.i(cameraDevices, "cameraDevices");
                kotlin.jvm.internal.p.i(intrinsicZoomCalculator, "intrinsicZoomCalculator");
                return cameraQuirks.b().a(UseTorchAsFlashQuirk.class) ? new UseTorchAsFlashImpl(cameraQuirks, cameraDevices, intrinsicZoomCalculator) : x.f38718a;
            }

            public Companion() {
            }
        }
    }

    boolean a();

    Object b(InterfaceC5074l<? super InterfaceC4014c<? super w.x>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super Boolean> interfaceC4014c);
}
