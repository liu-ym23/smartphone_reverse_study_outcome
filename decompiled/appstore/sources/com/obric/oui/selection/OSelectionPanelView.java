package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.p;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$style;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0003\u0013[\u000bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH$¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ7\u0010$\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010&R\u0014\u0010)\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010&R\"\u0010B\u001a\u00020;8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010&R \u0010K\u001a\b\u0012\u0004\u0012\u00020F0E8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR$\u0010S\u001a\u0004\u0018\u00010L8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010Z\u001a\u0004\u0018\u00010T8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b!\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y¨\u0006\\"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "theme", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "b", "()Z", "", "Lcom/obric/oui/selection/OSelectionPanelView$b;", Card.KEY_ITEMS, "", "setItems", "(Ljava/util/List;)V", "a", "()V", Style.KEY_HEIGHT, "setScrollViewHeight", "(I)V", "Lcom/obric/oui/selection/OSelectionPanelView$IIconLoader;", "loader", "setIconLoader", "(Lcom/obric/oui/selection/OSelectionPanelView$IIconLoader;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "l", "t", "r", "onLayout", "(ZIIII)V", "Z", "showSelectLabel", "Landroid/widget/LinearLayout;", "itemContainer", "Landroid/widget/FrameLayout;", "c", "Landroid/widget/FrameLayout;", "btnContainer", "Landroidx/core/widget/NestedScrollView;", "d", "Landroidx/core/widget/NestedScrollView;", "itemScrollView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "e", "Landroidx/constraintlayout/widget/ConstraintLayout;", "rootConstraintView", "f", "Lcom/obric/oui/selection/OSelectionPanelView$IIconLoader;", "iconLoader", "g", "supportForMinHeight", "Landroid/view/View;", "h", "Landroid/view/View;", "getBottomDivider", "()Landroid/view/View;", "setBottomDivider", "(Landroid/view/View;)V", "bottomDivider", "i", "allowDividersShow", "", "Lcom/obric/oui/selection/OSelectionPanelItemView;", "j", "Ljava/util/List;", "getItemViews", "()Ljava/util/List;", "itemViews", "Lcom/obric/oui/selection/OSingleSelectionPanelView$OnItemSelectListener;", "k", "Lcom/obric/oui/selection/OSingleSelectionPanelView$OnItemSelectListener;", "getOnItemSelectListener", "()Lcom/obric/oui/selection/OSingleSelectionPanelView$OnItemSelectListener;", "setOnItemSelectListener", "(Lcom/obric/oui/selection/OSingleSelectionPanelView$OnItemSelectListener;)V", "onItemSelectListener", "Lcom/obric/oui/selection/OMultiSelectionPanelView$OnMultiItemSelectListener;", "Lcom/obric/oui/selection/OMultiSelectionPanelView$OnMultiItemSelectListener;", "getOnMultiItemSelectListener", "()Lcom/obric/oui/selection/OMultiSelectionPanelView$OnMultiItemSelectListener;", "setOnMultiItemSelectListener", "(Lcom/obric/oui/selection/OMultiSelectionPanelView$OnMultiItemSelectListener;)V", "onMultiItemSelectListener", "IIconLoader", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OSelectionPanelView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f16744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f16745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NestedScrollView f16746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f16747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IIconLoader f16748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f16749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f16750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f16751i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f16752j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OSingleSelectionPanelView.OnItemSelectListener f16753k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OMultiSelectionPanelView.OnMultiItemSelectListener f16754l;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelView$IIconLoader;", "", "Landroid/widget/ImageView;", "iconImageView", "Lcom/obric/oui/selection/OSelectionPanelView$b;", "data", "Landroid/content/Context;", "context", "", "loadIcon", "(Landroid/widget/ImageView;Lcom/obric/oui/selection/OSelectionPanelView$b;Landroid/content/Context;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IIconLoader {
        void loadIcon(@NotNull ImageView r10, @NotNull b r11, @NotNull Context r12);
    }

    public static final class a implements IIconLoader {
        public a() {
        }

        @Override // com.obric.oui.selection.OSelectionPanelView.IIconLoader
        public void loadIcon(ImageView r10, b r11, Context r12) {
            q.g(r10, "iconImageView");
            q.g(r11, "data");
            q.g(r12, "context");
            throw null;
        }
    }

    public static final class b {
    }

    @JvmOverloads
    public OSelectionPanelView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public abstract void a();

    public abstract boolean b();

    @NotNull
    public final View getBottomDivider() {
        View r10 = this.f16750h;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("bottomDivider");
        return null;
    }

    @NotNull
    public final List<OSelectionPanelItemView> getItemViews() {
        return this.f16752j;
    }

    @Nullable
    public final OSingleSelectionPanelView.OnItemSelectListener getOnItemSelectListener() {
        return this.f16753k;
    }

    @Nullable
    public final OMultiSelectionPanelView.OnMultiItemSelectListener getOnMultiItemSelectListener() {
        return this.f16754l;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void setBottomDivider(@NotNull View r10) {
        q.g(r10, "<set-?>");
        this.f16750h = r10;
    }

    public final void setIconLoader(@NotNull IIconLoader r10) {
        q.g(r10, "loader");
        this.f16748f = r10;
    }

    public final void setItems(@NotNull List<b> r10) {
        q.g(r10, Card.KEY_ITEMS);
        Iterator<T> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        ((OSelectionPanelItemView) b0.i0(this.f16752j)).h();
        a();
        return;
    L6:
        p.a(r11.next());
        getItemViews();
        Context r12 = getContext();
        q.f(r12, "context");
        AttributeSet r13 = null;
        boolean r14 = false;
        OSelectionPanelItemView r15 = new OSelectionPanelItemView(r12, r13, r14, this.f16751i, 6, null);
        r15.setSelectMode(b());
        r15.k(this.f16743a);
        throw null;
    }

    public final void setOnItemSelectListener(@Nullable OSingleSelectionPanelView.OnItemSelectListener r10) {
        this.f16753k = r10;
    }

    public final void setOnMultiItemSelectListener(@Nullable OMultiSelectionPanelView.OnMultiItemSelectListener r10) {
        this.f16754l = r10;
    }

    public final void setScrollViewHeight(int r10) {
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(-1, r10);
        if (this.f16752j.size() < 4) goto L5;
    L7:
        this.f16746d.setLayoutParams(r11);
        return;
    L5:
        if (this.f16749g == false) goto L7;
        ConstraintLayout.LayoutParams r12 = new ConstraintLayout.LayoutParams(-1, -2);
        r12.f2205j = -1;
        r12.f2209l = 0;
        this.f16745c.setLayoutParams(r12);
        r11.f2207k = -1;
        goto L7
    }

    @JvmOverloads
    public OSelectionPanelView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OSelectionPanelView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = R$style.OSelectionPanel;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OSelectionPanelView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(new ContextThemeWrapper(r10, r12), r11);
        this.f16743a = true;
        this.f16748f = new a();
        this.f16749g = true;
        this.f16752j = new ArrayList();
        LinearLayout.inflate(getContext(), R$layout.o_view_selection_panel, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setOrientation(1);
        View r13 = findViewById(R$id.item_container);
        q.f(r13, "findViewById(R.id.item_container)");
        this.f16744b = (LinearLayout) r13;
        View r14 = findViewById(R$id.btn_container);
        q.f(r14, "findViewById(R.id.btn_container)");
        this.f16745c = (FrameLayout) r14;
        View r15 = findViewById(R$id.item_scroll_view);
        q.f(r15, "findViewById(R.id.item_scroll_view)");
        this.f16746d = (NestedScrollView) r15;
        View r16 = findViewById(R$id.root_constraint);
        q.f(r16, "findViewById(R.id.root_constraint)");
        this.f16747e = (ConstraintLayout) r16;
        View r17 = findViewById(R$id.bottom_divider);
        q.f(r17, "findViewById(R.id.bottom_divider)");
        setBottomDivider(r17);
    }
}
