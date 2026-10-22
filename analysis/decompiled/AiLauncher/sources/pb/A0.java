package pb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.serialization.KSerializer;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R4\u0010\f\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\b0\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lpb/A0;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lpb/Z;", "Lkotlin/Result;", "Lkotlinx/serialization/KSerializer;", Const.INTENT_KEY_APIKEY, "Ljava/util/concurrent/ConcurrentHashMap;", "serializers", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class A0<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentHashMap<List<Z>, Result<KSerializer<T>>> serializers = new ConcurrentHashMap<>();
}
