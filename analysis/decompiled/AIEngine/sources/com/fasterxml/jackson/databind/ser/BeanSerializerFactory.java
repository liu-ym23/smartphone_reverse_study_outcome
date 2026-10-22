package com.fasterxml.jackson.databind.ser;

import java.io.Serializable;
import q3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class BeanSerializerFactory extends BasicSerializerFactory implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final BeanSerializerFactory f4304d = new BeanSerializerFactory();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0279 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.fasterxml.jackson.databind.ser.BeanPropertyWriter g(b3.h r20, i3.e r21, n3.d r22, boolean r23, com.fasterxml.jackson.databind.introspect.AnnotatedMember r24) throws java.lang.IllegalAccessException, com.fasterxml.jackson.databind.exc.InvalidDefinitionException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 659
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.BeanSerializerFactory.g(b3.h, i3.e, n3.d, boolean, com.fasterxml.jackson.databind.introspect.AnnotatedMember):com.fasterxml.jackson.databind.ser.BeanPropertyWriter");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:157:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x038a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x04c8 A[EDGE_INSN: B:685:0x04c8->B:289:0x04c8 BREAK  A[LOOP:0: B:284:0x04ad->B:687:?], EDGE_INSN: B:288:0x04c5->B:289:0x04c8 BREAK  A[LOOP:0: B:284:0x04ad->B:687:?]] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0562  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0628 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:406:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x06c2  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:594:0x0a4b  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x0a4e  */
    /* JADX WARN: Removed duplicated region for block: B:605:0x0aad  */
    /* JADX WARN: Removed duplicated region for block: B:618:0x0ada  */
    /* JADX WARN: Removed duplicated region for block: B:620:0x0ae2  */
    /* JADX WARN: Removed duplicated region for block: B:672:0x0bda  */
    /* JADX WARN: Removed duplicated region for block: B:674:0x0bf8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0128  */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.fasterxml.jackson.databind.ser.BasicSerializerFactory, com.fasterxml.jackson.databind.ser.BeanSerializerFactory] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.fasterxml.jackson.databind.ser.BasicSerializerFactory] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.fasterxml.jackson.databind.ser.BeanSerializerFactory] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.fasterxml.jackson.databind.ser.BeanSerializerFactory] */
    /* JADX WARN: Type inference failed for: r12v90, types: [n3.g] */
    /* JADX WARN: Type inference failed for: r14v55, types: [n3.g] */
    /* JADX WARN: Type inference failed for: r15v10, types: [n3.g] */
    /* JADX WARN: Type inference failed for: r1v0, types: [b3.h] */
    /* JADX WARN: Type inference failed for: r1v10, types: [b3.h] */
    /* JADX WARN: Type inference failed for: r1v11, types: [b3.b, b3.h] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v4, types: [b3.h] */
    /* JADX WARN: Type inference failed for: r1v5, types: [b3.h] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r20v11, types: [n3.g] */
    /* JADX WARN: Type inference failed for: r20v27, types: [n3.g] */
    /* JADX WARN: Type inference failed for: r2v14, types: [n3.g] */
    /* JADX WARN: Type inference failed for: r8v5, types: [n3.g] */
    /* JADX WARN: Type inference failed for: r9v46 */
    /* JADX WARN: Type inference failed for: r9v47 */
    /* JADX WARN: Type inference failed for: r9v48 */
    /* JADX WARN: Type inference failed for: r9v53, types: [b3.f] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b3.f h(b3.h r42, com.fasterxml.jackson.databind.JavaType r43, i3.d r44, boolean r45) {
        /*
            Method dump skipped, instructions count: 3094
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.BeanSerializerFactory.h(b3.h, com.fasterxml.jackson.databind.JavaType, i3.d, boolean):b3.f");
    }

    public final c i() {
        return new c(this.f4289a.f3838a);
    }
}
