package c2;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedList f6033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6034b;

    public a(int r10) {
        this.f6033a = new LinkedList();
        this.f6034b = r10;
    }

    public void a(Object r10) {
        if (this.f6033a.size() <= this.f6034b) goto L5;
        this.f6033a.removeFirst();
    L5:
        this.f6033a.addLast(r10);
    }

    public LinkedList b() {
        return this.f6033a;
    }
}
