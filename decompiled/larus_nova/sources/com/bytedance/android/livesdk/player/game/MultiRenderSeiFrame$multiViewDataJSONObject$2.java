package com.bytedance.android.livesdk.player.game;

import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class MultiRenderSeiFrame$multiViewDataJSONObject$2 extends FunctionReferenceImpl implements Function0<JSONObject> {
    public MultiRenderSeiFrame$multiViewDataJSONObject$2(MultiRenderSeiFrame r100) {
        super(0, r100, MultiRenderSeiFrame.class, "parseMultiViewDataJson", "parseMultiViewDataJson()Lorg/json/JSONObject;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final JSONObject invoke2() {
        String r100 = ((MultiRenderSeiFrame) this.receiver).f155387g;
        LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L5
        return LiveSeiUtil.c(r100).optJSONObject("multi_view_data");
    L5:
        return null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ JSONObject invoke() {
        return invoke2();
    }
}
