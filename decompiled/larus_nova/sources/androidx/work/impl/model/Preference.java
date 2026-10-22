package androidx.work.impl.model;

/* JADX INFO: loaded from: classes17.dex */
public class Preference {
    public String mKey;
    public Long mValue;

    public int hashCode() {
        int r100 = this.mKey.hashCode() * 31;
        Long r101 = this.mValue;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Preference) == true) goto L8;
        return false;
    L8:
        Preference r101 = (Preference) r100;
        if (this.mKey.equals(r101.mKey) == true) goto L11;
        return false;
    L11:
        Long r102 = this.mValue;
        Long r103 = r101.mValue;
        if (r102 != null) goto L18;
        if (r103 == null) goto L19;
        return false;
    L19:
        return true;
    L18:
        return r102.equals(r103);
    }

    public Preference(String r100, long r101) {
        this.mKey = r100;
        this.mValue = Long.valueOf(r101);
    }

    public Preference(String r100, boolean r101) {
        if (r101 == false) goto L4;
        long r102 = 1;
    L5:
        this(r100, r102);
        return;
    L4:
        r102 = 0;
        goto L5
    }
}
