package o3;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f7255e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7256a;

    /* renamed from: b, reason: collision with root package name */
    public final File f7257b;

    /* renamed from: c, reason: collision with root package name */
    public final Lock f7258c;

    /* renamed from: d, reason: collision with root package name */
    public FileChannel f7259d;

    public a(String str, File file, boolean z4) {
        Lock lock;
        this.f7256a = z4;
        this.f7257b = file != null ? new File(file, str.concat(".lck")) : null;
        HashMap map = f7255e;
        synchronized (map) {
            try {
                Object reentrantLock = map.get(str);
                if (reentrantLock == null) {
                    reentrantLock = new ReentrantLock();
                    map.put(str, reentrantLock);
                }
                lock = (Lock) reentrantLock;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f7258c = lock;
    }

    public final void a(boolean z4) throws IOException {
        this.f7258c.lock();
        if (z4) {
            File file = this.f7257b;
            try {
                if (file == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(file).getChannel();
                channel.lock();
                this.f7259d = channel;
            } catch (IOException e10) {
                this.f7259d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e10);
            }
        }
    }

    public final void b() throws IOException {
        try {
            FileChannel fileChannel = this.f7259d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f7258c.unlock();
    }
}
