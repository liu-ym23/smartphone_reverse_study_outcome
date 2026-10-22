package com.bytedanceos.appstore.buss.widget.app.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.d1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR`\u0010\u001a\u001a@\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/item/ItemSearchTipKeywordView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "searchKey", "", "setNewData", "(Ljava/lang/String;)V", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "entity", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "a", "Lkotlin/jvm/functions/Function2;", "getAppOnClickListener", "()Lkotlin/jvm/functions/Function2;", "setAppOnClickListener", "(Lkotlin/jvm/functions/Function2;)V", "appOnClickListener", "Lx7/d1;", "b", "Lx7/d1;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemSearchTipKeywordView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f9146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d1 f9147b;

    public /* synthetic */ ItemSearchTipKeywordView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static /* synthetic */ void a(ItemSearchTipKeywordView r10, String r11, View r12) {
        b(r10, r11, r12);
    }

    public static final void b(ItemSearchTipKeywordView r10, String r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        Function2 r13 = r10.f9146a;
        if (r13 == null) goto L6;
        r13.mo0invoke(r10, r11);
        return;
    }

    @Nullable
    public final Function2<View, String, Unit> getAppOnClickListener() {
        return this.f9146a;
    }

    public final void setAppOnClickListener(@Nullable Function2<? super View, ? super String, Unit> r10) {
        this.f9146a = r10;
    }

    public final void setNewData(@Nullable final String r10) {
        if (r10 != null) goto L4;
    L8:
        setVisibility(8);
        return;
    L4:
        if (kotlin.text.o.r(r10) == true) goto L8;
        setVisibility(0);
        this.f9147b.f25535b.setText(r10);
        setOnClickListener(new n(this, r10));
    }

    public ItemSearchTipKeywordView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11);
        d1 r12 = d1.c(LayoutInflater.from(r10), this, true);
        kotlin.jvm.internal.q.f(r12, "inflate(...)");
        this.f9147b = r12;
    }
}
