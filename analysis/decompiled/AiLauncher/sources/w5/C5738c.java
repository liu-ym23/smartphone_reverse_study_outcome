package w5;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lw5/c;", "", "<init>", "()V", "", "chatPageShowing", "expandedPanel", "panelContentHidden", Const.INTENT_KEY_APIKEY, "(ZZZ)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: w5.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5738c {
    public static final C5738c INSTANCE = new C5738c();

    public final boolean a(boolean chatPageShowing, boolean expandedPanel, boolean panelContentHidden) {
        return chatPageShowing && expandedPanel && !panelContentHidden;
    }
}
