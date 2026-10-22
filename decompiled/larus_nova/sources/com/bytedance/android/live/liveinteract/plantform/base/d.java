package com.bytedance.android.live.liveinteract.plantform.base;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.interact.audience.InteractAudienceVideoWindowManager;
import com.bytedance.android.live.liveinteract.interact.audience.context.InteractAnchorContext;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.live.datacontext.DataContext;

/* JADX INFO: loaded from: classes46.dex */
public interface d {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final a f75487j0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f75488a = null;

        public a() {
        }

        static {
            f75488a = new a();
        }

        public static d a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("interact_anchor_service");
            if ((r100 instanceof InteractAnchorContext) == true) goto L5;
            r100 = null;
        L5:
            InteractAnchorContext r101 = (InteractAnchorContext) r100;
            if (r101 == null) goto L11;
            com.bytedance.live.datacontext.j<d> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    static {
        f75487j0 = a.f75488a;
    }

    int H();

    com.bytedance.android.live.liveinteract.plantform.core.f X4();

    void Zn();

    void finishInteract(String r100);

    void g0(IBaseUser r100);

    y getLinkUserCenter();

    void h2(gd0.d r100);

    void invite(long r100, String r101, String r102, int r103, long r104);

    boolean isEngineOn();

    void kickOut(String r100, String r101, String r102);

    void showInviteAndPermitDialog();

    InteractAudienceVideoWindowManager windowManager();

    com.bytedance.android.live.pushstream.d xd();
}
