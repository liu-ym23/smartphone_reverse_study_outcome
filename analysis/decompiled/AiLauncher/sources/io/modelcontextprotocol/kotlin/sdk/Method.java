package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import io.modelcontextprotocol.kotlin.sdk.Method;
import io.modelcontextprotocol.spec.McpSchema;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import p9.InterfaceC5063a;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00062\u00020\u0001:\u0003\u0007\b\u0006R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\t\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/Method;", "", "", "getValue", "()Ljava/lang/String;", UxipConstants.f30680s, "Companion", "Defined", "Custom", "Lio/modelcontextprotocol/kotlin/sdk/Method$Custom;", "Lio/modelcontextprotocol/kotlin/sdk/Method$Defined;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l(with = RequestMethodSerializer.class)
/* loaded from: classes4.dex */
public interface Method {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/Method$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<Method> serializer() {
            return RequestMethodSerializer.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0015J\u0010\u0010\u0019\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0015¨\u0006$"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/Method$Custom;", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "", UxipConstants.f30680s, "<init>", "(Ljava/lang/String;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/Method$Custom;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;)Lio/modelcontextprotocol/kotlin/sdk/Method$Custom;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getValue", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final /* data */ class Custom implements Method {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/Method$Custom$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/Method$Custom;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Custom> serializer() {
                return Method$Custom$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        public /* synthetic */ Custom(int i10, String str, T0 t02) {
            if (1 != (i10 & 1)) {
                E0.a(i10, 1, Method$Custom$$serializer.INSTANCE.getDescriptor());
            }
            this.value = str;
        }

        public static /* synthetic */ Custom copy$default(Custom custom, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = custom.value;
            }
            return custom.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final Custom copy(String value) {
            kotlin.jvm.internal.p.i(value, "value");
            return new Custom(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Custom) && kotlin.jvm.internal.p.d(this.value, ((Custom) other).value);
        }

        @Override // io.modelcontextprotocol.kotlin.sdk.Method
        public String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Custom(value=" + this.value + ')';
        }

        public Custom(String value) {
            kotlin.jvm.internal.p.i(value, "value");
            this.value = value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b!\b\u0087\u0081\u0002\u0018\u0000 \n2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006$"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/Method$Defined;", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "", "", UxipConstants.f30680s, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "Initialize", "Ping", "ResourcesList", "ResourcesTemplatesList", "ResourcesRead", "ResourcesSubscribe", "ResourcesUnsubscribe", "PromptsList", "PromptsGet", "NotificationsCancelled", "NotificationsInitialized", "NotificationsProgress", "NotificationsMessage", "NotificationsResourcesUpdated", "NotificationsResourcesListChanged", "NotificationsToolsListChanged", "NotificationsRootsListChanged", "NotificationsPromptsListChanged", "ToolsList", "ToolsCall", "LoggingSetLevel", "SamplingCreateMessage", "CompletionComplete", "RootsList", "ElicitationCreate", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final class Defined implements Method {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Defined[] $VALUES;
        private static final Y8.h<KSerializer<Object>> $cachedSerializer$delegate;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String value;
        public static final Defined Initialize = new Defined("Initialize", 0, McpSchema.METHOD_INITIALIZE);
        public static final Defined Ping = new Defined("Ping", 1, McpSchema.METHOD_PING);
        public static final Defined ResourcesList = new Defined("ResourcesList", 2, McpSchema.METHOD_RESOURCES_LIST);
        public static final Defined ResourcesTemplatesList = new Defined("ResourcesTemplatesList", 3, McpSchema.METHOD_RESOURCES_TEMPLATES_LIST);
        public static final Defined ResourcesRead = new Defined("ResourcesRead", 4, McpSchema.METHOD_RESOURCES_READ);
        public static final Defined ResourcesSubscribe = new Defined("ResourcesSubscribe", 5, McpSchema.METHOD_RESOURCES_SUBSCRIBE);
        public static final Defined ResourcesUnsubscribe = new Defined("ResourcesUnsubscribe", 6, McpSchema.METHOD_RESOURCES_UNSUBSCRIBE);
        public static final Defined PromptsList = new Defined("PromptsList", 7, McpSchema.METHOD_PROMPT_LIST);
        public static final Defined PromptsGet = new Defined("PromptsGet", 8, McpSchema.METHOD_PROMPT_GET);
        public static final Defined NotificationsCancelled = new Defined("NotificationsCancelled", 9, "notifications/cancelled");
        public static final Defined NotificationsInitialized = new Defined("NotificationsInitialized", 10, McpSchema.METHOD_NOTIFICATION_INITIALIZED);
        public static final Defined NotificationsProgress = new Defined("NotificationsProgress", 11, McpSchema.METHOD_NOTIFICATION_PROGRESS);
        public static final Defined NotificationsMessage = new Defined("NotificationsMessage", 12, McpSchema.METHOD_NOTIFICATION_MESSAGE);
        public static final Defined NotificationsResourcesUpdated = new Defined("NotificationsResourcesUpdated", 13, McpSchema.METHOD_NOTIFICATION_RESOURCES_UPDATED);
        public static final Defined NotificationsResourcesListChanged = new Defined("NotificationsResourcesListChanged", 14, McpSchema.METHOD_NOTIFICATION_RESOURCES_LIST_CHANGED);
        public static final Defined NotificationsToolsListChanged = new Defined("NotificationsToolsListChanged", 15, McpSchema.METHOD_NOTIFICATION_TOOLS_LIST_CHANGED);
        public static final Defined NotificationsRootsListChanged = new Defined("NotificationsRootsListChanged", 16, McpSchema.METHOD_NOTIFICATION_ROOTS_LIST_CHANGED);
        public static final Defined NotificationsPromptsListChanged = new Defined("NotificationsPromptsListChanged", 17, McpSchema.METHOD_NOTIFICATION_PROMPTS_LIST_CHANGED);
        public static final Defined ToolsList = new Defined("ToolsList", 18, McpSchema.METHOD_TOOLS_LIST);
        public static final Defined ToolsCall = new Defined("ToolsCall", 19, McpSchema.METHOD_TOOLS_CALL);
        public static final Defined LoggingSetLevel = new Defined("LoggingSetLevel", 20, McpSchema.METHOD_LOGGING_SET_LEVEL);
        public static final Defined SamplingCreateMessage = new Defined("SamplingCreateMessage", 21, McpSchema.METHOD_SAMPLING_CREATE_MESSAGE);
        public static final Defined CompletionComplete = new Defined("CompletionComplete", 22, McpSchema.METHOD_COMPLETION_COMPLETE);
        public static final Defined RootsList = new Defined("RootsList", 23, McpSchema.METHOD_ROOTS_LIST);
        public static final Defined ElicitationCreate = new Defined("ElicitationCreate", 24, McpSchema.METHOD_ELICITATION_CREATE);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/Method$Defined$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/Method$Defined;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) Defined.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Defined> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        private static final /* synthetic */ Defined[] $values() {
            return new Defined[]{Initialize, Ping, ResourcesList, ResourcesTemplatesList, ResourcesRead, ResourcesSubscribe, ResourcesUnsubscribe, PromptsList, PromptsGet, NotificationsCancelled, NotificationsInitialized, NotificationsProgress, NotificationsMessage, NotificationsResourcesUpdated, NotificationsResourcesListChanged, NotificationsToolsListChanged, NotificationsRootsListChanged, NotificationsPromptsListChanged, ToolsList, ToolsCall, LoggingSetLevel, SamplingCreateMessage, CompletionComplete, RootsList, ElicitationCreate};
        }

        static {
            Defined[] definedArr$values = $values();
            $VALUES = definedArr$values;
            $ENTRIES = kotlin.enums.a.a(definedArr$values);
            INSTANCE = new Companion(null);
            $cachedSerializer$delegate = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.z
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Method.Defined._init_$_anonymous_();
                }
            });
        }

        private Defined(String str, int i10, String str2) {
            this.value = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return pb.I.a("io.modelcontextprotocol.kotlin.sdk.Method.Defined", values());
        }

        public static InterfaceC4149a<Defined> getEntries() {
            return $ENTRIES;
        }

        public static Defined valueOf(String str) {
            return (Defined) Enum.valueOf(Defined.class, str);
        }

        public static Defined[] values() {
            return (Defined[]) $VALUES.clone();
        }

        @Override // io.modelcontextprotocol.kotlin.sdk.Method
        public String getValue() {
            return this.value;
        }
    }

    String getValue();
}
