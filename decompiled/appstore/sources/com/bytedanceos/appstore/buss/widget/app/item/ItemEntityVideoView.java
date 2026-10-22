package com.bytedanceos.appstore.buss.widget.app.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.t0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rR`\u0010\u001a\u001a@\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/item/ItemEntityVideoView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "entity", "", "setNewData", "(Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;)V", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "a", "Lkotlin/jvm/functions/Function2;", "getVideoItemOnClickListener", "()Lkotlin/jvm/functions/Function2;", "setVideoItemOnClickListener", "(Lkotlin/jvm/functions/Function2;)V", "videoItemOnClickListener", "Lx7/t0;", "b", "Lx7/t0;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemEntityVideoView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f9118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t0 f9119b;

    public ItemEntityVideoView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11);
        t0 r12 = t0.c(LayoutInflater.from(r10), this, true);
        kotlin.jvm.internal.q.f(r12, "inflate(...)");
        this.f9119b = r12;
    }

    public static /* synthetic */ void a(ItemEntityVideoView r10, AppEntityWrap r11, View r12) {
        b(r10, r11, r12);
    }

    public static final void b(ItemEntityVideoView r10, AppEntityWrap r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        Function2 r13 = r10.f9118a;
        if (r13 == null) goto L6;
        r13.mo0invoke(r10, r11);
        return;
    }

    @Nullable
    public final Function2<View, AppEntityWrap, Unit> getVideoItemOnClickListener() {
        return this.f9118a;
    }

    public final void setNewData(@Nullable final AppEntityWrap r10) {
        if (r10 != null) goto L5;
        setVisibility(8);
        return;
    L5:
        setVisibility(0);
        ImageView r11 = this.f9119b.f25761b;
        kotlin.jvm.internal.q.f(r11, "ivVideo");
        ImageUtilKt.h(r11, r10.getVideo_img(), getContext().getResources().getDimensionPixelOffset(R.dimen.lkp_video_radius));
        setOnClickListener(new c(this, r10));
    }

    public final void setVideoItemOnClickListener(@Nullable Function2<? super View, ? super AppEntityWrap, Unit> r10) {
        this.f9118a = r10;
    }

    public ItemEntityVideoView(@NotNull Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        this(r10, null);
    }
}
