package com.stepos.ailauncher.debug;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import h8.C4148a;
import kotlin.Metadata;
import o6.C5009a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/debug/a;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, "", Const.INTENT_KEY_PKGNAME, "()Z", "", "TAG", "Ljava/lang/String;", "MMKV_ID", "KEY_PUSH_RAW_PAYLOAD_DUMP", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final String KEY_PUSH_RAW_PAYLOAD_DUMP = "push_raw_payload_dump";
    private static final String MMKV_ID = "agentframework_debug";
    private static final String TAG = "AgentFrameworkDebugConfig";

    public final void a() {
        boolean zB = b();
        ChatCoreSdk.INSTANCE.b(zB);
        C4148a.k(TAG, "applyFromStorage pushRawPayloadDump=" + zB, false, 4, null);
    }

    public final boolean b() {
        C5009a c5009a = C5009a.INSTANCE;
        if (c5009a.c(MMKV_ID, KEY_PUSH_RAW_PAYLOAD_DUMP)) {
            return c5009a.h(MMKV_ID, KEY_PUSH_RAW_PAYLOAD_DUMP, false);
        }
        return false;
    }
}
