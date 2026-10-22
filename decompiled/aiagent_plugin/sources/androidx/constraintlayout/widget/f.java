package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: StateSet.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SparseArray<a> f1009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SparseArray<c> f1010e;
    private d f;

    /* JADX INFO: compiled from: StateSet.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<b> f1012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1014d;

        public a(Context r8, XmlPullParser r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
            XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.aiagent.plugin");
            this.f1012b = new ArrayList();
            this.f1013c = -1;
            int r0 = 0;
            this.f1014d = false;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.State);
            int r2 = r12.getIndexCount();
        L3:
            if (r0 >= r2) goto L13;
            int r3 = r12.getIndex(r0);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_android_id, "styleable", "State_android_id")) goto L8;
            this.f1011a = r12.getResourceId(r3, this.f1011a);
        L12:
            r0 = r0 + 1;
            goto L3
        L8:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_constraints, "styleable", "State_constraints")) goto L12;
            this.f1013c = r12.getResourceId(r3, this.f1013c);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceTypeName(this.f1013c);
            ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceName(this.f1013c);
            if ("layout".equals(r4) == false) goto L12;
            this.f1014d = true;
            goto L12
        L13:
            r12.recycle();
        }

        void a(b r1) {
            this.f1012b.add(r1);
        }

        public int a(float r5, float r6) {
            int r0 = 0;
        L4:
            if (r0 >= this.f1012b.size()) goto L9;
            if (((b) ZeusTransformUtils.preCheckCast(this.f1012b.get(r0), b.class, "com.obric.aiagent.plugin")).a(r5, r6) == true) goto L7;
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
        float f1015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f1016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f1017c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f1018d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1019e;
        boolean f;

        public b(Context r8, XmlPullParser r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
            XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.aiagent.plugin");
            this.f1015a = Float.NaN;
            this.f1016b = Float.NaN;
            this.f1017c = Float.NaN;
            this.f1018d = Float.NaN;
            this.f1019e = -1;
            int r0 = 0;
            this.f = false;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.Variant);
            int r2 = r12.getIndexCount();
        L3:
            if (r0 >= r2) goto L23;
            int r3 = r12.getIndex(r0);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_constraints, "styleable", "Variant_constraints")) goto L10;
            this.f1019e = r12.getResourceId(r3, this.f1019e);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceTypeName(this.f1019e);
            ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceName(this.f1019e);
            if ("layout".equals(r4) == false) goto L22;
            this.f = true;
        L22:
            r0 = r0 + 1;
            goto L3
        L10:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_heightLessThan, "styleable", "Variant_region_heightLessThan")) goto L13;
            this.f1018d = r12.getDimension(r3, this.f1018d);
            goto L22
        L13:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_heightMoreThan, "styleable", "Variant_region_heightMoreThan")) goto L16;
            this.f1016b = r12.getDimension(r3, this.f1016b);
            goto L22
        L16:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_widthLessThan, "styleable", "Variant_region_widthLessThan")) goto L19;
            this.f1017c = r12.getDimension(r3, this.f1017c);
            goto L22
        L19:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_widthMoreThan, "styleable", "Variant_region_widthMoreThan")) goto L21;
            this.f1015a = r12.getDimension(r3, this.f1015a);
            goto L22
        L21:
            a("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r12.recycle();
        }

        boolean a(float r3, float r4) {
            if (Float.isNaN(this.f1015a) == true) goto L8;
            if (r3 >= this.f1015a) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.f1016b) == true) goto L13;
            if (r4 >= this.f1016b) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.f1017c) == true) goto L18;
            if (r3 <= this.f1017c) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.f1018d) == false) goto L20;
            return true;
        L20:
            if (r4 <= this.f1018d) goto L24;
            return false;
        L24:
            return true;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
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
        this.f1006a = -1;
        this.f1007b = -1;
        this.f1008c = -1;
        this.f1009d = new SparseArray();
        this.f1010e = new SparseArray();
        this.f = null;
        a(r5, r6);
    }

    private void a(Context r10, XmlPullParser r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r13 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.aiagent.plugin");
        TypedArray r0 = r12.obtainStyledAttributes(Xml.asAttributeSet(r13), R.styleable.StateSet);
        int r1 = r0.getIndexCount();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        int r4 = r0.getIndex(r3);
        if (r4 != ZeusTransformUtils.mapRes(R.styleable.StateSet_defaultState, "styleable", "StateSet_defaultState")) goto L7;
        this.f1006a = r0.getResourceId(r4, this.f1006a);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        r0.recycle();
        a r2 = null;
        int r5 = r13.getEventType();     // Catch: IOException -> L46 XmlPullParserException -> L48
    L10:
        byte r6 = 1;
        if (r5 == 1) goto L66;
        if (r5 != 0) goto L14;
        r13.getName();     // Catch: IOException -> L46 XmlPullParserException -> L48
    L44:
        r5 = r13.next();     // Catch: IOException -> L46 XmlPullParserException -> L48
        goto L10
    L14:
        if (r5 == 2) goto L20;
        if (r5 != 3) goto L44;
        if ("StateSet".equals(r13.getName()) == false) goto L44;
        return;
    L20:
        String r7 = r13.getName();     // Catch: IOException -> L46 XmlPullParserException -> L48
        switch(r7.hashCode()) {
            case 80204913: goto L33;
            case 1301459538: goto L30;
            case 1382829617: goto L27;
            case 1901439077: goto L24;
            default: goto L35;
        };     // Catch: IOException -> L46 XmlPullParserException -> L48
    L35:
        r6 = -1;
    L36:
        if (r6 == 2) goto L42;
        if (r6 != 3) goto L44;
        b r8 = new b(r12, r13);     // Catch: IOException -> L46 XmlPullParserException -> L48
        if (r2 == null) goto L44;
        r2.a(r8);     // Catch: IOException -> L46 XmlPullParserException -> L48
        goto L44
    L42:
        r2 = new a(r12, r13);     // Catch: IOException -> L46 XmlPullParserException -> L48
        this.f1009d.put(r2.f1011a, r2);     // Catch: IOException -> L46 XmlPullParserException -> L48
        goto L44
    L24:
        if (r7.equals("Variant") == false) goto L35;
        r6 = 3;
        goto L36
    L27:
        if (r7.equals("StateSet") == false) goto L35;
    L30:
        if (r7.equals("LayoutDescription") == false) goto L35;
        r6 = 0;
        goto L36
    L33:
        if (r7.equals("State") == false) goto L35;
        r6 = 2;
        goto L36
    L66:
        return;
    L46:
        e = move-exception;
        e.printStackTrace();
        return;
    L48:
        e = move-exception;
        e.printStackTrace();
    }

    public int a(int r2, int r3, int r4) {
        return b(-1, r2, r3, r4);
    }

    public int a(int r5, int r6, float r7, float r8) {
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.f1009d.get(r6), a.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return r6;
    L6:
        if (r7 == (-1.0f)) goto L25;
        if (r8 == (-1.0f)) goto L25;
        b r9 = null;
        Iterator<b> r0 = r4.f1012b.iterator();
    L12:
        if (r0.hasNext() == false) goto L19;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.aiagent.plugin");
        if (r2.a(r7, r8) == false) goto L12;
        if (r5 == r2.f1019e) goto L17;
        r9 = r2;
        goto L12
    L17:
        return r5;
    L19:
        if (r9 == null) goto L23;
        return r9.f1019e;
    L23:
        return r4.f1013c;
    L25:
        if (r4.f1013c != r5) goto L27;
        return r5;
    L27:
        Iterator<b> r10 = r4.f1012b.iterator();
    L29:
        if (r10.hasNext() == false) goto L34;
        if (r5 != ((b) ZeusTransformUtils.preCheckCast(r10.next(), b.class, "com.obric.aiagent.plugin")).f1019e) goto L29;
        return r5;
    L34:
        return r4.f1013c;
    }

    public int b(int r4, int r5, float r6, float r7) {
        if (r4 != r5) goto L21;
        if (r5 != (-1)) goto L6;
        a r8 = (a) ZeusTransformUtils.preCheckCast(this.f1009d.valueAt(0), a.class, "com.obric.aiagent.plugin");
    L7:
        if (r8 != null) goto L10;
        return -1;
    L10:
        if (this.f1008c != (-1)) goto L12;
    L14:
        int r3 = r8.a(r6, r7);
        if (r4 != r3) goto L17;
        return r4;
    L17:
        if (r3 != (-1)) goto L20;
        return r8.f1013c;
    L20:
        return ((b) ZeusTransformUtils.preCheckCast(r8.f1012b.get(r3), b.class, "com.obric.aiagent.plugin")).f1019e;
    L12:
        if (((b) ZeusTransformUtils.preCheckCast(r8.f1012b.get(r4), b.class, "com.obric.aiagent.plugin")).a(r6, r7) == false) goto L14;
        return r4;
    L6:
        r8 = (a) ZeusTransformUtils.preCheckCast(this.f1009d.get(this.f1007b), a.class, "com.obric.aiagent.plugin");
        goto L7
    L21:
        a r9 = (a) ZeusTransformUtils.preCheckCast(this.f1009d.get(r5), a.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L24;
        return -1;
    L24:
        int r10 = r9.a(r6, r7);
        if (r10 != (-1)) goto L28;
        return r9.f1013c;
    L28:
        return ((b) ZeusTransformUtils.preCheckCast(r9.f1012b.get(r10), b.class, "com.obric.aiagent.plugin")).f1019e;
    }
}
