package com.stepos.taskrobot.appwhitelist.repository;

import S0.b;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.stepos.taskrobot.appwhitelist.remote.MockWhitelistRemoteSource;
import com.stepos.taskrobot.appwhitelist.remote.dto.WhitelistManifestDto;
import j9.AbstractC1607a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/repository/DefaultManifestSource;", "", "context", "Landroid/content/Context;", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "load", "Lcom/stepos/taskrobot/appwhitelist/remote/dto/WhitelistManifestDto;", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultManifestSource {
    private final Context context;

    public DefaultManifestSource(Context context) {
        k.f(context, "context");
        this.context = context;
    }

    public final WhitelistManifestDto load() throws JsonSyntaxException, IOException {
        InputStream inputStreamOpen = this.context.getAssets().open(MockWhitelistRemoteSource.ASSET_NAME);
        k.e(inputStreamOpen, "open(...)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, AbstractC1607a.f4778a), 8192);
        try {
            String strO1 = b.o1(bufferedReader);
            bufferedReader.close();
            Object objFromJson = new Gson().fromJson(strO1, (Class<Object>) WhitelistManifestDto.class);
            k.e(objFromJson, "fromJson(...)");
            return (WhitelistManifestDto) objFromJson;
        } finally {
        }
    }
}
