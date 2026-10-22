package com.bytedance.android.live.livepkaudience.service;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.livepkaudience.base.i;
import com.bytedance.android.live.livepkaudience.base.p;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractAnchorContext;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public interface b {

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final a f82248v0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f82249a = null;

        public a() {
        }

        static {
            f82249a = new a();
        }

        public static b a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("linkpk_interact_anchor_service");
            if ((r100 instanceof LinkPkInteractAnchorContext) == true) goto L5;
            r100 = null;
        L5:
            LinkPkInteractAnchorContext r101 = (LinkPkInteractAnchorContext) r100;
            if (r101 == null) goto L11;
            j<b> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.livepkaudience.service.b$b, reason: collision with other inner class name */
    public static final class C1256b {
        public static /* synthetic */ void a(b r100, String r101, String r102) {
            r100.kickOut(r101, r102, "");
        }
    }

    static {
        f82248v0 = a.f82249a;
    }

    void Fl(User r100);

    int H();

    p X4();

    void b5(String r100);

    void bf(boolean r100);

    void finishInteract(String r100);

    i getLinkUserCenter();

    void invite(long r100, String r101, String r102, int r103, long r104);

    void kickOut(String r100, String r101, String r102);

    void markSwitchToMulti(boolean r100);

    void switchAudioByClient(boolean r100, List<AnchorLinkUser> r101, long r102, Map<Long, ? extends RoomLinkerContent> r103);

    void u3(String r100);
}
