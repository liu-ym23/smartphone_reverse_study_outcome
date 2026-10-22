package com.bytedance.safetyguard.lxc.api.sidecar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;

/* JADX INFO: compiled from: SafetyGuardSidecar.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SidecarOperation extends Closeable {

    /* JADX INFO: compiled from: SafetyGuardSidecar.kt */
    public static final class DefaultImpls {
        public static void close(SidecarOperation r2) {
            ((SidecarOperation) ZeusTransformUtils.wrapperContextForParams(r2, SidecarOperation.class, "com.obric.aiagent.plugin")).cancel();
        }
    }

    boolean cancel();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getOperationId();
}
