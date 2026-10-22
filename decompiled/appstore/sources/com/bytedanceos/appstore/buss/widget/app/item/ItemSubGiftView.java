package com.bytedanceos.appstore.buss.widget.app.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedanceos.appstore.buss.entity.netwrap.SubDetailGiftEntity;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.f1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/item/ItemSubGiftView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/bytedanceos/appstore/buss/entity/netwrap/SubDetailGiftEntity;", "entity", "", "setNewData", "(Lcom/bytedanceos/appstore/buss/entity/netwrap/SubDetailGiftEntity;)V", "Lx7/f1;", "a", "Lx7/f1;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemSubGiftView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f1 f9148a;

    public /* synthetic */ ItemSubGiftView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public final void setNewData(@Nullable SubDetailGiftEntity r10) {
        if (r10 != null) goto L5;
        setVisibility(8);
        return;
    L5:
        setVisibility(0);
        ImageView r11 = this.f9148a.f25562b;
        kotlin.jvm.internal.q.f(r11, "ivGiftPic");
        ImageUtilKt.d(r11, r10.getPic());
        this.f9148a.f25563c.setText(r10.getName());
        this.f9148a.f25564d.setText("X " + r10.getNum());
    }

    public ItemSubGiftView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11);
        f1 r12 = f1.c(LayoutInflater.from(r10), this, true);
        kotlin.jvm.internal.q.f(r12, "inflate(...)");
        this.f9148a = r12;
    }
}
