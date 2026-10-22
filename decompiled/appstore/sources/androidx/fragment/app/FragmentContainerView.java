package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R$styleable;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001CB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\nB!\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0004\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0017¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010%\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0014¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00102\u0006\u0010'\u001a\u00020 H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00102\u0006\u0010'\u001a\u00020 H\u0016¢\u0006\u0004\b*\u0010)J\u0017\u0010,\u001a\u00020\u00102\u0006\u0010+\u001a\u00020$H\u0001¢\u0006\u0004\b,\u0010-J)\u00101\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 2\u0006\u0010.\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\bH\u0016¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00102\u0006\u0010'\u001a\u00020 H\u0016¢\u0006\u0004\b5\u0010)J\u0017\u00106\u001a\u00020\u00102\u0006\u0010'\u001a\u00020 H\u0016¢\u0006\u0004\b6\u0010)J\u001f\u00109\u001a\u00020\u00102\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bH\u0016¢\u0006\u0004\b9\u0010:J\u001f\u0010;\u001a\u00020\u00102\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bH\u0016¢\u0006\u0004\b;\u0010:J\u000f\u0010<\u001a\u00020\u0010H\u0016¢\u0006\u0004\b<\u0010=J\u0019\u0010@\u001a\u00028\u0000\"\n\b\u0000\u0010?*\u0004\u0018\u00010>¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u00102\u0006\u0010B\u001a\u00020 H\u0002¢\u0006\u0004\bC\u0010)R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020 0D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010ER\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020 0D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010ER\u0018\u0010K\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010+\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010M¨\u0006N"}, d2 = {"Landroidx/fragment/app/FragmentContainerView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/fragment/app/FragmentManager;", "fm", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroidx/fragment/app/FragmentManager;)V", "Landroid/animation/LayoutTransition;", "transition", "", "setLayoutTransition", "(Landroid/animation/LayoutTransition;)V", "Landroid/view/View$OnApplyWindowInsetsListener;", "listener", "setOnApplyWindowInsetsListener", "(Landroid/view/View$OnApplyWindowInsetsListener;)V", "Landroid/view/WindowInsets;", "insets", "onApplyWindowInsets", "(Landroid/view/WindowInsets;)Landroid/view/WindowInsets;", "dispatchApplyWindowInsets", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "Landroid/view/View;", "child", "", "drawingTime", "", "drawChild", "(Landroid/graphics/Canvas;Landroid/view/View;J)Z", "view", "startViewTransition", "(Landroid/view/View;)V", "endViewTransition", "drawDisappearingViewsFirst", "setDrawDisappearingViewsLast", "(Z)V", SlideCard.KEY_INDEX, "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "removeViewAt", "(I)V", "removeViewInLayout", "removeView", "start", "count", "removeViews", "(II)V", "removeViewsInLayout", "removeAllViewsInLayout", "()V", "Landroidx/fragment/app/Fragment;", "F", "getFragment", "()Landroidx/fragment/app/Fragment;", "v", "a", "", "Ljava/util/List;", "disappearingFragmentChildren", "b", "transitioningFragmentViews", "c", "Landroid/view/View$OnApplyWindowInsetsListener;", "applyWindowInsetsListener", "d", "Z", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFragmentContainerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FragmentContainerView.kt\nandroidx/fragment/app/FragmentContainerView\n+ 2 Context.kt\nandroidx/core/content/ContextKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,353:1\n55#2,6:354\n55#2,6:360\n1855#3,2:366\n*S KotlinDebug\n*F\n+ 1 FragmentContainerView.kt\nandroidx/fragment/app/FragmentContainerView\n*L\n113#1:354,6\n135#1:360,6\n226#1:366,2\n*E\n"})
public final class FragmentContainerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f3176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f3177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3178d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3179a = null;

        static {
            f3179a = new a();
        }

        public a() {
        }

        public final WindowInsets a(View.OnApplyWindowInsetsListener r10, View r11, WindowInsets r12) {
            kotlin.jvm.internal.q.g(r10, "onApplyWindowInsetsListener");
            kotlin.jvm.internal.q.g(r11, "v");
            kotlin.jvm.internal.q.g(r12, "insets");
            WindowInsets r13 = r10.onApplyWindowInsets(r11, r12);
            kotlin.jvm.internal.q.f(r13, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return r13;
        }
    }

    @JvmOverloads
    public FragmentContainerView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public final void a(View r10) {
        if (this.f3176b.contains(r10) == false) goto L6;
        this.f3175a.add(r10);
        return;
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        kotlin.jvm.internal.q.g(r10, "child");
        if (FragmentManager.F0(r10) == null) goto L7;
        super.addView(r10, r11, r12);
        return;
    L7:
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + r10 + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets r10) {
        kotlin.jvm.internal.q.g(r10, "insets");
        WindowInsetsCompat r11 = WindowInsetsCompat.y(r10);
        kotlin.jvm.internal.q.f(r11, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener r12 = this.f3177c;
        if (r12 == null) goto L5;
        a r13 = a.f3179a;
        kotlin.jvm.internal.q.d(r12);
        WindowInsetsCompat r14 = WindowInsetsCompat.y(r13.a(r12, this, r10));
    L6:
        kotlin.jvm.internal.q.f(r14, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (r14.r() == true) goto L11;
        int r15 = getChildCount();
        int r16 = 0;
    L9:
        if (r16 >= r15) goto L11;
        ViewCompat.h(getChildAt(r16), r14);
        r16 = r16 + 1;
    L11:
        return r10;
    L5:
        r14 = ViewCompat.b0(this, r11);
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r10) {
        kotlin.jvm.internal.q.g(r10, "canvas");
        if (this.f3178d == false) goto L8;
        Iterator r11 = this.f3175a.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        super.drawChild(r10, (View) r11.next(), getDrawingTime());
    L8:
        super.dispatchDraw(r10);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r10, View r11, long r12) {
        kotlin.jvm.internal.q.g(r10, "canvas");
        kotlin.jvm.internal.q.g(r11, "child");
        if (this.f3178d == false) goto L11;
        if (this.f3175a.isEmpty() == true) goto L11;
        if (this.f3175a.contains(r11) == false) goto L11;
        return false;
    L11:
        return super.drawChild(r10, r11, r12);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View r10) {
        kotlin.jvm.internal.q.g(r10, "view");
        this.f3176b.remove(r10);
        if (this.f3175a.remove(r10) == false) goto L5;
        this.f3178d = true;
    L5:
        super.endViewTransition(r10);
    }

    public final <F extends Fragment> F getFragment() {
        return (F) FragmentManager.k0(this).h0(getId());
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets r10) {
        kotlin.jvm.internal.q.g(r10, "insets");
        return r10;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int r10 = getChildCount();
    L3:
        r10 = r10 - 1;
        if ((-1) >= r10) goto L6;
        View r11 = getChildAt(r10);
        kotlin.jvm.internal.q.f(r11, "view");
        a(r11);
        goto L3
    L6:
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r10) {
        kotlin.jvm.internal.q.g(r10, "view");
        a(r10);
        super.removeView(r10);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int r10) {
        View r11 = getChildAt(r10);
        kotlin.jvm.internal.q.f(r11, "view");
        a(r11);
        super.removeViewAt(r10);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View r10) {
        kotlin.jvm.internal.q.g(r10, "view");
        a(r10);
        super.removeViewInLayout(r10);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int r10, int r11) {
        int r12 = r10 + r11;
        int r13 = r10;
    L3:
        if (r13 >= r12) goto L5;
        View r14 = getChildAt(r13);
        kotlin.jvm.internal.q.f(r14, "view");
        a(r14);
        r13 = r13 + 1;
        goto L3
    L5:
        super.removeViews(r10, r11);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int r10, int r11) {
        int r12 = r10 + r11;
        int r13 = r10;
    L3:
        if (r13 >= r12) goto L5;
        View r14 = getChildAt(r13);
        kotlin.jvm.internal.q.f(r14, "view");
        a(r14);
        r13 = r13 + 1;
        goto L3
    L5:
        super.removeViewsInLayout(r10, r11);
    }

    @JvmName(name = "setDrawDisappearingViewsLast")
    public final void setDrawDisappearingViewsLast(boolean r10) {
        this.f3178d = r10;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(@Nullable LayoutTransition r10) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(@NotNull View.OnApplyWindowInsetsListener r10) {
        kotlin.jvm.internal.q.g(r10, "listener");
        this.f3177c = r10;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View r10) {
        kotlin.jvm.internal.q.g(r10, "view");
        if (r10.getParent() != this) goto L5;
        this.f3176b.add(r10);
    L5:
        super.startViewTransition(r10);
    }

    public FragmentContainerView(@NotNull Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10);
        this.f3175a = new ArrayList();
        this.f3176b = new ArrayList();
        this.f3178d = true;
    }

    public /* synthetic */ FragmentContainerView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = 0;
    L5:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public FragmentContainerView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(r10, r11, r12);
        this.f3175a = new ArrayList();
        this.f3176b = new ArrayList();
        this.f3178d = true;
        if (r11 == null) goto L15;
        String r13 = r11.getClassAttribute();
        int[] r14 = R$styleable.FragmentContainerView;
        kotlin.jvm.internal.q.f(r14, "FragmentContainerView");
        TypedArray r15 = r10.obtainStyledAttributes(r11, r14, 0, 0);
        if (r13 != null) goto L7;
        r13 = r15.getString(R$styleable.FragmentContainerView_android_name);
        String r16 = "android:name";
    L8:
        r15.recycle();
        if (r13 != null) goto L11;
        return;
    L11:
        if (isInEditMode() == false) goto L14;
        return;
    L14:
        throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + r16 + "=\"" + r13 + TokenParser.DQUOTE);
    L7:
        r16 = "class";
        goto L8
    }

    public FragmentContainerView(Context r10, AttributeSet r11, FragmentManager r12) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "attrs");
        kotlin.jvm.internal.q.g(r12, "fm");
        super(r10, r11);
        this.f3175a = new ArrayList();
        this.f3176b = new ArrayList();
        this.f3178d = true;
        String r13 = r11.getClassAttribute();
        int[] r14 = R$styleable.FragmentContainerView;
        kotlin.jvm.internal.q.f(r14, "FragmentContainerView");
        TypedArray r15 = r10.obtainStyledAttributes(r11, r14, 0, 0);
        if (r13 != null) goto L5;
        r13 = r15.getString(R$styleable.FragmentContainerView_android_name);
    L5:
        String r16 = r15.getString(R$styleable.FragmentContainerView_android_tag);
        r15.recycle();
        int r17 = getId();
        Fragment r18 = r12.h0(r17);
        if (r13 == null) goto L16;
        if (r18 != null) goto L16;
        if (r17 != (-1)) goto L15;
        if (r16 == null) goto L12;
        String r19 = " with tag " + r16;
    L14:
        throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + r13 + r19);
    L12:
        r19 = "";
        goto L14
    L15:
        Fragment r20 = r12.v0().a(r10.getClassLoader(), r13);
        kotlin.jvm.internal.q.f(r20, "fm.fragmentFactory.insta…ontext.classLoader, name)");
        r20.mFragmentId = r17;
        r20.mContainerId = r17;
        r20.mTag = r16;
        r20.mFragmentManager = r12;
        r20.mHost = r12.y0();
        r20.onInflate(r10, r11, null);
        r12.o().z(true).d(this, r20, r16).m();
    L16:
        r12.d1(this);
    }
}
