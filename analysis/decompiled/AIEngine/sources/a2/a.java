package a2;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f3e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4a;

    /* renamed from: b, reason: collision with root package name */
    public final File f5b;

    /* renamed from: c, reason: collision with root package name */
    public final Lock f6c;

    /* renamed from: d, reason: collision with root package name */
    public FileChannel f7d;

    public a(String str, File file, boolean z) {
        Lock lock;
        this.f4a = z;
        this.f5b = file != null ? new File(file, str.concat(".lck")) : null;
        HashMap map = f3e;
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
        this.f6c = lock;
    }

    public final void a(boolean z) throws IOException {
        this.f6c.lock();
        if (z) {
            File file = this.f5b;
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
                this.f7d = channel;
            } catch (IOException e10) {
                this.f7d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e10);
            }
        }
    }

    public final void b() throws IOException {
        try {
            FileChannel fileChannel = this.f7d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f6c.unlock();
    }
}
