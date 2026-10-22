package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkPrecisionMatchInviteContract$View;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkPrecisionMatchInviteFragment;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k extends x31.n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f96036d;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f96037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f96038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f96039c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f96040d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f96041e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f96042f;

        public a(k r100, int r101, long r102, int r103, String r104, long r105) {
            this.f96037a = r100;
            this.f96038b = r101;
            this.f96039c = r102;
            this.f96040d = r103;
            this.f96041e = r104;
            this.f96042f = r105;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            ExtraResponse r111 = (ExtraResponse) r110;
            InteractDialogPkPrecisionMatchInviteContract$View r112 = (InteractDialogPkPrecisionMatchInviteContract$View) this.f96037a.f92392c;
            if (r112 == null) goto L5;
            r112.ca0(this.f96038b);
        L5:
            com.bytedance.android.live.revlink.impl.global.c r113 = com.bytedance.android.live.revlink.impl.global.b.k();
            if (r113 == null) goto L8;
            w31.e r114 = r113.getPrecisionMatchMonitor();
        L9:
            w31.e r100 = r114;
            if (r100 == null) goto L13;
            r100.a(this.f96038b, this.f96039c, this.f96040d, this.f96041e, this.f96042f, null, "click");
            return;
        L13:
            return;
        L8:
            r114 = null;
            goto L9
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f96043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f96044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f96045c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f96046d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f96047e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f96048f;

        public b(k r100, int r101, long r102, int r103, String r104, long r105) {
            this.f96043a = r100;
            this.f96044b = r101;
            this.f96045c = r102;
            this.f96046d = r103;
            this.f96047e = r104;
            this.f96048f = r105;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Throwable r100 = (Throwable) r110;
            this.f96043a.d(r100);
            InteractDialogPkPrecisionMatchInviteContract$View r111 = (InteractDialogPkPrecisionMatchInviteContract$View) this.f96043a.f92392c;
            if (r111 == null) goto L5;
            r111.ba0(r100);
        L5:
            com.bytedance.android.live.revlink.impl.global.c r112 = com.bytedance.android.live.revlink.impl.global.b.k();
            if (r112 == null) goto L8;
            w31.e r113 = r112.getPrecisionMatchMonitor();
        L9:
            w31.e r101 = r113;
            if (r101 == null) goto L13;
            r101.a(this.f96044b, this.f96045c, this.f96046d, this.f96047e, this.f96048f, r100, "click");
            return;
        L13:
            return;
        L8:
            r113 = null;
            goto L9
        }
    }

    public k(InteractPkPrecisionMatchInviteFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }

    public final void e(int r110, long r111, int r112, String r113, long r114) {
        Intrinsics.checkNotNullParameter(r113, "flexActivityId");
        Observable<ExtraResponse<Object, Extra>> r100 = r31.b.a(r31.a.f535859a).a(r110, r111, r112, r113, r114);
        if (r100 == null) goto L8;
        ObservableSubscribeProxy r101 = (ObservableSubscribeProxy) r100.as(c());
        if (r101 == null) goto L9;
        r101.subscribe(new a(this, r110, r111, r112, r113, r114), new b(this, r110, r111, r112, r113, r114));
        return;
    L9:
        return;
    }
}
