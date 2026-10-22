package com.stepos.net.response;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u000e\u001a\u00020\u000fH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00018\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/stepos/net/response/IResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", "getCode", "()I", "message", "", "getMessage", "()Ljava/lang/String;", SettingsConfig.KEY_DATA, "getData", "()Ljava/lang/Object;", "isSuccess", "", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IResponse<T> {
    int getCode();

    T getData();

    String getMessage();

    boolean isSuccess();
}
