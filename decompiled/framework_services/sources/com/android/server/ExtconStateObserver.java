package com.android.server;

import android.os.FileUtils;
import android.os.UEventObserver;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class ExtconStateObserver<S> extends ExtconUEventObserver {
    private static final boolean LOG = false;
    private static final String TAG = "ExtconStateObserver";

    public abstract S parseState(ExtconUEventObserver.ExtconInfo r1, String r2);

    public abstract void updateState(ExtconUEventObserver.ExtconInfo r1, String r2, S r3);

    public ExtconStateObserver() {
    }

    public S parseStateFromFile(ExtconUEventObserver.ExtconInfo extconInfo) throws IOException {
        String statePath = extconInfo.getStatePath();
        return parseState(extconInfo, FileUtils.readTextFile(new File(statePath), 0, null).trim());
    }

    @Override // com.android.server.ExtconUEventObserver
    public void onUEvent(ExtconUEventObserver.ExtconInfo extconInfo, UEventObserver.UEvent event) {
        String name = event.get("NAME");
        S state = parseState(extconInfo, event.get("STATE"));
        if (state == null) goto L6;
        updateState(extconInfo, name, state);
        return;
    }
}
