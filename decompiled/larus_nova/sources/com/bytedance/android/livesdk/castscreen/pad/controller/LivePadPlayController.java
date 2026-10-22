package com.bytedance.android.livesdk.castscreen.pad.controller;

import com.byted.cast.common.api.ISendResultListener;
import com.byted.cast.common.source.ServiceInfo;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import com.ss.cast.source.api.g;
import com.ss.cast.source.api.i;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class LivePadPlayController implements com.bytedance.android.livesdk.castscreen.pad.controller.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f104602b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f104603c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LivePadPlayController f104604d = null;

    public static final class a implements ISendResultListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f104605a;

        @Override // com.byted.cast.common.api.ISendResultListener
        public final void onSuccess() {
            nf1.b r100 = (nf1.b) this.f104605a.get();
            if (r100 == null) goto L6;
            r100.onSuccess();
            return;
        }

        public a(WeakReference r100) {
            this.f104605a = r100;
        }

        @Override // com.byted.cast.common.api.ISendResultListener
        public final void onReceive(String r100) {
            nf1.b r101 = (nf1.b) this.f104605a.get();
            if (r101 == null) goto L6;
            r101.onReceive(r100);
            return;
        }

        @Override // com.byted.cast.common.api.ISendResultListener
        public final void onFailure(int r100, String r101) {
            nf1.b r102 = (nf1.b) this.f104605a.get();
            if (r102 == null) goto L6;
            r102.onFailure(r100, r101);
            return;
        }
    }

    public LivePadPlayController() {
    }

    static {
        f104604d = new LivePadPlayController();
        f104602b = LazyKt.lazy(LivePadPlayController$byteCastSource$2.INSTANCE);
        f104603c = CollectionsKt.listOf("BDLink");
    }

    @Override // com.bytedance.android.livesdk.castscreen.pad.controller.a
    public final void a(of1.a r100, String r101, WeakReference<nf1.b> r102) {
        Intrinsics.checkNotNullParameter(r100, NsdHelper.serviceInfoKey);
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "listenerRef");
        if ((r100 instanceof of1.b) == true) goto L5;
        r100 = null;
    L5:
        of1.b r103 = (of1.b) r100;
        if (r103 == null) goto L11;
        i r104 = (i) f104602b.getValue();
        if (r104 == null) goto L12;
        ServiceInfo r105 = r103.f523071g;
        a r106 = new a(r102);
        r104.f456561a.getMsg(r105, r101, new g(r106));
        return;
    L12:
        return;
    }
}
