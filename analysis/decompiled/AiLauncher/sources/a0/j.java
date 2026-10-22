package a0;

import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"La0/j;", "", "<init>", "()V", "", "deviceId", "La0/k;", Const.INTENT_KEY_APIKEY, "(I)La0/k;", "", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "repositoryMap", "camera-lifecycle"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f7807a = new j();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Map<Integer, k> repositoryMap = new LinkedHashMap();

    public static final k a(int deviceId) {
        k kVar;
        Map<Integer, k> map = repositoryMap;
        synchronized (map) {
            try {
                Integer numValueOf = Integer.valueOf(deviceId);
                k kVar2 = map.get(numValueOf);
                if (kVar2 == null) {
                    kVar2 = new k(deviceId);
                    map.put(numValueOf, kVar2);
                }
                kVar = kVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return kVar;
    }
}
