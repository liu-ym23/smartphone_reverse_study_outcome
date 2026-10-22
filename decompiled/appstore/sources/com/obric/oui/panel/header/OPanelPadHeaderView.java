package com.obric.oui.panel.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.divider.ODivider;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/panel/header/OPanelPadHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroidx/appcompat/widget/AppCompatImageView;", "getCloseIconView", "()Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "a", "Landroidx/appcompat/widget/AppCompatImageView;", "ivClose", "b", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "ivBack", "Lcom/obric/oui/divider/ODivider;", "d", "Lcom/obric/oui/divider/ODivider;", "dividerView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPanelPadHeaderView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatImageView f15884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f15885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f15886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ODivider f15887d;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OPanelPadHeaderView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @NotNull
    public final AppCompatImageView getCloseIconView() {
        return this.f15884a;
    }

    @NotNull
    public final TextView getTitleView() {
        return this.f15885b;
    }

    public /* synthetic */ OPanelPadHeaderView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OPanelPadHeaderView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, R$layout.o_basic_panel_pad_header, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, tc.a.f24778a.b(r10, R$attr.oui_PanelDefaultHeaderHeight, R$dimen.oui_panel_default_header_height)));
        setBackgroundColor(0);
        View r12 = findViewById(R$id.iv_close);
        q.f(r12, "findViewById(R.id.iv_close)");
        this.f15884a = (AppCompatImageView) r12;
        View r13 = findViewById(R$id.tv_title);
        q.f(r13, "findViewById(R.id.tv_title)");
        this.f15885b = (TextView) r13;
        View r14 = findViewById(R$id.iv_back);
        q.f(r14, "findViewById(R.id.iv_back)");
        this.f15886c = (ImageView) r14;
        View r15 = findViewById(R$id.divider);
        q.f(r15, "findViewById(R.id.divider)");
        this.f15887d = (ODivider) r15;
    }
}
