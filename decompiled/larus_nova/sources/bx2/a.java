package bx2;

import android.graphics.Paint;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21282a;

    public abstract void b(ax2.b r100);

    public abstract void g(Map<String, ? extends Object> r100, ax2.c r101);

    public abstract String h();

    public a() {
        this.f21282a = h();
    }

    public final String getType() {
        return this.f21282a;
    }

    public static float[] d(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter("ps", "key");
        Object r101 = r100.get("ps");
        if (r101 == null) goto L14;
        List r102 = (List) r101;
        ArrayList r103 = new ArrayList();
        int r104 = r102.size();
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L12;
        Object r106 = ListProtector.get(r102, r105);
        if (r106 == null) goto L10;
        r103.add(Float.valueOf((float) ((Double) r106).doubleValue()));
        r105 = r105 + 1;
        goto L5
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L12:
        return CollectionsKt.toFloatArray(r103);
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
    }

    public static int[] f(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(SRStrategy.MEDIAINFO_KEY_CACHE_SIZE, "key");
        ArrayList r101 = new ArrayList();
        Object r102 = r100.get(SRStrategy.MEDIAINFO_KEY_CACHE_SIZE);
        if (r102 == null) goto L16;
        List r103 = (List) r102;
        int r104 = r103.size();
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L14;
        Map<String, Integer> r106 = cx2.a.f465678a;
        Object r107 = ListProtector.get(r103, r105);
        if ((r107 instanceof String) == false) goto L9;
        String r108 = (String) r107;
    L10:
        if (r108 != null) goto L12;
        r108 = "";
    L12:
        r101.add(Integer.valueOf(cx2.a.C5599a.d(r108)));
        r105 = r105 + 1;
        goto L5
    L9:
        r108 = null;
        goto L10
    L14:
        return CollectionsKt.toIntArray(r101);
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
    }

    public static float c(Map r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "key");
        Double r102 = (Double) r100.get(r101);
        if (r102 != null) goto L5;
        return 0.0f;
    L5:
        return (float) r102.doubleValue();
    }

    public static int e(Map r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "key");
        Double r102 = (Double) r100.get(r101);
        if (r102 != null) goto L5;
        return 0;
    L5:
        return (int) r102.doubleValue();
    }

    public static float a(String r100, float r101, Paint r102) {
        Intrinsics.checkNotNullParameter(r100, "baselineType");
        Intrinsics.checkNotNullParameter(r102, "paint");
        if (Intrinsics.areEqual(r100, "alphabetic") == false) goto L5;
        return r101;
    L5:
        Paint.FontMetrics r103 = r102.getFontMetrics();
        float r104 = r103.top;
        float r105 = r103.bottom;
        switch(r100.hashCode()) {
            case -1383228885: goto L20;
            case -1074341483: goto L16;
            case 115029: goto L12;
            case 692890160: goto L9;
            default: goto L26;
        };
    L26:
        return r101;
    L9:
        if (r100.equals("hanging") == true) goto L24;
        return r101;
    L24:
        return r101 - r104;
    L12:
        if (r100.equals("top") == true) goto L24;
        return r101;
    L16:
        if (r100.equals("middle") == true) goto L25;
        return r101;
    L25:
        return (r101 - (r103.ascent / 2)) - r103.descent;
    L20:
        if (r100.equals("bottom") == true) goto L23;
        return r101;
    L23:
        return r101 - r105;
    }
}
