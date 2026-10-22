package b9a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends a9a.a {
    @Override // a9a.a
    public final String f() {
        return CloudControlInf.DATA_CLEAR;
    }

    public e() {
    }

    @Override // a9a.a
    public final boolean g(z8a.a r210) throws Exception {
        JSONObject r100 = new JSONObject(r210.f570965a);
        if (a9a.a.e(r100, r210) == false) goto L5;
        return true;
    L5:
        String r101 = r100.optString("rootNode");
        String r102 = r100.optString("relativeDirName");
        int r103 = com.monitor.cloudmessage.utils.a.f384389a;
        Context r104 = x8a.c.b().getContext();
        r101.getClass();
        switch(r101.hashCode()) {
            case -1481211727: goto L29;
            case -1427366653: goto L25;
            case -1301710629: goto L21;
            case -540898700: goto L17;
            case 70125656: goto L13;
            case 1506669642: goto L9;
            default: goto L32;
        };
    L32:
        byte r105 = -1;
    L34:
        if (r105 == 0) goto L46;
        if (r105 == 1) goto L45;
        if (r105 == 2) goto L44;
        if (r105 == 3) goto L43;
        if (r105 == 4) goto L42;
        if (r105 == 5) goto L41;
        String r106 = null;
    L48:
        if (TextUtils.isEmpty(r106) == false) goto L50;
        String r107 = "目录名为空";
        PolarisFileWrapper r108 = null;
    L55:
        if (TextUtils.isEmpty(r107) == true) goto L58;
        a9a.a.h(r107, r210);
        return true;
    L58:
        int r109 = r100.optInt("deleteStrategy", 0);
        if (r109 == 0) goto L83;
        if (r109 == 1) goto L63;
        a9a.a.h("数据清理策略不合法", r210);
        return true;
    L63:
        long r110 = r100.optLong("expiration_time", -1);
        if (r110 >= 0) goto L67;
        a9a.a.h("数据清理过期时间为空", r210);
    L81:
        boolean r111 = true;
    L86:
        if (r111 == true) goto L88;
        a9a.a.h("数据删除失败(部分文件执行delete操作失败)", r210);
    L89:
        return true;
    L88:
        i9a.b r112 = new i9a.b(r210.f570967c, null);
        r112.f488823d = 2;
        g9a.a.c(r112);
        goto L89
    L67:
        if (r108.isDirectory() == false) goto L79;
        File[] r113 = r108.listFiles();
        int r114 = r113.length;
        int r115 = 0;
        r111 = true;
    L69:
        if (r115 >= r114) goto L86;
        if (r113[r115].lastModified() >= (r110 * 1000)) goto L77;
        if (r111 == true) goto L74;
    L76:
        r111 = false;
        goto L77
    L74:
        if (r108.delete() == false) goto L76;
        r111 = true;
    L77:
        r115 = r115 + 1;
        goto L69
    L79:
        if (r108.lastModified() >= (r110 * 1000)) goto L81;
        r111 = r108.delete();
        goto L86
    L83:
        if (r108.isDirectory() == false) goto L85;
        r111 = com.monitor.cloudmessage.utils.a.g(r108.getAbsolutePath());
        goto L86
    L85:
        r111 = r108.delete();
        goto L86
    L50:
        r108 = new PolarisFileWrapper(r106);
        if (r108.exists() == true) goto L53;
        r107 = "文件/目录不存在";
        goto L55
    L53:
        r107 = null;
        goto L55
    L41:
        r106 = new PolarisFileWrapper(r104.getFilesDir(), r102).getAbsolutePath();
        goto L48
    L42:
        r106 = new PolarisFileWrapper(r104.getExternalFilesDir(null).getParentFile(), r102).getAbsolutePath();
        goto L48
    L43:
        r106 = new PolarisFileWrapper(r104.getCacheDir(), r102).getAbsolutePath();
        goto L48
    L44:
        r106 = new PolarisFileWrapper(r104.getExternalCacheDir(), r102).getAbsolutePath();
        goto L48
    L45:
        r106 = new PolarisFileWrapper(r104.getExternalFilesDir(null), r102).getAbsolutePath();
        goto L48
    L46:
        r106 = new PolarisFileWrapper(r104.getFilesDir().getParentFile(), r102).getAbsolutePath();
        goto L48
    L9:
        if (r101.equals("data_package_file") == false) goto L32;
        r105 = 5;
        goto L34
    L13:
        if (r101.equals("sd_package") == false) goto L32;
        r105 = 4;
        goto L34
    L17:
        if (r101.equals("data_package_cache") == false) goto L32;
        r105 = 3;
        goto L34
    L21:
        if (r101.equals("sd_package_cache") == false) goto L32;
        r105 = 2;
        goto L34
    L25:
        if (r101.equals("sd_package_file") == false) goto L32;
        r105 = 1;
        goto L34
    L29:
        if (r101.equals("data_package") == false) goto L32;
        r105 = 0;
        goto L34
    }
}
