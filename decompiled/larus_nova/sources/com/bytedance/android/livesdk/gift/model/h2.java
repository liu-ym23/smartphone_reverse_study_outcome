package com.bytedance.android.livesdk.gift.model;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public interface h2 {
    int getAfterSendAction();

    List<Long> getAssetIds();

    String getDescribe();

    int getDiamondCount();

    long getDuration();

    long getGiftEndingTime();

    k0 getGiftPreviewInfo();

    long getId();

    py.k getImage();

    py.k getLeftLogo();

    String getName();

    long getPrimaryEffectId();

    boolean getRepeat();

    String getSortExtra();

    Map<String, Long> getSpecialEffects();

    int getType();

    boolean isDisplayedOnPanel();

    boolean isForFansClub();

    boolean isForFirstRecharge();
}
