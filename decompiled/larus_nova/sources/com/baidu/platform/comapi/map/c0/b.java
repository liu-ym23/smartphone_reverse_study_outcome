package com.baidu.platform.comapi.map.c0;

import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MapController f33171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.baidu.platform.comapi.map.c0.e.b f33172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.baidu.platform.comapi.map.c0.e.a f33173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    com.baidu.platform.comapi.map.c0.e.a.InterfaceC0665a f33174d;

    public class a implements com.baidu.platform.comapi.map.c0.e.a.InterfaceC0665a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f33175a;

        public a(b r100) {
            this.f33175a = r100;
        }

        @Override // com.baidu.platform.comapi.map.c0.e.a.InterfaceC0665a
        public boolean a(com.baidu.platform.comapi.map.c0.e.a r100) {
            if (b.a(this.f33175a).isTwoTouchClickZoomEnabled() == true) goto L5;
            return false;
        L5:
            b.a(this.f33175a).setActingTwoClickZoom(true);
            b.a(this.f33175a).getGestureMonitor().b(b.a(this.f33175a).getZoomLevel() - 1.0f);
            b.a(this.f33175a).mapStatusChangeStart();
            b.a(this.f33175a).MapMsgProc(8193, 4, 0);
            if (b.a(this.f33175a).isNaviMode() == true) goto L8;
        L10:
            return true;
        L8:
            if (b.a(this.f33175a).getNaviMapViewListener() == null) goto L10;
            b.a(this.f33175a).getNaviMapViewListener().onAction(521, null);
            goto L10
        }
    }

    public b(MapController r100) {
        this.f33174d = new a(this);
        this.f33171a = r100;
        this.f33172b = new com.baidu.platform.comapi.map.c0.e.b(new com.baidu.platform.comapi.map.c0.f.b(r100));
        this.f33173c = new com.baidu.platform.comapi.map.c0.e.a(this.f33174d, r100);
    }

    public void a(MotionEvent r100) {
        this.f33172b.b(r100);
        this.f33173c.b(r100);
    }

    public static /* synthetic */ MapController a(b r100) {
        return r100.f33171a;
    }
}
