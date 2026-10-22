package com.bytedance.android.livesdkapi.bytecast;

import com.bytedance.android.live.base.IService;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J,\u0010\u0006\u001a\u00020\u00032\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\nH&J4\u0010\u0006\u001a\u00020\u00032\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u000b\u001a\u00020\tH&J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\fH&J$\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\u000b\u001a\u00020\tH&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/bytecast/ILiveCastService;", "Lcom/bytedance/android/live/base/IService;", "addCastScreenStatusListener", "", "listener", "Lcom/bytedance/android/livesdkapi/bytecast/ICastStatusListener;", "appendCastSDKLogCommonParams", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "eventName", "", "Lorg/json/JSONObject;", "isScreenCasting", "", "removeCastScreenStatusListener", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveCastService extends IService {
    void addCastScreenStatusListener(ICastStatusListener r100);

    void appendCastSDKLogCommonParams(HashMap<String, String> r100);

    void appendCastSDKLogCommonParams(HashMap<String, String> r100, String r101);

    void appendCastSDKLogCommonParams(Map<String, String> r100);

    void appendCastSDKLogCommonParams(Map<String, String> r100, String r101);

    void appendCastSDKLogCommonParams(JSONObject r100, String r101);

    boolean isScreenCasting();

    void removeCastScreenStatusListener(ICastStatusListener r100);
}
