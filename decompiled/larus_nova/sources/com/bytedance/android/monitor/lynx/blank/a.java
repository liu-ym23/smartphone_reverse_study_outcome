package com.bytedance.android.monitor.lynx.blank;

import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f162840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f162841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f162842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f162843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f162844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<C2488a> f162845f;

    /* JADX INFO: renamed from: com.bytedance.android.monitor.lynx.blank.a$a, reason: collision with other inner class name */
    public static class C2488a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f162846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f162847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f162848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f162849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f162850e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f162851f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f162852g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f162853h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f162854i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f162855j;

        public final String toString() {
            if (this.f162854i != 0) goto L10;
            StringBuilder r100 = new StringBuilder("Element{left=");
            r100.append(this.f162846a);
            r100.append(", right=");
            r100.append(this.f162847b);
            r100.append(", top=");
            r100.append(this.f162848c);
            r100.append(", bottom=");
            r100.append(this.f162849d);
            r100.append(", result= ");
            if (this.f162855j != 1) goto L7;
            String r101 = com.alipay.sdk.m.l.c.f25505j;
        L8:
            r100.append(r101);
            r100.append(", className='");
            r100.append(this.f162850e);
            r100.append("'}");
            return r100.toString();
        L7:
            r101 = "invalidate";
            goto L8
        L10:
            StringBuilder r102 = new StringBuilder("Element{left=");
            r102.append(this.f162846a);
            r102.append(", right=");
            r102.append(this.f162847b);
            r102.append(", top=");
            r102.append(this.f162848c);
            r102.append(", bottom=");
            r102.append(this.f162849d);
            r102.append(", alpha=");
            r102.append(this.f162851f);
            r102.append(", scaleX=");
            r102.append(this.f162852g);
            r102.append(", scaleY=");
            r102.append(this.f162853h);
            r102.append(", visibility=");
            if (this.f162854i != 4) goto L13;
            String r103 = "invisible";
        L14:
            r102.append(r103);
            r102.append(", className='");
            r102.append(this.f162850e);
            r102.append("'}");
            return r102.toString();
        L13:
            r103 = "gone";
            goto L14
        }

        public C2488a() {
            this.f162854i = 0;
            this.f162855j = 0;
        }
    }

    public a() {
    }

    public final String toString() {
        return "BlankDetectData{template='" + this.f162840a + "', percentage=" + this.f162841b + ", width=" + this.f162842c + ", height=" + this.f162843d + ", alpha=" + this.f162844e + ", elementCount=0, dataList=" + this.f162845f + '}';
    }
}
