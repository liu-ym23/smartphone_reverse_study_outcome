package com.obric.oui.tab.optimize;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0002\u0018,B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabBar;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/obric/oui/tab/optimize/OBottomTabBar$OnTabSelectedListener;", "listener", "", "setOnTabSelectedListener", "(Lcom/obric/oui/tab/optimize/OBottomTabBar$OnTabSelectedListener;)V", "", "show", "setShowTopLine", "(Z)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "<set-?>", "a", "I", "getSelectedIndex", "()I", "selectedIndex", "b", "Lcom/obric/oui/tab/optimize/OBottomTabBar$OnTabSelectedListener;", "_onTabSelectedListener", "", "c", "F", "dividerWith", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "mDividerPaint", "e", "Z", "topLineVis", "f", "OnTabSelectedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomTabBar extends LinearLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f17223f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final sc.a f17224g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OnTabSelectedListener f17226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f17227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f17228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f17229e;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabBar$OnTabSelectedListener;", "", "onTabSelected", "", SlideCard.KEY_INDEX, "", "item", "Lcom/obric/oui/tab/optimize/OBottomTabItem;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnTabSelectedListener {
        void onTabSelected(int r10, @NotNull OBottomTabItem r11);
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f17223f = new a(null);
        f17224g = new sc.a();
    }

    @JvmOverloads
    public OBottomTabBar(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final int getSelectedIndex() {
        return this.f17225a;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f17229e == false) goto L10;
        r10.save();
        r10.drawLine(0.0f, this.f17227c / 2.0f, getWidth(), this.f17227c, this.f17228d);
        r10.restore();
        return;
    }

    public final void setOnTabSelectedListener(@NotNull OnTabSelectedListener r10) {
        q.g(r10, "listener");
        this.f17226b = r10;
    }

    public final void setShowTopLine(boolean r10) {
        this.f17229e = r10;
        invalidate();
    }

    @JvmOverloads
    public OBottomTabBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OBottomTabBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OBottomTabBar(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f17225a = -1;
        Paint r13 = new Paint();
        r13.setStyle(Paint.Style.FILL);
        r13.setColor(getResources().getColor(R$color.oui_line_2));
        this.f17228d = r13;
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        Resources r14 = getResources();
        int r15 = R$dimen.oui_p_container_2;
        setPadding((int) r14.getDimension(r15), f.p(this, 4.5d), (int) getResources().getDimension(r15), f.r(this, 2));
        float r16 = f.q(this, 0.6f);
        this.f17227c = r16;
        r13.setStrokeWidth(r16);
        setWillNotDraw(false);
        this.f17229e = true;
    }
}
