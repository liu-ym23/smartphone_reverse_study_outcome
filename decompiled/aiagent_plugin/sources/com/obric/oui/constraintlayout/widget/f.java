package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: StateSet.java */
/* JADX INFO: loaded from: classes4.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f34990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f34991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f34992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SparseArray<a> f34993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d f34994e;

    /* JADX INFO: compiled from: StateSet.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f34995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<b> f34996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f34997c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f34998d;

        a(Context r8, XmlPullParser r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
            XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.aiagent.plugin");
            this.f34996b = new ArrayList();
            this.f34997c = -1;
            int r0 = 0;
            this.f34998d = false;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.State);
            int r2 = r12.getIndexCount();
        L3:
            if (r0 >= r2) goto L13;
            int r3 = r12.getIndex(r0);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_android_id, "styleable", "State_android_id")) goto L8;
            this.f34995a = r12.getResourceId(r3, this.f34995a);
        L12:
            r0 = r0 + 1;
            goto L3
        L8:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_constraints, "styleable", "State_constraints")) goto L12;
            this.f34997c = r12.getResourceId(r3, this.f34997c);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceTypeName(this.f34997c);
            ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceName(this.f34997c);
            if ("layout".equals(r4) == false) goto L12;
            this.f34998d = true;
            goto L12
        L13:
            r12.recycle();
        }

        void a(b r1) {
            this.f34996b.add(r1);
        }

        public int a(float r5, float r6) {
            int r0 = 0;
        L4:
            if (r0 >= this.f34996b.size()) goto L9;
            if (((b) ZeusTransformUtils.preCheckCast(this.f34996b.get(r0), b.class, "com.obric.aiagent.plugin")).a(r5, r6) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }
    }

    /* JADX INFO: compiled from: StateSet.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f34999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f35000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f35001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f35002d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35003e;
        boolean f;

        b(Context r8, XmlPullParser r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
            XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.aiagent.plugin");
            this.f34999a = Float.NaN;
            this.f35000b = Float.NaN;
            this.f35001c = Float.NaN;
            this.f35002d = Float.NaN;
            this.f35003e = -1;
            int r0 = 0;
            this.f = false;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.Variant);
            int r2 = r12.getIndexCount();
        L3:
            if (r0 >= r2) goto L23;
            int r3 = r12.getIndex(r0);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_constraints, "styleable", "Variant_constraints")) goto L10;
            this.f35003e = r12.getResourceId(r3, this.f35003e);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceTypeName(this.f35003e);
            ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceName(this.f35003e);
            if ("layout".equals(r4) == false) goto L22;
            this.f = true;
        L22:
            r0 = r0 + 1;
            goto L3
        L10:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_heightLessThan, "styleable", "Variant_region_heightLessThan")) goto L13;
            this.f35002d = r12.getDimension(r3, this.f35002d);
            goto L22
        L13:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_heightMoreThan, "styleable", "Variant_region_heightMoreThan")) goto L16;
            this.f35000b = r12.getDimension(r3, this.f35000b);
            goto L22
        L16:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_widthLessThan, "styleable", "Variant_region_widthLessThan")) goto L19;
            this.f35001c = r12.getDimension(r3, this.f35001c);
            goto L22
        L19:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_widthMoreThan, "styleable", "Variant_region_widthMoreThan")) goto L21;
            this.f34999a = r12.getDimension(r3, this.f34999a);
            goto L22
        L21:
            a("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r12.recycle();
        }

        boolean a(float r3, float r4) {
            if (Float.isNaN(this.f34999a) == true) goto L8;
            if (r3 >= this.f34999a) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.f35000b) == true) goto L13;
            if (r4 >= this.f35000b) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.f35001c) == true) goto L18;
            if (r3 <= this.f35001c) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.f35002d) == false) goto L20;
            return true;
        L20:
            if (r4 <= this.f35002d) goto L24;
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

    public f(Context r3, XmlPullParser r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.aiagent.plugin");
        this.f34990a = -1;
        this.f34991b = -1;
        this.f34992c = -1;
        this.f34993d = new SparseArray();
        this.f34994e = null;
        a(r5, r6);
    }

    private void a(Context r12, XmlPullParser r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r15 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r13, XmlPullParser.class, "com.obric.aiagent.plugin");
        TypedArray r2 = r14.obtainStyledAttributes(Xml.asAttributeSet(r15), R.styleable.StateSet);
        int r3 = r2.getIndexCount();
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L8;
        int r6 = r2.getIndex(r5);
        if (r6 != ZeusTransformUtils.mapRes(R.styleable.StateSet_defaultState, "styleable", "StateSet_defaultState")) goto L7;
        this.f34990a = r2.getResourceId(r6, this.f34990a);
    L7:
        r5 = r5 + 1;
        goto L3
    L8:
        r2.recycle();
        a r4 = null;
        int r7 = r15.getEventType();     // Catch: IOException -> L44 XmlPullParserException -> L46
    L10:
        byte r8 = 1;
        if (r7 == 1) goto L63;
        if (r7 == 2) goto L19;
        if (r7 != 3) goto L42;
        if ("StateSet".equals(r15.getName()) == false) goto L42;
        return;
    L42:
        r7 = r15.next();     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L10
    L19:
        String r9 = r15.getName();     // Catch: IOException -> L44 XmlPullParserException -> L46
        switch(r9.hashCode()) {
            case 80204913: goto L32;
            case 1301459538: goto L29;
            case 1382829617: goto L26;
            case 1901439077: goto L23;
            default: goto L34;
        };     // Catch: IOException -> L44 XmlPullParserException -> L46
    L34:
        r8 = -1;
    L35:
        if (r8 == 2) goto L41;
        if (r8 != 3) goto L42;
        b r10 = new b(r14, r15);     // Catch: IOException -> L44 XmlPullParserException -> L46
        if (r4 == null) goto L42;
        r4.a(r10);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L42
    L41:
        r4 = new a(r14, r15);     // Catch: IOException -> L44 XmlPullParserException -> L46
        this.f34993d.put(r4.f34995a, r4);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L42
    L23:
        if (r9.equals("Variant") == false) goto L34;
        r8 = 3;
        goto L35
    L26:
        if (r9.equals("StateSet") == false) goto L34;
    L29:
        if (r9.equals("LayoutDescription") == false) goto L34;
        r8 = 0;
        goto L35
    L32:
        if (r9.equals("State") == false) goto L34;
        r8 = 2;
        goto L35
    L63:
        return;
    L44:
        e = move-exception;
        a("ConstraintLayoutStates", "Error parsing XML resource", e);
        return;
    L46:
        e = move-exception;
        a("ConstraintLayoutStates", "Error parsing XML resource", e);
    }

    public int a(int r2, int r3, int r4) {
        return b(-1, r2, r3, r4);
    }

    public int a(int r5, int r6, float r7, float r8) {
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.f34993d.get(r6), a.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return r6;
    L6:
        if (r7 == (-1.0f)) goto L25;
        if (r8 == (-1.0f)) goto L25;
        b r9 = null;
        Iterator<b> r0 = r4.f34996b.iterator();
    L12:
        if (r0.hasNext() == false) goto L19;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.aiagent.plugin");
        if (r2.a(r7, r8) == false) goto L12;
        if (r5 == r2.f35003e) goto L17;
        r9 = r2;
        goto L12
    L17:
        return r5;
    L19:
        if (r9 == null) goto L23;
        return r9.f35003e;
    L23:
        return r4.f34997c;
    L25:
        if (r4.f34997c != r5) goto L27;
        return r5;
    L27:
        Iterator<b> r10 = r4.f34996b.iterator();
    L29:
        if (r10.hasNext() == false) goto L34;
        if (r5 != ((b) ZeusTransformUtils.preCheckCast(r10.next(), b.class, "com.obric.aiagent.plugin")).f35003e) goto L29;
        return r5;
    L34:
        return r4.f34997c;
    }

    public int b(int r4, int r5, float r6, float r7) {
        if (r4 != r5) goto L21;
        if (r5 != (-1)) goto L6;
        a r8 = (a) ZeusTransformUtils.preCheckCast(this.f34993d.valueAt(0), a.class, "com.obric.aiagent.plugin");
    L7:
        if (r8 != null) goto L10;
        return -1;
    L10:
        if (this.f34992c != (-1)) goto L12;
    L14:
        int r3 = r8.a(r6, r7);
        if (r4 != r3) goto L17;
        return r4;
    L17:
        if (r3 != (-1)) goto L20;
        return r8.f34997c;
    L20:
        return ((b) ZeusTransformUtils.preCheckCast(r8.f34996b.get(r3), b.class, "com.obric.aiagent.plugin")).f35003e;
    L12:
        if (((b) ZeusTransformUtils.preCheckCast(r8.f34996b.get(r4), b.class, "com.obric.aiagent.plugin")).a(r6, r7) == false) goto L14;
        return r4;
    L6:
        r8 = (a) ZeusTransformUtils.preCheckCast(this.f34993d.get(this.f34991b), a.class, "com.obric.aiagent.plugin");
        goto L7
    L21:
        a r9 = (a) ZeusTransformUtils.preCheckCast(this.f34993d.get(r5), a.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L24;
        return -1;
    L24:
        int r10 = r9.a(r6, r7);
        if (r10 != (-1)) goto L28;
        return r9.f34997c;
    L28:
        return ((b) ZeusTransformUtils.preCheckCast(r9.f34996b.get(r10), b.class, "com.obric.aiagent.plugin")).f35003e;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
