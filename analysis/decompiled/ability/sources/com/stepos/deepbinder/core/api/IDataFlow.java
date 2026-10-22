package com.stepos.deepbinder.core.api;

import androidx.annotation.Keep;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/deepbinder/core/api/IDataFlow;", ExifInterface.GPS_DIRECTION_TRUE, "", SettingsConfig.KEY_DATA, "LC7/r;", "readFromObject", "(Ljava/lang/Object;)V", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IDataFlow<T> {
    @Keep
    void readFromObject(T data);
}
