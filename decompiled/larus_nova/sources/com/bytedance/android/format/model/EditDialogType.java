package com.bytedance.android.format.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/format/model/EditDialogType;", "", "TopicMusic", "ScriptChapterMusic", "TopicBackground", "ScriptBackground", "ScriptOpeningPage", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EditDialogType extends Enum<EditDialogType> {
    public static final EditDialogType ScriptBackground = null;
    public static final EditDialogType ScriptChapterMusic = null;
    public static final EditDialogType ScriptOpeningPage = null;
    public static final EditDialogType TopicBackground = null;
    public static final EditDialogType TopicMusic = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EditDialogType[] f51327a = null;

    static {
        EditDialogType r100 = new EditDialogType("TopicMusic", 0);
        TopicMusic = r100;
        EditDialogType r101 = new EditDialogType("ScriptChapterMusic", 1);
        ScriptChapterMusic = r101;
        EditDialogType r102 = new EditDialogType("TopicBackground", 2);
        TopicBackground = r102;
        EditDialogType r103 = new EditDialogType("ScriptBackground", 3);
        ScriptBackground = r103;
        EditDialogType r104 = new EditDialogType("ScriptOpeningPage", 4);
        ScriptOpeningPage = r104;
        f51327a = new EditDialogType[]{r100, r101, r102, r103, r104};
    }

    public static EditDialogType valueOf(String r100) {
        return (EditDialogType) r27.a.a(EditDialogType.class, r100);
    }

    public static EditDialogType[] values() {
        return (EditDialogType[]) f51327a.clone();
    }

    public EditDialogType(String r100, int r101) {
        super(r100, r101);
    }
}
