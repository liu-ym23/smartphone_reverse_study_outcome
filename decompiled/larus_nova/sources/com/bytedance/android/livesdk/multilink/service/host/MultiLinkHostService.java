package com.bytedance.android.livesdk.multilink.service.host;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.android.live.base.abtest.b;
import com.bytedance.android.live.core.log.ALogger;
import com.google.gson.Gson;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0016¢\u0006\u0002\u0010\u000bJ+\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eJ1\u0010\u000f\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\b0\u0011H\u0016¢\u0006\u0002\u0010\u0012J+\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\u0010\u0015\u001a\u0004\u0018\u0001H\bH\u0002¢\u0006\u0002\u0010\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/multilink/service/host/MultiLinkHostService;", "Lcom/bytedance/android/livesdk/multilink/service/host/IMultiLinkHostService;", "()V", "mABCaches", "", "", "", "getClientABValue", ExifInterface.GPS_DIRECTION_TRUE, "key", "Lcom/bytedance/android/live/base/abtest/ClientABTestKey;", "(Lcom/bytedance/android/live/base/abtest/ClientABTestKey;)Ljava/lang/Object;", "withExposure", "", "(Lcom/bytedance/android/live/base/abtest/ClientABTestKey;Z)Ljava/lang/Object;", "getClientABValueByJsonString", "clazz", "Ljava/lang/Class;", "(Lcom/bytedance/android/live/base/abtest/ClientABTestKey;Ljava/lang/Class;)Ljava/lang/Object;", "saveCache", "", "data", "(Lcom/bytedance/android/live/base/abtest/ClientABTestKey;Ljava/lang/Object;)V", "multilink-host-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MultiLinkHostService implements IMultiLinkHostService {
    private final Map<String, Object> mABCaches;

    public MultiLinkHostService() {
        this.mABCaches = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.livesdk.multilink.service.host.IMultiLinkHostService
    public <T> T getClientABValue(ClientABTestKey<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        b.f58812b.getClass();
        return (T) b.a.a(r100);
    }

    private final <T> void saveCache(ClientABTestKey<String> r100, T r101) {
        String r102 = r100.f58801a;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L16;
        ClientABTestKey.a r104 = r100.f58804d;
        if (r104 != null) goto L13;
        return;
    L13:
        if (r104.f58805a != 1) goto L18;
        this.mABCaches.put(r102, r101);
        return;
    L18:
        return;
    L16:
        return;
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.multilink.service.host.IMultiLinkHostService
    public <T> T getClientABValue(ClientABTestKey<T> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        b.f58812b.getClass();
        return (T) b.a.b(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.multilink.service.host.IMultiLinkHostService
    public <T> T getClientABValueByJsonString(ClientABTestKey<String> r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        long r102 = System.currentTimeMillis();     // Catch: Exception -> L22
        String r103 = r100.f58801a;     // Catch: Exception -> L22
        if (r103 != null) goto L6;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == true) goto L17;
        ClientABTestKey.a r105 = r100.f58804d;     // Catch: Exception -> L22
        if (r105 == null) goto L17;
        if (r105.f58805a != 1) goto L17;
        T r106 = (T) this.mABCaches.get(r100.f58801a);
        if ((r106 instanceof Object) == false) goto L17;
    L18:
        if (r106 == null) goto L20;
        return r106;
    L20:
        Gson r107 = GsonHelper.get();     // Catch: Exception -> L22
        b.f58812b.getClass();     // Catch: Exception -> L22
        T r108 = (T) r107.fromJson((String) b.a.a(r100), r101);
        saveCache(r100, r108);     // Catch: Exception -> L22
        ALogger.d("MultiLinkHostService", "cost time == " + (System.currentTimeMillis() - r102));     // Catch: Exception -> L22
        return r108;
    L17:
        r106 = null;
        goto L18
    L6:
        if (StringsKt.isBlank(r103) == true) goto L9;
        r104 = false;
    L22:
        e = move-exception;
        String r109 = e.getMessage();
        if (r109 != null) goto L26;
        r109 = "null";
    L26:
        ALogger.e("MultiLinkHostService", r109);
        return null;
    }
}
