package com.obric.capabilitykit.common.execution.eca;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0000H\u0016R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "", "()V", "paramName", "", "getParamName$annotations", "getParamName", "()Ljava/lang/String;", "setParamName", "(Ljava/lang/String;)V", "parent", "Lcom/obric/capabilitykit/common/execution/eca/ECAAction;", "getParent", "()Lcom/obric/capabilitykit/common/execution/eca/ECAAction;", "setParent", "(Lcom/obric/capabilitykit/common/execution/eca/ECAAction;)V", "getName", "getValue", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ECAInputParam {

    @NotNull
    private String paramName;

    @Nullable
    private ECAAction parent;

    public ECAInputParam() {
        this.paramName = "";
    }

    @Deprecated(message = "Not supposed to be accessed; use `getName()` instead.")
    public static /* synthetic */ void getParamName$annotations() {
    }

    @NotNull
    public String getName() {
        return this.paramName;
    }

    @NotNull
    public final String getParamName() {
        return this.paramName;
    }

    @Nullable
    public final ECAAction getParent() {
        return this.parent;
    }

    @NotNull
    public ECAInputParam getValue() {
        return this;
    }

    public final void setParamName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.paramName = r10;
    }

    public final void setParent(@Nullable ECAAction r10) {
        this.parent = r10;
    }
}
