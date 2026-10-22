package ms.bd.c;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f39496a = null;

    static {
        f39496a = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c18247", new byte[]{127, 54, 69, 71, 69, 35, 122, 28}), String.class, "com.obric.aiagent.plugin");
    }

    public static int a(Context r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin");
        int r0 = 3;
        ByteArrayOutputStream r4 = null;
        int r6 = 255;
        StringBuilder r7 = new StringBuilder().append(r16.getFilesDir().getAbsolutePath()).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "538800", new byte[]{107}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L48
        String r8 = f39496a;     // Catch: Throwable -> L48
        String r9 = r7.append(r8).toString();     // Catch: Throwable -> L48
        File r10 = new File(r9);     // Catch: Throwable -> L48
        if (r10.exists() == true) goto L63;
    L8:
        InputStream r17 = ZeusTransformUtils.getResources(r16, "com.obric.aiagent.plugin").getAssets().open(r8);     // Catch: Throwable -> L48
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();     // Catch: Throwable -> L43
        byte[] r12 = new byte[4096];     // Catch: Throwable -> L25
    L12:
        int r13 = r17.read(r12, 0, 4096);     // Catch: Throwable -> L25
        if (r13 == (-1)) goto L15;
        r11.write(r12, 0, r13);     // Catch: Throwable -> L25
        goto L12
    L15:
        FileOutputStream r5 = new FileOutputStream(r9);     // Catch: Throwable -> L25
        r5.write(r11.toByteArray());     // Catch: Throwable -> L25
        r5.close();     // Catch: Throwable -> L25
        if (r11.size() <= 0) goto L51;
        if (new File(r9).exists() == false) goto L21;
        r0 = 0;
        goto L51
    L21:
        r0 = r6;
    L51:
        r17.close();     // Catch: Throwable -> L41
    L67:
        r11.close();     // Catch: Throwable -> L42
        return r0;
    L73:
        return r0;
    L25:
        r4 = r11;
    L69:
        String r1 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "176ed8", new byte[]{33, 54, 122, 22}), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        if (r17 != null) goto L53;
    L31:
        if (r4 == null) goto L34;
        r4.close();     // Catch: Throwable -> L45
    L34:
        return r6;
    L53:
        r17.close();     // Catch: Throwable -> L44
    L35:
        th = move-exception;
        if (r17 != null) goto L49;
    L38:
        if (r4 == null) goto L74;
        r4.close();     // Catch: Throwable -> L47
        throw th;
    L75:
        throw th;
    L74:
        throw th;
    L49:
        r17.close();     // Catch: Throwable -> L46
        goto L38
    L63:
        r10.delete();     // Catch: Throwable -> L7
        r6 = 2;
    L7:
        r6 = 2;
    L26:
        r17 = null;
        goto L69
    }
}
