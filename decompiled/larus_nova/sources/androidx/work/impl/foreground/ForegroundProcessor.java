package androidx.work.impl.foreground;

import androidx.work.ForegroundInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface ForegroundProcessor {
    void startForeground(String r100, ForegroundInfo r101);

    void stopForeground(String r100);
}
