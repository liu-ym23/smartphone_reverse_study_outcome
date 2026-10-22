package com.bytedanceos.appstore.buss.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.g0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00068\u0006X\u0086D¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\u00020\u00068\u0006X\u0086D¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR`\u0010\u001e\u001a@\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/AppItemPagerFirstRecommendView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "a", "I", "getSpanCount", "()I", "spanCount", "b", "getSpaceWidth", "spaceWidth", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "entity", "", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "c", "Lkotlin/jvm/functions/Function2;", "getAppOnClickListener", "()Lkotlin/jvm/functions/Function2;", "setAppOnClickListener", "(Lkotlin/jvm/functions/Function2;)V", "appOnClickListener", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "d", "Lkotlin/Lazy;", "getAdapter", "()Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "adapter", "Lx7/g0;", "e", "Lx7/g0;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppItemPagerFirstRecommendView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2 f9051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f9052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g0 f9053e;

    public AppItemPagerFirstRecommendView(@NotNull Context r10) {
        q.g(r10, "context");
        super(r10);
        this.f9049a = 4;
        this.f9050b = 14;
        this.f9052d = kotlin.b.b(new AppItemPagerFirstRecommendView$adapter$2(this));
        g0 r11 = g0.c(LayoutInflater.from(r10), this, true);
        q.f(r11, "inflate(...)");
        this.f9053e = r11;
    }

    private final BinderAdapter getAdapter() {
        return (BinderAdapter) this.f9052d.getValue();
    }

    @Nullable
    public final Function2<View, CommonAppEntity, Unit> getAppOnClickListener() {
        return this.f9051c;
    }

    public final int getSpaceWidth() {
        return this.f9050b;
    }

    public final int getSpanCount() {
        return this.f9049a;
    }

    public final void setAppOnClickListener(@Nullable Function2<? super View, ? super CommonAppEntity, Unit> r10) {
        this.f9051c = r10;
    }
}
