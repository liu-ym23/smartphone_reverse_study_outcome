package com.alipay.sdk.m.a0;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes28.dex */
public final class c implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f25224a;

    public c(b r100) {
        this.f25224a = r100;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r100) {
        if (Pattern.matches("cpu[0-9]+", r100.getName()) == false) goto L6;
        return true;
    L6:
        return false;
    }
}
