package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class j extends i<BottomRightBannerWidget> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f115280q;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ViewGroup f115281m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HSImageView f115282n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f115283o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TransitionDrawable f115284p;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f115285a;

        public a(j r100) {
            this.f115285a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.livesdk.log.g r101 = com.bytedance.android.livesdk.log.u.l();
            Pair[] r102 = new Pair[2];
            if (this.f115285a.f115269f == false) goto L5;
            String r103 = "open";
        L6:
            r102[0] = TuplesKt.to("click_type", r103);
            r102[1] = TuplesKt.to("user_id", ((IUserService) jc1.k.n(IUserService.class)).user().n());
            r101.sendLog("live_activity_banner_button_click", MapsKt.mapOf(r102), new Object[]{am2.x.class, Room.class});
            j r104 = this.f115285a;
            if (r104.f115269f == false) goto L9;
            r104.b();
            return;
        L9:
            r104.a();
            return;
        L5:
            r103 = "retract";
            goto L6
        }
    }

    public static final class b {
    }

    static {
    }

    public final void d(int r100) {
        Drawable r101 = this.f115282n.getBackground();
        if ((r101 instanceof ShapeDrawable) == false) goto L10;
        Drawable r102 = this.f115282n.getBackground();
        if (r102 == null) goto L8;
        ((ShapeDrawable) r102).getPaint().setColor(r100);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ShapeDrawable");
    L10:
        if ((r101 instanceof GradientDrawable) == false) goto L17;
        Drawable r103 = this.f115282n.getBackground();
        if (r103 == null) goto L15;
        ((GradientDrawable) r103).setColor(r100);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L17:
        if ((r101 instanceof ColorDrawable) == false) goto L25;
        Drawable r104 = this.f115282n.getBackground();
        if (r104 == null) goto L22;
        ((ColorDrawable) r104).setColor(r100);
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    }

    public final void e(BannerInRoomCollection.BannerInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r100, "info");
        int r101 = r100.height;
        if (r101 <= 0) goto L5;
        int r102 = com.bytedance.android.live.core.utils.s1.f(Math.min(r101, 130));
        View r103 = this.f115266c;
        r103.getLayoutParams().height = r102;
        r103.requestLayout();
    L5:
        com.bytedance.android.livesdk.chatroom.model.m r104 = r100.collapseInfo;
        boolean r105 = false;
        if (r104 != null) goto L8;
    L11:
        com.bytedance.android.livesdk.chatroom.model.m r106 = r100.collapseInfo;
        if (r106 == null) goto L19;
        a5 r107 = r106.title;
        if (r107 == null) goto L19;
        TextView r108 = this.f115283o;
        Spannable r109 = sb2.a.f541209a;
        String r110 = "";
        if (TextUtils.isEmpty("") == false) goto L18;
        r110 = r107.getDefaultPattern();
    L18:
        r108.setText(sb2.a.g(r110, r107, sb2.a.c()).f545238a);
    L19:
        com.bytedance.android.livesdk.chatroom.model.m r111 = r100.collapseInfo;
        if (r111 == null) goto L24;
        py.k r112 = r111.image;
        if (r112 == null) goto L24;
        ImageLoader.bindImage(this.f115282n, r112);
        d(0);
        return;
    L24:
        Integer r113 = null;
        if (r111 == null) goto L27;
        String r114 = r111.backgroundColor;
    L29:
        if (r114 != null) goto L31;
    L32:
        r105 = true;
    L34:
        if ((!r105) == true) goto L45;
        r114 = null;
    L45:
        r113 = Integer.valueOf(Color.parseColor(r114));     // Catch: Throwable -> L39
    L40:
        if (r113 == null) goto L42;
        d(r113.intValue());
    L43:
        Unit r115 = Unit.INSTANCE;
        return;
    L42:
        this.f115282n.setBackgroundResource(R.drawable.ttlive_bg_regular_banner_collapse_default);
        goto L43
    L31:
        if (r114.length() != 0) goto L34;
    L27:
        r114 = null;
        goto L29
    L8:
        if (Boolean.valueOf(r104.enabled).booleanValue() == false) goto L10;
        this.f115281m.setVisibility(0);
        goto L11
    L10:
        this.f115281m.setVisibility(8);
        b();
        goto L11
    }

    public j(ViewGroup r100, i.b r101) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        Intrinsics.checkNotNullParameter(r101, "stateChangeListener");
        super(r100, r101);
        ViewGroup r102 = (ViewGroup) c().findViewById(R.id.bar_container);
        r102.setOnClickListener(new a(this));
        Unit r103 = Unit.INSTANCE;
        this.f115281m = r102;
        this.f115282n = (HSImageView) r102.findViewById(R.id.background);
        this.f115283o = (TextView) r102.findViewById(R.id.title);
        TransitionDrawable r104 = new TransitionDrawable(new Drawable[]{com.bytedance.android.live.core.utils.s1.m(R.drawable.ttlive_ic_banner_collapsed), com.bytedance.android.live.core.utils.s1.m(R.drawable.ttlive_ic_banner_expanded)});
        r104.setCrossFadeEnabled(true);
        ((ImageView) r102.findViewById(R.id.expand_icon)).setImageDrawable(r104);
        r104.startTransition(0);
        this.f115284p = r104;
    }
}
