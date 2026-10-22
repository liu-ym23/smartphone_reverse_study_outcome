package com.jeffmony.async.parser;

import com.jeffmony.async.DataEmitter;
import com.jeffmony.async.DataSink;
import com.jeffmony.async.callback.CompletedCallback;
import com.jeffmony.async.future.Future;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public interface AsyncParser<T> {
    String getMime();

    Type getType();

    Future<T> parse(DataEmitter r10);

    void write(DataSink r10, T r11, CompletedCallback r12);
}
