package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.Marker;

/* loaded from: classes5.dex */
public class b implements vc.b {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<String, Marker> f37941a = new ConcurrentHashMap();

    @Override // vc.b
    public Marker a(String str) {
        Marker markerPutIfAbsent;
        if (str == null) {
            throw new IllegalArgumentException("Marker name cannot be null");
        }
        Marker basicMarker = this.f37941a.get(str);
        return (basicMarker != null || (markerPutIfAbsent = this.f37941a.putIfAbsent(str, (basicMarker = new BasicMarker(str)))) == null) ? basicMarker : markerPutIfAbsent;
    }
}
