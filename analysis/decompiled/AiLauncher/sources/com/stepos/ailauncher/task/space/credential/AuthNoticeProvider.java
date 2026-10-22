package com.stepos.ailauncher.task.space.credential;

import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/AuthNoticeProvider;", "", "", "agreementUrl", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getAgreementUrl", "()Ljava/lang/String;", "Companion", Const.INTENT_KEY_APIKEY, "WECHAT", "ALIPAY", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AuthNoticeProvider {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ AuthNoticeProvider[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String agreementUrl;
    public static final AuthNoticeProvider WECHAT = new AuthNoticeProvider("WECHAT", 0, "https://support.weixin.qq.com/cgi-bin/mmsupportacctnodeweb-bin/pages/HBS2pZuIGJqUG0cC");
    public static final AuthNoticeProvider ALIPAY = new AuthNoticeProvider("ALIPAY", 1, "https://render.alipay.com/p/c/180021120000001810/index.html?agreementId=AG01001781");

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/AuthNoticeProvider$a;", "", "<init>", "()V", "", "vendorId", "Lcom/stepos/ailauncher/task/space/credential/AuthNoticeProvider;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ailauncher/task/space/credential/AuthNoticeProvider;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.credential.AuthNoticeProvider$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AuthNoticeProvider a(String vendorId) {
            kotlin.jvm.internal.p.i(vendorId, "vendorId");
            if (La.D.L(vendorId, "wechat", true) || La.D.L(vendorId, "weixin", true)) {
                return AuthNoticeProvider.WECHAT;
            }
            if (La.D.L(vendorId, "alipay", true)) {
                return AuthNoticeProvider.ALIPAY;
            }
            return null;
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ AuthNoticeProvider[] $values() {
        return new AuthNoticeProvider[]{WECHAT, ALIPAY};
    }

    static {
        AuthNoticeProvider[] authNoticeProviderArr$values = $values();
        $VALUES = authNoticeProviderArr$values;
        $ENTRIES = kotlin.enums.a.a(authNoticeProviderArr$values);
        INSTANCE = new Companion(null);
    }

    private AuthNoticeProvider(String str, int i10, String str2) {
        this.agreementUrl = str2;
    }

    public static InterfaceC4149a<AuthNoticeProvider> getEntries() {
        return $ENTRIES;
    }

    public static AuthNoticeProvider valueOf(String str) {
        return (AuthNoticeProvider) Enum.valueOf(AuthNoticeProvider.class, str);
    }

    public static AuthNoticeProvider[] values() {
        return (AuthNoticeProvider[]) $VALUES.clone();
    }

    public final String getAgreementUrl() {
        return this.agreementUrl;
    }
}
