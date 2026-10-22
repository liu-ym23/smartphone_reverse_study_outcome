package com.jeffmony.async;

/* JADX INFO: loaded from: classes3.dex */
public interface AsyncSocket extends DataEmitter, DataSink {
    @Override // com.jeffmony.async.DataEmitter, com.jeffmony.async.DataSink
    AsyncServer getServer();
}
