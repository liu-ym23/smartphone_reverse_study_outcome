package com.bytedance.android.live.ktv.common.view.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.message.model.ag;
import com.bytedance.android.livesdk.message.model.od;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/adapter/SoloMvListVh;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class SoloMvListVh extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f70786g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f70787h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f70788i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f70789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f70790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f70791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f70792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f70793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.view.adapter.b f70794f;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoloMvListVh f70795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f70796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f70797c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ od f70798d;

        public b(SoloMvListVh r100, int r101, c r102, od r103) {
            this.f70795a = r100;
            this.f70796b = r101;
            this.f70797c = r102;
            this.f70798d = r103;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SoloMvListVh r101 = this.f70795a;
            if (r101.f70789a != null) goto L11;
            r101.f70794f.c(this.f70796b, this.f70797c);
            View r102 = this.f70795a.f70790b;
            if (r102 == null) goto L7;
            r102.setVisibility(8);
        L7:
            this.f70795a.V3();
            if (this.f70795a.f70794f.b(this.f70798d) == true) goto L12;
            this.f70795a.U3();
            return;
        L12:
            return;
        }
    }

    static {
        s1.f(65.0f);
        f70786g = s1.f(88.0f);
        f70787h = s1.f(10.0f);
        f70788i = s1.f(18.0f);
    }

    public final void U3() {
        if (this.f70793e != null) goto L6;
        LiveDoubleColorBallAnimationView r100 = new LiveDoubleColorBallAnimationView(this.itemView.getContext());
        FrameLayout r101 = this.f70792d;
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams((int) s1.e(20.0f), (int) s1.e(20.0f));
        r102.gravity = 17;
        Unit r103 = Unit.INSTANCE;
        r101.addView(r100, r102);
        r100.b();
        this.f70793e = r100;
        return;
    }

    public final void V3() {
        this.f70794f.d(new SoloMvListVh$showSelected$1(this));
        View r100 = this.f70789a;
        if (r100 != null) goto L5;
        r100 = new View(this.itemView.getContext());
        this.f70789a = r100;
        r100.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r100.setBackgroundResource(R.drawable.preview_mv_selected_bg);
        this.f70792d.addView(r100);
    L5:
        r100.setVisibility(0);
    }

    public SoloMvListVh(View r100, com.bytedance.android.live.ktv.common.view.adapter.b r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "adapterClickCb");
        super(r100);
        this.f70794f = r101;
        View r102 = new View(r100.getContext());
        r102.setBackgroundResource(R.drawable.ttlive_solo_ktv_download_icon);
        int r103 = f70788i;
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(r103, r103);
        r104.gravity = GravityCompat.END;
        r104.leftMargin = s1.f(2.0f);
        r104.topMargin = s1.f(2.0f);
        Unit r105 = Unit.INSTANCE;
        r102.setLayoutParams(r104);
        this.f70790b = r102;
        HSImageView r106 = new HSImageView(r100.getContext());
        this.f70791c = r106;
        FrameLayout r107 = new FrameLayout(r100.getContext());
        r107.addView(r106, new ViewGroup.LayoutParams(-1, -1));
        r107.addView(r102);
        this.f70792d = r107;
    }

    public void T3(c r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        od r103 = r100.f70803a;
        if (r103 != null) goto L5;
        return;
    L5:
        ag r104 = r103.a();
        if (r104 == null) goto L16;
        String r105 = r104.a();
        if (r105 == null) goto L16;
        if ((!TextUtils.isEmpty(r105)) == true) goto L13;
        r105 = null;
    L13:
        if (r105 == null) goto L16;
        this.f70791c.setImageURI(r105);
    L16:
        if (r100.f70804b == false) goto L18;
        V3();
    L24:
        if (this.f70794f.b(r103) == false) goto L32;
        View r106 = this.f70790b;
        if (r106 == null) goto L28;
        r106.setVisibility(8);
    L28:
        LiveDoubleColorBallAnimationView r107 = this.f70793e;
        if (r107 == null) goto L40;
        r107.c();
        this.f70792d.removeView(r107);
    L40:
        this.itemView.setOnClickListener(new b(this, r101, r100, r103));
        return;
    L32:
        if (this.f70794f.a(r103) == false) goto L36;
        U3();
        View r108 = this.f70790b;
        if (r108 == null) goto L40;
        r108.setVisibility(8);
        goto L40
    L36:
        LiveDoubleColorBallAnimationView r109 = this.f70793e;
        if (r109 == null) goto L39;
        r109.c();
        this.f70792d.removeView(r109);
    L39:
        this.f70790b.setVisibility(0);
        goto L40
    L18:
        View r110 = this.f70789a;
        if (r110 == null) goto L24;
        if (r110 == null) goto L22;
        this.f70792d.removeView(r110);
    L22:
        this.f70789a = null;
        goto L24
    }
}
