package com.bytedance.android.live.liveinteract.voicechat;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes46.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r100, String r101, boolean r102, MediaOperation.a r103, int r104) {
            boolean r105 = false;
            if ((r104 & 2) == 0) goto L6;
            r102 = false;
        L6:
            if ((r104 & 4) == 0) goto L9;
            r103 = null;
        L9:
            if ((r104 & 8) == 0) goto L11;
            r105 = true;
        L11:
            r100.d(r101, r102, r103, r105);
        }
    }

    void a(VoiceChatMuteManager.a r100);

    void b(String r100, MediaOperation.a r101);

    void c(LifecycleOwner r100, Observer<Boolean> r101);

    void d(String r100, boolean r101, MediaOperation.a r102, boolean r103);

    boolean e(boolean r100);

    void f(String r100, MediaOperation.a r101);

    void g(VoiceChatMuteManager.a r100);

    void h(String r100);

    boolean i();

    boolean isMute();
}
