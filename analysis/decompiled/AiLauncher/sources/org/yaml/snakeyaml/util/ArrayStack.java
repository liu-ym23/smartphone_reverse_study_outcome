package org.yaml.snakeyaml.util;

import java.util.ArrayList;

/* loaded from: classes5.dex */
public class ArrayStack<T> {
    private final ArrayList<T> stack;

    public ArrayStack(int i10) {
        this.stack = new ArrayList<>(i10);
    }

    public void clear() {
        this.stack.clear();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public T pop() {
        return this.stack.remove(r1.size() - 1);
    }

    public void push(T t10) {
        this.stack.add(t10);
    }
}
