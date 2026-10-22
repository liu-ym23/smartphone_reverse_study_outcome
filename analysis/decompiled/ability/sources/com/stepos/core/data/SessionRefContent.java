package com.stepos.core.data;

import L.g;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.core.data.base.Content;
import d5.u;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/stepos/core/data/SessionRefContent;", "Lcom/stepos/core/data/base/Content;", "", HintConstants.AUTOFILL_HINT_NAME, HighlightArgsBundle.KEY_PROMPT, "Landroid/os/Bundle;", "args", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "Landroid/os/Parcel;", "parcel", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "getPrompt", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "Companion", "d5/u", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionRefContent extends Content {
    public static final int TYPE_SESSION_REF = 6;
    private final Bundle args;
    private final String name;
    private final String prompt;
    public static final u Companion = new u();
    public static final Parcelable.Creator<SessionRefContent> CREATOR = new g(20);

    public /* synthetic */ SessionRefContent(String str, String str2, Bundle bundle, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? Bundle.EMPTY : bundle);
    }

    public static final SessionRefContent readFieldsFromParcel(Parcel parcel) {
        Companion.getClass();
        k.f(parcel, "parcel");
        String string = parcel.readString();
        if (string == null) {
            string = "";
        }
        String string2 = parcel.readString();
        Bundle bundle = parcel.readBundle(SessionRefContent.class.getClassLoader());
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        k.c(bundle);
        return new SessionRefContent(string, string2, bundle);
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Bundle getArgs() {
        return this.args;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        super.writeToParcel(parcel, flags);
        parcel.writeString(this.name);
        parcel.writeString(this.prompt);
        parcel.writeBundle(this.args);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionRefContent(String name, String str, Bundle args) {
        super(6);
        k.f(name, "name");
        k.f(args, "args");
        this.name = name;
        this.prompt = str;
        this.args = args;
    }
}
