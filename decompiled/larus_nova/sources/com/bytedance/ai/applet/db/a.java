package com.bytedance.ai.applet.db;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes43.dex */
public interface a {
    Object a(String r100, Continuation<? super i> r101);

    Object b(i r100, Continuation<? super Long> r101);

    Object delete(i r100, Continuation<? super Unit> r101);

    Object insert(i r100, Continuation<? super Unit> r101);

    Object update(i r100, Continuation<? super Unit> r101);
}
