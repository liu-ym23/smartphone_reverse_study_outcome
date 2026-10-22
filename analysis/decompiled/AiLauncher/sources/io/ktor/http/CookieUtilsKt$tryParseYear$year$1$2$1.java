package io.ktor.http;

import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
/* loaded from: classes4.dex */
public final class CookieUtilsKt$tryParseYear$year$1$2$1 implements InterfaceC5074l<Character, Boolean> {
    public static final CookieUtilsKt$tryParseYear$year$1$2$1 INSTANCE = new CookieUtilsKt$tryParseYear$year$1$2$1();

    public final Boolean invoke(char c10) {
        return Boolean.valueOf(CookieUtilsKt.isDigit(c10));
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
        return invoke(ch.charValue());
    }
}
