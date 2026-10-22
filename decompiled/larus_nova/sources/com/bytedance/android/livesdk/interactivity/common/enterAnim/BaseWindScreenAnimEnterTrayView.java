package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/enterAnim/BaseWindScreenAnimEnterTrayView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "textSize", "", "setTextSize", "Lcom/bytedance/android/live/base/model/message/e;", "getComboInfo", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseWindScreenAnimEnterTrayView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f136516a;

    public BaseWindScreenAnimEnterTrayView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseWindScreenAnimEnterTrayView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public abstract void R5(k32.d r100);

    public void S5(com.bytedance.android.live.base.model.message.d r100, com.bytedance.android.livesdk.interactivity.enteranim.utils.d r101) {
        Intrinsics.checkNotNullParameter(r100, "nextCombo");
        Intrinsics.checkNotNullParameter(r101, "onComboListener");
    }

    public boolean T5(com.bytedance.android.livesdk.interactivity.enteranim.utils.e r100) {
        Intrinsics.checkNotNullParameter(r100, "onComboListener");
        return false;
    }

    public abstract void U5(int r100, int r101);

    public com.bytedance.android.live.base.model.message.e getComboInfo() {
        return null;
    }

    public abstract void setTextSize(float r100);

    public BaseWindScreenAnimEnterTrayView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ BaseWindScreenAnimEnterTrayView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
