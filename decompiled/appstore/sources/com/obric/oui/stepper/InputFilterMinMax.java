package com.obric.oui.stepper;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: loaded from: classes4.dex */
public class InputFilterMinMax implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FilterListener f17009c;

    public interface FilterListener {
        void onBeyondLimit(int r10);
    }

    public InputFilterMinMax(int r10, int r11, FilterListener r12) {
        this.f17007a = r10;
        this.f17008b = r11;
        this.f17009c = r12;
    }

    public final boolean a(int r10, int r11, int r12) {
        if (r11 <= r10) goto L7;
        if (r12 < r10) goto L10;
        if (r12 <= r11) goto L12;
        return false;
    L12:
        return true;
    L10:
        return false;
    L7:
        if (r12 < r11) goto L13;
        if (r12 <= r10) goto L12;
        return false;
    L13:
        return false;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r10, int r11, int r12, Spanned r13, int r14, int r15) {
        int r16 = Integer.parseInt(r13.toString() + r10.toString());     // Catch: NumberFormatException -> L11
        if (a(this.f17007a, this.f17008b, r16) == false) goto L6;
        return null;
    L6:
        FilterListener r17 = this.f17009c;     // Catch: NumberFormatException -> L11
        if (r17 == null) goto L14;
        r17.onBeyondLimit(r16);     // Catch: NumberFormatException -> L11
        return "";
    L14:
        return "";
    L15:
        return "";
    }
}
