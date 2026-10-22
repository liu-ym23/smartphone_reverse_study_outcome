package com.bytedance.android.livesdkapi.depend.model.live.abs;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
public interface IBaseRoom extends IRoom {

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.depend.model.live.abs.IBaseRoom$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isThirdPartyEx(IBaseRoom r100) {
            return false;
        }
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoom, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoom, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    String getAnchorId();

    boolean isThirdPartyEx();
}
