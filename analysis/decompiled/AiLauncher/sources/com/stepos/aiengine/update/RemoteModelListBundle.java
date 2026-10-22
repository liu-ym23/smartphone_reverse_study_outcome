package com.stepos.aiengine.update;

import La.H;
import Z8.C1172u;
import Z8.C1173v;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.model.RemoteModel;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/aiengine/update/RemoteModelListBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "Lcom/stepos/aiengine/model/RemoteModel;", "getBaseModel", "()Lcom/stepos/aiengine/model/RemoteModel;", "", "pluginName", "getPluginModel", "(Ljava/lang/String;)Lcom/stepos/aiengine/model/RemoteModel;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "", "getModels", "()Ljava/util/List;", "models", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RemoteModelListBundle {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    public RemoteModelListBundle(Bundle bundle) {
        p.i(bundle, "bundle");
        this.bundle = bundle;
    }

    public final RemoteModel getBaseModel() {
        Object next;
        Iterator<T> it = getModels().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!((RemoteModel) next).isPlugin()) {
                break;
            }
        }
        return (RemoteModel) next;
    }

    public final List<RemoteModel> getModels() {
        String string = this.bundle.getString("name", "");
        String str = string == null ? "" : string;
        String string2 = this.bundle.getString("url", "");
        String str2 = string2 == null ? "" : string2;
        long j10 = this.bundle.getLong("fileSize", 0L);
        String string3 = this.bundle.getString(Parameters.UPLOAD_REQUEST_PARAM_MD5, "");
        String str3 = string3 == null ? "" : string3;
        int i10 = this.bundle.getInt("versionCode", 0);
        String string4 = this.bundle.getString("updateInfo", "");
        String str4 = string4 == null ? "" : string4;
        long j11 = this.bundle.getLong("updateTime", 0L);
        List stringArrayList = this.bundle.getStringArrayList("abilities");
        if (stringArrayList == null) {
            stringArrayList = C1173v.m();
        }
        List list = stringArrayList;
        List stringArrayList2 = this.bundle.getStringArrayList("dependencies");
        if (stringArrayList2 == null) {
            stringArrayList2 = C1173v.m();
        }
        return (H.x0(str2) && j10 == 0) ? C1173v.m() : C1172u.e(new RemoteModel(str, i10, str2, j10, str3, str4, j11, list, stringArrayList2));
    }

    public final RemoteModel getPluginModel(String pluginName) {
        Object next;
        p.i(pluginName, "pluginName");
        Iterator<T> it = getModels().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            RemoteModel remoteModel = (RemoteModel) next;
            if (remoteModel.isPlugin() && p.d(remoteModel.getPluginName(), pluginName)) {
                break;
            }
        }
        return (RemoteModel) next;
    }
}
