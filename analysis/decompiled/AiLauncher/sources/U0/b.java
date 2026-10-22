package U0;

import Xa.k;
import Y8.j;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import g1.e;
import g1.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import x0.c;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0087\u0002¢\u0006\u0004\b\u000b\u0010\fR%\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR(\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00160\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u000fR+\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00160\r8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0014\u0010\u001d¨\u0006\u001f"}, d2 = {"LU0/b;", "", "", "", "initialState", "<init>", "(Ljava/util/Map;)V", ExifInterface.GPS_DIRECTION_TRUE, "key", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/Object;)V", "", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", "getRegular", "()Ljava/util/Map;", "regular", "Lg1/e$b;", Const.INTENT_KEY_PKGNAME, "providers", "LXa/k;", "c", "flows", "getMutableFlows", "mutableFlows", "e", "Lg1/e$b;", "()Lg1/e$b;", "savedStateProvider", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map<String, Object> regular;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<String, e.b> providers;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<String, k<Object>> flows;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Map<String, k<Object>> mutableFlows;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final e.b savedStateProvider;

    public b(Map<String, ? extends Object> initialState) {
        p.i(initialState, "initialState");
        this.regular = kotlin.collections.a.C(initialState);
        this.providers = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.mutableFlows = new LinkedHashMap();
        this.savedStateProvider = new e.b() { // from class: U0.a
            @Override // g1.e.b
            public final Bundle a() {
                return b.c(this.f6164a);
            }
        };
    }

    public static final Bundle c(b bVar) {
        Pair[] pairArr;
        for (Map.Entry entry : kotlin.collections.a.A(bVar.mutableFlows).entrySet()) {
            bVar.d((String) entry.getKey(), ((k) entry.getValue()).getValue());
        }
        for (Map.Entry entry2 : kotlin.collections.a.A(bVar.providers).entrySet()) {
            bVar.d((String) entry2.getKey(), ((e.b) entry2.getValue()).a());
        }
        Map<String, Object> map = bVar.regular;
        if (map.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, Object> entry3 : map.entrySet()) {
                arrayList.add(j.a(entry3.getKey(), entry3.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleA = c.a((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        i.a(bundleA);
        return bundleA;
    }

    /* renamed from: b, reason: from getter */
    public final e.b getSavedStateProvider() {
        return this.savedStateProvider;
    }

    public final <T> void d(String key, T value) {
        p.i(key, "key");
        this.regular.put(key, value);
        k<Object> kVar = this.flows.get(key);
        if (kVar != null) {
            kVar.setValue(value);
        }
        k<Object> kVar2 = this.mutableFlows.get(key);
        if (kVar2 != null) {
            kVar2.setValue(value);
        }
    }

    public /* synthetic */ b(Map map, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? kotlin.collections.a.i() : map);
    }
}
