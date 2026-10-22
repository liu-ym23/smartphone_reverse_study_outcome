package androidx.camera.camera2.pipe;

import androidx.camera.camera2.pipe.l;
import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0004Jy\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n2\u0012\u0010\f\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n2\u0012\u0010\r\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00028\u0001H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0018H&¢\u0006\u0004\b\u001b\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0018H¦@¢\u0006\u0004\b\u001c\u0010\u001dø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001eÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/m;", "TCaptureRequest", "Landroidx/camera/camera2/pipe/l;", "TCaptureSequence", "", "", "isRepeating", "", "Landroidx/camera/camera2/pipe/t;", "requests", "", "defaultParameters", "graphParameters", "requiredParameters", "Landroidx/camera/camera2/pipe/l$a;", "sequenceListener", "Landroidx/camera/camera2/pipe/t$a;", "listeners", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(ZLjava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Landroidx/camera/camera2/pipe/l$a;Ljava/util/List;)Landroidx/camera/camera2/pipe/l;", "captureSequence", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/camera/camera2/pipe/l;)Ljava/lang/Integer;", "LY8/t;", "f", "()V", "stopRepeating", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Le9/c;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface m<TCaptureRequest, TCaptureSequence extends l<? extends TCaptureRequest>> {
    void f();

    Integer g(TCaptureSequence captureSequence);

    Object h(InterfaceC4014c<? super Y8.t> interfaceC4014c);

    TCaptureSequence i(boolean isRepeating, List<t> requests, Map<?, ? extends Object> defaultParameters, Map<?, ? extends Object> graphParameters, Map<?, ? extends Object> requiredParameters, l.a sequenceListener, List<? extends t.a> listeners);

    void stopRepeating();
}
