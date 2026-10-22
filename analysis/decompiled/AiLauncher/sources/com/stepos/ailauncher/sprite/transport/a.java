package com.stepos.ailauncher.sprite.transport;

import android.os.Binder;
import android.os.Parcel;
import com.stepos.deepbinder.core.constant.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/sprite/transport/a;", "Landroid/os/Binder;", "<init>", "()V", "", "code", "Landroid/os/Parcel;", "data", Constants.PARAM_REPLY, "flags", "", "onTransact", "(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z", "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a extends Binder {
    public static final a INSTANCE = new a();

    @Override // android.os.Binder
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
        p.i(data, "data");
        throw new SecurityException("SpriteTransport bind denied");
    }
}
