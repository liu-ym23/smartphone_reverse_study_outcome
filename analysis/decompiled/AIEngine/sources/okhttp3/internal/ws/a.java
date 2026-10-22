package okhttp3.internal.ws;

import ad.c;
import java.io.IOException;
import okhttp3.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ RealWebSocket f11288g;
    public final /* synthetic */ h h;

    public a(RealWebSocket realWebSocket, h hVar) {
        this.f11288g = realWebSocket;
        this.h = hVar;
    }

    @Override // ad.c
    public final void onFailure(ad.b bVar, IOException iOException) {
        RealWebSocket.i(this.f11288g, iOException, null, 6);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d7 A[PHI: r11 r13 r15
      0x00d7: PHI (r11v6 java.lang.Integer) = (r11v5 java.lang.Integer), (r11v10 java.lang.Integer) binds: [B:55:0x0102, B:37:0x00cc] A[DONT_GENERATE, DONT_INLINE]
      0x00d7: PHI (r13v8 java.lang.Integer) = (r13v6 java.lang.Integer), (r13v4 java.lang.Integer) binds: [B:55:0x0102, B:37:0x00cc] A[DONT_GENERATE, DONT_INLINE]
      0x00d7: PHI (r15v17 boolean) = (r15v11 boolean), (r15v20 boolean) binds: [B:55:0x0102, B:37:0x00cc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015e  */
    @Override // ad.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onResponse(ad.b r21, okhttp3.Response r22) {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.a.onResponse(ad.b, okhttp3.Response):void");
    }
}
