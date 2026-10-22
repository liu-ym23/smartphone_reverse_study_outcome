package as0;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.depend.player.ILivePlatformPlayerProxy;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public interface a extends ILivePlatformPlayerProxy {

    /* JADX INFO: renamed from: as0.a$a, reason: collision with other inner class name */
    public static final class C0216a {
        public static /* synthetic */ AbsLivePlayerView a(a r100, Context r101, long r110) {
            return r100.s(r101, r110, true, false, false, true);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f16071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f16072b;

        public b() {
            this.f16071a = null;
            this.f16072b = false;
        }

        public final Context getContext() {
            return this.f16071a;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f16073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f16074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f16075c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L12;
            c r101 = (c) r100;
            if (this.f16073a == r101.f16073a) goto L8;
            return false;
        L8:
            if (this.f16074b == r101.f16074b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f16075c, r101.f16075c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            long r100 = this.f16073a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f16074b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            String r104 = this.f16075c;
            if (r104 == null) goto L5;
            int r105 = r104.hashCode();
        L7:
            return r103 + r105;
        L5:
            r105 = 0;
            goto L7
        }

        public final String toString() {
            return "SameRoomInfo(roomId=" + this.f16073a + ", originRoomId=" + this.f16074b + ", reason=" + this.f16075c + ")";
        }

        public c(long r100, long r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "reason");
            this.f16073a = r100;
            this.f16074b = r101;
            this.f16075c = r102;
        }
    }

    RoomBaseSession d();

    boolean e(Context r100, Bundle r101);

    void f(boolean r100, EndReason r101);

    ILivePlayerClient g(boolean r100);

    LivePlayerView getLivePlayerView();

    void h();

    void i(RoomBaseSession r100);

    void j(c r100);

    boolean k();

    void l(Context r100, Bundle r101);

    void log(String r100);

    boolean m();

    IBaseStreamUrl n();

    void o(b r100);

    boolean p(EndReason.USER_CLOSE r100);

    @Override // com.bytedance.android.livesdkapi.depend.player.ILivePlatformPlayerProxy
    ILivePlayerClient player();

    boolean q(Context r100);

    boolean r(Bundle r100);

    long roomId();

    LivePlayerView s(Context r100, long r101, boolean r102, boolean r103, boolean r104, boolean r105);

    void t(Context r100);

    boolean u(String r100, RoomSession r101);

    void v(Bundle r100);

    LivePlayerConfig w();

    boolean x(LiveMode r100, boolean r101, boolean r102, boolean r103, boolean r104);

    Context y();
}
