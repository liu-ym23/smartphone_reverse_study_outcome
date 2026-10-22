package L;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import cc.dd.dd.b0.l;
import com.google.android.material.badge.BadgeState$State;
import com.google.android.material.internal.ParcelableSparseBooleanArray;
import com.google.android.material.internal.ParcelableSparseIntArray;
import com.stepos.core.ability.AbilityInfo;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.LlmChatMessage;
import com.stepos.core.data.LlmToolCall;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.PrimitiveContent;
import com.stepos.core.data.SessionCommandContent;
import com.stepos.core.data.SessionRefContent;
import com.stepos.core.data.SessionResultContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.VideoContent;
import com.stepos.core.data.base.Content;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsrpk.RpkEvent;
import com.stepos.statsrpk.RpkInfo;
import d5.s;
import java.util.ArrayList;
import kotlin.jvm.internal.k;

/* loaded from: classes2.dex */
public final class g implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f922a;

    public /* synthetic */ g(int i) {
        this.f922a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ArrayList arrayList;
        ArrayList arrayList2;
        switch (this.f922a) {
            case 0:
                return new cc.dd.dd.aa.g(parcel);
            case 1:
                return new l(parcel);
            case 2:
                return new TrackerPayload(parcel);
            case 3:
                return new BadgeState$State(parcel);
            case 4:
                int i = parcel.readInt();
                ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(i);
                int[] iArr = new int[i];
                boolean[] zArr = new boolean[i];
                parcel.readIntArray(iArr);
                parcel.readBooleanArray(zArr);
                for (int i6 = 0; i6 < i; i6++) {
                    parcelableSparseBooleanArray.put(iArr[i6], zArr[i6]);
                }
                return parcelableSparseBooleanArray;
            case 5:
                int i10 = parcel.readInt();
                ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(i10);
                int[] iArr2 = new int[i10];
                int[] iArr3 = new int[i10];
                parcel.readIntArray(iArr2);
                parcel.readIntArray(iArr3);
                for (int i11 = 0; i11 < i10; i11++) {
                    parcelableSparseIntArray.put(iArr2[i11], iArr3[i11]);
                }
                return parcelableSparseIntArray;
            case 6:
                k.f(parcel, "parcel");
                return new AbilityInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.createStringArray(), parcel.readInt() != 0, parcel.readInt(), parcel.readString());
            case 7:
                return Content.createFromParcel(parcel);
            case 8:
                return new EmitterConfig(parcel);
            case 9:
                return new RpkEvent(parcel);
            case 10:
                return new RpkInfo(parcel);
            case 11:
                k.f(parcel, "parcel");
                parcel.readInt();
                ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
                AudioContent audioContent = new AudioContent(parcel);
                ((Content) audioContent).params = contentParamsCreateFromParcel;
                return audioContent;
            case 12:
                k.f(parcel, "parcel");
                return new ContentParams(parcel);
            case 13:
                k.f(parcel, "parcel");
                parcel.readInt();
                ContentParams contentParamsCreateFromParcel2 = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
                FileContent fileContent = new FileContent(parcel);
                ((Content) fileContent).params = contentParamsCreateFromParcel2;
                return fileContent;
            case 14:
                k.f(parcel, "parcel");
                parcel.readInt();
                ContentParams contentParamsCreateFromParcel3 = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
                ImageContent imageContent = new ImageContent(parcel);
                ((Content) imageContent).params = contentParamsCreateFromParcel3;
                return imageContent;
            case 15:
                k.f(parcel, "parcel");
                int i12 = parcel.readInt();
                String string = parcel.readString();
                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                ArrayList arrayList3 = null;
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int i13 = parcel.readInt();
                    arrayList = new ArrayList(i13);
                    for (int i14 = 0; i14 != i13; i14++) {
                        arrayList.add(parcel.readParcelable(LlmChatMessage.class.getClassLoader()));
                    }
                }
                if (parcel.readInt() == 0) {
                    arrayList2 = null;
                } else {
                    int i15 = parcel.readInt();
                    arrayList2 = new ArrayList(i15);
                    for (int i16 = 0; i16 != i15; i16++) {
                        arrayList2.add(parcel.readParcelable(LlmChatMessage.class.getClassLoader()));
                    }
                }
                if (parcel.readInt() != 0) {
                    int i17 = parcel.readInt();
                    arrayList3 = new ArrayList(i17);
                    for (int i18 = 0; i18 != i17; i18++) {
                        arrayList3.add(LlmToolCall.CREATOR.createFromParcel(parcel));
                    }
                }
                return new LlmChatMessage(i12, string, arrayListCreateStringArrayList, arrayList, arrayList2, arrayList3, parcel.readString());
            case 16:
                k.f(parcel, "parcel");
                return new LlmToolCall(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            case 17:
                k.f(parcel, "parcel");
                parcel.readInt();
                ContentParams contentParamsCreateFromParcel4 = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
                MixedContent mixedContent = new MixedContent(parcel);
                ((Content) mixedContent).params = contentParamsCreateFromParcel4;
                return mixedContent;
            case 18:
                k.f(parcel, "parcel");
                int i19 = parcel.readInt();
                PrimitiveContent.Companion.getClass();
                ContentParams contentParamsCreateFromParcel5 = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
                PrimitiveContent primitiveContent = new PrimitiveContent(s.a(parcel, i19), i19);
                ((Content) primitiveContent).params = contentParamsCreateFromParcel5;
                return primitiveContent;
            case 19:
                k.f(parcel, "parcel");
                parcel.readInt();
                if (parcel.readByte() == 1) {
                    ContentParams.CREATOR.createFromParcel(parcel);
                }
                Bundle bundle = parcel.readBundle(SessionCommandContent.class.getClassLoader());
                if (bundle == null) {
                    bundle = new Bundle();
                }
                return new SessionCommandContent(bundle);
            case 20:
                k.f(parcel, "parcel");
                parcel.readInt();
                ContentParams contentParamsCreateFromParcel6 = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
                String string2 = parcel.readString();
                if (string2 == null) {
                    string2 = "";
                }
                String string3 = parcel.readString();
                Bundle bundle2 = parcel.readBundle(SessionRefContent.class.getClassLoader());
                if (bundle2 == null) {
                    bundle2 = Bundle.EMPTY;
                }
                k.c(bundle2);
                SessionRefContent sessionRefContent = new SessionRefContent(string2, string3, bundle2);
                ((Content) sessionRefContent).params = contentParamsCreateFromParcel6;
                return sessionRefContent;
            case 21:
                k.f(parcel, "parcel");
                parcel.readInt();
                if (parcel.readByte() == 1) {
                    ContentParams.CREATOR.createFromParcel(parcel);
                }
                Bundle bundle3 = parcel.readBundle(SessionResultContent.class.getClassLoader());
                if (bundle3 == null) {
                    bundle3 = new Bundle();
                }
                return new SessionResultContent(bundle3);
            case 22:
                k.f(parcel, "parcel");
                parcel.readInt();
                ContentParams contentParamsCreateFromParcel7 = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
                String string4 = parcel.readString();
                if (string4 == null) {
                    string4 = "";
                }
                TextContent textContent = new TextContent(string4);
                ((Content) textContent).params = contentParamsCreateFromParcel7;
                return textContent;
            default:
                k.f(parcel, "parcel");
                parcel.readInt();
                ContentParams contentParamsCreateFromParcel8 = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
                VideoContent videoContent = new VideoContent(parcel);
                ((Content) videoContent).params = contentParamsCreateFromParcel8;
                return videoContent;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f922a) {
            case 0:
                return new cc.dd.dd.aa.g[i];
            case 1:
                return new l[i];
            case 2:
                return new TrackerPayload[i];
            case 3:
                return new BadgeState$State[i];
            case 4:
                return new ParcelableSparseBooleanArray[i];
            case 5:
                return new ParcelableSparseIntArray[i];
            case 6:
                return new AbilityInfo[i];
            case 7:
                return new Content[i];
            case 8:
                return new EmitterConfig[i];
            case 9:
                return new RpkEvent[i];
            case 10:
                return new RpkInfo[i];
            case 11:
                return new AudioContent[i];
            case 12:
                return new ContentParams[i];
            case 13:
                return new FileContent[i];
            case 14:
                return new ImageContent[i];
            case 15:
                return new LlmChatMessage[i];
            case 16:
                return new LlmToolCall[i];
            case 17:
                return new MixedContent[i];
            case 18:
                return new PrimitiveContent[i];
            case 19:
                return new SessionCommandContent[i];
            case 20:
                return new SessionRefContent[i];
            case 21:
                return new SessionResultContent[i];
            case 22:
                return new TextContent[i];
            default:
                return new VideoContent[i];
        }
    }
}
