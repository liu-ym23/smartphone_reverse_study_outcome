package com.stepos.core.data;

import La.H;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.data.base.Content;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/stepos/core/data/TextContent;", "Lcom/stepos/core/data/base/Content;", "", "text", "<init>", "(Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "validate", "()Z", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getText", "Companion", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TextContent extends Content {
    private final String text;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<TextContent> CREATOR = new Parcelable.Creator<TextContent>() { // from class: com.stepos.core.data.TextContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextContent createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
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
        public TextContent[] newArray(int size) {
            return new TextContent[size];
        }
    };

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/core/data/TextContent$Companion;", "", "<init>", "()V", "readFieldsFromParcel", "Lcom/stepos/core/data/TextContent;", "parcel", "Landroid/os/Parcel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final TextContent readFieldsFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
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
        p.i(text, "text");
        this.text = text;
    }

    public static final TextContent readFieldsFromParcel(Parcel parcel) {
        return INSTANCE.readFieldsFromParcel(parcel);
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getText() {
        return this.text;
    }

    public String toString() {
        return "TextContent(text='" + this.text + "')";
    }

    public final boolean validate() {
        return !H.x0(this.text);
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        super.writeToParcel(parcel, flags);
        parcel.writeString(this.text);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextContent(Parcel parcel) {
        p.i(parcel, "parcel");
        String string = parcel.readString();
        this(string == null ? "" : string);
    }
}
