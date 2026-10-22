package com.uxsense.rule;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.uxsense.base.metadata.CreationType;
import com.uxsense.parse.ContextExtractor;
import com.uxsense.parse.DeduplicateStrategy;
import com.uxsense.parse.IdSource;
import com.uxsense.parse.MetadataConfig;
import com.uxsense.parse.MetadataType;
import com.uxsense.search.MatchMode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010&\u001a\u00020'R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/uxsense/rule/MetadataConfigBuilder;", "", AppAgent.CONSTRUCT, "()V", "type", "Lcom/uxsense/parse/MetadataType;", "getType", "()Lcom/uxsense/parse/MetadataType;", "setType", "(Lcom/uxsense/parse/MetadataType;)V", "fieldMapping", "", "", "getFieldMapping", "()Ljava/util/Map;", "setFieldMapping", "(Ljava/util/Map;)V", "idSource", "Lcom/uxsense/parse/IdSource;", "getIdSource", "()Lcom/uxsense/parse/IdSource;", "setIdSource", "(Lcom/uxsense/parse/IdSource;)V", "userIdSource", "getUserIdSource", "setUserIdSource", "deduplicateStrategy", "Lcom/uxsense/parse/DeduplicateStrategy;", "getDeduplicateStrategy", "()Lcom/uxsense/parse/DeduplicateStrategy;", "setDeduplicateStrategy", "(Lcom/uxsense/parse/DeduplicateStrategy;)V", "matchMode", "Lcom/uxsense/search/MatchMode;", "getMatchMode", "()Lcom/uxsense/search/MatchMode;", "setMatchMode", "(Lcom/uxsense/search/MatchMode;)V", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/uxsense/parse/MetadataConfig;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MetadataConfigBuilder {
    private MetadataType type = MetadataType.CUSTOM;
    private Map<String, String> fieldMapping = a.M();
    private IdSource idSource = IdSource.AutoGenerate.INSTANCE;
    private IdSource userIdSource = IdSource.FromNickname.INSTANCE;
    private DeduplicateStrategy deduplicateStrategy = DeduplicateStrategy.UPDATE;
    private MatchMode matchMode = MatchMode.FUZZY;

    public final MetadataConfig build() {
        return new MetadataConfig(this.type, this.fieldMapping, this.idSource, this.userIdSource, (String) null, (CreationType) null, this.deduplicateStrategy, this.matchMode, (ContextExtractor) null, 304, (e) null);
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

    public final void setDeduplicateStrategy(DeduplicateStrategy deduplicateStrategy) {
        k.f(deduplicateStrategy, "<set-?>");
        this.deduplicateStrategy = deduplicateStrategy;
    }

    public final void setFieldMapping(Map<String, String> map) {
        k.f(map, "<set-?>");
        this.fieldMapping = map;
    }

    public final void setIdSource(IdSource idSource) {
        k.f(idSource, "<set-?>");
        this.idSource = idSource;
    }

    public final void setMatchMode(MatchMode matchMode) {
        k.f(matchMode, "<set-?>");
        this.matchMode = matchMode;
    }

    public final void setType(MetadataType metadataType) {
        k.f(metadataType, "<set-?>");
        this.type = metadataType;
    }

    public final void setUserIdSource(IdSource idSource) {
        k.f(idSource, "<set-?>");
        this.userIdSource = idSource;
    }
}
