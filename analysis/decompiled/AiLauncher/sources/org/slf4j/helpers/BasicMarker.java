package org.slf4j.helpers;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Marker;

/* loaded from: classes5.dex */
public class BasicMarker implements Marker {

    /* renamed from: a, reason: collision with root package name */
    public final String f37931a;

    /* renamed from: b, reason: collision with root package name */
    public final List<Marker> f37932b = new CopyOnWriteArrayList();

    public BasicMarker(String str) {
        if (str == null) {
            throw new IllegalArgumentException("A marker name cannot be null");
        }
        this.f37931a = str;
    }

    public boolean a() {
        return this.f37932b.size() > 0;
    }

    public Iterator<Marker> b() {
        return this.f37932b.iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Marker)) {
            return this.f37931a.equals(((Marker) obj).getName());
        }
        return false;
    }

    @Override // org.slf4j.Marker
    public String getName() {
        return this.f37931a;
    }

    public int hashCode() {
        return this.f37931a.hashCode();
    }

    public String toString() {
        if (!a()) {
            return getName();
        }
        Iterator<Marker> itB = b();
        StringBuilder sb2 = new StringBuilder(getName());
        sb2.append(' ');
        sb2.append("[ ");
        while (itB.hasNext()) {
            sb2.append(itB.next().getName());
            if (itB.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(" ]");
        return sb2.toString();
    }
}
