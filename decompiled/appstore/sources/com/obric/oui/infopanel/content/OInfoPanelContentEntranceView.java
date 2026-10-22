package com.obric.oui.infopanel.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import gd.a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/infopanel/content/OInfoPanelContentEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "onAttachedToWindow", "()V", "Landroid/view/View$OnClickListener;", "listener", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View$OnClickListener;)V", "", "text", "setEntranceText", "(Ljava/lang/CharSequence;)V", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "tvEntrance", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "ivJump", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "entranceContainer", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelContentEntranceView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f15082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f15083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f15084c;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OInfoPanelContentEntranceView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void g(OInfoPanelContentEntranceView r10) {
        h(r10);
    }

    public static final void h(OInfoPanelContentEntranceView r10) {
        q.g(r10, "this$0");
        l.d(r10, r10.f15084c.getWidth(), f.r(r10, 44), true);
        ViewGroup r11 = r10.f15084c;
        l.d(r11, r11.getWidth(), f.r(r10, 44), true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new a(this));
    }

    public final void onClick(@NotNull View.OnClickListener r10) {
        q.g(r10, "listener");
        this.f15084c.setOnClickListener(r10);
    }

    public final void setEntranceText(@NotNull CharSequence r10) {
        q.g(r10, "text");
        this.f15082a.setText(r10);
    }

    public /* synthetic */ OInfoPanelContentEntranceView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OInfoPanelContentEntranceView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, R$layout.o_info_panel_content_entrance_view, this);
        ViewGroup.MarginLayoutParams r12 = new ViewGroup.MarginLayoutParams(-1, -2);
        r12.setMargins(0, f.r(this, 8), 0, f.r(this, 12));
        setLayoutParams(r12);
        View r13 = findViewById(R$id.tv_title);
        q.f(r13, "findViewById(R.id.tv_title)");
        this.f15082a = (TextView) r13;
        View r14 = findViewById(R$id.iv_arrow);
        q.f(r14, "findViewById(R.id.iv_arrow)");
        this.f15083b = (ImageView) r14;
        View r15 = findViewById(R$id.entrance_container);
        q.f(r15, "findViewById(R.id.entrance_container)");
        this.f15084c = (ViewGroup) r15;
    }
}
