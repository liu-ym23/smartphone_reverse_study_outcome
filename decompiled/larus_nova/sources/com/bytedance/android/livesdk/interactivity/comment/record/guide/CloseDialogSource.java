package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/CloseDialogSource;", "", "Default", "ClickBack", "SaveDraft", "Publish", "SaveLocal", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CloseDialogSource extends Enum<CloseDialogSource> {
    public static final CloseDialogSource ClickBack = null;
    public static final CloseDialogSource Default = null;
    public static final CloseDialogSource Publish = null;
    public static final CloseDialogSource SaveDraft = null;
    public static final CloseDialogSource SaveLocal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CloseDialogSource[] f136110a = null;

    static {
        CloseDialogSource r100 = new CloseDialogSource("Default", 0);
        Default = r100;
        CloseDialogSource r101 = new CloseDialogSource("ClickBack", 1);
        ClickBack = r101;
        CloseDialogSource r102 = new CloseDialogSource("SaveDraft", 2);
        SaveDraft = r102;
        CloseDialogSource r103 = new CloseDialogSource("Publish", 3);
        Publish = r103;
        CloseDialogSource r104 = new CloseDialogSource("SaveLocal", 4);
        SaveLocal = r104;
        f136110a = new CloseDialogSource[]{r100, r101, r102, r103, r104};
    }

    public static CloseDialogSource valueOf(String r100) {
        return (CloseDialogSource) r27.a.a(CloseDialogSource.class, r100);
    }

    public static CloseDialogSource[] values() {
        return (CloseDialogSource[]) f136110a.clone();
    }

    public CloseDialogSource(String r100, int r101) {
        super(r100, r101);
    }
}
