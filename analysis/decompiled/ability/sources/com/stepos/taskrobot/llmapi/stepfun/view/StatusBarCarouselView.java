package com.stepos.taskrobot.llmapi.stepfun.view;

import C7.r;
import J7.c;
import S7.n;
import android.content.Context;
import android.util.AttributeSet;
import android.view.C0764ViewTreeLifecycleOwner;
import android.view.LayoutInflater;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.LifecycleOwnerKt;
import android.view.RepeatOnLifecycleKt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.llmapi.stepfun.R;
import com.stepos.taskrobot.llmapi.stepfun.view.carousel.StatusBarCarouselController;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.c0;
import p9.d;
import p9.t;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u00017B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001a\u0010\fJ\u001f\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\nH\u0014¢\u0006\u0004\b \u0010\fR$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/StatusBarCarouselView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LC7/r;", "startCollecting", "()V", "Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$Display;", "display", "applyDisplay", "(Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$Display;)V", "Lkotlin/Function0;", "onPulledUp", "setOnPulledUp", "(LS7/a;)V", "Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController;", "controller", "bindController", "(Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController;)V", "unbindController", "onAttachedToWindow", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "onDetachedFromWindow", "Lcom/stepos/taskrobot/llmapi/stepfun/view/StatusBarCarouselView$Listener;", "listener", "Lcom/stepos/taskrobot/llmapi/stepfun/view/StatusBarCarouselView$Listener;", "getListener", "()Lcom/stepos/taskrobot/llmapi/stepfun/view/StatusBarCarouselView$Listener;", "setListener", "(Lcom/stepos/taskrobot/llmapi/stepfun/view/StatusBarCarouselView$Listener;)V", "Lcom/stepos/taskrobot/llmapi/stepfun/view/PullableHandleHost;", "handleHost", "Lcom/stepos/taskrobot/llmapi/stepfun/view/PullableHandleHost;", "Landroid/widget/LinearLayout;", "zoneLeft", "Landroid/widget/LinearLayout;", "Landroid/widget/TextView;", "text", "Landroid/widget/TextView;", "btnStop", "Landroid/view/View;", "Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController;", "Lm9/c0;", "collectJob", "Lm9/c0;", "Listener", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StatusBarCarouselView extends FrameLayout {
    private final View btnStop;
    private c0 collectJob;
    private StatusBarCarouselController controller;
    private final PullableHandleHost handleHost;
    private Listener listener;
    private final TextView text;
    private final LinearLayout zoneLeft;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/StatusBarCarouselView$Listener;", "", "LC7/r;", "onLeftZoneClick", "()V", "onStopClick", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Listener {
        void onLeftZoneClick();

        void onStopClick();
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StatusBarCarouselController.FixedSlot.values().length];
            try {
                iArr[StatusBarCarouselController.FixedSlot.TOUCH_HINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StatusBarCarouselController.FixedSlot.INPUT_HINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.view.StatusBarCarouselView$startCollecting$1", f = "StatusBarCarouselView.kt", l = {127}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.view.StatusBarCarouselView$startCollecting$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ StatusBarCarouselController $controller;
        final /* synthetic */ LifecycleOwner $owner;
        int label;
        final /* synthetic */ StatusBarCarouselView this$0;

        @c(c = "com.stepos.taskrobot.llmapi.stepfun.view.StatusBarCarouselView$startCollecting$1$1", f = "StatusBarCarouselView.kt", l = {128}, m = "invokeSuspend", v = 1)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
        /* renamed from: com.stepos.taskrobot.llmapi.stepfun.view.StatusBarCarouselView$startCollecting$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01671 extends SuspendLambda implements n {
            final /* synthetic */ StatusBarCarouselController $controller;
            int label;
            final /* synthetic */ StatusBarCarouselView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01671(StatusBarCarouselController statusBarCarouselController, StatusBarCarouselView statusBarCarouselView, H7.c<? super C01671> cVar) {
                super(2, cVar);
                this.$controller = statusBarCarouselController;
                this.this$0 = statusBarCarouselView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C01671(this.$controller, this.this$0, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    kotlin.b.b(obj);
                    t display = this.$controller.getDisplay();
                    final StatusBarCarouselView statusBarCarouselView = this.this$0;
                    d dVar = new d() { // from class: com.stepos.taskrobot.llmapi.stepfun.view.StatusBarCarouselView.startCollecting.1.1.1
                        public final Object emit(StatusBarCarouselController.Display display2, H7.c<? super r> cVar) {
                            statusBarCarouselView.applyDisplay(display2);
                            return r.f317a;
                        }

                        @Override // p9.d
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, H7.c cVar) {
                            return emit((StatusBarCarouselController.Display) obj2, (H7.c<? super r>) cVar);
                        }
                    };
                    this.label = 1;
                    if (display.collect(dVar, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C01671) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LifecycleOwner lifecycleOwner, StatusBarCarouselController statusBarCarouselController, StatusBarCarouselView statusBarCarouselView, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$owner = lifecycleOwner;
            this.$controller = statusBarCarouselController;
            this.this$0 = statusBarCarouselView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$owner, this.$controller, this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                LifecycleOwner lifecycleOwner = this.$owner;
                Lifecycle.State state = Lifecycle.State.STARTED;
                C01671 c01671 = new C01671(this.$controller, this.this$0, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycleOwner, state, c01671, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatusBarCarouselView(Context context) {
        this(context, null, 0, 6, null);
        k.f(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(StatusBarCarouselView statusBarCarouselView, View view) {
        Listener listener = statusBarCarouselView.listener;
        if (listener != null) {
            listener.onLeftZoneClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(StatusBarCarouselView statusBarCarouselView, View view) {
        Listener listener = statusBarCarouselView.listener;
        if (listener != null) {
            listener.onStopClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyDisplay(StatusBarCarouselController.Display display) {
        String string;
        TextView textView = this.text;
        if (display instanceof StatusBarCarouselController.Display.Explain) {
            string = ((StatusBarCarouselController.Display.Explain) display).getText();
        } else {
            if (!(display instanceof StatusBarCarouselController.Display.Fixed)) {
                throw new NoWhenBranchMatchedException();
            }
            int i = WhenMappings.$EnumSwitchMapping$0[((StatusBarCarouselController.Display.Fixed) display).getSlot().ordinal()];
            if (i == 1) {
                string = getContext().getString(R.string.fullscreen_status_touch_hint);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                string = getContext().getString(R.string.fullscreen_status_input_hint);
            }
            k.c(string);
        }
        textView.setText(string);
    }

    private final void startCollecting() {
        LifecycleOwner lifecycleOwner;
        StatusBarCarouselController statusBarCarouselController = this.controller;
        if (statusBarCarouselController == null || (lifecycleOwner = C0764ViewTreeLifecycleOwner.get(this)) == null) {
            return;
        }
        c0 c0Var = this.collectJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.collectJob = AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, new AnonymousClass1(lifecycleOwner, statusBarCarouselController, this, null), 3);
    }

    public final void bindController(StatusBarCarouselController controller) {
        k.f(controller, "controller");
        this.controller = controller;
        startCollecting();
    }

    public final Listener getListener() {
        return this.listener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.controller != null) {
            c0 c0Var = this.collectJob;
            if (c0Var == null || !c0Var.isActive()) {
                startCollecting();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        c0 c0Var = this.collectJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.collectJob = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        k.f(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (changedView == this && visibility == 0) {
            if (this.handleHost.getVisibility() != 0) {
                this.handleHost.setVisibility(0);
            }
            this.handleHost.resetCardAlpha();
        }
    }

    public final void setListener(Listener listener) {
        this.listener = listener;
    }

    public final void setOnPulledUp(S7.a onPulledUp) {
        k.f(onPulledUp, "onPulledUp");
        PullableHandleHost pullableHandleHost = this.handleHost;
        View viewFindViewById = pullableHandleHost.findViewById(R.id.handle);
        k.e(viewFindViewById, "findViewById(...)");
        pullableHandleHost.bindHandle(viewFindViewById);
        this.handleHost.bindAnimator(new HandleSlideAnimator(onPulledUp));
        PullableHandleHost pullableHandleHost2 = this.handleHost;
        View viewFindViewById2 = pullableHandleHost2.findViewById(R.id.card_body);
        k.e(viewFindViewById2, "findViewById(...)");
        pullableHandleHost2.bindCardBody(viewFindViewById2);
        this.handleHost.setMaxRubberPx(getResources().getDimensionPixelSize(R.dimen.status_bar_pull_max_rubber));
    }

    public final void unbindController() {
        c0 c0Var = this.collectJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.collectJob = null;
        this.controller = null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatusBarCarouselView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusBarCarouselView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k.f(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_status_bar_carousel, (ViewGroup) this, true);
        View childAt = getChildAt(0);
        k.d(childAt, "null cannot be cast to non-null type com.stepos.taskrobot.llmapi.stepfun.view.PullableHandleHost");
        this.handleHost = (PullableHandleHost) childAt;
        View viewFindViewById = findViewById(R.id.zone_left);
        k.e(viewFindViewById, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById;
        this.zoneLeft = linearLayout;
        View viewFindViewById2 = findViewById(R.id.text);
        k.e(viewFindViewById2, "findViewById(...)");
        this.text = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.btn_stop);
        k.e(viewFindViewById3, "findViewById(...)");
        this.btnStop = viewFindViewById3;
        final int i6 = 0;
        linearLayout.setOnClickListener(new View.OnClickListener(this) { // from class: com.stepos.taskrobot.llmapi.stepfun.view.b
            public final /* synthetic */ StatusBarCarouselView b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i10 = i6;
                StatusBarCarouselView statusBarCarouselView = this.b;
                switch (i10) {
                    case 0:
                        StatusBarCarouselView._init_$lambda$0(statusBarCarouselView, view);
                        break;
                    default:
                        StatusBarCarouselView._init_$lambda$1(statusBarCarouselView, view);
                        break;
                }
            }
        });
        final int i10 = 1;
        viewFindViewById3.setOnClickListener(new View.OnClickListener(this) { // from class: com.stepos.taskrobot.llmapi.stepfun.view.b
            public final /* synthetic */ StatusBarCarouselView b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i102 = i10;
                StatusBarCarouselView statusBarCarouselView = this.b;
                switch (i102) {
                    case 0:
                        StatusBarCarouselView._init_$lambda$0(statusBarCarouselView, view);
                        break;
                    default:
                        StatusBarCarouselView._init_$lambda$1(statusBarCarouselView, view);
                        break;
                }
            }
        });
        setClickable(true);
        setClipChildren(false);
    }

    public /* synthetic */ StatusBarCarouselView(Context context, AttributeSet attributeSet, int i, int i6, e eVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 0 : i);
    }
}
