package android.support.v4.os;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.IResultReceiver;
import android.text.TextUtils;
import androidx.fragment.app.c;
import androidx.fragment.app.t;
import androidx.fragment.app.w;
import androidx.fragment.app.z;
import androidx.versionedparcelable.ParcelImpl;
import com.stepos.common.widget.e;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import d.j;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import m.l0;
import r3.g;
import stepos.support.v7.widget.t1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f647a;

    public /* synthetic */ a(int i) {
        this.f647a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f647a) {
            case 0:
                b bVar = new b();
                bVar.f648c = IResultReceiver.Stub.asInterface(parcel.readStrongBinder());
                VarHandle.storeStoreFence();
                return bVar;
            case 1:
                androidx.fragment.app.b bVar2 = new androidx.fragment.app.b();
                bVar2.f1252c = parcel.createIntArray();
                bVar2.f1253f = parcel.createStringArrayList();
                bVar2.f1254g = parcel.createIntArray();
                bVar2.f1255h = parcel.createIntArray();
                bVar2.i = parcel.readInt();
                bVar2.f1256j = parcel.readString();
                bVar2.f1257k = parcel.readInt();
                bVar2.f1258l = parcel.readInt();
                Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
                bVar2.f1259m = (CharSequence) creator.createFromParcel(parcel);
                bVar2.f1260n = parcel.readInt();
                bVar2.f1261o = (CharSequence) creator.createFromParcel(parcel);
                bVar2.f1262p = parcel.createStringArrayList();
                bVar2.f1263q = parcel.createStringArrayList();
                bVar2.f1264r = parcel.readInt() != 0;
                VarHandle.storeStoreFence();
                return bVar2;
            case 2:
                c cVar = new c();
                cVar.f1273c = parcel.createStringArrayList();
                cVar.f1274f = parcel.createTypedArrayList(androidx.fragment.app.b.CREATOR);
                VarHandle.storeStoreFence();
                return cVar;
            case 3:
                t tVar = new t();
                tVar.f1303c = parcel.readString();
                tVar.f1304f = parcel.readInt();
                return tVar;
            case 4:
                w wVar = new w();
                wVar.i = null;
                wVar.f1334j = new ArrayList();
                wVar.f1335k = new ArrayList();
                wVar.f1330c = parcel.createStringArrayList();
                wVar.f1331f = parcel.createStringArrayList();
                wVar.f1332g = (androidx.fragment.app.b[]) parcel.createTypedArray(androidx.fragment.app.b.CREATOR);
                wVar.f1333h = parcel.readInt();
                wVar.i = parcel.readString();
                wVar.f1334j = parcel.createStringArrayList();
                wVar.f1335k = parcel.createTypedArrayList(c.CREATOR);
                wVar.f1336l = parcel.createTypedArrayList(t.CREATOR);
                return wVar;
            case 5:
                z zVar = new z();
                zVar.f1343c = parcel.readString();
                zVar.f1344f = parcel.readString();
                zVar.f1345g = parcel.readInt() != 0;
                zVar.f1346h = parcel.readInt();
                zVar.i = parcel.readInt();
                zVar.f1347j = parcel.readString();
                zVar.f1348k = parcel.readInt() != 0;
                zVar.f1349l = parcel.readInt() != 0;
                zVar.f1350m = parcel.readInt() != 0;
                zVar.f1351n = parcel.readBundle();
                zVar.f1352o = parcel.readInt() != 0;
                zVar.f1354q = parcel.readBundle();
                zVar.f1353p = parcel.readInt();
                VarHandle.storeStoreFence();
                return zVar;
            case 6:
                String string = parcel.readString();
                string.getClass();
                int i = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i);
                for (int i3 = 0; i3 < i; i3++) {
                    String string2 = parcel.readString();
                    string2.getClass();
                    String string3 = parcel.readString();
                    string3.getClass();
                    linkedHashMap.put(string2, string3);
                }
                return new c6.a(string, linkedHashMap);
            case 7:
                e eVar = new e(parcel);
                eVar.f2684g = parcel.readInt();
                eVar.f2682c = parcel.readInt() == 1;
                eVar.f2683f = parcel.readInt() == 1;
                return eVar;
            case 8:
                com.stepos.statsrpk.a aVar = new com.stepos.statsrpk.a();
                aVar.f2844c = parcel.readString();
                aVar.f2845f = parcel.readString();
                aVar.f2846g = parcel.readString();
                aVar.f2847h = parcel.readHashMap(String.class.getClassLoader());
                aVar.i = parcel.readString();
                return aVar;
            case 9:
                com.stepos.statsrpk.b bVar3 = new com.stepos.statsrpk.b();
                bVar3.f2848c = parcel.readString();
                bVar3.f2849f = parcel.readString();
                bVar3.f2850g = parcel.readInt();
                bVar3.f2851h = parcel.readString();
                bVar3.i = parcel.readString();
                return bVar3;
            case 10:
                parcel.getClass();
                String string4 = parcel.readString();
                if (string4 == null) {
                    string4 = "";
                }
                int i10 = parcel.readInt();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                com.zyql.agentguard.collector.a aVar2 = new com.zyql.agentguard.collector.a();
                aVar2.f2917c = string4;
                aVar2.f2918f = i10;
                aVar2.f2919g = string5;
                aVar2.f2920h = string6;
                aVar2.i = string7;
                VarHandle.storeStoreFence();
                return aVar2;
            case 11:
                d.a aVar3 = new d.a();
                aVar3.f2921c = parcel.readInt();
                aVar3.f2922f = parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null;
                VarHandle.storeStoreFence();
                return aVar3;
            case 12:
                parcel.getClass();
                Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
                parcelable.getClass();
                return new j((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 13:
                ParcelImpl parcelImpl = new ParcelImpl();
                parcelImpl.f1656c = new e5.b(parcel).g();
                VarHandle.storeStoreFence();
                return parcelImpl;
            case 14:
                EmitterConfig emitterConfig = new EmitterConfig();
                emitterConfig.f2810c = true;
                emitterConfig.f2812g = true;
                emitterConfig.f2813h = true;
                emitterConfig.i = true;
                emitterConfig.f2814j = 1800000L;
                emitterConfig.f2815k = 50;
                emitterConfig.f2816l = 2097152L;
                emitterConfig.f2817m = 10;
                emitterConfig.f2811f = parcel.readByte() != 0;
                emitterConfig.f2810c = parcel.readByte() != 0;
                emitterConfig.f2812g = parcel.readByte() != 0;
                emitterConfig.f2813h = parcel.readByte() != 0;
                emitterConfig.i = parcel.readByte() != 0;
                emitterConfig.f2814j = parcel.readLong();
                emitterConfig.f2815k = parcel.readInt();
                emitterConfig.f2816l = parcel.readLong();
                emitterConfig.f2818n = parcel.readString();
                emitterConfig.f2819o = parcel.readString();
                return emitterConfig;
            case 15:
                TrackerPayload trackerPayload = new TrackerPayload();
                trackerPayload.f2842c = parcel.readHashMap(HashMap.class.getClassLoader());
                trackerPayload.f2843f = parcel.readHashMap(HashMap.class.getClassLoader());
                return trackerPayload;
            case 16:
                l0 l0Var = new l0(parcel);
                l0Var.f7986c = parcel.readByte() != 0;
                return l0Var;
            case 17:
                g gVar = new g(parcel);
                gVar.f10460c = parcel.readInt();
                return gVar;
            case 18:
                t1 t1Var = new t1(parcel);
                t1Var.f12834c = parcel.readInt();
                t1Var.f12835f = parcel.readInt() != 0;
                return t1Var;
            default:
                w6.b bVar4 = new w6.b(parcel);
                bVar4.f15269c = ((Integer) parcel.readValue(w6.b.class.getClassLoader())).intValue();
                return bVar4;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f647a) {
            case 0:
                return new b[i];
            case 1:
                return new androidx.fragment.app.b[i];
            case 2:
                return new c[i];
            case 3:
                return new t[i];
            case 4:
                return new w[i];
            case 5:
                return new z[i];
            case 6:
                return new c6.a[i];
            case 7:
                return new e[i];
            case 8:
                return new com.stepos.statsrpk.a[i];
            case 9:
                return new com.stepos.statsrpk.b[i];
            case 10:
                return new com.zyql.agentguard.collector.a[i];
            case 11:
                return new d.a[i];
            case 12:
                return new j[i];
            case 13:
                return new ParcelImpl[i];
            case 14:
                return new EmitterConfig[i];
            case 15:
                return new TrackerPayload[i];
            case 16:
                return new l0[i];
            case 17:
                return new g[i];
            case 18:
                return new t1[i];
            default:
                return new w6.b[i];
        }
    }
}
