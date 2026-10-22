package com.bytedance.android.live.liveinteract.videotalk.ui.theme;

import com.bytedance.android.live.ui.q;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.model.DefaultVoiceLiveThemeResource;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends q {

    public static final class a extends q.a {
        @Override // com.bytedance.android.live.ui.q.a
        public final q b() {
            return new b();
        }

        public a() {
        }
    }

    @Override // com.bytedance.android.live.ui.q
    public final IVoiceLiveTheme b() {
        return DefaultVoiceLiveThemeResource.videoTalkRoomDefaultTheme();
    }

    public b() {
    }
}
