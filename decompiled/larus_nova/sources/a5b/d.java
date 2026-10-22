package a5b;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.entity.message.CotContent;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CotStatus f1910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, h> f1911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, String> f1912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CotStatus f1913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1914e;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1915a = null;

        static {
            int[] r100 = new int[CotViewBlockType.values().length];
            r100[CotViewBlockType.RAW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CotViewBlockType.CUSTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f1915a = r100;
        }
    }

    public final void a() {
        Collection<h> r100 = this.f1911b.values();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((r103 instanceof j) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        j r105 = (j) r104.next();
        r105.b(CotBlockStatus.DONE);
        r105.f1922f = false;
        goto L10
    }

    public d(CotContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        r100.getCotId();
        this.f1910a = r100.getStatus();
        this.f1911b = new LinkedHashMap();
        this.f1912c = new HashMap();
        this.f1913d = r100.getStatus();
    }

    public final k c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        String r101 = e.c(r100, new String[]{"runId", "run_id"});
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        r101 = "default";
    L8:
        String r103 = "run:".concat(r101);
        LinkedHashMap<String, h> r104 = this.f1911b;
        h r105 = r104.get(r103);
        if (r105 != null) goto L12;
        r105 = new k(r103);
        r104.put(r103, r105);
    L12:
        return (k) r105;
    L5:
        r102 = false;
        goto L6
    }

    public final j b(CotEvent r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "json");
        String r102 = e.c(r101, new String[]{"messageId", MusicAppletPage.KEY_MESSAGE_ID});
        if (r102.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        r102 = r100.getEventId();
    L8:
        String r104 = "reasoning:" + r102;
        LinkedHashMap<String, h> r105 = this.f1911b;
        h r106 = r105.get(r104);
        if (r106 != null) goto L12;
        r106 = new j(r104);
        r105.put(r104, r106);
    L12:
        return (j) r106;
    L5:
        r103 = false;
        goto L6
    }
}
