package com.stepos.agentframework.chatui.longtext;

import La.H;
import La.K;
import La.m;
import Yb.u;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.longtext.LongTextDocument;
import com.stepos.agentframework.chatui.longtext.c;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010!¨\u0006#"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/b;", "", "<init>", "()V", "", "source", "", "k", "(Ljava/lang/String;)Z", "Lkotlin/Function0;", "LY8/t;", "checkCancelled", "Lcom/stepos/agentframework/chatui/longtext/c;", "e", "(Ljava/lang/String;Lp9/a;)Lcom/stepos/agentframework/chatui/longtext/c;", Const.INTENT_KEY_PKGNAME, "text", "c", "", "codePoint", Const.INTENT_KEY_UMID, "(I)Z", "offset", "l", "(Ljava/lang/String;I)Z", "THRESHOLD", "I", "MULTI_SCREEN_THRESHOLD", "LINE_THRESHOLD", "BLOCK_CHARS", "HARD_LIMIT", "Lkotlin/text/Regex;", "fencedCode", "Lkotlin/text/Regex;", "singleDollarMath", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class b {
    public static final int BLOCK_CHARS = 384;
    public static final int HARD_LIMIT = 512;
    public static final int LINE_THRESHOLD = 48;
    public static final int MULTI_SCREEN_THRESHOLD = 3072;
    public static final int THRESHOLD = 8192;
    public static final b INSTANCE = new b();
    private static final Regex fencedCode = new Regex("(?m)^[ \\t]*(`{3,}|~{3,}).*?\\n[\\s\\S]*?^[ \\t]*\\1[ \\t]*$");
    private static final Regex singleDollarMath = new Regex("(?<![\\\\$])\\$(?!\\$)([^$\\n]+?)\\$(?!\\$)");

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Integer.valueOf(((LongTextDocument.Style) t10).getStart()), Integer.valueOf(((LongTextDocument.Style) t11).getStart()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x055c  */
    /* JADX WARN: Type inference failed for: r4v8, types: [T, com.stepos.agentframework.uikit.G] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean f(p9.InterfaceC5063a<Y8.t> r23, java.lang.StringBuilder r24, java.util.LinkedHashMap<java.lang.Integer, kotlin.Pair<java.lang.Integer, com.stepos.agentframework.chatui.longtext.LongTextDocument.CodeBlock>> r25, kotlin.jvm.internal.Ref$ObjectRef<com.stepos.agentframework.uikit.G> r26, java.util.IdentityHashMap<Yb.v, java.lang.Integer> r27, java.util.ArrayList<com.stepos.agentframework.chatui.longtext.LongTextDocument.Style> r28, kotlin.jvm.internal.Ref$ObjectRef<com.stepos.agentframework.chatui.longtext.c.Fallback> r29, java.util.LinkedHashMap<java.lang.Integer, kotlin.Pair<java.lang.Integer, com.stepos.agentframework.chatui.longtext.LongTextDocument.TableRow>> r30, Yb.u r31, int r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.longtext.b.f(p9.a, java.lang.StringBuilder, java.util.LinkedHashMap, kotlin.jvm.internal.Ref$ObjectRef, java.util.IdentityHashMap, java.util.ArrayList, kotlin.jvm.internal.Ref$ObjectRef, java.util.LinkedHashMap, Yb.u, int):boolean");
    }

    public static final boolean g(Ref$IntRef ref$IntRef, LongTextDocument.Style it) {
        p.i(it, "it");
        return it.getEnd() <= ref$IntRef.f34818a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.stepos.agentframework.chatui.longtext.c$a] */
    public static final boolean h(Ref$ObjectRef<c.Fallback> ref$ObjectRef, LongTextFallbackReason longTextFallbackReason, u uVar, String str) {
        String simpleName = uVar.getClass().getSimpleName();
        p.h(simpleName, "getSimpleName(...)");
        ref$ObjectRef.f34820a = new c.Fallback(longTextFallbackReason, simpleName, str);
        return false;
    }

    public static /* synthetic */ boolean i(Ref$ObjectRef ref$ObjectRef, LongTextFallbackReason longTextFallbackReason, u uVar, String str, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str = "";
        }
        return h(ref$ObjectRef, longTextFallbackReason, uVar, str);
    }

    public static final void j(StringBuilder sb2) {
        if (sb2.length() > 0) {
            if (K.P1(sb2) != '\n') {
                sb2.append('\n');
            }
            if (sb2.length() < 2 || sb2.charAt(sb2.length() - 2) != '\n') {
                sb2.append('\n');
            }
        }
    }

    public final boolean b(String source) {
        int last = 0;
        if (!H.f0(source, '$', false, 2, null) && !H.g0(source, "\\(", false, 2, null) && !H.g0(source, "\\[", false, 2, null)) {
            return false;
        }
        for (m mVar : Regex.f(fencedCode, source, 0, 2, null)) {
            String strSubstring = source.substring(last, mVar.a().getFirst());
            p.h(strSubstring, "substring(...)");
            if (c(strSubstring)) {
                return true;
            }
            last = mVar.a().getLast() + 1;
        }
        String strSubstring2 = source.substring(last);
        p.h(strSubstring2, "substring(...)");
        return c(strSubstring2);
    }

    public final boolean c(String text) {
        if (H.g0(text, "$$", false, 2, null) || singleDollarMath.b(text)) {
            return true;
        }
        if (H.g0(text, "\\(", false, 2, null) && H.g0(text, "\\)", false, 2, null)) {
            return true;
        }
        return H.g0(text, "\\[", false, 2, null) && H.g0(text, "\\]", false, 2, null);
    }

    public final boolean d(int codePoint) {
        int type;
        if (127995 <= codePoint && codePoint < 128000) {
            return true;
        }
        if (917536 > codePoint || codePoint >= 917632) {
            return (917760 <= codePoint && codePoint < 918000) || codePoint == 65039 || (type = Character.getType(codePoint)) == 6 || type == 7 || type == 8;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x009c. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0419 A[LOOP:8: B:176:0x0413->B:178:0x0419, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0147  */
    /* JADX WARN: Type inference failed for: r10v0, types: [T, com.stepos.agentframework.chatui.longtext.c$a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.agentframework.chatui.longtext.c e(java.lang.String r31, p9.InterfaceC5063a<Y8.t> r32) {
        /*
            Method dump skipped, instructions count: 1264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.longtext.b.e(java.lang.String, p9.a):com.stepos.agentframework.chatui.longtext.c");
    }

    public final boolean k(String source) {
        p.i(source, "source");
        if (source.length() >= 3072) {
            return true;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < source.length(); i11++) {
            if (source.charAt(i11) == '\n') {
                i10++;
            }
        }
        return i10 >= 48 || com.stepos.agentframework.uikit.H.INSTANCE.c(source);
    }

    public final boolean l(String text, int offset) {
        int iCodePointAt = text.codePointAt(offset);
        if (127462 <= iCodePointAt && iCodePointAt < 127488) {
            int i10 = 0;
            while (offset > 0) {
                int iCodePointBefore = text.codePointBefore(offset);
                if (127462 > iCodePointBefore || iCodePointBefore >= 127488) {
                    break;
                }
                offset -= 2;
                i10++;
            }
            if (i10 % 2 != 0) {
                return true;
            }
        }
        return false;
    }
}
