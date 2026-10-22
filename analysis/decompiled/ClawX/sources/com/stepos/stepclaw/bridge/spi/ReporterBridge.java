package com.stepos.stepclaw.bridge.spi;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/stepclaw/bridge/spi/ReporterBridge;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "reporter", "Lcom/stepos/stepclaw/bridge/spi/Reporter;", "getReporter", "()Lcom/stepos/stepclaw/bridge/spi/Reporter;", "setReporter", "(Lcom/stepos/stepclaw/bridge/spi/Reporter;)V", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ReporterBridge {
    public static final ReporterBridge INSTANCE = new ReporterBridge();
    private static volatile Reporter reporter;

    private ReporterBridge() {
    }

    public final Reporter getReporter() {
        return reporter;
    }

    public final void setReporter(Reporter reporter2) {
        reporter = reporter2;
    }
}
