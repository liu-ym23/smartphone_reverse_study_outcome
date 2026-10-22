package com.bytedance.applet.aibridge.datepicker.picker.reels.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u001f\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\u0019J$\u0010\u001a\u001a\u00020\u0014*\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/OReelPickerMulti;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/OReelPicker;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "reelsContainer", "Landroid/widget/LinearLayout;", "highlightView", "Landroid/view/View;", "wheelViews", "", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView;", "reelsCount", "onAttachedToWindow", "", "addWheelView", "width", "weight", "", "(Ljava/lang/Integer;F)Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView;", "configure", "reel", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/OReelPicker$Reel;", "colIndex", "maxColIndex", "asView", "getReelView", "col", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OReelPickerMulti extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f191038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f191039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<WheelView> f191040c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<iv3.a> f191041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f191042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f191043c;

        public a() {
            this.f191041a = new ArrayList();
            Resources r100 = Resources.getSystem();
            this.f191042b = MathKt.roundToInt(TypedValue.applyDimension(1, 328, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
            Resources r101 = Resources.getSystem();
            this.f191043c = MathKt.roundToInt(TypedValue.applyDimension(1, 240, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
        }

        public final OReelPickerMulti a(Context r100, AttributeSet r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            OReelPickerMulti r103 = new OReelPickerMulti(r100, r101, r102);
            r103.setLayoutParams(new LinearLayout.LayoutParams(this.f191042b, this.f191043c));
            ArrayList r104 = (ArrayList) this.f191041a;
            r104.size();
            ((ArrayList) r103.f191040c).clear();
            r103.f191038a.removeAllViews();
            Iterator r105 = r104.iterator();
        L3:
            int r106 = 0;
            if (r105.hasNext() == false) goto L10;
            Integer r107 = ((iv3.a) r105.next()).f495932e;
            if (r107 == null) goto L8;
            LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(r107.intValue(), -1);
        L9:
            WheelView r109 = new WheelView(r103.getContext(), null, 6, r106);
            r109.setLayoutParams(r108);
            r109.setCyclic(false);
            r103.f191038a.addView(r109);
            ((ArrayList) r103.f191040c).add(r109);
            goto L3
        L8:
            r108 = new LinearLayout.LayoutParams(-2, -1);
            goto L9
        L10:
            Iterator r110 = r104.iterator();
            int r111 = 0;
        L12:
            if (r110.hasNext() == false) goto L32;
            Object r112 = r110.next();
            int r113 = r111 + 1;
            if (r111 >= 0) goto L16;
            CollectionsKt.throwIndexOverflow();
        L16:
            iv3.a r114 = (iv3.a) r112;
            Intrinsics.checkNotNullParameter(r114, "reel");
            WheelView r115 = r103.R5(r111);
            if (r115 == null) goto L31;
            r115.setItemCount(5);
            CharSequence r116 = r114.f495930c;
            if (r116 == null) goto L21;
            r115.setTagText(r116);
        L21:
            Integer r117 = r114.f495934g;
            if (r117 == null) goto L24;
            r115.setTagGap(Integer.valueOf(r117.intValue()));
        L24:
            Integer r118 = r114.f495933f;
            if (r118 == null) goto L27;
            r115.setMinimumWidth(r118.intValue());
        L27:
            r115.setOnWheelChangedListener(new kv3.a(r114));
            int r119 = r114.f495935h;
            if (r119 < 0) goto L30;
            r115.j(Math.min(r119, r114.f495929b.size() - 1), false);
        L30:
            r115.setEntries(r114.f495929b);
        L31:
            r111 = r113;
            goto L12
        L32:
            return r103;
        }
    }

    public OReelPickerMulti(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OReelPickerMulti(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LinearLayout r100 = this.f191038a;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L11;
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
        r102.startToStart = 0;
        r102.endToEnd = 0;
        r102.topToTop = 0;
        r102.bottomToBottom = 0;
        r100.setLayoutParams(r102);
        View r103 = this.f191039b;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L9;
        ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r104;
        r105.startToStart = this.f191038a.getId();
        r105.endToEnd = this.f191038a.getId();
        r105.topToTop = this.f191038a.getId();
        r105.bottomToBottom = this.f191038a.getId();
        Resources r106 = Resources.getSystem();
        ((ViewGroup.MarginLayoutParams) r105).height = MathKt.roundToInt(TypedValue.applyDimension(1, 36, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics())));
        ((ViewGroup.MarginLayoutParams) r105).width = 0;
        r103.setLayoutParams(r105);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final WheelView R5(int r100) {
        return (WheelView) CollectionsKt.getOrNull(this.f191040c, r100);
    }

    public OReelPickerMulti(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LinearLayout r103 = new LinearLayout(r100);
        r103.setId(View.generateViewId());
        r103.setOrientation(0);
        r103.setGravity(17);
        r103.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.f191038a = r103;
        View r104 = new View(r100);
        r104.setId(View.generateViewId());
        r104.setBackgroundResource(R.drawable.larus_applet_picker_selected_row_bg);
        this.f191039b = r104;
        this.f191040c = new ArrayList();
        addView(r104);
        addView(r103);
    }

    public /* synthetic */ OReelPickerMulti(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
