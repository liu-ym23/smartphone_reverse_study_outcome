package b5b;

import a5b.h;
import a5b.l;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotEventType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements a5b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f17805a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<CotEventType> f17806b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17807a = null;

        static {
            int[] r100 = new int[CotEventType.values().length];
            r100[CotEventType.STEP_STARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CotEventType.STEP_FINISHED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f17807a = r100;
        }
    }

    public e() {
    }

    static {
        f17805a = new e();
        f17806b = SetsKt.setOf(new CotEventType[]{CotEventType.STEP_STARTED, CotEventType.STEP_FINISHED});
    }

    @Override // a5b.b
    public final Set<CotEventType> a() {
        return f17806b;
    }

    @Override // a5b.b
    public final void b(a5b.d r100, CotEvent r101, JSONObject r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "json");
        Intrinsics.checkNotNullParameter(r102, "json");
        String r104 = a5b.e.c(r102, new String[]{"runId", "run_id"});
        String r105 = a5b.e.c(r102, new String[]{"stepName", "step_name", "name"});
        if (r105.length() != 0) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == false) goto L8;
        r105 = "step";
    L8:
        String r107 = a5b.e.c(r102, new String[]{"stepId", "step_id"});
        if (r107.length() != 0) goto L11;
        boolean r108 = true;
    L12:
        if (r108 == false) goto L14;
        r107 = r105;
    L14:
        String r109 = "step:" + r104 + ':' + r107;
        LinkedHashMap<String, h> r110 = r100.f1911b;
        h r111 = r110.get(r109);
        if (r111 != null) goto L17;
        r111 = new l(r109);
        r111.f1919c = r105;
        r110.put(r109, r111);
    L17:
        l r112 = (l) r111;
        int r113 = a.f17807a[r101.getEventType().ordinal()];
        if (r113 != 1) goto L20;
        r112.b(CotBlockStatus.RUNNING);
        r112.f1922f = true;
        return;
    L20:
        if (r113 != 2) goto L26;
        r112.b(CotBlockStatus.DONE);
        r112.f1922f = false;
        return;
    L26:
        return;
    L11:
        r108 = false;
        goto L12
    L5:
        r106 = false;
        goto L6
    }
}
