package se;

import com.ss.android.agilelogger.formatter.border.BorderFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class a implements BorderFormatter {
    public a() {
    }

    public static String a(String r10) {
        StringBuilder r11 = new StringBuilder(r10.length() + 10);
        String[] r12 = r10.split("\n");
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        if (r14 == 0) goto L6;
        r11.append("\n");
    L6:
        String r15 = r12[r14];
        r11.append(9553);
        r11.append(r15);
        r14 = r14 + 1;
        goto L3
    L8:
        return r11.toString();
    }

    public String b(String[] r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r10.length == 0) goto L31;
        String[] r11 = new String[r10.length];
        int r12 = r10.length;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L8:
        if (r14 >= r12) goto L13;
        String r16 = r10[r14];
        if (r16 == null) goto L12;
        r11[r15] = r16;
        r15 = r15 + 1;
    L12:
        r14 = r14 + 1;
        goto L8
    L13:
        if (r15 != 0) goto L15;
        return "";
    L15:
        StringBuilder r17 = new StringBuilder();
        r17.append("╔═══════════════════════════════════════════════════════════════════════════════════════════════════");
        r17.append("\n");
    L16:
        if (r13 >= r15) goto L23;
        r17.append(a(r11[r13]));
        if (r13 == (r15 - 1)) goto L20;
        r17.append("\n");
        r17.append("╟───────────────────────────────────────────────────────────────────────────────────────────────────");
        r17.append("\n");
    L21:
        r13 = r13 + 1;
        goto L16
    L20:
        r17.append("\n");
        r17.append("╚═══════════════════════════════════════════════════════════════════════════════════════════════════");
        goto L21
    L23:
        return r17.toString();
    L31:
        return "";
    }

    @Override // com.ss.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(String[] r10) {
        return b(r10);
    }
}
