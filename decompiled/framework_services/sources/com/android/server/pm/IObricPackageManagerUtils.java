package com.android.server.pm;

import android.content.pm.PkgSignForNative;
import com.obric.utils.IObricBase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IObricPackageManagerUtils extends IObricBase {
    default List<PkgSignForNative> getSignaturesForUid(PackageManagerService pms, int uid) {
        return new ArrayList();
    }
}
