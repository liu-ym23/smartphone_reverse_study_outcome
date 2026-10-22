package com.stepos.ailauncher.chat.manager;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import r4.C5218a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/i;", "", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.manager.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2700i {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_TASK_ID = "task_id";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/i$a;", "", "<init>", "()V", "", "key", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "KEY_TASK_ID", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.manager.i$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(String key, String value) {
            kotlin.jvm.internal.p.i(key, "key");
            kotlin.jvm.internal.p.i(value, "value");
            C5218a.Companion companion = C5218a.INSTANCE;
            if (companion.b() == null) {
                companion.c(new LinkedHashMap());
            }
            Map<String, String> mapB = companion.b();
            if (!kotlin.jvm.internal.z.q(mapB)) {
                mapB = null;
            }
            if (mapB != null) {
                mapB.put(key, value);
            }
        }

        public final void b(String key) {
            kotlin.jvm.internal.p.i(key, "key");
            Map<String, String> mapB = C5218a.INSTANCE.b();
            if (!kotlin.jvm.internal.z.q(mapB)) {
                mapB = null;
            }
            if (mapB != null) {
                mapB.remove(key);
            }
        }

        public Companion() {
        }
    }
}
