package G4;

import android.content.DialogInterface;
import android.os.RemoteException;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public final class j implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ A6.i f673a;
    public final /* synthetic */ b b;

    public j(A6.i iVar, b bVar) {
        this.f673a = iVar;
        this.b = bVar;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
    public final void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        kotlin.jvm.internal.k.f(dialogInterface, "dialogInterface");
        if (z11) {
            this.f673a.invoke();
        } else {
            this.b.invoke();
        }
    }
}
