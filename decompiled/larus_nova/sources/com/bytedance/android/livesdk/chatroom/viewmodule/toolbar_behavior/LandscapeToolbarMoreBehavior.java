package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.room.api.login.ILoginGuideService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.p9;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.ActivityRoomSkinInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class LandscapeToolbarMoreBehavior extends AbsToolbarMoreBehavior {
    public static final /* synthetic */ int T = 0;
    public final View.OnClickListener L;
    public View M;
    public LottieAnimationView N;
    public yo2.e O;
    public final float P;
    public final float Q;
    public Disposable R;
    public final a S;

    public class a implements Observer<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeToolbarMoreBehavior f116895a;

        public a(LandscapeToolbarMoreBehavior r100) {
            this.f116895a = r100;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Integer r100) {
            Integer r101 = r100;
            LandscapeToolbarMoreBehavior r102 = this.f116895a;
            if (r102.N == null) goto L7;
            r102.s(r101);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3 i() {
        return (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3) com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.i(this.f116873g);
    }

    public final void q() {
        if (VSMediaUIConfigHelper.b(this.f116873g) == true) goto L5;
        return;
    L5:
        if (ht2.g.e(this.f116883q, 8) == false) goto L31;
        this.N.setImageResource(0);
        Room r100 = this.f116883q;
        View r101 = this.M;
        if (r100 == null) goto L32;
        if (r101 != null) goto L11;
        return;
    L11:
        if (r100.getActivityRoomSkinInfo() == null) goto L35;
        ActivityRoomSkinInfo r102 = r100.getActivityRoomSkinInfo();
        py.k r103 = null;
        if (r102 == null) goto L18;
        Map<Integer, py.k> r104 = r102.getHorizontalImages();
        if (r104 == null) goto L18;
        py.k r105 = r104.get(8);
    L19:
        if (r105 == null) goto L36;
        ActivityRoomSkinInfo r106 = r100.getActivityRoomSkinInfo();
        if (r106 == null) goto L26;
        Map<Integer, py.k> r107 = r106.getHorizontalImages();
        if (r107 == null) goto L26;
        r103 = r107.get(8);
    L26:
        int r108 = ht2.k.f487116a;
        Observable<Bitmap> r109 = com.bytedance.android.livesdk.chatroom.utils.a1.k(r103).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnNext(new ht2.c(r101)).doOnError(ht2.d.f487108a);
        if (r109 == null) goto L33;
        r109.subscribe();
        return;
    L33:
        return;
    L36:
        return;
    L18:
        r105 = null;
        goto L19
    L35:
        return;
    L32:
        return;
    }

    public final void r() {
        yo2.e r100 = this.O;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.h() == false) goto L11;
        this.O.d();
        RoomContext.a r101 = RoomContext.Companion;
        DataCenter r102 = this.f116873g;
        r101.getClass();
        RoomContext r103 = RoomContext.a.a(r102, 0);
        if (r103 == null) goto L12;
        r103.getToolbarBubbleManager().c(new m0());
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
        super.dv(r100);
        if ((r100 instanceof pp1.j) == false) goto L6;
        o();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior
    public final void k(KVData r100) {
        super.k(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        String r101 = r100.getKey();
        r101.getClass();
        byte r102 = -1;
        switch(r101.hashCode()) {
            case 170235087: goto L17;
            case 220810209: goto L13;
            case 774252942: goto L9;
            default: goto L20;
        };
    L20:
        switch(r102) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L23;
            default: goto L37;
        };
    L30:
        r();
        return;
    L31:
        s((Integer) hd0.c.f().f481009b);
        return;
    L37:
        return;
    L23:
        if (tb1.c.f545231c == false) goto L26;
        return;
    L26:
        if (this.M == null) goto L33;
        com.bytedance.android.livesdk.chatroom.utils.p.f114578b.getClass();
        HashMap r103 = new HashMap();
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_guest_connection_guide_show", r103, new Object[]{am2.x.class, Room.class});
        r();
        View r104 = LayoutInflater.from(this.N.getContext()).inflate(R.layout.ttlive_view_popup_interact_apply, null);
        ((TextView) r104.findViewById(R.id.apply_tv)).setOnClickListener(new r0(this));
        yo2.e r105 = new yo2.e(this.N.getContext());
        r105.f568642d = r104;
        r105.f568643e = 0;
        r105.f568652n = true;
        r105.f568651m = 5;
        r105.f568650l = true;
        r105.f568640b = new s0(this);
        r105.a();
        this.O = r105;
        this.M.post(new t0(this));
        this.f116873g.put("cmd_send_show_apply_popup_success", Boolean.TRUE);
        RoomContext.a r106 = RoomContext.Companion;
        DataCenter r107 = this.f116873g;
        r106.getClass();
        RoomContext r108 = RoomContext.a.a(r107, 0);
        if (r108 == null) goto L34;
        r108.getToolbarBubbleManager().c(new n0());
        return;
    L34:
        return;
    L33:
        return;
    L9:
        if (r101.equals("cmd_apply_tips") == false) goto L20;
        r102 = 2;
        goto L20
    L13:
        if (r101.equals("cmd_dismiss_apply_popup") == false) goto L20;
        r102 = 1;
        goto L20
    L17:
        if (r101.equals("data_more_dialog_is_show_interact_more") == false) goto L20;
        r102 = 0;
        goto L20
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior, androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        k((KVData) r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior, android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (ILoginGuideService.CC.ins().intercept(new q61.c(new q61.b.a(cz.c.i.f466003c))) == false) goto L5;
        return;
    L5:
        View.OnClickListener r101 = this.L;
        if (r101 == null) goto L8;
        r101.onClick(r100);
    L8:
        super.onClick(r100);
    }

    public final void s(Integer r100) {
        boolean r101 = ((Boolean) this.f116873g.get("data_more_dialog_is_show_interact_more", Boolean.FALSE)).booleanValue();
        int r102 = R.drawable.ttlive_ic_more_land;
        if (r101 == true) goto L13;
        this.N.setBackgroundResource(0);
        LottieAnimationView r103 = this.N;
        if (com.bytedance.android.livesdk.utils.landscape.d.c(this.f116873g) == false) goto L7;
    L10:
        r103.setImageResource(r102);
        q();
        return;
    L7:
        if (VSMediaUIConfigHelper.b(this.f116873g) == true) goto L10;
        r102 = R.drawable.ttlive_ic_more;
        goto L10
    L13:
        if (r100.intValue() != 1) goto L16;
        long r104 = com.bytedance.android.livesdk.config.o.f120872a.getValue().interactIcWaitingId;
        LottieAnimationView r105 = this.N;
        q0 r106 = new q0(this, (FragmentActivity) r105.getContext(), r105);
        ((IGiftServiceExternal) jc1.k.f(IGiftServiceExternal.class)).getAssetsManager().j4(r104, r106, 2);
        this.N.setBackgroundResource(R.drawable.ttlive_bg_toolbar_audience_interact);
    L29:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(this.f116873g) == false) goto L31;
    L32:
        this.N.setBackgroundResource(0);
    L33:
        q();
        return;
    L31:
        if (VSMediaUIConfigHelper.b(this.f116873g) == false) goto L33;
    L16:
        if (r100.intValue() != 2) goto L18;
        long r107 = com.bytedance.android.livesdk.config.o.f120872a.getValue().interactIcCallingId;
        LottieAnimationView r108 = this.N;
        q0 r109 = new q0(this, (FragmentActivity) r108.getContext(), r108);
        ((IGiftServiceExternal) jc1.k.f(IGiftServiceExternal.class)).getAssetsManager().j4(r107, r109, 2);
        this.N.setBackgroundResource(R.drawable.ttlive_bg_toolbar_audience_interact);
        goto L29
    L18:
        Disposable r110 = this.R;
        if (r110 == null) goto L21;
        r110.dispose();
    L21:
        this.N.clearAnimation();
        this.N.setBackgroundResource(0);
        LottieAnimationView r111 = this.N;
        if (com.bytedance.android.livesdk.utils.landscape.d.c(this.f116873g) == false) goto L24;
    L27:
        r111.setImageResource(r102);
        goto L29
    L24:
        if (VSMediaUIConfigHelper.b(this.f116873g) == true) goto L27;
        r102 = R.drawable.ttlive_ic_more;
        goto L27
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        super.R9(r100, r101);
        hd0.c.f().e(this.S);
        r();
        this.f116873g.removeObserver(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        super.p4(r100, r101);
        p9 r102 = new p9(this.f116878l, false, true);
        r102.f113772a = this.f116872f;
        List<ToolbarButton> r103 = this.f116870d;
        Intrinsics.checkNotNullParameter(r103, "stableAreaStateConfigList");
        r102.f113773b = r103;
        Dialog r104 = r102.a();
        this.f116874h = r104;
        r104.setOnDismissListener(new l0());
        ((com.bytedance.android.livesdk.utils.y1) this.f116874h).setDataCenter(this.f116873g);
        this.M = r100;
        LottieAnimationView r105 = (LottieAnimationView) r100.findViewById(R.id.more_toolbar_icon);
        this.N = r105;
        if (com.bytedance.android.livesdk.utils.landscape.d.c(r101) == false) goto L5;
    L8:
        int r106 = R.drawable.ttlive_ic_more_land;
    L9:
        r105.setImageResource(r106);
        hd0.c.f().c(this.S);
        this.f116873g.observe("cmd_apply_tips", this);
        this.f116873g.observe("cmd_dismiss_apply_popup", this);
        this.f116873g.observe("data_more_dialog_is_show_interact_more", this);
        q();
        return;
    L5:
        if (VSMediaUIConfigHelper.b(r101) == true) goto L8;
        r106 = R.drawable.ttlive_ic_more_landscape;
        goto L9
    }

    public LandscapeToolbarMoreBehavior(Context r100, DataCenter r101, View.OnClickListener r102) {
        super(r100, r101);
        this.P = 2.0f;
        this.Q = 5.0f;
        this.S = new a(this);
        this.L = r102;
    }
}
