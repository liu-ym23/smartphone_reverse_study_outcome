package com.stepos.core.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.data.base.Content;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SessionRefContent extends Content {
    public static final int TYPE_SESSION_REF = 6;
    private final Bundle args;
    private final String name;
    private final String prompt;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<SessionRefContent> CREATOR = new Parcelable.Creator<SessionRefContent>() { // from class: com.stepos.core.data.SessionRefContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SessionRefContent createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
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
            g.c(bundle);
            SessionRefContent sessionRefContent = new SessionRefContent(string, string2, bundle);
            ((Content) sessionRefContent).params = contentParamsCreateFromParcel;
            return sessionRefContent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SessionRefContent[] newArray(int i10) {
            return new SessionRefContent[i10];
        }
    };

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final SessionRefContent readFieldsFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            String string = parcel.readString();
            if (string == null) {
                string = "";
            }
            String string2 = parcel.readString();
            Bundle bundle = parcel.readBundle(SessionRefContent.class.getClassLoader());
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            g.c(bundle);
            return new SessionRefContent(string, string2, bundle);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SessionRefContent(String str, String str2, Bundle bundle, int i10, e eVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? Bundle.EMPTY : bundle);
    }

    public static final SessionRefContent readFieldsFromParcel(Parcel parcel) {
        return Companion.readFieldsFromParcel(parcel);
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
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.name);
        parcel.writeString(this.prompt);
        parcel.writeBundle(this.args);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionRefContent(String name, String str, Bundle args) {
        super(6);
        g.f(name, "name");
        g.f(args, "args");
        this.name = name;
        this.prompt = str;
        this.args = args;
    }
}
