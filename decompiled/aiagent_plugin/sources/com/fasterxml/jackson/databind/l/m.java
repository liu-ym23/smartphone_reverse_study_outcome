package com.fasterxml.jackson.databind.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: IgnorePropertiesUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: compiled from: IgnorePropertiesUtil.java */
    public static final class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<String> f13042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<String> f13043b;

        private a(Set<String> r3, Set<String> r4) {
            Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L5;
            r5 = Collections.emptySet();
        L5:
            this.f13042a = r5;
            this.f13043b = r6;
        }

        public static a a(Set<String> r2, Set<String> r3) {
            return new a((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"));
        }

        public boolean a(Object r2) {
            Set<String> r0 = this.f13043b;
            if (r0 == null) goto L7;
            if (r0.contains(r2) == true) goto L7;
        L8:
            return true;
        L7:
            if (this.f13042a.contains(r2) == true) goto L8;
            return false;
        }
    }

    public static boolean a(Object r2, Collection<String> r3, Collection<String> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        if (r6 != null) goto L6;
        return false;
    L6:
        if (r6 != null) goto L10;
        return r5.contains(r2);
    L10:
        if (r5 != null) goto L14;
        return !r6.contains(r2);
    L14:
        if (r6.contains(r2) == false) goto L18;
        if (r5.contains(r2) == true) goto L18;
        return false;
    L18:
        return true;
    }

    public static a a(Set<String> r2, Set<String> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L10;
        if (r4 != null) goto L6;
        return null;
    L6:
        if (r4.isEmpty() == false) goto L10;
        return null;
    L10:
        return a.a(r4, r5);
    }

    public static Set<String> b(Set<String> r4, Set<String> r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        return r7;
    L5:
        if (r7 != null) goto L7;
        return r6;
    L7:
        HashSet r0 = new HashSet();
        Iterator<String> r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L13;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
        if (r6.contains(r2) == false) goto L9;
        r0.add(r2);
        goto L9
    L13:
        return r0;
    }
}
