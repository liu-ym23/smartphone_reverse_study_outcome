package com.bytedance.android.livesdk.gift.biggift.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.q3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.scope.m;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import i12.o;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import mz0.i;
import mz0.n;
import yz0.k;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0014\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/biggift/view/CustomGiftHintDialog;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/gift/model/q3;", "info", "", "setData", "Lcom/bytedance/android/livesdk/gift/biggift/view/CustomGiftHintDialog$a;", ce.f26391f, "Lcom/bytedance/android/livesdk/gift/biggift/view/CustomGiftHintDialog$a;", "getOnCustomGiftDialogListener", "()Lcom/bytedance/android/livesdk/gift/biggift/view/CustomGiftHintDialog$a;", "setOnCustomGiftDialogListener", "(Lcom/bytedance/android/livesdk/gift/biggift/view/CustomGiftHintDialog$a;)V", "onCustomGiftDialogListener", "Lyz0/k;", "getRoomDataService", "()Lyz0/k;", "roomDataService", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomGiftHintDialog extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f125957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f125958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f125959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f125960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f125961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f125962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f125963g;

    public interface a {
        void a();

        void b();
    }

    private final k getRoomDataService() {
        return (k) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), k.class);
    }

    public final a getOnCustomGiftDialogListener() {
        return this.f125963g;
    }

    public CustomGiftHintDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        b(r100);
    }

    public final void b(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.ttlive_custom_gift_hint_dialog, this);
        this.f125957a = (TextView) findViewById(R.id.custom_gift_hint_dialog_hint);
        this.f125958b = (TextView) findViewById(R.id.custom_gift_hint_dialog_buy);
        this.f125959c = findViewById(R.id.custom_gift_hint_dialog_continue_send_layout);
        this.f125960d = (TextView) findViewById(R.id.custom_gift_hint_dialog_continue_send_price);
        this.f125961e = findViewById(R.id.custom_gift_hint_dialog_close);
    }

    public final void setData(q3 r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        i12.e r101 = o.b();
        if (r101 == null) goto L5;
        Object r102 = m.f163449e.d(r101, GiftExtraRepo.class);
    L6:
        GiftExtraRepo r103 = (GiftExtraRepo) r102;
        if (r103 == null) goto L11;
        Long r104 = r103.s(r100.getRelatedGiftId());
        if (r104 == null) goto L11;
        long r105 = r104.longValue();
    L12:
        long r106 = r100.getRelatedGiftId();
        h2 r107 = GiftManagerKt.l(r105);
        h2 r108 = GiftManagerKt.l(r106);
        if (r107 == null) goto L36;
        if (r108 == null) goto L36;
        ViewUtilsKt.f(this);
        this.f125962f = r108.getId();
        String r109 = getContext().getString(R.string.ttlive_custom_gift_dialog_hint);
        StringCompanionObject r110 = StringCompanionObject.INSTANCE;
        String r111 = String.format(r109, Arrays.copyOf(new Object[]{r108.getName(), r107.getName()}, 2));
        TextView r112 = this.f125957a;
        if (r112 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("vCustomGiftDialogHint");
    L19:
        r112.setText(r111);
        String r113 = String.format(getContext().getString(R.string.ttlive_custom_gift_dialog_buy), Arrays.copyOf(new Object[]{r108.getName()}, 1));
        TextView r114 = this.f125958b;
        if (r114 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("vCustomGiftDialogBuy");
    L22:
        r114.setText(r113);
        String r115 = String.format(getContext().getString(R.string.ttlive_custom_gift_dialog_price, new Object[]{r3.b()}), Arrays.copyOf(new Object[]{Integer.valueOf(r107.getDiamondCount())}, 1));
        TextView r116 = this.f125960d;
        if (r116 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("vCustomGiftDialogSendPrice");
    L25:
        r116.setText(r115);
        TextView r117 = this.f125958b;
        if (r117 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("vCustomGiftDialogBuy");
    L28:
        r117.setOnClickListener(new e(this, r100));
        View r118 = this.f125959c;
        if (r118 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("vCustomGiftDialogSendLayout");
    L31:
        r118.setOnClickListener(new f(this));
        View r119 = this.f125961e;
        if (r119 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("vCustomGiftDialogClose");
    L34:
        r119.setOnClickListener(new g(this));
        return;
    L36:
        ViewUtilsKt.e(this);
        return;
    L11:
        r105 = 0;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public final void setOnCustomGiftDialogListener(a r100) {
        this.f125963g = r100;
    }

    public CustomGiftHintDialog(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        b(r100);
    }

    public static final void a(CustomGiftHintDialog r100, String r101) {
        r100.getClass();
        HashMap r102 = new HashMap();
        r102.put("special_effect_id", String.valueOf(r100.f125962f));
        r102.put("user_id", ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId());
        k r103 = r100.getRoomDataService();
        if (r103 == null) goto L5;
        r102.put("room_id", String.valueOf(r103.getRoom().getId()));
        r102.put("anchor_id", String.valueOf(r103.getRoom().getAnchorId()));
    L5:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r101);
        n r104 = new n();
        Map<String, String> r105 = r104.f516447a;
        Intrinsics.checkNotNullParameter(r105, "map");
        Intrinsics.checkNotNullParameter(r102, "map");
        r105.putAll(r102);
        cy0.e.f465759a.getClass();
        cy0.j r106 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r107 = m.b(r106).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r107);
        ((i) ((f80.a) r107)).w3("livesdk_nabob_special_runout_popup", r104.f516447a, r104.f516448b);
    }
}
