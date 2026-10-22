package com.obric.matrix.platform.sdk.ones.location;

import android.net.Uri;
import com.obric.matrix.platform.sdk.ones.internal.tunnel.MatrixEventObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import d.h.b.p;
import d.x;

/* JADX INFO: compiled from: LocationApi.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LocationApi {
    private static final String TAG = "LocationApi";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocationApi f33706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f33707b = null;

    /* JADX INFO: compiled from: LocationApi.kt */
    public static final class LocationObserver extends MatrixEventObserver {
        private volatile d.h.a.a<x> callback;

        public LocationObserver() {
            super("/location/status", false, null, 4, null);
        }

        public final d.h.a.a<x> getCallback() {
            return this.callback;
        }

        public final void setCallback(d.h.a.a<x> r3) {
            this.callback = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.platform.sdk.ones.internal.tunnel.MatrixEventObserver
        public void handleContentChange(Uri r2) {
            o.e(r2, "uri");
            if (this.callback != null) goto L6;
            return;
        L6:
            if (o.a(r2.getPath(), "/location/status") == false) goto L11;
            d.h.a.a<x> r1 = this.callback;
            if (r1 == null) goto L12;
            r1.invoke();
            return;
        L12:
            return;
        }
    }

    /* JADX INFO: compiled from: LocationApi.kt */
    static final class a extends p implements d.h.a.a<LocationObserver> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f33708a = null;

        static {
            f33708a = new a();
        }

        a() {
            super(0);
        }

        public final LocationObserver a() {
            return new LocationObserver();
        }

        @Override // d.h.a.a
        public /* synthetic */ LocationObserver invoke() {
            return a();
        }
    }

    private LocationApi() {
    }

    static {
        f33706a = new LocationApi();
        f33707b = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(a.f33708a, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }
}
