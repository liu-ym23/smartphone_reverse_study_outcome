package com.bytedance.android.livesdk.admin.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.common.AbsViewHolder;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Map;
import py.k;
import tb1.c;
import td1.d;
import td1.e;
import xs2.b;

/* JADX INFO: loaded from: classes7.dex */
public class AdminListViewHolder extends AbsViewHolder implements wd1.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f103097k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VHeadView f103098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f103099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f103100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f103101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HSImageView f103102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f103103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f103104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ud1.a f103105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f103106i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f103107j;

    public class a extends q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdminListViewHolder f103108a;

        public a(AdminListViewHolder r100) {
            this.f103108a = r100;
        }

        @Override // com.bytedance.android.live.core.utils.q0
        public final void h(k r100, int r101, int r102) {
            ViewGroup.LayoutParams r103 = this.f103108a.f103102e.getLayoutParams();
            int r104 = s1.f(32.0f);
            r103.width = r104;
            r103.height = (r102 * r104) / r101;
            this.f103108a.f103102e.setLayoutParams(r103);
        }
    }

    @Override // wd1.a
    public final void y0(e r100, Exception r101) {
    }

    public final Map<String, String> U3() {
        HashMap r100 = new HashMap();
        r100.put("anchor_id", String.valueOf(this.f103106i));
        r100.put("room_id", String.valueOf(this.f103107j));
        r100.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, String.valueOf(this.f103104g.mUser.getIdStr()));
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.common.AbsViewHolder
    public final <T> void T3(T r100) {
        if ((r100 instanceof d) == false) goto L24;
        d r101 = (d) r100;
        this.f103104g = r101;
        final User r102 = r101.mUser;
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.f103098a != null) goto L10;
    L14:
        this.f103101d.setText(r102.getNickName());
        if (r102.getUserHonor() == null) goto L17;
        ImageModel r103 = (ImageModel) r102.getUserHonor().getNewImIconWithLevel();
    L18:
        if (r103 != null) goto L20;
    L22:
        this.f103102e.setVisibility(8);
        return;
    L20:
        if (CollectionUtils.isEmpty(r103.getUrls()) == true) goto L22;
        ImageUtil.loadImage(this.f103102e, r103, new a(this));
        this.f103102e.setVisibility(0);
        return;
    L17:
        r103 = null;
        goto L18
    L10:
        if (r102.getAvatarThumb() == null) goto L12;
        ImageUtil.loadRoundImage(this.f103098a, r102.getAvatarThumb());
    L13:
        this.f103098a.setOnClickListener(new vd1.a(r102));
        goto L14
    L12:
        this.f103098a.setImageResource(R.drawable.ttlive_ic_default_head_small);
        goto L13
    }

    @Override // wd1.a
    public final void U1(boolean r100, Exception r101) {
        if (r100 == true) goto L5;
        this.f103099b.setVisibility(0);
        this.f103100c.setVisibility(8);
        ExceptionUtils.handleException(this.f103103f, r101);
        return;
    }

    @Override // wd1.a
    public final void y1(boolean r100, User r101) {
        if (r100 == true) goto L7;
        this.f103099b.setVisibility(0);
        this.f103100c.setVisibility(8);
        b.a().post(new sd1.a(r100, r101.getIdStr()));
        if (c.f545229a == true) goto L8;
        f2.b(R.string.ttlive_live_profile_manage_cancel_success, 0);
        return;
    L8:
        return;
    }

    public AdminListViewHolder(Context r100, View r101, String r102, long r103) {
        super(r101);
        this.f103098a = (VHeadView) r101.findViewById(R.id.header_image);
        this.f103099b = (TextView) r101.findViewById(R.id.cancel_btn);
        this.f103100c = r101.findViewById(R.id.cancel_progress);
        this.f103101d = (TextView) r101.findViewById(R.id.user_name);
        this.f103102e = (HSImageView) r101.findViewById(R.id.user_class_medal);
        this.f103099b.setOnClickListener(new vd1.b(this));
        this.f103103f = r100;
        this.f103106i = r102;
        this.f103107j = r103;
        this.f103105h = new ud1.a(this);
    }
}
