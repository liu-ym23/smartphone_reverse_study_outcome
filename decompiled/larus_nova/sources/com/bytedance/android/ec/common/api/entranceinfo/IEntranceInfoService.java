package com.bytedance.android.ec.common.api.entranceinfo;

import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import gl.a;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/common/api/entranceinfo/IEntranceInfoService;", "", "", "", "entranceInfoList", "fetchFilteredEntranceInfo", "entranceInfoString", "filterEntranceInfoInLocalTest", "Lcom/bytedance/android/ec/model/entranceinfo/EntranceInfoScene;", "scene", "entranceInfoStr", "Lgl/a;", "initEntranceInfo", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public interface IEntranceInfoService {
    List<String> fetchFilteredEntranceInfo(List<String> r100);

    String filterEntranceInfoInLocalTest(String r100);

    a initEntranceInfo(EntranceInfoScene r100, String r101);
}
