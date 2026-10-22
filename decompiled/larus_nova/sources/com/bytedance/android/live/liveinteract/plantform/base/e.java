package com.bytedance.android.live.liveinteract.plantform.base;

import android.content.Context;
import android.view.SurfaceView;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.interact.audience.InteractAudienceVideoWindowManager;
import com.bytedance.android.live.liveinteract.interact.audience.context.InteractGuestContext;
import com.bytedance.android.live.liveinteract.plantform.core.n;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.DataContext;
import w20.xc;

/* JADX INFO: loaded from: classes46.dex */
public interface e {

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final a f75489l0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f75490a = null;

        public a() {
        }

        static {
            f75490a = new a();
        }

        public static e a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("interact_guest_service");
            if ((r100 instanceof InteractGuestContext) == true) goto L5;
            r100 = null;
        L5:
            InteractGuestContext r101 = (InteractGuestContext) r100;
            if (r101 == null) goto L11;
            com.bytedance.live.datacontext.j<e> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        public static /* synthetic */ void a(e r100) {
            r100.Q6(null, true, true);
        }
    }

    static {
        f75489l0 = a.f75490a;
    }

    void D5(int r100, int r101, boolean r102, boolean r103, int r104, xc.a r105);

    void Dn();

    void F3(String r100);

    int H();

    void Q6(h80.a<Boolean> r100, boolean r101, boolean r102);

    SurfaceView R0();

    n W4();

    void X3(long r100, String r101, String r102, int r103);

    void c2(int r100, int r101, String r102, LinkApplyType r103);

    void disconnect();

    y getLinkUserCenter();

    com.bytedance.android.live.pushstream.d getLiveStream();

    boolean isCurrentLinkPaid();

    boolean isEngineOn();

    void n4(SurfaceView r100);

    void r0(Context r100, IRoom r101, rj0.b r102);

    void w4();

    InteractAudienceVideoWindowManager windowManager();
}
