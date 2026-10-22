package f5;

import java.util.LinkedHashMap;
import java.util.Map;
import q7.k;
import u4.h;
import w7.e0;

/* loaded from: classes.dex */
public final class d extends LinkedHashMap {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3442f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f3443g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i2, Object obj) {
        super(16, 0.75f, true);
        this.f3442f = i2;
        this.f3443g = obj;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        switch (this.f3442f) {
            case 0:
                if (obj instanceof String) {
                    break;
                }
                break;
            case 1:
                if (obj instanceof String) {
                    break;
                }
                break;
            default:
                if (obj instanceof String) {
                    break;
                }
                break;
        }
        return super.containsKey((String) obj);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        switch (this.f3442f) {
            case 0:
                if (obj instanceof c) {
                    return super.containsValue((c) obj);
                }
                return false;
            case 1:
                if (obj instanceof h5.a) {
                    return super.containsValue((h5.a) obj);
                }
                return false;
            default:
                if (obj instanceof u4.f) {
                    return super.containsValue((u4.f) obj);
                }
                return false;
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        switch (this.f3442f) {
            case 0:
                if (obj instanceof String) {
                    return (c) super.get((String) obj);
                }
                return null;
            case 1:
                if (obj instanceof String) {
                    return (h5.a) super.get((String) obj);
                }
                return null;
            default:
                if (obj instanceof String) {
                    return (u4.f) super.get((String) obj);
                }
                return null;
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        switch (this.f3442f) {
            case 0:
                return !(obj instanceof String) ? obj2 : (c) super.getOrDefault((String) obj, (c) obj2);
            case 1:
                return !(obj instanceof String) ? obj2 : (h5.a) super.getOrDefault((String) obj, (h5.a) obj2);
            default:
                return !(obj instanceof String) ? obj2 : (u4.f) super.getOrDefault((String) obj, (u4.f) obj2);
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        switch (this.f3442f) {
            case 0:
                if (obj instanceof String) {
                    return (c) super.remove((String) obj);
                }
                return null;
            case 1:
                if (obj instanceof String) {
                    return (h5.a) super.remove((String) obj);
                }
                return null;
            default:
                if (obj instanceof String) {
                    return (u4.f) super.remove((String) obj);
                }
                return null;
        }
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry entry) {
        switch (this.f3442f) {
            case 0:
                k.e(entry, "eldest");
                return ((f) this.f3443g).f3453i > ((f) this.f3443g).f3446b;
            case 1:
                k.e(entry, "eldest");
                return super.size() > ((h5.b) this.f3443g).f4181b;
            default:
                k.e(entry, "eldest");
                int size = super.size();
                h hVar = (h) this.f3443g;
                if (size <= 32) {
                    return false;
                }
                try {
                    ((u4.f) entry.getValue()).f10062a.flush();
                    ((u4.f) entry.getValue()).f10062a.close();
                } catch (Throwable th) {
                    e0.n(th);
                }
                hVar.f10075g.decrementAndGet();
                return true;
        }
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        switch (this.f3442f) {
            case 0:
                if ((obj instanceof String) && (obj2 instanceof c)) {
                    return super.remove((String) obj, (c) obj2);
                }
                return false;
            case 1:
                if ((obj instanceof String) && (obj2 instanceof h5.a)) {
                    return super.remove((String) obj, (h5.a) obj2);
                }
                return false;
            default:
                if ((obj instanceof String) && (obj2 instanceof u4.f)) {
                    return super.remove((String) obj, (u4.f) obj2);
                }
                return false;
        }
    }
}
