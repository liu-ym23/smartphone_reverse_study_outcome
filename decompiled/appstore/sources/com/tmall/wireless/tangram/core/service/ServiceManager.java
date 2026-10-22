package com.tmall.wireless.tangram.core.service;

/* JADX INFO: loaded from: classes4.dex */
public interface ServiceManager {
    <T> T getService(Class<T> r10);

    <T> void register(Class<T> r10, T r11);
}
