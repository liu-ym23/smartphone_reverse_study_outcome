package com.bytedance.android.livesdkapi.room.state;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\tR\u001e\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/state/IUserState;", "", "extra", "Landroid/os/Bundle;", "getExtra", "()Landroid/os/Bundle;", "isLoginFunc", "Lkotlin/Function0;", "", "()Lkotlin/jvm/functions/Function0;", "reportParams", "", "", "getReportParams", "()Ljava/util/Map;", "secUid", "getSecUid", "()Ljava/lang/String;", "streamType", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveMode;", "getStreamType", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveMode;", "uid", "getUid", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IUserState {
    Bundle getExtra();

    Map<String, String> getReportParams();

    String getSecUid();

    ILiveMode getStreamType();

    String getUid();

    Function0<Boolean> isLoginFunc();
}
