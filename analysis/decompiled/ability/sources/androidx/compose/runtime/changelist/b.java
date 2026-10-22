package androidx.compose.runtime.changelist;

import S7.k;
import android.content.Context;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.compose.DropUnlessLifecycleKt;
import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.SlotWriter;
import androidx.room.BaseRoomConnectionManager;
import com.zyql.ability.sdk.client.IAbilityCallbackProxy;
import com.zyql.common.utils.update.UpdateManager;
import com.zyql.common.utils.update.model.UpdateCheckResponse;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1750a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i) {
        this.f1750a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f1750a) {
            case 0:
                return OperationKt.attachComposeStackTrace$lambda$1((Anchor) this.b, (SlotWriter) this.c, (OperationErrorContext) this.d);
            case 1:
                return DropUnlessLifecycleKt.dropUnlessStateIsAtLeast$lambda$2$lambda$1((LifecycleOwner) this.b, (Lifecycle.State) this.c, (S7.a) this.d);
            case 2:
                return BaseRoomConnectionManager.DriverWrapper.openLocked$lambda$1((BaseRoomConnectionManager) this.b, (BaseRoomConnectionManager.DriverWrapper) this.c, (String) this.d);
            case 3:
                return IAbilityCallbackProxy.onSuccess$lambda$0((IAbilityCallbackProxy) this.b, (String) this.c, (String) this.d);
            default:
                return UpdateManager.checkAndDownloadUpdate$lambda$24$lambda$22((Context) this.b, (UpdateCheckResponse) this.c, (k) this.d);
        }
    }
}
