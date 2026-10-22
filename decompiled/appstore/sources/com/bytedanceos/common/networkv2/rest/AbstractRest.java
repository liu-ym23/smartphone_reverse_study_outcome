package com.bytedanceos.common.networkv2.rest;

import com.bytedanceos.common.networkv2.entity.RepBaseEntity;
import com.bytedanceos.common.networkv2.params.NetParamFactory;
import com.bytedanceos.common.networkv2.rest.intercepter.CommonInterceptor;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import pg.a;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.g;
import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractRest {
    protected Func1<Response<? extends RepBaseEntity>, RepBaseEntity> parseFun;
    public Retrofit retrofit;

    public static class MyTransformer implements Observable.Transformer {
        private MyTransformer() {
        }

        @Override // rx.functions.Func1
        public Observable call(Observable r10) {
            return r10.s(a.c()).A(a.c()).g(mg.a.b());
        }

        public /* synthetic */ MyTransformer(AnonymousClass1 r10) {
            this();
        }
    }

    public AbstractRest() {
        this.parseFun = new AnonymousClass1(this);
    }

    public abstract String getBaseUrl();

    public OkHttpClient.Builder getClientBuilder() {
        OkHttpClient.Builder r10 = new OkHttpClient.Builder();
        TimeUnit r11 = TimeUnit.SECONDS;
        r10.e(10, r11);
        r10.n(30, r11);
        r10.q(30, r11);
        r10.a(new CommonInterceptor());
        r10.o(true);
        return r10;
    }

    public Map getUrlParams(Map r10) {
        HashMap r11 = new HashMap();
        if (NetParamFactory.instance().getUrlParams() == null) goto L5;
        r11.putAll(NetParamFactory.instance().getUrlParams());
    L5:
        if (r10 == null) goto L7;
        r11.putAll(r10);
    L7:
        Iterator r12 = r11.keySet().iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        Object r13 = r12.next();
        if (r11.get(r13) != null) goto L9;
        r11.put(r13, "");
        goto L9
    L13:
        return r11;
    }

    public void init() {
        setRetrofit();
        setService();
    }

    public RepBaseEntity parseEntity(Response<? extends RepBaseEntity> r10) throws Throwable {
        if (r10.a() != null) goto L10;
        if (r10.d() == null) goto L10;
        throw new Throwable(r10.g());
    L10:
        return (RepBaseEntity) r10.a();
    }

    public Observable.Transformer schedulersTransformer() {
        return new MyTransformer(null);
    }

    public Retrofit setRetrofit() {
        String r10 = getBaseUrl();
        Gson r11 = new Gson();
        Retrofit r12 = new Retrofit.b().g(getClientBuilder().c()).b(retrofit2.converter.gson.a.d(r11)).a(g.d()).c(r10).e();
        this.retrofit = r12;
        return r12;
    }

    public abstract void setService();
}
