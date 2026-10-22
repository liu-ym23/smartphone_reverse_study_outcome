package W0;

import android.content.SharedPreferences;
import android.text.TextUtils;
import g1.AbstractC1451a;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f1473a;
    public volatile boolean b;
    public File c;
    public ConcurrentHashMap d;
    public long e;
    public volatile boolean f;
    public ArrayList g;

    public final b a(File file) {
        b();
        String name = file.getName();
        ConcurrentHashMap concurrentHashMap = this.d;
        if (concurrentHashMap.containsKey(name)) {
            return (b) concurrentHashMap.get(name);
        }
        b bVar = null;
        if (this.f1473a.contains(name)) {
            String string = this.f1473a.getString(name, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    String[] strArrSplit = string.split("_");
                    bVar = new b(Integer.parseInt(strArrSplit[0]), Long.parseLong(strArrSplit[1]));
                } catch (Exception unused) {
                }
            }
            if (bVar != null) {
                concurrentHashMap.put(name, bVar);
            }
        }
        return bVar;
    }

    public final synchronized void b() {
        try {
            if (this.b) {
                return;
            }
            File file = new File(S0.b.x0(), "log");
            if (!file.exists()) {
                file.mkdirs();
            }
            this.c = file;
            this.f1473a = AbstractC1451a.b.getSharedPreferences("log_report_message", 0);
            this.b = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void c(File file, int i, long j5) {
        b bVar;
        ConcurrentHashMap concurrentHashMap = this.d;
        try {
            b();
            SharedPreferences.Editor editorEdit = this.f1473a.edit();
            String name = file.getName();
            if (concurrentHashMap.containsKey(name)) {
                bVar = (b) concurrentHashMap.get(name);
            } else {
                b bVar2 = new b(i, j5);
                concurrentHashMap.put(name, bVar2);
                bVar = bVar2;
            }
            bVar.f1472a = i;
            bVar.b = j5;
            editorEdit.putString(name, bVar.f1472a + "_" + bVar.b);
            editorEdit.commit();
        } catch (Throwable th) {
            H4.o.g(S0.a.f1163a, "updateRetryMessage", th);
        }
    }

    public final void d(String str) {
        ArrayList arrayList = this.g;
        if (arrayList.size() > 5000) {
            this.e++;
        } else {
            arrayList.add(str);
        }
    }

    public final synchronized boolean e(long j5, String str, byte[] bArr, int i) {
        b();
        if (this.c == null) {
            return false;
        }
        String str2 = String.format("%d%s%s%s%s", Long.valueOf(System.currentTimeMillis()), "_", UUID.randomUUID().toString(), ".", str);
        File file = new File(this.c, str2);
        FileChannel channel = null;
        try {
            c(file, i, j5);
            channel = new FileOutputStream(file).getChannel();
            channel.write(ByteBuffer.wrap(bArr));
            if (!this.g.contains(str2)) {
                d(str2);
            }
            if (AbstractC1451a.f4467a) {
                H4.o.f(S0.a.f1163a, "saveFile:" + file.getName());
            }
            return true;
        } catch (Throwable th) {
            try {
                H4.o.g(S0.a.f1163a, "saveFile", th);
                return false;
            } finally {
                S0.b.F(channel);
            }
        }
    }
}
