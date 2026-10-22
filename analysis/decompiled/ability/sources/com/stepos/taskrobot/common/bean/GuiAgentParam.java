package com.stepos.taskrobot.common.bean;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.GuiAgentConfigKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bB-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/stepos/taskrobot/common/bean/GuiAgentParam;", "", "appName", "", "meta", "Lcom/stepos/taskrobot/common/bean/GuiAgentParam$Meta;", "platform", "task", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/stepos/taskrobot/common/bean/GuiAgentParam$Meta;Ljava/lang/String;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "getMeta", "()Lcom/stepos/taskrobot/common/bean/GuiAgentParam$Meta;", "getPlatform", "getTask", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Meta", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GuiAgentParam {

    @SerializedName(GuiAgentConfigKt.META_KEY_APP_NAME)
    private final String appName;

    @SerializedName("meta")
    private final Meta meta;

    @SerializedName("platform")
    private final String platform;

    @SerializedName("task")
    private final String task;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u00012B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0001HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u000fHÆ\u0003Jw\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u000fHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00063"}, d2 = {"Lcom/stepos/taskrobot/common/bean/GuiAgentParam$Meta;", "", "contextId", "", "guiTree", "originalQuery", "sessionId", "slots", "Lcom/stepos/taskrobot/common/bean/GuiAgentParam$Meta$Slots;", "stepTraceID", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "zyqlDeviceId", "zyqlMessageId", "zyqlSessionId", "zyqlTimeoutMillis", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/taskrobot/common/bean/GuiAgentParam$Meta$Slots;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getContextId", "()Ljava/lang/String;", "getGuiTree", "()Ljava/lang/Object;", "getOriginalQuery", "getSessionId", "getSlots", "()Lcom/stepos/taskrobot/common/bean/GuiAgentParam$Meta$Slots;", "getStepTraceID", "getTaskId", "getZyqlDeviceId", "getZyqlMessageId", "getZyqlSessionId", "getZyqlTimeoutMillis", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "Slots", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Meta {

        @SerializedName("context_id")
        private final String contextId;

        @SerializedName("gui_tree")
        private final Object guiTree;

        @SerializedName("original_query")
        private final String originalQuery;

        @SerializedName("session_id")
        private final String sessionId;

        @SerializedName("slots")
        private final Slots slots;

        @SerializedName("Step-Trace-ID")
        private final String stepTraceID;

        @SerializedName("task_id")
        private final String taskId;

        @SerializedName("zyql_device_id")
        private final String zyqlDeviceId;

        @SerializedName("zyql_message_id")
        private final String zyqlMessageId;

        @SerializedName("zyql_session_id")
        private final String zyqlSessionId;

        @SerializedName("zyql_timeout_millis")
        private final int zyqlTimeoutMillis;

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JW\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/stepos/taskrobot/common/bean/GuiAgentParam$Meta$Slots;", "", "appName", "", "deliveryMethod", "productSpecifications", "", "targetProducts", "targetShops", "taskEntry", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "getDeliveryMethod", "getProductSpecifications", "()Ljava/util/List;", "getTargetProducts", "getTargetShops", "getTaskEntry", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Slots {

            @SerializedName(GuiAgentConfigKt.META_KEY_APP_NAME)
            private final String appName;

            @SerializedName("delivery_method")
            private final String deliveryMethod;

            @SerializedName("product_specifications")
            private final List<String> productSpecifications;

            @SerializedName("target_products")
            private final List<String> targetProducts;

            @SerializedName("target_shops")
            private final List<String> targetShops;

            @SerializedName("task_entry")
            private final String taskEntry;

            public Slots(String appName, String deliveryMethod, List<String> productSpecifications, List<String> targetProducts, List<String> targetShops, String taskEntry) {
                k.f(appName, "appName");
                k.f(deliveryMethod, "deliveryMethod");
                k.f(productSpecifications, "productSpecifications");
                k.f(targetProducts, "targetProducts");
                k.f(targetShops, "targetShops");
                k.f(taskEntry, "taskEntry");
                this.appName = appName;
                this.deliveryMethod = deliveryMethod;
                this.productSpecifications = productSpecifications;
                this.targetProducts = targetProducts;
                this.targetShops = targetShops;
                this.taskEntry = taskEntry;
            }

            public static /* synthetic */ Slots copy$default(Slots slots, String str, String str2, List list, List list2, List list3, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = slots.appName;
                }
                if ((i & 2) != 0) {
                    str2 = slots.deliveryMethod;
                }
                if ((i & 4) != 0) {
                    list = slots.productSpecifications;
                }
                if ((i & 8) != 0) {
                    list2 = slots.targetProducts;
                }
                if ((i & 16) != 0) {
                    list3 = slots.targetShops;
                }
                if ((i & 32) != 0) {
                    str3 = slots.taskEntry;
                }
                List list4 = list3;
                String str4 = str3;
                return slots.copy(str, str2, list, list2, list4, str4);
            }

            /* renamed from: component1, reason: from getter */
            public final String getAppName() {
                return this.appName;
            }

            /* renamed from: component2, reason: from getter */
            public final String getDeliveryMethod() {
                return this.deliveryMethod;
            }

            public final List<String> component3() {
                return this.productSpecifications;
            }

            public final List<String> component4() {
                return this.targetProducts;
            }

            public final List<String> component5() {
                return this.targetShops;
            }

            /* renamed from: component6, reason: from getter */
            public final String getTaskEntry() {
                return this.taskEntry;
            }

            public final Slots copy(String appName, String deliveryMethod, List<String> productSpecifications, List<String> targetProducts, List<String> targetShops, String taskEntry) {
                k.f(appName, "appName");
                k.f(deliveryMethod, "deliveryMethod");
                k.f(productSpecifications, "productSpecifications");
                k.f(targetProducts, "targetProducts");
                k.f(targetShops, "targetShops");
                k.f(taskEntry, "taskEntry");
                return new Slots(appName, deliveryMethod, productSpecifications, targetProducts, targetShops, taskEntry);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Slots)) {
                    return false;
                }
                Slots slots = (Slots) other;
                return k.b(this.appName, slots.appName) && k.b(this.deliveryMethod, slots.deliveryMethod) && k.b(this.productSpecifications, slots.productSpecifications) && k.b(this.targetProducts, slots.targetProducts) && k.b(this.targetShops, slots.targetShops) && k.b(this.taskEntry, slots.taskEntry);
            }

            public final String getAppName() {
                return this.appName;
            }

            public final String getDeliveryMethod() {
                return this.deliveryMethod;
            }

            public final List<String> getProductSpecifications() {
                return this.productSpecifications;
            }

            public final List<String> getTargetProducts() {
                return this.targetProducts;
            }

            public final List<String> getTargetShops() {
                return this.targetShops;
            }

            public final String getTaskEntry() {
                return this.taskEntry;
            }

            public int hashCode() {
                return this.taskEntry.hashCode() + a.e(this.targetShops, a.e(this.targetProducts, a.e(this.productSpecifications, B7.a.c(this.appName.hashCode() * 31, 31, this.deliveryMethod), 31), 31), 31);
            }

            public String toString() {
                String str = this.appName;
                String str2 = this.deliveryMethod;
                List<String> list = this.productSpecifications;
                List<String> list2 = this.targetProducts;
                List<String> list3 = this.targetShops;
                String str3 = this.taskEntry;
                StringBuilder sbW = B7.a.w("Slots(appName=", str, ", deliveryMethod=", str2, ", productSpecifications=");
                sbW.append(list);
                sbW.append(", targetProducts=");
                sbW.append(list2);
                sbW.append(", targetShops=");
                sbW.append(list3);
                sbW.append(", taskEntry=");
                sbW.append(str3);
                sbW.append(")");
                return sbW.toString();
            }
        }

        public Meta(String contextId, Object guiTree, String originalQuery, String sessionId, Slots slots, String stepTraceID, String taskId, String zyqlDeviceId, String zyqlMessageId, String zyqlSessionId, int i) {
            k.f(contextId, "contextId");
            k.f(guiTree, "guiTree");
            k.f(originalQuery, "originalQuery");
            k.f(sessionId, "sessionId");
            k.f(slots, "slots");
            k.f(stepTraceID, "stepTraceID");
            k.f(taskId, "taskId");
            k.f(zyqlDeviceId, "zyqlDeviceId");
            k.f(zyqlMessageId, "zyqlMessageId");
            k.f(zyqlSessionId, "zyqlSessionId");
            this.contextId = contextId;
            this.guiTree = guiTree;
            this.originalQuery = originalQuery;
            this.sessionId = sessionId;
            this.slots = slots;
            this.stepTraceID = stepTraceID;
            this.taskId = taskId;
            this.zyqlDeviceId = zyqlDeviceId;
            this.zyqlMessageId = zyqlMessageId;
            this.zyqlSessionId = zyqlSessionId;
            this.zyqlTimeoutMillis = i;
        }

        public static /* synthetic */ Meta copy$default(Meta meta, String str, Object obj, String str2, String str3, Slots slots, String str4, String str5, String str6, String str7, String str8, int i, int i6, Object obj2) {
            if ((i6 & 1) != 0) {
                str = meta.contextId;
            }
            if ((i6 & 2) != 0) {
                obj = meta.guiTree;
            }
            if ((i6 & 4) != 0) {
                str2 = meta.originalQuery;
            }
            if ((i6 & 8) != 0) {
                str3 = meta.sessionId;
            }
            if ((i6 & 16) != 0) {
                slots = meta.slots;
            }
            if ((i6 & 32) != 0) {
                str4 = meta.stepTraceID;
            }
            if ((i6 & 64) != 0) {
                str5 = meta.taskId;
            }
            if ((i6 & 128) != 0) {
                str6 = meta.zyqlDeviceId;
            }
            if ((i6 & 256) != 0) {
                str7 = meta.zyqlMessageId;
            }
            if ((i6 & 512) != 0) {
                str8 = meta.zyqlSessionId;
            }
            if ((i6 & 1024) != 0) {
                i = meta.zyqlTimeoutMillis;
            }
            String str9 = str8;
            int i10 = i;
            String str10 = str6;
            String str11 = str7;
            String str12 = str4;
            String str13 = str5;
            Slots slots2 = slots;
            String str14 = str2;
            return meta.copy(str, obj, str14, str3, slots2, str12, str13, str10, str11, str9, i10);
        }

        /* renamed from: component1, reason: from getter */
        public final String getContextId() {
            return this.contextId;
        }

        /* renamed from: component10, reason: from getter */
        public final String getZyqlSessionId() {
            return this.zyqlSessionId;
        }

        /* renamed from: component11, reason: from getter */
        public final int getZyqlTimeoutMillis() {
            return this.zyqlTimeoutMillis;
        }

        /* renamed from: component2, reason: from getter */
        public final Object getGuiTree() {
            return this.guiTree;
        }

        /* renamed from: component3, reason: from getter */
        public final String getOriginalQuery() {
            return this.originalQuery;
        }

        /* renamed from: component4, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component5, reason: from getter */
        public final Slots getSlots() {
            return this.slots;
        }

        /* renamed from: component6, reason: from getter */
        public final String getStepTraceID() {
            return this.stepTraceID;
        }

        /* renamed from: component7, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: component8, reason: from getter */
        public final String getZyqlDeviceId() {
            return this.zyqlDeviceId;
        }

        /* renamed from: component9, reason: from getter */
        public final String getZyqlMessageId() {
            return this.zyqlMessageId;
        }

        public final Meta copy(String contextId, Object guiTree, String originalQuery, String sessionId, Slots slots, String stepTraceID, String taskId, String zyqlDeviceId, String zyqlMessageId, String zyqlSessionId, int zyqlTimeoutMillis) {
            k.f(contextId, "contextId");
            k.f(guiTree, "guiTree");
            k.f(originalQuery, "originalQuery");
            k.f(sessionId, "sessionId");
            k.f(slots, "slots");
            k.f(stepTraceID, "stepTraceID");
            k.f(taskId, "taskId");
            k.f(zyqlDeviceId, "zyqlDeviceId");
            k.f(zyqlMessageId, "zyqlMessageId");
            k.f(zyqlSessionId, "zyqlSessionId");
            return new Meta(contextId, guiTree, originalQuery, sessionId, slots, stepTraceID, taskId, zyqlDeviceId, zyqlMessageId, zyqlSessionId, zyqlTimeoutMillis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Meta)) {
                return false;
            }
            Meta meta = (Meta) other;
            return k.b(this.contextId, meta.contextId) && k.b(this.guiTree, meta.guiTree) && k.b(this.originalQuery, meta.originalQuery) && k.b(this.sessionId, meta.sessionId) && k.b(this.slots, meta.slots) && k.b(this.stepTraceID, meta.stepTraceID) && k.b(this.taskId, meta.taskId) && k.b(this.zyqlDeviceId, meta.zyqlDeviceId) && k.b(this.zyqlMessageId, meta.zyqlMessageId) && k.b(this.zyqlSessionId, meta.zyqlSessionId) && this.zyqlTimeoutMillis == meta.zyqlTimeoutMillis;
        }

        public final String getContextId() {
            return this.contextId;
        }

        public final Object getGuiTree() {
            return this.guiTree;
        }

        public final String getOriginalQuery() {
            return this.originalQuery;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final Slots getSlots() {
            return this.slots;
        }

        public final String getStepTraceID() {
            return this.stepTraceID;
        }

        public final String getTaskId() {
            return this.taskId;
        }

        public final String getZyqlDeviceId() {
            return this.zyqlDeviceId;
        }

        public final String getZyqlMessageId() {
            return this.zyqlMessageId;
        }

        public final String getZyqlSessionId() {
            return this.zyqlSessionId;
        }

        public final int getZyqlTimeoutMillis() {
            return this.zyqlTimeoutMillis;
        }

        public int hashCode() {
            return Integer.hashCode(this.zyqlTimeoutMillis) + B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c((this.slots.hashCode() + B7.a.c(B7.a.c((this.guiTree.hashCode() + (this.contextId.hashCode() * 31)) * 31, 31, this.originalQuery), 31, this.sessionId)) * 31, 31, this.stepTraceID), 31, this.taskId), 31, this.zyqlDeviceId), 31, this.zyqlMessageId), 31, this.zyqlSessionId);
        }

        public String toString() {
            String str = this.contextId;
            Object obj = this.guiTree;
            String str2 = this.originalQuery;
            String str3 = this.sessionId;
            Slots slots = this.slots;
            String str4 = this.stepTraceID;
            String str5 = this.taskId;
            String str6 = this.zyqlDeviceId;
            String str7 = this.zyqlMessageId;
            String str8 = this.zyqlSessionId;
            int i = this.zyqlTimeoutMillis;
            StringBuilder sb = new StringBuilder("Meta(contextId=");
            sb.append(str);
            sb.append(", guiTree=");
            sb.append(obj);
            sb.append(", originalQuery=");
            androidx.constraintlayout.core.dsl.a.A(sb, str2, ", sessionId=", str3, ", slots=");
            sb.append(slots);
            sb.append(", stepTraceID=");
            sb.append(str4);
            sb.append(", taskId=");
            androidx.constraintlayout.core.dsl.a.A(sb, str5, ", zyqlDeviceId=", str6, ", zyqlMessageId=");
            androidx.constraintlayout.core.dsl.a.A(sb, str7, ", zyqlSessionId=", str8, ", zyqlTimeoutMillis=");
            return a.o(sb, ")", i);
        }
    }

    public GuiAgentParam(String str, Meta meta, String str2, String task) {
        k.f(task, "task");
        this.appName = str;
        this.meta = meta;
        this.platform = str2;
        this.task = task;
    }

    public static /* synthetic */ GuiAgentParam copy$default(GuiAgentParam guiAgentParam, String str, Meta meta, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guiAgentParam.appName;
        }
        if ((i & 2) != 0) {
            meta = guiAgentParam.meta;
        }
        if ((i & 4) != 0) {
            str2 = guiAgentParam.platform;
        }
        if ((i & 8) != 0) {
            str3 = guiAgentParam.task;
        }
        return guiAgentParam.copy(str, meta, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component2, reason: from getter */
    public final Meta getMeta() {
        return this.meta;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTask() {
        return this.task;
    }

    public final GuiAgentParam copy(String appName, Meta meta, String platform, String task) {
        k.f(task, "task");
        return new GuiAgentParam(appName, meta, platform, task);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiAgentParam)) {
            return false;
        }
        GuiAgentParam guiAgentParam = (GuiAgentParam) other;
        return k.b(this.appName, guiAgentParam.appName) && k.b(this.meta, guiAgentParam.meta) && k.b(this.platform, guiAgentParam.platform) && k.b(this.task, guiAgentParam.task);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final Meta getMeta() {
        return this.meta;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getTask() {
        return this.task;
    }

    public int hashCode() {
        String str = this.appName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Meta meta = this.meta;
        int iHashCode2 = (iHashCode + (meta == null ? 0 : meta.hashCode())) * 31;
        String str2 = this.platform;
        return this.task.hashCode() + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public String toString() {
        String str = this.appName;
        Meta meta = this.meta;
        String str2 = this.platform;
        String str3 = this.task;
        StringBuilder sb = new StringBuilder("GuiAgentParam(appName=");
        sb.append(str);
        sb.append(", meta=");
        sb.append(meta);
        sb.append(", platform=");
        return a.p(sb, str2, ", task=", str3, ")");
    }
}
