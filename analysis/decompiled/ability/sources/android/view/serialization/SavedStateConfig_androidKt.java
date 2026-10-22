package android.view.serialization;

import D7.v;
import E9.e;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.serialization.serializers.SizeFSerializer;
import android.view.serialization.serializers.SizeSerializer;
import android.view.serialization.serializers.SparseArraySerializer;
import androidx.compose.ui.text.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlinx.serialization.modules.a;
import x9.b;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"LE9/e;", "getDefaultSerializersModuleOnPlatform", "()LE9/e;", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateConfig_androidKt {
    public static final e getDefaultSerializersModuleOnPlatform() {
        a aVar = new a();
        SizeSerializer sizeSerializer = SizeSerializer.INSTANCE;
        n nVar = m.f4928a;
        aVar.o(nVar.b(Size.class), sizeSerializer);
        aVar.o(nVar.b(SizeF.class), SizeFSerializer.INSTANCE);
        aVar.a(nVar.b(SparseArray.class), new d(11));
        return aVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b getDefaultSerializersModuleOnPlatform$lambda$1$lambda$0(List argSerializers) {
        k.f(argSerializers, "argSerializers");
        return new SparseArraySerializer((b) v.A0(argSerializers));
    }
}
