package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.ui.PkInviteUserListRefreshLayout;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.AnchorLinkmicUserSettings;
import com.bytedance.android.livesdk.chatroom.interact.model.LinkInviteResult;
import com.bytedance.android.livesdk.chatroom.interact.model.RivalExtraInfo;
import com.bytedance.android.livesdk.chatroom.interact.model.m0;
import com.bytedance.android.livesdk.config.lh0;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaAnchorLinkUserListContract$View;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.ui.MediaAnchorLinkExpandViewHolder;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.ui.MediaLinkAnchorItemExposeRecyclerView;
import com.bytedance.android.livesdk.message.model.Cif;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes9.dex */
public class MediaAnchorLinkUserListFragment extends MediaAnchorLinkUserListContract$View implements t82.c, MediaAnchorLinkExpandViewHolder.a {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MediaLinkAnchorItemExposeRecyclerView f138035g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f138036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PkInviteUserListRefreshLayout f138037i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f138038j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f138039k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f138040l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Boolean f138041m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f138042n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f138043o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public m0 f138044p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MultiTypeAdapter f138045q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public hy.e f138046r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<AnchorLinkUser> f138047s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Room f138048t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ey.k f138049u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f138050v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Handler f138051w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final nc0.b f138052x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a f138053y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final b f138054z;

    public class a extends ey.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaAnchorLinkUserListFragment f138055a;

        public a(MediaAnchorLinkUserListFragment r100) {
            this.f138055a = r100;
        }

        @Override // ey.d, ey.j
        public final void Ci(fy.c r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            this.f138055a.f138045q.notifyDataSetChanged();
        }

        @Override // ey.d, ey.j
        public final void qe(Cif r100) {
            Intrinsics.checkNotNullParameter(r100, "linkerMessage");
            Iterator<User> r101 = this.f138055a.f138046r.getInviteeList().iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            User r102 = r101.next();
            if (n0.a(r102.getIdStr(), r100.mReply.getToUserId()) == false) goto L4;
            this.f138055a.f138046r.k(r102);
            goto L4
        L8:
            this.f138055a.f138045q.notifyDataSetChanged();
        }

        @Override // ey.d, ey.j
        public final void Th(fy.e r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            this.f138055a.f138045q.notifyDataSetChanged();
            if ((r101 instanceof ApiServerException) == true) goto L5;
            return;
        L5:
            if (((ApiServerException) r101).getErrorCode() != 31012) goto L9;
            this.f138055a.f138106d.dismiss();
            return;
        }

        @Override // ey.d, ey.j
        public final void zm(fy.e r100, long r101, LinkInviteResult r102, ey.l r103) {
            super.zm(r100, r101, r102, r103);
            this.f138055a.f138046r.e((User) r100.f479180h.getBaseOwner());
            this.f138055a.f138046r.b(4, "invite_success_callback");
            this.f138055a.f138045q.notifyDataSetChanged();
            w82.b.e(r100, r100.f479180h);
        }
    }

    public class b extends hy.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaAnchorLinkUserListFragment f138056a;

        public b(MediaAnchorLinkUserListFragment r100) {
            this.f138056a = r100;
        }

        @Override // hy.f.a, hy.f.b
        public final void b(int r100, List<AnchorLinkUser> r101) {
            ((ArrayList) this.f138056a.f138047s).clear();
            ((ArrayList) this.f138056a.f138047s).addAll(r101);
        }
    }

    public class c implements PkInviteUserListRefreshLayout.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaAnchorLinkUserListFragment f138057a;

        @Override // com.bytedance.android.live.ui.PkInviteUserListRefreshLayout.k
        public final void y0() {
        }

        @Override // com.bytedance.android.live.ui.PkInviteUserListRefreshLayout.k
        public final void onFinish() {
            MediaAnchorLinkUserListFragment r100 = this.f138057a;
            r100.f138041m = Boolean.TRUE;
            r100.f138035g.r();
        }

        @Override // com.bytedance.android.live.ui.PkInviteUserListRefreshLayout.k
        public final void onRefresh() {
            MediaAnchorLinkUserListFragment r100 = this.f138057a;
            int r101 = MediaAnchorLinkUserListFragment.A;
            ((t82.d) r100.f138108f).c(r100.f138042n);
        }

        @Override // com.bytedance.android.live.ui.PkInviteUserListRefreshLayout.k
        public final void z1() {
            if (this.f138057a.f138041m.booleanValue() == false) goto L6;
            this.f138057a.f138038j.setVisibility(0);
            MediaAnchorLinkUserListFragment r100 = this.f138057a;
            r100.f138041m = Boolean.FALSE;
            return;
        }

        public c(MediaAnchorLinkUserListFragment r100) {
            this.f138057a = r100;
        }
    }

    public MediaAnchorLinkUserListFragment() {
        this.f138043o = Integer.MAX_VALUE;
        this.f138047s = new ArrayList();
        this.f138048t = ((IRoomService) jc1.k.f(IRoomService.class)).getCurrentRoom();
        this.f138050v = true;
        this.f138051w = new Handler();
        ey.g.f474778a.getClass();
        this.f138052x = ey.g.a.a();
        this.f138053y = new a(this);
        this.f138054z = new b(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final float T90() {
        return t6.d(s1.getContext(), t6.c(s1.getContext()) * 1.2f) - 48;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final String V90() {
        return getString(R.string.ttlive_media_anchor_link_user_list_title);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f138051w.removeCallbacksAndMessages(null);
        ((t82.d) this.f138108f).f119692a = null;
        nc0.b r100 = this.f138052x;
        if (r100 == null) goto L5;
        r100.a(17, this.f138053y);
    L5:
        hy.e r101 = this.f138046r;
        if (r101 == null) goto L9;
        r101.h(this.f138054z);
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        MediaLinkAnchorItemExposeRecyclerView r100 = this.f138035g;
        if (r100 == null) goto L6;
        r100.setNestedScrollingEnabled(true);
        this.f138035g.requestLayout();
    L6:
        if (this.f138050v == false) goto L12;
        hy.e r101 = this.f138046r;
        if (r101 == null) goto L10;
        r101.b(4, "show_link_list_dialog");
    L10:
        ((t82.d) this.f138108f).c(this.f138042n);
        this.f138050v = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaAnchorLinkUserListContract$View
    public final void Y90(Throwable r100) {
        if (this.mStatusViewValid == true) goto L5;
        return;
    L5:
        ExceptionUtils.handleException(getContext(), r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaAnchorLinkUserListContract$View
    public final void Z90(m0 r110) {
        if (this.mStatusViewValid == true) goto L5;
        return;
    L5:
        int r100 = 0;
        if (r110.a() == null) goto L31;
        if (Lists.isEmpty(r110.a()) == true) goto L31;
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L11:
        if (r103 >= r110.a().size()) goto L29;
        Room r104 = (Room) ListProtector.get(r110.a(), r103);
        RivalExtraInfo r105 = r110.b().get(Long.valueOf(r104.getId()));
        if (r105 == null) goto L20;
        AnchorLinkmicUserSettings r106 = r105.anchorLinkmicUserSettings;
        if (r106 == null) goto L20;
        if (r106.isTurnOn == true) goto L20;
        r102.add(r104);
    L28:
        r103 = r103 + 1;
    L20:
        if (r104.getLinkMicInfo() == null) goto L22;
        r102.add(r104);
        goto L28
    L22:
        Map<String, Long> r107 = r104.getLinkMap();
        if (r107 != null) goto L25;
    L27:
        r101.add(r104);
        goto L28
    L25:
        if (r107.containsKey(String.valueOf(17)) == false) goto L27;
        r102.add(r104);
        goto L28
    L29:
        r110.a().clear();
        r110.a().addAll(r101);
        r110.a().addAll(r102);
    L31:
        if (r110.a() != null) goto L33;
    L58:
        this.f138044p = r110;
        if (this.f138037i.f101964e == false) goto L61;
        new Handler().postDelayed(new h(this), 1000);
    L61:
        this.f138035g.f138155b.clear();
        MultiTypeAdapter r108 = this.f138045q;
        r108.f513437a = aa0(r110);
        this.f138045q.notifyDataSetChanged();
        this.f138039k.setVisibility(8);
        return;
    L33:
        if (Lists.isEmpty(r110.a()) == true) goto L58;
    L35:
        if (r100 >= r110.a().size()) goto L56;
        Room r109 = (Room) ListProtector.get(r110.a(), r100);
        if (r110.b() == null) goto L45;
        RivalExtraInfo r111 = r110.b().get(Long.valueOf(r109.getId()));
        if (r111 == null) goto L45;
        AnchorLinkmicUserSettings r112 = r111.anchorLinkmicUserSettings;
        if (r112 == null) goto L45;
        if (r112.isTurnOn == true) goto L45;
        this.f138043o = r100;
    L45:
        if (r109 == null) goto L54;
        if (r109.getLinkMicInfo() != null) goto L48;
        Map<String, Long> r113 = r109.getLinkMap();
        if (r113 == null) goto L54;
        if (r113.containsKey(String.valueOf(17)) == false) goto L54;
        this.f138043o = r100;
        goto L56
    L48:
        this.f138043o = r100;
    L54:
        r100 = r100 + 1;
    L56:
        if (r100 != r110.a().size()) goto L58;
        this.f138043o = r110.a().size();
        goto L58
    }

    public final List<Object> aa0(m0 r100) {
        LinkedList r101 = new LinkedList();
        if (r100.a() == null) goto L17;
        if (r100.a().size() <= 0) goto L7;
        v82.c.a r102 = new v82.c.a();
        r102.f553664a = s1.B(R.string.ttlive_media_link_title_follow_anchor);
        r101.add(r102);
    L7:
        Iterator<Room> r103 = r100.a().iterator();
        int r104 = 0;
    L9:
        if (r103.hasNext() == false) goto L17;
        Room r105 = r103.next();
        int r106 = this.f138043o;
        if (r104 != r106) goto L15;
        if (r106 >= r100.a().size()) goto L15;
        v82.a.C7973a r107 = new v82.a.C7973a();
        r107.f553660a = s1.C(R.string.ttlive_media_anchor_link_expand_unavailable_followed_anchor, new Object[]{Integer.valueOf(r100.a().size() - r104)});
        r101.add(r107);
    L15:
        Map<Long, RivalExtraInfo> r108 = r100.b();
        v82.d.a r109 = new v82.d.a();
        r109.f553666a = r105;
        r109.f553668c = 1;
        r109.f553667b = r108;
        r101.add(r109);
        r104 = r104 + 1;
    L17:
        if (r101.isEmpty() == false) goto L19;
        this.f138035g.setVisibility(8);
        this.f138040l.setVisibility(0);
        this.f138037i.setVisibility(8);
    L20:
        return r101;
    L19:
        this.f138035g.setVisibility(0);
        this.f138040l.setVisibility(8);
        this.f138037i.setVisibility(0);
        goto L20
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        T r101 = this.f138108f;
        if (r101 == 0) goto L5;
        ((t82.d) r101).f119692a = this;
    L5:
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r102 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
        if ((r102 instanceof x82.a) == false) goto L12;
        this.f138049u = ((x82.a) r102).getLinkOutManager();
        nc0.b r103 = this.f138052x;
        if (r103 == null) goto L10;
        r103.b(17, this.f138053y);
    L10:
        hy.e r104 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a().Np();
        this.f138046r = r104;
        r104.i(this.f138054z);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = r100.inflate(R.layout.ttlive_media_fragment_anchor_link_user_list, r101, false);
        this.f138035g = (MediaLinkAnchorItemExposeRecyclerView) r103.findViewById(R.id.recycler_view);
        this.f138036h = (TextView) r103.findViewById(R.id.private_hint);
        if (((IUserService) jc1.k.f(IUserService.class)).user().b().getSecret() != 1) goto L9;
        this.f138036h.setVisibility(0);
        String r104 = lh0.f120680a.getValue();
        if (TextUtils.isEmpty(r104) == false) goto L7;
    L10:
        PkInviteUserListRefreshLayout r105 = (PkInviteUserListRefreshLayout) r103.findViewById(R.id.userlist_swipe_refresh_layout);
        this.f138037i = r105;
        r105.setRecyclerView(this.f138035g);
        this.f138038j = r103.findViewById(R.id.userlist_refresh_progress_double_ball);
        this.f138039k = r103.findViewById(R.id.preload_progress_icon_double_ball);
        this.f138038j.setVisibility(0);
        this.f138039k.setVisibility(0);
        this.f138040l = r103.findViewById(R.id.tv_empty);
        this.f138041m = Boolean.TRUE;
        this.f138037i.setOnRefreshListener(new c(this));
        this.f138035g.setLayoutManager(new LinearLayoutManager(getContext()));
        MultiTypeAdapter r106 = new MultiTypeAdapter();
        this.f138045q = r106;
        r106.z2(v82.c.a.class, new v82.c());
        this.f138045q.z2(v82.a.C7973a.class, new v82.a(this));
        this.f138045q.z2(v82.d.a.class, new v82.d(this));
        this.f138037i.setmIsDisable(false);
        this.f138035g.setAdapter(this.f138045q);
        return r103;
    L7:
        if (getContext() == null) goto L10;
        this.f138036h.setText(String.format(r104, new Object[]{getContext().getResources().getString(R.string.ttlive_interaction_more)}));
        goto L10
    L9:
        this.f138036h.setVisibility(8);
        goto L10
    }
}
