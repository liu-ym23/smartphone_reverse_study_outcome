package u4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0019R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0019R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0019R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0019R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010#R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b$\u0010\u000f\"\u0004\b%\u0010\u0019R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lu4/e;", "", "", "id", "planId", "title", "description", "", "status", "url", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "appUIData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "setId", "(Ljava/lang/String;)V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "f", "l", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "I", "e", "k", "(I)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "m", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: u4.e, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AgentTask {
    private AppUIData appUIData;
    private String description;
    private String id;
    private String planId;
    private int status;
    private String title;
    private String url;

    public AgentTask() {
        this(null, null, null, null, 0, null, null, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final AppUIData getAppUIData() {
        return this.appUIData;
    }

    /* renamed from: b, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: c, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final String getPlanId() {
        return this.planId;
    }

    /* renamed from: e, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentTask)) {
            return false;
        }
        AgentTask agentTask = (AgentTask) other;
        return p.d(this.id, agentTask.id) && p.d(this.planId, agentTask.planId) && p.d(this.title, agentTask.title) && p.d(this.description, agentTask.description) && this.status == agentTask.status && p.d(this.url, agentTask.url) && p.d(this.appUIData, agentTask.appUIData);
    }

    /* renamed from: f, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: g, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final void h(AppUIData appUIData) {
        this.appUIData = appUIData;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.id.hashCode() * 31) + this.planId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.status)) * 31;
        String str = this.url;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        AppUIData appUIData = this.appUIData;
        return iHashCode2 + (appUIData != null ? appUIData.hashCode() : 0);
    }

    public final void i(String str) {
        p.i(str, "<set-?>");
        this.description = str;
    }

    public final void j(String str) {
        p.i(str, "<set-?>");
        this.planId = str;
    }

    public final void k(int i10) {
        this.status = i10;
    }

    public final void l(String str) {
        p.i(str, "<set-?>");
        this.title = str;
    }

    public final void m(String str) {
        this.url = str;
    }

    public String toString() {
        return "AgentTask(id=" + this.id + ", planId=" + this.planId + ", title=" + this.title + ", description=" + this.description + ", status=" + this.status + ", url=" + this.url + ", appUIData=" + this.appUIData + ")";
    }

    public AgentTask(String id, String planId, String title, String description, int i10, String str, AppUIData appUIData) {
        p.i(id, "id");
        p.i(planId, "planId");
        p.i(title, "title");
        p.i(description, "description");
        this.id = id;
        this.planId = planId;
        this.title = title;
        this.description = description;
        this.status = i10;
        this.url = str;
        this.appUIData = appUIData;
    }

    public /* synthetic */ AgentTask(String str, String str2, String str3, String str4, int i10, String str5, AppUIData appUIData, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? "" : str4, (i11 & 16) != 0 ? 0 : i10, (i11 & 32) != 0 ? null : str5, (i11 & 64) != 0 ? null : appUIData);
    }
}
