package com.uxsense.search;

import A9.d;
import B9.C0177d;
import B9.T;
import B9.d0;
import B9.h0;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.a;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u0000 92\u00020\u0001:\u0002:9BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rBW\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0012J'\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b \u0010\u001fJ\u0010\u0010!\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b%\u0010\u001fJR\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b(\u0010\"J\u0010\u0010)\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010-\u001a\u00020,2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b-\u0010.R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010/\u001a\u0004\b0\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b2\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u00101\u001a\u0004\b3\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u00104\u001a\u0004\b5\u0010\"R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006¢\u0006\f\n\u0004\b\n\u00106\u001a\u0004\b7\u0010$R\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u00101\u001a\u0004\b8\u0010\u001f¨\u0006;"}, d2 = {"Lcom/uxsense/search/SearchableEntity;", "", "Lcom/uxsense/search/EntityType;", "entityType", "", "entityId", "parentId", "", "searchableText", "", "keywords", "updatedAt", AppAgent.CONSTRUCT, "(Lcom/uxsense/search/EntityType;JJLjava/lang/String;Ljava/util/List;J)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILcom/uxsense/search/EntityType;JJLjava/lang/String;Ljava/util/List;JLB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/search/SearchableEntity;LA9/d;Lz9/g;)V", "write$Self", "component1", "()Lcom/uxsense/search/EntityType;", "component2", "()J", "component3", "component4", "()Ljava/lang/String;", "component5", "()Ljava/util/List;", "component6", "copy", "(Lcom/uxsense/search/EntityType;JJLjava/lang/String;Ljava/util/List;J)Lcom/uxsense/search/SearchableEntity;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/uxsense/search/EntityType;", "getEntityType", "J", "getEntityId", "getParentId", "Ljava/lang/String;", "getSearchableText", "Ljava/util/List;", "getKeywords", "getUpdatedAt", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SearchableEntity {
    private static final f[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long entityId;
    private final EntityType entityType;
    private final List<String> keywords;
    private final long parentId;
    private final String searchableText;
    private final long updatedAt;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/search/SearchableEntity$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/search/SearchableEntity;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return SearchableEntity$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        $childSerializers = new f[]{a.b(lazyThreadSafetyMode, new com.uxsense.parse.a(12)), null, null, null, a.b(lazyThreadSafetyMode, new com.uxsense.parse.a(13)), null};
    }

    public SearchableEntity(int i, EntityType entityType, long j5, long j6, String str, List list, long j10, d0 d0Var) {
        if (11 != (i & 11)) {
            T.g(SearchableEntity$$serializer.INSTANCE.getDescriptor(), i, 11);
            throw null;
        }
        this.entityType = entityType;
        this.entityId = j5;
        if ((i & 4) == 0) {
            this.parentId = 0L;
        } else {
            this.parentId = j6;
        }
        this.searchableText = str;
        if ((i & 16) == 0) {
            this.keywords = EmptyList.f4893a;
        } else {
            this.keywords = list;
        }
        if ((i & 32) == 0) {
            this.updatedAt = System.currentTimeMillis();
        } else {
            this.updatedAt = j10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_() {
        return EntityType.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_$0() {
        return new C0177d(h0.f242a);
    }

    public static /* synthetic */ SearchableEntity copy$default(SearchableEntity searchableEntity, EntityType entityType, long j5, long j6, String str, List list, long j10, int i, Object obj) {
        if ((i & 1) != 0) {
            entityType = searchableEntity.entityType;
        }
        if ((i & 2) != 0) {
            j5 = searchableEntity.entityId;
        }
        if ((i & 4) != 0) {
            j6 = searchableEntity.parentId;
        }
        if ((i & 8) != 0) {
            str = searchableEntity.searchableText;
        }
        if ((i & 16) != 0) {
            list = searchableEntity.keywords;
        }
        if ((i & 32) != 0) {
            j10 = searchableEntity.updatedAt;
        }
        long j11 = j6;
        return searchableEntity.copy(entityType, j5, j11, str, list, j10);
    }

    public static final void write$Self$uxsense_release(SearchableEntity self, d output, g serialDesc) {
        f[] fVarArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, (x9.f) fVarArr[0].getF4884a(), self.entityType);
        output.encodeLongElement(serialDesc, 1, self.entityId);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.parentId != 0) {
            output.encodeLongElement(serialDesc, 2, self.parentId);
        }
        output.encodeStringElement(serialDesc, 3, self.searchableText);
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !k.b(self.keywords, EmptyList.f4893a)) {
            output.encodeSerializableElement(serialDesc, 4, (x9.f) fVarArr[4].getF4884a(), self.keywords);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.updatedAt == System.currentTimeMillis()) {
            return;
        }
        output.encodeLongElement(serialDesc, 5, self.updatedAt);
    }

    /* renamed from: component1, reason: from getter */
    public final EntityType getEntityType() {
        return this.entityType;
    }

    /* renamed from: component2, reason: from getter */
    public final long getEntityId() {
        return this.entityId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getParentId() {
        return this.parentId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSearchableText() {
        return this.searchableText;
    }

    public final List<String> component5() {
        return this.keywords;
    }

    /* renamed from: component6, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final SearchableEntity copy(EntityType entityType, long entityId, long parentId, String searchableText, List<String> keywords, long updatedAt) {
        k.f(entityType, "entityType");
        k.f(searchableText, "searchableText");
        k.f(keywords, "keywords");
        return new SearchableEntity(entityType, entityId, parentId, searchableText, keywords, updatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchableEntity)) {
            return false;
        }
        SearchableEntity searchableEntity = (SearchableEntity) other;
        return this.entityType == searchableEntity.entityType && this.entityId == searchableEntity.entityId && this.parentId == searchableEntity.parentId && k.b(this.searchableText, searchableEntity.searchableText) && k.b(this.keywords, searchableEntity.keywords) && this.updatedAt == searchableEntity.updatedAt;
    }

    public final long getEntityId() {
        return this.entityId;
    }

    public final EntityType getEntityType() {
        return this.entityType;
    }

    public final List<String> getKeywords() {
        return this.keywords;
    }

    public final long getParentId() {
        return this.parentId;
    }

    public final String getSearchableText() {
        return this.searchableText;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return Long.hashCode(this.updatedAt) + androidx.appfunctions.metadata.a.e(this.keywords, B7.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(this.entityType.hashCode() * 31, 31, this.entityId), 31, this.parentId), 31, this.searchableText), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SearchableEntity(entityType=");
        sb.append(this.entityType);
        sb.append(", entityId=");
        sb.append(this.entityId);
        sb.append(", parentId=");
        sb.append(this.parentId);
        sb.append(", searchableText=");
        sb.append(this.searchableText);
        sb.append(", keywords=");
        sb.append(this.keywords);
        sb.append(", updatedAt=");
        return B7.a.p(sb, this.updatedAt, ')');
    }

    public SearchableEntity(EntityType entityType, long j5, long j6, String searchableText, List<String> keywords, long j10) {
        k.f(entityType, "entityType");
        k.f(searchableText, "searchableText");
        k.f(keywords, "keywords");
        this.entityType = entityType;
        this.entityId = j5;
        this.parentId = j6;
        this.searchableText = searchableText;
        this.keywords = keywords;
        this.updatedAt = j10;
    }

    public SearchableEntity(EntityType entityType, long j5, long j6, String str, List list, long j10, int i, e eVar) {
        this(entityType, j5, (i & 4) != 0 ? 0L : j6, str, (i & 16) != 0 ? EmptyList.f4893a : list, (i & 32) != 0 ? System.currentTimeMillis() : j10);
    }
}
