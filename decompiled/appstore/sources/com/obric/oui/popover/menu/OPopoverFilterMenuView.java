package com.obric.oui.popover.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.obric.common.oui.R$dimen;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000f\u0010\u0010R&\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010!R\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010!¨\u0006'"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverFilterMenuView;", "Lcom/obric/oui/popover/menu/OPopoverMenuView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "w", "h", "oldw", "oldh", "", "onSizeChanged", "(IIII)V", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", Card.KEY_ITEMS, "", "Lcom/obric/oui/popover/view/CheckableImageView;", "f", "Ljava/util/Map;", "radioMap", "", "Landroid/view/ViewGroup;", "g", "Ljava/util/List;", "itemContainers", "I", "itemVerticalMargin", "i", "itemWidth", "j", "itemHeight", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverFilterMenuView extends OPopoverMenuView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f16187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f16188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f16189g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f16190h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f16191i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f16192j;

    @JvmOverloads
    public OPopoverFilterMenuView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    @Override // com.obric.oui.popover.menu.OPopoverMenuView, android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        Iterator r14 = this.f16189g.iterator();
    L4:
        if (r14.hasNext() == false) goto L24;
        ViewGroup r15 = (ViewGroup) r14.next();
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L23;
        ViewGroup.LayoutParams r17 = r15.getLayoutParams();
        ViewGroup.LayoutParams r18 = null;
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == true) goto L10;
        r17 = null;
    L10:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r17;
        int r20 = 0;
        if (r19 == null) goto L13;
        int r21 = r19.leftMargin;
    L14:
        int r22 = r10 - r21;
        ViewGroup.LayoutParams r23 = r15.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r18 = r23;
    L18:
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r18;
        if (r24 == null) goto L21;
        r20 = r24.rightMargin;
    L21:
        r16.width = r22 - r20;
        r15.setLayoutParams(r16);
        goto L4
    L13:
        r21 = 0;
        goto L14
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @JvmOverloads
    public OPopoverFilterMenuView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OPopoverFilterMenuView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OPopoverFilterMenuView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f16187e = new ArrayList();
        this.f16188f = new LinkedHashMap();
        this.f16189g = new ArrayList();
        this.f16190h = f.r(this, 4);
        this.f16191i = f.r(this, 188);
        this.f16192j = (int) r10.getResources().getDimension(R$dimen.oui_h_list_item_menu);
    }
}
