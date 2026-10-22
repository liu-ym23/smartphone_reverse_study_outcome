package stepai.android.mindx.client.config;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lstepai/android/mindx/client/config/ChatData;", "", "type", "", "code", "response", "", "responseId", AppAgent.CONSTRUCT, "(IILjava/lang/String;Ljava/lang/String;)V", "getType", "()I", "getCode", "getResponse", "()Ljava/lang/String;", "getResponseId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "mindXClient_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ChatData {
    private final int code;
    private final String response;
    private final String responseId;
    private final int type;

    public ChatData(int i, int i6, String str, String str2) {
        this.type = i;
        this.code = i6;
        this.response = str;
        this.responseId = str2;
    }

    public static /* synthetic */ ChatData copy$default(ChatData chatData, int i, int i6, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = chatData.type;
        }
        if ((i10 & 2) != 0) {
            i6 = chatData.code;
        }
        if ((i10 & 4) != 0) {
            str = chatData.response;
        }
        if ((i10 & 8) != 0) {
            str2 = chatData.responseId;
        }
        return chatData.copy(i, i6, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component3, reason: from getter */
    public final String getResponse() {
        return this.response;
    }

    /* renamed from: component4, reason: from getter */
    public final String getResponseId() {
        return this.responseId;
    }

    public final ChatData copy(int type, int code, String response, String responseId) {
        return new ChatData(type, code, response, responseId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatData)) {
            return false;
        }
        ChatData chatData = (ChatData) other;
        return this.type == chatData.type && this.code == chatData.code && k.b(this.response, chatData.response) && k.b(this.responseId, chatData.responseId);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getResponse() {
        return this.response;
    }

    public final String getResponseId() {
        return this.responseId;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int iA = a.a(this.code, Integer.hashCode(this.type) * 31, 31);
        String str = this.response;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.responseId;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        int i = this.type;
        int i6 = this.code;
        return androidx.appfunctions.metadata.a.p(androidx.appfunctions.metadata.a.s(i, "ChatData(type=", i6, ", code=", ", response="), this.response, ", responseId=", this.responseId, ")");
    }
}
