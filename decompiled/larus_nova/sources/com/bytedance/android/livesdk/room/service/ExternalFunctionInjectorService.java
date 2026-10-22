package com.bytedance.android.livesdk.room.service;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IExternalFunctionInjector;
import com.bytedance.android.livesdk.config.jb;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.room.util.j;
import com.bytedance.android.livesdk.room.util.l;
import com.bytedance.android.livesdkapi.room.controller.DefaultStartLiveController;
import com.bytedance.android.livesdkapi.room.controller.ILiveMergeRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController;
import com.bytedance.android.livesdkapi.room.controller.RoomControllerKeyProvider;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tb1.c;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u0000 12\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b/\u00100J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J!\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0005*\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u001e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR!\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010*R\u0019\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00168F¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/room/service/ExternalFunctionInjectorService;", "Lcom/bytedance/android/live/room/IExternalFunctionInjector;", "", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomControllerProvider;", "filterProvider", ExifInterface.GPS_DIRECTION_TRUE, ShortVideoSegments.KEY_PROP_PROVIDER, "", "injectRoomControllerProvider", "(Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomControllerProvider;)V", "", "roomId", "", "identityCode", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomController;", "getLiveRoomController", "", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomControllerProvider$ProviderSource;", "source", "clearLiveRoomController", "Lcom/bytedance/android/livesdkapi/room/controller/IStartLivePreviewController;", "getStartLivePreviewController", "", "providers", "Ljava/util/Set;", "", "isFilterCommerceProvider", "Z", "()Z", "setFilterCommerceProvider", "(Z)V", "isFilterLiveAdProvider", "setFilterLiveAdProvider", "", "rejectList$delegate", "Lkotlin/Lazy;", "getRejectList", "()Ljava/util/List;", "rejectList", "Lcom/bytedance/android/livesdk/room/service/a;", "secureImpl$delegate", "getSecureImpl", "()Lcom/bytedance/android/livesdk/room/service/a;", "secureImpl", "getExposedProviders", "()Ljava/util/Set;", "exposedProviders", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ExternalFunctionInjectorService implements IExternalFunctionInjector {
    public static final String COMMERCE_PROVIDER_NAME_PREFIX = "com.bytedance.android.ec";
    public static final a Companion = null;
    public static final String LIVE_AD_COMMON_PROVIDER_NAME_PREFIX = "com.bytedance.ad.room";
    public static final String LIVE_AD_PROVIDER_NAME_PREFIX = "com.ss.android.ugc.aweme.live_ad";
    private boolean isFilterCommerceProvider;
    private boolean isFilterLiveAdProvider;
    private Set<? extends ILiveRoomControllerProvider> providers;
    private final Lazy rejectList$delegate;
    private final Lazy secureImpl$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean b() {
            IService r100 = k.f(IExternalFunctionInjector.class);
            Object r101 = null;
            if ((r100 instanceof ExternalFunctionInjectorService) == true) goto L5;
            r100 = null;
        L5:
            ExternalFunctionInjectorService r102 = (ExternalFunctionInjectorService) r100;
            if (r102 == null) goto L8;
            Set<ILiveRoomControllerProvider> r103 = r102.getExposedProviders();
        L10:
            if (r103 == null) goto L18;
            Iterator<T> r104 = r103.iterator();
        L13:
            if (r104.hasNext() == false) goto L17;
            Object r105 = r104.next();
            if (StringsKt.startsWith$default(((ILiveRoomControllerProvider) r105).getClass().getName(), ExternalFunctionInjectorService.COMMERCE_PROVIDER_NAME_PREFIX, false, 2, null) == false) goto L13;
            r101 = r105;
        L17:
            r101 = (ILiveRoomControllerProvider) r101;
        L18:
            if (r101 == null) goto L24;
            return true;
        L24:
            return false;
        L8:
            r103 = null;
            goto L10
        }

        @JvmStatic
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            if (k.f(IHostCommerceServiceLive.class) == null) goto L8;
            boolean r101 = b();
            if (r101 == true) goto L7;
            c(false, r100);
        L7:
            ALogger.w("ECLiveMonitor_" + r100, "CommerceService not null; injectSuccess:" + r101);
            return;
        L8:
            ALogger.w("ECLiveMonitor_" + r100, "CommerceService is null");
            c(true, r100);
        }

        @JvmStatic
        public static void d(boolean r100) {
            boolean r101 = false;
            if (r100 == true) goto L5;
        L7:
            boolean r102 = false;
        L8:
            IService r103 = k.f(IExternalFunctionInjector.class);
            IService r104 = null;
            if ((r103 instanceof ExternalFunctionInjectorService) == true) goto L11;
            r103 = null;
        L11:
            ExternalFunctionInjectorService r105 = (ExternalFunctionInjectorService) r103;
            if (r105 == null) goto L14;
            r105.setFilterCommerceProvider(r102);
        L14:
            if (r100 == true) goto L16;
        L18:
            IService r106 = k.f(IExternalFunctionInjector.class);
            if ((r106 instanceof ExternalFunctionInjectorService) == false) goto L22;
            r104 = r106;
        L22:
            ExternalFunctionInjectorService r107 = (ExternalFunctionInjectorService) r104;
            if (r107 == null) goto L26;
            r107.setFilterLiveAdProvider(r101);
            return;
        L26:
            return;
        L16:
            if (c.f545229a == false) goto L18;
            r101 = true;
            goto L18
        L5:
            if (Intrinsics.areEqual(jb.f120511a.getValue(), Boolean.FALSE) == false) goto L7;
            r102 = true;
            goto L8
        }

        public static void c(boolean r100, String r101) {
            g r102 = u.l();
            Pair[] r103 = new Pair[3];
            r103[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
            r103[1] = TuplesKt.to("scene", r101);
            if (r100 == false) goto L5;
            String r104 = "0";
        L6:
            r103[2] = TuplesKt.to("error_code", r104);
            r102.sendLog("livesdk_commerce_service_error", MapsKt.mutableMapOf(r103), new Object[0]);
            return;
        L5:
            r104 = "1";
            goto L6
        }
    }

    @JvmStatic
    public static final void checkCommerceServiceState(String r100) {
        Companion.getClass();
        a.a(r100);
    }

    private final List<String> getRejectList() {
        return (List) this.rejectList$delegate.getValue();
    }

    private final com.bytedance.android.livesdk.room.service.a getSecureImpl() {
        return (com.bytedance.android.livesdk.room.service.a) this.secureImpl$delegate.getValue();
    }

    @JvmStatic
    public static final boolean hasCommerceInject() {
        Companion.getClass();
        return a.b();
    }

    @JvmStatic
    public static final void setIsBroadcast(boolean r100) {
        Companion.getClass();
        a.d(r100);
    }

    static {
        Companion = new a();
    }

    private final Collection<ILiveRoomControllerProvider> filterProvider() {
        if (this.isFilterCommerceProvider == false) goto L11;
        Set<ILiveRoomControllerProvider> r100 = getExposedProviders();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L35;
        Object r103 = r102.next();
        if ((!StringsKt.startsWith$default(((ILiveRoomControllerProvider) r103).getClass().getName(), COMMERCE_PROVIDER_NAME_PREFIX, false, 2, null)) == false) goto L6;
        r101.add(r103);
        goto L6
    L35:
        return r101;
    L11:
        if (this.isFilterLiveAdProvider == false) goto L24;
        Set<ILiveRoomControllerProvider> r104 = getExposedProviders();
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L14:
        if (r106.hasNext() == false) goto L36;
        Object r107 = r106.next();
        ILiveRoomControllerProvider r108 = (ILiveRoomControllerProvider) r107;
        if (StringsKt.startsWith$default(r108.getClass().getName(), LIVE_AD_PROVIDER_NAME_PREFIX, false, 2, null) == false) goto L18;
    L20:
        boolean r109 = false;
    L21:
        if (r109 == false) goto L14;
        r105.add(r107);
        goto L14
    L18:
        if (StringsKt.startsWith$default(r108.getClass().getName(), LIVE_AD_COMMON_PROVIDER_NAME_PREFIX, false, 2, null) == true) goto L20;
        r109 = true;
        goto L21
    L36:
        return r105;
    L24:
        return getExposedProviders();
    }

    public ExternalFunctionInjectorService() {
        this.providers = SetsKt.emptySet();
        this.rejectList$delegate = LazyKt.lazy(ExternalFunctionInjectorService$rejectList$2.INSTANCE);
        this.secureImpl$delegate = LazyKt.lazy(ExternalFunctionInjectorService$secureImpl$2.INSTANCE);
    }

    public final Set<ILiveRoomControllerProvider> getExposedProviders() {
        return getSecureImpl().f157813b;
    }

    @Override // com.bytedance.android.live.room.IExternalFunctionInjector
    public IStartLivePreviewController getStartLivePreviewController() {
        Collection<ILiveRoomControllerProvider> r100 = filterProvider();
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        IStartLivePreviewController r103 = ((ILiveRoomControllerProvider) r102.next()).getStartLivePreviewController();     // Catch: Error -> L10
        if (r103 != null) goto L11;
        r103 = new DefaultStartLiveController();     // Catch: Error -> L10
    L11:
        r101.add(r103);
    L10:
        r103 = new DefaultStartLiveController();
        goto L11
    L13:
        return new l(CollectionsKt.filterNotNull(r101));
    }

    public final boolean isFilterCommerceProvider() {
        return this.isFilterCommerceProvider;
    }

    public final boolean isFilterLiveAdProvider() {
        return this.isFilterLiveAdProvider;
    }

    @Override // com.bytedance.android.live.room.IExternalFunctionInjector
    public <T extends ILiveRoomControllerProvider> void injectRoomControllerProvider(T r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        getSecureImpl().injectRoomControllerProvider(r100);
        boolean r101 = j.f157836a;
        String r102 = "regiset " + r100 + ", provider=" + r100.hashCode();
        Intrinsics.checkNotNullParameter(r102, "msg");
        if (j.f157836a == false) goto L6;
        ALogger.i("CommonRoomControllerTracer", r102);
        return;
    }

    public final void setFilterCommerceProvider(boolean r100) {
        this.isFilterCommerceProvider = r100;
    }

    public final void setFilterLiveAdProvider(boolean r100) {
        this.isFilterLiveAdProvider = r100;
    }

    @Override // com.bytedance.android.live.room.IExternalFunctionInjector
    public void clearLiveRoomController(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        clearLiveRoomController(r100, r101, ILiveRoomControllerProvider.ProviderSource.DEFAULT);
    }

    @Override // com.bytedance.android.live.room.IExternalFunctionInjector
    public ILiveRoomController getLiveRoomController(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        return getLiveRoomController(r100, r101, ILiveRoomControllerProvider.ProviderSource.DEFAULT);
    }

    @Override // com.bytedance.android.live.room.IExternalFunctionInjector
    public ILiveRoomController getLiveRoomController(long r100, int r101) {
        return getLiveRoomController(String.valueOf(r100), r101);
    }

    @Override // com.bytedance.android.live.room.IExternalFunctionInjector
    public void clearLiveRoomController(String r100, int r101, ILiveRoomControllerProvider.ProviderSource r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r102, "source");
        String r103 = RoomControllerKeyProvider.generateKey(r100, r101);
        Iterator<T> r104 = filterProvider().iterator();
    L4:
        if (r104.hasNext() == false) goto L12;
        ILiveRoomControllerProvider r105 = (ILiveRoomControllerProvider) r104.next();
        boolean r106 = j.f157836a;
        String r107 = "clearLiveRoomController called. businessType = " + r105.businessType() + ",code=" + r105.hashCode() + " roomId = " + r100 + ", identityCode = " + r101;
        Intrinsics.checkNotNullParameter(r107, "msg");
        if (j.f157836a == false) goto L9;
        ALogger.i("CommonRoomControllerTracer", r107);
    L9:
        if ((r105 instanceof ILiveMergeRoomControllerProvider) == true) goto L10;
        r105.substituteClearLiveRoomController(r100, r103);
        goto L4
    L10:
        ((ILiveMergeRoomControllerProvider) r105).substituteClearLiveRoomController(r100, r103, r102);
        goto L4
    }

    @Override // com.bytedance.android.live.room.IExternalFunctionInjector
    public ILiveRoomController getLiveRoomController(String r100, int r101, ILiveRoomControllerProvider.ProviderSource r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r102, "source");
        return getSecureImpl().getLiveRoomController(r100, r101, r102);
    }
}
