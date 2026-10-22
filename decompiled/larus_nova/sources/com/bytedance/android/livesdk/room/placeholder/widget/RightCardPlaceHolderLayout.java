package com.bytedance.android.livesdk.room.placeholder.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardConstant$Position;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\r\u0010\u0011B#\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\r\u0010\u0014R\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/room/placeholder/widget/RightCardPlaceHolderLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/room/placeholder/widget/c;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getCardType", "()Ljava/lang/String;", "setCardType", "(Ljava/lang/String;)V", "cardType", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RightCardPlaceHolderLayout extends FrameLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f157796a;

    @Override // com.bytedance.android.livesdk.room.placeholder.widget.c
    public String getCardType() {
        return this.f157796a;
    }

    public RightCardPlaceHolderLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f157796a = CardTypeAndPriority.AssembledIntroduceCard.getType();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getAction());
    L5:
        if (r101 == null) goto L20;
        if (r101.intValue() != 0) goto L20;
        i r102 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r102 == null) goto L20;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r103 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_msg_card_click");
        r103.b("position", Integer.valueOf(CommonCardConstant$Position.BOTTOM_RIGHT.getValue()));
        r103.b("type", getCardType());
        if ((getHeight() - r100.getY()) != 0.0f) goto L15;
    L17:
        String r104 = "picture";
    L18:
        r103.b(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r104);
        Unit r105 = Unit.INSTANCE;
        r102.b(r103.a());
        goto L20
    L15:
        if ((getHeight() / (getHeight() - r100.getY())) <= 4) goto L17;
        r104 = "action";
    L20:
        return super.onInterceptTouchEvent(r100);
    L4:
        r101 = null;
        goto L5
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.widget.c
    public void setCardType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f157796a = r100;
    }

    public RightCardPlaceHolderLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f157796a = CardTypeAndPriority.AssembledIntroduceCard.getType();
    }

    public RightCardPlaceHolderLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f157796a = CardTypeAndPriority.AssembledIntroduceCard.getType();
    }
}
