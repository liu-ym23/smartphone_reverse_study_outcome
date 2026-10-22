package com.stepos.core.data;

import a0.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.data.base.Content;
import gc.q;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TextContent extends Content {
    private final String text;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<TextContent> CREATOR = new Parcelable.Creator<TextContent>() { // from class: com.stepos.core.data.TextContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextContent createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            parcel.readInt();
            ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
            String string = parcel.readString();
            if (string == null) {
                string = "";
            }
            TextContent textContent = new TextContent(string);
            ((Content) textContent).params = contentParamsCreateFromParcel;
            return textContent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextContent[] newArray(int i10) {
            return new TextContent[i10];
        }
    };

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final TextContent readFieldsFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            String string = parcel.readString();
            if (string == null) {
                string = "";
            }
            return new TextContent(string);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextContent(String text) {
        super(0);
        g.f(text, "text");
        this.text = text;
    }

    public static final TextContent readFieldsFromParcel(Parcel parcel) {
        return Companion.readFieldsFromParcel(parcel);
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getText() {
        return this.text;
    }

    public String toString() {
        return a.k("TextContent(text='", this.text, "')");
    }

    public final boolean validate() {
        return !q.t0(this.text);
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.text);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextContent(Parcel parcel) {
        g.f(parcel, "parcel");
        String string = parcel.readString();
        this(string == null ? "" : string);
    }
}
