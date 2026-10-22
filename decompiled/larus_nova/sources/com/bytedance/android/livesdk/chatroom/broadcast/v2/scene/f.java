package com.bytedance.android.livesdk.chatroom.broadcast.v2.scene;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements SavedStateRegistry.SavedStateProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f105459a;

    public f(d r100) {
        this.f105459a = r100;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        Bundle r100 = new Bundle();
        r100.putBoolean("fragment_save_state_not_in_liveStreaming", true);
        Bundle r101 = this.f105459a.f105456m.getArguments();
        if (r101 == null) goto L9;
        Bundle r102 = r101.getBundle("extra");
        if (r102 == null) goto L9;
        String r103 = r102.getString("extra_live_from_type");
        if (r103 == null) goto L9;
        r100.putString("extra_live_from_type", r103);
    L9:
        Bundle r104 = this.f105459a.f105456m.getArguments();
        if (r104 == null) goto L16;
        Bundle r105 = r104.getBundle("extra");
        if (r105 == null) goto L16;
        String r106 = r105.getString("extra_live_source_params");
        if (r106 == null) goto L16;
        r100.putString("extra_live_source_params", r106);
    L16:
        return r100;
    }
}
