package com.uxsense.parse;

import A9.d;
import B9.H;
import B9.T;
import B9.d0;
import B9.h0;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.base.metadata.CreationType;
import com.uxsense.parse.IdSource;
import com.uxsense.search.MatchMode;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import z9.g;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0002ONBo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014B\u0081\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b \u0010\u001fJ\u0012\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b'\u0010(J\u0012\u0010)\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b)\u0010*Jz\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b-\u0010\"J\u0010\u0010.\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b.\u0010/J\u001a\u00102\u001a\u0002012\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b2\u00103J'\u0010<\u001a\u0002092\u0006\u00104\u001a\u00020\u00002\u0006\u00106\u001a\u0002052\u0006\u00108\u001a\u000207H\u0001¢\u0006\u0004\b:\u0010;R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010=\u001a\u0004\b>\u0010\u001bR#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010?\u001a\u0004\b@\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010A\u001a\u0004\bB\u0010\u001fR\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010A\u001a\u0004\bC\u0010\u001fR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010D\u001a\u0004\bE\u0010\"R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010F\u001a\u0004\bG\u0010$R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010H\u001a\u0004\bI\u0010&R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010J\u001a\u0004\bK\u0010(R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010L\u001a\u0004\bM\u0010*¨\u0006P"}, d2 = {"Lcom/uxsense/parse/MetadataConfig;", "", "Lcom/uxsense/parse/MetadataType;", "type", "", "", "fieldMapping", "Lcom/uxsense/parse/IdSource;", "idSource", "userIdSource", "customHandler", "Lcom/uxsense/base/metadata/CreationType;", "creationType", "Lcom/uxsense/parse/DeduplicateStrategy;", "deduplicateStrategy", "Lcom/uxsense/search/MatchMode;", "matchMode", "Lcom/uxsense/parse/ContextExtractor;", "contextExtractor", AppAgent.CONSTRUCT, "(Lcom/uxsense/parse/MetadataType;Ljava/util/Map;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/IdSource;Ljava/lang/String;Lcom/uxsense/base/metadata/CreationType;Lcom/uxsense/parse/DeduplicateStrategy;Lcom/uxsense/search/MatchMode;Lcom/uxsense/parse/ContextExtractor;)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILcom/uxsense/parse/MetadataType;Ljava/util/Map;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/IdSource;Ljava/lang/String;Lcom/uxsense/base/metadata/CreationType;Lcom/uxsense/parse/DeduplicateStrategy;Lcom/uxsense/search/MatchMode;Lcom/uxsense/parse/ContextExtractor;LB9/d0;)V", "component1", "()Lcom/uxsense/parse/MetadataType;", "component2", "()Ljava/util/Map;", "component3", "()Lcom/uxsense/parse/IdSource;", "component4", "component5", "()Ljava/lang/String;", "component6", "()Lcom/uxsense/base/metadata/CreationType;", "component7", "()Lcom/uxsense/parse/DeduplicateStrategy;", "component8", "()Lcom/uxsense/search/MatchMode;", "component9", "()Lcom/uxsense/parse/ContextExtractor;", "copy", "(Lcom/uxsense/parse/MetadataType;Ljava/util/Map;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/IdSource;Ljava/lang/String;Lcom/uxsense/base/metadata/CreationType;Lcom/uxsense/parse/DeduplicateStrategy;Lcom/uxsense/search/MatchMode;Lcom/uxsense/parse/ContextExtractor;)Lcom/uxsense/parse/MetadataConfig;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/parse/MetadataConfig;LA9/d;Lz9/g;)V", "write$Self", "Lcom/uxsense/parse/MetadataType;", "getType", "Ljava/util/Map;", "getFieldMapping", "Lcom/uxsense/parse/IdSource;", "getIdSource", "getUserIdSource", "Ljava/lang/String;", "getCustomHandler", "Lcom/uxsense/base/metadata/CreationType;", "getCreationType", "Lcom/uxsense/parse/DeduplicateStrategy;", "getDeduplicateStrategy", "Lcom/uxsense/search/MatchMode;", "getMatchMode", "Lcom/uxsense/parse/ContextExtractor;", "getContextExtractor", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MetadataConfig {
    private static final f[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ContextExtractor contextExtractor;
    private final CreationType creationType;
    private final String customHandler;
    private final DeduplicateStrategy deduplicateStrategy;
    private final Map<String, String> fieldMapping;
    private final IdSource idSource;
    private final MatchMode matchMode;
    private final MetadataType type;
    private final IdSource userIdSource;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/parse/MetadataConfig$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/parse/MetadataConfig;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final x9.b serializer() {
            return MetadataConfig$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        $childSerializers = new f[]{kotlin.a.b(lazyThreadSafetyMode, new com.uxsense.base.metadata.a(27)), kotlin.a.b(lazyThreadSafetyMode, new com.uxsense.base.metadata.a(28)), kotlin.a.b(lazyThreadSafetyMode, new com.uxsense.base.metadata.a(29)), kotlin.a.b(lazyThreadSafetyMode, new a(0)), null, kotlin.a.b(lazyThreadSafetyMode, new a(1)), kotlin.a.b(lazyThreadSafetyMode, new a(2)), kotlin.a.b(lazyThreadSafetyMode, new a(3)), null};
    }

    public /* synthetic */ MetadataConfig(int i, MetadataType metadataType, Map map, IdSource idSource, IdSource idSource2, String str, CreationType creationType, DeduplicateStrategy deduplicateStrategy, MatchMode matchMode, ContextExtractor contextExtractor, d0 d0Var) {
        if (1 != (i & 1)) {
            T.g(MetadataConfig$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.type = metadataType;
        if ((i & 2) == 0) {
            this.fieldMapping = kotlin.collections.a.M();
        } else {
            this.fieldMapping = map;
        }
        if ((i & 4) == 0) {
            this.idSource = IdSource.AutoGenerate.INSTANCE;
        } else {
            this.idSource = idSource;
        }
        if ((i & 8) == 0) {
            this.userIdSource = IdSource.FromNickname.INSTANCE;
        } else {
            this.userIdSource = idSource2;
        }
        if ((i & 16) == 0) {
            this.customHandler = null;
        } else {
            this.customHandler = str;
        }
        if ((i & 32) == 0) {
            this.creationType = CreationType.TEXT;
        } else {
            this.creationType = creationType;
        }
        if ((i & 64) == 0) {
            this.deduplicateStrategy = DeduplicateStrategy.UPDATE;
        } else {
            this.deduplicateStrategy = deduplicateStrategy;
        }
        if ((i & 128) == 0) {
            this.matchMode = MatchMode.FUZZY;
        } else {
            this.matchMode = matchMode;
        }
        if ((i & 256) == 0) {
            this.contextExtractor = null;
        } else {
            this.contextExtractor = contextExtractor;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ x9.b _childSerializers$_anonymous_() {
        return MetadataType.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ x9.b _childSerializers$_anonymous_$0() {
        h0 h0Var = h0.f242a;
        return new H(h0Var, h0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ x9.b _childSerializers$_anonymous_$1() {
        return IdSource.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ x9.b _childSerializers$_anonymous_$2() {
        return IdSource.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ x9.b _childSerializers$_anonymous_$3() {
        return CreationType.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ x9.b _childSerializers$_anonymous_$4() {
        return DeduplicateStrategy.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ x9.b _childSerializers$_anonymous_$5() {
        return MatchMode.INSTANCE.serializer();
    }

    public static /* synthetic */ MetadataConfig copy$default(MetadataConfig metadataConfig, MetadataType metadataType, Map map, IdSource idSource, IdSource idSource2, String str, CreationType creationType, DeduplicateStrategy deduplicateStrategy, MatchMode matchMode, ContextExtractor contextExtractor, int i, Object obj) {
        if ((i & 1) != 0) {
            metadataType = metadataConfig.type;
        }
        if ((i & 2) != 0) {
            map = metadataConfig.fieldMapping;
        }
        if ((i & 4) != 0) {
            idSource = metadataConfig.idSource;
        }
        if ((i & 8) != 0) {
            idSource2 = metadataConfig.userIdSource;
        }
        if ((i & 16) != 0) {
            str = metadataConfig.customHandler;
        }
        if ((i & 32) != 0) {
            creationType = metadataConfig.creationType;
        }
        if ((i & 64) != 0) {
            deduplicateStrategy = metadataConfig.deduplicateStrategy;
        }
        if ((i & 128) != 0) {
            matchMode = metadataConfig.matchMode;
        }
        if ((i & 256) != 0) {
            contextExtractor = metadataConfig.contextExtractor;
        }
        MatchMode matchMode2 = matchMode;
        ContextExtractor contextExtractor2 = contextExtractor;
        CreationType creationType2 = creationType;
        DeduplicateStrategy deduplicateStrategy2 = deduplicateStrategy;
        String str2 = str;
        IdSource idSource3 = idSource;
        return metadataConfig.copy(metadataType, map, idSource3, idSource2, str2, creationType2, deduplicateStrategy2, matchMode2, contextExtractor2);
    }

    public static final /* synthetic */ void write$Self$uxsense_release(MetadataConfig self, d output, g serialDesc) {
        f[] fVarArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, (x9.f) fVarArr[0].getF4884a(), self.type);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !k.b(self.fieldMapping, kotlin.collections.a.M())) {
            output.encodeSerializableElement(serialDesc, 1, (x9.f) fVarArr[1].getF4884a(), self.fieldMapping);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !k.b(self.idSource, IdSource.AutoGenerate.INSTANCE)) {
            output.encodeSerializableElement(serialDesc, 2, (x9.f) fVarArr[2].getF4884a(), self.idSource);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !k.b(self.userIdSource, IdSource.FromNickname.INSTANCE)) {
            output.encodeSerializableElement(serialDesc, 3, (x9.f) fVarArr[3].getF4884a(), self.userIdSource);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.customHandler != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, h0.f242a, self.customHandler);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.creationType != CreationType.TEXT) {
            output.encodeSerializableElement(serialDesc, 5, (x9.f) fVarArr[5].getF4884a(), self.creationType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.deduplicateStrategy != DeduplicateStrategy.UPDATE) {
            output.encodeSerializableElement(serialDesc, 6, (x9.f) fVarArr[6].getF4884a(), self.deduplicateStrategy);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.matchMode != MatchMode.FUZZY) {
            output.encodeSerializableElement(serialDesc, 7, (x9.f) fVarArr[7].getF4884a(), self.matchMode);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 8) && self.contextExtractor == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 8, ContextExtractor$$serializer.INSTANCE, self.contextExtractor);
    }

    /* renamed from: component1, reason: from getter */
    public final MetadataType getType() {
        return this.type;
    }

    public final Map<String, String> component2() {
        return this.fieldMapping;
    }

    /* renamed from: component3, reason: from getter */
    public final IdSource getIdSource() {
        return this.idSource;
    }

    /* renamed from: component4, reason: from getter */
    public final IdSource getUserIdSource() {
        return this.userIdSource;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCustomHandler() {
        return this.customHandler;
    }

    /* renamed from: component6, reason: from getter */
    public final CreationType getCreationType() {
        return this.creationType;
    }

    /* renamed from: component7, reason: from getter */
    public final DeduplicateStrategy getDeduplicateStrategy() {
        return this.deduplicateStrategy;
    }

    /* renamed from: component8, reason: from getter */
    public final MatchMode getMatchMode() {
        return this.matchMode;
    }

    /* renamed from: component9, reason: from getter */
    public final ContextExtractor getContextExtractor() {
        return this.contextExtractor;
    }

    public final MetadataConfig copy(MetadataType type, Map<String, String> fieldMapping, IdSource idSource, IdSource userIdSource, String customHandler, CreationType creationType, DeduplicateStrategy deduplicateStrategy, MatchMode matchMode, ContextExtractor contextExtractor) {
        k.f(type, "type");
        k.f(fieldMapping, "fieldMapping");
        k.f(idSource, "idSource");
        k.f(userIdSource, "userIdSource");
        k.f(creationType, "creationType");
        k.f(deduplicateStrategy, "deduplicateStrategy");
        k.f(matchMode, "matchMode");
        return new MetadataConfig(type, fieldMapping, idSource, userIdSource, customHandler, creationType, deduplicateStrategy, matchMode, contextExtractor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetadataConfig)) {
            return false;
        }
        MetadataConfig metadataConfig = (MetadataConfig) other;
        return this.type == metadataConfig.type && k.b(this.fieldMapping, metadataConfig.fieldMapping) && k.b(this.idSource, metadataConfig.idSource) && k.b(this.userIdSource, metadataConfig.userIdSource) && k.b(this.customHandler, metadataConfig.customHandler) && this.creationType == metadataConfig.creationType && this.deduplicateStrategy == metadataConfig.deduplicateStrategy && this.matchMode == metadataConfig.matchMode && k.b(this.contextExtractor, metadataConfig.contextExtractor);
    }

    public final ContextExtractor getContextExtractor() {
        return this.contextExtractor;
    }

    public final CreationType getCreationType() {
        return this.creationType;
    }

    public final String getCustomHandler() {
        return this.customHandler;
    }

    public final DeduplicateStrategy getDeduplicateStrategy() {
        return this.deduplicateStrategy;
    }

    public final Map<String, String> getFieldMapping() {
        return this.fieldMapping;
    }

    public final IdSource getIdSource() {
        return this.idSource;
    }

    public final MatchMode getMatchMode() {
        return this.matchMode;
    }

    public final MetadataType getType() {
        return this.type;
    }

    public final IdSource getUserIdSource() {
        return this.userIdSource;
    }

    public int hashCode() {
        int iHashCode = (this.userIdSource.hashCode() + ((this.idSource.hashCode() + androidx.appfunctions.metadata.a.f(this.fieldMapping, this.type.hashCode() * 31, 31)) * 31)) * 31;
        String str = this.customHandler;
        int iHashCode2 = (this.matchMode.hashCode() + ((this.deduplicateStrategy.hashCode() + ((this.creationType.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31)) * 31)) * 31;
        ContextExtractor contextExtractor = this.contextExtractor;
        return iHashCode2 + (contextExtractor != null ? contextExtractor.hashCode() : 0);
    }

    public String toString() {
        return "MetadataConfig(type=" + this.type + ", fieldMapping=" + this.fieldMapping + ", idSource=" + this.idSource + ", userIdSource=" + this.userIdSource + ", customHandler=" + this.customHandler + ", creationType=" + this.creationType + ", deduplicateStrategy=" + this.deduplicateStrategy + ", matchMode=" + this.matchMode + ", contextExtractor=" + this.contextExtractor + ')';
    }

    public MetadataConfig(MetadataType type, Map<String, String> fieldMapping, IdSource idSource, IdSource userIdSource, String str, CreationType creationType, DeduplicateStrategy deduplicateStrategy, MatchMode matchMode, ContextExtractor contextExtractor) {
        k.f(type, "type");
        k.f(fieldMapping, "fieldMapping");
        k.f(idSource, "idSource");
        k.f(userIdSource, "userIdSource");
        k.f(creationType, "creationType");
        k.f(deduplicateStrategy, "deduplicateStrategy");
        k.f(matchMode, "matchMode");
        this.type = type;
        this.fieldMapping = fieldMapping;
        this.idSource = idSource;
        this.userIdSource = userIdSource;
        this.customHandler = str;
        this.creationType = creationType;
        this.deduplicateStrategy = deduplicateStrategy;
        this.matchMode = matchMode;
        this.contextExtractor = contextExtractor;
    }

    public /* synthetic */ MetadataConfig(MetadataType metadataType, Map map, IdSource idSource, IdSource idSource2, String str, CreationType creationType, DeduplicateStrategy deduplicateStrategy, MatchMode matchMode, ContextExtractor contextExtractor, int i, e eVar) {
        this(metadataType, (i & 2) != 0 ? kotlin.collections.a.M() : map, (i & 4) != 0 ? IdSource.AutoGenerate.INSTANCE : idSource, (i & 8) != 0 ? IdSource.FromNickname.INSTANCE : idSource2, (i & 16) != 0 ? null : str, (i & 32) != 0 ? CreationType.TEXT : creationType, (i & 64) != 0 ? DeduplicateStrategy.UPDATE : deduplicateStrategy, (i & 128) != 0 ? MatchMode.FUZZY : matchMode, (i & 256) != 0 ? null : contextExtractor);
    }
}
