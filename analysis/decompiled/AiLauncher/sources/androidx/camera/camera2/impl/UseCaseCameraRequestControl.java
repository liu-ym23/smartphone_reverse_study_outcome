package androidx.camera.camera2.impl;

import Ua.Q;
import Y8.t;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.l;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import h9.InterfaceC4149a;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import t.n0;
import w.Result3A;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u00014JA\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u000b\u0010\fJA\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\fJ1\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H'¢\u0006\u0004\b\u0017\u0010\u0018J3\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0002H'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\tH'¢\u0006\u0004\b \u0010!J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\t2\u0006\u0010#\u001a\u00020\"H'¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\tH'¢\u0006\u0004\b&\u0010!JC\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010-0\t0\u000e2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u000e2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020)H'¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0012H¦@¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\nH&¢\u0006\u0004\b2\u00103ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00065À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "values", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl$Type;", "type", "Landroidx/camera/core/impl/Config$OptionPriority;", "optionPriority", "LUa/Q;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/Map;Landroidx/camera/camera2/impl/UseCaseCameraRequestControl$Type;Landroidx/camera/core/impl/Config$OptionPriority;)LUa/Q;", "l", "", "keys", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;Landroidx/camera/camera2/impl/UseCaseCameraRequestControl$Type;)LUa/Q;", "", "isPrimary", "", "Landroidx/camera/core/UseCase;", "runningUseCases", Const.INTENT_KEY_PKGNAME, "(ZLjava/util/Collection;)LUa/Q;", "Landroidx/camera/core/impl/Config;", "config", "", "tags", "n", "(Landroidx/camera/core/impl/Config;Ljava/util/Map;)LUa/Q;", "Lw/N;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()LUa/Q;", "Lw/a;", "aeMode", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)LUa/Q;", "f", "Landroidx/camera/core/impl/l;", "captureSequence", "", "captureMode", "flashType", "flashMode", "Ljava/lang/Void;", "e", "(Ljava/util/List;III)Ljava/util/List;", "k", "(Le9/c;)Ljava/lang/Object;", "close", "()V", "Type", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface UseCaseCameraRequestControl {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraRequestControl$Type;", "", "<init>", "(Ljava/lang/String;I)V", "SESSION_CONFIG", "DEFAULT", "CAMERA2_CAMERA_CONTROL", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type SESSION_CONFIG = new Type("SESSION_CONFIG", 0);
        public static final Type DEFAULT = new Type("DEFAULT", 1);
        public static final Type CAMERA2_CAMERA_CONTROL = new Type("CAMERA2_CAMERA_CONTROL", 2);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{SESSION_CONFIG, DEFAULT, CAMERA2_CAMERA_CONTROL};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = kotlin.enums.a.a(typeArr$values);
        }

        private Type(String str, int i10) {
        }

        public static InterfaceC4149a<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    static /* synthetic */ Q c(UseCaseCameraRequestControl useCaseCameraRequestControl, List list, Type type, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeParametersAsync");
        }
        if ((i10 & 2) != 0) {
            type = Type.DEFAULT;
        }
        return useCaseCameraRequestControl.i(list, type);
    }

    static /* synthetic */ Q d(UseCaseCameraRequestControl useCaseCameraRequestControl, Map map, Type type, Config.OptionPriority optionPriority, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setParametersAsync");
        }
        if ((i10 & 2) != 0) {
            type = Type.DEFAULT;
        }
        if ((i10 & 4) != 0) {
            optionPriority = n0.a();
        }
        return useCaseCameraRequestControl.h(map, type, optionPriority);
    }

    static /* synthetic */ Q m(UseCaseCameraRequestControl useCaseCameraRequestControl, Map map, Type type, Config.OptionPriority optionPriority, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: submitParameters");
        }
        if ((i10 & 2) != 0) {
            type = Type.DEFAULT;
        }
        if ((i10 & 4) != 0) {
            optionPriority = n0.a();
        }
        return useCaseCameraRequestControl.l(map, type, optionPriority);
    }

    Q<t> b(boolean isPrimary, Collection<? extends UseCase> runningUseCases);

    void close();

    List<Q<Void>> e(List<l> captureSequence, int captureMode, int flashType, int flashMode);

    Q<Result3A> f();

    Q<Result3A> g();

    Q<t> h(Map<CaptureRequest.Key<?>, ? extends Object> values, Type type, Config.OptionPriority optionPriority);

    Q<t> i(List<? extends CaptureRequest.Key<?>> keys, Type type);

    Q<Result3A> j(int aeMode);

    Object k(InterfaceC4014c<? super Boolean> interfaceC4014c);

    Q<t> l(Map<CaptureRequest.Key<?>, ? extends Object> values, Type type, Config.OptionPriority optionPriority);

    Q<t> n(Config config, Map<String, ? extends Object> tags);
}
