package bi1;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import ik1.e;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f19089a;

    @Override // ck1.e
    public final ILiveRoomPlayFragment getCurrentFragment() {
        e r100 = this.f19089a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f490251c;
    }

    public c(e r100) {
        this.f19089a = r100;
    }
}
