package aj1;

import com.bytedance.android.livesdk.chatroom.LivePlayFragmentV2;
import com.bytedance.android.livesdk.log.b0;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements Function0<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.room.b f3881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f3882b;

    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        this.f3881a.getActivity();
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_room_exit", "user close on end fragment");
        ((LivePlayFragmentV2) this.f3882b.f3889f.f510501h).f105048d.h(8, null);
        return Boolean.TRUE;
    }

    public f(h r100, com.bytedance.android.livesdk.room.b r101) {
        this.f3882b = r100;
        this.f3881a = r101;
    }
}
