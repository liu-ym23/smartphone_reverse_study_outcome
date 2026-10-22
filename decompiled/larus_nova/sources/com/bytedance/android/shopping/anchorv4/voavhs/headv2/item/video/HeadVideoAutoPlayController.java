package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mira.conig.Constants;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class HeadVideoAutoPlayController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f169722a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Long f169723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedList<Long> f169724c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f169725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f169726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f169727f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HeadVideoAutoPlayController f169728g = null;

    public HeadVideoAutoPlayController() {
    }

    public final synchronized void d() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (f169727f == true) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (f169725d == true) goto L13;
        if (f169726e == true) goto L13;
        e("start load records");     // Catch: Throwable -> L15
        f169726e = true;     // Catch: Throwable -> L15
        b2.a(HeadVideoAutoPlayController$loadPauseEventRecords$1.INSTANCE);     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    static {
        final HeadVideoAutoPlayController r100 = new HeadVideoAutoPlayController();
        f169728g = r100;
        f169722a = LazyKt.lazy(new HeadVideoAutoPlayController$playProgressMap$2(r100));
        f169724c = new LinkedList();
        boolean r101 = true;
        if (ECSettingKeys.B0() == 1) goto L8;
        boolean r102 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.f169207a;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.f169207a == true) goto L8;
        r101 = false;
    L8:
        f169727f = r101;
    }

    public static void f() {
        if (f169727f == true) goto L5;
        return;
    L5:
        long r100 = System.currentTimeMillis();
        LinkedList<Long> r101 = f169724c;
        r101.add(0, Long.valueOf(System.currentTimeMillis()));
        if (r101.size() <= 21) goto L8;
        r101.remove(r101.size() - 1);
    L8:
        Long r102 = (Long) CollectionsKt.getOrNull(r101, 20);
        if (r102 != null) goto L11;
    L13:
        b2.a(HeadVideoAutoPlayController$savePauseEventToDisk$1.INSTANCE);
        e("call onPauseClick: records size=" + r101.size() + " stopAutoPlayFlag=" + f169723b);
        return;
    L11:
        if ((r100 - r102.longValue()) >= Constants.DOWNLOAD_TEMP_FILE_PAST_TIME) goto L13;
        f169723b = Long.valueOf(r100);
        r101.clear();
        b2.a(HeadVideoAutoPlayController$savePauseEventToDisk$1.INSTANCE);
        goto L13
    }

    public static boolean b(s r100) {
        Intrinsics.checkNotNullParameter(r100, "headAbility");
        StringBuilder r101 = new StringBuilder("call canAutoPlay: isEnableAutoPlay=");
        boolean r102 = f169727f;
        r101.append(r102);
        r101.append(" hasLoadedRecordsFromDisk=");
        r101.append(f169725d);
        e(r101.toString());
        boolean r103 = false;
        if (r102 == true) goto L6;
        return false;
    L6:
        if (r100.n0() == true) goto L9;
        return false;
    L9:
        if (r100.oa() == false) goto L12;
        return false;
    L12:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.f169207a == true) goto L17;
        if (r100.r9() == false) goto L17;
        return false;
    L17:
        if (NetworkUtils.isWifi(r100.getContext()) == true) goto L20;
        return false;
    L20:
        if (f169725d == true) goto L22;
        return false;
    L22:
        long r104 = System.currentTimeMillis();
        Long r105 = f169723b;
        if (r105 != null) goto L25;
        Long r106 = (Long) CollectionsKt.getOrNull(f169724c, 5);
        if (r106 != null) goto L32;
        return true;
    L32:
        if ((r104 - r106.longValue()) <= 86400000) goto L35;
        r103 = true;
    L35:
        return r103;
    L25:
        if ((r104 - r105.longValue()) <= Constants.DOWNLOAD_TEMP_FILE_PAST_TIME) goto L28;
        f169723b = null;
        f169724c.clear();
        b2.a(HeadVideoAutoPlayController$savePauseEventToDisk$1.INSTANCE);
        return true;
    L28:
        return false;
    }

    public static void e(String r100) {
        if (ECAppInfoService.f48114e.isLocalTest() == false) goto L6;
        dm.a.a("PdpHeadAutoPlay").i(r100);
        return;
    }

    public static String a(VideoModel r100, s r101) {
        StringBuilder r102 = new StringBuilder();
        CommonMeta r103 = r101.rR().r0();
        if (r103 == null) goto L5;
        String r104 = r103.getPromotionId();
    L6:
        r102.append(r104);
        r102.append('_');
        r102.append(r100.getVid());
        return r102.toString();
    L5:
        r104 = null;
        goto L6
    }

    public static Long c(VideoModel r100, s r101) {
        Intrinsics.checkNotNullParameter(r101, "headAbility");
        if (f169727f == true) goto L5;
        return null;
    L5:
        if (r100 != null) goto L7;
        return null;
    L7:
        String r102 = a(r100, r101);
        StringBuilder r103 = new StringBuilder("call getPlayProgress id=");
        r103.append(r102);
        r103.append(" progress=");
        Lazy r104 = f169722a;
        r103.append((Long) ((HeadVideoAutoPlayController$playProgressMap$2.AnonymousClass1) r104.getValue()).get(r102));
        e(r103.toString());
        return (Long) ((HeadVideoAutoPlayController$playProgressMap$2.AnonymousClass1) r104.getValue()).get(r102);
    }

    public static void g(VideoModel r100, s r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "headAbility");
        if (f169727f == true) goto L5;
        return;
    L5:
        String r103 = a(r100, r101);
        ((HeadVideoAutoPlayController$playProgressMap$2.AnonymousClass1) f169722a.getValue()).put(r103, Long.valueOf(r102));
        e("call savePlayProgress id=" + r103 + " progress=" + r102);
    }
}
