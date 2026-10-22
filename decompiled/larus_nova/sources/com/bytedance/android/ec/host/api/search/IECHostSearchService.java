package com.bytedance.android.ec.host.api.search;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0007H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H&J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/host/api/search/IECHostSearchService;", "", "containCurrentPage", "", "pageName", "", "getMallScene", "Lcom/bytedance/android/ec/host/api/search/MALLSCENE;", "getPitayaUploadInfo", "activity", "Landroidx/fragment/app/FragmentActivity;", WidgetCostModule.TYPE_INFLATE, "Landroid/view/View;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "layoutId", "", "onUpdatePageState", "", "isShow", "sceneID", "scene", "showWindWane", "staticBuildTransWithPitaya", "staticConsumePitayaUploadInfo", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECHostSearchService {
    boolean containCurrentPage(String r100);

    MALLSCENE getMallScene(String r100);

    String getPitayaUploadInfo(FragmentActivity r100);

    View inflate(ViewGroup r100, int r101);

    void onUpdatePageState(boolean r100, String r101, MALLSCENE r102);

    boolean showWindWane(MALLSCENE r100);

    String staticBuildTransWithPitaya(FragmentActivity r100);

    void staticConsumePitayaUploadInfo(FragmentActivity r100);
}
