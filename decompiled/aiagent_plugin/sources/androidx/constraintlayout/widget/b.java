package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ConstraintLayoutStates.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    c f954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SparseArray<a> f958e;
    private SparseArray<c> f;
    private d g;

    /* JADX INFO: compiled from: ConstraintLayoutStates.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<C0018b> f960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        c f962d;

        public a(Context r8, XmlPullParser r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
            XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.aiagent.plugin");
            this.f960b = new ArrayList();
            this.f961c = -1;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.State);
            int r0 = r12.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L13;
            int r3 = r12.getIndex(r2);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_android_id, "styleable", "State_android_id")) goto L8;
            this.f959a = r12.getResourceId(r3, this.f959a);
        L12:
            r2 = r2 + 1;
            goto L3
        L8:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_constraints, "styleable", "State_constraints")) goto L12;
            this.f961c = r12.getResourceId(r3, this.f961c);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceTypeName(this.f961c);
            ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceName(this.f961c);
            if ("layout".equals(r4) == false) goto L12;
            c r5 = new c();
            this.f962d = r5;
            r5.a(r10, this.f961c);
            goto L12
        L13:
            r12.recycle();
        }

        void a(C0018b r1) {
            this.f960b.add(r1);
        }

        public int a(float r5, float r6) {
            int r0 = 0;
        L4:
            if (r0 >= this.f960b.size()) goto L9;
            if (((C0018b) ZeusTransformUtils.preCheckCast(this.f960b.get(r0), C0018b.class, "com.obric.aiagent.plugin")).a(r5, r6) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConstraintLayoutStates.java */
    static class C0018b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f966d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f967e;
        c f;

        public C0018b(Context r8, XmlPullParser r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
            XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.aiagent.plugin");
            this.f963a = Float.NaN;
            this.f964b = Float.NaN;
            this.f965c = Float.NaN;
            this.f966d = Float.NaN;
            this.f967e = -1;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.Variant);
            int r0 = r12.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L23;
            int r3 = r12.getIndex(r2);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_constraints, "styleable", "Variant_constraints")) goto L10;
            this.f967e = r12.getResourceId(r3, this.f967e);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceTypeName(this.f967e);
            ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceName(this.f967e);
            if ("layout".equals(r4) == false) goto L22;
            c r5 = new c();
            this.f = r5;
            r5.a(r10, this.f967e);
        L22:
            r2 = r2 + 1;
            goto L3
        L10:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_heightLessThan, "styleable", "Variant_region_heightLessThan")) goto L13;
            this.f966d = r12.getDimension(r3, this.f966d);
            goto L22
        L13:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_heightMoreThan, "styleable", "Variant_region_heightMoreThan")) goto L16;
            this.f964b = r12.getDimension(r3, this.f964b);
            goto L22
        L16:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_widthLessThan, "styleable", "Variant_region_widthLessThan")) goto L19;
            this.f965c = r12.getDimension(r3, this.f965c);
            goto L22
        L19:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_widthMoreThan, "styleable", "Variant_region_widthMoreThan")) goto L21;
            this.f963a = r12.getDimension(r3, this.f963a);
            goto L22
        L21:
            a("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r12.recycle();
        }

        boolean a(float r3, float r4) {
            if (Float.isNaN(this.f963a) == true) goto L8;
            if (r3 >= this.f963a) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.f964b) == true) goto L13;
            if (r4 >= this.f964b) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.f965c) == true) goto L18;
            if (r3 <= this.f965c) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.f966d) == false) goto L20;
            return true;
        L20:
            if (r4 <= this.f966d) goto L24;
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

    b(Context r3, ConstraintLayout r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f955b = -1;
        this.f956c = -1;
        this.f958e = new SparseArray();
        this.f = new SparseArray();
        this.g = null;
        this.f957d = r4;
        a(r6, r5);
    }

    public void a(int r7, float r8, float r9) {
        int r0 = this.f955b;
        if (r0 != r7) goto L29;
        if (r7 != (-1)) goto L6;
        a r10 = (a) ZeusTransformUtils.preCheckCast(this.f958e.valueAt(0), a.class, "com.obric.aiagent.plugin");
    L8:
        if (this.f956c != (-1)) goto L10;
    L12:
        int r11 = r10.a(r8, r9);
        if (this.f956c != r11) goto L15;
        return;
    L15:
        if (r11 != (-1)) goto L17;
        c r12 = this.f954a;
    L18:
        if (r11 != (-1)) goto L20;
        int r13 = r10.f961c;
    L21:
        if (r12 != null) goto L23;
        return;
    L23:
        this.f956c = r11;
        d r14 = this.g;
        if (r14 == null) goto L26;
        r14.a(-1, r13);
    L26:
        r12.c(this.f957d);
        d r6 = this.g;
        if (r6 == null) goto L46;
        r6.b(-1, r13);
        return;
    L46:
        return;
    L20:
        r13 = ((C0018b) ZeusTransformUtils.preCheckCast(r10.f960b.get(r11), C0018b.class, "com.obric.aiagent.plugin")).f967e;
        goto L21
    L17:
        r12 = ((C0018b) ZeusTransformUtils.preCheckCast(r10.f960b.get(r11), C0018b.class, "com.obric.aiagent.plugin")).f;
        goto L18
    L10:
        if (((C0018b) ZeusTransformUtils.preCheckCast(r10.f960b.get(this.f956c), C0018b.class, "com.obric.aiagent.plugin")).a(r8, r9) == false) goto L12;
        return;
    L6:
        r10 = (a) ZeusTransformUtils.preCheckCast(this.f958e.get(r0), a.class, "com.obric.aiagent.plugin");
        goto L8
    L29:
        this.f955b = r7;
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f958e.get(r7), a.class, "com.obric.aiagent.plugin");
        int r3 = r1.a(r8, r9);
        if (r3 != (-1)) goto L32;
        c r4 = r1.f962d;
    L33:
        if (r3 != (-1)) goto L35;
        int r2 = r1.f961c;
    L36:
        if (r4 != null) goto L39;
        a("ConstraintLayoutStates", "NO Constraint set found ! id=" + r7 + ", dim =" + r8 + ", " + r9);
        return;
    L39:
        this.f956c = r3;
        d r15 = this.g;
        if (r15 == null) goto L42;
        r15.a(r7, r2);
    L42:
        r4.c(this.f957d);
        d r16 = this.g;
        if (r16 == null) goto L48;
        r16.b(r7, r2);
        return;
    L48:
        return;
    L35:
        r2 = ((C0018b) ZeusTransformUtils.preCheckCast(r1.f960b.get(r3), C0018b.class, "com.obric.aiagent.plugin")).f967e;
        goto L36
    L32:
        r4 = ((C0018b) ZeusTransformUtils.preCheckCast(r1.f960b.get(r3), C0018b.class, "com.obric.aiagent.plugin")).f;
        goto L33
    }

    public void a(d r1) {
        this.g = r1;
    }

    private void a(Context r9, int r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        XmlResourceParser r12 = ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin").getXml(r10);
        a r0 = null;
        int r1 = r12.getEventType();     // Catch: IOException -> L41 XmlPullParserException -> L43
    L4:
        byte r2 = 1;
        if (r1 == 1) goto L58;
        if (r1 != 0) goto L8;
        r12.getName();     // Catch: IOException -> L41 XmlPullParserException -> L43
    L39:
        r1 = r12.next();     // Catch: IOException -> L41 XmlPullParserException -> L43
    L8:
        if (r1 != 2) goto L39;
        String r3 = r12.getName();     // Catch: IOException -> L41 XmlPullParserException -> L43
        switch(r3.hashCode()) {
            case -1349929691: goto L26;
            case 80204913: goto L23;
            case 1382829617: goto L20;
            case 1657696882: goto L17;
            case 1901439077: goto L14;
            default: goto L28;
        };     // Catch: IOException -> L41 XmlPullParserException -> L43
    L28:
        r2 = -1;
    L29:
        if (r2 == 2) goto L37;
        if (r2 == 3) goto L34;
        if (r2 != 4) goto L39;
        a(r11, r12);     // Catch: IOException -> L41 XmlPullParserException -> L43
        goto L39
    L34:
        C0018b r4 = new C0018b(r11, r12);     // Catch: IOException -> L41 XmlPullParserException -> L43
        if (r0 == null) goto L39;
        r0.a(r4);     // Catch: IOException -> L41 XmlPullParserException -> L43
        goto L39
    L37:
        r0 = new a(r11, r12);     // Catch: IOException -> L41 XmlPullParserException -> L43
        this.f958e.put(r0.f959a, r0);     // Catch: IOException -> L41 XmlPullParserException -> L43
        goto L39
    L14:
        if (r3.equals("Variant") == false) goto L28;
        r2 = 3;
        goto L29
    L17:
        if (r3.equals("layoutDescription") == false) goto L28;
        r2 = 0;
        goto L29
    L20:
        if (r3.equals("StateSet") == false) goto L28;
    L23:
        if (r3.equals("State") == false) goto L28;
        r2 = 2;
        goto L29
    L26:
        if (r3.equals("ConstraintSet") == false) goto L28;
        r2 = 4;
        goto L29
    L58:
        return;
    L41:
        e = move-exception;
        e.printStackTrace();
        return;
    L43:
        e = move-exception;
        e.printStackTrace();
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

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
