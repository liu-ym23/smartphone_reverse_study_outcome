package com.stepos.core.data;

import L.g;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.core.data.base.Content;
import d5.t;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/core/data/SessionCommandContent;", "Lcom/stepos/core/data/base/Content;", "Landroid/os/Bundle;", "payload", AppAgent.CONSTRUCT, "(Landroid/os/Bundle;)V", "Landroid/os/Parcel;", "parcel", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Landroid/os/Bundle;", "getPayload", "()Landroid/os/Bundle;", "Companion", "d5/t", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionCommandContent extends Content {
    public static final String KEY_ARGS = "session.args";
    public static final String KEY_EMBED_BUNDLE = "session.embedBundle";
    public static final String KEY_EMBED_ID = "session.embedId";
    public static final String KEY_EMBED_IDS = "session.embedIds";
    public static final String KEY_INDEX = "session.index";
    public static final String KEY_MESSAGE = "session.message";
    public static final String KEY_MESSAGES = "session.messages";
    public static final String KEY_NAME = "session.name";
    public static final String KEY_TOKEN = "session.token";
    public static final int SESSION_COMMAND_TYPE = -20;
    private final Bundle payload;
    public static final t Companion = new t();
    public static final Parcelable.Creator<SessionCommandContent> CREATOR = new g(19);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionCommandContent(Bundle payload) {
        super(-20);
        k.f(payload, "payload");
        this.payload = payload;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Bundle getPayload() {
        return this.payload;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        super.writeToParcel(parcel, flags);
        parcel.writeBundle(this.payload);
    }
}
