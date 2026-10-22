package com.obric.structure.omvvm.core.config;

import com.obric.structure.omvvm.core.monitor.QMonitorEntity;
import kotlin.Metadata;

/* JADX INFO: compiled from: QMonitorConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/obric/structure/omvvm/core/config/QMonitorConfig;", "", "errorInterval", "", "monitorInterval", "monitorReporter", "", "params", "Lcom/obric/structure/omvvm/core/monitor/QMonitorEntity;", "openMonitor", "", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface QMonitorConfig {

    /* JADX INFO: compiled from: QMonitorConfig.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int errorInterval(QMonitorConfig r0) {
            return 5000;
        }

        public static int monitorInterval(QMonitorConfig r0) {
            return 200;
        }
    }

    int errorInterval();

    int monitorInterval();

    void monitorReporter(QMonitorEntity r1);

    boolean openMonitor();
}
