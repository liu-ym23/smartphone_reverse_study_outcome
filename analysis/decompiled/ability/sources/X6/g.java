package X6;

import a7.AbstractC0308d;
import com.volcengine.tos.internal.TosResponse;
import com.volcengine.tos.model.bucket.GetBucketACLOutput;
import com.volcengine.tos.model.bucket.GetBucketCORSOutput;
import com.volcengine.tos.model.bucket.GetBucketLifecycleOutput;
import com.volcengine.tos.model.bucket.GetBucketLocationOutput;
import com.volcengine.tos.model.bucket.GetBucketMirrorBackOutput;
import com.volcengine.tos.model.bucket.GetBucketNotificationOutput;
import com.volcengine.tos.model.bucket.GetBucketRealTimeLogOutput;
import com.volcengine.tos.model.bucket.GetBucketRenameOutput;
import com.volcengine.tos.model.bucket.GetBucketReplicationOutput;
import com.volcengine.tos.model.bucket.GetBucketVersioningOutput;
import com.volcengine.tos.model.bucket.GetBucketWebsiteOutput;
import com.volcengine.tos.model.bucket.ListBucketCustomDomainOutput;
import k2.C1621a;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1511a;
    public final /* synthetic */ C1621a b;

    public /* synthetic */ g(C1621a c1621a, int i) {
        this.f1511a = i;
        this.b = c1621a;
    }

    @Override // X6.a
    public final Object c(TosResponse tosResponse) {
        int i = this.f1511a;
        this.b.getClass();
        switch (i) {
            case 0:
                return ((GetBucketMirrorBackOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            case 1:
                return ((GetBucketCORSOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            case 2:
                return ((GetBucketReplicationOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            case 3:
                return ((ListBucketCustomDomainOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            case 4:
                return ((GetBucketACLOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            case 5:
                return ((GetBucketWebsiteOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            case 6:
                return ((GetBucketRenameOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            case 7:
                return ((GetBucketLocationOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            case 8:
                return ((GetBucketRealTimeLogOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            case 9:
                return ((GetBucketVersioningOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            case 10:
                return ((GetBucketNotificationOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            default:
                return ((GetBucketLifecycleOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
        }
    }
}
