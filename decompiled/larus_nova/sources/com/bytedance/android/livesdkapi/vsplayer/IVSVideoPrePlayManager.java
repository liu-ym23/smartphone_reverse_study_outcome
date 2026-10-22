package com.bytedance.android.livesdkapi.vsplayer;

import android.os.Bundle;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/vsplayer/IVSVideoPrePlayManager;", "", "release", "", "startPrePlay", "", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "bundle", "Landroid/os/Bundle;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVSVideoPrePlayManager {
    void release();

    boolean startPrePlay(ViewGroup r100, Bundle r101);
}
