package com.stepos.stepclaw.base.net;

import b5.l;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.net.bean.StepOSCredentials;
import com.stepos.stepclaw.base.net.bean.StepOSHeaders;
import com.stepos.stepclaw.base.util.HmacSha256Utils;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0007\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u001e\u0010\u0005\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/Function0;", "Lcom/stepos/stepclaw/base/net/bean/StepOSCredentials;", "credentialsProvider", "Lb5/l;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "baseProvider", "Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;", "signingProvider", "(Lp5/a;Lp5/a;)Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;", "step-base_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StepOSHeadersProviderKt {
    public static final StepOSHeadersProvider signingProvider(final p5.a credentialsProvider, final p5.a baseProvider) {
        p.e(credentialsProvider, "credentialsProvider");
        p.e(baseProvider, "baseProvider");
        return new StepOSHeadersProvider() { // from class: com.stepos.stepclaw.base.net.a
            @Override // com.stepos.stepclaw.base.net.StepOSHeadersProvider
            public final StepOSHeaders provide() {
                return StepOSHeadersProviderKt.signingProvider$lambda$0(credentialsProvider, baseProvider);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepOSHeaders signingProvider$lambda$0(p5.a aVar, p5.a aVar2) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        StepOSCredentials stepOSCredentials = (StepOSCredentials) aVar.invoke();
        l lVar = (l) aVar2.invoke();
        String str = (String) lVar.f902a;
        String str2 = (String) lVar.f903b;
        String str3 = (String) lVar.f904c;
        String string = UUID.randomUUID().toString();
        p.d(string, "toString(...)");
        String strA1 = u.a1(string, "-", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        String strValueOf = String.valueOf(System.currentTimeMillis());
        return new StepOSHeaders(str, str2, str3, stepOSCredentials.getAppId(), strA1, strValueOf, HmacSha256Utils.INSTANCE.sign(stepOSCredentials.getAppId() + strA1 + strValueOf + stepOSCredentials.getAppSecret(), stepOSCredentials.getAppSecret()));
    }
}
