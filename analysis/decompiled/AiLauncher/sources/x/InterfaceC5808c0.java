package x;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.Set;
import kotlin.Metadata;
import w.InterfaceC5707m;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Lx/c0;", "", "Lw/n;", "cameraId", "Landroidx/camera/camera2/pipe/g;", "c", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/g;", "", "extension", "Lw/m;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;I)Lw/m;", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/util/Set;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.c0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC5808c0 {
    androidx.camera.camera2.pipe.g a(String cameraId);

    Set<Integer> b(String cameraId);

    Object c(String str, InterfaceC4014c<? super androidx.camera.camera2.pipe.g> interfaceC4014c);

    InterfaceC5707m d(String cameraId, int extension);
}
