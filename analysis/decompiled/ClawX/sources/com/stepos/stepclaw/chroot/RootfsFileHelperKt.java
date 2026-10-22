package com.stepos.stepclaw.chroot;

import a8.b;
import android.content.res.AssetManager;
import c5.l;
import com.stepos.stepclaw.SecurePrefs;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import k4.z;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\u001a-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/stepclaw/chroot/RootfsFileHelper;", "bootstrap", "Landroid/content/res/AssetManager;", "assets", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "assetDir", "rootfsDir", "Lb5/a0;", "deployAssetTreeToRootfs", "(Lcom/stepos/stepclaw/chroot/RootfsFileHelper;Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;)V", "SUB_AGENTS_ASSET_PREFIX", "Ljava/lang/String;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "SUB_AGENT_WORKSPACE_FILES", "Ljava/util/Set;", "getSUB_AGENT_WORKSPACE_FILES", "()Ljava/util/Set;", "step-runtime_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RootfsFileHelperKt {
    public static final String SUB_AGENTS_ASSET_PREFIX = "openclaw/sub-agents";
    private static final Set<String> SUB_AGENT_WORKSPACE_FILES = l.k0(new String[]{"AGENTS.md", "SOUL.md", "USER.md", "MEMORY.md", "TOOLS.md", "IDENTITY.md", "README.md"});

    public static final void deployAssetTreeToRootfs(RootfsFileHelper bootstrap, AssetManager assets, String assetDir, String rootfsDir) {
        p.e(bootstrap, "bootstrap");
        p.e(assets, "assets");
        p.e(assetDir, "assetDir");
        p.e(rootfsDir, "rootfsDir");
        String[] list = assets.list(assetDir);
        if (list == null) {
            return;
        }
        for (String str : list) {
            String strO = b.o(assetDir, "/", str);
            String[] list2 = assets.list(strO);
            if (list2 == null || list2.length == 0) {
                InputStream inputStreamOpen = assets.open(strO);
                p.d(inputStreamOpen, "open(...)");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, a.f6276a), 8192);
                try {
                    String strC = z.C(bufferedReader);
                    bufferedReader.close();
                    bootstrap.writeRootfsFile(rootfsDir + "/" + str, strC);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        z.h(bufferedReader, th);
                        throw th2;
                    }
                }
            } else {
                deployAssetTreeToRootfs(bootstrap, assets, strO, b.o(rootfsDir, "/", str));
            }
        }
    }

    public static final Set<String> getSUB_AGENT_WORKSPACE_FILES() {
        return SUB_AGENT_WORKSPACE_FILES;
    }
}
