package com.stepos.ailauncher.container.glass;

import A7.B;
import A7.C0743k;
import A7.C0746n;
import A7.C0757z;
import A7.L;
import A7.Z;
import Y8.t;
import Z8.C1172u;
import Z8.C1173v;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import p9.InterfaceC5074l;
import v9.C5685n;
import y7.C;
import y7.E;
import y7.F;
import y7.G;
import y7.H;
import y7.o;
import y7.s;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0019\u001a\u00020\u0018*\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001c0\u001b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010#\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$JA\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010%\u001a\u00020\u00162\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020\u0016¢\u0006\u0004\b+\u0010,J+\u0010-\u001a\u0004\u0018\u00010*2\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010%\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b-\u0010.J5\u00101\u001a\u0004\u0018\u00010*2\u0006\u0010 \u001a\u00020\u001f2\u0006\u00100\u001a\u00020/2\b\b\u0002\u0010%\u001a\u00020\u00162\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020\n2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\r2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b5\u00106J!\u00108\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\u001c2\u0006\u00107\u001a\u00020\r¢\u0006\u0004\b8\u00109J=\u0010<\u001a\u0004\u0018\u00010*2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\r2\b\b\u0002\u0010%\u001a\u00020\u00162\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b<\u0010=J5\u0010?\u001a\u0004\u0018\u00010*2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010>\u001a\u00020\r2\b\b\u0002\u0010%\u001a\u00020\u00162\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b?\u0010@J'\u0010C\u001a\u00020\u00182\b\u0010A\u001a\u0004\u0018\u00010*2\u0006\u0010&\u001a\u00020\r2\u0006\u0010B\u001a\u00020\u001f¢\u0006\u0004\bC\u0010DJ9\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010 \u001a\u00020\u001f2\b\u0010A\u001a\u0004\u0018\u00010*2\u0016\b\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0018\u0018\u00010E¢\u0006\u0004\bH\u0010IJ\u0015\u0010J\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\bJ\u0010KJ\u0017\u0010L\u001a\u00020\u00182\b\u0010A\u001a\u0004\u0018\u00010*¢\u0006\u0004\bL\u0010MJ\u001d\u0010N\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\r¢\u0006\u0004\bN\u0010OJ\u001d\u0010P\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\r¢\u0006\u0004\bP\u0010OJI\u0010T\u001a\u0004\u0018\u00010*2\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010%\u001a\u00020\u00162\u000e\b\u0002\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0\u00062\u0016\b\u0002\u0010S\u001a\u0010\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020\u0018\u0018\u00010E¢\u0006\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082T¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Y\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\bY\u0010LR\u0014\u0010Z\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\bZ\u0010LR\u0014\u0010[\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b[\u0010LR\u0014\u0010\\\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\\\u0010LR\u0014\u0010]\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b]\u0010LR\u0014\u0010^\u001a\u00020V8\u0002X\u0082T¢\u0006\u0006\n\u0004\b^\u0010XR\u0014\u0010_\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b_\u0010LR\u0014\u0010`\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b`\u00105R\u0014\u0010a\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\ba\u0010LR\u0014\u0010b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bb\u00105R\u0014\u0010c\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bc\u00105R\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020*0d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR \u0010h\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020!0g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR \u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020G0g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010i¨\u0006k"}, d2 = {"Lcom/stepos/ailauncher/container/glass/h;", "", "<init>", "()V", "Ly7/F;", "P", "Ly7/C;", "params", "N", "(Ly7/C;Ly7/F;)Ly7/C;", "", "from", "to", "", "t", ExifInterface.LONGITUDE_EAST, "(IIF)I", "rgb", "pct", "L", "(II)I", "LA7/n;", "", "keyboardUp", "LY8/t;", "C", "(LA7/n;Z)V", "", "Lkotlin/Pair;", "D", "(Z)Ljava/util/List;", "Landroid/view/View;", "target", "Landroid/graphics/drawable/Drawable;", "backplate", "H", "(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V", "crossWindow", "cornerRadiusDp", "Ly7/o;", "effect", "innerShadow", "Ly7/E;", "l", "(Landroid/view/View;ZLjava/lang/Float;Ly7/o;Z)Ly7/E;", "q", "(Landroid/view/View;ZZ)Ly7/E;", "Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;", "style", "y", "(Landroid/view/View;Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;ZLjava/lang/Float;)Ly7/E;", "K", "(Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;)I", "I", "(Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;)F", "fraction", "J", "(F)Lkotlin/Pair;", "tint", "blurRadius", "x", "(Landroid/view/View;IFZLjava/lang/Float;)Ly7/E;", "radiusDp", "n", "(Landroid/view/View;FZLjava/lang/Float;)Ly7/E;", "handle", "targetView", "M", "(Ly7/E;FLandroid/view/View;)V", "Lkotlin/Function1;", "onReleased", "Landroid/view/View$OnAttachStateChangeListener;", "G", "(Landroid/view/View;Ly7/E;Lp9/l;)Landroid/view/View$OnAttachStateChangeListener;", "B", "(Landroid/view/View;)V", "F", "(Ly7/E;)V", "k", "(Landroid/view/View;F)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LA7/B;", ChatTracker.SEND_PRESET, "configure", "u", "(Landroid/view/View;ZLy7/C;Lp9/l;)Ly7/E;", "", "TAG", "Ljava/lang/String;", "HALF_SHEET_BLUR_RADIUS_PX", "FULL_SHEET_BLUR_RADIUS_PX", "HALF_SHEET_SPLAY", "HALF_SHEET_STROKE_INTENSITY", "GREETING_CAPTURE_BLUR_PX", "GLASS_TEXT_ID", "ALL_TASKS_INNER_SHADOW_RADIUS_DP", "ALL_TASKS_BLEND1_PCT", "HALF_SHEET_LIGHT_ANGLE_DEG", "HALF_SHEET_TINT_COLOR", "FULL_SHEET_TINT_COLOR", "", "releasedHandles", "Ljava/util/Set;", "", "crossWindowBackplates", "Ljava/util/Map;", "backplateDetachWatchers", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h {
    private static final int ALL_TASKS_BLEND1_PCT = 6;
    private static final float ALL_TASKS_INNER_SHADOW_RADIUS_DP = 10.0f;
    private static final float FULL_SHEET_BLUR_RADIUS_PX = 120.0f;
    private static final int FULL_SHEET_TINT_COLOR = -233170406;
    private static final String GLASS_TEXT_ID = "glass_text";
    private static final float GREETING_CAPTURE_BLUR_PX = 300.0f;
    private static final float HALF_SHEET_BLUR_RADIUS_PX = 240.0f;
    private static final float HALF_SHEET_LIGHT_ANGLE_DEG = 0.0f;
    private static final float HALF_SHEET_SPLAY = 20.0f;
    private static final float HALF_SHEET_STROKE_INTENSITY = 0.0f;
    private static final int HALF_SHEET_TINT_COLOR = -652600806;
    public static final h INSTANCE = new h();
    private static final String TAG = "PanelGlass";
    private static final Map<View, View.OnAttachStateChangeListener> backplateDetachWatchers;
    private static final Map<View, Drawable> crossWindowBackplates;
    private static final Set<E> releasedHandles;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetGlassStyle.values().length];
            try {
                iArr[SheetGlassStyle.HALF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetGlassStyle.FULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/container/glass/h$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends ViewOutlineProvider {
        final /* synthetic */ float $radiusPx;

        public b(float f10) {
            this.$radiusPx = f10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            p.i(view, "view");
            p.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.$radiusPx);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/container/glass/h$c", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends ViewOutlineProvider {
        final /* synthetic */ float $radiusPx;

        public c(float f10) {
            this.$radiusPx = f10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            p.i(view, "view");
            p.i(outline, "outline");
            int width = view.getWidth();
            int height = view.getHeight();
            float f10 = this.$radiusPx;
            outline.setRoundRect(0, 0, width, height + ((int) f10), f10);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/container/glass/h$d", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements View.OnAttachStateChangeListener {
        final /* synthetic */ E $handle;
        final /* synthetic */ InterfaceC5074l<E, t> $onReleased;

        /* JADX WARN: Multi-variable type inference failed */
        public d(E e10, InterfaceC5074l<? super E, t> interfaceC5074l) {
            this.$handle = e10;
            this.$onReleased = interfaceC5074l;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            p.i(v10, "v");
            v10.removeOnAttachStateChangeListener(this);
            h.INSTANCE.F(this.$handle);
            InterfaceC5074l<E, t> interfaceC5074l = this.$onReleased;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(this.$handle);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/container/glass/h$e", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            p.i(v10, "v");
            if (v10.isTemporarilyDetached()) {
                return;
            }
            h.crossWindowBackplates.remove(v10);
            h.backplateDetachWatchers.remove(v10);
            v10.removeOnAttachStateChangeListener(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [P] */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"com/stepos/ailauncher/container/glass/h$f", "Ly7/C;", Const.INTENT_KEY_PKGNAME, "()Ly7/F;", "Landroid/content/Context;", "context", "", "isSupported", "(Landroid/content/Context;)Z", "Landroid/view/View;", "view", "params", "Ly7/s;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Ly7/F;)Ly7/s;", "", "getId", "()Ljava/lang/String;", "id", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f<P> implements C<P> {
        private final /* synthetic */ C<P> $$delegate_0;

        /* JADX INFO: Incorrect field signature: TP; */
        final /* synthetic */ F $params;

        /* JADX WARN: Incorrect types in method signature: (Ly7/C<TP;>;TP;)V */
        public f(C c10, F f10) {
            this.$params = f10;
            this.$$delegate_0 = c10;
        }

        /* JADX WARN: Incorrect types in method signature: (Landroid/view/View;TP;)Ly7/s; */
        @Override // y7.C
        public s a(View view, F params) {
            p.i(view, "view");
            p.i(params, "params");
            return this.$$delegate_0.a(view, params);
        }

        /* JADX WARN: Incorrect return type in method signature: ()TP; */
        @Override // y7.C
        /* renamed from: b, reason: from getter */
        public F get$params() {
            return this.$params;
        }

        @Override // y7.C
        public String getId() {
            return this.$$delegate_0.getId();
        }

        @Override // y7.C
        public boolean isSupported(Context context) {
            p.i(context, "context");
            return this.$$delegate_0.isSupported(context);
        }
    }

    static {
        Set<E> setNewSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        p.h(setNewSetFromMap, "newSetFromMap(...)");
        releasedHandles = setNewSetFromMap;
        crossWindowBackplates = new WeakHashMap();
        backplateDetachWatchers = new WeakHashMap();
    }

    public static final t A(double d10, Z apply) {
        p.i(apply, "$this$apply");
        apply.C(0.0f);
        apply.I(20.0f);
        apply.D((float) Math.cos(d10));
        apply.E((float) Math.sin(d10));
        apply.F(apply.getLight0X());
        apply.G(apply.getLight0Y());
        return t.f7040a;
    }

    public static /* synthetic */ E m(h hVar, View view, boolean z10, Float f10, o oVar, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            f10 = null;
        }
        if ((i10 & 8) != 0) {
            oVar = o.INSTANCE.l();
        }
        if ((i10 & 16) != 0) {
            z11 = true;
        }
        return hVar.l(view, z10, f10, oVar, z11);
    }

    public static /* synthetic */ E o(h hVar, View view, float f10, boolean z10, Float f11, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        if ((i10 & 8) != 0) {
            f11 = null;
        }
        return hVar.n(view, f10, z10, f11);
    }

    public static final t p(float f10, float f11, C0746n apply) {
        p.i(apply, "$this$apply");
        apply.n(f10 * f11);
        return t.f7040a;
    }

    public static final t r(boolean z10, C0746n apply) {
        p.i(apply, "$this$apply");
        INSTANCE.C(apply, z10);
        return t.f7040a;
    }

    public static final t s(boolean z10, C0743k apply) {
        p.i(apply, "$this$apply");
        apply.f(INSTANCE.D(z10));
        return t.f7040a;
    }

    public static final t t(C0757z glassText) {
        p.i(glassText, "$this$glassText");
        glassText.i(0.0f);
        return t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ E v(h hVar, View view, boolean z10, C c10, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            c10 = G.a.f43886a.f();
        }
        if ((i10 & 8) != 0) {
            interfaceC5074l = null;
        }
        return hVar.u(view, z10, c10, interfaceC5074l);
    }

    public static final t w(InterfaceC5074l interfaceC5074l, B apply) {
        p.i(apply, "$this$apply");
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(apply);
        }
        return t.f7040a;
    }

    public static final t z(float f10, int i10, C0746n apply) {
        p.i(apply, "$this$apply");
        apply.n(f10);
        apply.o(i10);
        return t.f7040a;
    }

    public final void B(View target) {
        p.i(target, "target");
        Drawable background = target.getBackground();
        if (background == null || background == crossWindowBackplates.get(target)) {
            return;
        }
        target.setBackground(null);
    }

    public final void C(C0746n c0746n, boolean z10) {
        if (z10) {
            c0746n.n(1.0f);
            c0746n.o(-1);
            c0746n.k(0.0f);
            c0746n.l(0.0f);
            c0746n.m(false);
            return;
        }
        c0746n.n(300.0f);
        c0746n.o(16777215);
        c0746n.k(0.0f);
        c0746n.l(0.0f);
        c0746n.m(false);
    }

    public final List<Pair<Integer, Integer>> D(boolean keyboardUp) {
        return keyboardUp ? C1172u.e(Y8.j.a(0, -1)) : C1173v.p(Y8.j.a(3, Integer.valueOf(L(16777215, 50))), Y8.j.a(3, Integer.valueOf(L(16777215, 100))), Y8.j.a(0, Integer.valueOf(L(16777215, 15))));
    }

    public final int E(int from, int to, float t10) {
        return C5685n.n((int) (from + ((to - from) * t10)), 0, 255);
    }

    public final void F(E handle) {
        Object objB;
        if (handle == null) {
            return;
        }
        Set<E> set = releasedHandles;
        synchronized (set) {
            if (set.add(handle)) {
                t tVar = t.f7040a;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    handle.g();
                    objB = Result.b(t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    Log.w(TAG, "release: handle.release() threw " + thE.getClass().getSimpleName() + ": " + thE.getMessage());
                }
            }
        }
    }

    public final View.OnAttachStateChangeListener G(View target, E handle, InterfaceC5074l<? super E, t> onReleased) {
        p.i(target, "target");
        if (handle == null) {
            return null;
        }
        d dVar = new d(handle, onReleased);
        target.addOnAttachStateChangeListener(dVar);
        return dVar;
    }

    public final void H(View target, Drawable backplate) {
        crossWindowBackplates.put(target, backplate);
        Map<View, View.OnAttachStateChangeListener> map = backplateDetachWatchers;
        if (map.containsKey(target)) {
            return;
        }
        e eVar = new e();
        map.put(target, eVar);
        target.addOnAttachStateChangeListener(eVar);
    }

    public final float I(SheetGlassStyle style) {
        p.i(style, "style");
        int i10 = a.$EnumSwitchMapping$0[style.ordinal()];
        if (i10 == 1) {
            return 240.0f;
        }
        if (i10 == 2) {
            return 120.0f;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Pair<Integer, Float> J(float fraction) {
        float fM = C5685n.m(fraction, 0.0f, 1.0f);
        return Y8.j.a(Integer.valueOf(Color.argb(E(Color.alpha(HALF_SHEET_TINT_COLOR), Color.alpha(FULL_SHEET_TINT_COLOR), fM), E(Color.red(HALF_SHEET_TINT_COLOR), Color.red(FULL_SHEET_TINT_COLOR), fM), E(Color.green(HALF_SHEET_TINT_COLOR), Color.green(FULL_SHEET_TINT_COLOR), fM), E(Color.blue(HALF_SHEET_TINT_COLOR), Color.blue(FULL_SHEET_TINT_COLOR), fM))), Float.valueOf((fM * (-120.0f)) + 240.0f));
    }

    public final int K(SheetGlassStyle style) {
        p.i(style, "style");
        int i10 = a.$EnumSwitchMapping$0[style.ordinal()];
        if (i10 == 1) {
            return HALF_SHEET_TINT_COLOR;
        }
        if (i10 == 2) {
            return FULL_SHEET_TINT_COLOR;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int L(int rgb, int pct) {
        return Color.argb((C5685n.n(pct, 0, 100) * 255) / 100, (rgb >> 16) & 255, (rgb >> 8) & 255, rgb & 255);
    }

    public final void M(E handle, float cornerRadiusDp, View targetView) {
        p.i(targetView, "targetView");
        float f10 = cornerRadiusDp * targetView.getResources().getDisplayMetrics().density;
        if (handle != null) {
            handle.b(f10);
        }
    }

    public final <P extends F> C<P> N(C<P> c10, P p10) {
        return new f(c10, p10);
    }

    public final void j(View target, float cornerRadiusDp) {
        p.i(target, "target");
        float f10 = cornerRadiusDp * target.getResources().getDisplayMetrics().density;
        target.setClipToOutline(true);
        target.setOutlineProvider(new b(f10));
        target.invalidateOutline();
    }

    public final void k(View target, float cornerRadiusDp) {
        p.i(target, "target");
        float f10 = cornerRadiusDp * target.getResources().getDisplayMetrics().density;
        target.setClipToOutline(true);
        target.setOutlineProvider(new c(f10));
        target.invalidateOutline();
    }

    public final E l(View target, boolean crossWindow, Float cornerRadiusDp, o effect, boolean innerShadow) {
        E eU;
        p.i(target, "target");
        p.i(effect, "effect");
        float f10 = target.getResources().getDisplayMetrics().density;
        y7.B bX = H.a(s7.p.f40121a, target).x(crossWindow);
        if (innerShadow) {
            bX.i(effect);
        } else {
            L lE = effect.E(f10);
            lE.p(10.0f * f10);
            C0743k c0743kC = effect.C(f10);
            List<Pair<Integer, Integer>> listE = c0743kC.e();
            if (!listE.isEmpty()) {
                Pair pair = (Pair) Z8.F.q0(listE);
                c0743kC.f(Z8.F.S0(C1172u.e(Y8.j.a(Integer.valueOf(((Number) pair.a()).intValue()), Integer.valueOf((((Number) pair.b()).intValue() & 16777215) | (((C5685n.n(6, 0, 100) * 255) / 100) << 24)))), Z8.F.h0(listE, 1)));
            }
            G g10 = G.f43879a;
            y7.B.k(y7.B.k(y7.B.k(y7.B.k(y7.B.k(bX, N(g10.b(), effect.D(f10)), null, 2, null), N(g10.f(), effect.G(f10)), null, 2, null), N(g10.d(), lE), null, 2, null), N(g10.e(), effect.F(f10)), null, 2, null), N(g10.a(), c0743kC), null, 2, null);
        }
        if (cornerRadiusDp != null) {
            bX.w(cornerRadiusDp.floatValue() * f10);
        }
        if (crossWindow) {
            Drawable background = target.getBackground();
            E eU2 = bX.u();
            if (eU2.c() != 0) {
                Drawable background2 = target.getBackground();
                if (background2 == null || background2 == background) {
                    Drawable drawable = crossWindowBackplates.get(target);
                    if (drawable != null && background2 != drawable && target.isAttachedToWindow()) {
                        y yVar = y.f34840a;
                        String str = String.format("commit: backplate lost view=%s bg=%s, reinstall", Arrays.copyOf(new Object[]{target.getClass().getSimpleName(), background2 != null ? background2.getClass().getSimpleName() : null}, 2));
                        p.h(str, "format(...)");
                        Log.w(TAG, str);
                        target.setBackground(drawable);
                    }
                } else {
                    H(target, background2);
                }
            }
            eU = eU2;
        } else {
            eU = bX.u();
        }
        if (eU.c() != 0) {
            y yVar2 = y.f34840a;
            String str2 = String.format("attach: view=%s crossWindow=%s cornerRadiusDp=%s activeCount=%d ids=%s", Arrays.copyOf(new Object[]{target.getClass().getSimpleName(), Boolean.valueOf(crossWindow), cornerRadiusDp, Integer.valueOf(eU.c()), eU.d()}, 5));
            p.h(str2, "format(...)");
            Log.d(TAG, str2);
            return eU;
        }
        y yVar3 = y.f34840a;
        String str3 = String.format("attach: fully degraded view=%s crossWindow=%s, release and return null", Arrays.copyOf(new Object[]{target.getClass().getSimpleName(), Boolean.valueOf(crossWindow)}, 2));
        p.h(str3, "format(...)");
        Log.i(TAG, str3);
        eU.g();
        return null;
    }

    public final E n(View target, final float radiusDp, boolean crossWindow, Float cornerRadiusDp) {
        E eU;
        p.i(target, "target");
        final float f10 = target.getResources().getDisplayMetrics().density;
        y7.B bX = H.a(s7.p.f40121a, target).x(crossWindow);
        if (cornerRadiusDp != null) {
            bX.w(cornerRadiusDp.floatValue() * f10);
        }
        if (crossWindow) {
            Drawable background = target.getBackground();
            E eU2 = bX.j(G.f43879a.b(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.container.glass.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return h.p(radiusDp, f10, (C0746n) obj);
                }
            }).u();
            if (eU2.c() != 0) {
                Drawable background2 = target.getBackground();
                if (background2 == null || background2 == background) {
                    Drawable drawable = crossWindowBackplates.get(target);
                    if (drawable != null && background2 != drawable && target.isAttachedToWindow()) {
                        y yVar = y.f34840a;
                        String str = String.format("commit: backplate lost view=%s bg=%s, reinstall", Arrays.copyOf(new Object[]{target.getClass().getSimpleName(), background2 != null ? background2.getClass().getSimpleName() : null}, 2));
                        p.h(str, "format(...)");
                        Log.w(TAG, str);
                        target.setBackground(drawable);
                    }
                } else {
                    H(target, background2);
                }
            }
            eU = eU2;
        } else {
            eU = bX.j(G.f43879a.b(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.container.glass.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return h.p(radiusDp, f10, (C0746n) obj);
                }
            }).u();
        }
        if (eU.c() != 0) {
            y yVar2 = y.f34840a;
            String str2 = String.format("attachBlur: view=%s crossWindow=%s radiusDp=%s cornerRadiusDp=%s activeCount=%d ids=%s", Arrays.copyOf(new Object[]{target.getClass().getSimpleName(), Boolean.valueOf(crossWindow), Float.valueOf(radiusDp), cornerRadiusDp, Integer.valueOf(eU.c()), eU.d()}, 6));
            p.h(str2, "format(...)");
            Log.d(TAG, str2);
            return eU;
        }
        y yVar3 = y.f34840a;
        String str3 = String.format("attachBlur: fully degraded view=%s crossWindow=%s, release and return null", Arrays.copyOf(new Object[]{target.getClass().getSimpleName(), Boolean.valueOf(crossWindow)}, 2));
        p.h(str3, "format(...)");
        Log.i(TAG, str3);
        eU.g();
        return null;
    }

    public final E q(View target, boolean crossWindow, final boolean keyboardUp) {
        p.i(target, "target");
        y7.B bX = H.b(s7.p.f40121a, target).x(crossWindow);
        G g10 = G.f43879a;
        E eU = bX.j(g10.b(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.container.glass.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return h.r(keyboardUp, (C0746n) obj);
            }
        }).j(g10.a(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.container.glass.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return h.s(keyboardUp, (C0743k) obj);
            }
        }).u();
        eU.e(new InterfaceC5074l() { // from class: com.stepos.ailauncher.container.glass.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return h.t((C0757z) obj);
            }
        });
        if (eU.c() != 0 && eU.d().contains(GLASS_TEXT_ID)) {
            y yVar = y.f34840a;
            String str = String.format("attachGlassText: view=%s crossWindow=%s blurPx=%s activeCount=%d ids=%s", Arrays.copyOf(new Object[]{target.getClass().getSimpleName(), Boolean.valueOf(crossWindow), Float.valueOf(300.0f), Integer.valueOf(eU.c()), eU.d()}, 5));
            p.h(str, "format(...)");
            Log.d(TAG, str);
            return eU;
        }
        y yVar2 = y.f34840a;
        String str2 = String.format("attachGlassText: degraded view=%s crossWindow=%s ids=%s, release", Arrays.copyOf(new Object[]{target.getClass().getSimpleName(), Boolean.valueOf(crossWindow), eU.d()}, 3));
        p.h(str2, "format(...)");
        Log.i(TAG, str2);
        eU.g();
        return null;
    }

    public final E u(View target, boolean crossWindow, C<B> preset, final InterfaceC5074l<? super B, t> configure) {
        E eU;
        p.i(target, "target");
        p.i(preset, "preset");
        if (crossWindow) {
            Drawable background = target.getBackground();
            E eU2 = H.a(s7.p.f40121a, target).x(crossWindow).j(preset, new InterfaceC5074l() { // from class: com.stepos.ailauncher.container.glass.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return h.w(configure, (B) obj);
                }
            }).u();
            if (eU2.c() != 0) {
                Drawable background2 = target.getBackground();
                if (background2 == null || background2 == background) {
                    Drawable drawable = crossWindowBackplates.get(target);
                    if (drawable != null && background2 != drawable && target.isAttachedToWindow()) {
                        y yVar = y.f34840a;
                        String str = String.format("commit: backplate lost view=%s bg=%s, reinstall", Arrays.copyOf(new Object[]{target.getClass().getSimpleName(), background2 != null ? background2.getClass().getSimpleName() : null}, 2));
                        p.h(str, "format(...)");
                        Log.w(TAG, str);
                        target.setBackground(drawable);
                    }
                } else {
                    H(target, background2);
                }
            }
            eU = eU2;
        } else {
            eU = H.a(s7.p.f40121a, target).x(crossWindow).j(preset, new InterfaceC5074l() { // from class: com.stepos.ailauncher.container.glass.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return h.w(configure, (B) obj);
                }
            }).u();
        }
        if (eU.c() != 0) {
            y yVar2 = y.f34840a;
            String str2 = String.format("attachGradientBlur: view=%s crossWindow=%s activeCount=%d ids=%s", Arrays.copyOf(new Object[]{target.getClass().getSimpleName(), Boolean.valueOf(crossWindow), Integer.valueOf(eU.c()), eU.d()}, 4));
            p.h(str2, "format(...)");
            Log.d(TAG, str2);
            return eU;
        }
        y yVar3 = y.f34840a;
        String str3 = String.format("attachGradientBlur: fully degraded view=%s crossWindow=%s, release and return null", Arrays.copyOf(new Object[]{target.getClass().getSimpleName(), Boolean.valueOf(crossWindow)}, 2));
        p.h(str3, "format(...)");
        Log.i(TAG, str3);
        eU.g();
        return null;
    }

    public final E x(View target, final int tint, final float blurRadius, boolean crossWindow, Float cornerRadiusDp) {
        E eU;
        p.i(target, "target");
        y7.B bX = H.a(s7.p.f40121a, target).x(crossWindow);
        if (cornerRadiusDp != null) {
            bX.w(cornerRadiusDp.floatValue() * target.getResources().getDisplayMetrics().density);
        }
        final double radians = Math.toRadians(0.0d);
        if (crossWindow) {
            Drawable background = target.getBackground();
            G g10 = G.f43879a;
            E eU2 = bX.j(g10.b(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.container.glass.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return h.z(blurRadius, tint, (C0746n) obj);
                }
            }).j(g10.f(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.container.glass.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return h.A(radians, (Z) obj);
                }
            }).u();
            if (eU2.c() != 0) {
                Drawable background2 = target.getBackground();
                if (background2 == null || background2 == background) {
                    Drawable drawable = crossWindowBackplates.get(target);
                    if (drawable != null && background2 != drawable && target.isAttachedToWindow()) {
                        y yVar = y.f34840a;
                        String str = String.format("commit: backplate lost view=%s bg=%s, reinstall", Arrays.copyOf(new Object[]{target.getClass().getSimpleName(), background2 != null ? background2.getClass().getSimpleName() : null}, 2));
                        p.h(str, "format(...)");
                        Log.w(TAG, str);
                        target.setBackground(drawable);
                    }
                } else {
                    H(target, background2);
                }
            }
            eU = eU2;
        } else {
            G g11 = G.f43879a;
            eU = bX.j(g11.b(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.container.glass.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return h.z(blurRadius, tint, (C0746n) obj);
                }
            }).j(g11.f(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.container.glass.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return h.A(radians, (Z) obj);
                }
            }).u();
        }
        if (eU.c() != 0) {
            y yVar2 = y.f34840a;
            String str2 = String.format("attachSheet: view=%s tint=#%08X blur=%.1f cornerRadiusDp=%s activeCount=%d ids=%s", Arrays.copyOf(new Object[]{target.getClass().getSimpleName(), Integer.valueOf(tint), Float.valueOf(blurRadius), cornerRadiusDp, Integer.valueOf(eU.c()), eU.d()}, 6));
            p.h(str2, "format(...)");
            Log.d(TAG, str2);
            return eU;
        }
        y yVar3 = y.f34840a;
        String str3 = String.format("attachSheet: fully degraded view=%s tint=#%08X blur=%.1f, release and return null", Arrays.copyOf(new Object[]{target.getClass().getSimpleName(), Integer.valueOf(tint), Float.valueOf(blurRadius)}, 3));
        p.h(str3, "format(...)");
        Log.i(TAG, str3);
        eU.g();
        return null;
    }

    public final E y(View target, SheetGlassStyle style, boolean crossWindow, Float cornerRadiusDp) {
        p.i(target, "target");
        p.i(style, "style");
        return x(target, K(style), I(style), crossWindow, cornerRadiusDp);
    }
}
