package com.tencent.mmkv;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public final class NameSpace {
    private final String rootDir;

    public NameSpace(String str) {
        this.rootDir = str;
    }

    public boolean backupOneToDirectory(String str, String str2) {
        return MMKV.backupOneToDirectory(str, str2, this.rootDir);
    }

    public boolean checkExist(String str) {
        return MMKV.checkExist(str, this.rootDir);
    }

    public String getRootDir() {
        return this.rootDir;
    }

    public boolean isFileValid(String str) {
        return MMKV.isFileValid(str, this.rootDir);
    }

    @NonNull
    public MMKV mmkvWithID(String str) throws RuntimeException {
        return MMKV.checkProcessMode(MMKV.getMMKVWithID(str, 1, null, this.rootDir, 0L), str, 1);
    }

    public boolean removeStorage(String str) {
        return MMKV.removeStorage(str, this.rootDir);
    }

    public boolean restoreOneMMKVFromDirectory(String str, String str2) {
        return MMKV.restoreOneMMKVFromDirectory(str, str2, this.rootDir);
    }

    @NonNull
    public MMKV mmkvWithID(String str, int i) throws RuntimeException {
        return MMKV.checkProcessMode(MMKV.getMMKVWithID(str, i, null, this.rootDir, 0L), str, i);
    }

    @NonNull
    public MMKV mmkvWithID(String str, int i, long j5) throws RuntimeException {
        return MMKV.checkProcessMode(MMKV.getMMKVWithID(str, i, null, this.rootDir, j5), str, i);
    }

    @NonNull
    public MMKV mmkvWithID(String str, int i, @Nullable String str2) throws RuntimeException {
        return MMKV.checkProcessMode(MMKV.getMMKVWithID(str, i, str2, this.rootDir, 0L), str, i);
    }

    @NonNull
    public MMKV mmkvWithID(String str, int i, @Nullable String str2, long j5) throws RuntimeException {
        return MMKV.checkProcessMode(MMKV.getMMKVWithID(str, i, str2, this.rootDir, j5), str, i);
    }
}
