package com.stepos.ability.common;

import U3.a;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\u0018\u00002\u00060\u0001j\u0002`\u0002B)\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ability/common/AbilityException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "LU3/a;", "error", "", "customMsg", "", "cause", "<init>", "(LU3/a;Ljava/lang/String;Ljava/lang/Throwable;)V", Const.INTENT_KEY_APIKEY, "LU3/a;", "getError", "()LU3/a;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "getCustomMsg", "()Ljava/lang/String;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AbilityException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final a error;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String customMsg;

    public /* synthetic */ AbilityException(a aVar, String str, Throwable th, int i10, i iVar) {
        this(aVar, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityException(a error, String str, Throwable th) {
        super("[" + error.getCode() + "] " + (str == null ? error.getMsg() : str), th);
        p.i(error, "error");
        this.error = error;
        this.customMsg = str;
    }
}
