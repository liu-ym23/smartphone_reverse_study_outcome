package com.airbnb.lottie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class KeyPath {
    public static final KeyPath COMPOSITION = new KeyPath("COMPOSITION");
    private final List<String> keys;
    private KeyPathElement resolvedElement;

    public KeyPath(String... strArr) {
        this.keys = Arrays.asList(strArr);
    }

    private boolean endsWithGlobstar() {
        return this.keys.get(r1.size() - 1).equals("**");
    }

    private boolean isContainer(String str) {
        return "__container".equals(str);
    }

    public KeyPath addKey(String str) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.keys.add(str);
        return keyPath;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            KeyPath keyPath = (KeyPath) obj;
            if (!this.keys.equals(keyPath.keys)) {
                return false;
            }
            KeyPathElement keyPathElement = this.resolvedElement;
            if (keyPathElement != null) {
                return keyPathElement.equals(keyPath.resolvedElement);
            }
            if (keyPath.resolvedElement == null) {
                return true;
            }
        }
        return false;
    }

    public boolean fullyResolvesTo(String str, int i10) {
        if (i10 >= this.keys.size()) {
            return false;
        }
        boolean z10 = i10 == this.keys.size() - 1;
        String str2 = this.keys.get(i10);
        if (!str2.equals("**")) {
            return (z10 || (i10 == this.keys.size() + (-2) && endsWithGlobstar())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z10 && this.keys.get(i10 + 1).equals(str)) {
            return i10 == this.keys.size() + (-2) || (i10 == this.keys.size() + (-3) && endsWithGlobstar());
        }
        if (z10) {
            return true;
        }
        int i11 = i10 + 1;
        if (i11 < this.keys.size() - 1) {
            return false;
        }
        return this.keys.get(i11).equals(str);
    }

    public KeyPathElement getResolvedElement() {
        return this.resolvedElement;
    }

    public int hashCode() {
        int iHashCode = this.keys.hashCode() * 31;
        KeyPathElement keyPathElement = this.resolvedElement;
        return iHashCode + (keyPathElement != null ? keyPathElement.hashCode() : 0);
    }

    public int incrementDepthBy(String str, int i10) {
        if (isContainer(str)) {
            return 0;
        }
        if (this.keys.get(i10).equals("**")) {
            return (i10 != this.keys.size() - 1 && this.keys.get(i10 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public String keysToString() {
        return this.keys.toString();
    }

    public boolean matches(String str, int i10) {
        if (isContainer(str)) {
            return true;
        }
        if (i10 >= this.keys.size()) {
            return false;
        }
        return this.keys.get(i10).equals(str) || this.keys.get(i10).equals("**") || this.keys.get(i10).equals("*");
    }

    public boolean propagateToChildren(String str, int i10) {
        return "__container".equals(str) || i10 < this.keys.size() - 1 || this.keys.get(i10).equals("**");
    }

    public KeyPath resolve(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.resolvedElement = keyPathElement;
        return keyPath;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("KeyPath{keys=");
        sb2.append(this.keys);
        sb2.append(",resolved=");
        sb2.append(this.resolvedElement != null);
        sb2.append('}');
        return sb2.toString();
    }

    private KeyPath(KeyPath keyPath) {
        this.keys = new ArrayList(keyPath.keys);
        this.resolvedElement = keyPath.resolvedElement;
    }
}
