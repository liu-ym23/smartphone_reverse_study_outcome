package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.common.utility.StringUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/GiftLabelTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftLabelTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f126642c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f126643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f126644b;

    public GiftLabelTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GiftLabelTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void x(long r100) {
        u0 r101 = u0.f90999f;
        long r102 = u0.f91003j.f91006a;
        if (r100 <= r102) goto L5;
        setText(s1.C(R.string.ttlive_gift_label_tip_day, new Object[]{Integer.valueOf((int) (r100 / r102))}));
        return;
    L5:
        long r103 = u0.f91002i.f91006a;
        if (r103 <= r100) goto L9;
    L11:
        long r104 = u0.f91001h.f91006a;
        if (r104 <= r100) goto L15;
    L17:
        long r105 = u0.f91000g.f91006a;
        if (r105 <= r100) goto L21;
    L23:
        setText(s1.C(R.string.ttlive_gift_label_day_off, new Object[]{0}));
        return;
    L21:
        if (r104 < r100) goto L23;
        setText(s1.C(R.string.ttlive_gift_label_tip_second, new Object[]{Integer.valueOf((int) (r100 / r105))}));
        return;
    L15:
        if (r103 < r100) goto L17;
        setText(s1.C(R.string.ttlive_gift_label_tip_minute, new Object[]{Integer.valueOf((int) (r100 / r104))}));
        return;
    L9:
        if (r102 < r100) goto L11;
        setText(s1.C(R.string.ttlive_gift_label_tip_hour, new Object[]{Integer.valueOf((int) (r100 / r103))}));
    }

    public final boolean z(long r100, long r101) {
        long r102 = r100 - (System.currentTimeMillis() - r101);
        if (((Boolean) nz1.a.f521361t.getValue(null, nz1.a.f521324a[18])).booleanValue() == false) goto L5;
        setText(s1.C(R.string.ttlive_MH_label_day_off, new Object[]{new SimpleDateFormat("MM/dd HH:mm", Locale.CHINA).format(new Date(r100))}));
    L7:
        if (r102 > 0) goto L11;
        return false;
    L11:
        return true;
    L5:
        x(r102);
        goto L7
    }

    public GiftLabelTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public final boolean A(long r100, long r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r111, "onStopAction");
        this.f126644b = r111;
        long r112 = r100 - (System.currentTimeMillis() - r110);
        if (((Boolean) nz1.a.f521361t.getValue(null, nz1.a.f521324a[18])).booleanValue() == false) goto L5;
        setText(s1.C(R.string.ttlive_MH_label_day_off, new Object[]{new SimpleDateFormat("MM/dd HH:mm", Locale.CHINA).format(new Date(r100))}));
    L14:
        if (r112 > 0) goto L18;
        return false;
    L18:
        return true;
    L5:
        x(r112);
        if (r112 <= 0) goto L14;
        Ref.LongRef r101 = new Ref.LongRef();
        r101.element = r112;
        if (r112 <= 0) goto L14;
        Disposable r102 = this.f126643a;
        if (r102 == null) goto L12;
        r102.dispose();
    L12:
        j.a r103 = j.f66356a;
        this.f126643a = RxUtilKt.h(j.c(1, TimeUnit.SECONDS).subscribeOn(Schedulers.io())).subscribe(new qz1.a(this, r101));
        goto L14
    }

    public final void y(long r100, String r101, String r110) {
        if (r100 > 0) goto L8;
        setText(r101);
        if (StringUtils.isEmpty(r101) == false) goto L18;
        UtilityKotlinExtentionsKt.u(this);
        return;
    L18:
        return;
    L8:
        u0 r102 = u0.f90999f;
        long r103 = u0.f91001h.f91006a;
        long r104 = r100 / r103;
        long r105 = r100 / u0.f91000g.f91006a;
        long r106 = r103 / u0.f90995b;
        Long.signum(r104);
        long r107 = r105 - (r106 * r104);
        long r108 = 10;
        if (r104 >= r108) goto L11;
        String r109 = "0" + r104;
    L13:
        if (r107 >= r108) goto L15;
        String r111 = "0" + r107;
    L16:
        setText(s1.C(R.string.ttlive_gift_label_tip_popular_box, new Object[]{r109, r111, r110}));
        return;
    L15:
        r111 = String.valueOf(r107);
        goto L16
    L11:
        r109 = String.valueOf(r104);
        goto L13
    }

    public /* synthetic */ GiftLabelTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
