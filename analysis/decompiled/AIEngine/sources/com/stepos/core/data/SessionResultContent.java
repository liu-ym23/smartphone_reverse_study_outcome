package com.stepos.core.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.data.base.Content;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SessionResultContent extends Content {
    public static final String KEY_BOOL = "result.bool";
    public static final String KEY_FLOAT_ARRAY = "result.floatArray";
    public static final String KEY_FLOAT_ARRAYS = "result.floatArrays";
    public static final String KEY_INT = "result.int";
    public static final String KEY_MESSAGE = "result.message";
    public static final String KEY_MESSAGES = "result.messages";
    public static final int SESSION_RESULT_TYPE = -21;
    private final Bundle payload;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<SessionResultContent> CREATOR = new Parcelable.Creator<SessionResultContent>() { // from class: com.stepos.core.data.SessionResultContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SessionResultContent createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            parcel.readInt();
            if (parcel.readByte() == 1) {
                ContentParams.CREATOR.createFromParcel(parcel);
            }
            Bundle bundle = parcel.readBundle(SessionResultContent.class.getClassLoader());
            if (bundle == null) {
                bundle = new Bundle();
            }
            return new SessionResultContent(bundle);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SessionResultContent[] newArray(int i10) {
            return new SessionResultContent[i10];
        }
    };

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionResultContent(Bundle payload) {
        super(-21);
        g.f(payload, "payload");
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
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        super.writeToParcel(parcel, i10);
        parcel.writeBundle(this.payload);
    }
}
