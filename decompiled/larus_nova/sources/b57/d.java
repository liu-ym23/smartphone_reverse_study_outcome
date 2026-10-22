package b57;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.snapshot.storage.ISnapshotStore;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f17777a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f17778b = null;

    public d() {
    }

    static {
        f17777a = new d();
        f17778b = new AtomicBoolean(false);
    }

    public static boolean a(String r110, String r111, long r112, JSONObject r210, int r211, String r212, String r213, boolean r214) {
        String r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r210, "query");
        Intrinsics.checkNotNullParameter(r212, "version");
        Intrinsics.checkNotNullParameter(r213, "url");
        Lazy<Settings> r101 = Settings.f266286f;
        if (Settings.a.a().u() == true) goto L5;
        return false;
    L5:
        com.bytedance.pia.core.utils.d.l("[SnapShot] Save a snapshot (URL: " + r213 + ", Query: " + r210 + ')', null, 14);
        ThreadUtil.a().post(b.f17774a);
        com.bytedance.pia.snapshot.storage.a r102 = com.bytedance.pia.snapshot.storage.a.f266521a;
        Stack r103 = new Stack();
        StringBuffer r113 = new StringBuffer();
        int r114 = 0;
    L7:
        if (r114 >= r110.length()) goto L27;
        char r115 = r100.charAt(r114);
        if (r115 != '<') goto L21;
        int r116 = r114 + 34;
        if (r116 <= r110.length()) goto L13;
    L15:
        int r117 = r114 + 32;
        if (r117 > r110.length()) goto L21;
        if (Intrinsics.areEqual(r100.substring(r114, r117), "<!-- PIA_SNAPSHOT_HIDDEN_END -->") == false) goto L21;
        r103.pop();
        r114 = r117;
    L26:
        r100 = r110;
        goto L7
    L13:
        if (Intrinsics.areEqual(r100.substring(r114, r116), "<!-- PIA_SNAPSHOT_HIDDEN_START -->") == false) goto L15;
        r103.push(0);
        r114 = r116;
    L21:
        if (r103.empty() == true) goto L23;
    L25:
        r114 = r114 + 1;
        goto L26
    L23:
        if (r115 == '\n') goto L25;
        r113.append(r115);
        goto L25
    L27:
        String r104 = r113.toString();
        Intrinsics.checkNotNullParameter(r104, "content");
        Intrinsics.checkNotNullParameter(r210, "query");
        Intrinsics.checkNotNullParameter(r212, "version");
        Intrinsics.checkNotNullParameter(r213, "url");
        Keva r105 = com.bytedance.pia.snapshot.storage.a.f266522b;
        if (r105 == null) goto L60;
        String r106 = j.d(UriProtector.parse(r213));
        ArrayList r107 = com.bytedance.pia.snapshot.storage.a.d(r210);
        if (r105.contains(r106) == false) goto L43;
        String[] r108 = r105.getStringArray(r106, null);
        if (r108 != null) goto L37;
        com.bytedance.pia.snapshot.storage.a.e(r106);
        goto L43
    L37:
        if (r108.length != 0) goto L39;
        boolean r109 = true;
    L40:
        if (r109 == false) goto L45;
        if (r107.isEmpty() == true) goto L43;
    L45:
        if (r108.length == r107.size()) goto L47;
        boolean r118 = true;
    L51:
        if (r118 == false) goto L58;
        if (r214 == false) goto L56;
        com.bytedance.pia.snapshot.storage.a.e(r106);
        if (com.bytedance.pia.snapshot.storage.a.g(r106, r210, r107, r104, r111, r112, r212, r211) == false) goto L60;
        return true;
    L56:
        com.bytedance.pia.core.utils.d.p("[SnapShot] snapshot conflict exception (URL: " + r213 + ", Query: " + r210 + "), Enforce: " + r214, null, null, 14);
        throw new ISnapshotStore.SnapshotConflictException("fail to save the snapshot for some conflicts.");
    L58:
        boolean r119 = com.bytedance.pia.snapshot.storage.a.f(r106, r210, r107);
        if (com.bytedance.pia.snapshot.storage.a.g(r106, r210, r107, r104, r111, r112, r212, r211) == false) goto L60;
        return r119;
    L47:
        ArrayList r120 = new ArrayList();
        int r121 = r108.length;
        int r122 = 0;
    L48:
        if (r122 >= r121) goto L50;
        r120.add(r108[r122]);
        r122 = r122 + 1;
        goto L48
    L50:
        CollectionsKt.sort(r120);
        r118 = !Intrinsics.areEqual(r107, r120);
        goto L51
    L39:
        r109 = false;
    L43:
        r118 = false;
    L60:
        return false;
    }
}
