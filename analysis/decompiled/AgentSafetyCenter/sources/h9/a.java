package h9;

import android.content.Context;
import android.util.Log;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements PolicySdk.PolicySdkCallback {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ b f5417a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Context f5418b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ String f5419c;

    @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
    public final void getResult(PolicySdkResultBean policySdkResultBean) {
        int code = policySdkResultBean != null ? policySdkResultBean.getCode() : -1;
        if (code == 0) {
            return;
        }
        if (code != -10003 && code != -1) {
            Log.w("PolicySdkInit", "getOnlinePolicyMethod code=" + code);
        } else {
            b bVar = this.f5417a;
            Context context = this.f5418b;
            String str = this.f5419c;
            bVar.getClass();
            b.b(context, str);
        }
    }
}
