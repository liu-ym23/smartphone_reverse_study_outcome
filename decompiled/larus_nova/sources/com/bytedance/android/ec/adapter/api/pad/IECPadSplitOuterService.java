package com.bytedance.android.ec.adapter.api.pad;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/pad/IECPadSplitOuterService;", "", "handleWideScreenAdaptParams", "Landroid/net/Uri;", "uri", "isEnableWideScreenAdapt", "", "showInSplit", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECPadSplitOuterService {
    Uri handleWideScreenAdaptParams(Uri r100);

    boolean isEnableWideScreenAdapt();

    boolean showInSplit(Context r100, Uri r101);
}
