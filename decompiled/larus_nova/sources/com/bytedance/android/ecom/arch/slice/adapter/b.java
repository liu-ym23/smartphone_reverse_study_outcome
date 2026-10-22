package com.bytedance.android.ecom.arch.slice.adapter;

/* JADX INFO: loaded from: classes44.dex */
public interface b {
    boolean areContentsTheSame(b r100);

    boolean areItemsTheSame(b r100);

    long getItemKey();

    <T> T getTag(Class<T> r100, String r101);

    void setItemKey(long r100);

    void setTag(String r100, Object r101);
}
