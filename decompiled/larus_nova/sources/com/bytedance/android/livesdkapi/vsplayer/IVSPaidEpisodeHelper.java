package com.bytedance.android.livesdkapi.vsplayer;

import com.bytedance.android.livesdk.user.k;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\tJ$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/vsplayer/IVSPaidEpisodeHelper;", "", "Lcom/bytedance/android/livesdk/user/k;", "loginParams", "", "", "payParams", "", "buyEpisode", "IPaidEpisodeListener", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVSPaidEpisodeHelper {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/vsplayer/IVSPaidEpisodeHelper$IPaidEpisodeListener;", "", "onDismissPayDialog", "", "onPurchasedFinish", "onPurchasedSuccess", "onPurchasedToWatch", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IPaidEpisodeListener {
        void onDismissPayDialog();

        void onPurchasedFinish();

        void onPurchasedSuccess();

        void onPurchasedToWatch();
    }

    void buyEpisode(k r100, Map<String, String> r101);
}
