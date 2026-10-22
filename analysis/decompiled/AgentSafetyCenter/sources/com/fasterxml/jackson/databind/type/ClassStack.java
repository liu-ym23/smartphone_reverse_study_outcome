package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class ClassStack {
    protected final Class<?> _current;
    protected final ClassStack _parent;
    private ArrayList<ResolvedRecursiveType> _selfRefs;

    private ClassStack(ClassStack classStack, Class<?> cls) {
        this._parent = classStack;
        this._current = cls;
    }

    public void addSelfReference(ResolvedRecursiveType resolvedRecursiveType) {
        if (this._selfRefs == null) {
            this._selfRefs = new ArrayList<>();
        }
        this._selfRefs.add(resolvedRecursiveType);
    }

    public ClassStack child(Class<?> cls) {
        return new ClassStack(this, cls);
    }

    public ClassStack find(Class<?> cls) {
        if (this._current == cls) {
            return this;
        }
        do {
            this = this._parent;
            if (this == null) {
                return null;
            }
        } while (this._current != cls);
        return this;
    }

    public void resolveSelfReferences(JavaType javaType) {
        ArrayList<ResolvedRecursiveType> arrayList = this._selfRefs;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                ResolvedRecursiveType resolvedRecursiveType = arrayList.get(i);
                i++;
                resolvedRecursiveType.setReference(javaType);
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[ClassStack (self-refs: ");
        ArrayList<ResolvedRecursiveType> arrayList = this._selfRefs;
        sb2.append(arrayList == null ? "0" : String.valueOf(arrayList.size()));
        sb2.append(')');
        while (this != null) {
            sb2.append(' ');
            sb2.append(this._current.getName());
            this = this._parent;
        }
        sb2.append(']');
        return sb2.toString();
    }

    public ClassStack(Class<?> cls) {
        this(null, cls);
    }
}
