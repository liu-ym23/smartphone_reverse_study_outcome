package am2;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class q {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f4323g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4329f;

    public static final class a {
        public static void a(q r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "endPageLog");
            if (r101 == null) goto L22;
            boolean r102 = false;
            if (r100.f4327d.length() <= 0) goto L7;
            boolean r103 = true;
        L8:
            if (r103 == false) goto L11;
            r101.put("is_inserted", r100.f4327d);
        L11:
            if (r100.f4328e.length() <= 0) goto L13;
            boolean r104 = true;
        L14:
            if (r104 == false) goto L17;
            r101.put("lifve_end_anchor_id", r100.f4328e);
        L17:
            if (r100.f4329f.length() <= 0) goto L19;
            r102 = true;
        L19:
            if (r102 == false) goto L23;
            r101.put("live_end_room_id", r100.f4329f);
            return;
        L23:
            return;
        L13:
            r104 = false;
            goto L14
        L7:
            r103 = false;
            goto L8
        }
    }

    static {
    }

    public q() {
        this.f4324a = "";
        this.f4325b = "";
        this.f4326c = "";
        this.f4327d = "";
        this.f4328e = "";
        this.f4329f = "";
    }
}
