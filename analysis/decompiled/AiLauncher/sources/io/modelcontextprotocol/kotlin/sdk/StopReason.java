package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.modelcontextprotocol.kotlin.sdk.StopReason;
import java.lang.annotation.Annotation;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import p9.InterfaceC5063a;
import pb.C5130x0;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00062\u00020\u0001:\u0005\u0007\b\t\n\u0006R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/StopReason;", "", "", "getValue", "()Ljava/lang/String;", UxipConstants.f30680s, "Companion", "EndTurn", "StopSequence", "MaxTokens", "Other", "Lio/modelcontextprotocol/kotlin/sdk/StopReason$EndTurn;", "Lio/modelcontextprotocol/kotlin/sdk/StopReason$MaxTokens;", "Lio/modelcontextprotocol/kotlin/sdk/StopReason$Other;", "Lio/modelcontextprotocol/kotlin/sdk/StopReason$StopSequence;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l(with = StopReasonSerializer.class)
/* loaded from: classes4.dex */
public interface StopReason {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/StopReason$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/StopReason;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<StopReason> serializer() {
            return StopReasonSerializer.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000f8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/StopReason$EndTurn;", "Lio/modelcontextprotocol/kotlin/sdk/StopReason;", "<init>", "()V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lkotlinx/serialization/KSerializer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "toString", "()Ljava/lang/String;", UxipConstants.f30680s, "Ljava/lang/String;", "getValue", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final /* data */ class EndTurn implements StopReason {
        public static final EndTurn INSTANCE = new EndTurn();
        private static final String value = "endTurn";
        private static final /* synthetic */ Y8.h<KSerializer<Object>> $cachedSerializer$delegate = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.I
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StopReason.EndTurn._init_$_anonymous_();
            }
        });

        private EndTurn() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new C5130x0("io.modelcontextprotocol.kotlin.sdk.StopReason.EndTurn", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof EndTurn);
        }

        @Override // io.modelcontextprotocol.kotlin.sdk.StopReason
        public String getValue() {
            return value;
        }

        public int hashCode() {
            return 959342473;
        }

        public final KSerializer<EndTurn> serializer() {
            return get$cachedSerializer();
        }

        public String toString() {
            return "EndTurn";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000f8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/StopReason$MaxTokens;", "Lio/modelcontextprotocol/kotlin/sdk/StopReason;", "<init>", "()V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lkotlinx/serialization/KSerializer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "toString", "()Ljava/lang/String;", UxipConstants.f30680s, "Ljava/lang/String;", "getValue", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final /* data */ class MaxTokens implements StopReason {
        public static final MaxTokens INSTANCE = new MaxTokens();
        private static final String value = "maxTokens";
        private static final /* synthetic */ Y8.h<KSerializer<Object>> $cachedSerializer$delegate = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.J
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StopReason.MaxTokens._init_$_anonymous_();
            }
        });

        private MaxTokens() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new C5130x0("io.modelcontextprotocol.kotlin.sdk.StopReason.MaxTokens", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof MaxTokens);
        }

        @Override // io.modelcontextprotocol.kotlin.sdk.StopReason
        public String getValue() {
            return value;
        }

        public int hashCode() {
            return 613133167;
        }

        public final KSerializer<MaxTokens> serializer() {
            return get$cachedSerializer();
        }

        public String toString() {
            return "MaxTokens";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0087@\u0018\u0000 \u00122\u00020\u0001:\u0002\u0013\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u000f\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0014"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/StopReason$Other;", "Lio/modelcontextprotocol/kotlin/sdk/StopReason;", "", UxipConstants.f30680s, "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getValue", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final class Other implements StopReason {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/StopReason$Other$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/StopReason$Other;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Other> serializer() {
                return StopReason$Other$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        private /* synthetic */ Other(String str) {
            this.value = str;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Other m223boximpl(String str) {
            return new Other(str);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static String m224constructorimpl(String value) {
            kotlin.jvm.internal.p.i(value, "value");
            return value;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m225equalsimpl(String str, Object obj) {
            return (obj instanceof Other) && kotlin.jvm.internal.p.d(str, ((Other) obj).m229unboximpl());
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m226equalsimpl0(String str, String str2) {
            return kotlin.jvm.internal.p.d(str, str2);
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m227hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m228toStringimpl(String str) {
            return "Other(value=" + str + ')';
        }

        public boolean equals(Object other) {
            return m225equalsimpl(this.value, other);
        }

        @Override // io.modelcontextprotocol.kotlin.sdk.StopReason
        public String getValue() {
            return this.value;
        }

        public int hashCode() {
            return m227hashCodeimpl(this.value);
        }

        public String toString() {
            return m228toStringimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ String m229unboximpl() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000f8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/StopReason$StopSequence;", "Lio/modelcontextprotocol/kotlin/sdk/StopReason;", "<init>", "()V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lkotlinx/serialization/KSerializer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "toString", "()Ljava/lang/String;", UxipConstants.f30680s, "Ljava/lang/String;", "getValue", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final /* data */ class StopSequence implements StopReason {
        public static final StopSequence INSTANCE = new StopSequence();
        private static final String value = "stopSequence";
        private static final /* synthetic */ Y8.h<KSerializer<Object>> $cachedSerializer$delegate = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.K
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StopReason.StopSequence._init_$_anonymous_();
            }
        });

        private StopSequence() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new C5130x0("io.modelcontextprotocol.kotlin.sdk.StopReason.StopSequence", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof StopSequence);
        }

        @Override // io.modelcontextprotocol.kotlin.sdk.StopReason
        public String getValue() {
            return value;
        }

        public int hashCode() {
            return 811533554;
        }

        public final KSerializer<StopSequence> serializer() {
            return get$cachedSerializer();
        }

        public String toString() {
            return "StopSequence";
        }
    }

    String getValue();
}
