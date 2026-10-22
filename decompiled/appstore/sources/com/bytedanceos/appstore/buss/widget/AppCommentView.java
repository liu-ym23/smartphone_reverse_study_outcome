package com.bytedanceos.appstore.buss.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedanceos.appstore.buss.entity.AppCommentEntity;
import com.bytedanceos.appstore.buss.utilities.s;
import com.bytedanceos.appstore.buss.widget.dialog.x;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.e0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\rR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/AppCommentView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "Lcom/bytedanceos/appstore/buss/entity/AppCommentEntity;", "entity", "", "setNewData", "(Lcom/bytedanceos/appstore/buss/entity/AppCommentEntity;)V", "onDetachedFromWindow", "()V", "e", "Lkotlinx/coroutines/Job;", "a", "Lkotlinx/coroutines/Job;", "appJob", "", "b", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "packageName", "Lx7/e0;", "c", "Lx7/e0;", "binding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppCommentView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Job f9043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e0 f9045c;

    public AppCommentView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f9044b = "";
        e0 r12 = e0.c(LayoutInflater.from(r10), this, true);
        q.f(r12, "inflate(...)");
        this.f9045c = r12;
    }

    public static /* synthetic */ void a(AppCommentView r10, AppCommentEntity r11, View r12) {
        c(r10, r11, r12);
    }

    public static /* synthetic */ void b(AppCommentEntity r10, AppCommentView r11, View r12) {
        d(r10, r11, r12);
    }

    public static final void c(AppCommentView r10, AppCommentEntity r11, View r12) {
        q.g(r10, "this$0");
        if (com.bytedanceos.common.toolbox.e.A0(r10.getContext()) == true) goto L7;
        s.d(r10, "点赞失败！请检查网络连接后重试");
        return;
    L7:
        if (r11.getUid().equals(AccountDataCache.b().k()) == false) goto L9;
        return;
    L9:
        x r13 = x.f9282a;
        Context r14 = r10.getContext();
        q.e(r14, "null cannot be cast to non-null type android.app.Activity");
        if (r13.b((Activity) r14, R.string.support_comment_no_user, "dialog_support_comments") == true) goto L13;
        return;
    L13:
        if (r11.getIfLike() != 0) goto L18;
        r11.setIfLike(1);
        r11.setLike(String.valueOf(Integer.parseInt(r11.getLike()) + 1));
        Job r15 = r10.f9043a;
        if (r15 == null) goto L17;
        Job.a.b(r15, null, 1, null);
    L17:
        r10.f9043a = kotlinx.coroutines.h.d(y0.f21772a, null, null, new AppCommentView$setNewData$1$1(r11, null), 3, null);
        Bundle r16 = new Bundle();
        r16.putString("pkg_name", r10.f9044b);
        f9.b.b("click_like_success", r16);
    L22:
        r10.e(r11);
        return;
    L18:
        r11.setIfLike(0);
        r11.setLike(String.valueOf(Integer.parseInt(r11.getLike()) - 1));
        Job r17 = r10.f9043a;
        if (r17 == null) goto L21;
        Job.a.b(r17, null, 1, null);
    L21:
        r10.f9043a = kotlinx.coroutines.h.d(y0.f21772a, null, null, new AppCommentView$setNewData$1$2(r11, null), 3, null);
        goto L22
    }

    public static final void d(AppCommentEntity r10, AppCommentView r11, View r12) {
        q.g(r11, "this$0");
        if (r10.isOpen() == true) goto L6;
        r11.f9045c.f25542d.setEllipsize(null);
        r11.f9045c.f25542d.setSingleLine(false);
        return;
    }

    public final void e(AppCommentEntity r10) {
    }

    @Nullable
    public final String getPackageName() {
        return this.f9044b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Job r10 = this.f9043a;
        if (r10 == null) goto L6;
        Job.a.b(r10, null, 1, null);
        return;
    }

    public final void setNewData(@Nullable final AppCommentEntity r10) {
        if (r10 == null) goto L4;
        String r11 = r10.getContent();
    L5:
        if (r11 != null) goto L8;
        setVisibility(8);
        return;
    L8:
        setVisibility(0);
        this.f9045c.f25544f.setText(r10.getNickname());
        this.f9045c.f25545g.setText(r10.getCreateTime());
        this.f9045c.f25546h.setText(" | " + r10.getVersion());
        this.f9045c.f25542d.setText(r10.getContent());
        e(r10);
        this.f9045c.f25541c.setImageResource(com.bytedanceos.common.toolbox.e.b0(getContext(), Float.parseFloat(r10.getScore()), false));
        this.f9045c.f25543e.setOnClickListener(new a(this, r10));
        setOnClickListener(new b(r10, this));
        return;
    L4:
        r11 = null;
        goto L5
    }

    public final void setPackageName(@Nullable String r10) {
        this.f9044b = r10;
    }

    public AppCommentView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null);
    }
}
