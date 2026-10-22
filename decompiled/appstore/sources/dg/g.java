package dg;

import kotlinx.coroutines.scheduling.TaskContext;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f19207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TaskContext f19208b;

    public g(long r10, TaskContext r11) {
        this.f19207a = r10;
        this.f19208b = r11;
    }

    public g() {
        this(0, j.f19217g);
    }
}
