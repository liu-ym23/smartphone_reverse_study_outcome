package com.bytedance.android.live.profit.format.voicechat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.PathInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/VoiceChatStartButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VoiceChatStartButton extends ConstraintLayout {

    public static final class a {
    }

    static {
    }

    public VoiceChatStartButton(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VoiceChatStartButton(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();
        if (r101 == 0) goto L11;
        if (r101 != 1) goto L6;
    L8:
        animate().scaleX(1.0f).scaleY(1.0f).setDuration(130).setInterpolator(new PathInterpolator(0.39f, 0.0f, 0.83f, 1.0f)).start();
        performClick();
    L10:
        return super.onTouchEvent(r100);
    L6:
        if (r101 == 3) goto L8;
    L11:
        animate().scaleX(0.87f).scaleY(0.87f).setDuration(130).setInterpolator(new PathInterpolator(0.18f, 0.0f, 0.57f, 1.0f)).start();
        return true;
    }

    public VoiceChatStartButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ VoiceChatStartButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
