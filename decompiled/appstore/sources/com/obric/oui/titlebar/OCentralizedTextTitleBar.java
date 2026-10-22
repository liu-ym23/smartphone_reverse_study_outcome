package com.obric.oui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/titlebar/OCentralizedTextTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "color", "", "setDividerLineBackground", "(I)V", "Landroid/widget/FrameLayout;", "b", "Landroid/widget/FrameLayout;", "mLeadingElement", "c", "mTrailingElement", "Landroid/view/View;", "d", "Landroid/view/View;", "mLine", "getLeadingElement", "()Landroid/widget/FrameLayout;", "leadingElement", "getTrailingElement", "trailingElement", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCentralizedTextTitleBar extends OTitleBar {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f17391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f17392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f17393d;

    @JvmOverloads
    public OCentralizedTextTitleBar(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    @Nullable
    public final FrameLayout getLeadingElement() {
        return this.f17391b;
    }

    @Nullable
    public final FrameLayout getTrailingElement() {
        return this.f17392c;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r10) {
        View r11 = this.f17393d;
        if (r11 == null) goto L7;
        r11.setBackgroundColor(r10);
        return;
    }

    @JvmOverloads
    public OCentralizedTextTitleBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OCentralizedTextTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OCentralizedTextTitleBar(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        FrameLayout.inflate(r10, R$layout.o_centralized_title_bar, this);
        this.f17391b = (FrameLayout) findViewById(R$id.fl_leading_element);
        this.f17392c = (FrameLayout) findViewById(R$id.fl_trailing_element);
        this.f17452a = (TextView) findViewById(R$id.tv_content_title);
        this.f17393d = findViewById(R$id.divider_view);
    }
}
