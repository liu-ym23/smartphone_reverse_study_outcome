package androidx.work;

import android.net.Network;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class WorkerParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UUID f5378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f5379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set f5380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f5381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Executor f5383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TaskExecutor f5384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f5385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ProgressUpdater f5386i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ForegroundUpdater f5387j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5388k;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f5389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f5390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Network f5391c;

        public a() {
            this.f5389a = Collections.emptyList();
            this.f5390b = Collections.emptyList();
        }
    }

    public WorkerParameters(UUID r10, c r11, Collection r12, a r13, int r14, int r15, Executor r16, TaskExecutor r17, m r18, ProgressUpdater r19, ForegroundUpdater r110) {
        this.f5378a = r10;
        this.f5379b = r11;
        this.f5380c = new HashSet(r12);
        this.f5381d = r13;
        this.f5382e = r14;
        this.f5388k = r15;
        this.f5383f = r16;
        this.f5384g = r17;
        this.f5385h = r18;
        this.f5386i = r19;
        this.f5387j = r110;
    }

    public Executor a() {
        return this.f5383f;
    }

    public ForegroundUpdater b() {
        return this.f5387j;
    }

    public UUID c() {
        return this.f5378a;
    }

    public c d() {
        return this.f5379b;
    }

    public TaskExecutor e() {
        return this.f5384g;
    }

    public m f() {
        return this.f5385h;
    }
}
