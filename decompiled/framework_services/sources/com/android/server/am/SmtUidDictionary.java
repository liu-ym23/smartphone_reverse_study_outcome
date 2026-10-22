package com.android.server.am;

import android.util.SparseArray;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SmtUidDictionary<T> {
    private SparseArray<T> uidOther;
    protected Set<Integer> uidSets;
    private Object[] uidSystem;
    private Object[] uidUserLevel1;
    private Object[] uidUserLevel2;

    public SmtUidDictionary() {
        this.uidSystem = new Object[50];
        this.uidUserLevel1 = new Object[200];
        this.uidUserLevel2 = new Object[20];
        this.uidOther = new SparseArray(50);
        this.uidSets = new HashSet(150);
    }

    public void setValueByUid(int uid, T value, boolean needSynchronize) {
        if (needSynchronize == false) goto L4;
        setValueByUidLocked(uid, value);
        return;
    L4:
        setValueByUidInner(uid, value);
    }

    public T getValueByUid(int uid, boolean needSynchronize) {
        if (needSynchronize == false) goto L6;
        return getValueByUidLocked(uid);
    L6:
        return getValueByUidInner(uid);
    }

    public Set<Integer> getAllUidSet() {
        return this.uidSets;
    }

    public int getSize() {
        return this.uidSets.size();
    }

    private void setValueByUidLocked(int uid, T value) {
        monitor-enter(this);
        setValueByUidInner(uid, value);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void setValueByUidInner(int uid, T value) {
        if (uid < 1000) goto L13;
        if (uid >= 1100) goto L13;
        int key = uid - 1000;
        if (key >= 50) goto L9;
    L11:
        this.uidSystem[key] = value;
    L43:
        if (value != null) goto L45;
        this.uidSets.remove(Integer.valueOf(uid));
        return;
    L45:
        this.uidSets.add(Integer.valueOf(uid));
        return;
    L9:
        if ((this.uidSystem.length - 1) >= key) goto L11;
        this.uidSystem = enlargeArray(this.uidSystem, 100);
    L13:
        if (uid < 10000) goto L33;
        if (uid >= 10500) goto L33;
        int key2 = uid + ProcessList.INVALID_ADJ;
        if (key2 < 400) goto L22;
        if ((this.uidUserLevel1.length - 1) >= key2) goto L31;
        this.uidUserLevel1 = enlargeArray(this.uidUserLevel1, 500);
    L31:
        this.uidUserLevel1[key2] = value;
        goto L43
    L22:
        if (key2 < 300) goto L27;
        if ((this.uidUserLevel1.length - 1) >= key2) goto L31;
        this.uidUserLevel1 = enlargeArray(this.uidUserLevel1, 400);
        goto L31
    L27:
        if (key2 < 200) goto L31;
        if ((this.uidUserLevel1.length - 1) >= key2) goto L31;
        this.uidUserLevel1 = enlargeArray(this.uidUserLevel1, 300);
    L33:
        if (uid >= 20000) goto L35;
    L42:
        this.uidOther.put(uid, value);
        goto L43
    L35:
        if (uid >= 20100) goto L42;
        int key3 = uid - 20000;
        if (key3 >= 20) goto L39;
    L41:
        this.uidUserLevel2[key3] = value;
        goto L43
    L39:
        if ((this.uidUserLevel2.length - 1) >= key3) goto L41;
        this.uidUserLevel2 = enlargeArray(this.uidUserLevel2, 100);
        goto L41
    }

    private static Object[] enlargeArray(Object[] srcArr, int enlargeLength) {
        Object[] destArr = new Object[enlargeLength];
        System.arraycopy(srcArr, 0, destArr, 0, srcArr.length);
        return destArr;
    }

    private T getValueByUidLocked(int uid) {
        monitor-enter(this);
        T r0 = getValueByUidInner(uid);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private T getValueByUidInner(int r4) {
        Object r0 = null;
        if (r4 < 1000) goto L10;
        if (r4 >= 1100) goto L10;
        int r1 = r4 - 1000;
        if (r1 >= this.uidSystem.length) goto L24;
        r0 = this.uidSystem[r1];
    L24:
        if (r0 != null) goto L28;
        return null;
    L28:
        return (T) r0;
    L10:
        if (r4 < 10000) goto L17;
        if (r4 >= 10500) goto L17;
        int r2 = r4 + ProcessList.INVALID_ADJ;
        if (r2 >= this.uidUserLevel1.length) goto L24;
        r0 = this.uidUserLevel1[r2];
    L17:
        if (r4 >= 20000) goto L19;
    L23:
        r0 = this.uidOther.get(r4);
        goto L24
    L19:
        if (r4 >= 20100) goto L23;
        int r3 = r4 - 20000;
        if (r3 >= this.uidUserLevel2.length) goto L24;
        r0 = this.uidUserLevel2[r3];
        goto L24
    }
}
