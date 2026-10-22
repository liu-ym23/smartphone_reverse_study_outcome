package com.bytedance.android.ec.model.abscontainer;

import android.os.Parcelable;
import android.view.View;
import gl.a;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/model/abscontainer/ISchemaModel;", "Landroid/os/Parcelable;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public interface ISchemaModel extends Parcelable {
    void appendBtmToken(View r100, String r101, Map<String, ? extends Object> r102);

    String formatToUrl();

    a getEntranceInfo();

    String getQueryParam(String r100);

    Map<String, Object> recordInfo();

    void replaceOrAppendParam(String r100, String r101);
}
