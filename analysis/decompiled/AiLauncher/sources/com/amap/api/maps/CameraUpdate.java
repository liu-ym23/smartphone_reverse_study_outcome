package com.amap.api.maps;

import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.sse.ServerSentEventKt;

/* loaded from: classes.dex */
public final class CameraUpdate {

    /* renamed from: a, reason: collision with root package name */
    AbstractCameraUpdateMessage f17216a;

    public CameraUpdate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        this.f17216a = abstractCameraUpdateMessage;
    }

    public AbstractCameraUpdateMessage getCameraUpdateFactoryDelegate() {
        return this.f17216a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Const.STR_MART_JSON_BEGIN);
        if (this.f17216a.geoPoint != null) {
            sb2.append("position");
            sb2.append(ServerSentEventKt.COLON);
            sb2.append(this.f17216a.geoPoint.toString());
            sb2.append(Const.STR_MART_COMMA);
        }
        if (!Float.isNaN(this.f17216a.bearing)) {
            sb2.append("rotate");
            sb2.append(ServerSentEventKt.COLON);
            sb2.append(this.f17216a.bearing);
            sb2.append(Const.STR_MART_COMMA);
        }
        if (!Float.isNaN(this.f17216a.zoom)) {
            sb2.append("zoom");
            sb2.append(ServerSentEventKt.COLON);
            sb2.append(this.f17216a.zoom);
            sb2.append(Const.STR_MART_COMMA);
        }
        if (!Float.isNaN(this.f17216a.tilt)) {
            sb2.append("tilt");
            sb2.append(ServerSentEventKt.COLON);
            sb2.append(this.f17216a.tilt);
            sb2.append(Const.STR_MART_COMMA);
        }
        sb2.append("}");
        return sb2.toString();
    }
}
