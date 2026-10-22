package dg;

import kotlinx.coroutines.scheduling.TaskContext;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements TaskContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19209a;

    public h(int r10) {
        this.f19209a = r10;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int getTaskMode() {
        return this.f19209a;
    }
}
