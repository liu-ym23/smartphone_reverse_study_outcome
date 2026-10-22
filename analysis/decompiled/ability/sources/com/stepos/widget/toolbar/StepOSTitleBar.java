package com.stepos.widget.toolbar;

import D6.f;
import D6.n;
import D6.o;
import D7.v;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.FloatRange;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.stepos.ability.R;
import com.stepos.motionkit.fx.material.GlassEffect;
import com.stepos.widget.glass.StepOSGlassImageButton;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0087\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0019\u001a\u00020\u00122\b\b\u0001\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u0019\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001e\u0010\u0017J\u0019\u0010 \u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b \u0010\u001aJ\u000f\u0010!\u001a\u00020\u001bH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u001bH\u0016¢\u0006\u0004\b$\u0010\u001dJ\u0017\u0010'\u001a\u00020\u00122\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u00020\u00122\b\b\u0001\u0010)\u001a\u00020\u001bH\u0016¢\u0006\u0004\b*\u0010\u001dJ\u0019\u0010,\u001a\u00020\u00122\b\b\u0001\u0010+\u001a\u00020\u001bH\u0016¢\u0006\u0004\b,\u0010\u001dJ\u0019\u0010-\u001a\u00020\u00122\b\b\u0001\u0010+\u001a\u00020\u001bH\u0016¢\u0006\u0004\b-\u0010\u001dJ\u000f\u0010.\u001a\u00020\u001bH\u0017¢\u0006\u0004\b.\u0010\"J\u0019\u00100\u001a\u00020\u00122\b\b\u0001\u0010/\u001a\u00020\u001bH\u0016¢\u0006\u0004\b0\u0010\u001dJ\u000f\u00101\u001a\u00020\u001bH\u0017¢\u0006\u0004\b1\u0010\"J\u0019\u00102\u001a\u00020\u00122\b\b\u0001\u0010/\u001a\u00020\u001bH\u0016¢\u0006\u0004\b2\u0010\u001dJ\u000f\u00103\u001a\u00020\u001bH\u0017¢\u0006\u0004\b3\u0010\"J\u0019\u00104\u001a\u00020\u00122\b\b\u0001\u0010/\u001a\u00020\u001bH\u0016¢\u0006\u0004\b4\u0010\u001dJ\u000f\u00105\u001a\u00020\u001bH\u0017¢\u0006\u0004\b5\u0010\"J\u0019\u00107\u001a\u00020\u00122\b\b\u0001\u00106\u001a\u00020\u001bH\u0016¢\u0006\u0004\b7\u0010\u001dJ\u000f\u00108\u001a\u00020\u001bH\u0017¢\u0006\u0004\b8\u0010\"J\u0019\u00109\u001a\u00020\u00122\b\b\u0001\u00106\u001a\u00020\u001bH\u0016¢\u0006\u0004\b9\u0010\u001dJ\u000f\u0010:\u001a\u00020\u001bH\u0017¢\u0006\u0004\b:\u0010\"J\u0019\u0010<\u001a\u00020\u00122\b\b\u0001\u0010;\u001a\u00020\u001bH\u0016¢\u0006\u0004\b<\u0010\u001dJ\u000f\u0010=\u001a\u00020\u001bH\u0017¢\u0006\u0004\b=\u0010\"J\u0019\u0010>\u001a\u00020\u00122\b\b\u0001\u0010;\u001a\u00020\u001bH\u0016¢\u0006\u0004\b>\u0010\u001dJ\u000f\u0010?\u001a\u00020\u001bH\u0017¢\u0006\u0004\b?\u0010\"J\u0019\u0010A\u001a\u00020\u00122\b\b\u0001\u0010@\u001a\u00020\u001bH\u0016¢\u0006\u0004\bA\u0010\u001dJ\u000f\u0010B\u001a\u00020\u001bH\u0017¢\u0006\u0004\bB\u0010\"J\u0019\u0010C\u001a\u00020\u00122\b\b\u0001\u0010/\u001a\u00020\u001bH\u0016¢\u0006\u0004\bC\u0010\u001dJ\u000f\u0010D\u001a\u00020\u001bH\u0017¢\u0006\u0004\bD\u0010\"J\u0019\u0010F\u001a\u00020\u00122\b\b\u0001\u0010E\u001a\u00020\u001bH\u0016¢\u0006\u0004\bF\u0010\u001dJ\u0019\u0010I\u001a\u00020\u00122\b\u0010H\u001a\u0004\u0018\u00010GH\u0016¢\u0006\u0004\bI\u0010JJ\u0011\u0010K\u001a\u0004\u0018\u00010GH\u0016¢\u0006\u0004\bK\u0010LJ\u0019\u0010M\u001a\u00020\u00122\b\u0010H\u001a\u0004\u0018\u00010GH\u0016¢\u0006\u0004\bM\u0010JJ\u0011\u0010N\u001a\u0004\u0018\u00010GH\u0016¢\u0006\u0004\bN\u0010LJ\u000f\u0010P\u001a\u00020OH\u0017¢\u0006\u0004\bP\u0010QJ\u0019\u0010S\u001a\u00020\u00122\b\b\u0001\u0010R\u001a\u00020OH\u0016¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020OH\u0017¢\u0006\u0004\bU\u0010QJ\u0019\u0010V\u001a\u00020\u00122\b\b\u0001\u0010R\u001a\u00020OH\u0016¢\u0006\u0004\bV\u0010TJ\u0017\u0010X\u001a\u00020\u00122\u0006\u0010W\u001a\u00020%H\u0016¢\u0006\u0004\bX\u0010(J\u0017\u0010Y\u001a\u00020\u00122\u0006\u0010W\u001a\u00020%H\u0016¢\u0006\u0004\bY\u0010(J\u0017\u0010[\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020%H\u0016¢\u0006\u0004\b[\u0010(J\u000f\u0010]\u001a\u00020\\H\u0016¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\\H\u0016¢\u0006\u0004\b`\u0010aJ\u0017\u0010b\u001a\u00020\u00122\u0006\u0010W\u001a\u00020%H\u0016¢\u0006\u0004\bb\u0010(J\u0019\u0010c\u001a\u00020\u00122\b\b\u0001\u0010+\u001a\u00020\u001bH\u0016¢\u0006\u0004\bc\u0010\u001dJ\u0019\u0010d\u001a\u00020\u00122\b\b\u0001\u0010+\u001a\u00020\u001bH\u0016¢\u0006\u0004\bd\u0010\u001dJ\u0019\u0010e\u001a\u00020\u00122\b\b\u0001\u0010+\u001a\u00020\u001bH\u0016¢\u0006\u0004\be\u0010\u001dJ\u0019\u0010f\u001a\u00020\u00122\b\b\u0001\u0010+\u001a\u00020\u001bH\u0016¢\u0006\u0004\bf\u0010\u001dJ\u0019\u0010g\u001a\u00020\u00122\b\u0010H\u001a\u0004\u0018\u00010GH\u0016¢\u0006\u0004\bg\u0010JJ\u000f\u0010i\u001a\u00020hH\u0016¢\u0006\u0004\bi\u0010jJ\u0015\u0010m\u001a\b\u0012\u0004\u0012\u00020l0kH\u0016¢\u0006\u0004\bm\u0010nJ\u000f\u0010o\u001a\u00020\u001bH\u0016¢\u0006\u0004\bo\u0010\"R&\u0010s\u001a\u00020\u001b2\b\b\u0001\u0010p\u001a\u00020\u001b8W@VX\u0096\u000e¢\u0006\f\u001a\u0004\bq\u0010\"\"\u0004\br\u0010\u001dR$\u0010t\u001a\u00020%2\u0006\u0010p\u001a\u00020%8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bt\u0010u\"\u0004\bv\u0010(R$\u0010w\u001a\u00020%2\u0006\u0010p\u001a\u00020%8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bw\u0010u\"\u0004\bx\u0010(R&\u0010{\u001a\u00020\u001b2\b\b\u0001\u0010p\u001a\u00020\u001b8W@VX\u0096\u000e¢\u0006\f\u001a\u0004\by\u0010\"\"\u0004\bz\u0010\u001dR+\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u001b2\n\b\u0001\u0010p\u001a\u0004\u0018\u00010\u001b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR-\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u001b2\n\b\u0001\u0010p\u001a\u0004\u0018\u00010\u001b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0081\u0001\u0010}\"\u0005\b\u0082\u0001\u0010\u007fR-\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001b2\n\b\u0001\u0010p\u001a\u0004\u0018\u00010\u001b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0084\u0001\u0010}\"\u0005\b\u0085\u0001\u0010\u007f¨\u0006\u0088\u0001"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSTitleBar;", "Landroid/widget/FrameLayout;", "Landroid/widget/LinearLayout;", "getStartActionContainer", "()Landroid/widget/LinearLayout;", "getEndActionContainer", "getLeftActionContainer", "getRightActionContainer", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "Landroid/view/ViewGroup;", "getCenterContainer", "()Landroid/view/ViewGroup;", "Landroid/view/View;", "getCenterView", "()Landroid/view/View;", "view", "LC7/r;", "setCenterView", "(Landroid/view/View;)V", "", "getTitle", "()Ljava/lang/CharSequence;", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "", "titleResId", "(I)V", "getSubtitle", "subtitle", "setSubtitle", "getTitleGravity", "()I", "gravity", "setTitleGravity", "", "centered", "setTitleCentered", "(Z)V", TypedValues.Custom.S_COLOR, "setTitleTextColor", "resId", "setTitleTextAppearance", "setTitleTextSizeRes", "getTopPadding", "padding", "setTopPadding", "getBottomPadding", "setBottomPadding", "getSidePadding", "setSidePadding", "getActionSize", "size", "setActionSize", "getIconSize", "setIconSize", "getActionSpacing", "spacing", "setActionSpacing", "getGroupSpacing", "setGroupSpacing", "getTitleActionGap", "gap", "setTitleActionGap", "getGroupPadding", "setGroupPadding", "getTitleMaxWidth", "maxWidth", "setTitleMaxWidth", "Landroid/graphics/drawable/Drawable;", "background", "setActionBackground", "(Landroid/graphics/drawable/Drawable;)V", "getActionBackground", "()Landroid/graphics/drawable/Drawable;", "setGroupBackground", "getGroupBackground", "", "getActionCornerRadius", "()F", "radius", "setActionCornerRadius", "(F)V", "getGroupCornerRadius", "setGroupCornerRadius", "enabled", "setGlassEnabled", "setActionsEnabled", "crossWindow", "setGlassCrossWindow", "Lcom/stepos/motionkit/fx/material/GlassEffect;", "getGlassEffect", "()Lcom/stepos/motionkit/fx/material/GlassEffect;", "effect", "setGlassEffect", "(Lcom/stepos/motionkit/fx/material/GlassEffect;)V", "setIndividualActionGlassEnabled", "setBackdropScrimColorResource", "setBackdropGradientStartColorResource", "setBackdropGradientMiddleColorResource", "setBackdropGradientEndColorResource", "setBackground", "Lcom/stepos/widget/toolbar/StepOSTitleBar$GlassRenderMode;", "getGlassRenderMode", "()Lcom/stepos/widget/toolbar/StepOSTitleBar$GlassRenderMode;", "", "", "getGlassActiveIds", "()Ljava/util/Set;", "getGlassActiveCount", "value", "getTitleTextSize", "setTitleTextSize", "titleTextSize", "isPressScaleEnabled", "()Z", "setPressScaleEnabled", "isBackdropBlurEnabled", "setBackdropBlurEnabled", "getBackdropScrimColor", "setBackdropScrimColor", "backdropScrimColor", "getBackdropGradientStartColor", "()Ljava/lang/Integer;", "setBackdropGradientStartColor", "(Ljava/lang/Integer;)V", "backdropGradientStartColor", "getBackdropGradientMiddleColor", "setBackdropGradientMiddleColor", "backdropGradientMiddleColor", "getBackdropGradientEndColor", "setBackdropGradientEndColor", "backdropGradientEndColor", "GlassRenderMode", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class StepOSTitleBar extends FrameLayout {

    /* renamed from: f0, reason: collision with root package name */
    public static final /* synthetic */ int f4156f0 = 0;

    /* renamed from: A, reason: collision with root package name */
    public Drawable f4157A;

    /* renamed from: B, reason: collision with root package name */
    public View f4158B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f4159C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f4160D;
    public GlassEffect E;

    /* renamed from: F, reason: collision with root package name */
    public D6.a f4161F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f4162G;

    /* renamed from: L, reason: collision with root package name */
    public final float f4163L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f4164M;

    /* renamed from: N, reason: collision with root package name */
    public int f4165N;

    /* renamed from: O, reason: collision with root package name */
    public final float f4166O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f4167P;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f4168Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f4169R;

    /* renamed from: S, reason: collision with root package name */
    public Integer f4170S;

    /* renamed from: T, reason: collision with root package name */
    public Integer f4171T;

    /* renamed from: U, reason: collision with root package name */
    public Integer f4172U;

    /* renamed from: V, reason: collision with root package name */
    public Integer f4173V;

    /* renamed from: W, reason: collision with root package name */
    public final f f4174W;

    /* renamed from: a, reason: collision with root package name */
    public final e f4175a;

    /* renamed from: a0, reason: collision with root package name */
    public Drawable f4176a0;
    public final e b;
    public boolean b0;
    public final FrameLayout c;

    /* renamed from: c0, reason: collision with root package name */
    public final boolean f4177c0;
    public final TextView d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f4178d0;
    public final TextView e;

    /* renamed from: e0, reason: collision with root package name */
    public final D6.b f4179e0;
    public final LinearLayout f;
    public final ArrayList g;
    public final ArrayList h;
    public final ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4180j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public int f4181q;

    /* renamed from: r, reason: collision with root package name */
    public int f4182r;

    /* renamed from: s, reason: collision with root package name */
    public int f4183s;

    /* renamed from: t, reason: collision with root package name */
    public int f4184t;
    public int u;

    /* renamed from: v, reason: collision with root package name */
    public final int f4185v;

    /* renamed from: w, reason: collision with root package name */
    public int f4186w;

    /* renamed from: x, reason: collision with root package name */
    public float f4187x;
    public float y;

    /* renamed from: z, reason: collision with root package name */
    public Drawable f4188z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSTitleBar$GlassRenderMode;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class GlassRenderMode {

        /* renamed from: a, reason: collision with root package name */
        public static final GlassRenderMode f4189a;
        public static final GlassRenderMode b;
        public static final GlassRenderMode c;
        public static final /* synthetic */ GlassRenderMode[] d;

        static {
            GlassRenderMode glassRenderMode = new GlassRenderMode("DISABLED", 0);
            f4189a = glassRenderMode;
            GlassRenderMode glassRenderMode2 = new GlassRenderMode("PENDING", 1);
            b = glassRenderMode2;
            GlassRenderMode glassRenderMode3 = new GlassRenderMode("MOTION_KIT", 2);
            c = glassRenderMode3;
            GlassRenderMode[] glassRenderModeArr = {glassRenderMode, glassRenderMode2, glassRenderMode3};
            d = glassRenderModeArr;
            kotlin.enums.a.a(glassRenderModeArr);
        }

        public static GlassRenderMode valueOf(String str) {
            return (GlassRenderMode) Enum.valueOf(GlassRenderMode.class, str);
        }

        public static GlassRenderMode[] values() {
            return (GlassRenderMode[]) d.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:50:0x025e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public StepOSTitleBar(android.content.Context r21, android.util.AttributeSet r22) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 992
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.toolbar.StepOSTitleBar.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public static void a(StepOSTitleBar stepOSTitleBar) {
        stepOSTitleBar.f4178d0 = false;
        if (stepOSTitleBar.isAttachedToWindow()) {
            if (!stepOSTitleBar.f4169R || stepOSTitleBar.getWidth() <= 0 || stepOSTitleBar.getHeight() <= 0) {
                stepOSTitleBar.i(true);
                return;
            }
            float dimension = stepOSTitleBar.getResources().getDimension(R.dimen.stepos_titlebar_backdrop_blur_radius);
            stepOSTitleBar.b0 = true;
            try {
                super.setBackground(null);
                stepOSTitleBar.b0 = false;
                if (!stepOSTitleBar.f4174W.c(0, 0.0f, new d(dimension, stepOSTitleBar, stepOSTitleBar.getBackdropScrimColor(), 0))) {
                    stepOSTitleBar.b0 = true;
                    try {
                        super.setBackground(stepOSTitleBar.f4176a0);
                    } finally {
                    }
                }
                stepOSTitleBar.invalidate();
            } finally {
            }
        }
    }

    public static int k(Integer num, int i, int i6) {
        return num != null ? num.intValue() : Color.argb(U7.a.U(AbstractC1451a.t(((i6 >>> 24) & 255) / 255.0f, 0.0f, 1.0f) * 255.0f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public static int p(e eVar) {
        if (eVar.getVisibility() == 8) {
            return 0;
        }
        return eVar.getMeasuredWidth();
    }

    public final void b(View view) {
        view.setEnabled(this.f4180j);
        if ((view instanceof TextView) && !(view instanceof Button) && !(view instanceof CompoundButton)) {
            ((TextView) view).setAlpha(this.f4180j ? 1.0f : 0.3f);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                k.e(childAt, "getChildAt(...)");
                b(childAt);
            }
        }
    }

    public final Drawable c(Drawable drawable) {
        Drawable drawableNewDrawable;
        Drawable drawableMutate;
        if (drawable == null) {
            return null;
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null && (drawableNewDrawable = constantState.newDrawable(getResources())) != null && (drawableMutate = drawableNewDrawable.mutate()) != null) {
            return drawableMutate;
        }
        Drawable drawableMutate2 = drawable.mutate();
        k.e(drawableMutate2, "mutate(...)");
        return drawableMutate2;
    }

    public final D6.a d() {
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            return new n(getResources().getDisplayMetrics().density, 1);
        }
        return o.f391a.a(getResources().getDisplayMetrics().density);
    }

    public final int e(int i) {
        return getResources().getDimensionPixelSize(i);
    }

    public final float f() {
        float f = this.f4187x;
        return f > 0.0f ? f : this.o / 2.0f;
    }

    public final float g() {
        float f = this.y;
        return f > 0.0f ? f : this.o / 2.0f;
    }

    public Drawable getActionBackground() {
        return c(this.f4188z);
    }

    @FloatRange(from = 0.0d)
    /* renamed from: getActionCornerRadius, reason: from getter */
    public float getF4187x() {
        return this.f4187x;
    }

    @Px
    /* renamed from: getActionSize, reason: from getter */
    public int getO() {
        return this.o;
    }

    @Px
    /* renamed from: getActionSpacing, reason: from getter */
    public int getF4181q() {
        return this.f4181q;
    }

    /* renamed from: getBackdropGradientEndColor, reason: from getter */
    public Integer getF4173V() {
        return this.f4173V;
    }

    /* renamed from: getBackdropGradientMiddleColor, reason: from getter */
    public Integer getF4172U() {
        return this.f4172U;
    }

    /* renamed from: getBackdropGradientStartColor, reason: from getter */
    public Integer getF4171T() {
        return this.f4171T;
    }

    @ColorInt
    public int getBackdropScrimColor() {
        Integer num = this.f4170S;
        return num != null ? num.intValue() : getResources().getColor(R.color.stepos_titlebar_backdrop_scrim_top);
    }

    @Px
    /* renamed from: getBottomPadding, reason: from getter */
    public int getN() {
        return this.n;
    }

    public ViewGroup getCenterContainer() {
        return this.c;
    }

    public View getCenterView() {
        View view = this.f4158B;
        return view == null ? this.f : view;
    }

    public LinearLayout getEndActionContainer() {
        return this.b;
    }

    public int getGlassActiveCount() {
        return getGlassActiveIds().size();
    }

    public Set<String> getGlassActiveIds() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = v.Q0(this.i, this.f4167P ? this.g : EmptyList.f4893a).iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (view instanceof StepOSGlassImageButton) {
                linkedHashSet.addAll(((StepOSGlassImageButton) view).getGlassActiveIds());
            }
        }
        return linkedHashSet;
    }

    /* renamed from: getGlassEffect, reason: from getter */
    public GlassEffect getE() {
        return this.E;
    }

    public GlassRenderMode getGlassRenderMode() {
        if (!this.f4159C) {
            return GlassRenderMode.f4189a;
        }
        ArrayList arrayListQ0 = v.Q0(this.i, this.f4167P ? this.g : EmptyList.f4893a);
        if (arrayListQ0.isEmpty()) {
            return GlassRenderMode.b;
        }
        boolean z10 = true;
        if (!arrayListQ0.isEmpty()) {
            Iterator it = arrayListQ0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                View view = (View) it.next();
                if (!(view instanceof StepOSGlassImageButton ? ((StepOSGlassImageButton) view).b.d : false)) {
                    z10 = false;
                    break;
                }
            }
        }
        return z10 ? GlassRenderMode.c : GlassRenderMode.b;
    }

    public Drawable getGroupBackground() {
        return c(this.f4157A);
    }

    @FloatRange(from = 0.0d)
    /* renamed from: getGroupCornerRadius, reason: from getter */
    public float getY() {
        return this.y;
    }

    @Px
    /* renamed from: getGroupPadding, reason: from getter */
    public int getF4184t() {
        return this.f4184t;
    }

    @Px
    /* renamed from: getGroupSpacing, reason: from getter */
    public int getF4182r() {
        return this.f4182r;
    }

    @Px
    /* renamed from: getIconSize, reason: from getter */
    public int getP() {
        return this.p;
    }

    public LinearLayout getLeftActionContainer() {
        return this.f4175a;
    }

    public LinearLayout getRightActionContainer() {
        return this.b;
    }

    @Px
    /* renamed from: getSidePadding, reason: from getter */
    public int getL() {
        return this.l;
    }

    public LinearLayout getStartActionContainer() {
        return this.f4175a;
    }

    public CharSequence getSubtitle() {
        CharSequence text = this.e.getText();
        k.e(text, "getText(...)");
        return text;
    }

    public CharSequence getTitle() {
        CharSequence text = this.d.getText();
        k.e(text, "getText(...)");
        return text;
    }

    @Px
    /* renamed from: getTitleActionGap, reason: from getter */
    public int getF4183s() {
        return this.f4183s;
    }

    /* renamed from: getTitleGravity, reason: from getter */
    public int getK() {
        return this.k;
    }

    @Px
    /* renamed from: getTitleMaxWidth, reason: from getter */
    public int getU() {
        return this.u;
    }

    @Px
    /* renamed from: getTitleTextSize, reason: from getter */
    public int getF4165N() {
        return this.f4165N;
    }

    /* renamed from: getTitleView, reason: from getter */
    public TextView getD() {
        return this.d;
    }

    @Px
    /* renamed from: getTopPadding, reason: from getter */
    public int getM() {
        return this.m;
    }

    public final void h(e eVar, int i, int i6, int i10, Float f) {
        int iRound;
        if (f == null) {
            iRound = ((i10 - eVar.getMeasuredHeight()) / 2) + getPaddingTop();
        } else {
            iRound = Math.round(f.floatValue() - (eVar.getMeasuredHeight() / 2.0f));
        }
        eVar.layout(i, iRound, i6, eVar.getMeasuredHeight() + iRound);
    }

    public final void i(boolean z10) {
        this.f4174W.d();
        if (z10) {
            this.b0 = true;
            try {
                super.setBackground(this.f4176a0);
            } finally {
                this.b0 = false;
            }
        }
    }

    public final void j() {
        if (this.f4169R && isAttachedToWindow() && !this.f4178d0) {
            this.f4178d0 = true;
            post(this.f4179e0);
        }
    }

    public final void l(ImageButton imageButton) throws Resources.NotFoundException {
        Drawable drawable;
        boolean z10 = imageButton instanceof StepOSGlassImageButton;
        StepOSGlassImageButton stepOSGlassImageButton = z10 ? (StepOSGlassImageButton) imageButton : null;
        if (stepOSGlassImageButton != null) {
            if (this.f4159C && this.f4167P) {
                drawable = null;
            } else {
                Drawable drawableC = c(this.f4188z);
                boolean z11 = drawableC instanceof ColorDrawable;
                drawable = drawableC;
                if (z11) {
                    int color = ((ColorDrawable) drawableC).getColor();
                    float f = f();
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(color);
                    gradientDrawable.setCornerRadius(f);
                    drawable = gradientDrawable;
                } else if (drawableC == null) {
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setCornerRadius(f());
                    drawable = gradientDrawable2;
                }
            }
            stepOSGlassImageButton.setSurfaceDrawable(drawable);
        }
        E6.e.a(imageButton, getContext().getColor(R.color.stepos_titlebar_action_ripple), Math.max(0.0f, f()), false, f());
        StepOSGlassImageButton stepOSGlassImageButton2 = z10 ? (StepOSGlassImageButton) imageButton : null;
        if (stepOSGlassImageButton2 != null) {
            stepOSGlassImageButton2.setPressScaleEnabled(this.f4168Q);
        }
    }

    public final void m(LinearLayout linearLayout) {
        int childCount = linearLayout.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = linearLayout.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).setMarginStart(i == 0 ? 0 : this.f4181q);
                childAt.setLayoutParams(layoutParams);
            }
            i++;
        }
    }

    public final void n(LinearLayout linearLayout) throws Resources.NotFoundException {
        if (!k.b(linearLayout.getTag(R.id.stepos_titlebar_action_group), Boolean.TRUE)) {
            float fG = g();
            E6.e.a(linearLayout, getContext().getColor(R.color.stepos_titlebar_action_ripple), Math.max(0.0f, fG), this.f4168Q, fG);
            return;
        }
        int color = getContext().getColor(R.color.stepos_titlebar_action_ripple);
        float fMax = Math.max(0.0f, g());
        boolean z10 = this.f4168Q;
        float fG2 = g();
        linearLayout.setAddStatesFromChildren(true);
        E6.e.a(linearLayout, color, fMax, z10, fG2);
    }

    public final void o(ImageButton imageButton) {
        ViewGroup.LayoutParams layoutParams = imageButton.getLayoutParams();
        if (layoutParams == null) {
            int i = this.p;
            layoutParams = new LinearLayout.LayoutParams(i, i);
        }
        int i6 = this.p;
        layoutParams.width = i6;
        layoutParams.height = i6;
        imageButton.setLayoutParams(layoutParams);
        imageButton.setPadding(0, 0, 0, 0);
        imageButton.setBackground(null);
        imageButton.setForeground(null);
        imageButton.setClipToOutline(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4169R) {
            j();
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration newConfig) throws Resources.NotFoundException {
        k.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        boolean z10 = this.f4159C;
        ArrayList arrayList = this.i;
        ArrayList arrayList2 = this.g;
        if (z10 && this.f4162G && this.f4161F != null) {
            D6.a aVarD = d();
            this.f4161F = aVarD;
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof StepOSGlassImageButton) {
                    arrayList3.add(next);
                }
            }
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                StepOSGlassImageButton stepOSGlassImageButton = (StepOSGlassImageButton) it2.next();
                stepOSGlassImageButton.getClass();
                stepOSGlassImageButton.e = aVarD;
                stepOSGlassImageButton.a();
                stepOSGlassImageButton.b();
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                it3.next();
            }
            Iterator it4 = arrayList4.iterator();
            if (it4.hasNext()) {
                throw B7.a.f(it4);
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            l((ImageButton) it5.next());
        }
        Iterator it6 = arrayList.iterator();
        while (it6.hasNext()) {
            n((LinearLayout) it6.next());
        }
        if (this.f4169R) {
            j();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f4179e0);
        this.f4178d0 = false;
        i(false);
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.toolbar.StepOSTitleBar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        int i10;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int iMax = mode == 0 ? 536870911 : Math.max(0, size - paddingRight);
        int iMax2 = mode2 != 0 ? Math.max(0, size2 - paddingBottom) : 536870911;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax2, Integer.MIN_VALUE);
        e eVar = this.f4175a;
        eVar.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        e eVar2 = this.b;
        eVar2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        View centerView = getCenterView();
        boolean z10 = (centerView.getVisibility() == 8 || (this.f4158B == null && TextUtils.isEmpty(this.d.getText()))) ? false : true;
        if (z10) {
            centerView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        }
        int iP = p(eVar);
        int iP2 = p(eVar2);
        int measuredWidth = z10 ? centerView.getMeasuredWidth() : 0;
        if (this.f4158B == null && (i10 = this.u) > 0) {
            measuredWidth = Math.min(measuredWidth, i10);
        }
        int i11 = (!z10 || iP <= 0) ? 0 : this.f4183s;
        int i12 = (!z10 || iP2 <= 0) ? 0 : this.f4183s;
        int iResolveSize = View.resolveSize(paddingRight + iP + iP2 + i11 + i12 + measuredWidth, i);
        int iMin = !z10 ? 0 : Math.min(measuredWidth, Math.max(0, (((Math.max(0, iResolveSize - paddingRight) - iP) - iP2) - i11) - i12));
        int iResolveSize2 = View.resolveSize(Math.max(this.f4185v, Math.max(eVar.getMeasuredHeight(), Math.max(eVar2.getMeasuredHeight(), z10 ? centerView.getMeasuredHeight() : 0)) + paddingBottom), i6);
        int iMax3 = Math.max(0, iResolveSize2 - paddingBottom);
        if (z10) {
            centerView.forceLayout();
        }
        FrameLayout frameLayout = this.c;
        frameLayout.forceLayout();
        frameLayout.measure(View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(iMax3, BasicMeasure.EXACTLY));
        setMeasuredDimension(iResolveSize, iResolveSize2);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        if (this.f4169R) {
            j();
        }
    }

    public void setActionBackground(Drawable background) throws Resources.NotFoundException {
        this.f4188z = c(background);
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            l((ImageButton) it.next());
        }
    }

    public void setActionCornerRadius(@FloatRange(from = 0.0d) float radius) throws Resources.NotFoundException {
        this.f4187x = Math.max(0.0f, radius);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.g;
        for (Object obj : arrayList2) {
            if (obj instanceof StepOSGlassImageButton) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((StepOSGlassImageButton) it.next()).setGlassCornerRadius(this.f4187x);
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            l((ImageButton) it2.next());
        }
    }

    public void setActionSize(@Px int size) throws Resources.NotFoundException {
        if (size < 1) {
            throw new IllegalArgumentException(B7.a.h(size, "actionSize must be >= 1 but was ").toString());
        }
        this.o = size;
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ImageButton imageButton = (ImageButton) it.next();
            ViewGroup.LayoutParams layoutParams = imageButton.getLayoutParams();
            if (layoutParams == null) {
                int i = this.o;
                layoutParams = new LinearLayout.LayoutParams(i, i);
            }
            int i6 = this.o;
            layoutParams.width = i6;
            layoutParams.height = i6;
            imageButton.setLayoutParams(layoutParams);
            int iMax = Math.max(0, (this.o - this.p) / 2);
            imageButton.setPadding(iMax, iMax, iMax, iMax);
            imageButton.setMinimumWidth(this.o);
            imageButton.setMinimumHeight(this.o);
            l(imageButton);
        }
        Iterator it2 = this.h.iterator();
        while (it2.hasNext()) {
            o((ImageButton) it2.next());
        }
        Iterator it3 = this.i.iterator();
        while (it3.hasNext()) {
            LinearLayout linearLayout = (LinearLayout) it3.next();
            linearLayout.setMinimumHeight(this.o);
            n(linearLayout);
        }
        requestLayout();
    }

    public void setActionSpacing(@Px int spacing) {
        if (spacing < 0) {
            throw new IllegalArgumentException(B7.a.h(spacing, "actionSpacing must be >= 0 but was ").toString());
        }
        this.f4181q = spacing;
        m(this.f4175a);
        m(this.b);
        requestLayout();
    }

    public void setActionsEnabled(boolean enabled) {
        if (this.f4180j == enabled) {
            return;
        }
        this.f4180j = enabled;
        b(this.f4175a);
        b(this.b);
    }

    public void setBackdropBlurEnabled(boolean z10) {
        if (this.f4169R == z10) {
            return;
        }
        this.f4169R = z10;
        if (z10) {
            j();
        } else {
            i(true);
        }
    }

    public void setBackdropGradientEndColor(@ColorInt Integer num) {
        if (k.b(this.f4173V, num)) {
            return;
        }
        this.f4173V = num;
        j();
    }

    public void setBackdropGradientEndColorResource(@ColorRes int resId) {
        setBackdropGradientEndColor(Integer.valueOf(resId == 0 ? 0 : getContext().getColor(resId)));
    }

    public void setBackdropGradientMiddleColor(@ColorInt Integer num) {
        if (k.b(this.f4172U, num)) {
            return;
        }
        this.f4172U = num;
        j();
    }

    public void setBackdropGradientMiddleColorResource(@ColorRes int resId) {
        setBackdropGradientMiddleColor(Integer.valueOf(resId == 0 ? 0 : getContext().getColor(resId)));
    }

    public void setBackdropGradientStartColor(@ColorInt Integer num) {
        if (k.b(this.f4171T, num)) {
            return;
        }
        this.f4171T = num;
        j();
    }

    public void setBackdropGradientStartColorResource(@ColorRes int resId) {
        setBackdropGradientStartColor(Integer.valueOf(resId == 0 ? 0 : getContext().getColor(resId)));
    }

    public void setBackdropScrimColor(@ColorInt int i) {
        Integer num = this.f4170S;
        if (num != null && num.intValue() == i) {
            return;
        }
        this.f4170S = Integer.valueOf(i);
        j();
    }

    public void setBackdropScrimColorResource(@ColorRes int resId) {
        setBackdropScrimColor(getContext().getColor(resId));
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        if (!this.f4177c0 || this.b0) {
            super.setBackground(background);
            return;
        }
        this.f4176a0 = background;
        if (this.f4174W.d) {
            return;
        }
        super.setBackground(background);
    }

    public void setBottomPadding(@Px int padding) {
        int iMax = Math.max(0, padding);
        this.n = iMax;
        int i = this.l;
        setPaddingRelative(i, this.m, i, iMax);
        requestLayout();
    }

    public void setCenterView(View view) {
        LinearLayout linearLayout = this.f;
        FrameLayout frameLayout = this.c;
        if (view == null) {
            View view2 = this.f4158B;
            if (view2 != null) {
                frameLayout.removeView(view2);
                this.f4158B = null;
            }
            linearLayout.setVisibility(0);
            requestLayout();
            return;
        }
        if (view == this.f4158B) {
            return;
        }
        if (view.getParent() != null) {
            throw new IllegalStateException("The center view already has a parent");
        }
        View view3 = this.f4158B;
        if (view3 != null) {
            frameLayout.removeView(view3);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : layoutParams == null ? new FrameLayout.LayoutParams(-2, -2) : new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
        if (layoutParams2.gravity == -1) {
            layoutParams2.gravity = 17;
        }
        this.f4158B = view;
        linearLayout.setVisibility(8);
        frameLayout.addView(view, layoutParams2);
        requestLayout();
    }

    public void setGlassCrossWindow(boolean crossWindow) {
        if (this.f4160D == crossWindow) {
            return;
        }
        this.f4160D = crossWindow;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof StepOSGlassImageButton) {
                arrayList.add(next);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((StepOSGlassImageButton) it2.next()).setGlassCrossWindow(crossWindow);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it3 = this.i.iterator();
        while (it3.hasNext()) {
            it3.next();
        }
        Iterator it4 = arrayList2.iterator();
        if (it4.hasNext()) {
            throw B7.a.f(it4);
        }
    }

    public void setGlassEffect(GlassEffect effect) {
        k.f(effect, "effect");
        boolean z10 = this.f4161F != null;
        this.f4161F = null;
        this.f4162G = false;
        if (!k.b(this.E, effect) || z10) {
            this.E = effect;
            ArrayList arrayList = new ArrayList();
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof StepOSGlassImageButton) {
                    arrayList.add(next);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((StepOSGlassImageButton) it2.next()).setGlassEffect(effect);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = this.i.iterator();
            while (it3.hasNext()) {
                it3.next();
            }
            Iterator it4 = arrayList2.iterator();
            if (it4.hasNext()) {
                throw B7.a.f(it4);
            }
        }
    }

    public void setGlassEnabled(boolean enabled) throws Resources.NotFoundException {
        if (this.f4159C == enabled) {
            return;
        }
        this.f4159C = enabled;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.g;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof StepOSGlassImageButton) {
                arrayList.add(next);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((StepOSGlassImageButton) it2.next()).setGlassEnabled(enabled && this.f4167P);
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = this.i;
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            it3.next();
        }
        Iterator it4 = arrayList3.iterator();
        if (it4.hasNext()) {
            throw B7.a.f(it4);
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            l((ImageButton) it5.next());
        }
        Iterator it6 = arrayList4.iterator();
        while (it6.hasNext()) {
            n((LinearLayout) it6.next());
        }
    }

    public void setGroupBackground(Drawable background) throws Resources.NotFoundException {
        this.f4157A = c(background);
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            n((LinearLayout) it.next());
        }
    }

    public void setGroupCornerRadius(@FloatRange(from = 0.0d) float radius) throws Resources.NotFoundException {
        this.y = Math.max(0.0f, radius);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.i;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            it.next();
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            throw B7.a.f(it2);
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            n((LinearLayout) it3.next());
        }
    }

    public void setGroupPadding(@Px int padding) {
        this.f4184t = Math.max(0, padding);
        for (LinearLayout linearLayout : this.i) {
            int i = this.f4184t;
            linearLayout.setPadding(i, 0, i, 0);
        }
        requestLayout();
    }

    public void setGroupSpacing(@Px int spacing) {
        this.f4182r = Math.max(0, spacing);
        for (LinearLayout linearLayout : this.i) {
            int childCount = linearLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = linearLayout.getChildAt(i);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.setMarginStart(i == 0 ? 0 : this.f4182r);
                    int i6 = this.p;
                    layoutParams2.width = i6;
                    layoutParams2.height = i6;
                    childAt.setLayoutParams(layoutParams);
                }
                i++;
            }
        }
        requestLayout();
    }

    public void setIconSize(@Px int size) {
        if (size < 1) {
            throw new IllegalArgumentException(B7.a.h(size, "iconSize must be >= 1 but was ").toString());
        }
        this.p = size;
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ImageButton imageButton = (ImageButton) it.next();
            int iMax = Math.max(0, (this.o - this.p) / 2);
            imageButton.setPadding(iMax, iMax, iMax, iMax);
            imageButton.setMinimumWidth(this.o);
            imageButton.setMinimumHeight(this.o);
        }
        Iterator it2 = this.h.iterator();
        while (it2.hasNext()) {
            o((ImageButton) it2.next());
        }
        requestLayout();
    }

    public void setIndividualActionGlassEnabled(boolean enabled) throws Resources.NotFoundException {
        if (this.f4167P == enabled) {
            return;
        }
        this.f4167P = enabled;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.g;
        for (Object obj : arrayList2) {
            if (obj instanceof StepOSGlassImageButton) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((StepOSGlassImageButton) it.next()).setGlassEnabled(this.f4159C && enabled);
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            l((ImageButton) it2.next());
        }
    }

    public final void setPressScaleEnabled(boolean z10) {
        if (this.f4168Q == z10) {
            return;
        }
        this.f4168Q = z10;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof StepOSGlassImageButton) {
                arrayList.add(next);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((StepOSGlassImageButton) it2.next()).setPressScaleEnabled(z10);
        }
        E6.e.b(this, z10);
    }

    public void setSidePadding(@Px int padding) {
        int iMax = Math.max(0, padding);
        this.l = iMax;
        setPaddingRelative(iMax, this.m, iMax, this.n);
        requestLayout();
    }

    public void setSubtitle(CharSequence subtitle) {
        boolean z10 = subtitle == null || subtitle.length() == 0;
        TextView textView = this.e;
        textView.setText(subtitle);
        textView.setVisibility(!z10 ? 0 : 8);
        int iE = !z10 ? e(R.dimen.stepos_titlebar_subtitle_title_row_height) : 0;
        TextView textView2 = this.d;
        textView2.setMinimumHeight(iE);
        if (!this.f4164M) {
            textView2.setTextSize(0, !z10 ? this.f4166O : this.f4163L);
        }
        requestLayout();
    }

    public void setTitle(CharSequence title) {
        TextView textView = this.d;
        textView.setText(title);
        textView.forceLayout();
        this.f.forceLayout();
        this.c.forceLayout();
        requestLayout();
    }

    public void setTitleActionGap(@Px int gap) {
        this.f4183s = Math.max(0, gap);
        requestLayout();
    }

    public void setTitleCentered(boolean centered) {
        setTitleGravity(centered ? 1 : 0);
    }

    public void setTitleGravity(int gravity) {
        if (gravity != 0 && gravity != 1) {
            throw new IllegalArgumentException(B7.a.h(gravity, "Unsupported title gravity: ").toString());
        }
        if (this.k != gravity) {
            this.k = gravity;
            int i = gravity == 1 ? 17 : 8388627;
            this.d.setGravity(i);
            this.e.setGravity(i);
            requestLayout();
        }
    }

    public void setTitleMaxWidth(@Px int maxWidth) {
        int iMax = Math.max(0, maxWidth);
        this.u = iMax;
        if (iMax <= 0) {
            iMax = Integer.MAX_VALUE;
        }
        this.d.setMaxWidth(iMax);
        requestLayout();
    }

    public void setTitleTextAppearance(@StyleRes int resId) {
        this.d.setTextAppearance(getContext(), resId);
    }

    public void setTitleTextColor(@ColorInt int color) {
        this.f4186w = color;
        this.d.setTextColor(color);
    }

    public void setTitleTextSize(@Px int i) {
        if (i < 0) {
            throw new IllegalArgumentException(B7.a.h(i, "titleTextSize must be >= 0 but was ").toString());
        }
        if (this.f4165N == i) {
            return;
        }
        this.f4165N = i;
        this.f4164M = i > 0;
        this.d.setTextSize(0, i > 0 ? i : this.f4163L);
        requestLayout();
    }

    public void setTitleTextSizeRes(@DimenRes int resId) {
        setTitleTextSize(getResources().getDimensionPixelSize(resId));
    }

    public void setTopPadding(@Px int padding) {
        int iMax = Math.max(0, padding);
        this.m = iMax;
        int i = this.l;
        setPaddingRelative(i, iMax, i, this.n);
        requestLayout();
    }

    public void setTitle(@StringRes int titleResId) {
        TextView textView = this.d;
        textView.setText(titleResId);
        textView.forceLayout();
        this.f.forceLayout();
        this.c.forceLayout();
        requestLayout();
    }
}
