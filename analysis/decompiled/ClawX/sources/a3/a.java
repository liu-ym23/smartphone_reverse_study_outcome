package a3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;
import com.meizu.aiservice.algorithm.chat.LlmChatMessage;
import com.meizu.aiservice.algorithm.voice.asr.SpeechRecognitionSegment;
import com.meizu.aiservice.api.ability.AlgorithmAbilities;
import com.meizu.aiservice.api.bean.FloatArrayMap;
import com.meizu.aiservice.api.bean.FloatMatrix;
import com.meizu.aiservice.api.bean.ImageContour;
import com.meizu.aiservice.api.bean.IntMatrix;
import com.meizu.aiservice.api.bean.OpenCVHierarchy;
import com.meizu.aiservice.api.task.AlgorithmToken;
import com.meizu.aiservice.download.RemoteModel;
import g0.f;
import o2.d;
import org.bouncycastle.asn1.BERTags;
import v0.r;
import v0.r0;
import v0.s0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f90a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f90a) {
            case 0:
                return new FloatArrayMap(parcel);
            case 1:
                return new FloatMatrix(parcel);
            case 2:
                return new ImageContour(parcel);
            case 3:
                return new IntMatrix(parcel);
            case 4:
                return new OpenCVHierarchy(parcel);
            case 5:
                return new ParcelImpl(parcel);
            case 6:
                return new AlgorithmToken(parcel);
            case 7:
                return new RemoteModel(parcel);
            case 8:
                f fVar = new f(parcel);
                fVar.f2905a = parcel.readInt();
                return fVar;
            case 9:
                return new LlmChatMessage(parcel);
            case 10:
                d dVar = new d();
                dVar.f4302a = parcel.readString();
                dVar.f4303b = parcel.readString();
                dVar.f4304c = parcel.readString();
                return dVar;
            case BERTags.EMBEDDED_PDV /* 11 */:
                r rVar = new r();
                rVar.f5918a = parcel.readInt();
                rVar.f5919b = parcel.readInt();
                rVar.f5920c = parcel.readInt() == 1;
                return rVar;
            case 12:
                r0 r0Var = new r0();
                r0Var.f5921a = parcel.readInt();
                r0Var.f5922b = parcel.readInt();
                r0Var.d = parcel.readInt() == 1;
                int i8 = parcel.readInt();
                if (i8 > 0) {
                    int[] iArr = new int[i8];
                    r0Var.f5923c = iArr;
                    parcel.readIntArray(iArr);
                }
                return r0Var;
            case BERTags.RELATIVE_OID /* 13 */:
                s0 s0Var = new s0();
                s0Var.f5927a = parcel.readInt();
                s0Var.f5928b = parcel.readInt();
                int i9 = parcel.readInt();
                s0Var.f5929c = i9;
                if (i9 > 0) {
                    int[] iArr2 = new int[i9];
                    s0Var.d = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int i10 = parcel.readInt();
                s0Var.f5930e = i10;
                if (i10 > 0) {
                    int[] iArr3 = new int[i10];
                    s0Var.f5931f = iArr3;
                    parcel.readIntArray(iArr3);
                }
                s0Var.f5933h = parcel.readInt() == 1;
                s0Var.f5934j = parcel.readInt() == 1;
                s0Var.f5935k = parcel.readInt() == 1;
                s0Var.f5932g = parcel.readArrayList(r0.class.getClassLoader());
                return s0Var;
            case BERTags.TIME /* 14 */:
                return new SpeechRecognitionSegment(parcel);
            default:
                return new AlgorithmAbilities(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        switch (this.f90a) {
            case 0:
                return new FloatArrayMap[i8];
            case 1:
                return new FloatMatrix[i8];
            case 2:
                return new ImageContour[i8];
            case 3:
                return new IntMatrix[i8];
            case 4:
                return new OpenCVHierarchy[i8];
            case 5:
                return new ParcelImpl[i8];
            case 6:
                return new AlgorithmToken[i8];
            case 7:
                return new RemoteModel[i8];
            case 8:
                return new f[i8];
            case 9:
                return new LlmChatMessage[i8];
            case 10:
                return new d[i8];
            case BERTags.EMBEDDED_PDV /* 11 */:
                return new r[i8];
            case 12:
                return new r0[i8];
            case BERTags.RELATIVE_OID /* 13 */:
                return new s0[i8];
            case BERTags.TIME /* 14 */:
                return new SpeechRecognitionSegment[i8];
            default:
                return new AlgorithmAbilities[i8];
        }
    }
}
