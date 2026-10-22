package com.bytedance.privacy.attestation;

import android.text.TextUtils;
import com.bytedance.security.eventproto.monitor.ErrorEvent;
import com.bytedance.security.eventproto.monitor.NormalEvent;
import com.bytedance.security.eventproto.monitor.wrapper.AttestationConfigInfoWrapper;

/* JADX INFO: loaded from: classes2.dex */
public class IdAttestationEventTrace {
    public IdAttestationEventTrace() {
    }

    public static void eventTrace(int r6, int r7, String r8, String r9, long r10, AttestationConfig r12) {
        if (r6 != 0) goto L4;
        NormalEvent.eventReport(1, r7, r8, r9, r10);
        return;
    L4:
        ErrorEvent.eventReport(1, r7, r8, r9, r6, AttestationConfigInfoWrapper.newBuilder().setReqUdid(r12.isIdRequested(AttestationConfig.IdType.UDID)).setReqRpdid(r12.isIdRequested(AttestationConfig.IdType.RPDID)).setReqRpuid(r12.isIdRequested(AttestationConfig.IdType.RPUID)).setAddCustomInfo(!TextUtils.isEmpty(r12.getCustomInfo())).setDevHealthStatusRequired(r12.isDevHealthStatusRequired()).build());
    }
}
