package kotlinx.coroutines.flow.internal;

import Xa.b;
import Xa.c;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.q;

@Metadata(d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u008a\u0001\u0010\r\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0018\u00010\u00030\u000624\u0010\f\u001a0\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bH\u0081@¢\u0006\u0004\b\r\u0010\u000e*\u001c\b\u0002\u0010\u0010\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f2\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f¨\u0006\u0011"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "LXa/c;", "", "LXa/b;", "flows", "Lkotlin/Function0;", "arrayFactory", "Lkotlin/Function3;", "Le9/c;", "LY8/t;", "", "transform", Const.INTENT_KEY_APIKEY, "(LXa/c;[LXa/b;Lp9/a;Lp9/q;Le9/c;)Ljava/lang/Object;", "LZ8/J;", "Update", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CombineKt {
    public static final <R, T> Object a(c<? super R> cVar, b<? extends T>[] bVarArr, InterfaceC5063a<T[]> interfaceC5063a, q<? super c<? super R>, ? super T[], ? super InterfaceC4014c<? super t>, ? extends Object> qVar, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objA = FlowCoroutineKt.a(new CombineKt$combineInternal$2(bVarArr, interfaceC5063a, qVar, cVar, null), interfaceC4014c);
        return objA == C4063a.g() ? objA : t.f7040a;
    }
}
