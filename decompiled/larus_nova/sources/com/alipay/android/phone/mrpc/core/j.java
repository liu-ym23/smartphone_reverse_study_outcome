package com.alipay.android.phone.mrpc.core;

import com.byted.cast.common.source.ISendResultListener;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* JADX INFO: loaded from: classes28.dex */
public final class j extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f25021g;

    public j(g r100, Method r101, int r110, String r111, byte[] r112, boolean r113) {
        super(r101, r110, r111, r112, "application/x-www-form-urlencoded", r113);
        this.f25021g = r100;
    }

    @Override // com.alipay.android.phone.mrpc.core.v
    public final Object a() {
        o r100 = new o(this.f25021g.a());
        r100.a(this.f24990b);
        r100.a(this.f24993e);
        r100.a(this.f24994f);
        r100.a("id", String.valueOf(this.f24992d));
        r100.a("operationType", this.f24991c);
        r100.a(DownloadHelper.GZIP, String.valueOf(this.f25021g.d()));
        r100.a(new BasicHeader(ST.UUID_DEVICE, UUID.randomUUID().toString()));
        List<Header> r101 = this.f25021g.c().b();
        if (r101 != null) goto L5;
    L10:
        ThreadMethodProxy.currentThread().getId();
        r100.toString();
        u r102 = this.f25021g.b().a(r100).get();     // Catch: CancellationException -> L17 ExecutionException -> L20 InterruptedException -> L41
        if (r102 == null) goto L16;
        return r102.b();
    L16:
        throw new RpcException(9, ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_RESPONSE_IS_NULL);     // Catch: CancellationException -> L17 ExecutionException -> L20 InterruptedException -> L41
    L41:
        e = move-exception;
        throw new RpcException(13, "", e);
    L17:
        e = move-exception;
        throw new RpcException(13, "", e);
    L20:
        e = move-exception;
        Throwable r103 = e.getCause();
        if (r103 == null) goto L40;
        if ((r103 instanceof HttpException) == false) goto L40;
        HttpException r104 = (HttpException) r103;
        int r105 = r104.getCode();
        switch(r105) {
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L34;
            case 4: goto L33;
            case 5: goto L32;
            case 6: goto L31;
            case 7: goto L30;
            case 8: goto L29;
            case 9: goto L28;
            default: goto L38;
        };
    L28:
        r105 = 16;
        goto L38
    L29:
        r105 = 15;
        goto L38
    L30:
        r105 = 8;
        goto L38
    L31:
        r105 = 7;
        goto L38
    L32:
        r105 = 6;
        goto L38
    L33:
        r105 = 5;
        goto L38
    L34:
        r105 = 4;
        goto L38
    L35:
        r105 = 3;
        goto L38
    L36:
        r105 = 2;
    L38:
        throw new RpcException(Integer.valueOf(r105), r104.getMsg());
    L40:
        throw new RpcException(9, "", e);
    L5:
        if (r101.isEmpty() == true) goto L10;
        Iterator<Header> r106 = r101.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        r100.a(r106.next());
        goto L8
    }
}
