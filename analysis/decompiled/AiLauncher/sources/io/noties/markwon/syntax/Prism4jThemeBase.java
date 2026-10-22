package io.noties.markwon.syntax;

import M8.c;
import O8.h;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import java.util.HashMap;

/* loaded from: classes4.dex */
public abstract class Prism4jThemeBase implements c {

    /* renamed from: a, reason: collision with root package name */
    public final ColorHashMap f34294a = f();

    public static class ColorHashMap extends HashMap<String, a> {
        public ColorHashMap d(int i10, String str) {
            put(str, a.a(i10));
            return this;
        }

        public ColorHashMap g(int i10, String str, String str2) {
            a aVarA = a.a(i10);
            put(str, aVarA);
            put(str2, aVarA);
            return this;
        }

        public ColorHashMap h(int i10, String str, String str2, String str3) {
            a aVarA = a.a(i10);
            put(str, aVarA);
            put(str2, aVarA);
            put(str3, aVarA);
            return this;
        }

        public ColorHashMap i(int i10, String... strArr) {
            a aVarA = a.a(i10);
            for (String str : strArr) {
                put(str, aVarA);
            }
            return this;
        }
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f34295a;

        public a(int i10) {
            this.f34295a = i10;
        }

        public static a a(int i10) {
            return new a(i10);
        }
    }

    @Override // M8.c
    public void b(String str, h.d dVar, SpannableStringBuilder spannableStringBuilder, int i10, int i11) {
        String strType = dVar.type();
        String strA = dVar.a();
        int iE = e(str, strType, strA);
        if (iE != 0) {
            d(str, strType, strA, iE, spannableStringBuilder, i10, i11);
        }
    }

    public void d(String str, String str2, String str3, int i10, SpannableStringBuilder spannableStringBuilder, int i11, int i12) {
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i10), i11, i12, 33);
    }

    public int e(String str, String str2, String str3) {
        a aVar = this.f34294a.get(str2);
        if (aVar == null && str3 != null) {
            aVar = this.f34294a.get(str3);
        }
        if (aVar != null) {
            return aVar.f34295a;
        }
        return 0;
    }

    public abstract ColorHashMap f();
}
