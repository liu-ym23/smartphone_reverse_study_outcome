package com.bytedance.android.shopping.mall.feed.opt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECExposureDataDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECTrackDataDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import yj.t;

/* JADX INFO: loaded from: classes13.dex */
public final class MallLiveCardOpt implements com.bytedance.android.shopping.mall.feed.opt.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Bitmap f177168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Bitmap f177169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f177170d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f177171a;

    public static final class a {
        public a() {
        }
    }

    static {
        f177170d = new a();
    }

    public MallLiveCardOpt() {
        this.f177171a = LazyKt.lazy(MallLiveCardOpt$liveService$2.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.mall.feed.opt.a
    public final void a(Context r100, HomePageDTO r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        c(r100, r101);
    }

    @Override // com.bytedance.android.shopping.mall.feed.opt.a
    public final void b(Context r100, HomePageDTO r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        f177170d.getClass();
        f177168b = BitmapFactory.decodeResource(r100.getResources(), R.drawable.shopping_homepage_ic_mute_playback);
        f177169c = BitmapFactory.decodeResource(r100.getResources(), R.drawable.shopping_homepage_ic_unmute_playback);
        c(r100, r101);
    }

    public final void c(Context r100, HomePageDTO r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        HomePageBffDTO r102 = r101.getBff();
        if (r102 == null) goto L45;
        ECHybridListDTO r103 = r102.getFeed();
        if (r103 == null) goto L69;
        List<ECHybridListSectionDTO> r104 = r103.getSections();
        if (r104 == null) goto L70;
        Iterator<T> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L71;
        ArrayList<ECHybridListItemDTO> r106 = ((ECHybridListSectionDTO) r105.next()).getItems();
        if (r106 == null) goto L12;
        Iterator<T> r107 = r106.iterator();
    L17:
        if (r107.hasNext() == false) goto L12;
        ECHybridListItemDTO r108 = (ECHybridListItemDTO) r107.next();
        Integer r109 = r108.getItemType();
        if (r109 == null) goto L17;
        if (r109.intValue() != 1002) goto L17;
        ECTrackDataDTO r110 = r108.getTrackData();
        if (r110 == null) goto L17;
        List<ECExposureDataDTO> r111 = r110.getExposureData();
        if (r111 == null) goto L17;
        Iterator<T> r112 = r111.iterator();
    L29:
        if (r112.hasNext() == false) goto L17;
        ECExposureDataDTO r113 = (ECExposureDataDTO) r112.next();
        if (Intrinsics.areEqual(r113.getEventName(), "show_ecom_card") == false) goto L29;
        Map<String, Object> r114 = r113.getParams();
        Object r115 = null;
        if (r114 == null) goto L35;
        Object r116 = r114.get("room_id");
    L37:
        if ((r116 instanceof String) == false) goto L40;
        r115 = r116;
    L40:
        String r117 = (String) r115;
        if (r117 == null) goto L29;
        t r118 = (t) this.f177171a.getValue();
        if (r118 == null) goto L29;
        r118.createPlayViewAndSave(r100, r117);
        goto L29
    L35:
        r116 = null;
        goto L37
    L71:
        return;
    L70:
        return;
    L69:
        return;
    }
}
