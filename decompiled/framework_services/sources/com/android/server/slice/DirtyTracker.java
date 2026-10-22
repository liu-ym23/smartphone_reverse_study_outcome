package com.android.server.slice;

import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes3.dex */
public interface DirtyTracker {

    public interface Persistable {
        String getFileName();

        void writeTo(XmlSerializer r1) throws IOException;
    }

    void onPersistableDirty(Persistable r1);
}
