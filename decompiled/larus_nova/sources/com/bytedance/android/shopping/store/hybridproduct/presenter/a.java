package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.bytedance.android.ec.core.utils.t0;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.hybridproduct.presenter.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/shopping/store/hybridproduct/presenter/a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C2730a extends TypeToken<Map<String, String>> {
        public C2730a() {
        }
    }

    public static final Map<String, String> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$jsonString2Map");
        int r101 = t0.f45720a;     // Catch: Exception -> L5
        return (Map) t0.a.f45721a.fromJson(r100, new C2730a().getType());
    L5:
        return null;
    }
}
