package com.stepos.ailauncher.chat.activity;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0017\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0019\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/s0;", "", "", "background", "covered", "recentsPeek", "<init>", "(ZZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getBackground", "()Z", "getCovered", "getRecentsPeek", Const.INTENT_KEY_APIKEY, "chrome", Const.INTENT_KEY_PKGNAME, "panel", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.activity.s0, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class ChatGlassSuspension {
    private final boolean background;
    private final boolean covered;
    private final boolean recentsPeek;

    public ChatGlassSuspension(boolean z10, boolean z11, boolean z12) {
        this.background = z10;
        this.covered = z11;
        this.recentsPeek = z12;
    }

    public final boolean a() {
        return this.background || this.covered;
    }

    public final boolean b() {
        return a() || this.recentsPeek;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatGlassSuspension)) {
            return false;
        }
        ChatGlassSuspension chatGlassSuspension = (ChatGlassSuspension) other;
        return this.background == chatGlassSuspension.background && this.covered == chatGlassSuspension.covered && this.recentsPeek == chatGlassSuspension.recentsPeek;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.background) * 31) + Boolean.hashCode(this.covered)) * 31) + Boolean.hashCode(this.recentsPeek);
    }

    public String toString() {
        return "ChatGlassSuspension(background=" + this.background + ", covered=" + this.covered + ", recentsPeek=" + this.recentsPeek + ")";
    }
}
