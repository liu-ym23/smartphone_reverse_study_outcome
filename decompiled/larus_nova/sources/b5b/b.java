package b5b;

import a5b.h;
import a5b.j;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotEventType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements a5b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f17796a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<CotEventType> f17797b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17798a = null;

        static {
            int[] r100 = new int[CotEventType.values().length];
            r100[CotEventType.REASONING_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[CotEventType.REASONING_MESSAGE_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[CotEventType.REASONING_MESSAGE_CONTENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[CotEventType.REASONING_MESSAGE_CHUNK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[CotEventType.REASONING_MESSAGE_END.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[CotEventType.REASONING_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[CotEventType.REASONING_ENCRYPTED_VALUE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f17798a = r100;
        }
    }

    public b() {
    }

    static {
        f17796a = new b();
        f17797b = SetsKt.setOf(new CotEventType[]{CotEventType.REASONING_START, CotEventType.REASONING_MESSAGE_START, CotEventType.REASONING_MESSAGE_CONTENT, CotEventType.REASONING_MESSAGE_CHUNK, CotEventType.REASONING_MESSAGE_END, CotEventType.REASONING_END, CotEventType.REASONING_ENCRYPTED_VALUE});
    }

    @Override // a5b.b
    public final Set<CotEventType> a() {
        return f17797b;
    }

    @Override // a5b.b
    public final void b(a5b.d r100, CotEvent r101, JSONObject r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r110, "json");
        boolean r102 = false;
        boolean r103 = true;
        switch(a.f17798a[r101.getEventType().ordinal()]) {
            case 1: goto L52;
            case 2: goto L52;
            case 3: goto L46;
            case 4: goto L46;
            case 5: goto L38;
            case 6: goto L38;
            case 7: goto L5;
            default: goto L67;
        };
    L5:
        String r112 = a5b.e.c(r110, new String[]{"entityId", PickerReporterConstants.KEY.ENTITY_ID});
        if (r112.length() != 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L16;
        r112 = a5b.e.c(r110, new String[]{"messageId", MusicAppletPage.KEY_MESSAGE_ID});
        if (r112.length() != 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        r112 = r101.getEventId();
        goto L16
    L13:
        r105 = false;
    L16:
        Collection<h> r106 = r100.f1911b.values();
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L18:
        if (r108.hasNext() == false) goto L22;
        Object r109 = r108.next();
        if ((r109 instanceof j) == false) goto L18;
        r107.add(r109);
        goto L18
    L22:
        Iterator r113 = r107.iterator();
    L24:
        if (r113.hasNext() == false) goto L28;
        Object r114 = r113.next();
        if (Intrinsics.areEqual(((j) r114).f1917a, "reasoning:" + r112) == false) goto L24;
    L29:
        j r115 = (j) r114;
        if (r115 != null) goto L32;
        r115 = r100.b(r101, r110);
    L32:
        String r116 = a5b.e.c(r110, new String[]{"encryptedValue", "encrypted_value"});
        if (r116.length() <= 0) goto L35;
        r102 = true;
    L35:
        if (r102 == false) goto L62;
        ((ArrayList) r115.f1923g).add(r116);
        return;
    L62:
        return;
    L28:
        r114 = null;
        goto L29
    L8:
        r104 = false;
        goto L9
    L46:
        j r117 = r100.b(r101, r110);
        String r118 = a5b.e.a(r110, r101.getContent());
        if (r118.length() <= 0) goto L49;
        r102 = true;
    L49:
        if (r102 == false) goto L51;
        r117.f1920d.append(r118);
    L51:
        r117.b(CotBlockStatus.RUNNING);
        r117.f1922f = true;
        return;
    L52:
        j r119 = r100.b(r101, r110);
        r119.b(CotBlockStatus.RUNNING);
        r119.f1922f = true;
        return;
    L67:
        return;
    L38:
        if (a5b.e.c(r110, new String[]{"messageId", MusicAppletPage.KEY_MESSAGE_ID}).length() == 0) goto L41;
        r103 = false;
    L41:
        if (r103 == true) goto L43;
    L45:
        j r120 = r100.b(r101, r110);
        r120.b(CotBlockStatus.DONE);
        r120.f1922f = false;
        return;
    L43:
        if (r101.getEventType() != CotEventType.REASONING_END) goto L45;
        r100.a();
    }
}
