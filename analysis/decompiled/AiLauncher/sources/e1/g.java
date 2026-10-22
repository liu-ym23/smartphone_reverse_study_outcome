package e1;

import Y8.t;
import android.content.Context;
import android.util.Log;
import androidx.room.C1407c;
import androidx.room.InterfaceC1408d;
import com.autonavi.aps.amapapi.config.Const;
import f1.C4031a;
import f1.C4033c;
import j1.InterfaceC4756c;
import j1.InterfaceC4757d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m1.C4892a;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u0015J\u001f\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010 R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010%R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010*R\u001a\u0010\u000e\u001a\u00020\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010/R\u0016\u00102\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00109\u001a\u0002068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010;\u001a\u0002068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u00108¨\u0006<"}, d2 = {"Le1/g;", "Lj1/d;", "Landroidx/room/d;", "Landroid/content/Context;", "context", "", "copyFromAssetPath", "Ljava/io/File;", "copyFromFile", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "copyFromInputStream", "", "databaseVersion", "delegate", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;ILj1/d;)V", "", x5.d.EXTRA_ENABLED, "LY8/t;", "setWriteAheadLoggingEnabled", "(Z)V", "close", "()V", "Landroidx/room/c;", "databaseConfiguration", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/room/c;)V", "writable", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "destinationFile", Const.INTENT_KEY_PKGNAME, "(Ljava/io/File;Z)V", "databaseFile", "e", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", "Ljava/lang/String;", "c", "Ljava/io/File;", Const.INTENT_KEY_UMID, "Ljava/util/concurrent/Callable;", "I", "f", "Lj1/d;", "getDelegate", "()Lj1/d;", "Landroidx/room/c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Z", "verified", "getDatabaseName", "()Ljava/lang/String;", "databaseName", "Lj1/c;", "getWritableDatabase", "()Lj1/c;", "writableDatabase", "getReadableDatabase", "readableDatabase", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class g implements InterfaceC4757d, InterfaceC1408d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String copyFromAssetPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final File copyFromFile;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Callable<InputStream> copyFromInputStream;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int databaseVersion;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4757d delegate;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public C1407c databaseConfiguration;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public boolean verified;

    public g(Context context, String str, File file, Callable<InputStream> callable, int i10, InterfaceC4757d delegate) {
        p.i(context, "context");
        p.i(delegate, "delegate");
        this.context = context;
        this.copyFromAssetPath = str;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.databaseVersion = i10;
        this.delegate = delegate;
    }

    public final void b(File destinationFile, boolean writable) throws IOException {
        ReadableByteChannel readableByteChannelNewChannel;
        if (this.copyFromAssetPath != null) {
            readableByteChannelNewChannel = Channels.newChannel(this.context.getAssets().open(this.copyFromAssetPath));
            p.h(readableByteChannelNewChannel, "newChannel(...)");
        } else if (this.copyFromFile != null) {
            readableByteChannelNewChannel = new FileInputStream(this.copyFromFile).getChannel();
            p.h(readableByteChannelNewChannel, "getChannel(...)");
        } else {
            Callable<InputStream> callable = this.copyFromInputStream;
            if (callable == null) {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
            try {
                readableByteChannelNewChannel = Channels.newChannel(callable.call());
                p.h(readableByteChannelNewChannel, "newChannel(...)");
            } catch (Exception e10) {
                throw new IOException("inputStreamCallable exception on call", e10);
            }
        }
        File fileCreateTempFile = File.createTempFile("room-copy-helper", ".tmp", this.context.getCacheDir());
        fileCreateTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(fileCreateTempFile).getChannel();
        p.f(channel);
        C4033c.a(readableByteChannelNewChannel, channel);
        File parentFile = destinationFile.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + destinationFile.getAbsolutePath());
        }
        p.f(fileCreateTempFile);
        e(fileCreateTempFile, writable);
        if (fileCreateTempFile.renameTo(destinationFile)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + fileCreateTempFile.getAbsolutePath() + ") to destination (" + destinationFile.getAbsolutePath() + ").");
    }

    @Override // j1.InterfaceC4757d, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        getDelegate().close();
        this.verified = false;
    }

    public final void e(File databaseFile, boolean writable) {
        C1407c c1407c = this.databaseConfiguration;
        if (c1407c == null) {
            p.A("databaseConfiguration");
            c1407c = null;
        }
        c1407c.getClass();
    }

    public final void g(C1407c databaseConfiguration) {
        p.i(databaseConfiguration, "databaseConfiguration");
        this.databaseConfiguration = databaseConfiguration;
    }

    @Override // j1.InterfaceC4757d
    public String getDatabaseName() {
        return getDelegate().getDatabaseName();
    }

    @Override // androidx.room.InterfaceC1408d
    public InterfaceC4757d getDelegate() {
        return this.delegate;
    }

    @Override // j1.InterfaceC4757d
    public InterfaceC4756c getReadableDatabase() throws IOException {
        if (!this.verified) {
            i(false);
            this.verified = true;
        }
        return getDelegate().getReadableDatabase();
    }

    @Override // j1.InterfaceC4757d
    public InterfaceC4756c getWritableDatabase() throws IOException {
        if (!this.verified) {
            i(true);
            this.verified = true;
        }
        return getDelegate().getWritableDatabase();
    }

    public final void i(boolean writable) throws IOException {
        String databaseName = getDatabaseName();
        if (databaseName == null) {
            throw new IllegalStateException("Required value was null.");
        }
        File databasePath = this.context.getDatabasePath(databaseName);
        C1407c c1407c = this.databaseConfiguration;
        C1407c c1407c2 = null;
        if (c1407c == null) {
            p.A("databaseConfiguration");
            c1407c = null;
        }
        C4892a c4892a = new C4892a(databaseName, this.context.getFilesDir(), c1407c.multiInstanceInvalidation);
        try {
            C4892a.c(c4892a, false, 1, null);
            if (!databasePath.exists()) {
                try {
                    p.f(databasePath);
                    b(databasePath, writable);
                    c4892a.d();
                    return;
                } catch (IOException e10) {
                    throw new RuntimeException("Unable to copy database file.", e10);
                }
            }
            try {
                p.f(databasePath);
                int iF = C4031a.f(databasePath);
                if (iF == this.databaseVersion) {
                    c4892a.d();
                    return;
                }
                C1407c c1407c3 = this.databaseConfiguration;
                if (c1407c3 == null) {
                    p.A("databaseConfiguration");
                    c1407c3 = null;
                }
                if (c1407c3.migrationContainer.d(iF, this.databaseVersion) != null) {
                    c4892a.d();
                    return;
                }
                C1407c c1407c4 = this.databaseConfiguration;
                if (c1407c4 == null) {
                    p.A("databaseConfiguration");
                } else {
                    c1407c2 = c1407c4;
                }
                if (c1407c2.f(iF, this.databaseVersion)) {
                    c4892a.d();
                    return;
                }
                if (this.context.deleteDatabase(databaseName)) {
                    try {
                        b(databasePath, writable);
                        t tVar = t.f7040a;
                    } catch (IOException e11) {
                        Log.w("ROOM", "Unable to copy database file.", e11);
                    }
                } else {
                    Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                c4892a.d();
                return;
            } catch (IOException e12) {
                Log.w("ROOM", "Unable to read database version.", e12);
                c4892a.d();
                return;
            }
        } catch (Throwable th) {
            c4892a.d();
            throw th;
        }
        c4892a.d();
        throw th;
    }

    @Override // j1.InterfaceC4757d
    public void setWriteAheadLoggingEnabled(boolean enabled) {
        getDelegate().setWriteAheadLoggingEnabled(enabled);
    }
}
