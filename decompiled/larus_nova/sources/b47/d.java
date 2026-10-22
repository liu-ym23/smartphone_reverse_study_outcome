package b47;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.utils.GsonUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public class d implements com.bytedance.pia.core.tracing.d.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<EventName> f17584c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsonObject f17585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<EventName> f17586b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17587a = null;

        static {
            int[] r100 = new int[EventName.values().length];
            f17587a = r100;
            r100[EventName.NavigateStart.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f17587a[EventName.WorkerEnvironmentInitializeStart.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f17587a[EventName.WorkerEnvironmentInitializeEnd.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f17587a[EventName.WorkerScriptRequestStart.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f17587a[EventName.WorkerScriptRequestEnd.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f17587a[EventName.WorkerExecuteStart.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        f17584c = Arrays.asList(new EventName[]{EventName.NavigateStart, EventName.WorkerEnvironmentInitializeStart, EventName.WorkerEnvironmentInitializeEnd, EventName.WorkerScriptRequestStart, EventName.WorkerScriptRequestEnd, EventName.WorkerExecuteStart});
    }

    public void a() {
        throw null;
    }

    @Override // com.bytedance.pia.core.tracing.d.b
    public final boolean isFinished() {
        return ((HashSet) this.f17586b).isEmpty();
    }

    public d() {
        this.f17585a = new JsonObject();
        this.f17586b = new HashSet(f17584c);
    }

    @Override // l47.a
    public final void accept(com.bytedance.pia.core.tracing.d.a r100) {
        com.bytedance.pia.core.tracing.d.a r101 = r100;
        if (isFinished() == true) goto L22;
        Set<EventName> r102 = this.f17586b;
        HashSet r103 = (HashSet) r102;
        if (r103.contains(r101.name) == false) goto L23;
        Set<EventName> r104 = this.f17586b;
        HashSet r105 = (HashSet) r104;
        r105.remove(r101.name);
        switch(a.f17587a[r101.name.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            default: goto L18;
        };
    L11:
        b(r101, "WR", "t");
        goto L18
    L12:
        b(r101, "RW", "e");
        goto L18
    L13:
        b(r101, "RW", "s");
        goto L18
    L14:
        b(r101, "WEI", "e");
        goto L18
    L15:
        b(r101, "WEI", "s");
        goto L18
    L16:
        b(r101, "NAVS", "t");
    L18:
        if (isFinished() == false) goto L21;
        a();
        return;
    L21:
        return;
    L23:
        return;
    }

    public final void b(com.bytedance.pia.core.tracing.d.a r100, String r101, String r102) {
        JsonElement r103 = this.f17585a.get(r101);
        if (r103 != null) goto L5;
    L7:
        JsonObject r104 = new JsonObject();
    L8:
        r104.addProperty(r102, r100.timestamp);
        JsonElement r105 = GsonProtectorUtils.toJsonTree(GsonUtils.b(), r100.args);
        if (r105.isJsonObject() == false) goto L14;
        Iterator<Map.Entry<String, JsonElement>> r106 = r105.getAsJsonObject().entrySet().iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        Map.Entry<String, JsonElement> r107 = r106.next();
        r104.add(r107.getKey(), r107.getValue());
    L14:
        this.f17585a.add(r101, r104);
        return;
    L5:
        if (r103.isJsonObject() == false) goto L7;
        r104 = r103.getAsJsonObject();
        goto L8
    }
}
