package com.bytedance.android.ec.hybrid.data.gecko;

import com.bytedance.android.ec.hybrid.data.entity.ECHybridConfigDTO;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkDTO;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public interface c {
    void a(Throwable r100, String r101, Long r102);

    void b(Long r100, Map<String, ECHybridNetworkDTO> r101);

    void c(String r100, Long r101, ECHybridConfigDTO r102, Map<String, ? extends Object> r103);
}
