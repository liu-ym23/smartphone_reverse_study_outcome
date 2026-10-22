package com.stepos.policy.sdk.widget;

import H1.h;
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
import com.stepos.policy.sdk.q;
import com.stepos.policy.sdk.r;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import j4.g;
import j4.k;
import j4.v;
import java.lang.ref.WeakReference;
import s4.C1076i;
import s4.J;
import s4.W;
import s4.n0;

/* loaded from: classes.dex */
public final class PolicySDKLoadDataView extends FrameLayout {
    public static final Companion Companion = new Companion(null);
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

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(Context context) {
        super(context);
        k.g(context, "context");
        this.mProgressShowRunnable = new Runnable() { // from class: com.stepos.policy.sdk.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                PolicySDKLoadDataView.mProgressShowRunnable$lambda$0(this.f15877a);
            }
        };
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.refContext = weakReference;
        this.mContext = weakReference.get();
        initView(context);
    }

    private final void initView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(r.f15816d, this);
        View viewFindViewById = viewInflate.findViewById(q.f15804g);
        k.e(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.mProgressView = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(h.f2222L);
        k.e(viewFindViewById2, "null cannot be cast to non-null type com.stepos.common.widget.LoadingView");
        this.mLoadingView = (LoadingView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(q.f15799b);
        k.e(viewFindViewById3, "null cannot be cast to non-null type com.stepos.common.widget.EmptyView");
        this.mEmptyView = (EmptyView) viewFindViewById3;
        this.layoutEmptyView = (ConstraintLayout) findViewById(q.f15802e);
        View viewFindViewById4 = viewInflate.findViewById(q.f15798a);
        k.e(viewFindViewById4, "null cannot be cast to non-null type android.widget.Button");
        this.btnSettingNetWork = (Button) viewFindViewById4;
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mProgressShowRunnable$lambda$0(PolicySDKLoadDataView policySDKLoadDataView) {
        k.g(policySDKLoadDataView, "this$0");
        policySDKLoadDataView.showProgressNoDelay();
    }

    private final void setDebounceClickListener(View view, final View.OnClickListener onClickListener, final long j5) {
        final v vVar = new v();
        view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PolicySDKLoadDataView.setDebounceClickListener$lambda$1(vVar, j5, onClickListener, view2);
            }
        });
    }

    static /* synthetic */ void setDebounceClickListener$default(PolicySDKLoadDataView policySDKLoadDataView, View view, View.OnClickListener onClickListener, long j5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            j5 = 500;
        }
        policySDKLoadDataView.setDebounceClickListener(view, onClickListener, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r9v1, types: [T, s4.n0] */
    public static final void setDebounceClickListener$lambda$1(v vVar, long j5, View.OnClickListener onClickListener, View view) {
        k.g(vVar, "$job");
        k.g(onClickListener, "$listener");
        n0 n0Var = (n0) vVar.f17836a;
        if (n0Var != null) {
            n0.a.a(n0Var, null, 1, null);
        }
        vVar.f17836a = C1076i.b(J.a(W.c()), null, null, new PolicySDKLoadDataView$setDebounceClickListener$1$1(j5, onClickListener, view, null), 3, null);
    }

    public static /* synthetic */ void showEmptyView$default(PolicySDKLoadDataView policySDKLoadDataView, int i5, int i6, View.OnClickListener onClickListener, boolean z5, int i7, int i8, Object obj) {
        if ((i8 & 16) != 0) {
            i7 = 0;
        }
        policySDKLoadDataView.showEmptyView(i5, i6, onClickListener, z5, i7);
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

    public final void showEmptyView(int i5, int i6, View.OnClickListener onClickListener, boolean z5) {
        showEmptyView$default(this, i5, i6, onClickListener, z5, 0, 16, null);
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

    public final void showEmptyView(int i5, int i6, View.OnClickListener onClickListener, boolean z5, int i7) {
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
            if (i5 != 0) {
                Context context = this.mContext;
                String strValueOf = String.valueOf(context != null ? context.getText(i5) : null);
                if (!TextUtils.isEmpty(strValueOf) && (emptyView2 = this.mEmptyView) != null) {
                    emptyView2.setTitle(strValueOf);
                }
            }
            if (i6 > 0) {
                EmptyView emptyView4 = this.mEmptyView;
                if (emptyView4 != null) {
                    emptyView4.setImageDrawable(androidx.core.content.a.e(getContext(), i6));
                }
            } else if (i6 < 0 && (emptyView = this.mEmptyView) != null) {
                emptyView.setImageDrawable(null);
            }
            if (z5) {
                Button button = this.btnSettingNetWork;
                if (button != null) {
                    button.setVisibility(0);
                }
                Button button2 = this.btnSettingNetWork;
                if (button2 != null) {
                    button2.setText(i7);
                }
            } else {
                Button button3 = this.btnSettingNetWork;
                if (button3 != null) {
                    button3.setVisibility(8);
                }
            }
            if (onClickListener == null) {
                Button button4 = this.btnSettingNetWork;
                if (button4 != null) {
                    button4.setOnClickListener(null);
                }
            } else {
                Button button5 = this.btnSettingNetWork;
                if (button5 != null) {
                    setDebounceClickListener(button5, onClickListener, 500L);
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
        } catch (Exception e6) {
            if (e6.getMessage() != null) {
                PolicySdkLogUtils.Companion.e("showEmptyView", "Exception = " + e6.getMessage());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.g(context, "context");
        this.mProgressShowRunnable = new Runnable() { // from class: com.stepos.policy.sdk.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                PolicySDKLoadDataView.mProgressShowRunnable$lambda$0(this.f15877a);
            }
        };
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.refContext = weakReference;
        this.mContext = weakReference.get();
        initView(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        k.g(context, "context");
        this.mProgressShowRunnable = new Runnable() { // from class: com.stepos.policy.sdk.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                PolicySDKLoadDataView.mProgressShowRunnable$lambda$0(this.f15877a);
            }
        };
        initView(context);
    }
}
