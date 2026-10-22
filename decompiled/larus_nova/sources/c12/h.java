package c12;

import android.util.Log;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.BaseGetResourceException;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.Md5InvalidException;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.ss.android.ttmd5.TTMd5;
import java.io.File;
import java.util.HashMap;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements fd6.b<String>, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fd6.b<String> f22034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> f22035b;

    public h(fd6.b r100) {
        this.f22034a = r100;
    }

    @Override // fd6.b
    public final void a(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r101) {
        this.f22035b = r101;
        this.f22034a.a(r100, this);
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a
    public final void b(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r210, String r211) {
        String r100 = r211;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);     // Catch: Exception -> L36
        HashMap r110 = new HashMap();     // Catch: Exception -> L36
        r110.put(ChameleonAssertResManager.ASSET_FOLDER, String.valueOf(r210.f129099i));     // Catch: Exception -> L36
        long r111 = System.currentTimeMillis();     // Catch: Exception -> L36
        KmpEnv r112 = KmpEnv.f255139a;     // Catch: Exception -> L36
        if (KmpEnv.a() == true) goto L7;
    L24:
        String r113 = rlc.a.a(r101);     // Catch: Exception -> L36
        boolean r114 = r210.f129101k.equals(r113);     // Catch: Exception -> L36
        jy0.b.b("OptMD5Producer", "MD5 isOK:" + r114 + " file:" + r100, null);     // Catch: Exception -> L36
        if (r114 == false) goto L27;
        Object r102 = "md5";
    L28:
        r110.put("type", r102);     // Catch: Exception -> L36
    L29:
        r110.put("time", String.valueOf((int) (System.currentTimeMillis() - r111)));     // Catch: Exception -> L36
        i0.c().post(new g(r110));     // Catch: Exception -> L36
        if (r114 == true) goto L32;
        l(r210, new Md5InvalidException(String.format("File %1$s md5 is not equals", new Object[]{r100}), r210, r113));     // Catch: Exception -> L36
        r101.delete();     // Catch: Exception -> L36
        StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L36
        r103.append(r100.substring(0, r100.lastIndexOf(File.separator) + 1));     // Catch: Exception -> L36
        Lazy r104 = GiftResourceManagerFactory.f122285a;     // Catch: Exception -> L36
        r103.append(".fetched");     // Catch: Exception -> L36
        new PolarisFileWrapper(r103.toString()).delete();     // Catch: Exception -> L36
        return;
    L32:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r105 = this.f22035b;     // Catch: Exception -> L36
        if (r105 == null) goto L41;
        r105.b(r210, r100);     // Catch: Exception -> L36
        return;
    L41:
        return;
    L27:
        r102 = "md5E";
        goto L28
    L7:
        if ((r210 instanceof n) == false) goto L24;
        if (((n) r210).f22052q == null) goto L24;
        if (((n) r210).f22052q.isEmpty() == true) goto L24;
        String r115 = TTMd5.ttmd5(r101);     // Catch: Exception -> L36
        r114 = ((n) r210).f22052q.equals(r115);     // Catch: Exception -> L36
        jy0.b.b("OptMD5Producer", "TTMD5 isOK:" + r114 + " file:" + r100, null);     // Catch: Exception -> L36
        if (r114 == false) goto L15;
        String r106 = "ttmd5";
    L16:
        r110.put("type", r106);     // Catch: Exception -> L36
        if (r114 == true) goto L23;
        r113 = rlc.a.a(r101);     // Catch: Exception -> L36
        r114 = r210.f129101k.equals(r113);     // Catch: Exception -> L36
        jy0.b.b("OptMD5Producer", "MD5 isOK:" + r114 + " file:" + r100, null);     // Catch: Exception -> L36
        if (r114 == false) goto L21;
        Object r107 = "md5";
    L22:
        r110.put("type", r107);     // Catch: Exception -> L36
        goto L29
    L21:
        r107 = "md5E";
        goto L22
    L23:
        r113 = r115;
        goto L29
    L15:
        r106 = "ttmd5E";
    L36:
        e = move-exception;
        HashMap r108 = new HashMap();
        r108.put(ChameleonAssertResManager.ASSET_FOLDER, String.valueOf(r210.f129099i));
        r108.put("type", "error");
        r108.put("time", "0");
        r108.put("error_trace", Log.getStackTraceString(e));
        i0.c().post(new g(r108));
        l(r210, new Md5InvalidException(String.format("File %1$s md5 error", new Object[]{r100}), e, r210, ""));
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a
    public final void l(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100, BaseGetResourceException r101) {
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r102 = this.f22035b;
        if (r102 == null) goto L6;
        r102.l(r100, r101);
        return;
    }
}
