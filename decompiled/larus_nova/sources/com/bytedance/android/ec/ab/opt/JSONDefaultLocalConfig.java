package com.bytedance.android.ec.ab.opt;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class JSONDefaultLocalConfig<Config> extends com.bytedance.android.ec.ab.opt.a<Config> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f42660d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<Config> f42661c;

    public static final class a {
    }

    static {
        f42660d = LazyKt.lazy(JSONDefaultLocalConfig$Companion$gson$2.INSTANCE);
    }

    @Override // com.bytedance.android.ec.ab.opt.a
    public final Config b() {
        return (Config) ((Gson) f42660d.getValue()).fromJson("{\n    \"rules\": [\n        {\n            \"replace_domain\": \"p3-aio.ecombdimg.com\",\n            \"match\": [\n                {\n                    \"contains\": \"/ecom-shop-material/\"\n                }\n            ]\n        }\n    ]\n}", this.f42661c);
    L4:
        return null;
    }

    public JSONDefaultLocalConfig(Class<Config> r100) {
        Intrinsics.checkNotNullParameter(r100, "classOfT");
        this.f42661c = r100;
    }
}
