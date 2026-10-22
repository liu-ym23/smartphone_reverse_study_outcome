package com.stepos.policy.sdk.widget;

import Z2.G;
import Z2.Q;
import Z2.o0;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.R;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.Property;
import com.stepos.common.widget.EmptyView;
import com.stepos.common.widget.LoadingView;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import d3.q;
import f3.d;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t0.J;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 32\u00020\u0001:\u00013B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J4\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\tH\u0007J\u0006\u0010,\u001a\u00020!J\u0006\u0010-\u001a\u00020!J\u001e\u0010.\u001a\u00020!*\u00020/2\u0006\u00100\u001a\u00020(2\b\b\u0002\u00101\u001a\u000202H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/stepos/policy/sdk/widget/PolicySDKLoadDataView;", "Landroid/widget/FrameLayout;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnSettingNetWork", "Landroid/widget/Button;", "layoutEmptyView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayoutEmptyView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setLayoutEmptyView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mContext", "mEmptyView", "Lcom/stepos/common/widget/EmptyView;", "mHandler", "Landroid/os/Handler;", "mLoadingView", "Lcom/stepos/common/widget/LoadingView;", "mProgressShowRunnable", "Ljava/lang/Runnable;", "mProgressView", "Landroid/widget/RelativeLayout;", "refContext", "Ljava/lang/ref/WeakReference;", "hideEmptyView", "", "hideProgress", "initView", "showEmptyView", "titleId", "drawableId", "onRetryClickListener", "Landroid/view/View$OnClickListener;", "showSettingButton", "", "btnId", "showProgress", "showProgressNoDelay", "setDebounceClickListener", "Landroid/view/View;", "listener", AppSuggestStorable.COLUMN_TIME, "", "Companion", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicySDKLoadDataView extends FrameLayout {
    private static final int DURATION_ANIMATION = 100;

    @Nullable
    private Button btnSettingNetWork;

    @Nullable
    private ConstraintLayout layoutEmptyView;

    @Nullable
    private Context mContext;

    @Nullable
    private EmptyView mEmptyView;

    @Nullable
    private Handler mHandler;

    @Nullable
    private LoadingView mLoadingView;

    @NotNull
    private final Runnable mProgressShowRunnable;

    @Nullable
    private RelativeLayout mProgressView;

    @Nullable
    private WeakReference<Context> refContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        final int i4 = 1;
        this.mProgressShowRunnable = new Runnable(this) { // from class: com.stepos.policy.sdk.widget.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PolicySDKLoadDataView f12285b;

            {
                this.f12285b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i5 = i4;
                PolicySDKLoadDataView.mProgressShowRunnable$lambda$0(this.f12285b);
            }
        };
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.refContext = weakReference;
        this.mContext = weakReference.get();
        initView(context);
    }

    private final void initView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.policysdk_load_data_view, this);
        View viewFindViewById = viewInflate.findViewById(R.id.loading_view);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.mProgressView = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.mc_loading_view);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type com.stepos.common.widget.LoadingView");
        this.mLoadingView = (LoadingView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.empty_view);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type com.stepos.common.widget.EmptyView");
        this.mEmptyView = (EmptyView) viewFindViewById3;
        this.layoutEmptyView = (ConstraintLayout) findViewById(R.id.layout_empty_view);
        View viewFindViewById4 = viewInflate.findViewById(R.id.btn_setting_net_work);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.Button");
        this.btnSettingNetWork = (Button) viewFindViewById4;
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mProgressShowRunnable$lambda$0(PolicySDKLoadDataView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showProgressNoDelay();
    }

    private final void setDebounceClickListener(View view, final View.OnClickListener onClickListener, final long j4) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PolicySDKLoadDataView.setDebounceClickListener$lambda$1(objectRef, j4, onClickListener, view2);
            }
        });
    }

    public static /* synthetic */ void setDebounceClickListener$default(PolicySDKLoadDataView policySDKLoadDataView, View view, View.OnClickListener onClickListener, long j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 500;
        }
        policySDKLoadDataView.setDebounceClickListener(view, onClickListener, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r10v2, types: [T, Z2.D0] */
    public static final void setDebounceClickListener$lambda$1(Ref.ObjectRef job, long j4, View.OnClickListener listener, View view) {
        Intrinsics.checkNotNullParameter(job, "$job");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        o0 o0Var = (o0) job.element;
        if (o0Var != null) {
            o0Var.b(null);
        }
        d dVar = Q.f2189a;
        job.element = J.y(G.a(q.f12477a), null, new PolicySDKLoadDataView$setDebounceClickListener$1$1(j4, listener, view, null), 3);
    }

    public static /* synthetic */ void showEmptyView$default(PolicySDKLoadDataView policySDKLoadDataView, int i4, int i5, View.OnClickListener onClickListener, boolean z4, int i6, int i7, Object obj) {
        if ((i7 & 16) != 0) {
            i6 = 0;
        }
        policySDKLoadDataView.showEmptyView(i4, i5, onClickListener, z4, i6);
    }

    @Nullable
    public final ConstraintLayout getLayoutEmptyView() {
        return this.layoutEmptyView;
    }

    public final void hideEmptyView() {
        EmptyView emptyView = this.mEmptyView;
        if (emptyView != null) {
            emptyView.setVisibility(8);
        }
        ConstraintLayout constraintLayout = this.layoutEmptyView;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        Button button = this.btnSettingNetWork;
        if (button == null) {
            return;
        }
        button.setVisibility(8);
    }

    public final void hideProgress() {
        ObjectAnimator objectAnimator;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mProgressShowRunnable);
        }
        RelativeLayout relativeLayout = this.mProgressView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        LoadingView loadingView = this.mLoadingView;
        if (loadingView != null) {
            loadingView.setVisibility(8);
        }
        LoadingView loadingView2 = this.mLoadingView;
        if (loadingView2 == null || (objectAnimator = loadingView2.f11693d) == null) {
            return;
        }
        objectAnimator.cancel();
        loadingView2.f11693d = null;
    }

    public final void setLayoutEmptyView(@Nullable ConstraintLayout constraintLayout) {
        this.layoutEmptyView = constraintLayout;
    }

    @JvmOverloads
    public final void showEmptyView(int i4, int i5, @Nullable View.OnClickListener onClickListener, boolean z4) {
        showEmptyView$default(this, i4, i5, onClickListener, z4, 0, 16, null);
    }

    public final void showProgress() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mProgressShowRunnable);
        }
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.postDelayed(this.mProgressShowRunnable, 500L);
        }
        Button button = this.btnSettingNetWork;
        if (button != null) {
            button.setVisibility(8);
        }
        hideEmptyView();
    }

    public final void showProgressNoDelay() {
        setVisibility(0);
        RelativeLayout relativeLayout = this.mProgressView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        LoadingView loadingView = this.mLoadingView;
        if (loadingView != null) {
            loadingView.setVisibility(0);
        }
        LoadingView loadingView2 = this.mLoadingView;
        if (loadingView2 != null) {
            loadingView2.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        final int i4 = 2;
        this.mProgressShowRunnable = new Runnable(this) { // from class: com.stepos.policy.sdk.widget.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PolicySDKLoadDataView f12285b;

            {
                this.f12285b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i5 = i4;
                PolicySDKLoadDataView.mProgressShowRunnable$lambda$0(this.f12285b);
            }
        };
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.refContext = weakReference;
        this.mContext = weakReference.get();
        initView(context);
    }

    @JvmOverloads
    public final void showEmptyView(int titleId, int drawableId, @Nullable View.OnClickListener onRetryClickListener, boolean showSettingButton, int btnId) {
        EmptyView emptyView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator duration;
        EmptyView emptyView2;
        try {
            setVisibility(0);
            EmptyView emptyView3 = this.mEmptyView;
            if (emptyView3 != null) {
                emptyView3.setVisibility(0);
            }
            ConstraintLayout constraintLayout = this.layoutEmptyView;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            if (titleId != 0) {
                Context context = this.mContext;
                String strValueOf = String.valueOf(context != null ? context.getText(titleId) : null);
                if (!TextUtils.isEmpty(strValueOf) && (emptyView2 = this.mEmptyView) != null) {
                    emptyView2.setTitle(strValueOf);
                }
            }
            if (drawableId > 0) {
                EmptyView emptyView4 = this.mEmptyView;
                if (emptyView4 != null) {
                    emptyView4.setImageDrawable(androidx.core.content.a.b(getContext(), drawableId));
                }
            } else if (drawableId < 0 && (emptyView = this.mEmptyView) != null) {
                emptyView.setImageDrawable(null);
            }
            if (showSettingButton) {
                Button button = this.btnSettingNetWork;
                if (button != null) {
                    button.setVisibility(0);
                }
                Button button2 = this.btnSettingNetWork;
                if (button2 != null) {
                    button2.setText(btnId);
                }
            } else {
                Button button3 = this.btnSettingNetWork;
                if (button3 != null) {
                    button3.setVisibility(8);
                }
            }
            if (onRetryClickListener == null) {
                Button button4 = this.btnSettingNetWork;
                if (button4 != null) {
                    button4.setOnClickListener(null);
                }
            } else {
                Button button5 = this.btnSettingNetWork;
                if (button5 != null) {
                    setDebounceClickListener(button5, onRetryClickListener, 500L);
                }
            }
            EmptyView emptyView5 = this.mEmptyView;
            if (emptyView5 != null) {
                emptyView5.setAlpha(Property.DEFAULT_FLOAT_VALUE);
            }
            EmptyView emptyView6 = this.mEmptyView;
            if (emptyView6 == null || (viewPropertyAnimatorAnimate = emptyView6.animate()) == null || (viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(1.0f)) == null || (duration = viewPropertyAnimatorAlpha.setDuration(100L)) == null) {
                return;
            }
            duration.start();
        } catch (Exception e4) {
            if (e4.getMessage() != null) {
                PolicySdkLogUtils.INSTANCE.e("showEmptyView", "Exception = " + e4.getMessage());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        Intrinsics.checkNotNullParameter(context, "context");
        final int i5 = 0;
        this.mProgressShowRunnable = new Runnable(this) { // from class: com.stepos.policy.sdk.widget.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PolicySDKLoadDataView f12285b;

            {
                this.f12285b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i52 = i5;
                PolicySDKLoadDataView.mProgressShowRunnable$lambda$0(this.f12285b);
            }
        };
        initView(context);
    }
}
