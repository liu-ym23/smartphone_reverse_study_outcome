package g9;

import android.content.Context;
import android.content.UriMatcher;
import android.graphics.Bitmap;
import com.stepos.agentsafetycenter.permission.AgentPermissionProvider;
import java.io.File;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4508c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Context f4509f;

    @Override // xb.a
    public final Object invoke() {
        int i = this.f4508c;
        Context context = this.f4509f;
        switch (i) {
            case 0:
                UriMatcher uriMatcher = AgentPermissionProvider.f2512f;
                break;
            case 1:
                Bitmap.Config config = i6.d.f5804a;
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    od.f.e("cacheDir == null");
                    break;
                } else {
                    cacheDir.mkdirs();
                    break;
                }
            default:
                Bitmap.Config config2 = i6.d.f5804a;
                File cacheDir2 = context.getCacheDir();
                if (cacheDir2 == null) {
                    od.f.e("cacheDir == null");
                    break;
                } else {
                    cacheDir2.mkdirs();
                    break;
                }
        }
        return null;
    }
}
