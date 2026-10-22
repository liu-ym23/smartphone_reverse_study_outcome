package com.stepos.agentframework.chatcore.session.bean;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import u4.AgentTaskToolCall;
import u4.AppUiMeta;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001e\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001f\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$R*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/bean/a;", "", "", "id", "title", "description", "planId", "", "status", "Lu4/l;", "appui", "", "Lu4/j;", "toolCalls", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILu4/l;Ljava/util/List;)V", "Lu4/e;", Const.INTENT_KEY_APIKEY, "()Lu4/e;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getTitle", "getDescription", "getPlanId", "I", "getStatus", "Lu4/l;", "getAppui", "()Lu4/l;", "Ljava/util/List;", "getToolCalls", "()Ljava/util/List;", "setToolCalls", "(Ljava/util/List;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.bean.a, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AgentTaskAppUi {
    private final AppUiMeta appui;
    private final String description;
    private final String id;

    @SerializedName("plan_id")
    private final String planId;
    private final int status;
    private final String title;

    @SerializedName("tool_calls")
    private List<AgentTaskToolCall> toolCalls;

    public AgentTaskAppUi() {
        this(null, null, null, null, 0, null, null, 127, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final u4.AgentTask a() {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.bean.AgentTaskAppUi.a():u4.e");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentTaskAppUi)) {
            return false;
        }
        AgentTaskAppUi agentTaskAppUi = (AgentTaskAppUi) other;
        return p.d(this.id, agentTaskAppUi.id) && p.d(this.title, agentTaskAppUi.title) && p.d(this.description, agentTaskAppUi.description) && p.d(this.planId, agentTaskAppUi.planId) && this.status == agentTaskAppUi.status && p.d(this.appui, agentTaskAppUi.appui) && p.d(this.toolCalls, agentTaskAppUi.toolCalls);
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31;
        String str = this.planId;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.status)) * 31;
        AppUiMeta appUiMeta = this.appui;
        int iHashCode3 = (iHashCode2 + (appUiMeta == null ? 0 : appUiMeta.hashCode())) * 31;
        List<AgentTaskToolCall> list = this.toolCalls;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "AgentTaskAppUi(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", planId=" + this.planId + ", status=" + this.status + ", appui=" + this.appui + ", toolCalls=" + this.toolCalls + ")";
    }

    public AgentTaskAppUi(String id, String title, String description, String str, int i10, AppUiMeta appUiMeta, List<AgentTaskToolCall> list) {
        p.i(id, "id");
        p.i(title, "title");
        p.i(description, "description");
        this.id = id;
        this.title = title;
        this.description = description;
        this.planId = str;
        this.status = i10;
        this.appui = appUiMeta;
        this.toolCalls = list;
    }

    public /* synthetic */ AgentTaskAppUi(String str, String str2, String str3, String str4, int i10, AppUiMeta appUiMeta, List list, int i11, i iVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? 0 : i10, (i11 & 32) != 0 ? null : appUiMeta, (i11 & 64) != 0 ? null : list);
    }
}
