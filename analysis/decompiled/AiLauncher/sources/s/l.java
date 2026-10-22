package s;

import androidx.camera.core.impl.CameraInternal;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\u0003J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Ls/l;", "", "Landroidx/camera/core/impl/CameraInternal;", Const.INTENT_KEY_APIKEY, "()Landroidx/camera/core/impl/CameraInternal;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface l {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Ls/l$a;", "", "Ls/m;", "config", Const.INTENT_KEY_PKGNAME, "(Ls/m;)Ls/l$a;", "LP/i;", "streamSpecsCalculator", Const.INTENT_KEY_APIKEY, "(LP/i;)Ls/l$a;", "Ls/l;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Ls/l;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        a a(P.i streamSpecsCalculator);

        a b(m config);

        l build();
    }

    CameraInternal a();
}
