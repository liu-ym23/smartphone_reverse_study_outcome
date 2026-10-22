package com.bytedance.bdtracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class n1 {
    public final LinkedList<e4> a = new LinkedList<>();
    public final LinkedList<String> b = new LinkedList<>();

    public int a(ArrayList<e4> arrayList, d dVar, j0 j0Var) {
        int size;
        synchronized (this.a) {
            size = this.a.size();
            Iterator<e4> it = this.a.iterator();
            while (it.hasNext()) {
                e4 next = it.next();
                j0Var.a(dVar, next, arrayList);
                arrayList.add(next);
            }
            this.a.clear();
        }
        return size;
    }

    public void a(e4 e4Var) {
        synchronized (this.a) {
            if (this.a.size() > 300) {
                this.a.poll();
            }
            this.a.add(e4Var);
        }
    }

    public void a(String[] strArr) {
        synchronized (this.b) {
            if (this.b.size() > 300) {
                this.b.poll();
            }
            this.b.addAll(Arrays.asList(strArr));
        }
    }
}
