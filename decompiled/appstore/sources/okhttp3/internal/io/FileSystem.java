package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes4.dex */
public interface FileSystem {
    public static final FileSystem SYSTEM = null;

    static {
        SYSTEM = new AnonymousClass1();
    }

    Sink appendingSink(File r10) throws FileNotFoundException;

    void delete(File r10) throws IOException;

    void deleteContents(File r10) throws IOException;

    boolean exists(File r10);

    void rename(File r10, File r11) throws IOException;

    Sink sink(File r10) throws FileNotFoundException;

    long size(File r10);

    Source source(File r10) throws FileNotFoundException;
}
