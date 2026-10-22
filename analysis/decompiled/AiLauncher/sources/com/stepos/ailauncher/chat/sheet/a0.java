package com.stepos.ailauncher.chat.sheet;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/a0;", "", "<init>", "()V", "", "baseActivityClassName", "baseIntentClassName", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Z", "PICK_FILE_MEDIATOR_ACTIVITY", "Ljava/lang/String;", "TRANSFER_ACTIVITY", "PERMISSION_PROXY_ACTIVITY", "", "OWNED_ROOTS", "Ljava/util/Set;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a0 {
    public static final a0 INSTANCE = new a0();
    private static final String PICK_FILE_MEDIATOR_ACTIVITY = "com.stepos.ailauncher.chat.PickFileMediatorActivity";
    private static final String TRANSFER_ACTIVITY = "com.stepos.ailauncher.chat.TransferActivity";
    private static final String PERMISSION_PROXY_ACTIVITY = "com.stepos.ailauncher.common.permission.PermissionProxyActivity";
    private static final Set<String> OWNED_ROOTS = Z8.Y.j(PICK_FILE_MEDIATOR_ACTIVITY, TRANSFER_ACTIVITY, PERMISSION_PROXY_ACTIVITY);

    public final boolean a(String baseActivityClassName, String baseIntentClassName) {
        Set<String> set = OWNED_ROOTS;
        return Z8.F.f0(set, baseActivityClassName) || Z8.F.f0(set, baseIntentClassName);
    }
}
