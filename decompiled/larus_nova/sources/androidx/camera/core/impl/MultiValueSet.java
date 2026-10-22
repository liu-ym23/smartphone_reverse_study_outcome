package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MultiValueSet<C> {
    private Set<C> mSet;

    public abstract MultiValueSet<C> clone();

    public List<C> getAllItems() {
        return Collections.unmodifiableList(new ArrayList(this.mSet));
    }

    public MultiValueSet() {
        this.mSet = new HashSet();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1clone() throws CloneNotSupportedException {
        return clone();
    }

    public void addAll(List<C> r100) {
        this.mSet.addAll(r100);
    }
}
