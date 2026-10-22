package com.uxsense.search;

import A9.d;
import B9.C0177d;
import B9.T;
import B9.d0;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000298B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eBO\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\r\u0010\u0012J'\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b \u0010!J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b$\u0010%JH\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b(\u0010\u001fJ\u0010\u0010)\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b)\u0010\u001dJ\u001a\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00100\u001a\u0004\b1\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00102\u001a\u0004\b3\u0010!R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u00104\u001a\u0004\b5\u0010#R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u00106\u001a\u0004\b7\u0010%¨\u0006:"}, d2 = {"Lcom/uxsense/search/SearchIndex;", "", "", "version", "", "appName", "Lcom/uxsense/search/EntityType;", "entityType", "", "Lcom/uxsense/search/SearchableEntity;", "entities", "", "lastUpdatedAt", AppAgent.CONSTRUCT, "(ILjava/lang/String;Lcom/uxsense/search/EntityType;Ljava/util/List;J)V", "seen0", "LB9/d0;", "serializationConstructorMarker", "(IILjava/lang/String;Lcom/uxsense/search/EntityType;Ljava/util/List;JLB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/search/SearchIndex;LA9/d;Lz9/g;)V", "write$Self", "component1", "()I", "component2", "()Ljava/lang/String;", "component3", "()Lcom/uxsense/search/EntityType;", "component4", "()Ljava/util/List;", "component5", "()J", "copy", "(ILjava/lang/String;Lcom/uxsense/search/EntityType;Ljava/util/List;J)Lcom/uxsense/search/SearchIndex;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getVersion", "Ljava/lang/String;", "getAppName", "Lcom/uxsense/search/EntityType;", "getEntityType", "Ljava/util/List;", "getEntities", "J", "getLastUpdatedAt", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SearchIndex {
    private static final f[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String appName;
    private final List<SearchableEntity> entities;
    private final EntityType entityType;
    private final long lastUpdatedAt;
    private final int version;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/search/SearchIndex$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/search/SearchIndex;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return SearchIndex$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        $childSerializers = new f[]{null, null, a.b(lazyThreadSafetyMode, new com.uxsense.parse.a(10)), a.b(lazyThreadSafetyMode, new com.uxsense.parse.a(11)), null};
    }

    public /* synthetic */ SearchIndex(int i, int i6, String str, EntityType entityType, List list, long j5, d0 d0Var) {
        if (14 != (i & 14)) {
            T.g(SearchIndex$$serializer.INSTANCE.getDescriptor(), i, 14);
            throw null;
        }
        this.version = (i & 1) == 0 ? 1 : i6;
        this.appName = str;
        this.entityType = entityType;
        this.entities = list;
        if ((i & 16) == 0) {
            this.lastUpdatedAt = System.currentTimeMillis();
        } else {
            this.lastUpdatedAt = j5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_() {
        return EntityType.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_$0() {
        return new C0177d(SearchableEntity$$serializer.INSTANCE);
    }

    public static /* synthetic */ SearchIndex copy$default(SearchIndex searchIndex, int i, String str, EntityType entityType, List list, long j5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = searchIndex.version;
        }
        if ((i6 & 2) != 0) {
            str = searchIndex.appName;
        }
        if ((i6 & 4) != 0) {
            entityType = searchIndex.entityType;
        }
        if ((i6 & 8) != 0) {
            list = searchIndex.entities;
        }
        if ((i6 & 16) != 0) {
            j5 = searchIndex.lastUpdatedAt;
        }
        long j6 = j5;
        return searchIndex.copy(i, str, entityType, list, j6);
    }

    public static final /* synthetic */ void write$Self$uxsense_release(SearchIndex self, d output, g serialDesc) {
        f[] fVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.version != 1) {
            output.encodeIntElement(serialDesc, 0, self.version);
        }
        output.encodeStringElement(serialDesc, 1, self.appName);
        output.encodeSerializableElement(serialDesc, 2, (x9.f) fVarArr[2].getF4884a(), self.entityType);
        output.encodeSerializableElement(serialDesc, 3, (x9.f) fVarArr[3].getF4884a(), self.entities);
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.lastUpdatedAt == System.currentTimeMillis()) {
            return;
        }
        output.encodeLongElement(serialDesc, 4, self.lastUpdatedAt);
    }

    /* renamed from: component1, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component3, reason: from getter */
    public final EntityType getEntityType() {
        return this.entityType;
    }

    public final List<SearchableEntity> component4() {
        return this.entities;
    }

    /* renamed from: component5, reason: from getter */
    public final long getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public final SearchIndex copy(int version, String appName, EntityType entityType, List<SearchableEntity> entities, long lastUpdatedAt) {
        k.f(appName, "appName");
        k.f(entityType, "entityType");
        k.f(entities, "entities");
        return new SearchIndex(version, appName, entityType, entities, lastUpdatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchIndex)) {
            return false;
        }
        SearchIndex searchIndex = (SearchIndex) other;
        return this.version == searchIndex.version && k.b(this.appName, searchIndex.appName) && this.entityType == searchIndex.entityType && k.b(this.entities, searchIndex.entities) && this.lastUpdatedAt == searchIndex.lastUpdatedAt;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final List<SearchableEntity> getEntities() {
        return this.entities;
    }

    public final EntityType getEntityType() {
        return this.entityType;
    }

    public final long getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return Long.hashCode(this.lastUpdatedAt) + androidx.appfunctions.metadata.a.e(this.entities, (this.entityType.hashCode() + B7.a.c(Integer.hashCode(this.version) * 31, 31, this.appName)) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SearchIndex(version=");
        sb.append(this.version);
        sb.append(", appName=");
        sb.append(this.appName);
        sb.append(", entityType=");
        sb.append(this.entityType);
        sb.append(", entities=");
        sb.append(this.entities);
        sb.append(", lastUpdatedAt=");
        return B7.a.p(sb, this.lastUpdatedAt, ')');
    }

    public SearchIndex(int i, String appName, EntityType entityType, List<SearchableEntity> entities, long j5) {
        k.f(appName, "appName");
        k.f(entityType, "entityType");
        k.f(entities, "entities");
        this.version = i;
        this.appName = appName;
        this.entityType = entityType;
        this.entities = entities;
        this.lastUpdatedAt = j5;
    }

    public /* synthetic */ SearchIndex(int i, String str, EntityType entityType, List list, long j5, int i6, e eVar) {
        this((i6 & 1) != 0 ? 1 : i, str, entityType, list, (i6 & 16) != 0 ? System.currentTimeMillis() : j5);
    }
}
