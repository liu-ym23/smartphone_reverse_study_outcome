package G4;

import C7.r;
import F9.s;
import F9.t;
import a.AbstractC0291a;
import a7.AbstractC0308d;
import android.util.Log;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import ca.AbstractC0897f;
import com.stepos.ability.voicewakeup.setting.VoiceWakeSettingActivity;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.volcengine.tos.internal.TosResponse;
import com.volcengine.tos.model.bucket.CreateBucketV2Output;
import com.volcengine.tos.model.bucket.DeleteBucketCORSOutput;
import com.volcengine.tos.model.bucket.DeleteBucketCustomDomainOutput;
import com.volcengine.tos.model.bucket.DeleteBucketLifecycleOutput;
import com.volcengine.tos.model.bucket.DeleteBucketMirrorBackOutput;
import com.volcengine.tos.model.bucket.DeleteBucketOutput;
import com.volcengine.tos.model.bucket.DeleteBucketPolicyOutput;
import com.volcengine.tos.model.bucket.DeleteBucketRealTimeLogOutput;
import com.volcengine.tos.model.bucket.DeleteBucketRenameOutput;
import com.volcengine.tos.model.bucket.DeleteBucketReplicationOutput;
import com.volcengine.tos.model.bucket.GetBucketPolicyOutput;
import com.volcengine.tos.model.bucket.HeadBucketV2Output;
import com.volcengine.tos.model.bucket.ListBucketsV2Output;
import com.volcengine.tos.model.bucket.PutBucketACLOutput;
import com.volcengine.tos.model.bucket.PutBucketCORSOutput;
import com.volcengine.tos.model.bucket.PutBucketCustomDomainOutput;
import com.volcengine.tos.model.bucket.PutBucketLifecycleOutput;
import com.volcengine.tos.model.bucket.PutBucketMirrorBackOutput;
import com.volcengine.tos.model.bucket.PutBucketNotificationOutput;
import com.volcengine.tos.model.bucket.PutBucketPolicyOutput;
import com.volcengine.tos.model.bucket.PutBucketRenameOutput;
import com.volcengine.tos.model.bucket.PutBucketReplicationOutput;
import com.volcengine.tos.model.bucket.PutBucketStorageClassOutput;
import com.volcengine.tos.model.bucket.PutBucketVersioningOutput;
import com.volcengine.tos.model.bucket.PutBucketWebsiteOutput;
import k2.C1621a;
import kotlin.Result;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements OnApplyWindowInsetsListener, PolicySdk.PolicySdkCallback, s, C5.a, X6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f664a;

    public /* synthetic */ a(int i) {
        this.f664a = i;
    }

    @Override // C5.a
    public void b() {
        Object objA;
        try {
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (!C1621a.d) {
            throw new IllegalStateException("UsageStatsProxy3 is not initialised - invoke at least once with parameterised init");
        }
        O5.d dVar = O5.c.f1037a;
        I9.d.a(new C4.c(1));
        objA = r.f317a;
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.w("Analytics", "refreshDeviceInfo failed", thA);
        }
    }

    @Override // X6.a
    public Object c(TosResponse tosResponse) {
        switch (this.f664a) {
            case 5:
                return new HeadBucketV2Output(tosResponse.b(), tosResponse.c("X-Tos-Bucket-Region"), AbstractC0897f.u(tosResponse.c("X-Tos-Storage-Class")));
            case 6:
                return new PutBucketRenameOutput().setRequestInfo(tosResponse.b());
            case 7:
                return new PutBucketCORSOutput().setRequestInfo(tosResponse.b());
            case 8:
                return new DeleteBucketRenameOutput().setRequestInfo(tosResponse.b());
            case 9:
                return new PutBucketWebsiteOutput().setRequestInfo(tosResponse.b());
            case 10:
                return new DeleteBucketLifecycleOutput().setRequestInfo(tosResponse.b());
            case 11:
                return new PutBucketPolicyOutput().setRequestInfo(tosResponse.b());
            case 12:
                return new PutBucketVersioningOutput().setRequestInfo(tosResponse.b());
            case 13:
                return new DeleteBucketPolicyOutput().setRequestInfo(tosResponse.b());
            case 14:
                return new DeleteBucketMirrorBackOutput().setRequestInfo(tosResponse.b());
            case 15:
                return new DeleteBucketReplicationOutput().setRequestInfo(tosResponse.b());
            case 16:
                return ((ListBucketsV2Output) AbstractC0308d.a(tosResponse.d, new X6.e())).setRequestInfo(tosResponse.b());
            case 17:
                return new PutBucketACLOutput().setRequestInfo(tosResponse.b());
            case 18:
                return new PutBucketReplicationOutput().setRequestInfo(tosResponse.b());
            case 19:
                return new PutBucketCustomDomainOutput().setRequestInfo(tosResponse.b());
            case 20:
                return new DeleteBucketRealTimeLogOutput().setRequestInfo(tosResponse.b());
            case 21:
                return new PutBucketNotificationOutput().setRequestInfo(tosResponse.b());
            case 22:
                return new PutBucketLifecycleOutput().setRequestInfo(tosResponse.b());
            case 23:
                return new PutBucketStorageClassOutput().setRequestInfo(tosResponse.b());
            case 24:
                return new PutBucketMirrorBackOutput().setRequestInfo(tosResponse.b());
            case 25:
                return new CreateBucketV2Output(tosResponse.b(), tosResponse.c("Location"));
            case 26:
                return new DeleteBucketOutput(tosResponse.b());
            case 27:
                return new DeleteBucketCustomDomainOutput().setRequestInfo(tosResponse.b());
            case 28:
                return new DeleteBucketCORSOutput().setRequestInfo(tosResponse.b());
            default:
                return new GetBucketPolicyOutput().setRequestInfo(tosResponse.b()).setPolicy(AbstractC0291a.I(tosResponse.d, "bucket policy"));
        }
    }

    @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
    public void getResult(PolicySdkResultBean policySdkResultBean) {
        int i = VoiceWakeSettingActivity.f3343j;
    }

    @Override // F9.s
    public t i(J9.i iVar) {
        return t.f654a;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat insets) {
        int i = VoiceWakeSettingActivity.f3343j;
        kotlin.jvm.internal.k.f(view, "view");
        kotlin.jvm.internal.k.f(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        kotlin.jvm.internal.k.e(insets2, "getInsets(...)");
        view.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
        return insets;
    }

    public /* synthetic */ a(C1621a c1621a) {
        this.f664a = 16;
    }
}
