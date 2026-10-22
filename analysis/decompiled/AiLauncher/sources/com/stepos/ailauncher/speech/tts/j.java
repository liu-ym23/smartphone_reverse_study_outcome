package com.stepos.ailauncher.speech.tts;

import La.D;
import La.H;
import La.z;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\u00020\u000b*\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u000e*\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u000e*\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0013\u0010\u0012\u001a\u00020\u0004*\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0007J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\tJ\u0013\u0010\u0016\u001a\u00060\u0014j\u0002`\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00042\n\u0010\u0019\u001a\u00060\u0014j\u0002`\u0015H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u001a2\n\u0010\u0019\u001a\u00060\u0014j\u0002`\u0015H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u00060\u0014j\u0002`\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/stepos/ailauncher/speech/tts/j;", "", "<init>", "()V", "", "text", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_UMID, "()Ljava/lang/String;", "", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/CharSequence;)I", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/CharSequence;)Z", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/StringBuilder;", "raw", "out", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/StringBuilder;)V", "e", "(Ljava/lang/StringBuilder;)V", "line", "f", "(Ljava/lang/String;)Z", "Lkotlin/text/Regex;", "SEPARATOR_LINE", "Lkotlin/text/Regex;", "TABLE_PIPE_THRESHOLD", "I", "carry", "Ljava/lang/StringBuilder;", "inTable", "Z", "pendingSinglePipeLine", "Ljava/lang/String;", "Companion", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Regex SEPARATOR_LINE = new Regex("^[\\s|｜:\\-+]+$");
    private final int TABLE_PIPE_THRESHOLD = 2;
    private final StringBuilder carry = new StringBuilder();
    private boolean inTable;
    private String pendingSinglePipeLine;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/j$a;", "", "<init>", "()V", "", "text", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.speech.tts.j$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final String a(String text) {
            kotlin.jvm.internal.p.i(text, "text");
            j jVar = new j();
            return jVar.a(text) + jVar.d();
        }

        public Companion() {
        }
    }

    public final String a(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        if (text.length() == 0 && this.carry.length() == 0) {
            return "";
        }
        this.carry.append(text);
        String string = b().toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return H.G1(string, ' ', '\t');
    }

    public final StringBuilder b() {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String strK = k();
            if (strK == null) {
                return sb2;
            }
            h(strK, sb2);
        }
    }

    public final boolean c(CharSequence charSequence) {
        return H.k0(charSequence, "|", false, 2, null) || H.k0(charSequence, "｜", false, 2, null);
    }

    public final String d() {
        StringBuilder sb2 = new StringBuilder();
        String string = this.carry.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        if (string.length() > 0) {
            z.q(this.carry);
            h(string, sb2);
        }
        e(sb2);
        this.inTable = false;
        String string2 = sb2.toString();
        kotlin.jvm.internal.p.h(string2, "toString(...)");
        return H.F1(string2).toString();
    }

    public final void e(StringBuilder out) {
        String str = this.pendingSinglePipeLine;
        if (str == null) {
            return;
        }
        this.pendingSinglePipeLine = null;
        out.append(j(str));
        out.append('\n');
    }

    public final boolean f(String line) {
        return i(line) || this.SEPARATOR_LINE.k(line) || g(line) >= this.TABLE_PIPE_THRESHOLD || (g(line) >= 1 && c(line));
    }

    public final int g(CharSequence charSequence) {
        int i10 = 0;
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt == '|' || cCharAt == 65372) {
                i10++;
            }
        }
        return i10;
    }

    public final void h(String raw, StringBuilder out) {
        String string = H.D1(raw).toString();
        if (string.length() > 0 && this.SEPARATOR_LINE.k(string)) {
            this.pendingSinglePipeLine = null;
            this.inTable = true;
            return;
        }
        e(out);
        if (f(string)) {
            this.inTable = true;
            return;
        }
        if (!this.inTable || g(string) < 1) {
            if (!this.inTable && g(string) == 1) {
                this.pendingSinglePipeLine = raw;
                return;
            }
            out.append(j(raw));
            out.append('\n');
            if (this.inTable) {
                this.inTable = false;
            }
        }
    }

    public final boolean i(CharSequence charSequence) {
        return H.j1(charSequence, "|", false, 2, null) || H.j1(charSequence, "｜", false, 2, null);
    }

    public final String j(String str) {
        return D.T(D.T(str, "|", "", false, 4, null), "｜", "", false, 4, null);
    }

    public final String k() {
        int i10;
        int length = this.carry.length();
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i10 = 0;
                break;
            }
            char cCharAt = this.carry.charAt(i11);
            i10 = 1;
            if (cCharAt == '\n') {
                break;
            }
            if (cCharAt == '\r') {
                int i12 = i11 + 1;
                if (i12 < length && this.carry.charAt(i12) == '\n') {
                    i10 = 2;
                }
            } else {
                i11++;
            }
        }
        if (i10 == 0) {
            return null;
        }
        String strSubstring = this.carry.substring(0, i11);
        this.carry.delete(0, i11 + i10);
        return strSubstring;
    }
}
