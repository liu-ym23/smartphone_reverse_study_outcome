package com.bytedanceos.appstore.buss.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.f0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rR`\u0010\u001a\u001a@\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/AppItemFirstRecommendView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "entity", "", "setNewData", "(Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;)V", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "a", "Lkotlin/jvm/functions/Function2;", "getAppOnClickListener", "()Lkotlin/jvm/functions/Function2;", "setAppOnClickListener", "(Lkotlin/jvm/functions/Function2;)V", "appOnClickListener", "Lx7/f0;", "b", "Lx7/f0;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppItemFirstRecommendView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f9047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f9048b;

    public AppItemFirstRecommendView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        f0 r12 = f0.c(LayoutInflater.from(r10), this, true);
        q.f(r12, "inflate(...)");
        this.f9048b = r12;
    }

    public static /* synthetic */ void a(CommonAppEntity r10, AppItemFirstRecommendView r11, View r12) {
        b(r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    public static final void b(CommonAppEntity r10, AppItemFirstRecommendView r11, View r12) {
        q.g(r11, "this$0");
        if (r10.getDefault_check() != 0) goto L5;
        ?? r13 = 1;
    L6:
        r11.f9048b.f25560d.setSelected(r13);
        r10.setDefault_check(r13);
        Function2 r14 = r11.f9047a;
        if (r14 == null) goto L10;
        r14.mo0invoke(r11, r10);
        return;
    L10:
        return;
    L5:
        r13 = 0;
        goto L6
    }

    @Nullable
    public final Function2<View, CommonAppEntity, Unit> getAppOnClickListener() {
        return this.f9047a;
    }

    public final void setAppOnClickListener(@Nullable Function2<? super View, ? super CommonAppEntity, Unit> r10) {
        this.f9047a = r10;
    }

    public final void setNewData(@Nullable final CommonAppEntity r10) {
        if (r10 == null) goto L13;
        String r11 = r10.getPkg();
        if (r11 == null) goto L13;
        if (o.r(r11) == true) goto L13;
        boolean r12 = false;
        setVisibility(0);
        ImageView r13 = this.f9048b.f25558b;
        q.f(r13, "appIcon");
        ImageUtilKt.g(r13, r10.getLogo(), R.dimen.dp_12, 0, 4, null);
        this.f9048b.f25559c.setText(r10.getName());
        ImageView r14 = this.f9048b.f25560d;
        if (r10.getDefault_check() != 1) goto L11;
        r12 = true;
    L11:
        r14.setSelected(r12);
        setOnClickListener(new c(r10, this));
        return;
    L13:
        setVisibility(8);
    }

    public AppItemFirstRecommendView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null);
    }
}
