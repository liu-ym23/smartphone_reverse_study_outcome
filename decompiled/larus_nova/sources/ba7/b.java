package ba7;

import aa7.m;
import ca7.c;
import ca7.g;
import ca7.l;
import com.bytedance.express.command.FunctionCommand;
import com.bytedance.express.command.IdentifierCommand;
import com.bytedance.express.command.f;
import com.google.gson.JsonObject;
import ga7.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import v97.d;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f18426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, a> f18427b;

    public b() {
        this.f18426a = new a();
        this.f18427b = new HashMap();
    }

    public static List<c> b(a r100, ea7.b r101, int r102) {
        ArrayList r103 = new ArrayList();
        com.bytedance.express.command.b r104 = r101.f471626a;
        if ((r104 instanceof IdentifierCommand) == false) goto L12;
        String r105 = ((IdentifierCommand) r104).getIdentifier();
        HashMap<String, d<?>> r106 = ga7.b.f480571a;
        if (r106.containsKey(r105) == false) goto L8;
        r103.add(r100.a(r106.get(r105).getValue()));
    L42:
        Iterator r107 = r103.iterator();
    L44:
        if (r107.hasNext() == false) goto L46;
        ((c) r107.next()).f(r102);
        goto L44
    L46:
        return r103;
    L8:
        if (e.f480575a.containsKey(r105) == false) goto L10;
        g r108 = r100.b(r105);
        r108.f22962f = true;
        r103.add(r108);
        goto L42
    L10:
        r103.add(r100.b(r105));
        goto L42
    L12:
        if ((r104 instanceof f) == false) goto L15;
        r103.add(r100.a(((f) r104).f243204a));
        goto L42
    L15:
        if ((r104 instanceof com.bytedance.express.command.d) == false) goto L32;
        v97.e r109 = ((com.bytedance.express.command.d) r104).f243202a;
        Map<String, aa7.a> r110 = aa7.e.f2352a;
        if (r109.f553812a.equals("matches") == true) goto L19;
    L21:
        aa7.a r111 = (aa7.a) ((HashMap) aa7.e.f2352a).get(r109.f553812a);
        if (r111 == null) goto L30;
        aa7.a r112 = r111;
    L24:
        List<c> r113 = r112.a(r100, r101, r102);
        Iterator<c> r114 = r113.iterator();
    L26:
        if (r114.hasNext() == false) goto L28;
        r114.next().f(r102);
        goto L26
    L28:
        return r113;
    L30:
        throw new IllegalArgumentException("unsupported graph build operator = " + r109.f553812a);
    L19:
        if (com.bytedance.ruler.d.f267696t == false) goto L21;
        r112 = new m();
        goto L24
    L32:
        if ((r104 instanceof FunctionCommand) == false) goto L42;
        v97.b r115 = ((FunctionCommand) r104).f243192a;
        aa7.a r116 = (aa7.a) ((HashMap) aa7.e.f2353b).get(r115.f553811a);
        if (r116 == null) goto L41;
        List<c> r117 = r116.a(r100, r101, r102);
        Iterator<c> r118 = r117.iterator();
    L37:
        if (r118.hasNext() == false) goto L39;
        r118.next().f(r102);
        goto L37
    L39:
        return r117;
    L41:
        throw new IllegalArgumentException("unsupported graph build func = " + r115.f553811a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(ea7.b r100, int r101, JsonObject r102, fa7.a r103, a r104) {
        r104.getClass();
        String r105 = r102.toString();
        l r106 = r104.f18420b.get(r105);
        if (r106 != null) goto L5;
        r106 = new l(r102);
        r104.f18420b.put(r105, r106);
    L5:
        r106.f22957b = r101;
        ArrayList<ea7.b> r107 = r100.f471627b;     // Catch: Throwable -> L22
        if (r107 != null) goto L9;
    L10:
        com.bytedance.express.command.b r108 = r100.f471626a;     // Catch: Throwable -> L22
        if ((r108 instanceof f) == false) goto L17;
        T r109 = ((f) r108).f243204a;     // Catch: Throwable -> L22
        if ((r109 instanceof Boolean) == true) goto L15;
        return;
    L15:
        if (((Boolean) r109).booleanValue() == false) goto L27;
        r104.f18424f.add(r106);     // Catch: Throwable -> L22
        return;
    L27:
        return;
    L17:
        Iterator<c> r110 = b(r104, r100, r101).iterator();     // Catch: Throwable -> L22
    L19:
        if (r110.hasNext() == false) goto L29;
        r110.next().a(r106);     // Catch: Throwable -> L22
        goto L19
    L29:
        return;
    L9:
        if (r107.isEmpty() == false) goto L17;
    L22:
        r104.f18423e.add(r103);
    }
}
