package com.byted.cast.common.pin;

import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.ContextManager;

/* JADX INFO: loaded from: classes39.dex */
public class QRPinEventTrack {
    public QRPinEventTrack() {
    }

    public static void trackGenerateLinkInfoFailure(final String r100, final String r101, final String r102) {
        ContextManager.getMonitor(null).sendSinkEvent(CastMonitor.BYTECAST_GENERATE_LINK_INFO_FAILURE, new AnonymousClass2(r100, r101, r102));
    }

    public static void trackParseLinkInfo(ContextManager.CastContext r100, final String r101, final String r102, final String r103) {
        ContextManager.getMonitor(r100).sendSourceEvent(CastMonitor.BYTECAST_PARSE_LINK_INFO, new AnonymousClass3(r101, r102, r103), null);
    }

    public static void trackGenerateLinkInfo(final String r100, final String r101, final String r110, final String r111, final String r112) {
        ContextManager.getMonitor(null).sendSinkEvent(CastMonitor.BYTECAST_GENERATE_LINK_INFO, new AnonymousClass1(r100, r101, r110, r111, r112));
    }

    public static void trackParseLinkInfoFailure(ContextManager.CastContext r100, final String r101, final String r102, final String r103, final String r104) {
        ContextManager.getMonitor(r100).sendSourceEvent(CastMonitor.BYTECAST_PARSE_LINK_INFO_FAILURE, new AnonymousClass4(r101, r102, r103, r104), null);
    }
}
