package com.android.server.pm;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
final class CleanUpArgs {
    private final File mCodeFile;
    private final String[] mInstructionSets;
    private final String mPackageName;

    CleanUpArgs(String packageName, String codePath, String[] instructionSets) {
        this.mPackageName = packageName;
        this.mCodeFile = new File(codePath);
        this.mInstructionSets = instructionSets;
    }

    String getPackageName() {
        return this.mPackageName;
    }

    File getCodeFile() {
        return this.mCodeFile;
    }

    String getCodePath() {
        return this.mCodeFile.getAbsolutePath();
    }

    String[] getInstructionSets() {
        return this.mInstructionSets;
    }
}
