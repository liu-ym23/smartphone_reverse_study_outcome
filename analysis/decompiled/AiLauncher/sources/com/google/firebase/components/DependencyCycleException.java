package com.google.firebase.components;

import h3.C4127c;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class DependencyCycleException extends DependencyException {

    /* renamed from: a, reason: collision with root package name */
    public final List<C4127c<?>> f21797a;

    public DependencyCycleException(List<C4127c<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f21797a = list;
    }
}
