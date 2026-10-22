package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Quirks {
    private final List<Quirk> mQuirks;

    public Quirks(List<Quirk> r100) {
        this.mQuirks = new ArrayList(r100);
    }

    public static String toString(Quirks r100) {
        ArrayList r101 = new ArrayList();
        Iterator<Quirk> r102 = r100.mQuirks.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(r102.next().getClass().getSimpleName());
        goto L4
    L6:
        StringBuilder r103 = new StringBuilder();
        Iterator r104 = r101.iterator();
        if (r104.hasNext() == false) goto L12;
    L8:
        r103.append((CharSequence) r104.next());
        if (r104.hasNext() == false) goto L12;
        r103.append(" | ");
    L12:
        return r103.toString();
    }

    public void addQuirkForTesting(Quirk r100) {
        this.mQuirks.add(r100);
    }

    public boolean contains(Class<? extends Quirk> r100) {
        Iterator<Quirk> r101 = this.mQuirks.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r100.isAssignableFrom(r101.next().getClass()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public <T extends Quirk> T get(Class<T> r100) {
        Iterator<Quirk> r101 = this.mQuirks.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        T r102 = (T) r101.next();
        if (r102.getClass() != r100) goto L4;
        return r102;
    L8:
        return null;
    }

    public <T extends Quirk> List<T> getAll(Class<T> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<Quirk> r102 = this.mQuirks.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Quirk r103 = r102.next();
        if (r100.isAssignableFrom(r103.getClass()) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        return r101;
    }
}
