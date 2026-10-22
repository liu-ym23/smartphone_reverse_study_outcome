package com.stepos.ailauncher.chat.util;

import La.H;
import android.app.Activity;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.chat.activity.PolicySheetActivity;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/util/j;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "", QueryAlgorithmBundle.KEY_CATEGORY, "title", "LY8/t;", "c", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V", "f", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class j {
    public static final j INSTANCE = new j();

    public static final void d(final Activity activity, final String str, final String str2, PolicySdkResultBean policySdkResultBean) {
        if (policySdkResultBean.getCode() != 0) {
            activity.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.chat.util.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.e(activity, str, str2);
                }
            });
        }
    }

    public static final void e(Activity activity, String str, String str2) {
        PolicySdk.openPolicyByMethod(activity, Boolean.TRUE, str, str2);
    }

    public final void c(final Activity activity, final String category, final String title) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(category, "category");
        kotlin.jvm.internal.p.i(title, "title");
        String language = PolicySdkToolsUtils.INSTANCE.getLanguage();
        if (language == null || H.x0(language)) {
            language = null;
        }
        if (language == null) {
            language = "zh_CN";
        }
        String str = language;
        C4148a.d("openPolicy", " category is " + category + " and language is " + str, false, 4, null);
        PolicySdk.getOnlinePolicyMethod(activity, str, category, title, Boolean.TRUE, new PolicySdk.PolicySdkCallback() { // from class: com.stepos.ailauncher.chat.util.h
            @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
            public final void getResult(PolicySdkResultBean policySdkResultBean) {
                j.d(activity, title, category, policySdkResultBean);
            }
        });
    }

    public final void f(Activity activity, String category, String title) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(category, "category");
        kotlin.jvm.internal.p.i(title, "title");
        C4148a.d("openPolicyInSheet", " category is " + category, false, 4, null);
        PolicySheetActivity.INSTANCE.c(activity, category, title);
    }
}
