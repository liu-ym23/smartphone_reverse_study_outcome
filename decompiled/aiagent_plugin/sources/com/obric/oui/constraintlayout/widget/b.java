package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ConstraintLayoutStates.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    c f34938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f34939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f34940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f34941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SparseArray<a> f34942e;
    private SparseArray<c> f;
    private d g;

    /* JADX INFO: compiled from: ConstraintLayoutStates.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f34943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<C0944b> f34944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f34945c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        c f34946d;

        a(Context r8, XmlPullParser r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
            XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.aiagent.plugin");
            this.f34944b = new ArrayList();
            this.f34945c = -1;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.State);
            int r0 = r12.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L13;
            int r3 = r12.getIndex(r2);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_android_id, "styleable", "State_android_id")) goto L8;
            this.f34943a = r12.getResourceId(r3, this.f34943a);
        L12:
            r2 = r2 + 1;
            goto L3
        L8:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_constraints, "styleable", "State_constraints")) goto L12;
            this.f34945c = r12.getResourceId(r3, this.f34945c);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceTypeName(this.f34945c);
            ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceName(this.f34945c);
            if ("layout".equals(r4) == false) goto L12;
            c r5 = new c();
            this.f34946d = r5;
            r5.a(r10, this.f34945c);
            goto L12
        L13:
            r12.recycle();
        }

        void a(C0944b r1) {
            this.f34944b.add(r1);
        }

        public int a(float r5, float r6) {
            int r0 = 0;
        L4:
            if (r0 >= this.f34944b.size()) goto L9;
            if (((C0944b) ZeusTransformUtils.preCheckCast(this.f34944b.get(r0), C0944b.class, "com.obric.aiagent.plugin")).a(r5, r6) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConstraintLayoutStates.java */
    static class C0944b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f34947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f34948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f34949c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f34950d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f34951e;
        c f;

        C0944b(Context r8, XmlPullParser r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
            XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.aiagent.plugin");
            this.f34947a = Float.NaN;
            this.f34948b = Float.NaN;
            this.f34949c = Float.NaN;
            this.f34950d = Float.NaN;
            this.f34951e = -1;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.Variant);
            int r0 = r12.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L23;
            int r3 = r12.getIndex(r2);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_constraints, "styleable", "Variant_constraints")) goto L10;
            this.f34951e = r12.getResourceId(r3, this.f34951e);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceTypeName(this.f34951e);
            ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceName(this.f34951e);
            if ("layout".equals(r4) == false) goto L22;
            c r5 = new c();
            this.f = r5;
            r5.a(r10, this.f34951e);
        L22:
            r2 = r2 + 1;
            goto L3
        L10:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_heightLessThan, "styleable", "Variant_region_heightLessThan")) goto L13;
            this.f34950d = r12.getDimension(r3, this.f34950d);
            goto L22
        L13:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_heightMoreThan, "styleable", "Variant_region_heightMoreThan")) goto L16;
            this.f34948b = r12.getDimension(r3, this.f34948b);
            goto L22
        L16:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_widthLessThan, "styleable", "Variant_region_widthLessThan")) goto L19;
            this.f34949c = r12.getDimension(r3, this.f34949c);
            goto L22
        L19:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_widthMoreThan, "styleable", "Variant_region_widthMoreThan")) goto L21;
            this.f34947a = r12.getDimension(r3, this.f34947a);
            goto L22
        L21:
            a("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r12.recycle();
        }

        boolean a(float r3, float r4) {
            if (Float.isNaN(this.f34947a) == true) goto L8;
            if (r3 >= this.f34947a) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.f34948b) == true) goto L13;
            if (r4 >= this.f34948b) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.f34949c) == true) goto L18;
            if (r3 <= this.f34949c) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.f34950d) == false) goto L20;
            return true;
        L20:
            if (r4 <= this.f34950d) goto L24;
            return false;
        L24:
            return true;
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.v(r1, r2);
        }
    }

    b(Context r3, ConstraintLayout r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f34939b = -1;
        this.f34940c = -1;
        this.f34942e = new SparseArray();
        this.f = new SparseArray();
        this.g = null;
        this.f34941d = r4;
        a(r6, r5);
    }

    public void a(int r7, float r8, float r9) {
        int r0 = this.f34939b;
        if (r0 != r7) goto L29;
        if (r7 != (-1)) goto L6;
        a r10 = (a) ZeusTransformUtils.preCheckCast(this.f34942e.valueAt(0), a.class, "com.obric.aiagent.plugin");
    L8:
        if (this.f34940c != (-1)) goto L10;
    L12:
        int r11 = r10.a(r8, r9);
        if (this.f34940c != r11) goto L15;
        return;
    L15:
        if (r11 != (-1)) goto L17;
        c r12 = this.f34938a;
    L18:
        if (r11 != (-1)) goto L20;
        int r13 = r10.f34945c;
    L21:
        if (r12 != null) goto L23;
        return;
    L23:
        this.f34940c = r11;
        d r14 = this.g;
        if (r14 == null) goto L26;
        r14.a(-1, r13);
    L26:
        r12.c(this.f34941d);
        d r6 = this.g;
        if (r6 == null) goto L46;
        r6.b(-1, r13);
        return;
    L46:
        return;
    L20:
        r13 = ((C0944b) ZeusTransformUtils.preCheckCast(r10.f34944b.get(r11), C0944b.class, "com.obric.aiagent.plugin")).f34951e;
        goto L21
    L17:
        r12 = ((C0944b) ZeusTransformUtils.preCheckCast(r10.f34944b.get(r11), C0944b.class, "com.obric.aiagent.plugin")).f;
        goto L18
    L10:
        if (((C0944b) ZeusTransformUtils.preCheckCast(r10.f34944b.get(this.f34940c), C0944b.class, "com.obric.aiagent.plugin")).a(r8, r9) == false) goto L12;
        return;
    L6:
        r10 = (a) ZeusTransformUtils.preCheckCast(this.f34942e.get(r0), a.class, "com.obric.aiagent.plugin");
        goto L8
    L29:
        this.f34939b = r7;
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f34942e.get(r7), a.class, "com.obric.aiagent.plugin");
        int r3 = r1.a(r8, r9);
        if (r3 != (-1)) goto L32;
        c r4 = r1.f34946d;
    L33:
        if (r3 != (-1)) goto L35;
        int r2 = r1.f34945c;
    L36:
        if (r4 != null) goto L39;
        a("ConstraintLayoutStates", "NO Constraint set found ! id=" + r7 + ", dim =" + r8 + ", " + r9);
        return;
    L39:
        this.f34940c = r3;
        d r15 = this.g;
        if (r15 == null) goto L42;
        r15.a(r7, r2);
    L42:
        r4.c(this.f34941d);
        d r16 = this.g;
        if (r16 == null) goto L48;
        r16.b(r7, r2);
        return;
    L48:
        return;
    L35:
        r2 = ((C0944b) ZeusTransformUtils.preCheckCast(r1.f34944b.get(r3), C0944b.class, "com.obric.aiagent.plugin")).f34951e;
        goto L36
    L32:
        r4 = ((C0944b) ZeusTransformUtils.preCheckCast(r1.f34944b.get(r3), C0944b.class, "com.obric.aiagent.plugin")).f;
        goto L33
    }

    public void a(d r1) {
        this.g = r1;
    }

    private void a(Context r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        XmlResourceParser r2 = ZeusTransformUtils.getResources(r14, "com.obric.aiagent.plugin").getXml(r13);
        a r3 = null;
        int r4 = r2.getEventType();     // Catch: IOException -> L39 XmlPullParserException -> L41
    L4:
        byte r5 = 1;
        if (r4 == 1) goto L55;
        if (r4 != 2) goto L37;
        String r6 = r2.getName();     // Catch: IOException -> L39 XmlPullParserException -> L41
        switch(r6.hashCode()) {
            case -1349929691: goto L25;
            case 80204913: goto L22;
            case 1382829617: goto L19;
            case 1657696882: goto L16;
            case 1901439077: goto L13;
            default: goto L27;
        };     // Catch: IOException -> L39 XmlPullParserException -> L41
    L27:
        r5 = -1;
    L28:
        if (r5 == 2) goto L36;
        if (r5 == 3) goto L33;
        if (r5 != 4) goto L37;
        a(r14, r2);     // Catch: IOException -> L39 XmlPullParserException -> L41
        goto L37
    L33:
        C0944b r7 = new C0944b(r14, r2);     // Catch: IOException -> L39 XmlPullParserException -> L41
        if (r3 == null) goto L37;
        r3.a(r7);     // Catch: IOException -> L39 XmlPullParserException -> L41
        goto L37
    L36:
        r3 = new a(r14, r2);     // Catch: IOException -> L39 XmlPullParserException -> L41
        this.f34942e.put(r3.f34943a, r3);     // Catch: IOException -> L39 XmlPullParserException -> L41
        goto L37
    L13:
        if (r6.equals("Variant") == false) goto L27;
        r5 = 3;
        goto L28
    L16:
        if (r6.equals("layoutDescription") == false) goto L27;
        r5 = 0;
        goto L28
    L19:
        if (r6.equals("StateSet") == false) goto L27;
    L22:
        if (r6.equals("State") == false) goto L27;
        r5 = 2;
        goto L28
    L25:
        if (r6.equals("ConstraintSet") == false) goto L27;
        r5 = 4;
    L37:
        r4 = r2.next();     // Catch: IOException -> L39 XmlPullParserException -> L41
    L55:
        return;
    L39:
        e = move-exception;
        a("ConstraintLayoutStates", "Error parsing resource: " + r13, e);
        return;
    L41:
        e = move-exception;
        a("ConstraintLayoutStates", "Error parsing resource: " + r13, e);
    }

    private void a(Context r10, XmlPullParser r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r13 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.aiagent.plugin");
        c r0 = new c();
        int r2 = r13.getAttributeCount();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L27;
        String r4 = r13.getAttributeName(r3);
        String r5 = r13.getAttributeValue(r3);
        if (r4 == null) goto L20;
        if (r5 == null) goto L20;
        if (DbHelper.COL_ID.equals(r4) == false) goto L20;
        if (r5.contains("/") == false) goto L13;
        int r1 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin"), r5.substring(r5.indexOf(47) + 1), DbHelper.COL_ID, r12.getPackageName(), "com.obric.aiagent.plugin");
    L14:
        if (r1 == (-1)) goto L16;
    L19:
        r0.a(r12, r13);
        this.f.put(r1, r0);
        return;
    L16:
        if (r5.length() <= 1) goto L18;
        r1 = Integer.parseInt(r5.substring(1));
        goto L19
    L18:
        b("ConstraintLayoutStates", "error in parsing id");
        goto L19
    L13:
        r1 = -1;
    L20:
        r3 = r3 + 1;
        goto L3
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
