package com.stepos.agentframework.chatcore.audit;

import Y8.t;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.R$string;
import com.stepos.net.HttpManager;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u001a\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003R$\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0013R\"\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0013R\"\u0010!\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0013R\"\u0010$\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\r\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0013R\"\u0010'\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0013R\"\u0010*\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0016\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR\u0016\u0010-\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010\u0016¨\u0006."}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/k;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", UxipConstants.f30680s, "baseUrl", "Ljava/lang/String;", "getBaseUrl", "()Ljava/lang/String;", "bizType", Const.INTENT_KEY_APIKEY, "setBizType", "(Ljava/lang/String;)V", "", "onlyMachineAudit", "Z", "e", "()Z", "setOnlyMachineAudit", "(Z)V", "blockReplyText", Const.INTENT_KEY_PKGNAME, "setBlockReplyText", "errorReplyText", Const.INTENT_KEY_UMID, "setErrorReplyText", "serviceErrorReplyText", Const.INTENT_KEY_BACKGROUND_COMMAND, "setServiceErrorReplyText", "revertToastText", "f", "setRevertToastText", "uploadBlockToastText", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "setUploadBlockToastText", x5.d.EXTRA_ENABLED, "c", "setEnabled", "initialized", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class k {
    private static volatile boolean initialized;
    public static final k INSTANCE = new k();
    private static volatile String baseUrl = "";
    private static volatile String bizType = "clawphone";
    private static volatile boolean onlyMachineAudit = true;
    private static volatile String blockReplyText = "";
    private static volatile String errorReplyText = "";
    private static volatile String serviceErrorReplyText = "";
    private static volatile String revertToastText = "";
    private static volatile String uploadBlockToastText = "";
    private static volatile boolean enabled = true;

    public final String a() {
        return bizType;
    }

    public final String b() {
        return blockReplyText;
    }

    public final boolean c() {
        return enabled;
    }

    public final String d() {
        return errorReplyText;
    }

    public final boolean e() {
        return onlyMachineAudit;
    }

    public final String f() {
        return revertToastText;
    }

    public final String g() {
        return serviceErrorReplyText;
    }

    public final String h() {
        return uploadBlockToastText;
    }

    public final void i(Context context) {
        p.i(context, "context");
        if (initialized) {
            return;
        }
        synchronized (this) {
            if (initialized) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            baseUrl = C4.a.INSTANCE.a(applicationContext).a();
            String string = applicationContext.getString(R$string.audit_block_reply);
            p.h(string, "getString(...)");
            blockReplyText = string;
            String string2 = applicationContext.getString(R$string.audit_error_reply);
            p.h(string2, "getString(...)");
            errorReplyText = string2;
            String string3 = applicationContext.getString(R$string.audit_service_error);
            p.h(string3, "getString(...)");
            serviceErrorReplyText = string3;
            String string4 = applicationContext.getString(R$string.audit_revert_toast);
            p.h(string4, "getString(...)");
            revertToastText = string4;
            String string5 = applicationContext.getString(R$string.audit_upload_block_toast);
            p.h(string5, "getString(...)");
            uploadBlockToastText = string5;
            INSTANCE.j();
            initialized = true;
            t tVar = t.f7040a;
        }
    }

    public final void j() {
        if (baseUrl.length() <= 0 || !HttpManager.isInitialized()) {
            return;
        }
        HttpManager.INSTANCE.addBaseUrl("audit_base_url_key", baseUrl);
    }
}
