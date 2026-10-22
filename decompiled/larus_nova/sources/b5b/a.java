package b5b;

import a5b.h;
import a5b.i;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotEventType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements a5b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17793a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<CotEventType> f17794b = null;

    /* JADX INFO: renamed from: b5b.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0268a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17795a = null;

        static {
            int[] r100 = new int[CotEventType.values().length];
            r100[CotEventType.CUSTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f17795a = r100;
        }
    }

    public a() {
    }

    static {
        f17793a = new a();
        f17794b = SetsKt.setOf(new CotEventType[]{CotEventType.RAW, CotEventType.CUSTOM, CotEventType.STATE_DELTA, CotEventType.ACTIVITY_DELTA, CotEventType.UNKNOWN});
    }

    @Override // a5b.b
    public final Set<CotEventType> a() {
        return f17794b;
    }

    @Override // a5b.b
    public final void b(a5b.d r100, CotEvent r101, JSONObject r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "json");
        boolean r103 = true;
        if (C0268a.f17795a[r101.getEventType().ordinal()] != 1) goto L5;
        CotViewBlockType r104 = CotViewBlockType.CUSTOM;
    L6:
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r104, "type");
        String r105 = r101.getEventId();
        if (r105.length() != 0) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == false) goto L12;
        r105 = String.valueOf(r110);
    L12:
        String r107 = r104.name().toLowerCase(Locale.ROOT) + ':' + r105 + ':' + r110;
        LinkedHashMap<String, h> r108 = r100.f1911b;
        h r111 = r108.get(r107);
        if (r111 != null) goto L22;
        int r112 = a5b.d.a.f1915a[r104.ordinal()];
        if (r112 != 1) goto L17;
        r111 = new i(r107);
    L21:
        r108.put(r107, r111);
        goto L22
    L17:
        if (r112 == 2) goto L19;
        r111 = new i(r107);
        goto L21
    L19:
        r111 = new a5b.g(r107);
    L22:
        h r113 = r111;
        String r109 = a5b.e.d(r102);
        if (r109 != null) goto L26;
        r109 = "";
    L26:
        if (r109.length() > 0) goto L29;
        r103 = false;
    L29:
        if (r103 == false) goto L31;
        r113.f1920d.append(r109);
    L31:
        r113.b(CotBlockStatus.DONE);
        r113.f1922f = false;
        return;
    L9:
        r106 = false;
        goto L10
    L5:
        r104 = CotViewBlockType.RAW;
        goto L6
    }
}
