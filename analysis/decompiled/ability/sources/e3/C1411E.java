package e3;

/* renamed from: e3.E, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1411E {

    /* renamed from: a, reason: collision with root package name */
    public int f4340a;
    public B1.c b;
    public int[][] c;
    public B1.c[] d;

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
            int[] r3 = P2.a.f1068H
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
            e3.D r5 = new e3.D
            int r3 = r3.data
            android.content.res.Resources r6 = r2.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            int r3 = android.util.TypedValue.complexToDimensionPixelSize(r3, r6)
            float r3 = (float) r3
            com.google.android.material.shape.StateListSizeChange$SizeChangeType r6 = com.google.android.material.shape.StateListSizeChange$SizeChangeType.b
            r5.<init>(r6, r3)
            goto L6e
        L5c:
            r6 = 6
            if (r5 != r6) goto L6d
            e3.D r5 = new e3.D
            com.google.android.material.shape.StateListSizeChange$SizeChangeType r6 = com.google.android.material.shape.StateListSizeChange$SizeChangeType.f2508a
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
            r9 = 2130971051(0x7f0409ab, float:1.755083E38)
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
            B1.c r3 = new B1.c
            r3.<init>()
            r3.f180a = r5
            int r5 = r11.f4340a
            if (r5 == 0) goto La6
            int r6 = r2.length
            if (r6 != 0) goto La8
        La6:
            r11.b = r3
        La8:
            int[][] r6 = r11.c
            int r7 = r6.length
            if (r5 < r7) goto Lbf
            int r7 = r5 + 10
            int[][] r8 = new int[r7][]
            java.lang.System.arraycopy(r6, r4, r8, r4, r5)
            r11.c = r8
            B1.c[] r6 = new B1.c[r7]
            B1.c[] r7 = r11.d
            java.lang.System.arraycopy(r7, r4, r6, r4, r5)
            r11.d = r6
        Lbf:
            int[][] r4 = r11.c
            int r5 = r11.f4340a
            r4[r5] = r2
            B1.c[] r2 = r11.d
            r2[r5] = r3
            int r5 = r5 + r1
            r11.f4340a = r5
            goto L6
        Lce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.C1411E.a(android.content.Context, android.content.res.XmlResourceParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }
}
