package com.bytedance.android.livesdk.vscore_api.paidlive.ability;

import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface d extends g {

    public static final class a {
        public static /* synthetic */ void a(d r100, Map r101, String r102, boolean r103, int r104) {
            if ((r104 & 4) == 0) goto L5;
            r103 = true;
        L5:
            r100.Ko(r101, r102, r103, null);
        }
    }

    Boolean F0(PaidInteractEntry r100);

    void Ko(Map<String, String> r100, String r101, boolean r102, Episode r103);

    Map<String, String> Ph();

    void ld();
}
