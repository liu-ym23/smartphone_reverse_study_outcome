package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.s;
import com.bytedance.android.livesdk.gift.util.b;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.GiftListViewModelNew;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import py.k;
import qz1.t;
import vh7.f;

/* JADX INFO: loaded from: classes9.dex */
public class SimpleGiftViewHolder extends BaseLiveGiftViewHolder<AbsPanel<?>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AbsPanel f126733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f126734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f126735d;

    public class a implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsPanel f126736a;

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void d(ImageInfo r100) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void e(k r100) {
        }

        public a(AbsPanel r100) {
            this.f126736a = r100;
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void b(k r100, Exception r101) {
            AbsPanel r102 = this.f126736a;
            if (r102.f126613a != 1) goto L6;
            c0.c(r102.c(), r100.getUri(), r100.getUrls(), r101.getMessage());
            return;
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void c(k r100, int r101, int r102, boolean r103) {
            GiftContext r104 = b.b();
            if (r104 != null) goto L5;
            return;
        L5:
            if (r104.getFirstGiftImageRenderSucAt().getValue().longValue() != 0) goto L9;
            r104.getFirstGiftImageRenderSucAt().setValue(Long.valueOf(System.currentTimeMillis()));
            return;
        }
    }

    public final List<Integer> U3() {
        AbsPanel r100 = this.f126733b;
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList<e3> r101 = r100.f126614b;
        if (r101 != null) goto L8;
    L17:
        return null;
    L8:
        if (r101.size() == 0) goto L17;
        ArrayList r102 = new ArrayList();
        Iterator<e3> r103 = this.f126733b.f126614b.iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        if ((r103.next() instanceof e3) == false) goto L12;
        r102.add(0);
        goto L12
    L16:
        return r102;
    }

    public SimpleGiftViewHolder(View r100) {
        super(r100);
        this.f126734c = (HSImageView) r100.findViewById(R.id.gift_image);
        this.f126735d = (TextView) r100.findViewById(R.id.gift_name);
        r100.setOnClickListener(new t(this));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.BaseLiveGiftViewHolder
    public void T3(AbsPanel r100) {
        this.f126733b = r100;
        HSImageView r101 = this.f126734c;
        if (r101 == null) goto L9;
        GenericDraweeHierarchy r102 = r101.getHierarchy();
        int r103 = ((Integer) b.a().c(GiftConfigKey.KEY_GIFT_DEFAULT_ICON, Integer.valueOf(R.drawable.ttlive_ic_default_gift))).intValue();
        r102.setPlaceholderImage(r103);
        r102.setFailureImage(r103);
        if (r100.g() == null) goto L7;
        k r104 = r100.g();
    L8:
        ImageLoader.bindImage(this.f126734c, r104, s1.j(R.dimen.ttlive_gift_panel_icon_size), s1.j(R.dimen.ttlive_gift_panel_icon_size), new a(r100));
        goto L9
    L7:
        r104 = r100.d();
    L9:
        TextView r105 = this.f126735d;
        if (r105 == null) goto L13;
        r105.setText(r100.f());
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.BaseLiveGiftViewHolder, android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r110) {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.t.b() == true) goto L37;
        GiftListViewModelNew r111 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.l();
        if (r111 == null) goto L7;
        GiftStateMachineConfig.e r112 = r111.f132383j.b();
    L9:
        if ((r112 instanceof GiftStateMachineConfig.e.b) == false) goto L38;
        AbsPanel r113 = this.f126733b;
        if (r113 == null) goto L39;
        T r114 = r113.f126620h;
        boolean r100 = true;
        if ((r114 instanceof h1) == false) goto L21;
        h1 r115 = (h1) r114;
        if (r115.getGiftPreviewInfo() != null) goto L17;
    L19:
        boolean r116 = false;
    L20:
        boolean r117 = r116;
    L22:
        IBaseUser r118 = (IBaseUser) f.c(IBaseUser.class);
        if (s.c() != null) goto L25;
    L27:
        IBaseUser r119 = r118;
        T r120 = this.f126733b.f126620h;
        if ((r120 instanceof h1) == true) goto L30;
        boolean r121 = false;
    L35:
        long r101 = this.f126733b.c();
        boolean r102 = this.f126733b.f126620h instanceof h1;
        int r103 = getLayoutPosition();
        AbsPanel r122 = this.f126733b;
        h.Z(r101, r102, r103, false, r122.f126618f, r122.f126615c, r122.f126614b, r117, r119, r121);
        return;
    L30:
        if (((h1) r120).getBizType() == 2) goto L33;
        r100 = false;
    L33:
        r121 = r100;
        goto L35
    L25:
        if (s.c().f128462a == null) goto L27;
        r118 = s.c().f128462a;
        goto L27
    L17:
        if (r115.getGiftPreviewInfo().getLockStatus() != k0.UNLOCKED) goto L19;
        r116 = true;
        goto L20
    L21:
        r117 = false;
        goto L22
    L39:
        return;
    L38:
        return;
    L7:
        r112 = null;
        goto L9
    }
}
