package com.uxsense.parse;

import A9.d;
import B9.S;
import B9.T;
import B9.d0;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.annotation.Annotation;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import z9.g;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00112\u00020\u0001:\u0007\u0012\u0013\u0014\u0015\u0016\u0017\u0011B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0002\u0010\bJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0001\u0006\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/uxsense/parse/IdSource;", "", AppAgent.CONSTRUCT, "()V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self", "(Lcom/uxsense/parse/IdSource;LA9/d;Lz9/g;)V", "Companion", "AutoGenerate", "FromNode", "FromContext", "FromNickname", "Fixed", "FromSearch", "Lcom/uxsense/parse/IdSource$AutoGenerate;", "Lcom/uxsense/parse/IdSource$Fixed;", "Lcom/uxsense/parse/IdSource$FromContext;", "Lcom/uxsense/parse/IdSource$FromNickname;", "Lcom/uxsense/parse/IdSource$FromNode;", "Lcom/uxsense/parse/IdSource$FromSearch;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class IdSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final f $cachedSerializer$delegate = kotlin.a.b(LazyThreadSafetyMode.b, new com.uxsense.base.metadata.a(22));

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/uxsense/parse/IdSource$AutoGenerate;", "Lcom/uxsense/parse/IdSource;", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "serializer", "()Lx9/b;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class AutoGenerate extends IdSource {
        public static final AutoGenerate INSTANCE = new AutoGenerate();
        private static final /* synthetic */ f $cachedSerializer$delegate = kotlin.a.b(LazyThreadSafetyMode.b, new com.uxsense.base.metadata.a(23));

        private AutoGenerate() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ x9.b _init_$_anonymous_() {
            return new S("com.uxsense.parse.IdSource.AutoGenerate", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ x9.b get$cachedSerializer() {
            return (x9.b) $cachedSerializer$delegate.getF4884a();
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof AutoGenerate);
        }

        public int hashCode() {
            return -1319439695;
        }

        public final x9.b serializer() {
            return get$cachedSerializer();
        }

        public String toString() {
            return "AutoGenerate";
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/parse/IdSource$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/parse/IdSource;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ x9.b get$cachedSerializer() {
            return (x9.b) IdSource.$cachedSerializer$delegate.getF4884a();
        }

        public final x9.b serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002%$B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0015¨\u0006&"}, d2 = {"Lcom/uxsense/parse/IdSource$Fixed;", "Lcom/uxsense/parse/IdSource;", "", "value", AppAgent.CONSTRUCT, "(J)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(IJLB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/parse/IdSource$Fixed;LA9/d;Lz9/g;)V", "write$Self", "component1", "()J", "copy", "(J)Lcom/uxsense/parse/IdSource$Fixed;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getValue", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Fixed extends IdSource {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/parse/IdSource$Fixed$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/parse/IdSource$Fixed;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final x9.b serializer() {
                return IdSource$Fixed$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(e eVar) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Fixed(int i, long j5, d0 d0Var) {
            super(i, d0Var);
            if (1 != (i & 1)) {
                T.g(IdSource$Fixed$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
            this.value = j5;
        }

        public static /* synthetic */ Fixed copy$default(Fixed fixed, long j5, int i, Object obj) {
            if ((i & 1) != 0) {
                j5 = fixed.value;
            }
            return fixed.copy(j5);
        }

        public static final /* synthetic */ void write$Self$uxsense_release(Fixed self, d output, g serialDesc) {
            IdSource.write$Self(self, output, serialDesc);
            output.encodeLongElement(serialDesc, 0, self.value);
        }

        /* renamed from: component1, reason: from getter */
        public final long getValue() {
            return this.value;
        }

        public final Fixed copy(long value) {
            return new Fixed(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Fixed) && this.value == ((Fixed) other).value;
        }

        public final long getValue() {
            return this.value;
        }

        public int hashCode() {
            return Long.hashCode(this.value);
        }

        public String toString() {
            return B7.a.p(new StringBuilder("Fixed(value="), this.value, ')');
        }

        public Fixed(long j5) {
            super(null);
            this.value = j5;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/uxsense/parse/IdSource$FromContext;", "Lcom/uxsense/parse/IdSource;", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "serializer", "()Lx9/b;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class FromContext extends IdSource {
        public static final FromContext INSTANCE = new FromContext();
        private static final /* synthetic */ f $cachedSerializer$delegate = kotlin.a.b(LazyThreadSafetyMode.b, new com.uxsense.base.metadata.a(24));

        private FromContext() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ x9.b _init_$_anonymous_() {
            return new S("com.uxsense.parse.IdSource.FromContext", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ x9.b get$cachedSerializer() {
            return (x9.b) $cachedSerializer$delegate.getF4884a();
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof FromContext);
        }

        public int hashCode() {
            return 362309272;
        }

        public final x9.b serializer() {
            return get$cachedSerializer();
        }

        public String toString() {
            return "FromContext";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/uxsense/parse/IdSource$FromNickname;", "Lcom/uxsense/parse/IdSource;", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "serializer", "()Lx9/b;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class FromNickname extends IdSource {
        public static final FromNickname INSTANCE = new FromNickname();
        private static final /* synthetic */ f $cachedSerializer$delegate = kotlin.a.b(LazyThreadSafetyMode.b, new com.uxsense.base.metadata.a(25));

        private FromNickname() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ x9.b _init_$_anonymous_() {
            return new S("com.uxsense.parse.IdSource.FromNickname", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ x9.b get$cachedSerializer() {
            return (x9.b) $cachedSerializer$delegate.getF4884a();
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof FromNickname);
        }

        public int hashCode() {
            return -1015311195;
        }

        public final x9.b serializer() {
            return get$cachedSerializer();
        }

        public String toString() {
            return "FromNickname";
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0015J\u0010\u0010\u0019\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0015¨\u0006$"}, d2 = {"Lcom/uxsense/parse/IdSource$FromNode;", "Lcom/uxsense/parse/IdSource;", "", "nodeName", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILjava/lang/String;LB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/parse/IdSource$FromNode;LA9/d;Lz9/g;)V", "write$Self", "component1", "()Ljava/lang/String;", "copy", "(Ljava/lang/String;)Lcom/uxsense/parse/IdSource$FromNode;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getNodeName", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class FromNode extends IdSource {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String nodeName;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/parse/IdSource$FromNode$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/parse/IdSource$FromNode;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final x9.b serializer() {
                return IdSource$FromNode$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(e eVar) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FromNode(int i, String str, d0 d0Var) {
            super(i, d0Var);
            if (1 != (i & 1)) {
                T.g(IdSource$FromNode$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
            this.nodeName = str;
        }

        public static /* synthetic */ FromNode copy$default(FromNode fromNode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fromNode.nodeName;
            }
            return fromNode.copy(str);
        }

        public static final /* synthetic */ void write$Self$uxsense_release(FromNode self, d output, g serialDesc) {
            IdSource.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.nodeName);
        }

        /* renamed from: component1, reason: from getter */
        public final String getNodeName() {
            return this.nodeName;
        }

        public final FromNode copy(String nodeName) {
            k.f(nodeName, "nodeName");
            return new FromNode(nodeName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FromNode) && k.b(this.nodeName, ((FromNode) other).nodeName);
        }

        public final String getNodeName() {
            return this.nodeName;
        }

        public int hashCode() {
            return this.nodeName.hashCode();
        }

        public String toString() {
            return B7.a.g(')', this.nodeName, new StringBuilder("FromNode(nodeName="));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FromNode(String nodeName) {
            super(null);
            k.f(nodeName, "nodeName");
            this.nodeName = nodeName;
        }
    }

    public /* synthetic */ IdSource(e eVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x9.b _init_$_anonymous_() {
        n nVar = m.f4928a;
        return new x9.e("com.uxsense.parse.IdSource", nVar.b(IdSource.class), new Z7.d[]{nVar.b(AutoGenerate.class), nVar.b(Fixed.class), nVar.b(FromContext.class), nVar.b(FromNickname.class), nVar.b(FromNode.class), nVar.b(FromSearch.class)}, new x9.b[]{new S("com.uxsense.parse.IdSource.AutoGenerate", AutoGenerate.INSTANCE, new Annotation[0]), IdSource$Fixed$$serializer.INSTANCE, new S("com.uxsense.parse.IdSource.FromContext", FromContext.INSTANCE, new Annotation[0]), new S("com.uxsense.parse.IdSource.FromNickname", FromNickname.INSTANCE, new Annotation[0]), IdSource$FromNode$$serializer.INSTANCE, IdSource$FromSearch$$serializer.INSTANCE}, new Annotation[0]);
    }

    public static final /* synthetic */ void write$Self(IdSource self, d output, g serialDesc) {
    }

    private IdSource() {
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002/.B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ.\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0019J\u0010\u0010!\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b-\u0010\u001d¨\u00060"}, d2 = {"Lcom/uxsense/parse/IdSource$FromSearch;", "Lcom/uxsense/parse/IdSource;", "", "queryNodeName", "Lcom/uxsense/parse/SearchType;", "searchType", "", "threshold", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/uxsense/parse/SearchType;F)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/uxsense/parse/SearchType;FLB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/parse/IdSource$FromSearch;LA9/d;Lz9/g;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Lcom/uxsense/parse/SearchType;", "component3", "()F", "copy", "(Ljava/lang/String;Lcom/uxsense/parse/SearchType;F)Lcom/uxsense/parse/IdSource$FromSearch;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getQueryNodeName", "Lcom/uxsense/parse/SearchType;", "getSearchType", "F", "getThreshold", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class FromSearch extends IdSource {
        private final String queryNodeName;
        private final SearchType searchType;
        private final float threshold;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final f[] $childSerializers = {null, kotlin.a.b(LazyThreadSafetyMode.b, new com.uxsense.base.metadata.a(26)), null};

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/parse/IdSource$FromSearch$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/parse/IdSource$FromSearch;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final x9.b serializer() {
                return IdSource$FromSearch$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(e eVar) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FromSearch(int i, String str, SearchType searchType, float f, d0 d0Var) {
            super(i, d0Var);
            if (1 != (i & 1)) {
                T.g(IdSource$FromSearch$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
            this.queryNodeName = str;
            if ((i & 2) == 0) {
                this.searchType = SearchType.CREATION;
            } else {
                this.searchType = searchType;
            }
            if ((i & 4) == 0) {
                this.threshold = 0.5f;
            } else {
                this.threshold = f;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ x9.b _childSerializers$_anonymous_() {
            return SearchType.INSTANCE.serializer();
        }

        public static /* synthetic */ FromSearch copy$default(FromSearch fromSearch, String str, SearchType searchType, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fromSearch.queryNodeName;
            }
            if ((i & 2) != 0) {
                searchType = fromSearch.searchType;
            }
            if ((i & 4) != 0) {
                f = fromSearch.threshold;
            }
            return fromSearch.copy(str, searchType, f);
        }

        public static final /* synthetic */ void write$Self$uxsense_release(FromSearch self, d output, g serialDesc) {
            IdSource.write$Self(self, output, serialDesc);
            f[] fVarArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.queryNodeName);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.searchType != SearchType.CREATION) {
                output.encodeSerializableElement(serialDesc, 1, (x9.f) fVarArr[1].getF4884a(), self.searchType);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && Float.compare(self.threshold, 0.5f) == 0) {
                return;
            }
            output.encodeFloatElement(serialDesc, 2, self.threshold);
        }

        /* renamed from: component1, reason: from getter */
        public final String getQueryNodeName() {
            return this.queryNodeName;
        }

        /* renamed from: component2, reason: from getter */
        public final SearchType getSearchType() {
            return this.searchType;
        }

        /* renamed from: component3, reason: from getter */
        public final float getThreshold() {
            return this.threshold;
        }

        public final FromSearch copy(String queryNodeName, SearchType searchType, float threshold) {
            k.f(queryNodeName, "queryNodeName");
            k.f(searchType, "searchType");
            return new FromSearch(queryNodeName, searchType, threshold);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FromSearch)) {
                return false;
            }
            FromSearch fromSearch = (FromSearch) other;
            return k.b(this.queryNodeName, fromSearch.queryNodeName) && this.searchType == fromSearch.searchType && Float.compare(this.threshold, fromSearch.threshold) == 0;
        }

        public final String getQueryNodeName() {
            return this.queryNodeName;
        }

        public final SearchType getSearchType() {
            return this.searchType;
        }

        public final float getThreshold() {
            return this.threshold;
        }

        public int hashCode() {
            return Float.hashCode(this.threshold) + ((this.searchType.hashCode() + (this.queryNodeName.hashCode() * 31)) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("FromSearch(queryNodeName=");
            sb.append(this.queryNodeName);
            sb.append(", searchType=");
            sb.append(this.searchType);
            sb.append(", threshold=");
            return androidx.appfunctions.metadata.a.n(sb, this.threshold, ')');
        }

        public /* synthetic */ FromSearch(String str, SearchType searchType, float f, int i, e eVar) {
            this(str, (i & 2) != 0 ? SearchType.CREATION : searchType, (i & 4) != 0 ? 0.5f : f);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FromSearch(String queryNodeName, SearchType searchType, float f) {
            super(null);
            k.f(queryNodeName, "queryNodeName");
            k.f(searchType, "searchType");
            this.queryNodeName = queryNodeName;
            this.searchType = searchType;
            this.threshold = f;
        }
    }

    public /* synthetic */ IdSource(int i, d0 d0Var) {
    }
}
