package com.stepos.ailauncher.agent.aispace.skill.feishu;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u001a\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/p0;", "", "", "id", "title", "description", "", "recommended", HighlightArgsBundle.KEY_PROMPT, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "e", Const.INTENT_KEY_APIKEY, "Z", Const.INTENT_KEY_UMID, "()Z", "c", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.p0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class RecommendedTask {
    private final String description;
    private final String id;
    private final String prompt;
    private final boolean recommended;
    private final String title;

    public RecommendedTask(String id, String title, String str, boolean z10, String str2) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(title, "title");
        this.id = id;
        this.title = title;
        this.description = str;
        this.recommended = z10;
        this.prompt = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getRecommended() {
        return this.recommended;
    }

    /* renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommendedTask)) {
            return false;
        }
        RecommendedTask recommendedTask = (RecommendedTask) other;
        return kotlin.jvm.internal.p.d(this.id, recommendedTask.id) && kotlin.jvm.internal.p.d(this.title, recommendedTask.title) && kotlin.jvm.internal.p.d(this.description, recommendedTask.description) && this.recommended == recommendedTask.recommended && kotlin.jvm.internal.p.d(this.prompt, recommendedTask.prompt);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.title.hashCode()) * 31;
        String str = this.description;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.recommended)) * 31;
        String str2 = this.prompt;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "RecommendedTask(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", recommended=" + this.recommended + ", prompt=" + this.prompt + ")";
    }

    public /* synthetic */ RecommendedTask(String str, String str2, String str3, boolean z10, String str4, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? null : str4);
    }
}
