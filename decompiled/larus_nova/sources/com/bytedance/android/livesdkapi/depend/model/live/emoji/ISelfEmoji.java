package com.bytedance.android.livesdkapi.depend.model.live.emoji;

import java.util.List;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
public interface ISelfEmoji extends IBaseEmoji {
    String getAnimateType();

    k getAnimatedImage();

    String getDisplayName();

    String getId();

    long getResourcesId();

    int[] getSelfPosition();

    k getStaticImage();

    int getStickerType();

    int getViewHeight();

    int getViewWidth();

    String getWebUri();

    List<String> getmUrls();

    boolean isFromCache();

    boolean isGif();

    void setAnimateType(String r100);

    void setDisplayName(String r100);

    void setGif(boolean r100);

    void setId(String r100);

    void setIsFromCache(boolean r100);

    void setResourcesId(long r100);

    void setSelfPosition(int[] r100);

    void setStickerType(int r100);

    void setUrls(List<String> r100);

    void setViewHeight(int r100);

    void setViewWidth(int r100);

    void setWebUri(String r100);
}
