package com.bytedance.android.annie.pia;

import android.webkit.WebResourceResponse;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.annie.resource.o;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.android.annie.service.resource.h;
import com.bytedance.android.annie.service.resource.i;
import com.bytedance.pia.core.api.resource.LoadFrom;

/* JADX INFO: loaded from: classes43.dex */
public final class PiaResourceLoader implements i47.c {

    public static final class a implements l47.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f39720b;

        public a(h r100) {
            this.f39720b = r100;
        }

        @Override // l47.c
        public final void release() {
            h r100 = this.f39720b;
            if (r100 == null) goto L6;
            r100.a();
            return;
        }
    }

    public PiaResourceLoader() {
    }

    public static f c(i r100) {
        if (r100 == null) goto L5;
        WebResourceResponse r101 = r100.e();
    L6:
        if (r100 == null) goto L8;
        byte[] r102 = r100.a();
    L9:
        if (r100 == null) goto L11;
        String r103 = r100.f40040c;
    L13:
        if (r103 != "cdn") goto L15;
        LoadFrom r104 = LoadFrom.Online;
    L16:
        if (r101 == null) goto L20;
        if (r102 != null) goto L19;
        return null;
    L19:
        return new f(r101, r104);
    L20:
        return null;
    L15:
        r104 = LoadFrom.Offline;
        goto L16
    L11:
        r103 = null;
        goto L13
    L8:
        r102 = null;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    @Override // i47.c
    public final i47.e a(LoadFrom r100, i47.d r101) {
        String r102 = String.valueOf(r101.getUrl());
        LoadFrom r103 = LoadFrom.Auto;
        boolean r104 = false;
        if (r100 != r103) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r100 != r103) goto L11;
    L12:
        r104 = true;
    L13:
        o r106 = null;
        if (r105 == false) goto L21;
        WebResourceResponse r107 = com.bytedance.android.annie.service.resource.a.f40028a.j(r102);
        if (r107 != null) goto L18;
        e r108 = null;
    L19:
        if (r108 == null) goto L21;
        return r108;
    L18:
        r108 = new e(r107);
    L21:
        RequestConfig r109 = new RequestConfig(AnnieResType.STATIC);
        r109.f40017b = !r105;
        r109.f40019d = !r104;
        h r110 = n.h(r102, r109);
        if (r110 == null) goto L25;
        r106 = r110.b();
    L25:
        return c(r106);
    L11:
        if (r100 != LoadFrom.Online) goto L13;
    L5:
        if (r100 == LoadFrom.Offline) goto L8;
        r105 = false;
        goto L9
    }

    @Override // i47.c
    public final l47.c b(LoadFrom r100, i47.d r101, final l47.a<i47.e> r102, l47.a<Throwable> r103) {
        String r104 = String.valueOf(r101.getUrl());
        LoadFrom r105 = LoadFrom.Auto;
        boolean r106 = false;
        if (r100 != r105) goto L5;
    L8:
        boolean r107 = true;
    L9:
        if (r100 != r105) goto L11;
    L12:
        r106 = true;
    L13:
        if (r107 == false) goto L21;
        WebResourceResponse r108 = com.bytedance.android.annie.service.resource.a.f40028a.j(r104);
        if (r108 != null) goto L17;
        e r109 = null;
    L18:
        if (r109 == null) goto L21;
        r102.accept(r109);
        return null;
    L17:
        r109 = new e(r108);
    L21:
        RequestConfig r110 = new RequestConfig(AnnieResType.STATIC);
        r110.f40017b = !r107;
        r110.f40019d = !r106;
        return new a(n.g(r104, r110, new PiaResourceLoader$loadAsync$task$1(r102, this)));
    L11:
        if (r100 != LoadFrom.Online) goto L13;
    L5:
        if (r100 == LoadFrom.Offline) goto L8;
        r107 = false;
        goto L9
    }
}
