package com.obric.oui.avatar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OAvatarGroupView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OAvatarGroupView extends ConstraintLayout {
    private final OAvatar topAvatar;
    private final OAvatar underAvatar;

    /* JADX INFO: compiled from: OAvatarGroupView.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33994a = null;

        static {
            int[] r0 = new int[OAvatar.a.values().length];
            r0[OAvatar.a.f33986c.ordinal()] = 1;
            r0[OAvatar.a.f33987d.ordinal()] = 2;
            r0[OAvatar.a.f33988e.ordinal()] = 3;
            r0[OAvatar.a.f.ordinal()] = 4;
            r0[OAvatar.a.g.ordinal()] = 5;
            r0[OAvatar.a.h.ordinal()] = 6;
            r0[OAvatar.a.i.ordinal()] = 7;
            f33994a = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OAvatarGroupView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OAvatarGroupView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OAvatarGroupView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7);
        ConstraintLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_widget_avatar_group, "layout", "o_widget_avatar_group"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.under_avatar, DbHelper.COL_ID, "under_avatar"));
        o.c(r8, "findViewById(R.id.under_avatar)");
        this.underAvatar = (OAvatar) ZeusTransformUtils.preCheckCast(r8, OAvatar.class, "com.obric.aiagent.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.top_avatar, DbHelper.COL_ID, "top_avatar"));
        o.c(r9, "findViewById(R.id.top_avatar)");
        this.topAvatar = (OAvatar) ZeusTransformUtils.preCheckCast(r9, OAvatar.class, "com.obric.aiagent.plugin");
    }

    public final OAvatar getTopAvatar() {
        return this.topAvatar;
    }

    public final OAvatar getUnderAvatar() {
        return this.underAvatar;
    }

    public final void setAvatarGroupSize(OAvatar.a r6) {
        o.e(r6, MonitorConstants.SIZE);
        switch(a.f33994a[r6.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        OAvatar.a r0 = OAvatar.a.f;
    L14:
        if (r6.a() < OAvatar.a.g.a()) goto L16;
        View r1 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        int r2 = 3;
    L17:
        int r3 = g.a(r1, r2);
        configAvatar(this.topAvatar, r0, r3);
        configAvatar(this.underAvatar, r0, r3);
        View r4 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r5.height = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r6.a());
        r5.width = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r6.a());
        r4.setLayoutParams(r5);
        return;
    L16:
        r1 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        r2 = 2;
        goto L17
    L7:
        r0 = OAvatar.a.f33988e;
        goto L14
    L8:
        r0 = OAvatar.a.f33988e;
        goto L14
    L9:
        r0 = OAvatar.a.f33987d;
        goto L14
    L10:
        r0 = OAvatar.a.f33986c;
        goto L14
    L11:
        r0 = OAvatar.a.f33985b;
        goto L14
    L12:
        r0 = OAvatar.a.f33984a;
        goto L14
    L5:
        throw new IllegalArgumentException(o.a("disallow the size: ", r6));
    }

    private final void configAvatar(OAvatar r7, OAvatar.a r8, int r9) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        int r3 = r9 * 2;
        r2.width = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r8.a()) + r3;
        r2.height = r3 + g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r8.a());
        r0.setLayoutParams(r2);
        r7.setAvatarInset(r9);
    }
}
