package com.bytedance.android.live.core.utils;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class o0 implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f66242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f66243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHandler f66244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f66245d;

    public class a implements IHostFrescoHelper.DownloadImageCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f66246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ py.k f66247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o0 f66248c;

        @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.DownloadImageCallBack
        public final void onFailureImpl() {
            o0 r100 = this.f66248c;
            if (r100.f66243b == false) goto L5;
            return;
        L5:
            r100.f66243b = true;
            ALogger.e("ImageDownloader", "download image failed, model=" + this.f66247b);
            this.f66248c.f66244c.removeMessages(1);
            this.f66248c.f66244c.sendEmptyMessage(3);
        }

        @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.DownloadImageCallBack
        public final void onNewResultImpl() {
            o0 r100 = this.f66248c;
            if (r100.f66243b == false) goto L5;
            return;
        L5:
            int r101 = r100.f66242a + 1;
            r100.f66242a = r101;
            if (r101 != this.f66246a.size()) goto L9;
            this.f66248c.f66244c.removeMessages(1);
            this.f66248c.f66244c.sendEmptyMessage(2);
            return;
        }

        public a(o0 r100, List r101, py.k r102) {
            this.f66248c = r100;
            this.f66246a = r101;
            this.f66247b = r102;
        }
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    public o0() {
        this.f66243b = false;
        this.f66244c = new WeakHandler(Looper.getMainLooper(), this);
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 == null) goto L25;
        int r101 = r100.what;
        if (r101 != 1) goto L6;
        b r102 = this.f66245d;
        if (r102 != null) goto L21;
    L23:
        this.f66243b = true;
        return;
    L21:
        if (this.f66243b == true) goto L23;
        r102.b();
        goto L23
    L6:
        if (r101 != 2) goto L8;
        b r103 = this.f66245d;
        if (r103 == null) goto L17;
        r103.c();
    L17:
        this.f66243b = false;
        return;
    L8:
        if (r101 != 3) goto L28;
        b r104 = this.f66245d;
        if (r104 == null) goto L13;
        r104.a();
    L13:
        this.f66243b = true;
        return;
    L28:
        return;
    }

    public final void a(List<? extends py.k> r100, b r101) {
        if (Lists.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.f66245d = r101;
        this.f66242a = 0;
        this.f66244c.sendEmptyMessageDelayed(1, 5000);
        ArrayList r102 = (ArrayList) r100;
        Iterator r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L19;
        py.k r104 = (py.k) r103.next();
        if (TextUtils.isEmpty(((IHostFrescoHelper) jc1.k.f(IHostFrescoHelper.class)).getImageFilePath(r104)) == false) goto L10;
        if (r104 == null) goto L7;
        if (Lists.isEmpty(r104.getUrls()) == true) goto L7;
        if (TextUtils.isEmpty((CharSequence) ListProtector.get(r104.getUrls(), 0)) == true) goto L7;
        ((IHostFrescoHelper) jc1.k.f(IHostFrescoHelper.class)).tryDownloadImage((String) ListProtector.get(r104.getUrls(), 0), new a(this, r100, r104));
        goto L7
    L10:
        int r105 = this.f66242a + 1;
        this.f66242a = r105;
        if (r105 != r102.size()) goto L7;
        this.f66244c.removeMessages(1);
        this.f66244c.sendEmptyMessage(2);
        goto L7
    }
}
