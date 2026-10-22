package b87;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    @SerializedName("enable_token_retry")
    public boolean enableTokenRetry;

    @SerializedName("loop_retry_interval_in_second")
    public long loopRetryIntervalInSecond;

    @SerializedName("max_loop_retry_times")
    public int maxLoopRetryTimes;

    @SerializedName("need_retry_channel")
    public List<Integer> needRetryChannel;

    @SerializedName("retry_after_enter_background")
    public boolean retryAfterEnterBackground;

    @SerializedName("retry_after_network_changed")
    public boolean retryAfterNetworkChanged;

    @SerializedName("token_register_timeout_in_second")
    public long tokenRegisterTimeout;

    @SerializedName("trigger_retry_event_list")
    public List<String> triggerRetryEventList;

    public b() {
        this.enableTokenRetry = true;
        this.tokenRegisterTimeout = 60;
        this.needRetryChannel = Arrays.asList(new Integer[]{1, 7, 10, 11, 22});
        this.retryAfterNetworkChanged = true;
        this.maxLoopRetryTimes = -1;
        this.loopRetryIntervalInSecond = 60;
        this.retryAfterEnterBackground = true;
        this.triggerRetryEventList = new ArrayList();
    }
}
