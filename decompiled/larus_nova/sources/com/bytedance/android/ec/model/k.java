package com.bytedance.android.ec.model;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class k extends l {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f47871n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f47872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f47873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f47874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f47875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f47876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f47877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f47878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f47879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BitmapDrawable f47880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f47881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f47882k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f47883l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f47884m;

    public static final class a {
        public a() {
        }

        public static k c(String r100, String r101) {
            k r102 = new k();
            r102.f47872a = 1;
            r102.f47873b = r100;
            r102.f47874c = r101;
            return r102;
        }

        public static k a(ECUrlModel r100, boolean r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "ecUrlModel");
            k r104 = new k();
            if (r101 == true) goto L5;
            int r105 = 1;
        L6:
            r104.f47872a = r105;
            r104.f47873b = r100.getFirstUrl();
            r104.f47878g = Integer.valueOf(r100.getWidth());
            r104.f47879h = Integer.valueOf(r100.getHeight());
            r104.f47883l = r102;
            r104.f47884m = r103;
            return r104;
        L5:
            r105 = 6;
            goto L6
        }

        public static k b(ECUrlModel r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "urlModel");
            k r104 = new k();
            r104.f47872a = 4;
            r104.f47873b = r100.getFirstUrl();
            r104.f47878g = Integer.valueOf(r100.getWidth());
            r104.f47879h = Integer.valueOf(r100.getHeight());
            r104.f47882k = r101;
            r104.f47883l = r102;
            r104.f47884m = r103;
            return r104;
        }

        public static k d(String r100, String r101, Integer r102, Integer r103, String r104) {
            k r105 = new k();
            r105.f47872a = 2;
            r105.f47873b = r100;
            r105.f47877f = r101;
            r105.f47878g = r102;
            r105.f47879h = r103;
            r105.f47883l = r104;
            return r105;
        }
    }

    static {
        new a();
    }

    public k() {
        this.f47872a = 1;
    }

    @Override // com.bytedance.android.ec.model.l
    public int getType() {
        return this.f47872a;
    }
}
