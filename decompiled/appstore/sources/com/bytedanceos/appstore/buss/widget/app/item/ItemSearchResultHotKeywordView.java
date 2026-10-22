package com.bytedanceos.appstore.buss.widget.app.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedanceos.appstore.buss.entity.SearchResultPromoteEntity;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.widget.SearchChipsView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.b1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\r\u001a\u00020\f2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0004\b\r\u0010\u000eR`\u0010\u001d\u001a@\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/item/ItemSearchResultHotKeywordView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Ljava/util/ArrayList;", "Lcom/bytedanceos/appstore/buss/entity/SearchResultPromoteEntity;", "Lkotlin/collections/ArrayList;", ServerElements.LIST, "", "setNewData", "(Ljava/util/ArrayList;)V", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "entity", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "a", "Lkotlin/jvm/functions/Function2;", "getAppOnClickListener", "()Lkotlin/jvm/functions/Function2;", "setAppOnClickListener", "(Lkotlin/jvm/functions/Function2;)V", "appOnClickListener", "Lx7/b1;", "b", "Lx7/b1;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nItemSearchResultHotKeywordView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemSearchResultHotKeywordView.kt\ncom/bytedanceos/appstore/buss/widget/app/item/ItemSearchResultHotKeywordView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,56:1\n1864#2,3:57\n*S KotlinDebug\n*F\n+ 1 ItemSearchResultHotKeywordView.kt\ncom/bytedanceos/appstore/buss/widget/app/item/ItemSearchResultHotKeywordView\n*L\n35#1:57,3\n*E\n"})
public final class ItemSearchResultHotKeywordView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f9143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b1 f9144b;

    public /* synthetic */ ItemSearchResultHotKeywordView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static /* synthetic */ void a(ItemSearchResultHotKeywordView r10, SearchChipsView r11, View r12) {
        b(r10, r11, r12);
    }

    public static final void b(ItemSearchResultHotKeywordView r10, SearchChipsView r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$view");
        Function2 r13 = r10.f9143a;
        if (r13 == null) goto L6;
        r13.mo0invoke(r10, r11.getText().toString());
        return;
    }

    @Nullable
    public final Function2<View, String, Unit> getAppOnClickListener() {
        return this.f9143a;
    }

    public final void setAppOnClickListener(@Nullable Function2<? super View, ? super String, Unit> r10) {
        this.f9143a = r10;
    }

    public final void setNewData(@Nullable ArrayList<SearchResultPromoteEntity> r10) {
        if (r10 != null) goto L5;
    L22:
        setVisibility(8);
        return;
    L5:
        if (r10.isEmpty() == true) goto L22;
        int r11 = 0;
        setVisibility(0);
        this.f9144b.f25503b.removeAllViews();
        ViewGroup.MarginLayoutParams r12 = new ViewGroup.MarginLayoutParams(-2, -2);
        Iterator<T> r13 = r10.iterator();
    L9:
        if (r13.hasNext() == false) goto L21;
        Object r14 = r13.next();
        int r15 = r11 + 1;
        if (r11 >= 0) goto L13;
        kotlin.collections.t.q();
    L13:
        SearchResultPromoteEntity r16 = (SearchResultPromoteEntity) r14;
        final SearchChipsView r17 = new SearchChipsView(getContext());
        r17.setText(r16.getName());
        if (r11 != 0) goto L17;
        r17.setType(SearchChipsView.WHITE_SEARCH_ICON);
    L20:
        r17.setOnClickListener(new m(this, r17));
        this.f9144b.f25503b.addView(r17, r12);
        r11 = r15;
        goto L9
    L17:
        if (r16.getType() != 2) goto L19;
        r17.setType(8);
        goto L20
    L19:
        r17.setType(SearchChipsView.BLUE);
        goto L20
    }

    public ItemSearchResultHotKeywordView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11);
        b1 r12 = b1.c(LayoutInflater.from(r10), this, true);
        kotlin.jvm.internal.q.f(r12, "inflate(...)");
        this.f9144b = r12;
    }
}
