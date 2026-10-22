package com.android.ttcjpaysdk.base.framework.container.base;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import com.android.ttcjpaysdk.base.network.ICJPayRequest;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJT\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\r0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\r0\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0004Jh\u0010\u0019\u001a\u00020\u000b\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00122\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\r0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\r0\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0004JN\u0010\u001b\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\r0\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u001cJb\u0010\u001d\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00122\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\r0\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u001eR!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/base/StdModel;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "()V", "listOfRequest", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/network/ICJPayRequest;", "getListOfRequest", "()Ljava/util/ArrayList;", "listOfRequest$delegate", "Lkotlin/Lazy;", "cancelRequest", "", MonitorConstants.CONNECT_TYPE_GET, ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "url", "", "header", "", "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;", "clazz", "Ljava/lang/Class;", "optResFromData", "", UGCMonitor.TYPE_POST, "formData", "suspendGet", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/Class;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendPost", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Class;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class StdModel implements ICJTag {
    private final Lazy listOfRequest$delegate;

    private final ArrayList<ICJPayRequest> getListOfRequest() {
        return (ArrayList) this.listOfRequest$delegate.getValue();
    }

    public StdModel() {
        this.listOfRequest$delegate = LazyKt.lazy(StdModel$listOfRequest$2.INSTANCE);
    }

    public final void cancelRequest() {
        Iterator<T> r100 = getListOfRequest().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ICJPayRequest) r100.next()).cancel();
        goto L4
    L6:
        getListOfRequest().clear();
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    public final <T extends CJPayObject> void get(final String r100, Map<String, String> r101, final ICJPayNetWorkCallback<T> r110, final Class<T> r111, final boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "header");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Intrinsics.checkNotNullParameter(r111, "clazz");
        ICJPayRequest r102 = CJPayNetworkManager.get(r100, MapsKt.toMutableMap(r101), new AnonymousClass1(r110, this, r112, r111, r100));
        if (r102 == null) goto L6;
        getListOfRequest().add(r102);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends CJPayObject> Object suspendGet(String r110, Map<String, String> r111, Class<T> r112, boolean r113, Continuation<? super T> r114) {
        final j r100 = new j(IntrinsicsKt.intercepted(r114), 1);
        r100.C();
        get(r110, r111, new StdModel$suspendGet$2$1(r100), r112, r113);
        Object r115 = r100.B();
        if (r115 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r114);
    L5:
        return r115;
    }

    public final <T extends CJPayObject> void post(final String r100, Map<String, String> r101, Map<String, String> r110, final ICJPayNetWorkCallback<T> r111, final Class<T> r112, final boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "formData");
        Intrinsics.checkNotNullParameter(r110, "header");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "clazz");
        ICJPayRequest r102 = CJPayNetworkManager.postForm(r100, MapsKt.toMutableMap(r101), MapsKt.toMutableMap(r110), new C88391(r111, this, r113, r112, r100));
        if (r102 == null) goto L6;
        getListOfRequest().add(r102);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends CJPayObject> Object suspendPost(String r110, Map<String, String> r111, Map<String, String> r112, Class<T> r113, boolean r114, Continuation<? super T> r115) {
        final j r100 = new j(IntrinsicsKt.intercepted(r115), 1);
        r100.C();
        post(r110, r111, r112, new StdModel$suspendPost$2$1(r100), r113, r114);
        Object r101 = r100.B();
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r115);
    L5:
        return r101;
    }

    public static /* synthetic */ void get$default(StdModel r100, String r101, Map r102, ICJPayNetWorkCallback r103, Class r110, boolean r111, int r112, Object r113) {
        if (r113 != null) goto L10;
        if ((r112 & 16) == 0) goto L6;
        boolean r104 = true;
    L7:
        r100.get(r101, r102, r103, r110, r104);
        return;
    L6:
        r104 = r111;
        goto L7
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
    }

    public static /* synthetic */ Object suspendGet$default(StdModel r100, String r101, Map r102, Class r103, boolean r110, Continuation r111, int r112, Object r113) {
        if (r113 != null) goto L10;
        if ((r112 & 8) == 0) goto L6;
        boolean r104 = true;
    L8:
        return r100.suspendGet(r101, r102, r103, r104, r111);
    L6:
        r104 = r110;
        goto L8
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: suspendGet");
    }

    public static /* synthetic */ void post$default(StdModel r100, String r101, Map r102, Map r110, ICJPayNetWorkCallback r111, Class r112, boolean r113, int r114, Object r115) {
        if (r115 != null) goto L10;
        if ((r114 & 32) == 0) goto L6;
        boolean r103 = true;
    L7:
        r100.post(r101, r102, r110, r111, r112, r103);
        return;
    L6:
        r103 = r113;
        goto L7
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: post");
    }

    public static /* synthetic */ Object suspendPost$default(StdModel r100, String r101, Map r102, Map r110, Class r111, boolean r112, Continuation r113, int r114, Object r115) {
        if (r115 != null) goto L10;
        if ((r114 & 16) == 0) goto L6;
        boolean r103 = true;
    L8:
        return r100.suspendPost(r101, r102, r110, r111, r103, r113);
    L6:
        r103 = r112;
        goto L8
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: suspendPost");
    }
}
