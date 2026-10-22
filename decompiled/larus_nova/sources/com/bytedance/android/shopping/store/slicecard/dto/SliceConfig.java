package com.bytedance.android.shopping.store.slicecard.dto;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u000b\u0010\fR.\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/store/slicecard/dto/SliceConfig;", "Ljava/io/Serializable;", "", "", "Lcom/bytedance/android/shopping/store/slicecard/dto/ShopSliceItemConfig;", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "Ljava/util/Map;", "getConfigs", "()Ljava/util/Map;", "setConfigs", "(Ljava/util/Map;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SliceConfig implements Serializable {
    public static final a Companion = null;

    @SerializedName("slice_configs")
    private Map<String, ShopSliceItemConfig> configs;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.store.slicecard.dto.SliceConfig$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/shopping/store/slicecard/dto/SliceConfig$a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/bytedance/android/shopping/store/slicecard/dto/ShopSliceItemConfig;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C2739a extends TypeToken<Map<String, ? extends ShopSliceItemConfig>> {
            public C2739a() {
            }
        }

        public a() {
        }

        public static SliceConfig a(Map r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            String r101 = (String) r100.get("slice_configs");
            if (r101 != null) goto L12;
            return null;
        L12:
            Type r102 = new C2739a().getType();     // Catch: Exception -> L10
            int r103 = t0.f45720a;     // Catch: Exception -> L10
            Map<String, ShopSliceItemConfig> r104 = (Map) t0.a.f45722b.fromJson(r101, r102);     // Catch: Exception -> L10
            SliceConfig r105 = new SliceConfig();     // Catch: Exception -> L10
            r105.setConfigs(r104);     // Catch: Exception -> L10
            return r105;
        L10:
            EnsureManager.ensureNotReachHere();
            return null;
        }
    }

    static {
        Companion = new a();
    }

    public SliceConfig() {
        this.configs = MapsKt.emptyMap();
    }

    public final Map<String, ShopSliceItemConfig> getConfigs() {
        return this.configs;
    }

    public final void setConfigs(Map<String, ShopSliceItemConfig> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.configs = r100;
    }
}
