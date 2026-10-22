package com.bytedance.android.live.strategy.api;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ServiceLookup("com.bytedance.android.live.impl.StrategyService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J?\u0010\u0002\u001a\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH&¢\u0006\u0002\u0010\u000bJ5\u0010\u0002\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\tH&J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0014\u001a\u00020\u0011H&J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H&¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/strategy/api/IStrategyService;", "Lcom/bytedance/android/live/base/IService;", "getFactor", "Landroidx/lifecycle/LiveData;", ExifInterface.GPS_DIRECTION_TRUE, "faName", "", "default", "sendTeaLog", "", "useCache", "(Ljava/lang/String;Ljava/lang/Object;ZZ)Landroidx/lifecycle/LiveData;", "anchorId", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Z)Ljava/lang/Object;", "getShotStrategy", "Lcom/bytedance/android/live/strategy/api/CombineInfo;", "init", "", "isSmartSDKInit", "isStrategyFactor", "releaseCache", "sendLog", "value", "livestrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IStrategyService extends IService {

    public static final class a {
        public static /* synthetic */ LiveData a(IStrategyService r100, String r101, Object r102, boolean r103, int r104) {
            boolean r105 = true;
            if ((r104 & 4) == 0) goto L6;
            r103 = true;
        L6:
            if ((r104 & 8) != 0) goto L10;
            r105 = false;
        L10:
            return r100.getFactor(r101, r102, r103, r105);
        }
    }

    <T> LiveData<T> getFactor(String r100, T r101, boolean r102, boolean r103);

    <T> T getFactor(String r100, T r101, String r102, boolean r103);

    CombineInfo getShotStrategy(String r100);

    void init();

    boolean isSmartSDKInit();

    boolean isStrategyFactor(String r100);

    void releaseCache();

    void sendLog(String r100, String r101);
}
