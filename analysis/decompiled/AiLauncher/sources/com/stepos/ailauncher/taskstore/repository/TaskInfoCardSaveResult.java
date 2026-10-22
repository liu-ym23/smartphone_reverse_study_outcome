package com.stepos.ailauncher.taskstore.repository;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/taskstore/repository/b;", "", "", "written", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "<init>", "(ZLcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_PKGNAME, "()Z", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.repository.b, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TaskInfoCardSaveResult {
    private final TaskInfoCard card;
    private final boolean written;

    public TaskInfoCardSaveResult(boolean z10, TaskInfoCard card) {
        p.i(card, "card");
        this.written = z10;
        this.card = card;
    }

    /* renamed from: a, reason: from getter */
    public final TaskInfoCard getCard() {
        return this.card;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getWritten() {
        return this.written;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskInfoCardSaveResult)) {
            return false;
        }
        TaskInfoCardSaveResult taskInfoCardSaveResult = (TaskInfoCardSaveResult) other;
        return this.written == taskInfoCardSaveResult.written && p.d(this.card, taskInfoCardSaveResult.card);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.written) * 31) + this.card.hashCode();
    }

    public String toString() {
        return "TaskInfoCardSaveResult(written=" + this.written + ", card=" + this.card + ")";
    }
}
