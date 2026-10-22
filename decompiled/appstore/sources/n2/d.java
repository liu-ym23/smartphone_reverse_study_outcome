package n2;

import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MappedByteBuffer f22371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f22372b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f22373a = null;

        static {
            f22373a = new d();
        }

        public static /* synthetic */ d a() {
            return f22373a;
        }
    }

    public d() {
        this.f22372b = 0;
    }

    public static d a() {
        return a.a();
    }

    public long b() {
        if (this.f22371a == null) goto L20;
    L14:
        MappedByteBuffer r10 = this.f22371a;
        if (r10 == null) goto L18;
        long r11 = r10.getLong(0) + 1;
        this.f22372b = r11;
        this.f22371a.putLong(0, r11);
        return this.f22372b;
    L18:
        long r12 = this.f22372b;
        this.f22372b = 1 + r12;
        return r12;
    L20:
        File r13 = new File(b.f(), d3.a.m().replace(LibrarianImpl.Constants.DOT, "_").replace(":", "-") + "_seq_num.txt");     // Catch: Throwable -> L7
        boolean r14 = r13.exists();     // Catch: Throwable -> L7
        if (r14 == true) goto L9;
        r13.createNewFile();     // Catch: Throwable -> L7
    L9:
        MappedByteBuffer r15 = new RandomAccessFile(r13, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 8);     // Catch: Throwable -> L7
        this.f22371a = r15;     // Catch: Throwable -> L7
        if (r14 == true) goto L14;
        r15.putLong(0, 0);     // Catch: Throwable -> L7
        return 0;
    L7:
        th = move-exception;
        s3.a.c(n2.a.f22354a, "prepare seq_number fail.", th);
        goto L14
    }
}
