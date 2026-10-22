package bo2;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.performance.hprof.data.LiveUploadInfoRes;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.bduploader.BDObjectUploader;
import io.reactivex.functions.Consumer;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f19806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ File f19807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ff7.e f19808c;

    public j(h r100, PolarisFileWrapper r101, ff7.e r102) {
        this.f19806a = r100;
        this.f19807b = r101;
        this.f19808c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Response r111 = (Response) r110;
        this.f19806a.getClass();
        ((LiveUploadInfoRes) r111.data).getClass();
        h r100 = this.f19806a;
        LiveUploadInfoRes r112 = (LiveUploadInfoRes) r111.data;
        File r101 = this.f19807b;
        ff7.e r102 = this.f19808c;
        if (r112 == null) goto L18;
        h.a r103 = r100.f19798c;
        String r104 = r112.getDomain();
        String r105 = r112.getAccessKey();
        String r106 = r112.getSecretKey();
        String r107 = r112.getSpaceName();
        String r113 = r112.getSession();
        i r108 = new i(r100, r102);
        r103.getClass();
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        if (r105 != null) goto L9;
        r105 = "";
    L9:
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        if (r107 != null) goto L13;
        r107 = "";
    L13:
        if (r113 != null) goto L15;
        r113 = "";
    L15:
        Intrinsics.checkNotNullParameter(r104, "domain");
        Intrinsics.checkNotNullParameter(r105, "ak");
        Intrinsics.checkNotNullParameter(r106, "sk");
        Intrinsics.checkNotNullParameter(r107, "spaceName");
        Intrinsics.checkNotNullParameter(r113, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        BDObjectUploader r109 = new BDObjectUploader();
        r109.setSliceSize(5);
        r109.setSocketNum(5);
        r109.setFileRetryCount(2);
        r109.setSliceRetryCount(2);
        r109.setTopAccessKey(r105);
        r109.setTopSecretKey(r106);
        r109.setTopSessionToken(r113);
        r109.setSpaceName(r107);
        r109.setEnableHttps(1);
        r109.setUploadDomain(r104);
        r109.setEnableCommitUpload(true);
        if (r101 == null) goto L20;
        String[] r114 = {r101.getAbsolutePath()};
        r109.setListener(new g(r109, r108));
        r109.setFilePath(1, r114);
        r109.start();
        return;
    L20:
        return;
    L18:
        r100.getClass();
    }
}
