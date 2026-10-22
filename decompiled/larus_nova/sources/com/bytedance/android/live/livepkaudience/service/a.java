package com.bytedance.android.live.livepkaudience.service;

import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.livepkaudience.base.o;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractAdminContext;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: classes46.dex */
public interface a extends d {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final C1255a f82246u0 = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.livepkaudience.service.a$a, reason: collision with other inner class name */
    public static final class C1255a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C1255a f82247a = null;

        public C1255a() {
        }

        static {
            f82247a = new C1255a();
        }

        public static a a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("linkpk_interact_admin_service");
            if ((r100 instanceof LinkPkInteractAdminContext) == true) goto L5;
            r100 = null;
        L5:
            LinkPkInteractAdminContext r101 = (LinkPkInteractAdminContext) r100;
            if (r101 == null) goto L11;
            j<a> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    static {
        f82246u0 = C1255a.f82247a;
    }

    o A0();

    void b5(String r100);

    void kickOut(String r100, String r101, String r102);

    void t2(long r100, String r101, String r102);

    void u3(String r100);

    void v0(int r100, String r101, int r102, String r103);

    void wi(LinkPlayerInfo r100);
}
