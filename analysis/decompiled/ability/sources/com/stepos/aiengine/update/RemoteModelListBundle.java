package com.stepos.aiengine.update;

import H4.o;
import android.os.Bundle;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.model.RemoteModel;
import j9.m;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/aiengine/update/RemoteModelListBundle;", "", "Landroid/os/Bundle;", "bundle", AppAgent.CONSTRUCT, "(Landroid/os/Bundle;)V", "Lcom/stepos/aiengine/model/RemoteModel;", "getBaseModel", "()Lcom/stepos/aiengine/model/RemoteModel;", "", "pluginName", "getPluginModel", "(Ljava/lang/String;)Lcom/stepos/aiengine/model/RemoteModel;", "", "getModels", "()Ljava/util/List;", "models", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteModelListBundle {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3537a;

    public RemoteModelListBundle(Bundle bundle) {
        k.f(bundle, "bundle");
        this.f3537a = bundle;
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
        Bundle bundle = this.f3537a;
        String string = bundle.getString(HintConstants.AUTOFILL_HINT_NAME, "");
        String str = string == null ? "" : string;
        String string2 = bundle.getString(BffConstant.Type.Url, "");
        String str2 = string2 == null ? "" : string2;
        long j5 = bundle.getLong("fileSize", 0L);
        String string3 = bundle.getString("md5", "");
        if (string3 == null) {
            string3 = "";
        }
        int i = bundle.getInt("versionCode", 0);
        String string4 = bundle.getString("updateInfo", "");
        String str3 = string4 != null ? string4 : "";
        long j6 = bundle.getLong("updateTime", 0L);
        List stringArrayList = bundle.getStringArrayList("abilities");
        if (stringArrayList == null) {
            stringArrayList = EmptyList.f4893a;
        }
        List list = stringArrayList;
        List stringArrayList2 = bundle.getStringArrayList("dependencies");
        if (stringArrayList2 == null) {
            stringArrayList2 = EmptyList.f4893a;
        }
        return (m.s0(str2) && j5 == 0) ? EmptyList.f4893a : o.M(new RemoteModel(str, i, str2, j5, string3, str3, j6, list, stringArrayList2));
    }

    public final RemoteModel getPluginModel(String pluginName) {
        Object next;
        k.f(pluginName, "pluginName");
        Iterator<T> it = getModels().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            RemoteModel remoteModel = (RemoteModel) next;
            if (remoteModel.isPlugin() && k.b(remoteModel.getPluginName(), pluginName)) {
                break;
            }
        }
        return (RemoteModel) next;
    }
}
