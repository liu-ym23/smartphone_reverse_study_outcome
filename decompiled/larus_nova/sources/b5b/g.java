package b5b;

import a5b.h;
import a5b.n;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotEventType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements a5b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f17811a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<CotEventType> f17812b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17813a = null;

        static {
            int[] r100 = new int[CotEventType.values().length];
            r100[CotEventType.TOOL_CALL_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[CotEventType.TOOL_CALL_ARGS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[CotEventType.TOOL_CALL_CHUNK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[CotEventType.TOOL_CALL_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[CotEventType.TOOL_CALL_RESULT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f17813a = r100;
        }
    }

    public g() {
    }

    static {
        f17811a = new g();
        f17812b = SetsKt.setOf(new CotEventType[]{CotEventType.TOOL_CALL_START, CotEventType.TOOL_CALL_ARGS, CotEventType.TOOL_CALL_CHUNK, CotEventType.TOOL_CALL_END, CotEventType.TOOL_CALL_RESULT});
    }

    @Override // a5b.b
    public final Set<CotEventType> a() {
        return f17812b;
    }

    public static void c(n r100, JSONObject r101) {
        String r102 = a5b.e.c(r101, new String[]{"toolCallName", "tool_call_name", "name"});
        boolean r103 = false;
        if (r102.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        r102 = r100.f1926h;
    L8:
        r100.f1926h = r102;
        String r105 = a5b.e.c(r101, new String[]{"title"});
        if (r105.length() != 0) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L14;
        r105 = r100.f1919c;
    L14:
        r100.f1919c = r105;
        String r107 = r101.optString("icon");
        if (r107.length() != 0) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == false) goto L20;
        r107 = r100.f1927i;
    L20:
        r100.f1927i = r107;
        String r109 = a5b.e.c(r101, new String[]{"parentMessageId", "parent_message_id"});
        if (r109.length() != 0) goto L23;
        r103 = true;
    L23:
        if (r103 == false) goto L25;
        r109 = r100.f1932n;
    L25:
        r100.f1932n = r109;
        return;
    L17:
        r108 = false;
        goto L18
    L11:
        r106 = false;
        goto L12
    L5:
        r104 = false;
        goto L6
    }

    @Override // a5b.b
    public final void b(a5b.d r100, CotEvent r101, JSONObject r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "json");
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "json");
        String r104 = a5b.e.c(r102, new String[]{"toolCallId", "tool_call_id"});
        boolean r105 = false;
        boolean r106 = true;
        if (r104.length() != 0) goto L5;
        boolean r107 = true;
    L6:
        if (r107 == false) goto L8;
        r104 = r101.getEventId();
    L8:
        String r108 = "tool:" + r104;
        LinkedHashMap<String, h> r109 = r100.f1911b;
        h r110 = r109.get(r108);
        if (r110 != null) goto L11;
        r110 = new n(r108);
        r109.put(r108, r110);
    L11:
        n r111 = (n) r110;
        int r112 = a.f17813a[r101.getEventType().ordinal()];
        if (r112 != 1) goto L14;
        c(r111, r102);
        r111.b(CotBlockStatus.RUNNING);
        r111.f1922f = true;
        return;
    L14:
        if (r112 != 2) goto L16;
    L79:
        c(r111, r102);
        String r113 = a5b.e.a(r102, r101.getContent());
        if (r113.length() <= 0) goto L82;
        r105 = true;
    L82:
        if (r105 == false) goto L84;
        r111.f1928j.append(r113);
    L84:
        r111.b(CotBlockStatus.RUNNING);
        r111.f1922f = true;
        return;
    L16:
        if (r112 == 3) goto L79;
        String r114 = null;
        if (r112 != 4) goto L20;
        StringBuilder r115 = r111.f1928j;
        if (r115.length() <= 0) goto L63;
        boolean r116 = true;
    L64:
        if (r116 == true) goto L67;
        r115 = null;
    L67:
        if (r115 == null) goto L69;
        String r117 = r115.toString();
    L70:
        if (r117 != null) goto L72;
    L75:
        if (r106 == false) goto L88;
    L78:
        r111.f1929k = r114;
        r111.b(CotBlockStatus.RUNNING);
        r111.f1922f = false;
        return;
    L88:
        r114 = new JSONObject(r117).toString();     // Catch: Exception -> L87
        goto L78
    L72:
        if (StringsKt.isBlank(r117) == true) goto L75;
        r106 = false;
        goto L75
    L69:
        r117 = null;
        goto L70
    L63:
        r116 = false;
        goto L64
    L20:
        if (r112 != 5) goto L93;
        Object r118 = a5b.e.b(r102, new String[]{"content", "result", BdpAppEventConstant.PARAMS_OUTPUT});
        if (r118 != null) goto L25;
    L37:
        r111.f1931m = r114;
        if (r118 == null) goto L41;
        String r119 = a5b.e.d(r118);
        if (r119 == null) goto L41;
    L42:
        r111.setResult(r119);
        String r120 = r111.f1930l;
        if (r120 != null) goto L45;
    L50:
        boolean r121 = false;
    L51:
        if (r121 == true) goto L53;
    L59:
        r111.b(CotBlockStatus.DONE);
        r111.f1922f = false;
        return;
    L53:
        if (r111.f1920d.length() > 0) goto L56;
        r106 = false;
    L56:
        if (r106 == false) goto L58;
        r111.f1920d.append('\n');
    L58:
        r111.f1920d.append(r111.f1930l);
        goto L59
    L45:
        if (r120.length() <= 0) goto L47;
        boolean r122 = true;
    L48:
        if (r122 != true) goto L50;
        r121 = true;
        goto L51
    L47:
        r122 = false;
    L41:
        r119 = r101.getContent();
        goto L42
    L25:
        if (Intrinsics.areEqual(r118, JSONObject.NULL) == true) goto L37;
        if ((r118 instanceof String) == false) goto L31;
        r114 = (String) r118;
        goto L37
    L31:
        if ((r118 instanceof JSONObject) == false) goto L34;
        r114 = ((JSONObject) r118).toString();
        goto L37
    L34:
        if ((r118 instanceof JSONArray) == false) goto L36;
        r114 = ((JSONArray) r118).toString();
        goto L37
    L36:
        r114 = r118.toString();
        goto L37
    L93:
        return;
    L5:
        r107 = false;
        goto L6
    }
}
