package com.bytedance.android.livesdk.chatroom.record;

import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.nb;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public final class a0 extends PthreadAsyncTask<String, Void, Object> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f108045h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f108046i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f108047j;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [android.net.Uri, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v35, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] r100) {
        String[] r101 = (String[]) r100;
        if (r101 == null) goto L157;
        if (r101.length < 1) goto L157;
        if (TextUtils.isEmpty(r101[0]) == true) goto L157;
        if (tb1.c.f545229a == false) goto L12;
        String r102 = "douyin";
    L13:
        ?? r103 = BdMediaFileSystem.createVideoUri(s1.getContext(), r102 + "_record_" + System.currentTimeMillis() + ".mp4", MimeType.MP4, Environment.DIRECTORY_DCIM);
        ?? r104 = 0;
        PolarisFileInputStreamWrapper r105 = null;
        PolarisFileInputStreamWrapper r106 = null;
        PolarisFileInputStreamWrapper r107 = null;
        ?? r108 = 0;
        ?? r109 = 0;
        ?? r110 = 0;
        ?? r111 = 0;
        ?? r112 = 0;
        ?? r113 = ContentResolverWrapper.openOutputStream(s1.getContext().getContentResolver(), r103);     // Catch: Throwable -> L46 NullPointerException -> L48 IOException -> L65 FileNotFoundException -> L82
        PolarisFileInputStreamWrapper r114 = new PolarisFileInputStreamWrapper(r101[0]);     // Catch: Throwable -> L41 NullPointerException -> L122 IOException -> L123 FileNotFoundException -> L124
    L148:
        byte[] r115 = new byte[1048576];     // Catch: Throwable -> L36 NullPointerException -> L38 IOException -> L39 FileNotFoundException -> L40
    L18:
        int r116 = r114.read(r115);     // Catch: Throwable -> L36 NullPointerException -> L38 IOException -> L39 FileNotFoundException -> L40
        if (r116 < 0) goto L22;
        r113.write(r115, 0, r116);     // Catch: Throwable -> L36 NullPointerException -> L38 IOException -> L39 FileNotFoundException -> L40
    L22:
        if (r113 != 0) goto L133;
    L125:
        r114.close();     // Catch: IOException -> L29
    L32:
        if (this.f108047j == true) goto L34;
        return r103;
    L34:
        if (nb.f120818a.getValue().booleanValue() == false) goto L159;
        qc1.b.a(r101[0]);
        return r103;
    L159:
        return r103;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L133:
        r113.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L40:
        r105 = r114;
    L39:
        r106 = r114;
    L38:
        r107 = r114;
    L36:
        th = th;
        r108 = r114;
    L103:
        ?? r117 = r113;
        ?? r118 = r108;
        r112 = r117;
        String[] r119 = r101;
    L104:
        if (r112 != 0) goto L137;
    L109:
        if (r118 == 0) goto L115;
        r118.close();     // Catch: IOException -> L112
    L112:
        e = move-exception;
        e.printStackTrace();
    L115:
        if (this.f108047j == true) goto L117;
        throw th;
    L117:
        if (nb.f120818a.getValue().booleanValue() == false) goto L156;
        qc1.b.a(r119[0]);
        throw th;
    L156:
        throw th;
    L137:
        r112.close();     // Catch: IOException -> L107
    L107:
        e = move-exception;
        e.printStackTrace();
    L41:
        th = th;
    L45:
        PolarisFileInputStreamWrapper r120 = r105;
        r109 = r113;
    L83:
        Boolean r121 = Boolean.FALSE;     // Catch: Throwable -> L101
        ?? r122 = r109;
        if (r109 != 0) goto L131;
    L89:
        if (r120 != null) goto L146;
    L94:
        r104 = r122;
        r101 = r101;
        if (this.f108047j == false) goto L100;
        r104 = r122;
        r101 = r101;
        if (nb.f120818a.getValue().booleanValue() == false) goto L100;
        int r123 = qc1.b.f532434a;
        ?? r124 = r122;
        String r125 = r101[0];
    L99:
        qc1.b.a(r125);
        r104 = r124;
        r101 = r125;
    L100:
        r103 = r121;
        return r103;
    L146:
        r120.close();     // Catch: IOException -> L92
    L92:
        e = move-exception;
        e.printStackTrace();
        goto L94
    L131:
        r109.close();     // Catch: IOException -> L87
        r122 = r109;
    L87:
        e = move-exception;
        e.printStackTrace();
        r122 = e;
    L44:
        PolarisFileInputStreamWrapper r126 = r106;
        r110 = r113;
    L66:
        r121 = Boolean.FALSE;     // Catch: Throwable -> L101
        ?? r127 = r110;
        if (r110 != 0) goto L139;
    L72:
        if (r126 != null) goto L135;
    L77:
        r104 = r127;
        r101 = r101;
        if (this.f108047j == false) goto L100;
        r104 = r127;
        r101 = r101;
        if (nb.f120818a.getValue().booleanValue() == false) goto L100;
        int r128 = qc1.b.f532434a;
        r124 = r127;
        r125 = r101[0];
        goto L99
    L135:
        r126.close();     // Catch: IOException -> L75
    L75:
        e = move-exception;
        e.printStackTrace();
        goto L77
    L139:
        r110.close();     // Catch: IOException -> L70
        r127 = r110;
    L70:
        e = move-exception;
        e.printStackTrace();
        r127 = e;
    L43:
        PolarisFileInputStreamWrapper r129 = r107;
        r111 = r113;
    L49:
        r121 = Boolean.FALSE;     // Catch: Throwable -> L101
        ?? r130 = r111;
        if (r111 != 0) goto L127;
    L55:
        if (r129 != null) goto L141;
    L60:
        r104 = r130;
        r101 = r101;
        if (this.f108047j == false) goto L100;
        r104 = r130;
        r101 = r101;
        if (nb.f120818a.getValue().booleanValue() == false) goto L100;
        int r131 = qc1.b.f532434a;
        r124 = r130;
        r125 = r101[0];
        goto L99
    L141:
        r129.close();     // Catch: IOException -> L58
    L58:
        e = move-exception;
        e.printStackTrace();
        goto L60
    L127:
        r111.close();     // Catch: IOException -> L53
        r130 = r111;
    L53:
        e = move-exception;
        e.printStackTrace();
        r130 = e;
        goto L55
    L101:
        th = move-exception;
        ?? r132 = r104;
        r108 = r103;
        th = th;
        r113 = r132;
    L82:
        r120 = null;
    L65:
        r126 = null;
    L48:
        r129 = null;
    L46:
        th = th;
        r118 = 0;
        r119 = r101;
        goto L104
    L12:
        r102 = "live";
    L157:
        return Boolean.FALSE;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object r100) {
        this.f108045h.obtainMessage(this.f108046i, r100).sendToTarget();
    }

    public a0(WeakHandler r100, int r101) {
        this.f108045h = r100;
        this.f108046i = r101;
        this.f108047j = true;
    }

    public a0(Handler r100, int r101) {
        this.f108045h = r100;
        this.f108046i = r101;
    }
}
