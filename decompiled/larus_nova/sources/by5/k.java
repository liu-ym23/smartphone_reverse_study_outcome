package by5;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f21455a;

    public k(m r100) {
        this.f21455a = r100;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r110) {
        String r100 = r110.getName();
        this.f21455a.getClass();
        String r101 = r110.getName();
        int r102 = r101.indexOf("_");     // Catch: Exception -> L15
        if (r102 == (-1)) goto L9;
        if ((System.currentTimeMillis() - CastLongProtector.parseLong(r101.substring(0, r102))) < 604800000) goto L9;
        boolean r103 = true;
    L26:
        if (n.f21462e == false) goto L16;
        fy5.c.a("fileName:" + r101 + " " + r103);     // Catch: Exception -> L14
    L16:
        if (r103 == false) goto L20;
        xu3.b.a(r110);
        return false;
    L20:
        if (r100.endsWith(".log") == false) goto L22;
        return true;
    L22:
        r100.endsWith(DefaultDiskStorage.FileType.TEMP);
        return false;
    L9:
        r103 = false;
    L15:
        r103 = false;
        goto L16
    }
}
