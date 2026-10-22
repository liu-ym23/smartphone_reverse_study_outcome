package com.obric.structure.omvvm.core;

import android.os.Handler;
import androidx.core.app.NotificationCompat;
import com.obric.structure.omvvm.core.config.DefaultConfig;
import com.obric.structure.omvvm.core.config.QMonitorConfig;
import com.obric.structure.omvvm.core.extension.QConfig;
import com.obric.structure.omvvm.core.performance.QVsyncFrameCaller;
import com.obric.structure.omvvm.core.util.QExecutor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Q.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u001c\u001a\u00020\u0010H\u0007J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\u0017J\u0012\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\nH\u0007J\u0006\u0010#\u001a\u00020\u0010J\u000e\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00108BX\u0082\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/obric/structure/omvvm/core/Q;", "", "()V", "channel", "", "getChannel$omvvm_core_release", "()Ljava/lang/String;", "setChannel$omvvm_core_release", "(Ljava/lang/String;)V", "cig", "Lcom/obric/structure/omvvm/core/extension/QConfig;", "getCig$omvvm_core_release", "()Lcom/obric/structure/omvvm/core/extension/QConfig;", "setCig$omvvm_core_release", "(Lcom/obric/structure/omvvm/core/extension/QConfig;)V", "fixModuleViewAddError", "", "getFixModuleViewAddError", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "insightEnabled", "getInsightEnabled", "monitorCig", "Lcom/obric/structure/omvvm/core/config/QMonitorConfig;", "getMonitorCig$omvvm_core_release", "()Lcom/obric/structure/omvvm/core/config/QMonitorConfig;", "setMonitorCig$omvvm_core_release", "(Lcom/obric/structure/omvvm/core/config/QMonitorConfig;)V", "fixQLiveDataMemLeak", "getChannel", "getCig", "getMonitorCig", "init", "", "config", "isInsightEnabled", "uploadLog", NotificationCompat.CATEGORY_MESSAGE, "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Q {
    public static final Q INSTANCE = null;
    private static volatile String channel;
    private static QConfig cig;
    private static Boolean fixModuleViewAddError;
    private static Boolean insightEnabled;
    private static QMonitorConfig monitorCig;

    static {
        INSTANCE = new Q();
    }

    private Q() {
    }

    public final void setChannel$omvvm_core_release(String r1) {
        channel = r1;
    }

    public final String getChannel$omvvm_core_release() {
        if (channel != null) goto L11;
        QConfig r1 = getCig$omvvm_core_release();
        if (r1 == null) goto L8;
        String r2 = r1.channel();
        if (r2 == null) goto L8;
    L9:
        channel = r2;
    L8:
        r2 = "";
    L11:
        return channel;
    }

    public final String getChannel() {
        String r0 = getChannel$omvvm_core_release();
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final void setMonitorCig$omvvm_core_release(QMonitorConfig r1) {
        monitorCig = r1;
    }

    public final QMonitorConfig getMonitorCig$omvvm_core_release() {
        if (monitorCig != null) goto L10;
        QConfig r1 = getCig$omvvm_core_release();
        if (r1 == null) goto L7;
        QMonitorConfig r2 = r1.monitorCig();
    L8:
        monitorCig = r2;
        goto L10
    L7:
        r2 = null;
    L10:
        return monitorCig;
    }

    public final QMonitorConfig getMonitorCig() {
        QMonitorConfig r0 = getMonitorCig$omvvm_core_release();
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final void setCig$omvvm_core_release(QConfig r1) {
        cig = r1;
    }

    public final QConfig getCig$omvvm_core_release() {
        if (cig != null) goto L6;
        cig = new DefaultConfig();
    L6:
        return cig;
    }

    public final QConfig getCig() {
        QConfig r0 = getCig$omvvm_core_release();
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    private final Boolean getInsightEnabled() {
        if (insightEnabled != null) goto L10;
        QConfig r1 = getCig$omvvm_core_release();
        if (r1 == null) goto L7;
        boolean r2 = r1.enableInsight();
    L8:
        insightEnabled = Boolean.valueOf(r2);
        goto L10
    L7:
        r2 = false;
    L10:
        return insightEnabled;
    }

    public final boolean isInsightEnabled() {
        Boolean r0 = getInsightEnabled();
        Intrinsics.checkNotNull(r0);
        return r0.booleanValue();
    }

    private final Boolean getFixModuleViewAddError() {
        if (fixModuleViewAddError != null) goto L10;
        QConfig r1 = getCig$omvvm_core_release();
        if (r1 == null) goto L7;
        boolean r2 = r1.fixModuleViewAddError();
    L8:
        fixModuleViewAddError = Boolean.valueOf(r2);
        goto L10
    L7:
        r2 = false;
    L10:
        return fixModuleViewAddError;
    }

    public final boolean fixModuleViewAddError() {
        Boolean r0 = getFixModuleViewAddError();
        Intrinsics.checkNotNull(r0);
        return r0.booleanValue();
    }

    public final void uploadLog(String r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        QConfig r1 = getCig$omvvm_core_release();
        if (r1 == null) goto L6;
        r1.uploadLog(r2);
        return;
    }

    public static /* synthetic */ void init$default(Q r0, DefaultConfig r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new DefaultConfig();
    L5:
        r0.init(r1);
    }

    public final void init(QConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        cig = r2;
        channel = r2.channel();
        if (r2.handler() == null) goto L5;
        QExecutor r1 = QExecutor.INSTANCE;
        Handler r0 = r2.handler();
        Intrinsics.checkNotNull(r0);
        r1.setWork(r0);
    L5:
        monitorCig = r2.monitorCig();
        if (r2.openVsyncWorker() == false) goto L8;
        QVsyncFrameCaller.INSTANCE.start();
    L8:
        QVsyncFrameCaller.INSTANCE.setMinLimit$omvvm_core_release(r2.frameMinLimit());
        insightEnabled = Boolean.valueOf(r2.enableInsight());
        fixModuleViewAddError = Boolean.valueOf(r2.fixModuleViewAddError());
    }

    @JvmStatic
    public static final boolean fixQLiveDataMemLeak() {
        QConfig r0 = INSTANCE.getCig$omvvm_core_release();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.fixQLiveDataMemLeak();
    }
}
