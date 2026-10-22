package com.stepos.policy.sdk.activity;

import Z2.F;
import android.app.Activity;
import android.content.Context;
import androidx.core.content.g;
import com.stepos.alphame.persona.privacy.PolicyManager;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.widget.PolicySDKLoadDataView;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.stepos.policy.sdk.activity.PolicyWebViewActivity$fetchPolicyData$1$getResult$1", f = "PolicyWebViewActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nPolicyWebViewActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PolicyWebViewActivity.kt\ncom/stepos/policy/sdk/activity/PolicyWebViewActivity$fetchPolicyData$1$getResult$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,607:1\n1#2:608\n*E\n"})
/* loaded from: classes.dex */
public final class PolicyWebViewActivity$fetchPolicyData$1$getResult$1 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $category;
    final /* synthetic */ PolicySdkResultBean $policySdkResultBean;
    int label;
    final /* synthetic */ PolicyWebViewActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyWebViewActivity$fetchPolicyData$1$getResult$1(PolicyWebViewActivity policyWebViewActivity, PolicySdkResultBean policySdkResultBean, Ref.ObjectRef<String> objectRef, Continuation<? super PolicyWebViewActivity$fetchPolicyData$1$getResult$1> continuation) {
        super(2, continuation);
        this.this$0 = policyWebViewActivity;
        this.$policySdkResultBean = policySdkResultBean;
        this.$category = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PolicyWebViewActivity$fetchPolicyData$1$getResult$1(this.this$0, this.$policySdkResultBean, this.$category, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v18, types: [T, com.stepos.policy.sdk.bean.PolicySdkResultBean] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, com.stepos.policy.sdk.bean.PolicySdkResultBean] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Context context;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        PolicySDKLoadDataView loadDataView = this.this$0.getLoadDataView();
        if (loadDataView != null) {
            loadDataView.hideProgress();
        }
        PolicySdkResultBean policySdkResultBean = this.$policySdkResultBean;
        if (policySdkResultBean == null || policySdkResultBean.getCode() != 0) {
            try {
                if (this.this$0.mActivity != null) {
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    ?? policyNewestPath = PolicySdk.getPolicyNewestPath(this.this$0.mActivity, this.$category.element);
                    objectRef.element = policyNewestPath;
                    if (policyNewestPath.getCode() != 0 && (context = this.this$0.mContext) != null) {
                        objectRef.element = PolicySdk.getPolicyNewestPath(context.createDeviceProtectedStorageContext(), this.$category.element);
                    }
                    if (((PolicySdkResultBean) objectRef.element).getCode() == 0) {
                        PolicySdkResultBean policySdkResultBean2 = (PolicySdkResultBean) objectRef.element;
                        T uriForFile = 0;
                        String policyNewestPath2 = policySdkResultBean2 != null ? policySdkResultBean2.getPolicyNewestPath() : null;
                        File file = new File(policyNewestPath2);
                        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                        companion.d(PolicyManager.TAG, "newestFile exists = " + file.exists() + ' ');
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        Activity activity = this.this$0.mActivity;
                        if (activity != null) {
                            PolicyWebViewActivity policyWebViewActivity = this.this$0;
                            StringBuilder sb = new StringBuilder();
                            Activity activity2 = policyWebViewActivity.mActivity;
                            sb.append(activity2 != null ? activity2.getPackageName() : null);
                            sb.append(".PolicySdk.FileProvider");
                            uriForFile = g.getUriForFile(activity, sb.toString(), file);
                        }
                        objectRef2.element = uriForFile;
                        companion.d(PolicyManager.TAG, "fetchPolicyData  getLocalPolicySdkResultBean = " + policyNewestPath2 + ' ');
                        if (policyNewestPath2 != null) {
                            this.this$0.webViewLoadData(String.valueOf(objectRef2.element));
                        }
                    }
                } else {
                    PolicySdkLogUtils.INSTANCE.d("fetchPolicyData", "mActivity == null showNetWorkErrorView");
                }
                this.this$0.showNetWorkErrorView();
            } catch (Exception e4) {
                this.this$0.showNetWorkErrorView();
                PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
                StringBuilder sb2 = new StringBuilder("Exception= ");
                e4.printStackTrace();
                sb2.append(Unit.INSTANCE);
                sb2.append(' ');
                companion2.d("fetchPolicyData", sb2.toString());
            }
        } else {
            this.this$0.mUri = this.$policySdkResultBean.getPolicyUrl();
            this.this$0.webViewLoadData(this.$policySdkResultBean.getPolicyUrl());
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
        return ((PolicyWebViewActivity$fetchPolicyData$1$getResult$1) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
