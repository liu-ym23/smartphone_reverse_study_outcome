package com.obric.autogui.util.ui;

import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.ad;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.util.Arrays;
import org.xml.sax.XMLReader;

/* JADX INFO: compiled from: SpanFormatter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SpanFormatter {
    private static final String TAG = "mux-span";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f31572a = null;

    /* JADX INFO: compiled from: SpanFormatter.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: SpanFormatter.kt */
        public static final class InnerTagHandler implements Html.TagHandler {
            private final Spannable[] rawTexts;

            public InnerTagHandler(Spannable[] r2) {
                o.e(r2, "rawTexts");
                this.rawTexts = r2;
            }

            @Override // android.text.Html.TagHandler
            public void handleTag(boolean r9, String r10, Editable r11, XMLReader r12) {
                Editable r13 = (Editable) ZeusTransformUtils.wrapperContextForParams(r11, Editable.class, "com.obric.aiagent.plugin");
                XMLReader r14 = (XMLReader) ZeusTransformUtils.wrapperContextForParams(r12, XMLReader.class, "com.obric.aiagent.plugin");
                o.e(r10, "tag");
                o.e(r13, "output");
                o.e(r14, "xmlReader");
                int r0 = 0;
                if (d.o.o.b(r10, "mux-span-", false, 2, null) == false) goto L11;
                if (r9 == true) goto L15;
                Integer r15 = Integer.valueOf((String) ZeusTransformUtils.preCheckCast(p.m(d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"-"}, false, 0, 6, null)), String.class, "com.obric.aiagent.plugin"));
                Spannable[] r8 = this.rawTexts;
                o.a(r15);
                Spannable r16 = r8[r15.intValue()];
                CharacterStyle[] r17 = (CharacterStyle[]) ZeusTransformUtils.preCheckCast(r16.getSpans(0, r16.length(), CharacterStyle.class), CharacterStyle[].class, "com.obric.aiagent.plugin");
                o.a(r17);
                int r18 = r17.length;
            L6:
                if (r0 >= r18) goto L16;
                CharacterStyle r19 = r17[r0];
                int r1 = r16.getSpanStart(r19);
                int r2 = r16.getSpanEnd(r19);
                if (r13.getSpanStart(r19) >= 0) goto L10;
                int r3 = r13.length() - r16.length();
                r13.setSpan(r19, r1 + r3, r2 + r3, r16.getSpanFlags(r19));
            L10:
                r0 = r0 + 1;
                goto L6
            L16:
                return;
            L15:
                return;
            }
        }

        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        public final Spanned a(String r9, Spannable... r10) {
            o.e(r9, "format");
            o.e(r10, "args");
            String r11 = d.o.o.a(r9, "\n", "<br/>", false, 4, null);
            n.a r0 = n.f38560a;     // Catch: Throwable -> L11
            int r1 = r10.length;     // Catch: Throwable -> L11
            String[] r2 = new String[r1];     // Catch: Throwable -> L11
            int r3 = 0;
            int r4 = 0;
        L4:
            if (r4 >= r1) goto L6;
            r2[r4] = "";     // Catch: Throwable -> L11
            r4 = r4 + 1;     // Catch: Throwable -> L11
            goto L4
        L6:
            int r5 = r10.length;     // Catch: Throwable -> L11
            int r6 = 0;
        L7:
            if (r3 >= r5) goto L9;
            r2[r6] = SpanFormatter.f31572a.a(r10[r3].toString(), r6);     // Catch: Throwable -> L11
            r3 = r3 + 1;     // Catch: Throwable -> L11
            r6 = r6 + 1;     // Catch: Throwable -> L11
            goto L7
        L9:
            ad r7 = ad.f38485a;     // Catch: Throwable -> L11
            Object[] r8 = Arrays.copyOf(r2, r1);     // Catch: Throwable -> L11
            String r12 = String.format(r11, Arrays.copyOf(r8, r8.length));     // Catch: Throwable -> L11
            o.c(r12, "format(...)");     // Catch: Throwable -> L11
            Spanned r13 = androidx.core.text.b.a(r12, 63, null, (Html.TagHandler) ZeusTransformUtils.preCheckCast(new InnerTagHandler(r10), Html.TagHandler.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
            o.c(r13, "fromHtml(...)");     // Catch: Throwable -> L11
            return r13;
        L11:
            th = move-exception;
            n.a r14 = n.f38560a;
            Object r15 = n.f(d.o.a(th));
            if (n.c(r15) == null) goto L15;
            Loog.INSTANCE.e("SpanFormatter", "format string error , please check your params " + r11 + ' ' + r10);
        L15:
            SpannableStringBuilder r16 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"));
            if (n.b(r15) == false) goto L19;
            r15 = r16;
        L19:
            return (Spanned) ZeusTransformUtils.preCheckCast(r15, Spanned.class, "com.obric.aiagent.plugin");
        }

        private final String a(String r2, int r3) {
            return "<mux-span-" + r3 + '>' + r2 + "</mux-span-" + r3 + '>';
        }
    }

    static {
        f31572a = new Companion(null);
    }
}
