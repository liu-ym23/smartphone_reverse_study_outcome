package com.bytedance.android.live.effect.beauty.makeups;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.beauty.makeups.a$a, reason: collision with other inner class name */
    public static final class C1110a {
        public static /* synthetic */ void a(a r100, Sticker r101, String r102) {
            ((d) r100).a(r101, r102, false);
        }
    }

    public interface b {
        void a(Sticker r100);

        void onError();
    }

    public interface c {
        void onError();

        void onSuccess(List<Sticker> r100);
    }
}
