package com.bytedanceos.appstore.buss.widget.app.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedanceos.appstore.buss.entity.AppSubEntity;
import com.bytedanceos.appstore.buss.entity.AppSubVideoEntity;
import com.bytedanceos.appstore.buss.widget.VideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.u0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/item/ItemSubVideoView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/bytedanceos/appstore/buss/entity/AppSubEntity;", "entity", "", "setNewData", "(Lcom/bytedanceos/appstore/buss/entity/AppSubEntity;)V", "onDetachedFromWindow", "()V", "d", "c", "b", "", "a", "Z", "isPauseByUser", "()Z", "setPauseByUser", "(Z)V", "Lx7/u0;", "Lx7/u0;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemSubVideoView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u0 f9150b;

    public /* synthetic */ ItemSubVideoView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static /* synthetic */ void a(ItemSubVideoView r10, View r11) {
        e(r10, r11);
    }

    public static final void e(ItemSubVideoView r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        com.bytedanceos.appstore.buss.utilities.s.d(r10, "视频播放");
    }

    public final void b() {
        this.f9150b.f25766b.x();
    }

    public final void c() {
        if (this.f9150b.f25766b.u() == null) goto L7;
        Boolean r10 = this.f9150b.f25766b.u();
        kotlin.jvm.internal.q.d(r10);
        if (r10.booleanValue() == false) goto L7;
        this.f9149a = false;
        this.f9150b.f25766b.y();
        return;
    L7:
        this.f9149a = true;
    }

    public final void d() {
        if (this.f9149a == false) goto L5;
        return;
    L5:
        if (com.bytedanceos.common.toolbox.e.I0() == false) goto L9;
        this.f9150b.f25766b.z();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f9150b.f25766b.y();
    }

    public final void setNewData(@Nullable AppSubEntity r10) {
        if (r10 != null) goto L6;
        setVisibility(8);
        return;
    L6:
        setVisibility(0);
        AppSubVideoEntity r11 = r10.getVideo();
        String r12 = null;
        if (r11 == null) goto L9;
        String r13 = r11.getUrl();
    L11:
        if (r13 != null) goto L13;
    L23:
        this.f9150b.f25766b.setVisibility(8);
    L24:
        this.f9150b.f25768d.setPageSource("page_game_subscribe");
        this.f9150b.f25768d.setNewData(r10);
        setOnClickListener(new o(this));
        return;
    L13:
        if (kotlin.text.o.r(r13) == true) goto L23;
        this.f9150b.f25766b.setVisibility(0);
        VideoView r14 = this.f9150b.f25766b;
        AppSubVideoEntity r15 = r10.getVideo();
        if (r15 == null) goto L18;
        String r16 = r15.getUrl();
    L19:
        kotlin.jvm.internal.q.d(r16);
        AppSubVideoEntity r17 = r10.getVideo();
        if (r17 == null) goto L22;
        r12 = r17.getImg();
    L22:
        kotlin.jvm.internal.q.d(r12);
        r14.t(r16, r12, "page_game_subscribe");
        goto L24
    L18:
        r16 = null;
        goto L19
    L9:
        r13 = null;
        goto L11
    }

    public final void setPauseByUser(boolean r10) {
        this.f9149a = r10;
    }

    public ItemSubVideoView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11);
        this.f9149a = true;
        u0 r12 = u0.c(LayoutInflater.from(r10), this, true);
        kotlin.jvm.internal.q.f(r12, "inflate(...)");
        this.f9150b = r12;
    }
}
