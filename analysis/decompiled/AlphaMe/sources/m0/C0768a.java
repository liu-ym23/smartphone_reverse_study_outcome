package m0;

import android.util.Log;
import androidx.room.AbstractC0351g;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: m0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0768a {

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f13522d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final File f13523a;

    /* renamed from: b, reason: collision with root package name */
    public final Lock f13524b;

    /* renamed from: c, reason: collision with root package name */
    public FileChannel f13525c;

    public C0768a(String name, File file) {
        Lock lock;
        Intrinsics.checkNotNullParameter(name, "name");
        this.f13523a = file != null ? new File(file, AbstractC0351g.p(name, ".lck")) : null;
        HashMap map = f13522d;
        synchronized (map) {
            try {
                Object reentrantLock = map.get(name);
                if (reentrantLock == null) {
                    reentrantLock = new ReentrantLock();
                    map.put(name, reentrantLock);
                }
                lock = (Lock) reentrantLock;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f13524b = lock;
    }

    public final void a(boolean z4) throws IOException {
        this.f13524b.lock();
        if (z4) {
            File file = this.f13523a;
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
                this.f13525c = channel;
            } catch (IOException e4) {
                this.f13525c = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e4);
            }
        }
    }

    public final void b() throws IOException {
        try {
            FileChannel fileChannel = this.f13525c;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f13524b.unlock();
    }
}
