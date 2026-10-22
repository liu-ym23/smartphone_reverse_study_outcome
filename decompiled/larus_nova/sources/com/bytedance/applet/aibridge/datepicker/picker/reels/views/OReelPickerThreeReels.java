package com.bytedance.applet.aibridge.datepicker.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.common.CastMonitor;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kv3.b;
import kv3.c;
import kv3.d;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0002,-B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ$\u0010\u0018\u001a\u00020\u0019*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bH\u0014J0\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0014R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u000eR\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/OReelPickerThreeReels;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/OReelPicker;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "wv1", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView;", "getWv1", "()Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView;", "wv1$delegate", "Lkotlin/Lazy;", "wv2", "getWv2", "wv2$delegate", "wv3", "getWv3", "wv3$delegate", "reelsCount", "configure", "", "reel", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/OReelPicker$Reel;", "colIndex", "maxColIndex", "asView", "Landroid/view/View;", "getReelView", "col", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "left", "top", "right", "bottom", "Builder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OReelPickerThreeReels extends ConstraintLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f191044d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f191045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f191046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f191047c;

    public static final class a {
    }

    static {
    }

    public OReelPickerThreeReels(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OReelPickerThreeReels(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final WheelView getWv1() {
        return (WheelView) this.f191045a.getValue();
    }

    private final WheelView getWv2() {
        return (WheelView) this.f191046b.getValue();
    }

    private final WheelView getWv3() {
        return (WheelView) this.f191047c.getValue();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public OReelPickerThreeReels(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f191045a = LazyKt.lazy(new b(this));
        this.f191046b = LazyKt.lazy(new c(this));
        this.f191047c = LazyKt.lazy(new d(this));
        LayoutInflater.from(r100).inflate(R.layout.larus_applet_reel_picker_3_reels, this);
    }

    public /* synthetic */ OReelPickerThreeReels(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
