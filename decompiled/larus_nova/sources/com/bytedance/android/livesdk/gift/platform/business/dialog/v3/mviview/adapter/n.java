package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDIYCardItem;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import w20.u7;

/* JADX INFO: loaded from: classes9.dex */
public final class n extends BaseMVIListItem<GiftDIYCardItem, GiftAction> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public py.k f127860l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f127861m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f127862n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HSImageView f127863o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HSImageView f127864p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final HSImageView f127865q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final View f127866r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f127867s;

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
    }

    public n(View r100) {
        Intrinsics.checkNotNullParameter(r100, "inflateView");
        super(r100, new GiftDIYCardItem());
        this.f127860l = (py.k) vh7.f.c(py.k.class);
        this.f127861m = (TextView) this.f41534j.findViewById(R.id.main_text);
        this.f127862n = (TextView) this.f41534j.findViewById(R.id.sub_text);
        this.f127863o = (HSImageView) this.f41534j.findViewById(R.id.diy_icon);
        this.f127864p = (HSImageView) this.f41534j.findViewById(R.id.selected_view);
        this.f127865q = (HSImageView) this.f41534j.findViewById(R.id.diy_lock_icon);
        this.f127866r = this.f41534j.findViewById(R.id.remind_dot);
        this.f127867s = (TextView) this.f41534j.findViewById(R.id.card_time_text);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r110, MVIState r111) {
        GiftDIYCardItem r112 = (GiftDIYCardItem) r111;
        Intrinsics.checkNotNullParameter(r110, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r112, "state");
        r0<GiftDIYCardItem, py.k> r100 = r112.getGiftIcon();
        Object r101 = r110.f41740c.a(r100);
        if (r101 == null) goto L5;
        r110.f41739b.f41563a.invoke(r100);
        this.f127860l = (py.k) r101;
    L5:
        r0<GiftDIYCardItem, com.bytedance.android.livesdk.gift.model.n> r102 = r112.getDiyCardInfo();
        Object r103 = r110.f41740c.a(r102);
        boolean r104 = true;
        if (r103 == null) goto L97;
        r110.f41739b.f41563a.invoke(r102);
        com.bytedance.android.livesdk.gift.model.n r105 = (com.bytedance.android.livesdk.gift.model.n) r103;
        String r106 = r105.getMainText();
        Bitmap r107 = null;
        if (r106 != null) goto L10;
    L15:
        String r108 = r105.getSubText();
        if (r108 != null) goto L18;
    L23:
        CardLockInfo r109 = r105.getLockInfo();
        if (r109 == null) goto L26;
        Integer r113 = Integer.valueOf(r109.getLockStatus());
    L27:
        if (r113 == null) goto L37;
        CardLockInfo r114 = r105.getLockInfo();
        if (r114 != null) goto L31;
    L32:
        CardLockInfo r115 = r105.getLockInfo();
        if (r115 != null) goto L35;
    L36:
        this.f127863o.setAlpha(0.3f);
        ViewUtilsKt.f(this.f127865q);
    L39:
        if ((r105 instanceof sz1.a) == false) goto L93;
        if (TextUtils.isEmpty(((sz1.a) r105).getLocalIconBitmap()) == true) goto L93;
        byte[] r116 = Base64.decode(((sz1.a) r105).getLocalIconBitmap(), 0);     // Catch: Exception -> L91
        Bitmap r117 = BitmapFactory.decodeByteArray(r116, 0, r116.length);     // Catch: Exception -> L91
        u7.b r118 = ((sz1.a) r105).getGiftToolbarFrame();     // Catch: Exception -> L91
        if (r118 == null) goto L85;
        Float r119 = r118.c();     // Catch: Exception -> L91
        if (r119 == null) goto L47;
        int r120 = (int) r119.floatValue();     // Catch: Exception -> L91
    L48:
        if (r120 < 0) goto L53;
        Float r121 = r118.c();     // Catch: Exception -> L91
        if (r121 == null) goto L53;
        int r122 = (int) r121.floatValue();     // Catch: Exception -> L91
    L54:
        Float r123 = r118.d();     // Catch: Exception -> L91
        if (r123 == null) goto L57;
        int r124 = (int) r123.floatValue();     // Catch: Exception -> L91
    L58:
        if (r124 < 0) goto L63;
        Float r125 = r118.d();     // Catch: Exception -> L91
        if (r125 == null) goto L63;
        int r126 = (int) r125.floatValue();     // Catch: Exception -> L91
    L64:
        Float r127 = r118.b();     // Catch: Exception -> L91
        if (r127 == null) goto L67;
        int r128 = (int) r127.floatValue();     // Catch: Exception -> L91
    L69:
        if ((r128 + r122) > r117.getWidth()) goto L85;
        Float r129 = r118.a();     // Catch: Exception -> L91
        if (r129 == null) goto L73;
        int r130 = (int) r129.floatValue();     // Catch: Exception -> L91
    L75:
        if ((r130 + r126) > r117.getHeight()) goto L85;
        Float r131 = r118.b();     // Catch: Exception -> L91
        if (r131 == null) goto L79;
        int r132 = (int) r131.floatValue();     // Catch: Exception -> L91
    L80:
        Float r133 = r118.a();     // Catch: Exception -> L91
        if (r133 == null) goto L83;
        int r134 = (int) r133.floatValue();     // Catch: Exception -> L91
    L84:
        r107 = Bitmap.createBitmap(r117, r122, r126, r132, r134, null, false);     // Catch: Exception -> L91
        goto L85
    L83:
        r134 = 0;
        goto L84
    L79:
        r132 = 0;
        goto L80
    L73:
        r130 = 0;
        goto L75
    L67:
        r128 = 0;
    L63:
        r126 = 0;
        goto L64
    L57:
        r124 = 0;
    L53:
        r122 = 0;
        goto L54
    L47:
        r120 = 0;
    L85:
        HSImageView r135 = this.f127863o;     // Catch: Exception -> L91
        if (r107 == null) goto L89;
        r117 = r107;
    L89:
        r135.setImageBitmap(r117);     // Catch: Exception -> L91
    L96:
        this.f41534j.setOnClickListener(new m(this));
    L91:
        ImageLoader.bindImage(this.f127863o, this.f127860l);
    L93:
        if (r105.getIconImg() == null) goto L95;
        ImageLoader.bindImage(this.f127863o, r105.getIconImg());
        goto L96
    L95:
        ImageLoader.bindImage(this.f127863o, this.f127860l);
        goto L96
    L35:
        if (r115.getLockStatus() == CardLockInfo.Companion.LockStatus.UNLOCKED.getV()) goto L37;
    L31:
        if (r114.getLockStatus() != CardLockInfo.Companion.LockStatus.UNKNOWN.getV()) goto L32;
    L37:
        this.f127863o.setAlpha(1.0f);
        ViewUtilsKt.e(this.f127865q);
        goto L39
    L26:
        r113 = null;
        goto L27
    L18:
        if ((!TextUtils.isEmpty(r108)) == true) goto L21;
        r108 = null;
    L21:
        if (r108 == null) goto L23;
        this.f127862n.setText(r108);
        goto L23
    L10:
        if ((!TextUtils.isEmpty(r106)) == true) goto L13;
        r106 = null;
    L13:
        if (r106 == null) goto L15;
        this.f127861m.setText(r106);
    L97:
        r0<GiftDIYCardItem, Boolean> r136 = r112.getSelected();
        Object r137 = r110.f41740c.a(r136);
        if (r137 == null) goto L103;
        r110.f41739b.f41563a.invoke(r136);
        if (((Boolean) r137).booleanValue() == false) goto L102;
        ViewUtilsKt.f(this.f127864p);
        goto L103
    L102:
        ViewUtilsKt.e(this.f127864p);
    L103:
        r0<GiftDIYCardItem, Boolean> r138 = r112.getShowRemindDot();
        Object r139 = r110.f41740c.a(r138);
        if (r139 == null) goto L109;
        r110.f41739b.f41563a.invoke(r138);
        if (((Boolean) r139).booleanValue() == false) goto L108;
        ViewUtilsKt.f(this.f127866r);
        goto L109
    L108:
        ViewUtilsKt.e(this.f127866r);
    L109:
        r0<GiftDIYCardItem, String> r140 = r112.getExpireTime();
        Object r141 = r110.f41740c.a(r140);
        if (r141 == null) goto L121;
        r110.f41739b.f41563a.invoke(r140);
        String r142 = (String) r141;
        if (r142.length() > 0) goto L115;
        r104 = false;
    L115:
        if (r104 == false) goto L117;
        ViewUtilsKt.f(this.f127867s);
        this.f127867s.setText(r142);
        return;
    L117:
        ViewUtilsKt.e(this.f127867s);
        return;
    }
}
