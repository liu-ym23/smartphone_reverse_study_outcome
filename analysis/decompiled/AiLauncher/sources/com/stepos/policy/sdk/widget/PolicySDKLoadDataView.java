package com.stepos.policy.sdk.widget;

import Ua.C1060i;
import Ua.Y;
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
import com.stepos.common.widget.EmptyView;
import com.stepos.common.widget.LoadingView;
import com.stepos.policy.sdk.R$id;
import com.stepos.policy.sdk.R$layout;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.d;
import kotlinx.coroutines.g;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 @2\u00020\u0001:\u0001@B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0005J%\u0010\u0013\u001a\u00020\f*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0016J\r\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0016J\r\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u0016J;\u0010 \u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\tH\u0007¢\u0006\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/stepos/policy/sdk/widget/PolicySDKLoadDataView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "initView", "Landroid/view/View;", "Landroid/view/View$OnClickListener;", "listener", "", "time", "setDebounceClickListener", "(Landroid/view/View;Landroid/view/View$OnClickListener;J)V", "showProgressNoDelay", "()V", "showProgress", "hideProgress", "hideEmptyView", "titleId", "drawableId", "onRetryClickListener", "", "showSettingButton", "btnId", "showEmptyView", "(IILandroid/view/View$OnClickListener;ZI)V", "mContext", "Landroid/content/Context;", "Landroid/widget/RelativeLayout;", "mProgressView", "Landroid/widget/RelativeLayout;", "Lcom/stepos/common/widget/LoadingView;", "mLoadingView", "Lcom/stepos/common/widget/LoadingView;", "Lcom/stepos/common/widget/EmptyView;", "mEmptyView", "Lcom/stepos/common/widget/EmptyView;", "Landroid/widget/Button;", "btnSettingNetWork", "Landroid/widget/Button;", "Landroid/os/Handler;", "mHandler", "Landroid/os/Handler;", "Ljava/lang/ref/WeakReference;", "refContext", "Ljava/lang/ref/WeakReference;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "layoutEmptyView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayoutEmptyView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setLayoutEmptyView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "Ljava/lang/Runnable;", "mProgressShowRunnable", "Ljava/lang/Runnable;", "Companion", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicySDKLoadDataView extends FrameLayout {
    private static final int DURATION_ANIMATION = 100;
    private Button btnSettingNetWork;
    private ConstraintLayout layoutEmptyView;
    private Context mContext;
    private EmptyView mEmptyView;
    private Handler mHandler;
    private LoadingView mLoadingView;
    private final Runnable mProgressShowRunnable;
    private RelativeLayout mProgressView;
    private WeakReference<Context> refContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(Context context) {
        super(context);
        p.i(context, "context");
        this.mProgressShowRunnable = new Runnable() { // from class: com.stepos.policy.sdk.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                PolicySDKLoadDataView.mProgressShowRunnable$lambda$0(this.f30634a);
            }
        };
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.refContext = weakReference;
        this.mContext = weakReference.get();
        initView(context);
    }

    private final void initView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.policysdk_load_data_view, this);
        View viewFindViewById = viewInflate.findViewById(R$id.loading_view);
        p.g(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.mProgressView = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(com.stepos.common.R$id.mc_loading_view);
        p.g(viewFindViewById2, "null cannot be cast to non-null type com.stepos.common.widget.LoadingView");
        this.mLoadingView = (LoadingView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R$id.empty_view);
        p.g(viewFindViewById3, "null cannot be cast to non-null type com.stepos.common.widget.EmptyView");
        this.mEmptyView = (EmptyView) viewFindViewById3;
        this.layoutEmptyView = (ConstraintLayout) findViewById(R$id.layout_empty_view);
        View viewFindViewById4 = viewInflate.findViewById(R$id.btn_setting_net_work);
        p.g(viewFindViewById4, "null cannot be cast to non-null type android.widget.Button");
        this.btnSettingNetWork = (Button) viewFindViewById4;
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mProgressShowRunnable$lambda$0(PolicySDKLoadDataView this$0) {
        p.i(this$0, "this$0");
        this$0.showProgressNoDelay();
    }

    private final void setDebounceClickListener(View view, final View.OnClickListener onClickListener, final long j10) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PolicySDKLoadDataView.setDebounceClickListener$lambda$1(ref$ObjectRef, j10, onClickListener, view2);
            }
        });
    }

    public static /* synthetic */ void setDebounceClickListener$default(PolicySDKLoadDataView policySDKLoadDataView, View view, View.OnClickListener onClickListener, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 500;
        }
        policySDKLoadDataView.setDebounceClickListener(view, onClickListener, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r9v1, types: [T, kotlinx.coroutines.g] */
    public static final void setDebounceClickListener$lambda$1(Ref$ObjectRef job, long j10, View.OnClickListener listener, View view) {
        p.i(job, "$job");
        p.i(listener, "$listener");
        g gVar = (g) job.f34820a;
        if (gVar != null) {
            g.Y0(gVar, null, 1, null);
        }
        job.f34820a = C1060i.d(d.a(Y.c()), null, null, new PolicySDKLoadDataView$setDebounceClickListener$1$1(j10, listener, view, null), 3, null);
    }

    public static /* synthetic */ void showEmptyView$default(PolicySDKLoadDataView policySDKLoadDataView, int i10, int i11, View.OnClickListener onClickListener, boolean z10, int i12, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            i12 = 0;
        }
        policySDKLoadDataView.showEmptyView(i10, i11, onClickListener, z10, i12);
    }

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
        if (loadingView2 != null) {
            loadingView2.f();
        }
    }

    public final void setLayoutEmptyView(ConstraintLayout constraintLayout) {
        this.layoutEmptyView = constraintLayout;
    }

    public final void showEmptyView(int i10, int i11, View.OnClickListener onClickListener, boolean z10) {
        showEmptyView$default(this, i10, i11, onClickListener, z10, 0, 16, null);
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
            loadingView2.d();
        }
    }

    public final void showEmptyView(int titleId, int drawableId, View.OnClickListener onRetryClickListener, boolean showSettingButton, int btnId) {
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
                    emptyView4.setImageDrawable(androidx.core.content.a.e(getContext(), drawableId));
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
                emptyView5.setAlpha(0.0f);
            }
            EmptyView emptyView6 = this.mEmptyView;
            if (emptyView6 == null || (viewPropertyAnimatorAnimate = emptyView6.animate()) == null || (viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(1.0f)) == null || (duration = viewPropertyAnimatorAlpha.setDuration(100L)) == null) {
                return;
            }
            duration.start();
        } catch (Exception e10) {
            if (e10.getMessage() != null) {
                PolicySdkLogUtils.INSTANCE.e("showEmptyView", "Exception = " + e10.getMessage());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.i(context, "context");
        this.mProgressShowRunnable = new Runnable() { // from class: com.stepos.policy.sdk.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                PolicySDKLoadDataView.mProgressShowRunnable$lambda$0(this.f30634a);
            }
        };
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.refContext = weakReference;
        this.mContext = weakReference.get();
        initView(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        this.mProgressShowRunnable = new Runnable() { // from class: com.stepos.policy.sdk.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                PolicySDKLoadDataView.mProgressShowRunnable$lambda$0(this.f30634a);
            }
        };
        initView(context);
    }
}
