package com.bytedance.android.live.hostadapter.network.ws;

import android.content.Context;
import com.bytedance.android.livesdkapi.game_ws.ILiveWsListener;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003JE\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\rHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00062"}, d2 = {"Lcom/bytedance/android/live/hostadapter/network/ws/Config;", "", "url", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "listener", "Lcom/bytedance/android/livesdkapi/game_ws/ILiveWsListener;", "pingInterval", "", EventConstant.Value.RETRY, "", "retryTimes", "", "(Ljava/lang/String;Landroid/content/Context;Lcom/bytedance/android/livesdkapi/game_ws/ILiveWsListener;JZI)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getListener", "()Lcom/bytedance/android/livesdkapi/game_ws/ILiveWsListener;", "setListener", "(Lcom/bytedance/android/livesdkapi/game_ws/ILiveWsListener;)V", "getPingInterval", "()J", "setPingInterval", "(J)V", "getRetry", "()Z", "setRetry", "(Z)V", "getRetryTimes", "()I", "setRetryTimes", "(I)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
public final class Config {
    private Context context;
    private ILiveWsListener listener;
    private long pingInterval;
    private boolean retry;
    private int retryTimes;
    private String url;

    public static /* synthetic */ Config copy$default(Config r100, String r101, Context r102, ILiveWsListener r103, long r104, boolean r110, int r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.context;
    L8:
        Context r114 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.listener;
    L11:
        ILiveWsListener r105 = r103;
        if ((r112 & 8) == 0) goto L14;
        r104 = r100.pingInterval;
    L14:
        long r106 = r104;
        if ((r112 & 16) == 0) goto L17;
        r110 = r100.retry;
    L17:
        boolean r107 = r110;
        if ((r112 & 32) == 0) goto L20;
        r111 = r100.retryTimes;
    L20:
        String r108 = r101;
        return r100.copy(r108, r114, r105, r106, r107, r111);
    }

    public final String component1() {
        return this.url;
    }

    public final Context component2() {
        return this.context;
    }

    public final ILiveWsListener component3() {
        return this.listener;
    }

    public final long component4() {
        return this.pingInterval;
    }

    public final boolean component5() {
        return this.retry;
    }

    public final int component6() {
        return this.retryTimes;
    }

    public final Config copy(String r110, Context r111, ILiveWsListener r112, long r113, boolean r114, int r115) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "listener");
        return new Config(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Config) == false) goto L18;
        Config r101 = (Config) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.listener, r101.listener) == true) goto L12;
        return false;
    L12:
        if (this.pingInterval == r101.pingInterval) goto L14;
        return false;
    L14:
        if (this.retry == r101.retry) goto L16;
        return false;
    L16:
        if (this.retryTimes == r101.retryTimes) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Context r104 = this.context;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ILiveWsListener r107 = this.listener;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        long r109 = this.pingInterval;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        boolean r111 = this.retry;
        ?? r112 = r111;
        if (r111 == false) goto L17;
        r112 = 1;
    L17:
        return ((r110 + r112) * 31) + this.retryTimes;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "Config(url=" + this.url + ", context=" + this.context + ", listener=" + this.listener + ", pingInterval=" + this.pingInterval + ", retry=" + this.retry + ", retryTimes=" + this.retryTimes + ")";
    }

    public final Context getContext() {
        return this.context;
    }

    public final ILiveWsListener getListener() {
        return this.listener;
    }

    public final long getPingInterval() {
        return this.pingInterval;
    }

    public final boolean getRetry() {
        return this.retry;
    }

    public final int getRetryTimes() {
        return this.retryTimes;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setContext(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.context = r100;
    }

    public final void setListener(ILiveWsListener r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.listener = r100;
    }

    public final void setPingInterval(long r100) {
        this.pingInterval = r100;
    }

    public final void setRetry(boolean r100) {
        this.retry = r100;
    }

    public final void setRetryTimes(int r100) {
        this.retryTimes = r100;
    }

    public final void setUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }

    public Config(String r100, Context r101, ILiveWsListener r102, long r103, boolean r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "listener");
        this.url = r100;
        this.context = r101;
        this.listener = r102;
        this.pingInterval = r103;
        this.retry = r104;
        this.retryTimes = r105;
    }
}
