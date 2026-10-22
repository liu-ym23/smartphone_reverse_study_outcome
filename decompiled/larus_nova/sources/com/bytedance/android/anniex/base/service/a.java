package com.bytedance.android.anniex.base.service;

import android.content.Context;
import android.view.Menu;
import android.view.View;
import com.larus.platform.api.creation.TplType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends s26.a {

    /* JADX INFO: renamed from: com.bytedance.android.anniex.base.service.a$a, reason: collision with other inner class name */
    public static final class C0756a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f40318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f40319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f40320c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f40321d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0756a) == true) goto L8;
            return false;
        L8:
            C0756a r101 = (C0756a) r100;
            if (Intrinsics.areEqual(this.f40318a, r101.f40318a) == true) goto L12;
            return false;
        L12:
            if (this.f40319b == r101.f40319b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f40320c, r101.f40320c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f40321d, r101.f40321d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f40318a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            if (this.f40319b == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r103 + r104) * 31;
            String r106 = this.f40320c;
            if (r106 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (r105 + r107) * 31;
            String r109 = this.f40321d;
            if (r109 == null) goto L19;
            r101 = r109.hashCode();
        L19:
            return r108 + r101;
        L13:
            r107 = r106.hashCode();
            goto L14
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "LongClickConfig(sessionId=" + this.f40318a + ", disableSaveImage=" + this.f40319b + ", enterFrom=" + this.f40320c + ", enterMethod=" + this.f40321d + ')';
        }

        public C0756a(String r100, boolean r101, String r102) {
            this.f40318a = r100;
            this.f40319b = r101;
            this.f40320c = r102;
            this.f40321d = null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f40322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f40323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f40324c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f40325d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f40322a, r101.f40322a) == true) goto L12;
            return false;
        L12:
            if (this.f40323b == r101.f40323b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f40324c, r101.f40324c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f40325d, r101.f40325d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f40322a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            if (this.f40323b == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r103 + r104) * 31;
            String r106 = this.f40324c;
            if (r106 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (r105 + r107) * 31;
            String r109 = this.f40325d;
            if (r109 == null) goto L19;
            r101 = r109.hashCode();
        L19:
            return r108 + r101;
        L13:
            r107 = r106.hashCode();
            goto L14
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "SelectMenuConfig(sessionId=" + this.f40322a + ", enableSearch=" + this.f40323b + ", enterFrom=" + this.f40324c + ", enterMethod=" + this.f40325d + ')';
        }

        public b(String r100, boolean r101, String r102) {
            this.f40322a = r100;
            this.f40323b = r101;
            this.f40324c = r102;
            this.f40325d = null;
        }
    }

    public a() {
    }

    public static void G0(Context r100, la.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "copyData");
        s26.d r102 = s26.d.f540305c;
        if (((a) s26.d.f540305c.c(a.class)) == null) goto L6;
        G0(r100, r101);
        return;
    }

    public static void H0(Context r100, la.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "moreData");
        s26.d r102 = s26.d.f540305c;
        if (((a) s26.d.f540305c.c(a.class)) == null) goto L6;
        H0(r100, r101);
        return;
    }

    public static View.OnLongClickListener I0(Context r100, C0756a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        s26.d r102 = s26.d.f540305c;
        if (((a) s26.d.f540305c.c(a.class)) != null) goto L7;
        return null;
    L7:
        return I0(r100, r101);
    }

    public static void K0(Context r100, la.c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "reportData");
        s26.d r102 = s26.d.f540305c;
        if (((a) s26.d.f540305c.c(a.class)) == null) goto L6;
        K0(r100, r101);
        return;
    }

    public static void L0(Context r100, la.d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "searchData");
        s26.d r102 = s26.d.f540305c;
        if (((a) s26.d.f540305c.c(a.class)) == null) goto L6;
        L0(r100, r101);
        return;
    }

    public static List J0(Context r100, Menu r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, TplType.MENU);
        Intrinsics.checkNotNullParameter(r102, "config");
        s26.d r103 = s26.d.f540305c;
        if (((a) s26.d.f540305c.c(a.class)) != null) goto L7;
        return null;
    L7:
        return J0(r100, r101, r102);
    }
}
