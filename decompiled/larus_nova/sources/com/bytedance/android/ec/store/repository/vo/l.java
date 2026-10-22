package com.bytedance.android.ec.store.repository.vo;

import com.bytedance.android.ec.core.utils.z1;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class l extends StoreV2ProductItemVO {
    public static final a V = null;
    public Map<String, ? extends Object> R;
    public Map<String, ? extends Object> S;
    public Map<String, ? extends Object> T;
    public Map<String, Object> U;

    public static final class a {
        public a() {
        }

        public static l a(com.bytedance.android.ec.store.repository.dto.l r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            StoreV2ProductItemVO.a r101 = StoreV2ProductItemVO.Q;
            l r102 = new l();
            r101.getClass();
            StoreV2ProductItemVO.a.c(r100, r102);
            Map<String, ? extends Object> r103 = z1.k(com.bytedance.android.ec.hybrid.list.util.k.b(r100));
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r102.R = r103;
            return r102;
        }
    }

    @Override // com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO, com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 99;
    }

    static {
        V = new a();
    }

    public l() {
        this.R = MapsKt.emptyMap();
        this.S = MapsKt.emptyMap();
        this.T = MapsKt.emptyMap();
        this.U = new LinkedHashMap();
    }
}
