package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ab;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.n.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: OAvatarQueueView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OAvatarQueueView extends ConstraintLayout {
    /* JADX WARN: Multi-variable type inference failed */
    public OAvatarQueueView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OAvatarQueueView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OAvatarQueueView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7);
        ConstraintLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_widget_avatar_queue, "layout", "o_widget_avatar_queue"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<OAvatar> getAvatars() {
        List<OAvatar> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator<View> r4 = ab.b((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin")).a();
    L4:
        if (r4.hasNext() == false) goto L8;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r4.next(), View.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, OAvatar.class) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public final void setAvatars(List<? extends Drawable> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r7, "drawables");
        int r0 = 0;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.subList(0, 5), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Object r2 = r8.next();
        int r3 = r0 + 1;
        if (r0 >= 0) goto L8;
        p.c();
    L8:
        Drawable r4 = (Drawable) ZeusTransformUtils.preCheckCast(r2, Drawable.class, "com.obric.aiagent.plugin");
        View r1 = getChildAt(r0);
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.avatar.OAvatar");
        ((OAvatar) ZeusTransformUtils.preCheckCast(r1, OAvatar.class, "com.obric.aiagent.plugin")).getContentImageView().setImageDrawable(r4);
        r0 = r3;
        goto L4
    }

    public final void configAvatarSize(OAvatar.a r14, int r15) {
        o.e(r14, MonitorConstants.SIZE);
        Iterator<View> r0 = ab.b((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin")).a();
    L3:
        int r3 = 0;
        if (r0.hasNext() == false) goto L12;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r0.next(), View.class, "com.obric.aiagent.plugin");
        OAvatar r4 = (OAvatar) ZeusTransformUtils.preCheckCast(r2, OAvatar.class, "com.obric.aiagent.plugin");
        r4.setAvatarSize(r14);
        if (r14.a() < OAvatar.a.f33988e.a()) goto L8;
        int r5 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 3);
    L9:
        View r6 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r9 = r6.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        int r10 = r5 * 2;
        r9.width = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r14.a()) + r10;
        r9.height = r10 + g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r14.a());
        r6.setLayoutParams(r9);
        r4.setAvatarInset(r5);
        r4.getContentImageView().setContentPadding(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0));
        if (o.a(r2, m.c(ab.b((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin")))) == true) goto L3;
        View r7 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r11 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).setMargins(0, 0, (g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r14.a()) / 3) * 2, 0);
        r7.setLayoutParams(r11);
        goto L3
    L8:
        r5 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 2);
        goto L9
    L12:
        int r16 = getChildCount();
    L13:
        if (r3 >= r16) goto L19;
        int r1 = r3 + 1;
        if (r3 < r15) goto L17;
        View r12 = getChildAt(r3);
        o.c(r12, "getChildAt(index)");
        k.b(r12);
    L18:
        r3 = r1;
        goto L13
    L17:
        View r13 = getChildAt(r3);
        o.c(r13, "getChildAt(index)");
        k.a(r13);
        goto L18
    }
}
