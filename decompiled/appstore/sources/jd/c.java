package jd;

import android.content.Context;
import com.obric.common.oui.R$string;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f20998a = null;

    static {
        f20998a = new c();
    }

    public c() {
    }

    public static /* synthetic */ List c(c r10, int r11, int r12, String r13, int r14, int r15, Object r16) {
        if ((r15 & 4) == 0) goto L6;
        r13 = "";
    L6:
        if ((r15 & 8) == 0) goto L9;
        r14 = 2;
    L9:
        return r10.b(r11, r12, r13, r14);
    }

    public final List a(Context r10, int r11, int r12) {
        q.g(r10, "context");
        ArrayList r13 = new ArrayList();
        if (r11 > r12) goto L23;
    L4:
        int r14 = r11 + 1;
        switch(r11) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L6;
        };
    L6:
        int r15 = R$string.oui_reel_picker_month_def;
    L19:
        String r16 = r10.getString(r15);
        q.f(r16, "context.getString(monthRes)");
        r13.add(r16);
        if (r11 == r12) goto L23;
        r11 = r14;
        goto L4
    L7:
        r15 = R$string.oui_reel_picker_month_dec;
        goto L19
    L8:
        r15 = R$string.oui_reel_picker_month_nov;
        goto L19
    L9:
        r15 = R$string.oui_reel_picker_month_oct;
        goto L19
    L10:
        r15 = R$string.oui_reel_picker_month_sep;
        goto L19
    L11:
        r15 = R$string.oui_reel_picker_month_aug;
        goto L19
    L12:
        r15 = R$string.oui_reel_picker_month_jul;
        goto L19
    L13:
        r15 = R$string.oui_reel_picker_month_jun;
        goto L19
    L14:
        r15 = R$string.oui_reel_picker_month_may;
        goto L19
    L15:
        r15 = R$string.oui_reel_picker_month_apr;
        goto L19
    L16:
        r15 = R$string.oui_reel_picker_month_mar;
        goto L19
    L17:
        r15 = R$string.oui_reel_picker_month_feb;
        goto L19
    L18:
        r15 = R$string.oui_reel_picker_month_jan;
    L23:
        return r13;
    }

    public final List b(int r10, int r11, String r12, int r13) {
        q.g(r12, "suffix");
        ArrayList r14 = new ArrayList();
        if (r10 > r11) goto L8;
    L4:
        int r15 = r10 + 1;
        r14.add(q.p(StringsKt__StringsKt.b0(String.valueOf(r10), r13, '0'), r12));
        if (r10 == r11) goto L8;
        r10 = r15;
    L8:
        return r14;
    }
}
