package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import bg.h;
import com.obric.oui.picker.reels.OReelPicker;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001)B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\"\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010#J+\u0010&\u001a\u00020\u0010*\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002¢\u0006\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00170,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerMulti;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/picker/reels/OReelPicker;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "onAttachedToWindow", "()V", "Landroid/view/View;", "asView", "()Landroid/view/View;", "col", "Lcom/obric/oui/picker/reels/views/WheelView;", "getReelView", "(I)Lcom/obric/oui/picker/reels/views/WheelView;", "Lcom/obric/oui/picker/reels/OReelPicker$a;", "reel", "configure", "(ILcom/obric/oui/picker/reels/OReelPicker$a;)V", Style.KEY_WIDTH, "", "weight", "minHeight", "k", "(Ljava/lang/Integer;FI)Lcom/obric/oui/picker/reels/views/WheelView;", "colIndex", "maxColIndex", "l", "(Lcom/obric/oui/picker/reels/views/WheelView;Lcom/obric/oui/picker/reels/OReelPicker$a;II)V", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", "reelsContainer", "", "b", "Ljava/util/List;", "wheelViews", "c", "I", "reelsCount", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OReelPickerMulti extends ConstraintLayout implements OReelPicker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f15925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f15926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15927c;

    public static final class a implements OReelPicker.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f15928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15930c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15931d;

        public a() {
            this.f15928a = new ArrayList();
            this.f15929b = -1;
            this.f15930c = -1;
            this.f15931d = 16;
        }

        public final a a(int r10) {
            this.f15930c = r10;
            return this;
        }

        @Override // com.obric.oui.picker.reels.OReelPicker.Builder
        public OReelPicker.Builder addReel(OReelPicker.a r10) {
            q.g(r10, "reel");
            this.f15928a.add(r10);
            return this;
        }

        public final void b(OReelPickerMulti r10, List r11, int r12) {
            OReelPickerMulti.j(r10, r11.size());
            OReelPickerMulti.i(r10).clear();
            OReelPickerMulti.h(r10).removeAllViews();
            Iterator r13 = r11.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            OReelPicker.a r14 = (OReelPicker.a) r13.next();
            OReelPickerMulti.g(r10, r14.h(), r14.i(), r12);
            goto L4
        L6:
            Iterator r15 = r11.iterator();
            int r16 = 0;
        L8:
            if (r15.hasNext() == false) goto L13;
            Object r17 = r15.next();
            int r18 = r16 + 1;
            if (r16 >= 0) goto L12;
            t.q();
        L12:
            r10.configure(r16, (OReelPicker.a) r17);
            r16 = r18;
            goto L8
        }

        @Override // com.obric.oui.picker.reels.OReelPicker.Builder
        public OReelPicker build(Context r10, AttributeSet r11, int r12) {
            q.g(r10, "context");
            if (this.f15929b != (-1)) goto L6;
            this.f15929b = f.b(r10, 328);
        L6:
            if (this.f15930c != (-1)) goto L8;
            this.f15930c = f.b(r10, 240);
        L8:
            OReelPickerMulti r13 = new OReelPickerMulti(r10, r11, r12);
            r13.setLayoutParams(new LinearLayout.LayoutParams(this.f15929b, this.f15930c));
            b(r13, this.f15928a, this.f15930c - (f.b(r10, this.f15931d) * 2));
            return r13;
        }

        public final a c(int r10) {
            this.f15929b = r10;
            return this;
        }
    }

    public static final class b implements OnWheelChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OReelPicker.a f15932a;

        public b(OReelPicker.a r10) {
            this.f15932a = r10;
        }

        @Override // com.obric.oui.picker.reels.views.OnWheelChangedListener
        public void onChanged(int r10, int r11) {
            OReelPicker.ReelChangedListener r12 = this.f15932a.d();
            if (r12 == null) goto L7;
            r12.onReelChanged(this.f15932a.b(), r11);
            return;
        }

        @Override // com.obric.oui.picker.reels.views.OnWheelChangedListener
        public void onStopped(int r10) {
            OReelPicker.ReelChangedListener r11 = this.f15932a.d();
            if (r11 == null) goto L7;
            r11.onReelChanged(this.f15932a.b(), r10);
            return;
        }
    }

    @JvmOverloads
    public OReelPickerMulti(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final /* synthetic */ WheelView g(OReelPickerMulti r10, Integer r11, float r12, int r13) {
        return r10.k(r11, r12, r13);
    }

    public static final /* synthetic */ LinearLayout h(OReelPickerMulti r10) {
        return r10.f15925a;
    }

    public static final /* synthetic */ List i(OReelPickerMulti r10) {
        return r10.f15926b;
    }

    public static final /* synthetic */ void j(OReelPickerMulti r10, int r11) {
        r10.f15927c = r11;
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
        l(r12, r11, r10, this.f15927c - 1);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        if (getAlpha() >= 1.0f) goto L7;
        return true;
    L7:
        return super.dispatchTouchEvent(r10);
    }

    @Override // com.obric.oui.picker.reels.OReelPicker
    public WheelView getReelView(int r10) {
        return (WheelView) b0.a0(this.f15926b, r10);
    }

    public final WheelView k(Integer r10, float r11, int r12) {
        if (r10 == null) goto L5;
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(r10.intValue(), -1);
    L6:
        Context r14 = getContext();
        q.f(r14, "context");
        WheelView r15 = new WheelView(r14, null, 0, 6, null);
        r15.setLayoutParams(r13);
        r15.setMinimumHeight(r12);
        r15.setCyclic(false);
        this.f15925a.addView(r15);
        this.f15926b.add(r15);
        return r15;
    L5:
        r13 = new LinearLayout.LayoutParams(-2, -1);
        goto L6
    }

    public final void l(WheelView r10, OReelPicker.a r11, int r12, int r13) {
        r10.setItemCount(5);
        CharSequence r14 = r11.f();
        if (r14 == null) goto L6;
        r10.setTagText(r14);
    L6:
        Integer r15 = r11.g();
        if (r15 == null) goto L10;
        r10.setTagGap(Integer.valueOf(r15.intValue()));
    L10:
        Integer r16 = r11.c();
        if (r16 == null) goto L14;
        r10.setMinimumWidth(r16.intValue());
    L14:
        r10.setOnWheelChangedListener(new b(r11));
        r10.T(r11.a(), h.k(r11.e(), 0, h.d(r11.a().size() - 1, 0)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LinearLayout r10 = this.f15925a;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L7;
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
        r12.f2225t = 0;
        r12.f2229v = 0;
        r12.f2203i = 0;
        r12.f2209l = 0;
        r10.setLayoutParams(r12);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    @JvmOverloads
    public OReelPickerMulti(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OReelPickerMulti(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OReelPickerMulti(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        LinearLayout r13 = new LinearLayout(r10);
        r13.setId(ViewGroup.generateViewId());
        r13.setOrientation(0);
        r13.setGravity(17);
        r13.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.f15925a = r13;
        this.f15926b = new ArrayList();
        addView(r13);
    }
}
