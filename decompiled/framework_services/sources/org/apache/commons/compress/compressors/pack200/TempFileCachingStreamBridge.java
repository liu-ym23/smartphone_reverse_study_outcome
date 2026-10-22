package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;

/* JADX INFO: loaded from: classes3.dex */
class TempFileCachingStreamBridge extends StreamBridge {
    private final File f;

    static /* synthetic */ File access$000(TempFileCachingStreamBridge x0) {
        return x0.f;
    }

    TempFileCachingStreamBridge() throws IOException {
        this.f = File.createTempFile("commons-compress", "packtemp");
        this.f.deleteOnExit();
        ((FilterOutputStream) this).out = Files.newOutputStream(this.f.toPath(), new OpenOption[0]);
    }

    @Override // org.apache.commons.compress.compressors.pack200.StreamBridge
    InputStream getInputView() throws IOException {
        ((FilterOutputStream) this).out.close();
        final InputStream r1 = Files.newInputStream(this.f.toPath(), new OpenOption[0]);
        return new AnonymousClass1(this, r1);
    }
}
