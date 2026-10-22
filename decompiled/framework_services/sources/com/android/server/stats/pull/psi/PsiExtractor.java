package com.android.server.stats.pull.psi;

import android.util.Log;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes3.dex */
public class PsiExtractor {
    private static final String FULL = "full";
    private static final String PSI_CPU_PATH = "/proc/pressure/cpu";
    private static final String PSI_IO_PATH = "/proc/pressure/io";
    private static final String PSI_MEMORY_PATH = "/proc/pressure/memory";
    private static final String PSI_PATTERN_TEMPLATE = ".*{0} avg10=(\\d+.\\d+) avg60=(\\d+.\\d+) avg300=(\\d+.\\d+) total=(\\d+).*";
    private static final String SOME = "some";
    private static final String TAG = "PsiExtractor";
    private final PsiReader mPsiReader;

    public static class PsiReader {
        public PsiReader() {
        }

        public String read(String filePath) {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));     // Catch: IOException -> L6
            String r1 = (String) br.lines().collect(Collectors.joining(System.lineSeparator()));     // Catch: Throwable -> L8
            br.close();     // Catch: IOException -> L6
            return r1;
        L8:
            th = move-exception;
            br.close();     // Catch: Throwable -> L11
        L13:
            throw th;     // Catch: IOException -> L6
        L11:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L6
        L14:
            Log.w(PsiExtractor.TAG, "Cannot read file " + filePath);
            return null;
        }
    }

    public PsiExtractor() {
        this.mPsiReader = new PsiReader();
    }

    public PsiExtractor(PsiReader psiReader) {
        this.mPsiReader = psiReader;
    }

    public PsiData getPsiData(PsiData.ResourceType resourceType) {
        if (resourceType != PsiData.ResourceType.MEMORY) goto L6;
        String psiFileData = this.mPsiReader.read(PSI_MEMORY_PATH);
    L12:
        return parsePsiData(psiFileData, resourceType);
    L6:
        if (resourceType != PsiData.ResourceType.IO) goto L9;
        psiFileData = this.mPsiReader.read(PSI_IO_PATH);
        goto L12
    L9:
        if (resourceType != PsiData.ResourceType.CPU) goto L13;
        psiFileData = this.mPsiReader.read(PSI_CPU_PATH);
        goto L12
    L13:
        Log.w(TAG, "PsiExtractor failure: cannot read kernel source file, returning null");
        return null;
    }

    private static PsiData.AppsStallInfo parsePsiString(String psiFileData, String appType, PsiData.ResourceType resourceType) {
        if (appType == FULL) goto L5;
    L12:
        Pattern psiStringPattern = Pattern.compile(MessageFormat.format(PSI_PATTERN_TEMPLATE, new Object[]{appType}));
        Matcher psiLineMatcher = psiStringPattern.matcher(psiFileData);
        if (psiLineMatcher.find() == true) goto L21;
        Log.w(TAG, "Returning null: the line \"" + appType + "\" is not in expected pattern.");
        return null;
    L21:
        return new PsiData.AppsStallInfo(Float.parseFloat(psiLineMatcher.group(1)), Float.parseFloat(psiLineMatcher.group(2)), Float.parseFloat(psiLineMatcher.group(3)), Long.parseLong(psiLineMatcher.group(4)));
    L19:
        Log.w(TAG, "Returning null: some value in line \"" + appType + "\" cannot be parsed as numeric.");
        return null;
    L5:
        if (resourceType != PsiData.ResourceType.CPU) goto L12;
        if (psiFileData.contains(SOME) == false) goto L12;
        if (psiFileData.contains(FULL) == true) goto L12;
        return new PsiData.AppsStallInfo(0.0f, 0.0f, 0.0f, 0);
    }

    private static PsiData parsePsiData(String psiFileData, PsiData.ResourceType resourceType) {
        PsiData.AppsStallInfo someAppsStallInfo = parsePsiString(psiFileData, SOME, resourceType);
        PsiData.AppsStallInfo fullAppsStallInfo = parsePsiString(psiFileData, FULL, resourceType);
        if (someAppsStallInfo != null) goto L7;
        if (fullAppsStallInfo != null) goto L7;
        Log.w(TAG, "Returning empty PSI: some or full line are failed to parse");
        return null;
    L7:
        if (someAppsStallInfo != null) goto L9;
        Log.d(TAG, "Replacing some info with empty PSI record for the resource type " + resourceType);
        someAppsStallInfo = new PsiData.AppsStallInfo(-1.0f, -1.0f, -1.0f, -1);
    L12:
        return new PsiData(resourceType, someAppsStallInfo, fullAppsStallInfo);
    L9:
        if (fullAppsStallInfo != null) goto L12;
        Log.d(TAG, "Replacing full info with empty PSI record for the resource type " + resourceType);
        fullAppsStallInfo = new PsiData.AppsStallInfo(-1.0f, -1.0f, -1.0f, -1);
        goto L12
    }
}
