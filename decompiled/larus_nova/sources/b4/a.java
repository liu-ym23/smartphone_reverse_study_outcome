package b4;

import com.bytedance.ai.bridge.service.IAppletRetrofit;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements IHostNetworkDepend {

    /* JADX INFO: renamed from: b4.a$a, reason: collision with other inner class name */
    public final class C0259a implements IAppletRetrofit {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Retrofit f17425a;

        public C0259a(Retrofit r100) {
            Intrinsics.checkNotNullParameter(r100, "retrofit");
            this.f17425a = r100;
        }

        @Override // com.bytedance.ai.bridge.service.IAppletRetrofit
        public final <T> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "service");
            return (T) this.f17425a.create(r100);
        }
    }

    public a() {
    }

    @Override // com.bytedance.ai.bridge.service.IHostNetworkDepend
    public final IAppletRetrofit createRetrofit(String r100, boolean r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        int r103 = j.f17457a;
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Retrofit.Builder r104 = new Retrofit.Builder().setEndpoint(r100).addConverterFactory(rx5.a.a()).httpExecutor(new SsHttpExecutor()).addInterceptor(new SsInterceptor());
        if (r101 == false) goto L5;
        Client.Provider r105 = new i();
    L7:
        return new C0259a(r104.client(r105).build());
    L5:
        r105 = new l();
        goto L7
    }
}
