package com.uxsense.core.pattern;

import A9.d;
import B9.C0177d;
import B9.T;
import B9.d0;
import C7.f;
import H4.o;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.base.parse.KViewNode;
import com.uxsense.core.model.ViewTrigger;
import com.uxsense.core.pattern.builder.NodePatternBuilderKt;
import com.uxsense.core.utils.ApexLogger;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u001b2\u00020\u0001:\b\u001c\u001d\u001e\u001f !\"\u001bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0002\u0010\bJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001a\u0082\u0001\u0005#$%&'¨\u0006("}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern;", "", AppAgent.CONSTRUCT, "()V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self", "(Lcom/uxsense/core/pattern/ViewPattern;LA9/d;Lz9/g;)V", "Lcom/uxsense/core/base/parse/KViewNode;", "node", "Lcom/uxsense/core/pattern/MatchContext;", "context", "Lcom/uxsense/core/pattern/PatternMatchResult;", "match", "(Lcom/uxsense/core/base/parse/KViewNode;Lcom/uxsense/core/pattern/MatchContext;)Lcom/uxsense/core/pattern/PatternMatchResult;", "", "isOptional", "()Z", "Companion", "NodePatternSurrogate", "NodePatternSerializer", "NodePattern", "AnyOf", "NoneOf", "ConditionalGroup", "Branches", "Lcom/uxsense/core/pattern/ViewPattern$AnyOf;", "Lcom/uxsense/core/pattern/ViewPattern$Branches;", "Lcom/uxsense/core/pattern/ViewPattern$ConditionalGroup;", "Lcom/uxsense/core/pattern/ViewPattern$NodePattern;", "Lcom/uxsense/core/pattern/ViewPattern$NoneOf;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ViewPattern {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final f $cachedSerializer$delegate = kotlin.a.b(LazyThreadSafetyMode.b, new a(5));

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002.-B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ \u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b)\u0010*R\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010\u001f¨\u0006/"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$AnyOf;", "Lcom/uxsense/core/pattern/ViewPattern;", "", "patterns", AppAgent.CONSTRUCT, "(Ljava/util/List;)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILjava/util/List;LB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/core/pattern/ViewPattern$AnyOf;LA9/d;Lz9/g;)V", "write$Self", "Lcom/uxsense/core/base/parse/KViewNode;", "node", "Lcom/uxsense/core/pattern/MatchContext;", "context", "Lcom/uxsense/core/pattern/PatternMatchResult;", "match", "(Lcom/uxsense/core/base/parse/KViewNode;Lcom/uxsense/core/pattern/MatchContext;)Lcom/uxsense/core/pattern/PatternMatchResult;", "", "isOptional", "()Z", "component1", "()Ljava/util/List;", "copy", "(Ljava/util/List;)Lcom/uxsense/core/pattern/ViewPattern$AnyOf;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getPatterns", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class AnyOf extends ViewPattern {
        private final List<ViewPattern> patterns;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final f[] $childSerializers = {kotlin.a.b(LazyThreadSafetyMode.b, new a(6))};

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$AnyOf$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/core/pattern/ViewPattern$AnyOf;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final b serializer() {
                return ViewPattern$AnyOf$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(e eVar) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnyOf(int i, List list, d0 d0Var) {
            super(i, d0Var);
            if (1 != (i & 1)) {
                T.g(ViewPattern$AnyOf$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
            this.patterns = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ b _childSerializers$_anonymous_() {
            return new C0177d(ViewPattern.INSTANCE.serializer());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AnyOf copy$default(AnyOf anyOf, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = anyOf.patterns;
            }
            return anyOf.copy(list);
        }

        public static final /* synthetic */ void write$Self$uxsense_release(AnyOf self, d output, g serialDesc) {
            ViewPattern.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, (x9.f) $childSerializers[0].getF4884a(), self.patterns);
        }

        public final List<ViewPattern> component1() {
            return this.patterns;
        }

        public final AnyOf copy(List<? extends ViewPattern> patterns) {
            k.f(patterns, "patterns");
            return new AnyOf(patterns);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AnyOf) && k.b(this.patterns, ((AnyOf) other).patterns);
        }

        public final List<ViewPattern> getPatterns() {
            return this.patterns;
        }

        public int hashCode() {
            return this.patterns.hashCode();
        }

        @Override // com.uxsense.core.pattern.ViewPattern
        public boolean isOptional() {
            return true;
        }

        @Override // com.uxsense.core.pattern.ViewPattern
        public PatternMatchResult match(KViewNode node, MatchContext context) {
            k.f(node, "node");
            k.f(context, "context");
            for (ViewPattern viewPattern : this.patterns) {
                if (viewPattern instanceof NodePattern) {
                    StringBuilder sb = new StringBuilder("anyOf NodePattern ");
                    NodePattern nodePattern = (NodePattern) viewPattern;
                    sb.append(nodePattern.getName());
                    ApexLogger.d$default("ViewPattern", sb.toString(), null, 4, null);
                    Iterator<KViewNode> it = node.getChildren().iterator();
                    while (it.hasNext()) {
                        PatternMatchResult patternMatchResultMatch = nodePattern.match(it.next(), context);
                        if (patternMatchResultMatch != null) {
                            return patternMatchResultMatch;
                        }
                    }
                } else {
                    ApexLogger.d$default("ViewPattern", "anyOf " + m.f4928a.b(viewPattern.getClass()).m(), null, 4, null);
                    PatternMatchResult patternMatchResultMatch2 = viewPattern.match(node, context);
                    if (patternMatchResultMatch2 != null) {
                        return patternMatchResultMatch2;
                    }
                }
            }
            return null;
        }

        public String toString() {
            return B7.a.r(new StringBuilder("AnyOf(patterns="), this.patterns, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnyOf(List<? extends ViewPattern> patterns) {
            super(null);
            k.f(patterns, "patterns");
            this.patterns = patterns;
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0087\b\u0018\u0000 22\u00020\u0001:\u0003342B\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010\u001fJ*\u0010#\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010,\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010*HÖ\u0003¢\u0006\u0004\b,\u0010-R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010.\u001a\u0004\b/\u0010!R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u00100\u001a\u0004\b1\u0010\u001f¨\u00065"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$Branches;", "Lcom/uxsense/core/pattern/ViewPattern;", "", "Lcom/uxsense/core/pattern/ViewPattern$Branches$Branch;", "branches", "", "optional", AppAgent.CONSTRUCT, "(Ljava/util/List;Z)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILjava/util/List;ZLB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/core/pattern/ViewPattern$Branches;LA9/d;Lz9/g;)V", "write$Self", "Lcom/uxsense/core/base/parse/KViewNode;", "node", "Lcom/uxsense/core/pattern/MatchContext;", "context", "Lcom/uxsense/core/pattern/PatternMatchResult;", "match", "(Lcom/uxsense/core/base/parse/KViewNode;Lcom/uxsense/core/pattern/MatchContext;)Lcom/uxsense/core/pattern/PatternMatchResult;", "isOptional", "()Z", "component1", "()Ljava/util/List;", "component2", "copy", "(Ljava/util/List;Z)Lcom/uxsense/core/pattern/ViewPattern$Branches;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getBranches", "Z", "getOptional", "Companion", "Branch", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Branches extends ViewPattern {
        private final List<Branch> branches;
        private final boolean optional;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final f[] $childSerializers = {kotlin.a.b(LazyThreadSafetyMode.b, new a(7)), null};

        @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002+*B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ,\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010\u001a¨\u0006,"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$Branches$Branch;", "", "Lcom/uxsense/core/pattern/NodeCondition;", "condition", "", "Lcom/uxsense/core/pattern/ViewPattern;", "patterns", AppAgent.CONSTRUCT, "(Lcom/uxsense/core/pattern/NodeCondition;Ljava/util/List;)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILcom/uxsense/core/pattern/NodeCondition;Ljava/util/List;LB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/core/pattern/ViewPattern$Branches$Branch;LA9/d;Lz9/g;)V", "write$Self", "component1", "()Lcom/uxsense/core/pattern/NodeCondition;", "component2", "()Ljava/util/List;", "copy", "(Lcom/uxsense/core/pattern/NodeCondition;Ljava/util/List;)Lcom/uxsense/core/pattern/ViewPattern$Branches$Branch;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/uxsense/core/pattern/NodeCondition;", "getCondition", "Ljava/util/List;", "getPatterns", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Branch {
            private final NodeCondition condition;
            private final List<ViewPattern> patterns;

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final f[] $childSerializers = {null, kotlin.a.b(LazyThreadSafetyMode.b, new a(8))};

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$Branches$Branch$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/core/pattern/ViewPattern$Branches$Branch;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public final b serializer() {
                    return ViewPattern$Branches$Branch$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(e eVar) {
                    this();
                }
            }

            public /* synthetic */ Branch(int i, NodeCondition nodeCondition, List list, d0 d0Var) {
                if (3 != (i & 3)) {
                    T.g(ViewPattern$Branches$Branch$$serializer.INSTANCE.getDescriptor(), i, 3);
                    throw null;
                }
                this.condition = nodeCondition;
                this.patterns = list;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ b _childSerializers$_anonymous_() {
                return new C0177d(ViewPattern.INSTANCE.serializer());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Branch copy$default(Branch branch, NodeCondition nodeCondition, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    nodeCondition = branch.condition;
                }
                if ((i & 2) != 0) {
                    list = branch.patterns;
                }
                return branch.copy(nodeCondition, list);
            }

            public static final /* synthetic */ void write$Self$uxsense_release(Branch self, d output, g serialDesc) {
                f[] fVarArr = $childSerializers;
                output.encodeNullableSerializableElement(serialDesc, 0, NodeCondition$$serializer.INSTANCE, self.condition);
                output.encodeSerializableElement(serialDesc, 1, (x9.f) fVarArr[1].getF4884a(), self.patterns);
            }

            /* renamed from: component1, reason: from getter */
            public final NodeCondition getCondition() {
                return this.condition;
            }

            public final List<ViewPattern> component2() {
                return this.patterns;
            }

            public final Branch copy(NodeCondition condition, List<? extends ViewPattern> patterns) {
                k.f(patterns, "patterns");
                return new Branch(condition, patterns);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Branch)) {
                    return false;
                }
                Branch branch = (Branch) other;
                return k.b(this.condition, branch.condition) && k.b(this.patterns, branch.patterns);
            }

            public final NodeCondition getCondition() {
                return this.condition;
            }

            public final List<ViewPattern> getPatterns() {
                return this.patterns;
            }

            public int hashCode() {
                NodeCondition nodeCondition = this.condition;
                return this.patterns.hashCode() + ((nodeCondition == null ? 0 : nodeCondition.hashCode()) * 31);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Branch(condition=");
                sb.append(this.condition);
                sb.append(", patterns=");
                return B7.a.r(sb, this.patterns, ')');
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Branch(NodeCondition nodeCondition, List<? extends ViewPattern> patterns) {
                k.f(patterns, "patterns");
                this.condition = nodeCondition;
                this.patterns = patterns;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$Branches$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/core/pattern/ViewPattern$Branches;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final b serializer() {
                return ViewPattern$Branches$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(e eVar) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Branches(int i, List list, boolean z10, d0 d0Var) {
            super(i, d0Var);
            if (1 != (i & 1)) {
                T.g(ViewPattern$Branches$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
            this.branches = list;
            if ((i & 2) == 0) {
                this.optional = true;
            } else {
                this.optional = z10;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ b _childSerializers$_anonymous_() {
            return new C0177d(ViewPattern$Branches$Branch$$serializer.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Branches copy$default(Branches branches, List list, boolean z10, int i, Object obj) {
            if ((i & 1) != 0) {
                list = branches.branches;
            }
            if ((i & 2) != 0) {
                z10 = branches.optional;
            }
            return branches.copy(list, z10);
        }

        public static final /* synthetic */ void write$Self$uxsense_release(Branches self, d output, g serialDesc) {
            ViewPattern.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, (x9.f) $childSerializers[0].getF4884a(), self.branches);
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.optional) {
                return;
            }
            output.encodeBooleanElement(serialDesc, 1, self.optional);
        }

        public final List<Branch> component1() {
            return this.branches;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getOptional() {
            return this.optional;
        }

        public final Branches copy(List<Branch> branches, boolean optional) {
            k.f(branches, "branches");
            return new Branches(branches, optional);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Branches)) {
                return false;
            }
            Branches branches = (Branches) other;
            return k.b(this.branches, branches.branches) && this.optional == branches.optional;
        }

        public final List<Branch> getBranches() {
            return this.branches;
        }

        public final boolean getOptional() {
            return this.optional;
        }

        public int hashCode() {
            return Boolean.hashCode(this.optional) + (this.branches.hashCode() * 31);
        }

        @Override // com.uxsense.core.pattern.ViewPattern
        public boolean isOptional() {
            return this.optional;
        }

        @Override // com.uxsense.core.pattern.ViewPattern
        public PatternMatchResult match(KViewNode node, MatchContext context) {
            k.f(node, "node");
            k.f(context, "context");
            KViewNode parentNode = context.getParentNode();
            if (parentNode == null) {
                ApexLogger.d$default("ViewPattern", "branches: no parent node in context", null, 4, null);
                if (this.optional) {
                    return new PatternMatchResult(kotlin.collections.a.M(), null, null, 6, null);
                }
                return null;
            }
            ApexLogger.d$default("ViewPattern", "branches: checking " + this.branches.size() + " branches against parent node", null, 4, null);
            for (Branch branch : this.branches) {
                NodeCondition condition = branch.getCondition();
                if (condition != null ? NodeConditionKt.matches(condition, parentNode, context.getCustomPredicates()) : true) {
                    ApexLogger.d$default("ViewPattern", "branches: parent matches condition, matching " + branch.getPatterns().size() + " patterns in children", null, 4, null);
                    ChildMatchResult childMatchResultMatchChildren = ViewPatternKt.matchChildren(node.getChildren(), branch.getPatterns(), context);
                    if (childMatchResultMatchChildren != null) {
                        return new PatternMatchResult(childMatchResultMatchChildren.getNodes(), childMatchResultMatchChildren.getValueSources(), childMatchResultMatchChildren.getTriggers());
                    }
                }
            }
            if (this.optional) {
                return new PatternMatchResult(kotlin.collections.a.M(), null, null, 6, null);
            }
            return null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Branches(branches=");
            sb.append(this.branches);
            sb.append(", optional=");
            return androidx.appfunctions.metadata.a.r(sb, this.optional, ')');
        }

        public /* synthetic */ Branches(List list, boolean z10, int i, e eVar) {
            this(list, (i & 2) != 0 ? true : z10);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Branches(List<Branch> branches, boolean z10) {
            super(null);
            k.f(branches, "branches");
            this.branches = branches;
            this.optional = z10;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/core/pattern/ViewPattern;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ b get$cachedSerializer() {
            return (b) ViewPattern.$cachedSerializer$delegate.getF4884a();
        }

        public final b serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\f\b\u0087\b\u0018\u0000 72\u00020\u0001:\u000287B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b%\u0010 J4\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010-HÖ\u0003¢\u0006\u0004\b/\u00100R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u0010\"R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00103\u001a\u0004\b4\u0010$R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00105\u001a\u0004\b6\u0010 ¨\u00069"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$ConditionalGroup;", "Lcom/uxsense/core/pattern/ViewPattern;", "Lcom/uxsense/core/pattern/NodeCondition;", "condition", "", "patterns", "", "optional", AppAgent.CONSTRUCT, "(Lcom/uxsense/core/pattern/NodeCondition;Ljava/util/List;Z)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILcom/uxsense/core/pattern/NodeCondition;Ljava/util/List;ZLB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/core/pattern/ViewPattern$ConditionalGroup;LA9/d;Lz9/g;)V", "write$Self", "Lcom/uxsense/core/base/parse/KViewNode;", "node", "Lcom/uxsense/core/pattern/MatchContext;", "context", "Lcom/uxsense/core/pattern/PatternMatchResult;", "match", "(Lcom/uxsense/core/base/parse/KViewNode;Lcom/uxsense/core/pattern/MatchContext;)Lcom/uxsense/core/pattern/PatternMatchResult;", "isOptional", "()Z", "component1", "()Lcom/uxsense/core/pattern/NodeCondition;", "component2", "()Ljava/util/List;", "component3", "copy", "(Lcom/uxsense/core/pattern/NodeCondition;Ljava/util/List;Z)Lcom/uxsense/core/pattern/ViewPattern$ConditionalGroup;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/uxsense/core/pattern/NodeCondition;", "getCondition", "Ljava/util/List;", "getPatterns", "Z", "getOptional", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ConditionalGroup extends ViewPattern {
        private final NodeCondition condition;
        private final boolean optional;
        private final List<ViewPattern> patterns;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final f[] $childSerializers = {null, kotlin.a.b(LazyThreadSafetyMode.b, new a(9)), null};

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$ConditionalGroup$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/core/pattern/ViewPattern$ConditionalGroup;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final b serializer() {
                return ViewPattern$ConditionalGroup$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(e eVar) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ConditionalGroup(int i, NodeCondition nodeCondition, List list, boolean z10, d0 d0Var) {
            super(i, d0Var);
            if (3 != (i & 3)) {
                T.g(ViewPattern$ConditionalGroup$$serializer.INSTANCE.getDescriptor(), i, 3);
                throw null;
            }
            this.condition = nodeCondition;
            this.patterns = list;
            if ((i & 4) == 0) {
                this.optional = false;
            } else {
                this.optional = z10;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ b _childSerializers$_anonymous_() {
            return new C0177d(ViewPattern.INSTANCE.serializer());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ConditionalGroup copy$default(ConditionalGroup conditionalGroup, NodeCondition nodeCondition, List list, boolean z10, int i, Object obj) {
            if ((i & 1) != 0) {
                nodeCondition = conditionalGroup.condition;
            }
            if ((i & 2) != 0) {
                list = conditionalGroup.patterns;
            }
            if ((i & 4) != 0) {
                z10 = conditionalGroup.optional;
            }
            return conditionalGroup.copy(nodeCondition, list, z10);
        }

        public static final /* synthetic */ void write$Self$uxsense_release(ConditionalGroup self, d output, g serialDesc) {
            ViewPattern.write$Self(self, output, serialDesc);
            f[] fVarArr = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, NodeCondition$$serializer.INSTANCE, self.condition);
            output.encodeSerializableElement(serialDesc, 1, (x9.f) fVarArr[1].getF4884a(), self.patterns);
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.optional) {
                output.encodeBooleanElement(serialDesc, 2, self.optional);
            }
        }

        /* renamed from: component1, reason: from getter */
        public final NodeCondition getCondition() {
            return this.condition;
        }

        public final List<ViewPattern> component2() {
            return this.patterns;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getOptional() {
            return this.optional;
        }

        public final ConditionalGroup copy(NodeCondition condition, List<? extends ViewPattern> patterns, boolean optional) {
            k.f(condition, "condition");
            k.f(patterns, "patterns");
            return new ConditionalGroup(condition, patterns, optional);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConditionalGroup)) {
                return false;
            }
            ConditionalGroup conditionalGroup = (ConditionalGroup) other;
            return k.b(this.condition, conditionalGroup.condition) && k.b(this.patterns, conditionalGroup.patterns) && this.optional == conditionalGroup.optional;
        }

        public final NodeCondition getCondition() {
            return this.condition;
        }

        public final boolean getOptional() {
            return this.optional;
        }

        public final List<ViewPattern> getPatterns() {
            return this.patterns;
        }

        public int hashCode() {
            return Boolean.hashCode(this.optional) + androidx.appfunctions.metadata.a.e(this.patterns, this.condition.hashCode() * 31, 31);
        }

        @Override // com.uxsense.core.pattern.ViewPattern
        public boolean isOptional() {
            return this.optional;
        }

        @Override // com.uxsense.core.pattern.ViewPattern
        public PatternMatchResult match(KViewNode node, MatchContext context) {
            k.f(node, "node");
            k.f(context, "context");
            if (!NodeConditionKt.matches(this.condition, node, context.getCustomPredicates())) {
                ApexLogger.d$default("ViewPattern", "conditionalGroup: node does not match condition", null, 4, null);
                return null;
            }
            ApexLogger.d$default("ViewPattern", "conditionalGroup: node matches condition, matching " + this.patterns.size() + " patterns in children", null, 4, null);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            ChildMatchResult childMatchResultMatchChildren = ViewPatternKt.matchChildren(node.getChildren(), this.patterns, context);
            if (childMatchResultMatchChildren == null) {
                if (this.optional) {
                    return new PatternMatchResult(linkedHashMap, linkedHashMap2, linkedHashMap3);
                }
                return null;
            }
            linkedHashMap.putAll(childMatchResultMatchChildren.getNodes());
            linkedHashMap2.putAll(childMatchResultMatchChildren.getValueSources());
            linkedHashMap3.putAll(childMatchResultMatchChildren.getTriggers());
            return new PatternMatchResult(linkedHashMap, linkedHashMap2, linkedHashMap3);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ConditionalGroup(condition=");
            sb.append(this.condition);
            sb.append(", patterns=");
            sb.append(this.patterns);
            sb.append(", optional=");
            return androidx.appfunctions.metadata.a.r(sb, this.optional, ')');
        }

        public /* synthetic */ ConditionalGroup(NodeCondition nodeCondition, List list, boolean z10, int i, e eVar) {
            this(nodeCondition, list, (i & 4) != 0 ? false : z10);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ConditionalGroup(NodeCondition condition, List<? extends ViewPattern> patterns, boolean z10) {
            super(null);
            k.f(condition, "condition");
            k.f(patterns, "patterns");
            this.condition = condition;
            this.patterns = patterns;
            this.optional = z10;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$NodePatternSerializer;", "Lx9/b;", "Lcom/uxsense/core/pattern/ViewPattern$NodePattern;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/core/pattern/ViewPattern$NodePattern;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/core/pattern/ViewPattern$NodePattern;", "Lcom/uxsense/core/pattern/ViewPattern$NodePatternSurrogate;", "surrogateSerializer", "Lx9/b;", "Lz9/g;", "getDescriptor", "()Lz9/g;", "descriptor", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NodePatternSerializer implements b {
        public static final NodePatternSerializer INSTANCE = new NodePatternSerializer();
        private static final b surrogateSerializer = NodePatternSurrogate.INSTANCE.serializer();

        private NodePatternSerializer() {
        }

        @Override // x9.f, x9.InterfaceC2123a
        public g getDescriptor() {
            return surrogateSerializer.getDescriptor();
        }

        @Override // x9.InterfaceC2123a
        public NodePattern deserialize(A9.e decoder) {
            k.f(decoder, "decoder");
            return ((NodePatternSurrogate) surrogateSerializer.deserialize(decoder)).toNodePattern();
        }

        @Override // x9.f
        public void serialize(A9.f encoder, NodePattern value) {
            k.f(encoder, "encoder");
            k.f(value, "value");
            surrogateSerializer.serialize(encoder, NodePatternSurrogate.INSTANCE.fromNodePattern(value));
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0083\b\u0018\u0000 N2\u00020\u0001:\u0002NOBe\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006¢\u0006\u0004\b\u0012\u0010\u0013Bq\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0012\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b#\u0010\"J\u0010\u0010$\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b&\u0010'J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006HÆ\u0003¢\u0006\u0004\b(\u0010 Jn\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006HÆ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b+\u0010\u001cJ\u0010\u0010,\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b,\u0010%J\u001a\u0010.\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b.\u0010/J'\u00108\u001a\u0002052\u0006\u00100\u001a\u00020\u00002\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u000203H\u0001¢\u0006\u0004\b6\u00107R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u00109\u0012\u0004\b;\u0010<\u001a\u0004\b:\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010=\u001a\u0004\b>\u0010\u001eR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010?\u001a\u0004\b@\u0010 R \u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010A\u0012\u0004\bC\u0010<\u001a\u0004\bB\u0010\"R \u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010A\u0012\u0004\bE\u0010<\u001a\u0004\bD\u0010\"R \u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010F\u0012\u0004\bH\u0010<\u001a\u0004\bG\u0010%R \u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010I\u0012\u0004\bK\u0010<\u001a\u0004\bJ\u0010'R&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010?\u0012\u0004\bM\u0010<\u001a\u0004\bL\u0010 ¨\u0006P"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$NodePatternSurrogate;", "", "", HintConstants.AUTOFILL_HINT_NAME, "Lcom/uxsense/core/pattern/NodeCondition;", "condition", "", "Lcom/uxsense/core/pattern/ViewPattern;", "children", "", "optional", "captureChildren", "", "depth", "Lcom/uxsense/core/pattern/ValueSource;", "valueSource", "Lcom/uxsense/core/model/ViewTrigger;", "triggers", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/uxsense/core/pattern/NodeCondition;Ljava/util/List;ZZILcom/uxsense/core/pattern/ValueSource;Ljava/util/List;)V", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/uxsense/core/pattern/NodeCondition;Ljava/util/List;ZZILcom/uxsense/core/pattern/ValueSource;Ljava/util/List;LB9/d0;)V", "Lcom/uxsense/core/pattern/ViewPattern$NodePattern;", "toNodePattern", "()Lcom/uxsense/core/pattern/ViewPattern$NodePattern;", "component1", "()Ljava/lang/String;", "component2", "()Lcom/uxsense/core/pattern/NodeCondition;", "component3", "()Ljava/util/List;", "component4", "()Z", "component5", "component6", "()I", "component7", "()Lcom/uxsense/core/pattern/ValueSource;", "component8", "copy", "(Ljava/lang/String;Lcom/uxsense/core/pattern/NodeCondition;Ljava/util/List;ZZILcom/uxsense/core/pattern/ValueSource;Ljava/util/List;)Lcom/uxsense/core/pattern/ViewPattern$NodePatternSurrogate;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/core/pattern/ViewPattern$NodePatternSurrogate;LA9/d;Lz9/g;)V", "write$Self", "Ljava/lang/String;", "getName", "getName$annotations", "()V", "Lcom/uxsense/core/pattern/NodeCondition;", "getCondition", "Ljava/util/List;", "getChildren", "Z", "getOptional", "getOptional$annotations", "getCaptureChildren", "getCaptureChildren$annotations", "I", "getDepth", "getDepth$annotations", "Lcom/uxsense/core/pattern/ValueSource;", "getValueSource", "getValueSource$annotations", "getTriggers", "getTriggers$annotations", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class NodePatternSurrogate {
        private static final f[] $childSerializers;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean captureChildren;
        private final List<ViewPattern> children;
        private final NodeCondition condition;
        private final int depth;
        private final String name;
        private final boolean optional;
        private final List<ViewTrigger> triggers;
        private final ValueSource valueSource;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$NodePatternSurrogate$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lcom/uxsense/core/pattern/ViewPattern$NodePattern;", "pattern", "Lcom/uxsense/core/pattern/ViewPattern$NodePatternSurrogate;", "fromNodePattern", "(Lcom/uxsense/core/pattern/ViewPattern$NodePattern;)Lcom/uxsense/core/pattern/ViewPattern$NodePatternSurrogate;", "Lx9/b;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            public final NodePatternSurrogate fromNodePattern(NodePattern pattern) {
                k.f(pattern, "pattern");
                return new NodePatternSurrogate(NodePatternBuilderKt.isAnonymousName(pattern.getName()) ? null : pattern.getName(), pattern.getCondition(), pattern.getChildren(), pattern.getOptional(), pattern.getCaptureChildren(), pattern.getDepth(), pattern.getValueSource(), pattern.getTriggers());
            }

            public final b serializer() {
                return ViewPattern$NodePatternSurrogate$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        static {
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
            $childSerializers = new f[]{null, null, kotlin.a.b(lazyThreadSafetyMode, new a(0)), null, null, null, kotlin.a.b(lazyThreadSafetyMode, new a(1)), kotlin.a.b(lazyThreadSafetyMode, new a(2))};
        }

        public NodePatternSurrogate() {
            this((String) null, (NodeCondition) null, (List) null, false, false, 0, (ValueSource) null, (List) null, 255, (e) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ b _childSerializers$_anonymous_() {
            return new C0177d(ViewPattern.INSTANCE.serializer());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ b _childSerializers$_anonymous_$0() {
            return ValueSource.INSTANCE.serializer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ b _childSerializers$_anonymous_$1() {
            return new C0177d(ViewTrigger.INSTANCE.serializer());
        }

        public static /* synthetic */ NodePatternSurrogate copy$default(NodePatternSurrogate nodePatternSurrogate, String str, NodeCondition nodeCondition, List list, boolean z10, boolean z11, int i, ValueSource valueSource, List list2, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                str = nodePatternSurrogate.name;
            }
            if ((i6 & 2) != 0) {
                nodeCondition = nodePatternSurrogate.condition;
            }
            if ((i6 & 4) != 0) {
                list = nodePatternSurrogate.children;
            }
            if ((i6 & 8) != 0) {
                z10 = nodePatternSurrogate.optional;
            }
            if ((i6 & 16) != 0) {
                z11 = nodePatternSurrogate.captureChildren;
            }
            if ((i6 & 32) != 0) {
                i = nodePatternSurrogate.depth;
            }
            if ((i6 & 64) != 0) {
                valueSource = nodePatternSurrogate.valueSource;
            }
            if ((i6 & 128) != 0) {
                list2 = nodePatternSurrogate.triggers;
            }
            ValueSource valueSource2 = valueSource;
            List list3 = list2;
            boolean z12 = z11;
            int i10 = i;
            return nodePatternSurrogate.copy(str, nodeCondition, list, z10, z12, i10, valueSource2, list3);
        }

        public static /* synthetic */ void getCaptureChildren$annotations() {
        }

        public static /* synthetic */ void getDepth$annotations() {
        }

        public static /* synthetic */ void getName$annotations() {
        }

        public static /* synthetic */ void getOptional$annotations() {
        }

        public static /* synthetic */ void getTriggers$annotations() {
        }

        public static /* synthetic */ void getValueSource$annotations() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0061  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final void write$Self$uxsense_release(com.uxsense.core.pattern.ViewPattern.NodePatternSurrogate r40, A9.d r41, z9.g r42) {
            /*
                r0 = r40
                r1 = r41
                r2 = r42
                C7.f[] r3 = com.uxsense.core.pattern.ViewPattern.NodePatternSurrogate.$childSerializers
                java.lang.String r4 = r0.name
                if (r4 == 0) goto L12
                r5 = 0
                B9.h0 r6 = B9.h0.f242a
                r1.encodeNullableSerializableElement(r2, r5, r6, r4)
            L12:
                r4 = 1
                boolean r5 = r1.shouldEncodeElementDefault(r2, r4)
                if (r5 == 0) goto L1a
                goto L61
            L1a:
                com.uxsense.core.pattern.NodeCondition r5 = r0.condition
                com.uxsense.core.pattern.NodeCondition r6 = new com.uxsense.core.pattern.NodeCondition
                r38 = 2147483647(0x7fffffff, float:NaN)
                r39 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r20 = 0
                r21 = 0
                r22 = 0
                r23 = 0
                r24 = 0
                r25 = 0
                r26 = 0
                r27 = 0
                r28 = 0
                r29 = 0
                r30 = 0
                r31 = 0
                r32 = 0
                r33 = 0
                r34 = 0
                r35 = 0
                r36 = 0
                r37 = 0
                r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)
                boolean r5 = kotlin.jvm.internal.k.b(r5, r6)
                if (r5 != 0) goto L68
            L61:
                com.uxsense.core.pattern.NodeCondition$$serializer r5 = com.uxsense.core.pattern.NodeCondition$$serializer.INSTANCE
                com.uxsense.core.pattern.NodeCondition r6 = r0.condition
                r1.encodeSerializableElement(r2, r4, r5, r6)
            L68:
                r5 = 2
                boolean r6 = r1.shouldEncodeElementDefault(r2, r5)
                if (r6 == 0) goto L70
                goto L7a
            L70:
                java.util.List<com.uxsense.core.pattern.ViewPattern> r6 = r0.children
                kotlin.collections.EmptyList r7 = kotlin.collections.EmptyList.f4893a
                boolean r6 = kotlin.jvm.internal.k.b(r6, r7)
                if (r6 != 0) goto L87
            L7a:
                r6 = r3[r5]
                java.lang.Object r6 = r6.getF4884a()
                x9.f r6 = (x9.f) r6
                java.util.List<com.uxsense.core.pattern.ViewPattern> r7 = r0.children
                r1.encodeSerializableElement(r2, r5, r6, r7)
            L87:
                boolean r5 = r0.optional
                if (r5 == 0) goto L8f
                r6 = 3
                r1.encodeBooleanElement(r2, r6, r5)
            L8f:
                boolean r5 = r0.captureChildren
                if (r5 == 0) goto L97
                r6 = 4
                r1.encodeBooleanElement(r2, r6, r5)
            L97:
                int r5 = r0.depth
                if (r5 == r4) goto L9f
                r4 = 5
                r1.encodeIntElement(r2, r4, r5)
            L9f:
                com.uxsense.core.pattern.ValueSource r4 = r0.valueSource
                com.uxsense.core.pattern.ValueSource r5 = com.uxsense.core.pattern.ValueSource.TEXT
                if (r4 == r5) goto Lb3
                r4 = 6
                r5 = r3[r4]
                java.lang.Object r5 = r5.getF4884a()
                x9.f r5 = (x9.f) r5
                com.uxsense.core.pattern.ValueSource r6 = r0.valueSource
                r1.encodeSerializableElement(r2, r4, r5, r6)
            Lb3:
                java.util.List<com.uxsense.core.model.ViewTrigger> r4 = r0.triggers
                kotlin.collections.EmptyList r5 = kotlin.collections.EmptyList.f4893a
                boolean r4 = kotlin.jvm.internal.k.b(r4, r5)
                if (r4 != 0) goto Lcb
                r4 = 7
                r3 = r3[r4]
                java.lang.Object r3 = r3.getF4884a()
                x9.f r3 = (x9.f) r3
                java.util.List<com.uxsense.core.model.ViewTrigger> r0 = r0.triggers
                r1.encodeSerializableElement(r2, r4, r3, r0)
            Lcb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.pattern.ViewPattern.NodePatternSurrogate.write$Self$uxsense_release(com.uxsense.core.pattern.ViewPattern$NodePatternSurrogate, A9.d, z9.g):void");
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final NodeCondition getCondition() {
            return this.condition;
        }

        public final List<ViewPattern> component3() {
            return this.children;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getOptional() {
            return this.optional;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getCaptureChildren() {
            return this.captureChildren;
        }

        /* renamed from: component6, reason: from getter */
        public final int getDepth() {
            return this.depth;
        }

        /* renamed from: component7, reason: from getter */
        public final ValueSource getValueSource() {
            return this.valueSource;
        }

        public final List<ViewTrigger> component8() {
            return this.triggers;
        }

        public final NodePatternSurrogate copy(String name, NodeCondition condition, List<? extends ViewPattern> children, boolean optional, boolean captureChildren, int depth, ValueSource valueSource, List<? extends ViewTrigger> triggers) {
            k.f(condition, "condition");
            k.f(children, "children");
            k.f(valueSource, "valueSource");
            k.f(triggers, "triggers");
            return new NodePatternSurrogate(name, condition, children, optional, captureChildren, depth, valueSource, triggers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NodePatternSurrogate)) {
                return false;
            }
            NodePatternSurrogate nodePatternSurrogate = (NodePatternSurrogate) other;
            return k.b(this.name, nodePatternSurrogate.name) && k.b(this.condition, nodePatternSurrogate.condition) && k.b(this.children, nodePatternSurrogate.children) && this.optional == nodePatternSurrogate.optional && this.captureChildren == nodePatternSurrogate.captureChildren && this.depth == nodePatternSurrogate.depth && this.valueSource == nodePatternSurrogate.valueSource && k.b(this.triggers, nodePatternSurrogate.triggers);
        }

        public final boolean getCaptureChildren() {
            return this.captureChildren;
        }

        public final List<ViewPattern> getChildren() {
            return this.children;
        }

        public final NodeCondition getCondition() {
            return this.condition;
        }

        public final int getDepth() {
            return this.depth;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getOptional() {
            return this.optional;
        }

        public final List<ViewTrigger> getTriggers() {
            return this.triggers;
        }

        public final ValueSource getValueSource() {
            return this.valueSource;
        }

        public int hashCode() {
            String str = this.name;
            return this.triggers.hashCode() + ((this.valueSource.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.depth, androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.e(this.children, (this.condition.hashCode() + ((str == null ? 0 : str.hashCode()) * 31)) * 31, 31), 31, this.optional), 31, this.captureChildren), 31)) * 31);
        }

        public final NodePattern toNodePattern() {
            String strGenerateNodeName = this.name;
            if (strGenerateNodeName == null) {
                strGenerateNodeName = NodePatternBuilderKt.generateNodeName();
            }
            return new NodePattern(strGenerateNodeName, this.condition, this.children, this.optional, this.captureChildren, this.depth, this.valueSource, this.triggers);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("NodePatternSurrogate(name=");
            sb.append(this.name);
            sb.append(", condition=");
            sb.append(this.condition);
            sb.append(", children=");
            sb.append(this.children);
            sb.append(", optional=");
            sb.append(this.optional);
            sb.append(", captureChildren=");
            sb.append(this.captureChildren);
            sb.append(", depth=");
            sb.append(this.depth);
            sb.append(", valueSource=");
            sb.append(this.valueSource);
            sb.append(", triggers=");
            return B7.a.r(sb, this.triggers, ')');
        }

        public NodePatternSurrogate(int i, String str, NodeCondition nodeCondition, List list, boolean z10, boolean z11, int i6, ValueSource valueSource, List list2, d0 d0Var) {
            this.name = (i & 1) == 0 ? null : str;
            if ((i & 2) == 0) {
                this.condition = new NodeCondition((String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Float) null, (Float) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, Integer.MAX_VALUE, (e) null);
            } else {
                this.condition = nodeCondition;
            }
            this.children = (i & 4) == 0 ? EmptyList.f4893a : list;
            if ((i & 8) == 0) {
                this.optional = false;
            } else {
                this.optional = z10;
            }
            if ((i & 16) == 0) {
                this.captureChildren = false;
            } else {
                this.captureChildren = z11;
            }
            this.depth = (i & 32) == 0 ? 1 : i6;
            this.valueSource = (i & 64) == 0 ? ValueSource.TEXT : valueSource;
            this.triggers = (i & 128) == 0 ? EmptyList.f4893a : list2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public NodePatternSurrogate(String str, NodeCondition condition, List<? extends ViewPattern> children, boolean z10, boolean z11, int i, ValueSource valueSource, List<? extends ViewTrigger> triggers) {
            k.f(condition, "condition");
            k.f(children, "children");
            k.f(valueSource, "valueSource");
            k.f(triggers, "triggers");
            this.name = str;
            this.condition = condition;
            this.children = children;
            this.optional = z10;
            this.captureChildren = z11;
            this.depth = i;
            this.valueSource = valueSource;
            this.triggers = triggers;
        }

        public NodePatternSurrogate(String str, NodeCondition nodeCondition, List list, boolean z10, boolean z11, int i, ValueSource valueSource, List list2, int i6, e eVar) {
            this((i6 & 1) != 0 ? null : str, (i6 & 2) != 0 ? new NodeCondition((String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Float) null, (Float) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, Integer.MAX_VALUE, (e) null) : nodeCondition, (i6 & 4) != 0 ? EmptyList.f4893a : list, (i6 & 8) != 0 ? false : z10, (i6 & 16) == 0 ? z11 : false, (i6 & 32) != 0 ? 1 : i, (i6 & 64) != 0 ? ValueSource.TEXT : valueSource, (i6 & 128) != 0 ? EmptyList.f4893a : list2);
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002.-B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ \u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b)\u0010*R\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010\u001f¨\u0006/"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$NoneOf;", "Lcom/uxsense/core/pattern/ViewPattern;", "", "patterns", AppAgent.CONSTRUCT, "(Ljava/util/List;)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILjava/util/List;LB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/core/pattern/ViewPattern$NoneOf;LA9/d;Lz9/g;)V", "write$Self", "Lcom/uxsense/core/base/parse/KViewNode;", "node", "Lcom/uxsense/core/pattern/MatchContext;", "context", "Lcom/uxsense/core/pattern/PatternMatchResult;", "match", "(Lcom/uxsense/core/base/parse/KViewNode;Lcom/uxsense/core/pattern/MatchContext;)Lcom/uxsense/core/pattern/PatternMatchResult;", "", "isOptional", "()Z", "component1", "()Ljava/util/List;", "copy", "(Ljava/util/List;)Lcom/uxsense/core/pattern/ViewPattern$NoneOf;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getPatterns", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class NoneOf extends ViewPattern {
        private final List<ViewPattern> patterns;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final f[] $childSerializers = {kotlin.a.b(LazyThreadSafetyMode.b, new a(10))};

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$NoneOf$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/core/pattern/ViewPattern$NoneOf;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final b serializer() {
                return ViewPattern$NoneOf$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(e eVar) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NoneOf(int i, List list, d0 d0Var) {
            super(i, d0Var);
            if (1 != (i & 1)) {
                T.g(ViewPattern$NoneOf$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
            this.patterns = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ b _childSerializers$_anonymous_() {
            return new C0177d(ViewPattern.INSTANCE.serializer());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NoneOf copy$default(NoneOf noneOf, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = noneOf.patterns;
            }
            return noneOf.copy(list);
        }

        public static final /* synthetic */ void write$Self$uxsense_release(NoneOf self, d output, g serialDesc) {
            ViewPattern.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, (x9.f) $childSerializers[0].getF4884a(), self.patterns);
        }

        public final List<ViewPattern> component1() {
            return this.patterns;
        }

        public final NoneOf copy(List<? extends ViewPattern> patterns) {
            k.f(patterns, "patterns");
            return new NoneOf(patterns);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NoneOf) && k.b(this.patterns, ((NoneOf) other).patterns);
        }

        public final List<ViewPattern> getPatterns() {
            return this.patterns;
        }

        public int hashCode() {
            return this.patterns.hashCode();
        }

        @Override // com.uxsense.core.pattern.ViewPattern
        public boolean isOptional() {
            return false;
        }

        @Override // com.uxsense.core.pattern.ViewPattern
        public PatternMatchResult match(KViewNode node, MatchContext context) {
            k.f(node, "node");
            k.f(context, "context");
            for (ViewPattern viewPattern : this.patterns) {
                if (viewPattern instanceof NodePattern) {
                    StringBuilder sb = new StringBuilder("noneOf NodePattern ");
                    NodePattern nodePattern = (NodePattern) viewPattern;
                    sb.append(nodePattern.getName());
                    ApexLogger.d$default("ViewPattern", sb.toString(), null, 4, null);
                    Iterator<KViewNode> it = node.getChildren().iterator();
                    while (it.hasNext()) {
                        if (nodePattern.match(it.next(), context) != null) {
                            return null;
                        }
                    }
                } else {
                    ApexLogger.d$default("ViewPattern", "noneOf " + m.f4928a.b(viewPattern.getClass()).m(), null, 4, null);
                    if (viewPattern.match(node, context) != null) {
                        return null;
                    }
                }
            }
            return new PatternMatchResult(kotlin.collections.a.M(), null, null, 6, null);
        }

        public String toString() {
            return B7.a.r(new StringBuilder("NoneOf(patterns="), this.patterns, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public NoneOf(List<? extends ViewPattern> patterns) {
            super(null);
            k.f(patterns, "patterns");
            this.patterns = patterns;
        }
    }

    public /* synthetic */ ViewPattern(e eVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b _init_$_anonymous_() {
        n nVar = m.f4928a;
        return new x9.e("com.uxsense.core.pattern.ViewPattern", nVar.b(ViewPattern.class), new Z7.d[]{nVar.b(AnyOf.class), nVar.b(Branches.class), nVar.b(ConditionalGroup.class), nVar.b(NodePattern.class), nVar.b(NoneOf.class)}, new b[]{ViewPattern$AnyOf$$serializer.INSTANCE, ViewPattern$Branches$$serializer.INSTANCE, ViewPattern$ConditionalGroup$$serializer.INSTANCE, NodePatternSerializer.INSTANCE, ViewPattern$NoneOf$$serializer.INSTANCE}, new Annotation[0]);
    }

    public static /* synthetic */ PatternMatchResult match$default(ViewPattern viewPattern, KViewNode kViewNode, MatchContext matchContext, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: match");
        }
        if ((i & 2) != 0) {
            matchContext = new MatchContext(null, false, 0, null, 15, null);
        }
        return viewPattern.match(kViewNode, matchContext);
    }

    public static final /* synthetic */ void write$Self(ViewPattern self, d output, g serialDesc) {
    }

    public abstract boolean isOptional();

    public abstract PatternMatchResult match(KViewNode node, MatchContext context);

    private ViewPattern() {
    }

    public /* synthetic */ ViewPattern(int i, d0 d0Var) {
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00020\u0001:\u00016Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\tH\u0016J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\t\u0010.\u001a\u00020\u000eHÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007HÆ\u0003Je\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007HÆ\u0001J\u0013\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\fHÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018¨\u00067"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$NodePattern;", "Lcom/uxsense/core/pattern/ViewPattern;", HintConstants.AUTOFILL_HINT_NAME, "", "condition", "Lcom/uxsense/core/pattern/NodeCondition;", "children", "", "optional", "", "captureChildren", "depth", "", "valueSource", "Lcom/uxsense/core/pattern/ValueSource;", "triggers", "Lcom/uxsense/core/model/ViewTrigger;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/uxsense/core/pattern/NodeCondition;Ljava/util/List;ZZILcom/uxsense/core/pattern/ValueSource;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getCondition", "()Lcom/uxsense/core/pattern/NodeCondition;", "getChildren", "()Ljava/util/List;", "getOptional", "()Z", "getCaptureChildren", "getDepth", "()I", "getValueSource", "()Lcom/uxsense/core/pattern/ValueSource;", "getTriggers", "match", "Lcom/uxsense/core/pattern/PatternMatchResult;", "node", "Lcom/uxsense/core/base/parse/KViewNode;", "context", "Lcom/uxsense/core/pattern/MatchContext;", "isOptional", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class NodePattern extends ViewPattern {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean captureChildren;
        private final List<ViewPattern> children;
        private final NodeCondition condition;
        private final int depth;
        private final String name;
        private final boolean optional;
        private final List<ViewTrigger> triggers;
        private final ValueSource valueSource;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/core/pattern/ViewPattern$NodePattern$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/core/pattern/ViewPattern$NodePattern;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final b serializer() {
                return NodePatternSerializer.INSTANCE;
            }

            public /* synthetic */ Companion(e eVar) {
                this();
            }
        }

        public NodePattern(String str, NodeCondition nodeCondition, List list, boolean z10, boolean z11, int i, ValueSource valueSource, List list2, int i6, e eVar) {
            this(str, (i6 & 2) != 0 ? new NodeCondition((String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Float) null, (Float) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, Integer.MAX_VALUE, (e) null) : nodeCondition, (i6 & 4) != 0 ? EmptyList.f4893a : list, (i6 & 8) != 0 ? false : z10, (i6 & 16) == 0 ? z11 : false, (i6 & 32) != 0 ? 1 : i, (i6 & 64) != 0 ? ValueSource.TEXT_OR_DESC : valueSource, (i6 & 128) != 0 ? EmptyList.f4893a : list2);
        }

        public static /* synthetic */ NodePattern copy$default(NodePattern nodePattern, String str, NodeCondition nodeCondition, List list, boolean z10, boolean z11, int i, ValueSource valueSource, List list2, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                str = nodePattern.name;
            }
            if ((i6 & 2) != 0) {
                nodeCondition = nodePattern.condition;
            }
            if ((i6 & 4) != 0) {
                list = nodePattern.children;
            }
            if ((i6 & 8) != 0) {
                z10 = nodePattern.optional;
            }
            if ((i6 & 16) != 0) {
                z11 = nodePattern.captureChildren;
            }
            if ((i6 & 32) != 0) {
                i = nodePattern.depth;
            }
            if ((i6 & 64) != 0) {
                valueSource = nodePattern.valueSource;
            }
            if ((i6 & 128) != 0) {
                list2 = nodePattern.triggers;
            }
            ValueSource valueSource2 = valueSource;
            List list3 = list2;
            boolean z12 = z11;
            int i10 = i;
            return nodePattern.copy(str, nodeCondition, list, z10, z12, i10, valueSource2, list3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final NodeCondition getCondition() {
            return this.condition;
        }

        public final List<ViewPattern> component3() {
            return this.children;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getOptional() {
            return this.optional;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getCaptureChildren() {
            return this.captureChildren;
        }

        /* renamed from: component6, reason: from getter */
        public final int getDepth() {
            return this.depth;
        }

        /* renamed from: component7, reason: from getter */
        public final ValueSource getValueSource() {
            return this.valueSource;
        }

        public final List<ViewTrigger> component8() {
            return this.triggers;
        }

        public final NodePattern copy(String name, NodeCondition condition, List<? extends ViewPattern> children, boolean optional, boolean captureChildren, int depth, ValueSource valueSource, List<? extends ViewTrigger> triggers) {
            k.f(name, "name");
            k.f(condition, "condition");
            k.f(children, "children");
            k.f(valueSource, "valueSource");
            k.f(triggers, "triggers");
            return new NodePattern(name, condition, children, optional, captureChildren, depth, valueSource, triggers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NodePattern)) {
                return false;
            }
            NodePattern nodePattern = (NodePattern) other;
            return k.b(this.name, nodePattern.name) && k.b(this.condition, nodePattern.condition) && k.b(this.children, nodePattern.children) && this.optional == nodePattern.optional && this.captureChildren == nodePattern.captureChildren && this.depth == nodePattern.depth && this.valueSource == nodePattern.valueSource && k.b(this.triggers, nodePattern.triggers);
        }

        public final boolean getCaptureChildren() {
            return this.captureChildren;
        }

        public final List<ViewPattern> getChildren() {
            return this.children;
        }

        public final NodeCondition getCondition() {
            return this.condition;
        }

        public final int getDepth() {
            return this.depth;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getOptional() {
            return this.optional;
        }

        public final List<ViewTrigger> getTriggers() {
            return this.triggers;
        }

        public final ValueSource getValueSource() {
            return this.valueSource;
        }

        public int hashCode() {
            return this.triggers.hashCode() + ((this.valueSource.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.depth, androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.e(this.children, (this.condition.hashCode() + (this.name.hashCode() * 31)) * 31, 31), 31, this.optional), 31, this.captureChildren), 31)) * 31);
        }

        @Override // com.uxsense.core.pattern.ViewPattern
        public boolean isOptional() {
            return this.optional;
        }

        @Override // com.uxsense.core.pattern.ViewPattern
        public PatternMatchResult match(KViewNode node, MatchContext context) {
            k.f(node, "node");
            k.f(context, "context");
            boolean zMatches = NodeConditionKt.matches(this.condition, node, context.getCustomPredicates());
            ApexLogger.d$default("ViewPattern", "[" + this.name + "] " + zMatches + " => " + node.getClassName() + ", valueSource=" + this.valueSource, null, 4, null);
            if (!zMatches) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            linkedHashMap.put(this.name, node);
            linkedHashMap2.put(this.name, this.valueSource);
            if (!this.triggers.isEmpty()) {
                linkedHashMap3.put(this.name, this.triggers);
            }
            if (!this.children.isEmpty()) {
                int i = this.depth;
                ChildMatchResult childMatchResultMatchChildren = ViewPatternKt.matchChildren(i == 1 ? node.getChildren() : ViewPatternKt.getAllDescendants(node, i), this.children, context.withParentNode(node));
                if (childMatchResultMatchChildren != null) {
                    linkedHashMap.putAll(childMatchResultMatchChildren.getNodes());
                    linkedHashMap2.putAll(childMatchResultMatchChildren.getValueSources());
                    linkedHashMap3.putAll(childMatchResultMatchChildren.getTriggers());
                } else if (!this.optional) {
                    return null;
                }
            }
            if (this.captureChildren) {
                int i6 = 0;
                for (Object obj : node.getChildren()) {
                    int i10 = i6 + 1;
                    if (i6 < 0) {
                        o.X();
                        throw null;
                    }
                    linkedHashMap.put(this.name + "_child_" + i6, (KViewNode) obj);
                    i6 = i10;
                }
            }
            return new PatternMatchResult(linkedHashMap, linkedHashMap2, linkedHashMap3);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("NodePattern(name=");
            sb.append(this.name);
            sb.append(", condition=");
            sb.append(this.condition);
            sb.append(", children=");
            sb.append(this.children);
            sb.append(", optional=");
            sb.append(this.optional);
            sb.append(", captureChildren=");
            sb.append(this.captureChildren);
            sb.append(", depth=");
            sb.append(this.depth);
            sb.append(", valueSource=");
            sb.append(this.valueSource);
            sb.append(", triggers=");
            return B7.a.r(sb, this.triggers, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public NodePattern(String name, NodeCondition condition, List<? extends ViewPattern> children, boolean z10, boolean z11, int i, ValueSource valueSource, List<? extends ViewTrigger> triggers) {
            super(null);
            k.f(name, "name");
            k.f(condition, "condition");
            k.f(children, "children");
            k.f(valueSource, "valueSource");
            k.f(triggers, "triggers");
            this.name = name;
            this.condition = condition;
            this.children = children;
            this.optional = z10;
            this.captureChildren = z11;
            this.depth = i;
            this.valueSource = valueSource;
            this.triggers = triggers;
        }
    }
}
