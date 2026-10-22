package b9a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class r extends a9a.a implements h9a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y8a.d f18369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PolarisFileWrapper f18370c;

    @Override // a9a.a
    public final String f() {
        return "custom";
    }

    @Override // h9a.a
    public final List<String> a() {
        ArrayList r100 = new ArrayList(1);
        PolarisFileWrapper r101 = this.f18370c;
        if (r101 == null) goto L5;
        r100.add(r101.getAbsolutePath());
    L5:
        return r100;
    }

    public r() {
        this.f18370c = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11, types: [com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper, java.io.FileWriter, java.io.Writer] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.FileWriter] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.FileWriter] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.io.BufferedWriter] */
    @Override // a9a.a
    public final boolean g(z8a.a r110) throws Exception {
        String r100 = r110.f570965a;
        if (this.f18369b != null) goto L6;
        return false;
    L6:
        JSONObject r101 = new JSONObject(r100);
        if (a9a.a.e(r101, r110) == false) goto L9;
        return true;
    L9:
        JSONObject r102 = r101.optJSONObject(ThumbGlideUrl.SOURCE_TEMPLATE);
        if (r102 != null) goto L13;
        a9a.a.h("template字段异常", r110);
        return true;
    L13:
        r101.put("cloud_command_id", r110.f570967c);
        this.f18369b.a(r102);
        z8a.b r103 = this.f18369b.getConsumerResult();
        if (r103.f570969a == true) goto L16;
        String r104 = r103.f570970b;
        i9a.b r105 = new i9a.b(r110.f570967c, r103.f570971c);
        r105.f488823d = 3;
        r105.f488824e = r104;
        g9a.a.c(r105);
    L72:
        return true;
    L16:
        if (TextUtils.isEmpty("") == false) goto L18;
        String r106 = "{\"result\" : \"no one handle it.\"}";
    L19:
        Context r107 = x8a.c.b().getContext();
        PolarisFileWrapper r108 = null;
        ?? r109 = 0;
        r108 = null;
        r108 = null;
        r108 = null;
        r109 = 0;
        if (TextUtils.isEmpty(r106) == true) goto L53;
        ?? r111 = com.monitor.cloudmessage.utils.a.e(r107).getAbsolutePath();
        ?? r112 = new StringBuilder();
        r112.append(r111);
        r112.append(File.separator);
        ?? r113 = "template.txt";
        r112.append("template.txt");
        String r114 = r112.toString();
        PolarisFileWrapper r115 = new PolarisFileWrapper(r111);     // Catch: Throwable -> L40 IOException -> L42
        if (r115.exists() == true) goto L26;
        r115.mkdirs();     // Catch: Throwable -> L40 IOException -> L42
    L26:
        r111 = new PolarisFileWriterWrapper(r114);     // Catch: Throwable -> L40 IOException -> L42
        r113 = new BufferedWriter(r111);     // Catch: Throwable -> L36 IOException -> L38
        r113.write(r106);     // Catch: IOException -> L34 Throwable -> L60
        r113.close();     // Catch: IOException -> L31
        r111.close();     // Catch: IOException -> L31
    L33:
        r108 = new PolarisFileWrapper(r114);
    L73:
    L31:
        e = move-exception;
        e.printStackTrace();
    L34:
        e = e;
    L44:
        e.printStackTrace();     // Catch: Throwable -> L60
        if (r113 != 0) goto L76;
    L49:
        if (r111 == 0) goto L73;
        r111.close();     // Catch: IOException -> L47
    L47:
        e = move-exception;
        e.printStackTrace();
        goto L73
    L76:
        r113.close();     // Catch: IOException -> L47
        goto L49
    L38:
        e = e;
        r113 = 0;
    L36:
        th = th;
    L62:
        if (r109 != 0) goto L80;
    L66:
        if (r111 == 0) goto L70;
        r111.close();     // Catch: IOException -> L64
    L64:
        e = move-exception;
        e.printStackTrace();
    L70:
        throw th;
    L80:
        r109.close();     // Catch: IOException -> L64
        goto L66
    L60:
        th = th;
        r109 = r113;
    L42:
        e = e;
        r111 = 0;
        r113 = 0;
    L40:
        th = th;
        r111 = 0;
    L53:
        if (r108 != null) goto L56;
        a9a.a.h("template文件生成异常", r110);
        return true;
    L56:
        this.f18370c = r108;
        String r116 = r101.optString("fileContentType", "");
        if (TextUtils.isEmpty(r116) == false) goto L59;
        r116 = r102.optString("fileContentType", "template_file_type");
    L59:
        g9a.a.b(new i9a.a(r116, r110.f570967c, this, r103.f570971c));
        goto L72
    L18:
        r106 = "";
        goto L19
    }
}
