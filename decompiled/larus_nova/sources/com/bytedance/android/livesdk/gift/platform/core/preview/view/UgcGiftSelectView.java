package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/UgcGiftSelectView;", "Landroid/widget/FrameLayout;", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getSelectView", "()Landroid/widget/TextView;", "setSelectView", "(Landroid/widget/TextView;)V", "selectView", "Landroid/view/View;", ce.f26391f, "Landroid/view/View;", "getBottomBackgroundView", "()Landroid/view/View;", "setBottomBackgroundView", "(Landroid/view/View;)V", "bottomBackgroundView", "Landroid/content/Context;", "mContext", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UgcGiftSelectView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pair<Float, Animator> f131066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Animator f131067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f131068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f131069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f131070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public py.k f131071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f131072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f131073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f131074i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f131075j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f131076k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f131077l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f131078m;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.preview.view.b f131079a;

        public b(com.bytedance.android.livesdk.gift.platform.core.preview.view.b r100) {
            this.f131079a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f131079a.f131084c.invoke();
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f131080a = null;

        static {
            f131080a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    static {
    }

    public UgcGiftSelectView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UgcGiftSelectView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View getBottomBackgroundView() {
        return this.f131072g;
    }

    public final TextView getSelectView() {
        return this.f131070e;
    }

    public final void a(com.bytedance.android.livesdk.gift.platform.core.preview.view.b r100) {
        if (r100 == null) goto L16;
        View r101 = this.f131076k;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
    L6:
        TextView r102 = this.f131070e;
        if (r102 == null) goto L9;
        r102.setText(s1.B(r100.f131083b));
    L9:
        View r103 = this.f131076k;
        if (r103 == null) goto L12;
        r103.setOnClickListener(new b(r100));
    L12:
        View r104 = this.f131072g;
        if (r104 == null) goto L17;
        r104.setBackgroundResource(r100.f131082a);
        return;
    L17:
        return;
    }

    public final void setBottomBackgroundView(View r100) {
        this.f131072g = r100;
    }

    public final void setSelectView(TextView r100) {
        this.f131070e = r100;
    }

    public UgcGiftSelectView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101, r102);
        FrameLayout.inflate(r100, R.layout.ttlive_base_selected_gift_animation_view, this);
        this.f131076k = findViewById(R.id.bottom_container);
        this.f131068c = (HSImageView) findViewById(R.id.gift_image);
        this.f131069d = (TextView) findViewById(R.id.gift_name_tiny_view);
        this.f131070e = (TextView) findViewById(R.id.select_view);
        this.f131072g = findViewById(R.id.bottom_bg);
        this.f131073h = findViewById(R.id.root_view);
        TextView r103 = (TextView) findViewById(R.id.send);
        this.f131075j = findViewById(R.id.loading_view);
        this.f131077l = (TextView) findViewById(R.id.diamond);
        this.f131078m = (TextView) findViewById(R.id.gift_name);
        this.f131074i = findViewById(R.id.top_container);
    }

    public /* synthetic */ UgcGiftSelectView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void b(py.k r100, String r101, String r102, com.bytedance.android.livesdk.gift.platform.core.preview.view.b r103) {
        ImageLoader.bindImage(this.f131068c, r100, s1.j(R.dimen.ttlive_effect_gift_icon_size), s1.j(R.dimen.ttlive_effect_gift_icon_size));
        this.f131071f = r100;
        TextView r104 = this.f131069d;
        if (r104 == null) goto L5;
        r104.setText(r101);
    L5:
        TextView r105 = this.f131078m;
        if (r105 == null) goto L8;
        r105.setText(r101);
    L8:
        TextView r106 = this.f131077l;
        if (r106 == null) goto L11;
        r106.setText(r102);
    L11:
        View r107 = this.f131074i;
        if (r107 == null) goto L14;
        r107.setOnClickListener(c.f131080a);
    L14:
        a(r103);
    }
}
