package org.java_websocket.exceptions;

import com.amap.api.services.core.AMapException;

/* loaded from: classes5.dex */
public class LimitExceededException extends InvalidDataException {

    /* renamed from: b, reason: collision with root package name */
    public final int f37836b;

    public LimitExceededException(int i10) {
        super(AMapException.CODE_AMAP_USERKEY_PLAT_NOMATCH);
        this.f37836b = i10;
    }

    public int b() {
        return this.f37836b;
    }

    public LimitExceededException(String str, int i10) {
        super(AMapException.CODE_AMAP_USERKEY_PLAT_NOMATCH, str);
        this.f37836b = i10;
    }

    public LimitExceededException(String str) {
        this(str, Integer.MAX_VALUE);
    }
}
