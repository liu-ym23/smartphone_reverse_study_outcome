package com.stepos.ailauncher.task.space.credential;

import Ua.C1056g;
import Ua.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.account.AccountInfo;
import e9.InterfaceC4014c;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\rH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/CredentialApi;", "", "<init>", "()V", "Lcom/stepos/ailauncher/task/space/credential/g;", Const.INTENT_KEY_UMID, "(Le9/c;)Ljava/lang/Object;", "", "vendorId", "Lcom/stepos/ailauncher/task/space/credential/f;", "c", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "integrationId", "", "fields", "Lcom/stepos/ailauncher/task/space/credential/s;", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Le9/c;)Ljava/lang/Object;", "", "e", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "TAG", "Ljava/lang/String;", "BASE_URL_KEY", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CredentialApi {
    public static final String BASE_URL_KEY = "credential";
    public static final CredentialApi INSTANCE = new CredentialApi();
    private static final String TAG = "AILauncher-CredentialApi";

    public final String b() {
        String token;
        AccountInfo accountInfoL = com.stepos.ailauncher.foundation.account.f.INSTANCE.l();
        if (accountInfoL == null || (token = accountInfoL.getToken()) == null) {
            token = "";
        }
        if (token.length() <= 0) {
            return "";
        }
        return "Bearer " + token;
    }

    public final Object c(String str, InterfaceC4014c<? super CredentialItem> interfaceC4014c) {
        return C1056g.j(Y.b(), new CredentialApi$getCredentialDetail$2(str, null), interfaceC4014c);
    }

    public final Object d(InterfaceC4014c<? super CredentialListData> interfaceC4014c) {
        return C1056g.j(Y.b(), new CredentialApi$getCredentialList$2(null), interfaceC4014c);
    }

    public final Object e(String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C1056g.j(Y.b(), new CredentialApi$revokeCredential$2(str, null), interfaceC4014c);
    }

    public final Object f(String str, String str2, Map<String, String> map, InterfaceC4014c<? super SaveCredentialData> interfaceC4014c) {
        return C1056g.j(Y.b(), new CredentialApi$saveCredential$2(str, str2, map, null), interfaceC4014c);
    }
}
