package com.bytedance.android.live.livepkaudience.service;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.livepkaudience.base.i;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestContext;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public interface d {

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final a f82252x0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f82253a = null;

        public a() {
        }

        static {
            f82253a = new a();
        }

        public static d a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("linkpk_interact_guest_service");
            if ((r100 instanceof LinkPkInteractGuestContext) == true) goto L5;
            r100 = null;
        L5:
            LinkPkInteractGuestContext r101 = (LinkPkInteractGuestContext) r100;
            if (r101 == null) goto L11;
            j<d> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        public static /* synthetic */ void b(d r100) {
            r100.disconnect("leave_normally");
        }

        public static /* synthetic */ void a(d r100, int r101, int r102, String r103) {
            r100.c2(r101, r102, r103, LinkApplyType.NORMAL);
        }
    }

    static {
        f82252x0 = a.f82253a;
    }

    void Rc(long r100, String r101, int r102);

    boolean T2();

    void c2(int r100, int r101, String r102, LinkApplyType r103);

    void cancelApply();

    void disconnect(String r100);

    m00.g getGuestLinkViewNew();

    i getLinkUserCenter();

    m00.g go();

    boolean isEngineOn();

    void onFirstRemoteVideoSend();

    void switchAudioByClient(boolean r100, List<AnchorLinkUser> r101, long r102, Map<Long, ? extends RoomLinkerContent> r103);
}
