package com.obric.oui.titlebar;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.SurfaceControl;
import android.view.View;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.oui.button.OButtonGroup;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: OFloatingTitleBarState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f36624a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f36625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f36626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f36627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h f36628e;
    private final d f;
    private final SurfaceControl g;

    /* JADX INFO: renamed from: com.obric.oui.titlebar.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OFloatingTitleBarState.kt */
    public static final class C0999a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C1000a f36629a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f36630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f36631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f36632d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f36633e;
        private final int f;
        private final View.OnClickListener g;
        private final boolean h;
        private final String i;

        /* JADX INFO: renamed from: com.obric.oui.titlebar.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OFloatingTitleBarState.kt */
        public static final class C1000a {
            public /* synthetic */ C1000a(d.h.b.h r1) {
                this();
            }

            private C1000a() {
            }

            public static /* synthetic */ C0999a a(C1000a r1, int r2, View.OnClickListener r3, int r4, Object r5) {
                View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
                if ((r4 & 2) == 0) goto L6;
                r6 = null;
            L6:
                return r1.a(r2, r6);
            }

            public final C0999a a(int r12, View.OnClickListener r13) {
                int r1 = 1;
                String r3 = null;
                String r4 = null;
                int r5 = 0;
                return new C0999a(r1, r12, r3, r4, r5, (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r13, View.OnClickListener.class, "com.obric.aiagent.plugin"), false, null, 192, null);
            }

            public static /* synthetic */ C0999a a(C1000a r1, String r2, View.OnClickListener r3, int r4, Object r5) {
                View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
                if ((r4 & 2) == 0) goto L6;
                r6 = null;
            L6:
                return r1.a(r2, r6);
            }

            public final C0999a a(String r12, View.OnClickListener r13) {
                View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r13, View.OnClickListener.class, "com.obric.aiagent.plugin");
                o.e(r12, "text");
                return new C0999a(2, 0, r12, null, 0, r6, false, null, 192, null);
            }

            public static /* synthetic */ C0999a b(C1000a r1, String r2, View.OnClickListener r3, int r4, Object r5) {
                View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
                if ((r4 & 2) == 0) goto L6;
                r6 = null;
            L6:
                return r1.b(r2, r6);
            }

            public final C0999a b(String r12, View.OnClickListener r13) {
                View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r13, View.OnClickListener.class, "com.obric.aiagent.plugin");
                o.e(r12, DBDefinition.TITLE);
                return new C0999a(3, 0, r12, null, 0, r6, false, null, 192, null);
            }
        }

        static {
            f36629a = new C1000a(null);
        }

        public static /* synthetic */ C0999a a(C0999a r9, int r10, int r11, String r12, String r13, int r14, View.OnClickListener r15, boolean r16, String r17, int r18, Object r19) {
            View.OnClickListener r2 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, View.OnClickListener.class, "com.obric.aiagent.plugin");
            if ((r18 & 1) == 0) goto L5;
            int r3 = r9.f36630b;
        L7:
            if ((r18 & 2) == 0) goto L9;
            int r4 = r9.f36631c;
        L11:
            if ((r18 & 4) == 0) goto L13;
            String r5 = r9.f36632d;
        L15:
            if ((r18 & 8) == 0) goto L17;
            String r6 = r9.f36633e;
        L19:
            if ((r18 & 16) == 0) goto L21;
            int r7 = r9.f;
        L23:
            if ((r18 & 32) == 0) goto L26;
            r2 = r9.g;
        L26:
            if ((r18 & 64) == 0) goto L28;
            boolean r8 = r9.h;
        L30:
            if ((r18 & 128) == 0) goto L32;
            String r1 = r9.i;
        L34:
            return r9.a(r3, r4, r5, r6, r7, r2, r8, r1);
        L32:
            r1 = r17;
            goto L34
        L28:
            r8 = r16;
            goto L30
        L21:
            r7 = r14;
            goto L23
        L17:
            r6 = r13;
            goto L19
        L13:
            r5 = r12;
            goto L15
        L9:
            r4 = r11;
            goto L11
        L5:
            r3 = r10;
            goto L7
        }

        public final C0999a a(int r11, int r12, String r13, String r14, int r15, View.OnClickListener r16, boolean r17, String r18) {
            return new C0999a(r11, r12, r13, r14, r15, (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r16, View.OnClickListener.class, "com.obric.aiagent.plugin"), r17, r18);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0999a.class) == true) goto L8;
            return false;
        L8:
            C0999a r6 = (C0999a) ZeusTransformUtils.preCheckCast(r5, C0999a.class, "com.obric.aiagent.plugin");
            if (this.f36630b == r6.f36630b) goto L12;
            return false;
        L12:
            if (this.f36631c == r6.f36631c) goto L15;
            return false;
        L15:
            if (o.a(this.f36632d, r6.f36632d) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f36633e, r6.f36633e) == true) goto L21;
            return false;
        L21:
            if (this.f == r6.f) goto L24;
            return false;
        L24:
            if (o.a(this.g, r6.g) == true) goto L27;
            return false;
        L27:
            if (this.h == r6.h) goto L30;
            return false;
        L30:
            if (o.a(this.i, r6.i) == true) goto L32;
            return false;
        L32:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r1v14, types: [int] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v19 */
        public int hashCode() {
            int r0 = ((Integer.hashCode(this.f36630b) * 31) + Integer.hashCode(this.f36631c)) * 31;
            String r1 = this.f36632d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f36633e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (((r4 + r6) * 31) + Integer.hashCode(this.f)) * 31;
            View.OnClickListener r8 = this.g;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            boolean r11 = this.h;
            ?? r12 = r11;
            if (r11 == false) goto L17;
            r12 = 1;
        L17:
            int r13 = (r10 + r12) * 31;
            String r14 = this.i;
            if (r14 == null) goto L22;
            r2 = r14.hashCode();
        L22:
            return r13 + r2;
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "ActionItem(type=" + this.f36630b + ", iconRes=" + this.f36631c + ", text=" + this.f36632d + ", id=" + this.f36633e + ", tintColor=" + this.f + ", onClickListener=" + this.g + ", enabled=" + this.h + ", iconResourceName=" + this.i + ')';
        }

        public C0999a(int r3, int r4, String r5, String r6, int r7, View.OnClickListener r8, boolean r9, String r10) {
            View.OnClickListener r11 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r8, View.OnClickListener.class, "com.obric.aiagent.plugin");
            this.f36630b = r3;
            this.f36631c = r4;
            this.f36632d = r5;
            this.f36633e = r6;
            this.f = r7;
            this.g = r11;
            this.h = r9;
            this.i = r10;
        }

        public /* synthetic */ C0999a(int r9, int r10, String r11, String r12, int r13, View.OnClickListener r14, boolean r15, String r16, int r17, d.h.b.h r18) {
            View.OnClickListener r1 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.aiagent.plugin");
            int r3 = 0;
            if ((r17 & 2) == 0) goto L5;
            int r2 = 0;
        L6:
            String r5 = null;
            if ((r17 & 4) == 0) goto L9;
            String r4 = null;
        L11:
            if ((r17 & 8) == 0) goto L13;
            String r6 = null;
        L15:
            if ((r17 & 16) != 0) goto L19;
            r3 = r13;
        L19:
            if ((r17 & 32) == 0) goto L22;
            r1 = null;
        L22:
            if ((r17 & 64) == 0) goto L24;
            boolean r7 = true;
        L26:
            if ((r17 & 128) != 0) goto L29;
            r5 = r16;
        L29:
            this(r9, r2, r4, r6, r3, r1, r7, r5);
            return;
        L24:
            r7 = r15;
            goto L26
        L13:
            r6 = r12;
            goto L15
        L9:
            r4 = r11;
            goto L11
        L5:
            r2 = r10;
            goto L6
        }

        public final int getType() {
            return this.f36630b;
        }

        public final int a() {
            return this.f36631c;
        }

        public final String b() {
            return this.f36632d;
        }

        public final String c() {
            return this.f36633e;
        }

        public final int d() {
            return this.f;
        }

        public final View.OnClickListener e() {
            return this.g;
        }

        public final boolean f() {
            return this.h;
        }

        public final String g() {
            return this.i;
        }

        public final C0999a a(String r12) {
            return a(this, 0, 0, null, r12, 0, null, false, null, 247, null);
        }

        public final C0999a a(int r12) {
            return a(this, 0, 0, null, null, r12, null, false, null, 239, null);
        }

        public final C0999a a(boolean r12) {
            return a(this, 0, 0, null, null, 0, null, r12, null, 191, null);
        }

        public final C0999a b(String r12) {
            return a(this, 0, 0, null, null, 0, null, false, r12, 127, null);
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBarState.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f36634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f36635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f36636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f36637d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f36638e;
        private final String f;

        public static /* synthetic */ b a(b r4, int r5, int r6, String r7, int r8, String r9, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.f36634a;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.f36635b;
        L8:
            int r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.f36636c;
        L11:
            String r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.f36637d;
        L14:
            int r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.f36638e;
        L17:
            String r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.f;
        L20:
            int r14 = r5;
            return r4.a(r14, r13, r0, r1, r2, r10);
        }

        public final b a(int r8, int r9, String r10, int r11, String r12, String r13) {
            return new b(r8, r9, r10, r11, r12, r13);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f36634a == r6.f36634a) goto L12;
            return false;
        L12:
            if (this.f36635b == r6.f36635b) goto L15;
            return false;
        L15:
            if (o.a(this.f36636c, r6.f36636c) == true) goto L18;
            return false;
        L18:
            if (this.f36637d == r6.f36637d) goto L21;
            return false;
        L21:
            if (o.a(this.f36638e, r6.f36638e) == true) goto L24;
            return false;
        L24:
            if (o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = ((Integer.hashCode(this.f36634a) * 31) + Integer.hashCode(this.f36635b)) * 31;
            String r1 = this.f36636c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + Integer.hashCode(this.f36637d)) * 31;
            String r5 = this.f36638e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "ActionKey(type=" + this.f36634a + ", iconRes=" + this.f36635b + ", text=" + this.f36636c + ", tintColor=" + this.f36637d + ", id=" + this.f36638e + ", iconResourceName=" + this.f + ')';
        }

        public b(int r1, int r2, String r3, int r4, String r5, String r6) {
            this.f36634a = r1;
            this.f36635b = r2;
            this.f36636c = r3;
            this.f36637d = r4;
            this.f36638e = r5;
            this.f = r6;
        }

        public final int getType() {
            return this.f36634a;
        }

        public final int a() {
            return this.f36635b;
        }

        public final String b() {
            return this.f36636c;
        }

        public final int c() {
            return this.f36637d;
        }

        public final String d() {
            return this.f36638e;
        }

        public final String e() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBarState.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<C0999a> f36639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<C0999a> f36640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<C0999a> f36641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<C0999a> f36642d;

        public c() {
            this(null, null, null, null, 15, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f36639a, r6.f36639a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f36640b, r6.f36640b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f36641c, r6.f36641c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f36642d, r6.f36642d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f36639a.hashCode() * 31) + this.f36640b.hashCode()) * 31) + this.f36641c.hashCode()) * 31) + this.f36642d.hashCode();
        }

        public String toString() {
            return "ActionsState(start=" + this.f36639a + ", center=" + this.f36640b + ", subEnd=" + this.f36641c + ", end=" + this.f36642d + ')';
        }

        public c(List<C0999a> r3, List<C0999a> r4, List<C0999a> r5, List<C0999a> r6) {
            List<C0999a> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List<C0999a> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            List<C0999a> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            List<C0999a> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            o.e(r7, "start");
            o.e(r8, "center");
            o.e(r9, "subEnd");
            o.e(r10, "end");
            this.f36639a = r7;
            this.f36640b = r8;
            this.f36641c = r9;
            this.f36642d = r10;
        }

        public /* synthetic */ c(List r2, List r3, List r4, List r5, int r6, d.h.b.h r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            if ((r6 & 1) == 0) goto L6;
            r8 = p.b();
        L6:
            if ((r6 & 2) == 0) goto L9;
            r9 = p.b();
        L9:
            if ((r6 & 4) == 0) goto L12;
            r10 = p.b();
        L12:
            if ((r6 & 8) == 0) goto L14;
            r11 = p.b();
        L14:
            this(r8, r9, r10, r11);
        }

        public final List<C0999a> a() {
            return this.f36639a;
        }

        public final List<C0999a> b() {
            return this.f36640b;
        }

        public final List<C0999a> c() {
            return this.f36641c;
        }

        public final List<C0999a> d() {
            return this.f36642d;
        }

        public final void a(List<C0999a> r3, List<C0999a> r4, List<C0999a> r5, List<C0999a> r6) {
            List<C0999a> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List<C0999a> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            List<C0999a> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            List<C0999a> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            o.e(r7, "start");
            o.e(r8, "center");
            o.e(r9, "subEnd");
            o.e(r10, "end");
            this.f36639a = r7;
            this.f36640b = r8;
            this.f36641c = r9;
            this.f36642d = r10;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBarState.kt */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OButtonGroup.b f36643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OButtonGroup.b f36644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final OButtonGroup.b f36645c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final OButtonGroup.b f36646d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f36647e;
        private final Integer f;
        private final float g;

        public static /* synthetic */ d a(d r5, OButtonGroup.b r6, OButtonGroup.b r7, OButtonGroup.b r8, OButtonGroup.b r9, float r10, Integer r11, float r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r6 = r5.f36643a;
        L6:
            if ((r13 & 2) == 0) goto L8;
            r7 = r5.f36644b;
        L8:
            OButtonGroup.b r15 = r7;
            if ((r13 & 4) == 0) goto L11;
            r8 = r5.f36645c;
        L11:
            OButtonGroup.b r0 = r8;
            if ((r13 & 8) == 0) goto L14;
            r9 = r5.f36646d;
        L14:
            OButtonGroup.b r1 = r9;
            if ((r13 & 16) == 0) goto L17;
            r10 = r5.f36647e;
        L17:
            float r2 = r10;
            if ((r13 & 32) == 0) goto L20;
            r11 = r5.f;
        L20:
            Integer r3 = r11;
            if ((r13 & 64) == 0) goto L23;
            r12 = r5.g;
        L23:
            OButtonGroup.b r16 = r6;
            return r5.a(r16, r15, r0, r1, r2, r3, r12);
        }

        public final d a(OButtonGroup.b r9, OButtonGroup.b r10, OButtonGroup.b r11, OButtonGroup.b r12, float r13, Integer r14, float r15) {
            o.e(r9, "startState");
            o.e(r10, "centerState");
            o.e(r11, "subEndState");
            o.e(r12, "endState");
            return new d(r9, r10, r11, r12, r13, r14, r15);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f36643a, r6.f36643a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f36644b, r6.f36644b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f36645c, r6.f36645c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f36646d, r6.f36646d) == true) goto L21;
            return false;
        L21:
            if (o.a(Float.valueOf(this.f36647e), Float.valueOf(r6.f36647e)) == true) goto L24;
            return false;
        L24:
            if (o.a(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (o.a(Float.valueOf(this.g), Float.valueOf(r6.g)) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((((this.f36643a.hashCode() * 31) + this.f36644b.hashCode()) * 31) + this.f36645c.hashCode()) * 31) + this.f36646d.hashCode()) * 31) + Float.hashCode(this.f36647e)) * 31;
            Integer r1 = this.f;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + Float.hashCode(this.g);
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "AnimationState(startState=" + this.f36643a + ", centerState=" + this.f36644b + ", subEndState=" + this.f36645c + ", endState=" + this.f36646d + ", subEndTranslationX=" + this.f36647e + ", freezeEndAreaWidth=" + this.f + ", centerTranslationX=" + this.g + ')';
        }

        public d(OButtonGroup.b r2, OButtonGroup.b r3, OButtonGroup.b r4, OButtonGroup.b r5, float r6, Integer r7, float r8) {
            o.e(r2, "startState");
            o.e(r3, "centerState");
            o.e(r4, "subEndState");
            o.e(r5, "endState");
            this.f36643a = r2;
            this.f36644b = r3;
            this.f36645c = r4;
            this.f36646d = r5;
            this.f36647e = r6;
            this.f = r7;
            this.g = r8;
        }

        public final OButtonGroup.b a() {
            return this.f36643a;
        }

        public final OButtonGroup.b b() {
            return this.f36644b;
        }

        public final OButtonGroup.b c() {
            return this.f36645c;
        }

        public final OButtonGroup.b d() {
            return this.f36646d;
        }

        public final float e() {
            return this.f36647e;
        }

        public final Integer f() {
            return this.f;
        }

        public final float g() {
            return this.g;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBarState.kt */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f36648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f36649b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f36650c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f36651d;

        public e() {
            this(0, 0, 0, 0, 15, null);
        }

        public static /* synthetic */ e a(e r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.f36648a;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.f36649b;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.f36650c;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.f36651d;
        L15:
            return r0.a(r1, r2, r3, r4);
        }

        public final e a(int r1, int r2, int r3, int r4) {
            return new e(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (this.f36648a == r6.f36648a) goto L12;
            return false;
        L12:
            if (this.f36649b == r6.f36649b) goto L15;
            return false;
        L15:
            if (this.f36650c == r6.f36650c) goto L18;
            return false;
        L18:
            if (this.f36651d == r6.f36651d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f36648a) * 31) + Integer.hashCode(this.f36649b)) * 31) + Integer.hashCode(this.f36650c)) * 31) + Integer.hashCode(this.f36651d);
        }

        public String toString() {
            return "BoundsState(width=" + this.f36648a + ", height=" + this.f36649b + ", screenX=" + this.f36650c + ", screenY=" + this.f36651d + ')';
        }

        public e(int r1, int r2, int r3, int r4) {
            this.f36648a = r1;
            this.f36649b = r2;
            this.f36650c = r3;
            this.f36651d = r4;
        }

        public /* synthetic */ e(int r2, int r3, int r4, int r5, int r6, d.h.b.h r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = 0;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = 0;
        L14:
            this(r2, r3, r4, r5);
        }

        public final int a() {
            return this.f36648a;
        }

        public final int b() {
            return this.f36649b;
        }

        public final int c() {
            return this.f36650c;
        }

        public final int d() {
            return this.f36651d;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBarState.kt */
    public static final class f {
        public /* synthetic */ f(d.h.b.h r1) {
            this();
        }

        private f() {
        }

        public static final /* synthetic */ c a(f r2, c r3, Context r4) {
            return r2.a(r3, (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ d a(f r2, d r3, Context r4) {
            return r2.a(r3, (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ void a(f r0, Bundle r1, e r2) {
            r0.a(r1, r2);
        }

        public static final /* synthetic */ void a(f r0, Bundle r1, g r2) {
            r0.a(r1, r2);
        }

        public static final /* synthetic */ void a(f r0, Bundle r1, h r2) {
            r0.a(r1, r2);
        }

        public static final /* synthetic */ void a(f r0, Bundle r1, String r2, d r3) {
            r0.a(r1, r2, r3);
        }

        public static final /* synthetic */ void a(f r2, Bundle r3, String r4, List r5) {
            r2.a(r3, r4, (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin"));
        }

        public final a a(Bundle r9) {
            o.e(r9, "bundle");
            r9.setClassLoader(a.class.getClassLoader());
            return new a(b(r9), c(r9), new c(a(r9, "start_actions"), a(r9, "center_actions"), a(r9, "sub_end_actions"), a(r9, "end_actions")), d(r9), b(r9, "animation_state"), f(r9));
        }

        private final void a(Bundle r2, e r3) {
            r2.putInt("width", r3.a());
            r2.putInt("height", r3.b());
            r2.putInt("screen_x", r3.c());
            r2.putInt("screen_y", r3.d());
        }

        private final e b(Bundle r5) {
            return new e(r5.getInt("width"), r5.getInt("height"), r5.getInt("screen_x"), r5.getInt("screen_y"));
        }

        private final void a(Bundle r2, g r3) {
            r2.putInt("start_title_width", r3.a());
            r2.putInt("center_title_width", r3.b());
            r2.putInt("center_custom_width", r3.c());
            r2.putInt("center_custom_height", r3.d());
            r2.putInt("content_top_inset", r3.e());
        }

        private final g c(Bundle r7) {
            return new g(r7.getInt("start_title_width"), r7.getInt("center_title_width"), r7.getInt("center_custom_width"), r7.getInt("center_custom_height"), r7.getInt("content_top_inset"));
        }

        private final void a(Bundle r9, String r10, List<C0999a> r11) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
            String r12 = o.a(r10, "_types");
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r3 = r1.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r2.add(Integer.valueOf(((C0999a) ZeusTransformUtils.preCheckCast(r3.next(), C0999a.class, "com.obric.aiagent.plugin")).getType()));
            goto L4
        L6:
            r9.putIntArray(r12, p.e((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
            String r13 = o.a(r10, "_icons");
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
            Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r4, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r6 = r4.iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            r5.add(Integer.valueOf(((C0999a) ZeusTransformUtils.preCheckCast(r6.next(), C0999a.class, "com.obric.aiagent.plugin")).a()));
            goto L8
        L10:
            r9.putIntArray(r13, p.e((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
            String r14 = o.a(r10, "_texts");
            Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
            Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r16 = r7.iterator();
        L12:
            if (r16.hasNext() == false) goto L14;
            r15.add(((C0999a) ZeusTransformUtils.preCheckCast(r16.next(), C0999a.class, "com.obric.aiagent.plugin")).b());
            goto L12
        L14:
            Object[] r17 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]);
            Objects.requireNonNull(r17, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            r9.putStringArray(r14, (String[]) ZeusTransformUtils.preCheckCast(r17, String[].class, "com.obric.aiagent.plugin"));
            String r18 = o.a(r10, "_ids");
            Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
            Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r19, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r21 = r19.iterator();
        L16:
            if (r21.hasNext() == false) goto L18;
            r20.add(((C0999a) ZeusTransformUtils.preCheckCast(r21.next(), C0999a.class, "com.obric.aiagent.plugin")).c());
            goto L16
        L18:
            Object[] r22 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]);
            Objects.requireNonNull(r22, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            r9.putStringArray(r18, (String[]) ZeusTransformUtils.preCheckCast(r22, String[].class, "com.obric.aiagent.plugin"));
            String r110 = o.a(r10, "_tints");
            Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
            Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r23, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r25 = r23.iterator();
        L20:
            if (r25.hasNext() == false) goto L22;
            r24.add(Integer.valueOf(((C0999a) ZeusTransformUtils.preCheckCast(r25.next(), C0999a.class, "com.obric.aiagent.plugin")).d()));
            goto L20
        L22:
            r9.putIntArray(r110, p.e((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
            String r111 = o.a(r10, "_enableds");
            Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
            Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r26, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r28 = r26.iterator();
        L24:
            if (r28.hasNext() == false) goto L26;
            r27.add(Boolean.valueOf(((C0999a) ZeusTransformUtils.preCheckCast(r28.next(), C0999a.class, "com.obric.aiagent.plugin")).f()));
            goto L24
        L26:
            r9.putBooleanArray(r111, p.b((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
            String r112 = o.a(r10, "_icon_names");
            Iterable r29 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
            Collection r113 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r29, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r30 = r29.iterator();
        L28:
            if (r30.hasNext() == false) goto L30;
            r113.add(((C0999a) ZeusTransformUtils.preCheckCast(r30.next(), C0999a.class, "com.obric.aiagent.plugin")).g());
            goto L28
        L30:
            Object[] r31 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r113, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]);
            Objects.requireNonNull(r31, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            r9.putStringArray(r112, (String[]) ZeusTransformUtils.preCheckCast(r31, String[].class, "com.obric.aiagent.plugin"));
        }

        private final List<C0999a> a(Bundle r25, String r26) {
            int[] r2 = r25.getIntArray(o.a(r26, "_types"));
            if (r2 == null) goto L5;
            int[] r3 = r25.getIntArray(o.a(r26, "_icons"));
            if (r3 != null) goto L9;
            r3 = new int[r2.length];
        L9:
            String[] r4 = r25.getStringArray(o.a(r26, "_texts"));
            if (r4 != null) goto L12;
            r4 = new String[r2.length];
        L12:
            String[] r5 = r25.getStringArray(o.a(r26, "_ids"));
            if (r5 != null) goto L15;
            r5 = new String[r2.length];
        L15:
            int[] r6 = r25.getIntArray(o.a(r26, "_tints"));
            if (r6 != null) goto L18;
            r6 = new int[r2.length];
        L18:
            boolean[] r7 = r25.getBooleanArray(o.a(r26, "_enableds"));
            if (r7 != null) goto L24;
            int r8 = r2.length;
            boolean[] r10 = new boolean[r8];
            int r11 = 0;
        L21:
            if (r11 >= r8) goto L23;
            r10[r11] = true;
            r11 = r11 + 1;
            goto L21
        L23:
            r7 = r10;
        L24:
            String[] r0 = r25.getStringArray(o.a(r26, "_icon_names"));
            if (r0 != null) goto L27;
            r0 = new String[r2.length];
        L27:
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r2.length), Collection.class, "com.obric.aiagent.plugin");
            int r12 = r2.length;
            int r13 = 0;
            int r14 = 0;
        L28:
            if (r13 >= r12) goto L49;
            int r15 = r2[r13];
            int r23 = r14 + 1;
            if (r14 >= 0) goto L32;
        L34:
            int r16 = 0;
        L35:
            String r17 = (String) ZeusTransformUtils.preCheckCast(i.b(r4, r14), String.class, "com.obric.aiagent.plugin");
            String r18 = (String) ZeusTransformUtils.preCheckCast(i.b(r5, r14), String.class, "com.obric.aiagent.plugin");
            if (r14 >= 0) goto L38;
        L40:
            int r19 = 0;
        L42:
            if (r14 >= 0) goto L44;
        L46:
            boolean r21 = true;
        L47:
            r1.add(new C0999a(r15, r16, r17, r18, r19, null, r21, (String) ZeusTransformUtils.preCheckCast(i.b(r0, r14), String.class, "com.obric.aiagent.plugin")));
            r13 = r13 + 1;
            r14 = r23;
            goto L28
        L44:
            if (r14 > i.a(r7)) goto L46;
            r21 = r7[r14];
            goto L47
        L38:
            if (r14 > i.e(r6)) goto L40;
            r19 = r6[r14];
            goto L42
        L32:
            if (r14 > i.e(r3)) goto L34;
            r16 = r3[r14];
            goto L35
        L49:
            return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        L5:
            return p.b();
        }

        private final void a(Bundle r2, h r3) {
            r2.putInt("start_button_style", r3.a());
            r2.putInt("center_button_style", r3.b());
            r2.putInt("sub_end_button_style", r3.c());
            r2.putInt("end_button_style", r3.d());
        }

        private final h d(Bundle r5) {
            return new h(r5.getInt("start_button_style"), r5.getInt("center_button_style"), r5.getInt("sub_end_button_style"), r5.getInt("end_button_style"));
        }

        private final void a(Bundle r4, String r5, d r6) {
            Bundle r3 = new Bundle();
            a.f36624a.a(r3, "start", r6.a());
            a.f36624a.a(r3, "center", r6.b());
            a.f36624a.a(r3, "sub_end", r6.c());
            a.f36624a.a(r3, "end", r6.d());
            r3.putFloat("sub_end_translation_x", r6.e());
            if (r6.f() == null) goto L5;
            boolean r0 = true;
        L6:
            r3.putBoolean("has_freeze_end_area_width", r0);
            Integer r1 = r6.f();
            if (r1 == null) goto L10;
            r3.putInt("freeze_end_area_width", ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue());
        L10:
            r3.putFloat("center_translation_x", r6.g());
            x r7 = x.f38692a;
            r4.putBundle(r5, r3);
            return;
        L5:
            r0 = false;
            goto L6
        }

        private final d b(Bundle r10, String r11) {
            Bundle r12 = r10.getBundle(r11);
            if (r12 != null) goto L5;
            return null;
        L5:
            OButtonGroup.b r1 = c(r12, "start");
            if (r1 != null) goto L8;
            return null;
        L8:
            OButtonGroup.b r2 = c(r12, "center");
            if (r2 != null) goto L11;
            return null;
        L11:
            OButtonGroup.b r3 = c(r12, "sub_end");
            if (r3 != null) goto L14;
            return null;
        L14:
            OButtonGroup.b r4 = c(r12, "end");
            if (r4 != null) goto L17;
            return null;
        L17:
            float r5 = r12.getFloat("sub_end_translation_x");
            if (r12.getBoolean("has_freeze_end_area_width") == false) goto L20;
            Integer r9 = Integer.valueOf(r12.getInt("freeze_end_area_width"));
        L22:
            return new d(r1, r2, r3, r4, r5, r9, r12.getFloat("center_translation_x"));
        L20:
            r9 = (Integer) ZeusTransformUtils.preCheckCast(null, Integer.class, "com.obric.aiagent.plugin");
            goto L22
        }

        private final void a(Bundle r5, String r6, OButtonGroup.b r7) {
            Bundle r4 = new Bundle();
            r4.putInt("visibility", r7.a());
            r4.putFloat("alpha", r7.b());
            r4.putFloat("scale_x", r7.c());
            r4.putFloat("scale_y", r7.d());
            r4.putFloat("group_blur", r7.e());
            r4.putInt("group_width", r7.f());
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7.g(), Iterable.class, "com.obric.aiagent.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L4:
            if (r9.hasNext() == false) goto L6;
            OButtonGroup.f r2 = (OButtonGroup.f) ZeusTransformUtils.preCheckCast(r9.next(), OButtonGroup.f.class, "com.obric.aiagent.plugin");
            r0.add(a.f36624a.a(r2));
            goto L4
        L6:
            r4.putParcelableArrayList("items", new ArrayList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
            x r10 = x.f38692a;
            r5.putBundle(r6, r4);
        }

        private final OButtonGroup.b c(Bundle r10, String r11) {
            Bundle r9 = r10.getBundle(r11);
            if (r9 != null) goto L6;
            return null;
        L6:
            List r12 = (List) ZeusTransformUtils.preCheckCast(r9.getParcelableArrayList("items"), List.class, "com.obric.aiagent.plugin");
            if (r12 != null) goto L9;
            r12 = p.b();
        L9:
            int r2 = r9.getInt("visibility");
            float r3 = r9.getFloat("alpha");
            float r4 = r9.getFloat("scale_x");
            float r5 = r9.getFloat("scale_y");
            float r6 = r9.getFloat("group_blur");
            int r7 = r9.getInt("group_width");
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r15 = r13.iterator();
        L11:
            if (r15.hasNext() == false) goto L16;
            Bundle r16 = (Bundle) ZeusTransformUtils.preCheckCast(r15.next(), Bundle.class, "com.obric.aiagent.plugin");
            f r1 = a.f36624a;
            o.c(r16, "it");
            OButtonGroup.f r17 = r1.e(r16);
            if (r17 == null) goto L11;
            r14.add(r17);
            goto L11
        L16:
            return new OButtonGroup.b(r2, r3, r4, r5, r6, r7, (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin"));
        }

        private final Bundle a(OButtonGroup.f r4) {
            Object r3 = r4.a();
            if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L5;
            b r5 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
        L6:
            Bundle r0 = new Bundle();
            r0.putInt("visibility", r4.b());
            r0.putFloat("alpha", r4.c());
            r0.putFloat("scale_x", r4.d());
            r0.putFloat("scale_y", r4.e());
            if (r5 == null) goto L9;
            r0.putBoolean("has_action_key", true);
            r0.putInt("type", r5.getType());
            r0.putInt("icon_res", r5.a());
            r0.putString("text", r5.b());
            r0.putInt("tint_color", r5.c());
            r0.putString(DbHelper.COL_ID, r5.d());
            r0.putString("icon_resource_name", r5.e());
        L9:
            return r0;
        L5:
            r5 = null;
            goto L6
        }

        private final OButtonGroup.f e(Bundle r8) {
            if (r8.getBoolean("has_action_key") == true) goto L5;
            return null;
        L5:
            return new OButtonGroup.f(new b(r8.getInt("type"), r8.getInt("icon_res"), r8.getString("text"), r8.getInt("tint_color"), r8.getString(DbHelper.COL_ID), r8.getString("icon_resource_name")), r8.getInt("visibility"), r8.getFloat("alpha"), r8.getFloat("scale_x", 1.0f), r8.getFloat("scale_y", 1.0f));
        }

        private final SurfaceControl f(Bundle r2) {
            Parcelable r1 = r2.getParcelable("interrupted_overlay_surface");
            if (ZeusTransformUtils.instanceOf(r1, SurfaceControl.class) == true) goto L7;
            return null;
        L7:
            return (SurfaceControl) ZeusTransformUtils.preCheckCast(r1, SurfaceControl.class, "com.obric.aiagent.plugin");
        }

        private final c a(c r5, Context r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            return new c(a(r5.a(), r7), a(r5.b(), r7), a(r5.c(), r7), a(r5.d(), r7));
        }

        private final List<C0999a> a(List<C0999a> r4, Context r5) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
            Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r7.iterator();
        L4:
            if (r9.hasNext() == false) goto L7;
            C0999a r1 = (C0999a) ZeusTransformUtils.preCheckCast(r9.next(), C0999a.class, "com.obric.aiagent.plugin");
            r8.add(a.f36624a.a(r1, r6));
            goto L4
        L7:
            return (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        }

        private final C0999a a(C0999a r13, Context r14) {
            Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
            if (r13.getType() == 1) goto L5;
            return r13;
        L5:
            int r3 = a(r15, r13.g());
            if (r3 != 0) goto L8;
            return r13;
        L8:
            return C0999a.a(r13, 0, r3, null, null, 0, null, false, null, 253, null);
        }

        private final d a(d r12, Context r13) {
            Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
            return d.a(r12, a(r12.a(), r14), a(r12.b(), r14), a(r12.c(), r14), a(r12.d(), r14), 0.0f, null, 0.0f, 112, null);
        }

        private final OButtonGroup.b a(OButtonGroup.b r14, Context r15) {
            Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin");
            Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r14.g(), Iterable.class, "com.obric.aiagent.plugin");
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r16, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r17 = r16.iterator();
        L4:
            if (r17.hasNext() == false) goto L18;
            OButtonGroup.f r3 = (OButtonGroup.f) ZeusTransformUtils.preCheckCast(r17.next(), OButtonGroup.f.class, "com.obric.aiagent.plugin");
            Object r2 = r3.a();
            if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L8;
            b r4 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
        L9:
            b r5 = r4;
            if (r5 == null) goto L16;
            if (r5.getType() != 1) goto L16;
            int r6 = a.f36624a.a(r13, r5.e());
            if (r6 == 0) goto L16;
            r3 = OButtonGroup.f.a(r3, b.a(r5, 0, r6, null, 0, null, null, 61, null), 0, 0.0f, 0.0f, 0.0f, 30, null);
        L16:
            r1.add(r3);
            goto L4
        L8:
            r4 = null;
            goto L9
        L18:
            return OButtonGroup.b.a(r14, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0, (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), 63, null);
        }

        private final int a(Context r6, String r7) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
            boolean r1 = true;
            if (r8 != null) goto L5;
        L8:
            boolean r9 = true;
        L9:
            if (r9 == false) goto L11;
            return 0;
        L11:
            String r4 = d.o.o.a(r7, '/', "");
            String r10 = d.o.o.b(r7, '/', "");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L14;
            boolean r11 = true;
        L15:
            if (r11 == false) goto L17;
        L24:
            return 0;
        L17:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() == 0) goto L20;
            r1 = false;
        L20:
            if (r1 == true) goto L24;
            return ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin"), r10, r4, r5.getPackageName(), "com.obric.aiagent.plugin");
        L14:
            r11 = false;
            goto L15
        L5:
            if (r8.length() == 0) goto L8;
            r9 = false;
            goto L9
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBarState.kt */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f36652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f36653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f36654c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f36655d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f36656e;

        public g() {
            this(0, 0, 0, 0, 0, 31, null);
        }

        public static /* synthetic */ g a(g r3, int r4, int r5, int r6, int r7, int r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.f36652a;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.f36653b;
        L8:
            int r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.f36654c;
        L11:
            int r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.f36655d;
        L14:
            int r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.f36656e;
        L17:
            int r12 = r4;
            return r3.a(r12, r11, r0, r1, r8);
        }

        public final g a(int r7, int r8, int r9, int r10, int r11) {
            return new g(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
            if (this.f36652a == r6.f36652a) goto L12;
            return false;
        L12:
            if (this.f36653b == r6.f36653b) goto L15;
            return false;
        L15:
            if (this.f36654c == r6.f36654c) goto L18;
            return false;
        L18:
            if (this.f36655d == r6.f36655d) goto L21;
            return false;
        L21:
            if (this.f36656e == r6.f36656e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.f36652a) * 31) + Integer.hashCode(this.f36653b)) * 31) + Integer.hashCode(this.f36654c)) * 31) + Integer.hashCode(this.f36655d)) * 31) + Integer.hashCode(this.f36656e);
        }

        public String toString() {
            return "ContentState(startTitleWidth=" + this.f36652a + ", centerTitleWidth=" + this.f36653b + ", centerCustomWidth=" + this.f36654c + ", centerCustomHeight=" + this.f36655d + ", contentTopInset=" + this.f36656e + ')';
        }

        public g(int r1, int r2, int r3, int r4, int r5) {
            this.f36652a = r1;
            this.f36653b = r2;
            this.f36654c = r3;
            this.f36655d = r4;
            this.f36656e = r5;
        }

        public /* synthetic */ g(int r2, int r3, int r4, int r5, int r6, int r7, d.h.b.h r8) {
            if ((r7 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r7 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r7 & 4) == 0) goto L12;
            r4 = 0;
        L12:
            if ((r7 & 8) == 0) goto L15;
            r5 = 0;
        L15:
            if ((r7 & 16) == 0) goto L17;
            r6 = 0;
        L17:
            this(r2, r3, r4, r5, r6);
        }

        public final int a() {
            return this.f36652a;
        }

        public final int b() {
            return this.f36653b;
        }

        public final int c() {
            return this.f36654c;
        }

        public final int d() {
            return this.f36655d;
        }

        public final int e() {
            return this.f36656e;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBarState.kt */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f36657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f36658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f36659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f36660d;

        public h() {
            this(0, 0, 0, 0, 15, null);
        }

        public final h a(int r1, int r2, int r3, int r4) {
            return new h(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
            return false;
        L8:
            h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
            if (this.f36657a == r6.f36657a) goto L12;
            return false;
        L12:
            if (this.f36658b == r6.f36658b) goto L15;
            return false;
        L15:
            if (this.f36659c == r6.f36659c) goto L18;
            return false;
        L18:
            if (this.f36660d == r6.f36660d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f36657a) * 31) + Integer.hashCode(this.f36658b)) * 31) + Integer.hashCode(this.f36659c)) * 31) + Integer.hashCode(this.f36660d);
        }

        public String toString() {
            return "StyleState(startButtonStyle=" + this.f36657a + ", centerButtonStyle=" + this.f36658b + ", subEndButtonStyle=" + this.f36659c + ", endButtonStyle=" + this.f36660d + ')';
        }

        public h(int r1, int r2, int r3, int r4) {
            this.f36657a = r1;
            this.f36658b = r2;
            this.f36659c = r3;
            this.f36660d = r4;
        }

        public /* synthetic */ h(int r2, int r3, int r4, int r5, int r6, d.h.b.h r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = 0;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = 0;
        L14:
            this(r2, r3, r4, r5);
        }

        public final int a() {
            return this.f36657a;
        }

        public final int b() {
            return this.f36658b;
        }

        public final int c() {
            return this.f36659c;
        }

        public final int d() {
            return this.f36660d;
        }
    }

    static {
        f36624a = new f(null);
    }

    public a() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ a a(a r4, e r5, g r6, c r7, h r8, d r9, SurfaceControl r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.f36625b;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.f36626c;
    L8:
        g r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.f36627d;
    L11:
        c r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.f36628e;
    L14:
        h r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.f;
    L17:
        d r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.g;
    L20:
        e r14 = r5;
        return r4.a(r14, r13, r0, r1, r2, r10);
    }

    public final a a(e r8, g r9, c r10, h r11, d r12, SurfaceControl r13) {
        o.e(r8, "bounds");
        o.e(r9, "content");
        o.e(r10, "actions");
        o.e(r11, "style");
        return new a(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f36625b, r6.f36625b) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f36626c, r6.f36626c) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f36627d, r6.f36627d) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f36628e, r6.f36628e) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        if (o.a(this.g, r6.g) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.f36625b.hashCode() * 31) + this.f36626c.hashCode()) * 31) + this.f36627d.hashCode()) * 31) + this.f36628e.hashCode()) * 31;
        d r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        SurfaceControl r5 = this.g;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "OFloatingTitleBarState(bounds=" + this.f36625b + ", content=" + this.f36626c + ", actions=" + this.f36627d + ", style=" + this.f36628e + ", animationState=" + this.f + ", interruptedOverlaySurface=" + this.g + ')';
    }

    public a(e r2, g r3, c r4, h r5, d r6, SurfaceControl r7) {
        o.e(r2, "bounds");
        o.e(r3, "content");
        o.e(r4, "actions");
        o.e(r5, "style");
        this.f36625b = r2;
        this.f36626c = r3;
        this.f36627d = r4;
        this.f36628e = r5;
        this.f = r6;
        this.g = r7;
    }

    public /* synthetic */ a(e r12, g r13, c r14, h r15, d r16, SurfaceControl r17, int r18, d.h.b.h r19) {
        if ((r18 & 1) == 0) goto L5;
        e r0 = new e(0, 0, 0, 0, 15, null);
    L7:
        if ((r18 & 2) == 0) goto L9;
        g r1 = new g(0, 0, 0, 0, 0, 31, null);
    L11:
        if ((r18 & 4) == 0) goto L13;
        c r2 = new c(null, null, null, null, 15, null);
    L15:
        if ((r18 & 8) == 0) goto L17;
        h r3 = new h(0, 0, 0, 0, 15, null);
    L18:
        SurfaceControl r5 = null;
        if ((r18 & 16) == 0) goto L21;
        d r4 = null;
    L23:
        if ((r18 & 32) != 0) goto L26;
        r5 = r17;
    L26:
        this(r0, r1, r2, r3, r4, r5);
        return;
    L21:
        r4 = r16;
        goto L23
    L17:
        r3 = r15;
        goto L18
    L13:
        r2 = r14;
        goto L15
    L9:
        r1 = r13;
        goto L11
    L5:
        r0 = r12;
        goto L7
    }

    public final e a() {
        return this.f36625b;
    }

    public final g b() {
        return this.f36626c;
    }

    public final c c() {
        return this.f36627d;
    }

    public final h d() {
        return this.f36628e;
    }

    public final d e() {
        return this.f;
    }

    public final SurfaceControl f() {
        return this.g;
    }

    public final a a(Context r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        f r0 = f36624a;
        c r5 = f.a(r0, this.f36627d, r13);
        d r1 = this.f;
        if (r1 != null) goto L5;
        d r14 = null;
    L7:
        return a(this, null, null, r5, null, r14, null, 43, null);
    L5:
        r14 = f.a(r0, r1, r13);
        goto L7
    }

    public final Bundle g() {
        Bundle r0 = new Bundle();
        f r1 = f36624a;
        f.a(r1, r0, a());
        f.a(r1, r0, b());
        f.a(r1, r0, "start_actions", c().a());
        f.a(r1, r0, "center_actions", c().b());
        f.a(r1, r0, "sub_end_actions", c().c());
        f.a(r1, r0, "end_actions", c().d());
        f.a(r1, r0, d());
        d r2 = e();
        if (r2 == null) goto L6;
        f.a(r1, r0, "animation_state", r2);
    L6:
        SurfaceControl r4 = f();
        if (r4 == null) goto L10;
        r0.putParcelable("interrupted_overlay_surface", (Parcelable) ZeusTransformUtils.preCheckCast(r4, Parcelable.class, "com.obric.aiagent.plugin"));
    L10:
        return r0;
    }
}
