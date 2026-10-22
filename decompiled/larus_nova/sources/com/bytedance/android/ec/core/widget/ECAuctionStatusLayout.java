package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000eB\u0019\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/core/widget/ECAuctionStatusLayout;", "Landroid/widget/LinearLayout;", "Lq83/a;", "", "getCountDownText", "", "getCountDownSeconds", "getCurrentMillis", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAuctionStatusLayout extends LinearLayout implements q83.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f45889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f45890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECPromotionAuctionInfo f45891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f45892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f45893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f45894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f45895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f45896h;

    public static final class a {
    }

    static {
    }

    private final long getCountDownSeconds() {
        return (this.f45896h - getCurrentMillis()) / ((long) 1000);
    }

    private final String getCountDownText() {
        long r100 = this.f45896h - getCurrentMillis();
        if (r100 >= 1000) goto L6;
        return null;
    L6:
        if (this.f45892d == false) goto L9;
        return b(r100);
    L9:
        return th.a.h(getContext(), R.string.shopping_live_auction_count_down, new Object[]{b(r100)});
    }

    public final boolean c() {
        if (this.f45891c != null) goto L5;
        return false;
    L5:
        if (getCountDownSeconds() <= 10) goto L7;
        return false;
    L7:
        return true;
    }

    private final long getCurrentMillis() {
        return SystemClock.elapsedRealtime();
    }

    public final void a(ECPromotionAuctionInfo r100) {
        Integer r101 = r100.getStatus();
        String r102 = null;
        if (r101 != null) goto L6;
    L8:
        if (r101 != null) goto L11;
    L13:
        if (r101 != null) goto L16;
    L18:
        if (r101 != null) goto L21;
    L24:
        if (r101 != null) goto L27;
    L23:
        int r103 = 0;
    L30:
        if (r103 == 0) goto L32;
        this.f45889a.setVisibility(0);
        this.f45889a.setImageResource(r103);
    L33:
        if (r102 == null) goto L48;
        this.f45890b.setVisibility(0);
        this.f45890b.setText(r102);
        TextView r104 = this.f45890b;
        if (this.f45892d == true) goto L46;
        Integer r105 = r100.getStatus();
        if (r105 == null) goto L46;
        if (r105.intValue() != 2) goto L46;
        if (c() == false) goto L45;
        int r106 = -52412;
    L47:
        r104.setTextColor(r106);
        return;
    L45:
        r106 = -2146035677;
    L46:
        r106 = -1;
        goto L47
    L48:
        this.f45890b.setVisibility(8);
        return;
    L32:
        this.f45889a.setVisibility(8);
        goto L33
    L27:
        if (r101.intValue() != 4) goto L23;
        r102 = th.a.g(getContext(), R.string.shopping_live_auction_status_fail);
        goto L23
    L21:
        if (r101.intValue() != 6) goto L24;
    L22:
        r102 = th.a.g(getContext(), R.string.shopping_live_auction_status_end);
        goto L23
    L16:
        if (r101.intValue() != 3) goto L18;
    L11:
        if (r101.intValue() != 2) goto L13;
        r102 = getCountDownText();
        r103 = R.drawable.shopping_ic_live_auction_start;
        goto L30
    L6:
        if (r101.intValue() != 1) goto L8;
        r103 = R.drawable.shopping_ic_live_auction_prepare;
        goto L30
    }

    public final String b(long r100) {
        long r101 = r100 / ((long) 1000);
        long r102 = 60;
        long r103 = r101 % r102;
        long r104 = r101 / r102;
        StringBuilder r105 = new StringBuilder();
        long r106 = 10;
        if (r104 >= r106) goto L5;
        String r107 = "0" + r104;
    L6:
        r105.append(r107);
        r105.append(':');
        if (r103 >= r106) goto L9;
        String r108 = "0" + r103;
    L10:
        r105.append(r108);
        return r105.toString();
    L9:
        r108 = String.valueOf(r103);
        goto L10
    L5:
        r107 = String.valueOf(r104);
        goto L6
    }

    public final boolean d(Long r100) {
        if (r100 == null) goto L4;
        long r101 = r100.longValue();
    L5:
        ECPromotionAuctionInfo r102 = this.f45891c;
        if (r102 == null) goto L16;
        int r103 = wl.a.f560165b;
        this.f45896h = wl.a.a(r102.getEndTime());
        Integer r104 = r102.getStatus();
        if (r104 != null) goto L11;
        return false;
    L11:
        if (r104.intValue() == 2) goto L13;
        return false;
    L13:
        if ((this.f45896h - r101) < 1000) goto L19;
        return true;
    L19:
        return false;
    L16:
        return false;
    L4:
        r101 = getCurrentMillis();
        goto L5
    }

    public final boolean e(ECPromotionAuctionInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "auctionInfo");
        Integer r101 = r100.getStatus();
        if (r101 != null) goto L6;
    L10:
        return false;
    L6:
        if (r101.intValue() != 2) goto L10;
        if (r100.getBizId() != 1) goto L10;
        r100.setStatus(6);
        r100.setButtonLabel(th.a.g(getContext(), R.string.shopping_live_auction_pre_end));
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f45890b.getVisibility() != 0) goto L19;
        Paint r101 = this.f45893e;
        if (this.f45889a.getVisibility() != 8) goto L8;
        int r102 = 855638016;
    L17:
        r101.setColor(r102);
        float r103 = UIUtils.dip2Px(getContext(), 8.0f);
        this.f45894f.set(0.0f, 0.0f, getWidth(), getHeight());
        r100.drawRoundRect(this.f45894f, r103, r103, this.f45893e);
        return;
    L8:
        if (this.f45892d == false) goto L14;
        if (c() == false) goto L12;
        r102 = 1476342596;
        goto L17
    L12:
        r102 = 1459617792;
        goto L17
    L14:
        if (c() == false) goto L16;
        r102 = 234491406;
        goto L17
    L16:
        r102 = 135665699;
        goto L17
    }

    @Override // q83.a
    public final boolean onTick(long r100) {
        if (d(Long.valueOf(r100)) == false) goto L17;
        ECPromotionAuctionInfo r101 = this.f45891c;
        if (r101 == null) goto L24;
        a(r101);
        if (getCountDownSeconds() != 10) goto L25;
        HashMap<String, JSONObject> r102 = com.bytedance.android.ec.core.hybrid.utils.j.f44312a;
        JSONObject r103 = com.bytedance.android.ec.core.hybrid.utils.j.d("ecom_auction_toast_timestamp");
        if (r103 == null) goto L11;
        long r104 = JSONObjectProtectorUtils.getLong(r103, "timestamp");
    L13:
        if ((System.currentTimeMillis() - r104) <= 2000) goto L26;
        Toast.makeText(getContext(), th.a.g(getContext(), R.string.shopping_live_auction_toast), 0).show();
        JSONObject r105 = new JSONObject();
        r105.put("timestamp", System.currentTimeMillis());
        Unit r106 = Unit.INSTANCE;
        com.bytedance.android.ec.core.hybrid.utils.j.h("ecom_auction_toast_timestamp", r105);
        return true;
    L26:
        return true;
    L11:
        r104 = 0;
        goto L13
    L25:
        return true;
    L24:
        return true;
    L17:
        ECPromotionAuctionInfo r107 = this.f45891c;
        if (r107 == null) goto L20;
        a(r107);
    L20:
        Function0<Unit> r108 = this.f45895g;
        if (r108 == null) goto L23;
        Unit r109 = r108.invoke();
    L23:
        return false;
    }

    public ECAuctionStatusLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f45893e = new Paint(1);
        this.f45894f = new RectF();
        setOrientation(0);
        setWillNotDraw(false);
        ImageView r102 = new ImageView(r100);
        this.f45889a = r102;
        r102.setAdjustViewBounds(true);
        r102.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        Unit r103 = Unit.INSTANCE;
        addView(r102);
        TextView r104 = new TextView(r100);
        this.f45890b = r104;
        r104.setIncludeFontPadding(false);
        r104.setVisibility(8);
        r104.setGravity(16);
        int r105 = (int) UIUtils.dip2Px(r100, 2.0f);
        r104.setPadding(r105, 0, r105, 0);
        r104.setTextColor(-1);
        r104.setTextSize(1, 10.0f);
        com.bytedance.android.ec.core.utils.c0.b(r104, 500);
        r104.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(r104);
    }
}
