package com.bytedance.android.livesdkapi.depend.model.broadcast;

import android.content.Context;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u001c\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/IBroadcastPlayer;", "", "prepareAsync", "", "release", "setDataSource", "var1", "Landroid/content/Context;", "var2", "", "setEventListener", "listener", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/IBroadcastPlayer$EventListener;", "start", "stop", "EventListener", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBroadcastPlayer {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/IBroadcastPlayer$EventListener;", "", "onCompletion", "", LynxVideoManagerLite.EVENT_ON_ERROR, "code", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onPrepared", "ode", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface EventListener {
        void onCompletion();

        void onError(int r100, Exception r101);

        void onPrepared(int r100);
    }

    void prepareAsync();

    void release();

    void setDataSource(Context r100, String r101);

    void setEventListener(EventListener r100);

    void start();

    void stop();
}
