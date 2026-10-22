package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/BaseGiftComboView;", "Landroid/widget/FrameLayout;", "", "countDownTime", "", "setCountDownTime", "", "isGroupSend", "setIsGroupSend", "isSeriesSend", "setIsSeriesSend", "", "count", "setComboCount", "", "giftType", "setGiftType", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseGiftComboView extends FrameLayout {
    public BaseGiftComboView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseGiftComboView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public abstract void a(long r100);

    public abstract void b(h2 r100);

    public abstract void c(Runnable r100, int r101, int r102);

    public abstract void d();

    public abstract void e(h2 r100, l1 r101, com.bytedance.android.livesdk.gift.model.n r102);

    public void f() {
    }

    public void g() {
    }

    public abstract void setComboCount(int r100);

    public abstract void setCountDownTime(long r100);

    public abstract void setGiftType(String r100);

    public abstract void setIsGroupSend(boolean r100);

    public abstract void setIsSeriesSend(boolean r100);

    public BaseGiftComboView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ BaseGiftComboView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
