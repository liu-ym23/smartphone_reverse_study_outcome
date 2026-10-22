package cj0;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public interface c {
    void clearIncreaseUserList();

    k currentPaidLinkMicState();

    long getIncreasePrice();

    List<String> getIncreaseUserList();

    NextLiveData<k> getPaidLinkMicState();

    NextLiveData<k> getPaidLinkMicStateObservable();

    boolean isIncreasePriceOn();

    boolean isPaidLinkOn();

    boolean needIntercepted();
}
