package okhttp3.internal.f;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import e.g;
import okhttp3.u;

/* JADX INFO: compiled from: HeadersReader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1076a f39939a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f39940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f39941c;

    /* JADX INFO: renamed from: okhttp3.internal.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HeadersReader.kt */
    public static final class C1076a {
        public /* synthetic */ C1076a(h r1) {
            this();
        }

        private C1076a() {
        }
    }

    static {
        f39939a = new C1076a(null);
    }

    public a(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        o.e(r4, DBHelper.BATTERY_COL_SOURCE);
        this.f39940b = r4;
        this.f39941c = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public final String a() {
        String r0 = this.f39940b.f(this.f39941c);
        this.f39941c -= (long) r0.length();
        return r0;
    }

    public final u b() {
        u.a r0 = new u.a();
    L3:
        String r1 = a();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L10;
        r0.a(r1);
        goto L3
    L10:
        return r0.b();
    L6:
        r2 = false;
        goto L7
    }
}
