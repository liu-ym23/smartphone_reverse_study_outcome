package com.bytedance.android.live.revlink.impl.multianchor.pk;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import gd0.v;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/pk/MultiAnchorLinkInfoTopSelectSubView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorLinkInfoTopSelectSubView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VHeadView f94465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f94466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f94467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f94468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VHeadView f94469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f94470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f94471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.multianchor.service.a f94472h;

    public final void a() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_multi_anchor_link_info_top_select_sub, this, true);
        this.f94465a = (VHeadView) r100.findViewById(R.id.iv_avatar);
        this.f94466b = (TextView) r100.findViewById(R.id.tv_status);
        this.f94467c = (ImageView) r100.findViewById(R.id.iv_living);
        this.f94468d = (TextView) r100.findViewById(R.id.tv_nickname);
        this.f94469e = (VHeadView) r100.findViewById(R.id.iv_close);
        this.f94470f = (ViewGroup) r100.findViewById(R.id.fl_avatar_gender);
        setSelected(true);
    }

    public MultiAnchorLinkInfoTopSelectSubView(Context r100) {
        Intrinsics.checkNotNull(r100);
        super(r100);
        this.f94472h = com.bytedance.android.live.revlink.impl.global.b.t();
        a();
    }

    public MultiAnchorLinkInfoTopSelectSubView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNull(r100);
        super(r100, r101);
        this.f94472h = com.bytedance.android.live.revlink.impl.global.b.t();
        a();
    }

    public final void b(p r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorLinkUser");
        boolean r102 = true;
        if (r100.getStatus() != 1) goto L5;
        boolean r103 = true;
    L6:
        this.f94471g = r103;
        ImageView r104 = this.f94467c;
        Intrinsics.checkNotNull(r104);
        r104.setVisibility(0);
        VHeadView r105 = this.f94465a;
        IBaseUser r106 = r100.getUser();
        Intrinsics.checkNotNull(r106);
        k r107 = r106.getAvatarThumbKt();
        VHeadView r108 = this.f94465a;
        Intrinsics.checkNotNull(r108);
        int r109 = r108.getWidth();
        VHeadView r110 = this.f94465a;
        Intrinsics.checkNotNull(r110);
        a1.x(r105, r107, r109, r110.getHeight(), R.drawable.ttlive_ic_multi_anchor_link_placeholder);
        UIUtils.updateLayout(this.f94470f, r101, r101);
        TextView r111 = this.f94468d;
        if (r111 == null) goto L13;
        IBaseUser r112 = r100.getUser();
        if (r112 == null) goto L11;
        String r113 = r112.getNickName();
    L12:
        r111.setText(r113);
        goto L13
    L11:
        r113 = null;
    L13:
        TextView r114 = this.f94468d;
        Intrinsics.checkNotNull(r114);
        r114.setVisibility(0);
        TextView r115 = this.f94468d;
        if (r115 == null) goto L17;
        r115.setMaxWidth(r101);
    L17:
        if (this.f94471g == false) goto L23;
        TextView r116 = this.f94466b;
        Intrinsics.checkNotNull(r116);
        r116.setVisibility(0);
        TextView r117 = this.f94466b;
        Intrinsics.checkNotNull(r117);
        if (r100.getRoleType() != 4) goto L21;
        int r118 = R.string.ttlive_anchor_link_window_applying;
    L22:
        r117.setText(r118);
    L25:
        if (this.f94471g == true) goto L27;
    L68:
        VHeadView r119 = this.f94469e;
        Intrinsics.checkNotNull(r119);
        r119.setVisibility(8);
    L69:
        VHeadView r120 = this.f94469e;
        Intrinsics.checkNotNull(r120);
        r120.setOnClickListener(new a(this, r100));
        setOnClickListener(new b(this));
        return;
    L27:
        if (com.bytedance.android.live.revlink.impl.global.b.I() == null) goto L31;
        com.bytedance.android.live.revlink.impl.multianchor.match.a r121 = com.bytedance.android.live.revlink.impl.global.b.I();
        Intrinsics.checkNotNull(r121);
        if (r121.Qd() == false) goto L31;
    L65:
        r102 = false;
    L66:
        if (r102 == false) goto L68;
        VHeadView r122 = this.f94469e;
        Intrinsics.checkNotNull(r122);
        r122.setVisibility(0);
    L31:
        com.bytedance.android.live.revlink.impl.service.internal.a r123 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r123 == null) goto L34;
        int r124 = r123.getCurrentMode();
    L36:
        if (v.a(r124, 4) == false) goto L44;
        com.bytedance.android.live.revlink.impl.pk.service.b r125 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r125 == null) goto L40;
        i11.b r126 = r125.getLinkUserCenter();
    L41:
        if (r126 == null) goto L51;
        i11.b r127 = r125.getLinkUserCenter();
        Intrinsics.checkNotNull(r127);
        List<IBaseUser> r128 = r127.getInviteeList();
    L53:
        if (r100.getUser() == null) goto L65;
        if (r128 == null) goto L65;
        Iterator<IBaseUser> r129 = r128.iterator();
    L57:
        if (r129.hasNext() == false) goto L65;
        String r130 = iz.a.a(r129.next());
        IBaseUser r131 = r100.getUser();
        if (r131 == null) goto L61;
        String r132 = r131.getIdString();
    L63:
        if (TextUtils.equals(r130, r132) == false) goto L57;
    L61:
        r132 = null;
    L51:
        r128 = null;
        goto L53
    L40:
        r126 = null;
        goto L41
    L44:
        if (v.a(r124, 64) == false) goto L51;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r133 = this.f94472h;
        if (r133 == null) goto L48;
        i11.b r134 = r133.getLinkUserCenter();
    L49:
        if (r134 == null) goto L51;
        r128 = this.f94472h.getLinkUserCenter().getInviteeList();
        goto L53
    L48:
        r134 = null;
        goto L49
    L34:
        r124 = 0;
        goto L36
    L21:
        r118 = R.string.ttlive_anchor_link_window_inviting;
        goto L22
    L23:
        TextView r135 = this.f94466b;
        Intrinsics.checkNotNull(r135);
        r135.setVisibility(8);
        TextView r136 = this.f94466b;
        Intrinsics.checkNotNull(r136);
        r136.setText("");
        goto L25
    L5:
        r103 = false;
        goto L6
    }

    public MultiAnchorLinkInfoTopSelectSubView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNull(r100);
        super(r100, r101, r102);
        this.f94472h = com.bytedance.android.live.revlink.impl.global.b.t();
        a();
    }
}
