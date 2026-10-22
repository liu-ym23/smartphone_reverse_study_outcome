package com.google.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Set;

/* renamed from: com.google.protobuf.y0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1012y0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2986a;
    public final Object b;
    public final Serializable c;

    public C1012y0(StringBuilder sb) {
        this.c = new StringBuilder();
        this.f2986a = false;
        this.b = sb;
    }

    public void a(E0 e02, String str) {
        String strSubstring;
        HashMap map = (HashMap) this.c;
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf == -1) {
            strSubstring = str;
        } else {
            a(e02, str.substring(0, iLastIndexOf));
            strSubstring = str.substring(iLastIndexOf + 1);
        }
        F0 f02 = (F0) map.put(str, new C1008x0(strSubstring, str, e02));
        if (f02 != null) {
            map.put(str, f02);
            if (f02 instanceof C1008x0) {
                return;
            }
            StringBuilder sbV = B7.a.v("\"", strSubstring, "\" is already defined (as something other than a package) in file \"");
            sbV.append(f02.a().f2826a.E());
            sbV.append("\".");
            throw new Descriptors$DescriptorValidationException(e02, sbV.toString());
        }
    }

    public void b(F0 f02) {
        HashMap map = (HashMap) this.c;
        String strC = f02.c();
        if (strC.length() == 0) {
            throw new Descriptors$DescriptorValidationException(f02, "Missing name.");
        }
        for (int i = 0; i < strC.length(); i++) {
            char cCharAt = strC.charAt(i);
            if (('a' > cCharAt || cCharAt > 'z') && (('A' > cCharAt || cCharAt > 'Z') && cCharAt != '_' && ('0' > cCharAt || cCharAt > '9' || i <= 0))) {
                throw new Descriptors$DescriptorValidationException(f02, B7.a.m("\"", strC, "\" is not a valid identifier."));
            }
        }
        String strB = f02.b();
        F0 f03 = (F0) map.put(strB, f02);
        if (f03 != null) {
            map.put(strB, f03);
            if (f02.a() != f03.a()) {
                StringBuilder sbV = B7.a.v("\"", strB, "\" is already defined in file \"");
                sbV.append(f03.a().f2826a.E());
                sbV.append("\".");
                throw new Descriptors$DescriptorValidationException(f02, sbV.toString());
            }
            int iLastIndexOf = strB.lastIndexOf(46);
            if (iLastIndexOf == -1) {
                throw new Descriptors$DescriptorValidationException(f02, B7.a.m("\"", strB, "\" is already defined."));
            }
            throw new Descriptors$DescriptorValidationException(f02, "\"" + strB.substring(iLastIndexOf + 1) + "\" is already defined in \"" + strB.substring(0, iLastIndexOf) + "\".");
        }
    }

    public void c() {
        ((StringBuilder) this.b).append((CharSequence) "\n");
        this.f2986a = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        if ((r0 instanceof com.google.protobuf.I0) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.protobuf.F0 d(java.lang.String r6, com.google.protobuf.Descriptors$DescriptorPool$SearchFilter r7) {
        /*
            r5 = this;
            java.io.Serializable r0 = r5.c
            java.util.HashMap r0 = (java.util.HashMap) r0
            java.lang.Object r0 = r0.get(r6)
            com.google.protobuf.F0 r0 = (com.google.protobuf.F0) r0
            com.google.protobuf.Descriptors$DescriptorPool$SearchFilter r1 = com.google.protobuf.Descriptors$DescriptorPool$SearchFilter.b
            com.google.protobuf.Descriptors$DescriptorPool$SearchFilter r2 = com.google.protobuf.Descriptors$DescriptorPool$SearchFilter.f2821a
            com.google.protobuf.Descriptors$DescriptorPool$SearchFilter r3 = com.google.protobuf.Descriptors$DescriptorPool$SearchFilter.c
            if (r0 == 0) goto L32
            if (r7 == r3) goto L31
            if (r7 != r2) goto L1f
            boolean r4 = r0 instanceof com.google.protobuf.C1004w0
            if (r4 != 0) goto L1e
            boolean r4 = r0 instanceof com.google.protobuf.A0
            if (r4 == 0) goto L1f
        L1e:
            return r0
        L1f:
            if (r7 != r1) goto L32
            boolean r4 = r0 instanceof com.google.protobuf.C1004w0
            if (r4 != 0) goto L31
            boolean r4 = r0 instanceof com.google.protobuf.A0
            if (r4 != 0) goto L31
            boolean r4 = r0 instanceof com.google.protobuf.C1008x0
            if (r4 != 0) goto L31
            boolean r4 = r0 instanceof com.google.protobuf.I0
            if (r4 == 0) goto L32
        L31:
            return r0
        L32:
            java.lang.Object r5 = r5.b
            java.util.Set r5 = (java.util.Set) r5
            java.util.Iterator r5 = r5.iterator()
        L3a:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L74
            java.lang.Object r0 = r5.next()
            com.google.protobuf.E0 r0 = (com.google.protobuf.E0) r0
            com.google.protobuf.y0 r0 = r0.g
            java.io.Serializable r0 = r0.c
            java.util.HashMap r0 = (java.util.HashMap) r0
            java.lang.Object r0 = r0.get(r6)
            com.google.protobuf.F0 r0 = (com.google.protobuf.F0) r0
            if (r0 == 0) goto L3a
            if (r7 == r3) goto L73
            if (r7 != r2) goto L61
            boolean r4 = r0 instanceof com.google.protobuf.C1004w0
            if (r4 != 0) goto L60
            boolean r4 = r0 instanceof com.google.protobuf.A0
            if (r4 == 0) goto L61
        L60:
            return r0
        L61:
            if (r7 != r1) goto L3a
            boolean r4 = r0 instanceof com.google.protobuf.C1004w0
            if (r4 != 0) goto L73
            boolean r4 = r0 instanceof com.google.protobuf.A0
            if (r4 != 0) goto L73
            boolean r4 = r0 instanceof com.google.protobuf.C1008x0
            if (r4 != 0) goto L73
            boolean r4 = r0 instanceof com.google.protobuf.I0
            if (r4 == 0) goto L3a
        L73:
            return r0
        L74:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C1012y0.d(java.lang.String, com.google.protobuf.Descriptors$DescriptorPool$SearchFilter):com.google.protobuf.F0");
    }

    public void e(E0 e02) {
        for (E0 e03 : Collections.unmodifiableList(Arrays.asList(e02.f))) {
            if (((Set) this.b).add(e03)) {
                e(e03);
            }
        }
    }

    public F0 f(F0 f02, String str) {
        F0 f0D;
        String string;
        boolean zStartsWith = str.startsWith(".");
        Descriptors$DescriptorPool$SearchFilter descriptors$DescriptorPool$SearchFilter = Descriptors$DescriptorPool$SearchFilter.f2821a;
        if (zStartsWith) {
            string = str.substring(1);
            f0D = d(string, descriptors$DescriptorPool$SearchFilter);
        } else {
            int iIndexOf = str.indexOf(46);
            String strSubstring = iIndexOf == -1 ? str : str.substring(0, iIndexOf);
            StringBuilder sb = new StringBuilder(f02.b());
            while (true) {
                int iLastIndexOf = sb.lastIndexOf(".");
                if (iLastIndexOf == -1) {
                    f0D = d(str, descriptors$DescriptorPool$SearchFilter);
                    string = str;
                    break;
                }
                int i = iLastIndexOf + 1;
                sb.setLength(i);
                sb.append(strSubstring);
                F0 f0D2 = d(sb.toString(), Descriptors$DescriptorPool$SearchFilter.b);
                if (f0D2 != null) {
                    if (iIndexOf != -1) {
                        sb.setLength(i);
                        sb.append(str);
                        f0D = d(sb.toString(), descriptors$DescriptorPool$SearchFilter);
                    } else {
                        f0D = f0D2;
                    }
                    string = sb.toString();
                } else {
                    sb.setLength(iLastIndexOf);
                }
            }
        }
        if (f0D != null) {
            return f0D;
        }
        if (!this.f2986a) {
            throw new Descriptors$DescriptorValidationException(f02, B7.a.m("\"", str, "\" is not defined."));
        }
        J0.f2844a.warning("The descriptor for message type \"" + str + "\" cannot be found and a placeholder is created for it");
        C1004w0 c1004w0 = new C1004w0(string);
        ((Set) this.b).add(c1004w0.c);
        return c1004w0;
    }

    public void g() {
        StringBuilder sb = (StringBuilder) this.c;
        int length = sb.length();
        if (length == 0) {
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }
        sb.setLength(length - 2);
    }

    public void h(CharSequence charSequence) {
        StringBuilder sb = (StringBuilder) this.b;
        if (this.f2986a) {
            this.f2986a = false;
            sb.append((CharSequence) this.c);
        }
        sb.append(charSequence);
    }

    public C1012y0(E0[] e0Arr) {
        this.c = new HashMap();
        this.b = Collections.newSetFromMap(new IdentityHashMap(e0Arr.length));
        this.f2986a = true;
        for (E0 e02 : e0Arr) {
            ((Set) this.b).add(e02);
            e(e02);
        }
        for (E0 e03 : (Set) this.b) {
            try {
                a(e03, e03.f2826a.G());
            } catch (Descriptors$DescriptorValidationException e) {
                throw new AssertionError(e);
            }
        }
    }
}
