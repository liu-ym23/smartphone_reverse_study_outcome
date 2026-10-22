package com.stepos.core.ota.domain.port;

import java.io.InputStream;
import kotlin.Result;
import lb.n;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface ArchiveExtractor {
    /* renamed from: extract-0E7RQCE */
    Object mo116extract0E7RQCE(String str, String str2, b<? super Result<n>> bVar);

    /* renamed from: extractStream-0E7RQCE */
    Object mo117extractStream0E7RQCE(InputStream inputStream, String str, b<? super Result<n>> bVar);
}
