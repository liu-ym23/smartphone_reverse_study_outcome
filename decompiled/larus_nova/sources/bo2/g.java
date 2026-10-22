package bo2;

import com.ss.bduploader.BDObjectInfo;
import com.ss.bduploader.BDObjectUploader;
import com.ss.bduploader.BDObjectUploaderListener;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements BDObjectUploaderListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BDObjectUploader f19794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ad2.b f19795b;

    @Override // com.ss.bduploader.BDObjectUploaderListener
    public final int objectUploadCheckNetState(int r100, int r101) {
        return 0;
    }

    public g(BDObjectUploader r100, i r101) {
        this.f19794a = r100;
        this.f19795b = r101;
    }

    @Override // com.ss.bduploader.BDObjectUploaderListener
    public final void onLog(int r100, int r101, String r102) {
    }

    @Override // com.ss.bduploader.BDObjectUploaderListener
    public final void onNotify(int r100, long r101, BDObjectInfo r102) {
        String r103 = "";
        boolean r104 = false;
        if (r100 != 6) goto L5;
        this.f19794a.close();
        ad2.b r105 = this.f19795b;
        if (r105 == null) goto L23;
        if (r102 == null) goto L14;
        r104 = true;
    L14:
        if (r102 == null) goto L19;
        String r106 = r102.mImageTosKey;
        if (r106 == null) goto L19;
        r103 = r106;
    L19:
        r105.a(r104, r103);
        return;
    L23:
        return;
    L5:
        if (r100 != 7) goto L24;
        this.f19794a.close();
        ad2.b r107 = this.f19795b;
        if (r107 == null) goto L21;
        r107.a(false, "");
        return;
    L21:
        return;
    }
}
