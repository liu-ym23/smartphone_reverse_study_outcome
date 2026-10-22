package com.bytedance.android.ec.core.imagex.opt;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/opt/PreloadLevel;", "", "ParseUrl", "DiskCache", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
final enum PreloadLevel extends Enum<PreloadLevel> {
    public static final PreloadLevel DiskCache = null;
    public static final PreloadLevel ParseUrl = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadLevel[] f44840a = null;

    static {
        PreloadLevel r100 = new PreloadLevel("ParseUrl", 0);
        ParseUrl = r100;
        PreloadLevel r101 = new PreloadLevel("DiskCache", 1);
        DiskCache = r101;
        f44840a = new PreloadLevel[]{r100, r101};
    }

    public static PreloadLevel valueOf(String r100) {
        return (PreloadLevel) r27.a.a(PreloadLevel.class, r100);
    }

    public static PreloadLevel[] values() {
        return (PreloadLevel[]) f44840a.clone();
    }

    public PreloadLevel(String r100, int r101) {
        super(r100, r101);
    }
}
