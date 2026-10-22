package androidx.work.impl.model;

/* JADX INFO: loaded from: classes17.dex */
public class SystemIdInfo {
    public final int systemId;
    public final String workSpecId;

    public int hashCode() {
        return (this.workSpecId.hashCode() * 31) + this.systemId;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemIdInfo) == true) goto L8;
        return false;
    L8:
        SystemIdInfo r101 = (SystemIdInfo) r100;
        if (this.systemId == r101.systemId) goto L12;
        return false;
    L12:
        return this.workSpecId.equals(r101.workSpecId);
    }

    public SystemIdInfo(String r100, int r101) {
        this.workSpecId = r100;
        this.systemId = r101;
    }
}
