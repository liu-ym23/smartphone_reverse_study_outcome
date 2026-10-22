package com.stepos.ailauncher.chat.wake;

import android.content.Context;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.common.utils.C3197a;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/t;", "Lcom/stepos/ailauncher/chat/wake/N1;", "<init>", "()V", "Landroid/content/Context;", "context", "", "source", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)Z", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.t, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3163t implements N1 {
    public static final C3163t INSTANCE = new C3163t();
    private static final String name = "Landscape";

    @Override // com.stepos.ailauncher.chat.wake.N1
    public boolean a(Context context, String source) {
        kotlin.jvm.internal.p.i(context, "context");
        if (context.getResources().getConfiguration().orientation != 2) {
            return true;
        }
        C4148a.d("WakeGuard", "Landscape: skip dialog", false, 4, null);
        Toast.makeText(C3197a.INSTANCE.a(), R$string.rotate_first, 0).show();
        return false;
    }

    @Override // com.stepos.ailauncher.chat.wake.N1
    public String getName() {
        return name;
    }
}
