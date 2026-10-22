package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class a implements xc.f {

    /* renamed from: a, reason: collision with root package name */
    public final k f37938a = new k();

    /* renamed from: b, reason: collision with root package name */
    public final InheritableThreadLocal<Map<String, String>> f37939b = new C0490a();

    /* renamed from: org.slf4j.helpers.a$a, reason: collision with other inner class name */
    public class C0490a extends InheritableThreadLocal<Map<String, String>> {
        public C0490a() {
        }

        @Override // java.lang.InheritableThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<String, String> childValue(Map<String, String> map) {
            if (map == null) {
                return null;
            }
            return new HashMap(map);
        }
    }

    @Override // xc.f
    public Map<String, String> a() {
        Map<String, String> map = this.f37939b.get();
        if (map != null) {
            return new HashMap(map);
        }
        return null;
    }

    @Override // xc.f
    public void b(Map<String, String> map) {
        this.f37939b.set(map != null ? new HashMap(map) : null);
    }

    @Override // xc.f
    public void clear() {
        Map<String, String> map = this.f37939b.get();
        if (map != null) {
            map.clear();
            this.f37939b.remove();
        }
    }
}
