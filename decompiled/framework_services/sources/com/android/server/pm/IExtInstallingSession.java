package com.android.server.pm;

import android.content.pm.parsing.PackageLite;
import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtInstallingSession extends IExtBase {
    boolean checkAdbInstall();

    boolean forbidInstall(PackageLite r1, InstallRequest r2);

    CharSequence getLabel();

    boolean needHandleReturnCode();

    void reset();
}
