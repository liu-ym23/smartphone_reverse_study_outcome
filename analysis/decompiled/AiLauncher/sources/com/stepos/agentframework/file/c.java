package com.stepos.agentframework.file;

import Y8.t;
import android.content.Context;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.utils.g;
import h8.C4148a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/file/c;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "sourceUri", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "CHAT_IMAGE", "CHAT_FILE", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class c {
    public static final c INSTANCE = new c();
    private static final String TAG = "ImageStorageManager";
    private static final String CHAT_IMAGE = "chat/image";
    private static final String CHAT_FILE = "chat/file";

    public final String a(Context context, Uri sourceUri) throws FileNotFoundException {
        p.i(context, "context");
        p.i(sourceUri, "sourceUri");
        try {
            File file = new File(context.getCacheDir(), CHAT_FILE);
            if (!file.exists() && !file.mkdirs()) {
                C4148a.h(TAG, "创建目录失败: " + file.getAbsolutePath(), false, 4, null);
                return null;
            }
            File file2 = new File(file, g.INSTANCE.e(context, sourceUri));
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(sourceUri);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            if (inputStreamOpenInputStream != null) {
                try {
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i10 = inputStreamOpenInputStream.read(bArr);
                            if (i10 == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i10);
                        }
                        fileOutputStream.flush();
                        t tVar = t.f7040a;
                        l9.b.a(fileOutputStream, null);
                        l9.b.a(inputStreamOpenInputStream, null);
                    } finally {
                    }
                } finally {
                }
            }
            return file2.getAbsolutePath();
        } catch (Exception e10) {
            C4148a.g(TAG, "文件复制失败: " + e10.getMessage(), e10, false, 8, null);
            return null;
        }
    }
}
