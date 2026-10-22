package com.stepos.ailauncher.agent.aispace.skill.feishu;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/n0;", "", "", "stepIndex", "totalSteps", "", "title", "subtitle", "", "completed", "<init>", "(IILjava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_PKGNAME, "getTotalSteps", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "c", "Z", Const.INTENT_KEY_APIKEY, "()Z", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.n0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class InstallProgress {
    private final boolean completed;
    private final int stepIndex;
    private final String subtitle;
    private final String title;
    private final int totalSteps;

    public InstallProgress(int i10, int i11, String title, String subtitle, boolean z10) {
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(subtitle, "subtitle");
        this.stepIndex = i10;
        this.totalSteps = i11;
        this.title = title;
        this.subtitle = subtitle;
        this.completed = z10;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getCompleted() {
        return this.completed;
    }

    /* renamed from: b, reason: from getter */
    public final int getStepIndex() {
        return this.stepIndex;
    }

    /* renamed from: c, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstallProgress)) {
            return false;
        }
        InstallProgress installProgress = (InstallProgress) other;
        return this.stepIndex == installProgress.stepIndex && this.totalSteps == installProgress.totalSteps && kotlin.jvm.internal.p.d(this.title, installProgress.title) && kotlin.jvm.internal.p.d(this.subtitle, installProgress.subtitle) && this.completed == installProgress.completed;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.stepIndex) * 31) + Integer.hashCode(this.totalSteps)) * 31) + this.title.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + Boolean.hashCode(this.completed);
    }

    public String toString() {
        return "InstallProgress(stepIndex=" + this.stepIndex + ", totalSteps=" + this.totalSteps + ", title=" + this.title + ", subtitle=" + this.subtitle + ", completed=" + this.completed + ")";
    }
}
