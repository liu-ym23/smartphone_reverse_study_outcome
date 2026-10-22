package c85;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.passportc.entity.UserSession;
import w75.a;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a<FM extends w75.a> implements e<FM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f22718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.config.strategy.d f22719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.report.a f22720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a95.a f22721d;

    @Override // c85.e
    public final void b(w75.c<FM> r100) {
        e(r100, a(r100));
    }

    public a(com.bytedance.ee.bear.drive.config.strategy.d r100, a95.a r101) {
        this.f22721d = r101;
        this.f22718a = t.l();
        this.f22719b = r100;
        this.f22720c = o75.b.a().Tb();
    }

    @Override // c85.e
    public final boolean c(w75.c<FM> r110, e.a r111) {
        this.f22720c.b(r110.getFileToken(), BitableNativeViewData.LOCAL_CACHE, this.f22719b);
        w75.a r100 = r110.getDetails();
        String r101 = a(r110);
        e(r110, r101);
        UserSession r102 = this.f22721d.f2278b;
        boolean r103 = !TextUtils.equals(this.f22719b.getPreviewFileSourceType(), "2");
        t r104 = this.f22718a;
        a95.a r105 = this.f22721d;
        r104.getClass();
        DriveCache r106 = t.i(r101, r103, r105);
        if (r106 != null) goto L5;
    L27:
        f85.a r107 = t.a(r100.c().f558557a, r106, "", this.f22721d);
        if (d(r106, r110) == false) goto L42;
        if (r111 != null) goto L31;
        boolean r112 = true;
    L32:
        if (r112 == false) goto L42;
        this.f22720c.s(BitableNativeViewData.LOCAL_CACHE, r107, this.f22719b);
        r100.f558542k = r107.a();
        r100.f558543l = r107.b();
        r100.f(true);
        if (TextUtils.equals(((f85.a.C5868a) r107.f558532a).f558558b, r100.c().f558558b) == true) goto L37;
        t r113 = this.f22718a;
        String r114 = r100.c().f558558b;
        r113.getClass();
        t.q(r101, r114);
    L37:
        if ((this.f22719b instanceof com.bytedance.ee.bear.drive.config.strategy.g) == true) goto L39;
    L41:
        return true;
    L39:
        if (r106.getType() == 2) goto L41;
        tt5.a.h("DRIVE_PREVIEW_FLOW", "convertCacheTypeSync");
        t r115 = this.f22718a;
        int r108 = r106.getType();
        UserSession r109 = this.f22721d.f2278b;
        r115.getClass();
        ((com.bytedance.ee.bear.drive.services.c) org.koin.java.a.a(com.bytedance.ee.bear.drive.services.c.class)).T5(r101, r108, 2, r109);
        goto L41
    L31:
        r112 = r111.isCacheValid(this.f22719b, r107);
    L42:
        return false;
    L5:
        if (r106.f216984r == true) goto L7;
    L9:
        boolean r116 = false;
    L10:
        if (r116 == false) goto L12;
    L20:
        StringBuilder r117 = new StringBuilder("Download findCacheFile() is wps cache, ignore it, wps=");
        if (r106.f216984r == true) goto L23;
    L25:
        boolean r118 = false;
    L26:
        r117.append(r118);
        tt5.a.h("DriveComponent", r117.toString());
        r106 = null;
        goto L27
    L23:
        if (z75.b.d(r106.f216968b, r102) == true) goto L25;
        r118 = true;
        goto L26
    L12:
        if ("3".equals(r106.f216972f) == true) goto L14;
    L18:
        boolean r119 = false;
    L19:
        if (r119 == false) goto L27;
    L14:
        if ("txt".equalsIgnoreCase(r106.f216970d) == false) goto L18;
        if ("txt".equalsIgnoreCase(r106.f216974h) == false) goto L18;
        r119 = true;
        goto L19
    L7:
        if (z75.b.d(r106.f216968b, r102) == true) goto L9;
        r116 = true;
        goto L10
    }

    public boolean d(DriveCache r100, w75.c<FM> r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101.B() == null) goto L25;
        String r102 = r100.f216970d;
        if (TextUtils.equals(r100.f216977k, r101.getFileToken()) == true) goto L10;
        return false;
    L10:
        if (TextUtils.equals(r100.f216971e, r101.h()) == true) goto L12;
        return false;
    L12:
        if (TextUtils.isEmpty(r102) == false) goto L14;
        return false;
    L14:
        if (r102.equalsIgnoreCase(r101.B()) == true) goto L16;
        return false;
    L16:
        if (TextUtils.equals(r100.f216983q, r101.getDetails().f558549r) == false) goto L24;
        return true;
    L24:
        return false;
    L25:
        return false;
    }

    public final void e(w75.c<FM> r100, String r101) {
        com.bytedance.ee.bear.drive.config.strategy.d r102 = this.f22719b;
        Application r103 = eu5.b.f474075a;
        r100.getFileSize();
        DriveFilePath r104 = r102.h(r103);
        r104.cacheName(r101);
        String r105 = r101 + ChameleonResConstants.TEMP_SUFFIX;
        com.bytedance.ee.bear.drive.config.strategy.d r106 = this.f22719b;
        Application r107 = eu5.b.f474075a;
        r100.getFileSize();
        DriveFilePath r108 = r106.h(r107);
        r108.cacheName(r105);
        r100.g(r104);
        r100.m(r108);
    }
}
