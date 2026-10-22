package org.apache.commons.math.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.math.MathException;

/* JADX INFO: loaded from: classes3.dex */
public class TransformerMap implements NumberTransformer, Serializable {
    private static final long serialVersionUID = 4605318041528645258L;
    private NumberTransformer defaultTransformer;
    private Map<Class<?>, NumberTransformer> map;

    public TransformerMap() {
        this.defaultTransformer = null;
        this.map = null;
        this.map = new HashMap();
        this.defaultTransformer = new DefaultTransformer();
    }

    public boolean containsClass(Class<?> key) {
        return this.map.containsKey(key);
    }

    public boolean containsTransformer(NumberTransformer value) {
        return this.map.containsValue(value);
    }

    public NumberTransformer getTransformer(Class<?> key) {
        return this.map.get(key);
    }

    public NumberTransformer putTransformer(Class<?> key, NumberTransformer transformer) {
        return this.map.put(key, transformer);
    }

    public NumberTransformer removeTransformer(Class<?> key) {
        return this.map.remove(key);
    }

    public void clear() {
        this.map.clear();
    }

    public Set<Class<?>> classes() {
        return this.map.keySet();
    }

    public Collection<NumberTransformer> transformers() {
        return this.map.values();
    }

    @Override // org.apache.commons.math.util.NumberTransformer
    public double transform(Object o) throws MathException {
        if ((o instanceof Number) == false) goto L5;
    L10:
        double value = this.defaultTransformer.transform(o);
        return value;
    L5:
        if ((o instanceof String) == true) goto L10;
        NumberTransformer trans = getTransformer(o.getClass());
        if (trans == null) goto L12;
        double value2 = trans.transform(o);
        return value2;
    L12:
        return Double.NaN;
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if ((other instanceof TransformerMap) == false) goto L21;
        TransformerMap rhs = (TransformerMap) other;
        if (this.defaultTransformer.equals(rhs.defaultTransformer) == true) goto L11;
        return false;
    L11:
        if (this.map.size() == rhs.map.size()) goto L13;
        return false;
    L13:
        Iterator<Map.Entry<Class<?>, NumberTransformer>> r3 = this.map.entrySet().iterator();
    L15:
        if (r3.hasNext() == false) goto L20;
        Map.Entry<Class<?>, NumberTransformer> entry = r3.next();
        if (entry.getValue().equals(rhs.map.get(entry.getKey())) == true) goto L15;
        return false;
    L20:
        return true;
    L21:
        return false;
    }

    public int hashCode() {
        int hash = this.defaultTransformer.hashCode();
        Iterator<NumberTransformer> r1 = this.map.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        NumberTransformer t = r1.next();
        hash = (hash * 31) + t.hashCode();
        goto L4
    L6:
        return hash;
    }
}
