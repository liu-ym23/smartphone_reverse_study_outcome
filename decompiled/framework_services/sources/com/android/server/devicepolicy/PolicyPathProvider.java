package com.android.server.devicepolicy;

import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public interface PolicyPathProvider {
    default File getDataSystemDirectory() {
        return Environment.getDataSystemDirectory();
    }

    default File getUserSystemDirectory(int userId) {
        return Environment.getUserSystemDirectory(userId);
    }
}
