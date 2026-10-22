package com.lynx.markdown;

import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.ttreader.tttext.lite.TTFont;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/* JADX INFO: compiled from: MarkdownStyleWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.lynx.markdown.a.e f13907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f13908b;

    public j(com.lynx.markdown.a.e r3, b r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        this.f13907a = r3;
        this.f13908b = r5;
    }

    public byte[] a(HashMap r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        DataOutputStream r2 = new DataOutputStream(r1);
        HashMap r3 = com.lynx.markdown.b.a.a(r5, "normalText", null);     // Catch: IOException -> L8
        a(r3, r2);     // Catch: IOException -> L8
        b(r3, r2);     // Catch: IOException -> L8
        HashMap r4 = com.lynx.markdown.b.a.a(r5, "h1", null);     // Catch: IOException -> L8
        a(r4, r2);     // Catch: IOException -> L8
        b(r4, r2);     // Catch: IOException -> L8
        HashMap r6 = com.lynx.markdown.b.a.a(r5, "h2", null);     // Catch: IOException -> L8
        a(r6, r2);     // Catch: IOException -> L8
        b(r6, r2);     // Catch: IOException -> L8
        HashMap r7 = com.lynx.markdown.b.a.a(r5, "h3", null);     // Catch: IOException -> L8
        a(r7, r2);     // Catch: IOException -> L8
        b(r7, r2);     // Catch: IOException -> L8
        HashMap r8 = com.lynx.markdown.b.a.a(r5, "h4", null);     // Catch: IOException -> L8
        a(r8, r2);     // Catch: IOException -> L8
        b(r8, r2);     // Catch: IOException -> L8
        HashMap r9 = com.lynx.markdown.b.a.a(r5, "h5", null);     // Catch: IOException -> L8
        a(r9, r2);     // Catch: IOException -> L8
        b(r9, r2);     // Catch: IOException -> L8
        HashMap r10 = com.lynx.markdown.b.a.a(r5, "h6", null);     // Catch: IOException -> L8
        a(r10, r2);     // Catch: IOException -> L8
        b(r10, r2);     // Catch: IOException -> L8
        a(com.lynx.markdown.b.a.a(r5, "link", null), r2);     // Catch: IOException -> L8
        HashMap r11 = com.lynx.markdown.b.a.a(r5, "inlineCode", null);     // Catch: IOException -> L8
        a(r11, r2);     // Catch: IOException -> L8
        c(r11, r2);     // Catch: IOException -> L8
        b(r11, r2);     // Catch: IOException -> L8
        HashMap r12 = com.lynx.markdown.b.a.a(r5, "codeBlock", null);     // Catch: IOException -> L8
        a(r12, r2);     // Catch: IOException -> L8
        b(r12, r2);     // Catch: IOException -> L8
        c(r12, r2);     // Catch: IOException -> L8
        HashMap r13 = com.lynx.markdown.b.a.a(r5, "quote", null);     // Catch: IOException -> L8
        a(r13, r2);     // Catch: IOException -> L8
        b(r13, r2);     // Catch: IOException -> L8
        c(r13, r2);     // Catch: IOException -> L8
        e(r13, r2);     // Catch: IOException -> L8
        HashMap r14 = com.lynx.markdown.b.a.a(r5, "orderedList", null);     // Catch: IOException -> L8
        a(r14, r2);     // Catch: IOException -> L8
        f(r14, r2);     // Catch: IOException -> L8
        b(r14, r2);     // Catch: IOException -> L8
        e(r14, r2);     // Catch: IOException -> L8
        HashMap r15 = com.lynx.markdown.b.a.a(r5, "unorderedList", null);     // Catch: IOException -> L8
        a(r15, r2);     // Catch: IOException -> L8
        g(r15, r2);     // Catch: IOException -> L8
        b(r15, r2);     // Catch: IOException -> L8
        e(r15, r2);     // Catch: IOException -> L8
        HashMap r16 = com.lynx.markdown.b.a.a(r5, "ref", null);     // Catch: IOException -> L8
        a(r16, r2);     // Catch: IOException -> L8
        b(r16, r2);     // Catch: IOException -> L8
        h(r16, r2);     // Catch: IOException -> L8
        HashMap r17 = com.lynx.markdown.b.a.a(r5, "table", null);     // Catch: IOException -> L8
        b(r17, r2);     // Catch: IOException -> L8
        c(r17, r2);     // Catch: IOException -> L8
        HashMap r18 = com.lynx.markdown.b.a.a(r5, "tableCell", null);     // Catch: IOException -> L8
        a(r18, r2);     // Catch: IOException -> L8
        b(r18, r2);     // Catch: IOException -> L8
        HashMap r19 = com.lynx.markdown.b.a.a(r5, "split", null);     // Catch: IOException -> L8
        c(r19, r2);     // Catch: IOException -> L8
        b(r19, r2);     // Catch: IOException -> L8
        i(com.lynx.markdown.b.a.a(r5, "typewriterCursor", null), r2);     // Catch: IOException -> L8
        HashMap r20 = com.lynx.markdown.b.a.a(r5, "mark", null);     // Catch: IOException -> L8
        a(r20, r2);     // Catch: IOException -> L8
        b(r20, r2);     // Catch: IOException -> L8
        c(r20, r2);     // Catch: IOException -> L8
        d(r20, r2);     // Catch: IOException -> L8
        HashMap r21 = com.lynx.markdown.b.a.a(r5, "doubleBraces", null);     // Catch: IOException -> L8
        a(r21, r2);     // Catch: IOException -> L8
        b(r21, r2);     // Catch: IOException -> L8
        c(r21, r2);     // Catch: IOException -> L8
        d(r21, r2);     // Catch: IOException -> L8
    L11:
        return r1.toByteArray();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public void a(HashMap r1, DataOutputStream r2, String r3, int r4) {
        String r0 = com.lynx.markdown.b.a.a(r1, r3, null);
        if (r0 == null) goto L12;
        r2.writeInt(r4);
        if (r0.equals(OProtocolTextEffectTextView.EffectNameNone) == false) goto L8;
        r2.writeInt(0);
        return;
    L8:
        if (r0.equals("solid") == false) goto L10;
        r2.writeInt(1);
        return;
    L10:
        r2.writeInt(0);
        return;
    }

    public void b(HashMap r1, DataOutputStream r2, String r3, int r4) {
        String r0 = com.lynx.markdown.b.a.a(r1, r3, null);
        if (r0 == null) goto L18;
        r2.writeInt(r4);
        if (r0.equals("number") == false) goto L8;
        r2.writeInt(0);
        return;
    L8:
        if (r0.equals("alphabet") == false) goto L11;
        r2.writeInt(1);
        return;
    L11:
        if (r0.equals("roman-numerals") == false) goto L14;
        r2.writeInt(2);
        return;
    L14:
        if (r0.equals("mixed") == false) goto L16;
        r2.writeInt(3);
        return;
    L16:
        r2.writeInt(0);
        return;
    }

    public void c(HashMap r1, DataOutputStream r2, String r3, int r4) {
        String r0 = com.lynx.markdown.b.a.a(r1, r3, null);
        if (r0 == null) goto L18;
        r2.writeInt(r4);
        if (r0.equals("circle") == false) goto L8;
        r2.writeInt(0);
        return;
    L8:
        if (r0.equals("ring") == false) goto L11;
        r2.writeInt(1);
        return;
    L11:
        if (r0.equals("square") == false) goto L14;
        r2.writeInt(2);
        return;
    L14:
        if (r0.equals("mixed") == false) goto L16;
        r2.writeInt(3);
        return;
    L16:
        r2.writeInt(0);
        return;
    }

    public void d(HashMap r1, DataOutputStream r2, String r3, int r4) {
        String r0 = com.lynx.markdown.b.a.a(r1, r3, null);
        if (r0 == null) goto L12;
        r2.writeInt(r4);
        if (r0.equals(OProtocolTextEffectTextView.EffectNameNone) == false) goto L8;
        r2.writeInt(0);
        return;
    L8:
        if (r0.equals("capsule") == false) goto L10;
        r2.writeInt(1);
        return;
    L10:
        r2.writeInt(0);
        return;
    }

    public void e(HashMap r1, DataOutputStream r2, String r3, int r4) {
        String r0 = com.lynx.markdown.b.a.a(r1, r3, null);
        if (r0 == null) goto L12;
        r2.writeInt(r4);
        if (r0.equals("clip") == false) goto L8;
        r2.writeInt(0);
        return;
    L8:
        if (r0.equals("ellipsis") == false) goto L10;
        r2.writeInt(1);
        return;
    L10:
        r2.writeInt(0);
        return;
    }

    public void f(HashMap r1, DataOutputStream r2, String r3, int r4) {
        String r0 = com.lynx.markdown.b.a.a(r1, r3, null);
        if (r0 == null) goto L18;
        r2.writeInt(r4);
        if (r0.equals("baseline") == false) goto L8;
        r2.writeInt(0);
        return;
    L8:
        if (r0.equals("top") == false) goto L11;
        r2.writeInt(1);
        return;
    L11:
        if (r0.equals("bottom") == false) goto L14;
        r2.writeInt(2);
        return;
    L14:
        if (r0.equals("center") == false) goto L16;
        r2.writeInt(3);
        return;
    L16:
        r2.writeInt(0);
        return;
    }

    public void g(HashMap r1, DataOutputStream r2, String r3, int r4) {
        String r0 = com.lynx.markdown.b.a.a(r1, r3, null);
        if (r0 == null) goto L12;
        r2.writeInt(r4);
        if (r0.equals("normal") == false) goto L8;
        r2.writeInt(0);
        return;
    L8:
        if (r0.equals("bold") == false) goto L10;
        r2.writeInt(1);
        return;
    L10:
        r2.writeInt(0);
        return;
    }

    public void a(HashMap r3, DataOutputStream r4) {
        if (r3 == null) goto L4;
        h(r3, r4, "font", 1);
        i(r3, r4, "fontSize", 2);
        g(r3, r4, "fontWeight", 3);
        i(r3, r4, "lineHeight", 5);
        i(r3, r4, "paragraphSpace", 6);
        j(r3, r4, "color", 7);
        j(r3, r4, "backgroundColor", 8);
        e(r3, r4, "textOverflow", 9);
    L4:
        r4.writeInt(0);
    }

    public void b(HashMap r3, DataOutputStream r4) {
        if (r3 == null) goto L4;
        i(r3, r4, "marginTop", 10);
        i(r3, r4, "marginBottom", 11);
        i(r3, r4, "marginLeft", 12);
        i(r3, r4, "marginRight", 13);
        i(r3, r4, "paddingTop", 14);
        i(r3, r4, "paddingBottom", 15);
        i(r3, r4, "paddingLeft", 16);
        i(r3, r4, "paddingRight", 17);
    L4:
        r4.writeInt(0);
    }

    public void c(HashMap r3, DataOutputStream r4) {
        if (r3 == null) goto L4;
        a(r3, r4, "borderType", 18);
        j(r3, r4, "borderColor", 19);
        i(r3, r4, "borderWidth", 20);
        i(r3, r4, "borderRadius", 21);
    L4:
        r4.writeInt(0);
    }

    public void d(HashMap r3, DataOutputStream r4) {
        if (r3 == null) goto L4;
        k(r3, r4, "backgroundImage", 22);
        k(r3, r4, "backgroundSize", 23);
        k(r3, r4, "backgroundRepeat", 24);
        k(r3, r4, "backgroundPosition", 25);
    L4:
        r4.writeInt(0);
    }

    public void e(HashMap r3, DataOutputStream r4) {
        if (r3 == null) goto L4;
        i(r3, r4, "indent", 26);
    L4:
        r4.writeInt(0);
    }

    public void f(HashMap r3, DataOutputStream r4) {
        if (r3 == null) goto L4;
        b(r3, r4, "numberType", 27);
        h(r3, r4, "numberFont", 28);
        i(r3, r4, "numberFontSize", 29);
        j(r3, r4, "numberColor", 30);
        i(r3, r4, "numberMarginRight", 31);
    L4:
        r4.writeInt(0);
    }

    public void g(HashMap r3, DataOutputStream r4) {
        if (r3 == null) goto L4;
        c(r3, r4, "markType", 32);
        j(r3, r4, "markColor", 33);
        i(r3, r4, "markSize", 34);
        i(r3, r4, "markMarginRight", 35);
    L4:
        r4.writeInt(0);
    }

    public void h(HashMap r3, DataOutputStream r4) {
        if (r3 == null) goto L4;
        d(r3, r4, "backgroundType", 36);
    L4:
        r4.writeInt(0);
    }

    public void i(HashMap r3, DataOutputStream r4) {
        if (r3 == null) goto L4;
        k(r3, r4, "customCursor", 37);
        f(r3, r4, "verticalAlign", 38);
    L4:
        r4.writeInt(0);
    }

    public void h(HashMap r2, DataOutputStream r3, String r4, int r5) {
        String r6 = com.lynx.markdown.b.a.a(r2, r4, null);
        if (r6 == null) goto L6;
        r3.writeInt(r5);
        TTFont r7 = this.f13908b.a(r6);
        r3.writeInt(this.f13907a.a(r7));
        return;
    }

    public void i(HashMap r3, DataOutputStream r4, String r5, int r6) {
        double r2 = com.lynx.markdown.b.a.a(r3, r5, Double.NaN);
        if (Double.isNaN(r2) == true) goto L6;
        r4.writeInt(r6);
        r4.writeFloat((float) r2);
        return;
    }

    public void j(HashMap r3, DataOutputStream r4, String r5, int r6) {
        String r2 = com.lynx.markdown.b.a.a(r3, r5, null);
        if (r2 == null) goto L9;
        long r0 = Long.parseLong(r2, 16);
        if (r2.length() > 6) goto L7;
        r0 = r0 | 4278190080L;
    L7:
        r4.writeInt(r6);
        r4.writeInt((int) r0);
        return;
    }

    public void k(HashMap r1, DataOutputStream r2, String r3, int r4) {
        String r0 = com.lynx.markdown.b.a.a(r1, r3, null);
        if (r0 == null) goto L6;
        r2.writeInt(r4);
        byte[] r5 = r0.getBytes(StandardCharsets.UTF_8);
        r2.writeInt(r5.length);
        r2.write(r5, 0, r5.length);
        return;
    }
}
