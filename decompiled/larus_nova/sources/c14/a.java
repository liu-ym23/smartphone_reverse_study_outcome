package c14;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f22065b;

    /* JADX INFO: renamed from: c14.a$a, reason: collision with other inner class name */
    public static final class C0387a {
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22066a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (r100.what != 1) goto L9;
            List<a24.a> r101 = this.f22066a.a();
            if ((!r101.isEmpty()) == false) goto L7;
            d14.a r102 = b14.a.f16924a;
            ((a34.a) b14.a.a(a34.a.class)).A2(r101);
        L7:
            sendEmptyMessageDelayed(1, this.f22066a.f22064a);
            return;
        }

        public b(a r100, Looper r101) {
            this.f22066a = r100;
            super(r101);
        }
    }

    static {
    }

    public abstract List<a24.a> a();

    public a() {
        JSONObject r100 = AoSettings.a("ao_live_config");
        if (r100 == null) goto L5;
        long r101 = r100.optLong("feed_live_check_interval");
    L6:
        this.f22064a = r101 * ((long) 1000);
        this.f22065b = new b(this, Looper.getMainLooper());
        return;
    L5:
        r101 = 300;
        goto L6
    }

    public final void b(boolean r100) {
        this.f22065b.removeMessages(1);
        if (r100 == false) goto L5;
        this.f22065b.sendEmptyMessage(1);
        return;
    L5:
        this.f22065b.sendEmptyMessageDelayed(1, this.f22064a);
    }
}
