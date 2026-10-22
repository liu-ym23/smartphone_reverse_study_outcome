package y9;

import android.text.TextUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class e extends x9.a {
    public e() {
    }

    @Override // x9.a
    public String d() {
        return CloudControlInf.DATA_CLEAR;
    }

    @Override // x9.a
    public boolean e(w9.a r18) {
        JSONObject r10 = new JSONObject(r18.c());
        if (c(r10, r18) == false) goto L5;
        return true;
    L5:
        String r11 = com.monitor.cloudmessage.utils.b.i(r10.optString("rootNode"), r10.optString("relativeDirName"));
        String r12 = null;
        if (TextUtils.isEmpty(r11) == false) goto L8;
        File r13 = null;
        r12 = "目录名为空";
    L12:
        if (TextUtils.isEmpty(r12) == true) goto L15;
        i(r12, r18);
        return true;
    L15:
        int r14 = r10.optInt("deleteStrategy", 0);
        if (r14 == 0) goto L40;
        if (r14 == 1) goto L20;
        i("数据清理策略不合法", r18);
        return true;
    L20:
        long r15 = r10.optLong("expiration_time", -1);
        if (r15 >= 0) goto L24;
        i("数据清理过期时间为空", r18);
    L38:
        boolean r16 = true;
    L43:
        if (r16 == true) goto L45;
        i("数据删除失败(部分文件执行delete操作失败)", r18);
    L46:
        return true;
    L45:
        j(r18);
        goto L46
    L24:
        if (r13.isDirectory() == false) goto L36;
        File[] r17 = r13.listFiles();
        int r19 = r17.length;
        r16 = true;
        int r110 = 0;
    L26:
        if (r110 >= r19) goto L43;
        if (r17[r110].lastModified() >= (r15 * 1000)) goto L34;
        if (r16 == true) goto L31;
    L33:
        r16 = false;
        goto L34
    L31:
        if (r13.delete() == false) goto L33;
        r16 = true;
    L34:
        r110 = r110 + 1;
        goto L26
    L36:
        if (r13.lastModified() >= (r15 * 1000)) goto L38;
        r16 = r13.delete();
        goto L43
    L40:
        if (r13.isDirectory() == false) goto L42;
        r16 = com.monitor.cloudmessage.utils.b.k(r13.getAbsolutePath());
        goto L43
    L42:
        r16 = r13.delete();
        goto L43
    L8:
        r13 = new File(r11);
        if (r13.exists() == true) goto L12;
        r12 = "文件/目录不存在";
        goto L12
    }
}
