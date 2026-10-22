package com.bytedanceos.common.ad.listener;

import android.view.View;
import com.bytedanceos.common.ad.entity.rep.RepAdEntity;
import com.bytedanceos.common.ad.entity.rep.media.RepMediaEntity;

/* JADX INFO: loaded from: classes2.dex */
public interface AdListener<M extends RepMediaEntity> {
    void onClick(RepAdEntity<M> r10, View r11);

    void onDismiss();

    void onNoAD(String r10);

    boolean onPresent(RepAdEntity<M> r10, View r11);

    void onResponse(RepAdEntity<M> r10);

    void onSkip(RepAdEntity<M> r10);
}
