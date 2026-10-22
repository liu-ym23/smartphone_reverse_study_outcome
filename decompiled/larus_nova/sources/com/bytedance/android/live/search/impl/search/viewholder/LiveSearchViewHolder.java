package com.bytedance.android.live.search.impl.search.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.FormatUtils;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.search.impl.search.b;
import com.bytedance.android.livesdk.config.uj;
import com.bytedance.android.livesdk.utils.p1;
import com.bytedance.android.livesdk.widget.LiveCoverOptView;
import com.bytedance.android.livesdkapi.depend.model.live.LiveHashTagInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import j40.b4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import qa1.e;
import sa1.d;
import sa1.f;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/viewholder/LiveSearchViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchViewHolder extends BaseViewHolder<Room> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f100822t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f100823u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f100824v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f100825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f100826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f100827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f100828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f100829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f100830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f100831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f100832h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f100833i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Room f100834j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f100835k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public e f100836l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f100837m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f100838n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f100839o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LiveCoverOptView f100840p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f100841q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d f100842r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ViewGroup f100843s;

    public static final class a {
    }

    static {
        f100822t = -1;
        f100823u = -1;
        f100824v = -1;
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void unbind() {
        super.unbind();
        d r100 = this.f100842r;
        if (r100 == null) goto L7;
        ViewGroup r101 = this.f100843s;
        if (r101 == null) goto L7;
        r101.removeOnLayoutChangeListener(r100);
    L7:
        this.f100842r = null;
    }

    public LiveSearchViewHolder(View r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "parent");
        super(r100);
        this.f100843s = r101;
        this.f100825a = (TextView) r100.findViewById(R.id.title);
        this.f100826b = (HSImageView) r100.findViewById(R.id.live_cover);
        this.f100827c = (HSImageView) r100.findViewById(R.id.live_room_label);
        this.f100828d = (TextView) r100.findViewById(R.id.audience_count);
        this.f100829e = r100.findViewById(R.id.iv_locate);
        this.f100830f = (TextView) r100.findViewById(R.id.locate);
        this.f100831g = (ImageView) r100.findViewById(R.id.live_type);
        this.f100832h = r100.findViewById(R.id.live_state_ic);
        this.f100833i = (TextView) r100.findViewById(R.id.live_state);
        s1.B(R.string.ttlive_search_feed_mars);
        this.f100838n = s1.j(R.dimen.ttlive_search_result_container_width);
        this.f100839o = r100.findViewById(R.id.content_container);
        this.f100840p = (LiveCoverOptView) r100.findViewById(R.id.live_cover_opt_view);
    }

    public final void T3(Room r110, int r111) {
        this.f100834j = r110;
        this.f100835k = r111;
        String r112 = null;
        if (r110 != null) goto L5;
        this.itemView.setOnLongClickListener(null);
        return;
    L5:
        if (b4.a() == true) goto L7;
        ViewGroup.LayoutParams r100 = this.itemView.getLayoutParams();
        int r101 = this.f100838n;
        r100.width = r101;
        r100.height = (r101 * 200) / 164;
        this.itemView.setLayoutParams(r100);
    L7:
        View r102 = this.f100832h;
        if (r102 == null) goto L10;
        r102.setVisibility(0);
    L10:
        View r103 = this.f100829e;
        if (r103 == null) goto L13;
        r103.setVisibility(8);
    L13:
        this.f100831g.setVisibility(8);
        User r104 = r110.mo8271getOwner();
        LiveHashTagInfo r105 = r110.getLiveHashTagInfo();
        if (TextUtils.isEmpty(r110.getTitle()) == false) goto L34;
        uj r106 = uj.f121379a;
        if (r106.getValue() != null) goto L18;
    L20:
        boolean r107 = false;
    L21:
        String r108 = "";
        if (r107 == false) goto L28;
        if (r105 == null) goto L25;
        this.f100825a.setText(r105.name);
    L38:
        if (r110.isMediaRoom() == false) goto L50;
        TextView r109 = this.f100830f;
        if (r109 == null) goto L42;
        r109.setVisibility(8);
    L42:
        User r113 = r110.mo8271getOwner();
        if (r113 == null) goto L50;
        if (TextUtils.isEmpty(r113.getRealNickName()) == true) goto L50;
        TextView r114 = this.f100825a;
        if (r114 == null) goto L49;
        r114.setVisibility(0);
    L49:
        this.f100825a.setText(r113.getRealNickName());
    L50:
        k r115 = r110.getCover();
        if (r115 != null) goto L53;
    L61:
        this.f100826b.setImageResource(R.drawable.ttlive_cover_err);
        if ((r115 instanceof ImageModel) == true) goto L64;
        r115 = null;
    L64:
        ImageModel r116 = (ImageModel) r115;
        if (r116 != null) goto L67;
        U3(0, 0);
    L68:
        ImageModel r117 = r110.getFeedRoomLabel();
        if (r117 != null) goto L71;
    L74:
        this.f100827c.setVisibility(8);
    L75:
        Room r118 = this.f100834j;
        if (r118 == null) goto L89;
        TextView r119 = this.f100833i;
        long r120 = 4;
        if (r118.getStatus() != r120) goto L81;
        String r121 = s1.B(R.string.ttlive_search_finished);
    L82:
        r119.setText(r121);
        if (r118.getStatus() != r120) goto L85;
        this.f100828d.setVisibility(4);
        goto L89
    L85:
        this.f100828d.setText(p1.a(r118));
        if (p1.c(r118) == false) goto L88;
        this.f100828d.setVisibility(8);
        goto L89
    L88:
        this.f100828d.setVisibility(0);
        goto L89
    L81:
        r121 = s1.B(R.string.ttlive_search_feed_on_live);
    L89:
        if (r104 == null) goto L92;
        r112 = r104.getCity();
    L92:
        if (StringUtils.isEmpty(r112) == false) goto L96;
        this.f100830f.setVisibility(8);
        View r122 = this.f100829e;
        if (r122 == null) goto L97;
        r122.setVisibility(8);
    L97:
        UIUtils.setViewVisibility(this.f100827c, 8);
        UIUtils.setViewVisibility(this.f100839o, 8);
        this.f100840p.setVisibility(0);
        this.f100840p.c(r110);
        this.itemView.setOnClickListener(new f(this, r110));
        return;
    L96:
        this.f100830f.setText(r112);
        this.f100830f.setVisibility(0);
        goto L97
    L71:
        if (Lists.isEmpty(r117.getUrls()) == true) goto L74;
        this.f100827c.setVisibility(0);
        ImageLoader.bindImageWithAnimation(this.f100827c, r117, new sa1.e(this), r117.isAnimated());
        goto L75
    L67:
        U3(r116.width, r116.height);
        goto L68
    L53:
        if (Lists.isEmpty(r115.getUrls()) == true) goto L61;
        ImageModel r123 = (ImageModel) r115;
        ImageLoader.d r124 = ImageLoader.load(r123);
        r124.f66062g = true;
        r124.f66061f = false;
        r124.a(this.f100826b);
        if (b4.a() == false) goto L68;
        d r125 = new d(this, r123);
        ViewGroup r126 = this.f100843s;
        if (r126 == null) goto L60;
        r126.addOnLayoutChangeListener(r125);
    L60:
        Unit r127 = Unit.INSTANCE;
        this.f100842r = r125;
        goto L68
    L25:
        if (r104 == null) goto L27;
        this.f100825a.setText(r104.getRealNickName());
        goto L38
    L27:
        this.f100825a.setText("");
        goto L38
    L28:
        TextView r128 = this.f100825a;
        if (r104 == null) goto L33;
        String r129 = r104.getRealNickName();
        if (r129 == null) goto L33;
        r108 = r129;
    L33:
        r128.setText(r108);
        goto L38
    L18:
        if (r106.getValue().showChallenge == false) goto L20;
        r107 = true;
        goto L21
    L34:
        if (r105 == null) goto L36;
        this.f100825a.setText(FormatUtils.format("%s#%s", new Object[]{r110.getTitle(), r105.name}));
        goto L38
    L36:
        this.f100825a.setText(r110.getTitle());
        goto L38
    }

    public final void U3(int r100, int r101) {
        if (this.f100841q == false) goto L5;
        int r102 = f100823u;
    L6:
        f100822t = r102;
        if (r102 > 0) goto L10;
        f100822t = (this.f100843s.getMeasuredWidth() - 3) / 2;
    L10:
        if (this.f100841q == false) goto L12;
        f100823u = f100822t;
    L13:
        if (r100 <= 0) goto L17;
        if (r101 <= 0) goto L17;
        int r103 = (f100822t * r101) / r100;
    L18:
        ViewGroup.LayoutParams r104 = this.f100826b.getLayoutParams();
        int r105 = r104.width;
        int r106 = f100822t;
        if (r105 == r106) goto L21;
    L23:
        r104.width = r106;
        r104.height = r103;
        this.f100826b.setLayoutParams(r104);
        return;
    L21:
        if (r104.height != r103) goto L23;
        return;
    L17:
        r103 = f100822t;
        goto L18
    L12:
        f100824v = f100822t;
        goto L13
    L5:
        r102 = f100824v;
        goto L6
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final /* bridge */ /* synthetic */ void bind(Room r100, int r101) {
        T3(r100, r101);
    }
}
