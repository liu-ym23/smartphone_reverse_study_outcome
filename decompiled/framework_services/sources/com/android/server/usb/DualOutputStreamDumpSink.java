package com.android.server.usb;

import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.server.utils.EventLogger;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class DualOutputStreamDumpSink implements EventLogger.DumpSink {
    private final DualDumpOutputStream mDumpOutputStream;
    private final long mId;

    DualOutputStreamDumpSink(DualDumpOutputStream dualDumpOutputStream, long id) {
        this.mDumpOutputStream = dualDumpOutputStream;
        this.mId = id;
    }

    @Override // com.android.server.utils.EventLogger.DumpSink
    public void sink(String tag, List<EventLogger.Event> events) {
        this.mDumpOutputStream.write("USB Event Log", this.mId, tag);
        Iterator<EventLogger.Event> r0 = events.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        EventLogger.Event evt = r0.next();
        this.mDumpOutputStream.write("USB Event", this.mId, evt.toString());
        goto L4
    }
}
