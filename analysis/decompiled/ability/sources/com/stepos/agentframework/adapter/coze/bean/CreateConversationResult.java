package com.stepos.agentframework.adapter.coze.bean;

import B7.a;
import androidx.annotation.Keep;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult;", "", "code", "", SettingsConfig.KEY_DATA, "Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult$Data;", "detail", "Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult$Detail;", NotificationCompat.CATEGORY_MESSAGE, "", AppAgent.CONSTRUCT, "(ILcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult$Data;Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult$Detail;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult$Data;", "getDetail", "()Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult$Detail;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "Data", "Detail", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CreateConversationResult {
    private final int code;
    private final Data data;
    private final Detail detail;
    private final String msg;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0001(BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006)"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult$Data;", "", "connector_id", "", "created_at", "", "creator_id", "id", "last_section_id", "meta_data", "Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult$Data$MetaData;", HintConstants.AUTOFILL_HINT_NAME, "updated_at", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult$Data$MetaData;Ljava/lang/String;I)V", "getConnector_id", "()Ljava/lang/String;", "getCreated_at", "()I", "getCreator_id", "getId", "getLast_section_id", "getMeta_data", "()Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult$Data$MetaData;", "getName", "getUpdated_at", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "MetaData", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data {
        private final String connector_id;
        private final int created_at;
        private final String creator_id;
        private final String id;
        private final String last_section_id;
        private final MetaData meta_data;
        private final String name;
        private final int updated_at;

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult$Data$MetaData;", "", "uuid", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getUuid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MetaData {
            private final String uuid;

            public MetaData(String uuid) {
                k.f(uuid, "uuid");
                this.uuid = uuid;
            }

            public static /* synthetic */ MetaData copy$default(MetaData metaData, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = metaData.uuid;
                }
                return metaData.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getUuid() {
                return this.uuid;
            }

            public final MetaData copy(String uuid) {
                k.f(uuid, "uuid");
                return new MetaData(uuid);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof MetaData) && k.b(this.uuid, ((MetaData) other).uuid);
            }

            public final String getUuid() {
                return this.uuid;
            }

            public int hashCode() {
                return this.uuid.hashCode();
            }

            public String toString() {
                return a.m("MetaData(uuid=", this.uuid, ")");
            }
        }

        public Data(String connector_id, int i, String creator_id, String id, String last_section_id, MetaData meta_data, String name, int i6) {
            k.f(connector_id, "connector_id");
            k.f(creator_id, "creator_id");
            k.f(id, "id");
            k.f(last_section_id, "last_section_id");
            k.f(meta_data, "meta_data");
            k.f(name, "name");
            this.connector_id = connector_id;
            this.created_at = i;
            this.creator_id = creator_id;
            this.id = id;
            this.last_section_id = last_section_id;
            this.meta_data = meta_data;
            this.name = name;
            this.updated_at = i6;
        }

        public static /* synthetic */ Data copy$default(Data data, String str, int i, String str2, String str3, String str4, MetaData metaData, String str5, int i6, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = data.connector_id;
            }
            if ((i10 & 2) != 0) {
                i = data.created_at;
            }
            if ((i10 & 4) != 0) {
                str2 = data.creator_id;
            }
            if ((i10 & 8) != 0) {
                str3 = data.id;
            }
            if ((i10 & 16) != 0) {
                str4 = data.last_section_id;
            }
            if ((i10 & 32) != 0) {
                metaData = data.meta_data;
            }
            if ((i10 & 64) != 0) {
                str5 = data.name;
            }
            if ((i10 & 128) != 0) {
                i6 = data.updated_at;
            }
            String str6 = str5;
            int i11 = i6;
            String str7 = str4;
            MetaData metaData2 = metaData;
            return data.copy(str, i, str2, str3, str7, metaData2, str6, i11);
        }

        /* renamed from: component1, reason: from getter */
        public final String getConnector_id() {
            return this.connector_id;
        }

        /* renamed from: component2, reason: from getter */
        public final int getCreated_at() {
            return this.created_at;
        }

        /* renamed from: component3, reason: from getter */
        public final String getCreator_id() {
            return this.creator_id;
        }

        /* renamed from: component4, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component5, reason: from getter */
        public final String getLast_section_id() {
            return this.last_section_id;
        }

        /* renamed from: component6, reason: from getter */
        public final MetaData getMeta_data() {
            return this.meta_data;
        }

        /* renamed from: component7, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component8, reason: from getter */
        public final int getUpdated_at() {
            return this.updated_at;
        }

        public final Data copy(String connector_id, int created_at, String creator_id, String id, String last_section_id, MetaData meta_data, String name, int updated_at) {
            k.f(connector_id, "connector_id");
            k.f(creator_id, "creator_id");
            k.f(id, "id");
            k.f(last_section_id, "last_section_id");
            k.f(meta_data, "meta_data");
            k.f(name, "name");
            return new Data(connector_id, created_at, creator_id, id, last_section_id, meta_data, name, updated_at);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return k.b(this.connector_id, data.connector_id) && this.created_at == data.created_at && k.b(this.creator_id, data.creator_id) && k.b(this.id, data.id) && k.b(this.last_section_id, data.last_section_id) && k.b(this.meta_data, data.meta_data) && k.b(this.name, data.name) && this.updated_at == data.updated_at;
        }

        public final String getConnector_id() {
            return this.connector_id;
        }

        public final int getCreated_at() {
            return this.created_at;
        }

        public final String getCreator_id() {
            return this.creator_id;
        }

        public final String getId() {
            return this.id;
        }

        public final String getLast_section_id() {
            return this.last_section_id;
        }

        public final MetaData getMeta_data() {
            return this.meta_data;
        }

        public final String getName() {
            return this.name;
        }

        public final int getUpdated_at() {
            return this.updated_at;
        }

        public int hashCode() {
            return Integer.hashCode(this.updated_at) + a.c((this.meta_data.hashCode() + a.c(a.c(a.c(androidx.constraintlayout.core.dsl.a.a(this.created_at, this.connector_id.hashCode() * 31, 31), 31, this.creator_id), 31, this.id), 31, this.last_section_id)) * 31, 31, this.name);
        }

        public String toString() {
            String str = this.connector_id;
            int i = this.created_at;
            String str2 = this.creator_id;
            String str3 = this.id;
            String str4 = this.last_section_id;
            MetaData metaData = this.meta_data;
            String str5 = this.name;
            int i6 = this.updated_at;
            StringBuilder sbT = androidx.appfunctions.metadata.a.t(i, "Data(connector_id=", str, ", created_at=", ", creator_id=");
            androidx.constraintlayout.core.dsl.a.A(sbT, str2, ", id=", str3, ", last_section_id=");
            sbT.append(str4);
            sbT.append(", meta_data=");
            sbT.append(metaData);
            sbT.append(", name=");
            sbT.append(str5);
            sbT.append(", updated_at=");
            sbT.append(i6);
            sbT.append(")");
            return sbT.toString();
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult$Detail;", "", "logid", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getLogid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Detail {
        private final String logid;

        public Detail(String logid) {
            k.f(logid, "logid");
            this.logid = logid;
        }

        public static /* synthetic */ Detail copy$default(Detail detail, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = detail.logid;
            }
            return detail.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLogid() {
            return this.logid;
        }

        public final Detail copy(String logid) {
            k.f(logid, "logid");
            return new Detail(logid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Detail) && k.b(this.logid, ((Detail) other).logid);
        }

        public final String getLogid() {
            return this.logid;
        }

        public int hashCode() {
            return this.logid.hashCode();
        }

        public String toString() {
            return a.m("Detail(logid=", this.logid, ")");
        }
    }

    public CreateConversationResult(int i, Data data, Detail detail, String msg) {
        k.f(data, "data");
        k.f(detail, "detail");
        k.f(msg, "msg");
        this.code = i;
        this.data = data;
        this.detail = detail;
        this.msg = msg;
    }

    public static /* synthetic */ CreateConversationResult copy$default(CreateConversationResult createConversationResult, int i, Data data, Detail detail, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = createConversationResult.code;
        }
        if ((i6 & 2) != 0) {
            data = createConversationResult.data;
        }
        if ((i6 & 4) != 0) {
            detail = createConversationResult.detail;
        }
        if ((i6 & 8) != 0) {
            str = createConversationResult.msg;
        }
        return createConversationResult.copy(i, data, detail, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final Data getData() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final Detail getDetail() {
        return this.detail;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final CreateConversationResult copy(int code, Data data, Detail detail, String msg) {
        k.f(data, "data");
        k.f(detail, "detail");
        k.f(msg, "msg");
        return new CreateConversationResult(code, data, detail, msg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateConversationResult)) {
            return false;
        }
        CreateConversationResult createConversationResult = (CreateConversationResult) other;
        return this.code == createConversationResult.code && k.b(this.data, createConversationResult.data) && k.b(this.detail, createConversationResult.detail) && k.b(this.msg, createConversationResult.msg);
    }

    public final int getCode() {
        return this.code;
    }

    public final Data getData() {
        return this.data;
    }

    public final Detail getDetail() {
        return this.detail;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return this.msg.hashCode() + ((this.detail.hashCode() + ((this.data.hashCode() + (Integer.hashCode(this.code) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "CreateConversationResult(code=" + this.code + ", data=" + this.data + ", detail=" + this.detail + ", msg=" + this.msg + ")";
    }
}
