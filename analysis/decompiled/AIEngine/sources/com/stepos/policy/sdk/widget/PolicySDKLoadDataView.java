package com.stepos.policy.sdk.widget;

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
import androidx.appcompat.widget.y0;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.aiengine.R;
import com.stepos.common.widget.EmptyView;
import com.stepos.common.widget.LoadingView;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(Context context) {
        super(context);
        g.f(context, "context");
        this.mProgressShowRunnable = new y0(this, 9);
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.refContext = weakReference;
        this.mContext = weakReference.get();
        initView(context);
    }

    private final void initView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.policysdk_load_data_view, this);
        View viewFindViewById = viewInflate.findViewById(R.id.loading_view);
        g.d(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.mProgressView = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.mc_loading_view);
        g.d(viewFindViewById2, "null cannot be cast to non-null type com.stepos.common.widget.LoadingView");
        this.mLoadingView = (LoadingView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.empty_view);
        g.d(viewFindViewById3, "null cannot be cast to non-null type com.stepos.common.widget.EmptyView");
        this.mEmptyView = (EmptyView) viewFindViewById3;
        this.layoutEmptyView = (ConstraintLayout) findViewById(R.id.layout_empty_view);
        View viewFindViewById4 = viewInflate.findViewById(R.id.btn_setting_net_work);
        g.d(viewFindViewById4, "null cannot be cast to non-null type android.widget.Button");
        this.btnSettingNetWork = (Button) viewFindViewById4;
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mProgressShowRunnable$lambda$0(PolicySDKLoadDataView this$0) {
        g.f(this$0, "this$0");
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
    /* JADX WARN: Type inference failed for: r9v1, types: [T, kotlinx.coroutines.Job] */
    public static final void setDebounceClickListener$lambda$1(Ref$ObjectRef job, long j10, View.OnClickListener listener, View view) {
        g.f(job, "$job");
        g.f(listener, "$listener");
        Job job2 = (Job) job.f10076a;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, null, 1, null);
        }
        job.f10076a = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new PolicySDKLoadDataView$setDebounceClickListener$1$1(j10, listener, view, null), 3, null);
    }

    public static /* synthetic */ void showEmptyView$default(PolicySDKLoadDataView policySDKLoadDataView, int i10, int i11, View.OnClickListener onClickListener, boolean z, int i12, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            i12 = 0;
        }
        policySDKLoadDataView.showEmptyView(i10, i11, onClickListener, z, i12);
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
        if (loadingView2 == null || (objectAnimator = loadingView2.f6939d) == null) {
            return;
        }
        objectAnimator.cancel();
        loadingView2.f6939d = null;
    }

    public final void setLayoutEmptyView(ConstraintLayout constraintLayout) {
        this.layoutEmptyView = constraintLayout;
    }

    public final void showEmptyView(int i10, int i11, View.OnClickListener onClickListener, boolean z) {
        showEmptyView$default(this, i10, i11, onClickListener, z, 0, 16, null);
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

    public final void showEmptyView(int i10, int i11, View.OnClickListener onClickListener, boolean z, int i12) {
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
            if (i10 != 0) {
                Context context = this.mContext;
                String strValueOf = String.valueOf(context != null ? context.getText(i10) : null);
                if (!TextUtils.isEmpty(strValueOf) && (emptyView2 = this.mEmptyView) != null) {
                    emptyView2.setTitle(strValueOf);
                }
            }
            if (i11 > 0) {
                EmptyView emptyView4 = this.mEmptyView;
                if (emptyView4 != null) {
                    emptyView4.setImageDrawable(getContext().getDrawable(i11));
                }
            } else if (i11 < 0 && (emptyView = this.mEmptyView) != null) {
                emptyView.setImageDrawable(null);
            }
            if (z) {
                Button button = this.btnSettingNetWork;
                if (button != null) {
                    button.setVisibility(0);
                }
                Button button2 = this.btnSettingNetWork;
                if (button2 != null) {
                    button2.setText(i12);
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
        } catch (Exception e10) {
            if (e10.getMessage() != null) {
                PolicySdkLogUtils.Companion.e("showEmptyView", "Exception = " + e10.getMessage());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g.f(context, "context");
        this.mProgressShowRunnable = new y0(this, 9);
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.refContext = weakReference;
        this.mContext = weakReference.get();
        initView(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        g.f(context, "context");
        this.mProgressShowRunnable = new y0(this, 9);
        initView(context);
    }
}
