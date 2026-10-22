package com.obric.autogui.agents.scripted.impl;

import android.os.Bundle;
import com.google.gson.annotations.SerializedName;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: JSViewTreeNode.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26978a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("text")
    private final String f26979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("contextDescription")
    private final String f26980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("hint")
    private final String f26981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("class")
    private final String f26982e;

    @SerializedName("viewId")
    private final String f;

    @SerializedName("clickable")
    private final Boolean g;

    @SerializedName("scrollable")
    private final Boolean h;

    @SerializedName("isVisibleToUser")
    private final Boolean i;

    @SerializedName("bounds")
    private final b j;

    @SerializedName("children")
    private final List<d> k;

    @SerializedName("extras")
    private final Map<String, Serializable> l;

    /* JADX INFO: compiled from: JSViewTreeNode.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final d a(com.obric.autogui.platforms.tools.internal.viewhierarchy.a r15) {
            d.h.b.o.e(r15, "<this>");
            int r0 = r15.a().getId();
            if (r15.a().getId() != (-1)) goto L6;
            String r1 = "";
        L5:
            String r6 = r1;
            boolean r2 = r15.isClickable();
            if (r15.getVisibility() != 0) goto L15;
            boolean r3 = true;
        L16:
            b r10 = b.f26973a.a(r15.getBounds());
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r15.getChildren(), Iterable.class, "com.obric.aiagent.plugin");
            Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r7 = r4.iterator();
        L18:
            if (r7.hasNext() == false) goto L23;
            d r8 = d.f26978a.a((VHNode) ZeusTransformUtils.preCheckCast(r7.next(), VHNode.class, "com.obric.aiagent.plugin"));
            if (r8 == null) goto L18;
            r5.add(r8);
            goto L18
        L23:
            return new d(String.valueOf(r15.getText()), String.valueOf(r15.a().getContentDescription()), String.valueOf(r15.getHint()), String.valueOf(r15.getClassName()), r6, Boolean.valueOf(r2), Boolean.valueOf(r15.isScrollable()), Boolean.valueOf(r3), r10, (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), a(r15.a().getExtras()));
        L15:
            r3 = false;
            goto L16
        L6:
            String r9 = r15.a().getIdEntry();
            String r11 = r15.a().getIdType();
            String r12 = r15.a().getIdPackage();
            if (r9 == null) goto L11;
            if (r11 == null) goto L11;
            if (r12 == null) goto L11;
            r1 = r12 + ':' + r11 + '/' + r9;
        L11:
            r1 = "0x" + Integer.toHexString(r0);
            goto L5
        }

        private final d a(VHNode r3) {
            VHNode r4 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r3, VHNode.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, com.obric.autogui.platforms.tools.internal.viewhierarchy.a.class) == true) goto L7;
            return null;
        L7:
            return a((com.obric.autogui.platforms.tools.internal.viewhierarchy.a) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.platforms.tools.internal.viewhierarchy.a.class, "com.obric.aiagent.plugin"));
        }

        private final Map<String, Serializable> a(Bundle r6) {
            Map<String, Serializable> r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L5;
            return r5;
        L5:
            Iterator<String> r0 = r6.keySet().iterator();
        L7:
            if (r0.hasNext() == false) goto L14;
            String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
            Object r3 = r6.get(r2);
            if (ZeusTransformUtils.instanceOf(r3, Serializable.class) == false) goto L11;
            Serializable r4 = (Serializable) ZeusTransformUtils.preCheckCast(r3, Serializable.class, "com.obric.aiagent.plugin");
        L12:
            if (r4 == null) goto L7;
            r5.put(r2, r4);
            goto L7
        L11:
            r4 = null;
            goto L12
        L14:
            return r5;
        }
    }

    static {
        f26978a = new a(null);
    }

    public d() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f26979b, r6.f26979b) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f26980c, r6.f26980c) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f26981d, r6.f26981d) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f26982e, r6.f26982e) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.h, r6.h) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.i, r6.i) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.j, r6.j) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.k, r6.k) == true) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.l, r6.l) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r0 = this.f26979b;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f26980c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f26981d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f26982e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.g;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.h;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.i;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        b r25 = this.j;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        List<d> r28 = this.k;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Map<String, Serializable> r31 = this.l;
        if (r31 == null) goto L47;
        r1 = r31.hashCode();
    L47:
        return r30 + r1;
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("JSViewTreeNode(text=").append(this.f26979b).append(", contentDescription=").append(this.f26980c).append(", hint=").append(this.f26981d).append(", clazz=").append(this.f26982e).append(", viewId=").append(this.f).append(", clickable=").append(this.g).append(", scrollable=").append(this.h).append(", isVisibleToUser=").append(this.i).append(", bounds=").append(this.j).append(", children=").append(this.k).append(", extras=").append(this.l).append(')');
        return r0.toString();
    }

    public d(String r3, String r4, String r5, String r6, String r7, Boolean r8, Boolean r9, Boolean r10, b r11, List<d> r12, Map<String, ? extends Serializable> r13) {
        List<d> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        Map<String, Serializable> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        this.f26979b = r3;
        this.f26980c = r4;
        this.f26981d = r5;
        this.f26982e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r14;
        this.l = r15;
    }

    public /* synthetic */ d(String r15, String r16, String r17, String r18, String r19, Boolean r20, Boolean r21, Boolean r22, b r23, List r24, Map r25, int r26, d.h.b.h r27) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.aiagent.plugin");
        if ((r26 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r26 & 32) == 0) goto L25;
        Boolean r9 = null;
    L27:
        if ((r26 & 64) == 0) goto L29;
        Boolean r10 = null;
    L31:
        if ((r26 & 128) == 0) goto L33;
        Boolean r11 = null;
    L35:
        if ((r26 & 256) == 0) goto L37;
        b r12 = null;
    L39:
        if ((r26 & 512) == 0) goto L42;
        r1 = null;
    L42:
        if ((r26 & 1024) == 0) goto L44;
        r2 = null;
    L44:
        this(r3, r5, r6, r7, r8, r9, r10, r11, r12, r1, r2);
        return;
    L37:
        r12 = r23;
        goto L39
    L33:
        r11 = r22;
        goto L35
    L29:
        r10 = r21;
        goto L31
    L25:
        r9 = r20;
        goto L27
    L21:
        r8 = r19;
        goto L23
    L17:
        r7 = r18;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r3 = r15;
        goto L7
    }
}
