package com.stepos.probe;

import android.content.Context;
import android.util.Log;
import d7.r;
import d7.t;
import d7.z;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import n7.l;
import q7.k;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00102\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/probe/ProbeStore;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lc7/r;", "init", "(Landroid/content/Context;)V", "", "baseDirPath", "()Ljava/lang/String;", "module", "line", "append", "(Ljava/lang/String;Ljava/lang/String;)V", "", "moduleDirs", "()Ljava/util/List;", "readModuleToday", "(Ljava/lang/String;)Ljava/util/List;", "TAG", "Ljava/lang/String;", "Ljava/text/SimpleDateFormat;", "dayFmt", "Ljava/text/SimpleDateFormat;", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "io", "Ljava/util/concurrent/ExecutorService;", "Ljava/io/File;", "baseDir", "Ljava/io/File;", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProbeStore {
    private static final String TAG = "clawbench";
    private static volatile File baseDir;
    public static final ProbeStore INSTANCE = new ProbeStore();
    private static final SimpleDateFormat dayFmt = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    private static final ExecutorService io = Executors.newSingleThreadExecutor(new b(0));

    private ProbeStore() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void append$lambda$0(File file, String str, String str2) throws IOException {
        try {
            File file2 = new File(file, str);
            file2.mkdirs();
            File file3 = new File(file2, dayFmt.format(new Date()) + ".ndjson");
            String str3 = str2 + "\n";
            Charset charset = ga.a.f4005a;
            k.e(str3, "text");
            k.e(charset, "charset");
            FileOutputStream fileOutputStream = new FileOutputStream(file3, true);
            try {
                l.R(fileOutputStream, str3, charset);
                fileOutputStream.close();
            } finally {
            }
        } catch (Exception e10) {
            Log.w(TAG, "ProbeStore append failed [" + str + "]: " + e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread io$lambda$0(Runnable runnable) {
        return new Thread(runnable, "clawbench-probe-store");
    }

    public final void append(String module, String line) {
        k.e(module, "module");
        k.e(line, "line");
        File file = baseDir;
        if (file == null) {
            return;
        }
        io.execute(new a(file, module, line, 0));
    }

    public final String baseDirPath() {
        String absolutePath;
        File file = baseDir;
        return (file == null || (absolutePath = file.getAbsolutePath()) == null) ? "<not initialized>" : absolutePath;
    }

    public final void init(Context context) {
        k.e(context, "context");
        File file = new File(context.getFilesDir(), "clawbench/probe");
        baseDir = file;
        Log.i(TAG, "ProbeStore init: " + file.getAbsolutePath());
    }

    public final List<String> moduleDirs() {
        File[] fileArrListFiles;
        z zVar = z.f2978f;
        File file = baseDir;
        if (file == null || (fileArrListFiles = file.listFiles()) == null) {
            return zVar;
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                arrayList.add(file2);
            }
        }
        ArrayList arrayList2 = new ArrayList(t.A0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((File) it.next()).getName());
        }
        return r.i1(arrayList2);
    }

    public final List<String> readModuleToday(String module) {
        z zVar = z.f2978f;
        k.e(module, "module");
        File file = baseDir;
        if (file != null) {
            File file2 = new File(new File(file, module), a1.a.i(dayFmt.format(new Date()), ".ndjson"));
            try {
                if (file2.exists()) {
                    return l.M(file2);
                }
            } catch (Exception e10) {
                Log.w(TAG, "ProbeStore read failed [" + module + "]: " + e10.getMessage());
                return zVar;
            }
        }
        return zVar;
    }
}
