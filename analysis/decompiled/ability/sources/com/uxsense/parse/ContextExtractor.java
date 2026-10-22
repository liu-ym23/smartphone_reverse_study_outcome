package com.uxsense.parse;

import A9.d;
import B9.H;
import B9.T;
import B9.d0;
import B9.h0;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.pattern.ViewPattern;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import z9.g;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002<;Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eBm\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0017J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0017J\u001c\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJl\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'J'\u00100\u001a\u00020-2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0001¢\u0006\u0004\b.\u0010/R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00103\u001a\u0004\b4\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u00103\u001a\u0004\b5\u0010\u0017R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u00103\u001a\u0004\b6\u0010\u0017R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u00103\u001a\u0004\b7\u0010\u0017R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u00103\u001a\u0004\b8\u0010\u0017R#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u00109\u001a\u0004\b:\u0010\u001d¨\u0006="}, d2 = {"Lcom/uxsense/parse/ContextExtractor;", "", "Lcom/uxsense/core/pattern/ViewPattern;", "pattern", "Lcom/uxsense/parse/IdSource;", "creationIdSource", "userIdSource", "chatIdSource", "senderIdSource", "rootCommentIdSource", "", "", "fieldMapping", AppAgent.CONSTRUCT, "(Lcom/uxsense/core/pattern/ViewPattern;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/IdSource;Ljava/util/Map;)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILcom/uxsense/core/pattern/ViewPattern;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/IdSource;Ljava/util/Map;LB9/d0;)V", "component1", "()Lcom/uxsense/core/pattern/ViewPattern;", "component2", "()Lcom/uxsense/parse/IdSource;", "component3", "component4", "component5", "component6", "component7", "()Ljava/util/Map;", "copy", "(Lcom/uxsense/core/pattern/ViewPattern;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/IdSource;Ljava/util/Map;)Lcom/uxsense/parse/ContextExtractor;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/parse/ContextExtractor;LA9/d;Lz9/g;)V", "write$Self", "Lcom/uxsense/core/pattern/ViewPattern;", "getPattern", "Lcom/uxsense/parse/IdSource;", "getCreationIdSource", "getUserIdSource", "getChatIdSource", "getSenderIdSource", "getRootCommentIdSource", "Ljava/util/Map;", "getFieldMapping", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ContextExtractor {
    private static final f[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final IdSource chatIdSource;
    private final IdSource creationIdSource;
    private final Map<String, String> fieldMapping;
    private final ViewPattern pattern;
    private final IdSource rootCommentIdSource;
    private final IdSource senderIdSource;
    private final IdSource userIdSource;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/parse/ContextExtractor$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/parse/ContextExtractor;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final x9.b serializer() {
            return ContextExtractor$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        $childSerializers = new f[]{kotlin.a.b(lazyThreadSafetyMode, new com.uxsense.base.metadata.a(14)), kotlin.a.b(lazyThreadSafetyMode, new com.uxsense.base.metadata.a(15)), kotlin.a.b(lazyThreadSafetyMode, new com.uxsense.base.metadata.a(16)), kotlin.a.b(lazyThreadSafetyMode, new com.uxsense.base.metadata.a(17)), kotlin.a.b(lazyThreadSafetyMode, new com.uxsense.base.metadata.a(18)), kotlin.a.b(lazyThreadSafetyMode, new com.uxsense.base.metadata.a(19)), kotlin.a.b(lazyThreadSafetyMode, new com.uxsense.base.metadata.a(20))};
    }

    public /* synthetic */ ContextExtractor(int i, ViewPattern viewPattern, IdSource idSource, IdSource idSource2, IdSource idSource3, IdSource idSource4, IdSource idSource5, Map map, d0 d0Var) {
        if (1 != (i & 1)) {
            T.g(ContextExtractor$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.pattern = viewPattern;
        if ((i & 2) == 0) {
            this.creationIdSource = null;
        } else {
            this.creationIdSource = idSource;
        }
        if ((i & 4) == 0) {
            this.userIdSource = null;
        } else {
            this.userIdSource = idSource2;
        }
        if ((i & 8) == 0) {
            this.chatIdSource = null;
        } else {
            this.chatIdSource = idSource3;
        }
        if ((i & 16) == 0) {
            this.senderIdSource = null;
        } else {
            this.senderIdSource = idSource4;
        }
        if ((i & 32) == 0) {
            this.rootCommentIdSource = null;
        } else {
            this.rootCommentIdSource = idSource5;
        }
        if ((i & 64) == 0) {
            this.fieldMapping = kotlin.collections.a.M();
        } else {
            this.fieldMapping = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ x9.b _childSerializers$_anonymous_() {
        return ViewPattern.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ x9.b _childSerializers$_anonymous_$0() {
        return IdSource.INSTANCE.serializer();
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
        return IdSource.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ x9.b _childSerializers$_anonymous_$4() {
        return IdSource.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ x9.b _childSerializers$_anonymous_$5() {
        h0 h0Var = h0.f242a;
        return new H(h0Var, h0Var);
    }

    public static /* synthetic */ ContextExtractor copy$default(ContextExtractor contextExtractor, ViewPattern viewPattern, IdSource idSource, IdSource idSource2, IdSource idSource3, IdSource idSource4, IdSource idSource5, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            viewPattern = contextExtractor.pattern;
        }
        if ((i & 2) != 0) {
            idSource = contextExtractor.creationIdSource;
        }
        if ((i & 4) != 0) {
            idSource2 = contextExtractor.userIdSource;
        }
        if ((i & 8) != 0) {
            idSource3 = contextExtractor.chatIdSource;
        }
        if ((i & 16) != 0) {
            idSource4 = contextExtractor.senderIdSource;
        }
        if ((i & 32) != 0) {
            idSource5 = contextExtractor.rootCommentIdSource;
        }
        if ((i & 64) != 0) {
            map = contextExtractor.fieldMapping;
        }
        IdSource idSource6 = idSource5;
        Map map2 = map;
        IdSource idSource7 = idSource4;
        IdSource idSource8 = idSource2;
        return contextExtractor.copy(viewPattern, idSource, idSource8, idSource3, idSource7, idSource6, map2);
    }

    public static final /* synthetic */ void write$Self$uxsense_release(ContextExtractor self, d output, g serialDesc) {
        f[] fVarArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, (x9.f) fVarArr[0].getF4884a(), self.pattern);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.creationIdSource != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (x9.f) fVarArr[1].getF4884a(), self.creationIdSource);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.userIdSource != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (x9.f) fVarArr[2].getF4884a(), self.userIdSource);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.chatIdSource != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (x9.f) fVarArr[3].getF4884a(), self.chatIdSource);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.senderIdSource != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (x9.f) fVarArr[4].getF4884a(), self.senderIdSource);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.rootCommentIdSource != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (x9.f) fVarArr[5].getF4884a(), self.rootCommentIdSource);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && k.b(self.fieldMapping, kotlin.collections.a.M())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 6, (x9.f) fVarArr[6].getF4884a(), self.fieldMapping);
    }

    /* renamed from: component1, reason: from getter */
    public final ViewPattern getPattern() {
        return this.pattern;
    }

    /* renamed from: component2, reason: from getter */
    public final IdSource getCreationIdSource() {
        return this.creationIdSource;
    }

    /* renamed from: component3, reason: from getter */
    public final IdSource getUserIdSource() {
        return this.userIdSource;
    }

    /* renamed from: component4, reason: from getter */
    public final IdSource getChatIdSource() {
        return this.chatIdSource;
    }

    /* renamed from: component5, reason: from getter */
    public final IdSource getSenderIdSource() {
        return this.senderIdSource;
    }

    /* renamed from: component6, reason: from getter */
    public final IdSource getRootCommentIdSource() {
        return this.rootCommentIdSource;
    }

    public final Map<String, String> component7() {
        return this.fieldMapping;
    }

    public final ContextExtractor copy(ViewPattern pattern, IdSource creationIdSource, IdSource userIdSource, IdSource chatIdSource, IdSource senderIdSource, IdSource rootCommentIdSource, Map<String, String> fieldMapping) {
        k.f(pattern, "pattern");
        k.f(fieldMapping, "fieldMapping");
        return new ContextExtractor(pattern, creationIdSource, userIdSource, chatIdSource, senderIdSource, rootCommentIdSource, fieldMapping);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContextExtractor)) {
            return false;
        }
        ContextExtractor contextExtractor = (ContextExtractor) other;
        return k.b(this.pattern, contextExtractor.pattern) && k.b(this.creationIdSource, contextExtractor.creationIdSource) && k.b(this.userIdSource, contextExtractor.userIdSource) && k.b(this.chatIdSource, contextExtractor.chatIdSource) && k.b(this.senderIdSource, contextExtractor.senderIdSource) && k.b(this.rootCommentIdSource, contextExtractor.rootCommentIdSource) && k.b(this.fieldMapping, contextExtractor.fieldMapping);
    }

    public final IdSource getChatIdSource() {
        return this.chatIdSource;
    }

    public final IdSource getCreationIdSource() {
        return this.creationIdSource;
    }

    public final Map<String, String> getFieldMapping() {
        return this.fieldMapping;
    }

    public final ViewPattern getPattern() {
        return this.pattern;
    }

    public final IdSource getRootCommentIdSource() {
        return this.rootCommentIdSource;
    }

    public final IdSource getSenderIdSource() {
        return this.senderIdSource;
    }

    public final IdSource getUserIdSource() {
        return this.userIdSource;
    }

    public int hashCode() {
        int iHashCode = this.pattern.hashCode() * 31;
        IdSource idSource = this.creationIdSource;
        int iHashCode2 = (iHashCode + (idSource == null ? 0 : idSource.hashCode())) * 31;
        IdSource idSource2 = this.userIdSource;
        int iHashCode3 = (iHashCode2 + (idSource2 == null ? 0 : idSource2.hashCode())) * 31;
        IdSource idSource3 = this.chatIdSource;
        int iHashCode4 = (iHashCode3 + (idSource3 == null ? 0 : idSource3.hashCode())) * 31;
        IdSource idSource4 = this.senderIdSource;
        int iHashCode5 = (iHashCode4 + (idSource4 == null ? 0 : idSource4.hashCode())) * 31;
        IdSource idSource5 = this.rootCommentIdSource;
        return this.fieldMapping.hashCode() + ((iHashCode5 + (idSource5 != null ? idSource5.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "ContextExtractor(pattern=" + this.pattern + ", creationIdSource=" + this.creationIdSource + ", userIdSource=" + this.userIdSource + ", chatIdSource=" + this.chatIdSource + ", senderIdSource=" + this.senderIdSource + ", rootCommentIdSource=" + this.rootCommentIdSource + ", fieldMapping=" + this.fieldMapping + ')';
    }

    public ContextExtractor(ViewPattern pattern, IdSource idSource, IdSource idSource2, IdSource idSource3, IdSource idSource4, IdSource idSource5, Map<String, String> fieldMapping) {
        k.f(pattern, "pattern");
        k.f(fieldMapping, "fieldMapping");
        this.pattern = pattern;
        this.creationIdSource = idSource;
        this.userIdSource = idSource2;
        this.chatIdSource = idSource3;
        this.senderIdSource = idSource4;
        this.rootCommentIdSource = idSource5;
        this.fieldMapping = fieldMapping;
    }

    public /* synthetic */ ContextExtractor(ViewPattern viewPattern, IdSource idSource, IdSource idSource2, IdSource idSource3, IdSource idSource4, IdSource idSource5, Map map, int i, e eVar) {
        this(viewPattern, (i & 2) != 0 ? null : idSource, (i & 4) != 0 ? null : idSource2, (i & 8) != 0 ? null : idSource3, (i & 16) != 0 ? null : idSource4, (i & 32) != 0 ? null : idSource5, (i & 64) != 0 ? kotlin.collections.a.M() : map);
    }
}
