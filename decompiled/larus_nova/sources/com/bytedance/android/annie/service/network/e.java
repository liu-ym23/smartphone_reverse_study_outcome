package com.bytedance.android.annie.service.network;

import com.bytedance.android.annie.depend.IHostNetworkDepend;
import com.bytedance.android.annie.depend.IRetrofit;
import com.bytedance.retrofit2.Retrofit;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements IHostNetworkDepend {

    public final class a implements IRetrofit {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Retrofit f39896a;

        public a(Retrofit r100) {
            Intrinsics.checkNotNullParameter(r100, "retrofit");
            this.f39896a = r100;
        }

        @Override // com.bytedance.android.annie.depend.IRetrofit
        public final <T> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "service");
            return (T) this.f39896a.create(r100);
        }
    }

    public e() {
    }

    @Override // com.bytedance.android.annie.depend.IHostNetworkDepend
    public final Map<String, Object> getAPIParams() {
        return null;
    }

    @Override // com.bytedance.android.annie.depend.IHostNetworkDepend
    public final IRetrofit createRetrofit(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        return new a(k.a(r100));
    }
}
