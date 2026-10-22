package com.jeffmony.async.future;

/* JADX INFO: loaded from: classes3.dex */
public interface TypeConverter<T, F> {
    Future<T> convert(F r10, String r11) throws Exception;
}
