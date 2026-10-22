package com.stepos.agentframework.chatui.util;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u001a!\u0010\u0003\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "systemFontScale", "contextFontScale", Const.INTENT_KEY_PKGNAME, "(FF)Ljava/lang/Float;", "", "systemNightMode", "contextUiMode", Const.INTENT_KEY_APIKEY, "(II)Ljava/lang/Integer;", "agentcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class s {
    public static final Integer a(int i10, int i11) {
        int i12;
        if (i10 == 1) {
            i12 = 16;
        } else {
            if (i10 != 2) {
                return null;
            }
            i12 = 32;
        }
        Integer numValueOf = Integer.valueOf(i12);
        if (numValueOf.intValue() != (i11 & 48)) {
            return numValueOf;
        }
        return null;
    }

    public static final Float b(float f10, float f11) {
        if (f10 <= 0.0f || f11 <= 0.0f || f10 == f11) {
            return null;
        }
        return Float.valueOf(f10);
    }
}
