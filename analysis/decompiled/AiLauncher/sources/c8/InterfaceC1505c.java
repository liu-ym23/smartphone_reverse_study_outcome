package c8;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lc8/c;", "", "LY8/t;", "onConnected", "()V", "onDisconnected", "", "reason", "onBindFailed", "(Ljava/lang/String;)V", "", "retryCount", "maxRetry", Const.INTENT_KEY_APIKEY, "(II)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: c8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC1505c {
    default void a(int retryCount, int maxRetry) {
    }

    void onBindFailed(String reason);

    void onConnected();

    void onDisconnected();
}
