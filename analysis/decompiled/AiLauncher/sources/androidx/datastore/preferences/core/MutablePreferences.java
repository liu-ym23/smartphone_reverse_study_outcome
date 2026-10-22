package androidx.datastore.preferences.core;

import M0.a;
import Z8.F;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0004\b\r\u0010\fJ&\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J,\u0010\u0016\u001a\u00020\n\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0015\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0018\u001a\u00020\n2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0018\u0010\u0017J)\u0010\u001c\u001a\u00020\n2\u001a\u0010\u001b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0019\"\u0006\u0012\u0002\b\u00030\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u001e\u0010\u0011J\u001a\u0010 \u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'R*\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010\u0014R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010+¨\u0006-"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "LM0/a;", "", "LM0/a$a;", "", "preferencesMap", "", "startFrozen", "<init>", "(Ljava/util/Map;Z)V", "LY8/t;", "e", "()V", "f", ExifInterface.GPS_DIRECTION_TRUE, "key", Const.INTENT_KEY_PKGNAME, "(LM0/a$a;)Ljava/lang/Object;", "", Const.INTENT_KEY_APIKEY, "()Ljava/util/Map;", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LM0/a$a;Ljava/lang/Object;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", "LM0/a$b;", "pairs", Const.INTENT_KEY_BACKGROUND_COMMAND, "([LM0/a$b;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/Map;", "getPreferencesMap$datastore_preferences_core", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "frozen", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class MutablePreferences extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map<a.C0079a<?>, Object> preferencesMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean frozen;

    /* JADX WARN: Multi-variable type inference failed */
    public MutablePreferences() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    @Override // M0.a
    public Map<a.C0079a<?>, Object> a() {
        Map<a.C0079a<?>, Object> mapUnmodifiableMap = Collections.unmodifiableMap(this.preferencesMap);
        p.h(mapUnmodifiableMap, "unmodifiableMap(preferencesMap)");
        return mapUnmodifiableMap;
    }

    @Override // M0.a
    public <T> T b(a.C0079a<T> key) {
        p.i(key, "key");
        return (T) this.preferencesMap.get(key);
    }

    public final void e() {
        if (this.frozen.get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public boolean equals(Object other) {
        if (other instanceof MutablePreferences) {
            return p.d(this.preferencesMap, ((MutablePreferences) other).preferencesMap);
        }
        return false;
    }

    public final void f() {
        this.frozen.set(true);
    }

    public final void g(a.b<?>... pairs) {
        p.i(pairs, "pairs");
        e();
        for (a.b<?> bVar : pairs) {
            j(bVar.a(), bVar.b());
        }
    }

    public final <T> T h(a.C0079a<T> key) {
        p.i(key, "key");
        e();
        return (T) this.preferencesMap.remove(key);
    }

    public int hashCode() {
        return this.preferencesMap.hashCode();
    }

    public final <T> void i(a.C0079a<T> key, T value) {
        p.i(key, "key");
        j(key, value);
    }

    public final void j(a.C0079a<?> key, Object value) {
        p.i(key, "key");
        e();
        if (value == null) {
            h(key);
            return;
        }
        if (!(value instanceof Set)) {
            this.preferencesMap.put(key, value);
            return;
        }
        Map<a.C0079a<?>, Object> map = this.preferencesMap;
        Set setUnmodifiableSet = Collections.unmodifiableSet(F.r1((Iterable) value));
        p.h(setUnmodifiableSet, "unmodifiableSet(value.toSet())");
        map.put(key, setUnmodifiableSet);
    }

    public String toString() {
        return F.A0(this.preferencesMap.entrySet(), ",\n", "{\n", "\n}", 0, null, new InterfaceC5074l<Map.Entry<a.C0079a<?>, Object>, CharSequence>() { // from class: androidx.datastore.preferences.core.MutablePreferences.toString.1
            @Override // p9.InterfaceC5074l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(Map.Entry<a.C0079a<?>, Object> entry) {
                p.i(entry, "entry");
                return "  " + entry.getKey().getName() + " = " + entry.getValue();
            }
        }, 24, null);
    }

    public /* synthetic */ MutablePreferences(Map map, boolean z10, int i10, i iVar) {
        this((i10 & 1) != 0 ? new LinkedHashMap() : map, (i10 & 2) != 0 ? true : z10);
    }

    public MutablePreferences(Map<a.C0079a<?>, Object> preferencesMap, boolean z10) {
        p.i(preferencesMap, "preferencesMap");
        this.preferencesMap = preferencesMap;
        this.frozen = new AtomicBoolean(z10);
    }
}
