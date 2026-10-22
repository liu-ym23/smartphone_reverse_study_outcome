package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OAvatar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OAvatar extends ConstraintLayout {
    private a avatarSize;
    private int iconBorderColor;
    private b iconType;
    private final OCircleImageView ivAvatar;
    private final AppCompatImageView ivBg;
    private final OCircleImageView ivIcon;
    private final Space spacer;

    /* JADX INFO: compiled from: OAvatar.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f33984a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f33985b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f33986c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f33987d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f33988e = null;
        public static final a f = null;
        public static final a g = null;
        public static final a h = null;
        public static final a i = null;
        private static final /* synthetic */ a[] k = null;
        private final int j;

        private static final /* synthetic */ a[] b() {
            return new a[]{f33984a, f33985b, f33986c, f33987d, f33988e, f, g, h, i};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(k.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.j = r3;
        }

        public final int a() {
            return this.j;
        }

        static {
            f33984a = new a("DP_16", 0, 16);
            f33985b = new a("DP_20", 1, 20);
            f33986c = new a("DP_24", 2, 24);
            f33987d = new a("DP_32", 3, 32);
            f33988e = new a("DP_40", 4, 40);
            f = new a("DP_48", 5, 48);
            g = new a("DP_56", 6, 56);
            h = new a("DP_64", 7, 64);
            i = new a("DP_72", 8, 72);
            k = b();
        }
    }

    /* JADX INFO: compiled from: OAvatar.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f33989a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f33990b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ b[] f33991c = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f33989a, f33990b};
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f33991c.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f33989a = new b("ONLINE", 0);
            f33990b = new b("LOGO", 1);
            f33991c = a();
        }
    }

    /* JADX INFO: compiled from: OAvatar.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33992a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f33993b = null;

        static {
            int[] r0 = new int[a.values().length];
            r0[a.f33986c.ordinal()] = 1;
            r0[a.f33987d.ordinal()] = 2;
            r0[a.f33988e.ordinal()] = 3;
            r0[a.f.ordinal()] = 4;
            r0[a.g.ordinal()] = 5;
            r0[a.h.ordinal()] = 6;
            r0[a.i.ordinal()] = 7;
            f33992a = r0;
            int[] r1 = new int[b.values().length];
            r1[b.f33990b.ordinal()] = 1;
            r1[b.f33989a.ordinal()] = 2;
            f33993b = r1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OAvatar(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OAvatar(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OAvatar(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8);
        this.avatarSize = a.f33986c;
        this.iconType = b.f33990b;
        this.iconBorderColor = -1;
        ConstraintLayout.inflate(r7, ZeusTransformUtils.mapRes(R.layout.o_widget_avatar, "layout", "o_widget_avatar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_avatar, DbHelper.COL_ID, "iv_avatar"));
        o.c(r9, "findViewById(R.id.iv_avatar)");
        OCircleImageView r10 = (OCircleImageView) ZeusTransformUtils.preCheckCast(r9, OCircleImageView.class, "com.obric.aiagent.plugin");
        this.ivAvatar = r10;
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_icon, DbHelper.COL_ID, "iv_icon"));
        o.c(r2, "findViewById(R.id.iv_icon)");
        this.ivIcon = (OCircleImageView) ZeusTransformUtils.preCheckCast(r2, OCircleImageView.class, "com.obric.aiagent.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_bg, DbHelper.COL_ID, "iv_bg"));
        o.c(r3, "findViewById(R.id.iv_bg)");
        this.ivBg = (AppCompatImageView) ZeusTransformUtils.preCheckCast(r3, AppCompatImageView.class, "com.obric.aiagent.plugin");
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.spacer, DbHelper.COL_ID, "spacer"));
        o.c(r0, "findViewById(R.id.spacer)");
        this.spacer = (Space) ZeusTransformUtils.preCheckCast(r0, Space.class, "com.obric.aiagent.plugin");
        setClipChildren(false);
        r10.setBorderWidth(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 1));
        r10.setBorderColor(androidx.core.content.a.c(r7, ZeusTransformUtils.mapRes(R.color.LineReverse2, "color", "LineReverse2")));
    }

    public final void setAvatarSize(a r6) {
        o.e(r6, MonitorConstants.SIZE);
        this.avatarSize = r6;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r2.width = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r6.a());
        r2.height = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r6.a());
        r0.setLayoutParams(r2);
        if (this.ivIcon.isShown() == true) goto L5;
        return;
    L5:
        if (this.ivIcon.getDrawable() != null) goto L7;
        return;
    L7:
        if (this.iconType != b.f33989a) goto L10;
        applyOnlineIconSize(r6);
        return;
    L10:
        if (this.iconType != b.f33990b) goto L16;
        applyLogoIconSize(r6);
        return;
    }

    public final void setAvatarInset(int r5) {
        View r4 = (View) ZeusTransformUtils.preCheckCast(this.ivAvatar, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).setMargins(r5, r5, r5, r5);
        r4.setLayoutParams(r1);
    }

    private final void applyOnlineIconSize(a r10) {
        float r0 = 12.0f;
        float r3 = 1.5f;
        float r5 = 0.0f;
        switch(c.f33992a[r10.ordinal()]) {
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        r0 = 0.0f;
        r3 = 0.0f;
    L13:
        applyIconSizeInternal(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r5), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r5), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r0));
        return;
    L5:
        r5 = ((2 * 2.0f) + 12.0f) + 2.0f;
    L8:
        r3 = 2.0f;
        goto L13
    L6:
        r5 = ((2 * 2.0f) + 12.0f) + 1.0f;
        goto L8
    L7:
        r5 = ((2 * 2.0f) + 10.0f) + 0.5f;
        r0 = 10.0f;
        goto L8
    L9:
        r5 = ((2 * 1.5f) + 8.0f) + 0.5f;
    L11:
        r0 = 8.0f;
        goto L13
    L10:
        r5 = ((2 * 1.5f) + 8.0f) - 0.5f;
        goto L11
    L12:
        r0 = 6.0f;
        r5 = ((2 * 1.0f) + 6.0f) - 1;
        r3 = 1.0f;
        goto L13
    }

    private final void applyLogoIconSize(a r12) {
        float r0 = 20.0f;
        float r3 = 1.0f;
        float r6 = 0.0f;
        switch(c.f33992a[r12.ordinal()]) {
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        float r13 = 0.0f;
        r0 = 0.0f;
        r3 = 0.0f;
    L13:
        applyIconSizeInternal(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r6), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r13), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r0));
        return;
    L5:
        float r14 = (2 * 2.0f) + 20.0f;
        float r7 = r14 - 2.0f;
        float r15 = r14 - 4.0f;
    L7:
        r3 = 2.0f;
    L12:
        float r10 = r7;
        r6 = r15;
        r13 = r10;
        goto L13
    L6:
        float r16 = (2 * 2.0f) + 16.0f;
        r7 = r16 - 2.0f;
        r15 = r16 - 4.0f;
        r0 = 16.0f;
        goto L7
    L8:
        float r17 = (2 * 1.5f) + 16.0f;
        r7 = r17 - 1.5f;
        r15 = r17 - 3.5f;
        r0 = 16.0f;
    L10:
        r3 = 1.5f;
        goto L12
    L9:
        float r18 = (2 * 1.5f) + 12.0f;
        r7 = r18 - 1.5f;
        r15 = r18 - 3.5f;
        r0 = 12.0f;
        goto L10
    L11:
        r0 = 10.0f;
        float r19 = (2 * 1.0f) + 10.0f;
        r7 = r19 - 1.0f;
        r15 = r19 - 3.0f;
        goto L12
    }

    private final void applyIconSizeInternal(int r6, int r7, int r8, int r9) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.spacer, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r4.rightMargin = r6;
        r4.bottomMargin = r7;
        r0.setLayoutParams(r2);
        setAvatarInset(1);
        this.ivIcon.setContentPadding(0);
        this.ivIcon.setBorderWidth(r8);
        this.ivIcon.setBorderColor(this.iconBorderColor);
        View r5 = (View) ZeusTransformUtils.preCheckCast(this.ivIcon, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        Objects.requireNonNull(r10, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r11 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r10, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        int r13 = r9 + (r8 * 2);
        r12.width = r13;
        r12.height = r13;
        r5.setLayoutParams(r11);
    }

    public final void setIconBorderColor(int r1) {
        this.iconBorderColor = r1;
    }

    public final void setAvatar(Bitmap r2) {
        o.e(r2, "bitmap");
        this.ivAvatar.setImageBitmap(r2);
    }

    public final void setAvatar(Drawable r1) {
        this.ivAvatar.setImageDrawable(r1);
    }

    public final void setAvatar(int r1) {
        this.ivAvatar.setImageResource(r1);
    }

    public final void setIconType(b r2) {
        o.e(r2, "iconType");
        this.iconType = r2;
    }

    public static /* synthetic */ void setIcon$default(OAvatar r0, int r1, b r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = b.f33990b;
    L5:
        r0.setIcon(r1, r2);
    }

    public final void setIcon(int r4, b r5) {
        o.e(r5, "iconType");
        setIcon(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4), r5);
    }

    public static /* synthetic */ void setIcon$default(OAvatar r0, Drawable r1, b r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = b.f33990b;
    L5:
        r0.setIcon(r1, r2);
    }

    public final void setIcon(Drawable r4, b r5) {
        o.e(r5, "iconType");
        if (r4 != null) goto L6;
        k.b((View) ZeusTransformUtils.preCheckCast(this.ivIcon, View.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        if (getParent() != null) goto L8;
    L10:
        this.iconType = r5;
        this.ivIcon.setImageDrawable(r4);
        k.a((View) ZeusTransformUtils.preCheckCast(this.ivIcon, View.class, "com.obric.aiagent.plugin"));
        int r6 = c.f33993b[r5.ordinal()];
        if (r6 != 1) goto L13;
        applyLogoIconSize(this.avatarSize);
        return;
    L13:
        if (r6 != 2) goto L20;
        applyOnlineIconSize(this.avatarSize);
        return;
    L20:
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(getParent(), ViewGroup.class) == false) goto L10;
        ViewParent r1 = getParent();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.aiagent.plugin")).setClipChildren(false);
        goto L10
    }

    public final void hideIcon() {
        k.b((View) ZeusTransformUtils.preCheckCast(this.ivIcon, View.class, "com.obric.aiagent.plugin"));
    }

    public final void showIcon() {
        k.a((View) ZeusTransformUtils.preCheckCast(this.ivIcon, View.class, "com.obric.aiagent.plugin"));
    }

    public final OCircleImageView getContentImageView() {
        return this.ivAvatar;
    }

    public final AppCompatImageView getBackgroundImageView() {
        return this.ivBg;
    }

    public final OCircleImageView getLogoImageView() {
        return this.ivIcon;
    }
}
