package com.stepos.stepclaw.provider.contract;

import android.os.Bundle;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0006"}, d2 = {"resolveExtensionSkillId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ExtensionCallContract.KEY_EXTRAS, "Landroid/os/Bundle;", "resolveExtensionToolId", "resolveExtensionZipUri", "step-runtime_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExtensionCallContractKt {
    public static final String resolveExtensionSkillId(Bundle extras) {
        String string;
        p.e(extras, "extras");
        String string2 = extras.getString("id");
        if (string2 == null || (string = n.T1(string2).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    public static final String resolveExtensionToolId(Bundle extras) {
        String string;
        p.e(extras, "extras");
        String string2 = extras.getString("id");
        if (string2 == null || (string = n.T1(string2).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    public static final String resolveExtensionZipUri(Bundle extras) {
        String string;
        p.e(extras, "extras");
        String string2 = extras.getString(ExtensionCallContract.ZIP_URI);
        if (string2 == null || (string = n.T1(string2).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }
}
