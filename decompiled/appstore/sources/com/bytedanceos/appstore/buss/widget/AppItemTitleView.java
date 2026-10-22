package com.bytedanceos.appstore.buss.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedanceos.appstore.buss.utilities.s;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.j0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/AppItemTitleView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "showIvNext", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Z)V", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "title", "", "setNewData", "(Ljava/lang/String;)V", "a", "Z", "Lx7/j0;", "b", "Lx7/j0;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppItemTitleView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0 f9055b;

    public AppItemTitleView(Context r10, AttributeSet r11, boolean r12) {
        q.g(r10, "context");
        super(r10, r11);
        this.f9054a = r12;
        j0 r13 = j0.c(LayoutInflater.from(r10), this, true);
        q.f(r13, "inflate(...)");
        this.f9055b = r13;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public static /* synthetic */ void a(AppItemTitleView r10, String r11, View r12) {
        b(r10, r11, r12);
    }

    public static final void b(AppItemTitleView r10, String r11, View r12) {
        q.g(r10, "this$0");
        q.d(r11);
        s.d(r10, r11);
    }

    public final void setNewData(@Nullable final String r10) {
        if (r10 != null) goto L5;
    L8:
        setVisibility(8);
    L9:
        this.f9055b.f25621d.setText(r10);
        if (this.f9054a == false) goto L13;
        this.f9055b.f25619b.setVisibility(0);
        this.f9055b.f25619b.setImageResource(R.drawable.item_arrow);
        this.f9055b.f25619b.setOnClickListener(new d(this, r10));
        return;
    L13:
        return;
    L5:
        if (o.r(r10) == true) goto L8;
        setVisibility(0);
        goto L9
    }

    public AppItemTitleView(@NotNull Context r10, @NotNull AttributeSet r11) {
        q.g(r10, "context");
        q.g(r11, "attrs");
        this(r10, r11, false);
    }
}
