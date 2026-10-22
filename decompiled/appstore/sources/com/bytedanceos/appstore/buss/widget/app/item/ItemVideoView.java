package com.bytedanceos.appstore.buss.widget.app.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.widget.VideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.i1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/item/ItemVideoView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "entity", "", "setNewData", "(Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;)V", "onDetachedFromWindow", "()V", "d", "c", "b", "", "a", "Z", "isPauseByUser", "()Z", "setPauseByUser", "(Z)V", "Lx7/i1;", "Lx7/i1;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemVideoView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i1 f9159b;

    public /* synthetic */ ItemVideoView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static /* synthetic */ void a(ItemVideoView r10, View r11) {
        e(r10, r11);
    }

    public static final void e(ItemVideoView r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        com.bytedanceos.appstore.buss.utilities.s.d(r10, "play video");
    }

    public final void b() {
        this.f9159b.f25612b.x();
    }

    public final void c() {
        if (this.f9159b.f25612b.u() == null) goto L7;
        Boolean r10 = this.f9159b.f25612b.u();
        kotlin.jvm.internal.q.d(r10);
        if (r10.booleanValue() == false) goto L7;
        this.f9158a = false;
        this.f9159b.f25612b.y();
        return;
    L7:
        this.f9158a = true;
    }

    public final void d() {
        if (this.f9158a == false) goto L5;
        return;
    L5:
        if (com.bytedanceos.common.toolbox.e.I0() == false) goto L9;
        this.f9159b.f25612b.z();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f9159b.f25612b.y();
    }

    public final void setNewData(@Nullable CommonAppEntity r10) {
        if (r10 == null) goto L15;
        String r11 = r10.getName();
        if (r11 == null) goto L15;
        if (kotlin.text.o.r(r11) == true) goto L15;
        String r12 = r10.getPkg();
        if (r12 == null) goto L15;
        if (kotlin.text.o.r(r12) == true) goto L15;
        setVisibility(0);
        VideoView r13 = this.f9159b.f25612b;
        String r14 = r10.getVideo_url();
        kotlin.jvm.internal.q.d(r14);
        String r15 = r10.getVideo_img();
        kotlin.jvm.internal.q.d(r15);
        r13.t(r14, r15, r10.getPageTitle());
        ItemHorizontalView r16 = this.f9159b.f25613c;
        kotlin.jvm.internal.q.f(r16, "tvItemHorizontalView");
        ItemHorizontalView.f(r16, r10, 0, 2, null);
        setOnClickListener(new u(this));
        return;
    L15:
        setVisibility(8);
    }

    public final void setPauseByUser(boolean r10) {
        this.f9158a = r10;
    }

    public ItemVideoView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11);
        this.f9158a = true;
        i1 r12 = i1.c(LayoutInflater.from(r10), this, true);
        kotlin.jvm.internal.q.f(r12, "inflate(...)");
        this.f9159b = r12;
    }
}
