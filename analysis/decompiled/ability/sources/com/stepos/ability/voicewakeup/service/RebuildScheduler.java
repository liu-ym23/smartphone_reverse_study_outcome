package com.stepos.ability.voicewakeup.service;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ability/voicewakeup/service/RebuildScheduler;", "", "", "delayMs", "Lkotlin/Function0;", "LC7/r;", "task", "Lcom/stepos/ability/voicewakeup/service/RebuildScheduler$Cancellable;", "schedule", "(JLS7/a;)Lcom/stepos/ability/voicewakeup/service/RebuildScheduler$Cancellable;", "Cancellable", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface RebuildScheduler {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/voicewakeup/service/RebuildScheduler$Cancellable;", "", "LC7/r;", "cancel", "()V", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Cancellable {
        void cancel();
    }

    Cancellable schedule(long delayMs, S7.a task);
}
