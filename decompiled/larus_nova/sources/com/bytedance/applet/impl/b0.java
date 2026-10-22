package com.bytedance.applet.impl;

import com.bytedance.ai.bridge.service.IAppletRetrofit;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b0 implements IHostNetworkDepend {

    public static final class a implements IAppletRetrofit {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ XIRetrofit f191883a;

        public a(XIRetrofit r100) {
            this.f191883a = r100;
        }

        @Override // com.bytedance.ai.bridge.service.IAppletRetrofit
        public final <T> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "service");
            return (T) this.f191883a.create(r100);
        }
    }

    public b0() {
    }

    @Override // com.bytedance.ai.bridge.service.IHostNetworkDepend
    public final IAppletRetrofit createRetrofit(String r100, boolean r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        if (r102 != null) goto L5;
        r102 = MapsKt.emptyMap();
    L5:
        Map<String, ? extends Object> r103 = MapsKt.plus(r102, TuplesKt.to("flowAppletNetworkInterceptor", com.bytedance.applet.impl.a.f191876a));
        XBaseRuntime r104 = XBaseRuntime.f270095a;
        r104.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.f r105 = XBaseRuntime.f270105k;
        if (r105 == null) goto L10;
        XIRetrofit r106 = r105.createRetrofit(r100, r101, r103);
        if (r106 == null) goto L10;
    L17:
        return new a(r106);
    L10:
        r104.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend r107 = XBaseRuntime.f270104j;
        if (r107 == null) goto L13;
        r106 = r107.createRetrofit(r100, r101);
    L14:
        if (r106 != null) goto L17;
        return null;
    L13:
        r106 = null;
        goto L14
    }
}
