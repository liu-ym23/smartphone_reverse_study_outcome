package ao7;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.webkit.MimeTypeMap;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import in7.g;
import java.io.File;
import oo7.f;
import oo7.k;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f15798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShareContent f15799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d.a f15800c;

    @Override // in7.g
    public final void onDenied() {
        d.a r100 = this.f15800c;
        if (r100 == null) goto L6;
        pn7.b.a r101 = (pn7.b.a) r100;
        r101.f529982b.e(false, r101.f529981a);
        return;
    }

    @Override // in7.g
    public final void onGranted() {
        Activity r100 = this.f15798a;
        ShareContent r101 = this.f15799b;
        boolean r102 = false;
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        if (r101.getImage() == null) goto L12;
        d.a(r101);
        String r103 = "share_image_" + System.currentTimeMillis() + ".jpeg";
        String r104 = f.e();
        if (f.h(r101.getImage(), r104, r103) == false) goto L11;
        String r105 = r104 + File.separator + r103;
        f.j(r100, r105, true);
        MediaScannerConnection.scanFile(r100, new String[]{r105}, new String[]{MimeTypeMap.getSingleton().getMimeTypeFromExtension(".jpeg")}, new b());
        bo7.a.C0322a.f19870a.b(r103, false);
        r101.setImageUrl(r105);
        r102 = true;
        goto L12
    L11:
        k.e("ImageSaveUtils", "saveBitmapWithHiddenStr saveBitmapToSD false , dir = " + r104 + " , path = " + r103);
    L12:
        d.a r106 = this.f15800c;
        if (r106 == null) goto L16;
        pn7.b.a r107 = (pn7.b.a) r106;
        r107.f529982b.e(r102, r107.f529981a);
        return;
    }

    public c(Activity r100, ShareContent r101, pn7.b.a r102) {
        this.f15798a = r100;
        this.f15799b = r101;
        this.f15800c = r102;
    }
}
