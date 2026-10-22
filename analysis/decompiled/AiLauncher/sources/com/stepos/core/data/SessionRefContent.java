package com.stepos.core.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.core.data.base.Content;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/core/data/SessionRefContent;", "Lcom/stepos/core/data/base/Content;", "", "name", HighlightArgsBundle.KEY_PROMPT, "Landroid/os/Bundle;", "args", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "Landroid/os/Parcel;", "parcel", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "getPrompt", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "Companion", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionRefContent extends Content {
    public static final int TYPE_SESSION_REF = 6;
    private final Bundle args;
    private final String name;
    private final String prompt;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SessionRefContent> CREATOR = new Parcelable.Creator<SessionRefContent>() { // from class: com.stepos.core.data.SessionRefContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SessionRefContent createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            parcel.readInt();
            ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
            String string = parcel.readString();
            if (string == null) {
                string = "";
            }
            String string2 = parcel.readString();
            Bundle bundle = parcel.readBundle(SessionRefContent.class.getClassLoader());
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            p.f(bundle);
            SessionRefContent sessionRefContent = new SessionRefContent(string, string2, bundle);
            ((Content) sessionRefContent).params = contentParamsCreateFromParcel;
            return sessionRefContent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SessionRefContent[] newArray(int size) {
            return new SessionRefContent[size];
        }
    };

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/core/data/SessionRefContent$Companion;", "", "<init>", "()V", "TYPE_SESSION_REF", "", "readFieldsFromParcel", "Lcom/stepos/core/data/SessionRefContent;", "parcel", "Landroid/os/Parcel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final SessionRefContent readFieldsFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            String string = parcel.readString();
            if (string == null) {
                string = "";
            }
            String string2 = parcel.readString();
            Bundle bundle = parcel.readBundle(SessionRefContent.class.getClassLoader());
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            p.f(bundle);
            return new SessionRefContent(string, string2, bundle);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SessionRefContent(String str, String str2, Bundle bundle, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? Bundle.EMPTY : bundle);
    }

    public static final SessionRefContent readFieldsFromParcel(Parcel parcel) {
        return INSTANCE.readFieldsFromParcel(parcel);
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
        p.i(parcel, "parcel");
        super.writeToParcel(parcel, flags);
        parcel.writeString(this.name);
        parcel.writeString(this.prompt);
        parcel.writeBundle(this.args);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionRefContent(String name, String str, Bundle args) {
        super(6);
        p.i(name, "name");
        p.i(args, "args");
        this.name = name;
        this.prompt = str;
        this.args = args;
    }
}
