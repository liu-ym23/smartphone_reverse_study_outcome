package com.stepos.activeview.download;

import android.content.Context;
import com.stepos.activeview.json.ActiveData;

/* loaded from: classes.dex */
public interface GetActInterface {
    Context getContextForTask();

    void onDownloadError();

    void onDownloadSuccess(String str);

    void onExtractError(String str);

    void onExtractSuccess(String str);

    void onLoadDataError();

    void onLoadDataSuccess(ActiveData activeData);
}
