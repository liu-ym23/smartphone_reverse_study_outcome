package com.obric.oui.bouncelayout;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.OverScroller;
import com.GlobalProxyLancet;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OListView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0002MNB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0015H\u0016J\n\u0010/\u001a\u0004\u0018\u000100H\u0002J\b\u00101\u001a\u00020'H\u0002J\b\u00102\u001a\u00020'H\u0002J\u0012\u00103\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u00105\u001a\u00020\u000eJ\b\u00106\u001a\u00020'H\u0014J\u0010\u00107\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-H\u0016J(\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\bH\u0014J\u0010\u0010=\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u00020\u0015H\u0002J\b\u0010@\u001a\u00020'H\u0002J\u0014\u0010A\u001a\u00020'2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CH\u0002J\b\u0010D\u001a\u00020'H\u0002J\u0012\u0010E\u001a\u00020'2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0010\u0010H\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010I\u001a\u00020'H\u0002J\u0018\u0010J\u001a\u00020\u000e2\u0006\u0010K\u001a\u0002002\u0006\u0010L\u001a\u00020\u0015H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/obric/oui/bouncelayout/OListView;", "Landroid/widget/ListView;", "Lcom/obric/oui/bouncelayout/IBounceTranslationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bounceBottom", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceTop", "edgeEffectsInstalled", "", "edgeFieldBottom", "Ljava/lang/reflect/Field;", "edgeFieldTop", "emptyAreaBounceDragging", "emptyAreaBounceTouchActive", "emptyAreaDownY", "", "emptyAreaLastY", "flingRunnableField", "flingRunnableScrollerField", "lastScrollDirection", "lastScrollerVelocity", "lastVerticalScrollOffset", "originalBottomEffect", "", "originalTopEffect", "overscrollDelegate", "Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "scrollerField", "touchDownTranslationY", "touchSlop", "translationDelegate", "Lcom/obric/oui/bouncelayout/BounceTranslationDelegate;", "computeScroll", "", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getBounceTranslation", "getOverScrollerOrNull", "Landroid/widget/OverScroller;", "initEdgeEffectReflection", "installBounceEdgeEffects", "isBounceEffectActive", "effect", "isOverScrolling", "onDetachedFromWindow", "onInterceptTouchEvent", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "pullEmptyAreaBounce", "deltaY", "releaseEmptyAreaBounce", "removeCurrentFlingRunnable", "flingRunnable", "Ljava/lang/Runnable;", "restoreOriginalEdgeEffects", "setOnBounceTranslationListener", "listener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "shouldHandleEmptyAreaBounce", "stopBounceIfNeeded", "tryAbsorbRunningFlingAtEdge", "scroller", RealFpsTracer.SCROLL_VELOCITY, "Companion", "ReflectionFields", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListView extends ListView implements IBounceTranslationView {
    public static final Companion Companion = null;
    public static final String TAG = "OListView";
    private static volatile ReflectionFields cachedReflectionFields;
    private BounceEdgeEffect bounceBottom;
    private BounceEdgeEffect bounceTop;
    private boolean edgeEffectsInstalled;
    private Field edgeFieldBottom;
    private Field edgeFieldTop;
    private boolean emptyAreaBounceDragging;
    private boolean emptyAreaBounceTouchActive;
    private float emptyAreaDownY;
    private float emptyAreaLastY;
    private Field flingRunnableField;
    private Field flingRunnableScrollerField;
    private int lastScrollDirection;
    private float lastScrollerVelocity;
    private int lastVerticalScrollOffset;
    private Object originalBottomEffect;
    private Object originalTopEffect;
    private final BounceOverscrollDelegate overscrollDelegate;
    private Field scrollerField;
    private float touchDownTranslationY;
    private final int touchSlop;
    private final BounceTranslationDelegate translationDelegate;

    /* JADX INFO: compiled from: OListView.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u001e\u0010\t\u001a\u0004\u0018\u00010\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/bouncelayout/OListView$Companion;", "", "()V", "TAG", "", "cachedReflectionFields", "Lcom/obric/oui/bouncelayout/OListView$ReflectionFields;", "getCachedReflectionFields", "resolveReflectionFields", "tryGetField", "Ljava/lang/reflect/Field;", "clazz", "Ljava/lang/Class;", "name", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ ReflectionFields access$getCachedReflectionFields(Companion r0) {
            return r0.getCachedReflectionFields();
        }

        private final ReflectionFields getCachedReflectionFields() {
            ReflectionFields r0 = OListView.access$getCachedReflectionFields$cp();
            if (r0 != null) goto L13;
            monitor-enter(this);
            ReflectionFields r1 = OListView.access$getCachedReflectionFields$cp();     // Catch: Throwable -> L10
            if (r1 != null) goto L8;
            r1 = OListView.Companion.resolveReflectionFields();     // Catch: Throwable -> L10
            Companion r2 = OListView.Companion;     // Catch: Throwable -> L10
            OListView.access$setCachedReflectionFields$cp(r1);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
            return r1;
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }

        private final ReflectionFields resolveReflectionFields() {
            Field r2 = tryGetField(AbsListView.class, "mEdgeGlowTop");     // Catch: Throwable -> L18
            if (r2 != null) goto L6;
            r2 = tryGetField(AbsListView.class, "mTopGlow");     // Catch: Throwable -> L18
        L6:
            Field r3 = tryGetField(AbsListView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L18
            if (r3 != null) goto L9;
            r3 = tryGetField(AbsListView.class, "mBottomGlow");     // Catch: Throwable -> L18
        L9:
            Field r4 = tryGetField(AbsListView.class, "mScroller");     // Catch: Throwable -> L18
            Field r10 = tryGetField(AbsListView.class, "mFlingRunnable");     // Catch: Throwable -> L18
            if (r10 != null) goto L12;
        L11:
            Field r5 = null;
        L16:
            return new ReflectionFields(r2, r3, r4, r10, r5);
        L12:
            Class<?> r6 = r10.getType();     // Catch: Throwable -> L18
            if (r6 == null) goto L11;
            r5 = OListView.Companion.tryGetField(r6, "mScroller");     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(OListView.TAG, "Failed to reflect edge effect fields", th);
            return new ReflectionFields(null, null, null, null, null, 31, null);
        }

        private final Field tryGetField(Class<?> r3, String r4) {
            Field r2 = r3.getDeclaredField(r4);     // Catch: Throwable -> L4
            r2.setAccessible(true);     // Catch: Throwable -> L4
            return r2;
        L4:
            th = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(OListView.TAG, "Failed to reflect field " + r4 + " from " + r3.getName(), th);
            Field r5 = (Field) null;
            return null;
        }
    }

    /* JADX INFO: compiled from: OListView.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/bouncelayout/OListView$ReflectionFields;", "", "edgeFieldTop", "Ljava/lang/reflect/Field;", "edgeFieldBottom", "scrollerField", "flingRunnableField", "flingRunnableScrollerField", "(Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;)V", "getEdgeFieldBottom", "()Ljava/lang/reflect/Field;", "getEdgeFieldTop", "getFlingRunnableField", "getFlingRunnableScrollerField", "getScrollerField", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class ReflectionFields {
        private final Field edgeFieldBottom;
        private final Field edgeFieldTop;
        private final Field flingRunnableField;
        private final Field flingRunnableScrollerField;
        private final Field scrollerField;

        public ReflectionFields() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ ReflectionFields copy$default(ReflectionFields r3, Field r4, Field r5, Field r6, Field r7, Field r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.edgeFieldTop;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.edgeFieldBottom;
        L8:
            Field r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.scrollerField;
        L11:
            Field r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.flingRunnableField;
        L14:
            Field r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.flingRunnableScrollerField;
        L17:
            Field r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final Field component1() {
            return this.edgeFieldTop;
        }

        public final Field component2() {
            return this.edgeFieldBottom;
        }

        public final Field component3() {
            return this.scrollerField;
        }

        public final Field component4() {
            return this.flingRunnableField;
        }

        public final Field component5() {
            return this.flingRunnableScrollerField;
        }

        public final ReflectionFields copy(Field r7, Field r8, Field r9, Field r10, Field r11) {
            return new ReflectionFields(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ReflectionFields) == true) goto L8;
            return false;
        L8:
            ReflectionFields r6 = (ReflectionFields) r5;
            if (Intrinsics.areEqual(this.edgeFieldTop, r6.edgeFieldTop) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.edgeFieldBottom, r6.edgeFieldBottom) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.scrollerField, r6.scrollerField) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.flingRunnableField, r6.flingRunnableField) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.flingRunnableScrollerField, r6.flingRunnableScrollerField) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            Field r0 = this.edgeFieldTop;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Field r4 = this.edgeFieldBottom;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Field r7 = this.scrollerField;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Field r10 = this.flingRunnableField;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Field r13 = this.flingRunnableScrollerField;
            if (r13 == null) goto L23;
            r1 = r13.hashCode();
        L23:
            return r12 + r1;
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ReflectionFields(edgeFieldTop=" + this.edgeFieldTop + ", edgeFieldBottom=" + this.edgeFieldBottom + ", scrollerField=" + this.scrollerField + ", flingRunnableField=" + this.flingRunnableField + ", flingRunnableScrollerField=" + this.flingRunnableScrollerField + ')';
        }

        public ReflectionFields(Field r1, Field r2, Field r3, Field r4, Field r5) {
            this.edgeFieldTop = r1;
            this.edgeFieldBottom = r2;
            this.scrollerField = r3;
            this.flingRunnableField = r4;
            this.flingRunnableScrollerField = r5;
        }

        public /* synthetic */ ReflectionFields(Field r2, Field r3, Field r4, Field r5, Field r6, int r7, DefaultConstructorMarker r8) {
            if ((r7 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r7 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r7 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r7 & 8) == 0) goto L15;
            r5 = null;
        L15:
            if ((r7 & 16) == 0) goto L17;
            r6 = null;
        L17:
            this(r2, r3, r4, r5, r6);
        }

        public final Field getEdgeFieldTop() {
            return this.edgeFieldTop;
        }

        public final Field getEdgeFieldBottom() {
            return this.edgeFieldBottom;
        }

        public final Field getScrollerField() {
            return this.scrollerField;
        }

        public final Field getFlingRunnableField() {
            return this.flingRunnableField;
        }

        public final Field getFlingRunnableScrollerField() {
            return this.flingRunnableScrollerField;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OListView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OListView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OListView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = R.attr.listViewStyle;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceBottom$p(OListView r0) {
        return r0.bounceBottom;
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceTop$p(OListView r0) {
        return r0.bounceTop;
    }

    public static final /* synthetic */ ReflectionFields access$getCachedReflectionFields$cp() {
        return cachedReflectionFields;
    }

    public static final /* synthetic */ void access$setCachedReflectionFields$cp(ReflectionFields r0) {
        cachedReflectionFields = r0;
    }

    public OListView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.overscrollDelegate = new BounceOverscrollDelegate(new OListView$overscrollDelegate$1(this), new OListView$overscrollDelegate$2(this));
        this.translationDelegate = new BounceTranslationDelegate(new OListView$translationDelegate$1(this), new OListView$translationDelegate$2(this));
        setOverScrollMode(0);
        BounceEdgeEffect.Companion.bypassHiddenApi("Landroid/widget/AbsListView;");
        initEdgeEffectReflection();
        installBounceEdgeEffects();
        this.touchSlop = ViewConfiguration.get(r2).getScaledTouchSlop();
    }

    @Override // com.obric.oui.bouncelayout.IBounceTranslationView
    public float getBounceTranslation() {
        BounceEdgeEffect r0 = this.bounceTop;
        float r1 = 0.0f;
        if (r0 != null) goto L5;
        float r2 = 0.0f;
    L6:
        BounceEdgeEffect r3 = this.bounceBottom;
        if (r3 == null) goto L11;
        r1 = r3.getTranslation();
    L11:
        return r2 + r1;
    L5:
        r2 = r0.getTranslation();
        goto L6
    }

    @Override // com.obric.oui.bouncelayout.IBounceTranslationView
    public void setOnBounceTranslationListener(OnBounceTranslationListener r1) {
        this.translationDelegate.setOnBounceTranslationListener(r1);
    }

    public final boolean isOverScrolling() {
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 == null) goto L12;
        Intrinsics.checkNotNull(r0);
        if (r0.getDistance() != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        BounceEdgeEffect r2 = this.bounceTop;
        Intrinsics.checkNotNull(r2);
        if (r2.isFinished() == true) goto L12;
    L11:
        boolean r3 = true;
    L13:
        BounceEdgeEffect r4 = this.bounceBottom;
        if (r4 == null) goto L23;
        Intrinsics.checkNotNull(r4);
        if (r4.getDistance() != 0.0f) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L22;
        BounceEdgeEffect r6 = this.bounceBottom;
        Intrinsics.checkNotNull(r6);
        if (r6.isFinished() == true) goto L23;
    L22:
        boolean r7 = true;
    L24:
        if (r3 == true) goto L29;
        if (r7 == false) goto L28;
        return true;
    L28:
        return false;
    L29:
        return true;
    L18:
        r5 = false;
    L23:
        r7 = false;
        goto L24
    L7:
        r1 = false;
    L12:
        r3 = false;
        goto L13
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.overscrollDelegate.onSizeChanged();
        BounceEdgeEffect r5 = this.bounceTop;
        if (r5 == null) goto L6;
        r5.setSize(r1, r2);
    L6:
        BounceEdgeEffect r0 = this.bounceBottom;
        if (r0 == null) goto L11;
        r0.setSize(r1, r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        if (r6.getActionMasked() != 0) goto L5;
        this.touchDownTranslationY = getBounceTranslation();
    L5:
        float r0 = this.touchDownTranslationY;
        if (r0 != 0.0f) goto L8;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L18;
        r6.offsetLocation(0.0f, -r0);
        boolean r3 = super.dispatchTouchEvent(r6);
        r6.offsetLocation(0.0f, r0);
        if (r6.getActionMasked() != 1) goto L14;
    L15:
        this.touchDownTranslationY = 0.0f;
    L16:
        return r3;
    L14:
        if (r6.getActionMasked() != 3) goto L16;
    L18:
        if (r6.getActionMasked() != 1) goto L20;
    L21:
        this.touchDownTranslationY = 0.0f;
    L23:
        return super.dispatchTouchEvent(r6);
    L20:
        if (r6.getActionMasked() != 3) goto L23;
    L8:
        r2 = false;
        goto L10
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        if (r2.getActionMasked() != 0) goto L6;
        stopBounceIfNeeded();
    L6:
        return super.onInterceptTouchEvent(r2);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        int r0 = r6.getActionMasked();
        boolean r1 = false;
        if (r0 == 0) goto L30;
        if (r0 == 1) goto L27;
        if (r0 == 2) goto L11;
        if (r0 == 3) goto L27;
    L35:
        return super.onTouchEvent(r6);
    L11:
        if (this.emptyAreaBounceTouchActive == false) goto L35;
        float r7 = r6.getY();
        float r2 = r7 - this.emptyAreaDownY;
        float r3 = r7 - this.emptyAreaLastY;
        if (this.emptyAreaBounceDragging == true) goto L18;
        if (Math.abs(r2) <= this.touchSlop) goto L18;
        this.emptyAreaBounceDragging = true;
    L18:
        if (this.emptyAreaBounceDragging == true) goto L20;
    L24:
        this.emptyAreaLastY = r7;
        return true;
    L20:
        if (r3 != 0.0f) goto L22;
        r1 = true;
    L22:
        if (r1 == true) goto L24;
        pullEmptyAreaBounce(r3);
    L27:
        if (this.emptyAreaBounceTouchActive == false) goto L35;
        releaseEmptyAreaBounce();
        return true;
    L30:
        stopBounceIfNeeded();
        if (shouldHandleEmptyAreaBounce(r6) == false) goto L35;
        this.emptyAreaBounceTouchActive = true;
        this.emptyAreaBounceDragging = false;
        this.emptyAreaDownY = r6.getY();
        this.emptyAreaLastY = r6.getY();
        return true;
    }

    private final boolean shouldHandleEmptyAreaBounce(MotionEvent r3) {
        if (this.edgeEffectsInstalled == true) goto L5;
        return false;
    L5:
        if (getHeight() > 0) goto L8;
        return false;
    L8:
        if (pointToPosition((int) r3.getX(), (int) r3.getY()) != (-1)) goto L12;
        return true;
    L12:
        return false;
    }

    private final void pullEmptyAreaBounce(float r5) {
        if (getHeight() > 0) goto L5;
        return;
    L5:
        float r0 = r5 / getHeight();
        boolean r1 = isBounceEffectActive(this.bounceTop);
        boolean r2 = isBounceEffectActive(this.bounceBottom);
        if (r1 == false) goto L11;
        BounceEdgeEffect r6 = this.bounceTop;
        if (r6 == null) goto L28;
        r6.onPull(r0, 0.5f);
    L28:
        invalidate();
        return;
    L11:
        if (r2 == false) goto L17;
        BounceEdgeEffect r7 = this.bounceBottom;
        if (r7 == null) goto L28;
        r7.onPull(-r0, 0.5f);
        goto L28
    L17:
        if (r5 <= 0.0f) goto L23;
        BounceEdgeEffect r8 = this.bounceTop;
        if (r8 == null) goto L28;
        r8.onPull(r0, 0.5f);
        goto L28
    L23:
        if (r5 >= 0.0f) goto L28;
        BounceEdgeEffect r9 = this.bounceBottom;
        if (r9 == null) goto L28;
        r9.onPull(-r0, 0.5f);
        goto L28
    }

    private final void releaseEmptyAreaBounce() {
        this.emptyAreaBounceTouchActive = false;
        this.emptyAreaBounceDragging = false;
        BounceDebugLogger r0 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L5;
        BounceDebugLogger.log(this, "emptyAreaRelease", Intrinsics.stringPlus("translation=", Float.valueOf(getBounceTranslation())));
    L5:
        BounceEdgeEffect r1 = this.bounceTop;
        if (r1 == null) goto L9;
        r1.onRelease();
    L9:
        BounceEdgeEffect r2 = this.bounceBottom;
        if (r2 == null) goto L13;
        r2.onRelease();
    L13:
        invalidate();
    }

    private final boolean isBounceEffectActive(BounceEdgeEffect r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.getDistance() != 0.0f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L17;
        if (r4.getTranslation() != 0.0f) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L17;
        if (r4.isFinished() == false) goto L17;
        return false;
    L12:
        r1 = false;
    L17:
        return true;
    L7:
        r0 = false;
        goto L8
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.edgeEffectsInstalled == true) goto L6;
        return;
    L6:
        if (computeVerticalScrollRange() > computeVerticalScrollExtent()) goto L8;
        return;
    L8:
        int r0 = computeVerticalScrollOffset();
        OverScroller r1 = getOverScrollerOrNull();
        if (r1 != null) goto L11;
    L22:
        float r2 = this.lastScrollerVelocity;
        if (r2 <= 0.0f) goto L37;
        boolean r3 = !canScrollList(-1);
        boolean r4 = true ^ canScrollList(1);
        int r5 = this.lastScrollDirection;
        if (r5 >= 0) goto L31;
        if (r3 == false) goto L31;
        BounceEdgeEffect r6 = this.bounceTop;
        if (r6 == null) goto L37;
        r6.onAbsorb((int) r2);
    L31:
        if (r5 <= 0) goto L37;
        if (r4 == false) goto L37;
        BounceEdgeEffect r7 = this.bounceBottom;
        if (r7 == null) goto L37;
        r7.onAbsorb(-((int) r2));
    L37:
        this.lastScrollerVelocity = 0.0f;
        this.lastScrollDirection = 0;
        this.lastVerticalScrollOffset = r0;
        return;
    L11:
        if (r1.isFinished() == true) goto L22;
        this.lastScrollerVelocity = r1.getCurrVelocity();
        int r8 = r0 - this.lastVerticalScrollOffset;
        if (r8 <= 0) goto L15;
        this.lastScrollDirection = 1;
    L17:
        BounceDebugLogger r9 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L20;
        BounceDebugLogger.log(this, "flingFrame", "offset=" + r0 + " delta=" + r8 + " velocity=" + this.lastScrollerVelocity + " direction=" + this.lastScrollDirection);
    L20:
        this.lastVerticalScrollOffset = r0;
        tryAbsorbRunningFlingAtEdge(r1, this.lastScrollerVelocity);
        return;
    L15:
        if (r8 >= 0) goto L17;
        this.lastScrollDirection = -1;
        goto L17
    }

    private final boolean tryAbsorbRunningFlingAtEdge(OverScroller r8, float r9) {
        if (r9 > 0.0f) goto L5;
        return false;
    L5:
        boolean r1 = !canScrollList(-1);
        boolean r4 = !canScrollList(1);
        if (this.lastScrollDirection >= 0) goto L24;
        if (r1 == false) goto L24;
        BounceEdgeEffect r2 = this.bounceTop;
        if (r2 != null) goto L12;
    L10:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L24;
        BounceDebugLogger r5 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L18;
        BounceDebugLogger.log(this, "flingAbsorbTop", Intrinsics.stringPlus("velocity=", Float.valueOf(r9)));
    L18:
        BounceEdgeEffect r6 = this.bounceTop;
        if (r6 == null) goto L22;
        r6.onAbsorb((int) r9);
    L22:
        boolean r10 = true;
    L41:
        if (r10 == false) goto L43;
        r8.abortAnimation();
        removeCurrentFlingRunnable$default(this, null, 1, null);
        this.lastScrollerVelocity = 0.0f;
        this.lastScrollDirection = 0;
        invalidate();
    L43:
        return r10;
    L12:
        if (r2.isFinished() != true) goto L10;
        r3 = true;
    L24:
        if (this.lastScrollDirection <= 0) goto L40;
        if (r4 == false) goto L40;
        BounceEdgeEffect r7 = this.bounceBottom;
        if (r7 != null) goto L30;
    L28:
        boolean r11 = false;
    L32:
        if (r11 == false) goto L40;
        BounceDebugLogger r12 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L36;
        BounceDebugLogger.log(this, "flingAbsorbBottom", Intrinsics.stringPlus("velocity=", Float.valueOf(r9)));
    L36:
        BounceEdgeEffect r13 = this.bounceBottom;
        if (r13 == null) goto L22;
        r13.onAbsorb(-((int) r9));
        goto L22
    L30:
        if (r7.isFinished() != true) goto L28;
        r11 = true;
    L40:
        r10 = false;
        goto L41
    }

    private final void stopBounceIfNeeded() {
        if (this.edgeEffectsInstalled == true) goto L5;
        return;
    L5:
        OverScroller r0 = getOverScrollerOrNull();
        BounceEdgeEffect r1 = this.bounceTop;
        if (r1 != null) goto L8;
        float r2 = 0.0f;
    L9:
        boolean r3 = true;
        if (r2 != 0.0f) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L25;
        BounceEdgeEffect r5 = this.bounceBottom;
        if (r5 != null) goto L17;
        float r6 = 0.0f;
    L19:
        if (r6 != 0.0f) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L25;
        boolean r8 = false;
    L26:
        BounceEdgeEffect r9 = this.bounceTop;
        if (r9 != null) goto L30;
    L28:
        boolean r10 = false;
    L32:
        if (r10 == true) goto L42;
        BounceEdgeEffect r11 = this.bounceBottom;
        if (r11 != null) goto L37;
    L35:
        boolean r12 = false;
    L39:
        if (r12 == true) goto L42;
        boolean r13 = false;
    L43:
        if (r8 == true) goto L45;
        if (r13 == true) goto L45;
    L72:
        this.lastScrollerVelocity = 0.0f;
        this.lastScrollDirection = 0;
        this.lastVerticalScrollOffset = computeVerticalScrollOffset();
        return;
    L45:
        if (r0 != null) goto L48;
    L46:
        r3 = false;
    L49:
        if (r3 == false) goto L53;
        if (r0 == null) goto L53;
        r0.abortAnimation();
    L53:
        Runnable r14 = null;
        Field r15 = this.flingRunnableField;     // Catch: Throwable -> L62
        if (r15 != null) goto L57;
        Object r16 = null;
    L59:
        if ((r16 instanceof Runnable) == false) goto L63;
        r14 = (Runnable) r16;     // Catch: Throwable -> L62
    L63:
        removeCurrentFlingRunnable(r14);
        BounceEdgeEffect r17 = this.bounceTop;
        if (r17 == null) goto L67;
        r17.stopAnimationForTouch();
    L67:
        BounceEdgeEffect r18 = this.bounceBottom;
        if (r18 == null) goto L71;
        r18.stopAnimationForTouch();
    L71:
        invalidate();
        goto L72
    L57:
        r16 = r15.get(this);     // Catch: Throwable -> L62
    L62:
        Runnable r19 = (Runnable) null;
        goto L63
    L48:
        if (r0.isFinished() == true) goto L46;
    L37:
        if (r11.isFinished() == true) goto L35;
        r12 = true;
    L42:
        r13 = true;
        goto L43
    L30:
        if (r9.isFinished() == true) goto L28;
        r10 = true;
        goto L32
    L21:
        r7 = false;
        goto L22
    L17:
        r6 = r5.getTranslation();
    L25:
        r8 = true;
        goto L26
    L12:
        r4 = false;
        goto L13
    L8:
        r2 = r1.getTranslation();
        goto L9
    }

    static /* synthetic */ void removeCurrentFlingRunnable$default(OListView r0, Runnable r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        r0.removeCurrentFlingRunnable(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeCurrentFlingRunnable");
    }

    private final void removeCurrentFlingRunnable(Runnable r3) {
        if (r3 != null) goto L13;
        r3 = null;
        Field r0 = this.flingRunnableField;     // Catch: Throwable -> L12
        if (r0 != null) goto L7;
        Object r1 = null;
    L9:
        if ((r1 instanceof Runnable) == false) goto L13;
        r3 = (Runnable) r1;     // Catch: Throwable -> L12
        goto L13
    L7:
        r1 = r0.get(this);     // Catch: Throwable -> L12
    L12:
        Runnable r2 = (Runnable) null;
    L13:
        if (r3 == null) goto L18;
        removeCallbacks(r3);
        return;
    }

    private final OverScroller getOverScrollerOrNull() {
        Field r1 = this.scrollerField;     // Catch: Throwable -> L32
        if (r1 != null) goto L6;
        Object r2 = null;
    L8:
        if ((r2 instanceof OverScroller) == false) goto L11;
        OverScroller r3 = (OverScroller) r2;     // Catch: Throwable -> L32
    L12:
        if (r3 == null) goto L34;
        return r3;
    L11:
        r3 = null;
        goto L12
    L6:
        r2 = r1.get(this);     // Catch: Throwable -> L32
    L34:
        Field r4 = this.flingRunnableField;     // Catch: Throwable -> L33
        if (r4 == null) goto L19;
        Object r5 = r4.get(this);     // Catch: Throwable -> L33
    L20:
        if (r5 != null) goto L36;
        return null;
    L36:
        Field r6 = this.flingRunnableScrollerField;     // Catch: Throwable -> L30
        if (r6 != null) goto L25;
        Object r7 = null;
    L27:
        if ((r7 instanceof OverScroller) == false) goto L40;
        return (OverScroller) r7;
    L40:
        return null;
    L25:
        r7 = r6.get(r5);     // Catch: Throwable -> L30
    L30:
        OverScroller r8 = (OverScroller) null;
        return null;
    L19:
        r5 = null;
        goto L20
    }

    private final void initEdgeEffectReflection() {
        ReflectionFields r0 = Companion.access$getCachedReflectionFields(Companion);
        this.edgeFieldTop = r0.getEdgeFieldTop();
        this.edgeFieldBottom = r0.getEdgeFieldBottom();
        this.scrollerField = r0.getScrollerField();
        this.flingRunnableField = r0.getFlingRunnableField();
        this.flingRunnableScrollerField = r0.getFlingRunnableScrollerField();
    }

    private final void installBounceEdgeEffects() {
        Field r1 = this.edgeFieldTop;
        Field r2 = this.edgeFieldBottom;
        if (r1 == null) goto L24;
        if (r2 == null) goto L25;
    L19:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Failed to install BounceEdgeEffects, restoring original.", th);
        restoreOriginalEdgeEffects();
        return;
    L7:
        if (this.originalTopEffect != null) goto L10;
        this.originalTopEffect = r1.get(this);     // Catch: Throwable -> L19
    L10:
        if (this.originalBottomEffect != null) goto L12;
        this.originalBottomEffect = r2.get(this);     // Catch: Throwable -> L19
    L12:
        this.overscrollDelegate.onSizeChanged();     // Catch: Throwable -> L19
        Context r4 = getContext();     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r4, "context");     // Catch: Throwable -> L19
        BounceEdgeEffect r3 = new BounceEdgeEffect(r4, this, 0, this.overscrollDelegate.getMaxOverscrollPx());     // Catch: Throwable -> L19
        Context r5 = getContext();     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r5, "context");     // Catch: Throwable -> L19
        BounceEdgeEffect r6 = new BounceEdgeEffect(r5, this, 1, this.overscrollDelegate.getMaxOverscrollPx());     // Catch: Throwable -> L19
        if (getWidth() > 0) goto L15;
    L17:
        r1.set(this, r3);     // Catch: Throwable -> L19
        r2.set(this, r6);     // Catch: Throwable -> L19
        this.bounceTop = r3;     // Catch: Throwable -> L19
        this.bounceBottom = r6;     // Catch: Throwable -> L19
        this.overscrollDelegate.applyMaxToEffects();     // Catch: Throwable -> L19
        this.translationDelegate.updateBounceListeners();     // Catch: Throwable -> L19
        this.edgeEffectsInstalled = true;     // Catch: Throwable -> L19
        return;
    L15:
        if (getHeight() <= 0) goto L17;
        r3.setSize(getWidth(), getHeight());     // Catch: Throwable -> L19
        r6.setSize(getWidth(), getHeight());     // Catch: Throwable -> L19
        goto L17
    L25:
        return;
    }

    private final void restoreOriginalEdgeEffects() {
        Field r0 = this.edgeFieldTop;
        Field r1 = this.edgeFieldBottom;
        if (r0 != null) goto L29;
    L7:
        if (r1 == null) goto L19;
        Object r2 = this.originalBottomEffect;     // Catch: Throwable -> L12
        if (r2 == null) goto L19;
        r1.set(this, r2);     // Catch: Throwable -> L12
    L12:
        BounceEdgeEffect r3 = this.bounceTop;
        if (r3 == null) goto L16;
        r3.finish();
    L16:
        BounceEdgeEffect r4 = this.bounceBottom;
        if (r4 == null) goto L27;
    L26:
        r4.finish();
    L27:
        this.bounceTop = null;
        this.bounceBottom = null;
        this.edgeEffectsInstalled = false;
        return;
    L19:
        BounceEdgeEffect r5 = this.bounceTop;
        if (r5 == null) goto L23;
        r5.finish();
    L23:
        r4 = this.bounceBottom;
        if (r4 != null) goto L26;
    L29:
        Object r6 = this.originalTopEffect;     // Catch: Throwable -> L12
        if (r6 == null) goto L7;
        r0.set(this, r6);     // Catch: Throwable -> L12
        goto L7
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 == null) goto L6;
        r0.finish();
    L6:
        BounceEdgeEffect r1 = this.bounceBottom;
        if (r1 == null) goto L11;
        r1.finish();
        return;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r4) {
        if (r4 != null) goto L5;
        super.dispatchDraw(r4);
        return;
    L5:
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 != null) goto L8;
        float r1 = 0.0f;
    L9:
        BounceEdgeEffect r2 = this.bounceBottom;
        if (r2 != null) goto L12;
        float r3 = 0.0f;
    L13:
        float r5 = r1 + r3;
        if (r5 != 0.0f) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == true) goto L19;
        int r7 = r4.save();
        r4.translate(0.0f, r5);
        super.dispatchDraw(r4);
        r4.restoreToCount(r7);
        return;
    L19:
        super.dispatchDraw(r4);
        return;
    L16:
        r6 = false;
        goto L17
    L12:
        r3 = r2.getTranslation();
        goto L13
    L8:
        r1 = r0.getTranslation();
        goto L9
    }
}
