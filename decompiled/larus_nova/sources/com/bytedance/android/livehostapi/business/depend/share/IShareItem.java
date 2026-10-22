package com.bytedance.android.livehostapi.business.depend.share;

import com.bytedance.android.live.base.model.ImageModel;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public interface IShareItem extends Serializable {
    boolean canShare();

    String getDisplayName();

    String getDotName();

    ImageModel getImageModel();

    String getKey();

    int getResId();

    IShareAble.SharePlatform getSharePlatform();

    boolean showRedDot();
}
