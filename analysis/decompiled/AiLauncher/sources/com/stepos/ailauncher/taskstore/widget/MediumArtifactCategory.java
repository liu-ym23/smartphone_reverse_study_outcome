package com.stepos.ailauncher.taskstore.widget;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/MediumArtifactCategory;", "", "<init>", "(Ljava/lang/String;I)V", "DOC", "PPT", "XLS", "PDF", "TXT", "MD", "CODE", "IMAGE", "AUDIO", "VIDEO", "ZIP", "FOLDER", "GENERIC", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class MediumArtifactCategory {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ MediumArtifactCategory[] $VALUES;
    public static final MediumArtifactCategory DOC = new MediumArtifactCategory("DOC", 0);
    public static final MediumArtifactCategory PPT = new MediumArtifactCategory("PPT", 1);
    public static final MediumArtifactCategory XLS = new MediumArtifactCategory("XLS", 2);
    public static final MediumArtifactCategory PDF = new MediumArtifactCategory("PDF", 3);
    public static final MediumArtifactCategory TXT = new MediumArtifactCategory("TXT", 4);
    public static final MediumArtifactCategory MD = new MediumArtifactCategory("MD", 5);
    public static final MediumArtifactCategory CODE = new MediumArtifactCategory("CODE", 6);
    public static final MediumArtifactCategory IMAGE = new MediumArtifactCategory("IMAGE", 7);
    public static final MediumArtifactCategory AUDIO = new MediumArtifactCategory("AUDIO", 8);
    public static final MediumArtifactCategory VIDEO = new MediumArtifactCategory("VIDEO", 9);
    public static final MediumArtifactCategory ZIP = new MediumArtifactCategory("ZIP", 10);
    public static final MediumArtifactCategory FOLDER = new MediumArtifactCategory("FOLDER", 11);
    public static final MediumArtifactCategory GENERIC = new MediumArtifactCategory("GENERIC", 12);

    private static final /* synthetic */ MediumArtifactCategory[] $values() {
        return new MediumArtifactCategory[]{DOC, PPT, XLS, PDF, TXT, MD, CODE, IMAGE, AUDIO, VIDEO, ZIP, FOLDER, GENERIC};
    }

    static {
        MediumArtifactCategory[] mediumArtifactCategoryArr$values = $values();
        $VALUES = mediumArtifactCategoryArr$values;
        $ENTRIES = kotlin.enums.a.a(mediumArtifactCategoryArr$values);
    }

    private MediumArtifactCategory(String str, int i10) {
    }

    public static InterfaceC4149a<MediumArtifactCategory> getEntries() {
        return $ENTRIES;
    }

    public static MediumArtifactCategory valueOf(String str) {
        return (MediumArtifactCategory) Enum.valueOf(MediumArtifactCategory.class, str);
    }

    public static MediumArtifactCategory[] values() {
        return (MediumArtifactCategory[]) $VALUES.clone();
    }
}
