package com.obric.capabilitykit.common.execution.eca.inputparam;

import com.bytedance.apm.constant.CommonKey;
import com.obric.capabilitykit.common.execution.eca.ECAInputParam;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/common/execution/eca/inputparam/ECAInputParamPrimitive;", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", CommonKey.KEY_VALUE, "", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "setValue", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ECAInputParamPrimitive extends ECAInputParam {

    @Nullable
    private Object value;

    public ECAInputParamPrimitive() {
        DefaultConstructorMarker r10 = null;
        this(r10, 1, r10);
    }

    @Nullable
    public final Object getValue() {
        return this.value;
    }

    public final void setValue(@Nullable Object r10) {
        this.value = r10;
    }

    public ECAInputParamPrimitive(@Nullable Object r10) {
        this.value = r10;
    }

    public /* synthetic */ ECAInputParamPrimitive(Object r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }
}
