package com.stepos.stepclaw.memory.embedding;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0018\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0005J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0014J\u001b\u0010\u0018\u001a\u00020\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u0014R$\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0011\u0010#\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010%\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b$\u0010\"¨\u0006'"}, d2 = {"Lcom/stepos/stepclaw/memory/embedding/EmbeddingClient;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/embedding/EmbeddingProvider;", "initialProvider", "<init>", "(Lcom/stepos/stepclaw/memory/embedding/EmbeddingProvider;)V", "Lcom/stepos/stepclaw/memory/embedding/RemoteEmbeddingProvider;", "remoteOrNull", "()Lcom/stepos/stepclaw/memory/embedding/RemoteEmbeddingProvider;", "newProvider", "Lb5/a0;", "switchProvider", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "texts", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "embed", "(Ljava/util/List;Lf5/c;)Ljava/lang/Object;", "newUrl", "updateBaseUrl", "(Ljava/lang/String;)V", "newKey", "updateApiKey", "newKeys", "updateApiKeys", "(Ljava/util/List;)V", "newModel", "updateModel", "value", ConfigIpcContract.KEY_PROVIDER, "Lcom/stepos/stepclaw/memory/embedding/EmbeddingProvider;", "getProvider", "()Lcom/stepos/stepclaw/memory/embedding/EmbeddingProvider;", "getProviderId", "()Ljava/lang/String;", "providerId", "getBaseUrl", ConfigIpcContract.KEY_BASE_URL, "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EmbeddingClient {
    public static final String DEFAULT_MODEL = "BAAI/bge-m3";
    private volatile EmbeddingProvider provider;

    public EmbeddingClient(EmbeddingProvider initialProvider) {
        p.e(initialProvider, "initialProvider");
        this.provider = initialProvider;
    }

    private final RemoteEmbeddingProvider remoteOrNull() {
        EmbeddingProvider embeddingProvider = this.provider;
        if (embeddingProvider instanceof RemoteEmbeddingProvider) {
            return (RemoteEmbeddingProvider) embeddingProvider;
        }
        return null;
    }

    public final Object embed(List<String> list, f5.c cVar) {
        return this.provider.embed(list, cVar);
    }

    public final String getBaseUrl() {
        String baseUrl;
        RemoteEmbeddingProvider remoteEmbeddingProviderRemoteOrNull = remoteOrNull();
        return (remoteEmbeddingProviderRemoteOrNull == null || (baseUrl = remoteEmbeddingProviderRemoteOrNull.getBaseUrl()) == null) ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : baseUrl;
    }

    public final EmbeddingProvider getProvider() {
        return this.provider;
    }

    public final String getProviderId() {
        return this.provider.getId();
    }

    public final void switchProvider(EmbeddingProvider newProvider) {
        p.e(newProvider, "newProvider");
        this.provider = newProvider;
    }

    public final void updateApiKey(String newKey) {
        p.e(newKey, "newKey");
        RemoteEmbeddingProvider remoteEmbeddingProviderRemoteOrNull = remoteOrNull();
        if (remoteEmbeddingProviderRemoteOrNull != null) {
            remoteEmbeddingProviderRemoteOrNull.updateApiKey(newKey);
        }
    }

    public final void updateApiKeys(List<String> newKeys) {
        p.e(newKeys, "newKeys");
        RemoteEmbeddingProvider remoteEmbeddingProviderRemoteOrNull = remoteOrNull();
        if (remoteEmbeddingProviderRemoteOrNull != null) {
            remoteEmbeddingProviderRemoteOrNull.updateApiKeys(newKeys);
        }
    }

    public final void updateBaseUrl(String newUrl) {
        p.e(newUrl, "newUrl");
        RemoteEmbeddingProvider remoteEmbeddingProviderRemoteOrNull = remoteOrNull();
        if (remoteEmbeddingProviderRemoteOrNull != null) {
            remoteEmbeddingProviderRemoteOrNull.updateBaseUrl(newUrl);
        }
    }

    public final void updateModel(String newModel) {
        p.e(newModel, "newModel");
        RemoteEmbeddingProvider remoteEmbeddingProviderRemoteOrNull = remoteOrNull();
        if (remoteEmbeddingProviderRemoteOrNull != null) {
            remoteEmbeddingProviderRemoteOrNull.updateModel(newModel);
        }
    }
}
