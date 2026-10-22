package com.bytedance.ai.applet.components.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ai.utils.h;
import com.bytedance.ai.utils.i;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/applet/components/widget/PlaceHolderView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ai/utils/IMotionProvider;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "longPressController", "Lcom/bytedance/ai/utils/IWidgetLongPressController;", "getLongPressController", "()Lcom/bytedance/ai/utils/IWidgetLongPressController;", "setLongPressController", "(Lcom/bytedance/ai/utils/IWidgetLongPressController;)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "lastMotionX", "", "getLastMotionX", "()Ljava/lang/Float;", "lastMotionY", "getLastMotionY", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlaceHolderView extends FrameLayout implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f34565a;

    public PlaceHolderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PlaceHolderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.ai.utils.h
    public Float getLastMotionX() {
        i r100 = this.f34565a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLastMotionX();
    }

    @Override // com.bytedance.ai.utils.h
    public Float getLastMotionY() {
        i r100 = this.f34565a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLastMotionY();
    }

    public final i getLongPressController() {
        return this.f34565a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        i r101 = this.f34565a;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L11;
        MotionEvent r103 = MotionEvent.obtain(r100);
        r103.setAction(3);
        super.dispatchTouchEvent(r103);
        r103.recycle();
        return true;
    L11:
        return super.dispatchTouchEvent(r100);
    L5:
        if (r101.dispatchTouchEvent(r100) != true) goto L7;
        r102 = true;
        goto L7
    }

    public final void setLongPressController(i r100) {
        this.f34565a = r100;
    }

    public PlaceHolderView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    }

    public /* synthetic */ PlaceHolderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
