package com.obric.capabilitykit.common.execution.eca.inputparam;

import com.obric.capabilitykit.common.execution.eca.ECAInputParam;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/common/execution/eca/inputparam/ECAInputParamDependency;", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "targetEcaId", "", "targetActionName", "dependedParamName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDependedParamName", "()Ljava/lang/String;", "getTargetActionName", "getTargetEcaId", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ECAInputParamDependency extends ECAInputParam {

    @Nullable
    private final String dependedParamName;

    @Nullable
    private final String targetActionName;

    @Nullable
    private final String targetEcaId;

    public ECAInputParamDependency() {
        String r10 = null;
        String r11 = null;
        String r12 = null;
        this(r10, r11, r12, 7, null);
    }

    @Nullable
    public final String getDependedParamName() {
        return this.dependedParamName;
    }

    @Nullable
    public final String getTargetActionName() {
        return this.targetActionName;
    }

    @Nullable
    public final String getTargetEcaId() {
        return this.targetEcaId;
    }

    public ECAInputParamDependency(@Nullable String r10, @Nullable String r11, @Nullable String r12) {
        this.targetEcaId = r10;
        this.targetActionName = r11;
        this.dependedParamName = r12;
    }

    public /* synthetic */ ECAInputParamDependency(String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
