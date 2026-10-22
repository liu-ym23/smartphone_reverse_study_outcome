package com.google.android.material.shape;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class StateListSizeChange {

    /* renamed from: a, reason: collision with root package name */
    public int f5122a;

    /* renamed from: b, reason: collision with root package name */
    public a f5123b;

    /* renamed from: c, reason: collision with root package name */
    public int[][] f5124c;

    /* renamed from: d, reason: collision with root package name */
    public a[] f5125d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class SizeChangeType {

        /* renamed from: a, reason: collision with root package name */
        public static final SizeChangeType f5126a;

        /* renamed from: b, reason: collision with root package name */
        public static final SizeChangeType f5127b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ SizeChangeType[] f5128c;

        static {
            SizeChangeType sizeChangeType = new SizeChangeType("PERCENT", 0);
            f5126a = sizeChangeType;
            SizeChangeType sizeChangeType2 = new SizeChangeType("PIXELS", 1);
            f5127b = sizeChangeType2;
            f5128c = new SizeChangeType[]{sizeChangeType, sizeChangeType2};
        }

        public SizeChangeType() {
            throw null;
        }

        public static SizeChangeType valueOf(String str) {
            return (SizeChangeType) Enum.valueOf(SizeChangeType.class, str);
        }

        public static SizeChangeType[] values() {
            return (SizeChangeType[]) f5128c.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public b f5129a;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final SizeChangeType f5130a;

        /* renamed from: b, reason: collision with root package name */
        public final float f5131b;

        public b(SizeChangeType sizeChangeType, float f8) {
            this.f5130a = sizeChangeType;
            this.f5131b = f8;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Context r12, android.content.res.XmlResourceParser r13, android.util.AttributeSet r14, android.content.res.Resources.Theme r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r11 = this;
            int r0 = r13.getDepth()
            r1 = 1
            int r0 = r0 + r1
        L6:
            int r2 = r13.next()
            if (r2 == r1) goto Lce
            int r3 = r13.getDepth()
            if (r3 >= r0) goto L15
            r4 = 3
            if (r2 == r4) goto Lce
        L15:
            r4 = 2
            if (r2 != r4) goto L6
            if (r3 > r0) goto L6
            java.lang.String r2 = r13.getName()
            java.lang.String r3 = "item"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L27
            goto L6
        L27:
            android.content.res.Resources r2 = r12.getResources()
            int[] r3 = k4.a.G
            r4 = 0
            if (r15 != 0) goto L35
            android.content.res.TypedArray r2 = r2.obtainAttributes(r14, r3)
            goto L39
        L35:
            android.content.res.TypedArray r2 = r15.obtainStyledAttributes(r14, r3, r4, r4)
        L39:
            android.util.TypedValue r3 = r2.peekValue(r4)
            if (r3 != 0) goto L40
            goto L6d
        L40:
            int r5 = r3.type
            r6 = 5
            if (r5 != r6) goto L5c
            com.google.android.material.shape.StateListSizeChange$b r5 = new com.google.android.material.shape.StateListSizeChange$b
            int r3 = r3.data
            android.content.res.Resources r6 = r2.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            int r3 = android.util.TypedValue.complexToDimensionPixelSize(r3, r6)
            float r3 = (float) r3
            com.google.android.material.shape.StateListSizeChange$SizeChangeType r6 = com.google.android.material.shape.StateListSizeChange.SizeChangeType.f5127b
            r5.<init>(r6, r3)
            goto L6e
        L5c:
            r6 = 6
            if (r5 != r6) goto L6d
            com.google.android.material.shape.StateListSizeChange$b r5 = new com.google.android.material.shape.StateListSizeChange$b
            com.google.android.material.shape.StateListSizeChange$SizeChangeType r6 = com.google.android.material.shape.StateListSizeChange.SizeChangeType.f5126a
            r7 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3.getFraction(r7, r7)
            r5.<init>(r6, r3)
            goto L6e
        L6d:
            r5 = 0
        L6e:
            r2.recycle()
            int r2 = r14.getAttributeCount()
            int[] r3 = new int[r2]
            r6 = r4
            r7 = r6
        L79:
            if (r6 >= r2) goto L94
            int r8 = r14.getAttributeNameResource(r6)
            r9 = 2130970678(0x7f040836, float:1.7550073E38)
            if (r8 == r9) goto L91
            int r9 = r7 + 1
            boolean r10 = r14.getAttributeBooleanValue(r6, r4)
            if (r10 == 0) goto L8d
            goto L8e
        L8d:
            int r8 = -r8
        L8e:
            r3[r7] = r8
            r7 = r9
        L91:
            int r6 = r6 + 1
            goto L79
        L94:
            int[] r2 = android.util.StateSet.trimStateSet(r3, r7)
            com.google.android.material.shape.StateListSizeChange$a r3 = new com.google.android.material.shape.StateListSizeChange$a
            r3.<init>()
            r3.f5129a = r5
            int r5 = r11.f5122a
            if (r5 == 0) goto La6
            int r6 = r2.length
            if (r6 != 0) goto La8
        La6:
            r11.f5123b = r3
        La8:
            int[][] r6 = r11.f5124c
            int r7 = r6.length
            if (r5 < r7) goto Lbf
            int r7 = r5 + 10
            int[][] r8 = new int[r7][]
            java.lang.System.arraycopy(r6, r4, r8, r4, r5)
            r11.f5124c = r8
            com.google.android.material.shape.StateListSizeChange$a[] r6 = new com.google.android.material.shape.StateListSizeChange.a[r7]
            com.google.android.material.shape.StateListSizeChange$a[] r7 = r11.f5125d
            java.lang.System.arraycopy(r7, r4, r6, r4, r5)
            r11.f5125d = r6
        Lbf:
            int[][] r4 = r11.f5124c
            int r5 = r11.f5122a
            r4[r5] = r2
            com.google.android.material.shape.StateListSizeChange$a[] r2 = r11.f5125d
            r2[r5] = r3
            int r5 = r5 + r1
            r11.f5122a = r5
            goto L6
        Lce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.shape.StateListSizeChange.a(android.content.Context, android.content.res.XmlResourceParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }
}
