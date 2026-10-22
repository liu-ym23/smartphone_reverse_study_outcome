package com.amap.api.col.s;

import androidx.camera.video.AudioStats;
import com.amap.api.services.core.LatLonPoint;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes28.dex */
final class af extends ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f26021a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        LatLonPoint f26022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double f26023b;

        public final boolean a(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L17:
            return false;
        L8:
            if (a.class != r100.getClass()) goto L17;
            LatLonPoint r101 = this.f26022a;
            a r102 = (a) r100;
            LatLonPoint r103 = r102.f26022a;
            if (r101 != r103) goto L13;
            return true;
        L13:
            if (r101 == null) goto L17;
            if (i.a(r101, r103) > r102.f26023b) goto L17;
            return true;
        }

        public a(double r100, double r101, double r102) {
            this.f26022a = null;
            this.f26023b = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.f26022a = new LatLonPoint(r100, r101);
            this.f26023b = r102;
        }
    }

    public final double a() {
        return this.f26021a;
    }

    public af(String... r100) {
        super(r100);
        this.f26021a = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // com.amap.api.col.s.ae
    public final void a(ad.a r100) {
        super.a(r100);
        if (r100 == null) goto L6;
        this.f26021a = r100.d();
        return;
    }

    @Override // com.amap.api.col.s.ae
    public final boolean a(LinkedHashMap<ad.b, Object> r100, ad.b r101) {
        if (r100 == null) goto L25;
        if (r101 == null) goto L25;
        if (r101.f26009b == null) goto L9;
        Iterator<ad.b> r102 = r100.keySet().iterator();
    L12:
        if (r102.hasNext() == false) goto L25;
        ad.b r103 = r102.next();
        if (r103 == null) goto L12;
        String r104 = r103.f26008a;
        if (r104 == null) goto L12;
        if (r104.equals(r101.f26008a) == false) goto L12;
        Object r105 = r103.f26009b;
        if ((r105 instanceof a) == false) goto L12;
        if (((a) r105).a(r101.f26009b) == false) goto L12;
        return true;
    L9:
        return super.a(r100, r101);
    L25:
        return false;
    }

    @Override // com.amap.api.col.s.ae
    public final Object b(LinkedHashMap<ad.b, Object> r100, ad.b r101) {
        if (r100 == null) goto L25;
        if (r101 == null) goto L25;
        if (r101.f26009b == null) goto L9;
        Iterator<ad.b> r102 = r100.keySet().iterator();
    L12:
        if (r102.hasNext() == false) goto L25;
        ad.b r103 = r102.next();
        if (r103 == null) goto L12;
        String r104 = r103.f26008a;
        if (r104 == null) goto L12;
        if (r104.equals(r101.f26008a) == false) goto L12;
        Object r105 = r103.f26009b;
        if ((r105 instanceof a) == false) goto L12;
        if (((a) r105).a(r101.f26009b) == false) goto L12;
        return r100.get(r103);
    L9:
        return super.b(r100, r101);
    L25:
        return null;
    }

    @Override // com.amap.api.col.s.ae
    public final Object c(LinkedHashMap<ad.b, Object> r100, ad.b r101) {
        if (r100 == null) goto L28;
        if (r101 == null) goto L28;
        if (r101.f26009b == null) goto L9;
        Iterator<ad.b> r102 = r100.keySet().iterator();
    L12:
        if (r102.hasNext() == false) goto L24;
        ad.b r103 = r102.next();
        if (r103 == null) goto L12;
        String r104 = r103.f26008a;
        if (r104 == null) goto L12;
        if (r104.equals(r101.f26008a) == false) goto L12;
        Object r105 = r103.f26009b;
        if ((r105 instanceof a) == false) goto L12;
        if (((a) r105).a(r101.f26009b) == false) goto L12;
    L25:
        if (r103 == null) goto L28;
        return r100.remove(r103);
    L24:
        r103 = null;
        goto L25
    L9:
        return super.c(r100, r101);
    L28:
        return null;
    }
}
