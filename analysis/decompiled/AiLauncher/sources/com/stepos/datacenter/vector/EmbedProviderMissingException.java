package com.stepos.datacenter.vector;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/datacenter/vector/EmbedProviderMissingException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "<init>", "()V", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EmbedProviderMissingException extends IllegalStateException {
    public EmbedProviderMissingException() {
        super("EmbedProvider not registered. Call DataCenter.setEmbedProvider(...) in your Application. DataCenter refuses to generate stub zero-vectors because they silently corrupt the index.");
    }
}
