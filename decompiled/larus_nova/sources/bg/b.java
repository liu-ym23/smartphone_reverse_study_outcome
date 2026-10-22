package bg;

import cf.f;
import com.bytedance.android.ec.common.api.IECPendantStateService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements IECPendantStateService {
    public b() {
    }

    @Override // com.bytedance.android.ec.common.api.IECPendantStateService
    public final f getPendantStateListener(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Map<String, f> r101 = a.f18854a;
        return (f) ((LinkedHashMap) a.f18854a).get(r100);
    }

    @Override // com.bytedance.android.ec.common.api.IECPendantStateService
    public final f removePendantStateListener(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Map<String, f> r101 = a.f18854a;
        return a.f18854a.remove(r100);
    }

    @Override // com.bytedance.android.ec.common.api.IECPendantStateService
    public final void addPendantStateListener(String r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Map<String, f> r102 = a.f18854a;
        a.f18854a.put(r100, r101);
    }
}
