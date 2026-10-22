package com.bytedance.android.livesdkapi.host;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerApi;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J!\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H&¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/host/ILivePlayerNetwork;", "", "apiHost", "", "createAPIByClass", ExifInterface.GPS_DIRECTION_TRUE, "cls", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "createLivePlayerAPI", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerApi;", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerNetwork {
    String apiHost();

    <T> T createAPIByClass(Class<T> r100);

    ILivePlayerApi createLivePlayerAPI();
}
