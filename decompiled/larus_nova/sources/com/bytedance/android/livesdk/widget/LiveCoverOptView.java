package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.cp;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveHashTagInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public class LiveCoverOptView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f160955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f160956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f160957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f160958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HSImageView f160959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HSImageView f160960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f160961g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f160962h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f160963i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f160964j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f160965k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f160966l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f160967m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewGroup f160968n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f160969o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f160970p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f160971q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f160972r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public s0 f160973s;

    public String getFrom() {
        return "";
    }

    public int getLayoutId() {
        return R.layout.ttlive_item_cover_style_opt;
    }

    public final void a() {
        HSImageView r100 = this.f160960f;
        int r101 = com.bytedance.android.live.core.utils.s1.f(16.0f);
        int r102 = com.bytedance.android.live.core.utils.s1.f(16.0f);
        if (r100 == null) goto L7;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        r103.width = r101;
        r103.height = r102;
        r100.setLayoutParams(r103);
    L7:
        if (getLayoutId() != R.layout.ttlive_item_cover_style_opt) goto L9;
        float r104 = 10.0f;
    L10:
        TextView r105 = this.f160958d;
        int r106 = com.bytedance.android.live.core.utils.s1.f(14.0f);
        if (r105 == null) goto L14;
        r105.setTextSize(1, r104);
        b(r105, r106);
    L14:
        TextView r107 = this.f160965k;
        int r108 = com.bytedance.android.live.core.utils.s1.f(17.0f);
        if (r107 == null) goto L18;
        r107.setTextSize(1, 12.0f);
        b(r107, r108);
    L18:
        b(this.f160955a, com.bytedance.android.live.core.utils.s1.f(16.0f));
        TextView r109 = this.f160963i;
        int r110 = com.bytedance.android.live.core.utils.s1.f(17.0f);
        if (r109 == null) goto L22;
        r109.setTextSize(1, 12.0f);
        b(r109, r110);
    L22:
        b(this.f160956b, com.bytedance.android.live.core.utils.s1.f(16.0f));
        b(this.f160957c, com.bytedance.android.live.core.utils.s1.f(16.0f));
        HSImageView r111 = this.f160959e;
        int r112 = com.bytedance.android.live.core.utils.s1.f(10.0f);
        int r113 = com.bytedance.android.live.core.utils.s1.f(10.0f);
        if (r111 == null) goto L27;
        ViewGroup.LayoutParams r114 = r111.getLayoutParams();
        r114.width = r112;
        r114.height = r113;
        r111.setLayoutParams(r114);
        return;
    L27:
        return;
    L9:
        r104 = 12.0f;
        goto L10
    }

    public int getDrawCoverStyle() {
        return cp.f119969a.getValue().intValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f160972r = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f160973s);
        this.f160973s = null;
        this.f160972r = false;
    }

    public int getStyle() {
        return this.f160969o;
    }

    public LiveCoverOptView(Context r100) {
        this(r100, null);
    }

    public final void c(IRoom r110) {
        UIUtils.setViewVisibility(this.f160964j, 0);
        if (r110.getOperationLabel() == null) goto L5;
        UIUtils.setViewVisibility(this.f160955a, 0);
        ImageLoader.d r100 = ImageLoader.load(r110.getOperationLabel());
        r100.f66060e = new t0(this);
        r100.a(this.f160955a);
    L6:
        IBaseUser r101 = r110.getOwner();
        String r102 = r110.getTitle();
        if ((r101 instanceof IBaseUser) == false) goto L16;
        int r103 = r.f161945a;
        if (r.a(this.f160959e, r101) == false) goto L13;
        ViewGroup r104 = this.f160961g;
        if (r104 == null) goto L16;
        r104.post(new r0(this));
        goto L16
    L13:
        TextView r105 = this.f160958d;
        if (r105 == null) goto L16;
        r105.setMaxWidth(Integer.MAX_VALUE);
        this.f160958d.setMaxEms(8);
    L16:
        this.f160969o = 1;
        UIUtils.setViewVisibility(this.f160956b, 0);
        UIUtils.setViewVisibility(this.f160957c, 8);
        if (this.f160970p == true) goto L19;
    L21:
        UIUtils.setViewVisibility(this.f160961g, 0);
    L22:
        UIUtils.setViewVisibility(this.f160962h, 8);
        if (getDrawCoverStyle() != 0) goto L25;
    L27:
        if (r101 == null) goto L34;
        User r106 = (User) r101;
        RoomAuthStatus r107 = (RoomAuthStatus) r110.getRoomAuthStatus();
        ImageUtil.loadRoundImage(this.f160960f, r106.getAvatarThumbByRoomAuth(r107));
        String r108 = r106.getRealNickNameByRoomAuth(r107);
        if (r101.getFollowInfo() != null) goto L31;
    L33:
        this.f160958d.setText(r108);
    L36:
        if (r110.getContentLabel() == null) goto L38;
        ImageLoader.d r109 = ImageLoader.load(r110.getContentLabel());
        r109.f66060e = new u0(this);
        r109.a(this.f160956b);
    L40:
        if (TextUtils.isEmpty(r102) == false) goto L42;
        r102 = getContext().getString(R.string.ttlive_live_default_title);
    L42:
        ILiveHashTagInfo r111 = r110.getLiveHashTagInfo();
        if (r111 == null) goto L45;
        String r112 = r111.getName();
    L47:
        if (TextUtils.isEmpty(r112) == true) goto L49;
        this.f160965k.setText(com.bytedance.android.livesdk.utils.r1.b("%s#%s", new Object[]{r102, r112}));
    L50:
        this.f160963i.setText(com.bytedance.android.livesdk.utils.p1.a(r110));
        if (com.bytedance.android.livesdk.utils.p1.c(r110) == false) goto L53;
        d(false);
    L54:
        this.f160966l.setVisibility(8);
        this.f160958d.setMaxEms(8);
        this.f160967m.setVisibility(0);
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) this.f160961g.getLayoutParams();
        r113.bottomMargin = 0;
        this.f160961g.setLayoutParams(r113);
        post(this.f160973s);
        return;
    L53:
        d(true);
        goto L54
    L49:
        this.f160965k.setText(r102);
        goto L50
    L45:
        r112 = r110.getContentTag();
        goto L47
    L38:
        UIUtils.setViewVisibility(this.f160956b, 8);
        goto L40
    L31:
        if (TextUtils.isEmpty(r101.getFollowInfo().getRemarkName()) == true) goto L33;
        r108 = r101.getFollowInfo().getRemarkName();
        goto L33
    L34:
        UIUtils.setViewVisibility(this.f160961g, 8);
        goto L36
    L25:
        if (this.f160970p == false) goto L27;
        UIUtils.setViewVisibility(this.f160960f, 8);
        goto L27
    L19:
        if (getDrawCoverStyle() != 2) goto L21;
        UIUtils.setViewVisibility(this.f160961g, 8);
        goto L22
    L5:
        UIUtils.setViewVisibility(this.f160955a, 8);
        goto L6
    }

    public void d(boolean r100) {
        TextView r101 = this.f160963i;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        UIUtils.setViewVisibility(r101, r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public LiveCoverOptView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static void b(View r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r102 = r100.getLayoutParams().width;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        r103.width = r102;
        r103.height = r101;
        r100.setLayoutParams(r103);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.livesdk.widget.s0] */
    public LiveCoverOptView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f160969o = 0;
        this.f160970p = false;
        this.f160973s = new s0(this);
        FrameLayout.inflate(getContext(), getLayoutId(), this);
        if (TextUtils.isEmpty(getFrom()) == false) goto L5;
    L7:
        this.f160955a = (HSImageView) findViewById(R.id.live_operation_label);
        this.f160956b = (HSImageView) findViewById(R.id.live_content_label_left);
        this.f160957c = (HSImageView) findViewById(R.id.live_content_label_right);
        this.f160958d = (TextView) findViewById(R.id.live_nickname);
        this.f160959e = (HSImageView) findViewById(R.id.user_verify_tag);
        this.f160960f = (HSImageView) findViewById(R.id.live_avatar);
        this.f160961g = (ViewGroup) findViewById(R.id.live_avatar_container);
        this.f160962h = (TextView) findViewById(R.id.live_locate);
        this.f160963i = (TextView) findViewById(R.id.live_audience_count);
        this.f160964j = (ViewGroup) findViewById(R.id.live_cover_opt_container);
        this.f160965k = (TextView) findViewById(R.id.live_title);
        this.f160966l = (TextView) findViewById(R.id.live_city_distance);
        this.f160967m = (ViewGroup) findViewById(R.id.live_audience_container);
        this.f160968n = (ViewGroup) findViewById(R.id.live_cover_bottom_container);
        View r103 = findViewById(R.id.cover_mask);
        this.f160971q = r103;
        r103.setVisibility(0);
        return;
    L5:
        if (getFrom().equals("draw") == false) goto L7;
        this.f160970p = true;
        goto L7
    }
}
