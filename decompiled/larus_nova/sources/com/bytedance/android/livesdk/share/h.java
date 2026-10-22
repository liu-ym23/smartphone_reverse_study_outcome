package com.bytedance.android.livesdk.share;

import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback;
import io.reactivex.subjects.SingleSubject;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements com.bytedance.android.livesdk.share.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHostShare f158093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SingleSubject<Object> f158094b;

    public class a extends SimpleShareCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f158095a;

        public a(h r100) {
            this.f158095a = r100;
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final void onFail(Throwable r100) {
            SingleSubject<Object> r101 = this.f158095a.f158094b;
            if (r101 == null) goto L6;
            r101.onError(r100);
            this.f158095a.f158094b = null;
            return;
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final void onSuccess(String r100, String r101) {
            SingleSubject<Object> r102 = this.f158095a.f158094b;
            if (r102 == null) goto L6;
            r102.onSuccess(new Object());
            this.f158095a.f158094b = null;
            return;
        }
    }

    public h(IHostShare r100) {
        new a(this);
        this.f158093a = r100;
    }
}
