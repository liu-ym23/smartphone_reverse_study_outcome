package com.bytedance.android.livesdk.provideservices;

import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.android.livesdkapi.depend.live.ILiveFeedEvent;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements ILiveFeedEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f156806a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f156807a = null;

        static {
            f156807a = new e();
        }
    }

    public void onEvent(b30.t r100) {
    }

    public e() {
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveFeedEvent
    public final void onLiveFeedHide(AppCompatActivity r100) {
        this.f156806a = false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveFeedEvent
    public final void onLiveFeedShow(AppCompatActivity r100, Map<String, String> r101) {
        if (this.f156806a == false) goto L5;
        return;
    L5:
        this.f156806a = true;
    }
}
