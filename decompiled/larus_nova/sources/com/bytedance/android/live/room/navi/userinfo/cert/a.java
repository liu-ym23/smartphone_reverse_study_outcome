package com.bytedance.android.live.room.navi.userinfo.cert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends d<AnchorTabLabel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f99782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f99783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC1525a f99784c;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.navi.userinfo.cert.a$a, reason: collision with other inner class name */
    public interface InterfaceC1525a {
        void a();

        ViewGroup getContainer();

        void onShow();

        void onUnload();
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final void b() {
        this.f99782a = false;
        ViewGroup r100 = this.f99784c.getContainer();
        if (r100 == null) goto L5;
        r100.removeAllViews();
        r100.setVisibility(8);
    L5:
        this.f99784c.onUnload();
    }

    public final void c() {
        ViewGroup r100 = this.f99784c.getContainer();
        if (r100 == null) goto L17;
        this.f99784c.a();
        if (r100.getChildCount() <= 0) goto L7;
        r100.removeAllViews();
    L7:
        r100.setVisibility(8);
        ViewGroup r101 = this.f99784c.getContainer();
        if (r101 == null) goto L12;
        Context r102 = r101.getContext();
        if (r102 == null) goto L12;
        Object r103 = r102.getSystemService("layout_inflater");
    L13:
        if (r103 == null) goto L16;
        View r104 = ((LayoutInflater) r103).inflate(R.layout.ttlive_user_info_poi_view, r100, false);
        this.f99783b = r104;
        r100.addView(r104);
        this.f99782a = false;
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    L12:
        r103 = null;
        goto L13
    }

    public a(com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f99784c = r100;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final /* bridge */ /* synthetic */ void a(AnchorTabLabel r100) {
        d(r100);
    }

    public final void d(AnchorTabLabel r100) {
        Intrinsics.checkNotNullParameter(r100, "tabLabel");
        if (this.f99782a == false) goto L5;
        return;
    L5:
        ViewGroup r101 = this.f99784c.getContainer();
        if (r101 == null) goto L39;
        this.f99782a = true;
        View r102 = this.f99783b;
        TextView r103 = null;
        if (r102 == null) goto L10;
        ImageView r104 = (ImageView) r102.findViewById(R.id.poi_img);
    L11:
        View r105 = this.f99783b;
        if (r105 == null) goto L14;
        r103 = (TextView) r105.findViewById(R.id.poi_txt);
    L14:
        k r106 = r100.getIcon();
        if (r106 == null) goto L26;
        if (r104 == null) goto L25;
        int r107 = r106.getWidth();
        int r108 = 10;
        if (r107 > 0) goto L21;
        r107 = 10;
    L21:
        int r109 = (int) UtilityKotlinExtentionsKt.h(r107);
        int r110 = r106.getHeight();
        if (r110 <= 0) goto L24;
        r108 = r110;
    L24:
        r104.setLayoutParams(new RelativeLayout.LayoutParams(r109, (int) UtilityKotlinExtentionsKt.h(r108)));
    L25:
        ((IHostFrescoHelper) jc1.k.n(IHostFrescoHelper.class)).loadFirstAvailableImageBitmap(r106, new b(this, r104));
    L26:
        String r111 = r100.getContent();
        if (r111 == null) goto L37;
        RelativeLayout.LayoutParams r112 = new RelativeLayout.LayoutParams(-2, -2);
        if (r104 == null) goto L31;
        r112.addRule(1, r104.getId());
        r112.leftMargin = s1.f(2.8f);
    L31:
        if (r103 == null) goto L33;
        r103.setLayoutParams(r112);
    L33:
        if (r103 == null) goto L35;
        r103.setTextSize(1, 8.0f);
    L35:
        if (r103 == null) goto L37;
        r103.setText(r111);
    L37:
        r101.setVisibility(0);
        return;
    L10:
        r104 = null;
        goto L11
    }
}
