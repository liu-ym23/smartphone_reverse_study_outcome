package com.stepos.stepclaw.provider.backend;

import com.stepos.stepclaw.SecurePrefs;
import java.io.File;
import java.util.List;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "path", "readRootfsFile", "(Ljava/lang/String;)Ljava/lang/String;", "content", "Lb5/a0;", "writeRootfsFile", "(Ljava/lang/String;Ljava/lang/String;)V", "dirPath", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "listRootfsFilesInDirectory", "(Ljava/lang/String;)Ljava/util/List;", "ensureDirectory", "(Ljava/lang/String;)V", "getRootfsSubdir", "()Ljava/lang/String;", "Ljava/io/File;", "resolveRootfsPath", "(Ljava/lang/String;)Ljava/io/File;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface IRootfsAccess {
    void ensureDirectory(String path);

    String getRootfsSubdir();

    List<String> listRootfsFilesInDirectory(String dirPath);

    String readRootfsFile(String path);

    File resolveRootfsPath(String path);

    void writeRootfsFile(String path, String content);
}
