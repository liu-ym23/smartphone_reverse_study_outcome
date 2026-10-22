package com.stepos.ailauncher.speech.tts;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/h;", "", "", "text", "", "consumed", "<init>", "(Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "I", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.speech.tts.h, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class FeedSlice {
    private final int consumed;
    private final String text;

    public FeedSlice(String text, int i10) {
        kotlin.jvm.internal.p.i(text, "text");
        this.text = text;
        this.consumed = i10;
    }

    /* renamed from: a, reason: from getter */
    public final int getConsumed() {
        return this.consumed;
    }

    /* renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedSlice)) {
            return false;
        }
        FeedSlice feedSlice = (FeedSlice) other;
        return kotlin.jvm.internal.p.d(this.text, feedSlice.text) && this.consumed == feedSlice.consumed;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + Integer.hashCode(this.consumed);
    }

    public String toString() {
        return "FeedSlice(text=" + this.text + ", consumed=" + this.consumed + ")";
    }
}
