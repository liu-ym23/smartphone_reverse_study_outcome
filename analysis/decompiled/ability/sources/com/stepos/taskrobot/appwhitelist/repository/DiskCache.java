package com.stepos.taskrobot.appwhitelist.repository;

import O7.i;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.taskrobot.appwhitelist.remote.dto.WhitelistManifestDto;
import j9.AbstractC1607a;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/repository/DiskCache;", "", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "Lcom/stepos/taskrobot/appwhitelist/remote/dto/WhitelistManifestDto;", "read", "()Lcom/stepos/taskrobot/appwhitelist/remote/dto/WhitelistManifestDto;", "dto", "LC7/r;", "write", "(Lcom/stepos/taskrobot/appwhitelist/remote/dto/WhitelistManifestDto;)V", "Ljava/io/File;", "dir", "Ljava/io/File;", BffConstant.Type.File, "tmpFile", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DiskCache {
    private final File dir;
    private final File file;
    private final File tmpFile;

    public DiskCache(Context context) {
        k.f(context, "context");
        File file = new File(context.getFilesDir(), "appwhitelist");
        file.mkdirs();
        this.dir = file;
        this.file = new File(file, "manifest.json");
        this.tmpFile = new File(file, "manifest.json.tmp");
    }

    public final WhitelistManifestDto read() {
        if (!this.file.exists()) {
            return null;
        }
        try {
            return (WhitelistManifestDto) new Gson().fromJson(i.X(this.file, AbstractC1607a.f4778a), WhitelistManifestDto.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void write(WhitelistManifestDto dto) {
        k.f(dto, "dto");
        File file = this.tmpFile;
        String json = new Gson().toJson(dto);
        k.e(json, "toJson(...)");
        i.Y(file, json);
        if (this.tmpFile.renameTo(this.file)) {
            return;
        }
        i.Y(this.file, i.X(this.tmpFile, AbstractC1607a.f4778a));
        this.tmpFile.delete();
    }
}
