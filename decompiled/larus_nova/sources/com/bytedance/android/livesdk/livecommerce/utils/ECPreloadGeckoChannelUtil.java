package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes10.dex */
public final class ECPreloadGeckoChannelUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f153043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f153044b;

    public static final class a extends GeckoUpdateListener {
        public a() {
        }

        @Override // com.bytedance.geckox.listener.GeckoUpdateListener
        public final void onLocalNewestVersion(LocalPackageModel r100) {
            super.onLocalNewestVersion(r100);
            if (r100 == null) goto L6;
            r100.getChannel();
            return;
        }

        @Override // com.bytedance.geckox.listener.GeckoUpdateListener
        public final void onUpdateFailed(UpdatePackage r100, Throwable r101) {
            super.onUpdateFailed(r100, r101);
            if (r100 == null) goto L6;
            r100.getChannel();
            return;
        }

        @Override // com.bytedance.geckox.listener.GeckoUpdateListener
        public final void onUpdateSuccess(UpdatePackage r100, long r101) {
            super.onUpdateSuccess(r100, r101);
            if (r100 == null) goto L6;
            r100.getChannel();
            return;
        }
    }

    public ECPreloadGeckoChannelUtil() {
    }

    public static void a() {
        hh2.g r100 = hh2.f.f485165a.f485167a;
        if (r100 == null) goto L7;
        Boolean r101 = r100.o();
        if (r101 == null) goto L7;
        boolean r102 = r101.booleanValue();
    L8:
        if (r102 == true) goto L11;
        return;
    L11:
        if (f153043a == false) goto L13;
        return;
    L13:
        f153043a = true;
        int r103 = LiveSettingKeys.getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_ENABLE_TYPE();
        f153044b = r103;
        if (r103 != 0) goto L16;
        return;
    L16:
        List<String> r104 = LiveSettingKeys.getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_CHANNELS_LIST();
        Objects.toString(r104);
        if (r104.isEmpty() == false) goto L19;
        return;
    L19:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ECPreloadGeckoChannelUtil$startPreload$1(r104, null), 3, null);
        return;
    L7:
        r102 = false;
        goto L8
    }

    static {
    }

    public static boolean b(List r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "channels");
        if (ECAppInfoService.f48114e.i() == false) goto L5;
        String r102 = "36723dc3e85a23e701d1697d57de07ed";
    L6:
        GeckoClient r103 = com.bytedance.geckox.a.a(r102);
        if (r103 != null) goto L9;
        return false;
    L9:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r100.iterator();
    L10:
        String r106 = null;
        if (r105.hasNext() == false) goto L35;
        String r107 = (String) r105.next();
        Intrinsics.checkNotNullParameter(r102, "accessKey");
        Intrinsics.checkNotNullParameter(r107, "channel");
        com.bytedance.geckox.b r108 = com.bytedance.geckox.b.a.f245076a;
        Map<String, String> r109 = GlobalManager.f250635d;
        if (r109 == null) goto L15;
        r106 = (String) ((ConcurrentHashMap) r109).get(r102);
    L15:
        if (r106 != null) goto L17;
    L20:
        boolean r110 = true;
    L21:
        if (r110 == false) goto L23;
        boolean r111 = false;
    L32:
        if (r111 == true) goto L10;
        r104.add(r107);
        goto L10
    L23:
        String r112 = ResLoadUtils.getChannelPath(new PolarisFileWrapper(r106), r102, r107);
        if (r112 != null) goto L26;
    L29:
        boolean r113 = true;
    L30:
        r111 = true ^ r113;
        goto L32
    L26:
        if (StringsKt.isBlank(r112) == true) goto L29;
        r113 = false;
        goto L30
    L17:
        if (StringsKt.isBlank(r106) == true) goto L20;
        r110 = false;
        goto L21
    L35:
        if ((!r104.isEmpty()) == true) goto L37;
    L43:
        return true;
    L37:
        if (r101 != 2) goto L43;
        OptionCheckUpdateParams r114 = new OptionCheckUpdateParams().setListener(new a());
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r116 = r104.iterator();
    L40:
        if (r116.hasNext() == false) goto L42;
        r115.add(new CheckRequestBodyModel.TargetChannel((String) r116.next()));
        goto L40
    L42:
        r103.checkUpdateMulti(null, MapsKt.mapOf(TuplesKt.to(r102, r115)), r114);
        goto L43
    L5:
        r102 = "5fb33cde3ebff01c8433ddc22aac0816";
        goto L6
    }
}
