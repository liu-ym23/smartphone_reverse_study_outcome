package c62;

import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o;
import com.ss.ugc.live.sdk.message.data.LimitedSizeHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements vlc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, c> f22545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vlc.k f22546b;

    public static final class a {
    }

    /* JADX INFO: renamed from: c62.b$b, reason: collision with other inner class name */
    public static final class C0409b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f22547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f22548b;

        public C0409b(int r100, long r101) {
            this.f22547a = r100;
            this.f22548b = r101;
        }
    }

    public static final class c implements vlc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LimitedSizeHashMap f22549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LimitedSizeHashMap f22550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final vlc.k f22551c;

        public c(vlc.k r100) {
            Intrinsics.checkNotNullParameter(r100, "onMessageDuplicateListener");
            this.f22551c = r100;
            this.f22549a = new LimitedSizeHashMap(512);
            this.f22550b = new LimitedSizeHashMap(512);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // vlc.b
        public final boolean onMessage(tlc.d r110) {
            if (r110 != null) goto L5;
            return false;
        L5:
            int r100 = r110.getGeneralMessageType();
            long r101 = r110.getMessageId();
            if (r100 != 2) goto L12;
            if (this.f22549a.containsKey(Long.valueOf(r101)) == false) goto L10;
            return true;
        L10:
            this.f22549a.put(Long.valueOf(r101), null);
        L20:
            return false;
        L12:
            if (r100 != 3) goto L20;
            if (this.f22550b.containsKey(Long.valueOf(r101)) == false) goto L19;
            C0409b r102 = (C0409b) this.f22550b.get(Long.valueOf(r101));
            if (r102 == null) goto L18;
            long r103 = System.currentTimeMillis() - r102.f22548b;
            this.f22551c.b(r101, r102.f22547a, r110.getMessageFrom(), r103);
        L18:
            return true;
        L19:
            long r104 = System.currentTimeMillis();
            C0409b r105 = new C0409b(r110.getMessageFrom(), r104);
            this.f22550b.put(Long.valueOf(r110.getMessageId()), r105);
            goto L20
        }
    }

    static {
    }

    public b(vlc.k r100) {
        Intrinsics.checkNotNullParameter(r100, "onMessageDuplicateListener");
        this.f22546b = r100;
        this.f22545a = new LinkedHashMap();
    }

    @Override // vlc.b
    public final boolean onMessage(tlc.d r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        long r101 = o.b(r100);
        if (r101 > 0) goto L8;
        return false;
    L8:
        Map<Long, c> r102 = this.f22545a;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        c r104 = (c) r103.get(Long.valueOf(r101));
        if (r104 != null) goto L12;
        r104 = new c(this.f22546b);
        this.f22545a.put(Long.valueOf(r101), r104);
    L12:
        return r104.onMessage(r100);
    }
}
