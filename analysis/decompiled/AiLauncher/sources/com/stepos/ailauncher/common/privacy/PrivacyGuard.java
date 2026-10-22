package com.stepos.ailauncher.common.privacy;

import Ua.C1056g;
import Ua.Y;
import Y8.h;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import mobile.Guard;
import mobile.Mobile;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/common/privacy/PrivacyGuard;", "", "<init>", "()V", "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "e", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "Lmobile/Guard;", "guard$delegate", "LY8/h;", "c", "()Lmobile/Guard;", "guard", "privacy_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PrivacyGuard {
    private static final String TAG = "AILauncher-PrivacyGuard";
    public static final PrivacyGuard INSTANCE = new PrivacyGuard();

    /* renamed from: guard$delegate, reason: from kotlin metadata */
    private static final h guard = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.privacy.c
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return PrivacyGuard.d();
        }
    });

    public static final Guard d() {
        return Mobile.newGuard(2L, 4L);
    }

    public final Guard c() {
        Object value = guard.getValue();
        p.h(value, "getValue(...)");
        return (Guard) value;
    }

    public final Object e(String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C1056g.j(Y.a(), new PrivacyGuard$isContentSafe$2(str, null), interfaceC4014c);
    }
}
