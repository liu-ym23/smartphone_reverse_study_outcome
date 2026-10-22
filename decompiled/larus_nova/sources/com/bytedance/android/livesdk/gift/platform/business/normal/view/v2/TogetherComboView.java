package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/TogetherComboView;", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/NormalGiftCombViewV2;", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/model/NormalGiftMessage;", "msg", "", "setDuration", "Luu0/b;", "H0", "Luu0/b;", "getPreviewData", "()Luu0/b;", "previewData", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TogetherComboView extends NormalGiftCombViewV2 {
    public final uu0.b H0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Map<Integer, View> f129888k0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final boolean f129889p0;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TogetherComboView f129890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NormalGiftMessage f129891b;

        public a(TogetherComboView r100, NormalGiftMessage r101) {
            this.f129890a = r100;
            this.f129891b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            s02.c r101 = this.f129890a.getClickListener();
            if (r101 == null) goto L9;
            NormalGiftMessage r102 = this.f129891b;
            String r103 = ((com.bytedance.android.livesdk.gift.platform.business.tray.l) r102).T;
            if (r103 != null) goto L7;
            r103 = "";
        L7:
            r101.d(r103, r102);
            return;
        }
    }

    public TogetherComboView(Context r100) {
        this(r100, null, 0, false, 30);
    }

    public TogetherComboView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, false, 28);
    }

    public TogetherComboView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, false, 24);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2, uu0.a
    public uu0.b getPreviewData() {
        return this.H0;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2
    public final void C(NormalGiftMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if ((r100 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == true) goto L6;
        super.C(r100);
        return;
    L6:
        D(((com.bytedance.android.livesdk.gift.platform.business.tray.l) r100).f129785o, true, new NormalGiftCombViewV2$bindNormalIconImage$1(this));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2
    public final void E(NormalGiftMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if ((r100 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == false) goto L19;
        com.bytedance.android.livesdk.gift.platform.business.tray.l r101 = (com.bytedance.android.livesdk.gift.platform.business.tray.l) r100;
        py.k r102 = r101.Z;
        if (r102 == null) goto L19;
        if (Lists.isEmpty(r102.getUrls()) == true) goto L19;
        py.k r103 = r101.Z;
        if (r103 == null) goto L13;
        List<String> r104 = r103.getUrls();
        if (r104 == null) goto L13;
        String r105 = (String) ListProtector.get(r104, 0);
    L15:
        if (TextUtils.isEmpty(r105) == true) goto L19;
        x((ImageView) o(R.id.normal_gift_bg_view), r101.Z, false);
        return;
    L13:
        r105 = null;
    L19:
        super.E(r100);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2
    public final void F(NormalGiftMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if ((r100 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == true) goto L6;
        super.F(r100);
        return;
    L6:
        LinearLayout r101 = (LinearLayout) o(R.id.group_body);
        if (r101 == null) goto L9;
        r101.setVisibility(8);
    L9:
        LinearLayout r102 = (LinearLayout) o(R.id.combo_body);
        if (r102 == null) goto L12;
        r102.setVisibility(0);
    L12:
        TextView r103 = (TextView) o(R.id.combo_count);
        if (r103 == null) goto L16;
        r103.setText(String.valueOf(((com.bytedance.android.livesdk.gift.platform.business.tray.l) r100).Y));
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2
    public final void G(NormalGiftMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if ((r100 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == true) goto L6;
        super.G(r100);
        return;
    L6:
        TextView r101 = (TextView) o(R.id.user_name_tv);
        if (r101 == null) goto L9;
        r101.setText(((com.bytedance.android.livesdk.gift.platform.business.tray.l) r100).V);
    L9:
        TextView r102 = (TextView) o(R.id.gift_description_tv);
        if (r102 == null) goto L12;
        r102.setText(((com.bytedance.android.livesdk.gift.platform.business.tray.l) r100).W);
    L12:
        u();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2
    public final void H(NormalGiftMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if ((r100 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == true) goto L6;
        super.H(r100);
        return;
    L6:
        HSImageView r101 = (HSImageView) o(R.id.iv_avatar_border);
        if (r101 == null) goto L9;
        r101.setVisibility(8);
    L9:
        HSImageView r102 = (HSImageView) o(R.id.user_avatar_decor_iv);
        if (r102 == null) goto L12;
        r102.setVisibility(8);
    L12:
        com.bytedance.android.livesdk.gift.platform.business.tray.l r103 = (com.bytedance.android.livesdk.gift.platform.business.tray.l) r100;
        if (r103.U == null) goto L15;
        boolean r104 = true;
    L17:
        if (r104 == false) goto L35;
        ImageView r105 = (ImageView) o(R.id.user_avatar_iv);
        if (r105 == null) goto L21;
        r105.setVisibility(4);
    L21:
        ConstraintLayout r106 = (ConstraintLayout) o(R.id.multi_user_avatar_container);
        if (r106 == null) goto L24;
        r106.setVisibility(0);
    L24:
        py.k r107 = r103.S;
        if (r107 == null) goto L27;
        x((ImageView) o(R.id.multi_user_avatar_top), r107, true);
    L27:
        py.k r108 = r103.U;
        if (r108 == null) goto L31;
        ImageView r109 = (ImageView) o(R.id.multi_user_avatar_bottom);
        a1.k(r108).compose(RxUtil.rxSchedulerHelper()).subscribe(new k(this, r109));
    L31:
        if (this.f129889p0 == true) goto L45;
        ConstraintLayout r110 = (ConstraintLayout) o(R.id.multi_user_avatar_container);
        if (r110 == null) goto L46;
        r110.setOnClickListener(new a(this, r100));
        return;
    L46:
        return;
    L45:
        return;
    L35:
        ImageView r111 = (ImageView) o(R.id.user_avatar_iv);
        if (r111 == null) goto L38;
        r111.setVisibility(0);
    L38:
        ConstraintLayout r112 = (ConstraintLayout) o(R.id.multi_user_avatar_container);
        if (r112 == null) goto L41;
        r112.setVisibility(8);
    L41:
        py.k r113 = r103.S;
        if (r113 == null) goto L48;
        x((ImageView) o(R.id.user_avatar_iv), r113, true);
        return;
    L48:
        return;
    L15:
        r104 = false;
        goto L17
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2
    public final View o(int r100) {
        if (this.f129888k0 != null) goto L5;
        this.f129888k0 = new LinkedHashMap();
    L5:
        View r101 = this.f129888k0.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f129888k0.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2
    public void setDuration(NormalGiftMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if ((r100 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == true) goto L6;
        super.setDuration(r100);
        return;
    L6:
        setDuration(((com.bytedance.android.livesdk.gift.platform.business.tray.l) r100).X);
    }

    public TogetherComboView(Context r100, AttributeSet r101, int r102, boolean r110, int r111) {
        if ((r111 & 2) == 0) goto L5;
        r101 = null;
    L5:
        AttributeSet r103 = r101;
        if ((r111 & 4) == 0) goto L8;
        int r104 = 0;
    L10:
        if ((r111 & 8) == 0) goto L12;
        r110 = false;
    L12:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r103, r104, r110, null);
        this.f129889p0 = r110;
        this.H0 = null;
        this.f129888k0 = new LinkedHashMap();
        return;
    L8:
        r104 = r102;
        goto L10
    }
}
