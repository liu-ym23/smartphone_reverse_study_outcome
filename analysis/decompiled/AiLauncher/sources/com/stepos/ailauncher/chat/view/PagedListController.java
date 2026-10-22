package com.stepos.ailauncher.chat.view;

import Ua.C1060i;
import Z8.C1173v;
import android.view.C1398p;
import android.view.InterfaceC1387e;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.view.C2796d7;
import com.stepos.ailauncher.chat.view.PagingFeedbackPolicy;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.model.ListPage;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001O\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bc\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0004\u0012\u00020\u000f0\u0007¢\u0006\u0004\b\u0011\u0010\u0012JQ\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152(\u0010\u001b\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u000f¢\u0006\u0004\b \u0010\u001fJ!\u0010\"\u001a\u00020\u000f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b&\u0010%J\u000f\u0010'\u001a\u00020\u000fH\u0002¢\u0006\u0004\b'\u0010\u001fJ\u000f\u0010(\u001a\u00020\u000fH\u0002¢\u0006\u0004\b(\u0010\u001fJ\u000f\u0010)\u001a\u00020\u000fH\u0002¢\u0006\u0004\b)\u0010\u001fJ\u0019\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010*\u001a\u00020\nH\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u0013H\u0002¢\u0006\u0004\b-\u0010.R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010/R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00100R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00101R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u00101R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00101R&\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0004\u0012\u00020\u000f0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u00102R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R:\u0010\u001b\u001a&\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00101R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006R"}, d2 = {"Lcom/stepos/ailauncher/chat/view/PagedListController;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/e;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/recyclerview/widget/RecyclerView;", "list", "Lkotlin/Function1;", "", "keyOf", "", "loadAll", "showEmpty", "showRetryWhenEmpty", "Lcom/stepos/ailauncher/chat/view/d7;", "LY8/t;", "render", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/recyclerview/widget/RecyclerView;Lp9/l;ZZZLp9/l;)V", "", "firstKey", "", "preview", "Lkotlin/Function2;", "Le9/c;", "Lcom/stepos/ailauncher/contract/model/ListPage;", "", "fetch", "w", "(ILjava/util/List;Lp9/p;)V", "m", "()V", "r", "predicate", "v", "(Lp9/l;)V", UxipConstants.f30640D, "(Landroidx/lifecycle/LifecycleOwner;)V", "onDestroy", "y", "s", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "renderContent", "t", "(Z)V", "n", "(I)I", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/recyclerview/widget/RecyclerView;", "Z", "Lp9/l;", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/ailauncher/chat/view/d7;", "p", "()Lcom/stepos/ailauncher/chat/view/d7;", "Lp9/p;", "Lkotlinx/coroutines/g;", "job", "Lkotlinx/coroutines/g;", "disposed", "Landroid/widget/TextView;", "footer", "Landroid/widget/TextView;", "Landroid/view/View;", "contentContainer", "Landroid/view/View;", "scroll", "Landroid/view/ViewTreeObserver;", "observer", "Landroid/view/ViewTreeObserver;", "Ljava/lang/Runnable;", "checkMore", "Ljava/lang/Runnable;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "scrollListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "layoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "com/stepos/ailauncher/chat/view/PagedListController$b", "attachListener", "Lcom/stepos/ailauncher/chat/view/PagedListController$b;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PagedListController<T> implements InterfaceC1387e {
    private final b attachListener;
    private final Runnable checkMore;
    private final View contentContainer;
    private boolean disposed;
    private p9.p<? super Integer, ? super InterfaceC4014c<? super ListPage<T>>, ? extends Object> fetch;
    private final TextView footer;
    private kotlinx.coroutines.g job;
    private final ViewTreeObserver.OnGlobalLayoutListener layoutListener;
    private final RecyclerView list;
    private final boolean loadAll;
    private ViewTreeObserver observer;
    private final LifecycleOwner owner;
    private final InterfaceC5074l<C2796d7<T>, Y8.t> render;
    private final View scroll;
    private final ViewTreeObserver.OnScrollChangedListener scrollListener;
    private final boolean showEmpty;
    private final boolean showRetryWhenEmpty;
    private final C2796d7<T> state;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PagingFeedbackPolicy.Feedback.values().length];
            try {
                iArr[PagingFeedbackPolicy.Feedback.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PagingFeedbackPolicy.Feedback.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PagingFeedbackPolicy.Feedback.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/view/PagedListController$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements View.OnAttachStateChangeListener {
        final /* synthetic */ PagedListController<T> this$0;

        public b(PagedListController<T> pagedListController) {
            this.this$0 = pagedListController;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            this.this$0.s();
            this.this$0.y();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            this.this$0.A();
            ((PagedListController) this.this$0).list.removeCallbacks(((PagedListController) this.this$0).checkMore);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, p9.l<? super com.stepos.ailauncher.chat.view.d7<T>, Y8.t>, p9.l<com.stepos.ailauncher.chat.view.d7<T>, Y8.t>] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View, androidx.recyclerview.widget.RecyclerView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.view.View] */
    public PagedListController(LifecycleOwner owner, RecyclerView list, InterfaceC5074l<? super T, String> keyOf, boolean z10, boolean z11, boolean z12, InterfaceC5074l<? super C2796d7<T>, Y8.t> render) {
        kotlin.jvm.internal.p.i(owner, "owner");
        kotlin.jvm.internal.p.i(list, "list");
        kotlin.jvm.internal.p.i(keyOf, "keyOf");
        kotlin.jvm.internal.p.i(render, "render");
        this.owner = owner;
        this.list = list;
        this.loadAll = z10;
        this.showEmpty = z11;
        this.showRetryWhenEmpty = z12;
        this.render = render;
        this.state = new C2796d7<>(keyOf);
        TextView textView = new TextView(list.getContext());
        textView.setGravity(17);
        textView.setTextColor(-1711276033);
        textView.setTextSize(13.0f);
        textView.setPadding(0, n(16), 0, n(16));
        textView.setVisibility(8);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.e7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PagedListController.o(this.f26118a, view);
            }
        });
        this.footer = textView;
        this.checkMore = new Runnable() { // from class: com.stepos.ailauncher.chat.view.f7
            @Override // java.lang.Runnable
            public final void run() {
                PagedListController.k(this.f26132a);
            }
        };
        this.scrollListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.stepos.ailauncher.chat.view.g7
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                PagedListController.z(this.f26149a);
            }
        };
        this.layoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.stepos.ailauncher.chat.view.h7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                PagedListController.q(this.f26162a);
            }
        };
        this.attachListener = new b(this);
        ViewParent parent = list.getParent();
        kotlin.jvm.internal.p.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        if ((viewGroup instanceof LinearLayout) && ((LinearLayout) viewGroup).getOrientation() == 1) {
            viewGroup.addView(textView, viewGroup.indexOfChild(list) + 1, new LinearLayout.LayoutParams(-1, -2));
        } else {
            int iIndexOfChild = viewGroup.indexOfChild(list);
            ViewGroup.LayoutParams layoutParams = list.getLayoutParams();
            viewGroup.removeView(list);
            LinearLayout linearLayout = new LinearLayout(list.getContext());
            linearLayout.setOrientation(1);
            viewGroup.addView(linearLayout, iIndexOfChild, layoutParams);
            linearLayout.addView((View) list, new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        }
        Object parent2 = list.getParent();
        kotlin.jvm.internal.p.g(parent2, "null cannot be cast to non-null type android.view.View");
        this.contentContainer = (View) parent2;
        for (Object parent3 = list.getParent(); parent3 instanceof View; parent3 = ((View) parent3).getParent()) {
            if ((parent3 instanceof NestedScrollView) || (parent3 instanceof ScrollView)) {
                list = (View) parent3;
                break;
            }
        }
        this.scroll = list;
        this.list.addOnAttachStateChangeListener(this.attachListener);
        if (this.list.isAttachedToWindow()) {
            s();
        }
        this.owner.getLifecycle().a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [int] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.view.View] */
    public static final void k(PagedListController pagedListController) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        ?? r82;
        PagingFeedbackPolicy pagingFeedbackPolicy = PagingFeedbackPolicy.INSTANCE;
        boolean z14 = false;
        boolean z15 = !pagedListController.disposed && pagedListController.owner.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED);
        if (pagedListController.contentContainer.isShown() && pagedListController.scroll.isShown()) {
            z10 = false;
            z14 = true;
        } else {
            z10 = false;
        }
        boolean zIsLayoutRequested = pagedListController.scroll.isLayoutRequested();
        boolean loading = pagedListController.state.getLoading();
        if (pagedListController.state.getError() != null) {
            z11 = true;
            z12 = zIsLayoutRequested;
            z13 = true;
        } else {
            z11 = true;
            z12 = zIsLayoutRequested;
            z13 = z10;
        }
        if (pagedListController.state.getNextKey() != null) {
            z10 = z11;
            r82 = z10;
        } else {
            r82 = z11;
        }
        if (pagingFeedbackPolicy.b(z15, z14, z12, loading, z13, z10, pagedListController.loadAll, pagedListController.scroll.canScrollVertically(r82))) {
            pagedListController.r();
        }
    }

    public static final void o(PagedListController pagedListController, View view) {
        pagedListController.r();
    }

    public static final void q(PagedListController pagedListController) {
        pagedListController.y();
    }

    public static /* synthetic */ void u(PagedListController pagedListController, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        pagedListController.t(z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void x(PagedListController pagedListController, int i10, List list, p9.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        if ((i11 & 2) != 0) {
            list = C1173v.m();
        }
        pagedListController.w(i10, list, pVar);
    }

    public static final void z(PagedListController pagedListController) {
        pagedListController.y();
    }

    public final void A() {
        ViewTreeObserver viewTreeObserver = this.observer;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                viewTreeObserver = null;
            }
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.scrollListener);
                viewTreeObserver.removeOnGlobalLayoutListener(this.layoutListener);
            }
        }
        this.observer = null;
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void b(LifecycleOwner lifecycleOwner) {
        super.b(lifecycleOwner);
    }

    public final void m() {
        kotlinx.coroutines.g gVar = this.job;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.fetch = null;
        C2796d7.k(this.state, null, null, 2, null);
        u(this, false, 1, null);
    }

    public final int n(int n10) {
        return (int) (n10 * this.list.getResources().getDisplayMetrics().density);
    }

    @Override // android.view.InterfaceC1387e
    public void onDestroy(LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        this.disposed = true;
        kotlinx.coroutines.g gVar = this.job;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        C2796d7.k(this.state, null, null, 2, null);
        this.list.removeCallbacks(this.checkMore);
        A();
        this.list.removeOnAttachStateChangeListener(this.attachListener);
        ViewParent parent = this.footer.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.footer);
        }
        owner.getLifecycle().d(this);
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onPause(LifecycleOwner lifecycleOwner) {
        super.onPause(lifecycleOwner);
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onResume(LifecycleOwner lifecycleOwner) {
        super.onResume(lifecycleOwner);
    }

    @Override // android.view.InterfaceC1387e
    public void onStart(LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        y();
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onStop(LifecycleOwner lifecycleOwner) {
        super.onStop(lifecycleOwner);
    }

    public final C2796d7<T> p() {
        return this.state;
    }

    public final void r() {
        p9.p<? super Integer, ? super InterfaceC4014c<? super ListPage<T>>, ? extends Object> pVar;
        C2796d7.Request requestB;
        if (this.disposed || (pVar = this.fetch) == null || (requestB = this.state.b()) == null) {
            return;
        }
        t(false);
        this.job = C1060i.d(C1398p.a(this.owner), null, null, new PagedListController$loadNext$1(this, requestB, pVar, null), 3, null);
    }

    public final void s() {
        A();
        ViewTreeObserver viewTreeObserver = this.list.getViewTreeObserver();
        viewTreeObserver.addOnScrollChangedListener(this.scrollListener);
        viewTreeObserver.addOnGlobalLayoutListener(this.layoutListener);
        this.observer = viewTreeObserver;
    }

    public final void t(boolean renderContent) {
        Integer numValueOf;
        if (this.disposed) {
            return;
        }
        if (renderContent) {
            this.render.invoke(this.state);
        }
        boolean z10 = false;
        int i10 = a.$EnumSwitchMapping$0[PagingFeedbackPolicy.INSTANCE.a(this.state.getLoading(), this.state.getError() != null, this.state.getCompleted(), this.state.f().isEmpty(), this.showEmpty, this.showRetryWhenEmpty).ordinal()];
        if (i10 == 1) {
            numValueOf = Integer.valueOf(R$string.list_page_retry);
        } else if (i10 == 2) {
            numValueOf = Integer.valueOf(R$string.list_page_empty);
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            numValueOf = null;
        }
        this.footer.setVisibility(numValueOf == null ? 8 : 0);
        if (numValueOf != null && !kotlin.jvm.internal.p.d(this.footer.getText(), this.footer.getContext().getText(numValueOf.intValue()))) {
            this.footer.setText(numValueOf.intValue());
        }
        TextView textView = this.footer;
        if (!this.state.getLoading() && this.state.getNextKey() != null) {
            z10 = true;
        }
        textView.setEnabled(z10);
        this.list.removeCallbacks(this.checkMore);
        this.list.post(this.checkMore);
    }

    public final void v(InterfaceC5074l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.p.i(predicate, "predicate");
        this.state.i(predicate);
        u(this, false, 1, null);
    }

    public final void w(int firstKey, List<? extends T> preview, p9.p<? super Integer, ? super InterfaceC4014c<? super ListPage<T>>, ? extends Object> fetch) {
        kotlin.jvm.internal.p.i(preview, "preview");
        kotlin.jvm.internal.p.i(fetch, "fetch");
        kotlinx.coroutines.g gVar = this.job;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.fetch = fetch;
        this.state.j(Integer.valueOf(firstKey), preview);
        u(this, false, 1, null);
        r();
    }

    public final void y() {
        this.list.removeCallbacks(this.checkMore);
        this.list.post(this.checkMore);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ PagedListController(android.view.LifecycleOwner r9, androidx.recyclerview.widget.RecyclerView r10, p9.InterfaceC5074l r11, boolean r12, boolean r13, boolean r14, p9.InterfaceC5074l r15, int r16, kotlin.jvm.internal.i r17) {
        /*
            r8 = this;
            r0 = r16 & 8
            if (r0 == 0) goto L5
            r12 = 0
        L5:
            r4 = r12
            r12 = r16 & 16
            r0 = 1
            if (r12 == 0) goto Ld
            r5 = r0
            goto Le
        Ld:
            r5 = r13
        Le:
            r12 = r16 & 32
            if (r12 == 0) goto L19
            r6 = r0
            r1 = r9
            r2 = r10
            r3 = r11
            r7 = r15
            r0 = r8
            goto L1f
        L19:
            r6 = r14
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r7 = r15
        L1f:
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.PagedListController.<init>(androidx.lifecycle.LifecycleOwner, androidx.recyclerview.widget.RecyclerView, p9.l, boolean, boolean, boolean, p9.l, int, kotlin.jvm.internal.i):void");
    }
}
