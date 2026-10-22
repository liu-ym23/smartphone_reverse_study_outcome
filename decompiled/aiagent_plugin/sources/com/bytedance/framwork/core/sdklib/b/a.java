package com.bytedance.framwork.core.sdklib.b;

import android.content.Context;
import com.bytedance.framwork.core.sdklib.a.k;
import com.bytedance.framwork.core.sdkmonitor.h;
import com.ss.android.common.util.ToolUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* JADX INFO: compiled from: DebugHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MappedByteBuffer f8651a;

    public static synchronized void a(JSONObject r14) {
        monitor-enter(a.class);
        monitor-enter(h.class);     // Catch: Throwable -> L22
        String r2 = ToolUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(k.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L17
        if (f8651a != null) goto L14;
        File r3 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(k.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getFilesDir(), "sdk_" + r2 + "_seq_num.txt");     // Catch: Throwable -> L17
        boolean r5 = r3.exists();     // Catch: Throwable -> L17
        if (r5 == true) goto L11;
        r3.createNewFile();     // Catch: Throwable -> L17
    L11:
        MappedByteBuffer r4 = new RandomAccessFile(r3, "rws").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 8);     // Catch: Throwable -> L17
        f8651a = r4;     // Catch: Throwable -> L17
        if (r5 == true) goto L14;
        r4.putLong(0, 0);     // Catch: Throwable -> L17
    L14:
        long r6 = f8651a.getLong(0);     // Catch: Throwable -> L17
        r14.put("seq_no", r6);     // Catch: Throwable -> L17
        r14.put("process_name", r2);     // Catch: Throwable -> L17
        f8651a.putLong(0, r6 + 1);     // Catch: Throwable -> L17
        monitor-exit(h.class);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L20:
        monitor-exit(a.class);
    }
}
