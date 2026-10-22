package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.ModelDownloaderBundle;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010\n¨\u0006$"}, d2 = {"LK6/a;", "", "<init>", "()V", "", "name", "Ljava/lang/String;", "c", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)V", "iconUrl", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_COMMAND, "", "suggested_questions", "Ljava/util/List;", "e", "()Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/List;)V", "prologue", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "botId", Const.INTENT_KEY_APIKEY, "f", "", "is_voice_call_closed", "Z", "()Z", "k", "(Z)V", ModelDownloaderBundle.KEY_MODEL_NAME, "getModel_name", "setModel_name", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0905a {
    private String botId;
    private String iconUrl;
    private boolean is_voice_call_closed;
    private String model_name;
    private String name;
    private String prologue;
    private List<String> suggested_questions;

    /* renamed from: a, reason: from getter */
    public final String getBotId() {
        return this.botId;
    }

    /* renamed from: b, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: d, reason: from getter */
    public final String getPrologue() {
        return this.prologue;
    }

    public final List<String> e() {
        return this.suggested_questions;
    }

    public final void f(String str) {
        this.botId = str;
    }

    public final void g(String str) {
        this.iconUrl = str;
    }

    public final void h(String str) {
        this.name = str;
    }

    public final void i(String str) {
        this.prologue = str;
    }

    public final void j(List<String> list) {
        this.suggested_questions = list;
    }

    public final void k(boolean z10) {
        this.is_voice_call_closed = z10;
    }
}
