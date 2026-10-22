package com.zyql.ai.selector.compress;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public abstract class InputStreamAdapter implements InputStreamProvider {
    private InputStream inputStream;

    @Override // com.zyql.ai.selector.compress.InputStreamProvider
    public void close() {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            } finally {
                this.inputStream = null;
            }
        }
    }

    @Override // com.zyql.ai.selector.compress.InputStreamProvider
    public InputStream open() throws IOException {
        close();
        InputStream inputStreamOpenInternal = openInternal();
        this.inputStream = inputStreamOpenInternal;
        return inputStreamOpenInternal;
    }

    public abstract InputStream openInternal() throws IOException;
}
