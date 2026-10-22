package androidx.compose.ui.graphics.vector;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.keyframes.model.KFAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u0002H\u0003H\u0016¢\u0006\u0002\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorConfig;", "", "getOrDefault", ExifInterface.GPS_DIRECTION_TRUE, KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Landroidx/compose/ui/graphics/vector/VectorProperty;", "defaultValue", "(Landroidx/compose/ui/graphics/vector/VectorProperty;Ljava/lang/Object;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface VectorConfig {

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.VectorConfig$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Object $default$getOrDefault(VectorConfig r100, VectorProperty r101, Object r102) {
            return r102;
        }

        public static /* synthetic */ Object access$getOrDefault$jd(VectorConfig r100, VectorProperty r101, Object r102) {
            return $default$getOrDefault(r100, r101, r102);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T> T getOrDefault(VectorConfig r100, VectorProperty<T> r101, T r102) {
            return (T) CC.access$getOrDefault$jd(r100, r101, r102);
        }
    }

    <T> T getOrDefault(VectorProperty<T> r100, T r101);
}
