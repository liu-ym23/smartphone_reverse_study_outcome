package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007J'\u0010\b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/SnapshotMutationPolicy;", ExifInterface.GPS_DIRECTION_TRUE, "", "equivalent", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "merge", "previous", "current", "applied", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface SnapshotMutationPolicy<T> {

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotMutationPolicy$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static Object $default$merge(SnapshotMutationPolicy r100, Object r101, Object r102, Object r103) {
            return null;
        }

        public static /* synthetic */ Object access$merge$jd(SnapshotMutationPolicy r100, Object r101, Object r102, Object r103) {
            return $default$merge(r100, r101, r102, r103);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T> T merge(SnapshotMutationPolicy<T> r100, T r101, T r102, T r103) {
            return (T) CC.access$merge$jd(r100, r101, r102, r103);
        }
    }

    boolean equivalent(T r100, T r101);

    T merge(T r100, T r101, T r102);
}
