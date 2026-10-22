package com.stepos.policy.sdk.widget;

import a4.t;
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
import com.stepos.common.widget.EmptyView;
import com.stepos.common.widget.LoadingView;
import com.stepos.policy.sdk.R;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import kc.e0;
import kc.w;
import kc.x0;
import pc.n;
import rc.e;
import yb.f;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(Context context) {
        super(context);
        context.getClass();
        t tVar = new t(9);
        tVar.f200f = this;
        VarHandle.storeStoreFence();
        this.mProgressShowRunnable = tVar;
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.refContext = weakReference;
        this.mContext = weakReference.get();
        initView(context);
    }

    private final void initView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.policysdk_load_data_view, this);
        View viewFindViewById = viewInflate.findViewById(R.id.loading_view);
        viewFindViewById.getClass();
        this.mProgressView = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(com.stepos.agentsafetycenter.R.id.mc_loading_view);
        viewFindViewById2.getClass();
        this.mLoadingView = (LoadingView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.empty_view);
        viewFindViewById3.getClass();
        this.mEmptyView = (EmptyView) viewFindViewById3;
        this.layoutEmptyView = (ConstraintLayout) findViewById(R.id.layout_empty_view);
        View viewFindViewById4 = viewInflate.findViewById(R.id.btn_setting_net_work);
        viewFindViewById4.getClass();
        this.btnSettingNetWork = (Button) viewFindViewById4;
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mProgressShowRunnable$lambda$0(PolicySDKLoadDataView policySDKLoadDataView) {
        policySDKLoadDataView.getClass();
        policySDKLoadDataView.showProgressNoDelay();
    }

    private final void setDebounceClickListener(View view, View.OnClickListener onClickListener, long j10) {
        u uVar = new u();
        a aVar = new a();
        aVar.f2807c = uVar;
        aVar.f2808f = j10;
        aVar.f2809g = onClickListener;
        VarHandle.storeStoreFence();
        view.setOnClickListener(aVar);
    }

    public static /* synthetic */ void setDebounceClickListener$default(PolicySDKLoadDataView policySDKLoadDataView, View view, View.OnClickListener onClickListener, long j10, int i, Object obj) {
        if ((i & 2) != 0) {
            j10 = 500;
        }
        policySDKLoadDataView.setDebounceClickListener(view, onClickListener, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDebounceClickListener$lambda$1(u uVar, long j10, View.OnClickListener onClickListener, View view) {
        uVar.getClass();
        onClickListener.getClass();
        x0 x0Var = (x0) uVar.f16098c;
        if (x0Var != null) {
            x0Var.e(null);
        }
        e eVar = e0.f7430a;
        uVar.f16098c = w.u(w.a(n.f9978a), null, null, new PolicySDKLoadDataView$setDebounceClickListener$1$1(j10, onClickListener, view, null), 3);
    }

    public static /* synthetic */ void showEmptyView$default(PolicySDKLoadDataView policySDKLoadDataView, int i, int i3, View.OnClickListener onClickListener, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            i10 = 0;
        }
        policySDKLoadDataView.showEmptyView(i, i3, onClickListener, z10, i10);
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
        if (loadingView2 == null || (objectAnimator = loadingView2.f2612h) == null) {
            return;
        }
        objectAnimator.cancel();
        loadingView2.f2612h = null;
    }

    public final void setLayoutEmptyView(ConstraintLayout constraintLayout) {
        this.layoutEmptyView = constraintLayout;
    }

    public final void showEmptyView(int i, int i3, View.OnClickListener onClickListener, boolean z10, int i10) {
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
            if (i != 0) {
                Context context = this.mContext;
                String strValueOf = String.valueOf(context != null ? context.getText(i) : null);
                if (!TextUtils.isEmpty(strValueOf) && (emptyView2 = this.mEmptyView) != null) {
                    emptyView2.setTitle(strValueOf);
                }
            }
            if (i3 > 0) {
                EmptyView emptyView4 = this.mEmptyView;
                if (emptyView4 != null) {
                    emptyView4.setImageDrawable(getContext().getDrawable(i3));
                }
            } else if (i3 < 0 && (emptyView = this.mEmptyView) != null) {
                emptyView.setImageDrawable(null);
            }
            Button button = this.btnSettingNetWork;
            if (z10) {
                if (button != null) {
                    button.setVisibility(0);
                }
                Button button2 = this.btnSettingNetWork;
                if (button2 != null) {
                    button2.setText(i10);
                }
            } else if (button != null) {
                button.setVisibility(8);
            }
            Button button3 = this.btnSettingNetWork;
            if (onClickListener == null) {
                if (button3 != null) {
                    button3.setOnClickListener(null);
                }
            } else if (button3 != null) {
                setDebounceClickListener(button3, onClickListener, 500L);
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
                PolicySdkLogUtils.Companion.e("showEmptyView", "Exception = " + e10.getMessage());
            }
        }
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
            loadingView2.b();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        t tVar = new t(9);
        tVar.f200f = this;
        VarHandle.storeStoreFence();
        this.mProgressShowRunnable = tVar;
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.refContext = weakReference;
        this.mContext = weakReference.get();
        initView(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        t tVar = new t(9);
        tVar.f200f = this;
        VarHandle.storeStoreFence();
        this.mProgressShowRunnable = tVar;
        initView(context);
    }

    public final void showEmptyView(int i, int i3, View.OnClickListener onClickListener, boolean z10) {
        showEmptyView$default(this, i, i3, onClickListener, z10, 0, 16, null);
    }
}
