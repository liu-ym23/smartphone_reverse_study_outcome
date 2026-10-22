package com.obric.capabilitykit.entity.memory;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/MemorySourceLinkType;", "", "()V", "DEEPLINK", "", "INTENT", "URL", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MemorySourceLinkType {

    @NotNull
    public static final String DEEPLINK = "deeplink";

    @NotNull
    public static final MemorySourceLinkType INSTANCE = null;

    @NotNull
    public static final String INTENT = "intent";

    @NotNull
    public static final String URL = "url";

    static {
        INSTANCE = new MemorySourceLinkType();
    }

    private MemorySourceLinkType() {
    }
}
