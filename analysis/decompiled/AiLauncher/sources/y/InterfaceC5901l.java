package y;

import androidx.camera.camera2.pipe.CameraGraph;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001:\u0001\u0003J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Ly/l;", "", "Landroidx/camera/camera2/pipe/CameraGraph;", Const.INTENT_KEY_APIKEY, "()Landroidx/camera/camera2/pipe/CameraGraph;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: y.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC5901l {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ly/l$a;", "", "Ly/m;", "config", Const.INTENT_KEY_APIKEY, "(Ly/m;)Ly/l$a;", "Ly/l;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Ly/l;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: y.l$a */
    public interface a {
        a a(C5902m config);

        InterfaceC5901l build();
    }

    CameraGraph a();
}
