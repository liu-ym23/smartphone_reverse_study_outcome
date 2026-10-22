package com.bytedance.android.live.liveinteract.plantform.base;

import com.bytedance.android.live.liveinteract.interact.audience.context.InteractAdminContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.live.datacontext.DataContext;

/* JADX INFO: loaded from: classes46.dex */
public interface c extends e {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final a f75485i0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f75486a = null;

        public a() {
        }

        static {
            f75486a = new a();
        }

        public static c a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("interact_admin_service");
            if ((r100 instanceof InteractAdminContext) == true) goto L5;
            r100 = null;
        L5:
            InteractAdminContext r101 = (InteractAdminContext) r100;
            if (r101 == null) goto L11;
            com.bytedance.live.datacontext.j<c> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    static {
        f75485i0 = a.f75486a;
    }

    com.bytedance.android.live.liveinteract.plantform.core.e A0();

    void kickOut(String r100, String r101, String r102);

    void permit(ILinkPlayerInfoBridge r100);

    void t2(long r100, String r101, String r102);
}
