package com.stepos.aiengine.update;

import O6.l;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001b\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/stepos/aiengine/update/AlgorithmUpdateBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "", "", "getUpdatableAlgorithms", "()Ljava/util/List;", "algorithm", "", "hasBaseUpdate", "(Ljava/lang/String;)Z", "hasBaseModelUpdate", "plugin", "hasPluginUpdate", "(Ljava/lang/String;Ljava/lang/String;)Z", "algorithmId", "Lcom/stepos/aiengine/update/RemoteModelListBundle;", "getRemoteModels", "(Ljava/lang/String;)Lcom/stepos/aiengine/update/RemoteModelListBundle;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "", "getCheckTime", "()J", "checkTime", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AlgorithmUpdateBundle {
    public static final String KEY_CHECK_TIME = "check_time";
    public static final String KEY_SUFFIX_MODEL = "model";
    public static final String KEY_UPDATES = "updates";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    public AlgorithmUpdateBundle(Bundle bundle) {
        p.i(bundle, "bundle");
        this.bundle = bundle;
    }

    public final long getCheckTime() {
        return this.bundle.getLong(KEY_CHECK_TIME, -1L);
    }

    public final RemoteModelListBundle getRemoteModels(String algorithmId) {
        p.i(algorithmId, "algorithmId");
        Bundle bundle = this.bundle.getBundle(algorithmId + ".model");
        if (bundle == null) {
            return null;
        }
        return new RemoteModelListBundle(bundle);
    }

    public final List<String> getUpdatableAlgorithms() {
        if (getCheckTime() == -1) {
            return null;
        }
        return this.bundle.getStringArrayList(KEY_UPDATES);
    }

    public final boolean hasBaseModelUpdate(String algorithm) {
        p.i(algorithm, "algorithm");
        return hasBaseUpdate(algorithm);
    }

    public final boolean hasBaseUpdate(String algorithm) {
        p.i(algorithm, "algorithm");
        List<String> updatableAlgorithms = getUpdatableAlgorithms();
        return updatableAlgorithms != null && updatableAlgorithms.contains(algorithm);
    }

    public final boolean hasPluginUpdate(String algorithm, String plugin) {
        p.i(algorithm, "algorithm");
        p.i(plugin, "plugin");
        List<String> updatableAlgorithms = getUpdatableAlgorithms();
        if (updatableAlgorithms != null) {
            if (updatableAlgorithms.contains(algorithm + l.DATE_SEPARATOR + plugin)) {
                return true;
            }
        }
        return false;
    }
}
