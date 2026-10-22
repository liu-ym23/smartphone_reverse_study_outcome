package a20;

import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;

/* JADX INFO: loaded from: classes45.dex */
public interface c {

    public static final class a {
        public static boolean a(c r100) {
            return r100.f().isInLive();
        }
    }

    AbsOpenFeaturePanelViewModel f();

    void onDestroy();
}
