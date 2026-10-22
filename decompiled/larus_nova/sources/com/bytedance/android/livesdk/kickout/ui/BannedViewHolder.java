package com.bytedance.android.livesdk.kickout.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bd2.a;
import bd2.b;
import bf1.e;
import bf1.f;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.larus.nova.R;
import dd2.c;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class BannedViewHolder extends RecyclerView.ViewHolder implements b, f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f142271n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VHeadView f142272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f142273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f142274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f142275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HSImageView f142276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f142277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<User> f142278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f142279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f142280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f142281j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public User f142282k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f142283l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f142284m;

    @Override // bd2.b
    public final void H3(c r100, Exception r101) {
    }

    @Override // bf1.f
    public final void N1(Exception r100) {
    }

    @Override // bd2.b
    public final void hideLoading() {
    }

    @Override // bd2.b
    public final void C2(boolean r100) {
        if (r100 == true) goto L5;
        this.f142273b.setVisibility(0);
        this.f142274c.setVisibility(8);
        xs2.b.a().post(new cd2.b(false, this.f142282k.getIdStr()));
        f2.b(R.string.ttlive_live_profile_manage_cancel_success, 0);
        return;
    }

    @Override // bf1.f
    public final void v3(boolean r100) {
        if (r100 == true) goto L7;
        xs2.b.a().post(new cd2.a(this.f142282k.getIdStr()));
        this.f142273b.setVisibility(0);
        this.f142274c.setVisibility(8);
        if (tb1.c.f545229a == true) goto L8;
        f2.b(R.string.ttlive_live_profile_manage_cancel_success, 0);
        return;
    L8:
        return;
    }

    @Override // bd2.b
    public final void x3(boolean r100, Exception r101) {
        if (r100 == true) goto L5;
        this.f142273b.setVisibility(0);
        this.f142274c.setVisibility(8);
        ExceptionUtils.handleException(this.f142277f, r101);
        return;
    }

    public BannedViewHolder(Context r100, View r101, String r102, long r103, String r104) {
        super(r101);
        this.f142278g = new ArrayList();
        this.f142272a = (VHeadView) r101.findViewById(R.id.header_image);
        this.f142273b = (TextView) r101.findViewById(R.id.cancel_btn);
        this.f142274c = r101.findViewById(R.id.cancel_progress);
        this.f142275d = (TextView) r101.findViewById(R.id.user_name);
        this.f142276e = (HSImageView) r101.findViewById(R.id.user_class_medal);
        this.f142277f = r100;
        this.f142279h = r102;
        this.f142283l = r103;
        this.f142284m = r104;
        a r105 = new a();
        this.f142280i = r105;
        r105.f18643a = this;
        e r106 = new e();
        this.f142281j = r106;
        r106.f18815a = this;
    }
}
