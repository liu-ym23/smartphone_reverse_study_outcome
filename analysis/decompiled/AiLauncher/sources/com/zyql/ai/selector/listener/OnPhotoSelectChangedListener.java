package com.zyql.ai.selector.listener;

import java.util.List;

/* loaded from: classes4.dex */
public interface OnPhotoSelectChangedListener<T> {
    void onChange(List<T> list);

    void onPictureClick(T t10, int i10);

    void onTakePhoto();
}
