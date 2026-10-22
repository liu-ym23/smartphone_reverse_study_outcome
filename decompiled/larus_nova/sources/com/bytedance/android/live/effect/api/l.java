package com.bytedance.android.live.effect.api;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.Effect;

/* JADX INFO: loaded from: classes45.dex */
public interface l {

    public interface a {
        void a(boolean r100);
    }

    public interface b {
        void a(Sticker r100);

        void b();

        void onDownloadStart();
    }

    public static class c implements b {
        public c() {
        }

        @Override // com.bytedance.android.live.effect.api.l.b
        public final void onDownloadStart() {
        }
    }

    void a(Effect r100, boolean r101, a r102);

    void b(String r100, Sticker r101, c r102);
}
