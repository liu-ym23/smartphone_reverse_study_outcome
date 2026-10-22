package com.stepos.datacenter.vector;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.datacenter.entity.MediaType;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\b\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/stepos/datacenter/vector/EmbedProvider;", "", "Lcom/stepos/datacenter/entity/MediaType;", "mediaType", "", UxipConstants.f30680s, "", "embed", "(Lcom/stepos/datacenter/entity/MediaType;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "getDimension", "()I", "dimension", "getModel", "()Ljava/lang/String;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "", "getSupportedMediaTypes", "()Ljava/util/Set;", "supportedMediaTypes", "getMaxInputChars", "maxInputChars", "Companion", Const.INTENT_KEY_APIKEY, "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface EmbedProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.f30109a;
    public static final int DEFAULT_MAX_INPUT_CHARS = 1600;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/datacenter/vector/EmbedProvider$a;", "", "<init>", "()V", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.vector.EmbedProvider$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f30109a = new Companion();
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        public static int a(EmbedProvider embedProvider) {
            return EmbedProvider.DEFAULT_MAX_INPUT_CHARS;
        }
    }

    Object embed(MediaType mediaType, String str, InterfaceC4014c<? super float[]> interfaceC4014c);

    int getDimension();

    int getMaxInputChars();

    String getModel();

    Set<MediaType> getSupportedMediaTypes();
}
