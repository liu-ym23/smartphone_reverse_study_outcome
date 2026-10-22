package androidx.work.impl.model;

/* JADX INFO: loaded from: classes17.dex */
public class Dependency {
    public final String prerequisiteId;
    public final String workSpecId;

    public Dependency(String r100, String r101) {
        this.workSpecId = r100;
        this.prerequisiteId = r101;
    }
}
