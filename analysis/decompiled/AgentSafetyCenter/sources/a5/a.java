package a5;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f220e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f221a;

    /* renamed from: b, reason: collision with root package name */
    public final File f222b;

    /* renamed from: c, reason: collision with root package name */
    public final Lock f223c;

    /* renamed from: d, reason: collision with root package name */
    public FileChannel f224d;

    public a(String str, File file, boolean z10) {
        Lock lock;
        this.f221a = z10;
        this.f222b = file != null ? new File(file, str.concat(".lck")) : null;
        HashMap map = f220e;
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
        this.f223c = lock;
    }

    public final void a(boolean z10) throws IOException {
        this.f223c.lock();
        if (z10) {
            File file = this.f222b;
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
                this.f224d = channel;
            } catch (IOException e10) {
                this.f224d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e10);
            }
        }
    }

    public final void b() throws IOException {
        try {
            FileChannel fileChannel = this.f224d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f223c.unlock();
    }
}
