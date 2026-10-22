package com.stepos.stepclaw.provider.handlers;

import a8.b;
import android.content.Context;
import android.net.Uri;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.backend.IRootfsAccess;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import k4.v;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m5.l;
import x5.a;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/ZipExtractor;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", "rootfs", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "base", "resourceId", "Landroid/net/Uri;", "zipUri", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "extract", "(Landroid/content/Context;Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)I", "Lb5/a0;", "deleteDir", "(Landroid/content/Context;Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;Ljava/lang/String;Ljava/lang/String;)V", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ZipExtractor {
    public static final ZipExtractor INSTANCE = new ZipExtractor();

    private ZipExtractor() {
    }

    public final void deleteDir(Context context, IRootfsAccess rootfs, String base, String resourceId) {
        p.e(context, "context");
        p.e(rootfs, "rootfs");
        p.e(base, "base");
        p.e(resourceId, "resourceId");
        File fileResolveRootfsPath = rootfs.resolveRootfsPath(base + "/" + resourceId);
        if (fileResolveRootfsPath.exists()) {
            l.z0(fileResolveRootfsPath);
        }
    }

    public final int extract(Context context, IRootfsAccess rootfs, String base, String resourceId, Uri zipUri) throws IOException {
        p.e(context, "context");
        p.e(rootfs, "rootfs");
        p.e(base, "base");
        p.e(resourceId, "resourceId");
        p.e(zipUri, "zipUri");
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(zipUri);
        if (inputStreamOpenInputStream == null) {
            throw new IllegalArgumentException("Cannot open zip URI: " + zipUri);
        }
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(inputStreamOpenInputStream));
            try {
                int i8 = 0;
                for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                    String name = nextEntry.getName();
                    p.d(name, "getName(...)");
                    String strB1 = n.B1(n.B1(name, "./"), "/");
                    if (n.g1(strB1, "..", false)) {
                        throw new IllegalArgumentException(("Zip path traversal: " + nextEntry.getName()).toString());
                    }
                    String str = base + "/" + resourceId + "/" + strB1;
                    if (nextEntry.isDirectory()) {
                        rootfs.ensureDirectory(str);
                    } else {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, zipInputStream.available()));
                        v.u(zipInputStream, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        p.d(byteArray, "toByteArray(...)");
                        rootfs.writeRootfsFile(str, new String(byteArray, a.f6276a));
                        i8++;
                    }
                }
                zipInputStream.close();
                inputStreamOpenInputStream.close();
                if (i8 == 0) {
                    throw new IllegalStateException(b.q("ZIP contained no files (skillId=", resourceId, ", base=", base, "). Refusing install."));
                }
                try {
                    context.revokeUriPermission(zipUri, 1);
                } catch (Exception unused) {
                }
                return i8;
            } finally {
            }
        } finally {
        }
    }
}
