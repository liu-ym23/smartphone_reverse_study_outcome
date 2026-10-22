package com.bytedance.android.livesdk.microom.enhance;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.common.MarqueeTextView;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.microom.NormalRoomShowListWidget;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.obric.sva.sdk.data.ISmModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f153852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f153853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f153854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f153855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f153856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f153857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f153858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f153859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f153860i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f153861j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CompositeDisposable f153862k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public User f153863l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f153864m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Room f153865n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f153866o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f153867p;

    public i() {
    }

    public final void d() {
        String r100 = this.f153864m;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        return;
    L10:
        if (this.f153866o == false) goto L12;
        String r102 = "anchor";
    L13:
        NormalRoomShowListWidget.a r103 = NormalRoomShowListWidget.f153806g;
        String r104 = this.f153864m;
        r103.getClass();
        String r105 = NormalRoomShowListWidget.a.a(r104, "user_identity", r102);
        ILiveActionHandler r106 = (ILiveActionHandler) jc1.k.f(ILiveActionHandler.class);
        if (r106 == null) goto L19;
        r106.handle(com.bytedance.android.live.core.utils.a.d(), r105);
        return;
    L19:
        return;
    L12:
        r102 = SourceType.DEFAULT;
        goto L13
    L7:
        r101 = false;
        goto L8
    }

    public final void e() {
        View r100 = this.f153853b;
        Drawable r101 = null;
        if (r100 == null) goto L5;
        Drawable r102 = r100.getBackground();
    L7:
        if ((r102 instanceof GradientDrawable) == false) goto L10;
        r101 = r102;
    L10:
        GradientDrawable r103 = (GradientDrawable) r101;
        if (r103 == null) goto L14;
        int r104 = s1.h(R.color.ttlive_hs_black_20);
        r103.setColors(new int[]{r104, r104});
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void c(String r110) {
        Room r100 = this.f153865n;
        if (r100 == null) goto L10;
        OfficialChannelInfo r101 = r100.officialChannelInfo;
        if (r101 == null) goto L10;
        String r102 = r101.getChannelName();
        if (r102 == null) goto L10;
        String r111 = r102;
    L11:
        IMicRoomService r103 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
        IBaseUser r104 = null;
        if (r103 == null) goto L14;
        Boolean r105 = Boolean.valueOf(r103.isMicRoom(this.f153865n));
    L16:
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L18;
        String r106 = "1";
    L20:
        if (this.f153866o == false) goto L22;
        String r107 = "anchor";
    L23:
        String r112 = r107;
        int r108 = a.f153840a;
        String r109 = this.f153867p;
        if (r109 != null) goto L26;
        String r113 = "";
    L27:
        Room r114 = this.f153865n;
        if (r114 == null) goto L32;
        OfficialChannelInfo r115 = r114.officialChannelInfo;
        if (r115 == null) goto L32;
        long r116 = r115.getBackupRoomId();
    L33:
        Room r117 = this.f153865n;
        if (r117 == null) goto L38;
        OfficialChannelInfo r118 = r117.officialChannelInfo;
        if (r118 == null) goto L38;
        IBaseUser r119 = r118.getChannelUser();
    L40:
        if ((r119 instanceof User) == false) goto L43;
        r104 = r119;
    L43:
        User r120 = (User) r104;
        if (r120 == null) goto L49;
        String r121 = r120.getIdStr();
        if (r121 == null) goto L49;
        String r122 = r121;
    L50:
        a.b(r110, "carousel_room", r116, r122, r113, r106, r112, r111, 0, null, ISmModel.VERSION_0300);
        return;
    L49:
        r122 = "0";
    L38:
        r119 = null;
    L32:
        r116 = 0;
        goto L33
    L26:
        r113 = r109;
        goto L27
    L22:
        r107 = SourceType.DEFAULT;
        goto L23
    L18:
        r106 = "0";
        goto L20
    L14:
        r105 = null;
    L10:
        r111 = "";
        goto L11
    }

    public static final int a(i r100, int r101, int r102) {
        r100.getClass();
        return (((int) (255 * (r101 / 100.0f))) << 24) | (16777215 & r102);
    }

    public static final void b(i r100, boolean r101, User r102) {
        r100.getClass();
        String r103 = null;
        if (r102 == null) goto L12;
        String r104 = r102.getIdString();
        User r105 = r100.f153863l;
        if (r105 == null) goto L7;
        String r106 = r105.getIdString();
    L9:
        if (Intrinsics.areEqual(r104, r106) == true) goto L12;
        int r107 = R.string.ttlive_mic_room_count_down;
    L13:
        int r108 = s1.h(R.color.ttlive_commonui_white_50);
        TextView r109 = r100.f153857f;
        if (r109 == null) goto L16;
        r109.setTextColor(r108);
    L16:
        int r110 = z.f153896a;
        z.a(r100.f153860i, r108);
        ImageView r111 = r100.f153858g;
        if (r111 == null) goto L19;
        r111.setImageAlpha(128);
    L19:
        ImageView r112 = r100.f153858g;
        if (r102 == null) goto L23;
        ImageModel r113 = r102.getAvatarThumb();
        if (r113 == null) goto L23;
    L27:
        a1.v(r112, r113, R.drawable.ttlive_ic_default_head_small);
        View r114 = r100.f153860i;
        if (r102 == null) goto L33;
        String r115 = r102.getRealNickName();
        if (r115 == null) goto L33;
        r103 = r115;
    L37:
        if ((r114 instanceof TextView) == false) goto L44;
        TextView r116 = (TextView) r114;
        if (r103 != null) goto L42;
        r103 = "";
    L42:
        r116.setText(r103);
    L50:
        if (r101 == false) goto L60;
        TextView r117 = r100.f153857f;
        if (r117 == null) goto L54;
        r117.setVisibility(0);
    L54:
        TextView r118 = r100.f153857f;
        if (r118 == null) goto L57;
        r118.setText(s1.C(r107, new Object[]{60}));
    L57:
        View r119 = r100.f153856e;
        if (r119 == null) goto L66;
        r119.setVisibility(8);
    L66:
        View r120 = r100.f153853b;
        if (r120 == null) goto L70;
        r120.post(new h(r100, r101, r107));
        return;
    L70:
        return;
    L60:
        TextView r121 = r100.f153857f;
        if (r121 == null) goto L63;
        r121.setVisibility(8);
    L63:
        View r122 = r100.f153856e;
        if (r122 == null) goto L66;
        r122.setVisibility(0);
        goto L66
    L44:
        if ((r114 instanceof MarqueeTextView) == false) goto L50;
        MarqueeTextView r123 = (MarqueeTextView) r114;
        if (r103 != null) goto L48;
        r103 = "";
    L48:
        r123.setTextWithFading(r103);
    L33:
        User r124 = r100.f153863l;
        if (r124 == null) goto L37;
        r103 = r124.getRealNickName();
    L23:
        User r125 = r100.f153863l;
        if (r125 == null) goto L26;
        r113 = r125.getAvatarThumb();
        goto L27
    L26:
        r113 = null;
        goto L27
    L7:
        r106 = null;
    L12:
        r107 = R.string.ttlive_mic_room_count_down_loyal;
        goto L13
    }
}
