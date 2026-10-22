package com.stepos.datacenter.api;

import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.api.DataCenter;
import com.stepos.datacenter.vector.CollectionDescriptor;
import com.stepos.datacenter.vector.EmbedProvider;
import e7.o;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/datacenter/api/a;", "", "<init>", "()V", "Lcom/stepos/datacenter/vector/EmbedProvider;", Const.JSON_KEY_PROVIDER, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/datacenter/vector/EmbedProvider;)V", "", "collectionId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/datacenter/vector/EmbedProvider;", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f29973a = new a();

    public final EmbedProvider a(String collectionId) {
        CollectionDescriptor collectionDescriptorE;
        p.i(collectionId, "collectionId");
        DataCenter.Companion companion = DataCenter.INSTANCE;
        o vectorRegistry$sdk_release = companion.getVectorRegistry$sdk_release();
        if (vectorRegistry$sdk_release != null && (collectionDescriptorE = vectorRegistry$sdk_release.e(collectionId)) != null) {
            EmbedProvider embedProvider = companion.getEmbedProviders$sdk_release().get(collectionDescriptorE.getEmbeddingModel());
            if (embedProvider != null) {
                if (embedProvider.getDimension() == collectionDescriptorE.getRawDim()) {
                    return embedProvider;
                }
                Log.w("DataCenter", "EmbedProvider model='" + collectionDescriptorE.getEmbeddingModel() + "' dim=" + embedProvider.getDimension() + " mismatches collection '" + collectionId + "' rawDim=" + collectionDescriptorE.getRawDim() + "; rejecting");
                return null;
            }
            EmbedProvider embedProvider$sdk_release = companion.getEmbedProvider$sdk_release();
            if (embedProvider$sdk_release == null) {
                return null;
            }
            if (embedProvider$sdk_release.getDimension() == collectionDescriptorE.getRawDim()) {
                return embedProvider$sdk_release;
            }
            Log.w("DataCenter", "No provider for model='" + collectionDescriptorE.getEmbeddingModel() + "' and default dim=" + embedProvider$sdk_release.getDimension() + " mismatches collection '" + collectionId + "' rawDim=" + collectionDescriptorE.getRawDim() + "; rejecting");
            return null;
        }
        return companion.getEmbedProvider$sdk_release();
    }

    public final void b(EmbedProvider provider) {
        p.i(provider, "provider");
        DataCenter.Companion companion = DataCenter.INSTANCE;
        companion.setEmbedProvider$sdk_release(provider);
        companion.getEmbedProviders$sdk_release().put(provider.getModel(), provider);
        Log.d("DataCenter", "EmbedProvider registered as default: model=" + provider.getModel() + ", dim=" + provider.getDimension());
    }
}
