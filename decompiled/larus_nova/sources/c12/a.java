package c12;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.revenue.common.c0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends fd6.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f22012c;

    public a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "mInputProducer");
        super(r100);
        boolean r101 = true;
        if (((Number) com.bytedance.android.livesdk.gift.platform.business.b.C.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.f126533a[27])).intValue() == 1) goto L6;
        r101 = false;
    L6:
        this.f22012c = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.String] */
    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a
    public final void b(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r110, String r111) {
        String r112 = r111;
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r112, "s");
        GiftResourceFileCacheService r100 = (GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class);
        if (r100.h().getEnable() == false) goto L51;
        Intrinsics.checkNotNullParameter(r110, "request");
        StringBuilder r101 = new StringBuilder();
        int r102 = uy0.a.f552061a;
        String r103 = r100.f();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r101.append(uy0.a.a(r103));
        r101.append(r110.f129101k);
        String r104 = r101.toString();
        new PolarisFileWrapper(r104).mkdirs();
        if (this.f22012c == false) goto L28;
        PolarisZipFileWrapper r105 = new PolarisZipFileWrapper(r112);
        Enumeration<? extends ZipEntry> r113 = r105.entries();
    L11:
        if (r113.hasMoreElements() == false) goto L27;
        ZipEntry r106 = r113.nextElement();
        String r107 = r106.getName();
        if (r107.contains("../") == true) goto L11;
        if (r106.isDirectory() == true) goto L17;
        PolarisFileWrapper r108 = new PolarisFileWrapper(r104 + File.separator + r107);
        if (r108.exists() == false) goto L21;
        r108.delete();
    L22:
        r108.createNewFile();
        BufferedOutputStream r109 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r108));
        byte[] r114 = new byte[2048];
        InputStream r115 = r105.getInputStream(r106);
    L23:
        int r116 = r115.read(r114);
        if (r116 == (-1)) goto L26;
        r109.write(r114, 0, r116);
        goto L23
    L26:
        r109.flush();
        r109.close();
        r115.close();
        goto L11
    L21:
        r108.getParentFile().mkdirs();
        goto L22
    L17:
        new PolarisFileWrapper(r104 + File.separator + r107).mkdirs();
        goto L11
    L27:
        r105.close();
    L47:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r117 = this.f476539a;
        if (r117 == null) goto L50;
        r117.b(r110, r104);
    L50:
        c0.b(new PolarisFileWrapper(r100.a(r110)));
        return;
    L28:
        ZipInputStream r118 = new ZipInputStream(new BufferedInputStream(new PolarisFileInputStreamWrapper(r112)));
    L29:
        ZipEntry r119 = r118.getNextEntry();
        if (r119 == null) goto L46;
        String r120 = r119.getName();
        if (r120.contains("../") == true) goto L29;
        if (r119.isDirectory() == true) goto L36;
        PolarisFileWrapper r121 = new PolarisFileWrapper(r104 + File.separator + r120);
        if (r121.exists() == false) goto L40;
        r121.delete();
    L41:
        r121.createNewFile();
        BufferedOutputStream r122 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r121));
        byte[] r123 = new byte[2048];
    L42:
        int r124 = r118.read(r123);
        if (r124 == (-1)) goto L45;
        r122.write(r123, 0, r124);
        goto L42
    L45:
        r122.flush();
        r122.close();
        goto L29
    L40:
        r121.getParentFile().mkdirs();
        goto L41
    L36:
        new PolarisFileWrapper(r104 + File.separator + r120).mkdirs();
        goto L29
    L46:
        r118.close();
        goto L47
    L51:
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r112, "s");
        Ref.ObjectRef r125 = new Ref.ObjectRef();
        r125.element = r112.substring(0, StringsKt.lastIndexOf$default(r112, HTTP.URL_DEFAULT, 0, false, 6, null));
        uy0.b r126 = (uy0.b) com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class);
        r126.unZipFolder(r112, (String) r125.element).subscribe(new fd6.c(this, r110, r125, r126, r112), new fd6.d(this, r110, r126, r125));
    }
}
