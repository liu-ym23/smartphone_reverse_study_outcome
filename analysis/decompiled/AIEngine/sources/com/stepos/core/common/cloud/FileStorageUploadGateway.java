package com.stepos.core.common.cloud;

import java.util.List;
import kotlinx.coroutines.Job;
import lb.n;
import o8.i;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface FileStorageUploadGateway {
    Job enqueueSingle(o8.h hVar, String str, l<? super Integer, n> lVar, l<? super List<i>, n> lVar2);

    void fetchDownloadUrl(String str, Integer num, l<? super String, n> lVar, l<? super Throwable, n> lVar2);
}
