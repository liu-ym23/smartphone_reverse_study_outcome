package b1;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017¨\u0006\u001a"}, d2 = {"Lb1/b;", "", "", ContentDisposition.Parameters.FileName, "", "useFileLock", "<init>", "(Ljava/lang/String;Z)V", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "onLocked", "Lkotlin/Function1;", "", "", "onLockError", Const.INTENT_KEY_PKGNAME, "(Lp9/a;Lp9/l;)Ljava/lang/Object;", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/concurrent/ReentrantLock;", Const.INTENT_KEY_APIKEY, "Ljava/util/concurrent/locks/ReentrantLock;", "threadLock", "Lb1/c;", "Lb1/c;", "fileLock", "c", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: b1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1443b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final Map<String, ReentrantLock> f15241d = new LinkedHashMap();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ReentrantLock threadLock;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C1444c fileLock;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0007j\u0002`\b0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lb1/b$a;", "", "Landroidx/room/concurrent/SynchronizedObject;", "<init>", "()V", "", "key", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/concurrent/ReentrantLock;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/util/concurrent/locks/ReentrantLock;", "Lb1/c;", "c", "(Ljava/lang/String;)Lb1/c;", "", "threadLocksMap", "Ljava/util/Map;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: b1.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final C1444c c(String key) {
            return new C1444c(key);
        }

        public final ReentrantLock d(String key) {
            ReentrantLock reentrantLock;
            synchronized (this) {
                try {
                    Map map = C1443b.f15241d;
                    Object reentrantLock2 = map.get(key);
                    if (reentrantLock2 == null) {
                        reentrantLock2 = new ReentrantLock();
                        map.put(key, reentrantLock2);
                    }
                    reentrantLock = (ReentrantLock) reentrantLock2;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return reentrantLock;
        }

        public Companion() {
        }
    }

    public C1443b(String filename, boolean z10) {
        p.i(filename, "filename");
        Companion companion = INSTANCE;
        this.threadLock = companion.d(filename);
        this.fileLock = z10 ? companion.c(filename) : null;
    }

    public final <T> T b(InterfaceC5063a<? extends T> onLocked, InterfaceC5074l onLockError) {
        p.i(onLocked, "onLocked");
        p.i(onLockError, "onLockError");
        this.threadLock.lock();
        boolean z10 = false;
        try {
            C1444c c1444c = this.fileLock;
            if (c1444c != null) {
                c1444c.a();
            }
            z10 = true;
            try {
                T tInvoke = onLocked.invoke();
                this.threadLock.unlock();
                return tInvoke;
            } finally {
                C1444c c1444c2 = this.fileLock;
                if (c1444c2 != null) {
                    c1444c2.b();
                }
            }
        } catch (Throwable th) {
            try {
                if (z10) {
                    throw th;
                }
                onLockError.invoke(th);
                throw new KotlinNothingValueException();
            } catch (Throwable th2) {
                this.threadLock.unlock();
                throw th2;
            }
        }
    }
}
