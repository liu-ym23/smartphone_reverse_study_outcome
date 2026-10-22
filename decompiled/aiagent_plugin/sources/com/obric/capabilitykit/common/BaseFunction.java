package com.obric.capabilitykit.common;

import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes3.dex */
public interface BaseFunction {
    Object doAction(JsonObject r1, DispatchContext r2, d.c.d<? super BaseResult> r3);

    String getName();

    boolean isBlock();

    long translateTimeIntoUTC(String r1);

    String translateUTCIntoTime(long r1);
}
