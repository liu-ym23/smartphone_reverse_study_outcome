package com.bytedance.ai.utils;

import com.bytedance.ai.model.objects.PageInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashSet<a> f37627a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f37628b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PageInfo f37629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<k2.j> f37630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f37631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f37632d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f37629a, r101.f37629a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f37630b, r101.f37630b) == true) goto L15;
            return false;
        L15:
            if (this.f37631c == r101.f37631c) goto L18;
            return false;
        L18:
            if (this.f37632d == r101.f37632d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f37629a.hashCode() * 31) + this.f37630b.hashCode()) * 31) + this.f37631c) * 31;
            if (this.f37632d == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "AppletPageInfo(pageInfo=" + this.f37629a + ", pageView=" + this.f37630b + ", fragmentHashCode=" + this.f37631c + ", isPaused=" + this.f37632d + ')';
        }

        public a(PageInfo r100, WeakReference r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "pageInfo");
            Intrinsics.checkNotNullParameter(r101, "pageView");
            this.f37629a = r100;
            this.f37630b = r101;
            this.f37631c = r102;
            this.f37632d = false;
        }
    }

    static {
        f37627a = new LinkedHashSet();
        f37628b = "AppletPageManager";
    }

    public static boolean a(int r100) {
        Iterator<T> r101 = f37627a.iterator();
    L3:
        String r102 = null;
        if (r101.hasNext() == false) goto L11;
        Object r103 = r101.next();
        if (((a) r103).f37631c != r100) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L3;
    L12:
        a r105 = (a) r103;
        g r106 = g.f37637a;
        String r107 = f37628b;
        StringBuilder r108 = new StringBuilder("popPage Page ");
        if (r105 == null) goto L17;
        PageInfo r109 = r105.f37629a;
        if (r109 == null) goto L17;
        r102 = r109.getPageName();
    L17:
        r108.append(r102);
        r108.append(" to ");
        r108.append(r100);
        r106.d(r107, r108.toString());
        if (r105 != null) goto L20;
        return false;
    L20:
        return f37627a.remove(r105);
    L8:
        r104 = false;
        goto L9
    L11:
        r103 = null;
        goto L12
    }

    public static void c(int r100, boolean r101) {
        Iterator<T> r102 = f37627a.iterator();
    L3:
        String r103 = null;
        if (r102.hasNext() == false) goto L11;
        Object r104 = r102.next();
        if (((a) r104).f37631c != r100) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L3;
    L12:
        a r106 = (a) r104;
        g r107 = g.f37637a;
        String r108 = f37628b;
        StringBuilder r109 = new StringBuilder("updatePagePauseState Page ");
        if (r106 == null) goto L17;
        PageInfo r110 = r106.f37629a;
        if (r110 == null) goto L17;
        r103 = r110.getPageName();
    L17:
        r109.append(r103);
        r109.append(" to ");
        r109.append(r101);
        r107.d(r108, r109.toString());
        if (r106 == null) goto L28;
        r106.f37632d = r101;
        if (r101 == true) goto L29;
        LinkedHashSet<a> r111 = f37627a;
        r111.remove(r106);
        r111.add(r106);
        return;
    L29:
        return;
    L28:
        return;
    L8:
        r105 = false;
        goto L9
    L11:
        r104 = null;
        goto L12
    }

    public static void b(PageInfo r100, com.bytedance.ai.model.widgets.c r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "pageInfo");
        Intrinsics.checkNotNullParameter(r101, "appletPage");
        Iterator<T> r103 = f37627a.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (((a) r104).f37631c != r102) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L4;
    L12:
        a r106 = (a) r104;
        if (r106 == null) goto L15;
        f37627a.remove(r106);
    L15:
        g.f37637a.d(f37628b, "push Page " + r100.getPageName() + " to " + r102);
        f37627a.add(new a(r100, new WeakReference(r101), r102));
        return;
    L8:
        r105 = false;
        goto L9
    L11:
        r104 = null;
        goto L12
    }
}
