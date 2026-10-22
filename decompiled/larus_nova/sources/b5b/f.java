package b5b;

import a5b.h;
import a5b.m;
import com.larus.bmhome.music.applet.MusicAppletPage;
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
public final class f implements a5b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f17808a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<CotEventType> f17809b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17810a = null;

        static {
            int[] r100 = new int[CotEventType.values().length];
            r100[CotEventType.TEXT_MESSAGE_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[CotEventType.TEXT_MESSAGE_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[CotEventType.TEXT_MESSAGE_CHUNK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[CotEventType.TEXT_MESSAGE_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f17810a = r100;
        }
    }

    public f() {
    }

    static {
        f17808a = new f();
        f17809b = SetsKt.setOf(new CotEventType[]{CotEventType.TEXT_MESSAGE_START, CotEventType.TEXT_MESSAGE_CONTENT, CotEventType.TEXT_MESSAGE_CHUNK, CotEventType.TEXT_MESSAGE_END});
    }

    @Override // a5b.b
    public final Set<CotEventType> a() {
        return f17809b;
    }

    @Override // a5b.b
    public final void b(a5b.d r100, CotEvent r101, JSONObject r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "json");
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "json");
        String r104 = a5b.e.c(r102, new String[]{"messageId", MusicAppletPage.KEY_MESSAGE_ID});
        boolean r105 = false;
        if (r104.length() != 0) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == false) goto L8;
        r104 = r101.getEventId();
    L8:
        String r107 = "text:" + r104;
        LinkedHashMap<String, h> r108 = r100.f1911b;
        h r109 = r108.get(r107);
        if (r109 != null) goto L11;
        r109 = new m(r107);
        r109.f1919c = a5b.e.c(r102, new String[]{"title"});
        r108.put(r107, r109);
    L11:
        m r110 = (m) r109;
        int r111 = a.f17810a[r101.getEventType().ordinal()];
        if (r111 != 1) goto L14;
        r110.b(CotBlockStatus.RUNNING);
        r110.f1922f = true;
        return;
    L14:
        if (r111 != 2) goto L16;
    L21:
        String r112 = a5b.e.a(r102, r101.getContent());
        if (r112.length() <= 0) goto L24;
        r105 = true;
    L24:
        if (r105 == false) goto L26;
        r110.f1920d.append(r112);
    L26:
        r110.b(CotBlockStatus.RUNNING);
        r110.f1922f = true;
        return;
    L16:
        if (r111 == 3) goto L21;
        if (r111 != 4) goto L31;
        r110.b(CotBlockStatus.DONE);
        r110.f1922f = false;
        return;
    L31:
        return;
    L5:
        r106 = false;
        goto L6
    }
}
