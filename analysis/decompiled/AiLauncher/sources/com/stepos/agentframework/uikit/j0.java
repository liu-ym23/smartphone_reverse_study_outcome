package com.stepos.agentframework.uikit;

import android.graphics.Bitmap;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.stepos.ame.sdk.SkillStoreKt;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0007J\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u000bJ)\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u001d¨\u0006$"}, d2 = {"Lcom/stepos/agentframework/uikit/j0;", "", "<init>", "()V", "", "markdown", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Ljava/lang/String;", "destination", "", "e", "(Ljava/lang/String;)Z", Const.INTENT_KEY_PKGNAME, SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "sizePx", "Landroid/graphics/Bitmap;", "c", "(Ljava/lang/String;I)Landroid/graphics/Bitmap;", "alt", "dest", "f", "(Ljava/lang/String;Ljava/lang/String;)Z", Const.INTENT_KEY_UMID, "imageStart", "imageEnd", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;II)Ljava/lang/String;", "SCHEME", "Ljava/lang/String;", "Lkotlin/text/Regex;", "SANDBOX_IMAGE_REGEX", "Lkotlin/text/Regex;", "URL_REGEX", "QR_HINT_REGEX", "URL_TRAILING_PUNCT", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class j0 {
    public static final String SCHEME = "amoo-qr:";
    private static final String URL_TRAILING_PUNCT = ".,;:!?*_～~。，；：！？";
    public static final j0 INSTANCE = new j0();
    private static final Regex SANDBOX_IMAGE_REGEX = new Regex("!\\[([^\\]\\n]*)\\]\\(\\s*(file://[^)\\s]+|/[^)\\s]+)(?:\\s+\"[^\"]*\")?\\s*\\)");
    private static final Regex URL_REGEX = new Regex("https?://[^\\s<>()\\[\\]\"'`]+");
    private static final Regex QR_HINT_REGEX = new Regex("(?i)qr|二维码|qrcode");

    public static final String h(final String markdown) {
        kotlin.jvm.internal.p.i(markdown, "markdown");
        return !La.H.g0(markdown, "![", false, 2, null) ? markdown : SANDBOX_IMAGE_REGEX.m(markdown, new InterfaceC5074l() { // from class: com.stepos.agentframework.uikit.i0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return j0.i(markdown, (La.m) obj);
            }
        });
    }

    public static final CharSequence i(String str, La.m m10) throws UnsupportedEncodingException {
        kotlin.jvm.internal.p.i(m10, "m");
        String str2 = m10.c().get(1);
        String str3 = m10.c().get(2);
        j0 j0Var = INSTANCE;
        if (!j0Var.f(str2, str3) || j0Var.d(str3)) {
            return m10.getValue();
        }
        String strG = j0Var.g(str, m10.a().getFirst(), m10.a().getLast() + 1);
        if (strG == null) {
            return m10.getValue();
        }
        return "![" + str2 + "](amoo-qr:" + URLEncoder.encode(strG, "UTF-8") + ")";
    }

    public final String b(String destination) throws UnsupportedEncodingException {
        kotlin.jvm.internal.p.i(destination, "destination");
        String strSubstring = destination.substring(8);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        String strDecode = URLDecoder.decode(strSubstring, "UTF-8");
        kotlin.jvm.internal.p.h(strDecode, "decode(...)");
        return strDecode;
    }

    public final Bitmap c(String content, int sizePx) {
        Object objB;
        kotlin.jvm.internal.p.i(content, "content");
        try {
            Result.Companion companion = Result.INSTANCE;
            D3.b bVarA = new A3.b().a(content, BarcodeFormat.QR_CODE, sizePx, sizePx, kotlin.collections.a.m(Y8.j.a(EncodeHintType.CHARACTER_SET, "UTF-8"), Y8.j.a(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M), Y8.j.a(EncodeHintType.MARGIN, 4)));
            int i10 = bVarA.i();
            int iH = bVarA.h();
            int[] iArr = new int[i10 * iH];
            for (int i11 = 0; i11 < iH; i11++) {
                int i12 = i11 * i10;
                for (int i13 = 0; i13 < i10; i13++) {
                    iArr[i12 + i13] = bVarA.g(i13, i11) ? -16777216 : -1;
                }
            }
            objB = Result.b(Bitmap.createBitmap(iArr, i10, iH, Bitmap.Config.ARGB_8888));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (Bitmap) objB;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean d(String dest) {
        Object objB;
        String strB;
        if (La.D.X(dest, "file://", false, 2, null)) {
            String strR0 = La.H.R0(dest, "file://");
            String strSubstring = strR0.substring(C5685n.f(La.H.t0(strR0, JsonPointer.SEPARATOR, 0, false, 6, null), 0));
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            try {
                Result.Companion companion = Result.INSTANCE;
                strB = Result.b(URLDecoder.decode(strSubstring, "UTF-8"));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                strB = Result.b(C4849c.a(th));
            }
            if (!Result.g(strB)) {
                strSubstring = strB;
            }
            dest = strSubstring;
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(new File(dest).exists()));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean e(String destination) {
        return destination != null && La.D.X(destination, SCHEME, false, 2, null);
    }

    public final boolean f(String alt, String dest) {
        Regex regex = QR_HINT_REGEX;
        return regex.b(alt) || regex.b(La.H.s1(dest, JsonPointer.SEPARATOR, null, 2, null));
    }

    public final String g(String markdown, int imageStart, int imageEnd) {
        CharSequence charSequenceSubSequence;
        Regex regex = URL_REGEX;
        String strSubstring = markdown.substring(0, imageStart);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        La.m mVarC = (La.m) SequencesKt___SequencesKt.Q(Regex.f(regex, strSubstring, 0, 2, null));
        if (mVarC == null && (mVarC = regex.c(markdown, imageEnd)) == null) {
            return null;
        }
        String value = mVarC.getValue();
        int length = value.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (!La.H.f0(URL_TRAILING_PUNCT, value.charAt(length), false, 2, null)) {
                    charSequenceSubSequence = value.subSequence(0, length + 1);
                    break;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
            charSequenceSubSequence = "";
        } else {
            charSequenceSubSequence = "";
        }
        String string = charSequenceSubSequence.toString();
        if (string.length() > 8) {
            return string;
        }
        return null;
    }
}
