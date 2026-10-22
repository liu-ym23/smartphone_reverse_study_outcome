package com.bytedance.android.ec.search.host.impl;

import android.content.Context;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.slice.api.ISliceInitService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostRouterService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.model.SearchEnterParam;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements ITradeSearchAwemeHostService {
    public g() {
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final boolean containCurrentPage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        return false;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final String getPageType(FragmentActivity r100) {
        return "";
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final String getPitayaUploadInfo(FragmentActivity r100) {
        return null;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final String getPrivacyState() {
        return "";
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final List<Pair<String, String>> getSearchHistoryForSugSession(SearchEnterParam r100) {
        Intrinsics.checkNotNullParameter(r100, "enterParam");
        return null;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final Object getValueByConfig(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return "";
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final View inflate(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        return null;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final String nextPredictId() {
        return "";
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final String staticBuildTransWithPitaya(FragmentActivity r100) {
        return "";
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final void staticConsumePitayaUploadInfo(FragmentActivity r100) {
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final boolean banOvalBlur() {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final void initSlice() {
        int r100 = ECSdk.f48106a;
        ISliceInitService r101 = (ISliceInitService) ECSdk.a(ISliceInitService.class);
        if (r101 == null) goto L6;
        r101.initSlice();
        return;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final void ovalDimBlur(View r100, float r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Build.VERSION.SDK_INT < 31) goto L8;
        r100.setVisibility(0);
        r100.setRenderEffect(RenderEffect.createBlurEffect(r101, r101, Shader.TileMode.DECAL));
        return;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final void openRoute(Context r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "map");
        ITradeSearchHostService r103 = TradeSearch.c(TradeSearch.f453393a);
        if (r103 == null) goto L8;
        ITradeSearchHostRouterService r104 = r103.getITradeSearchHostRouterService();
        if (r104 == null) goto L9;
        r104.openSchema(r100, r101);
        return;
    L9:
        return;
    }
}
