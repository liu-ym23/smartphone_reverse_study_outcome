package com.bytedance.android.ec.hybrid.hostapi;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.keva.Keva;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\bH&J-\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u0002H\nH&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/hybrid/hostapi/IECHybridKevaService;", "", "buildNewMap", "", "", "keva", "Lcom/bytedance/keva/Keva;", "map", "", "getSDKSettingsValueFromRepo", ExifInterface.GPS_DIRECTION_TRUE, "key", "type", "Ljava/lang/reflect/Type;", "defaultValue", "(Ljava/lang/String;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECHybridKevaService {
    Map<String, Object> buildNewMap(Keva r100, Map<String, Object> r101);

    <T> T getSDKSettingsValueFromRepo(String r100, Type r101, T r102);
}
