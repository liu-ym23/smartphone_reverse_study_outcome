package j0;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f9624a;

    /* renamed from: b, reason: collision with root package name */
    public int f9625b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f9626c = -1;

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray<C0094a> f9627d = new SparseArray<>();

    /* renamed from: e, reason: collision with root package name */
    public final SparseArray<androidx.constraintlayout.widget.c> f9628e = new SparseArray<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: j0.a$a, reason: collision with other inner class name */
    public static class C0094a {

        /* renamed from: a, reason: collision with root package name */
        public final int f9629a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<b> f9630b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        public final int f9631c;

        /* renamed from: d, reason: collision with root package name */
        public final androidx.constraintlayout.widget.c f9632d;

        public C0094a(Context context, XmlResourceParser xmlResourceParser) throws Resources.NotFoundException {
            this.f9631c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), d.f9647j);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == 0) {
                    this.f9629a = typedArrayObtainStyledAttributes.getResourceId(index, this.f9629a);
                } else if (index == 1) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f9631c);
                    this.f9631c = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                        this.f9632d = cVar;
                        cVar.b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final float f9633a;

        /* renamed from: b, reason: collision with root package name */
        public final float f9634b;

        /* renamed from: c, reason: collision with root package name */
        public final float f9635c;

        /* renamed from: d, reason: collision with root package name */
        public final float f9636d;

        /* renamed from: e, reason: collision with root package name */
        public final int f9637e;

        /* renamed from: f, reason: collision with root package name */
        public final androidx.constraintlayout.widget.c f9638f;

        public b(Context context, XmlResourceParser xmlResourceParser) throws Resources.NotFoundException {
            this.f9633a = Float.NaN;
            this.f9634b = Float.NaN;
            this.f9635c = Float.NaN;
            this.f9636d = Float.NaN;
            this.f9637e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), d.f9649l);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == 0) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f9637e);
                    this.f9637e = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                        this.f9638f = cVar;
                        cVar.b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                    }
                } else if (index == 1) {
                    this.f9636d = typedArrayObtainStyledAttributes.getDimension(index, this.f9636d);
                } else if (index == 2) {
                    this.f9634b = typedArrayObtainStyledAttributes.getDimension(index, this.f9634b);
                } else if (index == 3) {
                    this.f9635c = typedArrayObtainStyledAttributes.getDimension(index, this.f9635c);
                } else if (index == 4) {
                    this.f9633a = typedArrayObtainStyledAttributes.getDimension(index, this.f9633a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public final boolean a(float f8, float f9) {
            float f10 = this.f9633a;
            if (!Float.isNaN(f10) && f8 < f10) {
                return false;
            }
            float f11 = this.f9634b;
            if (!Float.isNaN(f11) && f9 < f11) {
                return false;
            }
            float f12 = this.f9635c;
            if (!Float.isNaN(f12) && f8 > f12) {
                return false;
            }
            float f13 = this.f9636d;
            return Float.isNaN(f13) || f9 <= f13;
        }
    }

    public a(Context context, ConstraintLayout constraintLayout, int i10) throws XmlPullParserException, Resources.NotFoundException, IOException, NumberFormatException {
        String str;
        this.f9624a = constraintLayout;
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            C0094a c0094a = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                a(context, xml);
                                break;
                            } else {
                                break;
                            }
                        case 80204913:
                            if (name.equals("State")) {
                                C0094a c0094a2 = new C0094a(context, xml);
                                this.f9627d.put(c0094a2.f9629a, c0094a2);
                                c0094a = c0094a2;
                                break;
                            } else {
                                break;
                            }
                        case 1382829617:
                            str = "StateSet";
                            name.equals(str);
                            break;
                        case 1657696882:
                            str = "layoutDescription";
                            name.equals(str);
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                b bVar = new b(context, xml);
                                if (c0094a != null) {
                                    c0094a.f9630b.add(bVar);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                    }
                }
            }
        } catch (IOException e10) {
            Log.e("ConstraintLayoutStates", "Error parsing resource: " + i10, e10);
        } catch (XmlPullParserException e11) {
            Log.e("ConstraintLayoutStates", "Error parsing resource: " + i10, e11);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x0209, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0110 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0109 A[Catch: IOException -> 0x0091, XmlPullParserException -> 0x0094, TryCatch #2 {IOException -> 0x0091, XmlPullParserException -> 0x0094, blocks: (B:20:0x0062, B:97:0x0209, B:28:0x0074, B:29:0x0082, B:31:0x0087, B:38:0x0097, B:46:0x00b1, B:41:0x00a0, B:44:0x00a9, B:47:0x00bf, B:51:0x00ce, B:53:0x00d6, B:54:0x00e0, B:63:0x0109, B:64:0x0110, B:65:0x0128, B:57:0x00e9, B:59:0x00f1, B:60:0x00ff, B:66:0x0129, B:68:0x0131, B:69:0x013f, B:72:0x0149, B:73:0x0154, B:74:0x016c, B:75:0x016d, B:78:0x0177, B:79:0x0182, B:80:0x019a, B:81:0x019b, B:83:0x01a3, B:84:0x01ac, B:87:0x01b6, B:88:0x01c0, B:89:0x01d8, B:90:0x01d9, B:93:0x01e3, B:94:0x01ed, B:95:0x0205, B:96:0x0206), top: B:105:0x0062 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Context r12, android.content.res.XmlResourceParser r13) throws org.xmlpull.v1.XmlPullParserException, java.lang.NumberFormatException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.a.a(android.content.Context, android.content.res.XmlResourceParser):void");
    }
}
