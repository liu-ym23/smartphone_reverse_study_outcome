package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class HeadVideoAutoPlayController$savePauseEventToDisk$1 extends Lambda implements Function0<Unit> {
    public static final HeadVideoAutoPlayController$savePauseEventToDisk$1 INSTANCE = null;

    static {
        INSTANCE = new HeadVideoAutoPlayController$savePauseEventToDisk$1();
    }

    public HeadVideoAutoPlayController$savePauseEventToDisk$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        mj.a r100 = com.bytedance.android.ec.sdk.helper.d.f48119b.getIECSPService();
        JSONObject r101 = new JSONObject();
        Lazy r102 = HeadVideoAutoPlayController.f169722a;
        Long r103 = HeadVideoAutoPlayController.f169723b;
        if (r103 == null) goto L5;
        r101.put("stop_flag", r103.longValue());
    L5:
        r101.put("records", new JSONArray(HeadVideoAutoPlayController.f169724c));
        Unit r104 = Unit.INSTANCE;
        r100.putString("ec_pd_head_video_pause_event", r101.toString());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
