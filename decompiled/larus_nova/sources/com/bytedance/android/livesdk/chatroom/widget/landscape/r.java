package com.bytedance.android.livesdk.chatroom.widget.landscape;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.landscape.ILandscapeSpiltManager;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class r implements ILandscapeSpiltManager {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f119120l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f119121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f119122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f119123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f119124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f119125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f119126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PropertyOwner<ILandscapeSpiltManager.State> f119127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PropertyOwner f119128h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f119129i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f119130j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f119131k;

    public static final class a {
    }

    static {
    }

    public static void a() {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.n<ILandscapeSpiltManager> r101 = r100.getLandscapeSpiltManager();
        if (r101 == null) goto L9;
        r101.setValue(null);
        return;
    L9:
        return;
    }

    public static boolean b() {
        RoomContext.a r100 = RoomContext.Companion;
        RoomContext r101 = RoomContext.a.c(r100, null, 0, 3);
        if (r101 == null) goto L7;
        com.bytedance.live.datacontext.j<DataCenter> r102 = r101.getDataCenter2();
        if (r102 == null) goto L7;
        DataCenter r103 = r102.getValue();
    L9:
        if (VrUtils.t(r103, true) == false) goto L19;
        RoomContext r104 = RoomContext.a.c(r100, null, 0, 3);
        if (r104 == null) goto L19;
        com.bytedance.live.datacontext.m<Room> r105 = r104.getRoom();
        if (r105 == null) goto L19;
        Room r106 = r105.getValue();
        if (r106 == null) goto L19;
        if (r106.isMediaRoom() != true) goto L19;
        return true;
    L19:
        return false;
    L7:
        r103 = null;
        goto L9
    }

    private final Context getContext() {
        return this.f119131k.getContext();
    }

    public final void g() {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.n<ILandscapeSpiltManager> r101 = r100.getLandscapeSpiltManager();
        if (r101 == null) goto L7;
        r101.setValue(this);
    L7:
        this.f119123c.addView(this.f119131k, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout r102 = this.f119123c;
        View r103 = this.f119122b;
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(s1.j(R.dimen.ttlive_landscape_spilt_public_screen_area_width), -1);
        r104.gravity = 5;
        Unit r105 = Unit.INSTANCE;
        r102.addView(r103, r104);
        View r106 = this.f119131k;
        if (r106 == null) goto L11;
        r106.setFitsSystemWindows(false);
        return;
    }

    @Override // com.bytedance.android.livesdk.landscape.ILandscapeSpiltManager
    public final PropertyOwner getState() {
        return this.f119128h;
    }

    public r(View r110) {
        Intrinsics.checkNotNullParameter(r110, "interactionRootView");
        this.f119131k = r110;
        View r100 = null;
        View r111 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_landscape_spilt_wrapper_layout, null);
        this.f119121a = r111;
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_landscape_spilt_public_screen, null);
        this.f119122b = r101;
        this.f119123c = (FrameLayout) r111.findViewById(R.id.spilt_wrapper_frame_layout);
        this.f119124d = (FrameLayout) r101.findViewById(R.id.spilt_message_view_container);
        this.f119125e = (FrameLayout) r101.findViewById(R.id.spilt_comment_view_container);
        this.f119126f = r101.findViewById(R.id.spilt_intercept_view);
        PropertyOwner<ILandscapeSpiltManager.State> r102 = new PropertyOwner(ILandscapeSpiltManager.State.HIDE);
        this.f119127g = r102;
        this.f119128h = r102;
        View r103 = r111.findViewById(R.id.live_shadow_top_vr_media);
        int r104 = 8;
        if (r103 == null) goto L20;
        nm1.s r105 = pm1.f.p();
        if (r105 == null) goto L8;
        r105.h();
        r103.setBackgroundResource(R.drawable.ttlive_vs_player_background_shadow_up3);
    L8:
        if (b() == false) goto L18;
        RoomContext r106 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r106 == null) goto L15;
        com.bytedance.live.datacontext.n<DataCenter> r107 = r106.getDataCenter();
        if (r107 == null) goto L15;
        DataCenter r108 = r107.getValue();
    L15:
        if (VrUtils.s() == true) goto L18;
        int r109 = 0;
    L19:
        r103.setVisibility(r109);
        Unit r112 = Unit.INSTANCE;
    L21:
        this.f119129i = r103;
        View r113 = r111.findViewById(R.id.live_shadow_bottom_vr_media);
        if (r113 == null) goto L38;
        nm1.s r114 = pm1.f.p();
        if (r114 == null) goto L27;
        r114.h();
        r113.setBackgroundResource(R.drawable.ttlive_vs_player_background_shadow_up3);
    L27:
        if (b() == false) goto L37;
        RoomContext r115 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r115 == null) goto L34;
        com.bytedance.live.datacontext.n<DataCenter> r116 = r115.getDataCenter();
        if (r116 == null) goto L34;
        DataCenter r117 = r116.getValue();
    L34:
        if (VrUtils.s() == true) goto L37;
        r104 = 0;
    L37:
        r113.setVisibility(r104);
        Unit r118 = Unit.INSTANCE;
        r100 = r113;
    L38:
        this.f119130j = r100;
        return;
    L18:
        r109 = 8;
        goto L19
    L20:
        r103 = null;
        goto L21
    }

    public static void f(boolean r100) {
        if (r100 == false) goto L5;
        HashMap r101 = new HashMap();
        j0.l().sendLog("livesdk_landscape_pannel_show", r101, new Object[]{new x(), IRoom.class});
        return;
    }

    public final void c(ILandscapeSpiltManager.State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f119127g.a(r100);
    }

    public final void e(int r100) {
        UIUtils.updateLayoutMargin(this.f119131k, -3, -3, r100, -3);
    }

    public final void d(int r100, int r101) {
        UIUtils.updateLayoutMargin(this.f119131k, r100, -3, r101, -3);
    }
}
