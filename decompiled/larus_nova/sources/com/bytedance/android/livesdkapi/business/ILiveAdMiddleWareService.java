package com.bytedance.android.livesdkapi.business;

import com.bytedance.android.live.base.IService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0015\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H&¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/business/ILiveAdMiddleWareService;", "Lcom/bytedance/android/live/base/IService;", "getAdInfo", "Lorg/json/JSONObject;", "cid", "", "getMannorUnionAdnSourceTypes", "", "()[Ljava/lang/String;", "DEFAULT", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveAdMiddleWareService extends IService {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0015\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/business/ILiveAdMiddleWareService$DEFAULT;", "Lcom/bytedance/android/livesdkapi/business/ILiveAdMiddleWareService;", "()V", "getAdInfo", "Lorg/json/JSONObject;", "cid", "", "getMannorUnionAdnSourceTypes", "", "()[Ljava/lang/String;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DEFAULT implements ILiveAdMiddleWareService {
        public DEFAULT() {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveAdMiddleWareService
        public JSONObject getAdInfo(String r100) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            return null;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveAdMiddleWareService
        public String[] getMannorUnionAdnSourceTypes() {
            return null;
        }
    }

    JSONObject getAdInfo(String r100);

    String[] getMannorUnionAdnSourceTypes();
}
