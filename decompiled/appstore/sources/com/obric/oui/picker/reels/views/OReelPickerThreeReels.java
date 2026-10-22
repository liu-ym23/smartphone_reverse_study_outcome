package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import bg.h;
import com.obric.common.oui.R$layout;
import com.obric.oui.picker.reels.OReelPicker;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0016\u0018\u0000 52\u00020\u00012\u00020\u0002:\u0001'B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0011\u001a\u00020\u0010*\u00020\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010%\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0014¢\u0006\u0004\b%\u0010&R\u001b\u0010+\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010.\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*R\u001b\u00101\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010(\u001a\u0004\b0\u0010*R\u0016\u00104\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerThreeReels;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/picker/reels/OReelPicker;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/obric/oui/picker/reels/views/WheelView;", "Lcom/obric/oui/picker/reels/OReelPicker$a;", "reel", "colIndex", "maxColIndex", "", "g", "(Lcom/obric/oui/picker/reels/views/WheelView;Lcom/obric/oui/picker/reels/OReelPicker$a;II)V", "Landroid/view/View;", "asView", "()Landroid/view/View;", "col", "getReelView", "(I)Lcom/obric/oui/picker/reels/views/WheelView;", "configure", "(ILcom/obric/oui/picker/reels/OReelPicker$a;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "a", "Lkotlin/Lazy;", "getWv1", "()Lcom/obric/oui/picker/reels/views/WheelView;", "wv1", "b", "getWv2", "wv2", "c", "getWv3", "wv3", "d", "I", "reelsCount", "e", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OReelPickerThreeReels extends ConstraintLayout implements OReelPicker {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f15933e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f15934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f15935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f15936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15937d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements OnWheelChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OReelPicker.a f15938a;

        public b(OReelPicker.a r10) {
            this.f15938a = r10;
        }

        @Override // com.obric.oui.picker.reels.views.OnWheelChangedListener
        public void onChanged(int r10, int r11) {
            Log.d("OReelPickerThreeReels", "onChanged: " + r10 + " -> " + r11);
            OReelPicker.ReelChangedListener r12 = this.f15938a.d();
            if (r12 == null) goto L7;
            r12.onReelChanged(this.f15938a.b(), r11);
            return;
        }

        @Override // com.obric.oui.picker.reels.views.OnWheelChangedListener
        public void onStopped(int r10) {
            Log.d("OReelPickerThreeReels", q.p("onStopped: ", Integer.valueOf(r10)));
            OReelPicker.ReelChangedListener r11 = this.f15938a.d();
            if (r11 == null) goto L7;
            r11.onReelChanged(this.f15938a.b(), r10);
            return;
        }
    }

    static {
        f15933e = new a(null);
    }

    @JvmOverloads
    public OReelPickerThreeReels(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private final void g(WheelView r10, OReelPicker.a r11, int r12, int r13) {
        r10.setVisibility(0);
        CharSequence r14 = r11.f();
        if (r14 == null) goto L6;
        r10.setTagText(r14);
    L6:
        r10.setLayoutParams(new LinearLayout.LayoutParams(0, -1, r11.i()));
        r10.setOnWheelChangedListener(new b(r11));
        r10.T(r11.a(), h.k(r11.e(), 0, h.d(r11.a().size() - 1, 0)));
    }

    private final WheelView getWv1() {
        Object r10 = this.f15934a.getValue();
        q.f(r10, "<get-wv1>(...)");
        return (WheelView) r10;
    }

    private final WheelView getWv2() {
        Object r10 = this.f15935b.getValue();
        q.f(r10, "<get-wv2>(...)");
        return (WheelView) r10;
    }

    private final WheelView getWv3() {
        Object r10 = this.f15936c.getValue();
        q.f(r10, "<get-wv3>(...)");
        return (WheelView) r10;
    }

    @Override // com.obric.oui.picker.reels.OReelPicker
    public View asView() {
        return this;
    }

    @Override // com.obric.oui.picker.reels.OReelPicker
    public void configure(int r10, OReelPicker.a r11) {
        q.g(r11, "reel");
        WheelView r12 = getReelView(r10);
        if (r12 == null) goto L7;
        g(r12, r11, r10, this.f15937d - 1);
        return;
    }

    @Override // com.obric.oui.picker.reels.OReelPicker
    public WheelView getReelView(int r10) {
        if (r10 == 0) goto L11;
        if (r10 == 1) goto L14;
        if (r10 == 2) goto L13;
        return null;
    L13:
        return getWv3();
    L14:
        return getWv2();
    L11:
        return getWv1();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @JvmOverloads
    public OReelPickerThreeReels(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OReelPickerThreeReels(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OReelPickerThreeReels(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f15934a = kotlin.b.b(new OReelPickerThreeReels$wv1$2(this));
        this.f15935b = kotlin.b.b(new OReelPickerThreeReels$wv2$2(this));
        this.f15936c = kotlin.b.b(new OReelPickerThreeReels$wv3$2(this));
        LayoutInflater.from(r10).inflate(R$layout.o_reel_picker_3_reels, this);
    }
}
