package c85;

import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.config.strategy.m;

/* JADX INFO: loaded from: classes16.dex */
public class b extends a<f85.a> {
    @Override // c85.e
    public final String a(w75.c<f85.a> r100) {
        return this.f22719b.i(r100.getDetails());
    }

    public b(com.bytedance.ee.bear.drive.config.strategy.d r100, a95.a r101) {
        super(r100, r101);
    }

    @Override // c85.a
    public boolean d(DriveCache r100, w75.c<f85.a> r101) {
        boolean r102 = super.d(r100, r101);
        if (r102 == true) goto L5;
    L12:
        return r102;
    L5:
        if ((this.f22719b instanceof m) == false) goto L12;
        DriveFilePath r103 = r100.f216968b;
        if (r103 != null) goto L9;
    L10:
        tt5.a.h("DriveComponent", "DriveCacheHandler#availableCache() not enable streaming and not found cache in vc");
        return false;
    L9:
        if (z75.b.d(r103, this.f22721d.f2278b) == true) goto L12;
        goto L10
    }
}
