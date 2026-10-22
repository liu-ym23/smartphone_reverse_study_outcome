package com.bytedanceos.common.tangram.style;

import a9.a;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.util.TangramViewMetrics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BannerStyle extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f9927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f9930i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9931j;

    public BannerStyle() {
        this.f9922a = 0;
        this.f9923b = 0;
        this.f9924c = 0;
        this.f9925d = 0;
        this.f9927f = new int[]{0, 0, 0, 0};
        this.f9928g = false;
        this.f9929h = false;
        this.f9930i = false;
    }

    public final void c(float r10) {
        int r11 = (int) (TangramViewMetrics.screenWidth() * r10);
        this.f9922a = r11;
        int[] r12 = this.f9927f;
        int r13 = (r11 - r12[3]) - r12[1];
        this.f9924c = r13;
        int r14 = (int) (r13 / this.aspectRatio);
        this.f9925d = r14;
        this.f9923b = (r14 + r12[0]) + r12[2];
    }

    public final int d(double r10) {
        return (int) (r10 * ((double) TangramViewMetrics.screenWidth()));
    }

    public final void e(double[] r10, int r11) {
        if (r11 != 1) goto L5;
        this.f9927f[0] = Style.dp2px(r10[0]);
        this.f9927f[1] = Style.dp2px(r10[1]);
        this.f9927f[2] = Style.dp2px(r10[2]);
        this.f9927f[3] = Style.dp2px(r10[3]);
        return;
    L5:
        if (r11 != 0) goto L9;
        this.f9927f[0] = d(r10[0]);
        this.f9927f[1] = d(r10[1]);
        this.f9927f[2] = d(r10[2]);
        this.f9927f[3] = d(r10[3]);
        return;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Style
    public void parseWith(JSONObject r10) {
        float r11 = (float) r10.optDouble("pageratio", 1.0d);
        b(r10);
        double[] r12 = {0.0d, 0.0d, 0.0d, 0.0d};
        a(r12, r10, "cMargin");
        boolean r13 = true;
        e(r12, r10.optInt("munit", 1));
        c(Math.max(Math.min(r11, 1.0f), 0.0f));
        this.f9926e = Style.dp2px(r10.optInt("elevation"));
        if (r10.optInt("hasLine", 0) != 1) goto L5;
        boolean r14 = true;
    L6:
        this.f9928g = r14;
        double r15 = r10.optDouble("radiu");
        if (r15 != 10.0d) goto L9;
        boolean r16 = true;
    L10:
        this.f9929h = r16;
        if (r15 == 12.0d) goto L14;
        r13 = false;
    L14:
        this.f9930i = r13;
        this.f9931j = Style.dp2px(r15);
        return;
    L9:
        r16 = false;
        goto L10
    L5:
        r14 = false;
        goto L6
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("isLargeBanner: ");
        r10.append(this.f9929h);
        r10.append(" ,bWidth: ");
        r10.append(this.f9922a);
        r10.append(" ,bHeight: ");
        r10.append(this.f9923b);
        r10.append(" ,imgHeight: ");
        r10.append(this.f9925d);
        r10.append(" ,imgWidth: ");
        r10.append(this.f9924c);
        r10.append(" ,radiu: ");
        r10.append(this.f9931j);
        r10.append(" ,elevation: ");
        r10.append(this.f9926e);
        int r11 = 0;
    L4:
        if (r11 >= this.f9927f.length) goto L7;
        r10.append(" ,cMargin[");
        r10.append(r11);
        r10.append("]=");
        r10.append(this.f9927f[r11]);
        r11 = r11 + 1;
        goto L4
    L7:
        return r10.toString();
    }
}
