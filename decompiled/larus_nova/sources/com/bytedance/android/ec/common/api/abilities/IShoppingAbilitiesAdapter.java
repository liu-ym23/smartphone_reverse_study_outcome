package com.bytedance.android.ec.common.api.abilities;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import ze.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/common/api/abilities/IShoppingAbilitiesAdapter;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "schema", "Lze/a;", "preloadStrategy", "", "forceEnable", "", "preloadPdpBySchema", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public interface IShoppingAbilitiesAdapter {
    void preloadPdpBySchema(Context r100, String r101, a r102, boolean r103);
}
