package com.android.server.pm;

import android.content.Context;
import android.os.DebugSmtEx;
import com.android.server.art.ArtManagerLocal;

/* JADX INFO: loaded from: classes2.dex */
public interface IProfileDrivenDexoptManager {
    default IProfileDrivenDexoptManager initialize(Context context, ArtManagerLocal artManagerLocal) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return this;
    }
}
