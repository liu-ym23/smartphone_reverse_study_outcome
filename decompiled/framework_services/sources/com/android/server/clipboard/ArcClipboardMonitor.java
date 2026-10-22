package com.android.server.clipboard;

import android.content.ClipData;
import com.android.server.LocalServices;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class ArcClipboardMonitor implements Consumer<ClipData> {
    private static final String TAG = "ArcClipboardMonitor";
    private BiConsumer<ClipData, Integer> mAndroidClipboardSetter;
    private ArcClipboardBridge mBridge;

    public interface ArcClipboardBridge {
        void onPrimaryClipChanged(ClipData r1);

        void setHandler(BiConsumer<ClipData, Integer> r1);
    }

    @Override // java.util.function.Consumer
    public /* bridge */ /* synthetic */ void accept(ClipData r1) {
        accept2(r1);
    }

    ArcClipboardMonitor(BiConsumer<ClipData, Integer> setAndroidClipboard) {
        this.mAndroidClipboardSetter = setAndroidClipboard;
        LocalServices.addService(ArcClipboardMonitor.class, this);
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(ClipData clip) {
        if (this.mBridge == null) goto L6;
        this.mBridge.onPrimaryClipChanged(clip);
        return;
    }

    public void setClipboardBridge(ArcClipboardBridge bridge) {
        this.mBridge = bridge;
        this.mBridge.setHandler(this.mAndroidClipboardSetter);
    }
}
