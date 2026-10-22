package com.stepos.taskrobot.app;

import androidx.annotation.Keep;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/stepos/taskrobot/app/ExcuteAction;", "", SettingsConfig.KEY_DATA, "Lcom/stepos/taskrobot/app/ExcuteAction$Data;", "type", "", AppAgent.CONSTRUCT, "(Lcom/stepos/taskrobot/app/ExcuteAction$Data;Ljava/lang/String;)V", "getData", "()Lcom/stepos/taskrobot/app/ExcuteAction$Data;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Data", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ExcuteAction {
    private final Data data;
    private final String type;

    @Keep
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/taskrobot/app/ExcuteAction$Data;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "", "code", "", "message", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/stepos/taskrobot/app/ExcuteAction$Data;", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data {
        private final String action;
        private final Integer code;
        private final String message;

        public Data(String str, Integer num, String str2) {
            this.action = str;
            this.code = num;
            this.message = str2;
        }

        public static /* synthetic */ Data copy$default(Data data, String str, Integer num, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = data.action;
            }
            if ((i & 2) != 0) {
                num = data.code;
            }
            if ((i & 4) != 0) {
                str2 = data.message;
            }
            return data.copy(str, num, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAction() {
            return this.action;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getCode() {
            return this.code;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Data copy(String action, Integer code, String message) {
            return new Data(action, code, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return k.b(this.action, data.action) && k.b(this.code, data.code) && k.b(this.message, data.message);
        }

        public final String getAction() {
            return this.action;
        }

        public final Integer getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            String str = this.action;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.code;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.message;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            String str = this.action;
            Integer num = this.code;
            String str2 = this.message;
            StringBuilder sb = new StringBuilder("Data(action=");
            sb.append(str);
            sb.append(", code=");
            sb.append(num);
            sb.append(", message=");
            return B7.a.q(sb, str2, ")");
        }
    }

    public ExcuteAction(Data data, String type) {
        k.f(type, "type");
        this.data = data;
        this.type = type;
    }

    public static /* synthetic */ ExcuteAction copy$default(ExcuteAction excuteAction, Data data, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            data = excuteAction.data;
        }
        if ((i & 2) != 0) {
            str = excuteAction.type;
        }
        return excuteAction.copy(data, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Data getData() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final ExcuteAction copy(Data data, String type) {
        k.f(type, "type");
        return new ExcuteAction(data, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExcuteAction)) {
            return false;
        }
        ExcuteAction excuteAction = (ExcuteAction) other;
        return k.b(this.data, excuteAction.data) && k.b(this.type, excuteAction.type);
    }

    public final Data getData() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        Data data = this.data;
        return this.type.hashCode() + ((data == null ? 0 : data.hashCode()) * 31);
    }

    public String toString() {
        return "ExcuteAction(data=" + this.data + ", type=" + this.type + ")";
    }
}
