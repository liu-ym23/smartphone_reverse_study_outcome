package com.obric.structure.omvvm.core.extension;

import android.os.Handler;
import androidx.core.app.NotificationCompat;
import com.obric.structure.omvvm.core.config.QMonitorConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016¨\u0006\u0014"}, d2 = {"Lcom/obric/structure/omvvm/core/extension/QConfig;", "", "channel", "", "enableInsight", "", "fixAsyncQuery", "fixModuleViewAddError", "fixQContextLifecycleLeak", "fixQLiveDataMemLeak", "frameMinLimit", "", "handler", "Landroid/os/Handler;", "monitorCig", "Lcom/obric/structure/omvvm/core/config/QMonitorConfig;", "openVsyncWorker", "uploadLog", "", NotificationCompat.CATEGORY_MESSAGE, "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface QConfig {

    /* JADX INFO: compiled from: QConfig.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean enableInsight(QConfig r0) {
            return false;
        }

        public static boolean fixAsyncQuery(QConfig r0) {
            return false;
        }

        public static boolean fixModuleViewAddError(QConfig r0) {
            return false;
        }

        public static boolean fixQContextLifecycleLeak(QConfig r0) {
            return false;
        }

        public static boolean fixQLiveDataMemLeak(QConfig r0) {
            return false;
        }

        public static int frameMinLimit(QConfig r0) {
            return -1;
        }

        public static boolean openVsyncWorker(QConfig r0) {
            return false;
        }

        public static void uploadLog(QConfig r0, String r1) {
            Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_MESSAGE);
        }

        public static QMonitorConfig monitorCig(QConfig r0) {
            return new AnonymousClass1();
        }
    }

    String channel();

    boolean enableInsight();

    boolean fixAsyncQuery();

    boolean fixModuleViewAddError();

    boolean fixQContextLifecycleLeak();

    boolean fixQLiveDataMemLeak();

    int frameMinLimit();

    Handler handler();

    QMonitorConfig monitorCig();

    boolean openVsyncWorker();

    void uploadLog(String r1);
}
