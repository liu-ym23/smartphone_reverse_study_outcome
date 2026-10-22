package com.baidu.naviapi.platform.net;

import com.baidu.naviapi.okhttp.HttpResponseListener;
import com.baidu.naviapi.okhttp.OkHttpManager;
import com.baidu.naviapi.okhttp.RequestEntity;

/* JADX INFO: loaded from: classes39.dex */
public class c {

    public class a implements HttpResponseListener<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f32681a;

        public a(d r100) {
            this.f32681a = r100;
        }

        public void a(String r100) {
            this.f32681a.b().onSuccess(r100);
        }

        @Override // com.baidu.naviapi.okhttp.HttpResponseListener
        public void onError(String r100) {
            this.f32681a.b().a(1, r100);
        }

        @Override // com.baidu.naviapi.okhttp.HttpResponseListener
        public /* bridge */ /* synthetic */ void onResponse(String r100) {
            a(r100);
        }
    }

    public static void a() {
        OkHttpManager.getInstance().cancelPendingRequest();
    }

    public static void a(d r100) {
        RequestEntity r101 = r100.a();
        OkHttpManager.getInstance().sendRequest(r101, new a(r100));
    }
}
