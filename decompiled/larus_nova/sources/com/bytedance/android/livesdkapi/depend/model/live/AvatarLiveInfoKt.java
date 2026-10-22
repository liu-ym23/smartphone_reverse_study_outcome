package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.model.ImageModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"isValid", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/AvatarLiveInfo;", "livebase-model_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class AvatarLiveInfoKt {
    public static final boolean isValid(AvatarLiveInfo r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        ImageModel r101 = r100.image;
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.isValid() != true) goto L28;
        String r102 = r100.text;
        if (r102 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == true) goto L29;
        String r104 = r100.type;
        if (r104 != null) goto L20;
    L23:
        boolean r105 = true;
    L24:
        if (r105 == true) goto L30;
        return true;
    L30:
        return false;
    L20:
        if (r104.length() == 0) goto L23;
        r105 = false;
        goto L24
    L29:
        return false;
    L12:
        if (r102.length() == 0) goto L15;
        r103 = false;
        goto L16
    L28:
        return false;
    }
}
